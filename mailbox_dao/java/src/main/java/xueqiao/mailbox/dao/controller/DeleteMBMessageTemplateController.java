package xueqiao.mailbox.dao.controller;

import org.soldier.platform.db_helper.DBTransactionHelper;
import org.soldier.platform.svr_platform.comm.ErrorInfo;
import org.soldier.platform.svr_platform.container.TServiceCntl;
import xueqiao.mailbox.dao.common.base.Precondition;
import xueqiao.mailbox.dao.controller.base.AbstractController;
import xueqiao.mailbox.dao.storage.table.*;

public class DeleteMBMessageTemplateController extends AbstractController {

    private long templateId;

    public DeleteMBMessageTemplateController(TServiceCntl oCntl) {
        super(oCntl);
    }

    public DeleteMBMessageTemplateController params(long templateId) {
        this.templateId = templateId;
        return this;
    }

    @Override
    public void checkParams() throws ErrorInfo {
        Precondition.check(templateId > 0, "invalid templateId");
    }

    public void doDelete() throws ErrorInfo {
        delete();
    }

    private void delete() throws ErrorInfo {
        new DBTransactionHelper<Void>(getDalSetDataSource()) {
            @Override
            public void onPrepareData() throws ErrorInfo, Exception {

            }

            @Override
            public void onUpdate() throws ErrorInfo, Exception {
                new MBMessageTemplateTable(getConnection()).delete(templateId);
                new MTemplateSendingTimeRuleTable(getConnection()).delete(templateId);
                new MTemplateRecevierSmsTable(getConnection()).delete(templateId);
                new MTemplateRecevierMailTable(getConnection()).delete(templateId);
                new MTemplateReceiverHostingTable(getConnection()).delete(templateId);
            }

            @Override
            public Void getResult() {
                return null;
            }
        }.execute();
    }
}
