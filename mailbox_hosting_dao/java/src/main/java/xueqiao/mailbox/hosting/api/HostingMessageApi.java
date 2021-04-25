package xueqiao.mailbox.hosting.api;

import com.google.common.base.Preconditions;
import org.soldier.base.logger.AppLog;
import org.soldier.platform.db_helper.DBQueryHelper;
import org.soldier.platform.db_helper.DBTransactionHelper;
import org.soldier.platform.page.IndexedPageOption;
import org.soldier.platform.svr_platform.comm.ErrorInfo;
import xueqiao.mailbox.hosting.dao.thriftapi.storage.HostingMessageTable;
import xueqiao.mailbox.hosting.thriftapi.*;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HostingMessageApi {

    public void addHostingMessage(DataSource dataSource, List<HostingMessage> hostingMessages) throws ErrorInfo {
        Preconditions.checkNotNull(hostingMessages);

        new DBTransactionHelper<Void>(dataSource) {

            HostingMessageTable table;

            @Override
            public void onPrepareData() throws ErrorInfo, Exception {
                table = new HostingMessageTable(getConnection());
                for (HostingMessage hostingMessage : hostingMessages) {
                    Preconditions.checkNotNull(hostingMessage, "HostingMessage can not be null.");
                    Preconditions.checkArgument(hostingMessage.getMessageJobId() > 0, "Message job id must set.");
                    Preconditions.checkArgument(hostingMessage.getUserId() > 0, "User id must set.");
                }
            }

            @Override
            public void onUpdate() throws ErrorInfo, Exception {
                for (HostingMessage hostingMessage : hostingMessages) {
                    HostingMessage item = table.queryCheck(hostingMessage.getMessageJobId(), hostingMessage.getUserId());
                    if (item == null) {
                        table.add(hostingMessage);
                    } else {
                        ErrorInfo errorInfo = new ErrorInfo(MailBoxHostingMessageError.HOSTING_MESSAGE_EXIST.getValue(), "Job message exists.");
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

    public HostingMessagePage reqHostingMessage(DataSource dataSource, ReqHostingMessageOption option, IndexedPageOption pageOption) throws ErrorInfo {
        return new DBQueryHelper<HostingMessagePage>(dataSource) {
            @Override
            protected HostingMessagePage onQuery(Connection connection) throws Exception {
                return new HostingMessageTable(connection).query(option, pageOption);
            }
        }.query();
    }

    public void updateHostingMessageState(DataSource dataSource, MarkReadOption option) throws ErrorInfo {
        Preconditions.checkNotNull(option, "MarkReadOption must set.");

        boolean conditionSet = false;

        ReqHostingMessageOption reqOption = new ReqHostingMessageOption();
        if (option.isSetCompanyId()) {
            reqOption.setCompanyId(option.getCompanyId());
            conditionSet = true;
        }
        if (option.isSetUserId()) {
            reqOption.setUserId(option.getUserId());
            conditionSet = true;
        }
        if (option.isSetMessageJobId()) {
            reqOption.setMessageJobId(option.getMessageJobId());
            conditionSet = true;
        }
        if (option.isSetHostingMessageId() && option.getHostingMessageIdSize() > 0) {
            reqOption.setHostingMessageId(option.getHostingMessageId());
            conditionSet = true;
        }
        reqOption.setState(MessageState.CREATE);
        if (!conditionSet) {
            throw new ErrorInfo(MailBoxHostingMessageError.HOSTING_MESSAGE_MARK_READ_OPTION_NOT_SET.getValue(), "Mark read option must set.");
        }
        Set<Long> messageIds = new HashSet<>();
        new DBTransactionHelper<Void>(dataSource) {
            HostingMessageTable table;

            @Override
            public void onPrepareData() throws ErrorInfo, Exception {
                table = new HostingMessageTable(getConnection());
                HostingMessagePage page = table.query(reqOption, null);

                for (HostingMessage message : page.getPage()) {
                    messageIds.add(message.getHostingMessageId());
                }
            }

            @Override
            public void onUpdate() throws ErrorInfo, Exception {
                if (messageIds.size() > 0) {
                    table.updateState(messageIds, MessageState.READ);
                } else {
                    throw new ErrorInfo(MailBoxHostingMessageError.HOSTING_MESSAGE_NOT_FOUND.getValue(), "Hosting message not found.");
                }

            }

            @Override
            public Void getResult() {
                return null;
            }
        }.execute();

    }
}
