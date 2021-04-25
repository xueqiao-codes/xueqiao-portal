package com.longsheng.xueqiao.admin.util;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringUtil {

    private static DecimalFormat DOUBLE_FORMAT = new DecimalFormat("######0.0#################");

    public static String getDoubleString(double d) {
        return DOUBLE_FORMAT.format(d);
    }

    public static String list2String(List<String> strList) {
        if (strList == null || strList.isEmpty()) {
            return "";
        } else {
            return new Gson().toJson(strList);
        }
    }

    public static List<String> string2List(String listStr) {
        if (listStr == null || listStr.isEmpty()) {
            return new ArrayList<String>();
        } else {
            return new Gson().fromJson(listStr, new TypeToken<List<String>>() {}.getType());
        }
    }

    public static String map2String(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return "";
        } else {
            return new Gson().toJson(map);
        }
    }

    public static Map<String, String> string2Map(String mapStr) {
        if (mapStr == null || mapStr.isEmpty()) {
            return new HashMap<String, String>();
        } else {
            return new Gson().fromJson(mapStr, new TypeToken<Map<String, String>>() {}.getType());
        }
    }
}
