package xueqiao.mailbox.dao.controller;

import com.antiy.error_code.ErrorCodeInner;
import org.apache.commons.lang.StringUtils;
import org.soldier.platform.db_helper.DBTransactionHelper;
import org.soldier.platform.svr_platform.comm.ErrorInfo;
import org.soldier.platform.svr_platform.container.TServiceCntl;
import xueqiao.mailbox.dao.common.base.Precondition;
import xueqiao.mailbox.dao.controller.base.AbstractController;
import xueqiao.mailbox.dao.storage.bean.TmSendingTimeRule;
import xueqiao.mailbox.dao.storage.bean.TmbMessageTemplate;
import xueqiao.mailbox.dao.storage.bean.TmbReceiverHosting;
import xueqiao.mailbox.dao.storage.table.*;
import xueqiao.mailbox.dao.util.CollectionUtil;
import xueqiao.mailbox.dao.util.IdMakerUtil;
import xueqiao.mailbox.dao.util.MessageUtil;
import xueqiao.mailbox.thriftdata.mb.*;

import java.util.ArrayList;
import java.util.List;

public class AddMBMessageTemplateController extends AbstractController {

    // params
    private MBMessageTemplate template;

    // parse result
    private TmbMessageTemplate tmbMessageTemplate;
    private TmSendingTimeRule timeRule = null;
    private List<MReceiverSms> receiverSmsList = null;
    private List<MReceiverMail> receiverMailList = null;
    private List<TmbReceiverHosting> receiverHostingList = null;

    public AddMBMessageTemplateController(TServiceCntl oCntl) {
        super(oCntl);
    }

    public AddMBMessageTemplateController params(MBMessageTemplate template) {
        this.template = template;
        return this;
    }

    @Override
    public void checkParams() throws ErrorInfo {
        Precondition.check(template != null, "template should not be null");
        Precondition.check(StringUtils.isNotBlank(template.getTemplateName()), "templateName should set");
        Precondition.check(template.getContent() != null, "content should set");
        Precondition.check(StringUtils.isNotBlank(template.getContent().getTitle()), "message title should be set");
    }

    public void doAddition() throws ErrorInfo {
        parseParams();
        add();
    }

    private void parseParams() throws ErrorInfo {
        // message
        tmbMessageTemplate = new TmbMessageTemplate();
        tmbMessageTemplate.setTemplateId(IdMakerUtil.genMBMessageTemplateId());
        tmbMessageTemplate.setTemplateName(template.getTemplateName());
        tmbMessageTemplate.setPolicy(template.getPolicy());
        if (template.getChannelListSize() > 0) {
            tmbMessageTemplate.setChannel(MessageUtil.convertChannelListToInt(template.getChannelList()));
        }
        tmbMessageTemplate.setContentType(template.getContent().getType());
        tmbMessageTemplate.setContentLevel(template.getContent().getLevel());
        tmbMessageTemplate.setContentTitle(template.getContent().getTitle());
        tmbMessageTemplate.setContentSummary(template.getContent().getSummary());
        tmbMessageTemplate.setContentBody(template.getContent().getContent());

        // time rule
        if (template.getPolicy() != MSendingPolicy.MSP_NOW) {
            MSendingTimeRule mSendingTimeRule = template.getTimeRule();
            mSendingTimeRule.setMbmId(tmbMessageTemplate.getTemplateId());
            timeRule = MessageUtil.convertTimeRuleToTm(mSendingTimeRule);
        }

        // receivers
        if (CollectionUtil.isListNotBlank(template.getSmsList())) {
            receiverSmsList = new ArrayList<>();
            for (MReceiverSms receiverSms : template.getSmsList()) {
                receiverSms.setMbmId(tmbMessageTemplate.getTemplateId());
                receiverSmsList.add(receiverSms);
            }
        }

        if (CollectionUtil.isListNotBlank(template.getMailList())) {
            receiverMailList = new ArrayList<>();
            for (MReceiverMail receiverMail : template.getMailList()) {
                receiverMail.setMbmId(tmbMessageTemplate.getTemplateId());
                receiverMailList.add(receiverMail);
            }
        }

        if (CollectionUtil.isListNotBlank(template.getHostingList())) {
            receiverHostingList = new ArrayList<>();
            for (MReceiverHosting receiverHosting : template.getHostingList()) {
                receiverHosting.setMbmId(tmbMessageTemplate.getTemplateId());
                receiverHostingList.add(MessageUtil.castToTmbReceiverHosting(receiverHosting));
            }
        }
    }

    private void add() throws ErrorInfo {
        new DBTransactionHelper<Void>(getDalSetDataSource()) {

            MBMessageTemplateTable templateTable;

            @Override
            public void onPrepareData() throws ErrorInfo, Exception {
                templateTable = new MBMessageTemplateTable(getConnection());
                TmbMessageTemplate template = templateTable.query(tmbMessageTemplate.getTemplateName());
                if (template != null && template.getTemplateId() > 0) {
                    throw new ErrorInfo(ErrorCodeInner.PARAM_ERROR.getErrorCode(), "duplicated template name");
                }
            }

            @Override
            public void onUpdate() throws ErrorInfo, Exception {
                templateTable.insert(tmbMessageTemplate);
                if (timeRule != null) {
                    new MTemplateSendingTimeRuleTable(getConnection()).insert(timeRule);
                }
                if (CollectionUtil.isListNotBlank(receiverSmsList)) {
                    MTemplateRecevierSmsTable templateRecevierSmsTable = new MTemplateRecevierSmsTable(getConnection());
                    for (MReceiverSms receiverSms : receiverSmsList) {
                        templateRecevierSmsTable.insert(receiverSms);
                    }
                }
                if (CollectionUtil.isListNotBlank(receiverMailList)) {
                    MTemplateRecevierMailTable templateRecevierMailTable = new MTemplateRecevierMailTable(getConnection());
                    for (MReceiverMail receiverMail : receiverMailList) {
                        templateRecevierMailTable.insert(receiverMail);
                    }
                }
                if (CollectionUtil.isListNotBlank(receiverHostingList)) {
                    MTemplateReceiverHostingTable templateReceiverHostingTable = new MTemplateReceiverHostingTable(getConnection());
                    for (TmbReceiverHosting receiverHosting : receiverHostingList) {
                        templateReceiverHostingTable.insert(receiverHosting);
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
