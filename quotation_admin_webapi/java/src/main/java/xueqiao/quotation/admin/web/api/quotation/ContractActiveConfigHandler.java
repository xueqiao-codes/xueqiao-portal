package xueqiao.quotation.admin.web.api.quotation;

import com.antiy.error_code.ErrorCodeOuter;
import com.longsheng.xueqiao.contract.standard.thriftapi.*;
import org.apache.thrift.TException;
import org.soldier.platform.page.IndexedPageOption;
import org.soldier.platform.svr_platform.comm.ErrorInfo;
import xueqiao.quotation.account.thriftapi.*;
import xueqiao.quotation.admin.web.api.contract.ContractApiFactory;
import xueqiao.quotation.admin.web.api.contract.IContractApi;
import xueqiao.quotation.admin.web.api.thriftapi.CommodityActiveConfig;
import xueqiao.quotation.admin.web.api.thriftapi.CommodityActiveConfigPage;
import xueqiao.quotation.admin.web.api.thriftapi.ReqCommodityActiveConfigOption;

import java.util.*;

public class ContractActiveConfigHandler {

    IndexedPageOption fullPage = new IndexedPageOption().setNeedTotalCount(true).setPageIndex(0).setPageSize(Integer.MAX_VALUE);

    public CommodityActiveConfigPage reqCommodityActiveConfig(ReqCommodityActiveConfigOption option, IndexedPageOption pageOption) throws TException {

        if (pageOption == null) {
            pageOption = fullPage;
        }

        IQuotationAccountApi iQuotationAccountApi = QuotationAccountApiFactory.getInstance().getDefault();
        IContractApi iContractApi = ContractApiFactory.getInstance().getDefault();

        ReqContractActiveRuleOption ruleOption = new ReqContractActiveRuleOption();

        Map<Integer, SledCommodity> sledCommodityMap = new HashMap<>();

        if (option.isSetCommodityNamePartical()) {
            ReqSledCommodityOption commodityOption = new ReqSledCommodityOption();
            commodityOption.setCnNamePartical(option.getCommodityNamePartical());
            commodityOption.setEngNamePartical(option.getCommodityNamePartical());
            commodityOption.setSledCommodityCodePartical(option.getCommodityNamePartical());
            SledCommodityPage page = iContractApi.reqCommodityFull(commodityOption);

            for (SledCommodity sledCommodity : page.getPage()) {
                sledCommodityMap.put(sledCommodity.getSledCommodityId(), sledCommodity);
            }

            if (sledCommodityMap.size() > 0) {
                ruleOption.setCommodityIds(sledCommodityMap.keySet());
            }
        }
        if (option.isSetCommodityId()) {
            ruleOption.addToCommodityIds(option.getCommodityId());
        }

        ContractActiveRulePage page = iQuotationAccountApi.reqContractActiveRule(ruleOption, pageOption);
        CommodityActiveConfigPage configPage = new CommodityActiveConfigPage();

        List<CommodityActiveConfig> list = new ArrayList<>();
        if (page.getPageSize() > 0) {
            if (sledCommodityMap.size() == 0) {
                Set<Integer> sledCommodityIds = new HashSet<>();
                for (ContractActiveRule rule : page.getPage()) {
                    sledCommodityIds.add(rule.getSledCommodityId());
                }
                ReqSledCommodityOption commodityOption = new ReqSledCommodityOption();
                SledCommodityPage commodityPage = iContractApi.reqCommodityFull(commodityOption);

                for (SledCommodity sledCommodity : commodityPage.getPage()) {
                    sledCommodityMap.put(sledCommodity.getSledCommodityId(), sledCommodity);
                }
            }

            Map<String, SledExchange> exchangeMap = new HashMap<>();
            ReqSledExchangeOption exchangeOption = new ReqSledExchangeOption();
            SledExchangePage exchangePage = iContractApi.reqExchangeFull(exchangeOption);
            for (SledExchange exchange : exchangePage.getPage()) {
                exchangeMap.put(exchange.getExchangeMic(), exchange);
            }
            for (ContractActiveRule rule : page.getPage()) {
                CommodityActiveConfig commodityActiveConfig = new CommodityActiveConfig();
                commodityActiveConfig.setSledCommodityId(rule.getSledCommodityId());

                if (rule.getActiveMonthMapSize() > 0) {
                    for (Integer month : rule.getActiveMonthMap().keySet()) {
                        if (rule.getActiveMonthMap().get(month)) {
                            commodityActiveConfig.addToActiveMonths(month);
                        }
                    }
                }

                SledCommodity sledCommodity = sledCommodityMap.get(rule.getSledCommodityId());
                commodityActiveConfig.setCommodityName(sledCommodity.getCnName());
                commodityActiveConfig.setExchangeName(exchangeMap.get(sledCommodity.getExchangeMic()).getCnName());
                commodityActiveConfig.setActiveType(rule.getActiveType());
                commodityActiveConfig.setFixedCode(rule.getFixedCode());
                if (option.isSetActiveType()) {
                    if (rule.getActiveType().equals(option.getActiveType())) {
                        list.add(commodityActiveConfig);
                    }
                } else {
                    list.add(commodityActiveConfig);
                }
            }
        }
        configPage.setTotal(page.getTotal());
        configPage.setPage(list);
        return configPage;
    }

    public CommodityActiveConfig getConfig(int sledCommodityId) throws TException {
        IQuotationAccountApi iQuotationAccountApi = QuotationAccountApiFactory.getInstance().getDefault();
        IContractApi iContractApi = ContractApiFactory.getInstance().getDefault();

        ReqContractActiveRuleOption ruleOption = new ReqContractActiveRuleOption();
        ruleOption.addToCommodityIds(sledCommodityId);
        ContractActiveRulePage rulePage = iQuotationAccountApi.reqContractActiveRule(ruleOption, new IndexedPageOption());

        ReqSledCommodityOption commodityOption = new ReqSledCommodityOption();
        commodityOption.addToSledCommodityIdList(sledCommodityId);
        SledCommodityPage page = iContractApi.reqCommodityFull(commodityOption);

        Map<Integer, SledCommodity> sledCommodityMap = new HashMap<>();
        for (SledCommodity sledCommodity : page.getPage()) {
            sledCommodityMap.put(sledCommodity.getSledCommodityId(), sledCommodity);
        }

        if (rulePage.getPageSize() > 0) {
            Map<String, SledExchange> exchangeMap = new HashMap<>();
            ReqSledExchangeOption exchangeOption = new ReqSledExchangeOption();
            SledExchangePage exchangePage = iContractApi.reqExchangeFull(exchangeOption);
            for (SledExchange exchange : exchangePage.getPage()) {
                exchangeMap.put(exchange.getExchangeMic(), exchange);
            }
            ContractActiveRule rule = rulePage.getPage().get(0);
            CommodityActiveConfig commodityActiveConfig = new CommodityActiveConfig();
            commodityActiveConfig.setSledCommodityId(rule.getSledCommodityId());

            if (rule.getActiveMonthMapSize() > 0) {
                for (Integer month : rule.getActiveMonthMap().keySet()) {
                    if (rule.getActiveMonthMap().get(month)) {
                        commodityActiveConfig.addToActiveMonths(month);
                    }
                }
            }

            SledCommodity sledCommodity = sledCommodityMap.get(rule.getSledCommodityId());
            commodityActiveConfig.setCommodityName(sledCommodity.getCnName());
            commodityActiveConfig.setExchangeName(exchangeMap.get(sledCommodity.getExchangeMic()).getCnName());
            commodityActiveConfig.setActiveType(rule.getActiveType());
            commodityActiveConfig.setFixedCode(rule.getFixedCode());
            return commodityActiveConfig;
        } else {
            throw new ErrorInfo(ErrorCodeOuter.PARAM_ERROR.getErrorCode(), "Record not found.");
        }
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
        if (activeConfig.isSetActiveMonths()) {
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
        }
        if (activeConfig.isSetActiveType()) {
            activeRule.setActiveType(activeConfig.getActiveType());
        }
        if (activeConfig.isSetFixedCode()) {
            activeRule.setFixedCode(activeConfig.getFixedCode());
        }
        return activeRule;
    }

    public CommodityActiveConfig addCommodityActiveConfig(CommodityActiveConfig activeConfig) throws TException {
        IQuotationAccountApi iQuotationAccountApi = QuotationAccountApiFactory.getInstance().getDefault();
        ContractActiveRule activeRule = map2ContractActiveRule(activeConfig);
        iQuotationAccountApi.addContractActiveRule(activeRule);

        return getConfig(activeConfig.getSledCommodityId());
    }


    public void deleteCommodityActiveConfig(int sledCommodityId, ContractActiveType activeType, String fixedCode) throws TException {

        if (fixedCode == null) {
            fixedCode = "";
        }

        IQuotationAccountApi iQuotationAccountApi = QuotationAccountApiFactory.getInstance().getDefault();
        ReqContractRegisterRuleOption option = new ReqContractRegisterRuleOption();
        option.addToCommodityIds(sledCommodityId);
        ContractRegisterRulePage registerRulePage = iQuotationAccountApi.reqContractRegisterRule(option, fullPage);
        if (registerRulePage.getPageSize() > 0) {
            for (ContractRegisterRule rule : registerRulePage.getPage()) {
                if (rule.getActiveType().equals(activeType) && fixedCode.equals(rule.getFixedCode())) {
                    throw new ErrorInfo(ErrorCodeOuter.PARAM_ERROR.getErrorCode(), "Can not remove active rule when register rule exists.");
                }
            }
        }
        iQuotationAccountApi.deleteContractActiveRule(sledCommodityId, activeType, fixedCode);
    }
}
