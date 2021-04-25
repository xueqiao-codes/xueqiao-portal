package xueqiao.mailbox.sending.daemon.util;

import com.antiy.error_code.ErrorCodeInner;
import org.soldier.platform.svr_platform.comm.ErrorInfo;
import xueqiao.company.OperatorRole;
import xueqiao.mailbox.thriftdata.mb.HostingUserRole;

public class UserRoleMapping {
    public static OperatorRole getGroupUserOperatorRole(HostingUserRole userRole) throws ErrorInfo {
        try {
            return OperatorRole.valueOf(userRole.name());
        } catch (Throwable throwable) {
            throw new ErrorInfo(ErrorCodeInner.ILLEGAL_OPERATION_ERROR.getErrorCode(), "Illegal userRole mapping, userRole : " + userRole);
        }
    }
}
