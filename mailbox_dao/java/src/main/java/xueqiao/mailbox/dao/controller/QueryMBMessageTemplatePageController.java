package xueqiao.mailbox.dao.controller;

import org.soldier.platform.page.IndexedPageOption;
import org.soldier.platform.svr_platform.comm.ErrorInfo;
import org.soldier.platform.svr_platform.container.TServiceCntl;
import xueqiao.mailbox.dao.controller.base.AbstractController;
import xueqiao.mailbox.dao.storage.bean.*;
import xueqiao.mailbox.dao.storage.handler.*;
import xueqiao.mailbox.dao.util.CollectionUtil;
import xueqiao.mailbox.dao.util.MessageUtil;
import xueqiao.mailbox.thriftdata.mb.*;
import xueqiao.mailbox.thriftdata.req.MBMessagePage;
import xueqiao.mailbox.thriftdata.req.MBMessageTemplatePage;
import xueqiao.mailbox.thriftdata.req.QueryMBMessageTemplateOption;

import java.util.*;

public class QueryMBMessageTemplatePageController extends AbstractController {

    // params
    private QueryMBMessageTemplateOption queryOption;
    private IndexedPageOption pageOption;

    private TmbMessageTemplatePage messageTemplateTemplatePage = null;
    private Set<Long> templateIdSet = null;

    private Map<Long, MSendingTimeRule> timeRuleMap = null;
    private Map<Long, List<MReceiverSms>> mReceiverSmsMap = null;
    private Map<Long, List<MReceiverMail>> mReceiverMailMap = null;
    private Map<Long, List<MReceiverHosting>> mReceiverHostingMap = null;

    public QueryMBMessageTemplatePageController(TServiceCntl oCntl) {
        super(oCntl);
    }

    public QueryMBMessageTemplatePageController params(QueryMBMessageTemplateOption queryOption, IndexedPageOption pageOption) {
        this.queryOption = queryOption;
        this.pageOption = pageOption;
        return this;
    }

    @Override
    public void checkParams() throws ErrorInfo {
        // check nothing here
    }

    public MBMessageTemplatePage doQuery() throws ErrorInfo {
        queryTmbMessageTemplatePage();
        queryTmSendingTimeRuleList();
        queryReceiverSmsList();
        queryReceiverMailList();
        queryReceiverHostingList();
        return converge();
    }

    private void queryTmbMessageTemplatePage() throws ErrorInfo {
        messageTemplateTemplatePage = MBMessageTemplateHandler.queryPage(getDalSetDataSource(), queryOption, pageOption);
        if (messageTemplateTemplatePage != null && CollectionUtil.isListNotBlank(messageTemplateTemplatePage.getTemplateList())) {
            templateIdSet = new HashSet<>();
            for (TmbMessageTemplate template : messageTemplateTemplatePage.getTemplateList()) {
                templateIdSet.add(template.getTemplateId());
            }
        }
    }

    private void queryTmSendingTimeRuleList() throws ErrorInfo {
        if (templateIdSet != null) {
            List<TmSendingTimeRule> tmSendingTimeRuleList = MTemplateSendingTimeRuleHandler.queryList(getDalSetDataSource(), templateIdSet);
            if (CollectionUtil.isListNotBlank(tmSendingTimeRuleList)) {
                timeRuleMap = new HashMap<>();
                for (TmSendingTimeRule timeRule : tmSendingTimeRuleList) {
                    timeRuleMap.put(timeRule.getMbmId(), MessageUtil.convertTmSendingTimeRuleToM(timeRule));
                }
            }
        }
    }

    private void queryReceiverSmsList() throws ErrorInfo {
        if (templateIdSet != null) {
            List<MReceiverSms> mReceiverSmsList = MTemplateRecevierSmsHandler.queryList(getDalSetDataSource(), templateIdSet);
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
        if (templateIdSet != null) {
            List<MReceiverMail> mReceiverMailList = MTemplateRecevierMailHandler.queryList(getDalSetDataSource(), templateIdSet);
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
        if (templateIdSet != null) {
            List<TmbReceiverHosting> tmbReceiverHostingList = MTemplateReceiverHostingHandler.queryList(getDalSetDataSource(), templateIdSet);
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

    private MBMessageTemplatePage converge() {
        MBMessageTemplatePage page = new MBMessageTemplatePage();
        if (messageTemplateTemplatePage != null && CollectionUtil.isListNotBlank(messageTemplateTemplatePage.getTemplateList())) {
            page.setTotalNum(messageTemplateTemplatePage.getTotalNum());
            MBMessageTemplate tempMessageTemplate;
            List<MReceiverSms> receiverSmsList = null;
            List<MReceiverMail> receiverMailList = null;
            List<MReceiverHosting> receiverHostingList = null;
            MSendingTimeRule mSendingTimeRule;
            for (TmbMessageTemplate messageTemplate : messageTemplateTemplatePage.getTemplateList()) {
                tempMessageTemplate = new MBMessageTemplate();

                tempMessageTemplate.setTemplateId(messageTemplate.getTemplateId());
                tempMessageTemplate.setTemplateName(messageTemplate.getTemplateName());
                tempMessageTemplate.setPolicy(messageTemplate.getPolicy());
                tempMessageTemplate.setChannelList(MessageUtil.convertChannelToList(messageTemplate.getChannel()));

                if (mReceiverSmsMap != null) {
                    receiverSmsList = mReceiverSmsMap.get(messageTemplate.getTemplateId());
                    if (CollectionUtil.isListNotBlank(receiverSmsList)) {
                        tempMessageTemplate.setSmsList(receiverSmsList);
                    }
                }

                if (mReceiverMailMap != null) {
                    receiverMailList = mReceiverMailMap.get(messageTemplate.getTemplateId());
                    if (CollectionUtil.isListNotBlank(receiverMailList)) {
                        tempMessageTemplate.setMailList(receiverMailList);
                    }
                }

                if (mReceiverHostingMap != null) {
                    receiverHostingList = mReceiverHostingMap.get(messageTemplate.getTemplateId());
                    if (CollectionUtil.isListNotBlank(receiverHostingList)) {
                        tempMessageTemplate.setHostingList(receiverHostingList);
                    }
                }

                if (timeRuleMap != null) {
                    mSendingTimeRule = timeRuleMap.get(messageTemplate.getTemplateId());
                    if (mSendingTimeRule != null) {
                        tempMessageTemplate.setTimeRule(mSendingTimeRule);
                    }
                }

                tempMessageTemplate.setContent(MessageUtil.castToMBMessage(messageTemplate));
                tempMessageTemplate.setCreateTimestamp(messageTemplate.getCreateTimestamp());
                tempMessageTemplate.setLastModityTimestamp(messageTemplate.getLastModityTimestamp());

                page.addToTemplateList(tempMessageTemplate);
            }
        }
        return page;
    }
}
