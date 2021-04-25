package com.longsheng.xueqiao.admin.bean.company;

public class LocalCompanyGroupSpecInfo {
    private int companyId;
    private int groupId;
    private String groupName;
    private String hostingServiceStatus;
    private String serviceType;
    private String specName;
    private String expiredTimestamp;
    private String releaseTimestamp;
    private String operateDescription;

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getHostingServiceStatus() {
        return hostingServiceStatus;
    }

    public void setHostingServiceStatus(String hostingServiceStatus) {
        this.hostingServiceStatus = hostingServiceStatus;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getSpecName() {
        return specName;
    }

    public void setSpecName(String specName) {
        this.specName = specName;
    }

    public String getExpiredTimestamp() {
        return expiredTimestamp;
    }

    public void setExpiredTimestamp(String expiredTimestamp) {
        this.expiredTimestamp = expiredTimestamp;
    }

    public String getReleaseTimestamp() {
        return releaseTimestamp;
    }

    public void setReleaseTimestamp(String releaseTimestamp) {
        this.releaseTimestamp = releaseTimestamp;
    }

    public String getOperateDescription() {
        return operateDescription;
    }

    public void setOperateDescription(String operateDescription) {
        this.operateDescription = operateDescription;
    }
}
