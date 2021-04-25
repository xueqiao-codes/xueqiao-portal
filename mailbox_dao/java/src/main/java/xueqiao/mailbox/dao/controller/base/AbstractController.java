package xueqiao.mailbox.dao.controller.base;

import org.soldier.platform.dal_set.DalSetDataSource;
import org.soldier.platform.svr_platform.container.TServiceCntl;
import xueqiao.mailbox.dao.config.ConfigurationProperty;

public abstract class AbstractController implements IController {
    protected TServiceCntl oCntl;

    public AbstractController(TServiceCntl oCntl) {
        this.oCntl = oCntl;
    }

    protected DalSetDataSource getDalSetDataSource() {
        return new DalSetDataSource(ConfigurationProperty.instance().getRoleName(), oCntl.getDalSetServiceName(), false, 0);
    }
}
