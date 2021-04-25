package com.longsheng.xueqiao.admin.web.controller;

import org.soldier.base.logger.AppLog;
import com.longsheng.xueqiao.admin.module.user.MXueqiaoUserCenterPayment;
import com.longsheng.xueqiao.payment.product.thriftapi.CurrencyType;
import com.longsheng.xueqiao.payment.thriftapi.CheckPrePayResp;
import com.longsheng.xueqiao.payment.thriftapi.Order;
import com.longsheng.xueqiao.payment.thriftapi.PayOrderInfo;
import com.longsheng.xueqiao.vendor.alipay.AlipayUtil;

public class MUserCenterOrderPayPage extends OaAuthController {

	private MXueqiaoUserCenterPayment mMXueqiaoUserCenterPayment;
	
	public void show() throws Exception {

		int orderId = parameter("orderId", -1);
		
		if (mMXueqiaoUserCenterPayment == null) {
			mMXueqiaoUserCenterPayment = new MXueqiaoUserCenterPayment();
		}
		
		CheckPrePayResp checkPrePayResp = mMXueqiaoUserCenterPayment.checkOrderPrePay(orderId);
		String htmlPageResult = "";
		Order order = null;
		AppLog.i("MXueqiaoUserCenterPayment ---- payOrder ---- orderId : " + orderId + ", checkPrePayResp.isValid() : " + checkPrePayResp.isValid());
		if (checkPrePayResp.isValid()) {
			order = checkPrePayResp.getOrder();
			if (order != null) {
				int expireTime = (int)(3600 - (System.currentTimeMillis() / 1000 - order.getCreateTimestamp())) / 60;
				AppLog.i("MXueqiaoUserCenterPayment ---- payOrder ---- order.getCurrencyType()  : " + order.getCurrencyType() + ", order.getCreateTimestamp() : " + order.getCreateTimestamp() + ", expireTime : " + expireTime + ", order.getTotalAmount() : " + order.getTotalAmount() + ", order.getTotalAmount() : " + order.getTotalAmount() + ", order.getProductDescription() : " + order.getProductDescription());
				
				if (expireTime < 1) {
					htmlPageResult = "订单过期";
				} else {
					if (order.getCurrencyType() == CurrencyType.XCOIN) {
						/* pay by xueqiao coin */
						PayOrderInfo payOrderInfo = new PayOrderInfo();
						payOrderInfo.setOrderId(order.getOrderId());
						payOrderInfo.setPayType(order.getPayType());
						payOrderInfo.setThirdPartyOrderNo(order.getThirdPartyOrderNo());
						payOrderInfo.setTotalAmount(order.getTotalAmount());
						payOrderInfo.setTradeInfo(order.getTradeInfo());
						payOrderInfo.setProductId(order.getProductId());
						payOrderInfo.setQuantity(order.getProductQuantity());
						
						mMXueqiaoUserCenterPayment.payOrder(payOrderInfo);
						htmlPageResult = "xcoin pay success";
					} else {
						/* pay by alipay */
						htmlPageResult = AlipayUtil.submitOrder(order, expireTime);
					}
				}
			} else {
				htmlPageResult = "查找订单失败";
			}
		} else {
			htmlPageResult = "订单信息校验失败  : " + checkPrePayResp.getErr().getErrorCode() + ", " + checkPrePayResp.getErr().getErrorMsg();
		}
		
		put("htmlPage", htmlPageResult);
		render("m_user_center_order_pay_page.html");
	}
}
