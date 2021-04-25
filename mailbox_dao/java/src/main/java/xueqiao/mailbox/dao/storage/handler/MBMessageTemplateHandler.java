package xueqiao.mailbox.dao.storage.handler;

import org.soldier.platform.dal_set.DalSetDataSource;
import org.soldier.platform.db_helper.DBQueryHelper;
import org.soldier.platform.page.IndexedPageOption;
import org.soldier.platform.svr_platform.comm.ErrorInfo;
import xueqiao.mailbox.dao.storage.bean.TmbMessageTemplate;
import xueqiao.mailbox.dao.storage.bean.TmbMessageTemplatePage;
import xueqiao.mailbox.dao.storage.table.MBMessageTemplateTable;
import xueqiao.mailbox.thriftdata.req.QueryMBMessageTemplateOption;

import java.sql.Connection;

public class MBMessageTemplateHandler {

    public static TmbMessageTemplate query(DalSetDataSource dataSource, long templateId) throws ErrorInfo {
        return new DBQueryHelper<TmbMessageTemplate>(dataSource) {
            @Override
            protected TmbMessageTemplate onQuery(Connection connection) throws Exception {
                return new MBMessageTemplateTable(connection).query(templateId);
            }
        }.query();
    }

    public static TmbMessageTemplatePage queryPage(DalSetDataSource dataSource, QueryMBMessageTemplateOption queryOption, IndexedPageOption pageOption) throws ErrorInfo {
        return new DBQueryHelper<TmbMessageTemplatePage>(dataSource) {
            @Override
            protected TmbMessageTemplatePage onQuery(Connection connection) throws Exception {
                return new MBMessageTemplateTable(connection).queryPage(queryOption, pageOption);
            }
        }.query();
    }
}
