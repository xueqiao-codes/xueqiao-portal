package xueqiao.quotation.admin.web.api.quotation;

import org.apache.thrift.TException;
import org.soldier.platform.page.IndexedPageOption;
import org.soldier.platform.svr_platform.comm.ErrorInfo;
import xueqiao.quotation.account.thriftapi.*;
import xueqiao.quotation.plan.bo.GenPreviewState;
import xueqiao.quotation.plan.bo.QuerySubscribeContractItemOption;
import xueqiao.quotation.plan.bo.SubscribeCommodityClass;
import xueqiao.quotation.plan.bo.SubscribeContractItemPage;

import java.util.List;

public interface IQuotationAccountApi {

    ContractActiveRulePage reqContractActiveRule(ReqContractActiveRuleOption option, IndexedPageOption pageOption) throws TException;

    void updateContractActiveRule(ContractActiveRule activeRule) throws TException;

    void addContractActiveRule(ContractActiveRule activeRule) throws TException;

    void deleteContractActiveRule(int sledCommodityId, ContractActiveType activeType, String fixedCode) throws TException;


    ContractRegisterRulePage reqContractRegisterRule(ReqContractRegisterRuleOption option, org.soldier.platform.page.IndexedPageOption pageOption) throws TException;

    void addContractRegisterRule(ContractRegisterRule rule) throws TException;

    void updateContractRegisterRule(ContractRegisterRule rule) throws TException;

    void deleteContractRegisterRule(int sledCommodityId, QuotationPlatformEnv platformEnv, ContractActiveType activeType, String fixedCode) throws TException;

    void setContractRegisterRuleOrderIndex(int sledCommodityId, QuotationPlatformEnv platformEnv, int orderIndex,  ContractActiveType activeType, String fixedCode) throws TException;


    QuotationAccountPage reqQuotationAccount(ReqQuotationAccountOption option, org.soldier.platform.page.IndexedPageOption pageOption) throws TException;

    QuotationAccountPage reqQuotationAccountFull(ReqQuotationAccountOption option) throws TException;

    long addQuotationAccount(QuotationAccount account) throws TException;

    void updateQuotationAccount(QuotationAccount account) throws TException;

    void deleteQuotationAccount(long accountId) throws TException;


    AccountCommodityRegisterAbilityPage reqAccountCommodityRegisterAbility(ReqAccountCommodityRegisterAbilityOption option, IndexedPageOption pageOption) throws TException;

    void batAddAccountCommodityRegisterAbility(List<AccountCommodityRegisterAbility> abilities) throws TException;

    void deleteAccountCommodityRegisterAbility(long abilityId) throws TException;

    void deleteAccountRegisterAbilityByExchange(long accountId, int sledExchangeId) throws TException;


    /**
     * ???????????????????????????
     */
    GenPreviewState startGenPreviewSCClasses() throws TException;

    /**
     * ???????????????????????????????????????
     */
    GenPreviewState getGenPreviewState() throws TException;

    /**
     * ???????????????????????????
     */
    void commitPreviewSCClasses() throws TException;

    /**
     * ?????????????????????????????????
     */
    SubscribeContractItemPage querySubscribeContractItemPage(QuerySubscribeContractItemOption option, IndexedPageOption pageOption) throws TException;

    /**
     * ??????????????????????????????
     */
    List<SubscribeCommodityClass> getPreviewSCClasses() throws TException;

    /**
     * ????????????????????????????????????
     */
    List<SubscribeCommodityClass> getCurrentSCClasses() throws TException;
}

