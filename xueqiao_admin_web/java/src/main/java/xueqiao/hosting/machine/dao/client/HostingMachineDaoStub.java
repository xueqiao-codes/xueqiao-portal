package xueqiao.hosting.machine.dao.client;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TProtocol;
import org.soldier.platform.svr_platform.client.BaseStub;
import org.soldier.platform.svr_platform.client.TStubOption;
import org.soldier.platform.svr_platform.comm.ErrorInfo;
import org.soldier.platform.svr_platform.comm.PlatformArgs;
import xueqiao.hosting.machine.dao.HostingMachineDao;
import xueqiao.hosting.machine.dao.HostingMachineDaoVariable;

public class HostingMachineDaoStub extends BaseStub {

  public HostingMachineDaoStub() {
    super(HostingMachineDaoVariable.serviceKey);
  }

  public long  addHostingMachine(xueqiao.hosting.machine.HostingMachine newMachine) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return addHostingMachine(newMachine, new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public long  addHostingMachine(xueqiao.hosting.machine.HostingMachine newMachine,TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("addHostingMachine").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    return super.runSync(new ThriftCallable<Long>(){
    @Override
    public Long call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      return new HostingMachineDao.Client(protocol).addHostingMachine(platformArgs, newMachine);
      }
    }, invokeInfo);
  }

  public long  addHostingMachine(int routeKey, int timeout,xueqiao.hosting.machine.HostingMachine newMachine)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return addHostingMachine(newMachine, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public void  updateHostingMachine(xueqiao.hosting.machine.HostingMachine updateMachine) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    updateHostingMachine(updateMachine, new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public void  updateHostingMachine(xueqiao.hosting.machine.HostingMachine updateMachine,TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("updateHostingMachine").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    super.runSync(new ThriftCallable<Void>(){
    @Override
    public Void call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      new HostingMachineDao.Client(protocol).updateHostingMachine(platformArgs, updateMachine);
      return null;
      }
    }, invokeInfo);
  }

  public void  updateHostingMachine(int routeKey, int timeout,xueqiao.hosting.machine.HostingMachine updateMachine)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    updateHostingMachine(updateMachine, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public void  deleteHostingMachine(long machineId) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    deleteHostingMachine(machineId, new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public void  deleteHostingMachine(long machineId,TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("deleteHostingMachine").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    super.runSync(new ThriftCallable<Void>(){
    @Override
    public Void call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      new HostingMachineDao.Client(protocol).deleteHostingMachine(platformArgs, machineId);
      return null;
      }
    }, invokeInfo);
  }

  public void  deleteHostingMachine(int routeKey, int timeout,long machineId)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    deleteHostingMachine(machineId, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public xueqiao.hosting.machine.HostingMachinePageResult  queryHostingMachinePage(xueqiao.hosting.machine.QueryHostingMachineOption queryOption, org.soldier.platform.page.IndexedPageOption pageOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return queryHostingMachinePage(queryOption, pageOption, new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public xueqiao.hosting.machine.HostingMachinePageResult  queryHostingMachinePage(xueqiao.hosting.machine.QueryHostingMachineOption queryOption, org.soldier.platform.page.IndexedPageOption pageOption,TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("queryHostingMachinePage").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    return super.runSync(new ThriftCallable<xueqiao.hosting.machine.HostingMachinePageResult>(){
    @Override
    public xueqiao.hosting.machine.HostingMachinePageResult call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      return new HostingMachineDao.Client(protocol).queryHostingMachinePage(platformArgs, queryOption, pageOption);
      }
    }, invokeInfo);
  }

  public xueqiao.hosting.machine.HostingMachinePageResult  queryHostingMachinePage(int routeKey, int timeout,xueqiao.hosting.machine.QueryHostingMachineOption queryOption, org.soldier.platform.page.IndexedPageOption pageOption)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return queryHostingMachinePage(queryOption, pageOption, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public long  addRelatedInfo(xueqiao.hosting.machine.HostingRelatedInfo newRelatedInfo) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return addRelatedInfo(newRelatedInfo, new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public long  addRelatedInfo(xueqiao.hosting.machine.HostingRelatedInfo newRelatedInfo,TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("addRelatedInfo").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    return super.runSync(new ThriftCallable<Long>(){
    @Override
    public Long call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      return new HostingMachineDao.Client(protocol).addRelatedInfo(platformArgs, newRelatedInfo);
      }
    }, invokeInfo);
  }

  public long  addRelatedInfo(int routeKey, int timeout,xueqiao.hosting.machine.HostingRelatedInfo newRelatedInfo)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return addRelatedInfo(newRelatedInfo, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public void  updateRelatedInfo(xueqiao.hosting.machine.HostingRelatedInfo updateRelatedInfo) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    updateRelatedInfo(updateRelatedInfo, new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public void  updateRelatedInfo(xueqiao.hosting.machine.HostingRelatedInfo updateRelatedInfo,TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("updateRelatedInfo").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    super.runSync(new ThriftCallable<Void>(){
    @Override
    public Void call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      new HostingMachineDao.Client(protocol).updateRelatedInfo(platformArgs, updateRelatedInfo);
      return null;
      }
    }, invokeInfo);
  }

  public void  updateRelatedInfo(int routeKey, int timeout,xueqiao.hosting.machine.HostingRelatedInfo updateRelatedInfo)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    updateRelatedInfo(updateRelatedInfo, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public void  deleteRelatedInfo(long relatedId) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    deleteRelatedInfo(relatedId, new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public void  deleteRelatedInfo(long relatedId,TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("deleteRelatedInfo").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    super.runSync(new ThriftCallable<Void>(){
    @Override
    public Void call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      new HostingMachineDao.Client(protocol).deleteRelatedInfo(platformArgs, relatedId);
      return null;
      }
    }, invokeInfo);
  }

  public void  deleteRelatedInfo(int routeKey, int timeout,long relatedId)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    deleteRelatedInfo(relatedId, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public xueqiao.hosting.machine.HostingRelatedInfoPageResult  queryRelatedInfoPage(xueqiao.hosting.machine.QueryHostingRelatedInfoOption queryOption, org.soldier.platform.page.IndexedPageOption pageOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return queryRelatedInfoPage(queryOption, pageOption, new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public xueqiao.hosting.machine.HostingRelatedInfoPageResult  queryRelatedInfoPage(xueqiao.hosting.machine.QueryHostingRelatedInfoOption queryOption, org.soldier.platform.page.IndexedPageOption pageOption,TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("queryRelatedInfoPage").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    return super.runSync(new ThriftCallable<xueqiao.hosting.machine.HostingRelatedInfoPageResult>(){
    @Override
    public xueqiao.hosting.machine.HostingRelatedInfoPageResult call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      return new HostingMachineDao.Client(protocol).queryRelatedInfoPage(platformArgs, queryOption, pageOption);
      }
    }, invokeInfo);
  }

  public xueqiao.hosting.machine.HostingRelatedInfoPageResult  queryRelatedInfoPage(int routeKey, int timeout,xueqiao.hosting.machine.QueryHostingRelatedInfoOption queryOption, org.soldier.platform.page.IndexedPageOption pageOption)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return queryRelatedInfoPage(queryOption, pageOption, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public int  addInitHostingMachineRecord(xueqiao.hosting.machine.HostingInitialization newHostingInitialization) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return addInitHostingMachineRecord(newHostingInitialization, new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public int  addInitHostingMachineRecord(xueqiao.hosting.machine.HostingInitialization newHostingInitialization,TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("addInitHostingMachineRecord").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    return super.runSync(new ThriftCallable<Integer>(){
    @Override
    public Integer call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      return new HostingMachineDao.Client(protocol).addInitHostingMachineRecord(platformArgs, newHostingInitialization);
      }
    }, invokeInfo);
  }

  public int  addInitHostingMachineRecord(int routeKey, int timeout,xueqiao.hosting.machine.HostingInitialization newHostingInitialization)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return addInitHostingMachineRecord(newHostingInitialization, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public void  updateInitHostingMachineRecord(xueqiao.hosting.machine.HostingInitialization updateHostingInitialization) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    updateInitHostingMachineRecord(updateHostingInitialization, new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public void  updateInitHostingMachineRecord(xueqiao.hosting.machine.HostingInitialization updateHostingInitialization,TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("updateInitHostingMachineRecord").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    super.runSync(new ThriftCallable<Void>(){
    @Override
    public Void call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      new HostingMachineDao.Client(protocol).updateInitHostingMachineRecord(platformArgs, updateHostingInitialization);
      return null;
      }
    }, invokeInfo);
  }

  public void  updateInitHostingMachineRecord(int routeKey, int timeout,xueqiao.hosting.machine.HostingInitialization updateHostingInitialization)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    updateInitHostingMachineRecord(updateHostingInitialization, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public xueqiao.hosting.machine.HostingInitializationPage  queryHostingInitializationPage(xueqiao.hosting.machine.QueryHostingInitializationOption queryOption, org.soldier.platform.page.IndexedPageOption pageOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return queryHostingInitializationPage(queryOption, pageOption, new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public xueqiao.hosting.machine.HostingInitializationPage  queryHostingInitializationPage(xueqiao.hosting.machine.QueryHostingInitializationOption queryOption, org.soldier.platform.page.IndexedPageOption pageOption,TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("queryHostingInitializationPage").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    return super.runSync(new ThriftCallable<xueqiao.hosting.machine.HostingInitializationPage>(){
    @Override
    public xueqiao.hosting.machine.HostingInitializationPage call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      return new HostingMachineDao.Client(protocol).queryHostingInitializationPage(platformArgs, queryOption, pageOption);
      }
    }, invokeInfo);
  }

  public xueqiao.hosting.machine.HostingInitializationPage  queryHostingInitializationPage(int routeKey, int timeout,xueqiao.hosting.machine.QueryHostingInitializationOption queryOption, org.soldier.platform.page.IndexedPageOption pageOption)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return queryHostingInitializationPage(queryOption, pageOption, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public int  addSyncHostingUser(xueqiao.hosting.machine.SyncHostingUser newSyncHostingUser) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return addSyncHostingUser(newSyncHostingUser, new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public int  addSyncHostingUser(xueqiao.hosting.machine.SyncHostingUser newSyncHostingUser,TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("addSyncHostingUser").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    return super.runSync(new ThriftCallable<Integer>(){
    @Override
    public Integer call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      return new HostingMachineDao.Client(protocol).addSyncHostingUser(platformArgs, newSyncHostingUser);
      }
    }, invokeInfo);
  }

  public int  addSyncHostingUser(int routeKey, int timeout,xueqiao.hosting.machine.SyncHostingUser newSyncHostingUser)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return addSyncHostingUser(newSyncHostingUser, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public void  updateSyncHostingUser(xueqiao.hosting.machine.SyncHostingUser updateSyncHostingUser) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    updateSyncHostingUser(updateSyncHostingUser, new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public void  updateSyncHostingUser(xueqiao.hosting.machine.SyncHostingUser updateSyncHostingUser,TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("updateSyncHostingUser").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    super.runSync(new ThriftCallable<Void>(){
    @Override
    public Void call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      new HostingMachineDao.Client(protocol).updateSyncHostingUser(platformArgs, updateSyncHostingUser);
      return null;
      }
    }, invokeInfo);
  }

  public void  updateSyncHostingUser(int routeKey, int timeout,xueqiao.hosting.machine.SyncHostingUser updateSyncHostingUser)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    updateSyncHostingUser(updateSyncHostingUser, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public xueqiao.hosting.machine.SyncHostingUserPage  querySyncHostingUserPage(xueqiao.hosting.machine.QuerySyncHostingUserOption queryOption, org.soldier.platform.page.IndexedPageOption pageOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return querySyncHostingUserPage(queryOption, pageOption, new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public xueqiao.hosting.machine.SyncHostingUserPage  querySyncHostingUserPage(xueqiao.hosting.machine.QuerySyncHostingUserOption queryOption, org.soldier.platform.page.IndexedPageOption pageOption,TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("querySyncHostingUserPage").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    return super.runSync(new ThriftCallable<xueqiao.hosting.machine.SyncHostingUserPage>(){
    @Override
    public xueqiao.hosting.machine.SyncHostingUserPage call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      return new HostingMachineDao.Client(protocol).querySyncHostingUserPage(platformArgs, queryOption, pageOption);
      }
    }, invokeInfo);
  }

  public xueqiao.hosting.machine.SyncHostingUserPage  querySyncHostingUserPage(int routeKey, int timeout,xueqiao.hosting.machine.QuerySyncHostingUserOption queryOption, org.soldier.platform.page.IndexedPageOption pageOption)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return querySyncHostingUserPage(queryOption, pageOption, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public void  addSyncTaskQueue(xueqiao.hosting.machine.taskqueue.TSyncTaskQueue taskQueue) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    addSyncTaskQueue(taskQueue, new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public void  addSyncTaskQueue(xueqiao.hosting.machine.taskqueue.TSyncTaskQueue taskQueue,TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("addSyncTaskQueue").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    super.runSync(new ThriftCallable<Void>(){
    @Override
    public Void call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      new HostingMachineDao.Client(protocol).addSyncTaskQueue(platformArgs, taskQueue);
      return null;
      }
    }, invokeInfo);
  }

  public void  addSyncTaskQueue(int routeKey, int timeout,xueqiao.hosting.machine.taskqueue.TSyncTaskQueue taskQueue)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    addSyncTaskQueue(taskQueue, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public xueqiao.hosting.machine.taskqueue.SyncTaskQueuePage  querySyncTaskQueue(xueqiao.hosting.machine.taskqueue.QuerySyncTaskQueueOption option, org.soldier.platform.page.IndexedPageOption pageOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return querySyncTaskQueue(option, pageOption, new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public xueqiao.hosting.machine.taskqueue.SyncTaskQueuePage  querySyncTaskQueue(xueqiao.hosting.machine.taskqueue.QuerySyncTaskQueueOption option, org.soldier.platform.page.IndexedPageOption pageOption,TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("querySyncTaskQueue").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    return super.runSync(new ThriftCallable<xueqiao.hosting.machine.taskqueue.SyncTaskQueuePage>(){
    @Override
    public xueqiao.hosting.machine.taskqueue.SyncTaskQueuePage call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      return new HostingMachineDao.Client(protocol).querySyncTaskQueue(platformArgs, option, pageOption);
      }
    }, invokeInfo);
  }

  public xueqiao.hosting.machine.taskqueue.SyncTaskQueuePage  querySyncTaskQueue(int routeKey, int timeout,xueqiao.hosting.machine.taskqueue.QuerySyncTaskQueueOption option, org.soldier.platform.page.IndexedPageOption pageOption)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
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
      new HostingMachineDao.Client(protocol).deleteSyncTaskQueue(platformArgs, taskId);
      return null;
      }
    }, invokeInfo);
  }

  public void  deleteSyncTaskQueue(int routeKey, int timeout,int taskId)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    deleteSyncTaskQueue(taskId, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public void  updateSyncTaskQueue(xueqiao.hosting.machine.taskqueue.TSyncTaskQueue taskQueue) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    updateSyncTaskQueue(taskQueue, new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public void  updateSyncTaskQueue(xueqiao.hosting.machine.taskqueue.TSyncTaskQueue taskQueue,TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("updateSyncTaskQueue").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    super.runSync(new ThriftCallable<Void>(){
    @Override
    public Void call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      new HostingMachineDao.Client(protocol).updateSyncTaskQueue(platformArgs, taskQueue);
      return null;
      }
    }, invokeInfo);
  }

  public void  updateSyncTaskQueue(int routeKey, int timeout,xueqiao.hosting.machine.taskqueue.TSyncTaskQueue taskQueue)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    updateSyncTaskQueue(taskQueue, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

}
