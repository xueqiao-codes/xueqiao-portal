package com.longsheng.xueqiao.contract.quotation.source.thriftapi.client;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TProtocol;
import org.soldier.platform.svr_platform.client.BaseStub;
import org.soldier.platform.svr_platform.client.TStubOption;
import org.soldier.platform.svr_platform.comm.ErrorInfo;
import org.soldier.platform.svr_platform.comm.PlatformArgs;
import java.util.Set;
import com.longsheng.xueqiao.contract.quotation.source.thriftapi.CommodityRelatedQuotationAccountSubscribePage;
import com.longsheng.xueqiao.contract.quotation.source.thriftapi.CommoditySubscribeQuota;
import com.longsheng.xueqiao.contract.quotation.source.thriftapi.CommoditySubscribeQuotaPage;
import com.longsheng.xueqiao.contract.quotation.source.thriftapi.QuotationAccount;
import com.longsheng.xueqiao.contract.quotation.source.thriftapi.QuotationAccountPage;
import com.longsheng.xueqiao.contract.quotation.source.thriftapi.QuotationAccountRelatedCommoditySubscribePage;
import com.longsheng.xueqiao.contract.quotation.source.thriftapi.QuotationAccountSubscribeQuota;
import com.longsheng.xueqiao.contract.quotation.source.thriftapi.QuotationAccountSubscribeQuotaPage;
import com.longsheng.xueqiao.contract.quotation.source.thriftapi.ReqCommoditySubscribeQuotaOption;
import com.longsheng.xueqiao.contract.quotation.source.thriftapi.ReqQuotationAccountOption;
import com.longsheng.xueqiao.contract.quotation.source.thriftapi.ReqQuotationAccountSubscribeQuotaOption;
import com.longsheng.xueqiao.contract.quotation.source.thriftapi.ReqRelatedInfoOption;
import com.longsheng.xueqiao.contract.quotation.source.thriftapi.QuotationSourceService;
import com.longsheng.xueqiao.contract.quotation.source.thriftapi.QuotationSourceServiceVariable;

public class QuotationSourceServiceStub extends BaseStub {

  public QuotationSourceServiceStub() {
    super(QuotationSourceServiceVariable.serviceKey);
  }

  public long  addQuotationAccount(QuotationAccount quotationAccount) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return addQuotationAccount(quotationAccount, new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public long  addQuotationAccount(QuotationAccount quotationAccount,TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("addQuotationAccount").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    return super.runSync(new ThriftCallable<Long>(){
    @Override
    public Long call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      return new QuotationSourceService.Client(protocol).addQuotationAccount(platformArgs, quotationAccount);
      }
    }, invokeInfo);
  }

  public long  addQuotationAccount(int routeKey, int timeout,QuotationAccount quotationAccount)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return addQuotationAccount(quotationAccount, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public void  updateQuotationAccount(QuotationAccount quotationAccount) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    updateQuotationAccount(quotationAccount, new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public void  updateQuotationAccount(QuotationAccount quotationAccount,TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("updateQuotationAccount").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    super.runSync(new ThriftCallable<Void>(){
    @Override
    public Void call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      new QuotationSourceService.Client(protocol).updateQuotationAccount(platformArgs, quotationAccount);
      return null;
      }
    }, invokeInfo);
  }

  public void  updateQuotationAccount(int routeKey, int timeout,QuotationAccount quotationAccount)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    updateQuotationAccount(quotationAccount, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public void  updateQuotationAccountSubscribeQuota(QuotationAccountSubscribeQuota quotationAccount) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    updateQuotationAccountSubscribeQuota(quotationAccount, new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public void  updateQuotationAccountSubscribeQuota(QuotationAccountSubscribeQuota quotationAccount,TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("updateQuotationAccountSubscribeQuota").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    super.runSync(new ThriftCallable<Void>(){
    @Override
    public Void call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      new QuotationSourceService.Client(protocol).updateQuotationAccountSubscribeQuota(platformArgs, quotationAccount);
      return null;
      }
    }, invokeInfo);
  }

  public void  updateQuotationAccountSubscribeQuota(int routeKey, int timeout,QuotationAccountSubscribeQuota quotationAccount)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    updateQuotationAccountSubscribeQuota(quotationAccount, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public QuotationAccountPage  reqQuotationAccount(ReqQuotationAccountOption option, org.soldier.platform.page.IndexedPageOption pageOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return reqQuotationAccount(option, pageOption, new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public QuotationAccountPage  reqQuotationAccount(ReqQuotationAccountOption option, org.soldier.platform.page.IndexedPageOption pageOption,TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("reqQuotationAccount").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    return super.runSync(new ThriftCallable<QuotationAccountPage>(){
    @Override
    public QuotationAccountPage call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      return new QuotationSourceService.Client(protocol).reqQuotationAccount(platformArgs, option, pageOption);
      }
    }, invokeInfo);
  }

  public QuotationAccountPage  reqQuotationAccount(int routeKey, int timeout,ReqQuotationAccountOption option, org.soldier.platform.page.IndexedPageOption pageOption)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return reqQuotationAccount(option, pageOption, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public QuotationAccountSubscribeQuotaPage  reqQuotationAccountSubscribeQuota(ReqQuotationAccountSubscribeQuotaOption option, org.soldier.platform.page.IndexedPageOption pageOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return reqQuotationAccountSubscribeQuota(option, pageOption, new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public QuotationAccountSubscribeQuotaPage  reqQuotationAccountSubscribeQuota(ReqQuotationAccountSubscribeQuotaOption option, org.soldier.platform.page.IndexedPageOption pageOption,TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("reqQuotationAccountSubscribeQuota").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    return super.runSync(new ThriftCallable<QuotationAccountSubscribeQuotaPage>(){
    @Override
    public QuotationAccountSubscribeQuotaPage call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      return new QuotationSourceService.Client(protocol).reqQuotationAccountSubscribeQuota(platformArgs, option, pageOption);
      }
    }, invokeInfo);
  }

  public QuotationAccountSubscribeQuotaPage  reqQuotationAccountSubscribeQuota(int routeKey, int timeout,ReqQuotationAccountSubscribeQuotaOption option, org.soldier.platform.page.IndexedPageOption pageOption)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return reqQuotationAccountSubscribeQuota(option, pageOption, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public void  addCommoditySubscribeQuota(CommoditySubscribeQuota commoditySubscribeQuota) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    addCommoditySubscribeQuota(commoditySubscribeQuota, new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public void  addCommoditySubscribeQuota(CommoditySubscribeQuota commoditySubscribeQuota,TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("addCommoditySubscribeQuota").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    super.runSync(new ThriftCallable<Void>(){
    @Override
    public Void call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      new QuotationSourceService.Client(protocol).addCommoditySubscribeQuota(platformArgs, commoditySubscribeQuota);
      return null;
      }
    }, invokeInfo);
  }

  public void  addCommoditySubscribeQuota(int routeKey, int timeout,CommoditySubscribeQuota commoditySubscribeQuota)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    addCommoditySubscribeQuota(commoditySubscribeQuota, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public void  updateCommoditySubscribeQuota(CommoditySubscribeQuota commoditySubscribeQuota) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    updateCommoditySubscribeQuota(commoditySubscribeQuota, new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public void  updateCommoditySubscribeQuota(CommoditySubscribeQuota commoditySubscribeQuota,TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("updateCommoditySubscribeQuota").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    super.runSync(new ThriftCallable<Void>(){
    @Override
    public Void call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      new QuotationSourceService.Client(protocol).updateCommoditySubscribeQuota(platformArgs, commoditySubscribeQuota);
      return null;
      }
    }, invokeInfo);
  }

  public void  updateCommoditySubscribeQuota(int routeKey, int timeout,CommoditySubscribeQuota commoditySubscribeQuota)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    updateCommoditySubscribeQuota(commoditySubscribeQuota, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public CommoditySubscribeQuotaPage  reqCommoditySubscribeQuota(ReqCommoditySubscribeQuotaOption option, org.soldier.platform.page.IndexedPageOption pageOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return reqCommoditySubscribeQuota(option, pageOption, new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public CommoditySubscribeQuotaPage  reqCommoditySubscribeQuota(ReqCommoditySubscribeQuotaOption option, org.soldier.platform.page.IndexedPageOption pageOption,TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("reqCommoditySubscribeQuota").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    return super.runSync(new ThriftCallable<CommoditySubscribeQuotaPage>(){
    @Override
    public CommoditySubscribeQuotaPage call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      return new QuotationSourceService.Client(protocol).reqCommoditySubscribeQuota(platformArgs, option, pageOption);
      }
    }, invokeInfo);
  }

  public CommoditySubscribeQuotaPage  reqCommoditySubscribeQuota(int routeKey, int timeout,ReqCommoditySubscribeQuotaOption option, org.soldier.platform.page.IndexedPageOption pageOption)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return reqCommoditySubscribeQuota(option, pageOption, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
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
      new QuotationSourceService.Client(protocol).deleteQuotationAccount(platformArgs, accountId);
      return null;
      }
    }, invokeInfo);
  }

  public void  deleteQuotationAccount(int routeKey, int timeout,long accountId)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    deleteQuotationAccount(accountId, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public void  setCommoditySubscribeAssigned(Set<Long> accountId, int sledCommodityId) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    setCommoditySubscribeAssigned(accountId, sledCommodityId, new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public void  setCommoditySubscribeAssigned(Set<Long> accountId, int sledCommodityId,TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("setCommoditySubscribeAssigned").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    super.runSync(new ThriftCallable<Void>(){
    @Override
    public Void call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      new QuotationSourceService.Client(protocol).setCommoditySubscribeAssigned(platformArgs, accountId, sledCommodityId);
      return null;
      }
    }, invokeInfo);
  }

  public void  setCommoditySubscribeAssigned(int routeKey, int timeout,Set<Long> accountId, int sledCommodityId)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    setCommoditySubscribeAssigned(accountId, sledCommodityId, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public void  deleteCommoditySubscribeAssigned(long account, int sledCommodityId) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    deleteCommoditySubscribeAssigned(account, sledCommodityId, new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public void  deleteCommoditySubscribeAssigned(long account, int sledCommodityId,TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("deleteCommoditySubscribeAssigned").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    super.runSync(new ThriftCallable<Void>(){
    @Override
    public Void call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      new QuotationSourceService.Client(protocol).deleteCommoditySubscribeAssigned(platformArgs, account, sledCommodityId);
      return null;
      }
    }, invokeInfo);
  }

  public void  deleteCommoditySubscribeAssigned(int routeKey, int timeout,long account, int sledCommodityId)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    deleteCommoditySubscribeAssigned(account, sledCommodityId, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public CommodityRelatedQuotationAccountSubscribePage  reqCommodityRelatedQuotationAccountSubscribe(ReqRelatedInfoOption option, org.soldier.platform.page.IndexedPageOption pageOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return reqCommodityRelatedQuotationAccountSubscribe(option, pageOption, new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public CommodityRelatedQuotationAccountSubscribePage  reqCommodityRelatedQuotationAccountSubscribe(ReqRelatedInfoOption option, org.soldier.platform.page.IndexedPageOption pageOption,TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("reqCommodityRelatedQuotationAccountSubscribe").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    return super.runSync(new ThriftCallable<CommodityRelatedQuotationAccountSubscribePage>(){
    @Override
    public CommodityRelatedQuotationAccountSubscribePage call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      return new QuotationSourceService.Client(protocol).reqCommodityRelatedQuotationAccountSubscribe(platformArgs, option, pageOption);
      }
    }, invokeInfo);
  }

  public CommodityRelatedQuotationAccountSubscribePage  reqCommodityRelatedQuotationAccountSubscribe(int routeKey, int timeout,ReqRelatedInfoOption option, org.soldier.platform.page.IndexedPageOption pageOption)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return reqCommodityRelatedQuotationAccountSubscribe(option, pageOption, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public QuotationAccountRelatedCommoditySubscribePage  reqQuotationAccountRelatedCommoditySubscribe(ReqRelatedInfoOption option, org.soldier.platform.page.IndexedPageOption pageOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return reqQuotationAccountRelatedCommoditySubscribe(option, pageOption, new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public QuotationAccountRelatedCommoditySubscribePage  reqQuotationAccountRelatedCommoditySubscribe(ReqRelatedInfoOption option, org.soldier.platform.page.IndexedPageOption pageOption,TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("reqQuotationAccountRelatedCommoditySubscribe").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    return super.runSync(new ThriftCallable<QuotationAccountRelatedCommoditySubscribePage>(){
    @Override
    public QuotationAccountRelatedCommoditySubscribePage call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      return new QuotationSourceService.Client(protocol).reqQuotationAccountRelatedCommoditySubscribe(platformArgs, option, pageOption);
      }
    }, invokeInfo);
  }

  public QuotationAccountRelatedCommoditySubscribePage  reqQuotationAccountRelatedCommoditySubscribe(int routeKey, int timeout,ReqRelatedInfoOption option, org.soldier.platform.page.IndexedPageOption pageOption)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return reqQuotationAccountRelatedCommoditySubscribe(option, pageOption, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

}
