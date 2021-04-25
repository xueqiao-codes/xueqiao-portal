package xueqiao.mailbox.user.message.api;

import com.google.common.base.Preconditions;
import org.soldier.base.logger.AppLog;
import org.soldier.platform.db_helper.DBQueryHelper;
import org.soldier.platform.db_helper.DBTransactionHelper;
import org.soldier.platform.page.IndexedPageOption;
import org.soldier.platform.svr_platform.comm.ErrorInfo;
import xueqiao.mailbox.user.message.config.ConfigurationProperty;
import xueqiao.mailbox.user.message.storage.UserMessageTable;
import xueqiao.mailbox.user.message.thriftapi.*;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.List;

public class UserMessageApi {

    public void addmessage(DataSource dataSource, List<UserMessage> hostingMessages) throws ErrorInfo {
        Preconditions.checkNotNull(hostingMessages);

        new DBTransactionHelper<Void>(dataSource) {

            UserMessageTable table;

            @Override
            public void onPrepareData() throws ErrorInfo, Exception {
                table = new UserMessageTable(getConnection(), ConfigurationProperty.instance().getRoleName());

                for (UserMessage hostingMessage : hostingMessages) {
                    Preconditions.checkNotNull(hostingMessage, "HostingMessage can not be null.");
                    Preconditions.checkArgument(hostingMessage.getMessageJobId() > 0, "Message job id must set.");
                    Preconditions.checkArgument(hostingMessage.getUserId() > 0, "User id must set.");
                }
            }

            @Override
            public void onUpdate() throws ErrorInfo, Exception {
                for (UserMessage hostingMessage : hostingMessages) {
                    UserMessage item = table.queryCheck(hostingMessage.getMessageJobId(), hostingMessage.getUserId());
                    if (item == null) {
                        table.add(hostingMessage);
                    } else {
                        ErrorInfo errorInfo = new ErrorInfo(MailBoxUserMessageError.HOSTING_MESSAGE_EXIST.getValue(), "Job message exists.");
                        AppLog.e(errorInfo.getErrorMsg(), errorInfo);
                    }
                }
            }

            @Override
            public Void getResult() {
                return null;
            }
        }.execute();
    }

    public UserMessagePage reqUserMessage(DataSource dataSource, ReqUserMessageOption option, IndexedPageOption pageOption) throws ErrorInfo {
        return new DBQueryHelper<UserMessagePage>(dataSource) {
            @Override
            protected UserMessagePage onQuery(Connection connection) throws Exception {
                return new UserMessageTable(connection, ConfigurationProperty.instance().getRoleName()).query(option, pageOption);
            }
        }.query();
    }

    public void markMessageAsRead(DataSource dataSource, MarkReadOption option) throws ErrorInfo {
        Preconditions.checkNotNull(option, "MarkReadOption must set.");
        Preconditions.checkNotNull(option.isSetUserId(), "User id must set");
        new DBTransactionHelper<Void>(dataSource) {
            UserMessageTable table;

            @Override
            public void onPrepareData() throws ErrorInfo, Exception {
                table = new UserMessageTable(getConnection(), ConfigurationProperty.instance().getRoleName());
            }

            @Override
            public void onUpdate() throws ErrorInfo, Exception {
                ReqUserMessageOption queryOption = new ReqUserMessageOption();
                queryOption.setUserId(option.getUserId());
                if (option.isSetCompanyId()) {
                    queryOption.setCompanyId(option.getCompanyId());
                }
                if (option.isSetMessageJobId()) {
                    queryOption.setMessageJobId(option.getMessageJobId());
                }


                UserMessagePage page = table.query(queryOption, null);
                for (UserMessage message : page.getPage()) {
                    option.addToMessageIds(message.getMessageId());
                }

                table.markRead(option.getUserId(), option.getMessageIds());
            }

            @Override
            public Void getResult() {
                return null;
            }
        }.execute();

    }
}
