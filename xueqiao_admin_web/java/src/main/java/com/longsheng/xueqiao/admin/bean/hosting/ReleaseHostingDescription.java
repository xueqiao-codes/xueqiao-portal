package com.longsheng.xueqiao.admin.bean.hosting;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

public class ReleaseHostingDescription {
    private static final String REASON_FORCE_RELEASE = "强制释放：";
    private static final String REASON_TIMEOUT_RELEASE = "正常释放";

    private String operator;
    private String reason;
    private String releaseDay;

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getReleaseDay() {
        return releaseDay;
    }

    public void setReleaseDay(String releaseDay) {
        this.releaseDay = releaseDay;
    }

    public static String getForceReleaseReason(String reason) {
        return REASON_FORCE_RELEASE + reason;
    }

    public static String getTimeoutReleaseReason() {
        return REASON_TIMEOUT_RELEASE;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }

    public static ReleaseHostingDescription getInstanceFromJson(String jsonStr) {
        ReleaseHostingDescription instance = null;
        try {
            instance = new Gson().fromJson(jsonStr, ReleaseHostingDescription.class);
        } catch (JsonSyntaxException e) {
        }
        return instance;
    }
}
