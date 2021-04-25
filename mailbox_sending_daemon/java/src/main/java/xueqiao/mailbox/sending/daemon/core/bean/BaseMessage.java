package xueqiao.mailbox.sending.daemon.core.bean;

import xueqiao.mailbox.thriftdata.mb.*;
import xueqiao.mailbox.thriftdata.message.MessageContent;

import java.util.List;

public class BaseMessage {
    private long jobId;
    private long mbmId;
    private List<MSendingChannel> channelList;
    private List<MReceiverSms> smsList;
    private List<MReceiverMail> mailList;
    private List<MReceiverHosting> hostingList;
    private MessageContent content;

//    public static BaseMessage getFromMBMessage(MBMessage mbMessage) {
//        BaseMessage baseMessage = new BaseMessage();
//        baseMessage.setMbmId(mbMessage.getMbmId());
//        baseMessage.setChannelList(mbMessage.getChannelList());
//        baseMessage.setSmsList(mbMessage.getSmsList());
//        baseMessage.setMailList(mbMessage.getMailList());
//        baseMessage.setHostingList(mbMessage.getHostingList());
//        baseMessage.setContent(mbMessage.getContent());
//        return baseMessage;
//    }

    public static BaseMessage getFromMBMessageJob(MBMessageJob mbMessageJob) {
        BaseMessage baseMessage = new BaseMessage();
        baseMessage.setJobId(mbMessageJob.getJobId());
        baseMessage.setMbmId(mbMessageJob.getMbmId());
        baseMessage.setChannelList(mbMessageJob.getChannelList());
        baseMessage.setSmsList(mbMessageJob.getSmsList());
        baseMessage.setMailList(mbMessageJob.getMailList());
        baseMessage.setHostingList(mbMessageJob.getHostingList());
        baseMessage.setContent(mbMessageJob.getContent());
        return baseMessage;
    }

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

    public List<MSendingChannel> getChannelList() {
        return channelList;
    }

    public void setChannelList(List<MSendingChannel> channelList) {
        this.channelList = channelList;
    }

    public List<MReceiverSms> getSmsList() {
        return smsList;
    }

    public void setSmsList(List<MReceiverSms> smsList) {
        this.smsList = smsList;
    }

    public List<MReceiverMail> getMailList() {
        return mailList;
    }

    public void setMailList(List<MReceiverMail> mailList) {
        this.mailList = mailList;
    }

    public List<MReceiverHosting> getHostingList() {
        return hostingList;
    }

    public void setHostingList(List<MReceiverHosting> hostingList) {
        this.hostingList = hostingList;
    }

    public MessageContent getContent() {
        return content;
    }

    public void setContent(MessageContent content) {
        this.content = content;
    }
}
