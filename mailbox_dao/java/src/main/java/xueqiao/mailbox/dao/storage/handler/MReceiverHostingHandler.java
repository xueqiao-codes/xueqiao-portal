package xueqiao.mailbox.dao.storage.handler;

import org.soldier.platform.dal_set.DalSetDataSource;
import org.soldier.platform.db_helper.DBQueryHelper;
import org.soldier.platform.svr_platform.comm.ErrorInfo;
import xueqiao.mailbox.dao.storage.bean.TmbReceiverHosting;
import xueqiao.mailbox.dao.storage.table.MReceiverHostingTable;

import java.sql.Connection;
import java.util.List;
import java.util.Set;

public class MReceiverHostingHandler {
    public static List<TmbReceiverHosting> queryList(DalSetDataSource dataSource, Set<Long> mbmIdSet) throws ErrorInfo {
        return new DBQueryHelper<List<TmbReceiverHosting>>(dataSource) {
            @Override
            protected List<TmbReceiverHosting> onQuery(Connection connection) throws Exception {
                return new MReceiverHostingTable(connection).queryList(mbmIdSet);
            }
        }.query();
    }
}
