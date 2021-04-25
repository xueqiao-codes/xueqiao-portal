package xueqiao.mailbox.dao.storage.table;

import org.soldier.base.sql.PreparedFields;
import org.soldier.base.sql.SqlQueryBuilder;
import org.soldier.platform.db_helper.TableHelper;
import org.soldier.platform.page.IndexedPageOption;
import xueqiao.mailbox.dao.storage.bean.TmbMessage;
import xueqiao.mailbox.dao.storage.bean.TmbMessageJob;
import xueqiao.mailbox.dao.storage.bean.TmbMessageJobPage;
import xueqiao.mailbox.dao.util.MessageUtil;
import xueqiao.mailbox.thriftdata.mb.MJStatus;
import xueqiao.mailbox.thriftdata.mb.MStatus;
import xueqiao.mailbox.thriftdata.message.MLevel;
import xueqiao.mailbox.thriftdata.message.MType;
import xueqiao.mailbox.thriftdata.req.QueryMBMessageJobOption;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MBMessageJobTable extends TableHelper<TmbMessageJob> {

    private final static String TABLE_NAME = "tmb_message_job";

    private final static String F_JOB_ID = "Fmb_job_id";
    private final static String F_MB_MID = "Fmb_mid";
    private final static String F_MB_CHANNEL = "Fmb_channel";
    private final static String F_MB_STATUS = "Fmb_status";
    private final static String F_MB_CONTENT_TYPE = "Fmb_content_type";
    private final static String F_MB_CONTENT_LEVEL = "Fmb_content_level";
    private final static String F_MB_CONTENT_TITLE = "Fmb_content_title";
    private final static String F_MB_CONTENT_SUMMARY = "Fmb_content_summary";
    private final static String F_MB_CONTENT_BODY = "Fmb_content_body";
    private final static String F_MB_ERROR_DESCRIPTION = "Fmb_error_description";
    private final static String F_MB_OPERATOR = "Fmb_operator";
    private final static String F_CREATE_TIMESTAMP = "Fcreate_timestamp";
    private final static String F_LASTMODIFY_TIMESTAMP = "Flastmodify_timestamp";

    public MBMessageJobTable(Connection conn) {
        super(conn);
    }

    public void insert(TmbMessageJob job) throws SQLException {
        long currentTimestamp = System.currentTimeMillis() / 1000;
        PreparedFields pf = new PreparedFields();
        pf.addLong(F_JOB_ID, job.getJobId());
        pf.addLong(F_MB_MID, job.getMbmId());
        pf.addInt(F_MB_CHANNEL, job.getChannel());
        if (job.getStatus() != null) {
            pf.addInt(F_MB_STATUS, job.getStatus().getValue());
        }
        pf.addInt(F_MB_CONTENT_TYPE, job.getContentType().getValue());
        pf.addInt(F_MB_CONTENT_LEVEL, job.getContentLevel().getValue());
        pf.addString(F_MB_CONTENT_TITLE, job.getContentTitle());
        pf.addString(F_MB_CONTENT_SUMMARY, job.getContentSummary());
        pf.addString(F_MB_CONTENT_BODY, job.getContentBody());
        pf.addString(F_MB_ERROR_DESCRIPTION, job.getErrorDescription());
        pf.addString(F_MB_OPERATOR, job.getOperator());
        pf.addLong(F_CREATE_TIMESTAMP, currentTimestamp);
        pf.addLong(F_LASTMODIFY_TIMESTAMP, currentTimestamp);
        super.insert(pf);
    }

    public void updateStatus(long jobId, MJStatus status, String errorDescription) throws SQLException {
        long currentTimestamp = System.currentTimeMillis() / 1000;
        PreparedFields pf = new PreparedFields();
        pf.addInt(F_MB_STATUS, status.getValue());
        /*
        * errorDescription 为null，则不修改
        * */
        if (errorDescription != null) {
            pf.addString(F_MB_ERROR_DESCRIPTION, errorDescription);
        }
        pf.addLong(F_LASTMODIFY_TIMESTAMP, currentTimestamp);
        super.update(pf, F_JOB_ID + "=?", jobId);
    }

    public TmbMessageJob query(long jobId) throws SQLException {
        SqlQueryBuilder qryBuilder = super.prepareSqlQueryBuilder();
        qryBuilder.addFieldCondition(SqlQueryBuilder.ConditionType.AND, F_JOB_ID + "=?", jobId);
        return super.getItem(qryBuilder);
    }

    public TmbMessageJobPage queryPage(QueryMBMessageJobOption queryOption, IndexedPageOption pageOption) throws SQLException {
        SqlQueryBuilder qryBuilder = super.prepareSqlQueryBuilder();
        if (queryOption != null) {
            if (queryOption.isSetJobIdSet()) {
                qryBuilder.addInFieldCondition(SqlQueryBuilder.ConditionType.AND, F_JOB_ID, queryOption.getJobIdSet());
            }
            if (queryOption.isSetChannel()) {
                qryBuilder.addInFieldCondition(SqlQueryBuilder.ConditionType.AND, F_MB_CHANNEL, MessageUtil.convertChannelToIntegerList(queryOption.getChannel()));
            }
            if (queryOption.isSetType()) {
                qryBuilder.addFieldCondition(SqlQueryBuilder.ConditionType.AND, F_MB_CONTENT_TYPE + "=?", queryOption.getType().getValue());
            }
            if (queryOption.isSetLevel()) {
                qryBuilder.addFieldCondition(SqlQueryBuilder.ConditionType.AND, F_MB_CONTENT_LEVEL + "=?", queryOption.getLevel().getValue());
            }
            if (queryOption.isSetQueryStartCreateTimestamp()) {
                qryBuilder.addFieldCondition(SqlQueryBuilder.ConditionType.AND, F_CREATE_TIMESTAMP + ">=?", queryOption.getQueryStartCreateTimestamp());
            }
            if (queryOption.isSetQueryEndCreateTimestamp()) {
                qryBuilder.addFieldCondition(SqlQueryBuilder.ConditionType.AND, F_CREATE_TIMESTAMP + "<=?", queryOption.getQueryEndCreateTimestamp());
            }
            if (queryOption.isSetStatusSet()) {
                qryBuilder.addInFieldCondition(SqlQueryBuilder.ConditionType.AND, F_MB_STATUS, MessageUtil.getMJStatusValueSet(queryOption.getStatusSet()));
            }
        }
        qryBuilder.setOrder(SqlQueryBuilder.OrderType.DESC, F_LASTMODIFY_TIMESTAMP);
        TmbMessageJobPage page = new TmbMessageJobPage();
        if (pageOption != null) {
            qryBuilder.setPage(pageOption.getPageIndex(), pageOption.getPageSize());

            if (pageOption.isNeedTotalCount()) {
                page.setTotalNum(super.getTotalNum(qryBuilder));
            }
        }
        page.setJobList(super.getItemList(qryBuilder));
        return page;
    }

    @Override
    protected String getTableName() throws SQLException {
        return TABLE_NAME;
    }

    @Override
    public TmbMessageJob fromResultSet(ResultSet rs) throws Exception {
        TmbMessageJob job = new TmbMessageJob();
        job.setJobId(rs.getLong(F_JOB_ID));
        job.setMbmId(rs.getLong(F_MB_MID));
        job.setChannel(rs.getInt(F_MB_CHANNEL));
        job.setStatus(MJStatus.findByValue(rs.getInt(F_MB_STATUS)));
        job.setContentType(MType.findByValue(rs.getInt(F_MB_CONTENT_TYPE)));
        job.setContentLevel(MLevel.findByValue(rs.getInt(F_MB_CONTENT_LEVEL)));
        job.setContentTitle(rs.getString(F_MB_CONTENT_TITLE));
        job.setContentSummary(rs.getString(F_MB_CONTENT_SUMMARY));
        job.setContentBody(rs.getString(F_MB_CONTENT_BODY));
        job.setErrorDescription(rs.getString(F_MB_ERROR_DESCRIPTION));
        job.setOperator(rs.getString(F_MB_OPERATOR));
        job.setCreateTimestamp(rs.getLong(F_CREATE_TIMESTAMP));
        job.setLastModityTimestamp(rs.getLong(F_LASTMODIFY_TIMESTAMP));
        return job;
    }
}
