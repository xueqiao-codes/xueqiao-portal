package com.longsheng.xueqiao.payment.dao.thriftapi.client;

import com.longsheng.xueqiao.payment.dao.thriftapi.PaymentDao;
import com.longsheng.xueqiao.payment.dao.thriftapi.PaymentDaoVariable;
import org.apache.thrift.TException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import org.soldier.base.logger.AppLog;
import org.soldier.platform.svr_platform.client.AsyncCallRunner;
import org.soldier.platform.svr_platform.client.IMethodCallback;
import org.soldier.platform.svr_platform.client.SvrContainer;
import org.soldier.platform.svr_platform.client.TRequestOption;
import org.soldier.platform.svr_platform.client.TServiceCall;
import org.soldier.platform.svr_platform.comm.PlatformArgs;
import org.soldier.platform.svr_platform.client.BaseStub;

public class PaymentDaoAsyncStub extends BaseStub { 
  public PaymentDaoAsyncStub() {
    super(PaymentDaoVariable.serviceKey);
  }
  public void send_reqProduct(int routeKey, int timeout, com.longsheng.xueqiao.payment.product.thriftapi.ReqProductOption option) throws TException {
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":" 
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    SvrContainer.getInstance().sendRequest(
        create_reqProductServiceCall(routeKey, timeout, platformArgs, option), new TRequestOption());
  }

  public void send_reqProduct(int routeKey, int timeout, com.longsheng.xueqiao.payment.product.thriftapi.ReqProductOption option,TRequestOption requestOption) throws TException { 
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":" 
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    SvrContainer.getInstance().sendRequest(
        create_reqProductServiceCall(routeKey, timeout, platformArgs, option), requestOption);
  }

  public long reqProduct(int routeKey, int timeout, com.longsheng.xueqiao.payment.product.thriftapi.ReqProductOption option, IMethodCallback<PaymentDao.reqProduct_args, PaymentDao.reqProduct_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":"
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    return SvrContainer.getInstance().sendRequest(
            create_reqProductServiceCall(routeKey, timeout, platformArgs, option), callback);
  }

  public long add_reqProductCall(AsyncCallRunner runner, int routeKey, int timeout, com.longsheng.xueqiao.payment.product.thriftapi.ReqProductOption option, IMethodCallback<PaymentDao.reqProduct_args, PaymentDao.reqProduct_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":" 
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    return runner.addAsyncCall(
            create_reqProductServiceCall(routeKey, timeout, platformArgs, option), callback);
  }

  protected TServiceCall create_reqProductServiceCall(int routeKey, int timeout, org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, com.longsheng.xueqiao.payment.product.thriftapi.ReqProductOption option){
    TServiceCall serviceCall = new TServiceCall();
    if (!getPeerAddr().isEmpty()) {
      serviceCall.setChooseServiceIp(getPeerAddr());
    }
    if (getPeerPort() != 0) {
      serviceCall.setChooseServicePort(getPeerPort());
    }
    serviceCall.setServiceKey(PaymentDaoVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    PaymentDao.reqProduct_args request = new PaymentDao.reqProduct_args();
    request.setPlatformArgs(platformArgs);
    request.setOption(option);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("reqProduct");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(PaymentDao.reqProduct_result.class);
    return serviceCall;
  }

  public void send_addProduct(int routeKey, int timeout, com.longsheng.xueqiao.payment.product.thriftapi.Product product) throws TException {
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":" 
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    SvrContainer.getInstance().sendRequest(
        create_addProductServiceCall(routeKey, timeout, platformArgs, product), new TRequestOption());
  }

  public void send_addProduct(int routeKey, int timeout, com.longsheng.xueqiao.payment.product.thriftapi.Product product,TRequestOption requestOption) throws TException { 
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":" 
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    SvrContainer.getInstance().sendRequest(
        create_addProductServiceCall(routeKey, timeout, platformArgs, product), requestOption);
  }

  public long addProduct(int routeKey, int timeout, com.longsheng.xueqiao.payment.product.thriftapi.Product product, IMethodCallback<PaymentDao.addProduct_args, PaymentDao.addProduct_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":"
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    return SvrContainer.getInstance().sendRequest(
            create_addProductServiceCall(routeKey, timeout, platformArgs, product), callback);
  }

  public long add_addProductCall(AsyncCallRunner runner, int routeKey, int timeout, com.longsheng.xueqiao.payment.product.thriftapi.Product product, IMethodCallback<PaymentDao.addProduct_args, PaymentDao.addProduct_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":" 
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    return runner.addAsyncCall(
            create_addProductServiceCall(routeKey, timeout, platformArgs, product), callback);
  }

  protected TServiceCall create_addProductServiceCall(int routeKey, int timeout, org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, com.longsheng.xueqiao.payment.product.thriftapi.Product product){
    TServiceCall serviceCall = new TServiceCall();
    if (!getPeerAddr().isEmpty()) {
      serviceCall.setChooseServiceIp(getPeerAddr());
    }
    if (getPeerPort() != 0) {
      serviceCall.setChooseServicePort(getPeerPort());
    }
    serviceCall.setServiceKey(PaymentDaoVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    PaymentDao.addProduct_args request = new PaymentDao.addProduct_args();
    request.setPlatformArgs(platformArgs);
    request.setProduct(product);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("addProduct");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(PaymentDao.addProduct_result.class);
    return serviceCall;
  }

  public void send_updateProduct(int routeKey, int timeout, com.longsheng.xueqiao.payment.product.thriftapi.Product product) throws TException {
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":" 
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    SvrContainer.getInstance().sendRequest(
        create_updateProductServiceCall(routeKey, timeout, platformArgs, product), new TRequestOption());
  }

  public void send_updateProduct(int routeKey, int timeout, com.longsheng.xueqiao.payment.product.thriftapi.Product product,TRequestOption requestOption) throws TException { 
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":" 
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    SvrContainer.getInstance().sendRequest(
        create_updateProductServiceCall(routeKey, timeout, platformArgs, product), requestOption);
  }

  public long updateProduct(int routeKey, int timeout, com.longsheng.xueqiao.payment.product.thriftapi.Product product, IMethodCallback<PaymentDao.updateProduct_args, PaymentDao.updateProduct_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":"
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    return SvrContainer.getInstance().sendRequest(
            create_updateProductServiceCall(routeKey, timeout, platformArgs, product), callback);
  }

  public long add_updateProductCall(AsyncCallRunner runner, int routeKey, int timeout, com.longsheng.xueqiao.payment.product.thriftapi.Product product, IMethodCallback<PaymentDao.updateProduct_args, PaymentDao.updateProduct_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":" 
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    return runner.addAsyncCall(
            create_updateProductServiceCall(routeKey, timeout, platformArgs, product), callback);
  }

  protected TServiceCall create_updateProductServiceCall(int routeKey, int timeout, org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, com.longsheng.xueqiao.payment.product.thriftapi.Product product){
    TServiceCall serviceCall = new TServiceCall();
    if (!getPeerAddr().isEmpty()) {
      serviceCall.setChooseServiceIp(getPeerAddr());
    }
    if (getPeerPort() != 0) {
      serviceCall.setChooseServicePort(getPeerPort());
    }
    serviceCall.setServiceKey(PaymentDaoVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    PaymentDao.updateProduct_args request = new PaymentDao.updateProduct_args();
    request.setPlatformArgs(platformArgs);
    request.setProduct(product);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("updateProduct");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(PaymentDao.updateProduct_result.class);
    return serviceCall;
  }

  public void send_buyProduct(int routeKey, int timeout, com.longsheng.xueqiao.payment.thriftapi.Order order) throws TException {
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":" 
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    SvrContainer.getInstance().sendRequest(
        create_buyProductServiceCall(routeKey, timeout, platformArgs, order), new TRequestOption());
  }

  public void send_buyProduct(int routeKey, int timeout, com.longsheng.xueqiao.payment.thriftapi.Order order,TRequestOption requestOption) throws TException { 
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":" 
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    SvrContainer.getInstance().sendRequest(
        create_buyProductServiceCall(routeKey, timeout, platformArgs, order), requestOption);
  }

  public long buyProduct(int routeKey, int timeout, com.longsheng.xueqiao.payment.thriftapi.Order order, IMethodCallback<PaymentDao.buyProduct_args, PaymentDao.buyProduct_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":"
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    return SvrContainer.getInstance().sendRequest(
            create_buyProductServiceCall(routeKey, timeout, platformArgs, order), callback);
  }

  public long add_buyProductCall(AsyncCallRunner runner, int routeKey, int timeout, com.longsheng.xueqiao.payment.thriftapi.Order order, IMethodCallback<PaymentDao.buyProduct_args, PaymentDao.buyProduct_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":" 
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    return runner.addAsyncCall(
            create_buyProductServiceCall(routeKey, timeout, platformArgs, order), callback);
  }

  protected TServiceCall create_buyProductServiceCall(int routeKey, int timeout, org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, com.longsheng.xueqiao.payment.thriftapi.Order order){
    TServiceCall serviceCall = new TServiceCall();
    if (!getPeerAddr().isEmpty()) {
      serviceCall.setChooseServiceIp(getPeerAddr());
    }
    if (getPeerPort() != 0) {
      serviceCall.setChooseServicePort(getPeerPort());
    }
    serviceCall.setServiceKey(PaymentDaoVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    PaymentDao.buyProduct_args request = new PaymentDao.buyProduct_args();
    request.setPlatformArgs(platformArgs);
    request.setOrder(order);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("buyProduct");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(PaymentDao.buyProduct_result.class);
    return serviceCall;
  }

  public void send_payOrder(int routeKey, int timeout, com.longsheng.xueqiao.payment.thriftapi.PayOrderInfo payOrderInfo) throws TException {
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":" 
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    SvrContainer.getInstance().sendRequest(
        create_payOrderServiceCall(routeKey, timeout, platformArgs, payOrderInfo), new TRequestOption());
  }

  public void send_payOrder(int routeKey, int timeout, com.longsheng.xueqiao.payment.thriftapi.PayOrderInfo payOrderInfo,TRequestOption requestOption) throws TException { 
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":" 
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    SvrContainer.getInstance().sendRequest(
        create_payOrderServiceCall(routeKey, timeout, platformArgs, payOrderInfo), requestOption);
  }

  public long payOrder(int routeKey, int timeout, com.longsheng.xueqiao.payment.thriftapi.PayOrderInfo payOrderInfo, IMethodCallback<PaymentDao.payOrder_args, PaymentDao.payOrder_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":"
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    return SvrContainer.getInstance().sendRequest(
            create_payOrderServiceCall(routeKey, timeout, platformArgs, payOrderInfo), callback);
  }

  public long add_payOrderCall(AsyncCallRunner runner, int routeKey, int timeout, com.longsheng.xueqiao.payment.thriftapi.PayOrderInfo payOrderInfo, IMethodCallback<PaymentDao.payOrder_args, PaymentDao.payOrder_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":" 
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    return runner.addAsyncCall(
            create_payOrderServiceCall(routeKey, timeout, platformArgs, payOrderInfo), callback);
  }

  protected TServiceCall create_payOrderServiceCall(int routeKey, int timeout, org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, com.longsheng.xueqiao.payment.thriftapi.PayOrderInfo payOrderInfo){
    TServiceCall serviceCall = new TServiceCall();
    if (!getPeerAddr().isEmpty()) {
      serviceCall.setChooseServiceIp(getPeerAddr());
    }
    if (getPeerPort() != 0) {
      serviceCall.setChooseServicePort(getPeerPort());
    }
    serviceCall.setServiceKey(PaymentDaoVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    PaymentDao.payOrder_args request = new PaymentDao.payOrder_args();
    request.setPlatformArgs(platformArgs);
    request.setPayOrderInfo(payOrderInfo);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("payOrder");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(PaymentDao.payOrder_result.class);
    return serviceCall;
  }

  public void send_reqOrder(int routeKey, int timeout, com.longsheng.xueqiao.payment.thriftapi.ReqOrderOption option) throws TException {
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":" 
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    SvrContainer.getInstance().sendRequest(
        create_reqOrderServiceCall(routeKey, timeout, platformArgs, option), new TRequestOption());
  }

  public void send_reqOrder(int routeKey, int timeout, com.longsheng.xueqiao.payment.thriftapi.ReqOrderOption option,TRequestOption requestOption) throws TException { 
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":" 
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    SvrContainer.getInstance().sendRequest(
        create_reqOrderServiceCall(routeKey, timeout, platformArgs, option), requestOption);
  }

  public long reqOrder(int routeKey, int timeout, com.longsheng.xueqiao.payment.thriftapi.ReqOrderOption option, IMethodCallback<PaymentDao.reqOrder_args, PaymentDao.reqOrder_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":"
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    return SvrContainer.getInstance().sendRequest(
            create_reqOrderServiceCall(routeKey, timeout, platformArgs, option), callback);
  }

  public long add_reqOrderCall(AsyncCallRunner runner, int routeKey, int timeout, com.longsheng.xueqiao.payment.thriftapi.ReqOrderOption option, IMethodCallback<PaymentDao.reqOrder_args, PaymentDao.reqOrder_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":" 
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    return runner.addAsyncCall(
            create_reqOrderServiceCall(routeKey, timeout, platformArgs, option), callback);
  }

  protected TServiceCall create_reqOrderServiceCall(int routeKey, int timeout, org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, com.longsheng.xueqiao.payment.thriftapi.ReqOrderOption option){
    TServiceCall serviceCall = new TServiceCall();
    if (!getPeerAddr().isEmpty()) {
      serviceCall.setChooseServiceIp(getPeerAddr());
    }
    if (getPeerPort() != 0) {
      serviceCall.setChooseServicePort(getPeerPort());
    }
    serviceCall.setServiceKey(PaymentDaoVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    PaymentDao.reqOrder_args request = new PaymentDao.reqOrder_args();
    request.setPlatformArgs(platformArgs);
    request.setOption(option);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("reqOrder");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(PaymentDao.reqOrder_result.class);
    return serviceCall;
  }

  public void send_reqOrderFlow(int routeKey, int timeout, com.longsheng.xueqiao.payment.thriftapi.ReqOrderFlowOption option) throws TException {
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":" 
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    SvrContainer.getInstance().sendRequest(
        create_reqOrderFlowServiceCall(routeKey, timeout, platformArgs, option), new TRequestOption());
  }

  public void send_reqOrderFlow(int routeKey, int timeout, com.longsheng.xueqiao.payment.thriftapi.ReqOrderFlowOption option,TRequestOption requestOption) throws TException { 
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":" 
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    SvrContainer.getInstance().sendRequest(
        create_reqOrderFlowServiceCall(routeKey, timeout, platformArgs, option), requestOption);
  }

  public long reqOrderFlow(int routeKey, int timeout, com.longsheng.xueqiao.payment.thriftapi.ReqOrderFlowOption option, IMethodCallback<PaymentDao.reqOrderFlow_args, PaymentDao.reqOrderFlow_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":"
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    return SvrContainer.getInstance().sendRequest(
            create_reqOrderFlowServiceCall(routeKey, timeout, platformArgs, option), callback);
  }

  public long add_reqOrderFlowCall(AsyncCallRunner runner, int routeKey, int timeout, com.longsheng.xueqiao.payment.thriftapi.ReqOrderFlowOption option, IMethodCallback<PaymentDao.reqOrderFlow_args, PaymentDao.reqOrderFlow_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":" 
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    return runner.addAsyncCall(
            create_reqOrderFlowServiceCall(routeKey, timeout, platformArgs, option), callback);
  }

  protected TServiceCall create_reqOrderFlowServiceCall(int routeKey, int timeout, org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, com.longsheng.xueqiao.payment.thriftapi.ReqOrderFlowOption option){
    TServiceCall serviceCall = new TServiceCall();
    if (!getPeerAddr().isEmpty()) {
      serviceCall.setChooseServiceIp(getPeerAddr());
    }
    if (getPeerPort() != 0) {
      serviceCall.setChooseServicePort(getPeerPort());
    }
    serviceCall.setServiceKey(PaymentDaoVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    PaymentDao.reqOrderFlow_args request = new PaymentDao.reqOrderFlow_args();
    request.setPlatformArgs(platformArgs);
    request.setOption(option);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("reqOrderFlow");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(PaymentDao.reqOrderFlow_result.class);
    return serviceCall;
  }

  public void send_reqPurchaseHistory(int routeKey, int timeout, com.longsheng.xueqiao.payment.thriftapi.ReqPurchaseHistoryOption option) throws TException {
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":" 
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    SvrContainer.getInstance().sendRequest(
        create_reqPurchaseHistoryServiceCall(routeKey, timeout, platformArgs, option), new TRequestOption());
  }

  public void send_reqPurchaseHistory(int routeKey, int timeout, com.longsheng.xueqiao.payment.thriftapi.ReqPurchaseHistoryOption option,TRequestOption requestOption) throws TException { 
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":" 
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    SvrContainer.getInstance().sendRequest(
        create_reqPurchaseHistoryServiceCall(routeKey, timeout, platformArgs, option), requestOption);
  }

  public long reqPurchaseHistory(int routeKey, int timeout, com.longsheng.xueqiao.payment.thriftapi.ReqPurchaseHistoryOption option, IMethodCallback<PaymentDao.reqPurchaseHistory_args, PaymentDao.reqPurchaseHistory_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":"
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    return SvrContainer.getInstance().sendRequest(
            create_reqPurchaseHistoryServiceCall(routeKey, timeout, platformArgs, option), callback);
  }

  public long add_reqPurchaseHistoryCall(AsyncCallRunner runner, int routeKey, int timeout, com.longsheng.xueqiao.payment.thriftapi.ReqPurchaseHistoryOption option, IMethodCallback<PaymentDao.reqPurchaseHistory_args, PaymentDao.reqPurchaseHistory_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":" 
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    return runner.addAsyncCall(
            create_reqPurchaseHistoryServiceCall(routeKey, timeout, platformArgs, option), callback);
  }

  protected TServiceCall create_reqPurchaseHistoryServiceCall(int routeKey, int timeout, org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, com.longsheng.xueqiao.payment.thriftapi.ReqPurchaseHistoryOption option){
    TServiceCall serviceCall = new TServiceCall();
    if (!getPeerAddr().isEmpty()) {
      serviceCall.setChooseServiceIp(getPeerAddr());
    }
    if (getPeerPort() != 0) {
      serviceCall.setChooseServicePort(getPeerPort());
    }
    serviceCall.setServiceKey(PaymentDaoVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    PaymentDao.reqPurchaseHistory_args request = new PaymentDao.reqPurchaseHistory_args();
    request.setPlatformArgs(platformArgs);
    request.setOption(option);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("reqPurchaseHistory");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(PaymentDao.reqPurchaseHistory_result.class);
    return serviceCall;
  }

  public void send_reqCompanyBalance(int routeKey, int timeout, com.longsheng.xueqiao.payment.thriftapi.ReqCompanyBalanceOption option) throws TException {
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":" 
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    SvrContainer.getInstance().sendRequest(
        create_reqCompanyBalanceServiceCall(routeKey, timeout, platformArgs, option), new TRequestOption());
  }

  public void send_reqCompanyBalance(int routeKey, int timeout, com.longsheng.xueqiao.payment.thriftapi.ReqCompanyBalanceOption option,TRequestOption requestOption) throws TException { 
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":" 
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    SvrContainer.getInstance().sendRequest(
        create_reqCompanyBalanceServiceCall(routeKey, timeout, platformArgs, option), requestOption);
  }

  public long reqCompanyBalance(int routeKey, int timeout, com.longsheng.xueqiao.payment.thriftapi.ReqCompanyBalanceOption option, IMethodCallback<PaymentDao.reqCompanyBalance_args, PaymentDao.reqCompanyBalance_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":"
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    return SvrContainer.getInstance().sendRequest(
            create_reqCompanyBalanceServiceCall(routeKey, timeout, platformArgs, option), callback);
  }

  public long add_reqCompanyBalanceCall(AsyncCallRunner runner, int routeKey, int timeout, com.longsheng.xueqiao.payment.thriftapi.ReqCompanyBalanceOption option, IMethodCallback<PaymentDao.reqCompanyBalance_args, PaymentDao.reqCompanyBalance_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":" 
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    return runner.addAsyncCall(
            create_reqCompanyBalanceServiceCall(routeKey, timeout, platformArgs, option), callback);
  }

  protected TServiceCall create_reqCompanyBalanceServiceCall(int routeKey, int timeout, org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, com.longsheng.xueqiao.payment.thriftapi.ReqCompanyBalanceOption option){
    TServiceCall serviceCall = new TServiceCall();
    if (!getPeerAddr().isEmpty()) {
      serviceCall.setChooseServiceIp(getPeerAddr());
    }
    if (getPeerPort() != 0) {
      serviceCall.setChooseServicePort(getPeerPort());
    }
    serviceCall.setServiceKey(PaymentDaoVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    PaymentDao.reqCompanyBalance_args request = new PaymentDao.reqCompanyBalance_args();
    request.setPlatformArgs(platformArgs);
    request.setOption(option);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("reqCompanyBalance");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(PaymentDao.reqCompanyBalance_result.class);
    return serviceCall;
  }

  public void send_checkOrderPrePay(int routeKey, int timeout, com.longsheng.xueqiao.payment.thriftapi.PayOrderInfo payOrderInfo) throws TException {
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":" 
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    SvrContainer.getInstance().sendRequest(
        create_checkOrderPrePayServiceCall(routeKey, timeout, platformArgs, payOrderInfo), new TRequestOption());
  }

  public void send_checkOrderPrePay(int routeKey, int timeout, com.longsheng.xueqiao.payment.thriftapi.PayOrderInfo payOrderInfo,TRequestOption requestOption) throws TException { 
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":" 
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    SvrContainer.getInstance().sendRequest(
        create_checkOrderPrePayServiceCall(routeKey, timeout, platformArgs, payOrderInfo), requestOption);
  }

  public long checkOrderPrePay(int routeKey, int timeout, com.longsheng.xueqiao.payment.thriftapi.PayOrderInfo payOrderInfo, IMethodCallback<PaymentDao.checkOrderPrePay_args, PaymentDao.checkOrderPrePay_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":"
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    return SvrContainer.getInstance().sendRequest(
            create_checkOrderPrePayServiceCall(routeKey, timeout, platformArgs, payOrderInfo), callback);
  }

  public long add_checkOrderPrePayCall(AsyncCallRunner runner, int routeKey, int timeout, com.longsheng.xueqiao.payment.thriftapi.PayOrderInfo payOrderInfo, IMethodCallback<PaymentDao.checkOrderPrePay_args, PaymentDao.checkOrderPrePay_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":" 
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    return runner.addAsyncCall(
            create_checkOrderPrePayServiceCall(routeKey, timeout, platformArgs, payOrderInfo), callback);
  }

  protected TServiceCall create_checkOrderPrePayServiceCall(int routeKey, int timeout, org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, com.longsheng.xueqiao.payment.thriftapi.PayOrderInfo payOrderInfo){
    TServiceCall serviceCall = new TServiceCall();
    if (!getPeerAddr().isEmpty()) {
      serviceCall.setChooseServiceIp(getPeerAddr());
    }
    if (getPeerPort() != 0) {
      serviceCall.setChooseServicePort(getPeerPort());
    }
    serviceCall.setServiceKey(PaymentDaoVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    PaymentDao.checkOrderPrePay_args request = new PaymentDao.checkOrderPrePay_args();
    request.setPlatformArgs(platformArgs);
    request.setPayOrderInfo(payOrderInfo);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("checkOrderPrePay");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(PaymentDao.checkOrderPrePay_result.class);
    return serviceCall;
  }

  public void send_operateOrder(int routeKey, int timeout, com.longsheng.xueqiao.payment.thriftapi.OperateOrderInfo info) throws TException {
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":" 
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    SvrContainer.getInstance().sendRequest(
        create_operateOrderServiceCall(routeKey, timeout, platformArgs, info), new TRequestOption());
  }

  public void send_operateOrder(int routeKey, int timeout, com.longsheng.xueqiao.payment.thriftapi.OperateOrderInfo info,TRequestOption requestOption) throws TException { 
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":" 
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    SvrContainer.getInstance().sendRequest(
        create_operateOrderServiceCall(routeKey, timeout, platformArgs, info), requestOption);
  }

  public long operateOrder(int routeKey, int timeout, com.longsheng.xueqiao.payment.thriftapi.OperateOrderInfo info, IMethodCallback<PaymentDao.operateOrder_args, PaymentDao.operateOrder_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":"
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    return SvrContainer.getInstance().sendRequest(
            create_operateOrderServiceCall(routeKey, timeout, platformArgs, info), callback);
  }

  public long add_operateOrderCall(AsyncCallRunner runner, int routeKey, int timeout, com.longsheng.xueqiao.payment.thriftapi.OperateOrderInfo info, IMethodCallback<PaymentDao.operateOrder_args, PaymentDao.operateOrder_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":" 
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    return runner.addAsyncCall(
            create_operateOrderServiceCall(routeKey, timeout, platformArgs, info), callback);
  }

  protected TServiceCall create_operateOrderServiceCall(int routeKey, int timeout, org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, com.longsheng.xueqiao.payment.thriftapi.OperateOrderInfo info){
    TServiceCall serviceCall = new TServiceCall();
    if (!getPeerAddr().isEmpty()) {
      serviceCall.setChooseServiceIp(getPeerAddr());
    }
    if (getPeerPort() != 0) {
      serviceCall.setChooseServicePort(getPeerPort());
    }
    serviceCall.setServiceKey(PaymentDaoVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    PaymentDao.operateOrder_args request = new PaymentDao.operateOrder_args();
    request.setPlatformArgs(platformArgs);
    request.setInfo(info);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("operateOrder");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(PaymentDao.operateOrder_result.class);
    return serviceCall;
  }

  public void send_setNewMachineOrderGroupId(int routeKey, int timeout, int orderId, int companyGroupId) throws TException {
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":" 
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    SvrContainer.getInstance().sendRequest(
        create_setNewMachineOrderGroupIdServiceCall(routeKey, timeout, platformArgs, orderId, companyGroupId), new TRequestOption());
  }

  public void send_setNewMachineOrderGroupId(int routeKey, int timeout, int orderId, int companyGroupId,TRequestOption requestOption) throws TException { 
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":" 
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    SvrContainer.getInstance().sendRequest(
        create_setNewMachineOrderGroupIdServiceCall(routeKey, timeout, platformArgs, orderId, companyGroupId), requestOption);
  }

  public long setNewMachineOrderGroupId(int routeKey, int timeout, int orderId, int companyGroupId, IMethodCallback<PaymentDao.setNewMachineOrderGroupId_args, PaymentDao.setNewMachineOrderGroupId_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":"
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    return SvrContainer.getInstance().sendRequest(
            create_setNewMachineOrderGroupIdServiceCall(routeKey, timeout, platformArgs, orderId, companyGroupId), callback);
  }

  public long add_setNewMachineOrderGroupIdCall(AsyncCallRunner runner, int routeKey, int timeout, int orderId, int companyGroupId, IMethodCallback<PaymentDao.setNewMachineOrderGroupId_args, PaymentDao.setNewMachineOrderGroupId_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":" 
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    return runner.addAsyncCall(
            create_setNewMachineOrderGroupIdServiceCall(routeKey, timeout, platformArgs, orderId, companyGroupId), callback);
  }

  protected TServiceCall create_setNewMachineOrderGroupIdServiceCall(int routeKey, int timeout, org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, int orderId, int companyGroupId){
    TServiceCall serviceCall = new TServiceCall();
    if (!getPeerAddr().isEmpty()) {
      serviceCall.setChooseServiceIp(getPeerAddr());
    }
    if (getPeerPort() != 0) {
      serviceCall.setChooseServicePort(getPeerPort());
    }
    serviceCall.setServiceKey(PaymentDaoVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    PaymentDao.setNewMachineOrderGroupId_args request = new PaymentDao.setNewMachineOrderGroupId_args();
    request.setPlatformArgs(platformArgs);
    request.setOrderId(orderId);
    request.setCompanyGroupId(companyGroupId);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("setNewMachineOrderGroupId");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(PaymentDao.setNewMachineOrderGroupId_result.class);
    return serviceCall;
  }

  public void send_reqCompanyGroupSpec(int routeKey, int timeout, com.longsheng.xueqiao.payment.thriftapi.ReqCompanyGroupSpecOption option) throws TException {
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":" 
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    SvrContainer.getInstance().sendRequest(
        create_reqCompanyGroupSpecServiceCall(routeKey, timeout, platformArgs, option), new TRequestOption());
  }

  public void send_reqCompanyGroupSpec(int routeKey, int timeout, com.longsheng.xueqiao.payment.thriftapi.ReqCompanyGroupSpecOption option,TRequestOption requestOption) throws TException { 
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":" 
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    SvrContainer.getInstance().sendRequest(
        create_reqCompanyGroupSpecServiceCall(routeKey, timeout, platformArgs, option), requestOption);
  }

  public long reqCompanyGroupSpec(int routeKey, int timeout, com.longsheng.xueqiao.payment.thriftapi.ReqCompanyGroupSpecOption option, IMethodCallback<PaymentDao.reqCompanyGroupSpec_args, PaymentDao.reqCompanyGroupSpec_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":"
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    return SvrContainer.getInstance().sendRequest(
            create_reqCompanyGroupSpecServiceCall(routeKey, timeout, platformArgs, option), callback);
  }

  public long add_reqCompanyGroupSpecCall(AsyncCallRunner runner, int routeKey, int timeout, com.longsheng.xueqiao.payment.thriftapi.ReqCompanyGroupSpecOption option, IMethodCallback<PaymentDao.reqCompanyGroupSpec_args, PaymentDao.reqCompanyGroupSpec_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":" 
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    return runner.addAsyncCall(
            create_reqCompanyGroupSpecServiceCall(routeKey, timeout, platformArgs, option), callback);
  }

  protected TServiceCall create_reqCompanyGroupSpecServiceCall(int routeKey, int timeout, org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, com.longsheng.xueqiao.payment.thriftapi.ReqCompanyGroupSpecOption option){
    TServiceCall serviceCall = new TServiceCall();
    if (!getPeerAddr().isEmpty()) {
      serviceCall.setChooseServiceIp(getPeerAddr());
    }
    if (getPeerPort() != 0) {
      serviceCall.setChooseServicePort(getPeerPort());
    }
    serviceCall.setServiceKey(PaymentDaoVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    PaymentDao.reqCompanyGroupSpec_args request = new PaymentDao.reqCompanyGroupSpec_args();
    request.setPlatformArgs(platformArgs);
    request.setOption(option);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("reqCompanyGroupSpec");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(PaymentDao.reqCompanyGroupSpec_result.class);
    return serviceCall;
  }

  public void send_xcoinPay(int routeKey, int timeout, com.longsheng.xueqiao.payment.thriftapi.PayOrderInfo payOrderInfo) throws TException {
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":" 
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    SvrContainer.getInstance().sendRequest(
        create_xcoinPayServiceCall(routeKey, timeout, platformArgs, payOrderInfo), new TRequestOption());
  }

  public void send_xcoinPay(int routeKey, int timeout, com.longsheng.xueqiao.payment.thriftapi.PayOrderInfo payOrderInfo,TRequestOption requestOption) throws TException { 
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":" 
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    SvrContainer.getInstance().sendRequest(
        create_xcoinPayServiceCall(routeKey, timeout, platformArgs, payOrderInfo), requestOption);
  }

  public long xcoinPay(int routeKey, int timeout, com.longsheng.xueqiao.payment.thriftapi.PayOrderInfo payOrderInfo, IMethodCallback<PaymentDao.xcoinPay_args, PaymentDao.xcoinPay_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":"
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    return SvrContainer.getInstance().sendRequest(
            create_xcoinPayServiceCall(routeKey, timeout, platformArgs, payOrderInfo), callback);
  }

  public long add_xcoinPayCall(AsyncCallRunner runner, int routeKey, int timeout, com.longsheng.xueqiao.payment.thriftapi.PayOrderInfo payOrderInfo, IMethodCallback<PaymentDao.xcoinPay_args, PaymentDao.xcoinPay_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":" 
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    return runner.addAsyncCall(
            create_xcoinPayServiceCall(routeKey, timeout, platformArgs, payOrderInfo), callback);
  }

  protected TServiceCall create_xcoinPayServiceCall(int routeKey, int timeout, org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, com.longsheng.xueqiao.payment.thriftapi.PayOrderInfo payOrderInfo){
    TServiceCall serviceCall = new TServiceCall();
    if (!getPeerAddr().isEmpty()) {
      serviceCall.setChooseServiceIp(getPeerAddr());
    }
    if (getPeerPort() != 0) {
      serviceCall.setChooseServicePort(getPeerPort());
    }
    serviceCall.setServiceKey(PaymentDaoVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    PaymentDao.xcoinPay_args request = new PaymentDao.xcoinPay_args();
    request.setPlatformArgs(platformArgs);
    request.setPayOrderInfo(payOrderInfo);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("xcoinPay");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(PaymentDao.xcoinPay_result.class);
    return serviceCall;
  }

  public void send_alterCompanyBalance(int routeKey, int timeout, com.longsheng.xueqiao.payment.balance.alteration.BalanceAlteration balanceAlteration) throws TException {
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":" 
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    SvrContainer.getInstance().sendRequest(
        create_alterCompanyBalanceServiceCall(routeKey, timeout, platformArgs, balanceAlteration), new TRequestOption());
  }

  public void send_alterCompanyBalance(int routeKey, int timeout, com.longsheng.xueqiao.payment.balance.alteration.BalanceAlteration balanceAlteration,TRequestOption requestOption) throws TException { 
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":" 
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    SvrContainer.getInstance().sendRequest(
        create_alterCompanyBalanceServiceCall(routeKey, timeout, platformArgs, balanceAlteration), requestOption);
  }

  public long alterCompanyBalance(int routeKey, int timeout, com.longsheng.xueqiao.payment.balance.alteration.BalanceAlteration balanceAlteration, IMethodCallback<PaymentDao.alterCompanyBalance_args, PaymentDao.alterCompanyBalance_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":"
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    return SvrContainer.getInstance().sendRequest(
            create_alterCompanyBalanceServiceCall(routeKey, timeout, platformArgs, balanceAlteration), callback);
  }

  public long add_alterCompanyBalanceCall(AsyncCallRunner runner, int routeKey, int timeout, com.longsheng.xueqiao.payment.balance.alteration.BalanceAlteration balanceAlteration, IMethodCallback<PaymentDao.alterCompanyBalance_args, PaymentDao.alterCompanyBalance_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":" 
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    return runner.addAsyncCall(
            create_alterCompanyBalanceServiceCall(routeKey, timeout, platformArgs, balanceAlteration), callback);
  }

  protected TServiceCall create_alterCompanyBalanceServiceCall(int routeKey, int timeout, org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, com.longsheng.xueqiao.payment.balance.alteration.BalanceAlteration balanceAlteration){
    TServiceCall serviceCall = new TServiceCall();
    if (!getPeerAddr().isEmpty()) {
      serviceCall.setChooseServiceIp(getPeerAddr());
    }
    if (getPeerPort() != 0) {
      serviceCall.setChooseServicePort(getPeerPort());
    }
    serviceCall.setServiceKey(PaymentDaoVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    PaymentDao.alterCompanyBalance_args request = new PaymentDao.alterCompanyBalance_args();
    request.setPlatformArgs(platformArgs);
    request.setBalanceAlteration(balanceAlteration);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("alterCompanyBalance");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(PaymentDao.alterCompanyBalance_result.class);
    return serviceCall;
  }

  public void send_updateCompanyBalanceAlteration(int routeKey, int timeout, com.longsheng.xueqiao.payment.balance.alteration.BalanceAlteration balanceAlteration) throws TException {
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":" 
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    SvrContainer.getInstance().sendRequest(
        create_updateCompanyBalanceAlterationServiceCall(routeKey, timeout, platformArgs, balanceAlteration), new TRequestOption());
  }

  public void send_updateCompanyBalanceAlteration(int routeKey, int timeout, com.longsheng.xueqiao.payment.balance.alteration.BalanceAlteration balanceAlteration,TRequestOption requestOption) throws TException { 
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":" 
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    SvrContainer.getInstance().sendRequest(
        create_updateCompanyBalanceAlterationServiceCall(routeKey, timeout, platformArgs, balanceAlteration), requestOption);
  }

  public long updateCompanyBalanceAlteration(int routeKey, int timeout, com.longsheng.xueqiao.payment.balance.alteration.BalanceAlteration balanceAlteration, IMethodCallback<PaymentDao.updateCompanyBalanceAlteration_args, PaymentDao.updateCompanyBalanceAlteration_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":"
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    return SvrContainer.getInstance().sendRequest(
            create_updateCompanyBalanceAlterationServiceCall(routeKey, timeout, platformArgs, balanceAlteration), callback);
  }

  public long add_updateCompanyBalanceAlterationCall(AsyncCallRunner runner, int routeKey, int timeout, com.longsheng.xueqiao.payment.balance.alteration.BalanceAlteration balanceAlteration, IMethodCallback<PaymentDao.updateCompanyBalanceAlteration_args, PaymentDao.updateCompanyBalanceAlteration_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":" 
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    return runner.addAsyncCall(
            create_updateCompanyBalanceAlterationServiceCall(routeKey, timeout, platformArgs, balanceAlteration), callback);
  }

  protected TServiceCall create_updateCompanyBalanceAlterationServiceCall(int routeKey, int timeout, org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, com.longsheng.xueqiao.payment.balance.alteration.BalanceAlteration balanceAlteration){
    TServiceCall serviceCall = new TServiceCall();
    if (!getPeerAddr().isEmpty()) {
      serviceCall.setChooseServiceIp(getPeerAddr());
    }
    if (getPeerPort() != 0) {
      serviceCall.setChooseServicePort(getPeerPort());
    }
    serviceCall.setServiceKey(PaymentDaoVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    PaymentDao.updateCompanyBalanceAlteration_args request = new PaymentDao.updateCompanyBalanceAlteration_args();
    request.setPlatformArgs(platformArgs);
    request.setBalanceAlteration(balanceAlteration);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("updateCompanyBalanceAlteration");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(PaymentDao.updateCompanyBalanceAlteration_result.class);
    return serviceCall;
  }

  public void send_reqCompanyBalanceAlteration(int routeKey, int timeout, com.longsheng.xueqiao.payment.balance.alteration.ReqBalanceAlterationOption reqOption, org.soldier.platform.page.IndexedPageOption pageOption) throws TException {
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":" 
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    SvrContainer.getInstance().sendRequest(
        create_reqCompanyBalanceAlterationServiceCall(routeKey, timeout, platformArgs, reqOption, pageOption), new TRequestOption());
  }

  public void send_reqCompanyBalanceAlteration(int routeKey, int timeout, com.longsheng.xueqiao.payment.balance.alteration.ReqBalanceAlterationOption reqOption, org.soldier.platform.page.IndexedPageOption pageOption,TRequestOption requestOption) throws TException { 
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":" 
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    SvrContainer.getInstance().sendRequest(
        create_reqCompanyBalanceAlterationServiceCall(routeKey, timeout, platformArgs, reqOption, pageOption), requestOption);
  }

  public long reqCompanyBalanceAlteration(int routeKey, int timeout, com.longsheng.xueqiao.payment.balance.alteration.ReqBalanceAlterationOption reqOption, org.soldier.platform.page.IndexedPageOption pageOption, IMethodCallback<PaymentDao.reqCompanyBalanceAlteration_args, PaymentDao.reqCompanyBalanceAlteration_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":"
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    return SvrContainer.getInstance().sendRequest(
            create_reqCompanyBalanceAlterationServiceCall(routeKey, timeout, platformArgs, reqOption, pageOption), callback);
  }

  public long add_reqCompanyBalanceAlterationCall(AsyncCallRunner runner, int routeKey, int timeout, com.longsheng.xueqiao.payment.balance.alteration.ReqBalanceAlterationOption reqOption, org.soldier.platform.page.IndexedPageOption pageOption, IMethodCallback<PaymentDao.reqCompanyBalanceAlteration_args, PaymentDao.reqCompanyBalanceAlteration_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":" 
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    return runner.addAsyncCall(
            create_reqCompanyBalanceAlterationServiceCall(routeKey, timeout, platformArgs, reqOption, pageOption), callback);
  }

  protected TServiceCall create_reqCompanyBalanceAlterationServiceCall(int routeKey, int timeout, org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, com.longsheng.xueqiao.payment.balance.alteration.ReqBalanceAlterationOption reqOption, org.soldier.platform.page.IndexedPageOption pageOption){
    TServiceCall serviceCall = new TServiceCall();
    if (!getPeerAddr().isEmpty()) {
      serviceCall.setChooseServiceIp(getPeerAddr());
    }
    if (getPeerPort() != 0) {
      serviceCall.setChooseServicePort(getPeerPort());
    }
    serviceCall.setServiceKey(PaymentDaoVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    PaymentDao.reqCompanyBalanceAlteration_args request = new PaymentDao.reqCompanyBalanceAlteration_args();
    request.setPlatformArgs(platformArgs);
    request.setReqOption(reqOption);
    request.setPageOption(pageOption);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("reqCompanyBalanceAlteration");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(PaymentDao.reqCompanyBalanceAlteration_result.class);
    return serviceCall;
  }

  public void send_removeInvalidOrder(int routeKey, int timeout, int orderId) throws TException {
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":" 
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    SvrContainer.getInstance().sendRequest(
        create_removeInvalidOrderServiceCall(routeKey, timeout, platformArgs, orderId), new TRequestOption());
  }

  public void send_removeInvalidOrder(int routeKey, int timeout, int orderId,TRequestOption requestOption) throws TException { 
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":" 
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    SvrContainer.getInstance().sendRequest(
        create_removeInvalidOrderServiceCall(routeKey, timeout, platformArgs, orderId), requestOption);
  }

  public long removeInvalidOrder(int routeKey, int timeout, int orderId, IMethodCallback<PaymentDao.removeInvalidOrder_args, PaymentDao.removeInvalidOrder_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":"
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    return SvrContainer.getInstance().sendRequest(
            create_removeInvalidOrderServiceCall(routeKey, timeout, platformArgs, orderId), callback);
  }

  public long add_removeInvalidOrderCall(AsyncCallRunner runner, int routeKey, int timeout, int orderId, IMethodCallback<PaymentDao.removeInvalidOrder_args, PaymentDao.removeInvalidOrder_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":" 
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    return runner.addAsyncCall(
            create_removeInvalidOrderServiceCall(routeKey, timeout, platformArgs, orderId), callback);
  }

  protected TServiceCall create_removeInvalidOrderServiceCall(int routeKey, int timeout, org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, int orderId){
    TServiceCall serviceCall = new TServiceCall();
    if (!getPeerAddr().isEmpty()) {
      serviceCall.setChooseServiceIp(getPeerAddr());
    }
    if (getPeerPort() != 0) {
      serviceCall.setChooseServicePort(getPeerPort());
    }
    serviceCall.setServiceKey(PaymentDaoVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    PaymentDao.removeInvalidOrder_args request = new PaymentDao.removeInvalidOrder_args();
    request.setPlatformArgs(platformArgs);
    request.setOrderId(orderId);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("removeInvalidOrder");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(PaymentDao.removeInvalidOrder_result.class);
    return serviceCall;
  }

}
