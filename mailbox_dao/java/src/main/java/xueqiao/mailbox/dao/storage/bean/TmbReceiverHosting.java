package xueqiao.mailbox.dao.storage.bean;

public class TmbReceiverHosting {
    private long mbmId;
    private long companyId;
    private long groupId;
    private int role;

    public long getMbmId() {
        return mbmId;
    }

    public void setMbmId(long mbmId) {
        this.mbmId = mbmId;
    }

    public long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(long companyId) {
        this.companyId = companyId;
    }

    public long getGroupId() {
        return groupId;
    }

    public void setGroupId(long groupId) {
        this.groupId = groupId;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
}
