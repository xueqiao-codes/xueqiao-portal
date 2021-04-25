package xueqiao.mailbox.sending.daemon.core.controller;

import com.antiy.error_code.ErrorCodeInner;
import com.google.gson.Gson;
import org.apache.thrift.TException;
import org.soldier.base.logger.AppLog;
import org.soldier.platform.svr_platform.comm.ErrorInfo;
import xueqiao.mailbox.sending.daemon.core.bean.SendingMessage;
import xueqiao.mailbox.sending.daemon.util.CollectionUtil;
import xueqiao.mailbox.sending.daemon.util.SleepUtil;
import xueqiao.mailbox.thriftdata.mb.*;
import xueqiao.mailbox.sending.daemon.core.channel.ChannelFactory;

public abstract class AbstractSendingController {

    public void startSendingLoopUtilEmpty() {
        while (true) {
            if (sendingOneRound()) {
                break;
            }
            SleepUtil.sleep(2000);
        }
    }

    protected abstract boolean sendingOneRound();

    protected void sendOneMessage(SendingMessage sendingMessage) throws TException {

        AppLog.i("sendOneMessage ---- sendingMessage : " + new Gson().toJson(sendingMessage));

        // 按渠道发送
        if (CollectionUtil.isListBlank(sendingMessage.getChannelList())) {
            throw new ErrorInfo(ErrorCodeInner.SERVER_INNER_ERROR.getErrorCode(), "Illegal message, channel list is empty");
        }
        for (MSendingChannel channel : sendingMessage.getChannelList()) {
            ChannelFactory.getChannel(channel, sendingMessage).send();
        }
    }
}
