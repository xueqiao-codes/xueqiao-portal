package com.longsheng.xueqiao.admin.web.servlet.base;

import org.soldier.base.logger.AppLog;


import com.antiy.error_code.ErrorCode;
import com.antiy.error_code.ErrorCodeOuter;
import org.soldier.platform.svr_platform.comm.ErrorInfo;


public abstract class WebMethod {

protected ResponseContentType contentType;
	
	protected void setContentType(ResponseContentType type){
		contentType= type;
	}
	
	public ResponseContentType getContentType(){
		return contentType;
	}
	
	protected abstract BaseResult doMethod(final WebRequest request) throws Exception;
	
	public Object runMethod(final WebRequest request) {
		BaseResult result = new BaseResult();
		try {
			BaseResult methodResult = doMethod(request);
			if (methodResult == null) {
				return result.setErrorCode(ErrorCodeOuter.SERVER_BUSY.getErrorCode())
							 .setErrorMessage("null for method!");
			}
			return getResult(methodResult);
		} catch (ErrorInfo error) {
			result.setErrorCode(error.getErrorCode())
				  .setErrorMessage(error.getErrorMsg());
		} catch (IllegalArgumentException e) {
			result.setErrorCode(ErrorConfig.ILLEGAL_ARUGUMENT)
				  .setErrorMessage(ErrorConfig.ILLEGAL_ARUGUMENT_MSG + e.getMessage());
		} catch (Exception e) {
			AppLog.e(e.getMessage(), e);
			result.setErrorCode(ErrorCodeOuter.SERVER_BUSY.getErrorCode())
				  .setErrorMessage(ErrorCodeOuter.SERVER_BUSY.getErrorMsg());
		}
		return toOuterErrorInfo(result);
	}
	
	protected Object getResult(BaseResult result) {
		if (result.getErrorInfo() != null) {
			toOuterErrorInfo(result);
		}
		return result;
	}
	
	protected BooleanResult deprecated(){
		BooleanResult result = new BooleanResult(false);
		result.setErrorInfo(new ErrorInfo(9000, "Interface deprecated."));
		return result;
	}
	
	protected BaseResult toOuterErrorInfo(BaseResult baseResult) {
		ErrorCode outErrorCode = ErrorCode.toOuter(
				baseResult.getErrorInfo().getErrorCode(),
				baseResult.getErrorInfo().getErrorMsg());
		baseResult.setErrorCode(outErrorCode.getErrorCode())
				  .setErrorMessage(outErrorCode.getErrorMsg());
		return baseResult;
	}
}
