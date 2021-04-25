package xueqiao.quotation.admin.web.api.contract;

import com.longsheng.xueqiao.contract.standard.thriftapi.*;
import org.apache.thrift.TException;
import org.soldier.platform.page.IndexedPageOption;

public interface IContractApi {

    SledExchangePage reqExchange(ReqSledExchangeOption option, IndexedPageOption pageOption) throws TException;

    SledExchangePage reqExchangeFull(ReqSledExchangeOption option) throws TException;

    SledCommodityPage reqCommodity(ReqSledCommodityOption option, IndexedPageOption pageOption) throws TException;

    SledCommodityPage reqCommodityFull(ReqSledCommodityOption option) throws TException;

    SledContractPage reqContract(ReqSledContractOption option, IndexedPageOption pageOption) throws TException;

    SledContractPage reqContractFull(ReqSledContractOption option) throws TException;
}
