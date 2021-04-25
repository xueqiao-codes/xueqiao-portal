package xueqiao.mailbox.dao.controller;

import org.apache.commons.lang.StringUtils;
import org.soldier.platform.db_helper.DBTransactionHelper;
import org.soldier.platform.svr_platform.comm.ErrorInfo;
import org.soldier.platform.svr_platform.container.TServiceCntl;
import xueqiao.mailbox.dao.common.base.Precondition;
import xueqiao.mailbox.dao.controller.base.AbstractController;
import xueqiao.mailbox.dao.storage.bean.TmSendingTimeRule;
import xueqiao.mailbox.dao.storage.bean.TmbMessage;
import xueqiao.mailbox.dao.storage.bean.TmbReceiverHosting;
import xueqiao.mailbox.dao.storage.table.*;
import xueqiao.mailbox.dao.util.CollectionUtil;
import xueqiao.mailbox.dao.util.MessageUtil;
import xueqiao.mailbox.dao.util.IdMakerUtil;
import xueqiao.mailbox.thriftdata.mb.*;

import java.util.ArrayList;
import java.util.List;

public class AddMBMessageController extends AbstractController {

    // param
    private MBMessage message;

    // parse result
    private TmbMessage tmbMessage;
    private TmSendingTimeRule timeRule = null;
    private List<MReceiverSms> receiverSmsList = null;
    private List<MReceiverMail> receiverMailList = null;
    private List<TmbReceiverHosting> receiverHostingList = null;

    public AddMBMessageController(TServiceCntl oCntl) {
        super(oCntl);
    }

    public AddMBMessageController params(MBMessage message) {
        this.message = message;
        return this;
    }

    @Override
    public void checkParams() throws ErrorInfo {
        Precondition.check(message != null, "message should not be null");
        Precondition.check(CollectionUtil.isListNotBlank(message.getChannelList()), "channelList should not be empty");
        Precondition.check(CollectionUtil.isListNotBlank(message.getSmsList()) || CollectionUtil.isListNotBlank(message.getMailList()) || CollectionUtil.isListNotBlank(message.getHostingList()), "receiver should be set");
        if (message.getPolicy() == MSendingPolicy.MSP_FIXED_TIME) {
            Precondition.check(message.getTimeRule() != null && message.getTimeRule().getMbStartTime() < System.currentTimeMillis(), "invalid start time");
        } else if (message.getPolicy() == MSendingPolicy.MSP_REPEAT) {
            Precondition.check(message.getTimeRule() != null && CollectionUtil.isListNotBlank(message.getTimeRule().getDayTimeList()), "day time list should be set");
        }
        Precondition.check(message.getContent() != null, "content should set");
        Precondition.check(message.getContent().isSetType(), "message type should be set");
        Precondition.check(message.getContent().isSetLevel(), "message level should be set");
        Precondition.check(StringUtils.isNotBlank(message.getContent().getTitle()), "message title should be set");
        Precondition.check(StringUtils.isNotBlank(message.getContent().getSummary()), "message summary should be set");
        Precondition.check(StringUtils.isNotBlank(message.getContent().getContent()), "message content should be set");
    }

    public void doAddition() throws ErrorInfo {
        parseParams();
        add();
    }

    private void parseParams() throws ErrorInfo {
        // message
        tmbMessage = new TmbMessage();
        tmbMessage.setMbmId(IdMakerUtil.genMBMessageId());
        tmbMessage.setPolicy(message.getPolicy());
        tmbMessage.setChannel(MessageUtil.convertChannelListToInt(message.getChannelList()));

        tmbMessage.setContentType(message.getContent().getType());
        tmbMessage.setContentLevel(message.getContent().getLevel());
        tmbMessage.setContentTitle(message.getContent().getTitle());
        tmbMessage.setContentSummary(message.getContent().getSummary());
        tmbMessage.setContentBody(message.getContent().getContent());
        if (message.isSetOperator()) {
            tmbMessage.setOperator(message.getOperator());
        } else {
            tmbMessage.setOperator("");
        }

        // time rule
        if (message.getPolicy() != MSendingPolicy.MSP_NOW) {
            MSendingTimeRule mSendingTimeRule = message.getTimeRule();
            mSendingTimeRule.setMbmId(tmbMessage.getMbmId());
            timeRule = MessageUtil.convertTimeRuleToTm(mSendingTimeRule);
        }

        // receivers
        if (CollectionUtil.isListNotBlank(message.getSmsList())) {
            receiverSmsList = new ArrayList<>();
            for (MReceiverSms receiverSms : message.getSmsList()) {
                receiverSms.setMbmId(tmbMessage.getMbmId());
                receiverSmsList.add(receiverSms);
            }
        }

        if (CollectionUtil.isListNotBlank(message.getMailList())) {
            receiverMailList = new ArrayList<>();
            for (MReceiverMail receiverMail : message.getMailList()) {
                receiverMail.setMbmId(tmbMessage.getMbmId());
                receiverMailList.add(receiverMail);
            }
        }

        if (CollectionUtil.isListNotBlank(message.getHostingList())) {
            receiverHostingList = new ArrayList<>();
            for (MReceiverHosting receiverHosting : message.getHostingList()) {
                receiverHosting.setMbmId(tmbMessage.getMbmId());
                receiverHostingList.add(MessageUtil.castToTmbReceiverHosting(receiverHosting));
            }
        }
    }

    private void add() throws ErrorInfo {
        new DBTransactionHelper<Void>(getDalSetDataSource()) {
            @Override
            public void onPrepareData() throws ErrorInfo, Exception {

            }

            @Override
            public void onUpdate() throws ErrorInfo, Exception {
                new MBMessageTable(getConnection()).insert(tmbMessage);
                if (timeRule != null) {
                    new MSendingTimeRuleTable(getConnection()).insert(timeRule);
                }
                if (CollectionUtil.isListNotBlank(receiverSmsList)) {
                    MReceiverSmsTable receiverSmsTable = new MReceiverSmsTable(getConnection());
                    for (MReceiverSms receiverSms : receiverSmsList) {
                        receiverSmsTable.insert(receiverSms);
                    }
                }
                if (CollectionUtil.isListNotBlank(receiverMailList)) {
                    MReceiverMailTable receiverMailTable = new MReceiverMailTable(getConnection());
                    for (MReceiverMail receiverMail : receiverMailList) {
                        receiverMailTable.insert(receiverMail);
                    }
                }
                if (CollectionUtil.isListNotBlank(receiverHostingList)) {
                    MReceiverHostingTable receiverHostingTable = new MReceiverHostingTable(getConnection());
                    for (TmbReceiverHosting receiverHosting : receiverHostingList) {
                        receiverHostingTable.insert(receiverHosting);
                    }
                }
            }

            @Override
            public Void getResult() {
                return null;
            }
        }.execute();
    }
}
