package com.longsheng.xueqiao.admin.web.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import com.longsheng.xueqiao.admin.bean.tradetime.LocalDateTimeSpan;
import com.longsheng.xueqiao.admin.helper.Mapper;
import com.longsheng.xueqiao.contract.thriftapi.*;
import org.apache.commons.lang.StringUtils;
import org.apache.thrift.TException;
import org.soldier.base.logger.AppLog;
import org.soldier.platform.page.IndexedPageOption;
import org.soldier.platform.svr_platform.comm.ErrorInfo;

import com.longsheng.xueqiao.admin.bean.tradetime.LocalTradeTime;
import com.longsheng.xueqiao.contract.standard.thriftapi.ReqSledCommodityOption;
import com.longsheng.xueqiao.contract.standard.thriftapi.SledCommodity;
import com.longsheng.xueqiao.contract.thriftapi.client.ContractServiceStub;


public class SledTradeTimeAdmin extends AbstractDBLockController {

	ContractServiceStub mContractServiceStub = new ContractServiceStub();

	private static SimpleDateFormat dateSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
	private static SimpleDateFormat dateSimpleTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private static SimpleDateFormat dateSimpleTimeFormatWithoutYear = new SimpleDateFormat("MM-dd HH:mm:ss");
	private static SimpleDateFormat dateSimpleTimeFormatLocal = new SimpleDateFormat("MM-dd HH:mm:ss");

	private static String BIEJING_ZONE_ID = "Asia/Shanghai";//"GMT+8";

	private static final String TIME_SPAN_DIVIDER = "--";

	private static final int ONE_DATE_TIMESTAMP = 60 * 60 * 24 - 1;
	private static final int PAGE_SIZE = 10;
	private static final int PAGE_SIZE_MAX = Integer.MAX_VALUE;

	private int mTotalPage = 1;
	private int mTotalNum = 0;

	public void show() throws Exception {

		getModuleLockStatus(ModuleType.MM_CONTRACT);

		int requestPage = parameter("requestPage", 1);
		String sledCommodityCode = parameter("sledCommodityCode", "");
		int sledCommodityId = parameter("sledCommodityId", -1);
		String searchTime = parameter("searchTime", "");
		String exchangeMic = parameter("exchangeMic", "");
		String commodityCnName = parameter("commodityCnName", "");

		int marginDays = parameter("marginDays", 0);

		AppLog.i("SledTradeTimeAdmin ---- show ---- requestPage : " + requestPage + ", sledCommodityId : " + sledCommodityId
			+ ", searchTime : " + searchTime + ", sledCommodityCode : " + sledCommodityCode
			+ ", exchangeMic : " + exchangeMic + ", commodityCnName : " + commodityCnName
			+ ", marginDays : " + marginDays);

		List<Integer> sledCommodityIds = new ArrayList<Integer>();
		if (sledCommodityId > 0) {
			sledCommodityIds.add(sledCommodityId);
		} else {
			if (StringUtils.isNotBlank(sledCommodityCode) || StringUtils.isNotBlank(exchangeMic) || StringUtils.isNotBlank(commodityCnName)) {
				sledCommodityIds = getSledCommodityId(sledCommodityCode.trim(), exchangeMic, commodityCnName);
			}
		}
		if (marginDays > 7) {
			marginDays = 7;
		} else if (marginDays < 0) {
			marginDays = 0;
		}

//		long searchTimestamp = -1;
		if (StringUtils.isBlank(searchTime)) {
			searchTime = dateSimpleDateFormat.format(new Date(System.currentTimeMillis()));
		}


		if (requestPage < 1) {
			requestPage = 1;
		}
		requestPage = queryTradeTimeList(sledCommodityIds, searchTime, marginDays, requestPage - 1);

		if (mTotalPage < 1) {
			mTotalPage = 1;
		}
		put("currentPage", requestPage + 1);
		put("totalPage", mTotalPage);
		put("totalNum", mTotalNum);

		put("sledCommodityId", sledCommodityId);
		put("sledCommodityCode", sledCommodityCode);
		put("searchTime", searchTime);
		put("marginDays", marginDays);
		put("exchangeMic", exchangeMic);
		put("commodityCnName", commodityCnName);

		setBaseQueryUrl(sledCommodityId, searchTime, sledCommodityCode, exchangeMic, commodityCnName, marginDays);
		render("sled_trade_time_admin.html");
	}

	private void setBaseQueryUrl(int sledCommodityId, String searchTime, String sledCommodityCode, String exchangeMic, String commodityCnName, int marginDays) {
		StringBuffer baseQueryUrl = new StringBuffer();
		String baseUrl = this.baseUrl;
		int l = baseUrl.indexOf("requestPage");
		if (l > 0) {
			baseUrl = baseUrl.substring(0, l);
		}
		baseQueryUrl.append(baseUrl);
		baseQueryUrl.append("/SledTradeTimeAdmin/show?sledCommodityId=").append(sledCommodityId);
		baseQueryUrl.append("&searchTime=").append(searchTime);
		baseQueryUrl.append("&sledCommodityCode=").append(sledCommodityCode);
		baseQueryUrl.append("&exchangeMic=").append(exchangeMic);
		baseQueryUrl.append("&commodityCnName=").append(commodityCnName);
		baseQueryUrl.append("&marginDays=").append(marginDays);
		baseQueryUrl.append("&");
		put("baseQueryUrl", baseQueryUrl);
	}

	private int queryTradeTimeList(List<Integer> sledCommodityIds, String searchTime, int days, int pageIndex) throws ErrorInfo, TException, ParseException {

		if (mContractServiceStub == null) {
			mContractServiceStub = new ContractServiceStub();
		}

		List<LocalTradeTime> LocalTradeTimeList = new ArrayList<LocalTradeTime>();

		long currentDateBeginTimeStamp = 0;
		long currentDateEndTimeStamp = 0;

		ReqSledTradeTimeOption reqSledTradeTimeOption = new ReqSledTradeTimeOption();
		reqSledTradeTimeOption.setDays(days);
		if (StringUtils.isNotBlank(searchTime)) {
			reqSledTradeTimeOption.setDate(searchTime);

			currentDateBeginTimeStamp = dateSimpleDateFormat.parse(searchTime).getTime() / 1000;
			currentDateEndTimeStamp = currentDateBeginTimeStamp + ONE_DATE_TIMESTAMP;
		} else {

			String searchTimeTemp = dateSimpleDateFormat.format(new Date(System.currentTimeMillis()));
			reqSledTradeTimeOption.setDate(searchTimeTemp);

			reqSledTradeTimeOption.setDateTimestamp(System.currentTimeMillis() / 1000);

			try {
				Date date = dateSimpleDateFormat.parse(searchTimeTemp);
				currentDateBeginTimeStamp = date.getTime() / 1000;
				currentDateEndTimeStamp = currentDateBeginTimeStamp + ONE_DATE_TIMESTAMP;
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		AppLog.i("SledTradeTimeAdmin ---- queryTradeTimeList ---- currentDateBeginTimeStamp : " + currentDateBeginTimeStamp + ", currentDateEndTimeStamp : " + currentDateEndTimeStamp + ", System.currentTimeMillis() : " + System.currentTimeMillis());

		if (sledCommodityIds != null && !sledCommodityIds.isEmpty()) {
			reqSledTradeTimeOption.setSledCommodityIds(sledCommodityIds);
		}
		SledTradeTimePage sledTradeTimePage = mContractServiceStub.reqSledTradeTime(reqSledTradeTimeOption, pageIndex, PAGE_SIZE);

		AppLog.i("SledTradeTimeAdmin ---- queryTradeTimeList ---- reqSledTradeTimeOption : " + reqSledTradeTimeOption.toString() + ", sledTradeTimePage : " + sledTradeTimePage.toString());

		List<Integer> commodityIdList = new ArrayList<Integer>();
		Map<Integer, SledCommodity> commodityMap = new HashMap<Integer, SledCommodity>();
		Map<Integer, SledCommoditySpecTradeTime> commoditySpecTradeTimeMap = new HashMap<Integer, SledCommoditySpecTradeTime>();

		LocalTradeTime localTradeTime = null;
		List<LocalDateTimeSpan> localDateTimeSpanList = null;
		LocalDateTimeSpan localDateTimeSpan = null;
		List<String> localTimeTOpenList = null;
		List<String> beijingTimeTOpenList = null;

		for (SledTradeTime sledTradeTime : sledTradeTimePage.getPage()) {
			commodityIdList.add(sledTradeTime.getSledCommodityId());

			localTradeTime = new LocalTradeTime();
			localDateTimeSpanList = new ArrayList<LocalDateTimeSpan>();

			localTradeTime.setSledCommodityId(sledTradeTime.getSledCommodityId());
			localTradeTime.setTimezone(sledTradeTime.getZoneId());

			/*
			 * 排序
			 * */
			sledTradeTime.getDateTimeSpans().sort(SledTradeTimeAdmin::compareDateTimeSpan);

			for (DateTimeSpan dateTimeSpan : sledTradeTime.getDateTimeSpans()) {
				localDateTimeSpan = new LocalDateTimeSpan();
				localTimeTOpenList = new ArrayList<String>();
				beijingTimeTOpenList = new ArrayList<String>();

				for (TTimeSpan TTimeSpan : dateTimeSpan.getTTimeSpan()) {
					/*
					* 参数校验
					* */
					if (TTimeSpan == null || StringUtils.isBlank(TTimeSpan.getStartTimeString()) || StringUtils.isBlank(TTimeSpan.getEndTimeString())) {
						continue;
					}

					/*
					 * 本地时间段
					 * */
					String timeSpan = dateSimpleTimeFormatLocal.format(new Date(TTimeSpan.getStartTimestamp())) + TIME_SPAN_DIVIDER + dateSimpleTimeFormatLocal.format(new Date(TTimeSpan.getEndTimestamp()));
					String timeSpanState = Mapper.getTimeSpanStateString(TTimeSpan.getTimeSpanState());
					localTimeTOpenList.add(timeSpan + " " + timeSpanState);

					/*
					 * 北京时间段
					 * */
					timeSpan = getBeijingTimeSpan(TTimeSpan.getStartTimeString(), TTimeSpan.getEndTimeString(), sledTradeTime.getZoneId());
					beijingTimeTOpenList.add(timeSpan + " " + timeSpanState);
				}
				/*
				* 一天的所有时间段
				* */
				localDateTimeSpan.setDate(dateTimeSpan.getDate());
				localDateTimeSpan.setLocalTimeTOpenList(localTimeTOpenList);
				localDateTimeSpan.setBeijingTimeTOpenList(beijingTimeTOpenList);

				localDateTimeSpanList.add(localDateTimeSpan);
			}

			if (localDateTimeSpanList.size() > 0) {
				localTradeTime.setLocalDateTimeSpanList(localDateTimeSpanList);
			}

			LocalTradeTimeList.add(localTradeTime);
		}

		// query commodities info
		if (commodityIdList.size() > 0) {
			ReqSledCommodityOption reqSledCommodityOption = new ReqSledCommodityOption();
			reqSledCommodityOption.setSledCommodityIdList(commodityIdList);
			SledCommodityEditPage sledCommodityEditPage = mContractServiceStub.reqSledCommodity(reqSledCommodityOption, 0, commodityIdList.size());

			for (SledCommodityEdit sledCommodityEdit : sledCommodityEditPage.getPage()) {
				commodityMap.put(sledCommodityEdit.getSledCommodity().getSledCommodityId(), sledCommodityEdit.getSledCommodity());
			}
		}

		// query spec time info
		ReqCommoditySpecTradeTimeOption reqCommoditySpecTradeTimeOption = new ReqCommoditySpecTradeTimeOption();
		reqCommoditySpecTradeTimeOption.setSledCommodityIds(new HashSet(commodityIdList));
		reqCommoditySpecTradeTimeOption.setStartTimestamp(currentDateBeginTimeStamp);
		reqCommoditySpecTradeTimeOption.setEndTimestamp(currentDateEndTimeStamp);

		SledCommoditySpecTradeTimePage sledCommoditySpecTradeTimePage = mContractServiceStub.reqSledCommoditySpecTradeTime(reqCommoditySpecTradeTimeOption, 0, PAGE_SIZE_MAX);

		AppLog.i("SledTradeTimeAdmin ---- sledCommoditySpecTradeTimePage :" + sledCommoditySpecTradeTimePage.toString());


		for (SledCommoditySpecTradeTime sledCommoditySpecTradeTime : sledCommoditySpecTradeTimePage.getPage()) {
			commoditySpecTradeTimeMap.put(sledCommoditySpecTradeTime.getSledCommodityId(), sledCommoditySpecTradeTime);
		}

		// query week trade times info
		ReqSledTradeTimeConfigOption reqSledTradeTimeConfigOption = new ReqSledTradeTimeConfigOption();
		reqSledTradeTimeConfigOption.setSledCommodityIds(new HashSet(commodityIdList));

		/*
		 * 查询 trading session 的数量 条件
		 * */
		ReqSledTradingSessionOption option = new ReqSledTradingSessionOption();
		IndexedPageOption page = new IndexedPageOption();
		page.setPageIndex(0).setPageSize(1).setNeedTotalCount(true);
		SledTradingSessionPage sledTradingSessionPage = null;

		// put datas together in LocalTradeTimeList
		for (LocalTradeTime localTradeTimeItem : LocalTradeTimeList) {
			//set commodity info
			SledCommodity sledCommodity = commodityMap.get(localTradeTimeItem.getSledCommodityId());
			if (sledCommodity != null) {
				localTradeTimeItem.setExchangeMic(sledCommodity.getExchangeMic());
				localTradeTimeItem.setSledCommodityType(sledCommodity.getSledCommodityType().name());
				localTradeTimeItem.setSledCommodityCode(sledCommodity.getSledCommodityCode());
				localTradeTimeItem.setSledCommodityCnName(sledCommodity.getCnName());
			}

			//set spec time info
			if (commoditySpecTradeTimeMap.containsKey(localTradeTimeItem.getSledCommodityId())) {
				localTradeTimeItem.setIsSpecTime(1);
			} else {
				localTradeTimeItem.setIsSpecTime(0);
			}

			option.setSledCommodityId(localTradeTimeItem.getSledCommodityId());
			sledTradingSessionPage = mContractServiceStub.reqSledTradingSession(option, page);
			//set week trade times info
			/*
			 * 设置 trading sesison 的数量，以便页面上显示是否已经设置了常规时间
			 * trading session 数量不为0，则说明已经设置了常规时间
			 * trading session 数量为0，则说明还没有设置常规时间
			 * */
			localTradeTimeItem.setWeekTradeTimesSize(sledTradingSessionPage.getTotal());
		}

		put("sledTradeTimeList", LocalTradeTimeList);

		mTotalNum = sledTradeTimePage.getTotal();
		mTotalPage = (sledTradeTimePage.getTotal() + PAGE_SIZE - 1) / PAGE_SIZE;
		return pageIndex > mTotalPage ? mTotalPage : pageIndex;
	}

	private List<Integer> getSledCommodityId(String sledCommodityCode, String exchangeMic, String commodityCnName) throws ErrorInfo, TException {

		if (mContractServiceStub == null) {
			mContractServiceStub = new ContractServiceStub();
		}

		List<Integer> sledCommodityIds = new ArrayList<Integer>();

		ReqSledCommodityOption reqSledCommodityOption = new ReqSledCommodityOption();

		if (sledCommodityCode != null && !sledCommodityCode.isEmpty()) {
			reqSledCommodityOption.setSledCommodityCode(sledCommodityCode);
		}
		if (exchangeMic != null && !exchangeMic.isEmpty()) {
			reqSledCommodityOption.setExchangeMic(exchangeMic);
		}
		if (commodityCnName != null && !commodityCnName.isEmpty()) {
			reqSledCommodityOption.setCnNamePartical(commodityCnName);
		}

		SledCommodityEditPage sledCommodityEditPage = mContractServiceStub.reqSledCommodity(reqSledCommodityOption, 0, PAGE_SIZE_MAX);

		AppLog.i("SledTradeTimeAdmin ---- getSledCommodityIdByCode ---- sledCommodityCode : " + sledCommodityCode + ", sledCommodityEditPage.getPageSize() :" + sledCommodityEditPage.getPageSize());

		if (sledCommodityEditPage.getPageSize() > 0) {
			for (SledCommodityEdit sledCommodityEdit : sledCommodityEditPage.getPage()) {
				sledCommodityIds.add(sledCommodityEdit.getSledCommodity().getSledCommodityId());
			}
//			return sledCommodityEditPage.getPage().get(0).getSledCommodity().getSledCommodityId();
		}

		return sledCommodityIds;
	}

	private String transferTimeByTimezone(String timeStr, String srcTimezone, String dstTimezone) throws ParseException {

		dateSimpleTimeFormat.setTimeZone(TimeZone.getTimeZone(srcTimezone));
		Date date = dateSimpleTimeFormat.parse(timeStr);
		dateSimpleTimeFormatWithoutYear.setTimeZone(TimeZone.getTimeZone(dstTimezone));
		return dateSimpleTimeFormatWithoutYear.format(date);
	}

	private String getBeijingTimeSpan(String startTimeStr, String endTimeStr, String srcTimezone) throws ParseException {
		return transferTimeByTimezone(startTimeStr, srcTimezone, BIEJING_ZONE_ID) + TIME_SPAN_DIVIDER + transferTimeByTimezone(endTimeStr, srcTimezone, BIEJING_ZONE_ID);
	}

	private static int compareDateTimeSpan(DateTimeSpan o1, DateTimeSpan o2) {
		long date1 = 0;
		long date2 = 0;
		try {
			date1 = dateSimpleDateFormat.parse(o1.getDate()).getTime();
			date2 = dateSimpleDateFormat.parse(o2.getDate()).getTime();
		} catch (ParseException e) {
			e.printStackTrace();
		}

		AppLog.i("SledTradeTimeAdmin ---- compareDateTimeSpan ---- startDate : " + date1 + ", endDate : " + date2);

		if (date1 < date2) {
			return -1;
		} else if (date1 > date2) {
			return 1;
		} else {
			return 0;
		}
	}
}
