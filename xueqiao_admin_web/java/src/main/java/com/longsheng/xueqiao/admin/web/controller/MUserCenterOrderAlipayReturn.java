package com.longsheng.xueqiao.admin.web.controller;

import org.soldier.platform.web_framework.CTemplateController;

public class MUserCenterOrderAlipayReturn extends CTemplateController{

	public void show() throws Exception {

		String charset = parameter("charset", "");
		String outTradeNo = parameter("out_trade_no", "");
		String method = parameter("method", "");
		String totalAmount = parameter("total_amount", "");
		String sign = parameter("sign", "");
		String tradeNo = parameter("trade_no", "");
		String authAppId = parameter("auth_app_id", "");
		String version = parameter("version", "");
		String appId = parameter("app_id", "");
		String signType = parameter("sign_type", "");
		String sellerId = parameter("seller_id", "");
		String timestamp = parameter("timestamp", "");

		put("charset", charset);
		put("outTradeNo", outTradeNo);
		put("method", method);
		put("totalAmount", totalAmount);
		put("sign", sign);
		put("tradeNo", tradeNo);
		put("authAppId", authAppId);
		put("version", version);
		put("appId", appId);
		put("signType", signType);
		put("sellerId", sellerId);
		put("timestamp", timestamp);
		
		render("m_user_center_order_alipay_return.html");
	}
}
