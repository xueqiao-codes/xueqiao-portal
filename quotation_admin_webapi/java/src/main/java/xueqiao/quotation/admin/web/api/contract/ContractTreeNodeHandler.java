package xueqiao.quotation.admin.web.api.contract;

import com.antiy.error_code.ErrorCodeOuter;
import com.google.gson.Gson;
import com.longsheng.xueqiao.contract.standard.thriftapi.*;
import org.apache.thrift.TException;
import org.soldier.platform.page.IndexedPageOption;
import org.soldier.platform.svr_platform.comm.ErrorInfo;
import xueqiao.quotation.admin.web.api.bean.TreeNode;
import xueqiao.quotation.admin.web.api.thriftapi.ContractTreeNode;
import xueqiao.quotation.admin.web.api.thriftapi.ContractTreeNodeType;
import xueqiao.quotation.admin.web.api.thriftapi.Tree;

import java.util.*;

public class ContractTreeNodeHandler {

    public Tree reqCommodityTree(TechPlatformEnv platformEnv) throws TException {
        IContractApi contractApi = ContractApiFactory.getInstance().getDefault();

        IndexedPageOption pageOption = new IndexedPageOption();
        pageOption.setPageIndex(0);
        pageOption.setPageSize(Integer.MAX_VALUE);
        ReqSledCommodityOption option = new ReqSledCommodityOption();
        option.setPlatformEnv(platformEnv);
        SledCommodityPage page = contractApi.reqCommodity(option, pageOption);
        Map<String, List<SledCommodity>> commodities = new HashMap<>();
        Map<String, List<String>> exTypes = new HashMap<>();

        for (SledCommodity sledCommodity : page.getPage()) {
            String micType = sledCommodity.getExchangeMic() + "|" + sledCommodity.getSledCommodityType().name();
            List<SledCommodity> list = commodities.get(micType);
            if (list == null) {
                list = new ArrayList<>();
                commodities.put(micType, list);
            }

            list.add(sledCommodity);

            List<String> types = exTypes.get(sledCommodity.getExchangeMic());
            if (types == null) {
                types = new ArrayList<>();
                exTypes.put(sledCommodity.getExchangeMic(), types);
            }
            if (!types.contains(sledCommodity.getSledCommodityType().name())) {
                types.add(sledCommodity.getSledCommodityType().name());
            }
        }

//        AppLog.d("exTypes: " + new Gson().toJson(exTypes));

        SledExchangePage exchangePage = contractApi.reqExchangeFull(new ReqSledExchangeOption());
        Map<String, SledExchange> sledExchanges = new HashMap<>();
        for (SledExchange sledExchange : exchangePage.getPage()) {
            sledExchanges.put(sledExchange.getExchangeMic(), sledExchange);
        }

        TreeNode rootNode = new TreeNode();
        List<TreeNode> exTreeNodes = new ArrayList<>();
        for (SledExchange sledExchange : exchangePage.getPage()) {
            TreeNode exchangeNode = new TreeNode();
            exchangeNode.setLabel(sledExchange.getCnName());
            exchangeNode.setValue(sledExchange.getExchangeMic());
            List<TreeNode> typeNodes = new ArrayList<>();

            List<String> list = exTypes.get(sledExchange.getExchangeMic());
            if (list == null) {
                continue;
            }

            for (String typeName : list) {
                TreeNode typeNode = new TreeNode();
                SledCommodityType type = SledCommodityType.valueOf(typeName);
                typeNode.setLabel(type.name());
                typeNode.setValue(type.name());

                String key = sledExchange.getExchangeMic() + "|" + type.name();
                List<SledCommodity> sledCommodities = commodities.get(key);
                List<TreeNode> sledCommodityNodes = new ArrayList<>();
                for (SledCommodity sledCommodity : sledCommodities) {
                    TreeNode node = new TreeNode();
                    node.setValue(String.valueOf(sledCommodity.getSledCommodityId()));
                    node.setLabel(sledCommodity.getCnName());
                    sledCommodityNodes.add(node);
                }

                typeNode.setChildren(sledCommodityNodes);
//                AppLog.d("typeNode: " + new Gson().toJson(typeNode));

                typeNodes.add(typeNode);
            }
            exchangeNode.setChildren(typeNodes);
//            AppLog.d("exchangeNode: " +new Gson().toJson( exchangeNode));

            if (list.size() > 0) {
                exTreeNodes.add(exchangeNode);
            }
        }

        rootNode.setValue("root");
        rootNode.setLabel("Root");
        rootNode.setChildren(exTreeNodes);

        Tree tree = new Tree();
        tree.setName("CommodityTree");
        tree.setTreeJson(new Gson().toJson(rootNode));

        return tree;

    }

    public Tree reqCommodityTypeTree(TechPlatformEnv platformEnv) throws TException {
        IContractApi contractApi = ContractApiFactory.getInstance().getDefault();

        IndexedPageOption pageOption = new IndexedPageOption();
        pageOption.setPageIndex(0);
        pageOption.setPageSize(Integer.MAX_VALUE);
        ReqSledCommodityOption option = new ReqSledCommodityOption();
        option.setPlatformEnv(platformEnv);
        SledCommodityPage page = contractApi.reqCommodity(option, pageOption);
        Map<String, List<SledCommodity>> commodities = new HashMap<>();
        Map<String, List<String>> exTypes = new HashMap<>();

        for (SledCommodity sledCommodity : page.getPage()) {
            String micType = sledCommodity.getExchangeMic() + "|" + sledCommodity.getSledCommodityType().name();
            List<SledCommodity> list = commodities.get(micType);
            if (list == null) {
                list = new ArrayList<>();
                commodities.put(micType, list);
            }

            list.add(sledCommodity);

            List<String> types = exTypes.get(sledCommodity.getExchangeMic());
            if (types == null) {
                types = new ArrayList<>();
                exTypes.put(sledCommodity.getExchangeMic(), types);
            }
            if (!types.contains(sledCommodity.getSledCommodityType().name())) {
                types.add(sledCommodity.getSledCommodityType().name());
            }
        }

        SledExchangePage exchangePage = contractApi.reqExchangeFull(new ReqSledExchangeOption());
        Map<String, SledExchange> sledExchanges = new HashMap<>();
        for (SledExchange sledExchange : exchangePage.getPage()) {
            sledExchanges.put(sledExchange.getExchangeMic(), sledExchange);
        }

        TreeNode rootNode = new TreeNode();
        List<TreeNode> exTreeNodes = new ArrayList<>();
        for (SledExchange sledExchange : exchangePage.getPage()) {
            TreeNode exchangeNode = new TreeNode();
            exchangeNode.setLabel(sledExchange.getCnName());
            exchangeNode.setValue(String.valueOf(sledExchange.getSledExchangeId()));
            List<TreeNode> typeNodes = new ArrayList<>();

            List<String> list = exTypes.get(sledExchange.getExchangeMic());
            if (list == null) {
                continue;
            }

            for (String typeName : list) {
                TreeNode typeNode = new TreeNode();
                SledCommodityType type = SledCommodityType.valueOf(typeName);
                typeNode.setLabel(type.name());
                typeNode.setValue(type.name());

                typeNodes.add(typeNode);
            }
            exchangeNode.setChildren(typeNodes);

            if (list.size() > 0) {
                exTreeNodes.add(exchangeNode);
            }
        }

        rootNode.setValue("root");
        rootNode.setLabel("Root");
        rootNode.setChildren(exTreeNodes);

        Tree tree = new Tree();
        tree.setName("CommodityTypeTree");
        tree.setTreeJson(new Gson().toJson(rootNode));

        return tree;

    }

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

    public List<ContractTreeNode> reqCommodityNodes(int exchangeId, SledCommodityType commodityType, TechPlatformEnv platformEnv) throws TException {

        List<xueqiao.quotation.admin.web.api.thriftapi.ContractTreeNode> nodes = new ArrayList<>();
        IContractApi contractApi = ContractApiFactory.getInstance().getDefault();

        IndexedPageOption pageOption = new IndexedPageOption();
        pageOption.setPageIndex(0);
        pageOption.setPageSize(Integer.MAX_VALUE);

        ReqSledExchangeOption option = new ReqSledExchangeOption();
        pageOption.setNeedTotalCount(true);
        pageOption.setPageIndex(0);
        pageOption.setPageSize(Integer.MAX_VALUE);
        option.addToSledExchangeIds(exchangeId);
        SledExchangePage exchangePage = contractApi.reqExchange(option, pageOption);
        String exchangeMic;
        if (exchangePage.getPageSize() > 0) {
            exchangeMic = exchangePage.getPage().get(0).getExchangeMic();
        } else {
            throw new ErrorInfo(ErrorCodeOuter.PARAM_ERROR.getErrorCode(), "exchange not found");
        }

        SledCommodityPage page = contractApi.reqCommodity(
                new ReqSledCommodityOption()
                        .setExchangeMic(exchangeMic)
                        .setSledCommodityType(commodityType)
                        .setPlatformEnv(platformEnv), pageOption);
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
