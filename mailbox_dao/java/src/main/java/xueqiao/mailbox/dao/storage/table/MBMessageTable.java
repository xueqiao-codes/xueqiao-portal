package xueqiao.mailbox.dao.storage.table;

import org.soldier.base.sql.PreparedFields;
import org.soldier.base.sql.SqlQueryBuilder;
import org.soldier.platform.db_helper.TableHelper;
import org.soldier.platform.page.IndexedPageOption;
import xueqiao.mailbox.dao.storage.bean.TmbMessage;
import xueqiao.mailbox.dao.storage.bean.TmbMessagePage;
import xueqiao.mailbox.thriftdata.mb.MSendingPolicy;
import xueqiao.mailbox.dao.util.MessageUtil;
import xueqiao.mailbox.thriftdata.mb.MStatus;
import xueqiao.mailbox.thriftdata.message.MLevel;
import xueqiao.mailbox.thriftdata.message.MType;
import xueqiao.mailbox.thriftdata.req.QueryMBMessageOption;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MBMessageTable extends TableHelper<TmbMessage> {

    private final static String TABLE_NAME = "tmb_message";

    private final static String F_MB_MID = "Fmb_mid";
    private final static String F_MB_POLICY = "Fmb_policy";
    private final static String F_MB_CHANNEL = "Fmb_channel";
    private final static String F_MB_STATUS = "Fmb_status";
    private final static String F_MB_CONTENT_TYPE = "Fmb_content_type";
    private final static String F_MB_CONTENT_LEVEL = "Fmb_content_level";
    private final static String F_MB_CONTENT_TITLE = "Fmb_content_title";
    private final static String F_MB_CONTENT_SUMMARY = "Fmb_content_summary";
    private final static String F_MB_CONTENT_BODY = "Fmb_content_body";
    private final static String F_MB_OPERATOR = "Fmb_operator";
    private final static String F_CREATE_TIMESTAMP = "Fcreate_timestamp";
    private final static String F_LASTMODIFY_TIMESTAMP = "Flastmodify_timestamp";

    public MBMessageTable(Connection conn) {
        super(conn);
    }

    public void insert(TmbMessage message) throws SQLException {
        long currentTimestamp = System.currentTimeMillis() / 1000;
        PreparedFields pf = new PreparedFields();
        pf.addLong(F_MB_MID, message.getMbmId());
        pf.addInt(F_MB_POLICY, message.getPolicy().getValue());
        pf.addInt(F_MB_CHANNEL, message.getChannel());
//        pf.addInt(F_MB_STATUS, message.getStatus().getValue());
        pf.addInt(F_MB_CONTENT_TYPE, message.getContentType().getValue());
        pf.addInt(F_MB_CONTENT_LEVEL, message.getContentLevel().getValue());
        pf.addString(F_MB_CONTENT_TITLE, message.getContentTitle());
        pf.addString(F_MB_CONTENT_SUMMARY, message.getContentSummary());
        pf.addString(F_MB_CONTENT_BODY, message.getContentBody());
        pf.addString(F_MB_OPERATOR, message.getOperator());
        pf.addLong(F_CREATE_TIMESTAMP, currentTimestamp);
        pf.addLong(F_LASTMODIFY_TIMESTAMP, currentTimestamp);
        super.insert(pf);
    }

    public void updateStatus(long mbmId, MStatus status) throws SQLException {
        long currentTimestamp = System.currentTimeMillis() / 1000;
        PreparedFields pf = new PreparedFields();
        pf.addInt(F_MB_STATUS, status.getValue());
        pf.addLong(F_LASTMODIFY_TIMESTAMP, currentTimestamp);
        super.update(pf, F_MB_MID + "=?", mbmId);
    }

    public TmbMessage query(long mbmId) throws SQLException {
        SqlQueryBuilder qryBuilder = super.prepareSqlQueryBuilder();
        qryBuilder.addFieldCondition(SqlQueryBuilder.ConditionType.AND, F_MB_MID + "=?", mbmId);
        return super.getItem(qryBuilder);
    }

    public TmbMessagePage queryPage(QueryMBMessageOption queryOption, IndexedPageOption pageOption) throws SQLException {
        SqlQueryBuilder qryBuilder = super.prepareSqlQueryBuilder();
        if (queryOption != null) {
            if (queryOption.isSetMbmIdSet()) {
                qryBuilder.addInFieldCondition(SqlQueryBuilder.ConditionType.AND, F_MB_MID, queryOption.getMbmIdSet());
            }
            if (queryOption.isSetStatusList()) {
                qryBuilder.addInFieldCondition(SqlQueryBuilder.ConditionType.AND, F_MB_STATUS, MessageUtil.getMStatusValueSet(queryOption.getStatusList()));
            }
        }
        qryBuilder.setOrder(SqlQueryBuilder.OrderType.DESC, F_LASTMODIFY_TIMESTAMP);
        TmbMessagePage page = new TmbMessagePage();
        if (pageOption != null) {
            qryBuilder.setPage(pageOption.getPageIndex(), pageOption.getPageSize());

            if (pageOption.isNeedTotalCount()) {
                page.setTotalNum(super.getTotalNum(qryBuilder));
            }
        }
        page.setMessageList(super.getItemList(qryBuilder));
        return page;
    }

    @Override
    protected String getTableName() throws SQLException {
        return TABLE_NAME;
    }

    @Override
    public TmbMessage fromResultSet(ResultSet rs) throws Exception {
        TmbMessage message = new TmbMessage();
        message.setMbmId(rs.getLong(F_MB_MID));
        message.setPolicy(MSendingPolicy.findByValue(rs.getInt(F_MB_POLICY)));
        message.setChannel(rs.getInt(F_MB_CHANNEL));
        message.setStatus(MStatus.findByValue(rs.getInt(F_MB_STATUS)));
        message.setContentType(MType.findByValue(rs.getInt(F_MB_CONTENT_TYPE)));
        message.setContentLevel(MLevel.findByValue(rs.getInt(F_MB_CONTENT_LEVEL)));
        message.setContentTitle(rs.getString(F_MB_CONTENT_TITLE));
        message.setContentSummary(rs.getString(F_MB_CONTENT_SUMMARY));
        message.setContentBody(rs.getString(F_MB_CONTENT_BODY));
        message.setOperator(rs.getString(F_MB_OPERATOR));
        message.setCreateTimestamp(rs.getLong(F_CREATE_TIMESTAMP));
        message.setLastModityTimestamp(rs.getLong(F_LASTMODIFY_TIMESTAMP));
        return message;
    }
}
