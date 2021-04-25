package xueqiao.mailbox.dao.storage.table;

import org.apache.commons.lang.StringUtils;
import org.soldier.base.sql.PreparedFields;
import org.soldier.base.sql.SqlQueryBuilder;
import org.soldier.platform.db_helper.TableHelper;
import xueqiao.mailbox.dao.storage.bean.TmSendingTimeRule;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;

public class MTemplateSendingTimeRuleTable extends TableHelper<TmSendingTimeRule> {

    private final static String TABLE_NAME = "tmb_template_sending_time_rule";

    private final static String F_TEMPLATE_ID = "Ftemplate_id";
    private final static String F_MB_START_TIME = "Fmb_start_time";
    private final static String F_REPEAT_UNIT = "Frepeat_unit";
    private final static String F_REPEAT_COUNT = "Frepeat_count";
    private final static String F_DAY_TIME_LIST = "Fday_time_list";
    private final static String F_UNIT_TIME_LIST = "Funit_time_list";
    private final static String F_CREATE_TIMESTAMP = "Fcreate_timestamp";
    private final static String F_LASTMODIFY_TIMESTAMP = "Flastmodify_timestamp";


    public MTemplateSendingTimeRuleTable(Connection conn) {
        super(conn);
    }

    public void insert(TmSendingTimeRule timeRule) throws SQLException {
        long currentTimestamp = System.currentTimeMillis() / 1000;
        PreparedFields pf = new PreparedFields();
        pf.addLong(F_TEMPLATE_ID, timeRule.getMbmId());
        pf.addLong(F_MB_START_TIME, timeRule.getMbStartTime());
        pf.addInt(F_REPEAT_UNIT, timeRule.getRepeatUnit().getValue());
        pf.addInt(F_REPEAT_COUNT, timeRule.getRepeatCount());
        pf.addString(F_DAY_TIME_LIST, timeRule.getDayTimeList());
        pf.addString(F_UNIT_TIME_LIST, timeRule.getUnitTimeList());
        pf.addLong(F_CREATE_TIMESTAMP, currentTimestamp);
        pf.addLong(F_LASTMODIFY_TIMESTAMP, currentTimestamp);
        super.insert(pf);
    }

    public void update(TmSendingTimeRule timeRule) throws SQLException {
        long currentTimestamp = System.currentTimeMillis() / 1000;
        PreparedFields pf = new PreparedFields();
        if (timeRule.getMbStartTime() > 0) {
            pf.addLong(F_MB_START_TIME, timeRule.getMbStartTime());
        }
        if (timeRule.getRepeatUnit() != null) {
            pf.addInt(F_REPEAT_UNIT, timeRule.getRepeatUnit().getValue());
        }
        if (timeRule.getRepeatCount() > 0) {
            pf.addInt(F_REPEAT_COUNT, timeRule.getRepeatCount());
        }
        if (StringUtils.isNotBlank(timeRule.getDayTimeList())) {
            pf.addString(F_DAY_TIME_LIST, timeRule.getDayTimeList());
        }
        if (StringUtils.isNotBlank(timeRule.getUnitTimeList())) {
            pf.addString(F_UNIT_TIME_LIST, timeRule.getUnitTimeList());
        }
        pf.addLong(F_LASTMODIFY_TIMESTAMP, currentTimestamp);
        super.update(pf, F_TEMPLATE_ID + "=?", timeRule.getMbmId());
    }

    public void delete(long mbmId) throws SQLException {
        super.delete(F_TEMPLATE_ID + "=?", mbmId);
    }

    public TmSendingTimeRule query(long mbmId) throws SQLException {
        SqlQueryBuilder qryBuilder = super.prepareSqlQueryBuilder();
        qryBuilder.addFieldCondition(SqlQueryBuilder.ConditionType.AND, F_TEMPLATE_ID + "=?", mbmId);
        return super.getItem(qryBuilder);
    }

    public List<TmSendingTimeRule> queryList(Set<Long> mbmIdSet) throws SQLException {
        SqlQueryBuilder qryBuilder = super.prepareSqlQueryBuilder();
        qryBuilder.addInFieldCondition(SqlQueryBuilder.ConditionType.AND, F_TEMPLATE_ID, mbmIdSet);
        return super.getItemList(qryBuilder);
    }

    @Override
    protected String getTableName() throws SQLException {
        return TABLE_NAME;
    }

    @Override
    public TmSendingTimeRule fromResultSet(ResultSet resultSet) throws Exception {
        return null;
    }
}
