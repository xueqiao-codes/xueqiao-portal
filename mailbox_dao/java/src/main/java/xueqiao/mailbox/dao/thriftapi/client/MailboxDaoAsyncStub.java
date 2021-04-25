package xueqiao.mailbox.dao.thriftapi.client;

import xueqiao.mailbox.dao.thriftapi.MailboxDao;
import xueqiao.mailbox.dao.thriftapi.MailboxDaoVariable;
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

public class MailboxDaoAsyncStub extends BaseStub { 
  public MailboxDaoAsyncStub() {
    super(MailboxDaoVariable.serviceKey);
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

  public long addMBMessage(int routeKey, int timeout, xueqiao.mailbox.thriftdata.mb.MBMessage message, IMethodCallback<MailboxDao.addMBMessage_args, MailboxDao.addMBMessage_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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

  public long add_addMBMessageCall(AsyncCallRunner runner, int routeKey, int timeout, xueqiao.mailbox.thriftdata.mb.MBMessage message, IMethodCallback<MailboxDao.addMBMessage_args, MailboxDao.addMBMessage_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
    serviceCall.setServiceKey(MailboxDaoVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    MailboxDao.addMBMessage_args request = new MailboxDao.addMBMessage_args();
    request.setPlatformArgs(platformArgs);
    request.setMessage(message);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("addMBMessage");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(MailboxDao.addMBMessage_result.class);
    return serviceCall;
  }

  public void send_modifyMBMessageStatus(int routeKey, int timeout, long mbmId, xueqiao.mailbox.thriftdata.mb.MStatus status) throws TException {
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
        create_modifyMBMessageStatusServiceCall(routeKey, timeout, platformArgs, mbmId, status), new TRequestOption());
  }

  public void send_modifyMBMessageStatus(int routeKey, int timeout, long mbmId, xueqiao.mailbox.thriftdata.mb.MStatus status,TRequestOption requestOption) throws TException { 
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
        create_modifyMBMessageStatusServiceCall(routeKey, timeout, platformArgs, mbmId, status), requestOption);
  }

  public long modifyMBMessageStatus(int routeKey, int timeout, long mbmId, xueqiao.mailbox.thriftdata.mb.MStatus status, IMethodCallback<MailboxDao.modifyMBMessageStatus_args, MailboxDao.modifyMBMessageStatus_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
            create_modifyMBMessageStatusServiceCall(routeKey, timeout, platformArgs, mbmId, status), callback);
  }

  public long add_modifyMBMessageStatusCall(AsyncCallRunner runner, int routeKey, int timeout, long mbmId, xueqiao.mailbox.thriftdata.mb.MStatus status, IMethodCallback<MailboxDao.modifyMBMessageStatus_args, MailboxDao.modifyMBMessageStatus_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
            create_modifyMBMessageStatusServiceCall(routeKey, timeout, platformArgs, mbmId, status), callback);
  }

  protected TServiceCall create_modifyMBMessageStatusServiceCall(int routeKey, int timeout, org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, long mbmId, xueqiao.mailbox.thriftdata.mb.MStatus status){
    TServiceCall serviceCall = new TServiceCall();
    if (!getPeerAddr().isEmpty()) {
      serviceCall.setChooseServiceIp(getPeerAddr());
    }
    if (getPeerPort() != 0) {
      serviceCall.setChooseServicePort(getPeerPort());
    }
    serviceCall.setServiceKey(MailboxDaoVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    MailboxDao.modifyMBMessageStatus_args request = new MailboxDao.modifyMBMessageStatus_args();
    request.setPlatformArgs(platformArgs);
    request.setMbmId(mbmId);
    request.setStatus(status);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("modifyMBMessageStatus");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(MailboxDao.modifyMBMessageStatus_result.class);
    return serviceCall;
  }

  public void send_queryMBMessagePage(int routeKey, int timeout, xueqiao.mailbox.thriftdata.req.QueryMBMessageOption queryOption, org.soldier.platform.page.IndexedPageOption pageOption) throws TException {
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
        create_queryMBMessagePageServiceCall(routeKey, timeout, platformArgs, queryOption, pageOption), new TRequestOption());
  }

  public void send_queryMBMessagePage(int routeKey, int timeout, xueqiao.mailbox.thriftdata.req.QueryMBMessageOption queryOption, org.soldier.platform.page.IndexedPageOption pageOption,TRequestOption requestOption) throws TException { 
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
        create_queryMBMessagePageServiceCall(routeKey, timeout, platformArgs, queryOption, pageOption), requestOption);
  }

  public long queryMBMessagePage(int routeKey, int timeout, xueqiao.mailbox.thriftdata.req.QueryMBMessageOption queryOption, org.soldier.platform.page.IndexedPageOption pageOption, IMethodCallback<MailboxDao.queryMBMessagePage_args, MailboxDao.queryMBMessagePage_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
            create_queryMBMessagePageServiceCall(routeKey, timeout, platformArgs, queryOption, pageOption), callback);
  }

  public long add_queryMBMessagePageCall(AsyncCallRunner runner, int routeKey, int timeout, xueqiao.mailbox.thriftdata.req.QueryMBMessageOption queryOption, org.soldier.platform.page.IndexedPageOption pageOption, IMethodCallback<MailboxDao.queryMBMessagePage_args, MailboxDao.queryMBMessagePage_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
            create_queryMBMessagePageServiceCall(routeKey, timeout, platformArgs, queryOption, pageOption), callback);
  }

  protected TServiceCall create_queryMBMessagePageServiceCall(int routeKey, int timeout, org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, xueqiao.mailbox.thriftdata.req.QueryMBMessageOption queryOption, org.soldier.platform.page.IndexedPageOption pageOption){
    TServiceCall serviceCall = new TServiceCall();
    if (!getPeerAddr().isEmpty()) {
      serviceCall.setChooseServiceIp(getPeerAddr());
    }
    if (getPeerPort() != 0) {
      serviceCall.setChooseServicePort(getPeerPort());
    }
    serviceCall.setServiceKey(MailboxDaoVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    MailboxDao.queryMBMessagePage_args request = new MailboxDao.queryMBMessagePage_args();
    request.setPlatformArgs(platformArgs);
    request.setQueryOption(queryOption);
    request.setPageOption(pageOption);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("queryMBMessagePage");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(MailboxDao.queryMBMessagePage_result.class);
    return serviceCall;
  }

  public void send_addMBMessageTemplate(int routeKey, int timeout, xueqiao.mailbox.thriftdata.mb.MBMessageTemplate template) throws TException {
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
        create_addMBMessageTemplateServiceCall(routeKey, timeout, platformArgs, template), new TRequestOption());
  }

  public void send_addMBMessageTemplate(int routeKey, int timeout, xueqiao.mailbox.thriftdata.mb.MBMessageTemplate template,TRequestOption requestOption) throws TException { 
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
        create_addMBMessageTemplateServiceCall(routeKey, timeout, platformArgs, template), requestOption);
  }

  public long addMBMessageTemplate(int routeKey, int timeout, xueqiao.mailbox.thriftdata.mb.MBMessageTemplate template, IMethodCallback<MailboxDao.addMBMessageTemplate_args, MailboxDao.addMBMessageTemplate_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
            create_addMBMessageTemplateServiceCall(routeKey, timeout, platformArgs, template), callback);
  }

  public long add_addMBMessageTemplateCall(AsyncCallRunner runner, int routeKey, int timeout, xueqiao.mailbox.thriftdata.mb.MBMessageTemplate template, IMethodCallback<MailboxDao.addMBMessageTemplate_args, MailboxDao.addMBMessageTemplate_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
            create_addMBMessageTemplateServiceCall(routeKey, timeout, platformArgs, template), callback);
  }

  protected TServiceCall create_addMBMessageTemplateServiceCall(int routeKey, int timeout, org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, xueqiao.mailbox.thriftdata.mb.MBMessageTemplate template){
    TServiceCall serviceCall = new TServiceCall();
    if (!getPeerAddr().isEmpty()) {
      serviceCall.setChooseServiceIp(getPeerAddr());
    }
    if (getPeerPort() != 0) {
      serviceCall.setChooseServicePort(getPeerPort());
    }
    serviceCall.setServiceKey(MailboxDaoVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    MailboxDao.addMBMessageTemplate_args request = new MailboxDao.addMBMessageTemplate_args();
    request.setPlatformArgs(platformArgs);
    request.setTemplate(template);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("addMBMessageTemplate");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(MailboxDao.addMBMessageTemplate_result.class);
    return serviceCall;
  }

  public void send_modifyMBMessageTemplate(int routeKey, int timeout, xueqiao.mailbox.thriftdata.mb.MBMessageTemplate template) throws TException {
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
        create_modifyMBMessageTemplateServiceCall(routeKey, timeout, platformArgs, template), new TRequestOption());
  }

  public void send_modifyMBMessageTemplate(int routeKey, int timeout, xueqiao.mailbox.thriftdata.mb.MBMessageTemplate template,TRequestOption requestOption) throws TException { 
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
        create_modifyMBMessageTemplateServiceCall(routeKey, timeout, platformArgs, template), requestOption);
  }

  public long modifyMBMessageTemplate(int routeKey, int timeout, xueqiao.mailbox.thriftdata.mb.MBMessageTemplate template, IMethodCallback<MailboxDao.modifyMBMessageTemplate_args, MailboxDao.modifyMBMessageTemplate_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
            create_modifyMBMessageTemplateServiceCall(routeKey, timeout, platformArgs, template), callback);
  }

  public long add_modifyMBMessageTemplateCall(AsyncCallRunner runner, int routeKey, int timeout, xueqiao.mailbox.thriftdata.mb.MBMessageTemplate template, IMethodCallback<MailboxDao.modifyMBMessageTemplate_args, MailboxDao.modifyMBMessageTemplate_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
            create_modifyMBMessageTemplateServiceCall(routeKey, timeout, platformArgs, template), callback);
  }

  protected TServiceCall create_modifyMBMessageTemplateServiceCall(int routeKey, int timeout, org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, xueqiao.mailbox.thriftdata.mb.MBMessageTemplate template){
    TServiceCall serviceCall = new TServiceCall();
    if (!getPeerAddr().isEmpty()) {
      serviceCall.setChooseServiceIp(getPeerAddr());
    }
    if (getPeerPort() != 0) {
      serviceCall.setChooseServicePort(getPeerPort());
    }
    serviceCall.setServiceKey(MailboxDaoVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    MailboxDao.modifyMBMessageTemplate_args request = new MailboxDao.modifyMBMessageTemplate_args();
    request.setPlatformArgs(platformArgs);
    request.setTemplate(template);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("modifyMBMessageTemplate");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(MailboxDao.modifyMBMessageTemplate_result.class);
    return serviceCall;
  }

  public void send_deleteMBMessageTemplate(int routeKey, int timeout, long templateId) throws TException {
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
        create_deleteMBMessageTemplateServiceCall(routeKey, timeout, platformArgs, templateId), new TRequestOption());
  }

  public void send_deleteMBMessageTemplate(int routeKey, int timeout, long templateId,TRequestOption requestOption) throws TException { 
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
        create_deleteMBMessageTemplateServiceCall(routeKey, timeout, platformArgs, templateId), requestOption);
  }

  public long deleteMBMessageTemplate(int routeKey, int timeout, long templateId, IMethodCallback<MailboxDao.deleteMBMessageTemplate_args, MailboxDao.deleteMBMessageTemplate_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
            create_deleteMBMessageTemplateServiceCall(routeKey, timeout, platformArgs, templateId), callback);
  }

  public long add_deleteMBMessageTemplateCall(AsyncCallRunner runner, int routeKey, int timeout, long templateId, IMethodCallback<MailboxDao.deleteMBMessageTemplate_args, MailboxDao.deleteMBMessageTemplate_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
            create_deleteMBMessageTemplateServiceCall(routeKey, timeout, platformArgs, templateId), callback);
  }

  protected TServiceCall create_deleteMBMessageTemplateServiceCall(int routeKey, int timeout, org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, long templateId){
    TServiceCall serviceCall = new TServiceCall();
    if (!getPeerAddr().isEmpty()) {
      serviceCall.setChooseServiceIp(getPeerAddr());
    }
    if (getPeerPort() != 0) {
      serviceCall.setChooseServicePort(getPeerPort());
    }
    serviceCall.setServiceKey(MailboxDaoVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    MailboxDao.deleteMBMessageTemplate_args request = new MailboxDao.deleteMBMessageTemplate_args();
    request.setPlatformArgs(platformArgs);
    request.setTemplateId(templateId);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("deleteMBMessageTemplate");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(MailboxDao.deleteMBMessageTemplate_result.class);
    return serviceCall;
  }

  public void send_queryMBMessageTemplatePage(int routeKey, int timeout, xueqiao.mailbox.thriftdata.req.QueryMBMessageTemplateOption queryOption, org.soldier.platform.page.IndexedPageOption pageOption) throws TException {
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
        create_queryMBMessageTemplatePageServiceCall(routeKey, timeout, platformArgs, queryOption, pageOption), new TRequestOption());
  }

  public void send_queryMBMessageTemplatePage(int routeKey, int timeout, xueqiao.mailbox.thriftdata.req.QueryMBMessageTemplateOption queryOption, org.soldier.platform.page.IndexedPageOption pageOption,TRequestOption requestOption) throws TException { 
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
        create_queryMBMessageTemplatePageServiceCall(routeKey, timeout, platformArgs, queryOption, pageOption), requestOption);
  }

  public long queryMBMessageTemplatePage(int routeKey, int timeout, xueqiao.mailbox.thriftdata.req.QueryMBMessageTemplateOption queryOption, org.soldier.platform.page.IndexedPageOption pageOption, IMethodCallback<MailboxDao.queryMBMessageTemplatePage_args, MailboxDao.queryMBMessageTemplatePage_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
            create_queryMBMessageTemplatePageServiceCall(routeKey, timeout, platformArgs, queryOption, pageOption), callback);
  }

  public long add_queryMBMessageTemplatePageCall(AsyncCallRunner runner, int routeKey, int timeout, xueqiao.mailbox.thriftdata.req.QueryMBMessageTemplateOption queryOption, org.soldier.platform.page.IndexedPageOption pageOption, IMethodCallback<MailboxDao.queryMBMessageTemplatePage_args, MailboxDao.queryMBMessageTemplatePage_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
            create_queryMBMessageTemplatePageServiceCall(routeKey, timeout, platformArgs, queryOption, pageOption), callback);
  }

  protected TServiceCall create_queryMBMessageTemplatePageServiceCall(int routeKey, int timeout, org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, xueqiao.mailbox.thriftdata.req.QueryMBMessageTemplateOption queryOption, org.soldier.platform.page.IndexedPageOption pageOption){
    TServiceCall serviceCall = new TServiceCall();
    if (!getPeerAddr().isEmpty()) {
      serviceCall.setChooseServiceIp(getPeerAddr());
    }
    if (getPeerPort() != 0) {
      serviceCall.setChooseServicePort(getPeerPort());
    }
    serviceCall.setServiceKey(MailboxDaoVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    MailboxDao.queryMBMessageTemplatePage_args request = new MailboxDao.queryMBMessageTemplatePage_args();
    request.setPlatformArgs(platformArgs);
    request.setQueryOption(queryOption);
    request.setPageOption(pageOption);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("queryMBMessageTemplatePage");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(MailboxDao.queryMBMessageTemplatePage_result.class);
    return serviceCall;
  }

  public void send_startSendMBMessage(int routeKey, int timeout, long mbmId, boolean isMessageCompleted) throws TException {
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
        create_startSendMBMessageServiceCall(routeKey, timeout, platformArgs, mbmId, isMessageCompleted), new TRequestOption());
  }

  public void send_startSendMBMessage(int routeKey, int timeout, long mbmId, boolean isMessageCompleted,TRequestOption requestOption) throws TException { 
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
        create_startSendMBMessageServiceCall(routeKey, timeout, platformArgs, mbmId, isMessageCompleted), requestOption);
  }

  public long startSendMBMessage(int routeKey, int timeout, long mbmId, boolean isMessageCompleted, IMethodCallback<MailboxDao.startSendMBMessage_args, MailboxDao.startSendMBMessage_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
            create_startSendMBMessageServiceCall(routeKey, timeout, platformArgs, mbmId, isMessageCompleted), callback);
  }

  public long add_startSendMBMessageCall(AsyncCallRunner runner, int routeKey, int timeout, long mbmId, boolean isMessageCompleted, IMethodCallback<MailboxDao.startSendMBMessage_args, MailboxDao.startSendMBMessage_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
            create_startSendMBMessageServiceCall(routeKey, timeout, platformArgs, mbmId, isMessageCompleted), callback);
  }

  protected TServiceCall create_startSendMBMessageServiceCall(int routeKey, int timeout, org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, long mbmId, boolean isMessageCompleted){
    TServiceCall serviceCall = new TServiceCall();
    if (!getPeerAddr().isEmpty()) {
      serviceCall.setChooseServiceIp(getPeerAddr());
    }
    if (getPeerPort() != 0) {
      serviceCall.setChooseServicePort(getPeerPort());
    }
    serviceCall.setServiceKey(MailboxDaoVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    MailboxDao.startSendMBMessage_args request = new MailboxDao.startSendMBMessage_args();
    request.setPlatformArgs(platformArgs);
    request.setMbmId(mbmId);
    request.setIsMessageCompleted(isMessageCompleted);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("startSendMBMessage");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(MailboxDao.startSendMBMessage_result.class);
    return serviceCall;
  }

  public void send_modifyMBMessageJobStatus(int routeKey, int timeout, long jobId, xueqiao.mailbox.thriftdata.mb.MJStatus status, String errorDescription) throws TException {
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
        create_modifyMBMessageJobStatusServiceCall(routeKey, timeout, platformArgs, jobId, status, errorDescription), new TRequestOption());
  }

  public void send_modifyMBMessageJobStatus(int routeKey, int timeout, long jobId, xueqiao.mailbox.thriftdata.mb.MJStatus status, String errorDescription,TRequestOption requestOption) throws TException { 
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
        create_modifyMBMessageJobStatusServiceCall(routeKey, timeout, platformArgs, jobId, status, errorDescription), requestOption);
  }

  public long modifyMBMessageJobStatus(int routeKey, int timeout, long jobId, xueqiao.mailbox.thriftdata.mb.MJStatus status, String errorDescription, IMethodCallback<MailboxDao.modifyMBMessageJobStatus_args, MailboxDao.modifyMBMessageJobStatus_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
            create_modifyMBMessageJobStatusServiceCall(routeKey, timeout, platformArgs, jobId, status, errorDescription), callback);
  }

  public long add_modifyMBMessageJobStatusCall(AsyncCallRunner runner, int routeKey, int timeout, long jobId, xueqiao.mailbox.thriftdata.mb.MJStatus status, String errorDescription, IMethodCallback<MailboxDao.modifyMBMessageJobStatus_args, MailboxDao.modifyMBMessageJobStatus_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
            create_modifyMBMessageJobStatusServiceCall(routeKey, timeout, platformArgs, jobId, status, errorDescription), callback);
  }

  protected TServiceCall create_modifyMBMessageJobStatusServiceCall(int routeKey, int timeout, org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, long jobId, xueqiao.mailbox.thriftdata.mb.MJStatus status, String errorDescription){
    TServiceCall serviceCall = new TServiceCall();
    if (!getPeerAddr().isEmpty()) {
      serviceCall.setChooseServiceIp(getPeerAddr());
    }
    if (getPeerPort() != 0) {
      serviceCall.setChooseServicePort(getPeerPort());
    }
    serviceCall.setServiceKey(MailboxDaoVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    MailboxDao.modifyMBMessageJobStatus_args request = new MailboxDao.modifyMBMessageJobStatus_args();
    request.setPlatformArgs(platformArgs);
    request.setJobId(jobId);
    request.setStatus(status);
    request.setErrorDescription(errorDescription);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("modifyMBMessageJobStatus");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(MailboxDao.modifyMBMessageJobStatus_result.class);
    return serviceCall;
  }

  public void send_queryMBMessageJobPage(int routeKey, int timeout, xueqiao.mailbox.thriftdata.req.QueryMBMessageJobOption queryOption, org.soldier.platform.page.IndexedPageOption pageOption) throws TException {
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
        create_queryMBMessageJobPageServiceCall(routeKey, timeout, platformArgs, queryOption, pageOption), new TRequestOption());
  }

  public void send_queryMBMessageJobPage(int routeKey, int timeout, xueqiao.mailbox.thriftdata.req.QueryMBMessageJobOption queryOption, org.soldier.platform.page.IndexedPageOption pageOption,TRequestOption requestOption) throws TException { 
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
        create_queryMBMessageJobPageServiceCall(routeKey, timeout, platformArgs, queryOption, pageOption), requestOption);
  }

  public long queryMBMessageJobPage(int routeKey, int timeout, xueqiao.mailbox.thriftdata.req.QueryMBMessageJobOption queryOption, org.soldier.platform.page.IndexedPageOption pageOption, IMethodCallback<MailboxDao.queryMBMessageJobPage_args, MailboxDao.queryMBMessageJobPage_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
            create_queryMBMessageJobPageServiceCall(routeKey, timeout, platformArgs, queryOption, pageOption), callback);
  }

  public long add_queryMBMessageJobPageCall(AsyncCallRunner runner, int routeKey, int timeout, xueqiao.mailbox.thriftdata.req.QueryMBMessageJobOption queryOption, org.soldier.platform.page.IndexedPageOption pageOption, IMethodCallback<MailboxDao.queryMBMessageJobPage_args, MailboxDao.queryMBMessageJobPage_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
            create_queryMBMessageJobPageServiceCall(routeKey, timeout, platformArgs, queryOption, pageOption), callback);
  }

  protected TServiceCall create_queryMBMessageJobPageServiceCall(int routeKey, int timeout, org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, xueqiao.mailbox.thriftdata.req.QueryMBMessageJobOption queryOption, org.soldier.platform.page.IndexedPageOption pageOption){
    TServiceCall serviceCall = new TServiceCall();
    if (!getPeerAddr().isEmpty()) {
      serviceCall.setChooseServiceIp(getPeerAddr());
    }
    if (getPeerPort() != 0) {
      serviceCall.setChooseServicePort(getPeerPort());
    }
    serviceCall.setServiceKey(MailboxDaoVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    MailboxDao.queryMBMessageJobPage_args request = new MailboxDao.queryMBMessageJobPage_args();
    request.setPlatformArgs(platformArgs);
    request.setQueryOption(queryOption);
    request.setPageOption(pageOption);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("queryMBMessageJobPage");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(MailboxDao.queryMBMessageJobPage_result.class);
    return serviceCall;
  }

}
