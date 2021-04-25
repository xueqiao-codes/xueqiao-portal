package xueqiao.trade.admin.web.api.quotation;

import org.apache.thrift.TException;
import org.soldier.platform.page.IndexedPageOption;
import org.soldier.platform.svr_platform.comm.ErrorInfo;
import xueqiao.quotation.account.thriftapi.*;

public interface IQuotationAccountApi {

    ContractActiveRulePage reqContractActiveRule(ReqContractActiveRuleOption option, IndexedPageOption pageOption) throws TException;

    void updateContractActiveRule(ContractActiveRule activeRule) throws TException;

    void addContractActiveRule(ContractActiveRule activeRule) throws TException;

    void deleteContractActiveRule(int sledCommodityId) throws TException;


    ContractRegisterRulePage reqContractRegisterRule(ReqContractRegisterRuleOption option, org.soldier.platform.page.IndexedPageOption pageOption) throws TException;

    void addContractRegisterRule(ContractRegisterRule rule) throws TException;

    void updateContractRegisterRule(ContractRegisterRule rule) throws TException;

    void deleteContractRegisterRule(int sledCommodityId, QuotationPlatformEnv platformEnv) throws TException;


    QuotationAccountPage reqQuotationAccount(ReqQuotationAccountOption option, org.soldier.platform.page.IndexedPageOption pageOption) throws TException;

    QuotationAccountPage reqQuotationAccountFull(ReqQuotationAccountOption option) throws TException;

    long addQuotationAccount(QuotationAccount account) throws TException;

    void updateQuotationAccount(QuotationAccount account) throws TException;

    void deleteQuotationAccount(long accountId) throws TException;


    AccountCommodityRegisterAbilityPage reqAccountCommodityRegisterAbility(ReqAccountCommodityRegisterAbilityOption option, IndexedPageOption pageOption) throws TException;

    void addAccountCommodityRegisterAbility(AccountCommodityRegisterAbility ability) throws TException;

    void deleteAccountCommodityRegisterAbility(long accountId, int sledCommodityId) throws TException;

    QuotationAccountSubscribePage reqQuotationAccountSubscribe(ReqQuotationAccountSubscribeOption option, IndexedPageOption pageOption) throws TException;
}

