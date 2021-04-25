package xueqiao.quotation.admin.web.api.thriftapi.server;

import java.util.Properties;
import org.soldier.platform.svr_platform.container.TServiceCntl;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import xueqiao.quotation.admin.web.api.thriftapi.AccountRegisterAbility;
import xueqiao.quotation.admin.web.api.thriftapi.CommodityActiveConfig;
import xueqiao.quotation.admin.web.api.thriftapi.CommodityActiveConfigPage;
import xueqiao.quotation.admin.web.api.thriftapi.CommodityRegister;
import xueqiao.quotation.admin.web.api.thriftapi.CommodityRegisterPage;
import xueqiao.quotation.admin.web.api.thriftapi.ContractTreeNode;
import xueqiao.quotation.admin.web.api.thriftapi.ExchangeRegisterAbility;
import xueqiao.quotation.admin.web.api.thriftapi.PlanningSubscribedInfo;
import xueqiao.quotation.admin.web.api.thriftapi.QuotationAccountInfo;
import xueqiao.quotation.admin.web.api.thriftapi.QuotationAccountInfoPage;
import xueqiao.quotation.admin.web.api.thriftapi.RePlanSubscribedInfoPreviewPage;
import xueqiao.quotation.admin.web.api.thriftapi.ReqAccountRegisterAbilityOption;
import xueqiao.quotation.admin.web.api.thriftapi.ReqCommodityActiveConfigOption;
import xueqiao.quotation.admin.web.api.thriftapi.ReqCommodityRegisterOption;
import xueqiao.quotation.admin.web.api.thriftapi.ReqPlanningSubscribedInfoOption;
import xueqiao.quotation.admin.web.api.thriftapi.ReqQuotationAccountInfoOption;
import xueqiao.quotation.admin.web.api.thriftapi.ReqRePlanSubscribedInfoPreviewOption;
import xueqiao.quotation.admin.web.api.thriftapi.ReqSubscribedContractOption;
import xueqiao.quotation.admin.web.api.thriftapi.SubscribedContractPage;
import xueqiao.quotation.admin.web.api.thriftapi.Tree;
import xueqiao.quotation.admin.web.api.thriftapi.QuotationAdminWebApi;
import xueqiao.quotation.admin.web.api.thriftapi.QuotationAdminWebApiVariable;


public abstract class QuotationAdminWebApiAdaptor implements QuotationAdminWebApi.Iface{
  // unmodified map, so we do not need lock for this 
  private final Map<String, String[]> methodParameterNameMap = new HashMap<String, String[]>(); 

  public String[] getMethodParameterName(String methodName) {
    return methodParameterNameMap.get(methodName);
  }

  @Override
  public CommodityActiveConfigPage reqCommodityActiveConfig(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, ReqCommodityActiveConfigOption option, org.soldier.platform.page.IndexedPageOption pageOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(QuotationAdminWebApiVariable.serviceKey,"reqCommodityActiveConfig",platformArgs);
    return reqCommodityActiveConfig(oCntl, option, pageOption);
  }

  protected abstract CommodityActiveConfigPage reqCommodityActiveConfig(TServiceCntl oCntl, ReqCommodityActiveConfigOption option, org.soldier.platform.page.IndexedPageOption pageOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public CommodityActiveConfig updateCommodityActiveConfig(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, CommodityActiveConfig activeConfig) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(QuotationAdminWebApiVariable.serviceKey,"updateCommodityActiveConfig",platformArgs);
    return updateCommodityActiveConfig(oCntl, activeConfig);
  }

  protected abstract CommodityActiveConfig updateCommodityActiveConfig(TServiceCntl oCntl, CommodityActiveConfig activeConfig) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public CommodityActiveConfig addCommodityActiveConfig(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, CommodityActiveConfig activeConfig) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(QuotationAdminWebApiVariable.serviceKey,"addCommodityActiveConfig",platformArgs);
    return addCommodityActiveConfig(oCntl, activeConfig);
  }

  protected abstract CommodityActiveConfig addCommodityActiveConfig(TServiceCntl oCntl, CommodityActiveConfig activeConfig) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public void deleteCommodityActiveConfig(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, int sledCommodityId, xueqiao.quotation.account.thriftapi.ContractActiveType activeType, String fixedCode) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(QuotationAdminWebApiVariable.serviceKey,"deleteCommodityActiveConfig",platformArgs);
deleteCommodityActiveConfig(oCntl, sledCommodityId, activeType, fixedCode);
  }

  protected abstract void deleteCommodityActiveConfig(TServiceCntl oCntl, int sledCommodityId, xueqiao.quotation.account.thriftapi.ContractActiveType activeType, String fixedCode) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public CommodityRegisterPage reqCommodityRegister(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, ReqCommodityRegisterOption option, org.soldier.platform.page.IndexedPageOption pageOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(QuotationAdminWebApiVariable.serviceKey,"reqCommodityRegister",platformArgs);
    return reqCommodityRegister(oCntl, option, pageOption);
  }

  protected abstract CommodityRegisterPage reqCommodityRegister(TServiceCntl oCntl, ReqCommodityRegisterOption option, org.soldier.platform.page.IndexedPageOption pageOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public CommodityRegister updateCommodityRegister(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, CommodityRegister commodityRegister) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(QuotationAdminWebApiVariable.serviceKey,"updateCommodityRegister",platformArgs);
    return updateCommodityRegister(oCntl, commodityRegister);
  }

  protected abstract CommodityRegister updateCommodityRegister(TServiceCntl oCntl, CommodityRegister commodityRegister) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public CommodityRegister addCommodityRegister(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, CommodityRegister commodityRegister) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(QuotationAdminWebApiVariable.serviceKey,"addCommodityRegister",platformArgs);
    return addCommodityRegister(oCntl, commodityRegister);
  }

  protected abstract CommodityRegister addCommodityRegister(TServiceCntl oCntl, CommodityRegister commodityRegister) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public void deleteCommodityRegister(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, int sledCommodityId, com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv platformEnv, xueqiao.quotation.account.thriftapi.ContractActiveType activeType, String fixedCode) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(QuotationAdminWebApiVariable.serviceKey,"deleteCommodityRegister",platformArgs);
deleteCommodityRegister(oCntl, sledCommodityId, platformEnv, activeType, fixedCode);
  }

  protected abstract void deleteCommodityRegister(TServiceCntl oCntl, int sledCommodityId, com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv platformEnv, xueqiao.quotation.account.thriftapi.ContractActiveType activeType, String fixedCode) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public void setCommodityRegisterOrderIndex(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, int sledCommodityId, com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv platformEnv, int orderIndex, xueqiao.quotation.account.thriftapi.ContractActiveType activeType, String fixedCode) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(QuotationAdminWebApiVariable.serviceKey,"setCommodityRegisterOrderIndex",platformArgs);
setCommodityRegisterOrderIndex(oCntl, sledCommodityId, platformEnv, orderIndex, activeType, fixedCode);
  }

  protected abstract void setCommodityRegisterOrderIndex(TServiceCntl oCntl, int sledCommodityId, com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv platformEnv, int orderIndex, xueqiao.quotation.account.thriftapi.ContractActiveType activeType, String fixedCode) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public QuotationAccountInfoPage reqQuotationAccountInfo(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, ReqQuotationAccountInfoOption option, org.soldier.platform.page.IndexedPageOption pageOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(QuotationAdminWebApiVariable.serviceKey,"reqQuotationAccountInfo",platformArgs);
    return reqQuotationAccountInfo(oCntl, option, pageOption);
  }

  protected abstract QuotationAccountInfoPage reqQuotationAccountInfo(TServiceCntl oCntl, ReqQuotationAccountInfoOption option, org.soldier.platform.page.IndexedPageOption pageOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public QuotationAccountInfo updateQuotationAccountInfo(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, QuotationAccountInfo quotationAccountInfo) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(QuotationAdminWebApiVariable.serviceKey,"updateQuotationAccountInfo",platformArgs);
    return updateQuotationAccountInfo(oCntl, quotationAccountInfo);
  }

  protected abstract QuotationAccountInfo updateQuotationAccountInfo(TServiceCntl oCntl, QuotationAccountInfo quotationAccountInfo) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public QuotationAccountInfo addQuotationAccountInfo(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, QuotationAccountInfo quotationAccountInfo) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(QuotationAdminWebApiVariable.serviceKey,"addQuotationAccountInfo",platformArgs);
    return addQuotationAccountInfo(oCntl, quotationAccountInfo);
  }

  protected abstract QuotationAccountInfo addQuotationAccountInfo(TServiceCntl oCntl, QuotationAccountInfo quotationAccountInfo) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public void deleteQuotationAccount(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, long accountId) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(QuotationAdminWebApiVariable.serviceKey,"deleteQuotationAccount",platformArgs);
deleteQuotationAccount(oCntl, accountId);
  }

  protected abstract void deleteQuotationAccount(TServiceCntl oCntl, long accountId) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public List<ExchangeRegisterAbility> reqExchangeRegisterAbility(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, ReqAccountRegisterAbilityOption option) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(QuotationAdminWebApiVariable.serviceKey,"reqExchangeRegisterAbility",platformArgs);
    return reqExchangeRegisterAbility(oCntl, option);
  }

  protected abstract List<ExchangeRegisterAbility> reqExchangeRegisterAbility(TServiceCntl oCntl, ReqAccountRegisterAbilityOption option) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public void batAddAccountRegisterAbility(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, List<AccountRegisterAbility> abilities) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(QuotationAdminWebApiVariable.serviceKey,"batAddAccountRegisterAbility",platformArgs);
batAddAccountRegisterAbility(oCntl, abilities);
  }

  protected abstract void batAddAccountRegisterAbility(TServiceCntl oCntl, List<AccountRegisterAbility> abilities) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public void deleteAccountRegisterAbility(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, long abilityId) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(QuotationAdminWebApiVariable.serviceKey,"deleteAccountRegisterAbility",platformArgs);
deleteAccountRegisterAbility(oCntl, abilityId);
  }

  protected abstract void deleteAccountRegisterAbility(TServiceCntl oCntl, long abilityId) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public void deleteAccountRegisterAbilityByExchange(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, long accountId, int exchangeId) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(QuotationAdminWebApiVariable.serviceKey,"deleteAccountRegisterAbilityByExchange",platformArgs);
deleteAccountRegisterAbilityByExchange(oCntl, accountId, exchangeId);
  }

  protected abstract void deleteAccountRegisterAbilityByExchange(TServiceCntl oCntl, long accountId, int exchangeId) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public SubscribedContractPage reqSubscribedContract(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, ReqSubscribedContractOption option, org.soldier.platform.page.IndexedPageOption pageOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(QuotationAdminWebApiVariable.serviceKey,"reqSubscribedContract",platformArgs);
    return reqSubscribedContract(oCntl, option, pageOption);
  }

  protected abstract SubscribedContractPage reqSubscribedContract(TServiceCntl oCntl, ReqSubscribedContractOption option, org.soldier.platform.page.IndexedPageOption pageOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public void replanSubscribe(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv platformEnv) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(QuotationAdminWebApiVariable.serviceKey,"replanSubscribe",platformArgs);
replanSubscribe(oCntl, platformEnv);
  }

  protected abstract void replanSubscribe(TServiceCntl oCntl, com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv platformEnv) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public RePlanSubscribedInfoPreviewPage reqPreviewSubscribedContract(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, ReqRePlanSubscribedInfoPreviewOption option, org.soldier.platform.page.IndexedPageOption pageOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(QuotationAdminWebApiVariable.serviceKey,"reqPreviewSubscribedContract",platformArgs);
    return reqPreviewSubscribedContract(oCntl, option, pageOption);
  }

  protected abstract RePlanSubscribedInfoPreviewPage reqPreviewSubscribedContract(TServiceCntl oCntl, ReqRePlanSubscribedInfoPreviewOption option, org.soldier.platform.page.IndexedPageOption pageOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public void submitSubscribeInfo(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv platformEnv) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(QuotationAdminWebApiVariable.serviceKey,"submitSubscribeInfo",platformArgs);
submitSubscribeInfo(oCntl, platformEnv);
  }

  protected abstract void submitSubscribeInfo(TServiceCntl oCntl, com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv platformEnv) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public List<PlanningSubscribedInfo> reqPlanningSubscribedInfo(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, ReqPlanningSubscribedInfoOption option) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(QuotationAdminWebApiVariable.serviceKey,"reqPlanningSubscribedInfo",platformArgs);
    return reqPlanningSubscribedInfo(oCntl, option);
  }

  protected abstract List<PlanningSubscribedInfo> reqPlanningSubscribedInfo(TServiceCntl oCntl, ReqPlanningSubscribedInfoOption option) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public Tree reqCommodityTree(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv platformEnv) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(QuotationAdminWebApiVariable.serviceKey,"reqCommodityTree",platformArgs);
    return reqCommodityTree(oCntl, platformEnv);
  }

  protected abstract Tree reqCommodityTree(TServiceCntl oCntl, com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv platformEnv) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public Tree reqCommodityTypeTree(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv platformEnv) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(QuotationAdminWebApiVariable.serviceKey,"reqCommodityTypeTree",platformArgs);
    return reqCommodityTypeTree(oCntl, platformEnv);
  }

  protected abstract Tree reqCommodityTypeTree(TServiceCntl oCntl, com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv platformEnv) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public List<ContractTreeNode> reqContractTreeCommodityNodes(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, int sledExchangeId, com.longsheng.xueqiao.contract.standard.thriftapi.SledCommodityType commodityType, com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv platformEnv) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(QuotationAdminWebApiVariable.serviceKey,"reqContractTreeCommodityNodes",platformArgs);
    return reqContractTreeCommodityNodes(oCntl, sledExchangeId, commodityType, platformEnv);
  }

  protected abstract List<ContractTreeNode> reqContractTreeCommodityNodes(TServiceCntl oCntl, int sledExchangeId, com.longsheng.xueqiao.contract.standard.thriftapi.SledCommodityType commodityType, com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv platformEnv) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public List<ContractTreeNode> reqContractNodes(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, int sledCommodityId, com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv platformEnv) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(QuotationAdminWebApiVariable.serviceKey,"reqContractNodes",platformArgs);
    return reqContractNodes(oCntl, sledCommodityId, platformEnv);
  }

  protected abstract List<ContractTreeNode> reqContractNodes(TServiceCntl oCntl, int sledCommodityId, com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv platformEnv) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public Tree reqBrokerTree(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv platformEnv) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(QuotationAdminWebApiVariable.serviceKey,"reqBrokerTree",platformArgs);
    return reqBrokerTree(oCntl, platformEnv);
  }

  protected abstract Tree reqBrokerTree(TServiceCntl oCntl, com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv platformEnv) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  protected QuotationAdminWebApiAdaptor(){
    methodParameterNameMap.put("reqCommodityActiveConfig",new String[]{"platformArgs", "option", "pageOption"});
    methodParameterNameMap.put("updateCommodityActiveConfig",new String[]{"platformArgs", "activeConfig"});
    methodParameterNameMap.put("addCommodityActiveConfig",new String[]{"platformArgs", "activeConfig"});
    methodParameterNameMap.put("deleteCommodityActiveConfig",new String[]{"platformArgs", "sledCommodityId", "activeType", "fixedCode"});
    methodParameterNameMap.put("reqCommodityRegister",new String[]{"platformArgs", "option", "pageOption"});
    methodParameterNameMap.put("updateCommodityRegister",new String[]{"platformArgs", "commodityRegister"});
    methodParameterNameMap.put("addCommodityRegister",new String[]{"platformArgs", "commodityRegister"});
    methodParameterNameMap.put("deleteCommodityRegister",new String[]{"platformArgs", "sledCommodityId", "platformEnv", "activeType", "fixedCode"});
    methodParameterNameMap.put("setCommodityRegisterOrderIndex",new String[]{"platformArgs", "sledCommodityId", "platformEnv", "orderIndex", "activeType", "fixedCode"});
    methodParameterNameMap.put("reqQuotationAccountInfo",new String[]{"platformArgs", "option", "pageOption"});
    methodParameterNameMap.put("updateQuotationAccountInfo",new String[]{"platformArgs", "quotationAccountInfo"});
    methodParameterNameMap.put("addQuotationAccountInfo",new String[]{"platformArgs", "quotationAccountInfo"});
    methodParameterNameMap.put("deleteQuotationAccount",new String[]{"platformArgs", "accountId"});
    methodParameterNameMap.put("reqExchangeRegisterAbility",new String[]{"platformArgs", "option"});
    methodParameterNameMap.put("batAddAccountRegisterAbility",new String[]{"platformArgs", "abilities"});
    methodParameterNameMap.put("deleteAccountRegisterAbility",new String[]{"platformArgs", "abilityId"});
    methodParameterNameMap.put("deleteAccountRegisterAbilityByExchange",new String[]{"platformArgs", "accountId", "exchangeId"});
    methodParameterNameMap.put("reqSubscribedContract",new String[]{"platformArgs", "option", "pageOption"});
    methodParameterNameMap.put("replanSubscribe",new String[]{"platformArgs", "platformEnv"});
    methodParameterNameMap.put("reqPreviewSubscribedContract",new String[]{"platformArgs", "option", "pageOption"});
    methodParameterNameMap.put("submitSubscribeInfo",new String[]{"platformArgs", "platformEnv"});
    methodParameterNameMap.put("reqPlanningSubscribedInfo",new String[]{"platformArgs", "option"});
    methodParameterNameMap.put("reqCommodityTree",new String[]{"platformArgs", "platformEnv"});
    methodParameterNameMap.put("reqCommodityTypeTree",new String[]{"platformArgs", "platformEnv"});
    methodParameterNameMap.put("reqContractTreeCommodityNodes",new String[]{"platformArgs", "sledExchangeId", "commodityType", "platformEnv"});
    methodParameterNameMap.put("reqContractNodes",new String[]{"platformArgs", "sledCommodityId", "platformEnv"});
    methodParameterNameMap.put("reqBrokerTree",new String[]{"platformArgs", "platformEnv"});
  }
  protected abstract int InitApp(final Properties props);

  protected abstract void destroy();

}
