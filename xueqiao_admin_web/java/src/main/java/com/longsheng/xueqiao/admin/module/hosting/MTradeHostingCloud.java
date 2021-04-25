package com.longsheng.xueqiao.admin.module.hosting;

import org.apache.thrift.TException;
import xueqiao.trade.hosting.cloud.ao.HostingInitReq;
import xueqiao.trade.hosting.cloud.ao.HostingInitResp;
import xueqiao.trade.hosting.cloud.ao.client.TradeHostingCloudAoAsyncStub;
import xueqiao.trade.hosting.cloud.ao.client.TradeHostingCloudAoStub;

public class MTradeHostingCloud {

    private static MTradeHostingCloud mInstance;

    private TradeHostingCloudAoAsyncStub mTradeHostingCloudAoAsyncStub;
    private TradeHostingCloudAoStub mTradeHostingCloudAoStub;

    private MTradeHostingCloud() {
        mTradeHostingCloudAoAsyncStub = new TradeHostingCloudAoAsyncStub();
        mTradeHostingCloudAoStub = new TradeHostingCloudAoStub();
    }

    public static MTradeHostingCloud getInstance() {
        if (mInstance == null) {
            mInstance = new MTradeHostingCloud();
        }
        return mInstance;
    }

    public HostingInitResp initHosting(String innerIp, HostingInitReq req) throws TException {
        mTradeHostingCloudAoStub.setPeerAddr(innerIp);
        return mTradeHostingCloudAoStub.initHosting(req);
    }
}
