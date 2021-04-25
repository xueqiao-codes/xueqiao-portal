package xueqiao.mailbox.dao.storage.bean;

import java.util.List;

public class TmbMessagePage {
    private int totalNum;
    private List<TmbMessage> messageList;

    public int getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(int totalNum) {
        this.totalNum = totalNum;
    }

    public List<TmbMessage> getMessageList() {
        return messageList;
    }

    public void setMessageList(List<TmbMessage> messageList) {
        this.messageList = messageList;
    }
}
