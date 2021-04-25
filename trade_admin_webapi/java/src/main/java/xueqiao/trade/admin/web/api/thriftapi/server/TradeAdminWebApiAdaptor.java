package xueqiao.trade.admin.web.api.thriftapi.server;

import java.util.Properties;
import org.soldier.platform.svr_platform.container.TServiceCntl;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import xueqiao.trade.admin.web.api.thriftapi.AccountRegisterAbility;
import xueqiao.trade.admin.web.api.thriftapi.AccountRegisterAbilityPage;
import xueqiao.trade.admin.web.api.thriftapi.CommodityActiveConfig;
import xueqiao.trade.admin.web.api.thriftapi.CommodityActiveConfigPage;
import xueqiao.trade.admin.web.api.thriftapi.CommodityRegister;
import xueqiao.trade.admin.web.api.thriftapi.CommodityRegisterPage;
import xueqiao.trade.admin.web.api.thriftapi.ContractTreeNode;
import xueqiao.trade.admin.web.api.thriftapi.QuotationAccountInfo;
import xueqiao.trade.admin.web.api.thriftapi.QuotationAccountInfoPage;
import xueqiao.trade.admin.web.api.thriftapi.ReqAccountRegisterAbilityOption;
import xueqiao.trade.admin.web.api.thriftapi.ReqCommodityActiveConfigOption;
import xueqiao.trade.admin.web.api.thriftapi.ReqCommodityRegisterOption;
import xueqiao.trade.admin.web.api.thriftapi.ReqQuotationAccountInfoOption;
import xueqiao.trade.admin.web.api.thriftapi.ReqSubscribedContractOption;
import xueqiao.trade.admin.web.api.thriftapi.SubscribedContractPage;
import xueqiao.trade.admin.web.api.thriftapi.TradeAdminWebApi;
import xueqiao.trade.admin.web.api.thriftapi.TradeAdminWebApiVariable;


public abstract class TradeAdminWebApiAdaptor implements TradeAdminWebApi.Iface{
  // unmodified map, so we do not need lock for this 
  private final Map<String, String[]> methodParameterNameMap = new HashMap<String, String[]>(); 

  public String[] getMethodParameterName(String methodName) {
    return methodParameterNameMap.get(methodName);
  }

  @Override
  public CommodityActiveConfigPage reqCommodityActiveConfig(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, ReqCommodityActiveConfigOption option, org.soldier.platform.page.IndexedPageOption pageOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(TradeAdminWebApiVariable.serviceKey,"reqCommodityActiveConfig",platformArgs);
    return reqCommodityActiveConfig(oCntl, option, pageOption);
  }

  protected abstract CommodityActiveConfigPage reqCommodityActiveConfig(TServiceCntl oCntl, ReqCommodityActiveConfigOption option, org.soldier.platform.page.IndexedPageOption pageOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public CommodityActiveConfig updateCommodityActiveConfig(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, CommodityActiveConfig activeConfig) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(TradeAdminWebApiVariable.serviceKey,"updateCommodityActiveConfig",platformArgs);
    return updateCommodityActiveConfig(oCntl, activeConfig);
  }

  protected abstract CommodityActiveConfig updateCommodityActiveConfig(TServiceCntl oCntl, CommodityActiveConfig activeConfig) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public CommodityActiveConfig addCommodityActiveConfig(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, CommodityActiveConfig activeConfig) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(TradeAdminWebApiVariable.serviceKey,"addCommodityActiveConfig",platformArgs);
    return addCommodityActiveConfig(oCntl, activeConfig);
  }

  protected abstract CommodityActiveConfig addCommodityActiveConfig(TServiceCntl oCntl, CommodityActiveConfig activeConfig) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public void deleteCommodityActiveConfig(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, int sledCommodityId) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(TradeAdminWebApiVariable.serviceKey,"deleteCommodityActiveConfig",platformArgs);
deleteCommodityActiveConfig(oCntl, sledCommodityId);
  }

  protected abstract void deleteCommodityActiveConfig(TServiceCntl oCntl, int sledCommodityId) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public CommodityRegisterPage reqCommodityRegister(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, ReqCommodityRegisterOption option, org.soldier.platform.page.IndexedPageOption pageOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(TradeAdminWebApiVariable.serviceKey,"reqCommodityRegister",platformArgs);
    return reqCommodityRegister(oCntl, option, pageOption);
  }

  protected abstract CommodityRegisterPage reqCommodityRegister(TServiceCntl oCntl, ReqCommodityRegisterOption option, org.soldier.platform.page.IndexedPageOption pageOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public CommodityRegister updateCommodityRegister(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, CommodityRegister commodityRegister) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(TradeAdminWebApiVariable.serviceKey,"updateCommodityRegister",platformArgs);
    return updateCommodityRegister(oCntl, commodityRegister);
  }

  protected abstract CommodityRegister updateCommodityRegister(TServiceCntl oCntl, CommodityRegister commodityRegister) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public CommodityRegister addCommodityRegister(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, CommodityRegister commodityRegister) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(TradeAdminWebApiVariable.serviceKey,"addCommodityRegister",platformArgs);
    return addCommodityRegister(oCntl, commodityRegister);
  }

  protected abstract CommodityRegister addCommodityRegister(TServiceCntl oCntl, CommodityRegister commodityRegister) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public void deleteCommodityRegister(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, int sledCommodityId, com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv platformEnv) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(TradeAdminWebApiVariable.serviceKey,"deleteCommodityRegister",platformArgs);
deleteCommodityRegister(oCntl, sledCommodityId, platformEnv);
  }

  protected abstract void deleteCommodityRegister(TServiceCntl oCntl, int sledCommodityId, com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv platformEnv) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public QuotationAccountInfoPage reqQuotationAccountInfo(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, ReqQuotationAccountInfoOption option, org.soldier.platform.page.IndexedPageOption pageOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(TradeAdminWebApiVariable.serviceKey,"reqQuotationAccountInfo",platformArgs);
    return reqQuotationAccountInfo(oCntl, option, pageOption);
  }

  protected abstract QuotationAccountInfoPage reqQuotationAccountInfo(TServiceCntl oCntl, ReqQuotationAccountInfoOption option, org.soldier.platform.page.IndexedPageOption pageOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public QuotationAccountInfo updateQuotationAccountInfo(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, QuotationAccountInfo quotationAccountInfo) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(TradeAdminWebApiVariable.serviceKey,"updateQuotationAccountInfo",platformArgs);
    return updateQuotationAccountInfo(oCntl, quotationAccountInfo);
  }

  protected abstract QuotationAccountInfo updateQuotationAccountInfo(TServiceCntl oCntl, QuotationAccountInfo quotationAccountInfo) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public QuotationAccountInfo addQuotationAccountInfo(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, QuotationAccountInfo quotationAccountInfo) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(TradeAdminWebApiVariable.serviceKey,"addQuotationAccountInfo",platformArgs);
    return addQuotationAccountInfo(oCntl, quotationAccountInfo);
  }

  protected abstract QuotationAccountInfo addQuotationAccountInfo(TServiceCntl oCntl, QuotationAccountInfo quotationAccountInfo) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public void deleteQuotationAccount(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, long accountId) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(TradeAdminWebApiVariable.serviceKey,"deleteQuotationAccount",platformArgs);
deleteQuotationAccount(oCntl, accountId);
  }

  protected abstract void deleteQuotationAccount(TServiceCntl oCntl, long accountId) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public AccountRegisterAbilityPage reqAccountRegisterAbility(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, ReqAccountRegisterAbilityOption option, org.soldier.platform.page.IndexedPageOption pageOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(TradeAdminWebApiVariable.serviceKey,"reqAccountRegisterAbility",platformArgs);
    return reqAccountRegisterAbility(oCntl, option, pageOption);
  }

  protected abstract AccountRegisterAbilityPage reqAccountRegisterAbility(TServiceCntl oCntl, ReqAccountRegisterAbilityOption option, org.soldier.platform.page.IndexedPageOption pageOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public AccountRegisterAbility addAccountRegisterAbility(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, AccountRegisterAbility ability) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(TradeAdminWebApiVariable.serviceKey,"addAccountRegisterAbility",platformArgs);
    return addAccountRegisterAbility(oCntl, ability);
  }

  protected abstract AccountRegisterAbility addAccountRegisterAbility(TServiceCntl oCntl, AccountRegisterAbility ability) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public void deleteAccountRegisterAbility(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, long accountId, int sledCommodityId) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(TradeAdminWebApiVariable.serviceKey,"deleteAccountRegisterAbility",platformArgs);
deleteAccountRegisterAbility(oCntl, accountId, sledCommodityId);
  }

  protected abstract void deleteAccountRegisterAbility(TServiceCntl oCntl, long accountId, int sledCommodityId) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public SubscribedContractPage reqSubscribedContract(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, ReqSubscribedContractOption option, org.soldier.platform.page.IndexedPageOption pageOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(TradeAdminWebApiVariable.serviceKey,"reqSubscribedContract",platformArgs);
    return reqSubscribedContract(oCntl, option, pageOption);
  }

  protected abstract SubscribedContractPage reqSubscribedContract(TServiceCntl oCntl, ReqSubscribedContractOption option, org.soldier.platform.page.IndexedPageOption pageOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public List<ContractTreeNode> reqContractTreeExchangeNodes(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv platformEnv) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(TradeAdminWebApiVariable.serviceKey,"reqContractTreeExchangeNodes",platformArgs);
    return reqContractTreeExchangeNodes(oCntl, platformEnv);
  }

  protected abstract List<ContractTreeNode> reqContractTreeExchangeNodes(TServiceCntl oCntl, com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv platformEnv) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public List<ContractTreeNode> reqContractTreeCommodityNodes(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, String exchangeMic, com.longsheng.xueqiao.contract.standard.thriftapi.SledCommodityType commodityType, com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv platformEnv) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(TradeAdminWebApiVariable.serviceKey,"reqContractTreeCommodityNodes",platformArgs);
    return reqContractTreeCommodityNodes(oCntl, exchangeMic, commodityType, platformEnv);
  }

  protected abstract List<ContractTreeNode> reqContractTreeCommodityNodes(TServiceCntl oCntl, String exchangeMic, com.longsheng.xueqiao.contract.standard.thriftapi.SledCommodityType commodityType, com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv platformEnv) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public List<ContractTreeNode> reqContractTreeContractNodes(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, int sledCommodityId, com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv platformEnv) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(TradeAdminWebApiVariable.serviceKey,"reqContractTreeContractNodes",platformArgs);
    return reqContractTreeContractNodes(oCntl, sledCommodityId, platformEnv);
  }

  protected abstract List<ContractTreeNode> reqContractTreeContractNodes(TServiceCntl oCntl, int sledCommodityId, com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv platformEnv) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  protected TradeAdminWebApiAdaptor(){
    methodParameterNameMap.put("reqCommodityActiveConfig",new String[]{"platformArgs", "option", "pageOption"});
    methodParameterNameMap.put("updateCommodityActiveConfig",new String[]{"platformArgs", "activeConfig"});
    methodParameterNameMap.put("addCommodityActiveConfig",new String[]{"platformArgs", "activeConfig"});
    methodParameterNameMap.put("deleteCommodityActiveConfig",new String[]{"platformArgs", "sledCommodityId"});
    methodParameterNameMap.put("reqCommodityRegister",new String[]{"platformArgs", "option", "pageOption"});
    methodParameterNameMap.put("updateCommodityRegister",new String[]{"platformArgs", "commodityRegister"});
    methodParameterNameMap.put("addCommodityRegister",new String[]{"platformArgs", "commodityRegister"});
    methodParameterNameMap.put("deleteCommodityRegister",new String[]{"platformArgs", "sledCommodityId", "platformEnv"});
    methodParameterNameMap.put("reqQuotationAccountInfo",new String[]{"platformArgs", "option", "pageOption"});
    methodParameterNameMap.put("updateQuotationAccountInfo",new String[]{"platformArgs", "quotationAccountInfo"});
    methodParameterNameMap.put("addQuotationAccountInfo",new String[]{"platformArgs", "quotationAccountInfo"});
    methodParameterNameMap.put("deleteQuotationAccount",new String[]{"platformArgs", "accountId"});
    methodParameterNameMap.put("reqAccountRegisterAbility",new String[]{"platformArgs", "option", "pageOption"});
    methodParameterNameMap.put("addAccountRegisterAbility",new String[]{"platformArgs", "ability"});
    methodParameterNameMap.put("deleteAccountRegisterAbility",new String[]{"platformArgs", "accountId", "sledCommodityId"});
    methodParameterNameMap.put("reqSubscribedContract",new String[]{"platformArgs", "option", "pageOption"});
    methodParameterNameMap.put("reqContractTreeExchangeNodes",new String[]{"platformArgs", "platformEnv"});
    methodParameterNameMap.put("reqContractTreeCommodityNodes",new String[]{"platformArgs", "exchangeMic", "commodityType", "platformEnv"});
    methodParameterNameMap.put("reqContractTreeContractNodes",new String[]{"platformArgs", "sledCommodityId", "platformEnv"});
  }
  protected abstract int InitApp(final Properties props);

  protected abstract void destroy();

}
