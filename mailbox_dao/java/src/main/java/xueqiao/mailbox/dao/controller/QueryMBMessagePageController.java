package xueqiao.mailbox.dao.controller;

import org.soldier.platform.page.IndexedPageOption;
import org.soldier.platform.svr_platform.comm.ErrorInfo;
import org.soldier.platform.svr_platform.container.TServiceCntl;
import xueqiao.mailbox.dao.controller.base.AbstractController;
import xueqiao.mailbox.dao.storage.bean.TmSendingTimeRule;
import xueqiao.mailbox.dao.storage.bean.TmbMessage;
import xueqiao.mailbox.dao.storage.bean.TmbMessagePage;
import xueqiao.mailbox.dao.storage.bean.TmbReceiverHosting;
import xueqiao.mailbox.dao.storage.handler.*;
import xueqiao.mailbox.dao.util.CollectionUtil;
import xueqiao.mailbox.dao.util.MessageUtil;
import xueqiao.mailbox.thriftdata.mb.*;
import xueqiao.mailbox.thriftdata.req.MBMessagePage;
import xueqiao.mailbox.thriftdata.req.QueryMBMessageOption;

import java.util.*;

public class QueryMBMessagePageController extends AbstractController {

    // params
    private QueryMBMessageOption queryOption = null;
    private IndexedPageOption pageOption = null;

    private TmbMessagePage tmbMessagePage = null;
    private Set<Long> mbmIdSet = null;

    private Map<Long, MSendingTimeRule> timeRuleMap = null;
    private Map<Long, List<MReceiverSms>> mReceiverSmsMap = null;
    private Map<Long, List<MReceiverMail>> mReceiverMailMap = null;
    private Map<Long, List<MReceiverHosting>> mReceiverHostingMap = null;

    public QueryMBMessagePageController(TServiceCntl oCntl) {
        super(oCntl);
    }

    public QueryMBMessagePageController params(QueryMBMessageOption queryOption, IndexedPageOption pageOption) {
        this.queryOption = queryOption;
        this.pageOption = pageOption;
        return this;
    }

    @Override
    public void checkParams() throws ErrorInfo {
        // check nothing here
    }

    public MBMessagePage doQuery() throws ErrorInfo {
        queryTmbMessagePage();
        queryTmSendingTimeRuleList();
        queryReceiverSmsList();
        queryReceiverMailList();
        queryReceiverHostingList();
        return converge();
    }

    private void queryTmbMessagePage() throws ErrorInfo {
        tmbMessagePage = MBMessageHandler.queryPage(getDalSetDataSource(), queryOption, pageOption);
        if (tmbMessagePage != null && CollectionUtil.isListNotBlank(tmbMessagePage.getMessageList())) {
            mbmIdSet = new HashSet<>();
            for (TmbMessage tmbMessage : tmbMessagePage.getMessageList()) {
                mbmIdSet.add(tmbMessage.getMbmId());
            }
        }
    }

    private void queryTmSendingTimeRuleList() throws ErrorInfo {
        if (mbmIdSet != null) {
            List<TmSendingTimeRule> tmSendingTimeRuleList = MSendingTimeRuleHandler.queryList(getDalSetDataSource(), mbmIdSet);
            if (CollectionUtil.isListNotBlank(tmSendingTimeRuleList)) {
                timeRuleMap = new HashMap<>();
                for (TmSendingTimeRule timeRule : tmSendingTimeRuleList) {
                    timeRuleMap.put(timeRule.getMbmId(), MessageUtil.convertTmSendingTimeRuleToM(timeRule));
                }
            }
        }
    }

    private void queryReceiverSmsList() throws ErrorInfo {
        if (mbmIdSet != null) {
            List<MReceiverSms> mReceiverSmsList = MReceiverSmsHandler.queryList(getDalSetDataSource(), mbmIdSet);
            if (CollectionUtil.isListNotBlank(mReceiverSmsList)) {
                mReceiverSmsMap = new HashMap<>();
                List<MReceiverSms> tempReceiverSmsList = null;
                for (MReceiverSms receiverSms : mReceiverSmsList) {
                    tempReceiverSmsList = mReceiverSmsMap.get(receiverSms.getMbmId());
                    if (tempReceiverSmsList == null) {
                        tempReceiverSmsList = new ArrayList<>();
                    }
                    tempReceiverSmsList.add(receiverSms);
                    mReceiverSmsMap.put(receiverSms.getMbmId(), tempReceiverSmsList);
                }
            }
        }
    }

    private void queryReceiverMailList() throws ErrorInfo {
        if (mbmIdSet != null) {
            List<MReceiverMail> mReceiverMailList = MReceiverMailHandler.queryList(getDalSetDataSource(), mbmIdSet);
            if (CollectionUtil.isListNotBlank(mReceiverMailList)) {
                mReceiverMailMap = new HashMap<>();
                List<MReceiverMail> tempReceiverMailList = null;
                for (MReceiverMail receiverMail : mReceiverMailList) {
                    tempReceiverMailList = mReceiverMailMap.get(receiverMail.getMbmId());
                    if (tempReceiverMailList == null) {
                        tempReceiverMailList = new ArrayList<>();
                    }
                    tempReceiverMailList.add(receiverMail);
                    mReceiverMailMap.put(receiverMail.getMbmId(), tempReceiverMailList);
                }
            }
        }
    }

    private void queryReceiverHostingList() throws ErrorInfo {
        if (mbmIdSet != null) {
            List<TmbReceiverHosting> tmbReceiverHostingList = MReceiverHostingHandler.queryList(getDalSetDataSource(), mbmIdSet);
            if (CollectionUtil.isListNotBlank(tmbReceiverHostingList)) {
                mReceiverHostingMap = new HashMap<>();
                List<MReceiverHosting> tempReceiverHostingList = null;
                for (TmbReceiverHosting receiverHosting : tmbReceiverHostingList) {
                    tempReceiverHostingList = mReceiverHostingMap.get(receiverHosting.getMbmId());
                    if (tempReceiverHostingList == null) {
                        tempReceiverHostingList = new ArrayList<>();
                    }
                    tempReceiverHostingList.add(MessageUtil.castToMReceiverHosting(receiverHosting));
                    mReceiverHostingMap.put(receiverHosting.getMbmId(), tempReceiverHostingList);
                }
            }
        }
    }

    private MBMessagePage converge() {
        MBMessagePage page = new MBMessagePage();
        if (tmbMessagePage != null && CollectionUtil.isListNotBlank(tmbMessagePage.getMessageList())) {
            page.setTotalNum(tmbMessagePage.getTotalNum());
            MBMessage tempMBMessage;
            List<MReceiverSms> receiverSmsList = null;
            List<MReceiverMail> receiverMailList = null;
            List<MReceiverHosting> receiverHostingList = null;
            MSendingTimeRule mSendingTimeRule;
            for (TmbMessage tmbMessage : tmbMessagePage.getMessageList()) {
                tempMBMessage = new MBMessage();

                tempMBMessage.setMbmId(tmbMessage.getMbmId());
                tempMBMessage.setPolicy(tmbMessage.getPolicy());
                tempMBMessage.setChannelList(MessageUtil.convertChannelToList(tmbMessage.getChannel()));

                if (mReceiverSmsMap != null) {
                    receiverSmsList = mReceiverSmsMap.get(tmbMessage.getMbmId());
                    if (CollectionUtil.isListNotBlank(receiverSmsList)) {
                        tempMBMessage.setSmsList(receiverSmsList);
                    }
                }

                if (mReceiverMailMap != null) {
                    receiverMailList = mReceiverMailMap.get(tmbMessage.getMbmId());
                    if (CollectionUtil.isListNotBlank(receiverMailList)) {
                        tempMBMessage.setMailList(receiverMailList);
                    }
                }

                if (mReceiverHostingMap != null) {
                    receiverHostingList = mReceiverHostingMap.get(tmbMessage.getMbmId());
                    if (CollectionUtil.isListNotBlank(receiverHostingList)) {
                        tempMBMessage.setHostingList(receiverHostingList);
                    }
                }

                if (timeRuleMap != null) {
                    mSendingTimeRule = timeRuleMap.get(tmbMessage.getMbmId());
                    if (mSendingTimeRule != null) {
                        tempMBMessage.setTimeRule(mSendingTimeRule);
                    }
                }

                tempMBMessage.setContent(MessageUtil.castToMBMessage(tmbMessage));
                tempMBMessage.setStatus(tmbMessage.getStatus());
                tempMBMessage.setOperator(tmbMessage.getOperator());
                tempMBMessage.setCreateTimestamp(tmbMessage.getCreateTimestamp());
                tempMBMessage.setLastModityTimestamp(tmbMessage.getLastModityTimestamp());

                page.addToMessageList(tempMBMessage);
            }
        }
        return page;
    }
}
