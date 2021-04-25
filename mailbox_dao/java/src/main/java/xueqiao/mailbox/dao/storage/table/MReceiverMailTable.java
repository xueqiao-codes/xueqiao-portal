package xueqiao.mailbox.dao.storage.table;

import org.soldier.base.sql.PreparedFields;
import org.soldier.base.sql.SqlQueryBuilder;
import org.soldier.platform.db_helper.TableHelper;
import xueqiao.mailbox.thriftdata.mb.MReceiverMail;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;

public class MReceiverMailTable extends TableHelper<MReceiverMail> {

    private final static String TABLE_NAME = "tmb_receiver_mail";

    private final static String F_MB_MID = "Fmb_mid";
    private final static String F_MB_RECEIVER_MAIL = "Fmb_receiver_mail";

    public MReceiverMailTable(Connection conn) {
        super(conn);
    }

    public void insert(MReceiverMail receiverMail) throws SQLException {
        PreparedFields pf = new PreparedFields();
        pf.addLong(F_MB_MID, receiverMail.getMbmId());
        pf.addString(F_MB_RECEIVER_MAIL, receiverMail.getMail());
        super.insert(pf);
    }

    public MReceiverMail query(long mbmId) throws SQLException {
        SqlQueryBuilder qryBuilder = super.prepareSqlQueryBuilder();
        qryBuilder.addFieldCondition(SqlQueryBuilder.ConditionType.AND, F_MB_MID + "=?", mbmId);
        return super.getItem(qryBuilder);
    }

    public List<MReceiverMail> queryList(Set<Long> mbmIdSet) throws SQLException {
        SqlQueryBuilder qryBuilder = super.prepareSqlQueryBuilder();
        qryBuilder.addInFieldCondition(SqlQueryBuilder.ConditionType.AND, F_MB_MID, mbmIdSet);
        return super.getItemList(qryBuilder);
    }

    @Override
    protected String getTableName() throws SQLException {
        return TABLE_NAME;
    }

    @Override
    public MReceiverMail fromResultSet(ResultSet rs) throws Exception {
        MReceiverMail receiverMail = new MReceiverMail();
        receiverMail.setMbmId(rs.getLong(F_MB_MID));
        receiverMail.setMail(rs.getString(F_MB_RECEIVER_MAIL));
        return receiverMail;
    }
}
