package com.longsheng.xueqiao.admin.util;

import java.text.DecimalFormat;

public class NumberUtil {

	private static DecimalFormat DOUBLE_FORMAT = new DecimalFormat("######0.0#################");
	
	public static String doubleToString(double d) {
		return DOUBLE_FORMAT.format(d);
	}
}
