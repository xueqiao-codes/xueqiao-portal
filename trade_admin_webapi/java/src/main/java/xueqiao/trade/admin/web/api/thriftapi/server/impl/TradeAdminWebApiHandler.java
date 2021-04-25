package xueqiao.trade.admin.web.api.thriftapi.server.impl;


import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.apache.thrift.TException;
import org.soldier.base.logger.AppLog;
import org.soldier.platform.page.IndexedPageOption;
import org.soldier.platform.svr_platform.comm.ErrorInfo;
import org.soldier.platform.svr_platform.container.TServiceCntl;
import xueqiao.trade.admin.web.api.contract.ContractTreeNodeHandler;
import xueqiao.trade.admin.web.api.quotation.CommodityRegisterHandler;
import xueqiao.trade.admin.web.api.quotation.ContractActiveConfigHandler;
import xueqiao.trade.admin.web.api.quotation.QuotationAccountHandler;
import xueqiao.trade.admin.web.api.thriftapi.*;
import xueqiao.trade.admin.web.api.thriftapi.server.TradeAdminWebApiAdaptor;

public class TradeAdminWebApiHandler extends TradeAdminWebApiAdaptor {
    @Override
    public int InitApp(Properties props) {
        AppLog.e("======= SERVICE START ======="+ new Date());
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
    protected void deleteCommodityActiveConfig(TServiceCntl oCntl, int sledCommodityId) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException {
        new ContractActiveConfigHandler().deleteCommodityActiveConfig(sledCommodityId);
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
    protected void deleteCommodityRegister(TServiceCntl oCntl, int sledCommodityId, com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv platformEnv) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException {
        new CommodityRegisterHandler().deleteCommodityRegister(sledCommodityId, platformEnv);
    }

    @Override
    protected QuotationAccountInfoPage reqQuotationAccountInfo(TServiceCntl oCntl, ReqQuotationAccountInfoOption option, org.soldier.platform.page.IndexedPageOption pageOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException {
        return new QuotationAccountHandler().reqQuotationAccountInfo(option,pageOption);
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
    protected AccountRegisterAbilityPage reqAccountRegisterAbility(TServiceCntl oCntl, ReqAccountRegisterAbilityOption option, org.soldier.platform.page.IndexedPageOption pageOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException {
        return new QuotationAccountHandler().reqAccountRegisterAbility(option,pageOption);
    }

    @Override
    protected AccountRegisterAbility addAccountRegisterAbility(TServiceCntl oCntl, AccountRegisterAbility ability) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException {
        return new QuotationAccountHandler().addAccountRegisterAbility(ability);
    }

    @Override
    protected void deleteAccountRegisterAbility(TServiceCntl oCntl, long accountId, int sledCommodityId) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException {
        new QuotationAccountHandler().deleteAccountRegisterAbility(accountId,sledCommodityId);
    }

    @Override
    protected SubscribedContractPage reqSubscribedContract(TServiceCntl oCntl, ReqSubscribedContractOption option, IndexedPageOption pageOption) throws ErrorInfo, TException {
        return null;
    }

    @Override
    protected List<ContractTreeNode> reqContractTreeExchangeNodes(TServiceCntl oCntl, com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv platformEnv) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException {
        return new ContractTreeNodeHandler().reqExchangeNodes(platformEnv);
    }

    @Override
    protected List<ContractTreeNode> reqContractTreeCommodityNodes(TServiceCntl oCntl, String exchangeMic, com.longsheng.xueqiao.contract.standard.thriftapi.SledCommodityType commodityType, com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv platformEnv) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException {
        return new ContractTreeNodeHandler().reqCommodityNodes(exchangeMic, commodityType, platformEnv);
    }

    @Override
    protected List<ContractTreeNode> reqContractTreeContractNodes(TServiceCntl oCntl, int sledCommodityId, com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv platformEnv) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException {
        return new ContractTreeNodeHandler().reqContractNodes(sledCommodityId, platformEnv);
    }

    @Override
    public void destroy() {
    }
}
