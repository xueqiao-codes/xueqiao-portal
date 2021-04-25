package com.longsheng.xueqiao.admin.web.controller;

import java.io.IOException;

import org.apache.commons.lang.math.RandomUtils;
import org.apache.thrift.TException;
import org.soldier.platform.svr_platform.comm.ErrorInfo;
import org.soldier.platform.web_framework.model.ErrorResult;

import com.longsheng.xueqiao.broker.dao.thriftapi.SyncBrokerOption;
import com.longsheng.xueqiao.broker.dao.thriftapi.SyncBrokerResp;
import com.longsheng.xueqiao.broker.dao.thriftapi.client.BrokerDaoServiceStub;
import com.longsheng.xueqiao.contract.thriftapi.DbLockingInfo;
import com.longsheng.xueqiao.contract.thriftapi.SyncContractOption;
import com.longsheng.xueqiao.contract.thriftapi.SyncContractResp;
import com.longsheng.xueqiao.contract.thriftapi.SyncTradeTimeResp;
import com.longsheng.xueqiao.contract.thriftapi.client.ContractServiceStub;

public abstract class AbstractDBLockController extends OaAuthController {

    public enum ModuleType {
        MM_CONTRACT,
        MM_BROKER,
        MM_TRADE_TIME,
    }

    public static final int LOCK_SUCCESS = 0;
    public static final int UNLOCK_SUCCESS = 0;
    public static final int LOCK_ERR_LOGIN_FAIL = 5;
    public static final int LOCK_ERR_LOCK_BY_OTHERS = 8;
    public static final int LOCK_ERR_LOCK_IN_OTHER_MODULE = 9;
    public static final int LOCK_ERR_LOCK_ALREADY = 10;
    public static final int LOCK_ERR_MODULE_UNLOCK = 15;

    public static final int SYNC_CONTRACT_FAIL = 20;
    public static final int SYNC_BROKER_FAIL = 21;

    private static final int LONG_TIME_OUT = 10000;

    protected void getModuleLockStatus(ModuleType moduleType) throws ErrorInfo, TException {
        ContractServiceStub stub = new ContractServiceStub();
        int moduleLock = getModuleLockStatus(stub, moduleType);

        String lockUserName = getLockUsername(stub);
        String lockModule = getLockModule(stub);
        put("moduleEditable", moduleLock);
        put("lockUserName", lockUserName);
        put("lockModule", getCNModuleName(lockModule));
    }

    private String getCNModuleName(String moduleType) {
        if ("MM_CONTRACT".equals(moduleType)) {
            return "合约管理";
        } else if ("MM_BROKER".equals(moduleType)) {
            return "券商管理";
        } else if ("MM_TRADE_TIME".equals(moduleType)) {
            return "交易时间管理";
        } else {
            return moduleType;
        }
    }

    /**
     * 返回值：
     * 0：目前无锁
     * 1：自己本模块加锁
     * 2：自已别的模块加锁
     * 3：他人加锁
     * */
    private int getModuleLockStatus(ContractServiceStub contractServiceStub, ModuleType moduleType) throws ErrorInfo, TException {
        DbLockingInfo dbLockingInfo = contractServiceStub.reqDbLockingInfo();
        if (dbLockingInfo.isIsLocked()) {
            String currentUsername = getUserName();
            if (currentUsername != null && !currentUsername.isEmpty()) {
                if (currentUsername.equals(dbLockingInfo.getLockedBy())) {
                    if (moduleType.name().equals(dbLockingInfo.getLockArea())) {
                        return 1;
                    } else {
                        return 2;
                    }
                } else {
                    return 3;
                }
            } else {
                throw new ErrorInfo(600, "获取oa用户信息失败，请尝试刷新页面后重启");
            }
        }
        return 0;
    }

    private boolean isModuleEditable(ContractServiceStub contractServiceStub, ModuleType moduleType) throws TException {
        return getModuleLockStatus(contractServiceStub, moduleType) == 1;
    }

    protected synchronized int lockModule(ContractServiceStub contractServiceStub, ModuleType moduleType) throws ErrorInfo, TException {
        String currentUsername = getUserName();
        if (currentUsername != null && !currentUsername.isEmpty()) {
            DbLockingInfo dbLockingInfo = contractServiceStub.reqDbLockingInfo();
            if (dbLockingInfo.isIsLocked()) {
                if (currentUsername.equals(dbLockingInfo.getLockedBy())) {
                    if (moduleType.name().equals(dbLockingInfo.getLockArea())) {
                        return LOCK_ERR_LOCK_ALREADY;
                    } else {
                        return LOCK_ERR_LOCK_IN_OTHER_MODULE;
                    }
                } else {
                    return LOCK_ERR_LOCK_BY_OTHERS;
                }
            } else {
                dbLockingInfo = new DbLockingInfo();
                dbLockingInfo.setLockedBy(currentUsername);
                dbLockingInfo.setLockArea(moduleType.name());
                contractServiceStub.addDbLocking(dbLockingInfo);
            }
        } else {
            return LOCK_ERR_LOGIN_FAIL;
        }
        return LOCK_SUCCESS;
    }

    protected synchronized int unlockModule(ContractServiceStub contractServiceStub, ModuleType moduleType) throws ErrorInfo, TException {
        String currentUsername = getUserName();
        if (currentUsername != null && !currentUsername.isEmpty()) {
            if (isModuleEditable(contractServiceStub, moduleType)) {
                contractServiceStub.removeDbLocking(currentUsername);
            } else {
                return LOCK_ERR_MODULE_UNLOCK;
            }
        } else {
            return LOCK_ERR_LOGIN_FAIL;
        }

        return UNLOCK_SUCCESS;
    }

    protected synchronized int _unlockModuleContract(ContractServiceStub contractServiceStub) throws ErrorInfo, TException {
        String currentUsername = getUserName();
        if (currentUsername != null && !currentUsername.isEmpty()) {
            if (isModuleEditable(contractServiceStub, ModuleType.MM_CONTRACT)) {
                SyncContractOption syncContractOption = new SyncContractOption();
                syncContractOption.setUserName(currentUsername);
                SyncContractResp syncContractResp = contractServiceStub.syncContract(RandomUtils.nextInt(), LONG_TIME_OUT, syncContractOption);
                if (!syncContractResp.isSuccess()) {
                    return SYNC_CONTRACT_FAIL;
                }
                // syncContract has already removeDbLocking.
//				contractServiceStub.removeDbLocking(currentUsername);
            } else {
                return LOCK_ERR_MODULE_UNLOCK;
            }
        } else {
            return LOCK_ERR_LOGIN_FAIL;
        }

        return UNLOCK_SUCCESS;
    }

    protected synchronized int _unlockModuleBroker(ContractServiceStub contractServiceStub) throws ErrorInfo, TException {
        String currentUsername = getUserName();
        if (currentUsername != null && !currentUsername.isEmpty()) {
            if (isModuleEditable(contractServiceStub, ModuleType.MM_BROKER)) {
                // sync broker
                BrokerDaoServiceStub brokerDaoServiceStub = new BrokerDaoServiceStub();
                SyncBrokerOption syncBrokerOption = new SyncBrokerOption();
                syncBrokerOption.setUserName(currentUsername);
                SyncBrokerResp syncBrokerResp = brokerDaoServiceStub.syncBroker(RandomUtils.nextInt(), LONG_TIME_OUT, syncBrokerOption);
                if (!syncBrokerResp.isSuccess()) {
                    return SYNC_BROKER_FAIL;
                }

                // sync contract
//				SyncContractOption syncContractOption = new SyncContractOption();
//				syncContractOption.setUserName(currentUsername);
//				SyncContractResp syncContractResp = contractServiceStub.syncContract(RandomUtils.nextInt(), LONG_TIME_OUT, syncContractOption);
//				if (!syncContractResp.isSuccess()) {
//					return SYNC_CONTRACT_FAIL;
//				}
                // syncContract has already removeDbLocking.
//				contractServiceStub.removeDbLocking(currentUsername);
            } else {
                return LOCK_ERR_MODULE_UNLOCK;
            }
        } else {
            return LOCK_ERR_LOGIN_FAIL;
        }

        return UNLOCK_SUCCESS;
    }

    protected synchronized int unlockModuleTradeTime(ContractServiceStub contractServiceStub) throws ErrorInfo, TException {
        String currentUsername = getUserName();
        if (currentUsername != null && !currentUsername.isEmpty()) {
            if (isModuleEditable(contractServiceStub, ModuleType.MM_CONTRACT)) {
                // sync trade time (the same as sync contract)
                SyncContractOption syncContractOption = new SyncContractOption();
                syncContractOption.setUserName(currentUsername);
                SyncContractResp syncContractResp = contractServiceStub.syncContract(RandomUtils.nextInt(), LONG_TIME_OUT, syncContractOption);
                if (!syncContractResp.isSuccess()) {
                    return SYNC_CONTRACT_FAIL;
                }
            } else {
                return LOCK_ERR_MODULE_UNLOCK;
            }
        } else {
            return LOCK_ERR_LOGIN_FAIL;
        }

        return UNLOCK_SUCCESS;
    }

    protected String getLockUsername(ContractServiceStub contractServiceStub) throws ErrorInfo, TException {
        DbLockingInfo dbLockingInfo = contractServiceStub.reqDbLockingInfo();
        return dbLockingInfo.getLockedBy();
    }

    protected String getLockModule(ContractServiceStub contractServiceStub) throws ErrorInfo, TException {
        DbLockingInfo dbLockingInfo = contractServiceStub.reqDbLockingInfo();
        return dbLockingInfo.getLockArea();
    }


    public void unlockModuleContract() throws IOException {
        ErrorResult result = new ErrorResult();
        ContractServiceStub stub = new ContractServiceStub();
        try {
            int ret = _unlockModuleContract(stub);
            if (ret == SYNC_CONTRACT_FAIL) {
                result.setErrorCode(SYNC_CONTRACT_FAIL);
                result.setErrorMsg("同步合约失败");
            } else if (ret == LOCK_ERR_LOGIN_FAIL) {
                result.setErrorCode(LOCK_ERR_LOGIN_FAIL);
                result.setErrorMsg("用户登录信息过期，请重新登录后再试");
            } else if (ret == LOCK_ERR_MODULE_UNLOCK) {
                result.setErrorCode(LOCK_ERR_MODULE_UNLOCK);
                result.setErrorMsg("目前已处于非编辑状态");
            }
        } catch (ErrorInfo errorInfo) {
            errorInfo.printStackTrace();
            result.setErrorCode(errorInfo.getErrorCode());
            result.setErrorMsg(errorInfo.getErrorMsg() + " : " + errorInfo.getErrorMsg());
        } catch (Throwable e) {
            e.printStackTrace();
            result.setErrorCode(34);
            result.setErrorMsg(e.getMessage());
        }
        echoJson(result);
    }

    public void lockModuleContract() throws IOException {
        ErrorResult result = new ErrorResult();
        ContractServiceStub stub = new ContractServiceStub();
        try {
            int ret = lockModule(stub, ModuleType.MM_CONTRACT);
            if (ret == LOCK_ERR_LOGIN_FAIL) {
                result.setErrorCode(LOCK_ERR_LOGIN_FAIL);
                result.setErrorMsg("用户登录信息过期，请重新登录后再试");
            } else if (ret == LOCK_ERR_LOCK_ALREADY) {
                result.setErrorCode(LOCK_ERR_LOCK_ALREADY);
                result.setErrorMsg("目前已处于编辑状态");
            } else if (ret == LOCK_ERR_LOCK_BY_OTHERS) {
                result.setErrorCode(LOCK_ERR_LOCK_BY_OTHERS);
                result.setErrorMsg(getLockUsername(stub) + "正在编辑中。");
            } else if (ret == LOCK_ERR_LOCK_IN_OTHER_MODULE) {
                result.setErrorCode(LOCK_ERR_LOCK_IN_OTHER_MODULE);
                String currentLockModule = getLockModule(stub);
                if (ModuleType.MM_BROKER.name().equals(currentLockModule)) {
                    result.setErrorMsg("券商管理处于编辑状态，请退出后再尝试");
                } else if (ModuleType.MM_TRADE_TIME.name().equals(currentLockModule)) {
                    result.setErrorMsg("交易时间管理处于编辑状态，请退出后再尝试");
                } else {
                    result.setErrorMsg("其他模块处于编辑状态，请退出后再尝试");
                }

            }
        } catch (ErrorInfo errorInfo) {
            errorInfo.printStackTrace();
            result.setErrorCode(errorInfo.getErrorCode());
            result.setErrorMsg(errorInfo.getErrorMsg() + " : " + errorInfo.getErrorMsg());
        } catch (Throwable e) {
            e.printStackTrace();
            result.setErrorCode(34);
            result.setErrorMsg(e.getMessage());
        }
        echoJson(result);
    }

    public void unlockModuleBroker() throws IOException {
        ErrorResult result = new ErrorResult();
        ContractServiceStub stub = new ContractServiceStub();
        try {
            int ret = _unlockModuleBroker(stub);
            if (ret == SYNC_BROKER_FAIL) {
                result.setErrorCode(SYNC_BROKER_FAIL);
                result.setErrorMsg("同步券商失败");
            } else if (ret == SYNC_CONTRACT_FAIL) {
                result.setErrorCode(SYNC_CONTRACT_FAIL);
                result.setErrorMsg("同步合约失败");
            } else if (ret == LOCK_ERR_LOGIN_FAIL) {
                result.setErrorCode(LOCK_ERR_LOGIN_FAIL);
                result.setErrorMsg("用户登录信息过期，请重新登录后再试");
            } else if (ret == LOCK_ERR_MODULE_UNLOCK) {
                result.setErrorCode(LOCK_ERR_MODULE_UNLOCK);
                result.setErrorMsg("目前已处于非编辑状态");
            }
        } catch (ErrorInfo errorInfo) {
            errorInfo.printStackTrace();
            result.setErrorCode(errorInfo.getErrorCode());
            result.setErrorMsg(errorInfo.getErrorMsg() + " : " + errorInfo.getErrorMsg());
        } catch (Throwable e) {
            e.printStackTrace();
            result.setErrorCode(34);
            result.setErrorMsg(e.getMessage());
        }
        echoJson(result);
    }

    public void lockModuleBroker() throws IOException {
        ErrorResult result = new ErrorResult();
        ContractServiceStub stub = new ContractServiceStub();
        try {
            int ret = lockModule(stub, ModuleType.MM_BROKER);
            if (ret == LOCK_ERR_LOGIN_FAIL) {
                result.setErrorCode(LOCK_ERR_LOGIN_FAIL);
                result.setErrorMsg("用户登录信息过期，请重新登录后再试");
            } else if (ret == LOCK_ERR_LOCK_ALREADY) {
                result.setErrorCode(LOCK_ERR_LOCK_ALREADY);
                result.setErrorMsg("目前已处于编辑状态");
            } else if (ret == LOCK_ERR_LOCK_BY_OTHERS) {
                result.setErrorCode(LOCK_ERR_LOCK_BY_OTHERS);
                result.setErrorMsg(getLockUsername(stub) + "正在编辑中。");
            } else if (ret == LOCK_ERR_LOCK_IN_OTHER_MODULE) {
                result.setErrorCode(LOCK_ERR_LOCK_IN_OTHER_MODULE);
                String currentLockModule = getLockModule(stub);
                if (ModuleType.MM_CONTRACT.name().equals(currentLockModule)) {
                    result.setErrorMsg("合约管理处于编辑状态，请退出后再尝试");
                } else if (ModuleType.MM_TRADE_TIME.name().equals(currentLockModule)) {
                    result.setErrorMsg("交易时间管理处于编辑状态，请退出后再尝试");
                } else {
                    result.setErrorMsg("其他模块处于编辑状态，请退出后再尝试");
                }

            }
        } catch (ErrorInfo errorInfo) {
            errorInfo.printStackTrace();
            result.setErrorCode(errorInfo.getErrorCode());
            result.setErrorMsg(errorInfo.getErrorMsg() + " : " + errorInfo.getErrorMsg());
        } catch (Throwable e) {
            e.printStackTrace();
            result.setErrorCode(34);
            result.setErrorMsg(e.getMessage());
        }
        echoJson(result);
    }

    public void unlockModuleTradeTime() throws IOException {
        ErrorResult result = new ErrorResult();
        ContractServiceStub stub = new ContractServiceStub();
        try {
            int ret = unlockModuleTradeTime(stub);
            if (ret == SYNC_BROKER_FAIL) {
                result.setErrorCode(SYNC_BROKER_FAIL);
                result.setErrorMsg("同步券商失败");
            } else if (ret == SYNC_CONTRACT_FAIL) {
                result.setErrorCode(SYNC_CONTRACT_FAIL);
                result.setErrorMsg("同步合约失败");
            } else if (ret == LOCK_ERR_LOGIN_FAIL) {
                result.setErrorCode(LOCK_ERR_LOGIN_FAIL);
                result.setErrorMsg("用户登录信息过期，请重新登录后再试");
            } else if (ret == LOCK_ERR_MODULE_UNLOCK) {
                result.setErrorCode(LOCK_ERR_MODULE_UNLOCK);
                result.setErrorMsg("目前已处于非编辑状态");
            }
        } catch (ErrorInfo errorInfo) {
            errorInfo.printStackTrace();
            result.setErrorCode(errorInfo.getErrorCode());
            result.setErrorMsg(errorInfo.getErrorMsg() + " : " + errorInfo.getErrorMsg());
        } catch (Throwable e) {
            e.printStackTrace();
            result.setErrorCode(34);
            result.setErrorMsg(e.getMessage());
        }
        echoJson(result);
    }

    public void lockModuleTradeTime() throws IOException {
        ErrorResult result = new ErrorResult();
        ContractServiceStub stub = new ContractServiceStub();
        try {
            int ret = lockModule(stub, ModuleType.MM_CONTRACT);
            if (ret == LOCK_ERR_LOGIN_FAIL) {
                result.setErrorCode(LOCK_ERR_LOGIN_FAIL);
                result.setErrorMsg("用户登录信息过期，请重新登录后再试");
            } else if (ret == LOCK_ERR_LOCK_ALREADY) {
                result.setErrorCode(LOCK_ERR_LOCK_ALREADY);
                result.setErrorMsg("目前已处于编辑状态");
            } else if (ret == LOCK_ERR_LOCK_BY_OTHERS) {
                result.setErrorCode(LOCK_ERR_LOCK_BY_OTHERS);
                result.setErrorMsg(getLockUsername(stub) + "正在编辑中。");
            } else if (ret == LOCK_ERR_LOCK_IN_OTHER_MODULE) {
                result.setErrorCode(LOCK_ERR_LOCK_IN_OTHER_MODULE);
                String currentLockModule = getLockModule(stub);
                if (ModuleType.MM_CONTRACT.name().equals(currentLockModule)) {
                    result.setErrorMsg("合约管理处于编辑状态，请退出后再尝试");
                } else if (ModuleType.MM_BROKER.name().equals(currentLockModule)) {
                    result.setErrorMsg("券商管理处于编辑状态，请退出后再尝试");
                } else {
                    result.setErrorMsg("其他模块处于编辑状态，请退出后再尝试");
                }

            }
        } catch (ErrorInfo errorInfo) {
            errorInfo.printStackTrace();
            result.setErrorCode(errorInfo.getErrorCode());
            result.setErrorMsg(errorInfo.getErrorMsg() + " : " + errorInfo.getErrorMsg());
        } catch (Throwable e) {
            e.printStackTrace();
            result.setErrorCode(34);
            result.setErrorMsg(e.getMessage());
        }
        echoJson(result);
    }
}
