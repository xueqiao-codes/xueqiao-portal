package com.longsheng.xueqiao.active.helper;

import com.longsheng.xueqiao.contract.thriftapi.Days;
import com.longsheng.xueqiao.contract.thriftapi.TimeSpanState;

import java.util.HashMap;
import java.util.Map;

public class Mapper {

	private static Map<Integer, String> timeSpanState = new HashMap<>();
	private static Map<Integer, String> daysMap = new HashMap<>();

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
}
