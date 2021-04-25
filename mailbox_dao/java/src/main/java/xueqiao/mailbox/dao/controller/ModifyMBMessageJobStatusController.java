package xueqiao.mailbox.dao.controller;

import org.soldier.platform.db_helper.DBStepHelper;
import org.soldier.platform.svr_platform.comm.ErrorInfo;
import org.soldier.platform.svr_platform.container.TServiceCntl;
import xueqiao.mailbox.dao.common.base.Precondition;
import xueqiao.mailbox.dao.controller.base.AbstractController;
import xueqiao.mailbox.dao.storage.table.MBMessageJobTable;
import xueqiao.mailbox.thriftdata.mb.MJStatus;

public class ModifyMBMessageJobStatusController extends AbstractController {

    private long jobId;
    private MJStatus status;
    private String errorDescription;

    public ModifyMBMessageJobStatusController(TServiceCntl oCntl) {
        super(oCntl);
    }

    public ModifyMBMessageJobStatusController params(long jobId, xueqiao.mailbox.thriftdata.mb.MJStatus status, String errorDescription) {
        this.jobId = jobId;
        this.status = status;
        this.errorDescription = errorDescription;
        return this;
    }

    @Override
    public void checkParams() throws ErrorInfo {
        Precondition.check(jobId > 0, "invalid jobId");
    }

    public void doModify() throws ErrorInfo {
        new DBStepHelper<Void>(getDalSetDataSource()) {
            @Override
            public void onPrepareData() throws ErrorInfo, Exception {

            }

            @Override
            public void onUpdate() throws ErrorInfo, Exception {
                if (status == MJStatus.MJS_COMPLETED) {
                    errorDescription = "";
                }
                new MBMessageJobTable(getConnection()).updateStatus(jobId, status, errorDescription);
            }

            @Override
            public Void getResult() {
                return null;
            }
        }.execute();
    }
}
