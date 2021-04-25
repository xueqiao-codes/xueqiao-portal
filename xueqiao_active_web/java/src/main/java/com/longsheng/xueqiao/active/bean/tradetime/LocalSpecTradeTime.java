package com.longsheng.xueqiao.active.bean.tradetime;

import com.longsheng.xueqiao.contract.thriftapi.SpecTradeTime;
import org.soldier.base.logger.AppLog;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

public class LocalSpecTradeTime {

	private static SimpleDateFormat dateSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private static String TIMEZONE_BEIJING = "Asia/Shanghai";

	private int specTradeTimeId;
	private String exchangeMic;
	private List<Integer> sledCommodityIds;
	private String nonTradeStartDate;
	private String nonTradeEndDate;
	private String nonTradeStartTime;
	private String nonTradeEndTime;
	private String bejingNonTradeStartTime;
	private String bejingNonTradeEndTime;
	private String nextTradeOpenType;
	private String sledCommodityType;
	private List<String> sledCommodityTypes;
	private List<String> sledCommodityNames;
	private String zoneId;

	public int getSpecTradeTimeId() {
		return specTradeTimeId;
	}

	public void setSpecTradeTimeId(int specTradeTimeId) {
		this.specTradeTimeId = specTradeTimeId;
	}

	public String getExchangeMic() {
		return exchangeMic;
	}

	public void setExchangeMic(String exchangeMic) {
		this.exchangeMic = exchangeMic;
	}

	public List<Integer> getSledCommodityIds() {
		return sledCommodityIds;
	}

	public void setSledCommodityIds(List<Integer> sledCommodityIds) {
		this.sledCommodityIds = sledCommodityIds;
	}

	public String getNonTradeStartDate() {
		return nonTradeStartDate;
	}

	public void setNonTradeStartDate(String nonTradeStartDate) {
		this.nonTradeStartDate = nonTradeStartDate;
	}

	public String getNonTradeEndDate() {
		return nonTradeEndDate;
	}

	public void setNonTradeEndDate(String nonTradeEndDate) {
		this.nonTradeEndDate = nonTradeEndDate;
	}

	public String getNonTradeStartTime() {
		return nonTradeStartTime;
	}

	public void setNonTradeStartTime(String nonTradeStartTime) {
		this.nonTradeStartTime = nonTradeStartTime;
	}

	public String getNonTradeEndTime() {
		return nonTradeEndTime;
	}

	public void setNonTradeEndTime(String nonTradeEndTime) {
		this.nonTradeEndTime = nonTradeEndTime;
	}

	public String getBejingNonTradeStartTime() {
		return bejingNonTradeStartTime;
	}

	public void setBejingNonTradeStartTime(String bejingNonTradeStartTime) {
		this.bejingNonTradeStartTime = bejingNonTradeStartTime;
	}

	public String getBejingNonTradeEndTime() {
		return bejingNonTradeEndTime;
	}

	public void setBejingNonTradeEndTime(String bejingNonTradeEndTime) {
		this.bejingNonTradeEndTime = bejingNonTradeEndTime;
	}

	public String getNextTradeOpenType() {
		return nextTradeOpenType;
	}

	public void setNextTradeOpenType(String nextTradeOpenType) {
		this.nextTradeOpenType = nextTradeOpenType;
	}

	public String getSledCommodityType() {
		return sledCommodityType;
	}

	public void setSledCommodityType(String sledCommodityType) {
		this.sledCommodityType = sledCommodityType;
	}

	public List<String> getSledCommodityTypes() {
		return sledCommodityTypes;
	}

	public void setSledCommodityTypes(List<String> sledCommodityTypes) {
		this.sledCommodityTypes = sledCommodityTypes;
	}

	public List<String> getSledCommodityNames() {
		return sledCommodityNames;
	}

	public void setSledCommodityNames(List<String> sledCommodityNames) {
		this.sledCommodityNames = sledCommodityNames;
	}

	public String getZoneId() {
		return zoneId;
	}

	public void setZoneId(String zoneId) {
		this.zoneId = zoneId;
	}

	public static List<LocalSpecTradeTime> transformSpecTradeTimeListtoLocal(List<SpecTradeTime> specTradeTimeList) {
		List<LocalSpecTradeTime> localSpecTradeTimeList = new ArrayList<LocalSpecTradeTime>();
		AppLog.i("LocalSpecTradeTime ---- transformSpecTradeTimeListtoLocal ---- specTradeTimeList size : "
				+ specTradeTimeList.size());
		if (specTradeTimeList != null && !specTradeTimeList.isEmpty()) {
			for (SpecTradeTime specTradeTime : specTradeTimeList) {
				LocalSpecTradeTime localSpecTradeTime = transformSpecTradeTimetoLocal(specTradeTime);
				localSpecTradeTimeList.add(localSpecTradeTime);
			}
		}
		AppLog.i("LocalSpecTradeTime ---- transformSpecTradeTimeListtoLocal ---- localSpecTradeTimeList size : "
				+ localSpecTradeTimeList.size());
		return localSpecTradeTimeList;
	}

	public static LocalSpecTradeTime transformSpecTradeTimetoLocal(SpecTradeTime specTradeTime) {
		LocalSpecTradeTime localSpecTradeTime = new LocalSpecTradeTime();
		AppLog.i("LocalSpecTradeTime ---- transformSpecTradeTimeListtoLocal ---- getZoneId : "
				+ specTradeTime.getZoneId());
		localSpecTradeTime.setSpecTradeTimeId(specTradeTime.getSpecTradeTimeId());
		localSpecTradeTime.setExchangeMic(specTradeTime.getExchangeMic());
		localSpecTradeTime.setSledCommodityIds(specTradeTime.getSledCommodityIds());

		Date date = new Date();
		date.setTime(specTradeTime.getNonTradeStartTimestamp() * 1000);
		localSpecTradeTime.setNonTradeStartTime(dateSimpleDateFormat.format(date));
		date.setTime(specTradeTime.getNonTradeEndTimestamp() * 1000);
		localSpecTradeTime.setNonTradeEndTime(dateSimpleDateFormat.format(date));
		
		dateSimpleDateFormat.setTimeZone(TimeZone.getTimeZone(TIMEZONE_BEIJING));
		date.setTime(specTradeTime.getNonTradeStartTimestamp() * 1000);
		localSpecTradeTime.setBejingNonTradeStartTime(dateSimpleDateFormat.format(date));
		date.setTime(specTradeTime.getNonTradeEndTimestamp() * 1000);
		localSpecTradeTime.setBejingNonTradeEndTime(dateSimpleDateFormat.format(date));

		localSpecTradeTime.setNextTradeOpenType(specTradeTime.getNextTradeOpenType().name());
		localSpecTradeTime.setSledCommodityTypes(specTradeTime.getSledCommodityTypes());
		localSpecTradeTime.setSledCommodityNames(specTradeTime.getSledCommodityNames());
		localSpecTradeTime.setZoneId(specTradeTime.getZoneId());

		return localSpecTradeTime;
	}
}
