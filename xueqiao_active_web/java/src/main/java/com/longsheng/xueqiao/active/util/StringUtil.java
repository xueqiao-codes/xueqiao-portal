package com.longsheng.xueqiao.active.util;

import java.text.DecimalFormat;

public class StringUtil {

    private static DecimalFormat DOUBLE_FORMAT = new DecimalFormat("######0.0#################");

    public static String getDoubleString(double d) {
        return DOUBLE_FORMAT.format(d);
    }
}
