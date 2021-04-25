package xueqiao.mailbox.webapi.thriftapi.client;

import xueqiao.mailbox.webapi.thriftapi.MailboxWebapi;
import xueqiao.mailbox.webapi.thriftapi.MailboxWebapiVariable;
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
import xueqiao.mailbox.webapi.thriftapi.CompanyReceiver;
import xueqiao.mailbox.webapi.thriftapi.ContentText;
import xueqiao.mailbox.webapi.thriftapi.GroupReceiver;
import xueqiao.mailbox.webapi.thriftapi.MBMessageTemplateSelector;
import xueqiao.mailbox.webapi.thriftapi.OperateResult;

public class MailboxWebapiAsyncStub extends BaseStub { 
  public MailboxWebapiAsyncStub() {
    super(MailboxWebapiVariable.serviceKey);
  }
  public void send_reqTemplate(int routeKey, int timeout, xueqiao.mailbox.thriftdata.req.QueryMBMessageTemplateOption option, org.soldier.platform.page.IndexedPageOption pageOption) throws TException {
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
        create_reqTemplateServiceCall(routeKey, timeout, platformArgs, option, pageOption), new TRequestOption());
  }

  public void send_reqTemplate(int routeKey, int timeout, xueqiao.mailbox.thriftdata.req.QueryMBMessageTemplateOption option, org.soldier.platform.page.IndexedPageOption pageOption,TRequestOption requestOption) throws TException { 
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
        create_reqTemplateServiceCall(routeKey, timeout, platformArgs, option, pageOption), requestOption);
  }

  public long reqTemplate(int routeKey, int timeout, xueqiao.mailbox.thriftdata.req.QueryMBMessageTemplateOption option, org.soldier.platform.page.IndexedPageOption pageOption, IMethodCallback<MailboxWebapi.reqTemplate_args, MailboxWebapi.reqTemplate_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
            create_reqTemplateServiceCall(routeKey, timeout, platformArgs, option, pageOption), callback);
  }

  public long add_reqTemplateCall(AsyncCallRunner runner, int routeKey, int timeout, xueqiao.mailbox.thriftdata.req.QueryMBMessageTemplateOption option, org.soldier.platform.page.IndexedPageOption pageOption, IMethodCallback<MailboxWebapi.reqTemplate_args, MailboxWebapi.reqTemplate_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
            create_reqTemplateServiceCall(routeKey, timeout, platformArgs, option, pageOption), callback);
  }

  protected TServiceCall create_reqTemplateServiceCall(int routeKey, int timeout, org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, xueqiao.mailbox.thriftdata.req.QueryMBMessageTemplateOption option, org.soldier.platform.page.IndexedPageOption pageOption){
    TServiceCall serviceCall = new TServiceCall();
    if (!getPeerAddr().isEmpty()) {
      serviceCall.setChooseServiceIp(getPeerAddr());
    }
    if (getPeerPort() != 0) {
      serviceCall.setChooseServicePort(getPeerPort());
    }
    serviceCall.setServiceKey(MailboxWebapiVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    MailboxWebapi.reqTemplate_args request = new MailboxWebapi.reqTemplate_args();
    request.setPlatformArgs(platformArgs);
    request.setOption(option);
    request.setPageOption(pageOption);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("reqTemplate");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(MailboxWebapi.reqTemplate_result.class);
    return serviceCall;
  }

  public void send_addTemplate(int routeKey, int timeout, xueqiao.mailbox.thriftdata.mb.MBMessageTemplate template) throws TException {
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
        create_addTemplateServiceCall(routeKey, timeout, platformArgs, template), new TRequestOption());
  }

  public void send_addTemplate(int routeKey, int timeout, xueqiao.mailbox.thriftdata.mb.MBMessageTemplate template,TRequestOption requestOption) throws TException { 
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
        create_addTemplateServiceCall(routeKey, timeout, platformArgs, template), requestOption);
  }

  public long addTemplate(int routeKey, int timeout, xueqiao.mailbox.thriftdata.mb.MBMessageTemplate template, IMethodCallback<MailboxWebapi.addTemplate_args, MailboxWebapi.addTemplate_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
            create_addTemplateServiceCall(routeKey, timeout, platformArgs, template), callback);
  }

  public long add_addTemplateCall(AsyncCallRunner runner, int routeKey, int timeout, xueqiao.mailbox.thriftdata.mb.MBMessageTemplate template, IMethodCallback<MailboxWebapi.addTemplate_args, MailboxWebapi.addTemplate_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
            create_addTemplateServiceCall(routeKey, timeout, platformArgs, template), callback);
  }

  protected TServiceCall create_addTemplateServiceCall(int routeKey, int timeout, org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, xueqiao.mailbox.thriftdata.mb.MBMessageTemplate template){
    TServiceCall serviceCall = new TServiceCall();
    if (!getPeerAddr().isEmpty()) {
      serviceCall.setChooseServiceIp(getPeerAddr());
    }
    if (getPeerPort() != 0) {
      serviceCall.setChooseServicePort(getPeerPort());
    }
    serviceCall.setServiceKey(MailboxWebapiVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    MailboxWebapi.addTemplate_args request = new MailboxWebapi.addTemplate_args();
    request.setPlatformArgs(platformArgs);
    request.setTemplate(template);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("addTemplate");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(MailboxWebapi.addTemplate_result.class);
    return serviceCall;
  }

  public void send_updateTemplate(int routeKey, int timeout, xueqiao.mailbox.thriftdata.mb.MBMessageTemplate template) throws TException {
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
        create_updateTemplateServiceCall(routeKey, timeout, platformArgs, template), new TRequestOption());
  }

  public void send_updateTemplate(int routeKey, int timeout, xueqiao.mailbox.thriftdata.mb.MBMessageTemplate template,TRequestOption requestOption) throws TException { 
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
        create_updateTemplateServiceCall(routeKey, timeout, platformArgs, template), requestOption);
  }

  public long updateTemplate(int routeKey, int timeout, xueqiao.mailbox.thriftdata.mb.MBMessageTemplate template, IMethodCallback<MailboxWebapi.updateTemplate_args, MailboxWebapi.updateTemplate_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
            create_updateTemplateServiceCall(routeKey, timeout, platformArgs, template), callback);
  }

  public long add_updateTemplateCall(AsyncCallRunner runner, int routeKey, int timeout, xueqiao.mailbox.thriftdata.mb.MBMessageTemplate template, IMethodCallback<MailboxWebapi.updateTemplate_args, MailboxWebapi.updateTemplate_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
            create_updateTemplateServiceCall(routeKey, timeout, platformArgs, template), callback);
  }

  protected TServiceCall create_updateTemplateServiceCall(int routeKey, int timeout, org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, xueqiao.mailbox.thriftdata.mb.MBMessageTemplate template){
    TServiceCall serviceCall = new TServiceCall();
    if (!getPeerAddr().isEmpty()) {
      serviceCall.setChooseServiceIp(getPeerAddr());
    }
    if (getPeerPort() != 0) {
      serviceCall.setChooseServicePort(getPeerPort());
    }
    serviceCall.setServiceKey(MailboxWebapiVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    MailboxWebapi.updateTemplate_args request = new MailboxWebapi.updateTemplate_args();
    request.setPlatformArgs(platformArgs);
    request.setTemplate(template);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("updateTemplate");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(MailboxWebapi.updateTemplate_result.class);
    return serviceCall;
  }

  public void send_removeTemplate(int routeKey, int timeout, long templateId) throws TException {
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
        create_removeTemplateServiceCall(routeKey, timeout, platformArgs, templateId), new TRequestOption());
  }

  public void send_removeTemplate(int routeKey, int timeout, long templateId,TRequestOption requestOption) throws TException { 
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
        create_removeTemplateServiceCall(routeKey, timeout, platformArgs, templateId), requestOption);
  }

  public long removeTemplate(int routeKey, int timeout, long templateId, IMethodCallback<MailboxWebapi.removeTemplate_args, MailboxWebapi.removeTemplate_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
            create_removeTemplateServiceCall(routeKey, timeout, platformArgs, templateId), callback);
  }

  public long add_removeTemplateCall(AsyncCallRunner runner, int routeKey, int timeout, long templateId, IMethodCallback<MailboxWebapi.removeTemplate_args, MailboxWebapi.removeTemplate_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
            create_removeTemplateServiceCall(routeKey, timeout, platformArgs, templateId), callback);
  }

  protected TServiceCall create_removeTemplateServiceCall(int routeKey, int timeout, org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, long templateId){
    TServiceCall serviceCall = new TServiceCall();
    if (!getPeerAddr().isEmpty()) {
      serviceCall.setChooseServiceIp(getPeerAddr());
    }
    if (getPeerPort() != 0) {
      serviceCall.setChooseServicePort(getPeerPort());
    }
    serviceCall.setServiceKey(MailboxWebapiVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    MailboxWebapi.removeTemplate_args request = new MailboxWebapi.removeTemplate_args();
    request.setPlatformArgs(platformArgs);
    request.setTemplateId(templateId);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("removeTemplate");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(MailboxWebapi.removeTemplate_result.class);
    return serviceCall;
  }

  public void send_reqMBMessageJob(int routeKey, int timeout, xueqiao.mailbox.thriftdata.req.QueryMBMessageJobOption option, org.soldier.platform.page.IndexedPageOption pageOption) throws TException {
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
        create_reqMBMessageJobServiceCall(routeKey, timeout, platformArgs, option, pageOption), new TRequestOption());
  }

  public void send_reqMBMessageJob(int routeKey, int timeout, xueqiao.mailbox.thriftdata.req.QueryMBMessageJobOption option, org.soldier.platform.page.IndexedPageOption pageOption,TRequestOption requestOption) throws TException { 
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
        create_reqMBMessageJobServiceCall(routeKey, timeout, platformArgs, option, pageOption), requestOption);
  }

  public long reqMBMessageJob(int routeKey, int timeout, xueqiao.mailbox.thriftdata.req.QueryMBMessageJobOption option, org.soldier.platform.page.IndexedPageOption pageOption, IMethodCallback<MailboxWebapi.reqMBMessageJob_args, MailboxWebapi.reqMBMessageJob_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
            create_reqMBMessageJobServiceCall(routeKey, timeout, platformArgs, option, pageOption), callback);
  }

  public long add_reqMBMessageJobCall(AsyncCallRunner runner, int routeKey, int timeout, xueqiao.mailbox.thriftdata.req.QueryMBMessageJobOption option, org.soldier.platform.page.IndexedPageOption pageOption, IMethodCallback<MailboxWebapi.reqMBMessageJob_args, MailboxWebapi.reqMBMessageJob_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
            create_reqMBMessageJobServiceCall(routeKey, timeout, platformArgs, option, pageOption), callback);
  }

  protected TServiceCall create_reqMBMessageJobServiceCall(int routeKey, int timeout, org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, xueqiao.mailbox.thriftdata.req.QueryMBMessageJobOption option, org.soldier.platform.page.IndexedPageOption pageOption){
    TServiceCall serviceCall = new TServiceCall();
    if (!getPeerAddr().isEmpty()) {
      serviceCall.setChooseServiceIp(getPeerAddr());
    }
    if (getPeerPort() != 0) {
      serviceCall.setChooseServicePort(getPeerPort());
    }
    serviceCall.setServiceKey(MailboxWebapiVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    MailboxWebapi.reqMBMessageJob_args request = new MailboxWebapi.reqMBMessageJob_args();
    request.setPlatformArgs(platformArgs);
    request.setOption(option);
    request.setPageOption(pageOption);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("reqMBMessageJob");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(MailboxWebapi.reqMBMessageJob_result.class);
    return serviceCall;
  }

  public void send_addMBMessage(int routeKey, int timeout, xueqiao.mailbox.thriftdata.mb.MBMessage message) throws TException {
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
        create_addMBMessageServiceCall(routeKey, timeout, platformArgs, message), new TRequestOption());
  }

  public void send_addMBMessage(int routeKey, int timeout, xueqiao.mailbox.thriftdata.mb.MBMessage message,TRequestOption requestOption) throws TException { 
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
        create_addMBMessageServiceCall(routeKey, timeout, platformArgs, message), requestOption);
  }

  public long addMBMessage(int routeKey, int timeout, xueqiao.mailbox.thriftdata.mb.MBMessage message, IMethodCallback<MailboxWebapi.addMBMessage_args, MailboxWebapi.addMBMessage_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
            create_addMBMessageServiceCall(routeKey, timeout, platformArgs, message), callback);
  }

  public long add_addMBMessageCall(AsyncCallRunner runner, int routeKey, int timeout, xueqiao.mailbox.thriftdata.mb.MBMessage message, IMethodCallback<MailboxWebapi.addMBMessage_args, MailboxWebapi.addMBMessage_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
            create_addMBMessageServiceCall(routeKey, timeout, platformArgs, message), callback);
  }

  protected TServiceCall create_addMBMessageServiceCall(int routeKey, int timeout, org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, xueqiao.mailbox.thriftdata.mb.MBMessage message){
    TServiceCall serviceCall = new TServiceCall();
    if (!getPeerAddr().isEmpty()) {
      serviceCall.setChooseServiceIp(getPeerAddr());
    }
    if (getPeerPort() != 0) {
      serviceCall.setChooseServicePort(getPeerPort());
    }
    serviceCall.setServiceKey(MailboxWebapiVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    MailboxWebapi.addMBMessage_args request = new MailboxWebapi.addMBMessage_args();
    request.setPlatformArgs(platformArgs);
    request.setMessage(message);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("addMBMessage");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(MailboxWebapi.addMBMessage_result.class);
    return serviceCall;
  }

  public void send_reqCompanyReceiver(int routeKey, int timeout) throws TException {
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
        create_reqCompanyReceiverServiceCall(routeKey, timeout, platformArgs), new TRequestOption());
  }

  public void send_reqCompanyReceiver(int routeKey, int timeout,TRequestOption requestOption) throws TException { 
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
        create_reqCompanyReceiverServiceCall(routeKey, timeout, platformArgs), requestOption);
  }

  public long reqCompanyReceiver(int routeKey, int timeout, IMethodCallback<MailboxWebapi.reqCompanyReceiver_args, MailboxWebapi.reqCompanyReceiver_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
            create_reqCompanyReceiverServiceCall(routeKey, timeout, platformArgs), callback);
  }

  public long add_reqCompanyReceiverCall(AsyncCallRunner runner, int routeKey, int timeout, IMethodCallback<MailboxWebapi.reqCompanyReceiver_args, MailboxWebapi.reqCompanyReceiver_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
            create_reqCompanyReceiverServiceCall(routeKey, timeout, platformArgs), callback);
  }

  protected TServiceCall create_reqCompanyReceiverServiceCall(int routeKey, int timeout, org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs){
    TServiceCall serviceCall = new TServiceCall();
    if (!getPeerAddr().isEmpty()) {
      serviceCall.setChooseServiceIp(getPeerAddr());
    }
    if (getPeerPort() != 0) {
      serviceCall.setChooseServicePort(getPeerPort());
    }
    serviceCall.setServiceKey(MailboxWebapiVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    MailboxWebapi.reqCompanyReceiver_args request = new MailboxWebapi.reqCompanyReceiver_args();
    request.setPlatformArgs(platformArgs);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("reqCompanyReceiver");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(MailboxWebapi.reqCompanyReceiver_result.class);
    return serviceCall;
  }

  public void send_reqGroupReceiver(int routeKey, int timeout, long companyId) throws TException {
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
        create_reqGroupReceiverServiceCall(routeKey, timeout, platformArgs, companyId), new TRequestOption());
  }

  public void send_reqGroupReceiver(int routeKey, int timeout, long companyId,TRequestOption requestOption) throws TException { 
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
        create_reqGroupReceiverServiceCall(routeKey, timeout, platformArgs, companyId), requestOption);
  }

  public long reqGroupReceiver(int routeKey, int timeout, long companyId, IMethodCallback<MailboxWebapi.reqGroupReceiver_args, MailboxWebapi.reqGroupReceiver_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
            create_reqGroupReceiverServiceCall(routeKey, timeout, platformArgs, companyId), callback);
  }

  public long add_reqGroupReceiverCall(AsyncCallRunner runner, int routeKey, int timeout, long companyId, IMethodCallback<MailboxWebapi.reqGroupReceiver_args, MailboxWebapi.reqGroupReceiver_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
            create_reqGroupReceiverServiceCall(routeKey, timeout, platformArgs, companyId), callback);
  }

  protected TServiceCall create_reqGroupReceiverServiceCall(int routeKey, int timeout, org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, long companyId){
    TServiceCall serviceCall = new TServiceCall();
    if (!getPeerAddr().isEmpty()) {
      serviceCall.setChooseServiceIp(getPeerAddr());
    }
    if (getPeerPort() != 0) {
      serviceCall.setChooseServicePort(getPeerPort());
    }
    serviceCall.setServiceKey(MailboxWebapiVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    MailboxWebapi.reqGroupReceiver_args request = new MailboxWebapi.reqGroupReceiver_args();
    request.setPlatformArgs(platformArgs);
    request.setCompanyId(companyId);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("reqGroupReceiver");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(MailboxWebapi.reqGroupReceiver_result.class);
    return serviceCall;
  }

  public void send_reqContentText(int routeKey, int timeout, String fileName) throws TException {
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
        create_reqContentTextServiceCall(routeKey, timeout, platformArgs, fileName), new TRequestOption());
  }

  public void send_reqContentText(int routeKey, int timeout, String fileName,TRequestOption requestOption) throws TException { 
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
        create_reqContentTextServiceCall(routeKey, timeout, platformArgs, fileName), requestOption);
  }

  public long reqContentText(int routeKey, int timeout, String fileName, IMethodCallback<MailboxWebapi.reqContentText_args, MailboxWebapi.reqContentText_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
            create_reqContentTextServiceCall(routeKey, timeout, platformArgs, fileName), callback);
  }

  public long add_reqContentTextCall(AsyncCallRunner runner, int routeKey, int timeout, String fileName, IMethodCallback<MailboxWebapi.reqContentText_args, MailboxWebapi.reqContentText_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
            create_reqContentTextServiceCall(routeKey, timeout, platformArgs, fileName), callback);
  }

  protected TServiceCall create_reqContentTextServiceCall(int routeKey, int timeout, org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, String fileName){
    TServiceCall serviceCall = new TServiceCall();
    if (!getPeerAddr().isEmpty()) {
      serviceCall.setChooseServiceIp(getPeerAddr());
    }
    if (getPeerPort() != 0) {
      serviceCall.setChooseServicePort(getPeerPort());
    }
    serviceCall.setServiceKey(MailboxWebapiVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    MailboxWebapi.reqContentText_args request = new MailboxWebapi.reqContentText_args();
    request.setPlatformArgs(platformArgs);
    request.setFileName(fileName);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("reqContentText");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(MailboxWebapi.reqContentText_result.class);
    return serviceCall;
  }

  public void send_reqMBMessageTemplateSelector(int routeKey, int timeout) throws TException {
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
        create_reqMBMessageTemplateSelectorServiceCall(routeKey, timeout, platformArgs), new TRequestOption());
  }

  public void send_reqMBMessageTemplateSelector(int routeKey, int timeout,TRequestOption requestOption) throws TException { 
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
        create_reqMBMessageTemplateSelectorServiceCall(routeKey, timeout, platformArgs), requestOption);
  }

  public long reqMBMessageTemplateSelector(int routeKey, int timeout, IMethodCallback<MailboxWebapi.reqMBMessageTemplateSelector_args, MailboxWebapi.reqMBMessageTemplateSelector_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
            create_reqMBMessageTemplateSelectorServiceCall(routeKey, timeout, platformArgs), callback);
  }

  public long add_reqMBMessageTemplateSelectorCall(AsyncCallRunner runner, int routeKey, int timeout, IMethodCallback<MailboxWebapi.reqMBMessageTemplateSelector_args, MailboxWebapi.reqMBMessageTemplateSelector_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
            create_reqMBMessageTemplateSelectorServiceCall(routeKey, timeout, platformArgs), callback);
  }

  protected TServiceCall create_reqMBMessageTemplateSelectorServiceCall(int routeKey, int timeout, org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs){
    TServiceCall serviceCall = new TServiceCall();
    if (!getPeerAddr().isEmpty()) {
      serviceCall.setChooseServiceIp(getPeerAddr());
    }
    if (getPeerPort() != 0) {
      serviceCall.setChooseServicePort(getPeerPort());
    }
    serviceCall.setServiceKey(MailboxWebapiVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    MailboxWebapi.reqMBMessageTemplateSelector_args request = new MailboxWebapi.reqMBMessageTemplateSelector_args();
    request.setPlatformArgs(platformArgs);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("reqMBMessageTemplateSelector");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(MailboxWebapi.reqMBMessageTemplateSelector_result.class);
    return serviceCall;
  }

  public void send_reqMBMessage(int routeKey, int timeout, xueqiao.mailbox.thriftdata.req.QueryMBMessageOption queryOption, org.soldier.platform.page.IndexedPageOption pageOption) throws TException {
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
        create_reqMBMessageServiceCall(routeKey, timeout, platformArgs, queryOption, pageOption), new TRequestOption());
  }

  public void send_reqMBMessage(int routeKey, int timeout, xueqiao.mailbox.thriftdata.req.QueryMBMessageOption queryOption, org.soldier.platform.page.IndexedPageOption pageOption,TRequestOption requestOption) throws TException { 
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
        create_reqMBMessageServiceCall(routeKey, timeout, platformArgs, queryOption, pageOption), requestOption);
  }

  public long reqMBMessage(int routeKey, int timeout, xueqiao.mailbox.thriftdata.req.QueryMBMessageOption queryOption, org.soldier.platform.page.IndexedPageOption pageOption, IMethodCallback<MailboxWebapi.reqMBMessage_args, MailboxWebapi.reqMBMessage_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
            create_reqMBMessageServiceCall(routeKey, timeout, platformArgs, queryOption, pageOption), callback);
  }

  public long add_reqMBMessageCall(AsyncCallRunner runner, int routeKey, int timeout, xueqiao.mailbox.thriftdata.req.QueryMBMessageOption queryOption, org.soldier.platform.page.IndexedPageOption pageOption, IMethodCallback<MailboxWebapi.reqMBMessage_args, MailboxWebapi.reqMBMessage_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
            create_reqMBMessageServiceCall(routeKey, timeout, platformArgs, queryOption, pageOption), callback);
  }

  protected TServiceCall create_reqMBMessageServiceCall(int routeKey, int timeout, org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, xueqiao.mailbox.thriftdata.req.QueryMBMessageOption queryOption, org.soldier.platform.page.IndexedPageOption pageOption){
    TServiceCall serviceCall = new TServiceCall();
    if (!getPeerAddr().isEmpty()) {
      serviceCall.setChooseServiceIp(getPeerAddr());
    }
    if (getPeerPort() != 0) {
      serviceCall.setChooseServicePort(getPeerPort());
    }
    serviceCall.setServiceKey(MailboxWebapiVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    MailboxWebapi.reqMBMessage_args request = new MailboxWebapi.reqMBMessage_args();
    request.setPlatformArgs(platformArgs);
    request.setQueryOption(queryOption);
    request.setPageOption(pageOption);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("reqMBMessage");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(MailboxWebapi.reqMBMessage_result.class);
    return serviceCall;
  }

  public void send_updateMessageJobStatus(int routeKey, int timeout, long messageJobId, xueqiao.mailbox.thriftdata.mb.MJStatus status) throws TException {
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
        create_updateMessageJobStatusServiceCall(routeKey, timeout, platformArgs, messageJobId, status), new TRequestOption());
  }

  public void send_updateMessageJobStatus(int routeKey, int timeout, long messageJobId, xueqiao.mailbox.thriftdata.mb.MJStatus status,TRequestOption requestOption) throws TException { 
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
        create_updateMessageJobStatusServiceCall(routeKey, timeout, platformArgs, messageJobId, status), requestOption);
  }

  public long updateMessageJobStatus(int routeKey, int timeout, long messageJobId, xueqiao.mailbox.thriftdata.mb.MJStatus status, IMethodCallback<MailboxWebapi.updateMessageJobStatus_args, MailboxWebapi.updateMessageJobStatus_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
            create_updateMessageJobStatusServiceCall(routeKey, timeout, platformArgs, messageJobId, status), callback);
  }

  public long add_updateMessageJobStatusCall(AsyncCallRunner runner, int routeKey, int timeout, long messageJobId, xueqiao.mailbox.thriftdata.mb.MJStatus status, IMethodCallback<MailboxWebapi.updateMessageJobStatus_args, MailboxWebapi.updateMessageJobStatus_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
            create_updateMessageJobStatusServiceCall(routeKey, timeout, platformArgs, messageJobId, status), callback);
  }

  protected TServiceCall create_updateMessageJobStatusServiceCall(int routeKey, int timeout, org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, long messageJobId, xueqiao.mailbox.thriftdata.mb.MJStatus status){
    TServiceCall serviceCall = new TServiceCall();
    if (!getPeerAddr().isEmpty()) {
      serviceCall.setChooseServiceIp(getPeerAddr());
    }
    if (getPeerPort() != 0) {
      serviceCall.setChooseServicePort(getPeerPort());
    }
    serviceCall.setServiceKey(MailboxWebapiVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    MailboxWebapi.updateMessageJobStatus_args request = new MailboxWebapi.updateMessageJobStatus_args();
    request.setPlatformArgs(platformArgs);
    request.setMessageJobId(messageJobId);
    request.setStatus(status);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("updateMessageJobStatus");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(MailboxWebapi.updateMessageJobStatus_result.class);
    return serviceCall;
  }

}
