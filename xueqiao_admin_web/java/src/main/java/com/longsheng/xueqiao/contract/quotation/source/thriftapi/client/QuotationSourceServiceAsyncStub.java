package com.longsheng.xueqiao.contract.quotation.source.thriftapi.client;

import com.longsheng.xueqiao.contract.quotation.source.thriftapi.QuotationSourceService;
import com.longsheng.xueqiao.contract.quotation.source.thriftapi.QuotationSourceServiceVariable;
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

public class QuotationSourceServiceAsyncStub extends BaseStub { 
  public QuotationSourceServiceAsyncStub() {
    super(QuotationSourceServiceVariable.serviceKey);
  }
  public void send_addQuotationAccount(int routeKey, int timeout, QuotationAccount quotationAccount) throws TException {
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
        create_addQuotationAccountServiceCall(routeKey, timeout, platformArgs, quotationAccount), new TRequestOption());
  }

  public void send_addQuotationAccount(int routeKey, int timeout, QuotationAccount quotationAccount,TRequestOption requestOption) throws TException { 
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
        create_addQuotationAccountServiceCall(routeKey, timeout, platformArgs, quotationAccount), requestOption);
  }

  public long addQuotationAccount(int routeKey, int timeout, QuotationAccount quotationAccount, IMethodCallback<QuotationSourceService.addQuotationAccount_args, QuotationSourceService.addQuotationAccount_result> callback) throws TException{
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
            create_addQuotationAccountServiceCall(routeKey, timeout, platformArgs, quotationAccount), callback);
  }

  public long add_addQuotationAccountCall(AsyncCallRunner runner, int routeKey, int timeout, QuotationAccount quotationAccount, IMethodCallback<QuotationSourceService.addQuotationAccount_args, QuotationSourceService.addQuotationAccount_result> callback) throws TException{
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
            create_addQuotationAccountServiceCall(routeKey, timeout, platformArgs, quotationAccount), callback);
  }

  protected TServiceCall create_addQuotationAccountServiceCall(int routeKey, int timeout, org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, QuotationAccount quotationAccount){
    TServiceCall serviceCall = new TServiceCall();
    if (!getPeerAddr().isEmpty()) {
      serviceCall.setChooseServiceIp(getPeerAddr());
    }
    if (getPeerPort() != 0) {
      serviceCall.setChooseServicePort(getPeerPort());
    }
    serviceCall.setServiceKey(QuotationSourceServiceVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    QuotationSourceService.addQuotationAccount_args request = new QuotationSourceService.addQuotationAccount_args();
    request.setPlatformArgs(platformArgs);
    request.setQuotationAccount(quotationAccount);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("addQuotationAccount");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(QuotationSourceService.addQuotationAccount_result.class);
    return serviceCall;
  }

  public void send_updateQuotationAccount(int routeKey, int timeout, QuotationAccount quotationAccount) throws TException {
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
        create_updateQuotationAccountServiceCall(routeKey, timeout, platformArgs, quotationAccount), new TRequestOption());
  }

  public void send_updateQuotationAccount(int routeKey, int timeout, QuotationAccount quotationAccount,TRequestOption requestOption) throws TException { 
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
        create_updateQuotationAccountServiceCall(routeKey, timeout, platformArgs, quotationAccount), requestOption);
  }

  public long updateQuotationAccount(int routeKey, int timeout, QuotationAccount quotationAccount, IMethodCallback<QuotationSourceService.updateQuotationAccount_args, QuotationSourceService.updateQuotationAccount_result> callback) throws TException{
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
            create_updateQuotationAccountServiceCall(routeKey, timeout, platformArgs, quotationAccount), callback);
  }

  public long add_updateQuotationAccountCall(AsyncCallRunner runner, int routeKey, int timeout, QuotationAccount quotationAccount, IMethodCallback<QuotationSourceService.updateQuotationAccount_args, QuotationSourceService.updateQuotationAccount_result> callback) throws TException{
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
            create_updateQuotationAccountServiceCall(routeKey, timeout, platformArgs, quotationAccount), callback);
  }

  protected TServiceCall create_updateQuotationAccountServiceCall(int routeKey, int timeout, org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, QuotationAccount quotationAccount){
    TServiceCall serviceCall = new TServiceCall();
    if (!getPeerAddr().isEmpty()) {
      serviceCall.setChooseServiceIp(getPeerAddr());
    }
    if (getPeerPort() != 0) {
      serviceCall.setChooseServicePort(getPeerPort());
    }
    serviceCall.setServiceKey(QuotationSourceServiceVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    QuotationSourceService.updateQuotationAccount_args request = new QuotationSourceService.updateQuotationAccount_args();
    request.setPlatformArgs(platformArgs);
    request.setQuotationAccount(quotationAccount);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("updateQuotationAccount");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(QuotationSourceService.updateQuotationAccount_result.class);
    return serviceCall;
  }

  public void send_updateQuotationAccountSubscribeQuota(int routeKey, int timeout, QuotationAccountSubscribeQuota quotationAccount) throws TException {
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
        create_updateQuotationAccountSubscribeQuotaServiceCall(routeKey, timeout, platformArgs, quotationAccount), new TRequestOption());
  }

  public void send_updateQuotationAccountSubscribeQuota(int routeKey, int timeout, QuotationAccountSubscribeQuota quotationAccount,TRequestOption requestOption) throws TException { 
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
        create_updateQuotationAccountSubscribeQuotaServiceCall(routeKey, timeout, platformArgs, quotationAccount), requestOption);
  }

  public long updateQuotationAccountSubscribeQuota(int routeKey, int timeout, QuotationAccountSubscribeQuota quotationAccount, IMethodCallback<QuotationSourceService.updateQuotationAccountSubscribeQuota_args, QuotationSourceService.updateQuotationAccountSubscribeQuota_result> callback) throws TException{
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
            create_updateQuotationAccountSubscribeQuotaServiceCall(routeKey, timeout, platformArgs, quotationAccount), callback);
  }

  public long add_updateQuotationAccountSubscribeQuotaCall(AsyncCallRunner runner, int routeKey, int timeout, QuotationAccountSubscribeQuota quotationAccount, IMethodCallback<QuotationSourceService.updateQuotationAccountSubscribeQuota_args, QuotationSourceService.updateQuotationAccountSubscribeQuota_result> callback) throws TException{
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
            create_updateQuotationAccountSubscribeQuotaServiceCall(routeKey, timeout, platformArgs, quotationAccount), callback);
  }

  protected TServiceCall create_updateQuotationAccountSubscribeQuotaServiceCall(int routeKey, int timeout, org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, QuotationAccountSubscribeQuota quotationAccount){
    TServiceCall serviceCall = new TServiceCall();
    if (!getPeerAddr().isEmpty()) {
      serviceCall.setChooseServiceIp(getPeerAddr());
    }
    if (getPeerPort() != 0) {
      serviceCall.setChooseServicePort(getPeerPort());
    }
    serviceCall.setServiceKey(QuotationSourceServiceVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    QuotationSourceService.updateQuotationAccountSubscribeQuota_args request = new QuotationSourceService.updateQuotationAccountSubscribeQuota_args();
    request.setPlatformArgs(platformArgs);
    request.setQuotationAccount(quotationAccount);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("updateQuotationAccountSubscribeQuota");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(QuotationSourceService.updateQuotationAccountSubscribeQuota_result.class);
    return serviceCall;
  }

  public void send_reqQuotationAccount(int routeKey, int timeout, ReqQuotationAccountOption option, org.soldier.platform.page.IndexedPageOption pageOption) throws TException {
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
        create_reqQuotationAccountServiceCall(routeKey, timeout, platformArgs, option, pageOption), new TRequestOption());
  }

  public void send_reqQuotationAccount(int routeKey, int timeout, ReqQuotationAccountOption option, org.soldier.platform.page.IndexedPageOption pageOption,TRequestOption requestOption) throws TException { 
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
        create_reqQuotationAccountServiceCall(routeKey, timeout, platformArgs, option, pageOption), requestOption);
  }

  public long reqQuotationAccount(int routeKey, int timeout, ReqQuotationAccountOption option, org.soldier.platform.page.IndexedPageOption pageOption, IMethodCallback<QuotationSourceService.reqQuotationAccount_args, QuotationSourceService.reqQuotationAccount_result> callback) throws TException{
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
            create_reqQuotationAccountServiceCall(routeKey, timeout, platformArgs, option, pageOption), callback);
  }

  public long add_reqQuotationAccountCall(AsyncCallRunner runner, int routeKey, int timeout, ReqQuotationAccountOption option, org.soldier.platform.page.IndexedPageOption pageOption, IMethodCallback<QuotationSourceService.reqQuotationAccount_args, QuotationSourceService.reqQuotationAccount_result> callback) throws TException{
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
            create_reqQuotationAccountServiceCall(routeKey, timeout, platformArgs, option, pageOption), callback);
  }

  protected TServiceCall create_reqQuotationAccountServiceCall(int routeKey, int timeout, org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, ReqQuotationAccountOption option, org.soldier.platform.page.IndexedPageOption pageOption){
    TServiceCall serviceCall = new TServiceCall();
    if (!getPeerAddr().isEmpty()) {
      serviceCall.setChooseServiceIp(getPeerAddr());
    }
    if (getPeerPort() != 0) {
      serviceCall.setChooseServicePort(getPeerPort());
    }
    serviceCall.setServiceKey(QuotationSourceServiceVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    QuotationSourceService.reqQuotationAccount_args request = new QuotationSourceService.reqQuotationAccount_args();
    request.setPlatformArgs(platformArgs);
    request.setOption(option);
    request.setPageOption(pageOption);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("reqQuotationAccount");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(QuotationSourceService.reqQuotationAccount_result.class);
    return serviceCall;
  }

  public void send_reqQuotationAccountSubscribeQuota(int routeKey, int timeout, ReqQuotationAccountSubscribeQuotaOption option, org.soldier.platform.page.IndexedPageOption pageOption) throws TException {
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
        create_reqQuotationAccountSubscribeQuotaServiceCall(routeKey, timeout, platformArgs, option, pageOption), new TRequestOption());
  }

  public void send_reqQuotationAccountSubscribeQuota(int routeKey, int timeout, ReqQuotationAccountSubscribeQuotaOption option, org.soldier.platform.page.IndexedPageOption pageOption,TRequestOption requestOption) throws TException { 
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
        create_reqQuotationAccountSubscribeQuotaServiceCall(routeKey, timeout, platformArgs, option, pageOption), requestOption);
  }

  public long reqQuotationAccountSubscribeQuota(int routeKey, int timeout, ReqQuotationAccountSubscribeQuotaOption option, org.soldier.platform.page.IndexedPageOption pageOption, IMethodCallback<QuotationSourceService.reqQuotationAccountSubscribeQuota_args, QuotationSourceService.reqQuotationAccountSubscribeQuota_result> callback) throws TException{
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
            create_reqQuotationAccountSubscribeQuotaServiceCall(routeKey, timeout, platformArgs, option, pageOption), callback);
  }

  public long add_reqQuotationAccountSubscribeQuotaCall(AsyncCallRunner runner, int routeKey, int timeout, ReqQuotationAccountSubscribeQuotaOption option, org.soldier.platform.page.IndexedPageOption pageOption, IMethodCallback<QuotationSourceService.reqQuotationAccountSubscribeQuota_args, QuotationSourceService.reqQuotationAccountSubscribeQuota_result> callback) throws TException{
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
            create_reqQuotationAccountSubscribeQuotaServiceCall(routeKey, timeout, platformArgs, option, pageOption), callback);
  }

  protected TServiceCall create_reqQuotationAccountSubscribeQuotaServiceCall(int routeKey, int timeout, org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, ReqQuotationAccountSubscribeQuotaOption option, org.soldier.platform.page.IndexedPageOption pageOption){
    TServiceCall serviceCall = new TServiceCall();
    if (!getPeerAddr().isEmpty()) {
      serviceCall.setChooseServiceIp(getPeerAddr());
    }
    if (getPeerPort() != 0) {
      serviceCall.setChooseServicePort(getPeerPort());
    }
    serviceCall.setServiceKey(QuotationSourceServiceVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    QuotationSourceService.reqQuotationAccountSubscribeQuota_args request = new QuotationSourceService.reqQuotationAccountSubscribeQuota_args();
    request.setPlatformArgs(platformArgs);
    request.setOption(option);
    request.setPageOption(pageOption);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("reqQuotationAccountSubscribeQuota");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(QuotationSourceService.reqQuotationAccountSubscribeQuota_result.class);
    return serviceCall;
  }

  public void send_addCommoditySubscribeQuota(int routeKey, int timeout, CommoditySubscribeQuota commoditySubscribeQuota) throws TException {
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
        create_addCommoditySubscribeQuotaServiceCall(routeKey, timeout, platformArgs, commoditySubscribeQuota), new TRequestOption());
  }

  public void send_addCommoditySubscribeQuota(int routeKey, int timeout, CommoditySubscribeQuota commoditySubscribeQuota,TRequestOption requestOption) throws TException { 
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
        create_addCommoditySubscribeQuotaServiceCall(routeKey, timeout, platformArgs, commoditySubscribeQuota), requestOption);
  }

  public long addCommoditySubscribeQuota(int routeKey, int timeout, CommoditySubscribeQuota commoditySubscribeQuota, IMethodCallback<QuotationSourceService.addCommoditySubscribeQuota_args, QuotationSourceService.addCommoditySubscribeQuota_result> callback) throws TException{
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
            create_addCommoditySubscribeQuotaServiceCall(routeKey, timeout, platformArgs, commoditySubscribeQuota), callback);
  }

  public long add_addCommoditySubscribeQuotaCall(AsyncCallRunner runner, int routeKey, int timeout, CommoditySubscribeQuota commoditySubscribeQuota, IMethodCallback<QuotationSourceService.addCommoditySubscribeQuota_args, QuotationSourceService.addCommoditySubscribeQuota_result> callback) throws TException{
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
            create_addCommoditySubscribeQuotaServiceCall(routeKey, timeout, platformArgs, commoditySubscribeQuota), callback);
  }

  protected TServiceCall create_addCommoditySubscribeQuotaServiceCall(int routeKey, int timeout, org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, CommoditySubscribeQuota commoditySubscribeQuota){
    TServiceCall serviceCall = new TServiceCall();
    if (!getPeerAddr().isEmpty()) {
      serviceCall.setChooseServiceIp(getPeerAddr());
    }
    if (getPeerPort() != 0) {
      serviceCall.setChooseServicePort(getPeerPort());
    }
    serviceCall.setServiceKey(QuotationSourceServiceVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    QuotationSourceService.addCommoditySubscribeQuota_args request = new QuotationSourceService.addCommoditySubscribeQuota_args();
    request.setPlatformArgs(platformArgs);
    request.setCommoditySubscribeQuota(commoditySubscribeQuota);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("addCommoditySubscribeQuota");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(QuotationSourceService.addCommoditySubscribeQuota_result.class);
    return serviceCall;
  }

  public void send_updateCommoditySubscribeQuota(int routeKey, int timeout, CommoditySubscribeQuota commoditySubscribeQuota) throws TException {
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
        create_updateCommoditySubscribeQuotaServiceCall(routeKey, timeout, platformArgs, commoditySubscribeQuota), new TRequestOption());
  }

  public void send_updateCommoditySubscribeQuota(int routeKey, int timeout, CommoditySubscribeQuota commoditySubscribeQuota,TRequestOption requestOption) throws TException { 
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
        create_updateCommoditySubscribeQuotaServiceCall(routeKey, timeout, platformArgs, commoditySubscribeQuota), requestOption);
  }

  public long updateCommoditySubscribeQuota(int routeKey, int timeout, CommoditySubscribeQuota commoditySubscribeQuota, IMethodCallback<QuotationSourceService.updateCommoditySubscribeQuota_args, QuotationSourceService.updateCommoditySubscribeQuota_result> callback) throws TException{
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
            create_updateCommoditySubscribeQuotaServiceCall(routeKey, timeout, platformArgs, commoditySubscribeQuota), callback);
  }

  public long add_updateCommoditySubscribeQuotaCall(AsyncCallRunner runner, int routeKey, int timeout, CommoditySubscribeQuota commoditySubscribeQuota, IMethodCallback<QuotationSourceService.updateCommoditySubscribeQuota_args, QuotationSourceService.updateCommoditySubscribeQuota_result> callback) throws TException{
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
            create_updateCommoditySubscribeQuotaServiceCall(routeKey, timeout, platformArgs, commoditySubscribeQuota), callback);
  }

  protected TServiceCall create_updateCommoditySubscribeQuotaServiceCall(int routeKey, int timeout, org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, CommoditySubscribeQuota commoditySubscribeQuota){
    TServiceCall serviceCall = new TServiceCall();
    if (!getPeerAddr().isEmpty()) {
      serviceCall.setChooseServiceIp(getPeerAddr());
    }
    if (getPeerPort() != 0) {
      serviceCall.setChooseServicePort(getPeerPort());
    }
    serviceCall.setServiceKey(QuotationSourceServiceVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    QuotationSourceService.updateCommoditySubscribeQuota_args request = new QuotationSourceService.updateCommoditySubscribeQuota_args();
    request.setPlatformArgs(platformArgs);
    request.setCommoditySubscribeQuota(commoditySubscribeQuota);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("updateCommoditySubscribeQuota");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(QuotationSourceService.updateCommoditySubscribeQuota_result.class);
    return serviceCall;
  }

  public void send_reqCommoditySubscribeQuota(int routeKey, int timeout, ReqCommoditySubscribeQuotaOption option, org.soldier.platform.page.IndexedPageOption pageOption) throws TException {
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
        create_reqCommoditySubscribeQuotaServiceCall(routeKey, timeout, platformArgs, option, pageOption), new TRequestOption());
  }

  public void send_reqCommoditySubscribeQuota(int routeKey, int timeout, ReqCommoditySubscribeQuotaOption option, org.soldier.platform.page.IndexedPageOption pageOption,TRequestOption requestOption) throws TException { 
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
        create_reqCommoditySubscribeQuotaServiceCall(routeKey, timeout, platformArgs, option, pageOption), requestOption);
  }

  public long reqCommoditySubscribeQuota(int routeKey, int timeout, ReqCommoditySubscribeQuotaOption option, org.soldier.platform.page.IndexedPageOption pageOption, IMethodCallback<QuotationSourceService.reqCommoditySubscribeQuota_args, QuotationSourceService.reqCommoditySubscribeQuota_result> callback) throws TException{
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
            create_reqCommoditySubscribeQuotaServiceCall(routeKey, timeout, platformArgs, option, pageOption), callback);
  }

  public long add_reqCommoditySubscribeQuotaCall(AsyncCallRunner runner, int routeKey, int timeout, ReqCommoditySubscribeQuotaOption option, org.soldier.platform.page.IndexedPageOption pageOption, IMethodCallback<QuotationSourceService.reqCommoditySubscribeQuota_args, QuotationSourceService.reqCommoditySubscribeQuota_result> callback) throws TException{
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
            create_reqCommoditySubscribeQuotaServiceCall(routeKey, timeout, platformArgs, option, pageOption), callback);
  }

  protected TServiceCall create_reqCommoditySubscribeQuotaServiceCall(int routeKey, int timeout, org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, ReqCommoditySubscribeQuotaOption option, org.soldier.platform.page.IndexedPageOption pageOption){
    TServiceCall serviceCall = new TServiceCall();
    if (!getPeerAddr().isEmpty()) {
      serviceCall.setChooseServiceIp(getPeerAddr());
    }
    if (getPeerPort() != 0) {
      serviceCall.setChooseServicePort(getPeerPort());
    }
    serviceCall.setServiceKey(QuotationSourceServiceVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    QuotationSourceService.reqCommoditySubscribeQuota_args request = new QuotationSourceService.reqCommoditySubscribeQuota_args();
    request.setPlatformArgs(platformArgs);
    request.setOption(option);
    request.setPageOption(pageOption);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("reqCommoditySubscribeQuota");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(QuotationSourceService.reqCommoditySubscribeQuota_result.class);
    return serviceCall;
  }

  public void send_deleteQuotationAccount(int routeKey, int timeout, long accountId) throws TException {
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
        create_deleteQuotationAccountServiceCall(routeKey, timeout, platformArgs, accountId), new TRequestOption());
  }

  public void send_deleteQuotationAccount(int routeKey, int timeout, long accountId,TRequestOption requestOption) throws TException { 
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
        create_deleteQuotationAccountServiceCall(routeKey, timeout, platformArgs, accountId), requestOption);
  }

  public long deleteQuotationAccount(int routeKey, int timeout, long accountId, IMethodCallback<QuotationSourceService.deleteQuotationAccount_args, QuotationSourceService.deleteQuotationAccount_result> callback) throws TException{
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
            create_deleteQuotationAccountServiceCall(routeKey, timeout, platformArgs, accountId), callback);
  }

  public long add_deleteQuotationAccountCall(AsyncCallRunner runner, int routeKey, int timeout, long accountId, IMethodCallback<QuotationSourceService.deleteQuotationAccount_args, QuotationSourceService.deleteQuotationAccount_result> callback) throws TException{
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
            create_deleteQuotationAccountServiceCall(routeKey, timeout, platformArgs, accountId), callback);
  }

  protected TServiceCall create_deleteQuotationAccountServiceCall(int routeKey, int timeout, org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, long accountId){
    TServiceCall serviceCall = new TServiceCall();
    if (!getPeerAddr().isEmpty()) {
      serviceCall.setChooseServiceIp(getPeerAddr());
    }
    if (getPeerPort() != 0) {
      serviceCall.setChooseServicePort(getPeerPort());
    }
    serviceCall.setServiceKey(QuotationSourceServiceVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    QuotationSourceService.deleteQuotationAccount_args request = new QuotationSourceService.deleteQuotationAccount_args();
    request.setPlatformArgs(platformArgs);
    request.setAccountId(accountId);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("deleteQuotationAccount");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(QuotationSourceService.deleteQuotationAccount_result.class);
    return serviceCall;
  }

  public void send_setCommoditySubscribeAssigned(int routeKey, int timeout, Set<Long> accountId, int sledCommodityId) throws TException {
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
        create_setCommoditySubscribeAssignedServiceCall(routeKey, timeout, platformArgs, accountId, sledCommodityId), new TRequestOption());
  }

  public void send_setCommoditySubscribeAssigned(int routeKey, int timeout, Set<Long> accountId, int sledCommodityId,TRequestOption requestOption) throws TException { 
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
        create_setCommoditySubscribeAssignedServiceCall(routeKey, timeout, platformArgs, accountId, sledCommodityId), requestOption);
  }

  public long setCommoditySubscribeAssigned(int routeKey, int timeout, Set<Long> accountId, int sledCommodityId, IMethodCallback<QuotationSourceService.setCommoditySubscribeAssigned_args, QuotationSourceService.setCommoditySubscribeAssigned_result> callback) throws TException{
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
            create_setCommoditySubscribeAssignedServiceCall(routeKey, timeout, platformArgs, accountId, sledCommodityId), callback);
  }

  public long add_setCommoditySubscribeAssignedCall(AsyncCallRunner runner, int routeKey, int timeout, Set<Long> accountId, int sledCommodityId, IMethodCallback<QuotationSourceService.setCommoditySubscribeAssigned_args, QuotationSourceService.setCommoditySubscribeAssigned_result> callback) throws TException{
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
            create_setCommoditySubscribeAssignedServiceCall(routeKey, timeout, platformArgs, accountId, sledCommodityId), callback);
  }

  protected TServiceCall create_setCommoditySubscribeAssignedServiceCall(int routeKey, int timeout, org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, Set<Long> accountId, int sledCommodityId){
    TServiceCall serviceCall = new TServiceCall();
    if (!getPeerAddr().isEmpty()) {
      serviceCall.setChooseServiceIp(getPeerAddr());
    }
    if (getPeerPort() != 0) {
      serviceCall.setChooseServicePort(getPeerPort());
    }
    serviceCall.setServiceKey(QuotationSourceServiceVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    QuotationSourceService.setCommoditySubscribeAssigned_args request = new QuotationSourceService.setCommoditySubscribeAssigned_args();
    request.setPlatformArgs(platformArgs);
    request.setAccountId(accountId);
    request.setSledCommodityId(sledCommodityId);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("setCommoditySubscribeAssigned");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(QuotationSourceService.setCommoditySubscribeAssigned_result.class);
    return serviceCall;
  }

  public void send_deleteCommoditySubscribeAssigned(int routeKey, int timeout, long account, int sledCommodityId) throws TException {
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
        create_deleteCommoditySubscribeAssignedServiceCall(routeKey, timeout, platformArgs, account, sledCommodityId), new TRequestOption());
  }

  public void send_deleteCommoditySubscribeAssigned(int routeKey, int timeout, long account, int sledCommodityId,TRequestOption requestOption) throws TException { 
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
        create_deleteCommoditySubscribeAssignedServiceCall(routeKey, timeout, platformArgs, account, sledCommodityId), requestOption);
  }

  public long deleteCommoditySubscribeAssigned(int routeKey, int timeout, long account, int sledCommodityId, IMethodCallback<QuotationSourceService.deleteCommoditySubscribeAssigned_args, QuotationSourceService.deleteCommoditySubscribeAssigned_result> callback) throws TException{
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
            create_deleteCommoditySubscribeAssignedServiceCall(routeKey, timeout, platformArgs, account, sledCommodityId), callback);
  }

  public long add_deleteCommoditySubscribeAssignedCall(AsyncCallRunner runner, int routeKey, int timeout, long account, int sledCommodityId, IMethodCallback<QuotationSourceService.deleteCommoditySubscribeAssigned_args, QuotationSourceService.deleteCommoditySubscribeAssigned_result> callback) throws TException{
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
            create_deleteCommoditySubscribeAssignedServiceCall(routeKey, timeout, platformArgs, account, sledCommodityId), callback);
  }

  protected TServiceCall create_deleteCommoditySubscribeAssignedServiceCall(int routeKey, int timeout, org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, long account, int sledCommodityId){
    TServiceCall serviceCall = new TServiceCall();
    if (!getPeerAddr().isEmpty()) {
      serviceCall.setChooseServiceIp(getPeerAddr());
    }
    if (getPeerPort() != 0) {
      serviceCall.setChooseServicePort(getPeerPort());
    }
    serviceCall.setServiceKey(QuotationSourceServiceVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    QuotationSourceService.deleteCommoditySubscribeAssigned_args request = new QuotationSourceService.deleteCommoditySubscribeAssigned_args();
    request.setPlatformArgs(platformArgs);
    request.setAccount(account);
    request.setSledCommodityId(sledCommodityId);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("deleteCommoditySubscribeAssigned");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(QuotationSourceService.deleteCommoditySubscribeAssigned_result.class);
    return serviceCall;
  }

  public void send_reqCommodityRelatedQuotationAccountSubscribe(int routeKey, int timeout, ReqRelatedInfoOption option, org.soldier.platform.page.IndexedPageOption pageOption) throws TException {
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
        create_reqCommodityRelatedQuotationAccountSubscribeServiceCall(routeKey, timeout, platformArgs, option, pageOption), new TRequestOption());
  }

  public void send_reqCommodityRelatedQuotationAccountSubscribe(int routeKey, int timeout, ReqRelatedInfoOption option, org.soldier.platform.page.IndexedPageOption pageOption,TRequestOption requestOption) throws TException { 
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
        create_reqCommodityRelatedQuotationAccountSubscribeServiceCall(routeKey, timeout, platformArgs, option, pageOption), requestOption);
  }

  public long reqCommodityRelatedQuotationAccountSubscribe(int routeKey, int timeout, ReqRelatedInfoOption option, org.soldier.platform.page.IndexedPageOption pageOption, IMethodCallback<QuotationSourceService.reqCommodityRelatedQuotationAccountSubscribe_args, QuotationSourceService.reqCommodityRelatedQuotationAccountSubscribe_result> callback) throws TException{
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
            create_reqCommodityRelatedQuotationAccountSubscribeServiceCall(routeKey, timeout, platformArgs, option, pageOption), callback);
  }

  public long add_reqCommodityRelatedQuotationAccountSubscribeCall(AsyncCallRunner runner, int routeKey, int timeout, ReqRelatedInfoOption option, org.soldier.platform.page.IndexedPageOption pageOption, IMethodCallback<QuotationSourceService.reqCommodityRelatedQuotationAccountSubscribe_args, QuotationSourceService.reqCommodityRelatedQuotationAccountSubscribe_result> callback) throws TException{
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
            create_reqCommodityRelatedQuotationAccountSubscribeServiceCall(routeKey, timeout, platformArgs, option, pageOption), callback);
  }

  protected TServiceCall create_reqCommodityRelatedQuotationAccountSubscribeServiceCall(int routeKey, int timeout, org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, ReqRelatedInfoOption option, org.soldier.platform.page.IndexedPageOption pageOption){
    TServiceCall serviceCall = new TServiceCall();
    if (!getPeerAddr().isEmpty()) {
      serviceCall.setChooseServiceIp(getPeerAddr());
    }
    if (getPeerPort() != 0) {
      serviceCall.setChooseServicePort(getPeerPort());
    }
    serviceCall.setServiceKey(QuotationSourceServiceVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    QuotationSourceService.reqCommodityRelatedQuotationAccountSubscribe_args request = new QuotationSourceService.reqCommodityRelatedQuotationAccountSubscribe_args();
    request.setPlatformArgs(platformArgs);
    request.setOption(option);
    request.setPageOption(pageOption);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("reqCommodityRelatedQuotationAccountSubscribe");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(QuotationSourceService.reqCommodityRelatedQuotationAccountSubscribe_result.class);
    return serviceCall;
  }

  public void send_reqQuotationAccountRelatedCommoditySubscribe(int routeKey, int timeout, ReqRelatedInfoOption option, org.soldier.platform.page.IndexedPageOption pageOption) throws TException {
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
        create_reqQuotationAccountRelatedCommoditySubscribeServiceCall(routeKey, timeout, platformArgs, option, pageOption), new TRequestOption());
  }

  public void send_reqQuotationAccountRelatedCommoditySubscribe(int routeKey, int timeout, ReqRelatedInfoOption option, org.soldier.platform.page.IndexedPageOption pageOption,TRequestOption requestOption) throws TException { 
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
        create_reqQuotationAccountRelatedCommoditySubscribeServiceCall(routeKey, timeout, platformArgs, option, pageOption), requestOption);
  }

  public long reqQuotationAccountRelatedCommoditySubscribe(int routeKey, int timeout, ReqRelatedInfoOption option, org.soldier.platform.page.IndexedPageOption pageOption, IMethodCallback<QuotationSourceService.reqQuotationAccountRelatedCommoditySubscribe_args, QuotationSourceService.reqQuotationAccountRelatedCommoditySubscribe_result> callback) throws TException{
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
            create_reqQuotationAccountRelatedCommoditySubscribeServiceCall(routeKey, timeout, platformArgs, option, pageOption), callback);
  }

  public long add_reqQuotationAccountRelatedCommoditySubscribeCall(AsyncCallRunner runner, int routeKey, int timeout, ReqRelatedInfoOption option, org.soldier.platform.page.IndexedPageOption pageOption, IMethodCallback<QuotationSourceService.reqQuotationAccountRelatedCommoditySubscribe_args, QuotationSourceService.reqQuotationAccountRelatedCommoditySubscribe_result> callback) throws TException{
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
            create_reqQuotationAccountRelatedCommoditySubscribeServiceCall(routeKey, timeout, platformArgs, option, pageOption), callback);
  }

  protected TServiceCall create_reqQuotationAccountRelatedCommoditySubscribeServiceCall(int routeKey, int timeout, org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, ReqRelatedInfoOption option, org.soldier.platform.page.IndexedPageOption pageOption){
    TServiceCall serviceCall = new TServiceCall();
    if (!getPeerAddr().isEmpty()) {
      serviceCall.setChooseServiceIp(getPeerAddr());
    }
    if (getPeerPort() != 0) {
      serviceCall.setChooseServicePort(getPeerPort());
    }
    serviceCall.setServiceKey(QuotationSourceServiceVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    QuotationSourceService.reqQuotationAccountRelatedCommoditySubscribe_args request = new QuotationSourceService.reqQuotationAccountRelatedCommoditySubscribe_args();
    request.setPlatformArgs(platformArgs);
    request.setOption(option);
    request.setPageOption(pageOption);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("reqQuotationAccountRelatedCommoditySubscribe");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(QuotationSourceService.reqQuotationAccountRelatedCommoditySubscribe_result.class);
    return serviceCall;
  }

}
