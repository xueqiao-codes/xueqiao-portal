package com.longsheng.xueqiao.admin.util;

import org.soldier.base.logger.AppLog;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by walter on 02/08/2017.
 */
public class Utils<T> {

    public List<T> getMembers(int pageSize, int pageIndex, List<T> members) {
        int fromIndex = pageIndex * pageSize;
        int endIndex = (pageIndex + 1) * pageSize;

        if (members.size() < endIndex + 1) {
            endIndex = members.size();
        }

        AppLog.d("fromIndex:" + fromIndex);
        AppLog.d("endIndex:" + endIndex);
        List<T> result = new ArrayList<>();
        if (endIndex > fromIndex) {
            result = members.subList(fromIndex, endIndex);
        }
        return result;
    }

    public static String dateInt2String(int date) {

        if (date == 0) {
            return "";
        }

        long longtime = (long) date * 1000;
        Date date1 = new Date(longtime);

        SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd");
        String dateText = df2.format(date1);
        return dateText;
    }
}
