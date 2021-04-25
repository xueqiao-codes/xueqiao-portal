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

public class MTemplateRecevierMailTable extends TableHelper<MReceiverMail> {

    private final static String TABLE_NAME = "tmb_template_receiver_mail";

    private final static String F_TEMPLATE_ID = "Ftemplate_id";
    private final static String F_MB_RECEIVER_MAIL = "Fmb_receiver_mail";

    public MTemplateRecevierMailTable(Connection conn) {
        super(conn);
    }

    public void insert(MReceiverMail receiverMail) throws SQLException {
        PreparedFields pf = new PreparedFields();
        pf.addLong(F_TEMPLATE_ID, receiverMail.getMbmId());
        pf.addString(F_MB_RECEIVER_MAIL, receiverMail.getMail());
        super.insert(pf);
    }

    public void delete(long mbmId) throws SQLException {
        super.delete(F_TEMPLATE_ID + "=?", mbmId);
    }

    public void delete(long mbmId, String mail) throws SQLException {
        super.delete(F_TEMPLATE_ID + "=? AND " + F_MB_RECEIVER_MAIL + "=?", mbmId, mail);
    }

    public List<MReceiverMail> query(long mbmId) throws SQLException {
        SqlQueryBuilder qryBuilder = super.prepareSqlQueryBuilder();
        qryBuilder.addFieldCondition(SqlQueryBuilder.ConditionType.AND, F_TEMPLATE_ID + "=?", mbmId);
        return super.getItemList(qryBuilder);
    }

    public List<MReceiverMail> queryList(Set<Long> mbmIdSet) throws SQLException {
        SqlQueryBuilder qryBuilder = super.prepareSqlQueryBuilder();
        qryBuilder.addInFieldCondition(SqlQueryBuilder.ConditionType.AND, F_TEMPLATE_ID, mbmIdSet);
        return super.getItemList(qryBuilder);
    }

    @Override
    protected String getTableName() throws SQLException {
        return TABLE_NAME;
    }

    @Override
    public MReceiverMail fromResultSet(ResultSet rs) throws Exception {
        MReceiverMail receiverMail = new MReceiverMail();
        receiverMail.setMbmId(rs.getLong(F_TEMPLATE_ID));
        receiverMail.setMail(rs.getString(F_MB_RECEIVER_MAIL));
        return receiverMail;
    }
}
