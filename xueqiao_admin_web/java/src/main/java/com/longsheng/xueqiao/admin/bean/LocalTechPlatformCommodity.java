package com.longsheng.xueqiao.admin.bean;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import com.longsheng.xueqiao.contract.thriftapi.TechPlatformCommodity;

public class LocalTechPlatformCommodity {

	private static DecimalFormat DOUBLE_FORMAT = new DecimalFormat("######0.0#################");
	
	private int sledCommodityId; // 内部唯一数字id
	private String exchange; // 交易所代号
	private String commodityType; // 商品类型
	private String commodityCode; // 商品代号
	private List<String> relateCommodityCodes; // 关联商品
	private String tradeCurrency; // 交易币种
	private String timezone; // 商品时区
	private double contractSize; // 合约每手乘数
	private String contractSizeStr;
	private double tickSize; // 最小变动价位
	private String tickSizeStr;
	
	private int denominator; // 报价分母
	private String cmbDirect; // 组合方向
	private String commodityState; // 商品状态

	private String engName; // 商品英文名称
	private String cnName; // 商品简体中文名称
	private String tcName; // 商品繁体中文名称

	private String deliveryMode; // 交割行权方式
	private int deliveryDays; // 交割日偏移
	private int maxSingleOrderVol; // 单笔最大下单量
	private int maxHoldVol; // 最大持仓

	private String commissionCalculateMode; // 手续费计算方式
	private double openCloseFee; // 开平手续费计算因子
	private String openCloseFeeStr;

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

	private String techPlatform; // 所属技术平台

	public int getSledCommodityId() {
		return sledCommodityId;
	}

	public void setSledCommodityId(int sledCommodityId) {
		this.sledCommodityId = sledCommodityId;
	}

	public String getExchange() {
		return exchange;
	}

	public void setExchange(String exchange) {
		this.exchange = exchange;
	}

	public String getCommodityType() {
		return commodityType;
	}

	public void setCommodityType(String commodityType) {
		this.commodityType = commodityType;
	}

	public String getCommodityCode() {
		return commodityCode;
	}

	public void setCommodityCode(String commodityCode) {
		this.commodityCode = commodityCode;
	}

	public List<String> getRelateCommodityCodes() {
		return relateCommodityCodes;
	}

	public void setRelateCommodityCodes(List<String> relateCommodityCodes) {
		this.relateCommodityCodes = relateCommodityCodes;
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
		this.contractSizeStr = DOUBLE_FORMAT.format(contractSize);
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
		this.openCloseFeeStr = DOUBLE_FORMAT.format(openCloseFee);
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
		this.initialMarginStr = DOUBLE_FORMAT.format(initialMargin);
	}

	public double getMaintenanceMargin() {
		return maintenanceMargin;
	}

	public void setMaintenanceMargin(double maintenanceMargin) {
		this.maintenanceMargin = maintenanceMargin;
		this.maintenanceMarginStr = DOUBLE_FORMAT.format(maintenanceMargin);
	}

	public double getSellInitialMargin() {
		return sellInitialMargin;
	}

	public void setSellInitialMargin(double sellInitialMargin) {
		this.sellInitialMargin = sellInitialMargin;
		this.sellInitialMarginStr = DOUBLE_FORMAT.format(sellInitialMargin);
	}

	public double getSellMaintenanceMargin() {
		return sellMaintenanceMargin;
	}

	public void setSellMaintenanceMargin(double sellMaintenanceMargin) {
		this.sellMaintenanceMargin = sellMaintenanceMargin;
		this.sellMaintenanceMarginStr = DOUBLE_FORMAT.format(sellMaintenanceMargin);
	}

	public double getLockMargin() {
		return lockMargin;
	}

	public void setLockMargin(double lockMargin) {
		this.lockMargin = lockMargin;
		this.lockMarginStr = DOUBLE_FORMAT.format(lockMargin);
	}

	public String getTechPlatform() {
		return techPlatform;
	}

	public void setTechPlatform(String techPlatform) {
		this.techPlatform = techPlatform;
	}

	public String getContractSizeStr() {
		return contractSizeStr;
	}

	public String getOpenCloseFeeStr() {
		return openCloseFeeStr;
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

	public static LocalTechPlatformCommodity transferToLocalCommodity(TechPlatformCommodity techPlatformCommodity) {
		LocalTechPlatformCommodity localTechPlatformCommodity = new LocalTechPlatformCommodity();

		if (techPlatformCommodity != null) {

			localTechPlatformCommodity.setSledCommodityId(techPlatformCommodity.getSledCommodityId());
			localTechPlatformCommodity.setExchange(techPlatformCommodity.getExchange());
			localTechPlatformCommodity.setCommodityType(techPlatformCommodity.getCommodityType());
			localTechPlatformCommodity.setCommodityCode(techPlatformCommodity.getCommodityCode());
			localTechPlatformCommodity.setRelateCommodityCodes(techPlatformCommodity.getRelateCommodityCodes());
			localTechPlatformCommodity.setTradeCurrency(techPlatformCommodity.getTradeCurrency());
			localTechPlatformCommodity.setTimezone(techPlatformCommodity.getTimezone());
			localTechPlatformCommodity.setContractSize(techPlatformCommodity.getContractSize());
			localTechPlatformCommodity.setTickSize(techPlatformCommodity.getTickSize());
			localTechPlatformCommodity.setTickSizeStr(DOUBLE_FORMAT.format(techPlatformCommodity.getTickSize()));
			
			localTechPlatformCommodity.setDenominator(techPlatformCommodity.getDenominator());
			if (techPlatformCommodity.getCmbDirect() != null) {
				localTechPlatformCommodity.setCmbDirect(techPlatformCommodity.getCmbDirect().name());
			}
			if (techPlatformCommodity.getCommodityState() != null) {
				localTechPlatformCommodity.setCommodityState(techPlatformCommodity.getCommodityState().name());
			}
			localTechPlatformCommodity.setEngName(techPlatformCommodity.getEngName());
			localTechPlatformCommodity.setCnName(techPlatformCommodity.getCnName());
			localTechPlatformCommodity.setTcName(techPlatformCommodity.getTcName());

			if (techPlatformCommodity.getDeliveryMode() != null) {
				localTechPlatformCommodity.setDeliveryMode(techPlatformCommodity.getDeliveryMode().name());
			}
			localTechPlatformCommodity.setDeliveryDays(techPlatformCommodity.getDeliveryDays());
			localTechPlatformCommodity.setMaxSingleOrderVol(techPlatformCommodity.getMaxSingleOrderVol());
			localTechPlatformCommodity.setMaxHoldVol(techPlatformCommodity.getMaxHoldVol());

			if (techPlatformCommodity.getCommissionCalculateMode() != null) {
				localTechPlatformCommodity
						.setCommissionCalculateMode(techPlatformCommodity.getCommissionCalculateMode().name());
			}
			localTechPlatformCommodity.setOpenCloseFee(techPlatformCommodity.getOpenCloseFee());

			if (techPlatformCommodity.getMarginCalculateMode() != null) {
				localTechPlatformCommodity
						.setMarginCalculateMode(techPlatformCommodity.getMarginCalculateMode().name());
			}
			localTechPlatformCommodity.setInitialMargin(techPlatformCommodity.getInitialMargin());
			localTechPlatformCommodity.setMaintenanceMargin(techPlatformCommodity.getMaintenanceMargin());
			localTechPlatformCommodity.setSellInitialMargin(techPlatformCommodity.getSellInitialMargin());
			localTechPlatformCommodity.setSellMaintenanceMargin(techPlatformCommodity.getSellMaintenanceMargin());
			localTechPlatformCommodity.setLockMargin(techPlatformCommodity.getLockMargin());

			if (techPlatformCommodity.getTechPlatform() != null) {
				localTechPlatformCommodity.setTechPlatform(techPlatformCommodity.getTechPlatform().name());
			}
		}

		return localTechPlatformCommodity;
	}

	public static List<LocalTechPlatformCommodity> transferToLocalCommodityList(
			List<TechPlatformCommodity> techPlatformCommodityList) {
		List<LocalTechPlatformCommodity> localTechPlatformCommodityList = new ArrayList<LocalTechPlatformCommodity>();

		for (TechPlatformCommodity techPlatformCommodity : techPlatformCommodityList) {
			localTechPlatformCommodityList.add(transferToLocalCommodity(techPlatformCommodity));
		}

		return localTechPlatformCommodityList;
	}
}
