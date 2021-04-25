package xueqiao.mailbox.dao.storage.handler;

import org.soldier.platform.dal_set.DalSetDataSource;
import org.soldier.platform.db_helper.DBQueryHelper;
import org.soldier.platform.svr_platform.comm.ErrorInfo;
import xueqiao.mailbox.dao.storage.table.MReceiverMailTable;
import xueqiao.mailbox.thriftdata.mb.MReceiverMail;

import java.sql.Connection;
import java.util.List;
import java.util.Set;

public class MReceiverMailHandler {

    public static List<MReceiverMail> queryList(DalSetDataSource dataSource, Set<Long> mbmIdSet) throws ErrorInfo {
        return new DBQueryHelper<List<MReceiverMail>>(dataSource) {
            @Override
            protected List<MReceiverMail> onQuery(Connection connection) throws Exception {
                return new MReceiverMailTable(connection).queryList(mbmIdSet);
            }
        }.query();
    }
}
