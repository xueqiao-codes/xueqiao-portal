package xueqiao.mailbox.sending.daemon.util;

import com.antiy.error_code.ErrorCodeInner;
import org.apache.thrift.TException;
import org.soldier.base.logger.AppLog;
import org.soldier.platform.svr_platform.comm.ErrorInfo;
import xueqiao.company.GroupUserEx;
import xueqiao.company.HostingServiceStatus;
import xueqiao.mailbox.sending.daemon.api.CompanyDaoApi;
import xueqiao.mailbox.sending.daemon.core.bean.Receiver;
import xueqiao.mailbox.sending.daemon.core.bean.SendingMessage;
import xueqiao.mailbox.thriftdata.mb.MBMessageJob;
import xueqiao.mailbox.thriftdata.mb.MJStatus;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class SendingMessageUtil {

    /**
     * 异常重试有效期为1小时
     */
    private final static long SENDING_MESSAGE_VALID_PERIOD = 1000 * 60 * 60;

    /**
     * 过期两个小时，则从map中删除
     */
    private final static long SENDING_MESSAGE_RESERVE_PERIOD = 1000 * 60 * 60 * 2;

    public static SendingMessage getSendingMessage(MBMessageJob message) throws TException {
        List<GroupUserEx> groupUserExList = CompanyDaoApi.queryAllGroupUserList(message.getHostingList());
        if (CollectionUtil.isListBlank(groupUserExList)) {
            throw new ErrorInfo(ErrorCodeInner.ILLEGAL_OPERATION_ERROR.getErrorCode(), "fail to find qualified users");
        }

        SendingMessage sendingMessage = new SendingMessage();
        sendingMessage.setJobId(message.getJobId());
        sendingMessage.setFirstSendTime(System.currentTimeMillis());
        sendingMessage.setChannelList(message.getChannelList());
        sendingMessage.setContent(message.getContent());


        Map<Integer, Integer> userIdMap = new HashMap<>();
        for (GroupUserEx groupUserEx : groupUserExList) {

            /*
             * 去掉没有绑定托管机的组的组用户
             * */
            if (groupUserEx.getHostingServiceStatus() != HostingServiceStatus.WORKING
                    && groupUserEx.getHostingServiceStatus() != HostingServiceStatus.UPGRADING
                    && groupUserEx.getHostingServiceStatus() != HostingServiceStatus.EXPIRED) {
                continue;
            }

            /*
             * 排除重复的用户
             * 因为公司用户可以对应多个组用户，这里查回来的是组用户
             * */
            Integer userId = userIdMap.get(groupUserEx.getUserId());
            if (userId != null) {
                continue;
            }
            userIdMap.put(groupUserEx.getUserId(), groupUserEx.getUserId());

            Receiver receiver = new Receiver();
            receiver.setCompanyId(groupUserEx.getCompanyId());
            receiver.setUserId(groupUserEx.getUserId());
            receiver.setCnName(groupUserEx.getCnName());
            receiver.setCompanyCode(groupUserEx.getCompanyCode());
            receiver.setGroupName(groupUserEx.getGroupName());
            receiver.setTel(groupUserEx.getTel());
            receiver.setEmail(groupUserEx.getEmail());

            sendingMessage.addToHostingList(receiver);
            sendingMessage.addToMailList(Receiver.copy(receiver));
            sendingMessage.addToSmsList(Receiver.copy(receiver));
        }

        return sendingMessage;
    }

    public static SendingMessage getMessage(MBMessageJob message, Map<Long, SendingMessage> sendingMessageMap) throws TException {
        long jobId = message.getJobId();
        SendingMessage sendingMessage = sendingMessageMap.get(jobId);
        if (sendingMessage == null) {
            sendingMessage = getSendingMessage(message);
            sendingMessageMap.put(jobId, sendingMessage);
            return sendingMessage;
        } else if (message.getStatus() == MJStatus.MJS_SENDING) {
            /*
             * 如果MAP中有值，且状态为发送中
             * 则说明这是人工重新发送，这时刷新有效时间
             * */
            sendingMessage.setFirstSendTime(System.currentTimeMillis());
        }
        /*
         * 如果超过有效时间，则不再重试
         * */
        if ((CollectionUtil.isListNotBlank(sendingMessage.getHostingList()) || CollectionUtil.isListNotBlank(sendingMessage.getSmsList()) || CollectionUtil.isListNotBlank(sendingMessage.getMailList()))
                && (System.currentTimeMillis() - sendingMessage.getFirstSendTime() > SENDING_MESSAGE_VALID_PERIOD)) {
//            sendingMessageMap.remove(jobId);
            sendingMessage = null;
        }
        return sendingMessage;
    }

//    public static void completeMessage(SendingMessage sendingMessage, Map<Long, SendingMessage> sendingMessageMap) {
//        if (CollectionUtil.isListBlank(sendingMessage.getHostingList()) && CollectionUtil.isListBlank(sendingMessage.getMailList()) && CollectionUtil.isListBlank(sendingMessage.getSmsList())) {
//            sendingMessageMap.remove(sendingMessage.getJobId());
//            AppLog.i("completeMessage ---- remove sendRecord, jobId : " + sendingMessage.getJobId());
//        }
//    }

    public static void completeMessage(Map<Long, SendingMessage> sendingMessageMap) {
        /*
         * 过期两个小时后，才从MAP中删除
         * 以面设置状态接口出错，又重新发送
         * */
        Iterator<SendingMessage> iterator = sendingMessageMap.values().iterator();
        while (iterator.hasNext()) {
            SendingMessage sendingMessage = iterator.next();
            if (System.currentTimeMillis() - sendingMessage.getFirstSendTime() > SENDING_MESSAGE_RESERVE_PERIOD) {
                iterator.remove();
            }
        }
    }
}
