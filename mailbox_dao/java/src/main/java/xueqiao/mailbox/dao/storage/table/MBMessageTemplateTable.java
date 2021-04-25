package xueqiao.mailbox.dao.storage.table;

import org.apache.commons.lang.StringUtils;
import org.soldier.base.sql.PreparedFields;
import org.soldier.base.sql.SqlQueryBuilder;
import org.soldier.platform.db_helper.TableHelper;
import org.soldier.platform.page.IndexedPageOption;
import xueqiao.mailbox.dao.storage.bean.TmbMessageTemplate;
import xueqiao.mailbox.dao.storage.bean.TmbMessageTemplatePage;
import xueqiao.mailbox.dao.util.MessageUtil;
import xueqiao.mailbox.thriftdata.mb.MSendingPolicy;
import xueqiao.mailbox.thriftdata.message.MLevel;
import xueqiao.mailbox.thriftdata.message.MType;
import xueqiao.mailbox.thriftdata.req.QueryMBMessageTemplateOption;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MBMessageTemplateTable extends TableHelper<TmbMessageTemplate> {

    private final static String TABLE_NAME = "tmb_message_template";

    private final static String F_TEMPLATE_ID = "Ftemplate_id";
    private final static String F_TEMPLATE_NAME = "Ftemplate_name";
    private final static String F_MB_POLICY = "Fmb_policy";
    private final static String F_MB_CHANNEL = "Fmb_channel";
    private final static String F_MB_CONTENT_TYPE = "Fmb_content_type";
    private final static String F_MB_CONTENT_LEVEL = "Fmb_content_level";
    private final static String F_MB_CONTENT_TITLE = "Fmb_content_title";
    private final static String F_MB_CONTENT_SUMMARY = "Fmb_content_summary";
    private final static String F_MB_CONTENT_BODY = "Fmb_content_body";
    private final static String F_CREATE_TIMESTAMP = "Fcreate_timestamp";
    private final static String F_LASTMODIFY_TIMESTAMP = "Flastmodify_timestamp";

    public MBMessageTemplateTable(Connection conn) {
        super(conn);
    }


    private PreparedFields getPreparedFields(TmbMessageTemplate template) {
        PreparedFields pf = new PreparedFields();
        if (StringUtils.isNotBlank(template.getTemplateName())) {
            pf.addString(F_TEMPLATE_NAME, template.getTemplateName());
        }
        if (template.getPolicy() != null) {
            pf.addInt(F_MB_POLICY, template.getPolicy().getValue());
        }
        if (template.getChannel() > 0) {
            pf.addInt(F_MB_CHANNEL, template.getChannel());
        }
        if (template.getContentType() != null) {
            pf.addInt(F_MB_CONTENT_TYPE, template.getContentType().getValue());
        }
        if (template.getContentLevel() != null) {
            pf.addInt(F_MB_CONTENT_LEVEL, template.getContentLevel().getValue());
        }
        if (StringUtils.isNotBlank(template.getContentTitle())) {
            pf.addString(F_MB_CONTENT_TITLE, template.getContentTitle());
        }
        if (StringUtils.isNotBlank(template.getContentSummary())) {
            pf.addString(F_MB_CONTENT_SUMMARY, template.getContentSummary());
        }
        if (StringUtils.isNotBlank(template.getContentBody())) {
            pf.addString(F_MB_CONTENT_BODY, template.getContentBody());
        }
        return pf;
    }

    public void insert(TmbMessageTemplate template) throws SQLException {
        long currentTimestamp = System.currentTimeMillis() / 1000;
        PreparedFields pf = getPreparedFields(template);
        pf.addLong(F_TEMPLATE_ID, template.getTemplateId());
        pf.addLong(F_CREATE_TIMESTAMP, currentTimestamp);
        pf.addLong(F_LASTMODIFY_TIMESTAMP, currentTimestamp);
        super.insert(pf);
    }

    public void update(TmbMessageTemplate template) throws SQLException {
        long currentTimestamp = System.currentTimeMillis() / 1000;
        PreparedFields pf = getPreparedFields(template);
        pf.addLong(F_LASTMODIFY_TIMESTAMP, currentTimestamp);
        super.update(pf, F_TEMPLATE_ID + "=?", template.getTemplateId());
    }

    public void delete(long templateId) throws SQLException {
        super.delete(F_TEMPLATE_ID + "=?", templateId);
    }

    public TmbMessageTemplate query(long templateId) throws SQLException {
        SqlQueryBuilder qryBuilder = super.prepareSqlQueryBuilder();
        qryBuilder.addFieldCondition(SqlQueryBuilder.ConditionType.AND, F_TEMPLATE_ID + "=?", templateId);
        return super.getItem(qryBuilder);
    }

    public TmbMessageTemplate query(String templateName) throws SQLException {
        SqlQueryBuilder qryBuilder = super.prepareSqlQueryBuilder();
        qryBuilder.addFieldCondition(SqlQueryBuilder.ConditionType.AND, F_TEMPLATE_NAME + "=?", templateName);
        return super.getItem(qryBuilder);
    }

    public TmbMessageTemplatePage queryPage(QueryMBMessageTemplateOption queryOption, IndexedPageOption pageOption) throws SQLException {
        SqlQueryBuilder qryBuilder = super.prepareSqlQueryBuilder();
        if (queryOption != null) {
            if (queryOption.isSetTemplateIdSet()) {
                qryBuilder.addInFieldCondition(SqlQueryBuilder.ConditionType.AND, F_TEMPLATE_ID, queryOption.getTemplateIdSet());
            }
            if (queryOption.isSetTemplateNamePartial()) {
                qryBuilder.addFieldCondition(SqlQueryBuilder.ConditionType.AND, F_TEMPLATE_NAME + " like ? ", "%" + queryOption.getTemplateNamePartial().trim() + "%");
            }
            if (queryOption.isSetChannel()) {
                qryBuilder.addInFieldCondition(SqlQueryBuilder.ConditionType.AND, F_MB_CHANNEL, MessageUtil.convertChannelToIntegerList(queryOption.getChannel()));
            }
            if (queryOption.isSetType()) {
                qryBuilder.addFieldCondition(SqlQueryBuilder.ConditionType.AND, F_MB_CONTENT_TYPE + "=?", queryOption.getType().getValue());
            }
            if (queryOption.isSetLevel()) {
                qryBuilder.addFieldCondition(SqlQueryBuilder.ConditionType.AND, F_MB_CONTENT_LEVEL + "=?", queryOption.getLevel().getValue());
            }
        }
        qryBuilder.setOrder(SqlQueryBuilder.OrderType.DESC, F_LASTMODIFY_TIMESTAMP);
        TmbMessageTemplatePage page = new TmbMessageTemplatePage();
        if (pageOption != null) {
            qryBuilder.setPage(pageOption.getPageIndex(), pageOption.getPageSize());

            if (pageOption.isNeedTotalCount()) {
                page.setTotalNum(super.getTotalNum(qryBuilder));
            }
        }
        page.setTemplateList(super.getItemList(qryBuilder));
        return page;
    }

    @Override
    protected String getTableName() throws SQLException {
        return TABLE_NAME;
    }

    @Override
    public TmbMessageTemplate fromResultSet(ResultSet rs) throws Exception {
        TmbMessageTemplate template = new TmbMessageTemplate();
        template.setTemplateId(rs.getLong(F_TEMPLATE_ID));
        template.setTemplateName(rs.getString(F_TEMPLATE_NAME));
        template.setPolicy(MSendingPolicy.findByValue(rs.getInt(F_MB_POLICY)));
        template.setChannel(rs.getInt(F_MB_CHANNEL));
        template.setContentType(MType.findByValue(rs.getInt(F_MB_CONTENT_TYPE)));
        template.setContentLevel(MLevel.findByValue(rs.getInt(F_MB_CONTENT_LEVEL)));
        template.setContentTitle(rs.getString(F_MB_CONTENT_TITLE));
        template.setContentSummary(rs.getString(F_MB_CONTENT_SUMMARY));
        template.setContentBody(rs.getString(F_MB_CONTENT_BODY));
        template.setCreateTimestamp(rs.getLong(F_CREATE_TIMESTAMP));
        template.setLastModityTimestamp(rs.getLong(F_LASTMODIFY_TIMESTAMP));
        return template;
    }
}
