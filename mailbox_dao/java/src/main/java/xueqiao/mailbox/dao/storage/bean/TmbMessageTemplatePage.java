package xueqiao.mailbox.dao.storage.bean;

import java.util.List;

public class TmbMessageTemplatePage {
    private int totalNum;
    private List<TmbMessageTemplate> templateList;

    public int getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(int totalNum) {
        this.totalNum = totalNum;
    }

    public List<TmbMessageTemplate> getTemplateList() {
        return templateList;
    }

    public void setTemplateList(List<TmbMessageTemplate> templateList) {
        this.templateList = templateList;
    }
}
