package xueqiao.mailbox.dao.controller;

import com.antiy.error_code.ErrorCodeInner;
import org.soldier.platform.db_helper.DBTransactionHelper;
import org.soldier.platform.svr_platform.comm.ErrorInfo;
import org.soldier.platform.svr_platform.container.TServiceCntl;
import xueqiao.mailbox.dao.common.base.Precondition;
import xueqiao.mailbox.dao.controller.base.AbstractController;
import xueqiao.mailbox.dao.storage.bean.TmbMessage;
import xueqiao.mailbox.dao.storage.bean.TmbMessageJob;
import xueqiao.mailbox.dao.storage.table.MBMessageJobTable;
import xueqiao.mailbox.dao.storage.table.MBMessageTable;
import xueqiao.mailbox.dao.util.IdMakerUtil;
import xueqiao.mailbox.thriftdata.mb.MStatus;

/**
 * 将message设置成发送中状态（避免出错重复发送）
 * 生成messageJob
 * 返回jobId
 */
public class StartSendMBMessageController extends AbstractController {

    private long mbmId;
    private boolean isMessageCompleted;

    public StartSendMBMessageController(TServiceCntl oCntl) {
        super(oCntl);
    }

    public StartSendMBMessageController params(long mbmId, boolean isMessageCompleted) {
        this.mbmId = mbmId;
        this.isMessageCompleted = isMessageCompleted;
        return this;
    }

    @Override
    public void checkParams() throws ErrorInfo {
        Precondition.check(mbmId > 0, "invalid mbmId");
    }

    public long start() throws ErrorInfo {
        return createMessageJob();
    }

    private long createMessageJob() throws ErrorInfo {
        return new DBTransactionHelper<Long>(getDalSetDataSource()) {

            MBMessageTable messageTable;
            TmbMessage tmbMessage;
            long jobId;

            @Override
            public void onPrepareData() throws ErrorInfo, Exception {
                messageTable = new MBMessageTable(getConnection());
                tmbMessage = messageTable.query(mbmId);
                if (tmbMessage == null) {
                    throw new ErrorInfo(ErrorCodeInner.PARAM_ERROR.getErrorCode(), "message not found, mbmId : " + mbmId);
                }
            }

            @Override
            public void onUpdate() throws ErrorInfo, Exception {
                /*
                * 消息发送时，移交到JOB后，发送的状态由JOB来跟踪
                * */
                if (isMessageCompleted) {
                    messageTable.updateStatus(mbmId, MStatus.MS_COMPLETED);
                } else {
                    messageTable.updateStatus(mbmId, MStatus.MS_VALID);
                }

                jobId = IdMakerUtil.genMBMessageJobId();
                TmbMessageJob tmbMessageJob = new TmbMessageJob();
                tmbMessageJob.setJobId(jobId);
                tmbMessageJob.setMbmId(tmbMessage.getMbmId());
                tmbMessageJob.setChannel(tmbMessage.getChannel());
                tmbMessageJob.setContentType(tmbMessage.getContentType());
                tmbMessageJob.setContentLevel(tmbMessage.getContentLevel());
                tmbMessageJob.setContentTitle(tmbMessage.getContentTitle());
                tmbMessageJob.setContentSummary(tmbMessage.getContentSummary());
                tmbMessageJob.setContentBody(tmbMessage.getContentBody());
                tmbMessageJob.setErrorDescription("");
                tmbMessageJob.setOperator(tmbMessage.getOperator());

                new MBMessageJobTable(getConnection()).insert(tmbMessageJob);
            }

            @Override
            public Long getResult() {
                return jobId;
            }
        }.execute().getResult();
    }
}
