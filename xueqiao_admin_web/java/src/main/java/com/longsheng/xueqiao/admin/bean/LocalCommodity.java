package com.longsheng.xueqiao.admin.bean;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.math.RandomUtils;
import org.apache.thrift.TException;
import org.soldier.base.logger.AppLog;
import org.soldier.platform.svr_platform.comm.ErrorInfo;

import com.longsheng.xueqiao.admin.util.TimeFormator;
import com.longsheng.xueqiao.contract.standard.thriftapi.CmbDirect;
import com.longsheng.xueqiao.contract.standard.thriftapi.CommodityState;
import com.longsheng.xueqiao.contract.standard.thriftapi.ReqSledCommodityOption;
import com.longsheng.xueqiao.contract.standard.thriftapi.SledCommodity;
import com.longsheng.xueqiao.contract.standard.thriftapi.SledCommodityConfig;
import com.longsheng.xueqiao.contract.standard.thriftapi.SledCommodityType;
import com.longsheng.xueqiao.contract.thriftapi.SledCommodityEdit;
import com.longsheng.xueqiao.contract.thriftapi.SledCommodityEditPage;
import com.longsheng.xueqiao.contract.thriftapi.client.ContractServiceStub;

public class LocalCommodity {

    private static DecimalFormat DOUBLE_FORMAT = new DecimalFormat("######0.0#################");

    private int sledCommodityId;
    private String sledCommodityType;
    private String sledCommodityCode;
    private String exchangeMic;

    private List<LocalSimpleCommodity> relateCommodityList;
    private List<Integer> relateCommodityIdList;

    private String tradeCurrency;
    private String timezone;
    private double contractSize;
    private double tickSize;
    private String tickSizeStr;
    private int denominator;
    private String cmbDirect;
    private String commodityState;

    private List<LocalCommodityConfig> localCommodityConfigList;

    private String engName;
    private String cnName;
    private String tcName;

    private String engAcronym;                        // 英文简称
    private String cnAcronym;                        // 中文简称
    private String tcAcronym;                        // 繁体简称

    private String editStatus;
    private String workingStatus;

    private String mappingCode;

    public int getSledCommodityId() {
        return sledCommodityId;
    }

    public void setSledCommodityId(int sledCommodityId) {
        this.sledCommodityId = sledCommodityId;
    }

    public String getSledCommodityType() {
        return sledCommodityType;
    }

    public void setSledCommodityType(String sledCommodityType) {
        this.sledCommodityType = sledCommodityType;
    }

    public String getSledCommodityCode() {
        return sledCommodityCode;
    }

    public void setSledCommodityCode(String sledCommodityCode) {
        this.sledCommodityCode = sledCommodityCode;
    }

    public String getExchangeMic() {
        return exchangeMic;
    }

    public void setExchangeMic(String exchangeMic) {
        this.exchangeMic = exchangeMic;
    }

    public List<LocalSimpleCommodity> getRelateCommodityList() {
        return relateCommodityList;
    }

    public void setRelateCommodityList(List<LocalSimpleCommodity> relateCommodityList) {
        this.relateCommodityList = relateCommodityList;
    }

    public List<Integer> getRelateCommodityIdList() {
        return relateCommodityIdList;
    }

    public void setRelateCommodityIdList(List<Integer> relateCommodityIdList) {
        this.relateCommodityIdList = relateCommodityIdList;
    }

    public String getTradeCurrency() {
        return tradeCurrency;
    }

    public void setTradeCurrency(String tradeCurrency) {
        this.tradeCurrency = tradeCurrency;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public double getContractSize() {
        return contractSize;
    }

    public void setContractSize(double contractSize) {
        this.contractSize = contractSize;
    }

    public double getTickSize() {
        return tickSize;
    }

    public void setTickSize(double tickSize) {
        this.tickSize = tickSize;
    }

    public String getTickSizeStr() {
        return tickSizeStr;
    }

    public void setTickSizeStr(String tickSizeStr) {
        this.tickSizeStr = tickSizeStr;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    public String getCmbDirect() {
        return cmbDirect;
    }

    public void setCmbDirect(String cmbDirect) {
        this.cmbDirect = cmbDirect;
    }

    public String getCommodityState() {
        return commodityState;
    }

    public void setCommodityState(String commodityState) {
        this.commodityState = commodityState;
    }

    public List<LocalCommodityConfig> getLocalCommodityConfigList() {
        return localCommodityConfigList;
    }

    public void setLocalCommodityConfigList(List<LocalCommodityConfig> localCommodityConfigList) {
        this.localCommodityConfigList = localCommodityConfigList;
    }

    public String getEngName() {
        return engName;
    }

    public void setEngName(String engName) {
        this.engName = engName;
    }

    public String getCnName() {
        return cnName;
    }

    public void setCnName(String cnName) {
        this.cnName = cnName;
    }

    public String getTcName() {
        return tcName;
    }

    public void setTcName(String tcName) {
        this.tcName = tcName;
    }

    public String getEngAcronym() {
        return engAcronym;
    }

    public void setEngAcronym(String engAcronym) {
        this.engAcronym = engAcronym;
    }

    public String getCnAcronym() {
        return cnAcronym;
    }

    public void setCnAcronym(String cnAcronym) {
        this.cnAcronym = cnAcronym;
    }

    public String getTcAcronym() {
        return tcAcronym;
    }

    public void setTcAcronym(String tcAcronym) {
        this.tcAcronym = tcAcronym;
    }

    public String getEditStatus() {
        return editStatus;
    }

    public void setEditStatus(String editStatus) {
        this.editStatus = editStatus;
    }

    public String getWorkingStatus() {
        return workingStatus;
    }

    public void setWorkingStatus(String workingStatus) {
        this.workingStatus = workingStatus;
    }

    public String getMappingCode() {
        return mappingCode;
    }

    public void setMappingCode(String mappingCode) {
        this.mappingCode = mappingCode;
    }

    public static LocalCommodity transferToLocalCommodity(ContractServiceStub stub, SledCommodityEdit sledCommodityEdit,
                                                          boolean withConfig) throws ErrorInfo, TException {
        LocalCommodity localCommodity = new LocalCommodity();

        localCommodity.setSledCommodityId(sledCommodityEdit.getSledCommodity().getSledCommodityId());
        localCommodity.setExchangeMic(sledCommodityEdit.getSledCommodity().getExchangeMic());
        localCommodity.setSledCommodityType(sledCommodityEdit.getSledCommodity().getSledCommodityType().name());
        localCommodity.setSledCommodityCode(sledCommodityEdit.getSledCommodity().getSledCommodityCode());

        List<LocalSimpleCommodity> relateCommodityList = new ArrayList<LocalSimpleCommodity>();
        for (int id : sledCommodityEdit.getSledCommodity().getRelateCommodityIds()) {
            LocalSimpleCommodity localSimpleCommodity = new LocalSimpleCommodity();
            localSimpleCommodity.setSledCommodityId(String.valueOf(id));
            localSimpleCommodity.setSledCommodityCode(getCommodityCodeById(stub, id));
            relateCommodityList.add(localSimpleCommodity);
        }
        localCommodity.setRelateCommodityList(relateCommodityList);

        localCommodity.setTradeCurrency(sledCommodityEdit.getSledCommodity().getTradeCurrency());
        localCommodity.setTimezone(sledCommodityEdit.getSledCommodity().getZoneId());
        localCommodity.setContractSize(sledCommodityEdit.getSledCommodity().getContractSize());
        localCommodity.setTickSize(sledCommodityEdit.getSledCommodity().getTickSize());
        localCommodity.setTickSizeStr(DOUBLE_FORMAT.format(sledCommodityEdit.getSledCommodity().getTickSize()));
        AppLog.i("LocalCommodity ---- transferToLocalCommodity ---- TickSize() : " + sledCommodityEdit.getSledCommodity().getTickSize() + ", TickSizeStr : " + localCommodity.getTickSizeStr());

        localCommodity.setDenominator(sledCommodityEdit.getSledCommodity().getDenominator());
        localCommodity.setCmbDirect(sledCommodityEdit.getSledCommodity().getCmbDirect().name());
        localCommodity.setCommodityState(sledCommodityEdit.getSledCommodity().getCommodityState().name());

        localCommodity.setEngName(sledCommodityEdit.getSledCommodity().getEngName());
        localCommodity.setCnName(sledCommodityEdit.getSledCommodity().getCnName());
        localCommodity.setTcName(sledCommodityEdit.getSledCommodity().getTcName());

        localCommodity.setEngAcronym(sledCommodityEdit.getSledCommodity().getEngAcronym());
        localCommodity.setCnAcronym(sledCommodityEdit.getSledCommodity().getCnAcronym());
        localCommodity.setTcAcronym(sledCommodityEdit.getSledCommodity().getTcAcronym());

        localCommodity.setEditStatus(sledCommodityEdit.getEditStatus().name());
        localCommodity.setWorkingStatus(sledCommodityEdit.getWorkingStatus().name());

        AppLog.i("LocalCommodity ---- transferToLocalCommodity ---- withConfig : " + withConfig + ", config size : "
                + sledCommodityEdit.getSledCommodity().getSledCommodityConfig().size() + ", TICKSIZE : " + localCommodity.getTickSize());
        if (withConfig) {
            localCommodity.setLocalCommodityConfigList(
                    transferToLocalCommodityConfig(sledCommodityEdit.getSledCommodity().getSledCommodityConfig()));
        }

        return localCommodity;
    }

    private static List<LocalCommodityConfig> transferToLocalCommodityConfig(
            List<SledCommodityConfig> sledCommodityConfigList) {
        List<LocalCommodityConfig> localCommodityConfigList = new ArrayList<LocalCommodityConfig>();
        if (sledCommodityConfigList != null) {
            for (SledCommodityConfig sledCommodityConfig : sledCommodityConfigList) {
                LocalCommodityConfig localCommodityConfig = new LocalCommodityConfig();

                localCommodityConfig.setConfigId(sledCommodityConfig.getConfigId());
                if (sledCommodityConfig.getDeliveryMode() != null) {
                    localCommodityConfig.setDeliveryMode(sledCommodityConfig.getDeliveryMode().name());
                }
                localCommodityConfig.setDeliveryDays(sledCommodityConfig.getDeliveryDays());
                localCommodityConfig.setMaxSingleOrderVol(sledCommodityConfig.getMaxSingleOrderVol());
                localCommodityConfig.setMaxHoldVol(sledCommodityConfig.getMaxHoldVol());

                if (sledCommodityConfig.getCommissionCalculateMode() != null) {
                    localCommodityConfig
                            .setCommissionCalculateMode(sledCommodityConfig.getCommissionCalculateMode().name());
                }
                localCommodityConfig.setOpenCloseFee(sledCommodityConfig.getOpenCloseFee());

                if (sledCommodityConfig.getMarginCalculateMode() != null) {
                    localCommodityConfig.setMarginCalculateMode(sledCommodityConfig.getMarginCalculateMode().name());
                }
                localCommodityConfig.setInitialMargin(sledCommodityConfig.getInitialMargin());
                localCommodityConfig.setMaintenanceMargin(sledCommodityConfig.getMaintenanceMargin());
                localCommodityConfig.setSellInitialMargin(sledCommodityConfig.getSellInitialMargin());
                localCommodityConfig.setSellMaintenanceMargin(sledCommodityConfig.getSellMaintenanceMargin());
                localCommodityConfig.setLockMargin(sledCommodityConfig.getLockMargin());

                localCommodityConfig.setActiveStartTimestamp(
                        TimeFormator.timeStampToDate2(sledCommodityConfig.getActiveStartTimestamp()));
                localCommodityConfig.setActiveEndTimestamp(
                        TimeFormator.timeStampToDate2(sledCommodityConfig.getActiveEndTimestamp()));

                long currentTimeStamp = TimeFormator
                        .dateToTimeStamp2(TimeFormator.timeStampToDate2(System.currentTimeMillis() / 1000));

                AppLog.i(
                        "LocalCommodity ---- transferToLocalCommodityConfig ---- currentTimeStamp : " + currentTimeStamp
                                + ", ActiveStartTimestamp() : " + sledCommodityConfig.getActiveStartTimestamp()
                                + ", sledCommodityConfig.getActiveEndTimestamp() : "
                                + sledCommodityConfig.getActiveEndTimestamp());

                if (currentTimeStamp < sledCommodityConfig.getActiveStartTimestamp()) {
                    localCommodityConfig.setWorkingStatus("未生效");
                } else if (currentTimeStamp >= sledCommodityConfig.getActiveEndTimestamp()) {
                    localCommodityConfig.setWorkingStatus("已失效");
                } else {
                    localCommodityConfig.setWorkingStatus("生效中");
                }

                localCommodityConfig.setChargeUnit(DOUBLE_FORMAT.format(sledCommodityConfig.getChargeUnit()));
                localCommodityConfig.setMeasureUnit(sledCommodityConfig.getMeasureUnit());

                localCommodityConfigList.add(localCommodityConfig);
            }
        }
        AppLog.i("LocalCommodity ---- transferToLocalCommodityConfig ---- localCommodityConfigList : "
                + localCommodityConfigList.size());
        return localCommodityConfigList;
    }

    public static List<LocalCommodity> transferToLocalCommodityList(ContractServiceStub stub,
                                                                    List<SledCommodityEdit> sledCommodityEditList) throws ErrorInfo, TException {
        List<LocalCommodity> localCommodityList = new ArrayList<LocalCommodity>();
        for (SledCommodityEdit sledCommodityEdit : sledCommodityEditList) {
            localCommodityList.add(transferToLocalCommodity(stub, sledCommodityEdit, false));
        }
        return localCommodityList;
    }

    public static SledCommodity transferToSledCommodity(LocalCommodity localCommodity) {
        SledCommodity sledCommodity = new SledCommodity();

        sledCommodity.setSledCommodityId(localCommodity.getSledCommodityId());
        sledCommodity.setExchangeMic(localCommodity.getExchangeMic());
        if (localCommodity.getSledCommodityType() != null) {
            sledCommodity.setSledCommodityType(SledCommodityType.valueOf(localCommodity.getSledCommodityType()));
        }
        sledCommodity.setSledCommodityCode(localCommodity.getSledCommodityCode());

        if (localCommodity.getRelateCommodityIdList() != null) {
            sledCommodity.setRelateCommodityIds(localCommodity.getRelateCommodityIdList());
        }

        sledCommodity.setTradeCurrency(localCommodity.getTradeCurrency());
        // not need to provide timezone info.
//		sledCommodity.setTimezone(localCommodity.getTimezone());
        sledCommodity.setContractSize(localCommodity.getContractSize());
        sledCommodity.setTickSize(localCommodity.getTickSize());
        sledCommodity.setDenominator(localCommodity.getDenominator());
        if (localCommodity.getCmbDirect() != null) {
            sledCommodity.setCmbDirect(CmbDirect.valueOf(localCommodity.getCmbDirect()));
        }
        if (localCommodity.getCommodityState() != null) {
            sledCommodity.setCommodityState(CommodityState.valueOf(localCommodity.getCommodityState()));
        }

        sledCommodity.setEngName(localCommodity.getEngName());
        sledCommodity.setCnName(localCommodity.getCnName());
        sledCommodity.setTcName(localCommodity.getTcName());

        sledCommodity.setEngAcronym(localCommodity.getEngAcronym());
        sledCommodity.setCnAcronym(localCommodity.getCnAcronym());
        sledCommodity.setTcAcronym(localCommodity.getTcAcronym());

        return sledCommodity;
    }

    private static String getCommodityCodeById(ContractServiceStub stub, int commodityId) throws ErrorInfo, TException {
        String commodityCode = "";
        ReqSledCommodityOption option = new ReqSledCommodityOption();
        List<Integer> sledCommodityIdList = new ArrayList<Integer>();
        sledCommodityIdList.add(commodityId);
        option.setSledCommodityIdList(sledCommodityIdList);
        SledCommodityEditPage sledCommodityEditPage = stub.reqSledCommodity(RandomUtils.nextInt(), 3000, option, 0, 1);
        if (sledCommodityEditPage.getPageSize() > 0) {
            commodityCode = sledCommodityEditPage.getPage().get(0).getSledCommodity().getSledCommodityCode();
        }
        return commodityCode;
    }
}
