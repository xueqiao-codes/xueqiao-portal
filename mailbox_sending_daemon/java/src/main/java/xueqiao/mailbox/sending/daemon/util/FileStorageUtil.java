package xueqiao.mailbox.sending.daemon.util;

import com.antiy.error_code.ErrorCodeOuter;
import org.apache.commons.lang.StringUtils;
import org.soldier.base.logger.AppLog;
import org.soldier.platform.file_storage.FileStorage;
import org.soldier.platform.file_storage.FileStorageException;
import org.soldier.platform.file_storage.FileStorageFactory;
import org.soldier.platform.filestorage.dao.EACLControlList;
import org.soldier.platform.filestorage.dao.HttpOption;
import org.soldier.platform.svr_platform.comm.ErrorInfo;

import java.io.UnsupportedEncodingException;
import java.util.UUID;

public class FileStorageUtil {

    private static final String FILE_STORAGE_KEY_MAILBOX = "mailbox";

    public static String saveContentText(String messageContent, String fileName) throws ErrorInfo {
        if (StringUtils.isBlank(fileName)) {
            fileName = UUID.randomUUID().toString().replace("-", "");
        }
        FileStorage fileStorage = FileStorageFactory.getInstance().getFileStorage(FILE_STORAGE_KEY_MAILBOX);
        try {
            byte[] content = messageContent.getBytes("utf-8");
            HttpOption httpOption = new HttpOption();
            httpOption.setAclControl(EACLControlList.PublicRead);
            fileStorage.write(fileName, content, httpOption);
            return fileName;
        } catch (UnsupportedEncodingException | FileStorageException e) {
            AppLog.e(e.getMessage(), e);
            throw new ErrorInfo(ErrorCodeOuter.SERVER_BUSY.getErrorCode(), "File storage write file fail.");
        }
    }

    public static String readContentText(String fileName) throws ErrorInfo {
        if (StringUtils.isBlank(fileName)) {
            return "";
        }
        FileStorage fileStorage = FileStorageFactory.getInstance().getFileStorage(FILE_STORAGE_KEY_MAILBOX);
        try {
            byte[] contentBytes = fileStorage.read(fileName);
            return new String(contentBytes);
        } catch (FileStorageException e) {
            AppLog.e(e.getMessage(), e);
            throw new ErrorInfo(ErrorCodeOuter.SERVER_BUSY.getErrorCode(), "File storage read file fail.");
        }
    }
}
