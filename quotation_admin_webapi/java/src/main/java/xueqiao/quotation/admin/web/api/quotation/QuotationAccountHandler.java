package xueqiao.quotation.admin.web.api.quotation;

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
import xueqiao.quotation.admin.web.api.broker.BrokerApiFactory;
import xueqiao.quotation.admin.web.api.broker.IBrokerApi;
import xueqiao.quotation.admin.web.api.contract.ContractApiFactory;
import xueqiao.quotation.admin.web.api.contract.IContractApi;
import xueqiao.quotation.admin.web.api.thriftapi.*;
import xueqiao.quotation.admin.web.api.utils.BeanMapping;

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
//                info.setAccountpwd(qa.getAccountpwd());
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
                info.setDeploySet(qa.getDeploySet());

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
                brokerAccessEntries.put(entry.getEntryId(), entry);
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
            if (option.isSetBrokerNamePartical()) {
                IBrokerApi iBrokerApi = BrokerApiFactory.getInstance().getDefault();
                ReqBrokerEntryOption brokerOption = new ReqBrokerEntryOption();
                brokerOption.setCnNamePartical(option.getBrokerNamePartical());
                BrokerEntryPage brokerPage = iBrokerApi.reqBrokerFull(brokerOption);
                for (BrokerEntry entry : brokerPage.getPage()) {
                    qaOption.addToBrokerIds(entry.getBrokerId());
                }
            }
            if (option.isSetCommodityNamePartical()) {

                IContractApi iContractApi = ContractApiFactory.getInstance().getDefault();
                Map<Integer, SledCommodity> sledCommodityMap = new HashMap<>();
                Set<String> exchangeMics = new HashSet<>();
                if (option != null && option.isSetCommodityNamePartical()) {
                    ReqSledCommodityOption commodityOption = new ReqSledCommodityOption();
                    commodityOption.setCnNamePartical(option.getCommodityNamePartical());
                    commodityOption.setEngNamePartical(option.getCommodityNamePartical());
                    commodityOption.setSledCommodityCodePartical(option.getCommodityNamePartical());
                    SledCommodityPage page = iContractApi.reqCommodityFull(commodityOption);

                    for (SledCommodity sledCommodity : page.getPage()) {
                        sledCommodityMap.put(sledCommodity.getSledCommodityId(), sledCommodity);
                        exchangeMics.add(sledCommodity.getExchangeMic());
                    }
                }

                Set<Long> accountIds = new HashSet<>();

                if (sledCommodityMap.size() > 0) {
                    ReqAccountCommodityRegisterAbilityOption abilityOption = new ReqAccountCommodityRegisterAbilityOption();
                    abilityOption.setSledCommodityIds(sledCommodityMap.keySet());
                    abilityOption.setSupportType(SupportType.SET);
                    AccountCommodityRegisterAbilityPage page = accountApi.reqAccountCommodityRegisterAbility(abilityOption, pageOption);
                    for (AccountCommodityRegisterAbility ability : page.getPage()) {
                        accountIds.add(ability.getAccountId());
                    }
                }

                SledExchangePage exchangePage = iContractApi.reqExchangeFull(new ReqSledExchangeOption());
                Map<String, Integer> exchanges = new HashMap<>();
                for (SledExchange exchange : exchangePage.getPage()) {
                    exchanges.put(exchange.getExchangeMic(), exchange.getSledExchangeId());
                }
                Set<Integer> exchangeIds = new HashSet<>();
                for (String mic : exchangeMics) {
                    exchangeIds.add(exchanges.get(mic));
                }
                if (exchangeIds.size() > 0) {
                    ReqAccountCommodityRegisterAbilityOption abilityOption = new ReqAccountCommodityRegisterAbilityOption();
                    abilityOption.setSledExchangeIds(exchangeIds);
                    abilityOption.setSupportType(SupportType.ALL);
                    AccountCommodityRegisterAbilityPage page = accountApi.reqAccountCommodityRegisterAbility(abilityOption, pageOption);
                    for (AccountCommodityRegisterAbility ability : page.getPage()) {
                        accountIds.add(ability.getAccountId());
                    }
                }

                qaOption.setAccountIds(accountIds);
            }

            if (option.isSetAccountId()) {
                qaOption.addToAccountIds(option.getAccountId());
            }
            if (option.isSetAccountNamePartical()) {
                qaOption.setAccountNamePartical(option.getAccountNamePartical());
            }
            if (option.isSetAccountNickNamePartical()) {
                qaOption.setNickNamePartical(option.getAccountNickNamePartical());
            }
            if (option.isSetPlatform()) {
                qaOption.setPlatform(BeanMapping.map2QuoTechPlatform(option.getPlatform()));
            }
            if (option.isSetPlatformEnv()) {
                qaOption.setPlatformEnv(BeanMapping.map2QuoPlatformEnv(option.getPlatformEnv()));
            }
            if (option.isSetDeploySet()) {
                qaOption.setDeploySet(option.getDeploySet());
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
        if (quotationAccountInfo.isSetAccessState()) {
            account.setAccessState(quotationAccountInfo.getAccessState());
        }
        if (quotationAccountInfo.isSetAccountState()) {
            account.setAccountState(quotationAccountInfo.getAccountState());
        }
        if (quotationAccountInfo.isSetDeploySet()) {
            account.setDeploySet(quotationAccountInfo.getDeploySet());
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

    public List<ExchangeRegisterAbility> reqExchangeAbility(ReqAccountRegisterAbilityOption option) throws TException {
        if (option == null) {
            throw new ErrorInfo(ErrorCodeOuter.PARAM_ERROR.getErrorCode(), "option must set");
        }
        if (!option.isSetAccountId()) {
            throw new ErrorInfo(ErrorCodeOuter.PARAM_ERROR.getErrorCode(), "accountId must set");
        }

        AccountRegisterAbilityPage page = reqAccountRegisterAbility(option, fullPage);
        List<ExchangeRegisterAbility> list = new ArrayList<>();
        Map<Integer, ExchangeRegisterAbility> exchangeRegisterAbilityMap = new HashMap<>();

        if (page.getPageSize() <= 0) {
            return list;
        }
        for (AccountRegisterAbility ability : page.getPage()) {

            ExchangeRegisterAbility exchangeRegisterAbility = exchangeRegisterAbilityMap.get(ability.getSledExchangeId());
            if (exchangeRegisterAbility == null) {
                exchangeRegisterAbility = new ExchangeRegisterAbility();
                exchangeRegisterAbilityMap.put(ability.getSledExchangeId(), exchangeRegisterAbility);
                exchangeRegisterAbility.setAccountId(ability.getAccountId());
                exchangeRegisterAbility.setSledExchangeId(ability.getSledExchangeId());
                exchangeRegisterAbility.setExchangeName(ability.getExchangeName());
                exchangeRegisterAbility.setSupportType(ability.getSupportType());
            }

            CommodityRegisterAbility commodityAbility = new CommodityRegisterAbility();
            commodityAbility.setAccountId(ability.getAccountId());
            commodityAbility.setCommodityName(ability.getCommodityName());
            commodityAbility.setRegisterAbilityId(ability.getRegisterAbilityId());
            commodityAbility.setSledExchangeId(ability.getSledExchangeId());

            exchangeRegisterAbility.addToCommodityAbilities(commodityAbility);
        }

        list.addAll(exchangeRegisterAbilityMap.values());
        return list;
    }

    public AccountRegisterAbilityPage reqAccountRegisterAbility(ReqAccountRegisterAbilityOption option, IndexedPageOption pageOption) throws TException {
        IQuotationAccountApi accountApi = QuotationAccountApiFactory.getInstance().getDefault();
        ReqAccountCommodityRegisterAbilityOption reqOption = new ReqAccountCommodityRegisterAbilityOption();
        AccountCommodityRegisterAbilityPage totalPage;
        if (option != null) {
            if (option.isSetAccountId()) {
                reqOption.setAccountId(option.getAccountId());
            }

            if (option.isSetSledCommodityId()) {
                reqOption.addToSledCommodityIds(option.getSledCommodityId());
            }
            if (option.isSetSledExchangeId()) {
                reqOption.addToSledExchangeIds(option.getSledExchangeId());
            }
            if (option.isSetExchangeNamePartical()) {
                IContractApi iContractApi = ContractApiFactory.getInstance().getDefault();
                SledExchangePage exchangePage = iContractApi.reqExchangeFull(new ReqSledExchangeOption().setCnNamePartical(option.getExchangeNamePartical()));
                for (SledExchange exchange : exchangePage.getPage()) {
                    reqOption.addToSledExchangeIds(exchange.getSledExchangeId());
                }
            }
            if (option.isSetCommodityNamePartical()) {

                IContractApi iContractApi = ContractApiFactory.getInstance().getDefault();
                Map<Integer, SledCommodity> sledCommodityMap = new HashMap<>();
                Set<String> exchangeMics = new HashSet<>();
                if (option != null && option.isSetCommodityNamePartical()) {
                    ReqSledCommodityOption commodityOption = new ReqSledCommodityOption();
                    commodityOption.setCnNamePartical(option.getCommodityNamePartical());
                    commodityOption.setEngNamePartical(option.getCommodityNamePartical());
                    commodityOption.setSledCommodityCodePartical(option.getCommodityNamePartical());
                    SledCommodityPage page = iContractApi.reqCommodityFull(commodityOption);

                    for (SledCommodity sledCommodity : page.getPage()) {
                        sledCommodityMap.put(sledCommodity.getSledCommodityId(), sledCommodity);
                        exchangeMics.add(sledCommodity.getExchangeMic());
                    }
                }

                AccountCommodityRegisterAbilityPage commoditySupportPage = null;
                AccountCommodityRegisterAbilityPage exchangeSupportPage = null;
                if (sledCommodityMap.size() > 0) {
                    reqOption.setSupportType(SupportType.SET);
                    reqOption.setSledCommodityIds(sledCommodityMap.keySet());
                    commoditySupportPage = accountApi.reqAccountCommodityRegisterAbility(reqOption, pageOption);
                    reqOption.unsetSledCommodityIds();
                    reqOption.unsetSupportType();
                }

                SledExchangePage exchangePage = iContractApi.reqExchangeFull(new ReqSledExchangeOption());
                Map<String, Integer> exchanges = new HashMap<>();
                for (SledExchange exchange : exchangePage.getPage()) {
                    exchanges.put(exchange.getExchangeMic(), exchange.getSledExchangeId());
                }
                Set<Integer> exchangeIds = new HashSet<>();
                for (String mic : exchangeMics) {
                    exchangeIds.add(exchanges.get(mic));
                }
                if (exchangeIds.size() > 0) {
                    reqOption.setSledExchangeIds(exchangeIds);
                    reqOption.setSupportType(SupportType.ALL);
                    exchangeSupportPage = accountApi.reqAccountCommodityRegisterAbility(reqOption, pageOption);
                    reqOption.unsetSledExchangeIds();
                    reqOption.unsetSupportType();
                }
                totalPage = new AccountCommodityRegisterAbilityPage().setPage(new ArrayList<>());
                if (commoditySupportPage != null) {
                    totalPage.getPage().addAll(commoditySupportPage.getPage());
                }

                if (exchangeSupportPage != null) {
                    totalPage.getPage().addAll(exchangeSupportPage.getPage());
                }
            } else {
                totalPage = accountApi.reqAccountCommodityRegisterAbility(reqOption, pageOption);
            }
        } else {
            totalPage = accountApi.reqAccountCommodityRegisterAbility(reqOption, pageOption);
        }

        Set<Long> abilityIds = new HashSet<>();
        AccountRegisterAbilityPage abilityPage = new AccountRegisterAbilityPage();
        abilityPage.setTotal(totalPage.getTotal());
        if (totalPage.getPageSize() > 0) {
            Set<Integer> sledCommodityIds = new HashSet<>();
            Set<Integer> sledExchangeIds = new HashSet<>();
            Set<Long> accountIds = new HashSet<>();
            for (AccountCommodityRegisterAbility ability : totalPage.getPage()) {

                if (abilityIds.contains(ability.getRegisterAbilityId())) {
                    continue;
                }

                AccountRegisterAbility registerAbility = new AccountRegisterAbility();
                registerAbility.setRegisterAbilityId(ability.getRegisterAbilityId());
                registerAbility.setAccountId(ability.getAccountId());
                registerAbility.setSledCommodityId(ability.getSledCommodityId());
                registerAbility.setSledExchangeId(ability.getSledExchangeId());
                registerAbility.setSupportType(ability.getSupportType());
                sledCommodityIds.add(ability.getSledCommodityId());
                sledExchangeIds.add(ability.getSledExchangeId());
                accountIds.add(ability.getAccountId());
                abilityIds.add(ability.getRegisterAbilityId());
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
            Map<Integer, SledExchange> exchangeMap = new HashMap<>();
            for (SledExchange exchange : exchangePage.getPage()) {
                exchangeMap.put(exchange.getSledExchangeId(), exchange);
            }

            ReqQuotationAccountOption accountOption = new ReqQuotationAccountOption();
            for (long id : accountIds) {
                accountOption.addToAccountIds(id);
            }
//            QuotationAccountPage accountPage = accountApi.reqQuotationAccountFull(accountOption);
//            Map<Long, QuotationAccount> accountMap = new HashMap<>();
//            for (QuotationAccount account : accountPage.getPage()) {
//                accountMap.put(account.getAccountId(), account);
//            }

            for (AccountRegisterAbility ability : abilityPage.getPage()) {
//                ability.setAccountName(accountMap.get(ability.getAccountId()).getAccountName());
                SledCommodity sledCommodity = commodityMap.get(ability.getSledCommodityId());
                if (sledCommodity != null) {
                    ability.setCommodityName(sledCommodity.getCnName());
                }
                ability.setExchangeName(exchangeMap.get(ability.getSledExchangeId()).getCnName());
            }
        }

        return abilityPage;
    }

    public void addAccountRegisterAbilities(List<AccountRegisterAbility> abilities) throws TException {
        IContractApi iContractApi = ContractApiFactory.getInstance().getDefault();
        List<AccountCommodityRegisterAbility> list = new ArrayList<>();
        for (AccountRegisterAbility ability : abilities) {
            ReqSledExchangeOption option = new ReqSledExchangeOption();
            option.addToSledExchangeIds(ability.getSledExchangeId());
            SledExchangePage exchangePage = iContractApi.reqExchangeFull(option);


            AccountCommodityRegisterAbility accountAbility = new AccountCommodityRegisterAbility();
            accountAbility.setAccountId(ability.getAccountId());
            accountAbility.setSledExchangeId(ability.getSledExchangeId());
            accountAbility.setSledCommodityId(ability.getSledCommodityId());
            accountAbility.setSupportType(ability.getSupportType());

            if (exchangePage.getPageSize() > 0) {
                accountAbility.setExchangeMic(exchangePage.getPage().get(0).getExchangeMic());
            }
            list.add(accountAbility);
        }
        IQuotationAccountApi accountApi = QuotationAccountApiFactory.getInstance().getDefault();
        accountApi.batAddAccountCommodityRegisterAbility(list);
    }

    public void deleteAccountRegisterAbility(long abilityId) throws TException {
        IQuotationAccountApi accountApi = QuotationAccountApiFactory.getInstance().getDefault();
        accountApi.deleteAccountCommodityRegisterAbility(abilityId);
    }

    public void deleteAccountRegisterAbilityByExchange(long accountId, int sledExchangeId) throws TException {
        IQuotationAccountApi accountApi = QuotationAccountApiFactory.getInstance().getDefault();
        accountApi.deleteAccountRegisterAbilityByExchange(accountId, sledExchangeId);
    }

}
