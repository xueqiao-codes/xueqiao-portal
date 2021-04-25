package com.longsheng.xueqiao.admin.helper;

import com.longsheng.xueqiao.contract.thriftapi.Days;
import com.longsheng.xueqiao.contract.thriftapi.TimeSpanState;
import com.longsheng.xueqiao.payment.product.thriftapi.Operation;
import com.longsheng.xueqiao.payment.product.thriftapi.ProductPurpose;
import com.longsheng.xueqiao.payment.product.thriftapi.ProductStatus;
import com.longsheng.xueqiao.payment.product.thriftapi.ProductType;
import com.longsheng.xueqiao.payment.thriftapi.OrderStatus;

import java.util.HashMap;
import java.util.Map;

public class Mapper {

	private static Map<Integer, String> timeSpanState = new HashMap<>();
	private static Map<Integer, String> daysMap = new HashMap<>();
	private static Map<Integer, String> orderProductTypeMap = new HashMap<>();
	private static Map<Integer, String> orderProductPurposeMap = new HashMap<>();
	private static Map<Integer, String> orderProductStatusMap = new HashMap<>();
	private static Map<Integer, String> orderStatusMap = new HashMap<>();
	private static Map<Integer, String> orderOperationMap = new HashMap<>();

	static {
		/*
		 * time span state
		 * */
		timeSpanState.put(TimeSpanState.T_OPEN.getValue(), "[交易时段]");
		timeSpanState.put(TimeSpanState.REST.getValue(), "[休市时段]");
		timeSpanState.put(TimeSpanState.CLOSED.getValue(), "[闭市时段]");
		timeSpanState.put(TimeSpanState.T_PLUS_ONE_OPEN.getValue(), "[T+1交易时段]");

		/*
		 * days
		 * */
		daysMap.put(Days.SUNDAY.getValue(), "星期日");
		daysMap.put(Days.MONDAY.getValue(), "星期一");
		daysMap.put(Days.TUESDAY.getValue(), "星期二");
		daysMap.put(Days.WEDNESDAY.getValue(), "星期三");
		daysMap.put(Days.THURSDAY.getValue(), "星期四");
		daysMap.put(Days.FRIDAY.getValue(), "星期五");
		daysMap.put(Days.SATURDAY.getValue(), "星期六");

		/*
		* order product type
		* */
		orderProductTypeMap.put(ProductType.XCOIN.getValue(), "雪橇币");
		orderProductTypeMap.put(ProductType.BASIC_SPEC.getValue(), "基本型");
		orderProductTypeMap.put(ProductType.COMMON_SPEC.getValue(), "通用型");
		orderProductTypeMap.put(ProductType.ENHANCEMENT_SPEC.getValue(), "增强型");

		/*
		* order product purpose
		* */
		orderProductPurposeMap.put(ProductPurpose.NEW.getValue(), "新建");
		orderProductPurposeMap.put(ProductPurpose.UPGRADE.getValue(), "升级");
		orderProductPurposeMap.put(ProductPurpose.RECHARGE_XCOIN.getValue(), "充雪橇币");
		orderProductPurposeMap.put(ProductPurpose.RECHARGE_TIME.getValue(), "续费");
		orderProductPurposeMap.put(ProductPurpose.PERSONAL_NEW.getValue(), "个人版新建");
		orderProductPurposeMap.put(ProductPurpose.PERSONAL_RECHARGE_TIME.getValue(), "个人版续费");

		/*
		* order product status
		* */
		orderProductStatusMap.put(ProductStatus.VALID.getValue(), "有效");
		orderProductStatusMap.put(ProductStatus.INVALID.getValue(), "无效");

		/*
		* order status
		* */
		orderStatusMap.put(OrderStatus.CREATED.getValue(), "创建订单");
		orderStatusMap.put(OrderStatus.PAY_SUCCESS.getValue(), "订单支付成功");
		orderStatusMap.put(OrderStatus.SYSTEM_PROCESSED.getValue(), "系统处理完成");
		orderStatusMap.put(OrderStatus.MANUAL_PROCESSING.getValue(), "人工介入处理中");
		orderStatusMap.put(OrderStatus.SUCCESS.getValue(), "订单完成");
		orderStatusMap.put(OrderStatus.CANCELLED.getValue(), "取消订单");
		orderStatusMap.put(OrderStatus.REMOVED.getValue(), "删除订单");
		orderStatusMap.put(OrderStatus.EXPIRED.getValue(), "订单过期");

		/*
		* order operation
		* */
		orderOperationMap.put(Operation.NONE.getValue(), "无");
		orderOperationMap.put(Operation.ALLOCATE_SPEC.getValue(), "分配托管机");
		orderOperationMap.put(Operation.UPGRADE_SPEC.getValue(), "升级托管机");
		orderOperationMap.put(Operation.ALLOCATE_PERSONAL_USER_HOSTING_SERVICE.getValue(), "分配个人版云服务");
	}

	/**
	 * 将 Days 枚举变量转换为中文字符
	 */
	public static String getDayString(Days day) {
		return daysMap.get(day.getValue());
	}

	/**
	 * 将 TimeSpanState 枚举变量转换为中文字符
	 */
	public static String getTimeSpanStateString(TimeSpanState state) {
		return timeSpanState.get(state.getValue());
	}

	/**
	 * 将订单商品类型转为中文字符
	 * */
	public static String getOrderProductTypeString(ProductType type) {
		return orderProductTypeMap.get(type.getValue());
	}

	/**
	 * 将订单商品目的转为中文字符
	 * */
	public static String getOrderProductPurposeString(ProductPurpose purpose) {
		return orderProductPurposeMap.get(purpose.getValue());
	}

	/**
	 * 将订单商品状态转为中文字符
	 * */
	public static String getOrderProductStatusString(ProductStatus status) {
		return orderProductStatusMap.get(status.getValue());
	}

	/**
	 * 将订单操作转为中文字符
	 * */
	public static String getOrderOperationString(Operation operation) {
		return orderOperationMap.get(operation.getValue());
	}

	public static String getOrderStatusString(OrderStatus status) {
		return orderStatusMap.get(status.getValue());
	}
}
