package xueqiao.mailbox.sending.daemon.core.channel;

import com.antiy.error_code.ErrorCodeInner;
import com.google.gson.Gson;
import org.apache.commons.lang.StringUtils;
import org.apache.thrift.TException;
import org.soldier.base.logger.AppLog;
import org.soldier.platform.svr_platform.comm.ErrorInfo;
import xueqiao.mailbox.sending.daemon.api.UserMessageDaoApi;
import xueqiao.mailbox.sending.daemon.core.bean.Receiver;
import xueqiao.mailbox.sending.daemon.core.bean.SendingMessage;
import xueqiao.mailbox.sending.daemon.util.CollectionUtil;
import xueqiao.mailbox.sending.daemon.util.FileStorageUtil;
import xueqiao.mailbox.sending.daemon.util.MLevelMapping;
import xueqiao.mailbox.sending.daemon.util.MTypeMapping;
import xueqiao.mailbox.user.message.thriftapi.UserMessage;

import java.util.*;

public class Hosting extends Channel {

    public Hosting(SendingMessage sendingMessage) {
        super(sendingMessage);
    }

    @Override
    public void send() throws TException {
        doSend();
    }

    private void doSend() throws TException {
        AppLog.i("doSend ---- getHostingList : " + new Gson().toJson(sendingMessage.getHostingList()));
        if (CollectionUtil.isListBlank(sendingMessage.getHostingList())) {
            return;
        }

        String messageBody = FileStorageUtil.readContentText(sendingMessage.getContent().getContent());
        boolean isMessageBodyShouldPreProcess = isMessageBodyShouldPreProcess(messageBody);
        if (StringUtils.isBlank(messageBody)) {
            throw new ErrorInfo(ErrorCodeInner.ILLEGAL_OPERATION_ERROR.getErrorCode(), "empty message body");
        }
        List<UserMessage> userMessageList = new ArrayList<>();
        Iterator<Receiver> receiverIterator = sendingMessage.getHostingList().iterator();
        while (receiverIterator.hasNext()) {
            Receiver receiver = receiverIterator.next();

            String preProcessSummary = preProcess(receiver, sendingMessage.getContent().getSummary());
            UserMessage userMessage = new UserMessage();
            userMessage.setCompanyId(receiver.getCompanyId());
            userMessage.setUserId(receiver.getUserId());
            userMessage.setMessageJobId(sendingMessage.getJobId());
            userMessage.setType(MTypeMapping.getMType(sendingMessage.getContent().getType()));
            userMessage.setLevel(MLevelMapping.getMLevel(sendingMessage.getContent().getLevel()));
            userMessage.setTitle(sendingMessage.getContent().getTitle());
            userMessage.setSummary(preProcessSummary);
            if (isMessageBodyShouldPreProcess) {
                userMessage.setContentFileName(getPreProcessBodyPath(receiver, messageBody));
            } else {
                userMessage.setContentFileName(sendingMessage.getContent().getContent());
            }
            userMessageList.add(userMessage);
        }
        UserMessageDaoApi.addUserMessage(userMessageList);
        AppLog.i("sendHostingMessage : " + new Gson().toJson(userMessageList));
        /*
         * 发送成功后清除发送列表
         * */
        sendingMessage.getHostingList().clear();
    }

//    private void doSend() throws TException {
//        /*
//         * 从托管机用户中获取邮箱地址
//         * */
//        if (CollectionUtil.isListNotBlank(groupUserList)) {
//            String messageContentText = FileStorageUtil.readContentText(message.getContent().getContent());
//            boolean isMessageBodyShouldPreProcess = isMessageBodyShouldPreProcess(messageContentText);
//            String preProcessSummary;
//            if (StringUtils.isBlank(messageContentText)) {
//                return;
//            }
//            List<HostingMessage> hostingMessages = new ArrayList<>();
//            Map<Integer,Integer> companyUserMap = new HashMap<>();
//            HostingMessage hostingMessage;
//            MessageContent messageContent = message.getContent();
//            for (GroupUserEx groupUserEx : groupUserList) {
//                /*
//                * 判断用户是否已经重复
//                * 因为一个用户可能会对应多个groupUser
//                * */
//                Integer companyUserId = companyUserMap.get(groupUserEx.getUserId());
//                if (companyUserId != null) {
//                    continue;
//                }
//                companyUserMap.put(groupUserEx.getUserId(), groupUserEx.getUserId());
//
//                preProcessSummary = preProcess(groupUserEx, message.getContent().getSummary());
//                hostingMessage = new HostingMessage();
//                hostingMessage.setCompanyId(groupUserEx.getCompanyId());
//                hostingMessage.setUserId(groupUserEx.getUserId());
//                hostingMessage.setMessageJobId(jobId);
//                hostingMessage.setType(MTypeMapping.getMType(messageContent.getType()));
//                hostingMessage.setLevel(MLevelMapping.getMLevel(messageContent.getLevel()));
//                hostingMessage.setTitle(messageContent.getTitle());
//                hostingMessage.setSummary(preProcessSummary);
//                if (isMessageBodyShouldPreProcess) {
//                    hostingMessage.setContentFileName(getPreProcessBodyPath(groupUserEx, messageContentText));
//                } else {
//                    hostingMessage.setContentFileName(messageContent.getContent());
//                }
//                hostingMessages.add(hostingMessage);
//            }
//            AppLog.i("doSend ---- hostingMessages : " + new Gson().toJson(hostingMessages));
//            MailboxHostingDaoApi.sendHostingMessage(hostingMessages);
//        }
//    }

//    private String getPreProcessBodyPath(GroupUserEx groupUserEx, String messageContent) throws ErrorInfo {
//        String preProcessBody = preProcess(groupUserEx, messageContent);
//        return FileStorageUtil.saveContentText(preProcessBody, "");
//    }

    private String getPreProcessBodyPath(Receiver receiver, String messageContent) throws ErrorInfo {
        String preProcessBody = preProcess(receiver, messageContent);
        return FileStorageUtil.saveContentText(preProcessBody, "");
    }
}
