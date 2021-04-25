package xueqiao.mailbox.webapi.thriftapi.client;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TProtocol;
import org.soldier.platform.svr_platform.client.BaseStub;
import org.soldier.platform.svr_platform.client.TStubOption;
import org.soldier.platform.svr_platform.comm.ErrorInfo;
import org.soldier.platform.svr_platform.comm.PlatformArgs;
import java.util.List;
import xueqiao.mailbox.webapi.thriftapi.CompanyReceiver;
import xueqiao.mailbox.webapi.thriftapi.ContentText;
import xueqiao.mailbox.webapi.thriftapi.GroupReceiver;
import xueqiao.mailbox.webapi.thriftapi.MBMessageTemplateSelector;
import xueqiao.mailbox.webapi.thriftapi.OperateResult;
import xueqiao.mailbox.webapi.thriftapi.MailboxWebapi;
import xueqiao.mailbox.webapi.thriftapi.MailboxWebapiVariable;

public class MailboxWebapiStub extends BaseStub {

  public MailboxWebapiStub() {
    super(MailboxWebapiVariable.serviceKey);
  }

  public xueqiao.mailbox.thriftdata.req.MBMessageTemplatePage  reqTemplate(xueqiao.mailbox.thriftdata.req.QueryMBMessageTemplateOption option, org.soldier.platform.page.IndexedPageOption pageOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return reqTemplate(option, pageOption, new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public xueqiao.mailbox.thriftdata.req.MBMessageTemplatePage  reqTemplate(xueqiao.mailbox.thriftdata.req.QueryMBMessageTemplateOption option, org.soldier.platform.page.IndexedPageOption pageOption,TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("reqTemplate").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    return super.runSync(new ThriftCallable<xueqiao.mailbox.thriftdata.req.MBMessageTemplatePage>(){
    @Override
    public xueqiao.mailbox.thriftdata.req.MBMessageTemplatePage call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      return new MailboxWebapi.Client(protocol).reqTemplate(platformArgs, option, pageOption);
      }
    }, invokeInfo);
  }

  public xueqiao.mailbox.thriftdata.req.MBMessageTemplatePage  reqTemplate(int routeKey, int timeout,xueqiao.mailbox.thriftdata.req.QueryMBMessageTemplateOption option, org.soldier.platform.page.IndexedPageOption pageOption)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return reqTemplate(option, pageOption, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public OperateResult  addTemplate(xueqiao.mailbox.thriftdata.mb.MBMessageTemplate template) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return addTemplate(template, new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public OperateResult  addTemplate(xueqiao.mailbox.thriftdata.mb.MBMessageTemplate template,TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("addTemplate").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    return super.runSync(new ThriftCallable<OperateResult>(){
    @Override
    public OperateResult call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      return new MailboxWebapi.Client(protocol).addTemplate(platformArgs, template);
      }
    }, invokeInfo);
  }

  public OperateResult  addTemplate(int routeKey, int timeout,xueqiao.mailbox.thriftdata.mb.MBMessageTemplate template)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return addTemplate(template, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public OperateResult  updateTemplate(xueqiao.mailbox.thriftdata.mb.MBMessageTemplate template) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return updateTemplate(template, new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public OperateResult  updateTemplate(xueqiao.mailbox.thriftdata.mb.MBMessageTemplate template,TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("updateTemplate").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    return super.runSync(new ThriftCallable<OperateResult>(){
    @Override
    public OperateResult call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      return new MailboxWebapi.Client(protocol).updateTemplate(platformArgs, template);
      }
    }, invokeInfo);
  }

  public OperateResult  updateTemplate(int routeKey, int timeout,xueqiao.mailbox.thriftdata.mb.MBMessageTemplate template)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return updateTemplate(template, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public OperateResult  removeTemplate(long templateId) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return removeTemplate(templateId, new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public OperateResult  removeTemplate(long templateId,TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("removeTemplate").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    return super.runSync(new ThriftCallable<OperateResult>(){
    @Override
    public OperateResult call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      return new MailboxWebapi.Client(protocol).removeTemplate(platformArgs, templateId);
      }
    }, invokeInfo);
  }

  public OperateResult  removeTemplate(int routeKey, int timeout,long templateId)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return removeTemplate(templateId, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public xueqiao.mailbox.thriftdata.req.MBMessageJobPage  reqMBMessageJob(xueqiao.mailbox.thriftdata.req.QueryMBMessageJobOption option, org.soldier.platform.page.IndexedPageOption pageOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return reqMBMessageJob(option, pageOption, new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public xueqiao.mailbox.thriftdata.req.MBMessageJobPage  reqMBMessageJob(xueqiao.mailbox.thriftdata.req.QueryMBMessageJobOption option, org.soldier.platform.page.IndexedPageOption pageOption,TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("reqMBMessageJob").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    return super.runSync(new ThriftCallable<xueqiao.mailbox.thriftdata.req.MBMessageJobPage>(){
    @Override
    public xueqiao.mailbox.thriftdata.req.MBMessageJobPage call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      return new MailboxWebapi.Client(protocol).reqMBMessageJob(platformArgs, option, pageOption);
      }
    }, invokeInfo);
  }

  public xueqiao.mailbox.thriftdata.req.MBMessageJobPage  reqMBMessageJob(int routeKey, int timeout,xueqiao.mailbox.thriftdata.req.QueryMBMessageJobOption option, org.soldier.platform.page.IndexedPageOption pageOption)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return reqMBMessageJob(option, pageOption, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public OperateResult  addMBMessage(xueqiao.mailbox.thriftdata.mb.MBMessage message) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return addMBMessage(message, new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public OperateResult  addMBMessage(xueqiao.mailbox.thriftdata.mb.MBMessage message,TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("addMBMessage").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    return super.runSync(new ThriftCallable<OperateResult>(){
    @Override
    public OperateResult call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      return new MailboxWebapi.Client(protocol).addMBMessage(platformArgs, message);
      }
    }, invokeInfo);
  }

  public OperateResult  addMBMessage(int routeKey, int timeout,xueqiao.mailbox.thriftdata.mb.MBMessage message)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return addMBMessage(message, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public List<CompanyReceiver>  reqCompanyReceiver() throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return reqCompanyReceiver(new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public List<CompanyReceiver>  reqCompanyReceiver(TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("reqCompanyReceiver").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    return super.runSync(new ThriftCallable<List<CompanyReceiver>>(){
    @Override
    public List<CompanyReceiver> call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      return new MailboxWebapi.Client(protocol).reqCompanyReceiver(platformArgs);
      }
    }, invokeInfo);
  }

  public List<CompanyReceiver>  reqCompanyReceiver(int routeKey, int timeout)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return reqCompanyReceiver(new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public List<GroupReceiver>  reqGroupReceiver(long companyId) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return reqGroupReceiver(companyId, new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public List<GroupReceiver>  reqGroupReceiver(long companyId,TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("reqGroupReceiver").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    return super.runSync(new ThriftCallable<List<GroupReceiver>>(){
    @Override
    public List<GroupReceiver> call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      return new MailboxWebapi.Client(protocol).reqGroupReceiver(platformArgs, companyId);
      }
    }, invokeInfo);
  }

  public List<GroupReceiver>  reqGroupReceiver(int routeKey, int timeout,long companyId)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return reqGroupReceiver(companyId, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public ContentText  reqContentText(String fileName) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return reqContentText(fileName, new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public ContentText  reqContentText(String fileName,TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("reqContentText").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    return super.runSync(new ThriftCallable<ContentText>(){
    @Override
    public ContentText call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      return new MailboxWebapi.Client(protocol).reqContentText(platformArgs, fileName);
      }
    }, invokeInfo);
  }

  public ContentText  reqContentText(int routeKey, int timeout,String fileName)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return reqContentText(fileName, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public List<MBMessageTemplateSelector>  reqMBMessageTemplateSelector() throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return reqMBMessageTemplateSelector(new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public List<MBMessageTemplateSelector>  reqMBMessageTemplateSelector(TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("reqMBMessageTemplateSelector").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    return super.runSync(new ThriftCallable<List<MBMessageTemplateSelector>>(){
    @Override
    public List<MBMessageTemplateSelector> call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      return new MailboxWebapi.Client(protocol).reqMBMessageTemplateSelector(platformArgs);
      }
    }, invokeInfo);
  }

  public List<MBMessageTemplateSelector>  reqMBMessageTemplateSelector(int routeKey, int timeout)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return reqMBMessageTemplateSelector(new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public xueqiao.mailbox.thriftdata.req.MBMessagePage  reqMBMessage(xueqiao.mailbox.thriftdata.req.QueryMBMessageOption queryOption, org.soldier.platform.page.IndexedPageOption pageOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return reqMBMessage(queryOption, pageOption, new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public xueqiao.mailbox.thriftdata.req.MBMessagePage  reqMBMessage(xueqiao.mailbox.thriftdata.req.QueryMBMessageOption queryOption, org.soldier.platform.page.IndexedPageOption pageOption,TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("reqMBMessage").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    return super.runSync(new ThriftCallable<xueqiao.mailbox.thriftdata.req.MBMessagePage>(){
    @Override
    public xueqiao.mailbox.thriftdata.req.MBMessagePage call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      return new MailboxWebapi.Client(protocol).reqMBMessage(platformArgs, queryOption, pageOption);
      }
    }, invokeInfo);
  }

  public xueqiao.mailbox.thriftdata.req.MBMessagePage  reqMBMessage(int routeKey, int timeout,xueqiao.mailbox.thriftdata.req.QueryMBMessageOption queryOption, org.soldier.platform.page.IndexedPageOption pageOption)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return reqMBMessage(queryOption, pageOption, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public OperateResult  updateMessageJobStatus(long messageJobId, xueqiao.mailbox.thriftdata.mb.MJStatus status) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return updateMessageJobStatus(messageJobId, status, new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public OperateResult  updateMessageJobStatus(long messageJobId, xueqiao.mailbox.thriftdata.mb.MJStatus status,TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("updateMessageJobStatus").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    return super.runSync(new ThriftCallable<OperateResult>(){
    @Override
    public OperateResult call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      return new MailboxWebapi.Client(protocol).updateMessageJobStatus(platformArgs, messageJobId, status);
      }
    }, invokeInfo);
  }

  public OperateResult  updateMessageJobStatus(int routeKey, int timeout,long messageJobId, xueqiao.mailbox.thriftdata.mb.MJStatus status)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return updateMessageJobStatus(messageJobId, status, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

}
