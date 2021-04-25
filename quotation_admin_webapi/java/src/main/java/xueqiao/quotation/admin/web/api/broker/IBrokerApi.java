package xueqiao.quotation.admin.web.api.broker;


import com.longsheng.xueqiao.broker.dao.thriftapi.BrokerAccessEntryPage;
import com.longsheng.xueqiao.broker.dao.thriftapi.BrokerEntryPage;
import com.longsheng.xueqiao.broker.dao.thriftapi.ReqBrokerAccessEntryOption;
import com.longsheng.xueqiao.broker.dao.thriftapi.ReqBrokerEntryOption;
import org.apache.thrift.TException;
import org.soldier.platform.page.IndexedPageOption;

public interface IBrokerApi {

    BrokerEntryPage reqBroker(ReqBrokerEntryOption option, IndexedPageOption pageOption) throws TException;

    BrokerEntryPage reqBrokerFull(ReqBrokerEntryOption option) throws TException;

    BrokerAccessEntryPage reqBrokerAccess(ReqBrokerAccessEntryOption option, IndexedPageOption pageOption) throws TException;

    BrokerAccessEntryPage reqBrokerAccessFull(ReqBrokerAccessEntryOption option) throws TException;
}
