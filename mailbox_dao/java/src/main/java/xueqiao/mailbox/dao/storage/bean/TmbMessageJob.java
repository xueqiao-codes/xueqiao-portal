package xueqiao.mailbox.dao.storage.bean;

import xueqiao.mailbox.thriftdata.mb.MJStatus;
import xueqiao.mailbox.thriftdata.message.MLevel;
import xueqiao.mailbox.thriftdata.message.MType;

public class TmbMessageJob {
    public long jobId;
    public long mbmId;
    public int channel;
    private MType contentType;
    private MLevel contentLevel;
    private MJStatus status;
    private String contentTitle;
    private String contentSummary;
    private String contentBody;
    private String errorDescription;
    private String operator = "";
    public long createTimestamp;
    public long lastModityTimestamp;

    public long getJobId() {
        return jobId;
    }

    public void setJobId(long jobId) {
        this.jobId = jobId;
    }

    public long getMbmId() {
        return mbmId;
    }

    public void setMbmId(long mbmId) {
        this.mbmId = mbmId;
    }

    public int getChannel() {
        return channel;
    }

    public void setChannel(int channel) {
        this.channel = channel;
    }

    public MType getContentType() {
        return contentType;
    }

    public void setContentType(MType contentType) {
        this.contentType = contentType;
    }

    public MLevel getContentLevel() {
        return contentLevel;
    }

    public void setContentLevel(MLevel contentLevel) {
        this.contentLevel = contentLevel;
    }

    public MJStatus getStatus() {
        return status;
    }

    public void setStatus(MJStatus status) {
        this.status = status;
    }

    public String getContentTitle() {
        return contentTitle;
    }

    public void setContentTitle(String contentTitle) {
        this.contentTitle = contentTitle;
    }

    public String getContentSummary() {
        return contentSummary;
    }

    public void setContentSummary(String contentSummary) {
        this.contentSummary = contentSummary;
    }

    public String getContentBody() {
        return contentBody;
    }

    public void setContentBody(String contentBody) {
        this.contentBody = contentBody;
    }

    public String getErrorDescription() {
        return errorDescription;
    }

    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
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
