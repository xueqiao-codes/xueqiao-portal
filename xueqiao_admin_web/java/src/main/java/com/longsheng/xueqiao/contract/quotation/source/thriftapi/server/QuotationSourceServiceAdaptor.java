package com.longsheng.xueqiao.contract.quotation.source.thriftapi.server;

import java.util.Properties;
import org.soldier.platform.svr_platform.container.TServiceCntl;
import java.util.Set;
import java.util.Map;
import java.util.HashMap;
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


public abstract class QuotationSourceServiceAdaptor implements QuotationSourceService.Iface{
  // unmodified map, so we do not need lock for this 
  private final Map<String, String[]> methodParameterNameMap = new HashMap<String, String[]>(); 

  public String[] getMethodParameterName(String methodName) {
    return methodParameterNameMap.get(methodName);
  }

  @Override
  public long addQuotationAccount(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, QuotationAccount quotationAccount) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(QuotationSourceServiceVariable.serviceKey,"addQuotationAccount",platformArgs);
    return addQuotationAccount(oCntl, quotationAccount);
  }

  protected abstract long addQuotationAccount(TServiceCntl oCntl, QuotationAccount quotationAccount) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public void updateQuotationAccount(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, QuotationAccount quotationAccount) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(QuotationSourceServiceVariable.serviceKey,"updateQuotationAccount",platformArgs);
updateQuotationAccount(oCntl, quotationAccount);
  }

  protected abstract void updateQuotationAccount(TServiceCntl oCntl, QuotationAccount quotationAccount) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public void updateQuotationAccountSubscribeQuota(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, QuotationAccountSubscribeQuota quotationAccount) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(QuotationSourceServiceVariable.serviceKey,"updateQuotationAccountSubscribeQuota",platformArgs);
updateQuotationAccountSubscribeQuota(oCntl, quotationAccount);
  }

  protected abstract void updateQuotationAccountSubscribeQuota(TServiceCntl oCntl, QuotationAccountSubscribeQuota quotationAccount) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public QuotationAccountPage reqQuotationAccount(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, ReqQuotationAccountOption option, org.soldier.platform.page.IndexedPageOption pageOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(QuotationSourceServiceVariable.serviceKey,"reqQuotationAccount",platformArgs);
    return reqQuotationAccount(oCntl, option, pageOption);
  }

  protected abstract QuotationAccountPage reqQuotationAccount(TServiceCntl oCntl, ReqQuotationAccountOption option, org.soldier.platform.page.IndexedPageOption pageOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public QuotationAccountSubscribeQuotaPage reqQuotationAccountSubscribeQuota(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, ReqQuotationAccountSubscribeQuotaOption option, org.soldier.platform.page.IndexedPageOption pageOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(QuotationSourceServiceVariable.serviceKey,"reqQuotationAccountSubscribeQuota",platformArgs);
    return reqQuotationAccountSubscribeQuota(oCntl, option, pageOption);
  }

  protected abstract QuotationAccountSubscribeQuotaPage reqQuotationAccountSubscribeQuota(TServiceCntl oCntl, ReqQuotationAccountSubscribeQuotaOption option, org.soldier.platform.page.IndexedPageOption pageOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public void addCommoditySubscribeQuota(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, CommoditySubscribeQuota commoditySubscribeQuota) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(QuotationSourceServiceVariable.serviceKey,"addCommoditySubscribeQuota",platformArgs);
addCommoditySubscribeQuota(oCntl, commoditySubscribeQuota);
  }

  protected abstract void addCommoditySubscribeQuota(TServiceCntl oCntl, CommoditySubscribeQuota commoditySubscribeQuota) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public void updateCommoditySubscribeQuota(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, CommoditySubscribeQuota commoditySubscribeQuota) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(QuotationSourceServiceVariable.serviceKey,"updateCommoditySubscribeQuota",platformArgs);
updateCommoditySubscribeQuota(oCntl, commoditySubscribeQuota);
  }

  protected abstract void updateCommoditySubscribeQuota(TServiceCntl oCntl, CommoditySubscribeQuota commoditySubscribeQuota) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public CommoditySubscribeQuotaPage reqCommoditySubscribeQuota(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, ReqCommoditySubscribeQuotaOption option, org.soldier.platform.page.IndexedPageOption pageOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(QuotationSourceServiceVariable.serviceKey,"reqCommoditySubscribeQuota",platformArgs);
    return reqCommoditySubscribeQuota(oCntl, option, pageOption);
  }

  protected abstract CommoditySubscribeQuotaPage reqCommoditySubscribeQuota(TServiceCntl oCntl, ReqCommoditySubscribeQuotaOption option, org.soldier.platform.page.IndexedPageOption pageOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public void deleteQuotationAccount(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, long accountId) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(QuotationSourceServiceVariable.serviceKey,"deleteQuotationAccount",platformArgs);
deleteQuotationAccount(oCntl, accountId);
  }

  protected abstract void deleteQuotationAccount(TServiceCntl oCntl, long accountId) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public void setCommoditySubscribeAssigned(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, Set<Long> accountId, int sledCommodityId) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(QuotationSourceServiceVariable.serviceKey,"setCommoditySubscribeAssigned",platformArgs);
setCommoditySubscribeAssigned(oCntl, accountId, sledCommodityId);
  }

  protected abstract void setCommoditySubscribeAssigned(TServiceCntl oCntl, Set<Long> accountId, int sledCommodityId) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public void deleteCommoditySubscribeAssigned(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, long account, int sledCommodityId) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(QuotationSourceServiceVariable.serviceKey,"deleteCommoditySubscribeAssigned",platformArgs);
deleteCommoditySubscribeAssigned(oCntl, account, sledCommodityId);
  }

  protected abstract void deleteCommoditySubscribeAssigned(TServiceCntl oCntl, long account, int sledCommodityId) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public CommodityRelatedQuotationAccountSubscribePage reqCommodityRelatedQuotationAccountSubscribe(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, ReqRelatedInfoOption option, org.soldier.platform.page.IndexedPageOption pageOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(QuotationSourceServiceVariable.serviceKey,"reqCommodityRelatedQuotationAccountSubscribe",platformArgs);
    return reqCommodityRelatedQuotationAccountSubscribe(oCntl, option, pageOption);
  }

  protected abstract CommodityRelatedQuotationAccountSubscribePage reqCommodityRelatedQuotationAccountSubscribe(TServiceCntl oCntl, ReqRelatedInfoOption option, org.soldier.platform.page.IndexedPageOption pageOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public QuotationAccountRelatedCommoditySubscribePage reqQuotationAccountRelatedCommoditySubscribe(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, ReqRelatedInfoOption option, org.soldier.platform.page.IndexedPageOption pageOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(QuotationSourceServiceVariable.serviceKey,"reqQuotationAccountRelatedCommoditySubscribe",platformArgs);
    return reqQuotationAccountRelatedCommoditySubscribe(oCntl, option, pageOption);
  }

  protected abstract QuotationAccountRelatedCommoditySubscribePage reqQuotationAccountRelatedCommoditySubscribe(TServiceCntl oCntl, ReqRelatedInfoOption option, org.soldier.platform.page.IndexedPageOption pageOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  protected QuotationSourceServiceAdaptor(){
    methodParameterNameMap.put("addQuotationAccount",new String[]{"platformArgs", "quotationAccount"});
    methodParameterNameMap.put("updateQuotationAccount",new String[]{"platformArgs", "quotationAccount"});
    methodParameterNameMap.put("updateQuotationAccountSubscribeQuota",new String[]{"platformArgs", "quotationAccount"});
    methodParameterNameMap.put("reqQuotationAccount",new String[]{"platformArgs", "option", "pageOption"});
    methodParameterNameMap.put("reqQuotationAccountSubscribeQuota",new String[]{"platformArgs", "option", "pageOption"});
    methodParameterNameMap.put("addCommoditySubscribeQuota",new String[]{"platformArgs", "commoditySubscribeQuota"});
    methodParameterNameMap.put("updateCommoditySubscribeQuota",new String[]{"platformArgs", "commoditySubscribeQuota"});
    methodParameterNameMap.put("reqCommoditySubscribeQuota",new String[]{"platformArgs", "option", "pageOption"});
    methodParameterNameMap.put("deleteQuotationAccount",new String[]{"platformArgs", "accountId"});
    methodParameterNameMap.put("setCommoditySubscribeAssigned",new String[]{"platformArgs", "accountId", "sledCommodityId"});
    methodParameterNameMap.put("deleteCommoditySubscribeAssigned",new String[]{"platformArgs", "account", "sledCommodityId"});
    methodParameterNameMap.put("reqCommodityRelatedQuotationAccountSubscribe",new String[]{"platformArgs", "option", "pageOption"});
    methodParameterNameMap.put("reqQuotationAccountRelatedCommoditySubscribe",new String[]{"platformArgs", "option", "pageOption"});
  }
  protected abstract int InitApp(final Properties props);

  protected abstract void destroy();

}
