package xueqiao.quotation.admin.web.api.thriftapi.client;

import xueqiao.quotation.admin.web.api.thriftapi.QuotationAdminWebApi;
import xueqiao.quotation.admin.web.api.thriftapi.QuotationAdminWebApiVariable;
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

public class QuotationAdminWebApiAsyncStub extends BaseStub { 
  public QuotationAdminWebApiAsyncStub() {
    super(QuotationAdminWebApiVariable.serviceKey);
  }
  public void send_reqCommodityActiveConfig(int routeKey, int timeout, ReqCommodityActiveConfigOption option, org.soldier.platform.page.IndexedPageOption pageOption) throws TException {
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
        create_reqCommodityActiveConfigServiceCall(routeKey, timeout, platformArgs, option, pageOption), new TRequestOption());
  }

  public void send_reqCommodityActiveConfig(int routeKey, int timeout, ReqCommodityActiveConfigOption option, org.soldier.platform.page.IndexedPageOption pageOption,TRequestOption requestOption) throws TException { 
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
        create_reqCommodityActiveConfigServiceCall(routeKey, timeout, platformArgs, option, pageOption), requestOption);
  }

  public long reqCommodityActiveConfig(int routeKey, int timeout, ReqCommodityActiveConfigOption option, org.soldier.platform.page.IndexedPageOption pageOption, IMethodCallback<QuotationAdminWebApi.reqCommodityActiveConfig_args, QuotationAdminWebApi.reqCommodityActiveConfig_result> callback) throws TException{
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
            create_reqCommodityActiveConfigServiceCall(routeKey, timeout, platformArgs, option, pageOption), callback);
  }

  public long add_reqCommodityActiveConfigCall(AsyncCallRunner runner, int routeKey, int timeout, ReqCommodityActiveConfigOption option, org.soldier.platform.page.IndexedPageOption pageOption, IMethodCallback<QuotationAdminWebApi.reqCommodityActiveConfig_args, QuotationAdminWebApi.reqCommodityActiveConfig_result> callback) throws TException{
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
            create_reqCommodityActiveConfigServiceCall(routeKey, timeout, platformArgs, option, pageOption), callback);
  }

  protected TServiceCall create_reqCommodityActiveConfigServiceCall(int routeKey, int timeout, org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, ReqCommodityActiveConfigOption option, org.soldier.platform.page.IndexedPageOption pageOption){
    TServiceCall serviceCall = new TServiceCall();
    if (!getPeerAddr().isEmpty()) {
      serviceCall.setChooseServiceIp(getPeerAddr());
    }
    if (getPeerPort() != 0) {
      serviceCall.setChooseServicePort(getPeerPort());
    }
    serviceCall.setServiceKey(QuotationAdminWebApiVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    QuotationAdminWebApi.reqCommodityActiveConfig_args request = new QuotationAdminWebApi.reqCommodityActiveConfig_args();
    request.setPlatformArgs(platformArgs);
    request.setOption(option);
    request.setPageOption(pageOption);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("reqCommodityActiveConfig");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(QuotationAdminWebApi.reqCommodityActiveConfig_result.class);
    return serviceCall;
  }

  public void send_updateCommodityActiveConfig(int routeKey, int timeout, CommodityActiveConfig activeConfig) throws TException {
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
        create_updateCommodityActiveConfigServiceCall(routeKey, timeout, platformArgs, activeConfig), new TRequestOption());
  }

  public void send_updateCommodityActiveConfig(int routeKey, int timeout, CommodityActiveConfig activeConfig,TRequestOption requestOption) throws TException { 
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
        create_updateCommodityActiveConfigServiceCall(routeKey, timeout, platformArgs, activeConfig), requestOption);
  }

  public long updateCommodityActiveConfig(int routeKey, int timeout, CommodityActiveConfig activeConfig, IMethodCallback<QuotationAdminWebApi.updateCommodityActiveConfig_args, QuotationAdminWebApi.updateCommodityActiveConfig_result> callback) throws TException{
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
            create_updateCommodityActiveConfigServiceCall(routeKey, timeout, platformArgs, activeConfig), callback);
  }

  public long add_updateCommodityActiveConfigCall(AsyncCallRunner runner, int routeKey, int timeout, CommodityActiveConfig activeConfig, IMethodCallback<QuotationAdminWebApi.updateCommodityActiveConfig_args, QuotationAdminWebApi.updateCommodityActiveConfig_result> callback) throws TException{
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
            create_updateCommodityActiveConfigServiceCall(routeKey, timeout, platformArgs, activeConfig), callback);
  }

  protected TServiceCall create_updateCommodityActiveConfigServiceCall(int routeKey, int timeout, org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, CommodityActiveConfig activeConfig){
    TServiceCall serviceCall = new TServiceCall();
    if (!getPeerAddr().isEmpty()) {
      serviceCall.setChooseServiceIp(getPeerAddr());
    }
    if (getPeerPort() != 0) {
      serviceCall.setChooseServicePort(getPeerPort());
    }
    serviceCall.setServiceKey(QuotationAdminWebApiVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    QuotationAdminWebApi.updateCommodityActiveConfig_args request = new QuotationAdminWebApi.updateCommodityActiveConfig_args();
    request.setPlatformArgs(platformArgs);
    request.setActiveConfig(activeConfig);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("updateCommodityActiveConfig");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(QuotationAdminWebApi.updateCommodityActiveConfig_result.class);
    return serviceCall;
  }

  public void send_addCommodityActiveConfig(int routeKey, int timeout, CommodityActiveConfig activeConfig) throws TException {
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
        create_addCommodityActiveConfigServiceCall(routeKey, timeout, platformArgs, activeConfig), new TRequestOption());
  }

  public void send_addCommodityActiveConfig(int routeKey, int timeout, CommodityActiveConfig activeConfig,TRequestOption requestOption) throws TException { 
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
        create_addCommodityActiveConfigServiceCall(routeKey, timeout, platformArgs, activeConfig), requestOption);
  }

  public long addCommodityActiveConfig(int routeKey, int timeout, CommodityActiveConfig activeConfig, IMethodCallback<QuotationAdminWebApi.addCommodityActiveConfig_args, QuotationAdminWebApi.addCommodityActiveConfig_result> callback) throws TException{
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
            create_addCommodityActiveConfigServiceCall(routeKey, timeout, platformArgs, activeConfig), callback);
  }

  public long add_addCommodityActiveConfigCall(AsyncCallRunner runner, int routeKey, int timeout, CommodityActiveConfig activeConfig, IMethodCallback<QuotationAdminWebApi.addCommodityActiveConfig_args, QuotationAdminWebApi.addCommodityActiveConfig_result> callback) throws TException{
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
            create_addCommodityActiveConfigServiceCall(routeKey, timeout, platformArgs, activeConfig), callback);
  }

  protected TServiceCall create_addCommodityActiveConfigServiceCall(int routeKey, int timeout, org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, CommodityActiveConfig activeConfig){
    TServiceCall serviceCall = new TServiceCall();
    if (!getPeerAddr().isEmpty()) {
      serviceCall.setChooseServiceIp(getPeerAddr());
    }
    if (getPeerPort() != 0) {
      serviceCall.setChooseServicePort(getPeerPort());
    }
    serviceCall.setServiceKey(QuotationAdminWebApiVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    QuotationAdminWebApi.addCommodityActiveConfig_args request = new QuotationAdminWebApi.addCommodityActiveConfig_args();
    request.setPlatformArgs(platformArgs);
    request.setActiveConfig(activeConfig);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("addCommodityActiveConfig");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(QuotationAdminWebApi.addCommodityActiveConfig_result.class);
    return serviceCall;
  }

  public void send_deleteCommodityActiveConfig(int routeKey, int timeout, int sledCommodityId, xueqiao.quotation.account.thriftapi.ContractActiveType activeType, String fixedCode) throws TException {
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
        create_deleteCommodityActiveConfigServiceCall(routeKey, timeout, platformArgs, sledCommodityId, activeType, fixedCode), new TRequestOption());
  }

  public void send_deleteCommodityActiveConfig(int routeKey, int timeout, int sledCommodityId, xueqiao.quotation.account.thriftapi.ContractActiveType activeType, String fixedCode,TRequestOption requestOption) throws TException { 
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
        create_deleteCommodityActiveConfigServiceCall(routeKey, timeout, platformArgs, sledCommodityId, activeType, fixedCode), requestOption);
  }

  public long deleteCommodityActiveConfig(int routeKey, int timeout, int sledCommodityId, xueqiao.quotation.account.thriftapi.ContractActiveType activeType, String fixedCode, IMethodCallback<QuotationAdminWebApi.deleteCommodityActiveConfig_args, QuotationAdminWebApi.deleteCommodityActiveConfig_result> callback) throws TException{
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
            create_deleteCommodityActiveConfigServiceCall(routeKey, timeout, platformArgs, sledCommodityId, activeType, fixedCode), callback);
  }

  public long add_deleteCommodityActiveConfigCall(AsyncCallRunner runner, int routeKey, int timeout, int sledCommodityId, xueqiao.quotation.account.thriftapi.ContractActiveType activeType, String fixedCode, IMethodCallback<QuotationAdminWebApi.deleteCommodityActiveConfig_args, QuotationAdminWebApi.deleteCommodityActiveConfig_result> callback) throws TException{
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
            create_deleteCommodityActiveConfigServiceCall(routeKey, timeout, platformArgs, sledCommodityId, activeType, fixedCode), callback);
  }

  protected TServiceCall create_deleteCommodityActiveConfigServiceCall(int routeKey, int timeout, org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, int sledCommodityId, xueqiao.quotation.account.thriftapi.ContractActiveType activeType, String fixedCode){
    TServiceCall serviceCall = new TServiceCall();
    if (!getPeerAddr().isEmpty()) {
      serviceCall.setChooseServiceIp(getPeerAddr());
    }
    if (getPeerPort() != 0) {
      serviceCall.setChooseServicePort(getPeerPort());
    }
    serviceCall.setServiceKey(QuotationAdminWebApiVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    QuotationAdminWebApi.deleteCommodityActiveConfig_args request = new QuotationAdminWebApi.deleteCommodityActiveConfig_args();
    request.setPlatformArgs(platformArgs);
    request.setSledCommodityId(sledCommodityId);
    request.setActiveType(activeType);
    request.setFixedCode(fixedCode);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("deleteCommodityActiveConfig");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(QuotationAdminWebApi.deleteCommodityActiveConfig_result.class);
    return serviceCall;
  }

  public void send_reqCommodityRegister(int routeKey, int timeout, ReqCommodityRegisterOption option, org.soldier.platform.page.IndexedPageOption pageOption) throws TException {
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
        create_reqCommodityRegisterServiceCall(routeKey, timeout, platformArgs, option, pageOption), new TRequestOption());
  }

  public void send_reqCommodityRegister(int routeKey, int timeout, ReqCommodityRegisterOption option, org.soldier.platform.page.IndexedPageOption pageOption,TRequestOption requestOption) throws TException { 
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
        create_reqCommodityRegisterServiceCall(routeKey, timeout, platformArgs, option, pageOption), requestOption);
  }

  public long reqCommodityRegister(int routeKey, int timeout, ReqCommodityRegisterOption option, org.soldier.platform.page.IndexedPageOption pageOption, IMethodCallback<QuotationAdminWebApi.reqCommodityRegister_args, QuotationAdminWebApi.reqCommodityRegister_result> callback) throws TException{
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
            create_reqCommodityRegisterServiceCall(routeKey, timeout, platformArgs, option, pageOption), callback);
  }

  public long add_reqCommodityRegisterCall(AsyncCallRunner runner, int routeKey, int timeout, ReqCommodityRegisterOption option, org.soldier.platform.page.IndexedPageOption pageOption, IMethodCallback<QuotationAdminWebApi.reqCommodityRegister_args, QuotationAdminWebApi.reqCommodityRegister_result> callback) throws TException{
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
            create_reqCommodityRegisterServiceCall(routeKey, timeout, platformArgs, option, pageOption), callback);
  }

  protected TServiceCall create_reqCommodityRegisterServiceCall(int routeKey, int timeout, org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, ReqCommodityRegisterOption option, org.soldier.platform.page.IndexedPageOption pageOption){
    TServiceCall serviceCall = new TServiceCall();
    if (!getPeerAddr().isEmpty()) {
      serviceCall.setChooseServiceIp(getPeerAddr());
    }
    if (getPeerPort() != 0) {
      serviceCall.setChooseServicePort(getPeerPort());
    }
    serviceCall.setServiceKey(QuotationAdminWebApiVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    QuotationAdminWebApi.reqCommodityRegister_args request = new QuotationAdminWebApi.reqCommodityRegister_args();
    request.setPlatformArgs(platformArgs);
    request.setOption(option);
    request.setPageOption(pageOption);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("reqCommodityRegister");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(QuotationAdminWebApi.reqCommodityRegister_result.class);
    return serviceCall;
  }

  public void send_updateCommodityRegister(int routeKey, int timeout, CommodityRegister commodityRegister) throws TException {
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
        create_updateCommodityRegisterServiceCall(routeKey, timeout, platformArgs, commodityRegister), new TRequestOption());
  }

  public void send_updateCommodityRegister(int routeKey, int timeout, CommodityRegister commodityRegister,TRequestOption requestOption) throws TException { 
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
        create_updateCommodityRegisterServiceCall(routeKey, timeout, platformArgs, commodityRegister), requestOption);
  }

  public long updateCommodityRegister(int routeKey, int timeout, CommodityRegister commodityRegister, IMethodCallback<QuotationAdminWebApi.updateCommodityRegister_args, QuotationAdminWebApi.updateCommodityRegister_result> callback) throws TException{
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
            create_updateCommodityRegisterServiceCall(routeKey, timeout, platformArgs, commodityRegister), callback);
  }

  public long add_updateCommodityRegisterCall(AsyncCallRunner runner, int routeKey, int timeout, CommodityRegister commodityRegister, IMethodCallback<QuotationAdminWebApi.updateCommodityRegister_args, QuotationAdminWebApi.updateCommodityRegister_result> callback) throws TException{
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
            create_updateCommodityRegisterServiceCall(routeKey, timeout, platformArgs, commodityRegister), callback);
  }

  protected TServiceCall create_updateCommodityRegisterServiceCall(int routeKey, int timeout, org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, CommodityRegister commodityRegister){
    TServiceCall serviceCall = new TServiceCall();
    if (!getPeerAddr().isEmpty()) {
      serviceCall.setChooseServiceIp(getPeerAddr());
    }
    if (getPeerPort() != 0) {
      serviceCall.setChooseServicePort(getPeerPort());
    }
    serviceCall.setServiceKey(QuotationAdminWebApiVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    QuotationAdminWebApi.updateCommodityRegister_args request = new QuotationAdminWebApi.updateCommodityRegister_args();
    request.setPlatformArgs(platformArgs);
    request.setCommodityRegister(commodityRegister);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("updateCommodityRegister");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(QuotationAdminWebApi.updateCommodityRegister_result.class);
    return serviceCall;
  }

  public void send_addCommodityRegister(int routeKey, int timeout, CommodityRegister commodityRegister) throws TException {
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
        create_addCommodityRegisterServiceCall(routeKey, timeout, platformArgs, commodityRegister), new TRequestOption());
  }

  public void send_addCommodityRegister(int routeKey, int timeout, CommodityRegister commodityRegister,TRequestOption requestOption) throws TException { 
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
        create_addCommodityRegisterServiceCall(routeKey, timeout, platformArgs, commodityRegister), requestOption);
  }

  public long addCommodityRegister(int routeKey, int timeout, CommodityRegister commodityRegister, IMethodCallback<QuotationAdminWebApi.addCommodityRegister_args, QuotationAdminWebApi.addCommodityRegister_result> callback) throws TException{
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
            create_addCommodityRegisterServiceCall(routeKey, timeout, platformArgs, commodityRegister), callback);
  }

  public long add_addCommodityRegisterCall(AsyncCallRunner runner, int routeKey, int timeout, CommodityRegister commodityRegister, IMethodCallback<QuotationAdminWebApi.addCommodityRegister_args, QuotationAdminWebApi.addCommodityRegister_result> callback) throws TException{
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
            create_addCommodityRegisterServiceCall(routeKey, timeout, platformArgs, commodityRegister), callback);
  }

  protected TServiceCall create_addCommodityRegisterServiceCall(int routeKey, int timeout, org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, CommodityRegister commodityRegister){
    TServiceCall serviceCall = new TServiceCall();
    if (!getPeerAddr().isEmpty()) {
      serviceCall.setChooseServiceIp(getPeerAddr());
    }
    if (getPeerPort() != 0) {
      serviceCall.setChooseServicePort(getPeerPort());
    }
    serviceCall.setServiceKey(QuotationAdminWebApiVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    QuotationAdminWebApi.addCommodityRegister_args request = new QuotationAdminWebApi.addCommodityRegister_args();
    request.setPlatformArgs(platformArgs);
    request.setCommodityRegister(commodityRegister);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("addCommodityRegister");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(QuotationAdminWebApi.addCommodityRegister_result.class);
    return serviceCall;
  }

  public void send_deleteCommodityRegister(int routeKey, int timeout, int sledCommodityId, com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv platformEnv, xueqiao.quotation.account.thriftapi.ContractActiveType activeType, String fixedCode) throws TException {
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
        create_deleteCommodityRegisterServiceCall(routeKey, timeout, platformArgs, sledCommodityId, platformEnv, activeType, fixedCode), new TRequestOption());
  }

  public void send_deleteCommodityRegister(int routeKey, int timeout, int sledCommodityId, com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv platformEnv, xueqiao.quotation.account.thriftapi.ContractActiveType activeType, String fixedCode,TRequestOption requestOption) throws TException { 
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
        create_deleteCommodityRegisterServiceCall(routeKey, timeout, platformArgs, sledCommodityId, platformEnv, activeType, fixedCode), requestOption);
  }

  public long deleteCommodityRegister(int routeKey, int timeout, int sledCommodityId, com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv platformEnv, xueqiao.quotation.account.thriftapi.ContractActiveType activeType, String fixedCode, IMethodCallback<QuotationAdminWebApi.deleteCommodityRegister_args, QuotationAdminWebApi.deleteCommodityRegister_result> callback) throws TException{
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
            create_deleteCommodityRegisterServiceCall(routeKey, timeout, platformArgs, sledCommodityId, platformEnv, activeType, fixedCode), callback);
  }

  public long add_deleteCommodityRegisterCall(AsyncCallRunner runner, int routeKey, int timeout, int sledCommodityId, com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv platformEnv, xueqiao.quotation.account.thriftapi.ContractActiveType activeType, String fixedCode, IMethodCallback<QuotationAdminWebApi.deleteCommodityRegister_args, QuotationAdminWebApi.deleteCommodityRegister_result> callback) throws TException{
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
            create_deleteCommodityRegisterServiceCall(routeKey, timeout, platformArgs, sledCommodityId, platformEnv, activeType, fixedCode), callback);
  }

  protected TServiceCall create_deleteCommodityRegisterServiceCall(int routeKey, int timeout, org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, int sledCommodityId, com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv platformEnv, xueqiao.quotation.account.thriftapi.ContractActiveType activeType, String fixedCode){
    TServiceCall serviceCall = new TServiceCall();
    if (!getPeerAddr().isEmpty()) {
      serviceCall.setChooseServiceIp(getPeerAddr());
    }
    if (getPeerPort() != 0) {
      serviceCall.setChooseServicePort(getPeerPort());
    }
    serviceCall.setServiceKey(QuotationAdminWebApiVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    QuotationAdminWebApi.deleteCommodityRegister_args request = new QuotationAdminWebApi.deleteCommodityRegister_args();
    request.setPlatformArgs(platformArgs);
    request.setSledCommodityId(sledCommodityId);
    request.setPlatformEnv(platformEnv);
    request.setActiveType(activeType);
    request.setFixedCode(fixedCode);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("deleteCommodityRegister");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(QuotationAdminWebApi.deleteCommodityRegister_result.class);
    return serviceCall;
  }

  public void send_setCommodityRegisterOrderIndex(int routeKey, int timeout, int sledCommodityId, com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv platformEnv, int orderIndex, xueqiao.quotation.account.thriftapi.ContractActiveType activeType, String fixedCode) throws TException {
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
        create_setCommodityRegisterOrderIndexServiceCall(routeKey, timeout, platformArgs, sledCommodityId, platformEnv, orderIndex, activeType, fixedCode), new TRequestOption());
  }

  public void send_setCommodityRegisterOrderIndex(int routeKey, int timeout, int sledCommodityId, com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv platformEnv, int orderIndex, xueqiao.quotation.account.thriftapi.ContractActiveType activeType, String fixedCode,TRequestOption requestOption) throws TException { 
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
        create_setCommodityRegisterOrderIndexServiceCall(routeKey, timeout, platformArgs, sledCommodityId, platformEnv, orderIndex, activeType, fixedCode), requestOption);
  }

  public long setCommodityRegisterOrderIndex(int routeKey, int timeout, int sledCommodityId, com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv platformEnv, int orderIndex, xueqiao.quotation.account.thriftapi.ContractActiveType activeType, String fixedCode, IMethodCallback<QuotationAdminWebApi.setCommodityRegisterOrderIndex_args, QuotationAdminWebApi.setCommodityRegisterOrderIndex_result> callback) throws TException{
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
            create_setCommodityRegisterOrderIndexServiceCall(routeKey, timeout, platformArgs, sledCommodityId, platformEnv, orderIndex, activeType, fixedCode), callback);
  }

  public long add_setCommodityRegisterOrderIndexCall(AsyncCallRunner runner, int routeKey, int timeout, int sledCommodityId, com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv platformEnv, int orderIndex, xueqiao.quotation.account.thriftapi.ContractActiveType activeType, String fixedCode, IMethodCallback<QuotationAdminWebApi.setCommodityRegisterOrderIndex_args, QuotationAdminWebApi.setCommodityRegisterOrderIndex_result> callback) throws TException{
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
            create_setCommodityRegisterOrderIndexServiceCall(routeKey, timeout, platformArgs, sledCommodityId, platformEnv, orderIndex, activeType, fixedCode), callback);
  }

  protected TServiceCall create_setCommodityRegisterOrderIndexServiceCall(int routeKey, int timeout, org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, int sledCommodityId, com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv platformEnv, int orderIndex, xueqiao.quotation.account.thriftapi.ContractActiveType activeType, String fixedCode){
    TServiceCall serviceCall = new TServiceCall();
    if (!getPeerAddr().isEmpty()) {
      serviceCall.setChooseServiceIp(getPeerAddr());
    }
    if (getPeerPort() != 0) {
      serviceCall.setChooseServicePort(getPeerPort());
    }
    serviceCall.setServiceKey(QuotationAdminWebApiVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    QuotationAdminWebApi.setCommodityRegisterOrderIndex_args request = new QuotationAdminWebApi.setCommodityRegisterOrderIndex_args();
    request.setPlatformArgs(platformArgs);
    request.setSledCommodityId(sledCommodityId);
    request.setPlatformEnv(platformEnv);
    request.setOrderIndex(orderIndex);
    request.setActiveType(activeType);
    request.setFixedCode(fixedCode);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("setCommodityRegisterOrderIndex");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(QuotationAdminWebApi.setCommodityRegisterOrderIndex_result.class);
    return serviceCall;
  }

  public void send_reqQuotationAccountInfo(int routeKey, int timeout, ReqQuotationAccountInfoOption option, org.soldier.platform.page.IndexedPageOption pageOption) throws TException {
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
        create_reqQuotationAccountInfoServiceCall(routeKey, timeout, platformArgs, option, pageOption), new TRequestOption());
  }

  public void send_reqQuotationAccountInfo(int routeKey, int timeout, ReqQuotationAccountInfoOption option, org.soldier.platform.page.IndexedPageOption pageOption,TRequestOption requestOption) throws TException { 
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
        create_reqQuotationAccountInfoServiceCall(routeKey, timeout, platformArgs, option, pageOption), requestOption);
  }

  public long reqQuotationAccountInfo(int routeKey, int timeout, ReqQuotationAccountInfoOption option, org.soldier.platform.page.IndexedPageOption pageOption, IMethodCallback<QuotationAdminWebApi.reqQuotationAccountInfo_args, QuotationAdminWebApi.reqQuotationAccountInfo_result> callback) throws TException{
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
            create_reqQuotationAccountInfoServiceCall(routeKey, timeout, platformArgs, option, pageOption), callback);
  }

  public long add_reqQuotationAccountInfoCall(AsyncCallRunner runner, int routeKey, int timeout, ReqQuotationAccountInfoOption option, org.soldier.platform.page.IndexedPageOption pageOption, IMethodCallback<QuotationAdminWebApi.reqQuotationAccountInfo_args, QuotationAdminWebApi.reqQuotationAccountInfo_result> callback) throws TException{
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
            create_reqQuotationAccountInfoServiceCall(routeKey, timeout, platformArgs, option, pageOption), callback);
  }

  protected TServiceCall create_reqQuotationAccountInfoServiceCall(int routeKey, int timeout, org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, ReqQuotationAccountInfoOption option, org.soldier.platform.page.IndexedPageOption pageOption){
    TServiceCall serviceCall = new TServiceCall();
    if (!getPeerAddr().isEmpty()) {
      serviceCall.setChooseServiceIp(getPeerAddr());
    }
    if (getPeerPort() != 0) {
      serviceCall.setChooseServicePort(getPeerPort());
    }
    serviceCall.setServiceKey(QuotationAdminWebApiVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    QuotationAdminWebApi.reqQuotationAccountInfo_args request = new QuotationAdminWebApi.reqQuotationAccountInfo_args();
    request.setPlatformArgs(platformArgs);
    request.setOption(option);
    request.setPageOption(pageOption);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("reqQuotationAccountInfo");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(QuotationAdminWebApi.reqQuotationAccountInfo_result.class);
    return serviceCall;
  }

  public void send_updateQuotationAccountInfo(int routeKey, int timeout, QuotationAccountInfo quotationAccountInfo) throws TException {
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
        create_updateQuotationAccountInfoServiceCall(routeKey, timeout, platformArgs, quotationAccountInfo), new TRequestOption());
  }

  public void send_updateQuotationAccountInfo(int routeKey, int timeout, QuotationAccountInfo quotationAccountInfo,TRequestOption requestOption) throws TException { 
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
        create_updateQuotationAccountInfoServiceCall(routeKey, timeout, platformArgs, quotationAccountInfo), requestOption);
  }

  public long updateQuotationAccountInfo(int routeKey, int timeout, QuotationAccountInfo quotationAccountInfo, IMethodCallback<QuotationAdminWebApi.updateQuotationAccountInfo_args, QuotationAdminWebApi.updateQuotationAccountInfo_result> callback) throws TException{
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
            create_updateQuotationAccountInfoServiceCall(routeKey, timeout, platformArgs, quotationAccountInfo), callback);
  }

  public long add_updateQuotationAccountInfoCall(AsyncCallRunner runner, int routeKey, int timeout, QuotationAccountInfo quotationAccountInfo, IMethodCallback<QuotationAdminWebApi.updateQuotationAccountInfo_args, QuotationAdminWebApi.updateQuotationAccountInfo_result> callback) throws TException{
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
            create_updateQuotationAccountInfoServiceCall(routeKey, timeout, platformArgs, quotationAccountInfo), callback);
  }

  protected TServiceCall create_updateQuotationAccountInfoServiceCall(int routeKey, int timeout, org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, QuotationAccountInfo quotationAccountInfo){
    TServiceCall serviceCall = new TServiceCall();
    if (!getPeerAddr().isEmpty()) {
      serviceCall.setChooseServiceIp(getPeerAddr());
    }
    if (getPeerPort() != 0) {
      serviceCall.setChooseServicePort(getPeerPort());
    }
    serviceCall.setServiceKey(QuotationAdminWebApiVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    QuotationAdminWebApi.updateQuotationAccountInfo_args request = new QuotationAdminWebApi.updateQuotationAccountInfo_args();
    request.setPlatformArgs(platformArgs);
    request.setQuotationAccountInfo(quotationAccountInfo);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("updateQuotationAccountInfo");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(QuotationAdminWebApi.updateQuotationAccountInfo_result.class);
    return serviceCall;
  }

  public void send_addQuotationAccountInfo(int routeKey, int timeout, QuotationAccountInfo quotationAccountInfo) throws TException {
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
        create_addQuotationAccountInfoServiceCall(routeKey, timeout, platformArgs, quotationAccountInfo), new TRequestOption());
  }

  public void send_addQuotationAccountInfo(int routeKey, int timeout, QuotationAccountInfo quotationAccountInfo,TRequestOption requestOption) throws TException { 
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
        create_addQuotationAccountInfoServiceCall(routeKey, timeout, platformArgs, quotationAccountInfo), requestOption);
  }

  public long addQuotationAccountInfo(int routeKey, int timeout, QuotationAccountInfo quotationAccountInfo, IMethodCallback<QuotationAdminWebApi.addQuotationAccountInfo_args, QuotationAdminWebApi.addQuotationAccountInfo_result> callback) throws TException{
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
            create_addQuotationAccountInfoServiceCall(routeKey, timeout, platformArgs, quotationAccountInfo), callback);
  }

  public long add_addQuotationAccountInfoCall(AsyncCallRunner runner, int routeKey, int timeout, QuotationAccountInfo quotationAccountInfo, IMethodCallback<QuotationAdminWebApi.addQuotationAccountInfo_args, QuotationAdminWebApi.addQuotationAccountInfo_result> callback) throws TException{
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
            create_addQuotationAccountInfoServiceCall(routeKey, timeout, platformArgs, quotationAccountInfo), callback);
  }

  protected TServiceCall create_addQuotationAccountInfoServiceCall(int routeKey, int timeout, org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, QuotationAccountInfo quotationAccountInfo){
    TServiceCall serviceCall = new TServiceCall();
    if (!getPeerAddr().isEmpty()) {
      serviceCall.setChooseServiceIp(getPeerAddr());
    }
    if (getPeerPort() != 0) {
      serviceCall.setChooseServicePort(getPeerPort());
    }
    serviceCall.setServiceKey(QuotationAdminWebApiVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    QuotationAdminWebApi.addQuotationAccountInfo_args request = new QuotationAdminWebApi.addQuotationAccountInfo_args();
    request.setPlatformArgs(platformArgs);
    request.setQuotationAccountInfo(quotationAccountInfo);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("addQuotationAccountInfo");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(QuotationAdminWebApi.addQuotationAccountInfo_result.class);
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

  public long deleteQuotationAccount(int routeKey, int timeout, long accountId, IMethodCallback<QuotationAdminWebApi.deleteQuotationAccount_args, QuotationAdminWebApi.deleteQuotationAccount_result> callback) throws TException{
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

  public long add_deleteQuotationAccountCall(AsyncCallRunner runner, int routeKey, int timeout, long accountId, IMethodCallback<QuotationAdminWebApi.deleteQuotationAccount_args, QuotationAdminWebApi.deleteQuotationAccount_result> callback) throws TException{
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
    serviceCall.setServiceKey(QuotationAdminWebApiVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    QuotationAdminWebApi.deleteQuotationAccount_args request = new QuotationAdminWebApi.deleteQuotationAccount_args();
    request.setPlatformArgs(platformArgs);
    request.setAccountId(accountId);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("deleteQuotationAccount");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(QuotationAdminWebApi.deleteQuotationAccount_result.class);
    return serviceCall;
  }

  public void send_reqExchangeRegisterAbility(int routeKey, int timeout, ReqAccountRegisterAbilityOption option) throws TException {
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
        create_reqExchangeRegisterAbilityServiceCall(routeKey, timeout, platformArgs, option), new TRequestOption());
  }

  public void send_reqExchangeRegisterAbility(int routeKey, int timeout, ReqAccountRegisterAbilityOption option,TRequestOption requestOption) throws TException { 
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
        create_reqExchangeRegisterAbilityServiceCall(routeKey, timeout, platformArgs, option), requestOption);
  }

  public long reqExchangeRegisterAbility(int routeKey, int timeout, ReqAccountRegisterAbilityOption option, IMethodCallback<QuotationAdminWebApi.reqExchangeRegisterAbility_args, QuotationAdminWebApi.reqExchangeRegisterAbility_result> callback) throws TException{
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
            create_reqExchangeRegisterAbilityServiceCall(routeKey, timeout, platformArgs, option), callback);
  }

  public long add_reqExchangeRegisterAbilityCall(AsyncCallRunner runner, int routeKey, int timeout, ReqAccountRegisterAbilityOption option, IMethodCallback<QuotationAdminWebApi.reqExchangeRegisterAbility_args, QuotationAdminWebApi.reqExchangeRegisterAbility_result> callback) throws TException{
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
            create_reqExchangeRegisterAbilityServiceCall(routeKey, timeout, platformArgs, option), callback);
  }

  protected TServiceCall create_reqExchangeRegisterAbilityServiceCall(int routeKey, int timeout, org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, ReqAccountRegisterAbilityOption option){
    TServiceCall serviceCall = new TServiceCall();
    if (!getPeerAddr().isEmpty()) {
      serviceCall.setChooseServiceIp(getPeerAddr());
    }
    if (getPeerPort() != 0) {
      serviceCall.setChooseServicePort(getPeerPort());
    }
    serviceCall.setServiceKey(QuotationAdminWebApiVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    QuotationAdminWebApi.reqExchangeRegisterAbility_args request = new QuotationAdminWebApi.reqExchangeRegisterAbility_args();
    request.setPlatformArgs(platformArgs);
    request.setOption(option);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("reqExchangeRegisterAbility");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(QuotationAdminWebApi.reqExchangeRegisterAbility_result.class);
    return serviceCall;
  }

  public void send_batAddAccountRegisterAbility(int routeKey, int timeout, List<AccountRegisterAbility> abilities) throws TException {
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
        create_batAddAccountRegisterAbilityServiceCall(routeKey, timeout, platformArgs, abilities), new TRequestOption());
  }

  public void send_batAddAccountRegisterAbility(int routeKey, int timeout, List<AccountRegisterAbility> abilities,TRequestOption requestOption) throws TException { 
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
        create_batAddAccountRegisterAbilityServiceCall(routeKey, timeout, platformArgs, abilities), requestOption);
  }

  public long batAddAccountRegisterAbility(int routeKey, int timeout, List<AccountRegisterAbility> abilities, IMethodCallback<QuotationAdminWebApi.batAddAccountRegisterAbility_args, QuotationAdminWebApi.batAddAccountRegisterAbility_result> callback) throws TException{
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
            create_batAddAccountRegisterAbilityServiceCall(routeKey, timeout, platformArgs, abilities), callback);
  }

  public long add_batAddAccountRegisterAbilityCall(AsyncCallRunner runner, int routeKey, int timeout, List<AccountRegisterAbility> abilities, IMethodCallback<QuotationAdminWebApi.batAddAccountRegisterAbility_args, QuotationAdminWebApi.batAddAccountRegisterAbility_result> callback) throws TException{
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
            create_batAddAccountRegisterAbilityServiceCall(routeKey, timeout, platformArgs, abilities), callback);
  }

  protected TServiceCall create_batAddAccountRegisterAbilityServiceCall(int routeKey, int timeout, org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, List<AccountRegisterAbility> abilities){
    TServiceCall serviceCall = new TServiceCall();
    if (!getPeerAddr().isEmpty()) {
      serviceCall.setChooseServiceIp(getPeerAddr());
    }
    if (getPeerPort() != 0) {
      serviceCall.setChooseServicePort(getPeerPort());
    }
    serviceCall.setServiceKey(QuotationAdminWebApiVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    QuotationAdminWebApi.batAddAccountRegisterAbility_args request = new QuotationAdminWebApi.batAddAccountRegisterAbility_args();
    request.setPlatformArgs(platformArgs);
    request.setAbilities(abilities);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("batAddAccountRegisterAbility");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(QuotationAdminWebApi.batAddAccountRegisterAbility_result.class);
    return serviceCall;
  }

  public void send_deleteAccountRegisterAbility(int routeKey, int timeout, long abilityId) throws TException {
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
        create_deleteAccountRegisterAbilityServiceCall(routeKey, timeout, platformArgs, abilityId), new TRequestOption());
  }

  public void send_deleteAccountRegisterAbility(int routeKey, int timeout, long abilityId,TRequestOption requestOption) throws TException { 
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
        create_deleteAccountRegisterAbilityServiceCall(routeKey, timeout, platformArgs, abilityId), requestOption);
  }

  public long deleteAccountRegisterAbility(int routeKey, int timeout, long abilityId, IMethodCallback<QuotationAdminWebApi.deleteAccountRegisterAbility_args, QuotationAdminWebApi.deleteAccountRegisterAbility_result> callback) throws TException{
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
            create_deleteAccountRegisterAbilityServiceCall(routeKey, timeout, platformArgs, abilityId), callback);
  }

  public long add_deleteAccountRegisterAbilityCall(AsyncCallRunner runner, int routeKey, int timeout, long abilityId, IMethodCallback<QuotationAdminWebApi.deleteAccountRegisterAbility_args, QuotationAdminWebApi.deleteAccountRegisterAbility_result> callback) throws TException{
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
            create_deleteAccountRegisterAbilityServiceCall(routeKey, timeout, platformArgs, abilityId), callback);
  }

  protected TServiceCall create_deleteAccountRegisterAbilityServiceCall(int routeKey, int timeout, org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, long abilityId){
    TServiceCall serviceCall = new TServiceCall();
    if (!getPeerAddr().isEmpty()) {
      serviceCall.setChooseServiceIp(getPeerAddr());
    }
    if (getPeerPort() != 0) {
      serviceCall.setChooseServicePort(getPeerPort());
    }
    serviceCall.setServiceKey(QuotationAdminWebApiVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    QuotationAdminWebApi.deleteAccountRegisterAbility_args request = new QuotationAdminWebApi.deleteAccountRegisterAbility_args();
    request.setPlatformArgs(platformArgs);
    request.setAbilityId(abilityId);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("deleteAccountRegisterAbility");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(QuotationAdminWebApi.deleteAccountRegisterAbility_result.class);
    return serviceCall;
  }

  public void send_deleteAccountRegisterAbilityByExchange(int routeKey, int timeout, long accountId, int exchangeId) throws TException {
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
        create_deleteAccountRegisterAbilityByExchangeServiceCall(routeKey, timeout, platformArgs, accountId, exchangeId), new TRequestOption());
  }

  public void send_deleteAccountRegisterAbilityByExchange(int routeKey, int timeout, long accountId, int exchangeId,TRequestOption requestOption) throws TException { 
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
        create_deleteAccountRegisterAbilityByExchangeServiceCall(routeKey, timeout, platformArgs, accountId, exchangeId), requestOption);
  }

  public long deleteAccountRegisterAbilityByExchange(int routeKey, int timeout, long accountId, int exchangeId, IMethodCallback<QuotationAdminWebApi.deleteAccountRegisterAbilityByExchange_args, QuotationAdminWebApi.deleteAccountRegisterAbilityByExchange_result> callback) throws TException{
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
            create_deleteAccountRegisterAbilityByExchangeServiceCall(routeKey, timeout, platformArgs, accountId, exchangeId), callback);
  }

  public long add_deleteAccountRegisterAbilityByExchangeCall(AsyncCallRunner runner, int routeKey, int timeout, long accountId, int exchangeId, IMethodCallback<QuotationAdminWebApi.deleteAccountRegisterAbilityByExchange_args, QuotationAdminWebApi.deleteAccountRegisterAbilityByExchange_result> callback) throws TException{
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
            create_deleteAccountRegisterAbilityByExchangeServiceCall(routeKey, timeout, platformArgs, accountId, exchangeId), callback);
  }

  protected TServiceCall create_deleteAccountRegisterAbilityByExchangeServiceCall(int routeKey, int timeout, org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, long accountId, int exchangeId){
    TServiceCall serviceCall = new TServiceCall();
    if (!getPeerAddr().isEmpty()) {
      serviceCall.setChooseServiceIp(getPeerAddr());
    }
    if (getPeerPort() != 0) {
      serviceCall.setChooseServicePort(getPeerPort());
    }
    serviceCall.setServiceKey(QuotationAdminWebApiVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    QuotationAdminWebApi.deleteAccountRegisterAbilityByExchange_args request = new QuotationAdminWebApi.deleteAccountRegisterAbilityByExchange_args();
    request.setPlatformArgs(platformArgs);
    request.setAccountId(accountId);
    request.setExchangeId(exchangeId);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("deleteAccountRegisterAbilityByExchange");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(QuotationAdminWebApi.deleteAccountRegisterAbilityByExchange_result.class);
    return serviceCall;
  }

  public void send_reqSubscribedContract(int routeKey, int timeout, ReqSubscribedContractOption option, org.soldier.platform.page.IndexedPageOption pageOption) throws TException {
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
        create_reqSubscribedContractServiceCall(routeKey, timeout, platformArgs, option, pageOption), new TRequestOption());
  }

  public void send_reqSubscribedContract(int routeKey, int timeout, ReqSubscribedContractOption option, org.soldier.platform.page.IndexedPageOption pageOption,TRequestOption requestOption) throws TException { 
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
        create_reqSubscribedContractServiceCall(routeKey, timeout, platformArgs, option, pageOption), requestOption);
  }

  public long reqSubscribedContract(int routeKey, int timeout, ReqSubscribedContractOption option, org.soldier.platform.page.IndexedPageOption pageOption, IMethodCallback<QuotationAdminWebApi.reqSubscribedContract_args, QuotationAdminWebApi.reqSubscribedContract_result> callback) throws TException{
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
            create_reqSubscribedContractServiceCall(routeKey, timeout, platformArgs, option, pageOption), callback);
  }

  public long add_reqSubscribedContractCall(AsyncCallRunner runner, int routeKey, int timeout, ReqSubscribedContractOption option, org.soldier.platform.page.IndexedPageOption pageOption, IMethodCallback<QuotationAdminWebApi.reqSubscribedContract_args, QuotationAdminWebApi.reqSubscribedContract_result> callback) throws TException{
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
            create_reqSubscribedContractServiceCall(routeKey, timeout, platformArgs, option, pageOption), callback);
  }

  protected TServiceCall create_reqSubscribedContractServiceCall(int routeKey, int timeout, org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, ReqSubscribedContractOption option, org.soldier.platform.page.IndexedPageOption pageOption){
    TServiceCall serviceCall = new TServiceCall();
    if (!getPeerAddr().isEmpty()) {
      serviceCall.setChooseServiceIp(getPeerAddr());
    }
    if (getPeerPort() != 0) {
      serviceCall.setChooseServicePort(getPeerPort());
    }
    serviceCall.setServiceKey(QuotationAdminWebApiVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    QuotationAdminWebApi.reqSubscribedContract_args request = new QuotationAdminWebApi.reqSubscribedContract_args();
    request.setPlatformArgs(platformArgs);
    request.setOption(option);
    request.setPageOption(pageOption);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("reqSubscribedContract");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(QuotationAdminWebApi.reqSubscribedContract_result.class);
    return serviceCall;
  }

  public void send_replanSubscribe(int routeKey, int timeout, com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv platformEnv) throws TException {
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
        create_replanSubscribeServiceCall(routeKey, timeout, platformArgs, platformEnv), new TRequestOption());
  }

  public void send_replanSubscribe(int routeKey, int timeout, com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv platformEnv,TRequestOption requestOption) throws TException { 
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
        create_replanSubscribeServiceCall(routeKey, timeout, platformArgs, platformEnv), requestOption);
  }

  public long replanSubscribe(int routeKey, int timeout, com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv platformEnv, IMethodCallback<QuotationAdminWebApi.replanSubscribe_args, QuotationAdminWebApi.replanSubscribe_result> callback) throws TException{
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
            create_replanSubscribeServiceCall(routeKey, timeout, platformArgs, platformEnv), callback);
  }

  public long add_replanSubscribeCall(AsyncCallRunner runner, int routeKey, int timeout, com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv platformEnv, IMethodCallback<QuotationAdminWebApi.replanSubscribe_args, QuotationAdminWebApi.replanSubscribe_result> callback) throws TException{
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
            create_replanSubscribeServiceCall(routeKey, timeout, platformArgs, platformEnv), callback);
  }

  protected TServiceCall create_replanSubscribeServiceCall(int routeKey, int timeout, org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv platformEnv){
    TServiceCall serviceCall = new TServiceCall();
    if (!getPeerAddr().isEmpty()) {
      serviceCall.setChooseServiceIp(getPeerAddr());
    }
    if (getPeerPort() != 0) {
      serviceCall.setChooseServicePort(getPeerPort());
    }
    serviceCall.setServiceKey(QuotationAdminWebApiVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    QuotationAdminWebApi.replanSubscribe_args request = new QuotationAdminWebApi.replanSubscribe_args();
    request.setPlatformArgs(platformArgs);
    request.setPlatformEnv(platformEnv);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("replanSubscribe");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(QuotationAdminWebApi.replanSubscribe_result.class);
    return serviceCall;
  }

  public void send_reqPreviewSubscribedContract(int routeKey, int timeout, ReqRePlanSubscribedInfoPreviewOption option, org.soldier.platform.page.IndexedPageOption pageOption) throws TException {
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
        create_reqPreviewSubscribedContractServiceCall(routeKey, timeout, platformArgs, option, pageOption), new TRequestOption());
  }

  public void send_reqPreviewSubscribedContract(int routeKey, int timeout, ReqRePlanSubscribedInfoPreviewOption option, org.soldier.platform.page.IndexedPageOption pageOption,TRequestOption requestOption) throws TException { 
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
        create_reqPreviewSubscribedContractServiceCall(routeKey, timeout, platformArgs, option, pageOption), requestOption);
  }

  public long reqPreviewSubscribedContract(int routeKey, int timeout, ReqRePlanSubscribedInfoPreviewOption option, org.soldier.platform.page.IndexedPageOption pageOption, IMethodCallback<QuotationAdminWebApi.reqPreviewSubscribedContract_args, QuotationAdminWebApi.reqPreviewSubscribedContract_result> callback) throws TException{
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
            create_reqPreviewSubscribedContractServiceCall(routeKey, timeout, platformArgs, option, pageOption), callback);
  }

  public long add_reqPreviewSubscribedContractCall(AsyncCallRunner runner, int routeKey, int timeout, ReqRePlanSubscribedInfoPreviewOption option, org.soldier.platform.page.IndexedPageOption pageOption, IMethodCallback<QuotationAdminWebApi.reqPreviewSubscribedContract_args, QuotationAdminWebApi.reqPreviewSubscribedContract_result> callback) throws TException{
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
            create_reqPreviewSubscribedContractServiceCall(routeKey, timeout, platformArgs, option, pageOption), callback);
  }

  protected TServiceCall create_reqPreviewSubscribedContractServiceCall(int routeKey, int timeout, org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, ReqRePlanSubscribedInfoPreviewOption option, org.soldier.platform.page.IndexedPageOption pageOption){
    TServiceCall serviceCall = new TServiceCall();
    if (!getPeerAddr().isEmpty()) {
      serviceCall.setChooseServiceIp(getPeerAddr());
    }
    if (getPeerPort() != 0) {
      serviceCall.setChooseServicePort(getPeerPort());
    }
    serviceCall.setServiceKey(QuotationAdminWebApiVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    QuotationAdminWebApi.reqPreviewSubscribedContract_args request = new QuotationAdminWebApi.reqPreviewSubscribedContract_args();
    request.setPlatformArgs(platformArgs);
    request.setOption(option);
    request.setPageOption(pageOption);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("reqPreviewSubscribedContract");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(QuotationAdminWebApi.reqPreviewSubscribedContract_result.class);
    return serviceCall;
  }

  public void send_submitSubscribeInfo(int routeKey, int timeout, com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv platformEnv) throws TException {
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
        create_submitSubscribeInfoServiceCall(routeKey, timeout, platformArgs, platformEnv), new TRequestOption());
  }

  public void send_submitSubscribeInfo(int routeKey, int timeout, com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv platformEnv,TRequestOption requestOption) throws TException { 
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
        create_submitSubscribeInfoServiceCall(routeKey, timeout, platformArgs, platformEnv), requestOption);
  }

  public long submitSubscribeInfo(int routeKey, int timeout, com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv platformEnv, IMethodCallback<QuotationAdminWebApi.submitSubscribeInfo_args, QuotationAdminWebApi.submitSubscribeInfo_result> callback) throws TException{
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
            create_submitSubscribeInfoServiceCall(routeKey, timeout, platformArgs, platformEnv), callback);
  }

  public long add_submitSubscribeInfoCall(AsyncCallRunner runner, int routeKey, int timeout, com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv platformEnv, IMethodCallback<QuotationAdminWebApi.submitSubscribeInfo_args, QuotationAdminWebApi.submitSubscribeInfo_result> callback) throws TException{
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
            create_submitSubscribeInfoServiceCall(routeKey, timeout, platformArgs, platformEnv), callback);
  }

  protected TServiceCall create_submitSubscribeInfoServiceCall(int routeKey, int timeout, org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv platformEnv){
    TServiceCall serviceCall = new TServiceCall();
    if (!getPeerAddr().isEmpty()) {
      serviceCall.setChooseServiceIp(getPeerAddr());
    }
    if (getPeerPort() != 0) {
      serviceCall.setChooseServicePort(getPeerPort());
    }
    serviceCall.setServiceKey(QuotationAdminWebApiVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    QuotationAdminWebApi.submitSubscribeInfo_args request = new QuotationAdminWebApi.submitSubscribeInfo_args();
    request.setPlatformArgs(platformArgs);
    request.setPlatformEnv(platformEnv);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("submitSubscribeInfo");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(QuotationAdminWebApi.submitSubscribeInfo_result.class);
    return serviceCall;
  }

  public void send_reqPlanningSubscribedInfo(int routeKey, int timeout, ReqPlanningSubscribedInfoOption option) throws TException {
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
        create_reqPlanningSubscribedInfoServiceCall(routeKey, timeout, platformArgs, option), new TRequestOption());
  }

  public void send_reqPlanningSubscribedInfo(int routeKey, int timeout, ReqPlanningSubscribedInfoOption option,TRequestOption requestOption) throws TException { 
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
        create_reqPlanningSubscribedInfoServiceCall(routeKey, timeout, platformArgs, option), requestOption);
  }

  public long reqPlanningSubscribedInfo(int routeKey, int timeout, ReqPlanningSubscribedInfoOption option, IMethodCallback<QuotationAdminWebApi.reqPlanningSubscribedInfo_args, QuotationAdminWebApi.reqPlanningSubscribedInfo_result> callback) throws TException{
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
            create_reqPlanningSubscribedInfoServiceCall(routeKey, timeout, platformArgs, option), callback);
  }

  public long add_reqPlanningSubscribedInfoCall(AsyncCallRunner runner, int routeKey, int timeout, ReqPlanningSubscribedInfoOption option, IMethodCallback<QuotationAdminWebApi.reqPlanningSubscribedInfo_args, QuotationAdminWebApi.reqPlanningSubscribedInfo_result> callback) throws TException{
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
            create_reqPlanningSubscribedInfoServiceCall(routeKey, timeout, platformArgs, option), callback);
  }

  protected TServiceCall create_reqPlanningSubscribedInfoServiceCall(int routeKey, int timeout, org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, ReqPlanningSubscribedInfoOption option){
    TServiceCall serviceCall = new TServiceCall();
    if (!getPeerAddr().isEmpty()) {
      serviceCall.setChooseServiceIp(getPeerAddr());
    }
    if (getPeerPort() != 0) {
      serviceCall.setChooseServicePort(getPeerPort());
    }
    serviceCall.setServiceKey(QuotationAdminWebApiVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    QuotationAdminWebApi.reqPlanningSubscribedInfo_args request = new QuotationAdminWebApi.reqPlanningSubscribedInfo_args();
    request.setPlatformArgs(platformArgs);
    request.setOption(option);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("reqPlanningSubscribedInfo");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(QuotationAdminWebApi.reqPlanningSubscribedInfo_result.class);
    return serviceCall;
  }

  public void send_reqCommodityTree(int routeKey, int timeout, com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv platformEnv) throws TException {
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
        create_reqCommodityTreeServiceCall(routeKey, timeout, platformArgs, platformEnv), new TRequestOption());
  }

  public void send_reqCommodityTree(int routeKey, int timeout, com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv platformEnv,TRequestOption requestOption) throws TException { 
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
        create_reqCommodityTreeServiceCall(routeKey, timeout, platformArgs, platformEnv), requestOption);
  }

  public long reqCommodityTree(int routeKey, int timeout, com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv platformEnv, IMethodCallback<QuotationAdminWebApi.reqCommodityTree_args, QuotationAdminWebApi.reqCommodityTree_result> callback) throws TException{
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
            create_reqCommodityTreeServiceCall(routeKey, timeout, platformArgs, platformEnv), callback);
  }

  public long add_reqCommodityTreeCall(AsyncCallRunner runner, int routeKey, int timeout, com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv platformEnv, IMethodCallback<QuotationAdminWebApi.reqCommodityTree_args, QuotationAdminWebApi.reqCommodityTree_result> callback) throws TException{
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
            create_reqCommodityTreeServiceCall(routeKey, timeout, platformArgs, platformEnv), callback);
  }

  protected TServiceCall create_reqCommodityTreeServiceCall(int routeKey, int timeout, org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv platformEnv){
    TServiceCall serviceCall = new TServiceCall();
    if (!getPeerAddr().isEmpty()) {
      serviceCall.setChooseServiceIp(getPeerAddr());
    }
    if (getPeerPort() != 0) {
      serviceCall.setChooseServicePort(getPeerPort());
    }
    serviceCall.setServiceKey(QuotationAdminWebApiVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    QuotationAdminWebApi.reqCommodityTree_args request = new QuotationAdminWebApi.reqCommodityTree_args();
    request.setPlatformArgs(platformArgs);
    request.setPlatformEnv(platformEnv);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("reqCommodityTree");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(QuotationAdminWebApi.reqCommodityTree_result.class);
    return serviceCall;
  }

  public void send_reqCommodityTypeTree(int routeKey, int timeout, com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv platformEnv) throws TException {
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
        create_reqCommodityTypeTreeServiceCall(routeKey, timeout, platformArgs, platformEnv), new TRequestOption());
  }

  public void send_reqCommodityTypeTree(int routeKey, int timeout, com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv platformEnv,TRequestOption requestOption) throws TException { 
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
        create_reqCommodityTypeTreeServiceCall(routeKey, timeout, platformArgs, platformEnv), requestOption);
  }

  public long reqCommodityTypeTree(int routeKey, int timeout, com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv platformEnv, IMethodCallback<QuotationAdminWebApi.reqCommodityTypeTree_args, QuotationAdminWebApi.reqCommodityTypeTree_result> callback) throws TException{
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
            create_reqCommodityTypeTreeServiceCall(routeKey, timeout, platformArgs, platformEnv), callback);
  }

  public long add_reqCommodityTypeTreeCall(AsyncCallRunner runner, int routeKey, int timeout, com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv platformEnv, IMethodCallback<QuotationAdminWebApi.reqCommodityTypeTree_args, QuotationAdminWebApi.reqCommodityTypeTree_result> callback) throws TException{
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
            create_reqCommodityTypeTreeServiceCall(routeKey, timeout, platformArgs, platformEnv), callback);
  }

  protected TServiceCall create_reqCommodityTypeTreeServiceCall(int routeKey, int timeout, org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv platformEnv){
    TServiceCall serviceCall = new TServiceCall();
    if (!getPeerAddr().isEmpty()) {
      serviceCall.setChooseServiceIp(getPeerAddr());
    }
    if (getPeerPort() != 0) {
      serviceCall.setChooseServicePort(getPeerPort());
    }
    serviceCall.setServiceKey(QuotationAdminWebApiVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    QuotationAdminWebApi.reqCommodityTypeTree_args request = new QuotationAdminWebApi.reqCommodityTypeTree_args();
    request.setPlatformArgs(platformArgs);
    request.setPlatformEnv(platformEnv);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("reqCommodityTypeTree");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(QuotationAdminWebApi.reqCommodityTypeTree_result.class);
    return serviceCall;
  }

  public void send_reqContractTreeCommodityNodes(int routeKey, int timeout, int sledExchangeId, com.longsheng.xueqiao.contract.standard.thriftapi.SledCommodityType commodityType, com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv platformEnv) throws TException {
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
        create_reqContractTreeCommodityNodesServiceCall(routeKey, timeout, platformArgs, sledExchangeId, commodityType, platformEnv), new TRequestOption());
  }

  public void send_reqContractTreeCommodityNodes(int routeKey, int timeout, int sledExchangeId, com.longsheng.xueqiao.contract.standard.thriftapi.SledCommodityType commodityType, com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv platformEnv,TRequestOption requestOption) throws TException { 
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
        create_reqContractTreeCommodityNodesServiceCall(routeKey, timeout, platformArgs, sledExchangeId, commodityType, platformEnv), requestOption);
  }

  public long reqContractTreeCommodityNodes(int routeKey, int timeout, int sledExchangeId, com.longsheng.xueqiao.contract.standard.thriftapi.SledCommodityType commodityType, com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv platformEnv, IMethodCallback<QuotationAdminWebApi.reqContractTreeCommodityNodes_args, QuotationAdminWebApi.reqContractTreeCommodityNodes_result> callback) throws TException{
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
            create_reqContractTreeCommodityNodesServiceCall(routeKey, timeout, platformArgs, sledExchangeId, commodityType, platformEnv), callback);
  }

  public long add_reqContractTreeCommodityNodesCall(AsyncCallRunner runner, int routeKey, int timeout, int sledExchangeId, com.longsheng.xueqiao.contract.standard.thriftapi.SledCommodityType commodityType, com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv platformEnv, IMethodCallback<QuotationAdminWebApi.reqContractTreeCommodityNodes_args, QuotationAdminWebApi.reqContractTreeCommodityNodes_result> callback) throws TException{
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
            create_reqContractTreeCommodityNodesServiceCall(routeKey, timeout, platformArgs, sledExchangeId, commodityType, platformEnv), callback);
  }

  protected TServiceCall create_reqContractTreeCommodityNodesServiceCall(int routeKey, int timeout, org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, int sledExchangeId, com.longsheng.xueqiao.contract.standard.thriftapi.SledCommodityType commodityType, com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv platformEnv){
    TServiceCall serviceCall = new TServiceCall();
    if (!getPeerAddr().isEmpty()) {
      serviceCall.setChooseServiceIp(getPeerAddr());
    }
    if (getPeerPort() != 0) {
      serviceCall.setChooseServicePort(getPeerPort());
    }
    serviceCall.setServiceKey(QuotationAdminWebApiVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    QuotationAdminWebApi.reqContractTreeCommodityNodes_args request = new QuotationAdminWebApi.reqContractTreeCommodityNodes_args();
    request.setPlatformArgs(platformArgs);
    request.setSledExchangeId(sledExchangeId);
    request.setCommodityType(commodityType);
    request.setPlatformEnv(platformEnv);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("reqContractTreeCommodityNodes");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(QuotationAdminWebApi.reqContractTreeCommodityNodes_result.class);
    return serviceCall;
  }

  public void send_reqContractNodes(int routeKey, int timeout, int sledCommodityId, com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv platformEnv) throws TException {
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
        create_reqContractNodesServiceCall(routeKey, timeout, platformArgs, sledCommodityId, platformEnv), new TRequestOption());
  }

  public void send_reqContractNodes(int routeKey, int timeout, int sledCommodityId, com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv platformEnv,TRequestOption requestOption) throws TException { 
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
        create_reqContractNodesServiceCall(routeKey, timeout, platformArgs, sledCommodityId, platformEnv), requestOption);
  }

  public long reqContractNodes(int routeKey, int timeout, int sledCommodityId, com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv platformEnv, IMethodCallback<QuotationAdminWebApi.reqContractNodes_args, QuotationAdminWebApi.reqContractNodes_result> callback) throws TException{
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
            create_reqContractNodesServiceCall(routeKey, timeout, platformArgs, sledCommodityId, platformEnv), callback);
  }

  public long add_reqContractNodesCall(AsyncCallRunner runner, int routeKey, int timeout, int sledCommodityId, com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv platformEnv, IMethodCallback<QuotationAdminWebApi.reqContractNodes_args, QuotationAdminWebApi.reqContractNodes_result> callback) throws TException{
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
            create_reqContractNodesServiceCall(routeKey, timeout, platformArgs, sledCommodityId, platformEnv), callback);
  }

  protected TServiceCall create_reqContractNodesServiceCall(int routeKey, int timeout, org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, int sledCommodityId, com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv platformEnv){
    TServiceCall serviceCall = new TServiceCall();
    if (!getPeerAddr().isEmpty()) {
      serviceCall.setChooseServiceIp(getPeerAddr());
    }
    if (getPeerPort() != 0) {
      serviceCall.setChooseServicePort(getPeerPort());
    }
    serviceCall.setServiceKey(QuotationAdminWebApiVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    QuotationAdminWebApi.reqContractNodes_args request = new QuotationAdminWebApi.reqContractNodes_args();
    request.setPlatformArgs(platformArgs);
    request.setSledCommodityId(sledCommodityId);
    request.setPlatformEnv(platformEnv);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("reqContractNodes");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(QuotationAdminWebApi.reqContractNodes_result.class);
    return serviceCall;
  }

  public void send_reqBrokerTree(int routeKey, int timeout, com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv platformEnv) throws TException {
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
        create_reqBrokerTreeServiceCall(routeKey, timeout, platformArgs, platformEnv), new TRequestOption());
  }

  public void send_reqBrokerTree(int routeKey, int timeout, com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv platformEnv,TRequestOption requestOption) throws TException { 
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
        create_reqBrokerTreeServiceCall(routeKey, timeout, platformArgs, platformEnv), requestOption);
  }

  public long reqBrokerTree(int routeKey, int timeout, com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv platformEnv, IMethodCallback<QuotationAdminWebApi.reqBrokerTree_args, QuotationAdminWebApi.reqBrokerTree_result> callback) throws TException{
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
            create_reqBrokerTreeServiceCall(routeKey, timeout, platformArgs, platformEnv), callback);
  }

  public long add_reqBrokerTreeCall(AsyncCallRunner runner, int routeKey, int timeout, com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv platformEnv, IMethodCallback<QuotationAdminWebApi.reqBrokerTree_args, QuotationAdminWebApi.reqBrokerTree_result> callback) throws TException{
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
            create_reqBrokerTreeServiceCall(routeKey, timeout, platformArgs, platformEnv), callback);
  }

  protected TServiceCall create_reqBrokerTreeServiceCall(int routeKey, int timeout, org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv platformEnv){
    TServiceCall serviceCall = new TServiceCall();
    if (!getPeerAddr().isEmpty()) {
      serviceCall.setChooseServiceIp(getPeerAddr());
    }
    if (getPeerPort() != 0) {
      serviceCall.setChooseServicePort(getPeerPort());
    }
    serviceCall.setServiceKey(QuotationAdminWebApiVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    QuotationAdminWebApi.reqBrokerTree_args request = new QuotationAdminWebApi.reqBrokerTree_args();
    request.setPlatformArgs(platformArgs);
    request.setPlatformEnv(platformEnv);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("reqBrokerTree");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(QuotationAdminWebApi.reqBrokerTree_result.class);
    return serviceCall;
  }

}
