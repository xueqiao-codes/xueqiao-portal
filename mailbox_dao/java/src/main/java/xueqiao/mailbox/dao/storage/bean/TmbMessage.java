package xueqiao.mailbox.dao.storage.bean;

import xueqiao.mailbox.thriftdata.mb.*;
import xueqiao.mailbox.thriftdata.message.MLevel;
import xueqiao.mailbox.thriftdata.message.MType;

public class TmbMessage {
    private long mbmId;
    private MSendingPolicy policy;
    private int channel;
    private MType contentType;
    private MLevel contentLevel;
    private String contentTitle;
    private String contentSummary;
    private String contentBody;
    private MStatus status;
    private String operator = "";
    private long createTimestamp;
    private long lastModityTimestamp;

    public long getMbmId() {
        return mbmId;
    }

    public void setMbmId(long mbmId) {
        this.mbmId = mbmId;
    }

    public MSendingPolicy getPolicy() {
        return policy;
    }

    public void setPolicy(MSendingPolicy policy) {
        this.policy = policy;
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

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public MStatus getStatus() {
        return status;
    }

    public void setStatus(MStatus status) {
        this.status = status;
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
