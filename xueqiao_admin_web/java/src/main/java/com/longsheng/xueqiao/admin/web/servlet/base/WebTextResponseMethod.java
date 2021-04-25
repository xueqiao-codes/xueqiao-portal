package com.longsheng.xueqiao.admin.web.servlet.base;

import org.soldier.base.logger.AppLog;
import org.soldier.platform.svr_platform.comm.ErrorInfo;

import com.antiy.error_code.ErrorCodeOuter;

public abstract class WebTextResponseMethod extends WebMethod {

	@Override
	protected BaseResult doMethod(WebRequest request) throws Exception {
		return implement(request);
	}

	protected abstract BaseResult implement(WebRequest request) throws Exception;

	@Override
	public Object runMethod(final WebRequest request) {
		BaseResult result = new BaseResult();
		try {
			StringResult methodResult = (StringResult) doMethod(request);
			if (methodResult == null) {
				return result.setErrorCode(ErrorCodeOuter.SERVER_BUSY.getErrorCode())
						.setErrorMessage("null for method!");
			}
			return methodResult.getData();
		} catch (ErrorInfo error) {
			result.setErrorCode(error.getErrorCode()).setErrorMessage(error.getErrorMsg());
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

}
