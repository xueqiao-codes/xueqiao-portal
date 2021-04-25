package xueqiao.mailbox.dao.util;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class JsonUtil {

    public static List<Long> convertToLongArrayList(String json) {
        if (StringUtils.isBlank(json)) {
            return new ArrayList<Long>();
        }
        return new Gson().fromJson(json, new TypeToken<ArrayList<Long>>() {
        }.getType());
    }

    public static List<Integer> convertToIntegerArrayList(String json) {
        if (StringUtils.isBlank(json)) {
            return new ArrayList<Integer>();
        }
        return new Gson().fromJson(json, new TypeToken<ArrayList<Integer>>() {
        }.getType());
    }
}
