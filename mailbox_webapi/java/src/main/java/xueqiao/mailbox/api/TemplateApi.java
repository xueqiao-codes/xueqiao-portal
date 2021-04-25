package xueqiao.mailbox.api;

import com.antiy.error_code.ErrorCodeOuter;
import org.apache.commons.lang.StringUtils;
import org.apache.thrift.TException;
import org.soldier.platform.page.IndexedPageOption;
import org.soldier.platform.svr_platform.comm.ErrorInfo;
import xueqiao.mailbox.dao.thriftapi.client.MailboxDaoStub;
import xueqiao.mailbox.thriftdata.mb.MBMessageTemplate;
import xueqiao.mailbox.thriftdata.req.MBMessageTemplatePage;
import xueqiao.mailbox.thriftdata.req.QueryMBMessageTemplateOption;
import xueqiao.mailbox.webapi.thriftapi.MBMessageTemplateSelector;
import xueqiao.mailbox.webapi.thriftapi.OperateResult;

import java.util.ArrayList;
import java.util.List;

public class TemplateApi {

    public MBMessageTemplatePage reqTemplate(QueryMBMessageTemplateOption option, IndexedPageOption pageOption) throws TException {
        MailboxDaoStub stub = new MailboxDaoStub();
        return stub.queryMBMessageTemplatePage(option, pageOption);
    }

    public OperateResult addTemplate(MBMessageTemplate template) throws TException {
        MailboxDaoStub stub = new MailboxDaoStub();
        handleContentText(template);
        stub.addMBMessageTemplate(template);
        return success();
    }

    public OperateResult updateTemplate(MBMessageTemplate template) throws TException {
        if (template == null || !template.isSetTemplateId()) {
            throw new ErrorInfo(ErrorCodeOuter.PARAM_ERROR.getErrorCode(), "template id must set.");
        }
        MailboxDaoStub stub = new MailboxDaoStub();
        handleContentText(template);
        stub.modifyMBMessageTemplate(template);
        return success();
    }

    private void handleContentText(MBMessageTemplate template) throws TException {
        if (template.isSetContent()) {
            if (template.getContent().isSetContent() && StringUtils.isNotBlank(template.getContent().getContent())) {
                String fileName = "";
                if (template.isSetTemplateId() && template.getTemplateId() > 0) {
                    QueryMBMessageTemplateOption option = new QueryMBMessageTemplateOption();
                    option.addToTemplateIdSet(template.getTemplateId());
                    MBMessageTemplatePage page = new MailboxDaoStub().queryMBMessageTemplatePage(option, null);
                    if (page.getTemplateListSize() > 0) {
                        MBMessageTemplate oldTemplate = page.getTemplateList().get(0);
                        if (oldTemplate.isSetContent()) {
                            fileName = oldTemplate.getContent().getContent();
                        }
                    }
                }

                template.getContent().setContent(Utils.saveContentText(template.getContent(), fileName));
            }
        }
    }

    public OperateResult removeTemplate(long templateId) throws TException {
        MailboxDaoStub stub = new MailboxDaoStub();
        stub.deleteMBMessageTemplate(templateId);
        return success();
    }

    public List<MBMessageTemplateSelector> reqMBMessageTemplateSelector() throws ErrorInfo, TException {
        MailboxDaoStub stub = new MailboxDaoStub();
        MBMessageTemplatePage page = stub.queryMBMessageTemplatePage(null, null);
        List<MBMessageTemplateSelector> selectorList = new ArrayList<>();
        if (page.getTemplateListSize()>0) {
            for (MBMessageTemplate template : page.getTemplateList()) {
                MBMessageTemplateSelector selector = new MBMessageTemplateSelector();
                selector.setTemplateId(template.getTemplateId());
                selector.setTemplateName(template.getTemplateName());
                selectorList.add(selector);
            }
        }
        return selectorList;
    }

    private OperateResult success() {
        OperateResult result = new OperateResult();
        result.setSuccess(true);
        return result;
    }
}
