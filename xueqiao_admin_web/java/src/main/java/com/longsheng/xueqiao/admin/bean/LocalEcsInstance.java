package com.longsheng.xueqiao.admin.bean;

public class LocalEcsInstance {

	private String aliyunInstanceId; // 阿里云ECS实例id
	private String regionId; // 地域id
	private String instanceName; // 实例名称
	private String aliyunExpiredTime; // 实例过期时间
	private String zoneId; // 可用区ID
	private String instanceNetworkType; // 实例网络类型
	private String instanceChargeType; // 实例付费方式
	private String tags; // 标签[key, value]
	private String innerIpAddress; // 机器内网IP
	private String publicIpAddress; // 机器外网IP
	private String runningStatus; // 实例运行状态
	// 规格
	private String machineSpec;
	private int memoryGB; // 内存多少GB
	private int cpuCount; // 核多少个
	private int outIfBandMB; // 出口网络宽带

	public String getAliyunInstanceId() {
		return aliyunInstanceId;
	}

	public void setAliyunInstanceId(String aliyunInstanceId) {
		this.aliyunInstanceId = aliyunInstanceId;
	}

	public String getRegionId() {
		return regionId;
	}

	public void setRegionId(String regionId) {
		this.regionId = regionId;
	}

	public String getInstanceName() {
		return instanceName;
	}

	public void setInstanceName(String instanceName) {
		this.instanceName = instanceName;
	}

	public String getAliyunExpiredTime() {
		return aliyunExpiredTime;
	}

	public void setAliyunExpiredTime(String aliyunExpiredTime) {
		this.aliyunExpiredTime = aliyunExpiredTime;
	}

	public String getZoneId() {
		return zoneId;
	}

	public void setZoneId(String zoneId) {
		this.zoneId = zoneId;
	}

	public String getInstanceNetworkType() {
		return instanceNetworkType;
	}

	public void setInstanceNetworkType(String instanceNetworkType) {
		this.instanceNetworkType = instanceNetworkType;
	}

	public String getInstanceChargeType() {
		return instanceChargeType;
	}

	public void setInstanceChargeType(String instanceChargeType) {
		this.instanceChargeType = instanceChargeType;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
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

	public String getRunningStatus() {
		return runningStatus;
	}

	public void setRunningStatus(String runningStatus) {
		this.runningStatus = runningStatus;
	}

	public String getMachineSpec() {
		return machineSpec;
	}

	public void setMachineSpec(String machineSpec) {
		this.machineSpec = machineSpec;
	}

	public int getMemoryGB() {
		return memoryGB;
	}

	public void setMemoryGB(int memoryGB) {
		this.memoryGB = memoryGB;
	}

	public int getCpuCount() {
		return cpuCount;
	}

	public void setCpuCount(int cpuCount) {
		this.cpuCount = cpuCount;
	}

	public int getOutIfBandMB() {
		return outIfBandMB;
	}

	public void setOutIfBandMB(int outIfBandMB) {
		this.outIfBandMB = outIfBandMB;
	}

}
