package xueqiao.mailbox.dao.storage.table;

import org.soldier.base.sql.PreparedFields;
import org.soldier.base.sql.SqlQueryBuilder;
import org.soldier.platform.db_helper.TableHelper;
import xueqiao.mailbox.thriftdata.mb.MReceiverSms;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;

public class MReceiverSmsTable extends TableHelper<MReceiverSms> {

    private final static String TABLE_NAME = "tmb_receiver_sms";

    private final static String F_MB_MID = "Fmb_mid";
    private final static String F_MB_RECEIVER_TEL = "Fmb_receiver_tel";

    public MReceiverSmsTable(Connection conn) {
        super(conn);
    }

    public void insert(MReceiverSms receiverSms) throws SQLException {
        PreparedFields pf = new PreparedFields();
        pf.addLong(F_MB_MID, receiverSms.getMbmId());
        pf.addString(F_MB_RECEIVER_TEL, receiverSms.getTel());
        super.insert(pf);
    }

    public List<MReceiverSms> query(long mbmId) throws SQLException {
        SqlQueryBuilder qryBuilder = super.prepareSqlQueryBuilder();
        qryBuilder.addFieldCondition(SqlQueryBuilder.ConditionType.AND, F_MB_MID + "=?", mbmId);
        return super.getItemList(qryBuilder);
    }

    public List<MReceiverSms> queryList(Set<Long> mbmIdSet) throws SQLException {
        SqlQueryBuilder qryBuilder = super.prepareSqlQueryBuilder();
        qryBuilder.addInFieldCondition(SqlQueryBuilder.ConditionType.AND, F_MB_MID, mbmIdSet);
        return super.getItemList(qryBuilder);
    }

    @Override
    protected String getTableName() throws SQLException {
        return TABLE_NAME;
    }

    @Override
    public MReceiverSms fromResultSet(ResultSet rs) throws Exception {
        MReceiverSms receiverSms = new MReceiverSms();
        receiverSms.setMbmId(rs.getLong(F_MB_MID));
        receiverSms.setTel(rs.getString(F_MB_RECEIVER_TEL));
        return receiverSms;
    }
}
