package xueqiao.mailbox.sending.daemon.service;

import xueqiao.mailbox.sending.daemon.app.AppConfig;
import xueqiao.mailbox.sending.daemon.core.controller.AddToMessageJobController;

/**
 * 该服务只负责把将要发送的消息添加一份实例到job列表.
 */
public class AddToMessageJobService extends AbstractService {

    private AddToMessageJobController controller;

    public AddToMessageJobService() {
        super("AddToMessageJobService");
        controller = new AddToMessageJobController();
        setSleepTimeMillis(AppConfig.DAEMON_ADD_TO_JOB_TIME_PERIOD_MILLIS);
    }

    @Override
    protected void execute() {
        controller.startSendingLoopUtilEmpty();
    }
}
