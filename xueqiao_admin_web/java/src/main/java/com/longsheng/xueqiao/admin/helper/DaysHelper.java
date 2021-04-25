package com.longsheng.xueqiao.admin.helper;

import com.longsheng.xueqiao.contract.thriftapi.Days;

public class DaysHelper {

	/**
	 * get previous week day
	 */
	public static Days getPreviousDay(Days day) {
		int dayValue = day.getValue();
		dayValue--;
		if (dayValue < Days.SUNDAY.getValue()) {
			dayValue = Days.SATURDAY.getValue();
		}
		return Days.findByValue(dayValue);
	}

	/**
	 * get next week day
	 */
	public static Days getNextDay(Days day) {
		int dayValue = day.getValue();
		dayValue++;
		if (dayValue > Days.SATURDAY.getValue()) {
			dayValue = Days.SUNDAY.getValue();
		}
		return Days.findByValue(dayValue);
	}
}
