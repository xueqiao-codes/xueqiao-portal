package xueqiao.mailbox.dao.storage.handler;

import org.soldier.platform.dal_set.DalSetDataSource;
import org.soldier.platform.db_helper.DBQueryHelper;
import org.soldier.platform.page.IndexedPageOption;
import org.soldier.platform.svr_platform.comm.ErrorInfo;
import xueqiao.mailbox.dao.storage.bean.TmbMessageJobPage;
import xueqiao.mailbox.dao.storage.table.MBMessageJobTable;
import xueqiao.mailbox.thriftdata.req.QueryMBMessageJobOption;

import java.sql.Connection;

public class MBMessageJobHandler {
    public static TmbMessageJobPage queryPage(DalSetDataSource dataSource, QueryMBMessageJobOption queryOption, IndexedPageOption pageOption) throws ErrorInfo {
        return new DBQueryHelper<TmbMessageJobPage>(dataSource) {
            @Override
            protected TmbMessageJobPage onQuery(Connection connection) throws Exception {
                return new MBMessageJobTable(connection).queryPage(queryOption, pageOption);
            }
        }.query();
    }
}
