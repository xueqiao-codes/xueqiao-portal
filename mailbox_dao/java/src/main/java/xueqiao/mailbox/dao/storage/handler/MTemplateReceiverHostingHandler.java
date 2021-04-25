package xueqiao.mailbox.dao.storage.handler;

import org.soldier.platform.dal_set.DalSetDataSource;
import org.soldier.platform.db_helper.DBQueryHelper;
import org.soldier.platform.svr_platform.comm.ErrorInfo;
import xueqiao.mailbox.dao.storage.bean.TmbReceiverHosting;
import xueqiao.mailbox.dao.storage.table.MTemplateReceiverHostingTable;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MTemplateReceiverHostingHandler {

    public static List<TmbReceiverHosting> queryList(DalSetDataSource dataSource, Set<Long> templateIdSet) throws ErrorInfo {
        return new DBQueryHelper<List<TmbReceiverHosting>>(dataSource) {
            @Override
            protected List<TmbReceiverHosting> onQuery(Connection connection) throws Exception {
                return new MTemplateReceiverHostingTable(connection).queryList(templateIdSet);
            }
        }.query();
    }

    public static void updateReceiverHosting(Connection connection, long templateId, List<TmbReceiverHosting> updateReceiverHostingList) throws SQLException {
        MTemplateReceiverHostingTable templateReceiverHostingTable = new MTemplateReceiverHostingTable(connection);
        List<TmbReceiverHosting> receiverHostingList = templateReceiverHostingTable.query(templateId);
        if ((updateReceiverHostingList == null || updateReceiverHostingList.isEmpty()) &&
                (receiverHostingList == null || receiverHostingList.isEmpty())) {
            /* 什么都不干 */
            return;
        }
        if (updateReceiverHostingList == null || updateReceiverHostingList.isEmpty()) {
            /* 全部删除 */
            templateReceiverHostingTable.delete(templateId);
            return;
        }
        if (receiverHostingList == null || receiverHostingList.isEmpty()) {
            /* 全部添加 */
            for (TmbReceiverHosting receiverhosting : updateReceiverHostingList) {
                templateReceiverHostingTable.insert(receiverhosting);
            }
            return;
        }

        Map<Long, TmbReceiverHosting> updateReceiverHostingMap = new HashMap<>();
        Map<Long, TmbReceiverHosting> originalReceiverHostingMap = new HashMap<>();
        TmbReceiverHosting tempReceiverSms;
        for (TmbReceiverHosting receiverhosting : updateReceiverHostingList) {
            updateReceiverHostingMap.put(receiverhosting.getMbmId(), receiverhosting);
        }
        for (TmbReceiverHosting receiverhosting : receiverHostingList) {
            originalReceiverHostingMap.put(receiverhosting.getMbmId(), receiverhosting);

            tempReceiverSms = updateReceiverHostingMap.get(receiverhosting.getMbmId());
            /* 删除的部分 */
            if (tempReceiverSms == null) {
                templateReceiverHostingTable.delete(receiverhosting.getMbmId(), receiverhosting.getCompanyId(), receiverhosting.getGroupId());
            }
        }
        for (TmbReceiverHosting receiverhosting : updateReceiverHostingList) {
            tempReceiverSms = originalReceiverHostingMap.get(receiverhosting.getMbmId());
            if (tempReceiverSms == null) {
                /* 添加的部分 */
                templateReceiverHostingTable.insert(receiverhosting);
            } else {
                /* 修改的部分 */
                templateReceiverHostingTable.update(receiverhosting);
            }
        }
    }
}
