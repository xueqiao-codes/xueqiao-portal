package xueqiao.mailbox.dao.controller;

import com.antiy.error_code.ErrorCodeInner;
import org.soldier.platform.db_helper.DBTransactionHelper;
import org.soldier.platform.svr_platform.comm.ErrorInfo;
import org.soldier.platform.svr_platform.container.TServiceCntl;
import xueqiao.mailbox.dao.common.base.Precondition;
import xueqiao.mailbox.dao.controller.base.AbstractController;
import xueqiao.mailbox.dao.storage.bean.TmbMessageJob;
import xueqiao.mailbox.dao.storage.table.MBMessageJobTable;
import xueqiao.mailbox.dao.storage.table.MBMessageTable;
import xueqiao.mailbox.thriftdata.mb.MJStatus;
import xueqiao.mailbox.thriftdata.mb.MStatus;

public class SendMBMessageSuccessController extends AbstractController {

    private long jobId;
    private boolean isMessageCompleted;

    public SendMBMessageSuccessController(TServiceCntl oCntl) {
        super(oCntl);
    }

    public SendMBMessageSuccessController params(long jobId, boolean isMessageCompleted) {
        this.jobId = jobId;
        this.isMessageCompleted = isMessageCompleted;
        return this;
    }

    @Override
    public void checkParams() throws ErrorInfo {
        Precondition.check(jobId > 0, "invalid jobId");
    }

    public void setStatus() throws ErrorInfo {
        doSet();
    }

    private void doSet() throws ErrorInfo {
        new DBTransactionHelper<Void>(getDalSetDataSource()) {

            MBMessageJobTable jobTable;
            TmbMessageJob tmbMessageJob;

            @Override
            public void onPrepareData() throws ErrorInfo, Exception {
                jobTable = new MBMessageJobTable(getConnection());
                tmbMessageJob = jobTable.query(jobId);
                if (tmbMessageJob == null) {
                    throw new ErrorInfo(ErrorCodeInner.PARAM_ERROR.getErrorCode(), "messageJob not found, jobId : " + jobId);
                }
            }

            @Override
            public void onUpdate() throws ErrorInfo, Exception {
                jobTable.updateStatus(jobId, MJStatus.MJS_COMPLETED, "");
                MBMessageTable messageTable = new MBMessageTable(getConnection());
                /*
                * 消息发送之前会把消息任务设置成发送中状态
                * 如果发送完成，则设置完成状态
                * 如果是重复发送的消息，只是单次发送完成，则设置回有效状态
                * */
                if (isMessageCompleted) {
                    messageTable.updateStatus(tmbMessageJob.getMbmId(), MStatus.MS_COMPLETED);
                } else {
                    messageTable.updateStatus(tmbMessageJob.getMbmId(), MStatus.MS_VALID);
                }
            }

            @Override
            public Void getResult() {
                return null;
            }
        }.execute();
    }
}
