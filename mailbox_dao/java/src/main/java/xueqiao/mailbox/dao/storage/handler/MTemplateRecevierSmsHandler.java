package xueqiao.mailbox.dao.storage.handler;

import org.soldier.platform.dal_set.DalSetDataSource;
import org.soldier.platform.db_helper.DBQueryHelper;
import org.soldier.platform.svr_platform.comm.ErrorInfo;
import xueqiao.mailbox.dao.storage.table.MTemplateRecevierSmsTable;
import xueqiao.mailbox.thriftdata.mb.MReceiverSms;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MTemplateRecevierSmsHandler {

    public static List<MReceiverSms> queryList(DalSetDataSource dataSource, Set<Long> templateIdSet) throws ErrorInfo {
        return new DBQueryHelper<List<MReceiverSms>>(dataSource) {
            @Override
            protected List<MReceiverSms> onQuery(Connection connection) throws Exception {
                return new MTemplateRecevierSmsTable(connection).queryList(templateIdSet);
            }
        }.query();
    }

    public static void updateReceiverSms(Connection connection, long templateId, List<MReceiverSms> updateReceiverSmsList) throws SQLException {
        MTemplateRecevierSmsTable templateRecevierSmsTable = new MTemplateRecevierSmsTable(connection);
        List<MReceiverSms> receiverSmsList = templateRecevierSmsTable.query(templateId);
        if ((updateReceiverSmsList == null || updateReceiverSmsList.isEmpty()) &&
                (receiverSmsList == null || receiverSmsList.isEmpty())) {
            /* 什么都不干 */
            return;
        }
        if (updateReceiverSmsList == null || updateReceiverSmsList.isEmpty()) {
            /* 全部删除 */
            templateRecevierSmsTable.delete(templateId);
            return;
        }
        if (receiverSmsList == null || receiverSmsList.isEmpty()) {
            /* 全部添加 */
            for (MReceiverSms receiverSms : updateReceiverSmsList) {
                templateRecevierSmsTable.insert(receiverSms);
            }
            return;
        }

        Map<Long, MReceiverSms> updateReceiverSmsMap = new HashMap<>();
        Map<Long, MReceiverSms> originalReceiverSmsMap = new HashMap<>();
        MReceiverSms tempReceiverSms;
        for (MReceiverSms receiverSms : updateReceiverSmsList) {
            updateReceiverSmsMap.put(receiverSms.getMbmId(), receiverSms);
        }
        for (MReceiverSms receiverSms : receiverSmsList) {
            originalReceiverSmsMap.put(receiverSms.getMbmId(), receiverSms);

            tempReceiverSms = updateReceiverSmsMap.get(receiverSms.getMbmId());
            /* 删除的部分 */
            if (tempReceiverSms == null) {
                templateRecevierSmsTable.delete(receiverSms.getMbmId(), receiverSms.getTel());
            }
        }
        for (MReceiverSms receiverSms : updateReceiverSmsList) {
            tempReceiverSms = originalReceiverSmsMap.get(receiverSms.getMbmId());
            /* 添加的部分 */
            if (tempReceiverSms == null) {
                templateRecevierSmsTable.insert(receiverSms);
            }
        }
    }
}
