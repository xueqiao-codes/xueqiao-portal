package xueqiao.mailbox.sending.daemon.core.channel;

import com.antiy.error_code.ErrorCodeInner;
import org.soldier.platform.svr_platform.comm.ErrorInfo;
import xueqiao.company.GroupUserEx;
import xueqiao.mailbox.sending.daemon.core.bean.BaseMessage;
import xueqiao.mailbox.sending.daemon.core.bean.SendingMessage;
import xueqiao.mailbox.thriftdata.mb.MSendingChannel;

import java.util.List;

public class ChannelFactory {

//    public static Channel getChannel(long jobId, MSendingChannel channel, List<GroupUserEx> groupUserList, BaseMessage message) throws ErrorInfo {
//        if (channel == MSendingChannel.MSC_MAIL) {
//            return new Mail(jobId, groupUserList, message);
//        } else if (channel == MSendingChannel.MSC_SMS) {
//            return new Sms(jobId, groupUserList, message);
//        } else if (channel == MSendingChannel.MSC_HOSTING) {
//            return new Hosting(jobId, groupUserList, message);
//        } else {
//            throw new ErrorInfo(ErrorCodeInner.SERVER_INNER_ERROR.getErrorCode(), "Illegal channel");
//        }
//    }

    public static Channel getChannel(MSendingChannel channel, SendingMessage sendingMessage) throws ErrorInfo {
        if (channel == MSendingChannel.MSC_MAIL) {
            return new Mail(sendingMessage);
        } else if (channel == MSendingChannel.MSC_SMS) {
            return new Sms(sendingMessage);
        } else if (channel == MSendingChannel.MSC_HOSTING) {
            return new Hosting(sendingMessage);
        } else {
            throw new ErrorInfo(ErrorCodeInner.SERVER_INNER_ERROR.getErrorCode(), "Illegal channel");
        }
    }
}
