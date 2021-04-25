package com.longsheng.xueqiao.admin.bean;

public class LocalCommodityMapFileInfo {
	private int brokerId;
	private String cnName;
	private String lastModityTime;
	private String version;
	private String fileMD5;
	private String url;

	public int getBrokerId() {
		return brokerId;
	}

	public void setBrokerId(int brokerId) {
		this.brokerId = brokerId;
	}

	public String getCnName() {
		return cnName;
	}

	public void setCnName(String cnName) {
		this.cnName = cnName;
	}

	public String getLastModityTime() {
		return lastModityTime;
	}

	public void setLastModityTime(String lastModityTime) {
		this.lastModityTime = lastModityTime;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getFileMD5() {
		return fileMD5;
	}

	public void setFileMD5(String fileMD5) {
		this.fileMD5 = fileMD5;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
