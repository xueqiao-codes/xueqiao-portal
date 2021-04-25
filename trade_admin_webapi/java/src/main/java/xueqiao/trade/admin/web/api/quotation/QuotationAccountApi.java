package xueqiao.trade.admin.web.api.quotation;

import org.apache.thrift.TException;
import org.soldier.platform.page.IndexedPageOption;
import xueqiao.quotation.account.thriftapi.*;
import xueqiao.quotation.account.thriftapi.client.QuotationAccountDaoStub;

public class QuotationAccountApi implements IQuotationAccountApi {

    private IndexedPageOption fullPage = new IndexedPageOption().setNeedTotalCount(true).setPageIndex(0).setPageSize(Integer.MAX_VALUE);

    @Override
    public ContractActiveRulePage reqContractActiveRule(ReqContractActiveRuleOption option, IndexedPageOption pageOption) throws TException {

        return new QuotationAccountDaoStub().reqContractActiveRule(option, pageOption);
    }

    @Override
    public void updateContractActiveRule(ContractActiveRule activeRule) throws TException {
        new QuotationAccountDaoStub().updateContractActiveRule(activeRule);
    }

    @Override
    public void addContractActiveRule(ContractActiveRule activeRule) throws TException {
        new QuotationAccountDaoStub().addContractActiveRule(activeRule);
    }

    @Override
    public void deleteContractActiveRule(int sledCommodityId) throws TException {
        new QuotationAccountDaoStub().removeContractActiveRule(sledCommodityId);
    }

    @Override
    public ContractRegisterRulePage reqContractRegisterRule(ReqContractRegisterRuleOption option, IndexedPageOption pageOption) throws TException {
        return new QuotationAccountDaoStub().reqContractRegisterRule(option, pageOption);
    }

    @Override
    public void addContractRegisterRule(ContractRegisterRule rule) throws TException {
        new QuotationAccountDaoStub().addContractRegisterRule(rule);
    }

    @Override
    public void updateContractRegisterRule(ContractRegisterRule rule) throws TException {
        new QuotationAccountDaoStub().updateContractRegisterRule(rule);
    }

    @Override
    public void deleteContractRegisterRule(int sledCommodityId, QuotationPlatformEnv platformEnv) throws TException {
        new QuotationAccountDaoStub().removeContractRegisterRule(sledCommodityId, platformEnv);
    }

    @Override
    public QuotationAccountPage reqQuotationAccount(ReqQuotationAccountOption option, IndexedPageOption pageOption) throws TException {
        return new QuotationAccountDaoStub().reqQuotationAccount(option, pageOption);
    }

    @Override
    public QuotationAccountPage reqQuotationAccountFull(ReqQuotationAccountOption option) throws TException {
        return reqQuotationAccount(option, fullPage);
    }

    @Override
    public long addQuotationAccount(QuotationAccount account) throws TException {
        return new QuotationAccountDaoStub().addQuotationAccount(account);
    }

    @Override
    public void updateQuotationAccount(QuotationAccount account) throws TException {
        new QuotationAccountDaoStub().updateQuotationAccount(account);
    }

    @Override
    public void deleteQuotationAccount(long accountId) throws TException {
        new QuotationAccountDaoStub().removeQuotationAccount(accountId);
    }

    @Override
    public AccountCommodityRegisterAbilityPage reqAccountCommodityRegisterAbility(ReqAccountCommodityRegisterAbilityOption option, IndexedPageOption pageOption) throws TException {
        return new QuotationAccountDaoStub().reqAccountCommodityRegisterAbility(option, pageOption);
    }

    @Override
    public void addAccountCommodityRegisterAbility(AccountCommodityRegisterAbility ability) throws TException {
        new QuotationAccountDaoStub().addAccountCommodityRegisterAbility(ability);
    }

    @Override
    public void deleteAccountCommodityRegisterAbility(long accountId, int sledCommodityId) throws TException {
        new QuotationAccountDaoStub().removeAccountCommodityRegisterAbility(accountId, sledCommodityId);
    }

    @Override
    public QuotationAccountSubscribePage reqQuotationAccountSubscribe(ReqQuotationAccountSubscribeOption option, IndexedPageOption pageOption) throws TException {
        return new QuotationAccountDaoStub().reqQuotationAccountSubscribe(option, pageOption);
    }
}
