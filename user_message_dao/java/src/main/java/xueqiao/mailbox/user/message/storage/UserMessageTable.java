package xueqiao.mailbox.user.message.storage;

import com.antiy.error_code.ErrorCodeOuter;
import com.google.common.base.Preconditions;
import org.soldier.base.logger.AppLog;
import org.soldier.base.sql.PreparedFields;
import org.soldier.base.sql.SqlQueryBuilder;
import org.soldier.platform.dal_set.DalSetTableHelper;
import org.soldier.platform.id_maker.IdException;
import org.soldier.platform.page.IndexedPageOption;
import org.soldier.platform.svr_platform.comm.ErrorInfo;
import xueqiao.mailbox.user.message.config.ConfigurationProperty;
import xueqiao.mailbox.user.message.thriftapi.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Set;

public class UserMessageTable extends DalSetTableHelper<UserMessage> {

    private static final String TABLE_NAME = "tuser_message_";
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


    public UserMessageTable(Connection conn, String roleName) {
        super(conn, roleName);
    }

    @Override
    protected String getTableNamePrefix() {
        return TABLE_NAME;
    }

    @Override
    public UserMessage fromResultSet(ResultSet resultSet) throws Exception {
        UserMessage hostingMessage = new UserMessage();
        hostingMessage.setMessageId(resultSet.getLong(FMESSAGE_ID));
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

    public void add(UserMessage userMessage) throws ErrorInfo, SQLException {
        Preconditions.checkNotNull(userMessage);
        Preconditions.checkArgument(userMessage.isSetCompanyId());
        Preconditions.checkArgument(userMessage.isSetUserId());
        Preconditions.checkArgument(userMessage.isSetMessageJobId());

        setTableKey(userMessage.getUserId());

        long messageId;
        try {
            messageId = ConfigurationProperty.instance().getUserMessageIdMaker().createId();
        } catch (IdException e) {
            AppLog.e(e.getMessage(), e);
            throw new ErrorInfo(ErrorCodeOuter.SERVER_BUSY.getErrorCode(), "Create hosting message id fail.");
        }

        PreparedFields fields = getPreparedFields(userMessage);

        fields.addLong(FMESSAGE_ID, messageId);
        long now = System.currentTimeMillis() / 1000;
        fields.addLong(FCREATE_TIMESTAMP, now);
        fields.addLong(FLAST_MODIFY_TIMESTAMP, now);
        super.insert(fields);
    }

    private PreparedFields getPreparedFields(UserMessage hostingMessage) {
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

    public void update(UserMessage userMessage) throws SQLException {
        Preconditions.checkNotNull(userMessage);
        Preconditions.checkArgument(userMessage.isSetMessageId());
        Preconditions.checkArgument(userMessage.isSetUserId());
        PreparedFields fields = getPreparedFields(userMessage);
        setTableKey(userMessage.getUserId());

        long now = System.currentTimeMillis() / 1000;
        fields.addLong(FLAST_MODIFY_TIMESTAMP, now);
        super.update(fields, FMESSAGE_ID + "=?", userMessage.getMessageId());
    }

    public void markRead(long userId, Set<Long> messageIds) throws SQLException {
        Preconditions.checkNotNull(messageIds);
        Preconditions.checkArgument(messageIds.size() > 0);
        setTableKey(userId);
        PreparedFields fields = new PreparedFields();
        fields.addInt(FMESSAGE_STATE, MessageState.READ.getValue());
        long now = System.currentTimeMillis() / 1000;
        fields.addLong(FLAST_MODIFY_TIMESTAMP, now);

        StringBuilder condition = new StringBuilder(128);
        Iterator it = messageIds.iterator();
        condition.append(" IN (");
        while (it.hasNext()) {
            condition.append(it.next());
            if (it.hasNext()) {
                condition.append(",");
            }
        }
        condition.append(")");
        AppLog.d(" condition :" + condition);

        super.update(fields, FMESSAGE_ID + condition.toString());
    }

    public UserMessage queryCheck(long messageJobId, long userId) throws SQLException {
        setTableKey(userId);
        SqlQueryBuilder builder = super.prepareSqlQueryBuilder();
        builder.addFieldCondition(SqlQueryBuilder.ConditionType.AND, FMESSAGE_JOB_ID + "=?", messageJobId);
        builder.addFieldCondition(SqlQueryBuilder.ConditionType.AND, FUSER_ID + "=?", userId);
        return super.getItem(builder);
    }

    public UserMessagePage query(ReqUserMessageOption option, IndexedPageOption pageOption) throws SQLException {
        Preconditions.checkNotNull(option);
        Preconditions.checkArgument(option.isSetUserId());
        setTableKey(option.getUserId());
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
            if (option.isSetMessageId()) {
                builder.addFieldCondition(SqlQueryBuilder.ConditionType.AND, FMESSAGE_ID + "+?", option.getMessageId());
            }
            if (option.isSetState()) {
                builder.addFieldCondition(SqlQueryBuilder.ConditionType.AND, FMESSAGE_STATE + "=?", option.getState().getValue());
            }
            if (option.isSetStartTimestamp()) {
                builder.addFieldCondition(SqlQueryBuilder.ConditionType.AND, FCREATE_TIMESTAMP + ">=?", option.getStartTimestamp());
            }
            if (option.isSetEndTimstamp()) {
                builder.addFieldCondition(SqlQueryBuilder.ConditionType.AND, FCREATE_TIMESTAMP + "<=?", option.getEndTimstamp());
            }
        }
        UserMessagePage page = new UserMessagePage();
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
