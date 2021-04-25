package xueqiao.mailbox.sending.daemon.app;

public class AppConfig {
    public static final boolean DEBUG = false;

    /**
     *  核查时间周期（单位：毫秒）
     *  测试 10 秒检查一次时间
     */
    public static final int DAEMON_CHECK_TIME_PERIOD_MILLIS_TEST = 10000;

    /**
     *  DAEMON默认执行周期（单位：毫秒）
     *  10 秒
     */
    public static final int DAEMON_DEFAULT_TIME_PERIOD_MILLIS = 10000;

    /**
     *  添加消息到发送实例队列执行周期（单位：毫秒）
     *  5 秒
     */
    public static final int DAEMON_ADD_TO_JOB_TIME_PERIOD_MILLIS = 5000;

    /**
     *  核查时间周期（单位：毫秒）
     *  60 秒检查一次时间
     */
    public static final int DAEMON_CHECK_TIME_PERIOD_MILLIS = 60000;
}
