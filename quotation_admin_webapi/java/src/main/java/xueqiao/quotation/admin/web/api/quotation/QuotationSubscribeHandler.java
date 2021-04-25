package xueqiao.quotation.admin.web.api.quotation;

import com.antiy.error_code.ErrorCodeOuter;
import com.longsheng.xueqiao.contract.standard.thriftapi.*;
import org.apache.commons.lang.StringUtils;
import org.apache.thrift.TException;
import org.soldier.platform.page.IndexedPageOption;
import org.soldier.platform.svr_platform.comm.ErrorInfo;
import xueqiao.quotation.account.thriftapi.*;
import xueqiao.quotation.admin.web.api.contract.ContractApiFactory;
import xueqiao.quotation.admin.web.api.contract.IContractApi;
import xueqiao.quotation.admin.web.api.thriftapi.*;
import xueqiao.quotation.admin.web.api.utils.BeanMapping;
import xueqiao.quotation.plan.bo.*;

import java.util.*;

public class QuotationSubscribeHandler {

    IndexedPageOption fullPage = new IndexedPageOption().setNeedTotalCount(true).setPageIndex(0).setPageSize(Integer.MAX_VALUE);

    public void rePlan() throws TException {
        IQuotationAccountApi iQuotationAccountApi = QuotationAccountApiFactory.getInstance().getDefault();

        GenPreviewState state = iQuotationAccountApi.getGenPreviewState();

        if (state != null && EGenPreviewStatus.PREVIEW_GENTASK_RUNNING.equals(state.getStatus())) {
            throw new ErrorInfo(EQuotationPlanBoErrorCode.ERROR_GENPREVIEW_ISHANDING.getValue(), "A gen preview task is running.");
        }

        iQuotationAccountApi.startGenPreviewSCClasses();
    }

    public RePlanSubscribedInfoPreviewPage reqPreview(ReqRePlanSubscribedInfoPreviewOption option) throws TException {
        IQuotationAccountApi iQuotationAccountApi = QuotationAccountApiFactory.getInstance().getDefault();

        RePlanSubscribedInfoPreviewPage page = new RePlanSubscribedInfoPreviewPage().setTotal(0).setPage(new ArrayList<>());
        GenPreviewState state = iQuotationAccountApi.getGenPreviewState();
        page.setStateMsg(state.getStateMsg());
        switch (state.getStatus()) {
            case PREVIEW_FINISHED:
                page.setState(PreviewState.FINISH).setLastUpdateTimestampMs(state.getLastUpdateTimestampMs());
                break;
            case PREVIEW_EMPTY:
                page.setState(PreviewState.EMPTY);
                break;
            case PREVIEW_GENTASK_RUNNING:
                page.setState(PreviewState.GEN_TASK_RUNNING);
                break;
            case PREVIEW_GENFAILED:
                page.setState(PreviewState.GEN_FAIL);
            default:
                throw new ErrorInfo(ErrorCodeOuter.ILLEGAL_OPEARTION_ERROR.getErrorCode(), "Preview gen unknown status: " + state.getStateMsg());
        }

        if (!PreviewState.FINISH.equals(page.getState())) {
            return page;
        }

        List<SubscribeCommodityClass> previews = iQuotationAccountApi.getPreviewSCClasses();
        List<SubscribeCommodityClass> currentViews = iQuotationAccountApi.getCurrentSCClasses();

        Map<String, RePlanSubscribedInfoPreview> rePlanDiffs = new HashMap<>();
        Set<Integer> sledCommodityIds = new HashSet<>();
        mapping(previews, rePlanDiffs, sledCommodityIds, option, false);
        mapping(currentViews, rePlanDiffs, sledCommodityIds, option, true);

        for (RePlanSubscribedInfoPreview preview : rePlanDiffs.values()) {
            PreviewFields rePlanFields = preview.getRePlanFields();
            PreviewFields currentFields = preview.getCurrentFields();
            if (rePlanFields != null && rePlanFields.equals(currentFields)) {
                preview.setIsFieldsDifferent(false);
            } else {
                preview.setIsFieldsDifferent(true);
            }
        }

        IContractApi iContractApi = ContractApiFactory.getInstance().getDefault();
        SledExchangePage exchangePage = iContractApi.reqExchangeFull(new ReqSledExchangeOption());
        Map<String, SledExchange> exchanges = new HashMap<>();
        for (SledExchange exchange : exchangePage.getPage()) {
            exchanges.put(exchange.getExchangeMic(), exchange);
        }
        SledCommodityPage commodityPage = iContractApi.reqCommodityFull(new ReqSledCommodityOption().setSledCommodityIdList(add2List(sledCommodityIds)));
        Map<Integer, SledCommodity> commodities = new HashMap<>();
        for (SledCommodity sledCommodity : commodityPage.getPage()) {
            commodities.put(sledCommodity.getSledCommodityId(), sledCommodity);
        }


        for (RePlanSubscribedInfoPreview preview : rePlanDiffs.values()) {
            SledCommodity sledCommodity = commodities.get(preview.getSledCommodityId());
            SledExchange sledExchange = exchanges.get(sledCommodity.getExchangeMic());
            preview.setCommodityName(sledCommodity.getCnName());
            preview.setExchangeName(sledExchange.getCnName());
            preview.setSledExchangeId(sledExchange.getSledExchangeId());

            page.addToPage(preview);
        }

        page.setTotal(rePlanDiffs.size());
        return page;
    }

    public List<PlanningSubscribedInfo> reqPlanningSubscribedInfo(ReqPlanningSubscribedInfoOption option) throws TException {
        List<PlanningSubscribedInfo> planningSubscribedInfos = new ArrayList<>();
        IQuotationAccountApi iQuotationAccountApi = QuotationAccountApiFactory.getInstance().getDefault();
        List<SubscribeCommodityClass> currentViews = iQuotationAccountApi.getCurrentSCClasses();

        Set<Integer> targetIds = null;
        if (option != null) {
            if (option.isSetCommodityNamePartical() && StringUtils.isNotEmpty(option.getCommodityNamePartical().trim())) {
                targetIds = new HashSet<>();
                IContractApi iContractApi = ContractApiFactory.getInstance().getDefault();
                ReqSledCommodityOption commodityOption = new ReqSledCommodityOption();
                commodityOption.setCnNamePartical(option.getCommodityNamePartical());
                commodityOption.setEngNamePartical(option.getCommodityNamePartical());
                commodityOption.setSledCommodityCodePartical(option.getCommodityNamePartical());
                SledCommodityPage commodityPage = iContractApi.reqCommodityFull(commodityOption);
                for (SledCommodity sledCommodity : commodityPage.getPage()) {
                    targetIds.add(sledCommodity.getSledCommodityId());
                }
            }
        }

        Set<Integer> commodityIds = new HashSet<>();
        for (SubscribeCommodityClass scc : currentViews) {

            if (option != null) {
                if (option.isSetPlatformEnv()) {
                    if (!option.getPlatformEnv().equals(BeanMapping.map2PlatformEnv(scc.getPlatformEnv()))) {
                        continue;
                    }
                }
            }
            if (targetIds != null && !targetIds.contains((int) scc.getSledCommodityId())) {
                continue;
            }

            PlanningSubscribedInfo info = new PlanningSubscribedInfo();
            info.setPlatformEnv(BeanMapping.map2PlatformEnv(scc.getPlatformEnv()));
            info.setSledCommodityId((int) scc.getSledCommodityId());
            info.setFields(getPreviewFields(scc));
            commodityIds.add((int) scc.getSledCommodityId());

            planningSubscribedInfos.add(info);
        }

        IContractApi iContractApi = ContractApiFactory.getInstance().getDefault();
        SledExchangePage exchangePage = iContractApi.reqExchangeFull(new ReqSledExchangeOption());
        Map<String, SledExchange> exchanges = new HashMap<>();
        for (SledExchange exchange : exchangePage.getPage()) {
            exchanges.put(exchange.getExchangeMic(), exchange);
        }

        SledCommodityPage commodityPage = iContractApi.reqCommodityFull(new ReqSledCommodityOption().setSledCommodityIdList(add2List(commodityIds)));
        Map<Integer, SledCommodity> commodities = new HashMap<>();
        for (SledCommodity sledCommodity : commodityPage.getPage()) {
            commodities.put(sledCommodity.getSledCommodityId(), sledCommodity);
        }

        for (PlanningSubscribedInfo info : planningSubscribedInfos) {
            SledCommodity sledCommodity = commodities.get(info.getSledCommodityId());
            SledExchange sledExchange = exchanges.get(sledCommodity.getExchangeMic());
            info.setCommodityName(sledCommodity.getCnName());
            info.setExchangeName(sledExchange.getCnName());
            info.setSledExchangeId(sledExchange.getSledExchangeId());
        }

        return planningSubscribedInfos;
    }

    private void mapping(List<SubscribeCommodityClass> sccs,
                         Map<String, RePlanSubscribedInfoPreview> rePlanDiffs,
                         Set<Integer> sledCommodityIds,
                         ReqRePlanSubscribedInfoPreviewOption option,
                         boolean isCurrent) throws TException {

        Set<Integer> targetIds = null;
        if (option != null) {
            if (option.isSetCommodityNamePartical() && StringUtils.isNotEmpty(option.getCommodityNamePartical().trim())) {
                targetIds = new HashSet<>();
                IContractApi iContractApi = ContractApiFactory.getInstance().getDefault();
                ReqSledCommodityOption commodityOption = new ReqSledCommodityOption();
                commodityOption.setSledCommodityCodePartical(option.getCommodityNamePartical());
                commodityOption.setCnNamePartical(option.getCommodityNamePartical());
                commodityOption.setEngNamePartical(option.getCommodityNamePartical());
                SledCommodityPage commodityPage = iContractApi.reqCommodityFull(commodityOption);
                for (SledCommodity sledCommodity : commodityPage.getPage()) {
                    targetIds.add(sledCommodity.getSledCommodityId());
                }
            }
        }

        for (SubscribeCommodityClass preview : sccs) {

            if (option != null) {
                if (option.isSetPlatformEnv()) {
                    if (!option.getPlatformEnv().equals(BeanMapping.map2PlatformEnv(preview.getPlatformEnv()))) {
                        continue;
                    }
                }
            }
            if (targetIds != null && !targetIds.contains((int) preview.getSledCommodityId())) {
                continue;
            }

            sledCommodityIds.add((int) preview.getSledCommodityId());
            String commodityKey = genKey(preview.getSledCommodityId(), preview.getPlatformEnv(), preview.getFixedContractCode());
            RePlanSubscribedInfoPreview rePlanPreview = rePlanDiffs.get(commodityKey);
            if (rePlanPreview == null) {
                rePlanPreview = new RePlanSubscribedInfoPreview();
                rePlanDiffs.put(commodityKey, rePlanPreview);
                rePlanPreview.setPlatformEnv(BeanMapping.map2PlatformEnv(preview.getPlatformEnv()));
                rePlanPreview.setSledCommodityId((int) preview.getSledCommodityId());
                rePlanPreview.setIsCurrentSubcribe(false);
                rePlanPreview.setIsReplanSubcribe(false);
            }

            if (isCurrent) {
                rePlanPreview.setIsCurrentSubcribe(true);
                PreviewFields fields = getPreviewFields(preview);
                rePlanPreview.setCurrentFields(fields);
            } else {
                rePlanPreview.setIsReplanSubcribe(true);
                PreviewFields fields = getPreviewFields(preview);
                rePlanPreview.setRePlanFields(fields);
            }
        }

    }

    private PreviewFields getPreviewFields(SubscribeCommodityClass preview) {
        PreviewFields fields = new PreviewFields();
        if (preview.isSetActiveMonths()) {
            fields.setActiveMonths(StringUtils.join(preview.getActiveMonths(), ","));
        }
        fields.setActiveSubscribeNum(preview.getActiveSubscribeNum());
        if (preview.isSetInactiveMonths()) {
            fields.setInactiveMonths(StringUtils.join(preview.getInactiveMonths(), ","));
        }
        fields.setInActiveSubscribeNum(preview.getInActiveSubscribeNum());
        fields.setBackupCounts(preview.getSubscribeAccountsSize() - 1 > 0 ? preview.getSubscribeAccountsSize() - 1 : 0);
        fields.setFixedCode(preview.getFixedContractCode());
        return fields;
    }

    public void submitPreviewSubscribe() throws TException {
        IQuotationAccountApi iQuotationAccountApi = QuotationAccountApiFactory.getInstance().getDefault();
        iQuotationAccountApi.commitPreviewSCClasses();
    }

    private String genKey(long sledCommodityId, QuotationPlatformEnv env, String fixedCode) {
        return String.valueOf(sledCommodityId) + "|" + env.getValue() + "|" + fixedCode;
    }

    public SubscribedContractPage reqSubscribedContract(ReqSubscribedContractOption option, IndexedPageOption pageOption) throws TException {
        IQuotationAccountApi accountApi = QuotationAccountApiFactory.getInstance().getDefault();
        QuerySubscribeContractItemOption reqOption = new QuerySubscribeContractItemOption();
        DeploySet deploySetFilter = null;

        if (option != null) {
            if (option.isSetDeploySet()) {
                deploySetFilter = option.getDeploySet();
            }
            if (option.isSetPlatformEnv()) {
                reqOption.setPlatformEnv(BeanMapping.map2QuoPlatformEnv(option.getPlatformEnv()));
            }
            if (option.isSetAccountNamePartical()) {
                ReqQuotationAccountOption accountOption = new ReqQuotationAccountOption();
//                accountOption.setAccountNamePartical(option.getAccountNamePartical());
                // 使用nick name， 界面显示需要
                accountOption.setNickNamePartical(option.getAccountNamePartical());
                QuotationAccountPage accountPage = accountApi.reqQuotationAccount(accountOption, fullPage);
                if (accountPage.getPageSize() <= 0) {
                    return new SubscribedContractPage();
                }

                for (QuotationAccount account : accountPage.getPage()) {
                    reqOption.addToQuotationAccountIds(account.getAccountId());
                }
            }
            if (option.isSetCommodityNamePartical()) {
                IContractApi iContractApi = ContractApiFactory.getInstance().getDefault();
                ReqSledCommodityOption commodityOption = new ReqSledCommodityOption();
                commodityOption.setCnNamePartical(option.getCommodityNamePartical());
                commodityOption.setEngNamePartical(option.getCommodityNamePartical());
                commodityOption.setSledCommodityCodePartical(option.getCommodityNamePartical());
                SledCommodityPage commodityPage = iContractApi.reqCommodityFull(commodityOption);
                if (commodityPage.getPageSize() <= 0) {
                    return new SubscribedContractPage();
                }
                for (SledCommodity sledCommodity : commodityPage.getPage()) {
                    reqOption.addToSledCommodityIds(sledCommodity.getSledCommodityId());
                }
            }
        }

        SubscribeContractItemPage totalPage = accountApi.querySubscribeContractItemPage(reqOption, fullPage);

        SubscribedContractPage scPage = new SubscribedContractPage();
        scPage.setTotal(totalPage.getTotalCount());

        SubscribedContractPage filterPage = new SubscribedContractPage().setPage(new ArrayList<>());

        Set<Integer> sledCommodityIds = new HashSet<>();
        Set<String> sledExchangeMics = new HashSet<>();
        Set<Integer> sledContractIds = new HashSet<>();
        Set<Long> accountIds = new HashSet<>();
        for (SubscribeContractItem subscribe : totalPage.getResultList()) {
            SubscribedContract subscribedContract = new SubscribedContract();
            subscribedContract.setAccountId(subscribe.getQuotationAccountId());
            subscribedContract.setSledCommodityId((int) subscribe.getSledCommodityId());
            subscribedContract.setSledContractId((int) subscribe.getSledContractId());
            subscribedContract.setIsActiveMonth(subscribe.isIsForActive());
            subscribedContract.setPlatformEnv(BeanMapping.map2PlatformEnv(subscribe.getPlatformEnv()));
            subscribedContract.setSledExchangeMic(subscribe.getSledExchangeMic());

            sledCommodityIds.add((int) subscribe.getSledCommodityId());
            sledExchangeMics.add(subscribe.getSledExchangeMic());
            sledContractIds.add((int) subscribe.getSledContractId());
            accountIds.add(subscribe.getQuotationAccountId());

            scPage.addToPage(subscribedContract);
        }

        if (scPage.getPageSize() > 0) {
            IContractApi iContractApi = ContractApiFactory.getInstance().getDefault();
            Map<Integer, SledCommodity> commodityMap = new HashMap<>();
            Map<String, SledExchange> exchangeMap = new HashMap<>();
            Map<Integer, SledContract> contractMap = new HashMap<>();
            Map<Long, QuotationAccount> accountMap = new HashMap<>();

            SledCommodityPage page = iContractApi.reqCommodityFull(new ReqSledCommodityOption().setSledCommodityIdList(add2List(sledCommodityIds)));
            for (SledCommodity sledCommodity : page.getPage()) {
                commodityMap.put(sledCommodity.getSledCommodityId(), sledCommodity);
            }
            SledExchangePage exchangePage = iContractApi.reqExchangeFull(new ReqSledExchangeOption());
            for (SledExchange exchange : exchangePage.getPage()) {
                exchangeMap.put(exchange.getExchangeMic(), exchange);
            }
            SledContractPage contractPage = iContractApi.reqContractFull(new ReqSledContractOption().setSledContractIdList(add2List(sledContractIds)));
            for (SledContract contract : contractPage.getPage()) {
                contractMap.put(contract.getSledContractId(), contract);
            }

            QuotationAccountPage accountPage = accountApi.reqQuotationAccount(new ReqQuotationAccountOption().setAccountIds(accountIds), fullPage);
            for (QuotationAccount account : accountPage.getPage()) {
                accountMap.put(account.getAccountId(), account);
            }


            for (SubscribedContract subscribedContract : scPage.getPage()) {
                subscribedContract.setSledExchangeId(exchangeMap.get(subscribedContract.getSledExchangeMic()).getSledExchangeId());
                subscribedContract.setExchangeName(exchangeMap.get(subscribedContract.getSledExchangeMic()).getCnName());
                subscribedContract.setCommodityName(commodityMap.get(subscribedContract.getSledCommodityId()).getCnName());
                // 使用 code 代替 name，有月份信息
                subscribedContract.setContractName(contractMap.get(subscribedContract.getSledContractId()).getSledContractCode());
                // 使用nick name， 界面显示需要
                QuotationAccount account = accountMap.get(subscribedContract.getAccountId());
                if (account != null) {
                    subscribedContract.setAccountName(account.getNickName() + "(" + account.getAccountName() + ")");
                }

                if (deploySetFilter != null && !deploySetFilter.equals(account.getDeploySet())) {
                    continue;
                }
                filterPage.addToPage(subscribedContract);
            }
        }
        filterPage.setTotal(filterPage.getPageSize());

        if (pageOption == null) {
            return filterPage;
        } else {

            List<SubscribedContract> list = new ArrayList<>();
            int end = Math.min(pageOption.getPageSize() * (pageOption.getPageIndex() + 1), filterPage.getPageSize());
            for (int i = pageOption.getPageIndex() * pageOption.getPageSize(); i < end; i++) {
                list.add(filterPage.getPage().get(i));
            }
            return new SubscribedContractPage().setTotal(filterPage.getTotal()).setPage(list);
        }
    }


    private List<Integer> add2List(Set<Integer> ids) {
        List<Integer> list = new ArrayList<>();
        list.addAll(ids);
        return list;
    }
}
