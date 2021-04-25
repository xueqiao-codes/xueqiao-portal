package xueqiao.mailbox.hosting.dao.thriftapi.server;

import java.util.Properties;
import org.soldier.platform.svr_platform.container.TServiceCntl;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import xueqiao.mailbox.hosting.dao.thriftapi.MailboxHostingDao;
import xueqiao.mailbox.hosting.dao.thriftapi.MailboxHostingDaoVariable;


public abstract class MailboxHostingDaoAdaptor implements MailboxHostingDao.Iface{
  // unmodified map, so we do not need lock for this 
  private final Map<String, String[]> methodParameterNameMap = new HashMap<String, String[]>(); 

  public String[] getMethodParameterName(String methodName) {
    return methodParameterNameMap.get(methodName);
  }

  @Override
  public void addHostingMessage(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, List<xueqiao.mailbox.hosting.thriftapi.HostingMessage> hostingMessages) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(MailboxHostingDaoVariable.serviceKey,"addHostingMessage",platformArgs);
addHostingMessage(oCntl, hostingMessages);
  }

  protected abstract void addHostingMessage(TServiceCntl oCntl, List<xueqiao.mailbox.hosting.thriftapi.HostingMessage> hostingMessages) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public xueqiao.mailbox.hosting.thriftapi.HostingMessagePage reqHostingMessage(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, xueqiao.mailbox.hosting.thriftapi.ReqHostingMessageOption option, org.soldier.platform.page.IndexedPageOption pageOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(MailboxHostingDaoVariable.serviceKey,"reqHostingMessage",platformArgs);
    return reqHostingMessage(oCntl, option, pageOption);
  }

  protected abstract xueqiao.mailbox.hosting.thriftapi.HostingMessagePage reqHostingMessage(TServiceCntl oCntl, xueqiao.mailbox.hosting.thriftapi.ReqHostingMessageOption option, org.soldier.platform.page.IndexedPageOption pageOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public void markAsRead(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, xueqiao.mailbox.hosting.thriftapi.MarkReadOption option) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(MailboxHostingDaoVariable.serviceKey,"markAsRead",platformArgs);
markAsRead(oCntl, option);
  }

  protected abstract void markAsRead(TServiceCntl oCntl, xueqiao.mailbox.hosting.thriftapi.MarkReadOption option) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  protected MailboxHostingDaoAdaptor(){
    methodParameterNameMap.put("addHostingMessage",new String[]{"platformArgs", "hostingMessages"});
    methodParameterNameMap.put("reqHostingMessage",new String[]{"platformArgs", "option", "pageOption"});
    methodParameterNameMap.put("markAsRead",new String[]{"platformArgs", "option"});
  }
  protected abstract int InitApp(final Properties props);

  protected abstract void destroy();

}
