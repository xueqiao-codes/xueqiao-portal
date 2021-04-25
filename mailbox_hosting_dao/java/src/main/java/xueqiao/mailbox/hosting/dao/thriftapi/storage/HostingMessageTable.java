package xueqiao.mailbox.hosting.dao.thriftapi.storage;

import com.antiy.error_code.ErrorCodeOuter;
import com.google.common.base.Preconditions;
import org.apache.commons.dbutils.QueryRunner;
import org.soldier.base.logger.AppLog;
import org.soldier.base.sql.PreparedFields;
import org.soldier.base.sql.SqlQueryBuilder;
import org.soldier.platform.db_helper.TableHelper;
import org.soldier.platform.id_maker.IdException;
import org.soldier.platform.page.IndexedPageOption;
import org.soldier.platform.svr_platform.comm.ErrorInfo;
import xueqiao.mailbox.hosting.config.ConfigurationProperty;
import xueqiao.mailbox.hosting.thriftapi.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class HostingMessageTable extends TableHelper<HostingMessage> {

    private static final String TABLE_NAME = "t_hosting_message";
    private static final String FMESSAGE_ID = "Fmessage_id";
    private static final String FUSER_ID = "Fuser_id";
    private static final String FCOMPANY_ID = "Fcompany_id";
    private static final String FMESSAGE_JOB_ID = "Fmessage_job_id";
    private static final String FMESSAGE_TYPE = "Fmessage_type";
    private static final String FMESSAGE_LEVEL = "Fmessage_level";
    private static final String FMESSAGE_STATE = "Fmessage_state";
    private static final String FTITLE = "Ftitle";
    private static final String FSUMMARY = "Fsummary";
    private static final String FCONTENT_FILE_NAME = "Fcontent_file_name";

    private static final String FCREATE_TIMESTAMP = "Fcreate_timestamp";
    private static final String FLAST_MODIFY_TIMESTAMP = "Flast_modify_timestamp";


    public HostingMessageTable(Connection conn) {
        super(conn);
    }

    @Override
    protected String getTableName() throws SQLException {
        return TABLE_NAME;
    }

    @Override
    public HostingMessage fromResultSet(ResultSet resultSet) throws Exception {
        HostingMessage hostingMessage = new HostingMessage();
        hostingMessage.setHostingMessageId(resultSet.getLong(FMESSAGE_ID));
        hostingMessage.setCompanyId(resultSet.getLong(FCOMPANY_ID));
        hostingMessage.setUserId(resultSet.getLong(FUSER_ID));
        hostingMessage.setMessageJobId(resultSet.getLong(FMESSAGE_JOB_ID));
        hostingMessage.setType(MType.findByValue(resultSet.getInt(FMESSAGE_TYPE)));
        hostingMessage.setLevel(MLevel.findByValue(resultSet.getInt(FMESSAGE_LEVEL)));
        hostingMessage.setState(MessageState.findByValue(resultSet.getInt(FMESSAGE_STATE)));
        hostingMessage.setTitle(resultSet.getString(FTITLE));
        hostingMessage.setSummary(resultSet.getString(FSUMMARY));
        hostingMessage.setContentFileName(resultSet.getString(FCONTENT_FILE_NAME));
        hostingMessage.setCreateTimestamp(resultSet.getLong(FCREATE_TIMESTAMP));
        hostingMessage.setLastModifyTimestamp(resultSet.getLong(FLAST_MODIFY_TIMESTAMP));

        return hostingMessage;
    }

    public void add(HostingMessage hostingMessage) throws ErrorInfo, SQLException {
        Preconditions.checkNotNull(hostingMessage);
        Preconditions.checkArgument(hostingMessage.isSetCompanyId());
        Preconditions.checkArgument(hostingMessage.isSetUserId());
        Preconditions.checkArgument(hostingMessage.isSetMessageJobId());
        long messageId;
        try {
            messageId = ConfigurationProperty.instance().getHostingMessageIdMaker().createId();
        } catch (IdException e) {
            AppLog.e(e.getMessage(), e);
            throw new ErrorInfo(ErrorCodeOuter.SERVER_BUSY.getErrorCode(), "Create hosting message id fail.");
        }

        PreparedFields fields = getPreparedFields(hostingMessage);

        fields.addLong(FMESSAGE_ID, messageId);
        long now = System.currentTimeMillis() / 1000;
        fields.addLong(FCREATE_TIMESTAMP, now);
        fields.addLong(FLAST_MODIFY_TIMESTAMP, now);
        super.insert(fields);
    }

    private PreparedFields getPreparedFields(HostingMessage hostingMessage) {
        PreparedFields fields = new PreparedFields();

        if (hostingMessage.isSetCompanyId()) {
            fields.addLong(FCOMPANY_ID, hostingMessage.getCompanyId());
        }
        if (hostingMessage.isSetUserId()) {
            fields.addLong(FUSER_ID, hostingMessage.getUserId());
        }
        if (hostingMessage.isSetMessageJobId()) {
            fields.addLong(FMESSAGE_JOB_ID, hostingMessage.getMessageJobId());
        }
        if (hostingMessage.isSetType()) {
            fields.addInt(FMESSAGE_TYPE, hostingMessage.getType().getValue());
        }
        if (hostingMessage.isSetLevel()) {
            fields.addInt(FMESSAGE_LEVEL, hostingMessage.getLevel().getValue());
        }
        if (hostingMessage.isSetTitle()) {
            fields.addString(FTITLE, hostingMessage.getTitle());
        }
        if (hostingMessage.isSetSummary()) {
            fields.addString(FSUMMARY, hostingMessage.getSummary());
        }
        if (hostingMessage.isSetContentFileName()) {
            fields.addString(FCONTENT_FILE_NAME, hostingMessage.getContentFileName());
        }
        if (hostingMessage.isSetState()) {
            fields.addInt(FMESSAGE_STATE, hostingMessage.getState().getValue());
        }
        return fields;
    }

    public void update(HostingMessage hostingMessage) throws SQLException {
        Preconditions.checkNotNull(hostingMessage);
        Preconditions.checkArgument(hostingMessage.isSetHostingMessageId());
        PreparedFields fields = getPreparedFields(hostingMessage);

        long now = System.currentTimeMillis() / 1000;
        fields.addLong(FLAST_MODIFY_TIMESTAMP, now);
        super.update(fields, FMESSAGE_ID + "=?", hostingMessage.getHostingMessageId());
    }

    public void updateState(Set<Long> hostingMessageIds, MessageState state) throws SQLException {

        Preconditions.checkNotNull(state);
        Preconditions.checkNotNull(hostingMessageIds);
        Preconditions.checkArgument(hostingMessageIds.size() > 0);
        PreparedFields fields = new PreparedFields();
        fields.addInt(FMESSAGE_STATE, state.getValue());
        long now = System.currentTimeMillis() / 1000;
        fields.addLong(FLAST_MODIFY_TIMESTAMP, now);
        super.update(fields, FMESSAGE_ID + " in ?", hostingMessageIds);
    }

    public HostingMessage queryCheck(long messageJobId, long userId) throws SQLException {
        SqlQueryBuilder builder = super.prepareSqlQueryBuilder();
        builder.addFieldCondition(SqlQueryBuilder.ConditionType.AND, FMESSAGE_JOB_ID + "=?", messageJobId);
        builder.addFieldCondition(SqlQueryBuilder.ConditionType.AND, FUSER_ID + "=?", userId);
        return super.getItem(builder);
    }

    public HostingMessagePage query(ReqHostingMessageOption option, IndexedPageOption pageOption) throws SQLException {
        SqlQueryBuilder builder = super.prepareSqlQueryBuilder();
        if (option != null) {
            if (option.isSetMessageJobId()) {
                builder.addFieldCondition(SqlQueryBuilder.ConditionType.AND, FMESSAGE_JOB_ID + "=?", option.getMessageJobId());
            }
            if (option.isSetCompanyId()) {
                builder.addFieldCondition(SqlQueryBuilder.ConditionType.AND, FCOMPANY_ID + "=?", option.getCompanyId());
            }
            if (option.isSetUserId()) {
                builder.addFieldCondition(SqlQueryBuilder.ConditionType.AND, FUSER_ID + "=?", option.getUserId());
            }
            if (option.isSetHostingMessageId() && option.getHostingMessageIdSize() > 0) {
                builder.addInFieldCondition(SqlQueryBuilder.ConditionType.AND, FMESSAGE_ID, option.getHostingMessageId());
            }
            if (option.isSetState()) {
                builder.addFieldCondition(SqlQueryBuilder.ConditionType.AND, FMESSAGE_STATE + "=?", option.getState().getValue());
            }
        }
        HostingMessagePage page = new HostingMessagePage();
        if (pageOption != null) {
            if (pageOption.isNeedTotalCount()) {
                page.setTotal(super.getTotalNum(builder));
            }
            if (pageOption.isSetPageSize() && pageOption.getPageSize() > 0 && pageOption.isSetPageIndex() && pageOption.getPageIndex() >= 0) {
                builder.setPage(pageOption.getPageIndex(), pageOption.getPageSize());
            }
        }
        builder.setOrder(SqlQueryBuilder.OrderType.DESC, FCREATE_TIMESTAMP);
        page.setPage(super.getItemList(builder));
        return page;
    }
}
