package com.longsheng.xueqiao.admin.bean.tradetime;

import java.util.List;

public class LocalDateTimeSpan {
	private String date;
	private List<String> localTimeTOpenList;
	private List<String> beijingTimeTOpenList;

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public List<String> getLocalTimeTOpenList() {
		return localTimeTOpenList;
	}

	public void setLocalTimeTOpenList(List<String> localTimeTOpenList) {
		this.localTimeTOpenList = localTimeTOpenList;
	}

	public List<String> getBeijingTimeTOpenList() {
		return beijingTimeTOpenList;
	}

	public void setBeijingTimeTOpenList(List<String> beijingTimeTOpenList) {
		this.beijingTimeTOpenList = beijingTimeTOpenList;
	}
}
