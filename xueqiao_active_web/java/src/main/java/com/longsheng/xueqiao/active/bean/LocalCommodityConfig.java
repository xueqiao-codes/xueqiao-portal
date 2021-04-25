package com.longsheng.xueqiao.active.bean;

import com.longsheng.xueqiao.active.util.StringUtil;
import org.soldier.base.logger.AppLog;

import com.longsheng.xueqiao.active.util.TimeFormator;
import com.longsheng.xueqiao.contract.standard.thriftapi.CalculateMode;
import com.longsheng.xueqiao.contract.standard.thriftapi.DeliveryMode;
import com.longsheng.xueqiao.contract.standard.thriftapi.SledCommodityConfig;

import java.text.DecimalFormat;

public class LocalCommodityConfig {

	private static DecimalFormat DOUBLE_FORMAT = new DecimalFormat("######0.0#################");

	private int sledCommodityId;
	private int configId; // 配置信息id
	private String deliveryMode; // 交割行权方式
	private int deliveryDays; // 交割日偏移
	private int maxSingleOrderVol; // 单笔最大下单量
	private int maxHoldVol; // 最大持仓

	private String commissionCalculateMode; // 手续费计算方式
	private double openCloseFee; // 开平手续费计算因子
	private String openCloseFeeStr; // 开平手续费计算因子

	private String marginCalculateMode; // 保证金计算方式
	private double initialMargin; // 初始保证金计算因子
	private String initialMarginStr;
	private double maintenanceMargin; // 维持保证金计算因子
	private String maintenanceMarginStr;
	private double sellInitialMargin; // 看空初始保证金计算因子
	private String sellInitialMarginStr;
	private double sellMaintenanceMargin; // 看空维持保证金计算因子
	private String sellMaintenanceMarginStr;
	private double lockMargin; // 锁仓保证金计算因子
	private String lockMarginStr;

	private String activeStartTimestamp; // 生效起始日期
	private String activeEndTimestamp; // 生效结束日期

	private String measureUnit; // 计量单位
	private String chargeUnit; // 计价单位 double

	private String createTimestamp; // 创建时间
	private String lastModityTimestamp; // 最后修改时间

	private String workingStatus; // 根据生效超始日期和结束日期计算该状态 【生效中，未生效， 已失效】

	public int getSledCommodityId() {
		return sledCommodityId;
	}

	public void setSledCommodityId(int sledCommodityId) {
		this.sledCommodityId = sledCommodityId;
	}

	public int getConfigId() {
		return configId;
	}

	public void setConfigId(int configId) {
		this.configId = configId;
	}

	public String getDeliveryMode() {
		return deliveryMode;
	}

	public void setDeliveryMode(String deliveryMode) {
		this.deliveryMode = deliveryMode;
	}

	public int getDeliveryDays() {
		return deliveryDays;
	}

	public void setDeliveryDays(int deliveryDays) {
		this.deliveryDays = deliveryDays;
	}

	public int getMaxSingleOrderVol() {
		return maxSingleOrderVol;
	}

	public void setMaxSingleOrderVol(int maxSingleOrderVol) {
		this.maxSingleOrderVol = maxSingleOrderVol;
	}

	public int getMaxHoldVol() {
		return maxHoldVol;
	}

	public void setMaxHoldVol(int maxHoldVol) {
		this.maxHoldVol = maxHoldVol;
	}

	public String getCommissionCalculateMode() {
		return commissionCalculateMode;
	}

	public void setCommissionCalculateMode(String commissionCalculateMode) {
		this.commissionCalculateMode = commissionCalculateMode;
	}

	public double getOpenCloseFee() {
		return openCloseFee;
	}

	public void setOpenCloseFee(double openCloseFee) {
		this.openCloseFee = openCloseFee;
		this.openCloseFeeStr = StringUtil.getDoubleString(openCloseFee);
	}

	public String getMarginCalculateMode() {
		return marginCalculateMode;
	}

	public void setMarginCalculateMode(String marginCalculateMode) {
		this.marginCalculateMode = marginCalculateMode;
	}

	public double getInitialMargin() {
		return initialMargin;
	}

	public void setInitialMargin(double initialMargin) {
		this.initialMargin = initialMargin;
		this.initialMarginStr = StringUtil.getDoubleString(initialMargin);
	}

	public double getMaintenanceMargin() {
		return maintenanceMargin;
	}

	public void setMaintenanceMargin(double maintenanceMargin) {
		this.maintenanceMargin = maintenanceMargin;
		this.maintenanceMarginStr = StringUtil.getDoubleString(maintenanceMargin);
	}

	public double getSellInitialMargin() {
		return sellInitialMargin;
	}

	public void setSellInitialMargin(double sellInitialMargin) {
		this.sellInitialMargin = sellInitialMargin;
		this.sellInitialMarginStr = StringUtil.getDoubleString(sellInitialMargin);
	}

	public double getSellMaintenanceMargin() {
		return sellMaintenanceMargin;
	}

	public void setSellMaintenanceMargin(double sellMaintenanceMargin) {
		this.sellMaintenanceMargin = sellMaintenanceMargin;
		this.sellMaintenanceMarginStr = StringUtil.getDoubleString(sellMaintenanceMargin);
	}

	public double getLockMargin() {
		return lockMargin;
	}

	public void setLockMargin(double lockMargin) {
		this.lockMargin = lockMargin;
		this.lockMarginStr = StringUtil.getDoubleString(lockMargin);
	}

	public String getInitialMarginStr() {
		return initialMarginStr;
	}

	public String getMaintenanceMarginStr() {
		return maintenanceMarginStr;
	}

	public String getSellInitialMarginStr() {
		return sellInitialMarginStr;
	}

	public String getSellMaintenanceMarginStr() {
		return sellMaintenanceMarginStr;
	}

	public String getLockMarginStr() {
		return lockMarginStr;
	}

	public String getOpenCloseFeeStr() {
		return openCloseFeeStr;
	}

	public String getActiveStartTimestamp() {
		return activeStartTimestamp;
	}

	public void setActiveStartTimestamp(String activeStartTimestamp) {
		this.activeStartTimestamp = activeStartTimestamp;
	}

	public String getActiveEndTimestamp() {
		return activeEndTimestamp;
	}

	public void setActiveEndTimestamp(String activeEndTimestamp) {
		this.activeEndTimestamp = activeEndTimestamp;
	}

	public String getMeasureUnit() {
		return measureUnit;
	}

	public void setMeasureUnit(String measureUnit) {
		this.measureUnit = measureUnit;
	}

	public String getChargeUnit() {
		return chargeUnit;
	}

	public void setChargeUnit(String chargeUnit) {
		this.chargeUnit = chargeUnit;
	}

	public String getCreateTimestamp() {
		return createTimestamp;
	}

	public void setCreateTimestamp(String createTimestamp) {
		this.createTimestamp = createTimestamp;
	}

	public String getLastModityTimestamp() {
		return lastModityTimestamp;
	}

	public void setLastModityTimestamp(String lastModityTimestamp) {
		this.lastModityTimestamp = lastModityTimestamp;
	}

	public String getWorkingStatus() {
		return workingStatus;
	}

	public void setWorkingStatus(String workingStatus) {
		this.workingStatus = workingStatus;
	}

	public static SledCommodityConfig transferToSledCommodityConfig(LocalCommodityConfig localCommodityConfig) {
		SledCommodityConfig sledCommodityConfig = new SledCommodityConfig();

		sledCommodityConfig.setConfigId(localCommodityConfig.getConfigId());
		if (localCommodityConfig.getDeliveryMode() != null) {
			sledCommodityConfig.setDeliveryMode(DeliveryMode.valueOf(localCommodityConfig.getDeliveryMode()));
		}
		sledCommodityConfig.setDeliveryDays(localCommodityConfig.getDeliveryDays());
		sledCommodityConfig.setMaxSingleOrderVol(localCommodityConfig.getMaxSingleOrderVol());
		sledCommodityConfig.setMaxHoldVol(localCommodityConfig.getMaxHoldVol());

		if (localCommodityConfig.getCommissionCalculateMode() != null) {
			sledCommodityConfig.setCommissionCalculateMode(
				CalculateMode.valueOf(localCommodityConfig.getCommissionCalculateMode()));
		}
		sledCommodityConfig.setOpenCloseFee(localCommodityConfig.getOpenCloseFee());

		if (localCommodityConfig.getMarginCalculateMode() != null) {
			sledCommodityConfig
				.setMarginCalculateMode(CalculateMode.valueOf(localCommodityConfig.getMarginCalculateMode()));
		}
		sledCommodityConfig.setInitialMargin(localCommodityConfig.getInitialMargin());
		sledCommodityConfig.setMaintenanceMargin(localCommodityConfig.getMaintenanceMargin());
		sledCommodityConfig.setSellInitialMargin(localCommodityConfig.getSellInitialMargin());
		sledCommodityConfig.setSellMaintenanceMargin(localCommodityConfig.getSellMaintenanceMargin());
		sledCommodityConfig.setLockMargin(localCommodityConfig.getLockMargin());

		AppLog.i("LocalCommodityConfig ---- transferToSledCommodityConfig ---- ActiveStartTimestamp() : "
			+ localCommodityConfig.getActiveStartTimestamp() + ", ActiveEndTimestamp() : "
			+ localCommodityConfig.getActiveEndTimestamp());
		if (localCommodityConfig.getActiveStartTimestamp() != null) {
			sledCommodityConfig.setActiveStartTimestamp(
				TimeFormator.dateToTimeStamp2(localCommodityConfig.getActiveStartTimestamp()));
		}
		if (localCommodityConfig.getActiveEndTimestamp() != null) {
			sledCommodityConfig
				.setActiveEndTimestamp(TimeFormator.dateToTimeStamp2(localCommodityConfig.getActiveEndTimestamp()));
		}

		sledCommodityConfig.setChargeUnit(Double.valueOf(localCommodityConfig.getChargeUnit()));
		sledCommodityConfig.setMeasureUnit(localCommodityConfig.getMeasureUnit());

		return sledCommodityConfig;
	}
}
