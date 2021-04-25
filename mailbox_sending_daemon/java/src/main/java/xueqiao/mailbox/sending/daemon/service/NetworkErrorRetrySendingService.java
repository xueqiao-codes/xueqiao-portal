package xueqiao.mailbox.sending.daemon.service;

import xueqiao.mailbox.sending.daemon.core.controller.NetworkErrorRetrySendingController;

public class NetworkErrorRetrySendingService extends AbstractService {

    private NetworkErrorRetrySendingController controller;

    public NetworkErrorRetrySendingService() {
        super("NetworkErrorRetrySendingService");
        controller = new NetworkErrorRetrySendingController();
    }

    @Override
    protected void execute() {
        controller.startSendingLoopUtilEmpty();
    }
}
