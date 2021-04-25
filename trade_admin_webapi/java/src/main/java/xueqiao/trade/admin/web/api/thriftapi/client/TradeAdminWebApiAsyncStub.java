package xueqiao.trade.admin.web.api.thriftapi.client;

import xueqiao.trade.admin.web.api.thriftapi.TradeAdminWebApi;
import xueqiao.trade.admin.web.api.thriftapi.TradeAdminWebApiVariable;
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

public class TradeAdminWebApiAsyncStub extends BaseStub { 
  public TradeAdminWebApiAsyncStub() {
    super(TradeAdminWebApiVariable.serviceKey);
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

  public long reqCommodityActiveConfig(int routeKey, int timeout, ReqCommodityActiveConfigOption option, org.soldier.platform.page.IndexedPageOption pageOption, IMethodCallback<TradeAdminWebApi.reqCommodityActiveConfig_args, TradeAdminWebApi.reqCommodityActiveConfig_result> callback) throws TException{
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

  public long add_reqCommodityActiveConfigCall(AsyncCallRunner runner, int routeKey, int timeout, ReqCommodityActiveConfigOption option, org.soldier.platform.page.IndexedPageOption pageOption, IMethodCallback<TradeAdminWebApi.reqCommodityActiveConfig_args, TradeAdminWebApi.reqCommodityActiveConfig_result> callback) throws TException{
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
    serviceCall.setServiceKey(TradeAdminWebApiVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    TradeAdminWebApi.reqCommodityActiveConfig_args request = new TradeAdminWebApi.reqCommodityActiveConfig_args();
    request.setPlatformArgs(platformArgs);
    request.setOption(option);
    request.setPageOption(pageOption);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("reqCommodityActiveConfig");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(TradeAdminWebApi.reqCommodityActiveConfig_result.class);
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

  public long updateCommodityActiveConfig(int routeKey, int timeout, CommodityActiveConfig activeConfig, IMethodCallback<TradeAdminWebApi.updateCommodityActiveConfig_args, TradeAdminWebApi.updateCommodityActiveConfig_result> callback) throws TException{
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

  public long add_updateCommodityActiveConfigCall(AsyncCallRunner runner, int routeKey, int timeout, CommodityActiveConfig activeConfig, IMethodCallback<TradeAdminWebApi.updateCommodityActiveConfig_args, TradeAdminWebApi.updateCommodityActiveConfig_result> callback) throws TException{
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
    serviceCall.setServiceKey(TradeAdminWebApiVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    TradeAdminWebApi.updateCommodityActiveConfig_args request = new TradeAdminWebApi.updateCommodityActiveConfig_args();
    request.setPlatformArgs(platformArgs);
    request.setActiveConfig(activeConfig);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("updateCommodityActiveConfig");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(TradeAdminWebApi.updateCommodityActiveConfig_result.class);
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

  public long addCommodityActiveConfig(int routeKey, int timeout, CommodityActiveConfig activeConfig, IMethodCallback<TradeAdminWebApi.addCommodityActiveConfig_args, TradeAdminWebApi.addCommodityActiveConfig_result> callback) throws TException{
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

  public long add_addCommodityActiveConfigCall(AsyncCallRunner runner, int routeKey, int timeout, CommodityActiveConfig activeConfig, IMethodCallback<TradeAdminWebApi.addCommodityActiveConfig_args, TradeAdminWebApi.addCommodityActiveConfig_result> callback) throws TException{
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
    serviceCall.setServiceKey(TradeAdminWebApiVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    TradeAdminWebApi.addCommodityActiveConfig_args request = new TradeAdminWebApi.addCommodityActiveConfig_args();
    request.setPlatformArgs(platformArgs);
    request.setActiveConfig(activeConfig);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("addCommodityActiveConfig");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(TradeAdminWebApi.addCommodityActiveConfig_result.class);
    return serviceCall;
  }

  public void send_deleteCommodityActiveConfig(int routeKey, int timeout, int sledCommodityId) throws TException {
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
        create_deleteCommodityActiveConfigServiceCall(routeKey, timeout, platformArgs, sledCommodityId), new TRequestOption());
  }

  public void send_deleteCommodityActiveConfig(int routeKey, int timeout, int sledCommodityId,TRequestOption requestOption) throws TException { 
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
        create_deleteCommodityActiveConfigServiceCall(routeKey, timeout, platformArgs, sledCommodityId), requestOption);
  }

  public long deleteCommodityActiveConfig(int routeKey, int timeout, int sledCommodityId, IMethodCallback<TradeAdminWebApi.deleteCommodityActiveConfig_args, TradeAdminWebApi.deleteCommodityActiveConfig_result> callback) throws TException{
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
            create_deleteCommodityActiveConfigServiceCall(routeKey, timeout, platformArgs, sledCommodityId), callback);
  }

  public long add_deleteCommodityActiveConfigCall(AsyncCallRunner runner, int routeKey, int timeout, int sledCommodityId, IMethodCallback<TradeAdminWebApi.deleteCommodityActiveConfig_args, TradeAdminWebApi.deleteCommodityActiveConfig_result> callback) throws TException{
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
            create_deleteCommodityActiveConfigServiceCall(routeKey, timeout, platformArgs, sledCommodityId), callback);
  }

  protected TServiceCall create_deleteCommodityActiveConfigServiceCall(int routeKey, int timeout, org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, int sledCommodityId){
    TServiceCall serviceCall = new TServiceCall();
    if (!getPeerAddr().isEmpty()) {
      serviceCall.setChooseServiceIp(getPeerAddr());
    }
    if (getPeerPort() != 0) {
      serviceCall.setChooseServicePort(getPeerPort());
    }
    serviceCall.setServiceKey(TradeAdminWebApiVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    TradeAdminWebApi.deleteCommodityActiveConfig_args request = new TradeAdminWebApi.deleteCommodityActiveConfig_args();
    request.setPlatformArgs(platformArgs);
    request.setSledCommodityId(sledCommodityId);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("deleteCommodityActiveConfig");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(TradeAdminWebApi.deleteCommodityActiveConfig_result.class);
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

  public long reqCommodityRegister(int routeKey, int timeout, ReqCommodityRegisterOption option, org.soldier.platform.page.IndexedPageOption pageOption, IMethodCallback<TradeAdminWebApi.reqCommodityRegister_args, TradeAdminWebApi.reqCommodityRegister_result> callback) throws TException{
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

  public long add_reqCommodityRegisterCall(AsyncCallRunner runner, int routeKey, int timeout, ReqCommodityRegisterOption option, org.soldier.platform.page.IndexedPageOption pageOption, IMethodCallback<TradeAdminWebApi.reqCommodityRegister_args, TradeAdminWebApi.reqCommodityRegister_result> callback) throws TException{
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
    serviceCall.setServiceKey(TradeAdminWebApiVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    TradeAdminWebApi.reqCommodityRegister_args request = new TradeAdminWebApi.reqCommodityRegister_args();
    request.setPlatformArgs(platformArgs);
    request.setOption(option);
    request.setPageOption(pageOption);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("reqCommodityRegister");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(TradeAdminWebApi.reqCommodityRegister_result.class);
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

  public long updateCommodityRegister(int routeKey, int timeout, CommodityRegister commodityRegister, IMethodCallback<TradeAdminWebApi.updateCommodityRegister_args, TradeAdminWebApi.updateCommodityRegister_result> callback) throws TException{
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

  public long add_updateCommodityRegisterCall(AsyncCallRunner runner, int routeKey, int timeout, CommodityRegister commodityRegister, IMethodCallback<TradeAdminWebApi.updateCommodityRegister_args, TradeAdminWebApi.updateCommodityRegister_result> callback) throws TException{
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
    serviceCall.setServiceKey(TradeAdminWebApiVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    TradeAdminWebApi.updateCommodityRegister_args request = new TradeAdminWebApi.updateCommodityRegister_args();
    request.setPlatformArgs(platformArgs);
    request.setCommodityRegister(commodityRegister);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("updateCommodityRegister");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(TradeAdminWebApi.updateCommodityRegister_result.class);
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

  public long addCommodityRegister(int routeKey, int timeout, CommodityRegister commodityRegister, IMethodCallback<TradeAdminWebApi.addCommodityRegister_args, TradeAdminWebApi.addCommodityRegister_result> callback) throws TException{
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

  public long add_addCommodityRegisterCall(AsyncCallRunner runner, int routeKey, int timeout, CommodityRegister commodityRegister, IMethodCallback<TradeAdminWebApi.addCommodityRegister_args, TradeAdminWebApi.addCommodityRegister_result> callback) throws TException{
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
    serviceCall.setServiceKey(TradeAdminWebApiVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    TradeAdminWebApi.addCommodityRegister_args request = new TradeAdminWebApi.addCommodityRegister_args();
    request.setPlatformArgs(platformArgs);
    request.setCommodityRegister(commodityRegister);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("addCommodityRegister");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(TradeAdminWebApi.addCommodityRegister_result.class);
    return serviceCall;
  }

  public void send_deleteCommodityRegister(int routeKey, int timeout, int sledCommodityId, com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv platformEnv) throws TException {
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
        create_deleteCommodityRegisterServiceCall(routeKey, timeout, platformArgs, sledCommodityId, platformEnv), new TRequestOption());
  }

  public void send_deleteCommodityRegister(int routeKey, int timeout, int sledCommodityId, com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv platformEnv,TRequestOption requestOption) throws TException { 
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
        create_deleteCommodityRegisterServiceCall(routeKey, timeout, platformArgs, sledCommodityId, platformEnv), requestOption);
  }

  public long deleteCommodityRegister(int routeKey, int timeout, int sledCommodityId, com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv platformEnv, IMethodCallback<TradeAdminWebApi.deleteCommodityRegister_args, TradeAdminWebApi.deleteCommodityRegister_result> callback) throws TException{
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
            create_deleteCommodityRegisterServiceCall(routeKey, timeout, platformArgs, sledCommodityId, platformEnv), callback);
  }

  public long add_deleteCommodityRegisterCall(AsyncCallRunner runner, int routeKey, int timeout, int sledCommodityId, com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv platformEnv, IMethodCallback<TradeAdminWebApi.deleteCommodityRegister_args, TradeAdminWebApi.deleteCommodityRegister_result> callback) throws TException{
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
            create_deleteCommodityRegisterServiceCall(routeKey, timeout, platformArgs, sledCommodityId, platformEnv), callback);
  }

  protected TServiceCall create_deleteCommodityRegisterServiceCall(int routeKey, int timeout, org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, int sledCommodityId, com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv platformEnv){
    TServiceCall serviceCall = new TServiceCall();
    if (!getPeerAddr().isEmpty()) {
      serviceCall.setChooseServiceIp(getPeerAddr());
    }
    if (getPeerPort() != 0) {
      serviceCall.setChooseServicePort(getPeerPort());
    }
    serviceCall.setServiceKey(TradeAdminWebApiVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    TradeAdminWebApi.deleteCommodityRegister_args request = new TradeAdminWebApi.deleteCommodityRegister_args();
    request.setPlatformArgs(platformArgs);
    request.setSledCommodityId(sledCommodityId);
    request.setPlatformEnv(platformEnv);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("deleteCommodityRegister");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(TradeAdminWebApi.deleteCommodityRegister_result.class);
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

  public long reqQuotationAccountInfo(int routeKey, int timeout, ReqQuotationAccountInfoOption option, org.soldier.platform.page.IndexedPageOption pageOption, IMethodCallback<TradeAdminWebApi.reqQuotationAccountInfo_args, TradeAdminWebApi.reqQuotationAccountInfo_result> callback) throws TException{
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

  public long add_reqQuotationAccountInfoCall(AsyncCallRunner runner, int routeKey, int timeout, ReqQuotationAccountInfoOption option, org.soldier.platform.page.IndexedPageOption pageOption, IMethodCallback<TradeAdminWebApi.reqQuotationAccountInfo_args, TradeAdminWebApi.reqQuotationAccountInfo_result> callback) throws TException{
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
    serviceCall.setServiceKey(TradeAdminWebApiVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    TradeAdminWebApi.reqQuotationAccountInfo_args request = new TradeAdminWebApi.reqQuotationAccountInfo_args();
    request.setPlatformArgs(platformArgs);
    request.setOption(option);
    request.setPageOption(pageOption);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("reqQuotationAccountInfo");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(TradeAdminWebApi.reqQuotationAccountInfo_result.class);
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

  public long updateQuotationAccountInfo(int routeKey, int timeout, QuotationAccountInfo quotationAccountInfo, IMethodCallback<TradeAdminWebApi.updateQuotationAccountInfo_args, TradeAdminWebApi.updateQuotationAccountInfo_result> callback) throws TException{
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

  public long add_updateQuotationAccountInfoCall(AsyncCallRunner runner, int routeKey, int timeout, QuotationAccountInfo quotationAccountInfo, IMethodCallback<TradeAdminWebApi.updateQuotationAccountInfo_args, TradeAdminWebApi.updateQuotationAccountInfo_result> callback) throws TException{
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
    serviceCall.setServiceKey(TradeAdminWebApiVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    TradeAdminWebApi.updateQuotationAccountInfo_args request = new TradeAdminWebApi.updateQuotationAccountInfo_args();
    request.setPlatformArgs(platformArgs);
    request.setQuotationAccountInfo(quotationAccountInfo);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("updateQuotationAccountInfo");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(TradeAdminWebApi.updateQuotationAccountInfo_result.class);
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

  public long addQuotationAccountInfo(int routeKey, int timeout, QuotationAccountInfo quotationAccountInfo, IMethodCallback<TradeAdminWebApi.addQuotationAccountInfo_args, TradeAdminWebApi.addQuotationAccountInfo_result> callback) throws TException{
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

  public long add_addQuotationAccountInfoCall(AsyncCallRunner runner, int routeKey, int timeout, QuotationAccountInfo quotationAccountInfo, IMethodCallback<TradeAdminWebApi.addQuotationAccountInfo_args, TradeAdminWebApi.addQuotationAccountInfo_result> callback) throws TException{
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
    serviceCall.setServiceKey(TradeAdminWebApiVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    TradeAdminWebApi.addQuotationAccountInfo_args request = new TradeAdminWebApi.addQuotationAccountInfo_args();
    request.setPlatformArgs(platformArgs);
    request.setQuotationAccountInfo(quotationAccountInfo);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("addQuotationAccountInfo");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(TradeAdminWebApi.addQuotationAccountInfo_result.class);
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

  public long deleteQuotationAccount(int routeKey, int timeout, long accountId, IMethodCallback<TradeAdminWebApi.deleteQuotationAccount_args, TradeAdminWebApi.deleteQuotationAccount_result> callback) throws TException{
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

  public long add_deleteQuotationAccountCall(AsyncCallRunner runner, int routeKey, int timeout, long accountId, IMethodCallback<TradeAdminWebApi.deleteQuotationAccount_args, TradeAdminWebApi.deleteQuotationAccount_result> callback) throws TException{
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
    serviceCall.setServiceKey(TradeAdminWebApiVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    TradeAdminWebApi.deleteQuotationAccount_args request = new TradeAdminWebApi.deleteQuotationAccount_args();
    request.setPlatformArgs(platformArgs);
    request.setAccountId(accountId);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("deleteQuotationAccount");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(TradeAdminWebApi.deleteQuotationAccount_result.class);
    return serviceCall;
  }

  public void send_reqAccountRegisterAbility(int routeKey, int timeout, ReqAccountRegisterAbilityOption option, org.soldier.platform.page.IndexedPageOption pageOption) throws TException {
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
        create_reqAccountRegisterAbilityServiceCall(routeKey, timeout, platformArgs, option, pageOption), new TRequestOption());
  }

  public void send_reqAccountRegisterAbility(int routeKey, int timeout, ReqAccountRegisterAbilityOption option, org.soldier.platform.page.IndexedPageOption pageOption,TRequestOption requestOption) throws TException { 
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
        create_reqAccountRegisterAbilityServiceCall(routeKey, timeout, platformArgs, option, pageOption), requestOption);
  }

  public long reqAccountRegisterAbility(int routeKey, int timeout, ReqAccountRegisterAbilityOption option, org.soldier.platform.page.IndexedPageOption pageOption, IMethodCallback<TradeAdminWebApi.reqAccountRegisterAbility_args, TradeAdminWebApi.reqAccountRegisterAbility_result> callback) throws TException{
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
            create_reqAccountRegisterAbilityServiceCall(routeKey, timeout, platformArgs, option, pageOption), callback);
  }

  public long add_reqAccountRegisterAbilityCall(AsyncCallRunner runner, int routeKey, int timeout, ReqAccountRegisterAbilityOption option, org.soldier.platform.page.IndexedPageOption pageOption, IMethodCallback<TradeAdminWebApi.reqAccountRegisterAbility_args, TradeAdminWebApi.reqAccountRegisterAbility_result> callback) throws TException{
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
            create_reqAccountRegisterAbilityServiceCall(routeKey, timeout, platformArgs, option, pageOption), callback);
  }

  protected TServiceCall create_reqAccountRegisterAbilityServiceCall(int routeKey, int timeout, org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, ReqAccountRegisterAbilityOption option, org.soldier.platform.page.IndexedPageOption pageOption){
    TServiceCall serviceCall = new TServiceCall();
    if (!getPeerAddr().isEmpty()) {
      serviceCall.setChooseServiceIp(getPeerAddr());
    }
    if (getPeerPort() != 0) {
      serviceCall.setChooseServicePort(getPeerPort());
    }
    serviceCall.setServiceKey(TradeAdminWebApiVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    TradeAdminWebApi.reqAccountRegisterAbility_args request = new TradeAdminWebApi.reqAccountRegisterAbility_args();
    request.setPlatformArgs(platformArgs);
    request.setOption(option);
    request.setPageOption(pageOption);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("reqAccountRegisterAbility");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(TradeAdminWebApi.reqAccountRegisterAbility_result.class);
    return serviceCall;
  }

  public void send_addAccountRegisterAbility(int routeKey, int timeout, AccountRegisterAbility ability) throws TException {
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
        create_addAccountRegisterAbilityServiceCall(routeKey, timeout, platformArgs, ability), new TRequestOption());
  }

  public void send_addAccountRegisterAbility(int routeKey, int timeout, AccountRegisterAbility ability,TRequestOption requestOption) throws TException { 
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
        create_addAccountRegisterAbilityServiceCall(routeKey, timeout, platformArgs, ability), requestOption);
  }

  public long addAccountRegisterAbility(int routeKey, int timeout, AccountRegisterAbility ability, IMethodCallback<TradeAdminWebApi.addAccountRegisterAbility_args, TradeAdminWebApi.addAccountRegisterAbility_result> callback) throws TException{
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
            create_addAccountRegisterAbilityServiceCall(routeKey, timeout, platformArgs, ability), callback);
  }

  public long add_addAccountRegisterAbilityCall(AsyncCallRunner runner, int routeKey, int timeout, AccountRegisterAbility ability, IMethodCallback<TradeAdminWebApi.addAccountRegisterAbility_args, TradeAdminWebApi.addAccountRegisterAbility_result> callback) throws TException{
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
            create_addAccountRegisterAbilityServiceCall(routeKey, timeout, platformArgs, ability), callback);
  }

  protected TServiceCall create_addAccountRegisterAbilityServiceCall(int routeKey, int timeout, org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, AccountRegisterAbility ability){
    TServiceCall serviceCall = new TServiceCall();
    if (!getPeerAddr().isEmpty()) {
      serviceCall.setChooseServiceIp(getPeerAddr());
    }
    if (getPeerPort() != 0) {
      serviceCall.setChooseServicePort(getPeerPort());
    }
    serviceCall.setServiceKey(TradeAdminWebApiVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    TradeAdminWebApi.addAccountRegisterAbility_args request = new TradeAdminWebApi.addAccountRegisterAbility_args();
    request.setPlatformArgs(platformArgs);
    request.setAbility(ability);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("addAccountRegisterAbility");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(TradeAdminWebApi.addAccountRegisterAbility_result.class);
    return serviceCall;
  }

  public void send_deleteAccountRegisterAbility(int routeKey, int timeout, long accountId, int sledCommodityId) throws TException {
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
        create_deleteAccountRegisterAbilityServiceCall(routeKey, timeout, platformArgs, accountId, sledCommodityId), new TRequestOption());
  }

  public void send_deleteAccountRegisterAbility(int routeKey, int timeout, long accountId, int sledCommodityId,TRequestOption requestOption) throws TException { 
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
        create_deleteAccountRegisterAbilityServiceCall(routeKey, timeout, platformArgs, accountId, sledCommodityId), requestOption);
  }

  public long deleteAccountRegisterAbility(int routeKey, int timeout, long accountId, int sledCommodityId, IMethodCallback<TradeAdminWebApi.deleteAccountRegisterAbility_args, TradeAdminWebApi.deleteAccountRegisterAbility_result> callback) throws TException{
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
            create_deleteAccountRegisterAbilityServiceCall(routeKey, timeout, platformArgs, accountId, sledCommodityId), callback);
  }

  public long add_deleteAccountRegisterAbilityCall(AsyncCallRunner runner, int routeKey, int timeout, long accountId, int sledCommodityId, IMethodCallback<TradeAdminWebApi.deleteAccountRegisterAbility_args, TradeAdminWebApi.deleteAccountRegisterAbility_result> callback) throws TException{
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
            create_deleteAccountRegisterAbilityServiceCall(routeKey, timeout, platformArgs, accountId, sledCommodityId), callback);
  }

  protected TServiceCall create_deleteAccountRegisterAbilityServiceCall(int routeKey, int timeout, org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, long accountId, int sledCommodityId){
    TServiceCall serviceCall = new TServiceCall();
    if (!getPeerAddr().isEmpty()) {
      serviceCall.setChooseServiceIp(getPeerAddr());
    }
    if (getPeerPort() != 0) {
      serviceCall.setChooseServicePort(getPeerPort());
    }
    serviceCall.setServiceKey(TradeAdminWebApiVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    TradeAdminWebApi.deleteAccountRegisterAbility_args request = new TradeAdminWebApi.deleteAccountRegisterAbility_args();
    request.setPlatformArgs(platformArgs);
    request.setAccountId(accountId);
    request.setSledCommodityId(sledCommodityId);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("deleteAccountRegisterAbility");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(TradeAdminWebApi.deleteAccountRegisterAbility_result.class);
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

  public long reqSubscribedContract(int routeKey, int timeout, ReqSubscribedContractOption option, org.soldier.platform.page.IndexedPageOption pageOption, IMethodCallback<TradeAdminWebApi.reqSubscribedContract_args, TradeAdminWebApi.reqSubscribedContract_result> callback) throws TException{
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

  public long add_reqSubscribedContractCall(AsyncCallRunner runner, int routeKey, int timeout, ReqSubscribedContractOption option, org.soldier.platform.page.IndexedPageOption pageOption, IMethodCallback<TradeAdminWebApi.reqSubscribedContract_args, TradeAdminWebApi.reqSubscribedContract_result> callback) throws TException{
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
    serviceCall.setServiceKey(TradeAdminWebApiVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    TradeAdminWebApi.reqSubscribedContract_args request = new TradeAdminWebApi.reqSubscribedContract_args();
    request.setPlatformArgs(platformArgs);
    request.setOption(option);
    request.setPageOption(pageOption);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("reqSubscribedContract");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(TradeAdminWebApi.reqSubscribedContract_result.class);
    return serviceCall;
  }

  public void send_reqContractTreeExchangeNodes(int routeKey, int timeout, com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv platformEnv) throws TException {
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
        create_reqContractTreeExchangeNodesServiceCall(routeKey, timeout, platformArgs, platformEnv), new TRequestOption());
  }

  public void send_reqContractTreeExchangeNodes(int routeKey, int timeout, com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv platformEnv,TRequestOption requestOption) throws TException { 
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
        create_reqContractTreeExchangeNodesServiceCall(routeKey, timeout, platformArgs, platformEnv), requestOption);
  }

  public long reqContractTreeExchangeNodes(int routeKey, int timeout, com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv platformEnv, IMethodCallback<TradeAdminWebApi.reqContractTreeExchangeNodes_args, TradeAdminWebApi.reqContractTreeExchangeNodes_result> callback) throws TException{
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
            create_reqContractTreeExchangeNodesServiceCall(routeKey, timeout, platformArgs, platformEnv), callback);
  }

  public long add_reqContractTreeExchangeNodesCall(AsyncCallRunner runner, int routeKey, int timeout, com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv platformEnv, IMethodCallback<TradeAdminWebApi.reqContractTreeExchangeNodes_args, TradeAdminWebApi.reqContractTreeExchangeNodes_result> callback) throws TException{
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
            create_reqContractTreeExchangeNodesServiceCall(routeKey, timeout, platformArgs, platformEnv), callback);
  }

  protected TServiceCall create_reqContractTreeExchangeNodesServiceCall(int routeKey, int timeout, org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv platformEnv){
    TServiceCall serviceCall = new TServiceCall();
    if (!getPeerAddr().isEmpty()) {
      serviceCall.setChooseServiceIp(getPeerAddr());
    }
    if (getPeerPort() != 0) {
      serviceCall.setChooseServicePort(getPeerPort());
    }
    serviceCall.setServiceKey(TradeAdminWebApiVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    TradeAdminWebApi.reqContractTreeExchangeNodes_args request = new TradeAdminWebApi.reqContractTreeExchangeNodes_args();
    request.setPlatformArgs(platformArgs);
    request.setPlatformEnv(platformEnv);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("reqContractTreeExchangeNodes");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(TradeAdminWebApi.reqContractTreeExchangeNodes_result.class);
    return serviceCall;
  }

  public void send_reqContractTreeCommodityNodes(int routeKey, int timeout, String exchangeMic, com.longsheng.xueqiao.contract.standard.thriftapi.SledCommodityType commodityType, com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv platformEnv) throws TException {
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
        create_reqContractTreeCommodityNodesServiceCall(routeKey, timeout, platformArgs, exchangeMic, commodityType, platformEnv), new TRequestOption());
  }

  public void send_reqContractTreeCommodityNodes(int routeKey, int timeout, String exchangeMic, com.longsheng.xueqiao.contract.standard.thriftapi.SledCommodityType commodityType, com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv platformEnv,TRequestOption requestOption) throws TException { 
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
        create_reqContractTreeCommodityNodesServiceCall(routeKey, timeout, platformArgs, exchangeMic, commodityType, platformEnv), requestOption);
  }

  public long reqContractTreeCommodityNodes(int routeKey, int timeout, String exchangeMic, com.longsheng.xueqiao.contract.standard.thriftapi.SledCommodityType commodityType, com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv platformEnv, IMethodCallback<TradeAdminWebApi.reqContractTreeCommodityNodes_args, TradeAdminWebApi.reqContractTreeCommodityNodes_result> callback) throws TException{
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
            create_reqContractTreeCommodityNodesServiceCall(routeKey, timeout, platformArgs, exchangeMic, commodityType, platformEnv), callback);
  }

  public long add_reqContractTreeCommodityNodesCall(AsyncCallRunner runner, int routeKey, int timeout, String exchangeMic, com.longsheng.xueqiao.contract.standard.thriftapi.SledCommodityType commodityType, com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv platformEnv, IMethodCallback<TradeAdminWebApi.reqContractTreeCommodityNodes_args, TradeAdminWebApi.reqContractTreeCommodityNodes_result> callback) throws TException{
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
            create_reqContractTreeCommodityNodesServiceCall(routeKey, timeout, platformArgs, exchangeMic, commodityType, platformEnv), callback);
  }

  protected TServiceCall create_reqContractTreeCommodityNodesServiceCall(int routeKey, int timeout, org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, String exchangeMic, com.longsheng.xueqiao.contract.standard.thriftapi.SledCommodityType commodityType, com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv platformEnv){
    TServiceCall serviceCall = new TServiceCall();
    if (!getPeerAddr().isEmpty()) {
      serviceCall.setChooseServiceIp(getPeerAddr());
    }
    if (getPeerPort() != 0) {
      serviceCall.setChooseServicePort(getPeerPort());
    }
    serviceCall.setServiceKey(TradeAdminWebApiVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    TradeAdminWebApi.reqContractTreeCommodityNodes_args request = new TradeAdminWebApi.reqContractTreeCommodityNodes_args();
    request.setPlatformArgs(platformArgs);
    request.setExchangeMic(exchangeMic);
    request.setCommodityType(commodityType);
    request.setPlatformEnv(platformEnv);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("reqContractTreeCommodityNodes");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(TradeAdminWebApi.reqContractTreeCommodityNodes_result.class);
    return serviceCall;
  }

  public void send_reqContractTreeContractNodes(int routeKey, int timeout, int sledCommodityId, com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv platformEnv) throws TException {
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
        create_reqContractTreeContractNodesServiceCall(routeKey, timeout, platformArgs, sledCommodityId, platformEnv), new TRequestOption());
  }

  public void send_reqContractTreeContractNodes(int routeKey, int timeout, int sledCommodityId, com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv platformEnv,TRequestOption requestOption) throws TException { 
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
        create_reqContractTreeContractNodesServiceCall(routeKey, timeout, platformArgs, sledCommodityId, platformEnv), requestOption);
  }

  public long reqContractTreeContractNodes(int routeKey, int timeout, int sledCommodityId, com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv platformEnv, IMethodCallback<TradeAdminWebApi.reqContractTreeContractNodes_args, TradeAdminWebApi.reqContractTreeContractNodes_result> callback) throws TException{
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
            create_reqContractTreeContractNodesServiceCall(routeKey, timeout, platformArgs, sledCommodityId, platformEnv), callback);
  }

  public long add_reqContractTreeContractNodesCall(AsyncCallRunner runner, int routeKey, int timeout, int sledCommodityId, com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv platformEnv, IMethodCallback<TradeAdminWebApi.reqContractTreeContractNodes_args, TradeAdminWebApi.reqContractTreeContractNodes_result> callback) throws TException{
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
            create_reqContractTreeContractNodesServiceCall(routeKey, timeout, platformArgs, sledCommodityId, platformEnv), callback);
  }

  protected TServiceCall create_reqContractTreeContractNodesServiceCall(int routeKey, int timeout, org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, int sledCommodityId, com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv platformEnv){
    TServiceCall serviceCall = new TServiceCall();
    if (!getPeerAddr().isEmpty()) {
      serviceCall.setChooseServiceIp(getPeerAddr());
    }
    if (getPeerPort() != 0) {
      serviceCall.setChooseServicePort(getPeerPort());
    }
    serviceCall.setServiceKey(TradeAdminWebApiVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    TradeAdminWebApi.reqContractTreeContractNodes_args request = new TradeAdminWebApi.reqContractTreeContractNodes_args();
    request.setPlatformArgs(platformArgs);
    request.setSledCommodityId(sledCommodityId);
    request.setPlatformEnv(platformEnv);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("reqContractTreeContractNodes");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(TradeAdminWebApi.reqContractTreeContractNodes_result.class);
    return serviceCall;
  }

}
