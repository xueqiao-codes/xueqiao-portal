package com.longsheng.xueqiao.admin.web.controller;

import com.longsheng.xueqiao.admin.bean.LocalCommodity;
import com.longsheng.xueqiao.admin.bean.tradetime.LocalTradingSession;
import com.longsheng.xueqiao.admin.bean.tradetime.LocalTradingSessionTimeSpan;
import com.longsheng.xueqiao.admin.helper.Mapper;
import com.longsheng.xueqiao.contract.thriftapi.*;
import com.longsheng.xueqiao.contract.thriftapi.client.ContractServiceStub;
import org.apache.thrift.TException;
import org.soldier.base.logger.AppLog;
import org.soldier.platform.page.IndexedPageOption;
import org.soldier.platform.svr_platform.comm.ErrorInfo;
import org.soldier.platform.web_framework.model.ErrorResult;
import org.soldier.platform.web_framework.util.GsonFactory;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class SledTradeTimeConfigAdmin extends AbstractDBLockController {

	ContractServiceStub mContractServiceStub = new ContractServiceStub();

	private static final int PAGE_SIZE_MAX = Integer.MAX_VALUE;
	private static final String SUFFIX_SECONS = ":00";
	private static final SimpleDateFormat TIME_FORMAT = new SimpleDateFormat("HH:mm:ss");

	public void show() throws Exception {
		getModuleLockStatus(ModuleType.MM_CONTRACT);

		String exchangeMic = parameter("exchangeMic");
		int sledCommodityId = parameter("sledCommodityId", 0);
		String sledCommodityCnName = parameter("sledCommodityCnName");

		put("sledCommodityId", sledCommodityId);
		put("exchangeMic", exchangeMic);
		put("sledCommodityCnName", sledCommodityCnName);


		render("sled_trade_time_config_admin.html");
	}

	/**
	 * ajax 接口
	 * 查询冬令时（标准时间）的trading session
	 */
	public void queryStandardTradingSession() throws IOException {
		ErrorResult result = new ErrorResult();

		int sledCommodityId = parameter("sledCommodityId", 0);
		AppLog.i("SledTradeTimeConfigAdmin ---- queryStandardTradingSession ---- sledCommodityId : " + sledCommodityId);
		if (sledCommodityId < 1) {
			result.setErrorCode(5);
			result.setErrorMsg("内部错误");
			echoJson(result);
		}

		if (mContractServiceStub == null) {
			mContractServiceStub = new ContractServiceStub();
		}

		ReqSledTradingSessionOption option = new ReqSledTradingSessionOption();
		option.setSledCommodityId(sledCommodityId);

		IndexedPageOption pageOption = new IndexedPageOption();
		pageOption.setPageIndex(0);
		pageOption.setPageSize(PAGE_SIZE_MAX);

		/*
		 * 冬令时
		 * */
		option.setTimeSystem(TimeSystem.STANDARD);
		SledTradingSessionPage TradingSessionStandardPage = null;
		try {
			TradingSessionStandardPage = mContractServiceStub.reqSledTradingSession(option, pageOption);
		} catch (ErrorInfo e) {
			AppLog.i("SledTradeTimeConfigAdmin ---- queryStandardTradingSession e : " + e.toString(), e);
			result.setErrorCode(e.getErrorCode());
			result.setErrorMsg(e.getErrorMsg());
			echoJson(result);
			return;
		} catch (Throwable throwable) {
			AppLog.i("SledTradeTimeConfigAdmin ---- queryStandardTradingSession throwable : " + throwable.toString(), throwable);
			result.setErrorCode(5);
			result.setErrorMsg("内部错误");
			echoJson(result);
			return;
		}
		List<LocalTradingSession> standardTradingSessionList = transferSledTradingSessionPageToLocalList(TradingSessionStandardPage);

		AppLog.i("SledTradeTimeConfigAdmin ---- queryStandardTradingSession ---- standardTradingSessionList : " + standardTradingSessionList.toString());
		echoJson(standardTradingSessionList);
	}

	/**
	 * ajax 接口
	 * 查询夏令时的trading session
	 */
	public void queryDstTradingSession() throws IOException {
		ErrorResult result = new ErrorResult();

		int sledCommodityId = parameter("sledCommodityId", 0);
		AppLog.i("SledTradeTimeConfigAdmin ---- queryDstTradingSession ---- sledCommodityId : " + sledCommodityId);
		if (sledCommodityId < 1) {
			result.setErrorCode(5);
			result.setErrorMsg("内部错误");
			echoJson(result);
		}

		if (mContractServiceStub == null) {
			mContractServiceStub = new ContractServiceStub();
		}

		ReqSledTradingSessionOption option = new ReqSledTradingSessionOption();
		option.setSledCommodityId(sledCommodityId);

		IndexedPageOption pageOption = new IndexedPageOption();
		pageOption.setPageIndex(0);
		pageOption.setPageSize(PAGE_SIZE_MAX);

		/*
		 * 夏令时
		 * */
		option.setTimeSystem(TimeSystem.DST);
		SledTradingSessionPage TradingSessionDstPage = null;
		try {
			TradingSessionDstPage = mContractServiceStub.reqSledTradingSession(option, pageOption);
		} catch (ErrorInfo e) {
			AppLog.i("SledTradeTimeConfigAdmin ---- queryDstTradingSession e : " + e.toString(), e);
			result.setErrorCode(e.getErrorCode());
			result.setErrorMsg(e.getErrorMsg());
			echoJson(result);
			return;
		} catch (Throwable throwable) {
			AppLog.i("SledTradeTimeConfigAdmin ---- queryDstTradingSession throwable : " + throwable.toString(), throwable);
			result.setErrorCode(5);
			result.setErrorMsg("内部错误");
			echoJson(result);
			return;
		}
		List<LocalTradingSession> dstTradingSessionList = transferSledTradingSessionPageToLocalList(TradingSessionDstPage);

		AppLog.i("SledTradeTimeConfigAdmin ---- queryDstTradingSession ---- dstTradingSessionList : " + dstTradingSessionList.toString());
		echoJson(dstTradingSessionList);
	}

	/**
	 * ajax 接口
	 * 添加 trading session
	 */
	public void addTradingSession() throws IOException {
		ErrorResult result = new ErrorResult();

		int sledCommodityId = parameter("sledCommodityId", 0);
		String tradingSessionStr = parameter("tradingSesison");
		AppLog.i("SledTradeTimeConfigAdmin ---- addTradingSession ---- sledCommodityId : " + sledCommodityId + ", tradingSessionStr : " + tradingSessionStr);
		if (sledCommodityId < 1) {
			result.setErrorCode(5);
			result.setErrorMsg("内部错误");
			echoJson(result);
		}

		LocalTradingSession localTradingSession = GsonFactory.getGson().fromJson(tradingSessionStr, LocalTradingSession.class);
		AppLog.i("SledTradeTimeConfigAdmin ---- addTradingSession ---- localTradingSession : " + localTradingSession);

		if (mContractServiceStub == null) {
			mContractServiceStub = new ContractServiceStub();
		}

		SledTradingSession sledTradingSession = new SledTradingSession();

		sledTradingSession.setSledCommodityId(sledCommodityId);
		sledTradingSession.setTimeSystem(TimeSystem.findByValue(localTradingSession.getTimeSystem()));
		List<SledTradingSessionTimeSpan> timeSpanList = new ArrayList<SledTradingSessionTimeSpan>();
		SledTradingSessionTimeSpan sledTradingSessionTimeSpan = null;
		try {
			for (LocalTradingSessionTimeSpan localTradingSessionTimeSpan : localTradingSession.getTimeSpans()) {
				sledTradingSessionTimeSpan = new SledTradingSessionTimeSpan();

				sledTradingSessionTimeSpan.setStartDay(Days.findByValue(localTradingSessionTimeSpan.getStartDay()));
				sledTradingSessionTimeSpan.setEndDay(Days.findByValue(localTradingSessionTimeSpan.getEndDay()));
				sledTradingSessionTimeSpan.setStartTime(getHHMMSSTimeString(localTradingSessionTimeSpan.getStartTime()));
				sledTradingSessionTimeSpan.setEndTime(getHHMMSSTimeString(localTradingSessionTimeSpan.getEndTime()));
				sledTradingSessionTimeSpan.setTimeSpanState(TimeSpanState.T_OPEN);

				/*
				 * 检查时间段，若不满足条件，则会抛出异常
				 * */
				checkTimeSpan(sledTradingSessionTimeSpan);

				timeSpanList.add(sledTradingSessionTimeSpan);
			}
			sledTradingSession.setTimeSpans(timeSpanList);

			mContractServiceStub.addSledTradingSession(sledTradingSession);
		} catch (ErrorInfo e) {
			AppLog.e("SledTradeTimeConfigAdmin ---- addTradingSession e : " + e.toString(), e);
			result.setErrorCode(e.getErrorCode());
			result.setErrorMsg(e.getErrorMsg());
			echoJson(result);
			return;
		} catch (Throwable throwable) {
			AppLog.e("SledTradeTimeConfigAdmin ---- addTradingSession throwable : " + throwable.toString(), throwable);
			result.setErrorCode(5);
			result.setErrorMsg("内部错误");
			echoJson(result);
			return;
		}
	}

	/**
	 * ajax 接口
	 * 编辑 trading session
	 */
	public void editTradingSession() throws IOException {
		ErrorResult result = new ErrorResult();

		int sledCommodityId = parameter("sledCommodityId", 0);
		String tradingSessionStr = parameter("tradingSesison");
		AppLog.i("SledTradeTimeConfigAdmin ---- editTradingSession ---- sledCommodityId : " + sledCommodityId + ", tradingSessionStr : " + tradingSessionStr);
		if (sledCommodityId < 1) {
			result.setErrorCode(5);
			result.setErrorMsg("内部错误");
			echoJson(result);
		}

		LocalTradingSession localTradingSession = GsonFactory.getGson().fromJson(tradingSessionStr, LocalTradingSession.class);
		AppLog.i("SledTradeTimeConfigAdmin ---- editTradingSession ---- localTradingSession : " + localTradingSession);

		if (mContractServiceStub == null) {
			mContractServiceStub = new ContractServiceStub();
		}

		SledTradingSession sledTradingSession = new SledTradingSession();

		sledTradingSession.setTradeSessionId(localTradingSession.getTradeSessionId());
		sledTradingSession.setSledCommodityId(sledCommodityId);
//		sledTradingSession.setTimeSystem(TimeSystem.findByValue(localTradingSession.getTimeSystem()));
		List<SledTradingSessionTimeSpan> timeSpanList = new ArrayList<SledTradingSessionTimeSpan>();
		SledTradingSessionTimeSpan sledTradingSessionTimeSpan = null;
		try {
			for (LocalTradingSessionTimeSpan localTradingSessionTimeSpan : localTradingSession.getTimeSpans()) {
				sledTradingSessionTimeSpan = new SledTradingSessionTimeSpan();

				/*
				 * timeSpanId 有效的为修改
				 * timeSpanId 无效的为添加
				 * 删除的则不包含在列表中
				 * */
				if (localTradingSessionTimeSpan.getTimeSpanId() > 0) {
					sledTradingSessionTimeSpan.setTimeSpanId(localTradingSessionTimeSpan.getTimeSpanId());
				}
				sledTradingSessionTimeSpan.setStartDay(Days.findByValue(localTradingSessionTimeSpan.getStartDay()));
				sledTradingSessionTimeSpan.setEndDay(Days.findByValue(localTradingSessionTimeSpan.getEndDay()));
				sledTradingSessionTimeSpan.setStartTime(getHHMMSSTimeString(localTradingSessionTimeSpan.getStartTime()));
				sledTradingSessionTimeSpan.setEndTime(getHHMMSSTimeString(localTradingSessionTimeSpan.getEndTime()));
				sledTradingSessionTimeSpan.setTimeSpanState(TimeSpanState.T_OPEN);

				/*
				 * 检查时间段，若不满足条件，则会抛出异常
				 * */
				checkTimeSpan(sledTradingSessionTimeSpan);

				timeSpanList.add(sledTradingSessionTimeSpan);
			}
			sledTradingSession.setTimeSpans(timeSpanList);

			AppLog.i("SledTradeTimeConfigAdmin ---- editTradingSession ---- sledTradingSession : " + sledTradingSession);

			mContractServiceStub.updateSledTradingSession(sledTradingSession);
		} catch (ErrorInfo e) {
			AppLog.e("SledTradeTimeConfigAdmin ---- editTradingSession e : " + e.toString(), e);
			result.setErrorCode(e.getErrorCode());
			result.setErrorMsg(e.getErrorMsg());
			echoJson(result);
			return;
		} catch (Throwable throwable) {
			AppLog.e("SledTradeTimeConfigAdmin ---- editTradingSession throwable : " + throwable.toString(), throwable);
			result.setErrorCode(5);
			result.setErrorMsg("内部错误");
			echoJson(result);
			return;
		}
	}

	/**
	 * ajax 接口
	 * 删除 trading session
	 * */
	public void removeTradingSession() throws IOException {
		ErrorResult result = new ErrorResult();

		long tradeSessionId = parameter("tradeSessionId", 0);
		AppLog.i("SledTradeTimeConfigAdmin ---- removeTradingSession ---- tradeSessionId : " + tradeSessionId);
		if (tradeSessionId < 1) {
			result.setErrorCode(5);
			result.setErrorMsg("内部错误");
			echoJson(result);
		}

		if (mContractServiceStub == null) {
			mContractServiceStub = new ContractServiceStub();
		}

		try {
			mContractServiceStub.removeSledTradingSession(tradeSessionId);
		} catch (ErrorInfo e) {
			AppLog.e("SledTradeTimeConfigAdmin ---- removeTradingSession e : " + e.toString(), e);
			result.setErrorCode(e.getErrorCode());
			result.setErrorMsg(e.getErrorMsg());
			echoJson(result);
			return;
		} catch (Throwable throwable) {
			AppLog.e("SledTradeTimeConfigAdmin ---- removeTradingSession throwable : " + throwable.toString(), throwable);
			result.setErrorCode(5);
			result.setErrorMsg("内部错误");
			echoJson(result);
			return;
		}
	}

	private List<LocalTradingSession> transferSledTradingSessionPageToLocalList(SledTradingSessionPage page) {
		List<LocalTradingSession> localTradingSessionList = new ArrayList<LocalTradingSession>();

		LocalTradingSession localTradingSessionTemp = null;
		List<LocalTradingSessionTimeSpan> localTradingSessionTimeSpanList = null;
		LocalTradingSessionTimeSpan localTradingSessionTimeSpanTemp = null;

		if (page != null && page.getPageSize() > 0) {
			for (SledTradingSession session : page.getPage()) {
				localTradingSessionTemp = new LocalTradingSession();

				localTradingSessionTimeSpanList = new ArrayList<LocalTradingSessionTimeSpan>();
				for (SledTradingSessionTimeSpan timeSpan : session.getTimeSpans()) {
					localTradingSessionTimeSpanTemp = new LocalTradingSessionTimeSpan();

					localTradingSessionTimeSpanTemp.setStartDay(timeSpan.getStartDay().getValue());
					localTradingSessionTimeSpanTemp.setEndDay(timeSpan.getEndDay().getValue());
					localTradingSessionTimeSpanTemp.setStartTime(timeSpan.getStartTime());
					localTradingSessionTimeSpanTemp.setEndTime(timeSpan.getEndTime());

					localTradingSessionTimeSpanTemp.setStartWeekdayAndTime(Mapper.getDayString(timeSpan.getStartDay()) + " " + timeSpan.getStartTime());
					localTradingSessionTimeSpanTemp.setEndWeekdayAndTime(Mapper.getDayString(timeSpan.getEndDay()) + " " + timeSpan.getEndTime());

					localTradingSessionTimeSpanList.add(localTradingSessionTimeSpanTemp);
				}
				localTradingSessionTemp.setTradeSessionId(session.getTradeSessionId());
				localTradingSessionTemp.setTimeSystem(session.getTimeSystem().getValue());
				localTradingSessionTemp.setTimeSpans(localTradingSessionTimeSpanList);
				localTradingSessionList.add(localTradingSessionTemp);
			}
		}
		return localTradingSessionList;
	}

	private String getHHMMSSTimeString(String time) throws Throwable {
		if (time.length() < 5) {
			AppLog.e("SledTradeTimeConfigAdmin ---- getHHMMSSTimeString length of time should more than 5");
			throw new Throwable("length of time should more than 5");
		}
		return time.substring(0, 5) + SUFFIX_SECONS;
	}

	private void checkTimeSpan(SledTradingSessionTimeSpan timeSpan) throws ParseException, ErrorInfo {
		if (timeSpan.getStartDay() == timeSpan.getEndDay()) {
			/*
			 * 如果前后是同一天，则确保结束的时间点要大于开始的时间点
			 * */
			long startTime = TIME_FORMAT.parse(timeSpan.getStartTime()).getTime();
			long endTime = TIME_FORMAT.parse(timeSpan.getEndTime()).getTime();
			if (startTime >= endTime) {
				throw new ErrorInfo(6, "同一时间段内开始时间点不能大于或者等于结束时间点");
			}
		} else {
			/*
			 * 如果前后不是同一天，则要确保开始的天是结果的天的前一天
			 * */
			int startDay = timeSpan.getStartDay().getValue();
			int endDay = timeSpan.getEndDay().getValue();
			startDay++;
			if (startDay > Days.SATURDAY.getValue()) {
				startDay = Days.SUNDAY.getValue();
			}
			if (startDay != endDay) {
				throw new ErrorInfo(6, "同一时间段内开始时间只能与结束时间在同一天，或者在结束时间的前一天");
			}
		}
	}
}
