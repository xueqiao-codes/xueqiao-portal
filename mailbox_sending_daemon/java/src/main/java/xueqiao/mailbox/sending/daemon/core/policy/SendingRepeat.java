package xueqiao.mailbox.sending.daemon.core.policy;

/**
 * 重复发送策略暂未在产品中使用，暂不实现
 * */
public class SendingRepeat implements ISendingPolicy {
    @Override
    public boolean sendNow() {
        return false;
    }

    @Override
    public boolean isMessageCompleted() {
        return false;
    }
}
