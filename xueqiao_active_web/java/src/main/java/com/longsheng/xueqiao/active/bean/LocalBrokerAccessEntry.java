package com.longsheng.xueqiao.active.bean;

import java.util.List;
import java.util.Map;

public class LocalBrokerAccessEntry {
	private int entryId;
	private int brokerId;
	private String platform;
	private String accessName;
	private List<LocalAccessAddress> tradeAddressList;
	private List<LocalAccessAddress> quotaAddressList;
	private Map<String, String> customInfoMap;
	private String status;
	private String workingStatus;
	private String techPlatformEnv;
	private List<LocalSimpleBrokerAccessEntry> brokerAccessEntryList;

	public int getEntryId() {
		return entryId;
	}

	public void setEntryId(int entryId) {
		this.entryId = entryId;
	}

	public int getBrokerId() {
		return brokerId;
	}

	public void setBrokerId(int brokerId) {
		this.brokerId = brokerId;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public String getAccessName() {
		return accessName;
	}

	public void setAccessName(String accessName) {
		this.accessName = accessName;
	}

	public List<LocalAccessAddress> getTradeAddressList() {
		return tradeAddressList;
	}

	public void setTradeAddressList(List<LocalAccessAddress> tradeAddressList) {
		this.tradeAddressList = tradeAddressList;
	}

	public List<LocalAccessAddress> getQuotaAddressList() {
		return quotaAddressList;
	}

	public void setQuotaAddressList(List<LocalAccessAddress> quotaAddressList) {
		this.quotaAddressList = quotaAddressList;
	}

	public Map<String, String> getCustomInfoMap() {
		return customInfoMap;
	}

	public void setCustomInfoMap(Map<String, String> customInfoMap) {
		this.customInfoMap = customInfoMap;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getWorkingStatus() {
		return workingStatus;
	}

	public void setWorkingStatus(String workingStatus) {
		this.workingStatus = workingStatus;
	}

	public String getTechPlatformEnv() {
		return techPlatformEnv;
	}

	public void setTechPlatformEnv(String techPlatformEnv) {
		this.techPlatformEnv = techPlatformEnv;
	}

	public List<LocalSimpleBrokerAccessEntry> getBrokerAccessEntryList() {
		return brokerAccessEntryList;
	}

	public void setBrokerAccessEntryList(List<LocalSimpleBrokerAccessEntry> brokerAccessEntryList) {
		this.brokerAccessEntryList = brokerAccessEntryList;
	}
	
}
