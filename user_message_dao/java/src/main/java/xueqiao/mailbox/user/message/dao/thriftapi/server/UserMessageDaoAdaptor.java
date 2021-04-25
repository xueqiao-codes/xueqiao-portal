package xueqiao.mailbox.user.message.dao.thriftapi.server;

import java.util.Properties;
import org.soldier.platform.svr_platform.container.TServiceCntl;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import xueqiao.mailbox.user.message.dao.thriftapi.UserMessageDao;
import xueqiao.mailbox.user.message.dao.thriftapi.UserMessageDaoVariable;


public abstract class UserMessageDaoAdaptor implements UserMessageDao.Iface{
  // unmodified map, so we do not need lock for this 
  private final Map<String, String[]> methodParameterNameMap = new HashMap<String, String[]>(); 

  public String[] getMethodParameterName(String methodName) {
    return methodParameterNameMap.get(methodName);
  }

  @Override
  public void addUserMessage(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, List<xueqiao.mailbox.user.message.thriftapi.UserMessage> userMessage) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(UserMessageDaoVariable.serviceKey,"addUserMessage",platformArgs);
addUserMessage(oCntl, userMessage);
  }

  protected abstract void addUserMessage(TServiceCntl oCntl, List<xueqiao.mailbox.user.message.thriftapi.UserMessage> userMessage) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public xueqiao.mailbox.user.message.thriftapi.UserMessagePage reqUserMessage(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, xueqiao.mailbox.user.message.thriftapi.ReqUserMessageOption option, org.soldier.platform.page.IndexedPageOption pageOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(UserMessageDaoVariable.serviceKey,"reqUserMessage",platformArgs);
    return reqUserMessage(oCntl, option, pageOption);
  }

  protected abstract xueqiao.mailbox.user.message.thriftapi.UserMessagePage reqUserMessage(TServiceCntl oCntl, xueqiao.mailbox.user.message.thriftapi.ReqUserMessageOption option, org.soldier.platform.page.IndexedPageOption pageOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public void markAsRead(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, xueqiao.mailbox.user.message.thriftapi.MarkReadOption option) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(UserMessageDaoVariable.serviceKey,"markAsRead",platformArgs);
markAsRead(oCntl, option);
  }

  protected abstract void markAsRead(TServiceCntl oCntl, xueqiao.mailbox.user.message.thriftapi.MarkReadOption option) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  protected UserMessageDaoAdaptor(){
    methodParameterNameMap.put("addUserMessage",new String[]{"platformArgs", "userMessage"});
    methodParameterNameMap.put("reqUserMessage",new String[]{"platformArgs", "option", "pageOption"});
    methodParameterNameMap.put("markAsRead",new String[]{"platformArgs", "option"});
  }
  protected abstract int InitApp(final Properties props);

  protected abstract void destroy();

}
