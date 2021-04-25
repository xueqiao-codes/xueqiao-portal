package xueqiao.mailbox.dao.storage.table;

import org.soldier.base.sql.PreparedFields;
import org.soldier.base.sql.SqlQueryBuilder;
import org.soldier.platform.db_helper.TableHelper;
import xueqiao.mailbox.dao.storage.bean.TmSendingTimeRule;
import xueqiao.mailbox.thriftdata.mb.MSendingTimeRepeatUnit;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;

public class MSendingTimeRuleTable extends TableHelper<TmSendingTimeRule> {

    private final static String TABLE_NAME = "tmb_sending_time_rule";

    private final static String F_MB_MID = "Fmb_mid";
    private final static String F_MB_START_TIME = "Fmb_start_time";
    private final static String F_REPEAT_UNIT = "Frepeat_unit";
    private final static String F_REPEAT_COUNT = "Frepeat_count";
    private final static String F_DAY_TIME_LIST = "Fday_time_list";
    private final static String F_UNIT_TIME_LIST = "Funit_time_list";

    public MSendingTimeRuleTable(Connection conn) {
        super(conn);
    }

    public void insert(TmSendingTimeRule timeRule) throws SQLException {
        PreparedFields pf = new PreparedFields();
        pf.addLong(F_MB_MID, timeRule.getMbmId());
        pf.addLong(F_MB_START_TIME, timeRule.getMbStartTime());
        pf.addInt(F_REPEAT_UNIT, timeRule.getRepeatUnit().getValue());
        pf.addInt(F_REPEAT_COUNT, timeRule.getRepeatCount());
        pf.addString(F_DAY_TIME_LIST, timeRule.getDayTimeList());
        pf.addString(F_UNIT_TIME_LIST, timeRule.getUnitTimeList());
        super.insert(pf);
    }

    public TmSendingTimeRule query(long mbmId) throws SQLException {
        SqlQueryBuilder qryBuilder = super.prepareSqlQueryBuilder();
        qryBuilder.addFieldCondition(SqlQueryBuilder.ConditionType.AND, F_MB_MID + "=?", mbmId);
        return super.getItem(qryBuilder);
    }

    public List<TmSendingTimeRule> queryList(Set<Long> mbmIdSet) throws SQLException {
        SqlQueryBuilder qryBuilder = super.prepareSqlQueryBuilder();
        qryBuilder.addInFieldCondition(SqlQueryBuilder.ConditionType.AND, F_MB_MID, mbmIdSet);
        return super.getItemList(qryBuilder);
    }

    @Override
    protected String getTableName() throws SQLException {
        return TABLE_NAME;
    }

    @Override
    public TmSendingTimeRule fromResultSet(ResultSet rs) throws Exception {
        TmSendingTimeRule timeRule = new TmSendingTimeRule();
        timeRule.setMbmId(rs.getLong(F_MB_MID));
        timeRule.setMbStartTime(rs.getLong(F_MB_START_TIME));
        timeRule.setRepeatUnit(MSendingTimeRepeatUnit.findByValue(rs.getInt(F_REPEAT_UNIT)));
        timeRule.setRepeatCount(rs.getInt(F_REPEAT_COUNT));
        timeRule.setDayTimeList(rs.getString(F_DAY_TIME_LIST));
        timeRule.setUnitTimeList(rs.getString(F_UNIT_TIME_LIST));
        return timeRule;
    }
}
