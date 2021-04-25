package xueqiao.quotation.admin.web.api.quotation;

import com.antiy.error_code.ErrorCodeOuter;
import com.longsheng.xueqiao.contract.standard.thriftapi.*;
import org.apache.thrift.TException;
import org.soldier.platform.page.IndexedPageOption;
import org.soldier.platform.svr_platform.comm.ErrorInfo;
import xueqiao.quotation.account.thriftapi.*;
import xueqiao.quotation.admin.web.api.contract.ContractApiFactory;
import xueqiao.quotation.admin.web.api.contract.IContractApi;
import xueqiao.quotation.admin.web.api.thriftapi.CommodityRegister;
import xueqiao.quotation.admin.web.api.thriftapi.CommodityRegisterPage;
import xueqiao.quotation.admin.web.api.thriftapi.ReqCommodityRegisterOption;
import xueqiao.quotation.admin.web.api.utils.BeanMapping;


import java.util.HashMap;
import java.util.Map;

public class CommodityRegisterHandler {

    public CommodityRegisterPage reqCommodityRegister(ReqCommodityRegisterOption option,
                                                      IndexedPageOption pageOption) throws TException {

        IQuotationAccountApi iQuotationAccountApi = QuotationAccountApiFactory.getInstance()
                .getDefault();
        IContractApi iContractApi = ContractApiFactory.getInstance().getDefault();

        ReqContractRegisterRuleOption ruleOption = new ReqContractRegisterRuleOption();
        Map<Integer, SledCommodity> sledCommodityMap = new HashMap<>();
        if (option != null) {
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
            if (option.isSetPlatformEnv()) {
                ruleOption.setPlatformEnv(BeanMapping.map2QuoPlatformEnv(option.getPlatformEnv()));
            }
        }

        ContractRegisterRulePage page = iQuotationAccountApi
                .reqContractRegisterRule(ruleOption, pageOption);
        CommodityRegisterPage registerPage = new CommodityRegisterPage();
        registerPage.setTotal(page.getTotal());

        if (page.getPageSize() > 0) {
            Map<String, SledExchange> exchangeMap = new HashMap<>();
            ReqSledExchangeOption exchangeOption = new ReqSledExchangeOption();
            SledExchangePage exchangePage = iContractApi.reqExchangeFull(exchangeOption);
            for (SledExchange exchange : exchangePage.getPage()) {
                exchangeMap.put(exchange.getExchangeMic(), exchange);
            }
            if (sledCommodityMap.size() == 0) {
                ReqSledCommodityOption reqCommodityOption = new ReqSledCommodityOption();
                for (ContractRegisterRule rule : page.getPage()) {
                    reqCommodityOption.addToSledCommodityIdList(rule.getSledCommodityId());
                }
                SledCommodityPage commodityPage = iContractApi.reqCommodityFull(reqCommodityOption);
                for (SledCommodity sledCommodity : commodityPage.getPage()) {
                    sledCommodityMap.put(sledCommodity.getSledCommodityId(), sledCommodity);
                }
            }

            for (ContractRegisterRule rule : page.getPage()) {
                SledCommodity sledCommodity = sledCommodityMap.get(rule.getSledCommodityId());
                if (sledCommodity == null) {
                    continue;
                }

                CommodityRegister register = new CommodityRegister();
                register.setSledCommodityId(rule.getSledCommodityId());
                register.setCommodityName(sledCommodity.getCnName());
                register.setExchangeName(exchangeMap.get(sledCommodity.getExchangeMic()).getCnName());
                register.setRegisterPriority(rule.getRegisterPriority());
                register.setActiveShowCount(rule.getActiveShowCount());
                register.setInactiveShowCount(rule.getInactiveShowCount());
                register.setPlatformEnv(BeanMapping.map2PlatformEnv(rule.getPlatformEnv()));
                register.setOrderIndex(rule.getOrderIndex());
                register.setFixedCode(rule.getFixedCode());
                register.setActiveType(rule.getActiveType());

                registerPage.addToPage(register);
            }
        }

        return registerPage;
    }


    public CommodityRegister updateCommodityRegister(CommodityRegister commodityRegister)
            throws TException {
        check(commodityRegister);
        IQuotationAccountApi iQuotationAccountApi = QuotationAccountApiFactory.getInstance()
                .getDefault();
        ContractRegisterRule registerRule = map2ContractRegisterRule(commodityRegister);
        iQuotationAccountApi.updateContractRegisterRule(registerRule);
        return getCommodityRegister(registerRule.getSledCommodityId(), registerRule.getPlatformEnv());
    }

    private CommodityRegister getCommodityRegister(int sledCommodityId,
                                                   QuotationPlatformEnv platformEnv) throws TException {

        IContractApi iContractApi = ContractApiFactory.getInstance().getDefault();
        ReqSledCommodityOption commodityOption = new ReqSledCommodityOption();
        commodityOption.addToSledCommodityIdList(sledCommodityId);
        commodityOption.setPlatformEnv(BeanMapping.map2PlatformEnv(platformEnv));
        SledCommodityPage page = iContractApi.reqCommodityFull(commodityOption);
        if (page.getPageSize() <= 0) {
            throw new ErrorInfo(ErrorCodeOuter.PARAM_ERROR.getErrorCode(), "Sled commodity not found.");
        }

        SledCommodity sledCommodity = page.getPage().get(0);

        IQuotationAccountApi iQuotationAccountApi = QuotationAccountApiFactory.getInstance()
                .getDefault();
        ReqContractRegisterRuleOption ruleOption = new ReqContractRegisterRuleOption();
        ruleOption.addToCommodityIds(sledCommodityId);
        ruleOption.setPlatformEnv(platformEnv);
        ContractRegisterRulePage rulePage = iQuotationAccountApi
                .reqContractRegisterRule(ruleOption, null);
        if (rulePage.getPageSize() <= 0) {
            throw new ErrorInfo(ErrorCodeOuter.PARAM_ERROR.getErrorCode(), "Record not found.");
        }
        ReqSledExchangeOption exchangeOption = new ReqSledExchangeOption();
        exchangeOption.setExchangeMic(sledCommodity.getExchangeMic());
        SledExchangePage exchangePage = iContractApi.reqExchangeFull(exchangeOption);
        SledExchange sledExchange = exchangePage.getPage().get(0);

        CommodityRegister register = new CommodityRegister();
        register.setSledCommodityId(sledCommodityId);
        register.setCommodityName(sledCommodity.getCnName());
        register.setExchangeName(sledExchange.getCnName());
        ContractRegisterRule rule = rulePage.getPage().get(0);
        register.setRegisterPriority(rule.getRegisterPriority());
        register.setActiveShowCount(rule.getActiveShowCount());
        register.setInactiveShowCount(rule.getInactiveShowCount());
        register.setPlatformEnv(BeanMapping.map2PlatformEnv(rule.getPlatformEnv()));
        register.setActiveType(rule.getActiveType());
        register.setFixedCode(rule.getFixedCode());
        return register;
    }


    public CommodityRegister addCommodityRegister(CommodityRegister commodityRegister)
            throws TException {
        check(commodityRegister);

        IQuotationAccountApi iQuotationAccountApi = QuotationAccountApiFactory.getInstance()
                .getDefault();
        ContractRegisterRule registerRule = map2ContractRegisterRule(commodityRegister);
        iQuotationAccountApi.addContractRegisterRule(registerRule);
        return getCommodityRegister(registerRule.getSledCommodityId(), registerRule.getPlatformEnv());
    }

    private void check(CommodityRegister commodityRegister) throws ErrorInfo {
        if (!commodityRegister.isSetSledCommodityId()) {
            throw new ErrorInfo(ErrorCodeOuter.PARAM_ERROR.getErrorCode(), "Sled commodity id must set.");
        }
        if (!commodityRegister.isSetPlatformEnv()) {
            throw new ErrorInfo(ErrorCodeOuter.PARAM_ERROR.getErrorCode(), "PlatformEnv must set.");
        }
    }

    private ContractRegisterRule map2ContractRegisterRule(CommodityRegister commodityRegister) {
        ContractRegisterRule registerRule = new ContractRegisterRule();
        if (commodityRegister.isSetSledCommodityId()) {
            registerRule.setSledCommodityId(commodityRegister.getSledCommodityId());
        }
        if (commodityRegister.isSetPlatformEnv()) {
            registerRule
                    .setPlatformEnv(BeanMapping.map2QuoPlatformEnv(commodityRegister.getPlatformEnv()));
        }
        if (commodityRegister.isSetActiveShowCount()) {
            registerRule.setActiveShowCount(commodityRegister.getActiveShowCount());
        }
        if (commodityRegister.isSetInactiveShowCount()) {
            registerRule.setInactiveShowCount(commodityRegister.getInactiveShowCount());
        }
        if (commodityRegister.isSetRegisterPriority()) {
            registerRule.setRegisterPriority(commodityRegister.getRegisterPriority());
        }
        if (commodityRegister.isSetActiveType()) {
            registerRule.setActiveType(commodityRegister.getActiveType());
        }
        if (commodityRegister.isSetFixedCode()) {
            registerRule.setFixedCode(commodityRegister.getFixedCode());
        }
        return registerRule;
    }

    public void deleteCommodityRegister(int sledCommodityId, TechPlatformEnv platformEnv, ContractActiveType activeType, String fixedCode) throws TException {
        IQuotationAccountApi iQuotationAccountApi = QuotationAccountApiFactory.getInstance().getDefault();
        iQuotationAccountApi.deleteContractRegisterRule(sledCommodityId, BeanMapping.map2QuoPlatformEnv(platformEnv), activeType, fixedCode);
    }

    public void setOrderIndex(int sledCommodityId, TechPlatformEnv platformEnv, int orderIndex, ContractActiveType activeType, String fixedCode) throws TException {
        IQuotationAccountApi iQuotationAccountApi = QuotationAccountApiFactory.getInstance().getDefault();
        iQuotationAccountApi.setContractRegisterRuleOrderIndex(sledCommodityId, BeanMapping.map2QuoPlatformEnv(platformEnv), orderIndex, activeType, fixedCode);
    }

}
