package xueqiao.quotation.admin.web.api.thriftapi.client;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TProtocol;
import org.soldier.platform.svr_platform.client.BaseStub;
import org.soldier.platform.svr_platform.client.TStubOption;
import org.soldier.platform.svr_platform.comm.ErrorInfo;
import org.soldier.platform.svr_platform.comm.PlatformArgs;
import java.util.List;
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

public class QuotationAdminWebApiStub extends BaseStub {

  public QuotationAdminWebApiStub() {
    super(QuotationAdminWebApiVariable.serviceKey);
  }

  public CommodityActiveConfigPage  reqCommodityActiveConfig(ReqCommodityActiveConfigOption option, org.soldier.platform.page.IndexedPageOption pageOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return reqCommodityActiveConfig(option, pageOption, new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public CommodityActiveConfigPage  reqCommodityActiveConfig(ReqCommodityActiveConfigOption option, org.soldier.platform.page.IndexedPageOption pageOption,TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("reqCommodityActiveConfig").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    return super.runSync(new ThriftCallable<CommodityActiveConfigPage>(){
    @Override
    public CommodityActiveConfigPage call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      return new QuotationAdminWebApi.Client(protocol).reqCommodityActiveConfig(platformArgs, option, pageOption);
      }
    }, invokeInfo);
  }

  public CommodityActiveConfigPage  reqCommodityActiveConfig(int routeKey, int timeout,ReqCommodityActiveConfigOption option, org.soldier.platform.page.IndexedPageOption pageOption)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return reqCommodityActiveConfig(option, pageOption, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public CommodityActiveConfig  updateCommodityActiveConfig(CommodityActiveConfig activeConfig) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return updateCommodityActiveConfig(activeConfig, new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public CommodityActiveConfig  updateCommodityActiveConfig(CommodityActiveConfig activeConfig,TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("updateCommodityActiveConfig").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    return super.runSync(new ThriftCallable<CommodityActiveConfig>(){
    @Override
    public CommodityActiveConfig call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      return new QuotationAdminWebApi.Client(protocol).updateCommodityActiveConfig(platformArgs, activeConfig);
      }
    }, invokeInfo);
  }

  public CommodityActiveConfig  updateCommodityActiveConfig(int routeKey, int timeout,CommodityActiveConfig activeConfig)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return updateCommodityActiveConfig(activeConfig, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public CommodityActiveConfig  addCommodityActiveConfig(CommodityActiveConfig activeConfig) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return addCommodityActiveConfig(activeConfig, new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public CommodityActiveConfig  addCommodityActiveConfig(CommodityActiveConfig activeConfig,TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("addCommodityActiveConfig").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    return super.runSync(new ThriftCallable<CommodityActiveConfig>(){
    @Override
    public CommodityActiveConfig call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      return new QuotationAdminWebApi.Client(protocol).addCommodityActiveConfig(platformArgs, activeConfig);
      }
    }, invokeInfo);
  }

  public CommodityActiveConfig  addCommodityActiveConfig(int routeKey, int timeout,CommodityActiveConfig activeConfig)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return addCommodityActiveConfig(activeConfig, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public void  deleteCommodityActiveConfig(int sledCommodityId, xueqiao.quotation.account.thriftapi.ContractActiveType activeType, String fixedCode) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    deleteCommodityActiveConfig(sledCommodityId, activeType, fixedCode, new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public void  deleteCommodityActiveConfig(int sledCommodityId, xueqiao.quotation.account.thriftapi.ContractActiveType activeType, String fixedCode,TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("deleteCommodityActiveConfig").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    super.runSync(new ThriftCallable<Void>(){
    @Override
    public Void call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      new QuotationAdminWebApi.Client(protocol).deleteCommodityActiveConfig(platformArgs, sledCommodityId, activeType, fixedCode);
      return null;
      }
    }, invokeInfo);
  }

  public void  deleteCommodityActiveConfig(int routeKey, int timeout,int sledCommodityId, xueqiao.quotation.account.thriftapi.ContractActiveType activeType, String fixedCode)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    deleteCommodityActiveConfig(sledCommodityId, activeType, fixedCode, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public CommodityRegisterPage  reqCommodityRegister(ReqCommodityRegisterOption option, org.soldier.platform.page.IndexedPageOption pageOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return reqCommodityRegister(option, pageOption, new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public CommodityRegisterPage  reqCommodityRegister(ReqCommodityRegisterOption option, org.soldier.platform.page.IndexedPageOption pageOption,TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("reqCommodityRegister").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    return super.runSync(new ThriftCallable<CommodityRegisterPage>(){
    @Override
    public CommodityRegisterPage call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      return new QuotationAdminWebApi.Client(protocol).reqCommodityRegister(platformArgs, option, pageOption);
      }
    }, invokeInfo);
  }

  public CommodityRegisterPage  reqCommodityRegister(int routeKey, int timeout,ReqCommodityRegisterOption option, org.soldier.platform.page.IndexedPageOption pageOption)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return reqCommodityRegister(option, pageOption, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public CommodityRegister  updateCommodityRegister(CommodityRegister commodityRegister) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return updateCommodityRegister(commodityRegister, new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public CommodityRegister  updateCommodityRegister(CommodityRegister commodityRegister,TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("updateCommodityRegister").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    return super.runSync(new ThriftCallable<CommodityRegister>(){
    @Override
    public CommodityRegister call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      return new QuotationAdminWebApi.Client(protocol).updateCommodityRegister(platformArgs, commodityRegister);
      }
    }, invokeInfo);
  }

  public CommodityRegister  updateCommodityRegister(int routeKey, int timeout,CommodityRegister commodityRegister)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return updateCommodityRegister(commodityRegister, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public CommodityRegister  addCommodityRegister(CommodityRegister commodityRegister) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return addCommodityRegister(commodityRegister, new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public CommodityRegister  addCommodityRegister(CommodityRegister commodityRegister,TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("addCommodityRegister").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    return super.runSync(new ThriftCallable<CommodityRegister>(){
    @Override
    public CommodityRegister call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      return new QuotationAdminWebApi.Client(protocol).addCommodityRegister(platformArgs, commodityRegister);
      }
    }, invokeInfo);
  }

  public CommodityRegister  addCommodityRegister(int routeKey, int timeout,CommodityRegister commodityRegister)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return addCommodityRegister(commodityRegister, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public void  deleteCommodityRegister(int sledCommodityId, com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv platformEnv, xueqiao.quotation.account.thriftapi.ContractActiveType activeType, String fixedCode) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    deleteCommodityRegister(sledCommodityId, platformEnv, activeType, fixedCode, new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public void  deleteCommodityRegister(int sledCommodityId, com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv platformEnv, xueqiao.quotation.account.thriftapi.ContractActiveType activeType, String fixedCode,TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("deleteCommodityRegister").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    super.runSync(new ThriftCallable<Void>(){
    @Override
    public Void call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      new QuotationAdminWebApi.Client(protocol).deleteCommodityRegister(platformArgs, sledCommodityId, platformEnv, activeType, fixedCode);
      return null;
      }
    }, invokeInfo);
  }

  public void  deleteCommodityRegister(int routeKey, int timeout,int sledCommodityId, com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv platformEnv, xueqiao.quotation.account.thriftapi.ContractActiveType activeType, String fixedCode)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    deleteCommodityRegister(sledCommodityId, platformEnv, activeType, fixedCode, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public void  setCommodityRegisterOrderIndex(int sledCommodityId, com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv platformEnv, int orderIndex, xueqiao.quotation.account.thriftapi.ContractActiveType activeType, String fixedCode) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    setCommodityRegisterOrderIndex(sledCommodityId, platformEnv, orderIndex, activeType, fixedCode, new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public void  setCommodityRegisterOrderIndex(int sledCommodityId, com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv platformEnv, int orderIndex, xueqiao.quotation.account.thriftapi.ContractActiveType activeType, String fixedCode,TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("setCommodityRegisterOrderIndex").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    super.runSync(new ThriftCallable<Void>(){
    @Override
    public Void call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      new QuotationAdminWebApi.Client(protocol).setCommodityRegisterOrderIndex(platformArgs, sledCommodityId, platformEnv, orderIndex, activeType, fixedCode);
      return null;
      }
    }, invokeInfo);
  }

  public void  setCommodityRegisterOrderIndex(int routeKey, int timeout,int sledCommodityId, com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv platformEnv, int orderIndex, xueqiao.quotation.account.thriftapi.ContractActiveType activeType, String fixedCode)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    setCommodityRegisterOrderIndex(sledCommodityId, platformEnv, orderIndex, activeType, fixedCode, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public QuotationAccountInfoPage  reqQuotationAccountInfo(ReqQuotationAccountInfoOption option, org.soldier.platform.page.IndexedPageOption pageOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return reqQuotationAccountInfo(option, pageOption, new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public QuotationAccountInfoPage  reqQuotationAccountInfo(ReqQuotationAccountInfoOption option, org.soldier.platform.page.IndexedPageOption pageOption,TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("reqQuotationAccountInfo").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    return super.runSync(new ThriftCallable<QuotationAccountInfoPage>(){
    @Override
    public QuotationAccountInfoPage call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      return new QuotationAdminWebApi.Client(protocol).reqQuotationAccountInfo(platformArgs, option, pageOption);
      }
    }, invokeInfo);
  }

  public QuotationAccountInfoPage  reqQuotationAccountInfo(int routeKey, int timeout,ReqQuotationAccountInfoOption option, org.soldier.platform.page.IndexedPageOption pageOption)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return reqQuotationAccountInfo(option, pageOption, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public QuotationAccountInfo  updateQuotationAccountInfo(QuotationAccountInfo quotationAccountInfo) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return updateQuotationAccountInfo(quotationAccountInfo, new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public QuotationAccountInfo  updateQuotationAccountInfo(QuotationAccountInfo quotationAccountInfo,TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("updateQuotationAccountInfo").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    return super.runSync(new ThriftCallable<QuotationAccountInfo>(){
    @Override
    public QuotationAccountInfo call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      return new QuotationAdminWebApi.Client(protocol).updateQuotationAccountInfo(platformArgs, quotationAccountInfo);
      }
    }, invokeInfo);
  }

  public QuotationAccountInfo  updateQuotationAccountInfo(int routeKey, int timeout,QuotationAccountInfo quotationAccountInfo)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return updateQuotationAccountInfo(quotationAccountInfo, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public QuotationAccountInfo  addQuotationAccountInfo(QuotationAccountInfo quotationAccountInfo) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return addQuotationAccountInfo(quotationAccountInfo, new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public QuotationAccountInfo  addQuotationAccountInfo(QuotationAccountInfo quotationAccountInfo,TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("addQuotationAccountInfo").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    return super.runSync(new ThriftCallable<QuotationAccountInfo>(){
    @Override
    public QuotationAccountInfo call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      return new QuotationAdminWebApi.Client(protocol).addQuotationAccountInfo(platformArgs, quotationAccountInfo);
      }
    }, invokeInfo);
  }

  public QuotationAccountInfo  addQuotationAccountInfo(int routeKey, int timeout,QuotationAccountInfo quotationAccountInfo)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return addQuotationAccountInfo(quotationAccountInfo, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public void  deleteQuotationAccount(long accountId) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    deleteQuotationAccount(accountId, new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public void  deleteQuotationAccount(long accountId,TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("deleteQuotationAccount").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    super.runSync(new ThriftCallable<Void>(){
    @Override
    public Void call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      new QuotationAdminWebApi.Client(protocol).deleteQuotationAccount(platformArgs, accountId);
      return null;
      }
    }, invokeInfo);
  }

  public void  deleteQuotationAccount(int routeKey, int timeout,long accountId)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    deleteQuotationAccount(accountId, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public List<ExchangeRegisterAbility>  reqExchangeRegisterAbility(ReqAccountRegisterAbilityOption option) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return reqExchangeRegisterAbility(option, new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public List<ExchangeRegisterAbility>  reqExchangeRegisterAbility(ReqAccountRegisterAbilityOption option,TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("reqExchangeRegisterAbility").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    return super.runSync(new ThriftCallable<List<ExchangeRegisterAbility>>(){
    @Override
    public List<ExchangeRegisterAbility> call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      return new QuotationAdminWebApi.Client(protocol).reqExchangeRegisterAbility(platformArgs, option);
      }
    }, invokeInfo);
  }

  public List<ExchangeRegisterAbility>  reqExchangeRegisterAbility(int routeKey, int timeout,ReqAccountRegisterAbilityOption option)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return reqExchangeRegisterAbility(option, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public void  batAddAccountRegisterAbility(List<AccountRegisterAbility> abilities) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    batAddAccountRegisterAbility(abilities, new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public void  batAddAccountRegisterAbility(List<AccountRegisterAbility> abilities,TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("batAddAccountRegisterAbility").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    super.runSync(new ThriftCallable<Void>(){
    @Override
    public Void call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      new QuotationAdminWebApi.Client(protocol).batAddAccountRegisterAbility(platformArgs, abilities);
      return null;
      }
    }, invokeInfo);
  }

  public void  batAddAccountRegisterAbility(int routeKey, int timeout,List<AccountRegisterAbility> abilities)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    batAddAccountRegisterAbility(abilities, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public void  deleteAccountRegisterAbility(long abilityId) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    deleteAccountRegisterAbility(abilityId, new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public void  deleteAccountRegisterAbility(long abilityId,TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("deleteAccountRegisterAbility").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    super.runSync(new ThriftCallable<Void>(){
    @Override
    public Void call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      new QuotationAdminWebApi.Client(protocol).deleteAccountRegisterAbility(platformArgs, abilityId);
      return null;
      }
    }, invokeInfo);
  }

  public void  deleteAccountRegisterAbility(int routeKey, int timeout,long abilityId)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    deleteAccountRegisterAbility(abilityId, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public void  deleteAccountRegisterAbilityByExchange(long accountId, int exchangeId) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    deleteAccountRegisterAbilityByExchange(accountId, exchangeId, new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public void  deleteAccountRegisterAbilityByExchange(long accountId, int exchangeId,TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("deleteAccountRegisterAbilityByExchange").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    super.runSync(new ThriftCallable<Void>(){
    @Override
    public Void call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      new QuotationAdminWebApi.Client(protocol).deleteAccountRegisterAbilityByExchange(platformArgs, accountId, exchangeId);
      return null;
      }
    }, invokeInfo);
  }

  public void  deleteAccountRegisterAbilityByExchange(int routeKey, int timeout,long accountId, int exchangeId)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    deleteAccountRegisterAbilityByExchange(accountId, exchangeId, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public SubscribedContractPage  reqSubscribedContract(ReqSubscribedContractOption option, org.soldier.platform.page.IndexedPageOption pageOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return reqSubscribedContract(option, pageOption, new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public SubscribedContractPage  reqSubscribedContract(ReqSubscribedContractOption option, org.soldier.platform.page.IndexedPageOption pageOption,TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("reqSubscribedContract").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    return super.runSync(new ThriftCallable<SubscribedContractPage>(){
    @Override
    public SubscribedContractPage call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      return new QuotationAdminWebApi.Client(protocol).reqSubscribedContract(platformArgs, option, pageOption);
      }
    }, invokeInfo);
  }

  public SubscribedContractPage  reqSubscribedContract(int routeKey, int timeout,ReqSubscribedContractOption option, org.soldier.platform.page.IndexedPageOption pageOption)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return reqSubscribedContract(option, pageOption, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public void  replanSubscribe(com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv platformEnv) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    replanSubscribe(platformEnv, new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public void  replanSubscribe(com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv platformEnv,TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("replanSubscribe").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    super.runSync(new ThriftCallable<Void>(){
    @Override
    public Void call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      new QuotationAdminWebApi.Client(protocol).replanSubscribe(platformArgs, platformEnv);
      return null;
      }
    }, invokeInfo);
  }

  public void  replanSubscribe(int routeKey, int timeout,com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv platformEnv)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    replanSubscribe(platformEnv, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public RePlanSubscribedInfoPreviewPage  reqPreviewSubscribedContract(ReqRePlanSubscribedInfoPreviewOption option, org.soldier.platform.page.IndexedPageOption pageOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return reqPreviewSubscribedContract(option, pageOption, new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public RePlanSubscribedInfoPreviewPage  reqPreviewSubscribedContract(ReqRePlanSubscribedInfoPreviewOption option, org.soldier.platform.page.IndexedPageOption pageOption,TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("reqPreviewSubscribedContract").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    return super.runSync(new ThriftCallable<RePlanSubscribedInfoPreviewPage>(){
    @Override
    public RePlanSubscribedInfoPreviewPage call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      return new QuotationAdminWebApi.Client(protocol).reqPreviewSubscribedContract(platformArgs, option, pageOption);
      }
    }, invokeInfo);
  }

  public RePlanSubscribedInfoPreviewPage  reqPreviewSubscribedContract(int routeKey, int timeout,ReqRePlanSubscribedInfoPreviewOption option, org.soldier.platform.page.IndexedPageOption pageOption)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return reqPreviewSubscribedContract(option, pageOption, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public void  submitSubscribeInfo(com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv platformEnv) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    submitSubscribeInfo(platformEnv, new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public void  submitSubscribeInfo(com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv platformEnv,TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("submitSubscribeInfo").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    super.runSync(new ThriftCallable<Void>(){
    @Override
    public Void call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      new QuotationAdminWebApi.Client(protocol).submitSubscribeInfo(platformArgs, platformEnv);
      return null;
      }
    }, invokeInfo);
  }

  public void  submitSubscribeInfo(int routeKey, int timeout,com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv platformEnv)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    submitSubscribeInfo(platformEnv, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public List<PlanningSubscribedInfo>  reqPlanningSubscribedInfo(ReqPlanningSubscribedInfoOption option) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return reqPlanningSubscribedInfo(option, new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public List<PlanningSubscribedInfo>  reqPlanningSubscribedInfo(ReqPlanningSubscribedInfoOption option,TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("reqPlanningSubscribedInfo").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    return super.runSync(new ThriftCallable<List<PlanningSubscribedInfo>>(){
    @Override
    public List<PlanningSubscribedInfo> call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      return new QuotationAdminWebApi.Client(protocol).reqPlanningSubscribedInfo(platformArgs, option);
      }
    }, invokeInfo);
  }

  public List<PlanningSubscribedInfo>  reqPlanningSubscribedInfo(int routeKey, int timeout,ReqPlanningSubscribedInfoOption option)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return reqPlanningSubscribedInfo(option, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public Tree  reqCommodityTree(com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv platformEnv) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return reqCommodityTree(platformEnv, new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public Tree  reqCommodityTree(com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv platformEnv,TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("reqCommodityTree").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    return super.runSync(new ThriftCallable<Tree>(){
    @Override
    public Tree call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      return new QuotationAdminWebApi.Client(protocol).reqCommodityTree(platformArgs, platformEnv);
      }
    }, invokeInfo);
  }

  public Tree  reqCommodityTree(int routeKey, int timeout,com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv platformEnv)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return reqCommodityTree(platformEnv, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public Tree  reqCommodityTypeTree(com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv platformEnv) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return reqCommodityTypeTree(platformEnv, new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public Tree  reqCommodityTypeTree(com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv platformEnv,TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("reqCommodityTypeTree").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    return super.runSync(new ThriftCallable<Tree>(){
    @Override
    public Tree call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      return new QuotationAdminWebApi.Client(protocol).reqCommodityTypeTree(platformArgs, platformEnv);
      }
    }, invokeInfo);
  }

  public Tree  reqCommodityTypeTree(int routeKey, int timeout,com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv platformEnv)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return reqCommodityTypeTree(platformEnv, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public List<ContractTreeNode>  reqContractTreeCommodityNodes(int sledExchangeId, com.longsheng.xueqiao.contract.standard.thriftapi.SledCommodityType commodityType, com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv platformEnv) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return reqContractTreeCommodityNodes(sledExchangeId, commodityType, platformEnv, new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public List<ContractTreeNode>  reqContractTreeCommodityNodes(int sledExchangeId, com.longsheng.xueqiao.contract.standard.thriftapi.SledCommodityType commodityType, com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv platformEnv,TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("reqContractTreeCommodityNodes").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    return super.runSync(new ThriftCallable<List<ContractTreeNode>>(){
    @Override
    public List<ContractTreeNode> call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      return new QuotationAdminWebApi.Client(protocol).reqContractTreeCommodityNodes(platformArgs, sledExchangeId, commodityType, platformEnv);
      }
    }, invokeInfo);
  }

  public List<ContractTreeNode>  reqContractTreeCommodityNodes(int routeKey, int timeout,int sledExchangeId, com.longsheng.xueqiao.contract.standard.thriftapi.SledCommodityType commodityType, com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv platformEnv)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return reqContractTreeCommodityNodes(sledExchangeId, commodityType, platformEnv, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public List<ContractTreeNode>  reqContractNodes(int sledCommodityId, com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv platformEnv) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return reqContractNodes(sledCommodityId, platformEnv, new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public List<ContractTreeNode>  reqContractNodes(int sledCommodityId, com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv platformEnv,TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("reqContractNodes").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    return super.runSync(new ThriftCallable<List<ContractTreeNode>>(){
    @Override
    public List<ContractTreeNode> call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      return new QuotationAdminWebApi.Client(protocol).reqContractNodes(platformArgs, sledCommodityId, platformEnv);
      }
    }, invokeInfo);
  }

  public List<ContractTreeNode>  reqContractNodes(int routeKey, int timeout,int sledCommodityId, com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv platformEnv)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return reqContractNodes(sledCommodityId, platformEnv, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public Tree  reqBrokerTree(com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv platformEnv) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return reqBrokerTree(platformEnv, new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public Tree  reqBrokerTree(com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv platformEnv,TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("reqBrokerTree").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    return super.runSync(new ThriftCallable<Tree>(){
    @Override
    public Tree call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      return new QuotationAdminWebApi.Client(protocol).reqBrokerTree(platformArgs, platformEnv);
      }
    }, invokeInfo);
  }

  public Tree  reqBrokerTree(int routeKey, int timeout,com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv platformEnv)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return reqBrokerTree(platformEnv, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

}
