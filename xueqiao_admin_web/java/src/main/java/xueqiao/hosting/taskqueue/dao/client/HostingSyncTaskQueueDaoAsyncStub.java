package xueqiao.hosting.taskqueue.dao.client;

import xueqiao.hosting.taskqueue.dao.HostingSyncTaskQueueDao;
import xueqiao.hosting.taskqueue.dao.HostingSyncTaskQueueDaoVariable;
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

public class HostingSyncTaskQueueDaoAsyncStub extends BaseStub { 
  public HostingSyncTaskQueueDaoAsyncStub() {
    super(HostingSyncTaskQueueDaoVariable.serviceKey);
  }
  public void send_addSyncTaskQueue(int routeKey, int timeout, xueqiao.hosting.taskqueue.TSyncTaskQueue taskQueue) throws TException {
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
        create_addSyncTaskQueueServiceCall(routeKey, timeout, platformArgs, taskQueue), new TRequestOption());
  }

  public void send_addSyncTaskQueue(int routeKey, int timeout, xueqiao.hosting.taskqueue.TSyncTaskQueue taskQueue,TRequestOption requestOption) throws TException { 
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
        create_addSyncTaskQueueServiceCall(routeKey, timeout, platformArgs, taskQueue), requestOption);
  }

  public long addSyncTaskQueue(int routeKey, int timeout, xueqiao.hosting.taskqueue.TSyncTaskQueue taskQueue, IMethodCallback<HostingSyncTaskQueueDao.addSyncTaskQueue_args, HostingSyncTaskQueueDao.addSyncTaskQueue_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
            create_addSyncTaskQueueServiceCall(routeKey, timeout, platformArgs, taskQueue), callback);
  }

  public long add_addSyncTaskQueueCall(AsyncCallRunner runner, int routeKey, int timeout, xueqiao.hosting.taskqueue.TSyncTaskQueue taskQueue, IMethodCallback<HostingSyncTaskQueueDao.addSyncTaskQueue_args, HostingSyncTaskQueueDao.addSyncTaskQueue_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
            create_addSyncTaskQueueServiceCall(routeKey, timeout, platformArgs, taskQueue), callback);
  }

  protected TServiceCall create_addSyncTaskQueueServiceCall(int routeKey, int timeout, org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, xueqiao.hosting.taskqueue.TSyncTaskQueue taskQueue){
    TServiceCall serviceCall = new TServiceCall();
    if (!getPeerAddr().isEmpty()) {
      serviceCall.setChooseServiceIp(getPeerAddr());
    }
    if (getPeerPort() != 0) {
      serviceCall.setChooseServicePort(getPeerPort());
    }
    serviceCall.setServiceKey(HostingSyncTaskQueueDaoVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    HostingSyncTaskQueueDao.addSyncTaskQueue_args request = new HostingSyncTaskQueueDao.addSyncTaskQueue_args();
    request.setPlatformArgs(platformArgs);
    request.setTaskQueue(taskQueue);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("addSyncTaskQueue");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(HostingSyncTaskQueueDao.addSyncTaskQueue_result.class);
    return serviceCall;
  }

  public void send_querySyncTaskQueue(int routeKey, int timeout, xueqiao.hosting.taskqueue.QuerySyncTaskQueueOption option, org.soldier.platform.page.IndexedPageOption pageOption) throws TException {
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
        create_querySyncTaskQueueServiceCall(routeKey, timeout, platformArgs, option, pageOption), new TRequestOption());
  }

  public void send_querySyncTaskQueue(int routeKey, int timeout, xueqiao.hosting.taskqueue.QuerySyncTaskQueueOption option, org.soldier.platform.page.IndexedPageOption pageOption,TRequestOption requestOption) throws TException { 
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
        create_querySyncTaskQueueServiceCall(routeKey, timeout, platformArgs, option, pageOption), requestOption);
  }

  public long querySyncTaskQueue(int routeKey, int timeout, xueqiao.hosting.taskqueue.QuerySyncTaskQueueOption option, org.soldier.platform.page.IndexedPageOption pageOption, IMethodCallback<HostingSyncTaskQueueDao.querySyncTaskQueue_args, HostingSyncTaskQueueDao.querySyncTaskQueue_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
            create_querySyncTaskQueueServiceCall(routeKey, timeout, platformArgs, option, pageOption), callback);
  }

  public long add_querySyncTaskQueueCall(AsyncCallRunner runner, int routeKey, int timeout, xueqiao.hosting.taskqueue.QuerySyncTaskQueueOption option, org.soldier.platform.page.IndexedPageOption pageOption, IMethodCallback<HostingSyncTaskQueueDao.querySyncTaskQueue_args, HostingSyncTaskQueueDao.querySyncTaskQueue_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
            create_querySyncTaskQueueServiceCall(routeKey, timeout, platformArgs, option, pageOption), callback);
  }

  protected TServiceCall create_querySyncTaskQueueServiceCall(int routeKey, int timeout, org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, xueqiao.hosting.taskqueue.QuerySyncTaskQueueOption option, org.soldier.platform.page.IndexedPageOption pageOption){
    TServiceCall serviceCall = new TServiceCall();
    if (!getPeerAddr().isEmpty()) {
      serviceCall.setChooseServiceIp(getPeerAddr());
    }
    if (getPeerPort() != 0) {
      serviceCall.setChooseServicePort(getPeerPort());
    }
    serviceCall.setServiceKey(HostingSyncTaskQueueDaoVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    HostingSyncTaskQueueDao.querySyncTaskQueue_args request = new HostingSyncTaskQueueDao.querySyncTaskQueue_args();
    request.setPlatformArgs(platformArgs);
    request.setOption(option);
    request.setPageOption(pageOption);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("querySyncTaskQueue");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(HostingSyncTaskQueueDao.querySyncTaskQueue_result.class);
    return serviceCall;
  }

  public void send_deleteSyncTaskQueue(int routeKey, int timeout, int taskId) throws TException {
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
        create_deleteSyncTaskQueueServiceCall(routeKey, timeout, platformArgs, taskId), new TRequestOption());
  }

  public void send_deleteSyncTaskQueue(int routeKey, int timeout, int taskId,TRequestOption requestOption) throws TException { 
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
        create_deleteSyncTaskQueueServiceCall(routeKey, timeout, platformArgs, taskId), requestOption);
  }

  public long deleteSyncTaskQueue(int routeKey, int timeout, int taskId, IMethodCallback<HostingSyncTaskQueueDao.deleteSyncTaskQueue_args, HostingSyncTaskQueueDao.deleteSyncTaskQueue_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
            create_deleteSyncTaskQueueServiceCall(routeKey, timeout, platformArgs, taskId), callback);
  }

  public long add_deleteSyncTaskQueueCall(AsyncCallRunner runner, int routeKey, int timeout, int taskId, IMethodCallback<HostingSyncTaskQueueDao.deleteSyncTaskQueue_args, HostingSyncTaskQueueDao.deleteSyncTaskQueue_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
            create_deleteSyncTaskQueueServiceCall(routeKey, timeout, platformArgs, taskId), callback);
  }

  protected TServiceCall create_deleteSyncTaskQueueServiceCall(int routeKey, int timeout, org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, int taskId){
    TServiceCall serviceCall = new TServiceCall();
    if (!getPeerAddr().isEmpty()) {
      serviceCall.setChooseServiceIp(getPeerAddr());
    }
    if (getPeerPort() != 0) {
      serviceCall.setChooseServicePort(getPeerPort());
    }
    serviceCall.setServiceKey(HostingSyncTaskQueueDaoVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    HostingSyncTaskQueueDao.deleteSyncTaskQueue_args request = new HostingSyncTaskQueueDao.deleteSyncTaskQueue_args();
    request.setPlatformArgs(platformArgs);
    request.setTaskId(taskId);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("deleteSyncTaskQueue");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(HostingSyncTaskQueueDao.deleteSyncTaskQueue_result.class);
    return serviceCall;
  }

  public void send_updateSyncTaskQueue(int routeKey, int timeout, xueqiao.hosting.taskqueue.TSyncTaskQueue taskQueue) throws TException {
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
        create_updateSyncTaskQueueServiceCall(routeKey, timeout, platformArgs, taskQueue), new TRequestOption());
  }

  public void send_updateSyncTaskQueue(int routeKey, int timeout, xueqiao.hosting.taskqueue.TSyncTaskQueue taskQueue,TRequestOption requestOption) throws TException { 
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
        create_updateSyncTaskQueueServiceCall(routeKey, timeout, platformArgs, taskQueue), requestOption);
  }

  public long updateSyncTaskQueue(int routeKey, int timeout, xueqiao.hosting.taskqueue.TSyncTaskQueue taskQueue, IMethodCallback<HostingSyncTaskQueueDao.updateSyncTaskQueue_args, HostingSyncTaskQueueDao.updateSyncTaskQueue_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
            create_updateSyncTaskQueueServiceCall(routeKey, timeout, platformArgs, taskQueue), callback);
  }

  public long add_updateSyncTaskQueueCall(AsyncCallRunner runner, int routeKey, int timeout, xueqiao.hosting.taskqueue.TSyncTaskQueue taskQueue, IMethodCallback<HostingSyncTaskQueueDao.updateSyncTaskQueue_args, HostingSyncTaskQueueDao.updateSyncTaskQueue_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
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
            create_updateSyncTaskQueueServiceCall(routeKey, timeout, platformArgs, taskQueue), callback);
  }

  protected TServiceCall create_updateSyncTaskQueueServiceCall(int routeKey, int timeout, org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, xueqiao.hosting.taskqueue.TSyncTaskQueue taskQueue){
    TServiceCall serviceCall = new TServiceCall();
    if (!getPeerAddr().isEmpty()) {
      serviceCall.setChooseServiceIp(getPeerAddr());
    }
    if (getPeerPort() != 0) {
      serviceCall.setChooseServicePort(getPeerPort());
    }
    serviceCall.setServiceKey(HostingSyncTaskQueueDaoVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    HostingSyncTaskQueueDao.updateSyncTaskQueue_args request = new HostingSyncTaskQueueDao.updateSyncTaskQueue_args();
    request.setPlatformArgs(platformArgs);
    request.setTaskQueue(taskQueue);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("updateSyncTaskQueue");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(HostingSyncTaskQueueDao.updateSyncTaskQueue_result.class);
    return serviceCall;
  }

}
