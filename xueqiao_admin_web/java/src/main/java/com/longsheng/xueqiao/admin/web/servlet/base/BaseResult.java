package com.longsheng.xueqiao.admin.web.servlet.base;

import org.soldier.platform.svr_platform.comm.ErrorInfo;

public class BaseResult {
    private ErrorInfo errorInfo;

    public ErrorInfo getErrorInfo() {
        return errorInfo;
    }

    public void setErrorInfo(ErrorInfo errorInfo) {
        this.errorInfo = errorInfo;
    }

    public BaseResult setErrorCode(int errorCode) {
        if (errorInfo == null) {
            errorInfo = new ErrorInfo();
        }
        errorInfo.setErrorCode(errorCode);
        return this;
    }

    public BaseResult setErrorMessage(String errorMessage) {
        if (errorInfo == null) {
            errorInfo = new ErrorInfo();
        }
        errorInfo.setErrorMsg(errorMessage);
        return this;
    }
}
