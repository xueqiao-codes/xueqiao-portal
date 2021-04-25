package com.longsheng.xueqiao.admin.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.apache.thrift.TException;
import org.soldier.base.StringFactory;
import org.soldier.base.logger.AppLog;
import org.soldier.platform.svr_platform.comm.ErrorInfo;
import org.soldier.platform.web_framework.model.ErrorResult;
import org.soldier.platform.web_framework.util.GsonFactory;

import com.longsheng.xueqiao.admin.module.user.MXueqiaoUserCenter;
import com.longsheng.xueqiao.admin.module.user.MXueqiaoUserCenterPayment;
import com.longsheng.xueqiao.admin.module.user.bean.LocalOrder;
import com.longsheng.xueqiao.broker.dao.thriftapi.client.BrokerDaoServiceStub;
import com.longsheng.xueqiao.contract.thriftapi.client.ContractServiceStub;
import com.longsheng.xueqiao.payment.thriftapi.Order;
import com.longsheng.xueqiao.payment.thriftapi.OrderPage;
import com.longsheng.xueqiao.vendor.alipay.AlipayUtil;

import freemarker.template.TemplateException;
import xueqiao.company.CompanyEntry;
import xueqiao.company.CompanyPageResult;

public class MUserCenterOrderAdmin extends OaAuthController {

	private static final int TIME_OUT = 3000;
	private static final int PAGE_SIZE = 10;
	private static final int PAGE_SIZE_MAX = Integer.MAX_VALUE;

	private MXueqiaoUserCenterPayment mMXueqiaoUserCenterPayment;
	
	private int mTotalPage = 1;
	private int mTotalNum = 0;
	
	public void show() throws Exception {

		int requestPage = parameter("requestPage", 1);
		if (requestPage < 1) {
			requestPage = 1;
		}
		
		setBaseQueryUrl();
		
		requestPage = queryOrderList(requestPage - 1);
		
		if (mTotalPage < 1) {
			mTotalPage = 1;
		}
		put("totalPage", mTotalPage);
		put("totalNum", mTotalNum);
		put("currentPage", requestPage + 1);
		
		render("m_user_center_order_admin.html");
	}

	private void setBaseQueryUrl() {
		StringBuffer baseQueryUrl = new StringBuffer();
		String baseUrl = this.baseUrl;
		int l = baseUrl.indexOf("requestPage");
		if (l > 0) {
			baseUrl = baseUrl.substring(0, l);
		}
		baseQueryUrl.append(baseUrl);
		baseQueryUrl.append("/MUserCenterOrderAdmin/show?");
		put("baseQueryUrl", baseQueryUrl);
	}
	
	private int queryOrderList(int pageIndex) throws TException {

		if (mMXueqiaoUserCenterPayment == null) {
			mMXueqiaoUserCenterPayment = new MXueqiaoUserCenterPayment();
		}

		OrderPage orderPage = mMXueqiaoUserCenterPayment.queryOrderList(pageIndex, 0, 0, 0, null);
		
		if (orderPage != null && orderPage.getPageSize() > 0) {
			List<LocalOrder> localOrderList = new ArrayList<LocalOrder>();
			for (Order order : orderPage.getPage()) {
				LocalOrder localOrder = new LocalOrder();
				localOrder.setOrderId(order.getOrderId());
				localOrder.setSource(order.getSource().name());
				localOrder.setProductId(order.getProductId());
				localOrder.setCompanyId(order.getCompanyId());
				localOrder.setCompanyGroupId(order.getCompanyGroupId());
				localOrder.setProductName(order.getProductName());
				localOrder.setProductDescription(order.getProductDescription());
				localOrder.setProductQuantity(order.getProductQuantity());
				localOrder.setPrice(order.getPrice());
				localOrder.setCurrencyType(order.getCurrencyType().name());
				localOrder.setTotalAmount(order.getTotalAmount());
				localOrder.setPayType(order.getPayType().name());
				localOrder.setThirdPartyOrderNo(order.getThirdPartyOrderNo());
				localOrder.setStatus(order.getStatus().name());
				localOrder.setTradeInfo(order.getTradeInfo());
				localOrder.setNeedOperator(order.isNeedOperator());
				localOrder.setOperator(order.getOperator());
				localOrder.setOperation(order.getOperation().name());
				localOrder.setCreateTimestamp(order.getCreateTimestamp());
				
				localOrderList.add(localOrder);
			}
			
			put("orderList", localOrderList);
		}

		mTotalNum = orderPage.getTotal();
		mTotalPage = (mTotalNum + MXueqiaoUserCenterPayment.PAGE_SIZE - 1) / MXueqiaoUserCenterPayment.PAGE_SIZE;
		return pageIndex > mTotalPage ? mTotalPage : pageIndex;
	}
	
	public void addOrder() throws IOException {
		if (mMXueqiaoUserCenterPayment == null) {
			mMXueqiaoUserCenterPayment = new MXueqiaoUserCenterPayment();
		}
		
		ErrorResult result = new ErrorResult();
		
		String content = StringFactory.newUtf8String(IOUtils.toByteArray(getServletRequest().getInputStream()));
		AppLog.i("MUserCenterOrderAdmin ---- addOrder ---- content : " + content);
		
		LocalOrder localOrder = GsonFactory.getGson().fromJson(content, LocalOrder.class);
		
		try {
			mMXueqiaoUserCenterPayment.placeOrder(localOrder);
		} catch(ErrorInfo errorInfo) {
			errorInfo.printStackTrace();
			result.setErrorCode(errorInfo.getErrorCode());
			result.setErrorMsg(errorInfo.getErrorMsg());
			echoJson(result);
			return;
		} catch (Throwable e) {
			e.printStackTrace();
			result.setErrorCode(5);
			result.setErrorMsg("服务器繁忙");
			echoJson(result);
			return;
		}
		echoJson(result);
	}

}
