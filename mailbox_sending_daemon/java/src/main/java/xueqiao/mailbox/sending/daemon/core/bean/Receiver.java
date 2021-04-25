package xueqiao.mailbox.sending.daemon.core.bean;

public class Receiver {
    private int companyId;
    private int userId;
    private String cnName;
    private String companyCode;
    private String groupName;
    private String tel;
    private String email;

    public static Receiver copy(Receiver receiver) {
        Receiver replica = new Receiver();
        replica.setCompanyId(receiver.getCompanyId());
        replica.setUserId(receiver.getUserId());
        replica.setCnName(receiver.getCnName());
        replica.setCompanyCode(receiver.getCompanyCode());
        replica.setGroupName(receiver.getGroupName());
        replica.setTel(receiver.getTel());
        replica.setEmail(receiver.getEmail());
        return replica;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getCnName() {
        return cnName;
    }

    public void setCnName(String cnName) {
        this.cnName = cnName;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
