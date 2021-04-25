package com.longsheng.xueqiao.admin.web.servlet.base;


public class  BooleanResult extends BaseResult {
	private boolean isSuccess;
	
	public BooleanResult() {
	}
	
	public BooleanResult(boolean isSuccess) {
		setSuccess(isSuccess);
	}

	public boolean isSuccess() {
		return isSuccess;
	}

	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

}
