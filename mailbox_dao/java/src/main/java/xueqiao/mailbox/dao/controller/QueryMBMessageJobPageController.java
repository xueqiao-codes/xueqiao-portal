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
import xueqiao.mailbox.thriftdata.req.MBMessageJobPage;
import xueqiao.mailbox.thriftdata.req.QueryMBMessageJobOption;

import java.util.*;

public class QueryMBMessageJobPageController extends AbstractController {

    // params
    private QueryMBMessageJobOption queryOption;
    private IndexedPageOption pageOption;

    private TmbMessageJobPage tmbMessageJobPage = null;
    private Set<Long> mbmIdSet = null;

    private Map<Long, List<MReceiverSms>> mReceiverSmsMap = null;
    private Map<Long, List<MReceiverMail>> mReceiverMailMap = null;
    private Map<Long, List<MReceiverHosting>> mReceiverHostingMap = null;

    public QueryMBMessageJobPageController(TServiceCntl oCntl) {
        super(oCntl);
    }

    public QueryMBMessageJobPageController params(QueryMBMessageJobOption queryOption, IndexedPageOption pageOption) {
        this.queryOption = queryOption;
        this.pageOption = pageOption;
        return this;
    }

    @Override
    public void checkParams() throws ErrorInfo {
        // check nothing
    }

    public MBMessageJobPage doQuery() throws ErrorInfo {
        queryMBMessageJobPage();
        queryReceiverSmsList();
        queryReceiverMailList();
        queryReceiverHostingList();
        return converge();
    }

    private void queryMBMessageJobPage() throws ErrorInfo {
        tmbMessageJobPage = MBMessageJobHandler.queryPage(getDalSetDataSource(), queryOption, pageOption);
        if (tmbMessageJobPage != null && CollectionUtil.isListNotBlank(tmbMessageJobPage.getJobList())) {
            mbmIdSet = new HashSet<>();
            for (TmbMessageJob tmbMessageJob : tmbMessageJobPage.getJobList()) {
                mbmIdSet.add(tmbMessageJob.getMbmId());
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

    private MBMessageJobPage converge() {
        MBMessageJobPage page = new MBMessageJobPage();
        if (tmbMessageJobPage != null && CollectionUtil.isListNotBlank(tmbMessageJobPage.getJobList())) {
            page.setTotalNum(tmbMessageJobPage.getTotalNum());
            MBMessageJob tempMBMessageJob;
            List<MReceiverSms> receiverSmsList = null;
            List<MReceiverMail> receiverMailList = null;
            List<MReceiverHosting> receiverHostingList = null;
            for (TmbMessageJob tmbMessageJob : tmbMessageJobPage.getJobList()) {
                tempMBMessageJob = new MBMessageJob();

                tempMBMessageJob.setJobId(tmbMessageJob.getJobId());
                tempMBMessageJob.setMbmId(tmbMessageJob.getMbmId());
                tempMBMessageJob.setChannelList(MessageUtil.convertChannelToList(tmbMessageJob.getChannel()));

                if (mReceiverSmsMap != null) {
                    receiverSmsList = mReceiverSmsMap.get(tmbMessageJob.getMbmId());
                    if (CollectionUtil.isListNotBlank(receiverSmsList)) {
                        tempMBMessageJob.setSmsList(receiverSmsList);
                    }
                }

                if (mReceiverMailMap != null) {
                    receiverMailList = mReceiverMailMap.get(tmbMessageJob.getMbmId());
                    if (CollectionUtil.isListNotBlank(receiverMailList)) {
                        tempMBMessageJob.setMailList(receiverMailList);
                    }
                }

                if (mReceiverHostingMap != null) {
                    receiverHostingList = mReceiverHostingMap.get(tmbMessageJob.getMbmId());
                    if (CollectionUtil.isListNotBlank(receiverHostingList)) {
                        tempMBMessageJob.setHostingList(receiverHostingList);
                    }
                }

                tempMBMessageJob.setStatus(tmbMessageJob.getStatus());
                tempMBMessageJob.setErrorDescription(tmbMessageJob.getErrorDescription());
                tempMBMessageJob.setContent(MessageUtil.castToMBMessage(tmbMessageJob));
                tempMBMessageJob.setOperator(tmbMessageJob.getOperator());
                tempMBMessageJob.setCreateTimestamp(tmbMessageJob.getCreateTimestamp());

                page.addToMessageJobList(tempMBMessageJob);
            }
        }
        return page;
    }
}
