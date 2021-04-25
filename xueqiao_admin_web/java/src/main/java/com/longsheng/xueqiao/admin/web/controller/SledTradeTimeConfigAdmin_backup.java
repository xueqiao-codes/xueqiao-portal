package com.longsheng.xueqiao.admin.web.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;

import org.apache.commons.io.IOUtils;
import org.apache.thrift.TException;
import org.soldier.base.StringFactory;
import org.soldier.base.logger.AppLog;
import org.soldier.platform.svr_platform.comm.ErrorInfo;
import org.soldier.platform.web_framework.model.ErrorResult;
import org.soldier.platform.web_framework.util.GsonFactory;

import com.longsheng.xueqiao.admin.bean.tradetime.LocalTradeTimeConfig;
import com.longsheng.xueqiao.contract.thriftapi.DayTradeTime;
import com.longsheng.xueqiao.contract.thriftapi.Days;
import com.longsheng.xueqiao.contract.thriftapi.ReqSledTradeTimeConfigOption;
import com.longsheng.xueqiao.contract.thriftapi.SledTradeTimeConfig;
import com.longsheng.xueqiao.contract.thriftapi.SledTradeTimeConfigPage;
import com.longsheng.xueqiao.contract.thriftapi.client.ContractServiceStub;

public class SledTradeTimeConfigAdmin_backup extends AbstractDBLockController {
	
	ContractServiceStub mContractServiceStub = new ContractServiceStub();
	
	private static SimpleDateFormat dateSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
	private static SimpleDateFormat dateSimpleTimeFormat = new SimpleDateFormat("HH:mm:ss");
	
	private static final String BEIJING_TIME_ZONE = "UTC+8";
	
	private static final int ONE_DATE_TIMESTAMP = 1000 * 60 * 60 * 24 - 1;
	private static final int PAGE_SIZE = 10;
	private static final int PAGE_SIZE_MAX = Integer.MAX_VALUE;
	
	public void show() throws Exception {
		
		getModuleLockStatus(ModuleType.MM_CONTRACT);

		String exchangeMic = parameter("exchangeMic");
		int sledCommodityId = parameter("sledCommodityId", 0);
		String sledCommodityCnName = parameter("sledCommodityCnName");
		
		queryTradeTimeConfig(sledCommodityId);
		
		put("sledCommodityId", sledCommodityId);
		put("exchangeMic", exchangeMic);
		put("sledCommodityCnName", sledCommodityCnName);
		
		
		render("sled_trade_time_config_admin.html");
	}
	
	private void queryTradeTimeConfig(int commodityId) throws ErrorInfo, TException {
		if (mContractServiceStub == null) {
			mContractServiceStub = new ContractServiceStub();
		}
		
		ReqSledTradeTimeConfigOption reqSledTradeTimeConfigOption = new ReqSledTradeTimeConfigOption();
		Set<Integer> sledCommodityIds = new HashSet<Integer>();
		sledCommodityIds.add(commodityId);
		reqSledTradeTimeConfigOption.setSledCommodityIds(sledCommodityIds);
		SledTradeTimeConfigPage sledTradeTimeConfigPage = mContractServiceStub.reqSledTradeTimeConfig( reqSledTradeTimeConfigOption, 0, PAGE_SIZE_MAX);
		
		List<LocalTradeTimeConfig> localTradeTimeConfigList = getLocalTradeTimeConfigList();
		
		AppLog.i("SledTradeTimeConfigAdmin ---- queryTradeTimeConfig ---- localTradeTimeConfigList size : " + sledTradeTimeConfigPage.getPageSize());
		
//		int isDstExists = 0;
//		String dst2Standard = null;
//		String standard2Dst = null;
		
		
		if (sledTradeTimeConfigPage.getPageSize() > 0) {
			SledTradeTimeConfig sledTradeTimeConfig = sledTradeTimeConfigPage.getPage().get(0);
			
			Map<Days, DayTradeTime> weekTradeTimes = sledTradeTimeConfig.getStandardWeekTradeTimes();
			Map<Days, DayTradeTime> dstWeekTradeTimes = sledTradeTimeConfig.getDstWeekTradeTimes();
			
			setLocalTradeTimeConfig(weekTradeTimes.get(Days.MONDAY), dstWeekTradeTimes.get(Days.MONDAY), localTradeTimeConfigList.get(0), sledTradeTimeConfig.getZoneId());
			setLocalTradeTimeConfig(weekTradeTimes.get(Days.TUESDAY), dstWeekTradeTimes.get(Days.TUESDAY), localTradeTimeConfigList.get(1), sledTradeTimeConfig.getZoneId());
			setLocalTradeTimeConfig(weekTradeTimes.get(Days.WEDNESDAY), dstWeekTradeTimes.get(Days.WEDNESDAY), localTradeTimeConfigList.get(2), sledTradeTimeConfig.getZoneId());
			setLocalTradeTimeConfig(weekTradeTimes.get(Days.THURSDAY), dstWeekTradeTimes.get(Days.THURSDAY), localTradeTimeConfigList.get(3), sledTradeTimeConfig.getZoneId());
			setLocalTradeTimeConfig(weekTradeTimes.get(Days.FRIDAY), dstWeekTradeTimes.get(Days.FRIDAY), localTradeTimeConfigList.get(4), sledTradeTimeConfig.getZoneId());
			setLocalTradeTimeConfig(weekTradeTimes.get(Days.SATURDAY), dstWeekTradeTimes.get(Days.SATURDAY), localTradeTimeConfigList.get(5), sledTradeTimeConfig.getZoneId());
			setLocalTradeTimeConfig(weekTradeTimes.get(Days.SUNDAY), dstWeekTradeTimes.get(Days.SUNDAY), localTradeTimeConfigList.get(6), sledTradeTimeConfig.getZoneId());
		
//			if (sledTradeTimeConfig.isDstExists()) {
//				isDstExists = 1;
//				// dst to standard
//				Calendar calendar = Calendar.getInstance();
//				calendar.set(Calendar.MONTH, sledTradeTimeConfig.getDst2Standard().getMonthIndex());
//				calendar.set(Calendar.WEEK_OF_MONTH, sledTradeTimeConfig.getDst2Standard().getWeekIndex());
//				calendar.set(Calendar.DAY_OF_WEEK, sledTradeTimeConfig.getDst2Standard().getDay().getValue() + 1);
//				dst2Standard = dateSimpleDateFormat.format(new Date(calendar.getTimeInMillis()));
//				
//				// standard to dst
//				calendar.set(Calendar.MONTH, sledTradeTimeConfig.getStandard2Dst().getMonthIndex());
//				calendar.set(Calendar.WEEK_OF_MONTH, sledTradeTimeConfig.getStandard2Dst().getWeekIndex());
//				calendar.set(Calendar.DAY_OF_WEEK, sledTradeTimeConfig.getStandard2Dst().getDay().getValue() + 1);
//				
//				standard2Dst = dateSimpleDateFormat.format(new Date(calendar.getTimeInMillis()));
//				
////				Date date = new Date();
////				date.setTime(sledTradeTimeConfig.getTimestampDst2Standard());
////				dst2Standard = dateSimpleDateFormat.format(date);
////				
////				date.setTime(sledTradeTimeConfig.getTimestampStandard2Dst());
////				standard2Dst = dateSimpleDateFormat.format(date);
//			}
		}
		
//		put("isDstExists", isDstExists);
//		put("dst2Standard", dst2Standard);
//		put("standard2Dst", standard2Dst);
		
		put("sledTradeTimeConfigList", localTradeTimeConfigList);
	}
	
	private void getDstAndStandardSwitchTime(SledTradeTimeConfig sledTradeTimeConfig) {
		
	}
	
	private void setLocalTradeTimeConfig(DayTradeTime dayTradeTime, DayTradeTime dstDayTradeTime, LocalTradeTimeConfig localTradeTimeConfig, String localTimeZone) {
		if (dayTradeTime != null) {
			
			Date currentDate = new Date();
			
			// Local trade time
			List<String> localTradeTimes = new ArrayList<String>();
			List<String> localPlusOneTradeTimes = new ArrayList<String>();
			
			// Dst trade time
			List<String> dstTradeTimes = new ArrayList<String>();
			List<String> dstPlusOneTradeTimes = new ArrayList<String>();
			
			// Beijing trade time
			List<String> beijingTradeTimes = new ArrayList<String>();
			List<String> beijingPlusOneTradeTimes = new ArrayList<String>();
			
			// Local trade time & beijing trade time
			for (String tradeTimeSpan : dayTradeTime.getTTradeTimes()) {
				if (tradeTimeSpan != null && !tradeTimeSpan.isEmpty()) {
					String[] tradeTimes = tradeTimeSpan.split("-");
					if (tradeTimes != null && tradeTimes.length == 2) {
						
						localTradeTimes.add(tradeTimeSpan + isNextDay(tradeTimes[0], tradeTimes[1]));
						
						try {
							dateSimpleTimeFormat.setTimeZone(TimeZone.getTimeZone(localTimeZone));
							currentDate = dateSimpleTimeFormat.parse(tradeTimes[0]);
							dateSimpleTimeFormat.setTimeZone(TimeZone.getTimeZone(BEIJING_TIME_ZONE));
							String beijingStartTradeTimeSpan = dateSimpleTimeFormat.format(currentDate);
							
							dateSimpleTimeFormat.setTimeZone(TimeZone.getTimeZone(localTimeZone));
							currentDate = dateSimpleTimeFormat.parse(tradeTimes[1]);
							dateSimpleTimeFormat.setTimeZone(TimeZone.getTimeZone(BEIJING_TIME_ZONE));
							String beijingEndTradeTimeSpan = dateSimpleTimeFormat.format(currentDate);
							beijingTradeTimes.add(beijingStartTradeTimeSpan + " - " + beijingEndTradeTimeSpan + isNextDay(beijingStartTradeTimeSpan, beijingEndTradeTimeSpan));
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
			
			// Local t+1 trade time & beijing t+1 trade time
			for (String tradeTimeSpan : dayTradeTime.getTPlusOneTradeTimes()) {
				if (tradeTimeSpan != null && !tradeTimeSpan.isEmpty()) {
					String[] tradeTimes = tradeTimeSpan.split("-");
					if (tradeTimes != null && tradeTimes.length == 2) {
						
						localPlusOneTradeTimes.add(tradeTimeSpan + isNextDay(tradeTimes[0], tradeTimes[1]));
						
						try {
							dateSimpleTimeFormat.setTimeZone(TimeZone.getTimeZone(localTimeZone));
							currentDate = dateSimpleTimeFormat.parse(tradeTimes[0]);
							dateSimpleTimeFormat.setTimeZone(TimeZone.getTimeZone(BEIJING_TIME_ZONE));
							String beijingStartTPlusOneTradeTimeSpan = dateSimpleTimeFormat.format(currentDate);
							
							dateSimpleTimeFormat.setTimeZone(TimeZone.getTimeZone(localTimeZone));
							currentDate = dateSimpleTimeFormat.parse(tradeTimes[1]);
							dateSimpleTimeFormat.setTimeZone(TimeZone.getTimeZone(BEIJING_TIME_ZONE));
							String beijingEndTPlusOneTradeTimeSpan = dateSimpleTimeFormat.format(currentDate);
							beijingPlusOneTradeTimes.add(beijingStartTPlusOneTradeTimeSpan + " - " + beijingEndTPlusOneTradeTimeSpan + isNextDay(beijingStartTPlusOneTradeTimeSpan, beijingEndTPlusOneTradeTimeSpan));
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
			
			// Dst
			if (dstDayTradeTime != null) {
				// Dst trade time
				if (dstDayTradeTime.getTTradeTimes() != null) {
					for (String tradeTimeSpan : dstDayTradeTime.getTTradeTimes()) {
						if (tradeTimeSpan != null && !tradeTimeSpan.isEmpty()) {
							String[] tradeTimes = tradeTimeSpan.split("-");
							if (tradeTimes != null && tradeTimes.length == 2) {
								dstTradeTimes.add(tradeTimeSpan + isNextDay(tradeTimes[0], tradeTimes[1]));
							}
						}
					}
				}
				
				// Dst t+1 trade time
				if (dstDayTradeTime.getTPlusOneTradeTimes() != null) {
					for (String tradeTimeSpan : dstDayTradeTime.getTPlusOneTradeTimes()) {
						if (tradeTimeSpan != null && !tradeTimeSpan.isEmpty()) {
							String[] tradeTimes = tradeTimeSpan.split("-");
							if (tradeTimes != null && tradeTimes.length == 2) {
								dstPlusOneTradeTimes.add(tradeTimeSpan + isNextDay(tradeTimes[0], tradeTimes[1]));
							}
						}
					}
				}
			}
			
			localTradeTimeConfig.setLocalTradeTimes(localTradeTimes);
			localTradeTimeConfig.setLocalPlusOneTradeTimes(localPlusOneTradeTimes);
			
			localTradeTimeConfig.setDstTradeTimes(dstTradeTimes);
			localTradeTimeConfig.setDstPlusOneTradeTimes(dstPlusOneTradeTimes);
			
			localTradeTimeConfig.setBejingTradeTimes(beijingTradeTimes);
			localTradeTimeConfig.setBejingPlusOneTradeTimes(beijingPlusOneTradeTimes);
			// Beijing trade time end
		}
	}
	
	private LocalTradeTimeConfig getLocalTradeTimeConfigLocalTime(DayTradeTime dayTradeTime, DayTradeTime dstDayTradeTime) {

		LocalTradeTimeConfig localTradeTimeConfig = new LocalTradeTimeConfig();
		
		if (dayTradeTime != null) {
			if (dayTradeTime.getTTradeTimes() != null && !dayTradeTime.getTTradeTimes().isEmpty()) {
				for (int index = 0; index < dayTradeTime.getTTradeTimes().size(); index++) {
					String tradeTimeSpan = dayTradeTime.getTTradeTimes().get(index);
					if (tradeTimeSpan != null && !tradeTimeSpan.isEmpty()) {
						String[] tradeTimes = tradeTimeSpan.split("-");
						if (tradeTimes != null && tradeTimes.length == 2) {
							
							switch (index) {
							case 0:
								localTradeTimeConfig.setLocalTTradeTimeStart1(tradeTimes[0].trim().substring(0, 5));
								localTradeTimeConfig.setLocalTTradeTimeEnd1(tradeTimes[1].trim().substring(0, 5));
								break;
							case 1:
								localTradeTimeConfig.setLocalTTradeTimeStart2(tradeTimes[0].trim().substring(0, 5));
								localTradeTimeConfig.setLocalTTradeTimeEnd2(tradeTimes[1].trim().substring(0, 5));
								break;
							case 2:
								localTradeTimeConfig.setLocalTTradeTimeStart3(tradeTimes[0].trim().substring(0, 5));
								localTradeTimeConfig.setLocalTTradeTimeEnd3(tradeTimes[1].trim().substring(0, 5));
								break;
							}
						}
					}
				}
			}
			
			if (dayTradeTime.getTPlusOneTradeTimes() != null && !dayTradeTime.getTPlusOneTradeTimes().isEmpty()) {
				for (int index = 0; index < dayTradeTime.getTPlusOneTradeTimes().size(); index++) {
					String tradeTimeSpan = dayTradeTime.getTPlusOneTradeTimes().get(index);
					if (tradeTimeSpan != null && !tradeTimeSpan.isEmpty()) {
						String[] tradeTimes = tradeTimeSpan.split("-");
						if (tradeTimes != null && tradeTimes.length == 2) {
							
							switch (index) {
							case 0:
								localTradeTimeConfig.setLocalTPlusOneTradeTimeStart1(tradeTimes[0].trim().substring(0, 5));
								localTradeTimeConfig.setLocalTPlusOneTradeTimeEnd1(tradeTimes[1].trim().substring(0, 5));
								break;
							case 1:
								localTradeTimeConfig.setLocalTPlusOneTradeTimeStart2(tradeTimes[0].trim().substring(0, 5));
								localTradeTimeConfig.setLocalTPlusOneTradeTimeEnd2(tradeTimes[1].trim().substring(0, 5));
								break;
							}
						}
					}
				}
			}
		}
		
		// DST
		if (dstDayTradeTime != null) {
			if (dstDayTradeTime.getTTradeTimes() != null && !dstDayTradeTime.getTTradeTimes().isEmpty()) {
				for (int index = 0; index < dstDayTradeTime.getTTradeTimes().size(); index++) {
					String tradeTimeSpan = dstDayTradeTime.getTTradeTimes().get(index);
					if (tradeTimeSpan != null && !tradeTimeSpan.isEmpty()) {
						String[] tradeTimes = tradeTimeSpan.split("-");
						if (tradeTimes != null && tradeTimes.length == 2) {
							
							switch (index) {
							case 0:
								localTradeTimeConfig.setLocalDstTTradeTimeStart1(tradeTimes[0].trim().substring(0, 5));
								localTradeTimeConfig.setLocalDstTTradeTimeEnd1(tradeTimes[1].trim().substring(0, 5));
								break;
							case 1:
								localTradeTimeConfig.setLocalDstTTradeTimeStart2(tradeTimes[0].trim().substring(0, 5));
								localTradeTimeConfig.setLocalDstTTradeTimeEnd2(tradeTimes[1].trim().substring(0, 5));
								break;
							case 2:
								localTradeTimeConfig.setLocalDstTTradeTimeStart3(tradeTimes[0].trim().substring(0, 5));
								localTradeTimeConfig.setLocalDstTTradeTimeEnd3(tradeTimes[1].trim().substring(0, 5));
								break;
							}
						}
					}
				}
			}
			
			if (dstDayTradeTime.getTPlusOneTradeTimes() != null && !dstDayTradeTime.getTPlusOneTradeTimes().isEmpty()) {
				for (int index = 0; index < dstDayTradeTime.getTPlusOneTradeTimes().size(); index++) {
					String tradeTimeSpan = dstDayTradeTime.getTPlusOneTradeTimes().get(index);
					if (tradeTimeSpan != null && !tradeTimeSpan.isEmpty()) {
						String[] tradeTimes = tradeTimeSpan.split("-");
						if (tradeTimes != null && tradeTimes.length == 2) {
							
							switch (index) {
							case 0:
								localTradeTimeConfig.setLocalDstTPlusOneTradeTimeStart1(tradeTimes[0].trim().substring(0, 5));
								localTradeTimeConfig.setLocalDstTPlusOneTradeTimeEnd1(tradeTimes[1].trim().substring(0, 5));
								break;
							case 1:
								localTradeTimeConfig.setLocalDstTPlusOneTradeTimeStart2(tradeTimes[0].trim().substring(0, 5));
								localTradeTimeConfig.setLocalDstTPlusOneTradeTimeEnd2(tradeTimes[1].trim().substring(0, 5));
								break;
							}
						}
					}
				}
			}
		}
		return localTradeTimeConfig;
	}
	
	private String isNextDay(String beginTime, String endTime) {
		
		String beginHourStr =  beginTime.trim().substring(0, 2);
		String endHourStr = endTime.trim().substring(0, 2);
		
		int beginHour = 0;
		int endHour = 0;
		
		try {
			beginHour = Integer.parseInt(beginHourStr);
			endHour = Integer.parseInt(endHourStr);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (endHour < beginHour) {
			return "  次交易日";
		}
		
		return "";
	}
	
	private List<LocalTradeTimeConfig> getLocalTradeTimeConfigList() {
		
		List<LocalTradeTimeConfig> localTradeTimeConfigList = new ArrayList<LocalTradeTimeConfig>();
		
		LocalTradeTimeConfig localTradeTimeConfig = new LocalTradeTimeConfig();
		localTradeTimeConfig.setWeekDayCN("星期一");
		localTradeTimeConfig.setWeekDayEN("MONDAY");
		localTradeTimeConfigList.add(localTradeTimeConfig);
		
		localTradeTimeConfig = new LocalTradeTimeConfig();
		localTradeTimeConfig.setWeekDayCN("星期二");
		localTradeTimeConfig.setWeekDayEN("TUESDAY");
		localTradeTimeConfigList.add(localTradeTimeConfig);
		
		localTradeTimeConfig = new LocalTradeTimeConfig();
		localTradeTimeConfig.setWeekDayCN("星期三");
		localTradeTimeConfig.setWeekDayEN("WEDNESDAY");
		localTradeTimeConfigList.add(localTradeTimeConfig);
		
		localTradeTimeConfig = new LocalTradeTimeConfig();
		localTradeTimeConfig.setWeekDayCN("星期四");
		localTradeTimeConfig.setWeekDayEN("THURSDAY");
		localTradeTimeConfigList.add(localTradeTimeConfig);
		
		localTradeTimeConfig = new LocalTradeTimeConfig();
		localTradeTimeConfig.setWeekDayCN("星期五");
		localTradeTimeConfig.setWeekDayEN("FRIDAY");
		localTradeTimeConfigList.add(localTradeTimeConfig);
		
		localTradeTimeConfig = new LocalTradeTimeConfig();
		localTradeTimeConfig.setWeekDayCN("星期六");
		localTradeTimeConfig.setWeekDayEN("SATURDAY");
		localTradeTimeConfigList.add(localTradeTimeConfig);
		
		localTradeTimeConfig = new LocalTradeTimeConfig();
		localTradeTimeConfig.setWeekDayCN("星期天");
		localTradeTimeConfig.setWeekDayEN("SUNDAY");
		localTradeTimeConfigList.add(localTradeTimeConfig);
		
		return localTradeTimeConfigList;
	}
	
	public void getTradeTimeInfo() throws IOException {
		ErrorResult result = new ErrorResult();
		int sledCommodityId = parameter("sledCommodityId", -1);
		String weekDay = parameter("weekDay", "");
		
		AppLog.i("SledTradeTimeConfigAdmin ---- getTradeTimeInfo ---- sledCommodityId : " + sledCommodityId + ", weekDay : " + weekDay);
		
//		ReqSledTradeTimeConfigOption reqSledTradeTimeConfigOption = new ReqSledTradeTimeConfigOption();
//		Set<Integer> sledCommodityIds = new HashSet<Integer>();
//		sledCommodityIds.add(sledCommodityId);
//		reqSledTradeTimeConfigOption.setSledCommodityIds(sledCommodityIds);
//		
//		SledTradeTimeConfigPage sledTradeTimeConfigPage = null;
		
		LocalTradeTimeConfig localTradeTimeConfig = new LocalTradeTimeConfig();
		
		SledTradeTimeConfig sledTradeTimeConfig = null;
		
		if (mContractServiceStub == null) {
			mContractServiceStub = new ContractServiceStub();
		}
		
		try {
//			sledTradeTimeConfigPage = mContractServiceStub.reqSledTradeTimeConfig( reqSledTradeTimeConfigOption, 0, PAGE_SIZE_MAX);
			sledTradeTimeConfig = getSledTradeTimeWeekdayConfigById(sledCommodityId);
		} catch(ErrorInfo errorInfo) {
			errorInfo.printStackTrace();
			result.setErrorCode(errorInfo.getErrorCode());
			result.setErrorMsg(errorInfo.getErrorMsg() + " : " + errorInfo.getErrorMsg());
			echoJson(result);
			return;
		} catch (Throwable e) {
			e.printStackTrace();
			result.setErrorCode(5);
			result.setErrorMsg("服务器繁忙");
			echoJson(result);
			return;
		}
		
		if (sledTradeTimeConfig != null) {
//			AppLog.i("SledTradeTimeConfigAdmin ---- getTradeTimeInfo ---- sledTradeTimeConfigPage.getPageSize() : " + sledTradeTimeConfigPage.getPageSize());
//			if (sledTradeTimeConfigPage.getPageSize() > 0) {
//				SledTradeTimeConfig sledTradeTimeConfig = sledTradeTimeConfigPage.getPage().get(0);
				
				Map<Days, DayTradeTime> weekTradeTimes = sledTradeTimeConfig.getStandardWeekTradeTimes();
				DayTradeTime dayTradeTime = weekTradeTimes.get(Days.valueOf(weekDay));
				
				Map<Days, DayTradeTime> dstWeekTradeTimes = sledTradeTimeConfig.getDstWeekTradeTimes();
				DayTradeTime dstDayTradeTime = dstWeekTradeTimes.get(Days.valueOf(weekDay));
				
				AppLog.i("SledTradeTimeConfigAdmin ---- getTradeTimeInfo ---- (dayTradeTime == null) : " + (dayTradeTime == null));
				localTradeTimeConfig = getLocalTradeTimeConfigLocalTime(dayTradeTime, dstDayTradeTime);
//			}
		} else {
			result.setErrorCode(6);
			result.setErrorMsg("获取时间失败");
			echoJson(result);
			return;
		}
		
		AppLog.i("SledTradeTimeConfigAdmin ---- getTradeTimeInfo ---- localTradeTimeConfig : " + localTradeTimeConfig.getLocalTTradeTimeStart1() + ", " + localTradeTimeConfig.getLocalTTradeTimeEnd1());
		
		echoJson(localTradeTimeConfig);
	}
	
	private SledTradeTimeConfig getSledTradeTimeWeekdayConfigById(int sledCommodityId) throws ErrorInfo, TException {
		ReqSledTradeTimeConfigOption reqSledTradeTimeConfigOption = new ReqSledTradeTimeConfigOption();
		Set<Integer> sledCommodityIds = new HashSet<Integer>();
		sledCommodityIds.add(sledCommodityId);
		reqSledTradeTimeConfigOption.setSledCommodityIds(sledCommodityIds);
		
		SledTradeTimeConfigPage sledTradeTimeConfigPage = null;
		
		if (mContractServiceStub == null) {
			mContractServiceStub = new ContractServiceStub();
		}
		
	
		sledTradeTimeConfigPage = mContractServiceStub.reqSledTradeTimeConfig( reqSledTradeTimeConfigOption, 0, PAGE_SIZE_MAX);
		if (sledTradeTimeConfigPage != null && sledTradeTimeConfigPage.getPageSize() > 0) {
			return sledTradeTimeConfigPage.getPage().get(0);
		} else {
			return null;
		}
	}
	
	public void updateTradeTimeConfig() throws IOException {
		ErrorResult result = new ErrorResult();
		
		if (mContractServiceStub == null) {
			mContractServiceStub = new ContractServiceStub();
		}
		
		String content = StringFactory.newUtf8String(IOUtils.toByteArray(getServletRequest().getInputStream()));
		AppLog.i("SledTradeTimeConfigAdmin ---- updateTradeTimeConfig ---- content : " + content);
		
		LocalTradeTimeConfig localTradeTimeConfig = GsonFactory.getGson().fromJson(content, LocalTradeTimeConfig.class);
//		AppLog.i("SledTradeTimeConfigAdmin ---- updateTradeTimeConfig ---- localTradeTimeConfig : " + localTradeTimeConfig.getLocalTPlusOneTradeTimeEnd1());
		
		// Check validation
		if (localTradeTimeConfig.getLocalTTradeTimeStart3() != null && !localTradeTimeConfig.getLocalTTradeTimeStart3().isEmpty()) {
			if (localTradeTimeConfig.getLocalTTradeTimeEnd2() != null && !localTradeTimeConfig.getLocalTTradeTimeEnd2().isEmpty()) {
				if (isTimeSpanNormal(localTradeTimeConfig.getLocalTTradeTimeStart2(), localTradeTimeConfig.getLocalTTradeTimeEnd2())) {
					if (isAcrossTimeSpanNormal(localTradeTimeConfig.getLocalTTradeTimeEnd2(), localTradeTimeConfig.getLocalTTradeTimeStart3())) {
						if (localTradeTimeConfig.getLocalTTradeTimeEnd1() != null && !localTradeTimeConfig.getLocalTTradeTimeEnd1().isEmpty()) {
							if (isTimeSpanNormal(localTradeTimeConfig.getLocalTTradeTimeStart1(), localTradeTimeConfig.getLocalTTradeTimeEnd1())) {
								if (isAcrossTimeSpanNormal(localTradeTimeConfig.getLocalTTradeTimeEnd1(), localTradeTimeConfig.getLocalTTradeTimeStart2())) {
									// TODO: three trade time
								} else {
									result.setErrorCode(6);
									result.setErrorMsg("T时间段1与T时间段2不能有交集");
									echoJson(result);
									return;
								}
							} else {
								result.setErrorCode(6);
								result.setErrorMsg("T时间段1不能跨天");
								echoJson(result);
								return;
							}
						} else {
							result.setErrorCode(6);
							result.setErrorMsg("不能跨时间段填写，请填写T时间段1");
							echoJson(result);
							return;
						}
					} else {
						result.setErrorCode(6);
						result.setErrorMsg("T时间段2与T时间段3不能有交集");
						echoJson(result);
						return;
					}
				} else {
					result.setErrorCode(6);
					result.setErrorMsg("T时间段2不能跨天");
					echoJson(result);
					return;
				}
			} else {
				result.setErrorCode(6);
				result.setErrorMsg("不能跨时间段填写，请填写T时间段2");
				echoJson(result);
				return;
			}
		} else {
			if (localTradeTimeConfig.getLocalTTradeTimeEnd2() != null && !localTradeTimeConfig.getLocalTTradeTimeEnd2().isEmpty()) {
				if (localTradeTimeConfig.getLocalTTradeTimeEnd1() != null && !localTradeTimeConfig.getLocalTTradeTimeEnd1().isEmpty()) {
					if (isTimeSpanNormal(localTradeTimeConfig.getLocalTTradeTimeStart1(), localTradeTimeConfig.getLocalTTradeTimeEnd1())) {
						if (isAcrossTimeSpanNormal(localTradeTimeConfig.getLocalTTradeTimeEnd1(), localTradeTimeConfig.getLocalTTradeTimeStart2())) {
							// TODO: two trade time
						} else {
							result.setErrorCode(6);
							result.setErrorMsg("T时间段1与T时间段2不能有交集");
							echoJson(result);
							return;
						}
					} else {
						result.setErrorCode(6);
						result.setErrorMsg("T时间段1不能跨天");
						echoJson(result);
						return;
					}
				} else {
					result.setErrorCode(6);
					result.setErrorMsg("不能跨时间段填写，请填写T时间段1");
					echoJson(result);
					return;
				}
			} else {
				if (localTradeTimeConfig.getLocalTTradeTimeEnd1() != null && !localTradeTimeConfig.getLocalTTradeTimeEnd1().isEmpty()) {
					//TODO: ONE
				} else {
					//TODO: NONE
				}
			}
		}
		
		if (localTradeTimeConfig.getLocalTPlusOneTradeTimeStart2() != null && !localTradeTimeConfig.getLocalTPlusOneTradeTimeStart2().isEmpty()) {
			if (localTradeTimeConfig.getLocalTPlusOneTradeTimeEnd1() != null && !localTradeTimeConfig.getLocalTPlusOneTradeTimeEnd1().isEmpty()) {
				if (isTimeSpanNormal(localTradeTimeConfig.getLocalTPlusOneTradeTimeStart1(), localTradeTimeConfig.getLocalTPlusOneTradeTimeEnd1())) {
					if (isAcrossTimeSpanNormal(localTradeTimeConfig.getLocalTPlusOneTradeTimeEnd1(), localTradeTimeConfig.getLocalTPlusOneTradeTimeStart2())) {
						// TODO: two trade time
					} else {
						result.setErrorCode(6);
						result.setErrorMsg("T+1时间段1与T+1时间段2不能有交集");
						echoJson(result);
						return;
					}
				} else {
					result.setErrorCode(6);
					result.setErrorMsg("T+1时间段1不能跨天");
					echoJson(result);
					return;
				}
			} else {
				result.setErrorCode(6);
				result.setErrorMsg("不能跨时间段填写，请填写T时间段1");
				echoJson(result);
				return;
			}
		} else {
			
		}
		
		// --------------------------------- DST ---------------------------------------
		if (localTradeTimeConfig.getStandardOrDst() == 1) {
		
			if (localTradeTimeConfig.getLocalDstTTradeTimeStart3() != null && !localTradeTimeConfig.getLocalDstTTradeTimeStart3().isEmpty()) {
				if (localTradeTimeConfig.getLocalDstTTradeTimeEnd2() != null && !localTradeTimeConfig.getLocalDstTTradeTimeEnd2().isEmpty()) {
					if (isTimeSpanNormal(localTradeTimeConfig.getLocalDstTTradeTimeStart2(), localTradeTimeConfig.getLocalDstTTradeTimeEnd2())) {
						if (isAcrossTimeSpanNormal(localTradeTimeConfig.getLocalDstTTradeTimeEnd2(), localTradeTimeConfig.getLocalDstTTradeTimeStart3())) {
							if (localTradeTimeConfig.getLocalDstTTradeTimeEnd1() != null && !localTradeTimeConfig.getLocalDstTTradeTimeEnd1().isEmpty()) {
								if (isTimeSpanNormal(localTradeTimeConfig.getLocalDstTTradeTimeStart1(), localTradeTimeConfig.getLocalDstTTradeTimeEnd1())) {
									if (isAcrossTimeSpanNormal(localTradeTimeConfig.getLocalDstTTradeTimeEnd1(), localTradeTimeConfig.getLocalDstTTradeTimeStart2())) {
										// TODO: three trade time
									} else {
										result.setErrorCode(6);
										result.setErrorMsg("夏令时T时间段1与T时间段2不能有交集");
										echoJson(result);
										return;
									}
								} else {
									result.setErrorCode(6);
									result.setErrorMsg("夏令时T时间段1不能跨天");
									echoJson(result);
									return;
								}
							} else {
								result.setErrorCode(6);
								result.setErrorMsg("不能跨时间段填写，请填写夏令时T时间段1");
								echoJson(result);
								return;
							}
						} else {
							result.setErrorCode(6);
							result.setErrorMsg("夏令时T时间段2与T时间段3不能有交集");
							echoJson(result);
							return;
						}
					} else {
						result.setErrorCode(6);
						result.setErrorMsg("夏令时T时间段2不能跨天");
						echoJson(result);
						return;
					}
				} else {
					result.setErrorCode(6);
					result.setErrorMsg("不能跨时间段填写，请填写夏令时T时间段2");
					echoJson(result);
					return;
				}
			} else {
				if (localTradeTimeConfig.getLocalDstTTradeTimeEnd2() != null && !localTradeTimeConfig.getLocalDstTTradeTimeEnd2().isEmpty()) {
					if (localTradeTimeConfig.getLocalDstTTradeTimeEnd1() != null && !localTradeTimeConfig.getLocalDstTTradeTimeEnd1().isEmpty()) {
						if (isTimeSpanNormal(localTradeTimeConfig.getLocalDstTTradeTimeStart1(), localTradeTimeConfig.getLocalDstTTradeTimeEnd1())) {
							if (isAcrossTimeSpanNormal(localTradeTimeConfig.getLocalDstTTradeTimeEnd1(), localTradeTimeConfig.getLocalDstTTradeTimeStart2())) {
								// TODO: two trade time
							} else {
								result.setErrorCode(6);
								result.setErrorMsg("夏令时T时间段1与T时间段2不能有交集");
								echoJson(result);
								return;
							}
						} else {
							result.setErrorCode(6);
							result.setErrorMsg("夏令时T时间段1不能跨天");
							echoJson(result);
							return;
						}
					} else {
						result.setErrorCode(6);
						result.setErrorMsg("不能跨时间段填写，请填写夏令时T时间段1");
						echoJson(result);
						return;
					}
				} else {
					if (localTradeTimeConfig.getLocalDstTTradeTimeEnd1() != null && !localTradeTimeConfig.getLocalDstTTradeTimeEnd1().isEmpty()) {
						//TODO: ONE
					} else {
						//TODO: NONE
					}
				}
			}
			
			if (localTradeTimeConfig.getLocalDstTPlusOneTradeTimeStart2() != null && !localTradeTimeConfig.getLocalDstTPlusOneTradeTimeStart2().isEmpty()) {
				if (localTradeTimeConfig.getLocalDstTPlusOneTradeTimeEnd1() != null && !localTradeTimeConfig.getLocalDstTPlusOneTradeTimeEnd1().isEmpty()) {
					if (isTimeSpanNormal(localTradeTimeConfig.getLocalDstTPlusOneTradeTimeStart1(), localTradeTimeConfig.getLocalDstTPlusOneTradeTimeEnd1())) {
						if (isAcrossTimeSpanNormal(localTradeTimeConfig.getLocalDstTPlusOneTradeTimeEnd1(), localTradeTimeConfig.getLocalDstTPlusOneTradeTimeStart2())) {
							// TODO: two trade time
						} else {
							result.setErrorCode(6);
							result.setErrorMsg("夏令时T+1时间段1与T+1时间段2不能有交集");
							echoJson(result);
							return;
						}
					} else {
						result.setErrorCode(6);
						result.setErrorMsg("夏令时T+1时间段1不能跨天");
						echoJson(result);
						return;
					}
				} else {
					result.setErrorCode(6);
					result.setErrorMsg("不能跨时间段填写，请填写夏令时T时间段1");
					echoJson(result);
					return;
				}
			} else {
				
			}
		}
		
		try {
			SledTradeTimeConfig sledTradeTimeConfig = getSledTradeTimeWeekdayConfigById(localTradeTimeConfig.getSledCommodityId());
			DayTradeTime dayTradeTime = new DayTradeTime();
			List<String> tTradeTimes = new ArrayList<String>();
			List<String> tPlusOneTradeTimes = new ArrayList<String>();
			
			if (localTradeTimeConfig.getLocalTTradeTimeStart1() != null && !localTradeTimeConfig.getLocalTTradeTimeStart1().isEmpty()) {
				tTradeTimes.add(localTradeTimeConfig.getLocalTTradeTimeStart1().trim().substring(0, 5) + ":00 - " + localTradeTimeConfig.getLocalTTradeTimeEnd1().trim().substring(0, 5) + ":00");
			}
			if(localTradeTimeConfig.getLocalTTradeTimeStart2() != null && !localTradeTimeConfig.getLocalTTradeTimeStart2().isEmpty()) {
				tTradeTimes.add(localTradeTimeConfig.getLocalTTradeTimeStart2().trim().substring(0, 5) + ":00 - " + localTradeTimeConfig.getLocalTTradeTimeEnd2().trim().substring(0, 5) + ":00");
			}
			if(localTradeTimeConfig.getLocalTTradeTimeStart3() != null && !localTradeTimeConfig.getLocalTTradeTimeStart3().isEmpty()) {
				tTradeTimes.add(localTradeTimeConfig.getLocalTTradeTimeStart3().trim().substring(0, 5) + ":00 - " + localTradeTimeConfig.getLocalTTradeTimeEnd3().trim().substring(0, 5) + ":00");
			}
			
			if (localTradeTimeConfig.getLocalTPlusOneTradeTimeStart1() != null && !localTradeTimeConfig.getLocalTPlusOneTradeTimeStart1().isEmpty()) {
				tPlusOneTradeTimes.add(localTradeTimeConfig.getLocalTPlusOneTradeTimeStart1().trim().substring(0, 5) + ":00 - " + localTradeTimeConfig.getLocalTPlusOneTradeTimeEnd1().trim().substring(0, 5) + ":00");
			}
			if (localTradeTimeConfig.getLocalTPlusOneTradeTimeStart2() != null && !localTradeTimeConfig.getLocalTPlusOneTradeTimeStart2().isEmpty()) {
				tPlusOneTradeTimes.add(localTradeTimeConfig.getLocalTPlusOneTradeTimeStart2().trim().substring(0, 5) + ":00 - " + localTradeTimeConfig.getLocalTPlusOneTradeTimeEnd2().trim().substring(0, 5) + ":00");
			}
			
//			AppLog.i("SledTradeTimeConfigAdmin ---- updateTradeTimeConfig ---- : " + tTradeTimes.get(0) + ", " + tTradeTimes.get(1) + ", " + tTradeTimes.get(2));
			
			dayTradeTime.setTTradeTimes(tTradeTimes);
			dayTradeTime.setTPlusOneTradeTimes(tPlusOneTradeTimes);
			sledTradeTimeConfig.getStandardWeekTradeTimes().put(Days.valueOf(localTradeTimeConfig.getWeekDayEN()), dayTradeTime);
			
			// ------------------------------- DST -------------------------------------
			if (localTradeTimeConfig.getStandardOrDst() == 1) {
				DayTradeTime dstDayTradeTime = new DayTradeTime();
				List<String> dstTTradeTimes = new ArrayList<String>();
				List<String> dstTPlusOneTradeTimes = new ArrayList<String>();
				
				if (localTradeTimeConfig.getLocalDstTTradeTimeStart1() != null && !localTradeTimeConfig.getLocalDstTTradeTimeStart1().isEmpty()) {
					dstTTradeTimes.add(localTradeTimeConfig.getLocalDstTTradeTimeStart1().trim().substring(0, 5) + ":00 - " + localTradeTimeConfig.getLocalDstTTradeTimeEnd1().trim().substring(0, 5) + ":00");
				}
				if(localTradeTimeConfig.getLocalDstTTradeTimeStart2() != null && !localTradeTimeConfig.getLocalDstTTradeTimeStart2().isEmpty()) {
					dstTTradeTimes.add(localTradeTimeConfig.getLocalDstTTradeTimeStart2().trim().substring(0, 5) + ":00 - " + localTradeTimeConfig.getLocalDstTTradeTimeEnd2().trim().substring(0, 5) + ":00");
				}
				if(localTradeTimeConfig.getLocalDstTTradeTimeStart3() != null && !localTradeTimeConfig.getLocalDstTTradeTimeStart3().isEmpty()) {
					dstTTradeTimes.add(localTradeTimeConfig.getLocalDstTTradeTimeStart3().trim().substring(0, 5) + ":00 - " + localTradeTimeConfig.getLocalDstTTradeTimeEnd3().trim().substring(0, 5) + ":00");
				}
				
				if (localTradeTimeConfig.getLocalDstTPlusOneTradeTimeStart1() != null && !localTradeTimeConfig.getLocalDstTPlusOneTradeTimeStart1().isEmpty()) {
					dstTPlusOneTradeTimes.add(localTradeTimeConfig.getLocalDstTPlusOneTradeTimeStart1().trim().substring(0, 5) + ":00 - " + localTradeTimeConfig.getLocalDstTPlusOneTradeTimeEnd1().trim().substring(0, 5) + ":00");
				}
				if (localTradeTimeConfig.getLocalDstTPlusOneTradeTimeStart2() != null && !localTradeTimeConfig.getLocalDstTPlusOneTradeTimeStart2().isEmpty()) {
					dstTPlusOneTradeTimes.add(localTradeTimeConfig.getLocalDstTPlusOneTradeTimeStart2().trim().substring(0, 5) + ":00 - " + localTradeTimeConfig.getLocalDstTPlusOneTradeTimeEnd2().trim().substring(0, 5) + ":00");
				}
				
				
				dstDayTradeTime.setTTradeTimes(dstTTradeTimes);
				dstDayTradeTime.setTPlusOneTradeTimes(dstTPlusOneTradeTimes);
				sledTradeTimeConfig.getDstWeekTradeTimes().put(Days.valueOf(localTradeTimeConfig.getWeekDayEN()), dstDayTradeTime); 
			}
			
//			if (localTradeTimeConfig.getStandardOrDst() == 1) {
//				sledTradeTimeConfig.getDstWeekTradeTimes().put(Days.valueOf(localTradeTimeConfig.getWeekDayEN()), dayTradeTime);
//			} else {
//				sledTradeTimeConfig.getStandardWeekTradeTimes().put(Days.valueOf(localTradeTimeConfig.getWeekDayEN()), dayTradeTime);
//			}
			mContractServiceStub.updateSledTradeTimeConfig(sledTradeTimeConfig);
		} catch(ErrorInfo errorInfo) {
			errorInfo.printStackTrace();
			result.setErrorCode(errorInfo.getErrorCode());
			result.setErrorMsg(errorInfo.getErrorMsg());
			echoJson(result);
			return;
		} catch (Throwable e) {
			e.printStackTrace();
			result.setErrorCode(5);
			result.setErrorMsg("服务器繁忙");
			echoJson(result);
			return;
		}
		echoJson(result);
	}
	
	private boolean isTimeSpanNormal(String timeSpanStart, String timeSpanEnd) {

		String start_hour = timeSpanStart.substring(0,2);
		String end_hour = timeSpanEnd.substring(0,2);
		
		int start_hour_int = Integer.parseInt(start_hour);
		int end_hour_int = Integer.parseInt(end_hour);
		if (start_hour_int < end_hour_int) {
			return true;
		} else if (start_hour_int > end_hour_int){
			return false;
		} else {
			String start_minute = timeSpanStart.substring(3);
			String end_minute = timeSpanEnd.substring(3);
			
			int start_minute_int = Integer.parseInt(start_minute);
			int end_minute_int = Integer.parseInt(end_minute);
			if (start_minute_int < end_minute_int) {
				return true;
			} else {
				return false;
			}
		}
	}
	
	private boolean isAcrossTimeSpanNormal(String previousTimeSpanEnd, String nextTimeSpanStart) {
		String start_hour = previousTimeSpanEnd.substring(0,2);
		String end_hour = nextTimeSpanStart.substring(0,2);
		
		int start_hour_int = Integer.parseInt(start_hour);
		int end_hour_int = Integer.parseInt(end_hour);
		if (start_hour_int < end_hour_int) {
			return true;
		} else if (start_hour_int > end_hour_int){
			return false;
		} else {
			String start_minute = previousTimeSpanEnd.substring(3);
			String end_minute = nextTimeSpanStart.substring(3);
			
			int start_minute_int = Integer.parseInt(start_minute);
			int end_minute_int = Integer.parseInt(end_minute);
			if (start_minute_int < end_minute_int) {
				return true;
			} else {
				return false;
			}
		}
	}
}
