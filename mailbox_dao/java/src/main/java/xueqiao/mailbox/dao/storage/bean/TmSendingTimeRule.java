package xueqiao.mailbox.dao.storage.bean;

import xueqiao.mailbox.thriftdata.mb.MSendingTimeRepeatUnit;

public class TmSendingTimeRule {
    private long mbmId;
    private long mbStartTime;
    private MSendingTimeRepeatUnit repeatUnit;
    private int repeatCount;
    private String dayTimeList;
    private String unitTimeList;
    private long createTimestamp;
    private long lastModityTimestamp;

    public long getMbmId() {
        return mbmId;
    }

    public void setMbmId(long mbmId) {
        this.mbmId = mbmId;
    }

    public long getMbStartTime() {
        return mbStartTime;
    }

    public void setMbStartTime(long mbStartTime) {
        this.mbStartTime = mbStartTime;
    }

    public MSendingTimeRepeatUnit getRepeatUnit() {
        return repeatUnit;
    }

    public void setRepeatUnit(MSendingTimeRepeatUnit repeatUnit) {
        this.repeatUnit = repeatUnit;
    }

    public int getRepeatCount() {
        return repeatCount;
    }

    public void setRepeatCount(int repeatCount) {
        this.repeatCount = repeatCount;
    }

    public String getDayTimeList() {
        return dayTimeList;
    }

    public void setDayTimeList(String dayTimeList) {
        this.dayTimeList = dayTimeList;
    }

    public String getUnitTimeList() {
        return unitTimeList;
    }

    public void setUnitTimeList(String unitTimeList) {
        this.unitTimeList = unitTimeList;
    }

    public long getCreateTimestamp() {
        return createTimestamp;
    }

    public void setCreateTimestamp(long createTimestamp) {
        this.createTimestamp = createTimestamp;
    }

    public long getLastModityTimestamp() {
        return lastModityTimestamp;
    }

    public void setLastModityTimestamp(long lastModityTimestamp) {
        this.lastModityTimestamp = lastModityTimestamp;
    }
}
