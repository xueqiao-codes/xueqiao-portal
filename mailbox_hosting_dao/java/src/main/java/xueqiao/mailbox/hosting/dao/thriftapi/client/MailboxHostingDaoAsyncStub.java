package xueqiao.mailbox.hosting.dao.thriftapi.client;

import xueqiao.mailbox.hosting.dao.thriftapi.MailboxHostingDao;
import xueqiao.mailbox.hosting.dao.thriftapi.MailboxHostingDaoVariable;
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

public class MailboxHostingDaoAsyncStub extends BaseStub { 
  public MailboxHostingDaoAsyncStub() {
    super(MailboxHostingDaoVariable.serviceKey);
  }
  public void send_addHostingMessage(int routeKey, int timeout, List<xueqiao.mailbox.hosting.thriftapi.HostingMessage> hostingMessages) throws TException {
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
        create_addHostingMessageServiceCall(routeKey, timeout, platformArgs, hostingMessages), new TRequestOption());
  }

  public void send_addHostingMessage(int routeKey, int timeout, List<xueqiao.mailbox.hosting.thriftapi.HostingMessage> hostingMessages,TRequestOption requestOption) throws TException { 
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
        create_addHostingMessageServiceCall(routeKey, timeout, platformArgs, hostingMessages), requestOption);
  }

  public long addHostingMessage(int routeKey, int timeout, List<xueqiao.mailbox.hosting.thriftapi.HostingMessage> hostingMessages, IMethodCallback<MailboxHostingDao.addHostingMessage_args, MailboxHostingDao.addHostingMessage_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
            create_addHostingMessageServiceCall(routeKey, timeout, platformArgs, hostingMessages), callback);
  }

  public long add_addHostingMessageCall(AsyncCallRunner runner, int routeKey, int timeout, List<xueqiao.mailbox.hosting.thriftapi.HostingMessage> hostingMessages, IMethodCallback<MailboxHostingDao.addHostingMessage_args, MailboxHostingDao.addHostingMessage_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
            create_addHostingMessageServiceCall(routeKey, timeout, platformArgs, hostingMessages), callback);
  }

  protected TServiceCall create_addHostingMessageServiceCall(int routeKey, int timeout, org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, List<xueqiao.mailbox.hosting.thriftapi.HostingMessage> hostingMessages){
    TServiceCall serviceCall = new TServiceCall();
    if (!getPeerAddr().isEmpty()) {
      serviceCall.setChooseServiceIp(getPeerAddr());
    }
    if (getPeerPort() != 0) {
      serviceCall.setChooseServicePort(getPeerPort());
    }
    serviceCall.setServiceKey(MailboxHostingDaoVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    MailboxHostingDao.addHostingMessage_args request = new MailboxHostingDao.addHostingMessage_args();
    request.setPlatformArgs(platformArgs);
    request.setHostingMessages(hostingMessages);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("addHostingMessage");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(MailboxHostingDao.addHostingMessage_result.class);
    return serviceCall;
  }

  public void send_reqHostingMessage(int routeKey, int timeout, xueqiao.mailbox.hosting.thriftapi.ReqHostingMessageOption option, org.soldier.platform.page.IndexedPageOption pageOption) throws TException {
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
        create_reqHostingMessageServiceCall(routeKey, timeout, platformArgs, option, pageOption), new TRequestOption());
  }

  public void send_reqHostingMessage(int routeKey, int timeout, xueqiao.mailbox.hosting.thriftapi.ReqHostingMessageOption option, org.soldier.platform.page.IndexedPageOption pageOption,TRequestOption requestOption) throws TException { 
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
        create_reqHostingMessageServiceCall(routeKey, timeout, platformArgs, option, pageOption), requestOption);
  }

  public long reqHostingMessage(int routeKey, int timeout, xueqiao.mailbox.hosting.thriftapi.ReqHostingMessageOption option, org.soldier.platform.page.IndexedPageOption pageOption, IMethodCallback<MailboxHostingDao.reqHostingMessage_args, MailboxHostingDao.reqHostingMessage_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
            create_reqHostingMessageServiceCall(routeKey, timeout, platformArgs, option, pageOption), callback);
  }

  public long add_reqHostingMessageCall(AsyncCallRunner runner, int routeKey, int timeout, xueqiao.mailbox.hosting.thriftapi.ReqHostingMessageOption option, org.soldier.platform.page.IndexedPageOption pageOption, IMethodCallback<MailboxHostingDao.reqHostingMessage_args, MailboxHostingDao.reqHostingMessage_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
            create_reqHostingMessageServiceCall(routeKey, timeout, platformArgs, option, pageOption), callback);
  }

  protected TServiceCall create_reqHostingMessageServiceCall(int routeKey, int timeout, org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, xueqiao.mailbox.hosting.thriftapi.ReqHostingMessageOption option, org.soldier.platform.page.IndexedPageOption pageOption){
    TServiceCall serviceCall = new TServiceCall();
    if (!getPeerAddr().isEmpty()) {
      serviceCall.setChooseServiceIp(getPeerAddr());
    }
    if (getPeerPort() != 0) {
      serviceCall.setChooseServicePort(getPeerPort());
    }
    serviceCall.setServiceKey(MailboxHostingDaoVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    MailboxHostingDao.reqHostingMessage_args request = new MailboxHostingDao.reqHostingMessage_args();
    request.setPlatformArgs(platformArgs);
    request.setOption(option);
    request.setPageOption(pageOption);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("reqHostingMessage");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(MailboxHostingDao.reqHostingMessage_result.class);
    return serviceCall;
  }

  public void send_markAsRead(int routeKey, int timeout, xueqiao.mailbox.hosting.thriftapi.MarkReadOption option) throws TException {
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
        create_markAsReadServiceCall(routeKey, timeout, platformArgs, option), new TRequestOption());
  }

  public void send_markAsRead(int routeKey, int timeout, xueqiao.mailbox.hosting.thriftapi.MarkReadOption option,TRequestOption requestOption) throws TException { 
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
        create_markAsReadServiceCall(routeKey, timeout, platformArgs, option), requestOption);
  }

  public long markAsRead(int routeKey, int timeout, xueqiao.mailbox.hosting.thriftapi.MarkReadOption option, IMethodCallback<MailboxHostingDao.markAsRead_args, MailboxHostingDao.markAsRead_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
            create_markAsReadServiceCall(routeKey, timeout, platformArgs, option), callback);
  }

  public long add_markAsReadCall(AsyncCallRunner runner, int routeKey, int timeout, xueqiao.mailbox.hosting.thriftapi.MarkReadOption option, IMethodCallback<MailboxHostingDao.markAsRead_args, MailboxHostingDao.markAsRead_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
            create_markAsReadServiceCall(routeKey, timeout, platformArgs, option), callback);
  }

  protected TServiceCall create_markAsReadServiceCall(int routeKey, int timeout, org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, xueqiao.mailbox.hosting.thriftapi.MarkReadOption option){
    TServiceCall serviceCall = new TServiceCall();
    if (!getPeerAddr().isEmpty()) {
      serviceCall.setChooseServiceIp(getPeerAddr());
    }
    if (getPeerPort() != 0) {
      serviceCall.setChooseServicePort(getPeerPort());
    }
    serviceCall.setServiceKey(MailboxHostingDaoVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    MailboxHostingDao.markAsRead_args request = new MailboxHostingDao.markAsRead_args();
    request.setPlatformArgs(platformArgs);
    request.setOption(option);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("markAsRead");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(MailboxHostingDao.markAsRead_result.class);
    return serviceCall;
  }

}
