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
import xueqiao.mailbox.dao.storage.handler.*;
import xueqiao.mailbox.dao.storage.table.MBMessageTemplateTable;
import xueqiao.mailbox.dao.storage.table.MTemplateSendingTimeRuleTable;
import xueqiao.mailbox.dao.util.CollectionUtil;
import xueqiao.mailbox.dao.util.MessageUtil;
import xueqiao.mailbox.thriftdata.mb.*;

import java.util.ArrayList;
import java.util.List;

public class ModifyMBMessageTemplateController extends AbstractController {

    // param
    private MBMessageTemplate template;

    // parse result
    private TmbMessageTemplate tmbMessageTemplate;
    private TmSendingTimeRule timeRule = null;
    private List<MReceiverSms> receiverSmsList = null;
    private List<MReceiverMail> receiverMailList = null;
    private List<TmbReceiverHosting> receiverHostingList = null;

    private TmbMessageTemplate originalTemplate;

    public ModifyMBMessageTemplateController(TServiceCntl oCntl) {
        super(oCntl);
    }

    public ModifyMBMessageTemplateController params(MBMessageTemplate template) {
        this.template = template;
        return this;
    }

    @Override
    public void checkParams() throws ErrorInfo {
        Precondition.check(template.getTemplateId() > 0, "templateId should be set");
        Precondition.check(template != null, "template should not be null");
        Precondition.check(StringUtils.isNotBlank(template.getTemplateName()), "templateName should set");
        Precondition.check(template.getContent() != null, "content should set");
        Precondition.check(StringUtils.isNotBlank(template.getContent().getTitle()), "message title should be set");

        checkRecordExist();
    }

    public void doModify() throws ErrorInfo {
        parseParams();
        modify();
    }

    private void checkRecordExist() throws ErrorInfo {
        originalTemplate = MBMessageTemplateHandler.query(getDalSetDataSource(), template.getTemplateId());
        if (originalTemplate == null) {
            throw new ErrorInfo(ErrorCodeInner.PARAM_ERROR.getErrorCode(), "template is not exist with templateId : " + template.getTemplateId());
        }
    }

    private void parseParams() throws ErrorInfo {
        // message
        tmbMessageTemplate = new TmbMessageTemplate();
        tmbMessageTemplate.setTemplateId(template.getTemplateId());

        if (template.isSetTemplateName()) {
            tmbMessageTemplate.setTemplateName(template.getTemplateName());
        } else {
            tmbMessageTemplate.setTemplateName(originalTemplate.getTemplateName());
        }
        if (template.isSetPolicy()) {
            tmbMessageTemplate.setPolicy(template.getPolicy());
        } else {
            tmbMessageTemplate.setPolicy(originalTemplate.getPolicy());
        }
        if (template.isSetChannelList()) {
            tmbMessageTemplate.setChannel(MessageUtil.convertChannelListToInt(template.getChannelList()));
        } else {
            tmbMessageTemplate.setChannel(originalTemplate.getChannel());
        }

        if (template.getContent().isSetType()) {
            tmbMessageTemplate.setContentType(template.getContent().getType());
        } else {
            tmbMessageTemplate.setContentType(originalTemplate.getContentType());
        }
        if (template.getContent().isSetLevel()) {
            tmbMessageTemplate.setContentLevel(template.getContent().getLevel());
        } else {
            tmbMessageTemplate.setContentLevel(originalTemplate.getContentLevel());
        }
        if (template.getContent().isSetTitle()) {
            tmbMessageTemplate.setContentTitle(template.getContent().getTitle());
        } else {
            tmbMessageTemplate.setContentTitle(originalTemplate.getContentTitle());
        }
        if (template.getContent().isSetSummary()) {
            tmbMessageTemplate.setContentSummary(template.getContent().getSummary());
        } else {
            tmbMessageTemplate.setContentSummary(originalTemplate.getContentSummary());
        }
        if (template.getContent().isSetContent()) {
            tmbMessageTemplate.setContentBody(template.getContent().getContent());
        } else {
            tmbMessageTemplate.setContentBody(originalTemplate.getContentBody());
        }

        // time rule
        if (template.getPolicy() != MSendingPolicy.MSP_NOW) {
            MSendingTimeRule mSendingTimeRule = template.getTimeRule();
            mSendingTimeRule.setMbmId(template.getTemplateId());
            timeRule = MessageUtil.convertTimeRuleToTm(mSendingTimeRule);
        }

        // receivers
        if (CollectionUtil.isListNotBlank(template.getSmsList())) {
            receiverSmsList = new ArrayList<>();
            for (MReceiverSms receiverSms : template.getSmsList()) {
                receiverSms.setMbmId(template.getTemplateId());
                receiverSmsList.add(receiverSms);
            }
        }

        if (CollectionUtil.isListNotBlank(template.getMailList())) {
            receiverMailList = new ArrayList<>();
            for (MReceiverMail receiverMail : template.getMailList()) {
                receiverMail.setMbmId(template.getTemplateId());
                receiverMailList.add(receiverMail);
            }
        }

        if (CollectionUtil.isListNotBlank(template.getHostingList())) {
            receiverHostingList = new ArrayList<>();
            for (MReceiverHosting receiverHosting : template.getHostingList()) {
                receiverHosting.setMbmId(template.getTemplateId());
                receiverHostingList.add(MessageUtil.castToTmbReceiverHosting(receiverHosting));
            }
        }
    }

    private void modify() throws ErrorInfo {
        new DBTransactionHelper<Void>(getDalSetDataSource()) {
            @Override
            public void onPrepareData() throws ErrorInfo, Exception {

            }

            @Override
            public void onUpdate() throws ErrorInfo, Exception {
                new MBMessageTemplateTable(getConnection()).update(tmbMessageTemplate);
                if (timeRule != null) {
                    new MTemplateSendingTimeRuleTable(getConnection()).update(timeRule);
                }
                MTemplateRecevierSmsHandler.updateReceiverSms(getConnection(), tmbMessageTemplate.getTemplateId(), receiverSmsList);
                MTemplateRecevierMailHandler.updateReceiverMail(getConnection(), tmbMessageTemplate.getTemplateId(), receiverMailList);
                MTemplateReceiverHostingHandler.updateReceiverHosting(getConnection(), tmbMessageTemplate.getTemplateId(), receiverHostingList);
            }

            @Override
            public Void getResult() {
                return null;
            }
        }.execute();
    }
}
