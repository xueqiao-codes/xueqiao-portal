package com.longsheng.xueqiao.contract.quotation.source.thriftapi.server.impl;


import java.util.Set;
import java.util.Properties;
import org.soldier.platform.svr_platform.container.TServiceCntl;
import com.longsheng.xueqiao.contract.quotation.source.thriftapi.server.QuotationSourceServiceAdaptor;
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

public class QuotationSourceServiceHandler extends QuotationSourceServiceAdaptor{
  @Override
  public int InitApp(Properties props){
    return 0;
  }

  @Override
  protected long addQuotationAccount(TServiceCntl oCntl, QuotationAccount quotationAccount) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    return 0;
  }

  @Override
  protected void updateQuotationAccount(TServiceCntl oCntl, QuotationAccount quotationAccount) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
  }

  @Override
  protected void updateQuotationAccountSubscribeQuota(TServiceCntl oCntl, QuotationAccountSubscribeQuota quotationAccount) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
  }

  @Override
  protected QuotationAccountPage reqQuotationAccount(TServiceCntl oCntl, ReqQuotationAccountOption option, org.soldier.platform.page.IndexedPageOption pageOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    return null;
  }

  @Override
  protected QuotationAccountSubscribeQuotaPage reqQuotationAccountSubscribeQuota(TServiceCntl oCntl, ReqQuotationAccountSubscribeQuotaOption option, org.soldier.platform.page.IndexedPageOption pageOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    return null;
  }

  @Override
  protected void addCommoditySubscribeQuota(TServiceCntl oCntl, CommoditySubscribeQuota commoditySubscribeQuota) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
  }

  @Override
  protected void updateCommoditySubscribeQuota(TServiceCntl oCntl, CommoditySubscribeQuota commoditySubscribeQuota) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
  }

  @Override
  protected CommoditySubscribeQuotaPage reqCommoditySubscribeQuota(TServiceCntl oCntl, ReqCommoditySubscribeQuotaOption option, org.soldier.platform.page.IndexedPageOption pageOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    return null;
  }

  @Override
  protected void deleteQuotationAccount(TServiceCntl oCntl, long accountId) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
  }

  @Override
  protected void setCommoditySubscribeAssigned(TServiceCntl oCntl, Set<Long> accountId, int sledCommodityId) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
  }

  @Override
  protected void deleteCommoditySubscribeAssigned(TServiceCntl oCntl, long account, int sledCommodityId) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
  }

  @Override
  protected CommodityRelatedQuotationAccountSubscribePage reqCommodityRelatedQuotationAccountSubscribe(TServiceCntl oCntl, ReqRelatedInfoOption option, org.soldier.platform.page.IndexedPageOption pageOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    return null;
  }

  @Override
  protected QuotationAccountRelatedCommoditySubscribePage reqQuotationAccountRelatedCommoditySubscribe(TServiceCntl oCntl, ReqRelatedInfoOption option, org.soldier.platform.page.IndexedPageOption pageOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    return null;
  }

  @Override
  public void destroy() {
  }
}
