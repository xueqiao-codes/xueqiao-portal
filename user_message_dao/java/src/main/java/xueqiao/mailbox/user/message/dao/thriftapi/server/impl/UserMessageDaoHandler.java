package xueqiao.mailbox.user.message.dao.thriftapi.server.impl;


import java.util.List;
import java.util.Properties;

import org.soldier.base.logger.AppLog;
import org.soldier.platform.dal_set.DalSetProxy;
import org.soldier.platform.svr_platform.container.TServiceCntl;
import xueqiao.mailbox.user.message.api.UserMessageApi;
import xueqiao.mailbox.user.message.config.ConfigurationProperty;
import xueqiao.mailbox.user.message.dao.thriftapi.server.UserMessageDaoAdaptor;

import javax.sql.DataSource;

public class UserMessageDaoHandler extends UserMessageDaoAdaptor{
  @Override
  public int InitApp(Properties props){
    try {
      DalSetProxy.getInstance().loadFromXml();
    } catch (Exception e) {
      AppLog.e("DAL init fail.", e);
      e.printStackTrace();
      return -1;
    }
    try {
      ConfigurationProperty.instance().init(props);

    } catch (Exception e) {
      e.printStackTrace();
      AppLog.e("Config init fail.", e);
      return -1;
    }
    AppLog.e("======= SERVICE START =======");
    return 0;
  }

  @Override
  protected void addUserMessage(TServiceCntl oCntl, List<xueqiao.mailbox.user.message.thriftapi.UserMessage> userMessage) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    new UserMessageApi().addmessage(getDataSource(oCntl), userMessage);
  }

  @Override
  protected xueqiao.mailbox.user.message.thriftapi.UserMessagePage reqUserMessage(TServiceCntl oCntl, xueqiao.mailbox.user.message.thriftapi.ReqUserMessageOption option, org.soldier.platform.page.IndexedPageOption pageOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    return new UserMessageApi().reqUserMessage(getDataSource(oCntl), option, pageOption);
  }

  @Override
  protected void markAsRead(TServiceCntl oCntl, xueqiao.mailbox.user.message.thriftapi.MarkReadOption option) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    new UserMessageApi().markMessageAsRead(getDataSource(oCntl), option);
  }

  @Override
  public void destroy() {
  }
  private DataSource getDataSource(TServiceCntl oCntl) {
    return ConfigurationProperty.instance().getDataSource(oCntl.getDalSetServiceName());
  }
}
