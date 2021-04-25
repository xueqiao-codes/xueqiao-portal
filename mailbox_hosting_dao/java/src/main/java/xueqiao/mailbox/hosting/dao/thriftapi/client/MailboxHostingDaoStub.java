package xueqiao.mailbox.hosting.dao.thriftapi.client;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TProtocol;
import org.soldier.platform.svr_platform.client.BaseStub;
import org.soldier.platform.svr_platform.client.TStubOption;
import org.soldier.platform.svr_platform.comm.ErrorInfo;
import org.soldier.platform.svr_platform.comm.PlatformArgs;
import java.util.List;
import xueqiao.mailbox.hosting.dao.thriftapi.MailboxHostingDao;
import xueqiao.mailbox.hosting.dao.thriftapi.MailboxHostingDaoVariable;

public class MailboxHostingDaoStub extends BaseStub {

  public MailboxHostingDaoStub() {
    super(MailboxHostingDaoVariable.serviceKey);
  }

  public void  addHostingMessage(List<xueqiao.mailbox.hosting.thriftapi.HostingMessage> hostingMessages) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    addHostingMessage(hostingMessages, new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public void  addHostingMessage(List<xueqiao.mailbox.hosting.thriftapi.HostingMessage> hostingMessages,TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("addHostingMessage").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    super.runSync(new ThriftCallable<Void>(){
    @Override
    public Void call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      new MailboxHostingDao.Client(protocol).addHostingMessage(platformArgs, hostingMessages);
      return null;
      }
    }, invokeInfo);
  }

  public void  addHostingMessage(int routeKey, int timeout,List<xueqiao.mailbox.hosting.thriftapi.HostingMessage> hostingMessages)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    addHostingMessage(hostingMessages, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public xueqiao.mailbox.hosting.thriftapi.HostingMessagePage  reqHostingMessage(xueqiao.mailbox.hosting.thriftapi.ReqHostingMessageOption option, org.soldier.platform.page.IndexedPageOption pageOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return reqHostingMessage(option, pageOption, new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public xueqiao.mailbox.hosting.thriftapi.HostingMessagePage  reqHostingMessage(xueqiao.mailbox.hosting.thriftapi.ReqHostingMessageOption option, org.soldier.platform.page.IndexedPageOption pageOption,TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("reqHostingMessage").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    return super.runSync(new ThriftCallable<xueqiao.mailbox.hosting.thriftapi.HostingMessagePage>(){
    @Override
    public xueqiao.mailbox.hosting.thriftapi.HostingMessagePage call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      return new MailboxHostingDao.Client(protocol).reqHostingMessage(platformArgs, option, pageOption);
      }
    }, invokeInfo);
  }

  public xueqiao.mailbox.hosting.thriftapi.HostingMessagePage  reqHostingMessage(int routeKey, int timeout,xueqiao.mailbox.hosting.thriftapi.ReqHostingMessageOption option, org.soldier.platform.page.IndexedPageOption pageOption)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return reqHostingMessage(option, pageOption, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public void  markAsRead(xueqiao.mailbox.hosting.thriftapi.MarkReadOption option) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    markAsRead(option, new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public void  markAsRead(xueqiao.mailbox.hosting.thriftapi.MarkReadOption option,TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("markAsRead").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    super.runSync(new ThriftCallable<Void>(){
    @Override
    public Void call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      new MailboxHostingDao.Client(protocol).markAsRead(platformArgs, option);
      return null;
      }
    }, invokeInfo);
  }

  public void  markAsRead(int routeKey, int timeout,xueqiao.mailbox.hosting.thriftapi.MarkReadOption option)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    markAsRead(option, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

}
