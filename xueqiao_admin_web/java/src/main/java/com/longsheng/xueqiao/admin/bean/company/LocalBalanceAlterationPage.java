package com.longsheng.xueqiao.admin.bean.company;

import java.util.List;

public class LocalBalanceAlterationPage {
    List<LocalBalanceAlteration> balanceAlterationList;
    private int totalNum;
    private int totalPage;
    private int currentPage;

    public List<LocalBalanceAlteration> getBalanceAlterationList() {
        return balanceAlterationList;
    }

    public void setBalanceAlterationList(List<LocalBalanceAlteration> balanceAlterationList) {
        this.balanceAlterationList = balanceAlterationList;
    }

    public int getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(int totalNum) {
        this.totalNum = totalNum;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }
}
