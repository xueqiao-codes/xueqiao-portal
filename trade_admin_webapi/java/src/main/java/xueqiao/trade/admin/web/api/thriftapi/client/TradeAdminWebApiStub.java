package xueqiao.trade.admin.web.api.thriftapi.client;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TProtocol;
import org.soldier.platform.svr_platform.client.BaseStub;
import org.soldier.platform.svr_platform.client.TStubOption;
import org.soldier.platform.svr_platform.comm.ErrorInfo;
import org.soldier.platform.svr_platform.comm.PlatformArgs;
import java.util.List;
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

public class TradeAdminWebApiStub extends BaseStub {

  public TradeAdminWebApiStub() {
    super(TradeAdminWebApiVariable.serviceKey);
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
      return new TradeAdminWebApi.Client(protocol).reqCommodityActiveConfig(platformArgs, option, pageOption);
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
      return new TradeAdminWebApi.Client(protocol).updateCommodityActiveConfig(platformArgs, activeConfig);
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
      return new TradeAdminWebApi.Client(protocol).addCommodityActiveConfig(platformArgs, activeConfig);
      }
    }, invokeInfo);
  }

  public CommodityActiveConfig  addCommodityActiveConfig(int routeKey, int timeout,CommodityActiveConfig activeConfig)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return addCommodityActiveConfig(activeConfig, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public void  deleteCommodityActiveConfig(int sledCommodityId) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    deleteCommodityActiveConfig(sledCommodityId, new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public void  deleteCommodityActiveConfig(int sledCommodityId,TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("deleteCommodityActiveConfig").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    super.runSync(new ThriftCallable<Void>(){
    @Override
    public Void call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      new TradeAdminWebApi.Client(protocol).deleteCommodityActiveConfig(platformArgs, sledCommodityId);
      return null;
      }
    }, invokeInfo);
  }

  public void  deleteCommodityActiveConfig(int routeKey, int timeout,int sledCommodityId)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    deleteCommodityActiveConfig(sledCommodityId, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
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
      return new TradeAdminWebApi.Client(protocol).reqCommodityRegister(platformArgs, option, pageOption);
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
      return new TradeAdminWebApi.Client(protocol).updateCommodityRegister(platformArgs, commodityRegister);
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
      return new TradeAdminWebApi.Client(protocol).addCommodityRegister(platformArgs, commodityRegister);
      }
    }, invokeInfo);
  }

  public CommodityRegister  addCommodityRegister(int routeKey, int timeout,CommodityRegister commodityRegister)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return addCommodityRegister(commodityRegister, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public void  deleteCommodityRegister(int sledCommodityId, com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv platformEnv) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    deleteCommodityRegister(sledCommodityId, platformEnv, new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public void  deleteCommodityRegister(int sledCommodityId, com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv platformEnv,TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("deleteCommodityRegister").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    super.runSync(new ThriftCallable<Void>(){
    @Override
    public Void call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      new TradeAdminWebApi.Client(protocol).deleteCommodityRegister(platformArgs, sledCommodityId, platformEnv);
      return null;
      }
    }, invokeInfo);
  }

  public void  deleteCommodityRegister(int routeKey, int timeout,int sledCommodityId, com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv platformEnv)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    deleteCommodityRegister(sledCommodityId, platformEnv, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
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
      return new TradeAdminWebApi.Client(protocol).reqQuotationAccountInfo(platformArgs, option, pageOption);
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
      return new TradeAdminWebApi.Client(protocol).updateQuotationAccountInfo(platformArgs, quotationAccountInfo);
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
      return new TradeAdminWebApi.Client(protocol).addQuotationAccountInfo(platformArgs, quotationAccountInfo);
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
      new TradeAdminWebApi.Client(protocol).deleteQuotationAccount(platformArgs, accountId);
      return null;
      }
    }, invokeInfo);
  }

  public void  deleteQuotationAccount(int routeKey, int timeout,long accountId)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    deleteQuotationAccount(accountId, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public AccountRegisterAbilityPage  reqAccountRegisterAbility(ReqAccountRegisterAbilityOption option, org.soldier.platform.page.IndexedPageOption pageOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return reqAccountRegisterAbility(option, pageOption, new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public AccountRegisterAbilityPage  reqAccountRegisterAbility(ReqAccountRegisterAbilityOption option, org.soldier.platform.page.IndexedPageOption pageOption,TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("reqAccountRegisterAbility").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    return super.runSync(new ThriftCallable<AccountRegisterAbilityPage>(){
    @Override
    public AccountRegisterAbilityPage call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      return new TradeAdminWebApi.Client(protocol).reqAccountRegisterAbility(platformArgs, option, pageOption);
      }
    }, invokeInfo);
  }

  public AccountRegisterAbilityPage  reqAccountRegisterAbility(int routeKey, int timeout,ReqAccountRegisterAbilityOption option, org.soldier.platform.page.IndexedPageOption pageOption)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return reqAccountRegisterAbility(option, pageOption, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public AccountRegisterAbility  addAccountRegisterAbility(AccountRegisterAbility ability) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return addAccountRegisterAbility(ability, new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public AccountRegisterAbility  addAccountRegisterAbility(AccountRegisterAbility ability,TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("addAccountRegisterAbility").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    return super.runSync(new ThriftCallable<AccountRegisterAbility>(){
    @Override
    public AccountRegisterAbility call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      return new TradeAdminWebApi.Client(protocol).addAccountRegisterAbility(platformArgs, ability);
      }
    }, invokeInfo);
  }

  public AccountRegisterAbility  addAccountRegisterAbility(int routeKey, int timeout,AccountRegisterAbility ability)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return addAccountRegisterAbility(ability, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public void  deleteAccountRegisterAbility(long accountId, int sledCommodityId) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    deleteAccountRegisterAbility(accountId, sledCommodityId, new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public void  deleteAccountRegisterAbility(long accountId, int sledCommodityId,TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("deleteAccountRegisterAbility").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    super.runSync(new ThriftCallable<Void>(){
    @Override
    public Void call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      new TradeAdminWebApi.Client(protocol).deleteAccountRegisterAbility(platformArgs, accountId, sledCommodityId);
      return null;
      }
    }, invokeInfo);
  }

  public void  deleteAccountRegisterAbility(int routeKey, int timeout,long accountId, int sledCommodityId)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    deleteAccountRegisterAbility(accountId, sledCommodityId, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
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
      return new TradeAdminWebApi.Client(protocol).reqSubscribedContract(platformArgs, option, pageOption);
      }
    }, invokeInfo);
  }

  public SubscribedContractPage  reqSubscribedContract(int routeKey, int timeout,ReqSubscribedContractOption option, org.soldier.platform.page.IndexedPageOption pageOption)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return reqSubscribedContract(option, pageOption, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public List<ContractTreeNode>  reqContractTreeExchangeNodes(com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv platformEnv) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return reqContractTreeExchangeNodes(platformEnv, new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public List<ContractTreeNode>  reqContractTreeExchangeNodes(com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv platformEnv,TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("reqContractTreeExchangeNodes").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    return super.runSync(new ThriftCallable<List<ContractTreeNode>>(){
    @Override
    public List<ContractTreeNode> call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      return new TradeAdminWebApi.Client(protocol).reqContractTreeExchangeNodes(platformArgs, platformEnv);
      }
    }, invokeInfo);
  }

  public List<ContractTreeNode>  reqContractTreeExchangeNodes(int routeKey, int timeout,com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv platformEnv)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return reqContractTreeExchangeNodes(platformEnv, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public List<ContractTreeNode>  reqContractTreeCommodityNodes(String exchangeMic, com.longsheng.xueqiao.contract.standard.thriftapi.SledCommodityType commodityType, com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv platformEnv) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return reqContractTreeCommodityNodes(exchangeMic, commodityType, platformEnv, new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public List<ContractTreeNode>  reqContractTreeCommodityNodes(String exchangeMic, com.longsheng.xueqiao.contract.standard.thriftapi.SledCommodityType commodityType, com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv platformEnv,TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("reqContractTreeCommodityNodes").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    return super.runSync(new ThriftCallable<List<ContractTreeNode>>(){
    @Override
    public List<ContractTreeNode> call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      return new TradeAdminWebApi.Client(protocol).reqContractTreeCommodityNodes(platformArgs, exchangeMic, commodityType, platformEnv);
      }
    }, invokeInfo);
  }

  public List<ContractTreeNode>  reqContractTreeCommodityNodes(int routeKey, int timeout,String exchangeMic, com.longsheng.xueqiao.contract.standard.thriftapi.SledCommodityType commodityType, com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv platformEnv)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return reqContractTreeCommodityNodes(exchangeMic, commodityType, platformEnv, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public List<ContractTreeNode>  reqContractTreeContractNodes(int sledCommodityId, com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv platformEnv) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return reqContractTreeContractNodes(sledCommodityId, platformEnv, new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public List<ContractTreeNode>  reqContractTreeContractNodes(int sledCommodityId, com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv platformEnv,TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("reqContractTreeContractNodes").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    return super.runSync(new ThriftCallable<List<ContractTreeNode>>(){
    @Override
    public List<ContractTreeNode> call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      return new TradeAdminWebApi.Client(protocol).reqContractTreeContractNodes(platformArgs, sledCommodityId, platformEnv);
      }
    }, invokeInfo);
  }

  public List<ContractTreeNode>  reqContractTreeContractNodes(int routeKey, int timeout,int sledCommodityId, com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv platformEnv)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return reqContractTreeContractNodes(sledCommodityId, platformEnv, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

}
