package com.longsheng.xueqiao.admin.bean.company;

public class LocalBalanceAlteration {
    private long alterationId;
    private long companyId;
    private String operationType;
    private String alterationChannel;
    private String thirdPartyTradeNo;
    private String description;
    private String operator;
    private String alerationXCoin;
    private double xCoinBalance;

    private String createTimestamp;

    public long getAlterationId() {
        return alterationId;
    }

    public void setAlterationId(long alterationId) {
        this.alterationId = alterationId;
    }

    public long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(long companyId) {
        this.companyId = companyId;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public String getAlterationChannel() {
        return alterationChannel;
    }

    public void setAlterationChannel(String alterationChannel) {
        this.alterationChannel = alterationChannel;
    }

    public String getThirdPartyTradeNo() {
        return thirdPartyTradeNo;
    }

    public void setThirdPartyTradeNo(String thirdPartyTradeNo) {
        this.thirdPartyTradeNo = thirdPartyTradeNo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getAlerationXCoin() {
        return alerationXCoin;
    }

    public void setAlerationXCoin(String alerationXCoin) {
        this.alerationXCoin = alerationXCoin;
    }

    public double getxCoinBalance() {
        return xCoinBalance;
    }

    public void setxCoinBalance(double xCoinBalance) {
        this.xCoinBalance = xCoinBalance;
    }

    public String getCreateTimestamp() {
        return createTimestamp;
    }

    public void setCreateTimestamp(String createTimestamp) {
        this.createTimestamp = createTimestamp;
    }
}
