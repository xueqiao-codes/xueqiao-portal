package xueqiao.mailbox.dao.bean;

import xueqiao.mailbox.thriftdata.message.MLevel;
import xueqiao.mailbox.thriftdata.message.MType;

/**
 * Local version of
 *
 * @see xueqiao.mailbox.thriftdata.message.MessageContent
 */
public class LMessageContent {
    private MType type;
    private MLevel level;
    private String title;
    private String summary;
    private String content;

    public MType getType() {
        return type;
    }

    public void setType(MType type) {
        this.type = type;
    }

    public MLevel getLevel() {
        return level;
    }

    public void setLevel(MLevel level) {
        this.level = level;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
