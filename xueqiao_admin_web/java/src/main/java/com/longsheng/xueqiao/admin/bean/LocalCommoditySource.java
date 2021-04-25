package com.longsheng.xueqiao.admin.bean;

import java.util.List;

public class LocalCommoditySource {

	private int sourceId;
	private List<String> exchangeMicList;
	private String techPlatformSource;
	private String techPlatformEnv;

	public int getSourceId() {
		return sourceId;
	}

	public void setSourceId(int sourceId) {
		this.sourceId = sourceId;
	}

	public List<String> getExchangeMicList() {
		return exchangeMicList;
	}

	public void setExchangeMicList(List<String> exchangeMicList) {
		this.exchangeMicList = exchangeMicList;
	}

	public String getTechPlatformSource() {
		return techPlatformSource;
	}

	public void setTechPlatformSource(String techPlatformSource) {
		this.techPlatformSource = techPlatformSource;
	}

	public String getTechPlatformEnv() {
		return techPlatformEnv;
	}

	public void setTechPlatformEnv(String techPlatformEnv) {
		this.techPlatformEnv = techPlatformEnv;
	}
}
