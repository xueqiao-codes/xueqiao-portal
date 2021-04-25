package xueqiao.mailbox.dao.storage.handler;

import org.soldier.platform.dal_set.DalSetDataSource;
import org.soldier.platform.db_helper.DBQueryHelper;
import org.soldier.platform.svr_platform.comm.ErrorInfo;
import xueqiao.mailbox.dao.storage.bean.TmSendingTimeRule;
import xueqiao.mailbox.dao.storage.table.MSendingTimeRuleTable;

import java.sql.Connection;
import java.util.List;
import java.util.Set;

public class MSendingTimeRuleHandler {

    public static List<TmSendingTimeRule> queryList(DalSetDataSource dataSource, Set<Long> mbmIdSet) throws ErrorInfo {
        return new DBQueryHelper<List<TmSendingTimeRule>>(dataSource) {
            @Override
            protected List<TmSendingTimeRule> onQuery(Connection connection) throws Exception {
                return new MSendingTimeRuleTable(connection).queryList(mbmIdSet);
            }
        }.query();
    }
}
