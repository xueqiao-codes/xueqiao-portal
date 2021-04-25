package com.longsheng.xueqiao.admin.bean.tradetime;

import java.util.List;

public class LocalTradeTime {

	private String exchangeMic;
	private int sledCommodityId;
	private String sledCommodityType;
	private String sledCommodityCode;
	private String sledCommodityCnName;
	private String timezone;
	private List<LocalDateTimeSpan> localDateTimeSpanList;
	//	private List<String> localTimeTOpenList;
//	private List<String> beijingTimeTOpenList;
//	private List<String> localTimeTPOOpenList;
//	private List<String> beijingTimeTPOOpenList;
	private int isSpecTime; /* 1:true, 0:false */
	private int weekTradeTimesSize;

	public String getExchangeMic() {
		return exchangeMic;
	}

	public void setExchangeMic(String exchangeMic) {
		this.exchangeMic = exchangeMic;
	}

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

	public String getSledCommodityCnName() {
		return sledCommodityCnName;
	}

	public void setSledCommodityCnName(String sledCommodityCnName) {
		this.sledCommodityCnName = sledCommodityCnName;
	}

	public String getTimezone() {
		return timezone;
	}

	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}

	public List<LocalDateTimeSpan> getLocalDateTimeSpanList() {
		return localDateTimeSpanList;
	}

	public void setLocalDateTimeSpanList(List<LocalDateTimeSpan> localDateTimeSpanList) {
		this.localDateTimeSpanList = localDateTimeSpanList;
	}

	//	public List<String> getLocalTimeTOpenList() {
//		return localTimeTOpenList;
//	}
//
//	public void setLocalTimeTOpenList(List<String> localTimeTOpenList) {
//		this.localTimeTOpenList = localTimeTOpenList;
//	}
//
//	public List<String> getBeijingTimeTOpenList() {
//		return beijingTimeTOpenList;
//	}
//
//	public void setBeijingTimeTOpenList(List<String> beijingTimeTOpenList) {
//		this.beijingTimeTOpenList = beijingTimeTOpenList;
//	}
//
//	public List<String> getLocalTimeTPOOpenList() {
//		return localTimeTPOOpenList;
//	}
//
//	public void setLocalTimeTPOOpenList(List<String> localTimeTPOOpenList) {
//		this.localTimeTPOOpenList = localTimeTPOOpenList;
//	}
//
//	public List<String> getBeijingTimeTPOOpenList() {
//		return beijingTimeTPOOpenList;
//	}
//
//	public void setBeijingTimeTPOOpenList(List<String> beijingTimeTPOOpenList) {
//		this.beijingTimeTPOOpenList = beijingTimeTPOOpenList;
//	}

	public int getIsSpecTime() {
		return isSpecTime;
	}

	public void setIsSpecTime(int isSpecTime) {
		this.isSpecTime = isSpecTime;
	}

	public int getWeekTradeTimesSize() {
		return weekTradeTimesSize;
	}

	public void setWeekTradeTimesSize(int weekTradeTimesSize) {
		this.weekTradeTimesSize = weekTradeTimesSize;
	}

}
