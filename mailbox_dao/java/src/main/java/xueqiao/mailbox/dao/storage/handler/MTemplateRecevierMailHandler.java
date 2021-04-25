package xueqiao.mailbox.dao.storage.handler;

import org.soldier.platform.dal_set.DalSetDataSource;
import org.soldier.platform.db_helper.DBQueryHelper;
import org.soldier.platform.svr_platform.comm.ErrorInfo;
import xueqiao.mailbox.dao.storage.table.MReceiverMailTable;
import xueqiao.mailbox.dao.storage.table.MTemplateRecevierMailTable;
import xueqiao.mailbox.thriftdata.mb.MReceiverMail;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MTemplateRecevierMailHandler {

    public static List<MReceiverMail> queryList(DalSetDataSource dataSource, Set<Long> mbmIdSet) throws ErrorInfo {
        return new DBQueryHelper<List<MReceiverMail>>(dataSource) {
            @Override
            protected List<MReceiverMail> onQuery(Connection connection) throws Exception {
                return new MTemplateRecevierMailTable(connection).queryList(mbmIdSet);
            }
        }.query();
    }

    public static void updateReceiverMail(Connection connection, long templateId, List<MReceiverMail> updateReceiverMailList) throws SQLException {
        MTemplateRecevierMailTable templateRecevierMailTable = new MTemplateRecevierMailTable(connection);
        List<MReceiverMail> receiverMailList = templateRecevierMailTable.query(templateId);
        if ((updateReceiverMailList == null || updateReceiverMailList.isEmpty()) &&
                (receiverMailList == null || receiverMailList.isEmpty())) {
            /* 什么都不干 */
            return;
        }
        if (updateReceiverMailList == null || updateReceiverMailList.isEmpty()) {
            /* 全部删除 */
            templateRecevierMailTable.delete(templateId);
            return;
        }
        if (receiverMailList == null || receiverMailList.isEmpty()) {
            /* 全部添加 */
            for (MReceiverMail receiverMail : updateReceiverMailList) {
                templateRecevierMailTable.insert(receiverMail);
            }
            return;
        }

        Map<Long, MReceiverMail> updateReceiverSmsMap = new HashMap<>();
        Map<Long, MReceiverMail> originalReceiverSmsMap = new HashMap<>();
        MReceiverMail tempReceiverSms;
        for (MReceiverMail receiverMail : updateReceiverMailList) {
            updateReceiverSmsMap.put(receiverMail.getMbmId(), receiverMail);
        }
        for (MReceiverMail receiverMail : receiverMailList) {
            originalReceiverSmsMap.put(receiverMail.getMbmId(), receiverMail);

            tempReceiverSms = updateReceiverSmsMap.get(receiverMail.getMbmId());
            /* 删除的部分 */
            if (tempReceiverSms == null) {
                templateRecevierMailTable.delete(receiverMail.getMbmId(), receiverMail.getMail());
            }
        }
        for (MReceiverMail receiverMail : updateReceiverMailList) {
            tempReceiverSms = originalReceiverSmsMap.get(receiverMail.getMbmId());
            /* 添加的部分 */
            if (tempReceiverSms == null) {
                templateRecevierMailTable.insert(receiverMail);
            }
        }
    }
}
