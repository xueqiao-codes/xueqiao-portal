package xueqiao.hosting.taskqueue.dao.client;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TProtocol;
import org.soldier.platform.svr_platform.client.BaseStub;
import org.soldier.platform.svr_platform.client.TStubOption;
import org.soldier.platform.svr_platform.comm.ErrorInfo;
import org.soldier.platform.svr_platform.comm.PlatformArgs;
import xueqiao.hosting.taskqueue.dao.HostingSyncTaskQueueDao;
import xueqiao.hosting.taskqueue.dao.HostingSyncTaskQueueDaoVariable;

public class HostingSyncTaskQueueDaoStub extends BaseStub {

  public HostingSyncTaskQueueDaoStub() {
    super(HostingSyncTaskQueueDaoVariable.serviceKey);
  }

  public void  addSyncTaskQueue(xueqiao.hosting.taskqueue.TSyncTaskQueue taskQueue) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    addSyncTaskQueue(taskQueue, new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public void  addSyncTaskQueue(xueqiao.hosting.taskqueue.TSyncTaskQueue taskQueue,TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("addSyncTaskQueue").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    super.runSync(new ThriftCallable<Void>(){
    @Override
    public Void call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      new HostingSyncTaskQueueDao.Client(protocol).addSyncTaskQueue(platformArgs, taskQueue);
      return null;
      }
    }, invokeInfo);
  }

  public void  addSyncTaskQueue(int routeKey, int timeout,xueqiao.hosting.taskqueue.TSyncTaskQueue taskQueue)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    addSyncTaskQueue(taskQueue, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public xueqiao.hosting.taskqueue.SyncTaskQueuePage  querySyncTaskQueue(xueqiao.hosting.taskqueue.QuerySyncTaskQueueOption option, org.soldier.platform.page.IndexedPageOption pageOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return querySyncTaskQueue(option, pageOption, new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public xueqiao.hosting.taskqueue.SyncTaskQueuePage  querySyncTaskQueue(xueqiao.hosting.taskqueue.QuerySyncTaskQueueOption option, org.soldier.platform.page.IndexedPageOption pageOption,TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("querySyncTaskQueue").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    return super.runSync(new ThriftCallable<xueqiao.hosting.taskqueue.SyncTaskQueuePage>(){
    @Override
    public xueqiao.hosting.taskqueue.SyncTaskQueuePage call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      return new HostingSyncTaskQueueDao.Client(protocol).querySyncTaskQueue(platformArgs, option, pageOption);
      }
    }, invokeInfo);
  }

  public xueqiao.hosting.taskqueue.SyncTaskQueuePage  querySyncTaskQueue(int routeKey, int timeout,xueqiao.hosting.taskqueue.QuerySyncTaskQueueOption option, org.soldier.platform.page.IndexedPageOption pageOption)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return querySyncTaskQueue(option, pageOption, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public void  deleteSyncTaskQueue(int taskId) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    deleteSyncTaskQueue(taskId, new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public void  deleteSyncTaskQueue(int taskId,TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("deleteSyncTaskQueue").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    super.runSync(new ThriftCallable<Void>(){
    @Override
    public Void call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      new HostingSyncTaskQueueDao.Client(protocol).deleteSyncTaskQueue(platformArgs, taskId);
      return null;
      }
    }, invokeInfo);
  }

  public void  deleteSyncTaskQueue(int routeKey, int timeout,int taskId)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    deleteSyncTaskQueue(taskId, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public void  updateSyncTaskQueue(xueqiao.hosting.taskqueue.TSyncTaskQueue taskQueue) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    updateSyncTaskQueue(taskQueue, new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public void  updateSyncTaskQueue(xueqiao.hosting.taskqueue.TSyncTaskQueue taskQueue,TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("updateSyncTaskQueue").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    super.runSync(new ThriftCallable<Void>(){
    @Override
    public Void call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      new HostingSyncTaskQueueDao.Client(protocol).updateSyncTaskQueue(platformArgs, taskQueue);
      return null;
      }
    }, invokeInfo);
  }

  public void  updateSyncTaskQueue(int routeKey, int timeout,xueqiao.hosting.taskqueue.TSyncTaskQueue taskQueue)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    updateSyncTaskQueue(taskQueue, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

}
