package com.longsheng.xueqiao.admin.module.hosting;

import org.apache.thrift.TException;
import org.soldier.base.logger.AppLog;
import xueqiao.trade.hosting.HostingInfo;
import xueqiao.trade.hosting.HostingStatus;
import xueqiao.trade.hosting.cloud.ao.client.TradeHostingCloudAoStub;

import java.util.HashMap;
import java.util.Map;

public class MXueqiaoHosting {
    private static MXueqiaoHosting mInstance;
    private TradeHostingCloudAoStub tradeHostingCloudAoStub;

    private static Map<String, String> HOSTING_STATUS = new HashMap<>();
    static {
        HOSTING_STATUS.put("EMPTY", "空机");
        HOSTING_STATUS.put("NORMAL", "正常");
        HOSTING_STATUS.put("CLEARING", "清理中");
    }

    public static MXueqiaoHosting getInstance() {
        if (mInstance == null) {
            mInstance = new MXueqiaoHosting();
        }
        return mInstance;
    }

    private MXueqiaoHosting() {
        tradeHostingCloudAoStub = new TradeHostingCloudAoStub();
    }

    public static String getHostingStatusString(HostingStatus hostingStatus) {
        return HOSTING_STATUS.get(hostingStatus.name());
    }

    public HostingInfo queryHostingInfo(String hostingIP) {
        tradeHostingCloudAoStub.setPeerAddr(hostingIP);
        try {
            return tradeHostingCloudAoStub.getHostingInfo();
        } catch (TException e) {
            AppLog.e("MXueqiaoHosting # queryHostingInfo fail", e);
        }
        return null;
    }
}
