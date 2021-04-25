package xueqiao.mailbox.dao.util;

import com.antiy.error_code.ErrorCodeInner;
import org.soldier.base.logger.AppLog;
import org.soldier.platform.id_maker.IdException;
import org.soldier.platform.svr_platform.comm.ErrorInfo;
import xueqiao.mailbox.dao.config.ConfigurationProperty;

public class IdMakerUtil {
    public static long genMBMessageId() throws ErrorInfo {
        try {
            return ConfigurationProperty.instance().getMbmessageIdMaker().createId();
        } catch (IdException e) {
            AppLog.e("genMBMessageId fail", e);
            throw new ErrorInfo(ErrorCodeInner.SERVER_INNER_ERROR.getErrorCode(), "gen mbmessageId fail");
        }
    }

    public static long genMBMessageTemplateId() throws ErrorInfo {
        try {
            return ConfigurationProperty.instance().getMbmessageTemplateIdMaker().createId();
        } catch (IdException e) {
            AppLog.e("genMBMessageTemplateId fail", e);
            throw new ErrorInfo(ErrorCodeInner.SERVER_INNER_ERROR.getErrorCode(), "gen mbmessageTemplateId fail");
        }
    }

    public static long genMBMessageJobId() throws ErrorInfo {
        try {
            return ConfigurationProperty.instance().getMbmessageJobIdMaker().createId();
        } catch (IdException e) {
            AppLog.e("genMBMessageJobId fail", e);
            throw new ErrorInfo(ErrorCodeInner.SERVER_INNER_ERROR.getErrorCode(), "gen mbmessageJobId fail");
        }
    }
}
