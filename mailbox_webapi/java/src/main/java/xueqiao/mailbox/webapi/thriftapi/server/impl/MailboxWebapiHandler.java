package xueqiao.mailbox.webapi.thriftapi.server.impl;


import java.util.List;
import java.util.Properties;

import org.apache.thrift.TException;
import org.soldier.platform.page.IndexedPageOption;
import org.soldier.platform.svr_platform.comm.ErrorInfo;
import org.soldier.platform.svr_platform.container.TServiceCntl;
import xueqiao.mailbox.api.*;
import xueqiao.mailbox.dao.thriftapi.client.MailboxDaoStub;
import xueqiao.mailbox.thriftdata.mb.MJStatus;
import xueqiao.mailbox.thriftdata.req.MBMessagePage;
import xueqiao.mailbox.thriftdata.req.QueryMBMessageOption;
import xueqiao.mailbox.webapi.thriftapi.*;
import xueqiao.mailbox.webapi.thriftapi.server.MailboxWebapiAdaptor;

public class MailboxWebapiHandler extends MailboxWebapiAdaptor {
    @Override
    public int InitApp(Properties props) {
        return 0;
    }

    @Override
    protected xueqiao.mailbox.thriftdata.req.MBMessageTemplatePage reqTemplate(TServiceCntl oCntl, xueqiao.mailbox.thriftdata.req.QueryMBMessageTemplateOption option, org.soldier.platform.page.IndexedPageOption pageOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException {
        return new TemplateApi().reqTemplate(option, pageOption);
    }

    @Override
    protected OperateResult addTemplate(TServiceCntl oCntl, xueqiao.mailbox.thriftdata.mb.MBMessageTemplate template) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException {
        return new TemplateApi().addTemplate(template);
    }

    @Override
    protected OperateResult updateTemplate(TServiceCntl oCntl, xueqiao.mailbox.thriftdata.mb.MBMessageTemplate template) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException {
        return new TemplateApi().updateTemplate(template);
    }

    @Override
    protected OperateResult removeTemplate(TServiceCntl oCntl, long templateId) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException {
        return new TemplateApi().removeTemplate(templateId);
    }

    @Override
    protected xueqiao.mailbox.thriftdata.req.MBMessageJobPage reqMBMessageJob(TServiceCntl oCntl, xueqiao.mailbox.thriftdata.req.QueryMBMessageJobOption option, org.soldier.platform.page.IndexedPageOption pageOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException {
        return new MessageJobApi().reqMBMessageJob(option, pageOption);
    }

    @Override
    protected OperateResult addMBMessage(TServiceCntl oCntl, xueqiao.mailbox.thriftdata.mb.MBMessage message) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException {
        return new MessageApi().addMBMessage(message);
    }

    @Override
    protected List<CompanyReceiver> reqCompanyReceiver(TServiceCntl oCntl) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException {
        return new CompanyApi().reqCompanyReceiver();
    }

    @Override
    protected List<GroupReceiver> reqGroupReceiver(TServiceCntl oCntl, long companyId) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException {
        return new CompanyApi().reqGroupReceiver(companyId);
    }

    @Override
    protected ContentText reqContentText(TServiceCntl oCntl, String fileName) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException {
        String text = Utils.readContentText(fileName);
        ContentText contentText = new ContentText();
        contentText.setContentText(text);
        contentText.setFileName(fileName);
        return contentText;
    }

    @Override
    protected List<MBMessageTemplateSelector> reqMBMessageTemplateSelector(TServiceCntl oCntl) throws ErrorInfo, TException {
        return new TemplateApi().reqMBMessageTemplateSelector();
    }

    @Override
    protected MBMessagePage reqMBMessage(TServiceCntl oCntl, QueryMBMessageOption queryOption, IndexedPageOption pageOption) throws ErrorInfo, TException {
        return new MailboxDaoStub().queryMBMessagePage(queryOption, pageOption);
    }

    @Override
    protected OperateResult updateMessageJobStatus(TServiceCntl oCntl, long messageJobId, MJStatus status) throws ErrorInfo, TException {
        return new MessageJobApi().updateMBMessageJobStatus(messageJobId, status);
    }

    @Override
    public void destroy() {
    }
}
