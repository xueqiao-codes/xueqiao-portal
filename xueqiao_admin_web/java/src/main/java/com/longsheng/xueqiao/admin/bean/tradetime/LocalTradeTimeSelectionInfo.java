package com.longsheng.xueqiao.admin.bean.tradetime;

import com.longsheng.xueqiao.admin.bean.LocalExchange;
import com.longsheng.xueqiao.admin.bean.LocalSimpleCommodity;

import java.util.List;

public class LocalTradeTimeSelectionInfo {

	// exchange selected
	private String exchangeMic;
	// all exchanges
	// private List<String> exchangeMicList;
	private List<LocalExchange> exchangeList;

	// commodity type selected
	private String sledCommodityType;

	// timezone selected
	private String zoneId;
	// timezone list
	private List<String> zoneIdList;

	// commodity list
	private List<LocalSimpleCommodity> LocalSimpleCommodityList;

	public String getExchangeMic() {
		return exchangeMic;
	}

	public void setExchangeMic(String exchangeMic) {
		this.exchangeMic = exchangeMic;
	}

	public List<LocalExchange> getExchangeList() {
		return exchangeList;
	}

	public void setExchangeList(List<LocalExchange> exchangeList) {
		this.exchangeList = exchangeList;
	}

	public String getSledCommodityType() {
		return sledCommodityType;
	}

	public void setSledCommodityType(String sledCommodityType) {
		this.sledCommodityType = sledCommodityType;
	}

	public String getZoneId() {
		return zoneId;
	}

	public void setZoneId(String zoneId) {
		this.zoneId = zoneId;
	}

	public List<String> getZoneIdList() {
		return zoneIdList;
	}

	public void setZoneIdList(List<String> zoneIdList) {
		this.zoneIdList = zoneIdList;
	}

	public List<LocalSimpleCommodity> getLocalSimpleCommodityList() {
		return LocalSimpleCommodityList;
	}

	public void setLocalSimpleCommodityList(List<LocalSimpleCommodity> localSimpleCommodityList) {
		LocalSimpleCommodityList = localSimpleCommodityList;
	}

	public String toString() {
		StringBuilder strBuffer = new StringBuilder();

		strBuffer.append("exchangeMic : ").append(exchangeMic);
		strBuffer.append(", exchangeMicList : ");
		if (exchangeList != null) {
			for (LocalExchange ex : exchangeList) {
				strBuffer.append(ex.getExchangeMic()).append(",");
			}
		}
		strBuffer.append(", sledCommodityType : ").append(sledCommodityType);

		if (zoneIdList != null) {
			strBuffer.append(", zoneId : ").append(zoneId);
			strBuffer.append(", zoneIdList : ");
			for (String zone : zoneIdList) {
				strBuffer.append(zone).append(",");
			}
		}

		strBuffer.append(", LocalSimpleCommodityList : ");
		if (LocalSimpleCommodityList != null) {
			for (LocalSimpleCommodity localSimpleCommodity : LocalSimpleCommodityList) {
				strBuffer.append("[").append(localSimpleCommodity.getSledCommodityId()).append(",")
						.append(localSimpleCommodity.getCnName()).append("],");
			}
		}
		return strBuffer.toString();
	}

}
