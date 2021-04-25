package com.longsheng.xueqiao.admin.bean;

import java.util.ArrayList;
import java.util.List;

import com.longsheng.xueqiao.contract.thriftapi.DstTransferConfig;

public class LocalDstTransferConfig {

	private int dstTransferConfigId;
	private String exchangeMic;
	private String sledCommodityType;
	private List<Integer> commodityIds;
	private List<String> sledCommodityNames;
	private int standard2DstOffSetMinute;
	private String standard2DstOffSetMinuteStr;

	public int getDstTransferConfigId() {
		return dstTransferConfigId;
	}

	public void setDstTransferConfigId(int dstTransferConfigId) {
		this.dstTransferConfigId = dstTransferConfigId;
	}

	public String getExchangeMic() {
		return exchangeMic;
	}

	public void setExchangeMic(String exchangeMic) {
		this.exchangeMic = exchangeMic;
	}

	public String getSledCommodityType() {
		return sledCommodityType;
	}

	public void setSledCommodityType(String sledCommodityType) {
		this.sledCommodityType = sledCommodityType;
	}

	public List<Integer> getCommodityIds() {
		return commodityIds;
	}

	public void setCommodityIds(List<Integer> commodityIds) {
		this.commodityIds = commodityIds;
	}

	public List<String> getSledCommodityNames() {
		return sledCommodityNames;
	}

	public void setSledCommodityNames(List<String> sledCommodityNames) {
		this.sledCommodityNames = sledCommodityNames;
	}

	public int getStandard2DstOffSetMinute() {
		return standard2DstOffSetMinute;
	}

	public void setStandard2DstOffSetMinute(int standard2DstOffSetMinute) {
		this.standard2DstOffSetMinute = standard2DstOffSetMinute;
	}

	public String getStandard2DstOffSetMinuteStr() {
		return standard2DstOffSetMinuteStr;
	}

	public void setStandard2DstOffSetMinuteStr(String standard2DstOffSetMinuteStr) {
		this.standard2DstOffSetMinuteStr = standard2DstOffSetMinuteStr;
	}

	public static List<LocalDstTransferConfig> transferToLocalDstTransferConfigList(List<DstTransferConfig> dstTransferConfigList) {
		List<LocalDstTransferConfig> localDstTransferConfigList = new ArrayList<LocalDstTransferConfig>();
		
		if (dstTransferConfigList != null && !dstTransferConfigList.isEmpty()) {
			for (DstTransferConfig dstTransferConfig : dstTransferConfigList) {
				localDstTransferConfigList.add(transferToLocalDstTransferConfig(dstTransferConfig));
			}
		}
		
		return localDstTransferConfigList;
	}
	
	public static LocalDstTransferConfig transferToLocalDstTransferConfig(DstTransferConfig dstTransferConfig) {
		LocalDstTransferConfig localDstTransferConfig = new LocalDstTransferConfig();
		
		localDstTransferConfig.setDstTransferConfigId(dstTransferConfig.getDstTransferConfigId());
		if (dstTransferConfig.getExchangeMics() != null && !dstTransferConfig.getExchangeMics().isEmpty()) {
			localDstTransferConfig.setExchangeMic(dstTransferConfig.getExchangeMics().get(0));
		}
		if (dstTransferConfig.getSledCommodityTypes() != null && !dstTransferConfig.getSledCommodityTypes().isEmpty()) {
			localDstTransferConfig.setSledCommodityType(dstTransferConfig.getSledCommodityTypes().get(0));
		}
		localDstTransferConfig.setCommodityIds(dstTransferConfig.getCommodityIds());
		localDstTransferConfig.setSledCommodityNames(dstTransferConfig.getSledCommodityNames());
		localDstTransferConfig.setStandard2DstOffSetMinute(dstTransferConfig.getStandard2DstOffSetMinute());
		if (dstTransferConfig.isCustom()) {
			localDstTransferConfig.setStandard2DstOffSetMinuteStr("自定义");
		} else {
			if (dstTransferConfig.getStandard2DstOffSetMinute() <= 0) {
				localDstTransferConfig.setStandard2DstOffSetMinuteStr("所有时间：提前" + Math.abs(dstTransferConfig.getStandard2DstOffSetMinute()) + "分钟");
			} else {
				localDstTransferConfig.setStandard2DstOffSetMinuteStr("所有时间：延后" + Math.abs(dstTransferConfig.getStandard2DstOffSetMinute()) + "分钟");
			}
		}
		
		return localDstTransferConfig;
	}
}
