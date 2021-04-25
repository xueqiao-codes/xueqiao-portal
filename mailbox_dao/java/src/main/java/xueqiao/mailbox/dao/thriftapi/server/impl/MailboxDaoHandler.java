package xueqiao.mailbox.dao.thriftapi.server.impl;


import java.util.Properties;

import org.apache.thrift.TException;
import org.soldier.base.logger.AppLog;
import org.soldier.platform.page.IndexedPageOption;
import org.soldier.platform.svr_platform.comm.ErrorInfo;
import org.soldier.platform.svr_platform.container.TServiceCntl;
import xueqiao.mailbox.dao.config.ConfigurationProperty;
import xueqiao.mailbox.dao.controller.*;
import xueqiao.mailbox.dao.thriftapi.server.MailboxDaoAdaptor;
import xueqiao.mailbox.thriftdata.mb.MBMessage;
import xueqiao.mailbox.thriftdata.mb.MBMessageTemplate;
import xueqiao.mailbox.thriftdata.mb.MJStatus;
import xueqiao.mailbox.thriftdata.mb.MStatus;
import xueqiao.mailbox.thriftdata.req.*;

public class MailboxDaoHandler extends MailboxDaoAdaptor {
    @Override
    public int InitApp(Properties props) {
        System.out.println("MailboxDaoHandler ####### InitApp");
        try {
            ConfigurationProperty.instance().init(props);
        } catch (Exception e) {
            AppLog.e("Config init fail.", e);
            return -1;
        }
        AppLog.e("======= SERVICE START =======");
        return 0;
    }

    @Override
    protected void addMBMessage(TServiceCntl oCntl, MBMessage message) throws ErrorInfo, TException {
        AddMBMessageController controller = new AddMBMessageController(oCntl).params(message);
        controller.checkParams();
        controller.doAddition();
    }

    @Override
    protected void modifyMBMessageStatus(TServiceCntl oCntl, long mbmId, MStatus status) throws ErrorInfo, TException {
        ModifyMBMessageStatusController controller = new ModifyMBMessageStatusController(oCntl).params(mbmId, status);
        controller.checkParams();
        controller.doModify();
    }

    @Override
    protected MBMessagePage queryMBMessagePage(TServiceCntl oCntl, QueryMBMessageOption queryOption, IndexedPageOption pageOption) throws ErrorInfo, TException {
        QueryMBMessagePageController controller = new QueryMBMessagePageController(oCntl).params(queryOption, pageOption);
        controller.checkParams();
        return controller.doQuery();
    }

    @Override
    protected void addMBMessageTemplate(TServiceCntl oCntl, MBMessageTemplate template) throws ErrorInfo, TException {
        AddMBMessageTemplateController controller = new AddMBMessageTemplateController(oCntl).params(template);
        controller.checkParams();
        controller.doAddition();
    }

    @Override
    protected void modifyMBMessageTemplate(TServiceCntl oCntl, MBMessageTemplate template) throws ErrorInfo, TException {
        ModifyMBMessageTemplateController controller = new ModifyMBMessageTemplateController(oCntl).params(template);
        controller.checkParams();
        controller.doModify();
    }

    @Override
    protected void deleteMBMessageTemplate(TServiceCntl oCntl, long templateId) throws ErrorInfo, TException {
        DeleteMBMessageTemplateController controller = new DeleteMBMessageTemplateController(oCntl).params(templateId);
        controller.checkParams();
        controller.doDelete();
    }

    @Override
    protected MBMessageTemplatePage queryMBMessageTemplatePage(TServiceCntl oCntl, QueryMBMessageTemplateOption queryOption, IndexedPageOption pageOption) throws ErrorInfo, TException {
        QueryMBMessageTemplatePageController controller = new QueryMBMessageTemplatePageController(oCntl).params(queryOption, pageOption);
        controller.checkParams();
        return controller.doQuery();
    }

    @Override
    protected long startSendMBMessage(TServiceCntl oCntl, long mbmId, boolean isMessageCompleted) throws ErrorInfo, TException {
        StartSendMBMessageController controller = new StartSendMBMessageController(oCntl).params(mbmId, isMessageCompleted);
        controller.checkParams();
        return controller.start();
    }

//    @Override
//    protected long startSendMBMessage(TServiceCntl oCntl, long mbmId) throws ErrorInfo, TException {
//        StartSendMBMessageController controller = new StartSendMBMessageController(oCntl).params(mbmId);
//        controller.checkParams();
//        return controller.start();
//    }

//    @Override
//    protected void sendMBMessageSuccess(TServiceCntl oCntl, long jobId, boolean isMessageCompleted) throws ErrorInfo, TException {
//        SendMBMessageSuccessController controller = new SendMBMessageSuccessController(oCntl).params(jobId, isMessageCompleted);
//        controller.checkParams();
//        controller.setStatus();
//    }

    @Override
    protected void modifyMBMessageJobStatus(TServiceCntl oCntl, long jobId, MJStatus status, String errorDescription) throws ErrorInfo, TException {
        ModifyMBMessageJobStatusController controller = new ModifyMBMessageJobStatusController(oCntl).params(jobId, status, errorDescription);
        controller.checkParams();
        controller.doModify();
    }

    @Override
    protected MBMessageJobPage queryMBMessageJobPage(TServiceCntl oCntl, QueryMBMessageJobOption queryOption, IndexedPageOption pageOption) throws ErrorInfo, TException {
        QueryMBMessageJobPageController controller = new QueryMBMessageJobPageController(oCntl).params(queryOption, pageOption);
        controller.checkParams();
        return controller.doQuery();
    }

    @Override
    public void destroy() {
    }
}
