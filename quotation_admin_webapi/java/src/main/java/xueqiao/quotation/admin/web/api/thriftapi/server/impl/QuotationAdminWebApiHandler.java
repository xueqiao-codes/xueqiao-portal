package xueqiao.quotation.admin.web.api.thriftapi.server.impl;


import java.util.*;

import com.longsheng.xueqiao.contract.standard.thriftapi.SledCommodityType;
import com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv;
import org.apache.thrift.TException;
import org.soldier.base.logger.AppLog;
import org.soldier.platform.page.IndexedPageOption;
import org.soldier.platform.svr_platform.comm.ErrorInfo;
import org.soldier.platform.svr_platform.container.TServiceCntl;
import xueqiao.quotation.account.thriftapi.ContractActiveType;
import xueqiao.quotation.account.thriftapi.ReqQuotationAccountSupportOption;
import xueqiao.quotation.account.thriftapi.client.QuotationAccountDaoStub;
import xueqiao.quotation.admin.web.api.broker.BrokerTreeNodeHandler;
import xueqiao.quotation.admin.web.api.contract.ContractTreeNodeHandler;
import xueqiao.quotation.admin.web.api.quotation.CommodityRegisterHandler;
import xueqiao.quotation.admin.web.api.quotation.ContractActiveConfigHandler;
import xueqiao.quotation.admin.web.api.quotation.QuotationAccountHandler;
import xueqiao.quotation.admin.web.api.quotation.QuotationSubscribeHandler;
import xueqiao.quotation.admin.web.api.thriftapi.*;
import xueqiao.quotation.admin.web.api.thriftapi.server.QuotationAdminWebApiAdaptor;

public class QuotationAdminWebApiHandler extends QuotationAdminWebApiAdaptor {
    @Override
    public int InitApp(Properties props) {

        AppLog.e("======= SERVICE START =======" + new Date());
        return 0;
    }

    @Override
    protected CommodityActiveConfigPage reqCommodityActiveConfig(TServiceCntl oCntl, ReqCommodityActiveConfigOption option, org.soldier.platform.page.IndexedPageOption pageOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException {
        return new ContractActiveConfigHandler().reqCommodityActiveConfig(option, pageOption);
    }

    @Override
    protected CommodityActiveConfig updateCommodityActiveConfig(TServiceCntl oCntl, CommodityActiveConfig activeConfig) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException {
        return new ContractActiveConfigHandler().updateCommodityActiveConfig(activeConfig);
    }

    @Override
    protected CommodityActiveConfig addCommodityActiveConfig(TServiceCntl oCntl, CommodityActiveConfig activeConfig) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException {
        return new ContractActiveConfigHandler().addCommodityActiveConfig(activeConfig);
    }

    @Override
    protected void deleteCommodityActiveConfig(TServiceCntl oCntl, int sledCommodityId, ContractActiveType activeType, String fixedCode) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException {
        new ContractActiveConfigHandler().deleteCommodityActiveConfig(sledCommodityId, activeType, fixedCode);
    }

    @Override
    protected CommodityRegisterPage reqCommodityRegister(TServiceCntl oCntl, ReqCommodityRegisterOption option, org.soldier.platform.page.IndexedPageOption pageOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException {
        return new CommodityRegisterHandler().reqCommodityRegister(option, pageOption);
    }

    @Override
    protected CommodityRegister updateCommodityRegister(TServiceCntl oCntl, CommodityRegister commodityRegister) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException {
        return new CommodityRegisterHandler().updateCommodityRegister(commodityRegister);
    }

    @Override
    protected CommodityRegister addCommodityRegister(TServiceCntl oCntl, CommodityRegister commodityRegister) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException {
        return new CommodityRegisterHandler().addCommodityRegister(commodityRegister);
    }

    @Override
    protected void deleteCommodityRegister(TServiceCntl oCntl, int sledCommodityId, com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv platformEnv, ContractActiveType activeType, String fixedCode) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException {
        new CommodityRegisterHandler().deleteCommodityRegister(sledCommodityId, platformEnv, activeType, fixedCode);
    }

    @Override
    protected void setCommodityRegisterOrderIndex(TServiceCntl oCntl, int sledCommodityId, TechPlatformEnv platformEnv, int orderIndex, ContractActiveType activeType, String fixedCode) throws ErrorInfo, TException {
        new CommodityRegisterHandler().setOrderIndex(sledCommodityId, platformEnv, orderIndex, activeType, fixedCode);
    }

    @Override
    protected QuotationAccountInfoPage reqQuotationAccountInfo(TServiceCntl oCntl, ReqQuotationAccountInfoOption option, org.soldier.platform.page.IndexedPageOption pageOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException {
        return new QuotationAccountHandler().reqQuotationAccountInfo(option, pageOption);
    }

    @Override
    protected QuotationAccountInfo updateQuotationAccountInfo(TServiceCntl oCntl, QuotationAccountInfo quotationAccountInfo) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException {
        return new QuotationAccountHandler().updateQuotationAccountInfo(quotationAccountInfo);
    }

    @Override
    protected QuotationAccountInfo addQuotationAccountInfo(TServiceCntl oCntl, QuotationAccountInfo quotationAccountInfo) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException {
        return new QuotationAccountHandler().addQuotationAccountInfo(quotationAccountInfo);
    }

    @Override
    protected void deleteQuotationAccount(TServiceCntl oCntl, long accountId) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException {
        new QuotationAccountHandler().deleteQuotationAccount(accountId);
    }

    @Override
    protected List<ExchangeRegisterAbility> reqExchangeRegisterAbility(TServiceCntl oCntl, ReqAccountRegisterAbilityOption option) throws ErrorInfo, TException {
        return new QuotationAccountHandler().reqExchangeAbility(option);
    }

    @Override
    protected void batAddAccountRegisterAbility(TServiceCntl oCntl, List<AccountRegisterAbility> abilities) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException {
        new QuotationAccountHandler().addAccountRegisterAbilities(abilities);
    }

    @Override
    protected void deleteAccountRegisterAbility(TServiceCntl oCntl, long abilityId) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException {
        new QuotationAccountHandler().deleteAccountRegisterAbility(abilityId);
    }

    @Override
    protected void deleteAccountRegisterAbilityByExchange(TServiceCntl oCntl, long accountId, int exchangeId) throws ErrorInfo, TException {
        new QuotationAccountHandler().deleteAccountRegisterAbilityByExchange(accountId, exchangeId);
    }

    @Override
    protected SubscribedContractPage reqSubscribedContract(TServiceCntl oCntl, ReqSubscribedContractOption option, org.soldier.platform.page.IndexedPageOption pageOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException {
        return new QuotationSubscribeHandler().reqSubscribedContract(option, pageOption);
    }

    @Override
    protected void replanSubscribe(TServiceCntl oCntl, TechPlatformEnv platformEnv) throws ErrorInfo, TException {
        new QuotationSubscribeHandler().rePlan();
    }

    @Override
    protected RePlanSubscribedInfoPreviewPage reqPreviewSubscribedContract(TServiceCntl oCntl, ReqRePlanSubscribedInfoPreviewOption option, IndexedPageOption pageOption) throws ErrorInfo, TException {
        return new QuotationSubscribeHandler().reqPreview(option);
    }

    @Override
    protected void submitSubscribeInfo(TServiceCntl oCntl, TechPlatformEnv platformEnv) throws ErrorInfo, TException {
        new QuotationSubscribeHandler().submitPreviewSubscribe();
    }

    @Override
    protected List<PlanningSubscribedInfo> reqPlanningSubscribedInfo(TServiceCntl oCntl, ReqPlanningSubscribedInfoOption option) throws ErrorInfo, TException {
        return new QuotationSubscribeHandler().reqPlanningSubscribedInfo(option);
    }

    @Override
    protected Tree reqCommodityTree(TServiceCntl oCntl, TechPlatformEnv platformEnv) throws ErrorInfo, TException {
        return new ContractTreeNodeHandler().reqCommodityTree(platformEnv);
    }

    @Override
    protected Tree reqCommodityTypeTree(TServiceCntl oCntl, TechPlatformEnv platformEnv) throws ErrorInfo, TException {
        return new ContractTreeNodeHandler().reqCommodityTypeTree(platformEnv);
    }

    @Override
    protected List<ContractTreeNode> reqContractTreeCommodityNodes(TServiceCntl oCntl, int exchangeId, SledCommodityType commodityType, TechPlatformEnv platformEnv) throws ErrorInfo, TException {
        return new ContractTreeNodeHandler().reqCommodityNodes(exchangeId, commodityType, platformEnv);
    }

    @Override
    protected List<ContractTreeNode> reqContractNodes(TServiceCntl oCntl, int sledCommodityId, TechPlatformEnv platformEnv) throws ErrorInfo, TException {
        return new ContractTreeNodeHandler().reqContractNodes(sledCommodityId, platformEnv);
    }

    @Override
    protected Tree reqBrokerTree(TServiceCntl oCntl, TechPlatformEnv platformEnv) throws ErrorInfo, TException {
        return new BrokerTreeNodeHandler().reqBrokerTree(platformEnv);
    }

    @Override
    public void destroy() {
    }
}
