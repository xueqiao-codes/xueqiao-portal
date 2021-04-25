package com.longsheng.xueqiao.admin.module.hosting;

import java.util.HashSet;
import java.util.Set;

import org.apache.thrift.TException;
import org.soldier.base.logger.AppLog;
import org.soldier.platform.page.IndexedPageOption;
import org.soldier.platform.svr_platform.comm.ErrorInfo;

import com.longsheng.xueqiao.aliyun.resource.thriftapi.EcsInstance;
import com.longsheng.xueqiao.aliyun.resource.thriftapi.EcsInstancePage;
import com.longsheng.xueqiao.aliyun.resource.thriftapi.ReqEcsInstanceOption;
import com.longsheng.xueqiao.aliyun.resource.thriftapi.client.AliyunResourceAoServiceStub;

import xueqiao.hosting.machine.*;
import xueqiao.hosting.machine.dao.client.HostingMachineDaoStub;

public class MXueqiaoHostMachine {

	private static MXueqiaoHostMachine mInstance;
	
	private HostingMachineDaoStub mHostingMachineDaoStub;
	private AliyunResourceAoServiceStub mAliyunResourceAoServiceStub;
	
	public static MXueqiaoHostMachine getInstance() {
		if (mInstance == null) {
			mInstance = new MXueqiaoHostMachine();
		}
		return mInstance;
	}
	
	private MXueqiaoHostMachine(){
		mHostingMachineDaoStub = new HostingMachineDaoStub();
		mAliyunResourceAoServiceStub = new AliyunResourceAoServiceStub();
	}
	
	public HostingRelatedInfo queryRelatedInfoById(int companyId, int companyGroupId) throws ErrorInfo, TException {
		QueryHostingRelatedInfoOption queryOption = new QueryHostingRelatedInfoOption();
		queryOption.setCompanyId(companyId);
		queryOption.setCompanyGroupId(companyGroupId);
		
		IndexedPageOption pageOption = new IndexedPageOption();
		pageOption.setPageIndex(0);
		pageOption.setPageSize(1);
		
		HostingRelatedInfoPageResult hostingRelatedInfoPageResult = mHostingMachineDaoStub.queryRelatedInfoPage(queryOption, pageOption);
		
		AppLog.i("MXueqiaoHostMachine ---- queryRelatedInfoById ---- companyId : " + companyId + ", companyGroupId : " + companyGroupId + ", hostingRelatedInfoPageResult : " + hostingRelatedInfoPageResult);
		
		if (hostingRelatedInfoPageResult != null && hostingRelatedInfoPageResult.getResultListSize() > 0) {
			return hostingRelatedInfoPageResult.getResultList().get(0);
		}
		return null;
	}
	
	public HostingRelatedInfo queryRelatedInfoByMachineId(long machineId) throws ErrorInfo, TException {
		QueryHostingRelatedInfoOption queryOption = new QueryHostingRelatedInfoOption();
		queryOption.setMachineId(machineId);
		
		IndexedPageOption pageOption = new IndexedPageOption();
		pageOption.setPageIndex(0);
		pageOption.setPageSize(1);
		
		HostingRelatedInfoPageResult hostingRelatedInfoPageResult = mHostingMachineDaoStub.queryRelatedInfoPage(queryOption, pageOption);
		
		AppLog.i("MXueqiaoHostMachine ---- queryRelatedInfoByMachineId ---- machineId : " + machineId + ", hostingRelatedInfoPageResult : " + hostingRelatedInfoPageResult.getResultListSize());
		
		if (hostingRelatedInfoPageResult != null && hostingRelatedInfoPageResult.getResultListSize() > 0) {
			return hostingRelatedInfoPageResult.getResultList().get(0);
		}
		return null;
	}
	
	public HostingMachine queryHostMachineById(long machineId) throws ErrorInfo, TException {
		QueryHostingMachineOption queryOption = new QueryHostingMachineOption();
		queryOption.setMachineId(machineId);
		
		IndexedPageOption pageOption = new IndexedPageOption();
		pageOption.setPageIndex(0);
		pageOption.setPageSize(1);
		HostingMachinePageResult hostingMachinePageResult = mHostingMachineDaoStub.queryHostingMachinePage(queryOption, pageOption);
		
		AppLog.i("MXueqiaoHostMachine ---- queryHostMachineById ---- machineId : " + machineId + ", hostingMachinePageResult : " + hostingMachinePageResult.getResultListSize());
		
		if (hostingMachinePageResult != null && hostingMachinePageResult.getResultListSize() > 0) {
			return hostingMachinePageResult.getResultList().get(0);
		}
		return null;
	}
	
	public EcsInstance queryEcsInstance(String instanceId, String regionId) throws ErrorInfo, TException {
		
		ReqEcsInstanceOption reqEcsInstanceOption = new ReqEcsInstanceOption();
		Set<String> instanceIds = new HashSet<String>();
		instanceIds.add(instanceId);
		reqEcsInstanceOption.setInstanceIds(instanceIds);
		reqEcsInstanceOption.setRegionId(regionId);
		
		EcsInstancePage ecsInstancePage = mAliyunResourceAoServiceStub.reqEcsInstance(reqEcsInstanceOption);
		
		AppLog.i("MXueqiaoHostMachine ---- queryEcsInstance ---- pageSize : " + ecsInstancePage.getPage().size() + ", instanceId: " + instanceId + ", regionId : " + regionId);
		
		if (ecsInstancePage.getPage().size() > 0) {
			return ecsInstancePage.getPage().get(0);
		} else {
			return null;
		}
	}
	
	public void addRelatedInfo(long machineId, int companyId, int companyGroupId, int activedEndTimestamp) throws ErrorInfo, TException {
		HostingRelatedInfo newRelatedInfo = new HostingRelatedInfo();
		newRelatedInfo.setMachineId(machineId);
		newRelatedInfo.setCompanyId(companyId);
		newRelatedInfo.setCompanyGroupId(companyGroupId);
		newRelatedInfo.setActivedEndTimestamp(activedEndTimestamp);
		AppLog.i("MXueqiaoHostMachine ---- addRelatedInfo ---- machineId : " + machineId + ", companyId : " + companyId + ", companyGroupId : " + companyGroupId + ", activedEndTimestamp : " + activedEndTimestamp);
		mHostingMachineDaoStub.addRelatedInfo(newRelatedInfo);
	}

	public void removeRelatedInfo(long relatedId) throws TException {
		mHostingMachineDaoStub.deleteRelatedInfo(relatedId);
	}
	
	public void updateHostingMachineAssignStatus(long machineId, HostingMachineAssignStatus assignStatus) throws ErrorInfo, TException {
		HostingMachine updateMachine = new HostingMachine();
		updateMachine.setMachineId(machineId);
		updateMachine.setMachineAssignStatus(assignStatus);
		AppLog.i("MXueqiaoHostMachine ---- updateHostingMachineAssignStatus ---- machineId : " + machineId + ", assignStatus : " + assignStatus);
		mHostingMachineDaoStub.updateHostingMachine(updateMachine);
	}

	public void addInitHostingMachineRecord(HostingInitialization newHostingInitialization) throws TException {
		mHostingMachineDaoStub.addInitHostingMachineRecord(newHostingInitialization);
	}
}
