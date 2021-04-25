package xueqiao.mailbox.dao.storage.handler;

import org.soldier.platform.dal_set.DalSetDataSource;
import org.soldier.platform.db_helper.DBQueryHelper;
import org.soldier.platform.svr_platform.comm.ErrorInfo;
import xueqiao.mailbox.dao.storage.table.MReceiverSmsTable;
import xueqiao.mailbox.thriftdata.mb.MReceiverSms;

import java.sql.Connection;
import java.util.List;
import java.util.Set;

public class MReceiverSmsHandler {

    public static List<MReceiverSms> queryList(DalSetDataSource dataSource, Set<Long> mbmIdSet) throws ErrorInfo {
        return new DBQueryHelper<List<MReceiverSms>>(dataSource) {
            @Override
            protected List<MReceiverSms> onQuery(Connection connection) throws Exception {
                return new MReceiverSmsTable(connection).queryList(mbmIdSet);
            }
        }.query();
    }
}
