package xueqiao.mailbox.sending.daemon.core.policy;

/**
 * 单次定时发送
 */
public class SendingFixedTime implements ISendingPolicy {
    @Override
    public boolean sendNow() {
        return false;
    }

    @Override
    public boolean isMessageCompleted() {
        return true;
    }
}
