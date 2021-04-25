package xueqiao.mailbox.sending.daemon.core.channel;

import com.antiy.error_code.ErrorCodeInner;
import com.google.gson.Gson;
import org.apache.commons.lang.StringUtils;
import org.apache.thrift.TException;
import org.soldier.base.logger.AppLog;
import org.soldier.platform.svr_platform.comm.ErrorInfo;
import xueqiao.mailbox.sending.daemon.api.MailAoApi;
import xueqiao.mailbox.sending.daemon.core.bean.Receiver;
import xueqiao.mailbox.sending.daemon.core.bean.SendingMessage;
import xueqiao.mailbox.sending.daemon.util.CollectionUtil;
import xueqiao.mailbox.sending.daemon.util.FileStorageUtil;

import java.util.*;

public class Mail extends Channel {

//    public Mail(long jobId, List<GroupUserEx> groupUserList, BaseMessage message) {
//        super(jobId, groupUserList, message);
//    }

    public Mail(SendingMessage sendingMessage) {
        super(sendingMessage);
    }

    @Override
    public void send() throws TException {
        doSend();
    }

    private void doSend() throws TException {

        AppLog.i("doSend ---- getMailList : " + new Gson().toJson(sendingMessage.getMailList()));

        if (CollectionUtil.isListBlank(sendingMessage.getMailList())) {
            return;
        }

        String messageBody = FileStorageUtil.readContentText(sendingMessage.getContent().getContent());
        if (StringUtils.isBlank(messageBody)) {
            throw new ErrorInfo(ErrorCodeInner.ILLEGAL_OPERATION_ERROR.getErrorCode(), "empty message body");
        }
        Iterator<Receiver> receiverIterator = sendingMessage.getMailList().iterator();
        while (receiverIterator.hasNext()) {
            Receiver receiver = receiverIterator.next();
            String messageContentPreProcess = preProcess(receiver, messageBody);
            sendMail(receiver.getEmail(), sendingMessage.getContent().getTitle(), messageContentPreProcess);
            receiverIterator.remove();
            AppLog.i("send mail : " + receiver.getEmail());
        }
    }

//    private void doSend() throws TException {
//        Map<String, String> hostingMap = new HashMap<>();
//        String hostingMailAddress;
//        /*
//         * 从托管机用户中获取邮箱地址
//         * */
//
//        AppLog.i("doSend ---- groupUserList : " + new Gson().toJson(groupUserList));
//
//        if (CollectionUtil.isListNotBlank(groupUserList)) {
//            String messageBody = FileStorageUtil.readContentText(message.getContent().getContent());
//            String messageContentPreProcess;
//
//            AppLog.i("doSend ---- messageBody : " + messageBody);
//
//            if (StringUtils.isBlank(messageBody)) {
//                return;
//            }
//            for (GroupUserEx groupUserEx : groupUserList) {
//                hostingMailAddress = hostingMap.get(groupUserEx.getEmail());
//                if (StringUtils.isBlank(hostingMailAddress)) {
//                    hostingMap.put(groupUserEx.getEmail(), groupUserEx.getEmail());
//                    messageContentPreProcess = preProcess(groupUserEx, messageBody);
//                    sendMail(groupUserEx.getEmail(), message.getContent().getTitle(), messageContentPreProcess);
//                }
//            }
////            Iterator<>
//        }
//
//        /*
//         * 从mailList中获取邮箱地址
//         * */
//
//        if (CollectionUtil.isListNotBlank(message.getMailList())) {
//            for (MReceiverMail receiverMail : message.getMailList()) {
//                hostingMailAddress = hostingMap.get(receiverMail.getMail());
//                /*
//                * 在hosting用户中已经发送过的，就不再重复发送
//                * */
//                if (StringUtils.isBlank(hostingMailAddress)) {
//                    sendMail(receiverMail.getMail(), message.getContent().getTitle(), message.getContent().getContent());
//                }
//            }
//        }
//
//    }

    private void sendMail(String mailAddress, String title, String content) throws TException {
        MailAoApi.sendMail(mailAddress, title, content);
        AppLog.i("sendMail ---- mailAddress : " + mailAddress + ", title : " + title);
    }

}
