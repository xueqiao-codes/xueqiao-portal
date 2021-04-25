package xueqiao.quotation.admin.web.api.broker;

import com.google.gson.Gson;
import com.longsheng.xueqiao.broker.dao.thriftapi.BrokerAccessEntryPage;
import com.longsheng.xueqiao.broker.dao.thriftapi.BrokerEntryPage;
import com.longsheng.xueqiao.broker.dao.thriftapi.ReqBrokerAccessEntryOption;
import com.longsheng.xueqiao.broker.dao.thriftapi.ReqBrokerEntryOption;
import com.longsheng.xueqiao.broker.thriftapi.BrokerAccessEntry;
import com.longsheng.xueqiao.broker.thriftapi.BrokerAccessWorkingStatus;
import com.longsheng.xueqiao.broker.thriftapi.BrokerEntry;
import com.longsheng.xueqiao.broker.thriftapi.BrokerPlatform;
import com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv;
import org.apache.thrift.TException;
import org.soldier.base.logger.AppLog;
import xueqiao.quotation.admin.web.api.bean.TreeNode;
import xueqiao.quotation.admin.web.api.thriftapi.Tree;
import xueqiao.quotation.admin.web.api.utils.BeanMapping;

import java.util.*;

public class BrokerTreeNodeHandler {

    public Tree reqBrokerTree(TechPlatformEnv platformEnv) throws TException {


        IBrokerApi brokerApi = BrokerApiFactory.getInstance().getDefault();

        BrokerAccessEntryPage brokerAccessEntryPage = brokerApi.reqBrokerAccessFull(new ReqBrokerAccessEntryOption().setWorkingStatus(BrokerAccessWorkingStatus.WORKING).setEnv(BeanMapping.map2BrokerPlatformEnv(platformEnv)));
        BrokerEntryPage brokerEntryPage = brokerApi.reqBrokerFull(new ReqBrokerEntryOption().setOrderAsc(true).setOrderByBrokerName(true).setEnv(BeanMapping.map2BrokerPlatformEnv(platformEnv)));

        Map<Integer, BrokerEntry> brokerEntries = new HashMap<>();
        for (BrokerEntry entry : brokerEntryPage.getPage()) {
            brokerEntries.put(entry.getBrokerId(), entry);
        }

        Map<BrokerPlatform, Set<Integer>> brokerPlatforms = new HashMap<>();
        Map<Integer, List<BrokerAccessEntry>> brokers = new HashMap<>();
        for (BrokerAccessEntry accessEntry : brokerAccessEntryPage.getPage()) {
            int brokerId = accessEntry.getBrokerId();
            List<BrokerAccessEntry> list = brokers.get(brokerId);
            if (list == null) {
                list = new ArrayList<>();
                brokers.put(brokerId, list);
            }
            list.add(accessEntry);

            BrokerPlatform brokerPlatform = accessEntry.getPlatform();
            Set<Integer> set = brokerPlatforms.get(brokerPlatform);
            if (set == null) {
                set = new HashSet<>();
                brokerPlatforms.put(brokerPlatform, set);
            }
            set.add(brokerId);
        }

        Map<BrokerPlatform, List<Integer>> sortedBrokerPlatformListMap = new HashMap<>();
        for (BrokerPlatform brokerPlatform : brokerPlatforms.keySet()) {
            Set<Integer> brokerIds = brokerPlatforms.get(brokerPlatform);
            List<Integer> sortedBrokerIds = sortedBrokerPlatformListMap.get(brokerPlatform);
            if (sortedBrokerIds == null) {
                sortedBrokerIds = new ArrayList<>();
                sortedBrokerPlatformListMap.put(brokerPlatform, sortedBrokerIds);
            }
            for (BrokerEntry entry : brokerEntryPage.getPage()){
                if (brokerIds.contains(entry.getBrokerId())){
                    sortedBrokerIds.add(entry.getBrokerId());
                }
            }
        }

        TreeNode rootNode = new TreeNode();
        rootNode.setValue("root");
        rootNode.setLabel("Root");

        List<TreeNode> platformNodes = new ArrayList<>();
        for (BrokerPlatform brokerPlatform : sortedBrokerPlatformListMap.keySet()) {
            TreeNode platformNode = new TreeNode();
            platformNode.setValue(BeanMapping.map2TechPlatform(brokerPlatform).name());
            platformNode.setLabel(BeanMapping.map2TechPlatform(brokerPlatform).name());

            List<Integer> brokerIds = sortedBrokerPlatformListMap.get(brokerPlatform);

            List<TreeNode> brokerNodes = new ArrayList<>();
            for (int brokerId : brokerIds) {
                TreeNode brokerNode = new TreeNode();
                BrokerEntry brokerEntry = brokerEntries.get(brokerId);
                if (brokerEntry == null) {
                    continue;
                }
                brokerNode.setValue(String.valueOf(brokerEntry.getBrokerId()));
                brokerNode.setLabel(brokerEntry.getCnName());
                List<BrokerAccessEntry> list = brokers.get(brokerId);

                List<TreeNode> brokerAccessNodes = new ArrayList<>();
                for (BrokerAccessEntry accessEntry : list) {
                    AppLog.d("access entry: " + accessEntry);
                    if (brokerPlatform.equals(accessEntry.getPlatform())) {
                        TreeNode brokerAccessNode = new TreeNode();
                        brokerAccessNode.setValue(String.valueOf(accessEntry.getEntryId()));
                        brokerAccessNode.setLabel(accessEntry.getAccessName());
                        brokerAccessNodes.add(brokerAccessNode);
                    }
                }

                if (brokerAccessNodes.size() > 0) {
                    brokerNode.setChildren(brokerAccessNodes);
                    brokerNodes.add(brokerNode);
                }
            }

            if (brokerNodes.size() > 0) {
                platformNode.setChildren(brokerNodes);
                platformNodes.add(platformNode);
            }
        }
        rootNode.setChildren(platformNodes);

        Tree tree = new Tree();
        tree.setName("CommodityTree");
        tree.setTreeJson(new Gson().toJson(rootNode));

        return tree;
    }
}
