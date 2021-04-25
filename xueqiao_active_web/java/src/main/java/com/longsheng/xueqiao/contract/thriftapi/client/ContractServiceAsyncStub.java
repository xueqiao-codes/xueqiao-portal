package com.longsheng.xueqiao.contract.thriftapi.client;

import com.longsheng.xueqiao.contract.thriftapi.ContractService;
import com.longsheng.xueqiao.contract.thriftapi.ContractServiceVariable;
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
import com.longsheng.xueqiao.contract.thriftapi.ActiveCommodityResp;
import com.longsheng.xueqiao.contract.thriftapi.CommodityMappingEdit;
import com.longsheng.xueqiao.contract.thriftapi.CommodityMappingEditPage;
import com.longsheng.xueqiao.contract.thriftapi.ImportCommodityMapResp;
import com.longsheng.xueqiao.contract.thriftapi.LinkCommodityMappingInfo;
import com.longsheng.xueqiao.contract.thriftapi.LinkCommodityMappingResp;
import com.longsheng.xueqiao.contract.thriftapi.RemoveCommodityResp;
import com.longsheng.xueqiao.contract.thriftapi.RemoveSledExchangeResp;
import com.longsheng.xueqiao.contract.thriftapi.ReqCommodityMappingEditOption;
import com.longsheng.xueqiao.contract.thriftapi.SledCommodityEdit;
import com.longsheng.xueqiao.contract.thriftapi.SledCommodityEditPage;
import com.longsheng.xueqiao.contract.thriftapi.SledCommodityStateChangeResp;
import com.longsheng.xueqiao.contract.thriftapi.SledContractEditPage;
import com.longsheng.xueqiao.contract.thriftapi.SyncCommodityConfigResp;

public class ContractServiceAsyncStub extends BaseStub { 
  public ContractServiceAsyncStub() {
    super(ContractServiceVariable.serviceKey);
  }
  public void send_reqSledContractDetail(int routeKey, int timeout, com.longsheng.xueqiao.contract.standard.thriftapi.ReqSledContractOption option, int pageIndex, int pageSize) throws TException {
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
        create_reqSledContractDetailServiceCall(routeKey, timeout, platformArgs, option, pageIndex, pageSize), new TRequestOption());
  }

  public void send_reqSledContractDetail(int routeKey, int timeout, com.longsheng.xueqiao.contract.standard.thriftapi.ReqSledContractOption option, int pageIndex, int pageSize,TRequestOption requestOption) throws TException { 
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
        create_reqSledContractDetailServiceCall(routeKey, timeout, platformArgs, option, pageIndex, pageSize), requestOption);
  }

  public long reqSledContractDetail(int routeKey, int timeout, com.longsheng.xueqiao.contract.standard.thriftapi.ReqSledContractOption option, int pageIndex, int pageSize, IMethodCallback<ContractService.reqSledContractDetail_args, ContractService.reqSledContractDetail_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
            create_reqSledContractDetailServiceCall(routeKey, timeout, platformArgs, option, pageIndex, pageSize), callback);
  }

  public long add_reqSledContractDetailCall(AsyncCallRunner runner, int routeKey, int timeout, com.longsheng.xueqiao.contract.standard.thriftapi.ReqSledContractOption option, int pageIndex, int pageSize, IMethodCallback<ContractService.reqSledContractDetail_args, ContractService.reqSledContractDetail_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
            create_reqSledContractDetailServiceCall(routeKey, timeout, platformArgs, option, pageIndex, pageSize), callback);
  }

  protected TServiceCall create_reqSledContractDetailServiceCall(int routeKey, int timeout, org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, com.longsheng.xueqiao.contract.standard.thriftapi.ReqSledContractOption option, int pageIndex, int pageSize){
    TServiceCall serviceCall = new TServiceCall();
    if (!getPeerAddr().isEmpty()) {
      serviceCall.setChooseServiceIp(getPeerAddr());
    }
    if (getPeerPort() != 0) {
      serviceCall.setChooseServicePort(getPeerPort());
    }
    serviceCall.setServiceKey(ContractServiceVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    ContractService.reqSledContractDetail_args request = new ContractService.reqSledContractDetail_args();
    request.setPlatformArgs(platformArgs);
    request.setOption(option);
    request.setPageIndex(pageIndex);
    request.setPageSize(pageSize);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("reqSledContractDetail");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(ContractService.reqSledContractDetail_result.class);
    return serviceCall;
  }

  public void send_reqSledCommodity(int routeKey, int timeout, com.longsheng.xueqiao.contract.standard.thriftapi.ReqSledCommodityOption option, int pageIndex, int pageSize) throws TException {
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
        create_reqSledCommodityServiceCall(routeKey, timeout, platformArgs, option, pageIndex, pageSize), new TRequestOption());
  }

  public void send_reqSledCommodity(int routeKey, int timeout, com.longsheng.xueqiao.contract.standard.thriftapi.ReqSledCommodityOption option, int pageIndex, int pageSize,TRequestOption requestOption) throws TException { 
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
        create_reqSledCommodityServiceCall(routeKey, timeout, platformArgs, option, pageIndex, pageSize), requestOption);
  }

  public long reqSledCommodity(int routeKey, int timeout, com.longsheng.xueqiao.contract.standard.thriftapi.ReqSledCommodityOption option, int pageIndex, int pageSize, IMethodCallback<ContractService.reqSledCommodity_args, ContractService.reqSledCommodity_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
            create_reqSledCommodityServiceCall(routeKey, timeout, platformArgs, option, pageIndex, pageSize), callback);
  }

  public long add_reqSledCommodityCall(AsyncCallRunner runner, int routeKey, int timeout, com.longsheng.xueqiao.contract.standard.thriftapi.ReqSledCommodityOption option, int pageIndex, int pageSize, IMethodCallback<ContractService.reqSledCommodity_args, ContractService.reqSledCommodity_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
            create_reqSledCommodityServiceCall(routeKey, timeout, platformArgs, option, pageIndex, pageSize), callback);
  }

  protected TServiceCall create_reqSledCommodityServiceCall(int routeKey, int timeout, org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, com.longsheng.xueqiao.contract.standard.thriftapi.ReqSledCommodityOption option, int pageIndex, int pageSize){
    TServiceCall serviceCall = new TServiceCall();
    if (!getPeerAddr().isEmpty()) {
      serviceCall.setChooseServiceIp(getPeerAddr());
    }
    if (getPeerPort() != 0) {
      serviceCall.setChooseServicePort(getPeerPort());
    }
    serviceCall.setServiceKey(ContractServiceVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    ContractService.reqSledCommodity_args request = new ContractService.reqSledCommodity_args();
    request.setPlatformArgs(platformArgs);
    request.setOption(option);
    request.setPageIndex(pageIndex);
    request.setPageSize(pageSize);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("reqSledCommodity");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(ContractService.reqSledCommodity_result.class);
    return serviceCall;
  }

  public void send_reqSledExchange(int routeKey, int timeout, com.longsheng.xueqiao.contract.standard.thriftapi.ReqSledExchangeOption option, int pageIndex, int pageSize) throws TException {
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
        create_reqSledExchangeServiceCall(routeKey, timeout, platformArgs, option, pageIndex, pageSize), new TRequestOption());
  }

  public void send_reqSledExchange(int routeKey, int timeout, com.longsheng.xueqiao.contract.standard.thriftapi.ReqSledExchangeOption option, int pageIndex, int pageSize,TRequestOption requestOption) throws TException { 
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
        create_reqSledExchangeServiceCall(routeKey, timeout, platformArgs, option, pageIndex, pageSize), requestOption);
  }

  public long reqSledExchange(int routeKey, int timeout, com.longsheng.xueqiao.contract.standard.thriftapi.ReqSledExchangeOption option, int pageIndex, int pageSize, IMethodCallback<ContractService.reqSledExchange_args, ContractService.reqSledExchange_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
            create_reqSledExchangeServiceCall(routeKey, timeout, platformArgs, option, pageIndex, pageSize), callback);
  }

  public long add_reqSledExchangeCall(AsyncCallRunner runner, int routeKey, int timeout, com.longsheng.xueqiao.contract.standard.thriftapi.ReqSledExchangeOption option, int pageIndex, int pageSize, IMethodCallback<ContractService.reqSledExchange_args, ContractService.reqSledExchange_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
            create_reqSledExchangeServiceCall(routeKey, timeout, platformArgs, option, pageIndex, pageSize), callback);
  }

  protected TServiceCall create_reqSledExchangeServiceCall(int routeKey, int timeout, org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, com.longsheng.xueqiao.contract.standard.thriftapi.ReqSledExchangeOption option, int pageIndex, int pageSize){
    TServiceCall serviceCall = new TServiceCall();
    if (!getPeerAddr().isEmpty()) {
      serviceCall.setChooseServiceIp(getPeerAddr());
    }
    if (getPeerPort() != 0) {
      serviceCall.setChooseServicePort(getPeerPort());
    }
    serviceCall.setServiceKey(ContractServiceVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    ContractService.reqSledExchange_args request = new ContractService.reqSledExchange_args();
    request.setPlatformArgs(platformArgs);
    request.setOption(option);
    request.setPageIndex(pageIndex);
    request.setPageSize(pageSize);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("reqSledExchange");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(ContractService.reqSledExchange_result.class);
    return serviceCall;
  }

  public void send_addCommodityMapping(int routeKey, int timeout, com.longsheng.xueqiao.contract.standard.thriftapi.CommodityMapping commodityMapping) throws TException {
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
        create_addCommodityMappingServiceCall(routeKey, timeout, platformArgs, commodityMapping), new TRequestOption());
  }

  public void send_addCommodityMapping(int routeKey, int timeout, com.longsheng.xueqiao.contract.standard.thriftapi.CommodityMapping commodityMapping,TRequestOption requestOption) throws TException { 
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
        create_addCommodityMappingServiceCall(routeKey, timeout, platformArgs, commodityMapping), requestOption);
  }

  public long addCommodityMapping(int routeKey, int timeout, com.longsheng.xueqiao.contract.standard.thriftapi.CommodityMapping commodityMapping, IMethodCallback<ContractService.addCommodityMapping_args, ContractService.addCommodityMapping_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
            create_addCommodityMappingServiceCall(routeKey, timeout, platformArgs, commodityMapping), callback);
  }

  public long add_addCommodityMappingCall(AsyncCallRunner runner, int routeKey, int timeout, com.longsheng.xueqiao.contract.standard.thriftapi.CommodityMapping commodityMapping, IMethodCallback<ContractService.addCommodityMapping_args, ContractService.addCommodityMapping_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
            create_addCommodityMappingServiceCall(routeKey, timeout, platformArgs, commodityMapping), callback);
  }

  protected TServiceCall create_addCommodityMappingServiceCall(int routeKey, int timeout, org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, com.longsheng.xueqiao.contract.standard.thriftapi.CommodityMapping commodityMapping){
    TServiceCall serviceCall = new TServiceCall();
    if (!getPeerAddr().isEmpty()) {
      serviceCall.setChooseServiceIp(getPeerAddr());
    }
    if (getPeerPort() != 0) {
      serviceCall.setChooseServicePort(getPeerPort());
    }
    serviceCall.setServiceKey(ContractServiceVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    ContractService.addCommodityMapping_args request = new ContractService.addCommodityMapping_args();
    request.setPlatformArgs(platformArgs);
    request.setCommodityMapping(commodityMapping);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("addCommodityMapping");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(ContractService.addCommodityMapping_result.class);
    return serviceCall;
  }

  public void send_addSledExchange(int routeKey, int timeout, com.longsheng.xueqiao.contract.standard.thriftapi.SledExchange sledExchange) throws TException {
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
        create_addSledExchangeServiceCall(routeKey, timeout, platformArgs, sledExchange), new TRequestOption());
  }

  public void send_addSledExchange(int routeKey, int timeout, com.longsheng.xueqiao.contract.standard.thriftapi.SledExchange sledExchange,TRequestOption requestOption) throws TException { 
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
        create_addSledExchangeServiceCall(routeKey, timeout, platformArgs, sledExchange), requestOption);
  }

  public long addSledExchange(int routeKey, int timeout, com.longsheng.xueqiao.contract.standard.thriftapi.SledExchange sledExchange, IMethodCallback<ContractService.addSledExchange_args, ContractService.addSledExchange_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
            create_addSledExchangeServiceCall(routeKey, timeout, platformArgs, sledExchange), callback);
  }

  public long add_addSledExchangeCall(AsyncCallRunner runner, int routeKey, int timeout, com.longsheng.xueqiao.contract.standard.thriftapi.SledExchange sledExchange, IMethodCallback<ContractService.addSledExchange_args, ContractService.addSledExchange_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
            create_addSledExchangeServiceCall(routeKey, timeout, platformArgs, sledExchange), callback);
  }

  protected TServiceCall create_addSledExchangeServiceCall(int routeKey, int timeout, org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, com.longsheng.xueqiao.contract.standard.thriftapi.SledExchange sledExchange){
    TServiceCall serviceCall = new TServiceCall();
    if (!getPeerAddr().isEmpty()) {
      serviceCall.setChooseServiceIp(getPeerAddr());
    }
    if (getPeerPort() != 0) {
      serviceCall.setChooseServicePort(getPeerPort());
    }
    serviceCall.setServiceKey(ContractServiceVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    ContractService.addSledExchange_args request = new ContractService.addSledExchange_args();
    request.setPlatformArgs(platformArgs);
    request.setSledExchange(sledExchange);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("addSledExchange");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(ContractService.addSledExchange_result.class);
    return serviceCall;
  }

  public void send_reqCommodityMapping(int routeKey, int timeout, ReqCommodityMappingEditOption option, int pageIndex, int pageSize) throws TException {
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
        create_reqCommodityMappingServiceCall(routeKey, timeout, platformArgs, option, pageIndex, pageSize), new TRequestOption());
  }

  public void send_reqCommodityMapping(int routeKey, int timeout, ReqCommodityMappingEditOption option, int pageIndex, int pageSize,TRequestOption requestOption) throws TException { 
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
        create_reqCommodityMappingServiceCall(routeKey, timeout, platformArgs, option, pageIndex, pageSize), requestOption);
  }

  public long reqCommodityMapping(int routeKey, int timeout, ReqCommodityMappingEditOption option, int pageIndex, int pageSize, IMethodCallback<ContractService.reqCommodityMapping_args, ContractService.reqCommodityMapping_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
            create_reqCommodityMappingServiceCall(routeKey, timeout, platformArgs, option, pageIndex, pageSize), callback);
  }

  public long add_reqCommodityMappingCall(AsyncCallRunner runner, int routeKey, int timeout, ReqCommodityMappingEditOption option, int pageIndex, int pageSize, IMethodCallback<ContractService.reqCommodityMapping_args, ContractService.reqCommodityMapping_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
            create_reqCommodityMappingServiceCall(routeKey, timeout, platformArgs, option, pageIndex, pageSize), callback);
  }

  protected TServiceCall create_reqCommodityMappingServiceCall(int routeKey, int timeout, org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, ReqCommodityMappingEditOption option, int pageIndex, int pageSize){
    TServiceCall serviceCall = new TServiceCall();
    if (!getPeerAddr().isEmpty()) {
      serviceCall.setChooseServiceIp(getPeerAddr());
    }
    if (getPeerPort() != 0) {
      serviceCall.setChooseServicePort(getPeerPort());
    }
    serviceCall.setServiceKey(ContractServiceVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    ContractService.reqCommodityMapping_args request = new ContractService.reqCommodityMapping_args();
    request.setPlatformArgs(platformArgs);
    request.setOption(option);
    request.setPageIndex(pageIndex);
    request.setPageSize(pageSize);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("reqCommodityMapping");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(ContractService.reqCommodityMapping_result.class);
    return serviceCall;
  }

  public void send_addSledCommodity(int routeKey, int timeout, com.longsheng.xueqiao.contract.standard.thriftapi.SledCommodity sledCommodity) throws TException {
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
        create_addSledCommodityServiceCall(routeKey, timeout, platformArgs, sledCommodity), new TRequestOption());
  }

  public void send_addSledCommodity(int routeKey, int timeout, com.longsheng.xueqiao.contract.standard.thriftapi.SledCommodity sledCommodity,TRequestOption requestOption) throws TException { 
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
        create_addSledCommodityServiceCall(routeKey, timeout, platformArgs, sledCommodity), requestOption);
  }

  public long addSledCommodity(int routeKey, int timeout, com.longsheng.xueqiao.contract.standard.thriftapi.SledCommodity sledCommodity, IMethodCallback<ContractService.addSledCommodity_args, ContractService.addSledCommodity_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
            create_addSledCommodityServiceCall(routeKey, timeout, platformArgs, sledCommodity), callback);
  }

  public long add_addSledCommodityCall(AsyncCallRunner runner, int routeKey, int timeout, com.longsheng.xueqiao.contract.standard.thriftapi.SledCommodity sledCommodity, IMethodCallback<ContractService.addSledCommodity_args, ContractService.addSledCommodity_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
            create_addSledCommodityServiceCall(routeKey, timeout, platformArgs, sledCommodity), callback);
  }

  protected TServiceCall create_addSledCommodityServiceCall(int routeKey, int timeout, org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, com.longsheng.xueqiao.contract.standard.thriftapi.SledCommodity sledCommodity){
    TServiceCall serviceCall = new TServiceCall();
    if (!getPeerAddr().isEmpty()) {
      serviceCall.setChooseServiceIp(getPeerAddr());
    }
    if (getPeerPort() != 0) {
      serviceCall.setChooseServicePort(getPeerPort());
    }
    serviceCall.setServiceKey(ContractServiceVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    ContractService.addSledCommodity_args request = new ContractService.addSledCommodity_args();
    request.setPlatformArgs(platformArgs);
    request.setSledCommodity(sledCommodity);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("addSledCommodity");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(ContractService.addSledCommodity_result.class);
    return serviceCall;
  }

  public void send_updateSledExchange(int routeKey, int timeout, com.longsheng.xueqiao.contract.standard.thriftapi.SledExchange sledExchange) throws TException {
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
        create_updateSledExchangeServiceCall(routeKey, timeout, platformArgs, sledExchange), new TRequestOption());
  }

  public void send_updateSledExchange(int routeKey, int timeout, com.longsheng.xueqiao.contract.standard.thriftapi.SledExchange sledExchange,TRequestOption requestOption) throws TException { 
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
        create_updateSledExchangeServiceCall(routeKey, timeout, platformArgs, sledExchange), requestOption);
  }

  public long updateSledExchange(int routeKey, int timeout, com.longsheng.xueqiao.contract.standard.thriftapi.SledExchange sledExchange, IMethodCallback<ContractService.updateSledExchange_args, ContractService.updateSledExchange_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
            create_updateSledExchangeServiceCall(routeKey, timeout, platformArgs, sledExchange), callback);
  }

  public long add_updateSledExchangeCall(AsyncCallRunner runner, int routeKey, int timeout, com.longsheng.xueqiao.contract.standard.thriftapi.SledExchange sledExchange, IMethodCallback<ContractService.updateSledExchange_args, ContractService.updateSledExchange_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
            create_updateSledExchangeServiceCall(routeKey, timeout, platformArgs, sledExchange), callback);
  }

  protected TServiceCall create_updateSledExchangeServiceCall(int routeKey, int timeout, org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, com.longsheng.xueqiao.contract.standard.thriftapi.SledExchange sledExchange){
    TServiceCall serviceCall = new TServiceCall();
    if (!getPeerAddr().isEmpty()) {
      serviceCall.setChooseServiceIp(getPeerAddr());
    }
    if (getPeerPort() != 0) {
      serviceCall.setChooseServicePort(getPeerPort());
    }
    serviceCall.setServiceKey(ContractServiceVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    ContractService.updateSledExchange_args request = new ContractService.updateSledExchange_args();
    request.setPlatformArgs(platformArgs);
    request.setSledExchange(sledExchange);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("updateSledExchange");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(ContractService.updateSledExchange_result.class);
    return serviceCall;
  }

  public void send_updateSledCommodity(int routeKey, int timeout, com.longsheng.xueqiao.contract.standard.thriftapi.SledCommodity sledCommodity) throws TException {
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
        create_updateSledCommodityServiceCall(routeKey, timeout, platformArgs, sledCommodity), new TRequestOption());
  }

  public void send_updateSledCommodity(int routeKey, int timeout, com.longsheng.xueqiao.contract.standard.thriftapi.SledCommodity sledCommodity,TRequestOption requestOption) throws TException { 
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
        create_updateSledCommodityServiceCall(routeKey, timeout, platformArgs, sledCommodity), requestOption);
  }

  public long updateSledCommodity(int routeKey, int timeout, com.longsheng.xueqiao.contract.standard.thriftapi.SledCommodity sledCommodity, IMethodCallback<ContractService.updateSledCommodity_args, ContractService.updateSledCommodity_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
            create_updateSledCommodityServiceCall(routeKey, timeout, platformArgs, sledCommodity), callback);
  }

  public long add_updateSledCommodityCall(AsyncCallRunner runner, int routeKey, int timeout, com.longsheng.xueqiao.contract.standard.thriftapi.SledCommodity sledCommodity, IMethodCallback<ContractService.updateSledCommodity_args, ContractService.updateSledCommodity_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
            create_updateSledCommodityServiceCall(routeKey, timeout, platformArgs, sledCommodity), callback);
  }

  protected TServiceCall create_updateSledCommodityServiceCall(int routeKey, int timeout, org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, com.longsheng.xueqiao.contract.standard.thriftapi.SledCommodity sledCommodity){
    TServiceCall serviceCall = new TServiceCall();
    if (!getPeerAddr().isEmpty()) {
      serviceCall.setChooseServiceIp(getPeerAddr());
    }
    if (getPeerPort() != 0) {
      serviceCall.setChooseServicePort(getPeerPort());
    }
    serviceCall.setServiceKey(ContractServiceVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    ContractService.updateSledCommodity_args request = new ContractService.updateSledCommodity_args();
    request.setPlatformArgs(platformArgs);
    request.setSledCommodity(sledCommodity);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("updateSledCommodity");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(ContractService.updateSledCommodity_result.class);
    return serviceCall;
  }

  public void send_updateCommodityMapping(int routeKey, int timeout, com.longsheng.xueqiao.contract.standard.thriftapi.CommodityMapping commodityMapping) throws TException {
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
        create_updateCommodityMappingServiceCall(routeKey, timeout, platformArgs, commodityMapping), new TRequestOption());
  }

  public void send_updateCommodityMapping(int routeKey, int timeout, com.longsheng.xueqiao.contract.standard.thriftapi.CommodityMapping commodityMapping,TRequestOption requestOption) throws TException { 
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
        create_updateCommodityMappingServiceCall(routeKey, timeout, platformArgs, commodityMapping), requestOption);
  }

  public long updateCommodityMapping(int routeKey, int timeout, com.longsheng.xueqiao.contract.standard.thriftapi.CommodityMapping commodityMapping, IMethodCallback<ContractService.updateCommodityMapping_args, ContractService.updateCommodityMapping_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
            create_updateCommodityMappingServiceCall(routeKey, timeout, platformArgs, commodityMapping), callback);
  }

  public long add_updateCommodityMappingCall(AsyncCallRunner runner, int routeKey, int timeout, com.longsheng.xueqiao.contract.standard.thriftapi.CommodityMapping commodityMapping, IMethodCallback<ContractService.updateCommodityMapping_args, ContractService.updateCommodityMapping_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
            create_updateCommodityMappingServiceCall(routeKey, timeout, platformArgs, commodityMapping), callback);
  }

  protected TServiceCall create_updateCommodityMappingServiceCall(int routeKey, int timeout, org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, com.longsheng.xueqiao.contract.standard.thriftapi.CommodityMapping commodityMapping){
    TServiceCall serviceCall = new TServiceCall();
    if (!getPeerAddr().isEmpty()) {
      serviceCall.setChooseServiceIp(getPeerAddr());
    }
    if (getPeerPort() != 0) {
      serviceCall.setChooseServicePort(getPeerPort());
    }
    serviceCall.setServiceKey(ContractServiceVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    ContractService.updateCommodityMapping_args request = new ContractService.updateCommodityMapping_args();
    request.setPlatformArgs(platformArgs);
    request.setCommodityMapping(commodityMapping);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("updateCommodityMapping");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(ContractService.updateCommodityMapping_result.class);
    return serviceCall;
  }

  public void send_importCommodityMapFile(int routeKey, int timeout, com.longsheng.xueqiao.contract.thriftapi.CommodityMapFileInfo mapFileInfo) throws TException {
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
        create_importCommodityMapFileServiceCall(routeKey, timeout, platformArgs, mapFileInfo), new TRequestOption());
  }

  public void send_importCommodityMapFile(int routeKey, int timeout, com.longsheng.xueqiao.contract.thriftapi.CommodityMapFileInfo mapFileInfo,TRequestOption requestOption) throws TException { 
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
        create_importCommodityMapFileServiceCall(routeKey, timeout, platformArgs, mapFileInfo), requestOption);
  }

  public long importCommodityMapFile(int routeKey, int timeout, com.longsheng.xueqiao.contract.thriftapi.CommodityMapFileInfo mapFileInfo, IMethodCallback<ContractService.importCommodityMapFile_args, ContractService.importCommodityMapFile_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
            create_importCommodityMapFileServiceCall(routeKey, timeout, platformArgs, mapFileInfo), callback);
  }

  public long add_importCommodityMapFileCall(AsyncCallRunner runner, int routeKey, int timeout, com.longsheng.xueqiao.contract.thriftapi.CommodityMapFileInfo mapFileInfo, IMethodCallback<ContractService.importCommodityMapFile_args, ContractService.importCommodityMapFile_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
            create_importCommodityMapFileServiceCall(routeKey, timeout, platformArgs, mapFileInfo), callback);
  }

  protected TServiceCall create_importCommodityMapFileServiceCall(int routeKey, int timeout, org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, com.longsheng.xueqiao.contract.thriftapi.CommodityMapFileInfo mapFileInfo){
    TServiceCall serviceCall = new TServiceCall();
    if (!getPeerAddr().isEmpty()) {
      serviceCall.setChooseServiceIp(getPeerAddr());
    }
    if (getPeerPort() != 0) {
      serviceCall.setChooseServicePort(getPeerPort());
    }
    serviceCall.setServiceKey(ContractServiceVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    ContractService.importCommodityMapFile_args request = new ContractService.importCommodityMapFile_args();
    request.setPlatformArgs(platformArgs);
    request.setMapFileInfo(mapFileInfo);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("importCommodityMapFile");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(ContractService.importCommodityMapFile_result.class);
    return serviceCall;
  }

  public void send_reqCommodityMapFileInfo(int routeKey, int timeout, com.longsheng.xueqiao.contract.thriftapi.ReqCommodityMapFileInfoOption option, int pageIndex, int pageSize) throws TException {
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
        create_reqCommodityMapFileInfoServiceCall(routeKey, timeout, platformArgs, option, pageIndex, pageSize), new TRequestOption());
  }

  public void send_reqCommodityMapFileInfo(int routeKey, int timeout, com.longsheng.xueqiao.contract.thriftapi.ReqCommodityMapFileInfoOption option, int pageIndex, int pageSize,TRequestOption requestOption) throws TException { 
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
        create_reqCommodityMapFileInfoServiceCall(routeKey, timeout, platformArgs, option, pageIndex, pageSize), requestOption);
  }

  public long reqCommodityMapFileInfo(int routeKey, int timeout, com.longsheng.xueqiao.contract.thriftapi.ReqCommodityMapFileInfoOption option, int pageIndex, int pageSize, IMethodCallback<ContractService.reqCommodityMapFileInfo_args, ContractService.reqCommodityMapFileInfo_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
            create_reqCommodityMapFileInfoServiceCall(routeKey, timeout, platformArgs, option, pageIndex, pageSize), callback);
  }

  public long add_reqCommodityMapFileInfoCall(AsyncCallRunner runner, int routeKey, int timeout, com.longsheng.xueqiao.contract.thriftapi.ReqCommodityMapFileInfoOption option, int pageIndex, int pageSize, IMethodCallback<ContractService.reqCommodityMapFileInfo_args, ContractService.reqCommodityMapFileInfo_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
            create_reqCommodityMapFileInfoServiceCall(routeKey, timeout, platformArgs, option, pageIndex, pageSize), callback);
  }

  protected TServiceCall create_reqCommodityMapFileInfoServiceCall(int routeKey, int timeout, org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, com.longsheng.xueqiao.contract.thriftapi.ReqCommodityMapFileInfoOption option, int pageIndex, int pageSize){
    TServiceCall serviceCall = new TServiceCall();
    if (!getPeerAddr().isEmpty()) {
      serviceCall.setChooseServiceIp(getPeerAddr());
    }
    if (getPeerPort() != 0) {
      serviceCall.setChooseServicePort(getPeerPort());
    }
    serviceCall.setServiceKey(ContractServiceVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    ContractService.reqCommodityMapFileInfo_args request = new ContractService.reqCommodityMapFileInfo_args();
    request.setPlatformArgs(platformArgs);
    request.setOption(option);
    request.setPageIndex(pageIndex);
    request.setPageSize(pageSize);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("reqCommodityMapFileInfo");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(ContractService.reqCommodityMapFileInfo_result.class);
    return serviceCall;
  }

  public void send_linkTechPlatformMapping(int routeKey, int timeout, LinkCommodityMappingInfo linkCommodityMappingInfo) throws TException {
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
        create_linkTechPlatformMappingServiceCall(routeKey, timeout, platformArgs, linkCommodityMappingInfo), new TRequestOption());
  }

  public void send_linkTechPlatformMapping(int routeKey, int timeout, LinkCommodityMappingInfo linkCommodityMappingInfo,TRequestOption requestOption) throws TException { 
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
        create_linkTechPlatformMappingServiceCall(routeKey, timeout, platformArgs, linkCommodityMappingInfo), requestOption);
  }

  public long linkTechPlatformMapping(int routeKey, int timeout, LinkCommodityMappingInfo linkCommodityMappingInfo, IMethodCallback<ContractService.linkTechPlatformMapping_args, ContractService.linkTechPlatformMapping_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
            create_linkTechPlatformMappingServiceCall(routeKey, timeout, platformArgs, linkCommodityMappingInfo), callback);
  }

  public long add_linkTechPlatformMappingCall(AsyncCallRunner runner, int routeKey, int timeout, LinkCommodityMappingInfo linkCommodityMappingInfo, IMethodCallback<ContractService.linkTechPlatformMapping_args, ContractService.linkTechPlatformMapping_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
            create_linkTechPlatformMappingServiceCall(routeKey, timeout, platformArgs, linkCommodityMappingInfo), callback);
  }

  protected TServiceCall create_linkTechPlatformMappingServiceCall(int routeKey, int timeout, org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, LinkCommodityMappingInfo linkCommodityMappingInfo){
    TServiceCall serviceCall = new TServiceCall();
    if (!getPeerAddr().isEmpty()) {
      serviceCall.setChooseServiceIp(getPeerAddr());
    }
    if (getPeerPort() != 0) {
      serviceCall.setChooseServicePort(getPeerPort());
    }
    serviceCall.setServiceKey(ContractServiceVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    ContractService.linkTechPlatformMapping_args request = new ContractService.linkTechPlatformMapping_args();
    request.setPlatformArgs(platformArgs);
    request.setLinkCommodityMappingInfo(linkCommodityMappingInfo);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("linkTechPlatformMapping");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(ContractService.linkTechPlatformMapping_result.class);
    return serviceCall;
  }

  public void send_reqTechPlatformCommodity(int routeKey, int timeout, com.longsheng.xueqiao.contract.thriftapi.ReqTechPlatformCommodityOption option, int pageIndex, int pageSize) throws TException {
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
        create_reqTechPlatformCommodityServiceCall(routeKey, timeout, platformArgs, option, pageIndex, pageSize), new TRequestOption());
  }

  public void send_reqTechPlatformCommodity(int routeKey, int timeout, com.longsheng.xueqiao.contract.thriftapi.ReqTechPlatformCommodityOption option, int pageIndex, int pageSize,TRequestOption requestOption) throws TException { 
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
        create_reqTechPlatformCommodityServiceCall(routeKey, timeout, platformArgs, option, pageIndex, pageSize), requestOption);
  }

  public long reqTechPlatformCommodity(int routeKey, int timeout, com.longsheng.xueqiao.contract.thriftapi.ReqTechPlatformCommodityOption option, int pageIndex, int pageSize, IMethodCallback<ContractService.reqTechPlatformCommodity_args, ContractService.reqTechPlatformCommodity_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
            create_reqTechPlatformCommodityServiceCall(routeKey, timeout, platformArgs, option, pageIndex, pageSize), callback);
  }

  public long add_reqTechPlatformCommodityCall(AsyncCallRunner runner, int routeKey, int timeout, com.longsheng.xueqiao.contract.thriftapi.ReqTechPlatformCommodityOption option, int pageIndex, int pageSize, IMethodCallback<ContractService.reqTechPlatformCommodity_args, ContractService.reqTechPlatformCommodity_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
            create_reqTechPlatformCommodityServiceCall(routeKey, timeout, platformArgs, option, pageIndex, pageSize), callback);
  }

  protected TServiceCall create_reqTechPlatformCommodityServiceCall(int routeKey, int timeout, org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, com.longsheng.xueqiao.contract.thriftapi.ReqTechPlatformCommodityOption option, int pageIndex, int pageSize){
    TServiceCall serviceCall = new TServiceCall();
    if (!getPeerAddr().isEmpty()) {
      serviceCall.setChooseServiceIp(getPeerAddr());
    }
    if (getPeerPort() != 0) {
      serviceCall.setChooseServicePort(getPeerPort());
    }
    serviceCall.setServiceKey(ContractServiceVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    ContractService.reqTechPlatformCommodity_args request = new ContractService.reqTechPlatformCommodity_args();
    request.setPlatformArgs(platformArgs);
    request.setOption(option);
    request.setPageIndex(pageIndex);
    request.setPageSize(pageSize);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("reqTechPlatformCommodity");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(ContractService.reqTechPlatformCommodity_result.class);
    return serviceCall;
  }

  public void send_addTechPlatformCommodity(int routeKey, int timeout, com.longsheng.xueqiao.contract.thriftapi.TechPlatformCommodity techPlatformCommodity) throws TException {
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
        create_addTechPlatformCommodityServiceCall(routeKey, timeout, platformArgs, techPlatformCommodity), new TRequestOption());
  }

  public void send_addTechPlatformCommodity(int routeKey, int timeout, com.longsheng.xueqiao.contract.thriftapi.TechPlatformCommodity techPlatformCommodity,TRequestOption requestOption) throws TException { 
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
        create_addTechPlatformCommodityServiceCall(routeKey, timeout, platformArgs, techPlatformCommodity), requestOption);
  }

  public long addTechPlatformCommodity(int routeKey, int timeout, com.longsheng.xueqiao.contract.thriftapi.TechPlatformCommodity techPlatformCommodity, IMethodCallback<ContractService.addTechPlatformCommodity_args, ContractService.addTechPlatformCommodity_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
            create_addTechPlatformCommodityServiceCall(routeKey, timeout, platformArgs, techPlatformCommodity), callback);
  }

  public long add_addTechPlatformCommodityCall(AsyncCallRunner runner, int routeKey, int timeout, com.longsheng.xueqiao.contract.thriftapi.TechPlatformCommodity techPlatformCommodity, IMethodCallback<ContractService.addTechPlatformCommodity_args, ContractService.addTechPlatformCommodity_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
            create_addTechPlatformCommodityServiceCall(routeKey, timeout, platformArgs, techPlatformCommodity), callback);
  }

  protected TServiceCall create_addTechPlatformCommodityServiceCall(int routeKey, int timeout, org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, com.longsheng.xueqiao.contract.thriftapi.TechPlatformCommodity techPlatformCommodity){
    TServiceCall serviceCall = new TServiceCall();
    if (!getPeerAddr().isEmpty()) {
      serviceCall.setChooseServiceIp(getPeerAddr());
    }
    if (getPeerPort() != 0) {
      serviceCall.setChooseServicePort(getPeerPort());
    }
    serviceCall.setServiceKey(ContractServiceVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    ContractService.addTechPlatformCommodity_args request = new ContractService.addTechPlatformCommodity_args();
    request.setPlatformArgs(platformArgs);
    request.setTechPlatformCommodity(techPlatformCommodity);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("addTechPlatformCommodity");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(ContractService.addTechPlatformCommodity_result.class);
    return serviceCall;
  }

  public void send_activeSledCommodity(int routeKey, int timeout, int sledCommodityId) throws TException {
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
        create_activeSledCommodityServiceCall(routeKey, timeout, platformArgs, sledCommodityId), new TRequestOption());
  }

  public void send_activeSledCommodity(int routeKey, int timeout, int sledCommodityId,TRequestOption requestOption) throws TException { 
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
        create_activeSledCommodityServiceCall(routeKey, timeout, platformArgs, sledCommodityId), requestOption);
  }

  public long activeSledCommodity(int routeKey, int timeout, int sledCommodityId, IMethodCallback<ContractService.activeSledCommodity_args, ContractService.activeSledCommodity_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
            create_activeSledCommodityServiceCall(routeKey, timeout, platformArgs, sledCommodityId), callback);
  }

  public long add_activeSledCommodityCall(AsyncCallRunner runner, int routeKey, int timeout, int sledCommodityId, IMethodCallback<ContractService.activeSledCommodity_args, ContractService.activeSledCommodity_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
            create_activeSledCommodityServiceCall(routeKey, timeout, platformArgs, sledCommodityId), callback);
  }

  protected TServiceCall create_activeSledCommodityServiceCall(int routeKey, int timeout, org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, int sledCommodityId){
    TServiceCall serviceCall = new TServiceCall();
    if (!getPeerAddr().isEmpty()) {
      serviceCall.setChooseServiceIp(getPeerAddr());
    }
    if (getPeerPort() != 0) {
      serviceCall.setChooseServicePort(getPeerPort());
    }
    serviceCall.setServiceKey(ContractServiceVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    ContractService.activeSledCommodity_args request = new ContractService.activeSledCommodity_args();
    request.setPlatformArgs(platformArgs);
    request.setSledCommodityId(sledCommodityId);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("activeSledCommodity");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(ContractService.activeSledCommodity_result.class);
    return serviceCall;
  }

  public void send_syncSledCommodityConfig(int routeKey, int timeout, int sledCommodityId) throws TException {
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
        create_syncSledCommodityConfigServiceCall(routeKey, timeout, platformArgs, sledCommodityId), new TRequestOption());
  }

  public void send_syncSledCommodityConfig(int routeKey, int timeout, int sledCommodityId,TRequestOption requestOption) throws TException { 
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
        create_syncSledCommodityConfigServiceCall(routeKey, timeout, platformArgs, sledCommodityId), requestOption);
  }

  public long syncSledCommodityConfig(int routeKey, int timeout, int sledCommodityId, IMethodCallback<ContractService.syncSledCommodityConfig_args, ContractService.syncSledCommodityConfig_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
            create_syncSledCommodityConfigServiceCall(routeKey, timeout, platformArgs, sledCommodityId), callback);
  }

  public long add_syncSledCommodityConfigCall(AsyncCallRunner runner, int routeKey, int timeout, int sledCommodityId, IMethodCallback<ContractService.syncSledCommodityConfig_args, ContractService.syncSledCommodityConfig_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
            create_syncSledCommodityConfigServiceCall(routeKey, timeout, platformArgs, sledCommodityId), callback);
  }

  protected TServiceCall create_syncSledCommodityConfigServiceCall(int routeKey, int timeout, org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, int sledCommodityId){
    TServiceCall serviceCall = new TServiceCall();
    if (!getPeerAddr().isEmpty()) {
      serviceCall.setChooseServiceIp(getPeerAddr());
    }
    if (getPeerPort() != 0) {
      serviceCall.setChooseServicePort(getPeerPort());
    }
    serviceCall.setServiceKey(ContractServiceVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    ContractService.syncSledCommodityConfig_args request = new ContractService.syncSledCommodityConfig_args();
    request.setPlatformArgs(platformArgs);
    request.setSledCommodityId(sledCommodityId);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("syncSledCommodityConfig");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(ContractService.syncSledCommodityConfig_result.class);
    return serviceCall;
  }

  public void send_removeSledCommodity(int routeKey, int timeout, int sledCommodityId) throws TException {
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
        create_removeSledCommodityServiceCall(routeKey, timeout, platformArgs, sledCommodityId), new TRequestOption());
  }

  public void send_removeSledCommodity(int routeKey, int timeout, int sledCommodityId,TRequestOption requestOption) throws TException { 
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
        create_removeSledCommodityServiceCall(routeKey, timeout, platformArgs, sledCommodityId), requestOption);
  }

  public long removeSledCommodity(int routeKey, int timeout, int sledCommodityId, IMethodCallback<ContractService.removeSledCommodity_args, ContractService.removeSledCommodity_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
            create_removeSledCommodityServiceCall(routeKey, timeout, platformArgs, sledCommodityId), callback);
  }

  public long add_removeSledCommodityCall(AsyncCallRunner runner, int routeKey, int timeout, int sledCommodityId, IMethodCallback<ContractService.removeSledCommodity_args, ContractService.removeSledCommodity_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
            create_removeSledCommodityServiceCall(routeKey, timeout, platformArgs, sledCommodityId), callback);
  }

  protected TServiceCall create_removeSledCommodityServiceCall(int routeKey, int timeout, org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, int sledCommodityId){
    TServiceCall serviceCall = new TServiceCall();
    if (!getPeerAddr().isEmpty()) {
      serviceCall.setChooseServiceIp(getPeerAddr());
    }
    if (getPeerPort() != 0) {
      serviceCall.setChooseServicePort(getPeerPort());
    }
    serviceCall.setServiceKey(ContractServiceVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    ContractService.removeSledCommodity_args request = new ContractService.removeSledCommodity_args();
    request.setPlatformArgs(platformArgs);
    request.setSledCommodityId(sledCommodityId);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("removeSledCommodity");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(ContractService.removeSledCommodity_result.class);
    return serviceCall;
  }

  public void send_removeSledExchange(int routeKey, int timeout, int sledExchangeId) throws TException {
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
        create_removeSledExchangeServiceCall(routeKey, timeout, platformArgs, sledExchangeId), new TRequestOption());
  }

  public void send_removeSledExchange(int routeKey, int timeout, int sledExchangeId,TRequestOption requestOption) throws TException { 
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
        create_removeSledExchangeServiceCall(routeKey, timeout, platformArgs, sledExchangeId), requestOption);
  }

  public long removeSledExchange(int routeKey, int timeout, int sledExchangeId, IMethodCallback<ContractService.removeSledExchange_args, ContractService.removeSledExchange_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
            create_removeSledExchangeServiceCall(routeKey, timeout, platformArgs, sledExchangeId), callback);
  }

  public long add_removeSledExchangeCall(AsyncCallRunner runner, int routeKey, int timeout, int sledExchangeId, IMethodCallback<ContractService.removeSledExchange_args, ContractService.removeSledExchange_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
            create_removeSledExchangeServiceCall(routeKey, timeout, platformArgs, sledExchangeId), callback);
  }

  protected TServiceCall create_removeSledExchangeServiceCall(int routeKey, int timeout, org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, int sledExchangeId){
    TServiceCall serviceCall = new TServiceCall();
    if (!getPeerAddr().isEmpty()) {
      serviceCall.setChooseServiceIp(getPeerAddr());
    }
    if (getPeerPort() != 0) {
      serviceCall.setChooseServicePort(getPeerPort());
    }
    serviceCall.setServiceKey(ContractServiceVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    ContractService.removeSledExchange_args request = new ContractService.removeSledExchange_args();
    request.setPlatformArgs(platformArgs);
    request.setSledExchangeId(sledExchangeId);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("removeSledExchange");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(ContractService.removeSledExchange_result.class);
    return serviceCall;
  }

  public void send_changeSledCommodityState(int routeKey, int timeout, int sledCommodityId, com.longsheng.xueqiao.contract.standard.thriftapi.CommodityState newState) throws TException {
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
        create_changeSledCommodityStateServiceCall(routeKey, timeout, platformArgs, sledCommodityId, newState), new TRequestOption());
  }

  public void send_changeSledCommodityState(int routeKey, int timeout, int sledCommodityId, com.longsheng.xueqiao.contract.standard.thriftapi.CommodityState newState,TRequestOption requestOption) throws TException { 
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
        create_changeSledCommodityStateServiceCall(routeKey, timeout, platformArgs, sledCommodityId, newState), requestOption);
  }

  public long changeSledCommodityState(int routeKey, int timeout, int sledCommodityId, com.longsheng.xueqiao.contract.standard.thriftapi.CommodityState newState, IMethodCallback<ContractService.changeSledCommodityState_args, ContractService.changeSledCommodityState_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
            create_changeSledCommodityStateServiceCall(routeKey, timeout, platformArgs, sledCommodityId, newState), callback);
  }

  public long add_changeSledCommodityStateCall(AsyncCallRunner runner, int routeKey, int timeout, int sledCommodityId, com.longsheng.xueqiao.contract.standard.thriftapi.CommodityState newState, IMethodCallback<ContractService.changeSledCommodityState_args, ContractService.changeSledCommodityState_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
            create_changeSledCommodityStateServiceCall(routeKey, timeout, platformArgs, sledCommodityId, newState), callback);
  }

  protected TServiceCall create_changeSledCommodityStateServiceCall(int routeKey, int timeout, org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, int sledCommodityId, com.longsheng.xueqiao.contract.standard.thriftapi.CommodityState newState){
    TServiceCall serviceCall = new TServiceCall();
    if (!getPeerAddr().isEmpty()) {
      serviceCall.setChooseServiceIp(getPeerAddr());
    }
    if (getPeerPort() != 0) {
      serviceCall.setChooseServicePort(getPeerPort());
    }
    serviceCall.setServiceKey(ContractServiceVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    ContractService.changeSledCommodityState_args request = new ContractService.changeSledCommodityState_args();
    request.setPlatformArgs(platformArgs);
    request.setSledCommodityId(sledCommodityId);
    request.setNewState(newState);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("changeSledCommodityState");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(ContractService.changeSledCommodityState_result.class);
    return serviceCall;
  }

}
