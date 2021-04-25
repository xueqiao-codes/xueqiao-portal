package xueqiao.mailbox.dao.config;

import com.antiy.error_code.ErrorCodeInner;
import org.soldier.platform.dal_set.DalSetProxy;
import org.soldier.platform.id_maker.IdException;
import org.soldier.platform.id_maker.IdMaker;
import org.soldier.platform.id_maker.IdMakerFactory;
import org.soldier.platform.svr_platform.comm.ErrorInfo;

import java.util.Properties;

public class ConfigurationProperty {
    private String roleName;
    private static ConfigurationProperty config;

    private IdMaker mbmessageIdMaker;
    private IdMaker mbmessageTemplateIdMaker;
    private IdMaker mbmessageJobIdMaker;

    private ConfigurationProperty() {
    }

    public static ConfigurationProperty instance() {
        if (config == null) {
            synchronized (ConfigurationProperty.class) {
                if (config == null) {
                    config = new ConfigurationProperty();
                }
            }
        }
        return config;
    }

    public void init(Properties props) throws Exception {
        DalSetProxy.getInstance().loadFromXml();
        initRoleName(props);
        initIdMaker(props);
    }

    private void initRoleName(Properties props) throws ErrorInfo {
        this.roleName = props.getProperty("role", "role_mailbox");
        System.out.println("roleName=" + roleName);
        if (roleName == null || "".equals(roleName)) {
            throw new ErrorInfo(ErrorCodeInner.SERVER_INNER_ERROR.getErrorCode(), "fail to get roleName : role_mailbox");
        }
    }

    private void initIdMaker(Properties props) throws IdException {
        int mbmessageIdMakerType = Integer.parseInt(props.getProperty("mbmessageIdMaker", "80"));
        mbmessageIdMaker = IdMakerFactory.getInstance().getIdMaker(mbmessageIdMakerType);
        if (this.mbmessageIdMaker == null) {
            throw new IdException("mbmessageIdMaker create failed!");
        }

        int mbmessageTemplateIdMakerType = Integer.parseInt(props.getProperty("mbmessageTemplateIdMaker", "81"));
        mbmessageTemplateIdMaker = IdMakerFactory.getInstance().getIdMaker(mbmessageTemplateIdMakerType);
        if (this.mbmessageTemplateIdMaker == null) {
            throw new IdException("mbmessageTemplateIdMaker create failed!");
        }

        int mbmessageJobIdMakerType = Integer.parseInt(props.getProperty("mbmessageJobIdMaker", "82"));
        mbmessageJobIdMaker = IdMakerFactory.getInstance().getIdMaker(mbmessageJobIdMakerType);
        if (this.mbmessageJobIdMaker == null) {
            throw new IdException("mbmessageJobIdMaker create failed!");
        }
    }

    public String getRoleName() {
        return roleName;
    }

    public IdMaker getMbmessageIdMaker() {
        return mbmessageIdMaker;
    }

    public IdMaker getMbmessageTemplateIdMaker() {
        return mbmessageTemplateIdMaker;
    }

    public IdMaker getMbmessageJobIdMaker() {
        return mbmessageJobIdMaker;
    }
}
