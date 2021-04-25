package xueqiao.mailbox.webapi.thriftapi.server;

import java.util.Properties;
import org.soldier.platform.svr_platform.container.TServiceCntl;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import xueqiao.mailbox.webapi.thriftapi.CompanyReceiver;
import xueqiao.mailbox.webapi.thriftapi.ContentText;
import xueqiao.mailbox.webapi.thriftapi.GroupReceiver;
import xueqiao.mailbox.webapi.thriftapi.MBMessageTemplateSelector;
import xueqiao.mailbox.webapi.thriftapi.OperateResult;
import xueqiao.mailbox.webapi.thriftapi.MailboxWebapi;
import xueqiao.mailbox.webapi.thriftapi.MailboxWebapiVariable;


public abstract class MailboxWebapiAdaptor implements MailboxWebapi.Iface{
  // unmodified map, so we do not need lock for this 
  private final Map<String, String[]> methodParameterNameMap = new HashMap<String, String[]>(); 

  public String[] getMethodParameterName(String methodName) {
    return methodParameterNameMap.get(methodName);
  }

  @Override
  public xueqiao.mailbox.thriftdata.req.MBMessageTemplatePage reqTemplate(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, xueqiao.mailbox.thriftdata.req.QueryMBMessageTemplateOption option, org.soldier.platform.page.IndexedPageOption pageOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(MailboxWebapiVariable.serviceKey,"reqTemplate",platformArgs);
    return reqTemplate(oCntl, option, pageOption);
  }

  protected abstract xueqiao.mailbox.thriftdata.req.MBMessageTemplatePage reqTemplate(TServiceCntl oCntl, xueqiao.mailbox.thriftdata.req.QueryMBMessageTemplateOption option, org.soldier.platform.page.IndexedPageOption pageOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public OperateResult addTemplate(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, xueqiao.mailbox.thriftdata.mb.MBMessageTemplate template) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(MailboxWebapiVariable.serviceKey,"addTemplate",platformArgs);
    return addTemplate(oCntl, template);
  }

  protected abstract OperateResult addTemplate(TServiceCntl oCntl, xueqiao.mailbox.thriftdata.mb.MBMessageTemplate template) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public OperateResult updateTemplate(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, xueqiao.mailbox.thriftdata.mb.MBMessageTemplate template) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(MailboxWebapiVariable.serviceKey,"updateTemplate",platformArgs);
    return updateTemplate(oCntl, template);
  }

  protected abstract OperateResult updateTemplate(TServiceCntl oCntl, xueqiao.mailbox.thriftdata.mb.MBMessageTemplate template) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public OperateResult removeTemplate(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, long templateId) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(MailboxWebapiVariable.serviceKey,"removeTemplate",platformArgs);
    return removeTemplate(oCntl, templateId);
  }

  protected abstract OperateResult removeTemplate(TServiceCntl oCntl, long templateId) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public xueqiao.mailbox.thriftdata.req.MBMessageJobPage reqMBMessageJob(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, xueqiao.mailbox.thriftdata.req.QueryMBMessageJobOption option, org.soldier.platform.page.IndexedPageOption pageOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(MailboxWebapiVariable.serviceKey,"reqMBMessageJob",platformArgs);
    return reqMBMessageJob(oCntl, option, pageOption);
  }

  protected abstract xueqiao.mailbox.thriftdata.req.MBMessageJobPage reqMBMessageJob(TServiceCntl oCntl, xueqiao.mailbox.thriftdata.req.QueryMBMessageJobOption option, org.soldier.platform.page.IndexedPageOption pageOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public OperateResult addMBMessage(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, xueqiao.mailbox.thriftdata.mb.MBMessage message) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(MailboxWebapiVariable.serviceKey,"addMBMessage",platformArgs);
    return addMBMessage(oCntl, message);
  }

  protected abstract OperateResult addMBMessage(TServiceCntl oCntl, xueqiao.mailbox.thriftdata.mb.MBMessage message) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public List<CompanyReceiver> reqCompanyReceiver(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(MailboxWebapiVariable.serviceKey,"reqCompanyReceiver",platformArgs);
    return reqCompanyReceiver(oCntl);
  }

  protected abstract List<CompanyReceiver> reqCompanyReceiver(TServiceCntl oCntl) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public List<GroupReceiver> reqGroupReceiver(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, long companyId) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(MailboxWebapiVariable.serviceKey,"reqGroupReceiver",platformArgs);
    return reqGroupReceiver(oCntl, companyId);
  }

  protected abstract List<GroupReceiver> reqGroupReceiver(TServiceCntl oCntl, long companyId) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public ContentText reqContentText(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, String fileName) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(MailboxWebapiVariable.serviceKey,"reqContentText",platformArgs);
    return reqContentText(oCntl, fileName);
  }

  protected abstract ContentText reqContentText(TServiceCntl oCntl, String fileName) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public List<MBMessageTemplateSelector> reqMBMessageTemplateSelector(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(MailboxWebapiVariable.serviceKey,"reqMBMessageTemplateSelector",platformArgs);
    return reqMBMessageTemplateSelector(oCntl);
  }

  protected abstract List<MBMessageTemplateSelector> reqMBMessageTemplateSelector(TServiceCntl oCntl) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public xueqiao.mailbox.thriftdata.req.MBMessagePage reqMBMessage(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, xueqiao.mailbox.thriftdata.req.QueryMBMessageOption queryOption, org.soldier.platform.page.IndexedPageOption pageOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(MailboxWebapiVariable.serviceKey,"reqMBMessage",platformArgs);
    return reqMBMessage(oCntl, queryOption, pageOption);
  }

  protected abstract xueqiao.mailbox.thriftdata.req.MBMessagePage reqMBMessage(TServiceCntl oCntl, xueqiao.mailbox.thriftdata.req.QueryMBMessageOption queryOption, org.soldier.platform.page.IndexedPageOption pageOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public OperateResult updateMessageJobStatus(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, long messageJobId, xueqiao.mailbox.thriftdata.mb.MJStatus status) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(MailboxWebapiVariable.serviceKey,"updateMessageJobStatus",platformArgs);
    return updateMessageJobStatus(oCntl, messageJobId, status);
  }

  protected abstract OperateResult updateMessageJobStatus(TServiceCntl oCntl, long messageJobId, xueqiao.mailbox.thriftdata.mb.MJStatus status) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  protected MailboxWebapiAdaptor(){
    methodParameterNameMap.put("reqTemplate",new String[]{"platformArgs", "option", "pageOption"});
    methodParameterNameMap.put("addTemplate",new String[]{"platformArgs", "template"});
    methodParameterNameMap.put("updateTemplate",new String[]{"platformArgs", "template"});
    methodParameterNameMap.put("removeTemplate",new String[]{"platformArgs", "templateId"});
    methodParameterNameMap.put("reqMBMessageJob",new String[]{"platformArgs", "option", "pageOption"});
    methodParameterNameMap.put("addMBMessage",new String[]{"platformArgs", "message"});
    methodParameterNameMap.put("reqCompanyReceiver",new String[]{"platformArgs"});
    methodParameterNameMap.put("reqGroupReceiver",new String[]{"platformArgs", "companyId"});
    methodParameterNameMap.put("reqContentText",new String[]{"platformArgs", "fileName"});
    methodParameterNameMap.put("reqMBMessageTemplateSelector",new String[]{"platformArgs"});
    methodParameterNameMap.put("reqMBMessage",new String[]{"platformArgs", "queryOption", "pageOption"});
    methodParameterNameMap.put("updateMessageJobStatus",new String[]{"platformArgs", "messageJobId", "status"});
  }
  protected abstract int InitApp(final Properties props);

  protected abstract void destroy();

}
