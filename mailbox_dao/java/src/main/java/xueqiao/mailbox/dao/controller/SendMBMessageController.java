package xueqiao.mailbox.dao.controller;

import org.soldier.platform.svr_platform.comm.ErrorInfo;
import org.soldier.platform.svr_platform.container.TServiceCntl;
import xueqiao.mailbox.dao.controller.base.AbstractController;

public class SendMBMessageController extends AbstractController {

    private long mbmId;

    public SendMBMessageController(TServiceCntl oCntl) {
        super(oCntl);
    }

    public SendMBMessageController params(long mbmId) {
        this.mbmId = mbmId;
        return this;
    }

    @Override
    public void checkParams() throws ErrorInfo {

    }

    public void doSend() {

    }
}
