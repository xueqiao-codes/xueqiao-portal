package xueqiao.mailbox.sending.daemon.service;

import xueqiao.mailbox.sending.daemon.app.AppConfig;
import xueqiao.mailbox.sending.daemon.util.SleepUtil;

public abstract class AbstractService extends Thread {

    private int sleepMillis = AppConfig.DAEMON_DEFAULT_TIME_PERIOD_MILLIS;

    public AbstractService(String name) {
        super(name);
    }

    protected abstract void execute();

    /**
     * 设置休眠时间
     * 默认时间为10秒
     */
    protected void setSleepTimeMillis(int sleepMillis) {
        this.sleepMillis = sleepMillis;
    }

    @Override
    public void run() {
        do {
            execute();
            if (AppConfig.DEBUG) {
                SleepUtil.sleep(AppConfig.DAEMON_CHECK_TIME_PERIOD_MILLIS_TEST);
            } else {
                SleepUtil.sleep(sleepMillis);
            }
        } while (true);
    }
}
