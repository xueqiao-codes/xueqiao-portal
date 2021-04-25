package xueqiao.mailbox.dao.storage.bean;

import java.util.List;

public class TmbMessageJobPage {
    private int totalNum;
    private List<TmbMessageJob> jobList;

    public int getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(int totalNum) {
        this.totalNum = totalNum;
    }

    public List<TmbMessageJob> getJobList() {
        return jobList;
    }

    public void setJobList(List<TmbMessageJob> jobList) {
        this.jobList = jobList;
    }
}
