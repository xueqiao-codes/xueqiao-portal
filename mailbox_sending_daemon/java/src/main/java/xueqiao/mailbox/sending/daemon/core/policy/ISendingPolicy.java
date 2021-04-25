package xueqiao.mailbox.sending.daemon.core.policy;

public interface ISendingPolicy {
    boolean sendNow();
    boolean isMessageCompleted();
}
