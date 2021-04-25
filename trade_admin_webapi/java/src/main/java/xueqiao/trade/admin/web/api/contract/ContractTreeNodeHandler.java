package xueqiao.trade.admin.web.api.contract;

import com.longsheng.xueqiao.contract.standard.thriftapi.*;
import org.apache.thrift.TException;
import org.soldier.platform.page.IndexedPageOption;
import xueqiao.trade.admin.web.api.thriftapi.ContractTreeNode;
import xueqiao.trade.admin.web.api.thriftapi.ContractTreeNodeType;

import java.util.ArrayList;
import java.util.List;

public class ContractTreeNodeHandler {

    public List<ContractTreeNode> reqExchangeNodes(TechPlatformEnv env) throws TException {

        IContractApi contractApi = ContractApiFactory.getInstance().getDefault();
        ReqSledExchangeOption option = new ReqSledExchangeOption();
        IndexedPageOption pageOption = new IndexedPageOption();
        pageOption.setNeedTotalCount(true);
        pageOption.setPageIndex(0);
        pageOption.setPageSize(Integer.MAX_VALUE);
        SledExchangePage page = contractApi.reqExchange(option, pageOption);
        List<ContractTreeNode> nodes = new ArrayList<>();
        for (SledExchange sledExchange : page.getPage()) {

            ContractTreeNode node = new ContractTreeNode();
            node.setId(sledExchange.getSledExchangeId());
            node.setCode(sledExchange.getExchangeMic());
            node.setName(sledExchange.getCnName());
            node.setNodeType(ContractTreeNodeType.EXCHANGE);
            node.setPlatformEnv(env);

            nodes.add(node);
        }
        return nodes;
    }

    public List<ContractTreeNode> reqCommodityNodes(String exchangeMic, SledCommodityType commodityType, TechPlatformEnv platformEnv) throws TException {

        List<ContractTreeNode> nodes = new ArrayList<>();
        IContractApi contractApi = ContractApiFactory.getInstance().getDefault();

        IndexedPageOption pageOption = new IndexedPageOption();
        pageOption.setPageIndex(0);
        pageOption.setPageSize(Integer.MAX_VALUE);
        ReqSledCommodityOption option = new ReqSledCommodityOption();
        option.setExchangeMic(exchangeMic);
        option.setSledCommodityType(commodityType);
        option.setPlatformEnv(platformEnv);
        SledCommodityPage page = contractApi.reqCommodity(option, pageOption);
        for (SledCommodity sledCommodity : page.getPage()) {
            ContractTreeNode node = new ContractTreeNode();
            node.setPlatformEnv(platformEnv);
            node.setNodeType(ContractTreeNodeType.COMMODITY);
            node.setName(sledCommodity.getCnName());
            node.setCode(sledCommodity.getSledCommodityCode());
            node.setId(sledCommodity.getSledCommodityId());
            nodes.add(node);
        }

        return nodes;
    }

    public List<ContractTreeNode> reqContractNodes(int sledCommodityId, TechPlatformEnv platformEnv) throws TException {

        List<ContractTreeNode> nodes = new ArrayList<>();
        IContractApi contractApi = ContractApiFactory.getInstance().getDefault();

        IndexedPageOption pageOption = new IndexedPageOption();
        pageOption.setPageIndex(0);
        pageOption.setPageSize(Integer.MAX_VALUE);

        ReqSledContractOption option = new ReqSledContractOption();
        option.setSledCommodityId(sledCommodityId);
        option.setPlatformEnv(platformEnv);

        SledContractPage page = contractApi.reqContract(option, pageOption);
        for (SledContract sledContract : page.getPage()) {
            ContractTreeNode node = new ContractTreeNode();
            node.setId(sledContract.getSledContractId());
            node.setCode(sledContract.getSledContractCode());
            node.setName(sledContract.getContractCnName());
            node.setPlatformEnv(platformEnv);
            node.setNodeType(ContractTreeNodeType.CONTRACT);
            nodes.add(node);
        }

        return nodes;
    }
}
