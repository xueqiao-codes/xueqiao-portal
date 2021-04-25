package com.longsheng.xueqiao.admin.bean;

public class LocalCommoditySourceAccount {

	private int accountId;
	private String techPlatform;
	private String techPlatformEnv;
	private String brokerEntry;
	private String brokerAccess;
	private int brokerEntryId;
	private int brokerAccessId;
	private String accountName;
	private String accountpwd;
	private String ipAddress;
	private int port;
	private String extraInfo;
	private String accessState;
	private String appId;
	private String cer;

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public String getTechPlatform() {
		return techPlatform;
	}

	public void setTechPlatform(String techPlatform) {
		this.techPlatform = techPlatform;
	}

	public String getTechPlatformEnv() {
		return techPlatformEnv;
	}

	public int getBrokerEntryId() {
		return brokerEntryId;
	}

	public void setBrokerEntryId(int brokerEntryId) {
		this.brokerEntryId = brokerEntryId;
	}

	public int getBrokerAccessId() {
		return brokerAccessId;
	}

	public void setBrokerAccessId(int brokerAccessId) {
		this.brokerAccessId = brokerAccessId;
	}

	public String getAccessState() {
		return accessState;
	}

	public void setAccessState(String accessState) {
		this.accessState = accessState;
	}

	public void setTechPlatformEnv(String techPlatformEnv) {
		this.techPlatformEnv = techPlatformEnv;
	}

	public String getBrokerEntry() {
		return brokerEntry;
	}

	public void setBrokerEntry(String brokerEntry) {
		this.brokerEntry = brokerEntry;
	}

	public String getBrokerAccess() {
		return brokerAccess;
	}

	public void setBrokerAccess(String brokerAccess) {
		this.brokerAccess = brokerAccess;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getAccountpwd() {
		return accountpwd;
	}

	public void setAccountpwd(String accountpwd) {
		this.accountpwd = accountpwd;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getExtraInfo() {
		return extraInfo;
	}

	public void setExtraInfo(String extraInfo) {
		this.extraInfo = extraInfo;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getCer() {
		return cer;
	}

	public void setCer(String cer) {
		this.cer = cer;
	}

}
