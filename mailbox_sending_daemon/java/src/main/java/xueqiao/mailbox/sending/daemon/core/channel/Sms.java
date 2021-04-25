package xueqiao.mailbox.sending.daemon.core.channel;

import com.antiy.error_code.ErrorCodeInner;
import com.google.gson.Gson;
import org.apache.commons.lang.StringUtils;
import org.apache.thrift.TException;
import org.soldier.base.logger.AppLog;
import org.soldier.platform.svr_platform.comm.ErrorInfo;
import xueqiao.company.GroupUserEx;
import xueqiao.mailbox.sending.daemon.api.SmsAoApi;
import xueqiao.mailbox.sending.daemon.core.bean.BaseMessage;
import xueqiao.mailbox.sending.daemon.core.bean.Receiver;
import xueqiao.mailbox.sending.daemon.core.bean.SendingMessage;
import xueqiao.mailbox.sending.daemon.util.CollectionUtil;
import xueqiao.mailbox.sending.daemon.util.FileStorageUtil;

import java.util.Iterator;
import java.util.List;

public class Sms extends Channel {
//    public Sms(long jobId, List<GroupUserEx> groupUserList, BaseMessage message) {
//        super(jobId, groupUserList, message);
//    }

    public Sms(SendingMessage sendingMessage) {
        super(sendingMessage);
    }

    @Override
    public void send() throws TException {
        doSend();
    }

    private void doSend() throws TException {

        AppLog.i("doSend ---- getSmsList : " + new Gson().toJson(sendingMessage.getSmsList()));

        if (CollectionUtil.isListBlank(sendingMessage.getSmsList())) {
            return;
        }

        String messageSummary = sendingMessage.getContent().getSummary();
        if (StringUtils.isBlank(messageSummary)) {
            throw new ErrorInfo(ErrorCodeInner.ILLEGAL_OPERATION_ERROR.getErrorCode(), "sms empty message summary");
        }
        Iterator<Receiver> receiverIterator = sendingMessage.getSmsList().iterator();
        while (receiverIterator.hasNext()) {
            Receiver receiver = receiverIterator.next();
            String messageContentPreProcess = preProcess(receiver, messageSummary);
            sendSms(receiver.getTel(), receiver.getCnName(), messageContentPreProcess);
            receiverIterator.remove();
            AppLog.i("send sms : " + receiver.getTel());
        }
    }

//    private void doSend() throws TException {
//        Map<String, String> hostingMap = new HashMap<>();
//        String hostingTel;
//        /*
//         * 从托管机用户中获取邮箱地址
//         * */
//        if (CollectionUtil.isListNotBlank(groupUserList)) {
//            String messageContent = message.getContent().getSummary();
//            String messageContentPreProcess;
//            if (StringUtils.isBlank(messageContent)) {
//                return;
//            }
//            for (GroupUserEx groupUserEx : groupUserList) {
//                hostingTel = hostingMap.get(groupUserEx.getTel());
//                if (StringUtils.isBlank(hostingTel)) {
//                    hostingMap.put(groupUserEx.getTel(), groupUserEx.getTel());
//                    messageContentPreProcess = preProcess(groupUserEx, messageContent);
//                    sendSms(groupUserEx.getTel(), groupUserEx.getCnName(), messageContentPreProcess);
//                }
//            }
//        }
//
//        /*
//         * 从smsList中获取手机地址
//         * */
//
//        if (CollectionUtil.isListNotBlank(message.getSmsList())) {
//            for (MReceiverSms receiverSms : message.getSmsList()) {
//                hostingTel = hostingMap.get(receiverSms.getTel());
//                /*
//                 * 在hosting用户中已经发送过的，就不再重复发送
//                 * */
//                if (StringUtils.isBlank(hostingTel)) {
//                    sendSms(receiverSms.getTel(), receiverSms.getTel(), message.getContent().getContent());
//                }
//            }
//        }
//
//    }

    private void sendSms(String tel, String userName, String content) throws TException {
        SmsAoApi.sendSms(tel, userName, content);
        AppLog.i("sendSms ---- tel : " + tel + ", content : " + content);
    }
}
