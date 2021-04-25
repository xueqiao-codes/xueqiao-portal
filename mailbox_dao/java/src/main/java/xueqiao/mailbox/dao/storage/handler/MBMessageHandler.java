package xueqiao.mailbox.dao.storage.handler;

import org.soldier.platform.dal_set.DalSetDataSource;
import org.soldier.platform.db_helper.DBQueryHelper;
import org.soldier.platform.page.IndexedPageOption;
import org.soldier.platform.svr_platform.comm.ErrorInfo;
import xueqiao.mailbox.dao.storage.bean.TmbMessage;
import xueqiao.mailbox.dao.storage.bean.TmbMessagePage;
import xueqiao.mailbox.dao.storage.table.MBMessageTable;
import xueqiao.mailbox.thriftdata.req.QueryMBMessageOption;

import java.sql.Connection;

public class MBMessageHandler {
    public static TmbMessagePage queryPage(DalSetDataSource dataSource, QueryMBMessageOption queryOption, IndexedPageOption pageOption) throws ErrorInfo {
        return new DBQueryHelper<TmbMessagePage>(dataSource) {
            @Override
            protected TmbMessagePage onQuery(Connection connection) throws Exception {
                return new MBMessageTable(connection).queryPage(queryOption, pageOption);
            }
        }.query();
    }

}
