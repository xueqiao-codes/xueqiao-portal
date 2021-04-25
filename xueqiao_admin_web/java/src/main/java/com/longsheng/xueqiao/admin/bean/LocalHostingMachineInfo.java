package com.longsheng.xueqiao.admin.bean;

import com.longsheng.xueqiao.admin.module.hosting.MXueqiaoHosting;

public class LocalHostingMachineInfo {

	private long machineId; // 机器ID
	private String machineHostname; // 机器
	private String machineAssignStatus;
	private String instanceId; // 阿里云ECS实例id
	private String regionId;

	// EcsInstance
	private String aliyunInstanceId;
	private String zoneId; // 可用区ID
	private String innerIpAddress; // 机器内网IP
	private String publicIpAddress; // 机器外网IP
	private String ipAddress;
	private String runningStatus;
	private String instanceNetworkType; // 实例网络类型
	private String machineSpec; // 机器规格(配置)
	private String instanceChargeType; // 实例付费方式
	private String aliyunExpiredTime;

	// HostingRelatedInfo
	private long relatedId;
	private int companyId;
	private int companyGroupId; // 对应托管服务ID

	// company & group info
	private String companyCode;
	private String groupName;

	// hosting info
	private String hostingStatus;

	public long getMachineId() {
		return machineId;
	}

	public void setMachineId(long machineId) {
		this.machineId = machineId;
	}

	public String getMachineHostname() {
		return machineHostname;
	}

	public void setMachineHostname(String machineHostname) {
		this.machineHostname = machineHostname;
	}

	public String getMachineAssignStatus() {
		return machineAssignStatus;
	}

	public void setMachineAssignStatus(String machineAssignStatus) {
		this.machineAssignStatus = machineAssignStatus;
	}

	public String getInstanceId() {
		return instanceId;
	}

	public void setInstanceId(String instanceId) {
		this.instanceId = instanceId;
	}

	public String getRegionId() {
		return regionId;
	}

	public void setRegionId(String regionId) {
		this.regionId = regionId;
	}

	public String getAliyunInstanceId() {
		return aliyunInstanceId;
	}

	public void setAliyunInstanceId(String aliyunInstanceId) {
		this.aliyunInstanceId = aliyunInstanceId;
	}

	public String getZoneId() {
		return zoneId;
	}

	public void setZoneId(String zoneId) {
		this.zoneId = zoneId;
	}

	public String getInnerIpAddress() {
		return innerIpAddress;
	}

	public void setInnerIpAddress(String innerIpAddress) {
		this.innerIpAddress = innerIpAddress;
	}

	public String getPublicIpAddress() {
		return publicIpAddress;
	}

	public void setPublicIpAddress(String publicIpAddress) {
		this.publicIpAddress = publicIpAddress;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getRunningStatus() {
		return runningStatus;
	}

	public void setRunningStatus(String runningStatus) {
		this.runningStatus = runningStatus;
	}

	public String getInstanceNetworkType() {
		return instanceNetworkType;
	}

	public void setInstanceNetworkType(String instanceNetworkType) {
		this.instanceNetworkType = instanceNetworkType;
	}

	public String getMachineSpec() {
		return machineSpec;
	}

	public void setMachineSpec(String machineSpec) {
		this.machineSpec = machineSpec;
	}

	public String getInstanceChargeType() {
		return instanceChargeType;
	}

	public void setInstanceChargeType(String instanceChargeType) {
		this.instanceChargeType = instanceChargeType;
	}

	public String getAliyunExpiredTime() {
		return aliyunExpiredTime;
	}

	public void setAliyunExpiredTime(String aliyunExpiredTime) {
		this.aliyunExpiredTime = aliyunExpiredTime;
	}

	public long getRelatedId() {
		return relatedId;
	}

	public void setRelatedId(long relatedId) {
		this.relatedId = relatedId;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public int getCompanyGroupId() {
		return companyGroupId;
	}

	public void setCompanyGroupId(int companyGroupId) {
		this.companyGroupId = companyGroupId;
	}

	public String getHostingStatus() {
		return hostingStatus;
	}

	public void setHostingStatus(xueqiao.trade.hosting.HostingStatus hostingStatus) {
		this.hostingStatus = MXueqiaoHosting.getHostingStatusString(hostingStatus);
	}

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
}
