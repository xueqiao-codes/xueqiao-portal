package com.longsheng.xueqiao.admin.module.sms;

import com.longsheng.xueqiao.goose.thriftapi.client.GooseAoStub;
import org.apache.thrift.TException;
import xueqiao.company.CompanyEntry;

public class SmsHandler {

    public static final String ALLOC_HOSINT_MACHINE = "开通";
    public static final String UPGRADE_HOSINT_MACHINE = "升级";

    private GooseAoStub gooseAoStub = new GooseAoStub();

    private static SmsHandler instance = new SmsHandler();

    public static SmsHandler getInstance() {
        return instance;
    }

    public void sendUserNotificationSms(CompanyEntry companyEntry, String groupName, String operation) throws TException {
        StringBuilder stringBuilder = new StringBuilder("云服务（");
        stringBuilder.append(groupName);
        stringBuilder.append(")");
        stringBuilder.append("已");
        stringBuilder.append(operation);
        stringBuilder.append("成功");
        sendUserNotificationSms(companyEntry.getTelephone(), stringBuilder.toString());
    }

    public void sendUserReleaseNotificationSms(CompanyEntry companyEntry, String groupName) throws TException {
        StringBuilder stringBuilder = new StringBuilder("云服务（");
        stringBuilder.append(groupName);
        stringBuilder.append(")");
        stringBuilder.append("已被释放,服务器所有数据已经安全清除，无法恢复，感谢您的使用");
        sendUserNotificationSms(companyEntry.getTelephone(), stringBuilder.toString());
    }

    public void sendMaintenanceNotificationSms(String msg) throws TException {
        gooseAoStub.sendMaintenanceNotificationSms(msg);
    }

    public void sendUserNotificationSms(String mobileNo, String msg) throws TException {
        gooseAoStub.sendUserNotificationSms(mobileNo, msg);
    }

    public void sendPersonalUserHostingServiceAllocateCompletedSms(String tel) throws TException {
        StringBuilder stringBuilder = new StringBuilder("您的雪橇交易云服务已开通，感谢您对雪橇的支持，请下载客户端进行体验");
        sendUserNotificationSms(tel, stringBuilder.toString());
    }
}
