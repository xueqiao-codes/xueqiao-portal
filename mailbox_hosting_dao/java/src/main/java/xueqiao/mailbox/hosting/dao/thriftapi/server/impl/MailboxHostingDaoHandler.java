package xueqiao.mailbox.hosting.dao.thriftapi.server.impl;


import java.util.List;
import java.util.Properties;

import org.apache.thrift.TException;
import org.soldier.base.logger.AppLog;
import org.soldier.platform.dal_set.DalSetProxy;
import org.soldier.platform.svr_platform.comm.ErrorInfo;
import org.soldier.platform.svr_platform.container.TServiceCntl;
import xueqiao.mailbox.hosting.api.HostingMessageApi;
import xueqiao.mailbox.hosting.config.ConfigurationProperty;
import xueqiao.mailbox.hosting.dao.thriftapi.server.MailboxHostingDaoAdaptor;
import xueqiao.mailbox.hosting.thriftapi.HostingMessage;

import javax.sql.DataSource;

public class MailboxHostingDaoHandler extends MailboxHostingDaoAdaptor {
    @Override
    public int InitApp(Properties props) {

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
    protected void addHostingMessage(TServiceCntl oCntl, List<HostingMessage> hostingMessages) throws ErrorInfo, TException {
        new HostingMessageApi().addHostingMessage(getDataSource(oCntl), hostingMessages);
    }


    @Override
    protected xueqiao.mailbox.hosting.thriftapi.HostingMessagePage reqHostingMessage(TServiceCntl oCntl, xueqiao.mailbox.hosting.thriftapi.ReqHostingMessageOption option, org.soldier.platform.page.IndexedPageOption pageOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException {
        return new HostingMessageApi().reqHostingMessage(getDataSource(oCntl), option, pageOption);
    }

    @Override
    protected void markAsRead(TServiceCntl oCntl, xueqiao.mailbox.hosting.thriftapi.MarkReadOption option) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException {
        new HostingMessageApi().updateHostingMessageState(getDataSource(oCntl), option);
    }

    @Override
    public void destroy() {
    }

    private DataSource getDataSource(TServiceCntl oCntl) {
        return ConfigurationProperty.instance().getDataSource(oCntl.getDalSetServiceName());
    }
}
