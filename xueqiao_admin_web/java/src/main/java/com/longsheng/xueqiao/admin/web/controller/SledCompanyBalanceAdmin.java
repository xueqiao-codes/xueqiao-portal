package com.longsheng.xueqiao.admin.web.controller;

import com.longsheng.xueqiao.admin.bean.company.LocalBalanceAlteration;
import com.longsheng.xueqiao.admin.bean.company.LocalBalanceAlterationPage;
import com.longsheng.xueqiao.admin.module.user.MXueqiaoUserCenterPayment;
import com.longsheng.xueqiao.admin.util.TimeFormator;
import com.longsheng.xueqiao.payment.balance.alteration.AlterationChannel;
import com.longsheng.xueqiao.payment.balance.alteration.BalanceAlteration;
import com.longsheng.xueqiao.payment.balance.alteration.BalanceAlterationPage;
import com.longsheng.xueqiao.payment.balance.alteration.OperationType;
import com.longsheng.xueqiao.payment.thriftapi.CompanyBalance;
import org.apache.thrift.TException;
import org.soldier.base.logger.AppLog;
import org.soldier.platform.svr_platform.comm.ErrorInfo;
import org.soldier.platform.web_framework.model.ErrorResult;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SledCompanyBalanceAdmin extends OaAuthController {

    public void show() throws Exception {

        int companyId = parameter("companyId", -1);
        String companyName = parameter("companyName", "");
        AppLog.i("SledCompanyBalanceAdmin ---- show ---- companyId : " + companyId);
        put("companyId", companyId);
        put("companyName", companyName);
        render("sled_company_balance_admin.html");
    }

    public void queryCompanyBalance() throws IOException {
        ErrorResult result = new ErrorResult();

        int companyId = parameter("companyId", 1);
        if (companyId <= 0) {
            result.setErrorCode(5);
            result.setErrorMsg("companyId(" + companyId + ")无效，请尝试刷新页面后再试");
            echoJson(result);
            return;
        }

        try {
            CompanyBalance companyBalance = MXueqiaoUserCenterPayment.getInstance().queryCompanyBalance(companyId);
            String xCoinBalanceStr = "0.0";
            if (companyBalance != null) {
                xCoinBalanceStr = String.valueOf(companyBalance.getXCoinBalance());
            }
            echoJson(xCoinBalanceStr);
        } catch(ErrorInfo errorInfo) {
            errorInfo.printStackTrace();
            result.setErrorCode(errorInfo.getErrorCode());
            result.setErrorMsg(errorInfo.getErrorMsg());
            echoJson(result);
        } catch (Throwable e) {
            e.printStackTrace();
            result.setErrorCode(5);
            result.setErrorMsg("服务器繁忙");
            echoJson(result);
        }
    }

    public void queryBalanceAlterationList() throws IOException {
        ErrorResult result = new ErrorResult();

        int companyId = parameter("companyId", 1);
        int pageIndex = parameter("pageIndex", 0);

        if (companyId <= 0) {
            result.setErrorCode(5);
            result.setErrorMsg("companyId(" + companyId + ")无效，请尝试刷新页面后再试");
            echoJson(result);
            return;
        }
        if (pageIndex < 0) {
            pageIndex = 0;
        }


        BalanceAlterationPage balanceAlterationPage = null;
        try {
            balanceAlterationPage = MXueqiaoUserCenterPayment.getInstance().queryBalanceAlterationList(companyId, pageIndex, MXueqiaoUserCenterPayment.PAGE_SIZE);
            LocalBalanceAlterationPage localBalanceAlterationPage = new LocalBalanceAlterationPage();

            if (balanceAlterationPage != null && balanceAlterationPage.getPageSize() > 0) {
                AppLog.i("SledCompanyBalanceAdmin ---- queryBalanceAlterationList ---- balanceAlterationPage size : " + balanceAlterationPage.getPageSize());

                localBalanceAlterationPage.setBalanceAlterationList(getLocalBalanceAlterationList(balanceAlterationPage.getPage()));
                localBalanceAlterationPage.setTotalNum(balanceAlterationPage.getTotal());
                localBalanceAlterationPage.setTotalPage((balanceAlterationPage.getTotal() + MXueqiaoUserCenterPayment.PAGE_SIZE - 1) / MXueqiaoUserCenterPayment.PAGE_SIZE);
                localBalanceAlterationPage.setCurrentPage(pageIndex + 1);
            } else {
                localBalanceAlterationPage.setBalanceAlterationList(new ArrayList<>());
                localBalanceAlterationPage.setTotalNum(0);
                localBalanceAlterationPage.setTotalPage(1);
                localBalanceAlterationPage.setCurrentPage(1);
            }
            echoJson(localBalanceAlterationPage);

        } catch(ErrorInfo errorInfo) {
            errorInfo.printStackTrace();
            result.setErrorCode(errorInfo.getErrorCode());
            result.setErrorMsg(errorInfo.getErrorMsg());
            echoJson(result);
        } catch (Throwable e) {
            e.printStackTrace();
            result.setErrorCode(5);
            result.setErrorMsg("服务器繁忙");
            echoJson(result);
        }
    }

    public void alterBalance() throws IOException {
        ErrorResult result = new ErrorResult();

        String oaUserName = getUserName();
        if (oaUserName == null || oaUserName.isEmpty()) {
            result.setErrorCode(5);
            result.setErrorMsg("登录信息过期，请重新登录后再操作");
            echoJson(result);
            return;
        }

        int companyId = parameter("companyId", 1);
        String operationType = parameter("operationType", "");
        String alterationChannel = parameter("alterationChannel", "");
        String thirdPartyTradeNo = parameter("thirdPartyTradeNo", "");
        String description = parameter("description", "");
        String alerationXCoinStr = parameter("alerationXCoin", "0");

        AppLog.i("SledCompanyBalanceAdmin ---- companyId : " + companyId + ", operationType : " + operationType + ", alterationChannel : " + alterationChannel
            + ", thirdPartyTradeNo : " + thirdPartyTradeNo + ", description : " + description + ", alerationXCoinStr : " + alerationXCoinStr);

        if (companyId <= 0) {
            AppLog.e("SledCompanyBalanceAdmin ---- alterBalance ---- companyId : " + companyId);
            result.setErrorCode(7);
            result.setErrorMsg("公司ID(" + companyId + ")不正确，请尝试刷新页面后再试");
            echoJson(result);
            return;
        }

        double alerationXCoin = 0.0;
        try {
            alerationXCoin = Double.parseDouble(alerationXCoinStr);
        } catch (NumberFormatException e) {
            AppLog.e("SledCompanyBalanceAdmin ---- alterBalance ---- parseDouble ---- e : " + e.toString());
            result.setErrorCode(6);
            result.setErrorMsg("雪橇币数额格式不正确");
            echoJson(result);
            return;
        }

        try {
            BalanceAlteration balanceAlteration = new BalanceAlteration();

            balanceAlteration.setCompanyId(companyId);
            balanceAlteration.setOperationType(OperationType.valueOf(operationType));
            balanceAlteration.setAlterationChannel(AlterationChannel.valueOf(alterationChannel));
            balanceAlteration.setThirdPartyTradeNo(thirdPartyTradeNo);
            balanceAlteration.setDescription(description);
            balanceAlteration.setOperator(oaUserName);
            balanceAlteration.setAlerationXCoin(alerationXCoin);

            MXueqiaoUserCenterPayment.getInstance().alterBalance(balanceAlteration);
        } catch(ErrorInfo errorInfo) {
            errorInfo.printStackTrace();
            result.setErrorCode(errorInfo.getErrorCode());
            result.setErrorMsg(errorInfo.getErrorMsg());
            echoJson(result);
        } catch (Throwable e) {
            e.printStackTrace();
            result.setErrorCode(5);
            result.setErrorMsg("服务器繁忙");
            echoJson(result);
        }
    }

    public void modifyAlterBalanceRecord() throws IOException {
        ErrorResult result = new ErrorResult();

        int alterationId = parameter("alterationId", 1);
        String description = parameter("description", "");

        try {
            MXueqiaoUserCenterPayment.getInstance().modifyAlterBalanceRecord(alterationId, description);
        } catch(ErrorInfo errorInfo) {
            errorInfo.printStackTrace();
            result.setErrorCode(errorInfo.getErrorCode());
            result.setErrorMsg(errorInfo.getErrorMsg());
            echoJson(result);
        } catch (Throwable e) {
            e.printStackTrace();
            result.setErrorCode(5);
            result.setErrorMsg("服务器繁忙");
            echoJson(result);
        }
    }

    private List<LocalBalanceAlteration> getLocalBalanceAlterationList(List<BalanceAlteration> balanceAlterationList) throws ErrorInfo, TException {
        List<LocalBalanceAlteration> localBalanceAlterationList = new ArrayList<LocalBalanceAlteration>();

        for(BalanceAlteration balanceAlteration : balanceAlterationList) {
            LocalBalanceAlteration localBalanceAlteration = new LocalBalanceAlteration();
            localBalanceAlteration.setAlterationId(balanceAlteration.getAlterationId());
            localBalanceAlteration.setCompanyId(balanceAlteration.getCompanyId());
            localBalanceAlteration.setOperationType(MXueqiaoUserCenterPayment.getBalanceAlterationOperationType().get(balanceAlteration.getOperationType().name()));
            localBalanceAlteration.setAlterationChannel(MXueqiaoUserCenterPayment.getBalanceAlterationChannel().get(balanceAlteration.getAlterationChannel().name()));
            localBalanceAlteration.setThirdPartyTradeNo(balanceAlteration.getThirdPartyTradeNo());
            localBalanceAlteration.setDescription(balanceAlteration.getDescription());
            localBalanceAlteration.setOperator(balanceAlteration.getOperator());
            localBalanceAlteration.setAlerationXCoin(String.valueOf(balanceAlteration.getAlerationXCoin()));
            localBalanceAlteration.setxCoinBalance(balanceAlteration.getXCoinBalance());
            localBalanceAlteration.setCreateTimestamp(TimeFormator.timeStampToDate(balanceAlteration.getCreateTimestamp()));

            localBalanceAlterationList.add(localBalanceAlteration);
        }

        return localBalanceAlterationList;
    }
}
