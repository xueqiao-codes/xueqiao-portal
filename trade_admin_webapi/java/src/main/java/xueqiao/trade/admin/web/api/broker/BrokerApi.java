package xueqiao.trade.admin.web.api.broker;

import com.longsheng.xueqiao.broker.dao.thriftapi.BrokerAccessEntryPage;
import com.longsheng.xueqiao.broker.dao.thriftapi.BrokerEntryPage;
import com.longsheng.xueqiao.broker.dao.thriftapi.ReqBrokerAccessEntryOption;
import com.longsheng.xueqiao.broker.dao.thriftapi.ReqBrokerEntryOption;
import com.longsheng.xueqiao.broker.dao.thriftapi.client.BrokerDaoServiceStub;
import org.apache.thrift.TException;
import org.soldier.platform.page.IndexedPageOption;

public class BrokerApi implements IBrokerApi {

    private IndexedPageOption fullPage = new IndexedPageOption().setNeedTotalCount(true).setPageIndex(0).setPageSize(Integer.MAX_VALUE);

    @Override
    public BrokerEntryPage reqBroker(ReqBrokerEntryOption option, IndexedPageOption pageOption) throws TException {
        pageOption = getIndexedPageOption(pageOption);
        return new BrokerDaoServiceStub().reqBrokerEntry(option, pageOption.getPageIndex(), pageOption.getPageSize());
    }

    private IndexedPageOption getIndexedPageOption(IndexedPageOption pageOption) {
        if (pageOption == null) {
            pageOption = new IndexedPageOption().setPageIndex(0).setPageSize(Integer.MAX_VALUE);
        }
        return pageOption;
    }

    @Override
    public BrokerEntryPage reqBrokerFull(ReqBrokerEntryOption option) throws TException {
        return reqBroker(option, fullPage);
    }

    @Override
    public BrokerAccessEntryPage reqBrokerAccess(ReqBrokerAccessEntryOption option, IndexedPageOption pageOption) throws TException {
        getIndexedPageOption(pageOption);
        return new BrokerDaoServiceStub().reqBrokerAccessEntry(option,pageOption.getPageIndex(),pageOption.getPageSize());
    }

    @Override
    public BrokerAccessEntryPage reqBrokerAccessFull(ReqBrokerAccessEntryOption option) throws TException {
        return reqBrokerAccess(option, fullPage);
    }
}
