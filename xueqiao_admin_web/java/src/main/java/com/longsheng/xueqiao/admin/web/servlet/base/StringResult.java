package com.longsheng.xueqiao.admin.web.servlet.base;


public class StringResult extends BaseResult {

	private String data;
	
	public StringResult() {
	}
	
	public StringResult(String data) {
		setData(data);
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
	
}
