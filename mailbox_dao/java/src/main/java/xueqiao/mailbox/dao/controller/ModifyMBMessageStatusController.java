package xueqiao.mailbox.dao.controller;

import org.soldier.platform.db_helper.DBStepHelper;
import org.soldier.platform.svr_platform.comm.ErrorInfo;
import org.soldier.platform.svr_platform.container.TServiceCntl;
import xueqiao.mailbox.dao.common.base.Precondition;
import xueqiao.mailbox.dao.controller.base.AbstractController;
import xueqiao.mailbox.dao.storage.table.MBMessageTable;
import xueqiao.mailbox.thriftdata.mb.MStatus;

public class ModifyMBMessageStatusController extends AbstractController {

    private long mbmId;
    private MStatus status;

    public ModifyMBMessageStatusController(TServiceCntl oCntl) {
        super(oCntl);
    }

    public ModifyMBMessageStatusController params(long mbmId, MStatus status) {
        this.mbmId = mbmId;
        this.status = status;
        return this;
    }

    @Override
    public void checkParams() throws ErrorInfo {
        Precondition.check(mbmId > 0, "invalid mbmId");
    }

    public void doModify() throws ErrorInfo {
        new DBStepHelper<Void>(getDalSetDataSource()) {
            @Override
            public void onPrepareData() throws ErrorInfo, Exception {

            }

            @Override
            public void onUpdate() throws ErrorInfo, Exception {
                new MBMessageTable(getConnection()).updateStatus(mbmId, status);
            }

            @Override
            public Void getResult() {
                return null;
            }
        }.execute();
    }
}
