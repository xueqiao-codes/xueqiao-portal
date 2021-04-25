package xueqiao.trade.admin.web.api.quotation;

import com.antiy.error_code.ErrorCodeOuter;
import com.longsheng.xueqiao.broker.dao.thriftapi.BrokerAccessEntryPage;
import com.longsheng.xueqiao.broker.dao.thriftapi.BrokerEntryPage;
import com.longsheng.xueqiao.broker.dao.thriftapi.ReqBrokerAccessEntryOption;
import com.longsheng.xueqiao.broker.dao.thriftapi.ReqBrokerEntryOption;
import com.longsheng.xueqiao.broker.thriftapi.BrokerAccessEntry;
import com.longsheng.xueqiao.broker.thriftapi.BrokerEntry;
import com.longsheng.xueqiao.contract.standard.thriftapi.*;
import org.apache.thrift.TException;
import org.soldier.platform.page.IndexedPageOption;
import org.soldier.platform.svr_platform.comm.ErrorInfo;
import xueqiao.quotation.account.thriftapi.*;
import xueqiao.trade.admin.web.api.broker.BrokerApiFactory;
import xueqiao.trade.admin.web.api.broker.IBrokerApi;
import xueqiao.trade.admin.web.api.contract.ContractApiFactory;
import xueqiao.trade.admin.web.api.contract.IContractApi;
import xueqiao.trade.admin.web.api.thriftapi.*;
import xueqiao.trade.admin.web.api.utils.BeanMapping;

import java.util.*;

public class QuotationAccountHandler {

    IndexedPageOption fullPage = new IndexedPageOption().setNeedTotalCount(true).setPageIndex(0).setPageSize(Integer.MAX_VALUE);

    public QuotationAccountInfoPage reqQuotationAccountInfo(ReqQuotationAccountInfoOption option, IndexedPageOption pageOption) throws TException {

        IQuotationAccountApi accountApi = QuotationAccountApiFactory.getInstance().getDefault();
        QuotationAccountPage accountPage = getQuotationAccountPage(option, pageOption, accountApi);
        QuotationAccountInfoPage page = new QuotationAccountInfoPage().setPage(new ArrayList<>());
        page.setTotal(accountPage.getTotal());
        if (accountPage.getPageSize() > 0) {

            Set<Integer> brokerIds = new HashSet<>();
            Set<Integer> brokerAccessIds = new HashSet<>();

            for (QuotationAccount qa : accountPage.getPage()) {
                QuotationAccountInfo info = new QuotationAccountInfo();
                info.setAccountId(qa.getAccountId());
                info.setAccountName(qa.getAccountName());
                info.setAccountpwd(qa.getAccountpwd());
                info.setNickName(qa.getNickName());
                info.setPlatform(BeanMapping.map2TechPlatform(qa.getPlatform()));
                info.setBrokerId(qa.getBrokerId());
                info.setBrokerAccessId(qa.getBrokerAccessId());
                info.setAccountProperties(qa.getAccountProperties());
                info.setAccountState(qa.getAccountState());
                info.setAccessState(qa.getAccessState());
                info.setInvalidReason(qa.getInvalidReason());
                info.setInvalidErrorCode(qa.getInvalidErrorCode());
                info.setApiRetCode(qa.getApiRetCode());
                info.setMaxRegisterCount(qa.getMaxRegisterCount());
                info.setCreateTimestamp(qa.getCreateTimestamp());
                info.setLastModifyTimestamp(qa.getLastModifyTimestamp());
                info.setPlatformEnv(BeanMapping.map2PlatformEnv(qa.getPlatformEnv()));

                brokerIds.add(qa.getBrokerId());
                brokerAccessIds.add(qa.getBrokerAccessId());

                page.addToPage(info);
            }

            IBrokerApi iBrokerApi = BrokerApiFactory.getInstance().getDefault();
            ReqBrokerEntryOption brokerOption = new ReqBrokerEntryOption();
            for (int id : brokerIds) {
                brokerOption.addToBrokerIds(id);
            }

            BrokerEntryPage brokerPage = iBrokerApi.reqBrokerFull(brokerOption);
            Map<Integer, BrokerEntry> brokerEntries = new HashMap<>();
            for (BrokerEntry brokerEntry : brokerPage.getPage()) {
                brokerEntries.put(brokerEntry.getBrokerId(), brokerEntry);
            }
            ReqBrokerAccessEntryOption brokerAccessOption = new ReqBrokerAccessEntryOption();
            for (int id : brokerAccessIds) {
                brokerAccessOption.addToEntryIds(id);
            }
            BrokerAccessEntryPage brokerAccessPage = iBrokerApi.reqBrokerAccessFull(brokerAccessOption);
            Map<Integer, BrokerAccessEntry> brokerAccessEntries = new HashMap<>();
            for (BrokerAccessEntry entry : brokerAccessPage.getPage()) {
                brokerAccessEntries.put(entry.getBrokerId(), entry);
            }

            for (QuotationAccountInfo info : page.getPage()) {
                info.setBrokerName(brokerEntries.get(info.getBrokerId()).getCnName());
                info.setBrokerAccessName(brokerAccessEntries.get(info.getBrokerAccessId()).getAccessName());
            }
        }

        return page;
    }

    private QuotationAccountPage getQuotationAccountPage(ReqQuotationAccountInfoOption option, IndexedPageOption pageOption, IQuotationAccountApi accountApi) throws TException {
        ReqQuotationAccountOption qaOption = new ReqQuotationAccountOption();

        if (option != null) {
            if (option.isSetAccountId()) {
                qaOption.addToAccountId(option.getAccountId());
                return accountApi.reqQuotationAccount(qaOption, pageOption);
            }
            if (option.isSetAccountNamePartical()) {
                qaOption.setAccountNamePartical(option.getAccountNamePartical());
                return accountApi.reqQuotationAccount(qaOption, pageOption);
            }
            if (option.isSetAccountNickNamePartical()) {
                qaOption.setNickNamePartical(option.getAccountNickNamePartical());
                return accountApi.reqQuotationAccount(qaOption, pageOption);
            }

            if (option.isSetBrokerNamePartical()) {
                IBrokerApi iBrokerApi = BrokerApiFactory.getInstance().getDefault();
                ReqBrokerEntryOption brokerOption = new ReqBrokerEntryOption();
                brokerOption.setCnNamePartical(option.getBrokerNamePartical());
                BrokerEntryPage brokerPage = iBrokerApi.reqBrokerFull(brokerOption);
                QuotationAccountPage page = new QuotationAccountPage().setPage(new ArrayList<>());
                for (BrokerEntry entry : brokerPage.getPage()) {
                    qaOption = new ReqQuotationAccountOption();
                    qaOption.setBrokerId(entry.getBrokerId());
                    QuotationAccountPage accountPage = accountApi.reqQuotationAccount(qaOption,
                            new IndexedPageOption().setPageIndex(0).setPageSize(Integer.MAX_VALUE));
                    page.setTotal(page.getTotal() + accountPage.getTotal());
                    page.getPage().addAll(accountPage.getPage());
                }
                return page;
            }
            if (option.isSetCommodityNamePartical()) {

                IContractApi iContractApi = ContractApiFactory.getInstance().getDefault();
                Map<Integer, SledCommodity> sledCommodityMap = new HashMap<>();
                if (option != null && option.isSetCommodityNamePartical()) {
                    ReqSledCommodityOption commodityOption = new ReqSledCommodityOption();
                    commodityOption.setCnNamePartical(option.getCommodityNamePartical());
                    commodityOption.setEngNamePartical(option.getCommodityNamePartical());
                    SledCommodityPage page = iContractApi.reqCommodityFull(commodityOption);

                    for (SledCommodity sledCommodity : page.getPage()) {
                        sledCommodityMap.put(sledCommodity.getSledCommodityId(), sledCommodity);
                    }
                }

                Set<Long> accountIds = new HashSet<>();
                for (int id : sledCommodityMap.keySet()) {
                    ReqAccountCommodityRegisterAbilityOption abilityOption = new ReqAccountCommodityRegisterAbilityOption();
                    abilityOption.setSledCommodityId(id);
                    AccountCommodityRegisterAbilityPage page = accountApi.reqAccountCommodityRegisterAbility(abilityOption, pageOption);
                    for (AccountCommodityRegisterAbility ability : page.getPage()) {
                        accountIds.add(ability.getAccountId());
                    }
                }
                qaOption.setAccountId(accountIds);
                return accountApi.reqQuotationAccount(qaOption, pageOption);
            }
        }

        return accountApi.reqQuotationAccount(qaOption, pageOption);
    }

    public QuotationAccountInfo updateQuotationAccountInfo(QuotationAccountInfo quotationAccountInfo) throws TException {
        if (quotationAccountInfo.getAccountId() <= 0) {
            throw new ErrorInfo(ErrorCodeOuter.PARAM_ERROR.getErrorCode(), "account id must set");
        }

        QuotationAccount account = map2QuotationAccount(quotationAccountInfo);
        account.setAccountId(quotationAccountInfo.getAccountId());

        IQuotationAccountApi accountApi = QuotationAccountApiFactory.getInstance().getDefault();
        accountApi.updateQuotationAccount(account);

        return getQuotationAccountInfo(quotationAccountInfo.getAccountId());
    }

    private QuotationAccount map2QuotationAccount(QuotationAccountInfo quotationAccountInfo) {
        QuotationAccount account = new QuotationAccount();
        if (quotationAccountInfo.isSetAccountName()) {
            account.setAccountName(quotationAccountInfo.getAccountName());
        }
        if (quotationAccountInfo.isSetAccountpwd()) {
            account.setAccountpwd(quotationAccountInfo.getAccountpwd());
        }
        if (quotationAccountInfo.isSetNickName()) {
            account.setNickName(quotationAccountInfo.getNickName());
        }
        if (quotationAccountInfo.isSetPlatform()) {
            account.setPlatform(BeanMapping.map2QuoTechPlatform(quotationAccountInfo.getPlatform()));
        }
        if (quotationAccountInfo.isSetBrokerId()) {
            account.setBrokerId(quotationAccountInfo.getBrokerId());
        }
        if (quotationAccountInfo.isSetBrokerAccessId()) {
            account.setBrokerAccessId(quotationAccountInfo.getBrokerAccessId());
        }
        if (quotationAccountInfo.isSetAccountProperties()) {
            account.setAccountProperties(quotationAccountInfo.getAccountProperties());
        }
        if (quotationAccountInfo.isSetPlatformEnv()) {
            account.setPlatformEnv(BeanMapping.map2QuoPlatformEnv(quotationAccountInfo.getPlatformEnv()));
        }
        if (quotationAccountInfo.isSetMaxRegisterCount()) {
            account.setMaxRegisterCount(quotationAccountInfo.getMaxRegisterCount());
        }
        return account;
    }

    private QuotationAccountInfo getQuotationAccountInfo(long accountId) throws TException {

        ReqQuotationAccountInfoOption option = new ReqQuotationAccountInfoOption();
        option.setAccountId(accountId);
        IndexedPageOption pageOption = new IndexedPageOption();
        pageOption.setNeedTotalCount(true);
        pageOption.setPageIndex(0);
        pageOption.setPageSize(1);
        QuotationAccountInfoPage page = reqQuotationAccountInfo(option, pageOption);
        return page.getPage().get(0);
    }

    public QuotationAccountInfo addQuotationAccountInfo(QuotationAccountInfo quotationAccountInfo) throws TException {
        QuotationAccount account = map2QuotationAccount(quotationAccountInfo);

        IQuotationAccountApi accountApi = QuotationAccountApiFactory.getInstance().getDefault();
        long accountId = accountApi.addQuotationAccount(account);

        return getQuotationAccountInfo(accountId);
    }

    public void deleteQuotationAccount(long accountId) throws TException {
        IQuotationAccountApi accountApi = QuotationAccountApiFactory.getInstance().getDefault();
        accountApi.deleteQuotationAccount(accountId);
    }

    public AccountRegisterAbilityPage reqAccountRegisterAbility(ReqAccountRegisterAbilityOption option, IndexedPageOption pageOption) throws TException {
        IQuotationAccountApi accountApi = QuotationAccountApiFactory.getInstance().getDefault();
        ReqAccountCommodityRegisterAbilityOption reqOption = new ReqAccountCommodityRegisterAbilityOption();
        if (option != null) {
            if (option.isSetAccountId()) {
                reqOption.setAccountId(option.getAccountId());
            }
            if (option.isSetSledCommodityId()) {
                reqOption.setSledCommodityId(option.getSledCommodityId());
            }
            if (option.isSetSledExchangeId()) {
                reqOption.setSledExchangeId(option.getSledExchangeId());
            }
        }
        AccountCommodityRegisterAbilityPage page = accountApi.reqAccountCommodityRegisterAbility(reqOption, pageOption);

        AccountRegisterAbilityPage abilityPage = new AccountRegisterAbilityPage();
        abilityPage.setTotal(page.getTotal());
        if (page.getPageSize() > 0) {
            Set<Integer> sledCommodityIds = new HashSet<>();
            Set<Integer> sledExchangeIds = new HashSet<>();
            Set<Long> accountIds = new HashSet<>();
            for (AccountCommodityRegisterAbility ability : page.getPage()) {
                AccountRegisterAbility registerAbility = new AccountRegisterAbility();
                registerAbility.setAccountId(ability.getAccountId());
                registerAbility.setSledCommodityId(ability.getSledCommodityId());
                registerAbility.setSledExchangeId(ability.getSledExchangeId());
                sledCommodityIds.add(ability.getSledCommodityId());
                sledExchangeIds.add(ability.getSledExchangeId());
                accountIds.add(ability.getAccountId());
                abilityPage.addToPage(registerAbility);
            }

            IContractApi iContractApi = ContractApiFactory.getInstance().getDefault();
            ReqSledCommodityOption commodityOption = new ReqSledCommodityOption();
            for (int id : sledCommodityIds) {
                commodityOption.addToSledCommodityIdList(id);
            }
            SledCommodityPage commodityPage = iContractApi.reqCommodityFull(commodityOption);
            Map<Integer, SledCommodity> commodityMap = new HashMap<>();
            for (SledCommodity commodity : commodityPage.getPage()) {
                commodityMap.put(commodity.getSledCommodityId(), commodity);
            }

            ReqSledExchangeOption exchangeOption = new ReqSledExchangeOption();
            for (int id : sledExchangeIds) {
                exchangeOption.addToSledExchangeIds(id);
            }
            SledExchangePage exchangePage = iContractApi.reqExchangeFull(exchangeOption);
            Map<String, SledExchange> exchangeMap = new HashMap<>();
            for (SledExchange exchange : exchangePage.getPage()) {
                exchangeMap.put(exchange.getExchangeMic(), exchange);
            }

            ReqQuotationAccountOption accountOption = new ReqQuotationAccountOption();
            for (long id : accountIds) {
                accountOption.addToAccountId(id);
            }
            QuotationAccountPage accountPage = accountApi.reqQuotationAccountFull(accountOption);
            Map<Long, QuotationAccount> accountMap = new HashMap<>();
            for (QuotationAccount account : accountPage.getPage()) {
                accountMap.put(account.getAccountId(), account);
            }

            for (AccountRegisterAbility ability : abilityPage.getPage()) {
                ability.setAccountName(accountMap.get(ability.getAccountId()).getAccountName());
                ability.setCommodityName(commodityMap.get(ability.getSledCommodityId()).getCnName());
                ability.setExchangeName(exchangeMap.get(commodityMap.get(ability.getSledCommodityId())).getCnName());
            }
        }

        return abilityPage;
    }

    public AccountRegisterAbility addAccountRegisterAbility(AccountRegisterAbility ability) throws TException {
        IQuotationAccountApi accountApi = QuotationAccountApiFactory.getInstance().getDefault();
        AccountCommodityRegisterAbility accountAbility = new AccountCommodityRegisterAbility();
        accountAbility.setAccountId(ability.getAccountId());
        accountAbility.setSledExchangeId(ability.getSledExchangeId());
        accountAbility.setSledCommodityId(ability.getSledCommodityId());
        accountApi.addAccountCommodityRegisterAbility(accountAbility);

        return getAccountRegisterAbility(ability.getAccountId(), ability.getSledCommodityId());
    }

    private AccountRegisterAbility getAccountRegisterAbility(long accountId, int sledCommodityId) throws TException {

        ReqAccountRegisterAbilityOption option = new ReqAccountRegisterAbilityOption();
        option.setAccountId(accountId);
        option.setSledCommodityId(sledCommodityId);
        IndexedPageOption pageOption = new IndexedPageOption();
        pageOption.setNeedTotalCount(true);
        pageOption.setPageIndex(0);
        pageOption.setPageSize(1);
        AccountRegisterAbilityPage page = reqAccountRegisterAbility(option, pageOption);
        return page.getPage().get(0);
    }

    public void deleteAccountRegisterAbility(long accountId, int sledCommodityId) throws TException {
        IQuotationAccountApi accountApi = QuotationAccountApiFactory.getInstance().getDefault();
        accountApi.deleteAccountCommodityRegisterAbility(accountId, sledCommodityId);
    }

    public SubscribedContractPage reqSubscribedContract(ReqSubscribedContractOption option, IndexedPageOption pageOption) throws TException {
        IQuotationAccountApi accountApi = QuotationAccountApiFactory.getInstance().getDefault();
        ReqQuotationAccountSubscribeOption reqOption = new ReqQuotationAccountSubscribeOption();
        QuotationAccountSubscribePage totalPage = new QuotationAccountSubscribePage().setPage(new ArrayList<>());
        if (option.isSetPlatformEnv()) {
            reqOption.setPlatformEnv(BeanMapping.map2QuoPlatformEnv(option.getPlatformEnv()));
        }
        if (option.isSetAccountNamePartical()) {
            ReqQuotationAccountOption accountOption = new ReqQuotationAccountOption();
            accountOption.setAccountNamePartical(option.getAccountNamePartical());
            QuotationAccountPage accountPage = accountApi.reqQuotationAccount(accountOption, fullPage);
            for (QuotationAccount account : accountPage.getPage()) {
                reqOption.setAccountId(account.getAccountId());
                QuotationAccountSubscribePage page = accountApi.reqQuotationAccountSubscribe(reqOption, pageOption);
                totalPage.setTotal(totalPage.getTotal() + page.getTotal());
                totalPage.getPage().addAll(page.getPage());
            }
        } else if (option.isSetCommodityNamePartical()) {
            IContractApi iContractApi = ContractApiFactory.getInstance().getDefault();
            ReqSledCommodityOption commodityOption = new ReqSledCommodityOption();
            commodityOption.setCnNamePartical(option.getCommodityNamePartical());
            SledCommodityPage commodityPage = iContractApi.reqCommodityFull(commodityOption);
            for (SledCommodity account : commodityPage.getPage()) {
                reqOption.setAccountId(account.getSledCommodityId());
                QuotationAccountSubscribePage page = accountApi.reqQuotationAccountSubscribe(reqOption, pageOption);
                totalPage.setTotal(totalPage.getTotal() + page.getTotal());
                totalPage.getPage().addAll(page.getPage());
            }
        } else {
            totalPage = accountApi.reqQuotationAccountSubscribe(reqOption, pageOption);
        }

        SubscribedContractPage scPage = new SubscribedContractPage();
        scPage.setTotal(totalPage.getTotal());
        Set<Integer> sledCommodityIds = new HashSet<>();
        Set<Integer> sledExchangeIds = new HashSet<>();
        Set<Integer> sledContractIds = new HashSet<>();
        Set<Long> accountIds = new HashSet<>();
        for (QuotationAccountSubscribe subscribe : totalPage.getPage()) {
            SubscribedContract subscribedContract = new SubscribedContract();
            subscribedContract.setAccountId(subscribe.getAccountId());
            subscribedContract.setSledCommodityId(subscribe.getSledCommodityId());
            subscribedContract.setSledContractId(subscribe.getSledContractId());
            subscribedContract.setIsActiveMonth(subscribe.isIsActiveMonth());
            subscribedContract.setPlatformEnv(BeanMapping.map2PlatformEnv(subscribe.getPlatformEnv()));
            subscribedContract.setSledExchangeId(subscribe.getSledExchangeId());

            sledCommodityIds.add(subscribe.getSledCommodityId());
            sledExchangeIds.add(subscribe.getSledExchangeId());
            sledContractIds.add(subscribe.getSledContractId());
            accountIds.add(subscribe.getAccountId());

            scPage.addToPage(subscribedContract);
        }


        if (totalPage.getPageSize() > 0) {
            IContractApi iContractApi = ContractApiFactory.getInstance().getDefault();
            Map<Integer, SledCommodity> commodityMap = new HashMap<>();
            Map<Integer, SledExchange> exchangeMap = new HashMap<>();
            Map<Integer, SledContract> contractMap = new HashMap<>();
            Map<Long, QuotationAccount> accountMap = new HashMap<>();

            SledCommodityPage page = iContractApi.reqCommodityFull(new ReqSledCommodityOption().setSledCommodityIdList(add2List(sledCommodityIds)));
            for (SledCommodity sledCommodity : page.getPage()) {
                commodityMap.put(sledCommodity.getSledCommodityId(), sledCommodity);
            }
            SledExchangePage exchangePage = iContractApi.reqExchangeFull(new ReqSledExchangeOption().setSledExchangeIds(add2List(sledExchangeIds)));
            for (SledExchange exchange : exchangePage.getPage()) {
                exchangeMap.put(exchange.getSledExchangeId(), exchange);
            }
            SledContractPage contractPage = iContractApi.reqContractFull(new ReqSledContractOption().setSledContractIdList(add2List(sledContractIds)));
            for (SledContract contract : contractPage.getPage()) {
                contractMap.put(contract.getSledContractId(), contract);
            }

            QuotationAccountPage accountPage = accountApi.reqQuotationAccount(new ReqQuotationAccountOption().setAccountId(accountIds), fullPage);
            for (QuotationAccount account : accountPage.getPage()) {
                accountMap.put(account.getAccountId(), account);
            }

            for (SubscribedContract subscribedContract : scPage.getPage()) {
                subscribedContract.setExchangeName(exchangeMap.get(subscribedContract.getSledExchangeId()).getCnName());
                subscribedContract.setCommodityName(commodityMap.get(subscribedContract.getSledCommodityId()).getCnName());
                subscribedContract.setContractName(contractMap.get(subscribedContract.getSledContractId()).getContractCnName());
                subscribedContract.setAccountName(accountMap.get(subscribedContract.getAccountId()).getAccountName());
            }
        }
        return scPage;
    }


    private List<Integer> add2List(Set<Integer> ids) {
        List<Integer> list = new ArrayList<>();
        list.addAll(ids);
        return list;
    }
}
