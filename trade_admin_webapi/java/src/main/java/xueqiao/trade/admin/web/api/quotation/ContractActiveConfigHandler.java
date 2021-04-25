package xueqiao.trade.admin.web.api.quotation;

import com.longsheng.xueqiao.contract.standard.thriftapi.*;
import org.apache.thrift.TException;
import org.soldier.platform.page.IndexedPageOption;
import xueqiao.quotation.account.thriftapi.ContractActiveRule;
import xueqiao.quotation.account.thriftapi.ContractActiveRulePage;
import xueqiao.quotation.account.thriftapi.ReqContractActiveRuleOption;
import xueqiao.trade.admin.web.api.contract.ContractApiFactory;
import xueqiao.trade.admin.web.api.contract.IContractApi;
import xueqiao.trade.admin.web.api.thriftapi.CommodityActiveConfig;
import xueqiao.trade.admin.web.api.thriftapi.CommodityActiveConfigPage;
import xueqiao.trade.admin.web.api.thriftapi.ReqCommodityActiveConfigOption;

import java.util.*;

public class ContractActiveConfigHandler {

    public CommodityActiveConfigPage reqCommodityActiveConfig(ReqCommodityActiveConfigOption option, IndexedPageOption pageOption) throws TException {

        pageOption.setNeedTotalCount(true);
        IQuotationAccountApi iQuotationAccountApi = QuotationAccountApiFactory.getInstance().getDefault();
        IContractApi iContractApi = ContractApiFactory.getInstance().getDefault();

        ReqContractActiveRuleOption ruleOption = new ReqContractActiveRuleOption();

        Map<Integer, SledCommodity> sledCommodityMap = new HashMap<>();
        if (option.isSetCommodityNamePartical()) {
            ReqSledCommodityOption commodityOption = new ReqSledCommodityOption();
            commodityOption.setCnNamePartical(option.getCommodityNamePartical());
            commodityOption.setEngNamePartical(option.getCommodityNamePartical());
            SledCommodityPage page = iContractApi.reqCommodityFull(commodityOption);

            for (SledCommodity sledCommodity : page.getPage()) {
                sledCommodityMap.put(sledCommodity.getSledCommodityId(), sledCommodity);
            }

            if (sledCommodityMap.size() > 0) {
                ruleOption.setCommodityIds(sledCommodityMap.keySet());
            }
        }

        ContractActiveRulePage page = iQuotationAccountApi.reqContractActiveRule(ruleOption, pageOption);
        CommodityActiveConfigPage configPage = new CommodityActiveConfigPage();

        List<CommodityActiveConfig> list = new ArrayList<>();
        if (page.getTotal() > 0) {
            Map<String, SledExchange> exchangeMap = new HashMap<>();
            ReqSledExchangeOption exchangeOption = new ReqSledExchangeOption();
            SledExchangePage exchangePage = iContractApi.reqExchangeFull(exchangeOption);
            for (SledExchange exchange : exchangePage.getPage()) {
                exchangeMap.put(exchange.getExchangeMic(), exchange);
            }
            for (ContractActiveRule rule : page.getPage()) {
                CommodityActiveConfig commodityActiveConfig = new CommodityActiveConfig();
                commodityActiveConfig.setSledCommodityId(rule.getSledCommodityId());

                for (Integer month : rule.getActiveMonthMap().keySet()) {
                    if (rule.getActiveMonthMap().get(month)) {
                        commodityActiveConfig.addToActiveMonths(month);
                    }
                }

                SledCommodity sledCommodity = sledCommodityMap.get(rule.getSledCommodityId());
                commodityActiveConfig.setCommodityName(sledCommodity.getCnName());
                commodityActiveConfig.setExchangeName(exchangeMap.get(sledCommodity.getExchangeMic()).getCnName());
                list.add(commodityActiveConfig);
            }
        }
        configPage.setTotal(page.getTotal());
        configPage.setPage(list);
        return configPage;
    }

    public CommodityActiveConfig getConfig(int sledCommodityId) {
        return null;
    }

    public CommodityActiveConfig updateCommodityActiveConfig(CommodityActiveConfig activeConfig) throws TException {

        IQuotationAccountApi iQuotationAccountApi = QuotationAccountApiFactory.getInstance().getDefault();
        ContractActiveRule activeRule = map2ContractActiveRule(activeConfig);
        iQuotationAccountApi.updateContractActiveRule(activeRule);

        return getConfig(activeConfig.getSledCommodityId());
    }

    private ContractActiveRule map2ContractActiveRule(CommodityActiveConfig activeConfig) {
        ContractActiveRule activeRule = new ContractActiveRule();
        activeRule.setSledCommodityId(activeConfig.getSledCommodityId());
        Map<Integer, Boolean> map = new HashMap<>();
        for (int i = 1; i < 13; i++) {
            if (activeConfig.getActiveMonths() != null) {
                if (activeConfig.getActiveMonths().contains(i)) {
                    map.put(i, true);
                    continue;
                }
            }
            map.put(i, false);
        }
        activeRule.setActiveMonthMap(map);
        return activeRule;
    }

    public CommodityActiveConfig addCommodityActiveConfig(CommodityActiveConfig activeConfig) throws TException {
        IQuotationAccountApi iQuotationAccountApi = QuotationAccountApiFactory.getInstance().getDefault();
        ContractActiveRule activeRule = map2ContractActiveRule(activeConfig);
        iQuotationAccountApi.addContractActiveRule(activeRule);

        return getConfig(activeConfig.getSledCommodityId());
    }


    public void deleteCommodityActiveConfig(int sledCommodityId) throws TException {

        IQuotationAccountApi iQuotationAccountApi = QuotationAccountApiFactory.getInstance().getDefault();
        iQuotationAccountApi.deleteContractActiveRule(sledCommodityId);
    }
}
