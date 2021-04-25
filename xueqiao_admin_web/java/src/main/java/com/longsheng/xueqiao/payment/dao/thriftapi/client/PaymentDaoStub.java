package com.longsheng.xueqiao.payment.dao.thriftapi.client;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TProtocol;
import org.soldier.platform.svr_platform.client.BaseStub;
import org.soldier.platform.svr_platform.client.TStubOption;
import org.soldier.platform.svr_platform.comm.ErrorInfo;
import org.soldier.platform.svr_platform.comm.PlatformArgs;
import com.longsheng.xueqiao.payment.dao.thriftapi.PaymentDao;
import com.longsheng.xueqiao.payment.dao.thriftapi.PaymentDaoVariable;

public class PaymentDaoStub extends BaseStub {

  public PaymentDaoStub() {
    super(PaymentDaoVariable.serviceKey);
  }

  public com.longsheng.xueqiao.payment.product.thriftapi.ProductPage  reqProduct(com.longsheng.xueqiao.payment.product.thriftapi.ReqProductOption option) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return reqProduct(option, new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public com.longsheng.xueqiao.payment.product.thriftapi.ProductPage  reqProduct(com.longsheng.xueqiao.payment.product.thriftapi.ReqProductOption option,TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("reqProduct").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    return super.runSync(new ThriftCallable<com.longsheng.xueqiao.payment.product.thriftapi.ProductPage>(){
    @Override
    public com.longsheng.xueqiao.payment.product.thriftapi.ProductPage call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      return new PaymentDao.Client(protocol).reqProduct(platformArgs, option);
      }
    }, invokeInfo);
  }

  public com.longsheng.xueqiao.payment.product.thriftapi.ProductPage  reqProduct(int routeKey, int timeout,com.longsheng.xueqiao.payment.product.thriftapi.ReqProductOption option)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return reqProduct(option, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public void  addProduct(com.longsheng.xueqiao.payment.product.thriftapi.Product product) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    addProduct(product, new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public void  addProduct(com.longsheng.xueqiao.payment.product.thriftapi.Product product,TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("addProduct").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    super.runSync(new ThriftCallable<Void>(){
    @Override
    public Void call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      new PaymentDao.Client(protocol).addProduct(platformArgs, product);
      return null;
      }
    }, invokeInfo);
  }

  public void  addProduct(int routeKey, int timeout,com.longsheng.xueqiao.payment.product.thriftapi.Product product)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    addProduct(product, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public void  updateProduct(com.longsheng.xueqiao.payment.product.thriftapi.Product product) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    updateProduct(product, new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public void  updateProduct(com.longsheng.xueqiao.payment.product.thriftapi.Product product,TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("updateProduct").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    super.runSync(new ThriftCallable<Void>(){
    @Override
    public Void call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      new PaymentDao.Client(protocol).updateProduct(platformArgs, product);
      return null;
      }
    }, invokeInfo);
  }

  public void  updateProduct(int routeKey, int timeout,com.longsheng.xueqiao.payment.product.thriftapi.Product product)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    updateProduct(product, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public com.longsheng.xueqiao.payment.thriftapi.Order  buyProduct(com.longsheng.xueqiao.payment.thriftapi.Order order) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return buyProduct(order, new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public com.longsheng.xueqiao.payment.thriftapi.Order  buyProduct(com.longsheng.xueqiao.payment.thriftapi.Order order,TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("buyProduct").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    return super.runSync(new ThriftCallable<com.longsheng.xueqiao.payment.thriftapi.Order>(){
    @Override
    public com.longsheng.xueqiao.payment.thriftapi.Order call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      return new PaymentDao.Client(protocol).buyProduct(platformArgs, order);
      }
    }, invokeInfo);
  }

  public com.longsheng.xueqiao.payment.thriftapi.Order  buyProduct(int routeKey, int timeout,com.longsheng.xueqiao.payment.thriftapi.Order order)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return buyProduct(order, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public com.longsheng.xueqiao.payment.thriftapi.Order  payOrder(com.longsheng.xueqiao.payment.thriftapi.PayOrderInfo payOrderInfo) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return payOrder(payOrderInfo, new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public com.longsheng.xueqiao.payment.thriftapi.Order  payOrder(com.longsheng.xueqiao.payment.thriftapi.PayOrderInfo payOrderInfo,TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("payOrder").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    return super.runSync(new ThriftCallable<com.longsheng.xueqiao.payment.thriftapi.Order>(){
    @Override
    public com.longsheng.xueqiao.payment.thriftapi.Order call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      return new PaymentDao.Client(protocol).payOrder(platformArgs, payOrderInfo);
      }
    }, invokeInfo);
  }

  public com.longsheng.xueqiao.payment.thriftapi.Order  payOrder(int routeKey, int timeout,com.longsheng.xueqiao.payment.thriftapi.PayOrderInfo payOrderInfo)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return payOrder(payOrderInfo, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public com.longsheng.xueqiao.payment.thriftapi.OrderPage  reqOrder(com.longsheng.xueqiao.payment.thriftapi.ReqOrderOption option) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return reqOrder(option, new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public com.longsheng.xueqiao.payment.thriftapi.OrderPage  reqOrder(com.longsheng.xueqiao.payment.thriftapi.ReqOrderOption option,TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("reqOrder").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    return super.runSync(new ThriftCallable<com.longsheng.xueqiao.payment.thriftapi.OrderPage>(){
    @Override
    public com.longsheng.xueqiao.payment.thriftapi.OrderPage call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      return new PaymentDao.Client(protocol).reqOrder(platformArgs, option);
      }
    }, invokeInfo);
  }

  public com.longsheng.xueqiao.payment.thriftapi.OrderPage  reqOrder(int routeKey, int timeout,com.longsheng.xueqiao.payment.thriftapi.ReqOrderOption option)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return reqOrder(option, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public com.longsheng.xueqiao.payment.thriftapi.OrderFlowPage  reqOrderFlow(com.longsheng.xueqiao.payment.thriftapi.ReqOrderFlowOption option) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return reqOrderFlow(option, new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public com.longsheng.xueqiao.payment.thriftapi.OrderFlowPage  reqOrderFlow(com.longsheng.xueqiao.payment.thriftapi.ReqOrderFlowOption option,TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("reqOrderFlow").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    return super.runSync(new ThriftCallable<com.longsheng.xueqiao.payment.thriftapi.OrderFlowPage>(){
    @Override
    public com.longsheng.xueqiao.payment.thriftapi.OrderFlowPage call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      return new PaymentDao.Client(protocol).reqOrderFlow(platformArgs, option);
      }
    }, invokeInfo);
  }

  public com.longsheng.xueqiao.payment.thriftapi.OrderFlowPage  reqOrderFlow(int routeKey, int timeout,com.longsheng.xueqiao.payment.thriftapi.ReqOrderFlowOption option)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return reqOrderFlow(option, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public com.longsheng.xueqiao.payment.thriftapi.PurchaseHistoryPage  reqPurchaseHistory(com.longsheng.xueqiao.payment.thriftapi.ReqPurchaseHistoryOption option) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return reqPurchaseHistory(option, new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public com.longsheng.xueqiao.payment.thriftapi.PurchaseHistoryPage  reqPurchaseHistory(com.longsheng.xueqiao.payment.thriftapi.ReqPurchaseHistoryOption option,TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("reqPurchaseHistory").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    return super.runSync(new ThriftCallable<com.longsheng.xueqiao.payment.thriftapi.PurchaseHistoryPage>(){
    @Override
    public com.longsheng.xueqiao.payment.thriftapi.PurchaseHistoryPage call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      return new PaymentDao.Client(protocol).reqPurchaseHistory(platformArgs, option);
      }
    }, invokeInfo);
  }

  public com.longsheng.xueqiao.payment.thriftapi.PurchaseHistoryPage  reqPurchaseHistory(int routeKey, int timeout,com.longsheng.xueqiao.payment.thriftapi.ReqPurchaseHistoryOption option)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return reqPurchaseHistory(option, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public com.longsheng.xueqiao.payment.thriftapi.CompanyBalancePage  reqCompanyBalance(com.longsheng.xueqiao.payment.thriftapi.ReqCompanyBalanceOption option) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return reqCompanyBalance(option, new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public com.longsheng.xueqiao.payment.thriftapi.CompanyBalancePage  reqCompanyBalance(com.longsheng.xueqiao.payment.thriftapi.ReqCompanyBalanceOption option,TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("reqCompanyBalance").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    return super.runSync(new ThriftCallable<com.longsheng.xueqiao.payment.thriftapi.CompanyBalancePage>(){
    @Override
    public com.longsheng.xueqiao.payment.thriftapi.CompanyBalancePage call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      return new PaymentDao.Client(protocol).reqCompanyBalance(platformArgs, option);
      }
    }, invokeInfo);
  }

  public com.longsheng.xueqiao.payment.thriftapi.CompanyBalancePage  reqCompanyBalance(int routeKey, int timeout,com.longsheng.xueqiao.payment.thriftapi.ReqCompanyBalanceOption option)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return reqCompanyBalance(option, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public com.longsheng.xueqiao.payment.thriftapi.CheckPrePayResp  checkOrderPrePay(com.longsheng.xueqiao.payment.thriftapi.PayOrderInfo payOrderInfo) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return checkOrderPrePay(payOrderInfo, new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public com.longsheng.xueqiao.payment.thriftapi.CheckPrePayResp  checkOrderPrePay(com.longsheng.xueqiao.payment.thriftapi.PayOrderInfo payOrderInfo,TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("checkOrderPrePay").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    return super.runSync(new ThriftCallable<com.longsheng.xueqiao.payment.thriftapi.CheckPrePayResp>(){
    @Override
    public com.longsheng.xueqiao.payment.thriftapi.CheckPrePayResp call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      return new PaymentDao.Client(protocol).checkOrderPrePay(platformArgs, payOrderInfo);
      }
    }, invokeInfo);
  }

  public com.longsheng.xueqiao.payment.thriftapi.CheckPrePayResp  checkOrderPrePay(int routeKey, int timeout,com.longsheng.xueqiao.payment.thriftapi.PayOrderInfo payOrderInfo)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return checkOrderPrePay(payOrderInfo, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public com.longsheng.xueqiao.payment.thriftapi.Order  operateOrder(com.longsheng.xueqiao.payment.thriftapi.OperateOrderInfo info) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return operateOrder(info, new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public com.longsheng.xueqiao.payment.thriftapi.Order  operateOrder(com.longsheng.xueqiao.payment.thriftapi.OperateOrderInfo info,TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("operateOrder").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    return super.runSync(new ThriftCallable<com.longsheng.xueqiao.payment.thriftapi.Order>(){
    @Override
    public com.longsheng.xueqiao.payment.thriftapi.Order call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      return new PaymentDao.Client(protocol).operateOrder(platformArgs, info);
      }
    }, invokeInfo);
  }

  public com.longsheng.xueqiao.payment.thriftapi.Order  operateOrder(int routeKey, int timeout,com.longsheng.xueqiao.payment.thriftapi.OperateOrderInfo info)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return operateOrder(info, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public void  setNewMachineOrderGroupId(int orderId, int companyGroupId) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    setNewMachineOrderGroupId(orderId, companyGroupId, new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public void  setNewMachineOrderGroupId(int orderId, int companyGroupId,TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("setNewMachineOrderGroupId").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    super.runSync(new ThriftCallable<Void>(){
    @Override
    public Void call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      new PaymentDao.Client(protocol).setNewMachineOrderGroupId(platformArgs, orderId, companyGroupId);
      return null;
      }
    }, invokeInfo);
  }

  public void  setNewMachineOrderGroupId(int routeKey, int timeout,int orderId, int companyGroupId)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    setNewMachineOrderGroupId(orderId, companyGroupId, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public com.longsheng.xueqiao.payment.thriftapi.CompanyGroupSpecPage  reqCompanyGroupSpec(com.longsheng.xueqiao.payment.thriftapi.ReqCompanyGroupSpecOption option) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return reqCompanyGroupSpec(option, new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public com.longsheng.xueqiao.payment.thriftapi.CompanyGroupSpecPage  reqCompanyGroupSpec(com.longsheng.xueqiao.payment.thriftapi.ReqCompanyGroupSpecOption option,TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("reqCompanyGroupSpec").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    return super.runSync(new ThriftCallable<com.longsheng.xueqiao.payment.thriftapi.CompanyGroupSpecPage>(){
    @Override
    public com.longsheng.xueqiao.payment.thriftapi.CompanyGroupSpecPage call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      return new PaymentDao.Client(protocol).reqCompanyGroupSpec(platformArgs, option);
      }
    }, invokeInfo);
  }

  public com.longsheng.xueqiao.payment.thriftapi.CompanyGroupSpecPage  reqCompanyGroupSpec(int routeKey, int timeout,com.longsheng.xueqiao.payment.thriftapi.ReqCompanyGroupSpecOption option)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return reqCompanyGroupSpec(option, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public void  xcoinPay(com.longsheng.xueqiao.payment.thriftapi.PayOrderInfo payOrderInfo) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    xcoinPay(payOrderInfo, new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public void  xcoinPay(com.longsheng.xueqiao.payment.thriftapi.PayOrderInfo payOrderInfo,TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("xcoinPay").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    super.runSync(new ThriftCallable<Void>(){
    @Override
    public Void call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      new PaymentDao.Client(protocol).xcoinPay(platformArgs, payOrderInfo);
      return null;
      }
    }, invokeInfo);
  }

  public void  xcoinPay(int routeKey, int timeout,com.longsheng.xueqiao.payment.thriftapi.PayOrderInfo payOrderInfo)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    xcoinPay(payOrderInfo, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public void  alterCompanyBalance(com.longsheng.xueqiao.payment.balance.alteration.BalanceAlteration balanceAlteration) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    alterCompanyBalance(balanceAlteration, new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public void  alterCompanyBalance(com.longsheng.xueqiao.payment.balance.alteration.BalanceAlteration balanceAlteration,TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("alterCompanyBalance").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    super.runSync(new ThriftCallable<Void>(){
    @Override
    public Void call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      new PaymentDao.Client(protocol).alterCompanyBalance(platformArgs, balanceAlteration);
      return null;
      }
    }, invokeInfo);
  }

  public void  alterCompanyBalance(int routeKey, int timeout,com.longsheng.xueqiao.payment.balance.alteration.BalanceAlteration balanceAlteration)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    alterCompanyBalance(balanceAlteration, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public void  updateCompanyBalanceAlteration(com.longsheng.xueqiao.payment.balance.alteration.BalanceAlteration balanceAlteration) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    updateCompanyBalanceAlteration(balanceAlteration, new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public void  updateCompanyBalanceAlteration(com.longsheng.xueqiao.payment.balance.alteration.BalanceAlteration balanceAlteration,TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("updateCompanyBalanceAlteration").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    super.runSync(new ThriftCallable<Void>(){
    @Override
    public Void call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      new PaymentDao.Client(protocol).updateCompanyBalanceAlteration(platformArgs, balanceAlteration);
      return null;
      }
    }, invokeInfo);
  }

  public void  updateCompanyBalanceAlteration(int routeKey, int timeout,com.longsheng.xueqiao.payment.balance.alteration.BalanceAlteration balanceAlteration)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    updateCompanyBalanceAlteration(balanceAlteration, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public com.longsheng.xueqiao.payment.balance.alteration.BalanceAlterationPage  reqCompanyBalanceAlteration(com.longsheng.xueqiao.payment.balance.alteration.ReqBalanceAlterationOption reqOption, org.soldier.platform.page.IndexedPageOption pageOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return reqCompanyBalanceAlteration(reqOption, pageOption, new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public com.longsheng.xueqiao.payment.balance.alteration.BalanceAlterationPage  reqCompanyBalanceAlteration(com.longsheng.xueqiao.payment.balance.alteration.ReqBalanceAlterationOption reqOption, org.soldier.platform.page.IndexedPageOption pageOption,TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("reqCompanyBalanceAlteration").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    return super.runSync(new ThriftCallable<com.longsheng.xueqiao.payment.balance.alteration.BalanceAlterationPage>(){
    @Override
    public com.longsheng.xueqiao.payment.balance.alteration.BalanceAlterationPage call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      return new PaymentDao.Client(protocol).reqCompanyBalanceAlteration(platformArgs, reqOption, pageOption);
      }
    }, invokeInfo);
  }

  public com.longsheng.xueqiao.payment.balance.alteration.BalanceAlterationPage  reqCompanyBalanceAlteration(int routeKey, int timeout,com.longsheng.xueqiao.payment.balance.alteration.ReqBalanceAlterationOption reqOption, org.soldier.platform.page.IndexedPageOption pageOption)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return reqCompanyBalanceAlteration(reqOption, pageOption, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public void  removeInvalidOrder(int orderId) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    removeInvalidOrder(orderId, new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public void  removeInvalidOrder(int orderId,TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("removeInvalidOrder").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    super.runSync(new ThriftCallable<Void>(){
    @Override
    public Void call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      new PaymentDao.Client(protocol).removeInvalidOrder(platformArgs, orderId);
      return null;
      }
    }, invokeInfo);
  }

  public void  removeInvalidOrder(int routeKey, int timeout,int orderId)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    removeInvalidOrder(orderId, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

}
