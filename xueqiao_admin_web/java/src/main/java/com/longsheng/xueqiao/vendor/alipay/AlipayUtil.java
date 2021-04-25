package com.longsheng.xueqiao.vendor.alipay;

import java.util.HashMap;
import java.util.Map;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.google.gson.Gson;
import com.longsheng.xueqiao.payment.thriftapi.Order;

public class AlipayUtil {

	/**
	 * @param expireTime : expire time in minutes.
	 * return : html page 
	 * */
	public static String submitOrder(Order order, int expireTime/*String orderId, String totalAmount, String productName, String description, int expireTime*/) {
		
		//String.valueOf(orderId), String.valueOf(order.getTotalAmount()), order.getProductName(), order.getProductDescription(), expireTime
		
		AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        alipayRequest.setReturnUrl(AlipayConfig.return_url);
        alipayRequest.setNotifyUrl(AlipayConfig.notify_url);

        //商户订单号，商户网站订单系统中唯一订单号，必填
        String out_trade_no = String.valueOf(order.getOrderId());
        //付款金额，必填
        String total_amount = String.valueOf(order.getTotalAmount());
        //订单名称，必填
        String subject = order.getProductName();
        //商品描述，可空
        String body = order.getProductDescription();
        
        String expireTimeStr = String.valueOf(expireTime) + "m";
        
        String passBackParams = "productId_" + order.getProductId() + "_quantity_" + order.getProductQuantity();

        Map<String, String> params = new HashMap<>();
        params.put("out_trade_no", out_trade_no);
        params.put("total_amount", total_amount);
        params.put("subject", subject);
        params.put("body", body);
        params.put("product_code", "FAST_INSTANT_TRADE_PAY");
        params.put("timeout_express", expireTimeStr);
        params.put("passback_params", passBackParams);

        alipayRequest.setBizContent(new Gson().toJson(params));

        String form = "";
        try {
            form = alipayClient.pageExecute(alipayRequest).getBody(); //调用SDK生成表单
        } catch (AlipayApiException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
//        setContentType(ResponseContentType.TEXT_HTML);
		
		return form;
	}
}
