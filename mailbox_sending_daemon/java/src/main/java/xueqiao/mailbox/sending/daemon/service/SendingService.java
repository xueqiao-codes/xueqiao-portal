package xueqiao.mailbox.sending.daemon.service;

import xueqiao.mailbox.sending.daemon.core.controller.SendingMessageController;

public class SendingService extends AbstractService {

    private SendingMessageController controller;

    public SendingService() {
        super("SendingService");
        controller = new SendingMessageController();
    }

    @Override
    protected void execute() {
        controller.startSendingLoopUtilEmpty();
    }
}
