package xueqiao.mailbox.dao.thriftapi.client;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TProtocol;
import org.soldier.platform.svr_platform.client.BaseStub;
import org.soldier.platform.svr_platform.client.TStubOption;
import org.soldier.platform.svr_platform.comm.ErrorInfo;
import org.soldier.platform.svr_platform.comm.PlatformArgs;
import xueqiao.mailbox.dao.thriftapi.MailboxDao;
import xueqiao.mailbox.dao.thriftapi.MailboxDaoVariable;

public class MailboxDaoStub extends BaseStub {

  public MailboxDaoStub() {
    super(MailboxDaoVariable.serviceKey);
  }

  public void  addMBMessage(xueqiao.mailbox.thriftdata.mb.MBMessage message) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    addMBMessage(message, new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public void  addMBMessage(xueqiao.mailbox.thriftdata.mb.MBMessage message,TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("addMBMessage").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    super.runSync(new ThriftCallable<Void>(){
    @Override
    public Void call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      new MailboxDao.Client(protocol).addMBMessage(platformArgs, message);
      return null;
      }
    }, invokeInfo);
  }

  public void  addMBMessage(int routeKey, int timeout,xueqiao.mailbox.thriftdata.mb.MBMessage message)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    addMBMessage(message, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public void  modifyMBMessageStatus(long mbmId, xueqiao.mailbox.thriftdata.mb.MStatus status) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    modifyMBMessageStatus(mbmId, status, new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public void  modifyMBMessageStatus(long mbmId, xueqiao.mailbox.thriftdata.mb.MStatus status,TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("modifyMBMessageStatus").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    super.runSync(new ThriftCallable<Void>(){
    @Override
    public Void call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      new MailboxDao.Client(protocol).modifyMBMessageStatus(platformArgs, mbmId, status);
      return null;
      }
    }, invokeInfo);
  }

  public void  modifyMBMessageStatus(int routeKey, int timeout,long mbmId, xueqiao.mailbox.thriftdata.mb.MStatus status)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    modifyMBMessageStatus(mbmId, status, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public xueqiao.mailbox.thriftdata.req.MBMessagePage  queryMBMessagePage(xueqiao.mailbox.thriftdata.req.QueryMBMessageOption queryOption, org.soldier.platform.page.IndexedPageOption pageOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return queryMBMessagePage(queryOption, pageOption, new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public xueqiao.mailbox.thriftdata.req.MBMessagePage  queryMBMessagePage(xueqiao.mailbox.thriftdata.req.QueryMBMessageOption queryOption, org.soldier.platform.page.IndexedPageOption pageOption,TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("queryMBMessagePage").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    return super.runSync(new ThriftCallable<xueqiao.mailbox.thriftdata.req.MBMessagePage>(){
    @Override
    public xueqiao.mailbox.thriftdata.req.MBMessagePage call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      return new MailboxDao.Client(protocol).queryMBMessagePage(platformArgs, queryOption, pageOption);
      }
    }, invokeInfo);
  }

  public xueqiao.mailbox.thriftdata.req.MBMessagePage  queryMBMessagePage(int routeKey, int timeout,xueqiao.mailbox.thriftdata.req.QueryMBMessageOption queryOption, org.soldier.platform.page.IndexedPageOption pageOption)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return queryMBMessagePage(queryOption, pageOption, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public void  addMBMessageTemplate(xueqiao.mailbox.thriftdata.mb.MBMessageTemplate template) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    addMBMessageTemplate(template, new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public void  addMBMessageTemplate(xueqiao.mailbox.thriftdata.mb.MBMessageTemplate template,TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("addMBMessageTemplate").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    super.runSync(new ThriftCallable<Void>(){
    @Override
    public Void call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      new MailboxDao.Client(protocol).addMBMessageTemplate(platformArgs, template);
      return null;
      }
    }, invokeInfo);
  }

  public void  addMBMessageTemplate(int routeKey, int timeout,xueqiao.mailbox.thriftdata.mb.MBMessageTemplate template)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    addMBMessageTemplate(template, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public void  modifyMBMessageTemplate(xueqiao.mailbox.thriftdata.mb.MBMessageTemplate template) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    modifyMBMessageTemplate(template, new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public void  modifyMBMessageTemplate(xueqiao.mailbox.thriftdata.mb.MBMessageTemplate template,TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("modifyMBMessageTemplate").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    super.runSync(new ThriftCallable<Void>(){
    @Override
    public Void call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      new MailboxDao.Client(protocol).modifyMBMessageTemplate(platformArgs, template);
      return null;
      }
    }, invokeInfo);
  }

  public void  modifyMBMessageTemplate(int routeKey, int timeout,xueqiao.mailbox.thriftdata.mb.MBMessageTemplate template)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    modifyMBMessageTemplate(template, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public void  deleteMBMessageTemplate(long templateId) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    deleteMBMessageTemplate(templateId, new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public void  deleteMBMessageTemplate(long templateId,TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("deleteMBMessageTemplate").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    super.runSync(new ThriftCallable<Void>(){
    @Override
    public Void call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      new MailboxDao.Client(protocol).deleteMBMessageTemplate(platformArgs, templateId);
      return null;
      }
    }, invokeInfo);
  }

  public void  deleteMBMessageTemplate(int routeKey, int timeout,long templateId)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    deleteMBMessageTemplate(templateId, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public xueqiao.mailbox.thriftdata.req.MBMessageTemplatePage  queryMBMessageTemplatePage(xueqiao.mailbox.thriftdata.req.QueryMBMessageTemplateOption queryOption, org.soldier.platform.page.IndexedPageOption pageOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return queryMBMessageTemplatePage(queryOption, pageOption, new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public xueqiao.mailbox.thriftdata.req.MBMessageTemplatePage  queryMBMessageTemplatePage(xueqiao.mailbox.thriftdata.req.QueryMBMessageTemplateOption queryOption, org.soldier.platform.page.IndexedPageOption pageOption,TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("queryMBMessageTemplatePage").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    return super.runSync(new ThriftCallable<xueqiao.mailbox.thriftdata.req.MBMessageTemplatePage>(){
    @Override
    public xueqiao.mailbox.thriftdata.req.MBMessageTemplatePage call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      return new MailboxDao.Client(protocol).queryMBMessageTemplatePage(platformArgs, queryOption, pageOption);
      }
    }, invokeInfo);
  }

  public xueqiao.mailbox.thriftdata.req.MBMessageTemplatePage  queryMBMessageTemplatePage(int routeKey, int timeout,xueqiao.mailbox.thriftdata.req.QueryMBMessageTemplateOption queryOption, org.soldier.platform.page.IndexedPageOption pageOption)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return queryMBMessageTemplatePage(queryOption, pageOption, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public long  startSendMBMessage(long mbmId, boolean isMessageCompleted) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return startSendMBMessage(mbmId, isMessageCompleted, new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public long  startSendMBMessage(long mbmId, boolean isMessageCompleted,TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("startSendMBMessage").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    return super.runSync(new ThriftCallable<Long>(){
    @Override
    public Long call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      return new MailboxDao.Client(protocol).startSendMBMessage(platformArgs, mbmId, isMessageCompleted);
      }
    }, invokeInfo);
  }

  public long  startSendMBMessage(int routeKey, int timeout,long mbmId, boolean isMessageCompleted)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return startSendMBMessage(mbmId, isMessageCompleted, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public void  modifyMBMessageJobStatus(long jobId, xueqiao.mailbox.thriftdata.mb.MJStatus status, String errorDescription) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    modifyMBMessageJobStatus(jobId, status, errorDescription, new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public void  modifyMBMessageJobStatus(long jobId, xueqiao.mailbox.thriftdata.mb.MJStatus status, String errorDescription,TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("modifyMBMessageJobStatus").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    super.runSync(new ThriftCallable<Void>(){
    @Override
    public Void call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      new MailboxDao.Client(protocol).modifyMBMessageJobStatus(platformArgs, jobId, status, errorDescription);
      return null;
      }
    }, invokeInfo);
  }

  public void  modifyMBMessageJobStatus(int routeKey, int timeout,long jobId, xueqiao.mailbox.thriftdata.mb.MJStatus status, String errorDescription)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    modifyMBMessageJobStatus(jobId, status, errorDescription, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public xueqiao.mailbox.thriftdata.req.MBMessageJobPage  queryMBMessageJobPage(xueqiao.mailbox.thriftdata.req.QueryMBMessageJobOption queryOption, org.soldier.platform.page.IndexedPageOption pageOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return queryMBMessageJobPage(queryOption, pageOption, new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public xueqiao.mailbox.thriftdata.req.MBMessageJobPage  queryMBMessageJobPage(xueqiao.mailbox.thriftdata.req.QueryMBMessageJobOption queryOption, org.soldier.platform.page.IndexedPageOption pageOption,TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("queryMBMessageJobPage").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    return super.runSync(new ThriftCallable<xueqiao.mailbox.thriftdata.req.MBMessageJobPage>(){
    @Override
    public xueqiao.mailbox.thriftdata.req.MBMessageJobPage call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      return new MailboxDao.Client(protocol).queryMBMessageJobPage(platformArgs, queryOption, pageOption);
      }
    }, invokeInfo);
  }

  public xueqiao.mailbox.thriftdata.req.MBMessageJobPage  queryMBMessageJobPage(int routeKey, int timeout,xueqiao.mailbox.thriftdata.req.QueryMBMessageJobOption queryOption, org.soldier.platform.page.IndexedPageOption pageOption)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return queryMBMessageJobPage(queryOption, pageOption, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

}
