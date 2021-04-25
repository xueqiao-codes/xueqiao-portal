package xueqiao.mailbox.dao.storage.table;

import org.soldier.base.sql.PreparedFields;
import org.soldier.base.sql.SqlQueryBuilder;
import org.soldier.platform.db_helper.TableHelper;
import xueqiao.mailbox.dao.storage.bean.TmbReceiverHosting;
import xueqiao.mailbox.thriftdata.mb.HostingUserRole;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;

public class MTemplateReceiverHostingTable extends TableHelper<TmbReceiverHosting> {

    private final static String TABLE_NAME = "tmb_template_receiver_hosting";

    private final static String F_TEMPLATE_ID = "Ftemplate_id";
    private final static String F_COMPANY_ID = "Fcompany_id";
    private final static String F_GROUP_ID = "Fgroup_id";
    private final static String F_USER_ROLE = "Fuser_role";

    public MTemplateReceiverHostingTable(Connection conn) {
        super(conn);
    }

    public void insert(TmbReceiverHosting receiverHosting) throws SQLException {
        PreparedFields pf = new PreparedFields();
        pf.addLong(F_TEMPLATE_ID, receiverHosting.getMbmId());
        pf.addLong(F_COMPANY_ID, receiverHosting.getCompanyId());
        pf.addLong(F_GROUP_ID, receiverHosting.getGroupId());
        pf.addInt(F_USER_ROLE, receiverHosting.getRole());
        super.insert(pf);
    }

    public void update(TmbReceiverHosting receiverHosting) throws SQLException {
        PreparedFields pf = new PreparedFields();
        pf.addInt(F_USER_ROLE, receiverHosting.getRole());
        super.update(pf, F_TEMPLATE_ID + "=? AND " + F_COMPANY_ID + "=? AND " + F_GROUP_ID + "=?", receiverHosting.getMbmId(), receiverHosting.getCompanyId(), receiverHosting.getGroupId());
    }

    public void delete(long mbmId) throws SQLException {
        super.delete(F_TEMPLATE_ID + "=?", mbmId);
    }

    public void delete(long mbmId, long companyId, long groupId) throws SQLException {
        super.delete(F_TEMPLATE_ID + "=? AND " + F_COMPANY_ID + "=? AND " + F_GROUP_ID + "=?", mbmId, companyId, groupId);
    }

    public List<TmbReceiverHosting> query(long mbmId) throws SQLException {
        SqlQueryBuilder qryBuilder = super.prepareSqlQueryBuilder();
        qryBuilder.addFieldCondition(SqlQueryBuilder.ConditionType.AND, F_TEMPLATE_ID + "=?", mbmId);
        return super.getItemList(qryBuilder);
    }

    public List<TmbReceiverHosting> queryList(Set<Long> mbmIdSet) throws SQLException {
        SqlQueryBuilder qryBuilder = super.prepareSqlQueryBuilder();
        qryBuilder.addInFieldCondition(SqlQueryBuilder.ConditionType.AND, F_TEMPLATE_ID, mbmIdSet);
        return super.getItemList(qryBuilder);
    }

    @Override
    protected String getTableName() throws SQLException {
        return TABLE_NAME;
    }

    @Override
    public TmbReceiverHosting fromResultSet(ResultSet rs) throws Exception {
        TmbReceiverHosting receiverHosting = new TmbReceiverHosting();
        receiverHosting.setMbmId(rs.getLong(F_TEMPLATE_ID));
        receiverHosting.setCompanyId(rs.getLong(F_COMPANY_ID));
        receiverHosting.setGroupId(rs.getLong(F_GROUP_ID));
        receiverHosting.setRole(rs.getInt(F_USER_ROLE));
        return receiverHosting;
    }
}
