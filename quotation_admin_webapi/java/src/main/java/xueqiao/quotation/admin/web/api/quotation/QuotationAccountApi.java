package xueqiao.quotation.admin.web.api.quotation;

import org.apache.thrift.TException;
import org.soldier.platform.page.IndexedPageOption;
import xueqiao.quotation.account.thriftapi.*;
import xueqiao.quotation.account.thriftapi.client.QuotationAccountDaoStub;
import xueqiao.quotation.plan.bo.GenPreviewState;
import xueqiao.quotation.plan.bo.QuerySubscribeContractItemOption;
import xueqiao.quotation.plan.bo.SubscribeCommodityClass;
import xueqiao.quotation.plan.bo.SubscribeContractItemPage;
import xueqiao.quotation.plan.bo.client.QuotationPlanBoStub;

import java.util.List;

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
    public void deleteContractActiveRule(int sledCommodityId, ContractActiveType activeType, String fixedCode) throws TException {
        new QuotationAccountDaoStub().removeContractActiveRule(sledCommodityId, activeType, fixedCode);
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
    public void deleteContractRegisterRule(int sledCommodityId, QuotationPlatformEnv platformEnv, ContractActiveType activeType, String fixedCode) throws TException {
        new QuotationAccountDaoStub().removeContractRegisterRule(sledCommodityId, platformEnv, activeType, fixedCode);
    }

    @Override
    public void setContractRegisterRuleOrderIndex(int sledCommodityId, QuotationPlatformEnv platformEnv, int orderIndex, ContractActiveType activeType, String fixedCode) throws TException {
        new QuotationAccountDaoStub().setCommodityRegisterOrderIndex(sledCommodityId, platformEnv, orderIndex, activeType, fixedCode);
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
    public void batAddAccountCommodityRegisterAbility(List<AccountCommodityRegisterAbility> abilities) throws TException {
        new QuotationAccountDaoStub().batAddAccountCommodityRegisterAbility(abilities);
    }

    @Override
    public void deleteAccountCommodityRegisterAbility(long abilityId) throws TException {
        new QuotationAccountDaoStub().removeAccountCommodityRegisterAbility(abilityId);
    }

    @Override
    public void deleteAccountRegisterAbilityByExchange(long accountId, int sledExchangeId) throws TException {
        new QuotationAccountDaoStub().removeAccountCommodityRegisterAbilities(accountId, sledExchangeId);
    }

    @Override
    public GenPreviewState startGenPreviewSCClasses() throws TException {
        return new QuotationPlanBoStub().startGenPreviewSCClasses();
    }

    @Override
    public GenPreviewState getGenPreviewState() throws TException {
        return new QuotationPlanBoStub().getGenPreviewState();
    }

    @Override
    public void commitPreviewSCClasses() throws TException {
        new QuotationPlanBoStub().commitPreviewSCClasses();
    }

    @Override
    public SubscribeContractItemPage querySubscribeContractItemPage(QuerySubscribeContractItemOption option, IndexedPageOption pageOption) throws TException {
        return new QuotationPlanBoStub().querySubscribeContractItemPage(option, pageOption);
    }

    @Override
    public List<SubscribeCommodityClass> getPreviewSCClasses() throws TException {
        return new QuotationPlanBoStub().getPreviewSCClasses();
    }

    @Override
    public List<SubscribeCommodityClass> getCurrentSCClasses() throws TException {
        return new QuotationPlanBoStub().getCurrentSCClasses();
    }
}
