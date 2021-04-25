package xueqiao.mailbox.sending.daemon.core.policy;

/**
 * 单次立即发送
 * */
public class SendingNow implements ISendingPolicy {
    @Override
    public boolean sendNow() {
        return true;
    }

    @Override
    public boolean isMessageCompleted() {
        return true;
    }
}
