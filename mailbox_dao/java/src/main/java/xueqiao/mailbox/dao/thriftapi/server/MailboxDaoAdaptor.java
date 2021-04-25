package xueqiao.mailbox.dao.thriftapi.server;

import java.util.Properties;
import org.soldier.platform.svr_platform.container.TServiceCntl;
import java.util.Map;
import java.util.HashMap;
import xueqiao.mailbox.dao.thriftapi.MailboxDao;
import xueqiao.mailbox.dao.thriftapi.MailboxDaoVariable;


public abstract class MailboxDaoAdaptor implements MailboxDao.Iface{
  // unmodified map, so we do not need lock for this 
  private final Map<String, String[]> methodParameterNameMap = new HashMap<String, String[]>(); 

  public String[] getMethodParameterName(String methodName) {
    return methodParameterNameMap.get(methodName);
  }

  @Override
  public void addMBMessage(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, xueqiao.mailbox.thriftdata.mb.MBMessage message) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(MailboxDaoVariable.serviceKey,"addMBMessage",platformArgs);
addMBMessage(oCntl, message);
  }

  protected abstract void addMBMessage(TServiceCntl oCntl, xueqiao.mailbox.thriftdata.mb.MBMessage message) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public void modifyMBMessageStatus(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, long mbmId, xueqiao.mailbox.thriftdata.mb.MStatus status) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(MailboxDaoVariable.serviceKey,"modifyMBMessageStatus",platformArgs);
modifyMBMessageStatus(oCntl, mbmId, status);
  }

  protected abstract void modifyMBMessageStatus(TServiceCntl oCntl, long mbmId, xueqiao.mailbox.thriftdata.mb.MStatus status) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public xueqiao.mailbox.thriftdata.req.MBMessagePage queryMBMessagePage(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, xueqiao.mailbox.thriftdata.req.QueryMBMessageOption queryOption, org.soldier.platform.page.IndexedPageOption pageOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(MailboxDaoVariable.serviceKey,"queryMBMessagePage",platformArgs);
    return queryMBMessagePage(oCntl, queryOption, pageOption);
  }

  protected abstract xueqiao.mailbox.thriftdata.req.MBMessagePage queryMBMessagePage(TServiceCntl oCntl, xueqiao.mailbox.thriftdata.req.QueryMBMessageOption queryOption, org.soldier.platform.page.IndexedPageOption pageOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public void addMBMessageTemplate(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, xueqiao.mailbox.thriftdata.mb.MBMessageTemplate template) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(MailboxDaoVariable.serviceKey,"addMBMessageTemplate",platformArgs);
addMBMessageTemplate(oCntl, template);
  }

  protected abstract void addMBMessageTemplate(TServiceCntl oCntl, xueqiao.mailbox.thriftdata.mb.MBMessageTemplate template) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public void modifyMBMessageTemplate(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, xueqiao.mailbox.thriftdata.mb.MBMessageTemplate template) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(MailboxDaoVariable.serviceKey,"modifyMBMessageTemplate",platformArgs);
modifyMBMessageTemplate(oCntl, template);
  }

  protected abstract void modifyMBMessageTemplate(TServiceCntl oCntl, xueqiao.mailbox.thriftdata.mb.MBMessageTemplate template) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public void deleteMBMessageTemplate(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, long templateId) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(MailboxDaoVariable.serviceKey,"deleteMBMessageTemplate",platformArgs);
deleteMBMessageTemplate(oCntl, templateId);
  }

  protected abstract void deleteMBMessageTemplate(TServiceCntl oCntl, long templateId) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public xueqiao.mailbox.thriftdata.req.MBMessageTemplatePage queryMBMessageTemplatePage(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, xueqiao.mailbox.thriftdata.req.QueryMBMessageTemplateOption queryOption, org.soldier.platform.page.IndexedPageOption pageOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(MailboxDaoVariable.serviceKey,"queryMBMessageTemplatePage",platformArgs);
    return queryMBMessageTemplatePage(oCntl, queryOption, pageOption);
  }

  protected abstract xueqiao.mailbox.thriftdata.req.MBMessageTemplatePage queryMBMessageTemplatePage(TServiceCntl oCntl, xueqiao.mailbox.thriftdata.req.QueryMBMessageTemplateOption queryOption, org.soldier.platform.page.IndexedPageOption pageOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public long startSendMBMessage(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, long mbmId, boolean isMessageCompleted) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(MailboxDaoVariable.serviceKey,"startSendMBMessage",platformArgs);
    return startSendMBMessage(oCntl, mbmId, isMessageCompleted);
  }

  protected abstract long startSendMBMessage(TServiceCntl oCntl, long mbmId, boolean isMessageCompleted) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public void modifyMBMessageJobStatus(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, long jobId, xueqiao.mailbox.thriftdata.mb.MJStatus status, String errorDescription) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(MailboxDaoVariable.serviceKey,"modifyMBMessageJobStatus",platformArgs);
modifyMBMessageJobStatus(oCntl, jobId, status, errorDescription);
  }

  protected abstract void modifyMBMessageJobStatus(TServiceCntl oCntl, long jobId, xueqiao.mailbox.thriftdata.mb.MJStatus status, String errorDescription) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public xueqiao.mailbox.thriftdata.req.MBMessageJobPage queryMBMessageJobPage(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, xueqiao.mailbox.thriftdata.req.QueryMBMessageJobOption queryOption, org.soldier.platform.page.IndexedPageOption pageOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(MailboxDaoVariable.serviceKey,"queryMBMessageJobPage",platformArgs);
    return queryMBMessageJobPage(oCntl, queryOption, pageOption);
  }

  protected abstract xueqiao.mailbox.thriftdata.req.MBMessageJobPage queryMBMessageJobPage(TServiceCntl oCntl, xueqiao.mailbox.thriftdata.req.QueryMBMessageJobOption queryOption, org.soldier.platform.page.IndexedPageOption pageOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  protected MailboxDaoAdaptor(){
    methodParameterNameMap.put("addMBMessage",new String[]{"platformArgs", "message"});
    methodParameterNameMap.put("modifyMBMessageStatus",new String[]{"platformArgs", "mbmId", "status"});
    methodParameterNameMap.put("queryMBMessagePage",new String[]{"platformArgs", "queryOption", "pageOption"});
    methodParameterNameMap.put("addMBMessageTemplate",new String[]{"platformArgs", "template"});
    methodParameterNameMap.put("modifyMBMessageTemplate",new String[]{"platformArgs", "template"});
    methodParameterNameMap.put("deleteMBMessageTemplate",new String[]{"platformArgs", "templateId"});
    methodParameterNameMap.put("queryMBMessageTemplatePage",new String[]{"platformArgs", "queryOption", "pageOption"});
    methodParameterNameMap.put("startSendMBMessage",new String[]{"platformArgs", "mbmId", "isMessageCompleted"});
    methodParameterNameMap.put("modifyMBMessageJobStatus",new String[]{"platformArgs", "jobId", "status", "errorDescription"});
    methodParameterNameMap.put("queryMBMessageJobPage",new String[]{"platformArgs", "queryOption", "pageOption"});
  }
  protected abstract int InitApp(final Properties props);

  protected abstract void destroy();

}
