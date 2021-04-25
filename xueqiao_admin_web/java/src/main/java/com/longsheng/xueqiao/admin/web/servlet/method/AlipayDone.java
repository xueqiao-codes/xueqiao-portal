package com.longsheng.xueqiao.admin.web.servlet.method;

import java.util.Map;

import org.soldier.base.logger.AppLog;
import org.soldier.platform.web_framework.util.GsonFactory;

import com.longsheng.xueqiao.admin.web.servlet.base.BaseResult;
import com.longsheng.xueqiao.admin.web.servlet.base.ResponseContentType;
import com.longsheng.xueqiao.admin.web.servlet.base.StringResult;
import com.longsheng.xueqiao.admin.web.servlet.base.WebRequest;
import com.longsheng.xueqiao.admin.web.servlet.base.WebTextResponseMethod;

public class AlipayDone extends WebTextResponseMethod {

	private static final int TIMEOUT = 5000;
	@Override
	protected BaseResult implement(WebRequest request) throws Exception {
		setContentType(ResponseContentType.TEXT_HTML);
		
		Map<String, String[]> params = request.getParameters();
		String json = GsonFactory.getGson().toJson(params);
		
		AppLog.i("AlipayDone ---- json : " + json);
//		RmbOrderAoStub stub = new RmbOrderAoStub();
//		stub.finishRmbOrder(RandomUtils.nextInt(), TIMEOUT, PayType.Alipay, json);
		
		return new StringResult("SUCCESS");
	}
}
