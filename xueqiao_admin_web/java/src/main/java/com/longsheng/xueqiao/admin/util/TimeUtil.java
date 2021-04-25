package com.longsheng.xueqiao.admin.util;

/**
 *  TimeUtil
 * */
public class TimeUtil {

    public static final int DAY_SECONDS = 60 * 60 * 24;

    public static final int getCurrentTimeSeconds() {
        return (int) (System.currentTimeMillis() / 1000);
    }
}
