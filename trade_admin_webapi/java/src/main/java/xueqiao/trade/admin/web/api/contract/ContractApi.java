package xueqiao.trade.admin.web.api.contract;

import com.longsheng.xueqiao.contract.standard.thriftapi.*;
import com.longsheng.xueqiao.contract.thriftapi.SledCommodityEdit;
import com.longsheng.xueqiao.contract.thriftapi.SledCommodityEditPage;
import com.longsheng.xueqiao.contract.thriftapi.SledContractEdit;
import com.longsheng.xueqiao.contract.thriftapi.SledContractEditPage;
import com.longsheng.xueqiao.contract.thriftapi.client.ContractServiceStub;
import org.apache.thrift.TException;
import org.soldier.platform.page.IndexedPageOption;

import java.util.ArrayList;

public class ContractApi implements IContractApi {

    private IndexedPageOption fullPage = new IndexedPageOption().setNeedTotalCount(true).setPageIndex(0).setPageSize(Integer.MAX_VALUE);

    @Override
    public SledExchangePage reqExchange(ReqSledExchangeOption option, IndexedPageOption pageOption) throws TException {

        if (pageOption == null) {
            pageOption = fullPage;
        }
        return new ContractServiceStub().reqSledExchange(option, pageOption.getPageIndex(), pageOption.getPageSize());
    }

    @Override
    public SledExchangePage reqExchangeFull(ReqSledExchangeOption option) throws TException {
        return reqExchange(option, fullPage);
    }

    @Override
    public SledCommodityPage reqCommodity(ReqSledCommodityOption option, IndexedPageOption pageOption) throws TException {
        if (pageOption == null) {
            pageOption = fullPage;
        }
        SledCommodityEditPage page = new ContractServiceStub().reqSledCommodity(option, pageOption.getPageIndex(), pageOption.getPageSize());
        SledCommodityPage commodityPage = new SledCommodityPage().setPage(new ArrayList<>());
        commodityPage.setTotal(page.getTotal());
        for (SledCommodityEdit edit : page.getPage()) {
            commodityPage.addToPage(edit.getSledCommodity());
        }
        return commodityPage;
    }

    @Override
    public SledCommodityPage reqCommodityFull(ReqSledCommodityOption option) throws TException {
        return reqCommodity(option, fullPage);
    }

    @Override
    public SledContractPage reqContract(ReqSledContractOption option, IndexedPageOption pageOption) throws TException {

        if (pageOption == null) {
            pageOption = fullPage;
        }
        SledContractEditPage page = new ContractServiceStub().reqSledContractDetail(option, pageOption.getPageIndex(), pageOption.getPageSize());
        SledContractPage contractPage = new SledContractPage().setPage(new ArrayList<>());
        contractPage.setTotal(page.getTotal());
        for (SledContractEdit edit : page.getPage()) {
            contractPage.addToPage(edit.getSledContract());
        }
        return contractPage;
    }

    @Override
    public SledContractPage reqContractFull(ReqSledContractOption option) throws TException {
        return reqContract(option, fullPage);
    }
}
