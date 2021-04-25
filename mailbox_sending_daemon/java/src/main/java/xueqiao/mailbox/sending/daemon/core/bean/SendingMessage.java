package xueqiao.mailbox.sending.daemon.core.bean;

import xueqiao.mailbox.thriftdata.mb.MSendingChannel;
import xueqiao.mailbox.thriftdata.message.MessageContent;

import java.util.ArrayList;
import java.util.List;

public class SendingMessage {
    private long jobId;
    private long firstSendTime;
    private List<MSendingChannel> channelList;
    private List<Receiver> hostingList;
    private List<Receiver> mailList;
    private List<Receiver> smsList;
    private MessageContent content;

    public long getJobId() {
        return jobId;
    }

    public void setJobId(long jobId) {
        this.jobId = jobId;
    }

    public long getFirstSendTime() {
        return firstSendTime;
    }

    public void setFirstSendTime(long firstSendTime) {
        this.firstSendTime = firstSendTime;
    }

    public List<MSendingChannel> getChannelList() {
        return channelList;
    }

    public void setChannelList(List<MSendingChannel> channelList) {
        this.channelList = channelList;
    }

    public List<Receiver> getHostingList() {
        return hostingList;
    }

    public void setHostingList(List<Receiver> hostingList) {
        this.hostingList = hostingList;
    }

    public void addToHostingList(Receiver hosting) {
        if (hostingList == null) {
            hostingList = new ArrayList<>();
        }
        hostingList.add(hosting);
    }

    public List<Receiver> getMailList() {
        return mailList;
    }

    public void setMailList(List<Receiver> mailList) {
        this.mailList = mailList;
    }

    public void addToMailList(Receiver mail) {
        if (mailList == null) {
            mailList = new ArrayList<>();
        }
        mailList.add(mail);
    }

    public List<Receiver> getSmsList() {
        return smsList;
    }

    public void setSmsList(List<Receiver> smsList) {
        this.smsList = smsList;
    }

    public void addToSmsList(Receiver sms) {
        if (smsList == null) {
            smsList = new ArrayList<>();
        }
        smsList.add(sms);
    }

    public MessageContent getContent() {
        return content;
    }

    public void setContent(MessageContent content) {
        this.content = content;
    }
}
