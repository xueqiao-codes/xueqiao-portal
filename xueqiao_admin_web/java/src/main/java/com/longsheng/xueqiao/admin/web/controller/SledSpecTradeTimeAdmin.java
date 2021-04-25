package com.longsheng.xueqiao.admin.web.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.apache.thrift.TException;
import org.soldier.base.StringFactory;
import org.soldier.base.logger.AppLog;
import org.soldier.platform.svr_platform.comm.ErrorInfo;
import org.soldier.platform.web_framework.model.ErrorResult;
import org.soldier.platform.web_framework.util.GsonFactory;

import com.longsheng.xueqiao.admin.bean.LocalExchange;
import com.longsheng.xueqiao.admin.bean.LocalSimpleCommodity;
import com.longsheng.xueqiao.admin.bean.tradetime.LocalSpecTradeTime;
import com.longsheng.xueqiao.admin.bean.tradetime.LocalTradeTimeSelectionInfo;
import com.longsheng.xueqiao.contract.standard.thriftapi.ReqSledCommodityOption;
import com.longsheng.xueqiao.contract.standard.thriftapi.ReqSledExchangeOption;
import com.longsheng.xueqiao.contract.standard.thriftapi.SledCommodity;
import com.longsheng.xueqiao.contract.standard.thriftapi.SledCommodityType;
import com.longsheng.xueqiao.contract.standard.thriftapi.SledExchange;
import com.longsheng.xueqiao.contract.standard.thriftapi.SledExchangePage;
import com.longsheng.xueqiao.contract.thriftapi.NextTradeOpenType;
import com.longsheng.xueqiao.contract.thriftapi.RemoveSpecTradeTimeOption;
import com.longsheng.xueqiao.contract.thriftapi.ReqSpecTradeTimeOption;
import com.longsheng.xueqiao.contract.thriftapi.SledCommodityEdit;
import com.longsheng.xueqiao.contract.thriftapi.SledCommodityEditPage;
import com.longsheng.xueqiao.contract.thriftapi.SpecTradeTime;
import com.longsheng.xueqiao.contract.thriftapi.SpecTradeTimePage;
import com.longsheng.xueqiao.contract.thriftapi.client.ContractServiceStub;

public class SledSpecTradeTimeAdmin extends AbstractDBLockController {
	
	private static final int PAGE_SIZE = 10;
	private static final int PAGE_SIZE_MAX = Integer.MAX_VALUE;
	
	private static SimpleDateFormat dateSimpleTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	
	private int mTotalPage = 1;
	private int mTotalNum = 0;
	
	ContractServiceStub mContractServiceStub = new ContractServiceStub();
	
	public void show() throws Exception {
		
		getModuleLockStatus(ModuleType.MM_CONTRACT);

		int requestPage = parameter("requestPage", 1);
		
		String exchangeMic = parameter("exchangeMic", "");
		String sledCommodityType = parameter("sledCommodityType", "");
		String searchTimeDate = parameter("searchTimeDate", "");
		String searchTimeTime = parameter("searchTimeTime", "");
		
		AppLog.i("SledExchangeAdmin ---- show ---- requestPage : " + requestPage + ", exchangeMic : " + exchangeMic
				+ ", sledCommodityType : " + sledCommodityType + ", searchTimeDate : " + searchTimeDate
				+ ", searchTimeTime : " + searchTimeTime);
		
		if (requestPage < 1) {
			requestPage = 1;
		}
		requestPage = requerySpecTradeTimeList(exchangeMic, sledCommodityType, searchTimeDate, searchTimeTime, requestPage - 1);
		put("currentPage", requestPage + 1);
		if (mTotalPage < 1) {
			mTotalPage = 1;
		}
		put("totalPage", mTotalPage);
		put("totalNum", mTotalNum);

		put("exchangeMic", exchangeMic);
		put("sledCommodityType", sledCommodityType);
		put("searchTimeDate", searchTimeDate);
		put("searchTimeTime", searchTimeTime);


		if (mContractServiceStub == null) {
			mContractServiceStub = new ContractServiceStub();
		}
		setBaseQueryUrl(exchangeMic, sledCommodityType, searchTimeDate, searchTimeTime);
		
		put("sledTradeTimeList", null);
		
		render("sled_spec_trade_time_admin.html");
	}
	
	private void setBaseQueryUrl(String exchangeMic, String sledCommodityType, String searchTimeDate, String searchTimeTime) {
		StringBuffer baseQueryUrl = new StringBuffer();
		String baseUrl = this.baseUrl;
		int l = baseUrl.indexOf("requestPage");
		if (l > 0) {
			baseUrl = baseUrl.substring(0, l);
		}
		baseQueryUrl.append(baseUrl);
		baseQueryUrl.append("/SledSpecTradeTimeAdmin/show?exchangeMic=").append(exchangeMic);
		baseQueryUrl.append("&sledCommodityType=").append(sledCommodityType);
		baseQueryUrl.append("&searchTimeDate=").append(searchTimeDate);
		baseQueryUrl.append("&searchTimeTime=").append(searchTimeTime);
		baseQueryUrl.append("&");
		put("baseQueryUrl", baseQueryUrl);
	}

	private int requerySpecTradeTimeList(String exchangeMic, String sledCommodityType, String searchTimeDate, String searchTimeTime, int pageIndex) throws ErrorInfo, TException {
		
		if (mContractServiceStub == null) {
			mContractServiceStub = new ContractServiceStub();
		}
		
		ReqSpecTradeTimeOption reqSpecTradeTimeOption = new ReqSpecTradeTimeOption();
		SpecTradeTimePage specTradeTimePage = mContractServiceStub.reqSpecTradeTime(reqSpecTradeTimeOption, 0, PAGE_SIZE_MAX);

//		AppLog.i("SledSpecTradeTimeAdmin ---- requerySpecTradeTimeList ---- specTradeTimePage : " + specTradeTimePage.toString());

		List<LocalSpecTradeTime> localSpecTradeTimeList = specTradeTimeFilter(specTradeTimePage, exchangeMic, sledCommodityType, searchTimeDate, searchTimeTime);
		List<LocalSpecTradeTime> localSpecTradeTimeListResult = new ArrayList<LocalSpecTradeTime>();
		
		if (((pageIndex + 1) * PAGE_SIZE) <= localSpecTradeTimeList.size()) {
			for (int index = pageIndex * PAGE_SIZE; index < ((pageIndex + 1) * PAGE_SIZE); index++) {
				localSpecTradeTimeListResult.add(localSpecTradeTimeList.get(index));
			}
		} else if ((pageIndex * PAGE_SIZE) < localSpecTradeTimeList.size()) {
			for (int index = pageIndex * PAGE_SIZE; index < localSpecTradeTimeList.size(); index++) {
				localSpecTradeTimeListResult.add(localSpecTradeTimeList.get(index));
			}
		}
		
		put("sledSpecTradeTimeList", localSpecTradeTimeListResult);
		
		mTotalNum = localSpecTradeTimeList.size();//specTradeTimePage.getTotal();
		mTotalPage = (mTotalNum + PAGE_SIZE - 1) / PAGE_SIZE;
		return pageIndex > mTotalPage ? mTotalPage : pageIndex;
	}
	
	private List<LocalSpecTradeTime> specTradeTimeFilter(SpecTradeTimePage specTradeTimePage, String exchangeMic, String sledCommodityType, String searchTimeDate, String searchTimeTime) {
		
		List<LocalSpecTradeTime> localSpecTradeTimeList = new ArrayList<LocalSpecTradeTime>();
		
		boolean searchTimeReady = false;
		long searchTimestamp = -1;
		if (!searchTimeDate.isEmpty() && !searchTimeTime.isEmpty()) {
			try {
				String nonTradeStartTimeStr = searchTimeDate.trim() + " " + searchTimeTime.trim().substring(0, 5);
				searchTimestamp = dateSimpleTimeFormat.parse(nonTradeStartTimeStr).getTime() / 1000;
				searchTimeReady = true;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if (exchangeMic.isEmpty() && sledCommodityType.isEmpty() && searchTimeReady) {
			//searchTime
			for (SpecTradeTime SpecTradeTime : specTradeTimePage.getPage()) {
				if (searchTimestamp >= SpecTradeTime.getNonTradeStartTimestamp() && searchTimestamp <= SpecTradeTime.getNonTradeEndTimestamp()) {
					localSpecTradeTimeList.add(LocalSpecTradeTime.transformSpecTradeTimetoLocal(SpecTradeTime));
				}
			}
			return localSpecTradeTimeList;
			
		} else if (!exchangeMic.isEmpty() && sledCommodityType.isEmpty() && searchTimeReady) {
			//exchangeMic, searchTime
			for (SpecTradeTime SpecTradeTime : specTradeTimePage.getPage()) {
				if (SpecTradeTime.getExchangeMic().equals(exchangeMic) && searchTimestamp >= SpecTradeTime.getNonTradeStartTimestamp() && searchTimestamp <= SpecTradeTime.getNonTradeEndTimestamp()) {
					localSpecTradeTimeList.add(LocalSpecTradeTime.transformSpecTradeTimetoLocal(SpecTradeTime));
				}
			}
			return localSpecTradeTimeList;
			
		} else if (exchangeMic.isEmpty() && !sledCommodityType.isEmpty() && searchTimeReady) {
			//sledCommodityType, searchTime
			for (SpecTradeTime SpecTradeTime : specTradeTimePage.getPage()) {
				if (SpecTradeTime.getSledCommodityTypes().contains(sledCommodityType) && searchTimestamp >= SpecTradeTime.getNonTradeStartTimestamp() && searchTimestamp <= SpecTradeTime.getNonTradeEndTimestamp()) {
					localSpecTradeTimeList.add(LocalSpecTradeTime.transformSpecTradeTimetoLocal(SpecTradeTime));
				}
			}
			return localSpecTradeTimeList;
			
		} else if (!exchangeMic.isEmpty() && !sledCommodityType.isEmpty() && searchTimeReady) {
			//exchangeMic, sledCommodityType, searchTime
			for (SpecTradeTime SpecTradeTime : specTradeTimePage.getPage()) {
				if (SpecTradeTime.getExchangeMic().equals(exchangeMic) && SpecTradeTime.getSledCommodityTypes().contains(sledCommodityType) && searchTimestamp >= SpecTradeTime.getNonTradeStartTimestamp() && searchTimestamp <= SpecTradeTime.getNonTradeEndTimestamp()) {
					localSpecTradeTimeList.add(LocalSpecTradeTime.transformSpecTradeTimetoLocal(SpecTradeTime));
				}
			}
			return localSpecTradeTimeList;
			
		} else if (!exchangeMic.isEmpty() && sledCommodityType.isEmpty()) {
			//exchangeMic
			for (SpecTradeTime SpecTradeTime : specTradeTimePage.getPage()) {
				if (SpecTradeTime.getExchangeMic().equals(exchangeMic)) {
					localSpecTradeTimeList.add(LocalSpecTradeTime.transformSpecTradeTimetoLocal(SpecTradeTime));
				}
			}
			return localSpecTradeTimeList;
			
		} else if (exchangeMic.isEmpty() && !sledCommodityType.isEmpty()) {
			//sledCommodityType
			for (SpecTradeTime SpecTradeTime : specTradeTimePage.getPage()) {
				if (SpecTradeTime.getSledCommodityTypes().contains(sledCommodityType)) {
					localSpecTradeTimeList.add(LocalSpecTradeTime.transformSpecTradeTimetoLocal(SpecTradeTime));
				}
			}
			return localSpecTradeTimeList;
			
		} else if (!exchangeMic.isEmpty() && !sledCommodityType.isEmpty()) {
			//exchangeMic, sledCommodityType
			for (SpecTradeTime SpecTradeTime : specTradeTimePage.getPage()) {
				if (SpecTradeTime.getExchangeMic().equals(exchangeMic) && SpecTradeTime.getSledCommodityTypes().contains(sledCommodityType)) {
					localSpecTradeTimeList.add(LocalSpecTradeTime.transformSpecTradeTimetoLocal(SpecTradeTime));
				}
			}
			return localSpecTradeTimeList;
		} 
		
		return LocalSpecTradeTime.transformSpecTradeTimeListtoLocal(specTradeTimePage.getPage());
	}
	
	public void getSpecTradeTimeSelectionInfo() throws IOException {
		ErrorResult result = new ErrorResult();

		String exchangeMic = parameter("exchangeMic", "");
		String sledCommodityType = parameter("sledCommodityType", "FUTURES");
		String zoneId = parameter("zoneId", "");
		
		if (sledCommodityType == null || sledCommodityType.isEmpty()) {
			sledCommodityType = "FUTURES";
		}
		
		AppLog.i("SledSpecTradeTimeAdmin ---- getSpecTradeTimeSelectionInfo ---- exchangeMic : " + exchangeMic + ", sledCommodityType : " + sledCommodityType + ", zoneId : " + zoneId);
		
		if (mContractServiceStub == null) {
			mContractServiceStub = new ContractServiceStub();
		}
		
		LocalTradeTimeSelectionInfo localSpecTradeTimeSelectionInfo = new LocalTradeTimeSelectionInfo();
		
		// get exchange list
		ReqSledExchangeOption reqSledExchangeOption = new ReqSledExchangeOption();
		try {
			SledExchangePage exchangePage = mContractServiceStub.reqSledExchange(reqSledExchangeOption, 0, PAGE_SIZE_MAX);
			if (exchangePage.getPageSize() > 0) {
				List<LocalExchange> exchangeList = new ArrayList<LocalExchange>();
				for (SledExchange sledExchange : exchangePage.getPage()) {
					LocalExchange localExchange = new LocalExchange();
					localExchange.setExchangeMic(sledExchange.getExchangeMic());
					localExchange.setCnName(sledExchange.getCnName());
					localExchange.setAcronym(sledExchange.getAcronym());
					localExchange.setCnAcronym(sledExchange.getCnAcronym());
					exchangeList.add(localExchange);
				}
				localSpecTradeTimeSelectionInfo.setExchangeList(exchangeList);
			} else {
				result.setErrorCode(6);
				result.setErrorMsg("查到交易所数量为0");
				echoJson(result);
				return;
			}
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
		
		if (exchangeMic == null || exchangeMic.isEmpty()) {
			exchangeMic = localSpecTradeTimeSelectionInfo.getExchangeList().get(0).getExchangeMic();
		}
		
		AppLog.i("SledSpecTradeTimeAdmin ---- getSpecTradeTimeSelectionInfo ---- exchangeMic : " + exchangeMic);
		
		// get exchange
		localSpecTradeTimeSelectionInfo.setExchangeMic(exchangeMic);
		
		// get commodity type
		localSpecTradeTimeSelectionInfo.setSledCommodityType(sledCommodityType);
		
		// get commodities
		ReqSledCommodityOption reqSledCommodityOption = new ReqSledCommodityOption();
		reqSledCommodityOption.setExchangeMic(exchangeMic);
		reqSledCommodityOption.setSledCommodityType(SledCommodityType.valueOf(sledCommodityType));
		
		try {
			SledCommodityEditPage sledCommodityEditPage = mContractServiceStub.reqSledCommodity(reqSledCommodityOption, 0, PAGE_SIZE_MAX);
			List<String> zoneIdList = new ArrayList<String>();
			List<LocalSimpleCommodity> localSimpleCommodityList = new ArrayList<LocalSimpleCommodity>();
			
			if (sledCommodityEditPage.getPageSize() > 0) {
				for (SledCommodityEdit sledCommodityEdit : sledCommodityEditPage.getPage()) {
					SledCommodity sledCommodity = sledCommodityEdit.getSledCommodity();
					if (sledCommodity.getZoneId() != null && !sledCommodity.getZoneId().isEmpty()) {
						if (!zoneIdList.contains(sledCommodity.getZoneId())) {
							zoneIdList.add(sledCommodity.getZoneId());
						}
					}
				}
				
				// get timezone
				if (zoneIdList.size() > 0) {
					if (zoneId == null || zoneId.isEmpty()) {
						zoneId = zoneIdList.get(0);
					}
					localSpecTradeTimeSelectionInfo.setZoneId(zoneId);
					
					for (SledCommodityEdit sledCommodityEdit : sledCommodityEditPage.getPage()) {
						SledCommodity sledCommodity = sledCommodityEdit.getSledCommodity();
						if (sledCommodity.getZoneId().equals(zoneId)) {
							LocalSimpleCommodity localSimpleCommodity = new LocalSimpleCommodity();
							localSimpleCommodity.setSledCommodityId(String.valueOf(sledCommodity.getSledCommodityId()));
							localSimpleCommodity.setCnName(sledCommodity.getCnName());
							localSimpleCommodity.setSledCommodityCode(sledCommodity.getSledCommodityCode());
							
							localSimpleCommodityList.add(localSimpleCommodity);
						}
					}
				}
				
			}
			// get timezone list
			localSpecTradeTimeSelectionInfo.setZoneIdList(zoneIdList);
			
			//get commodities 
			localSpecTradeTimeSelectionInfo.setLocalSimpleCommodityList(localSimpleCommodityList);
			
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
		
		AppLog.i("SledSpecTradeTimeAdmin ---- getSpecTradeTimeSelectionInfo ---- localSpecTradeTimeSelectionInfo : " + localSpecTradeTimeSelectionInfo.toString());
		echoJson(localSpecTradeTimeSelectionInfo);
	}
	
	public void addSpecTradeTime() throws IOException {
		ErrorResult result = new ErrorResult();
		
		if (mContractServiceStub == null) {
			mContractServiceStub = new ContractServiceStub();
		}
		
		try {
			String content = StringFactory.newUtf8String(IOUtils.toByteArray(getServletRequest().getInputStream()));

			AppLog.i("SledSpecTradeTimeAdmin ---- addSpecTradeTime ---- content : " + content);

			LocalSpecTradeTime localSpecTradeTime = GsonFactory.getGson().fromJson(content, LocalSpecTradeTime.class);
			
			AppLog.i("SledSpecTradeTimeAdmin ---- addSpecTradeTime ---- localSpecTradeTime is not null : " + (localSpecTradeTime != null));

			SpecTradeTime specTradeTime = new SpecTradeTime();
			
			if (localSpecTradeTime.getExchangeMic() != null && !localSpecTradeTime.getExchangeMic().isEmpty()) {
				specTradeTime.setExchangeMic(localSpecTradeTime.getExchangeMic());
			} else {
				result.setErrorCode(7);
				result.setErrorMsg("获取交易所信息失败");
				echoJson(result);
				return;
			}
			
			if (localSpecTradeTime.getSledCommodityType() != null && !localSpecTradeTime.getSledCommodityType().isEmpty()) {
				List<String> sledCommodityTypes = new ArrayList<String>();
				sledCommodityTypes.add(localSpecTradeTime.getSledCommodityType());
				specTradeTime.setSledCommodityTypes(sledCommodityTypes);
			} else {
				result.setErrorCode(7);
				result.setErrorMsg("获取商品类型信息失败");
				echoJson(result);
				return;
			}
			
			if (localSpecTradeTime.getZoneId() != null && !localSpecTradeTime.getZoneId().isEmpty()) {
				specTradeTime.setZoneId(localSpecTradeTime.getZoneId());
			} else {
				result.setErrorCode(7);
				result.setErrorMsg("获取时区信息失败");
				echoJson(result);
				return;
			}
			
			if (localSpecTradeTime.getSledCommodityIds().size() > 0) {
				specTradeTime.setSledCommodityIds(localSpecTradeTime.getSledCommodityIds());
				
				ReqSledCommodityOption reqSledCommodityOption = new ReqSledCommodityOption();
				reqSledCommodityOption.setSledCommodityIdList(localSpecTradeTime.getSledCommodityIds());
				SledCommodityEditPage sledCommodityEditPage = mContractServiceStub.reqSledCommodity(reqSledCommodityOption, 0, PAGE_SIZE_MAX);
				
				List<String> sledCommodityNames = new ArrayList<String>();
				for (SledCommodityEdit sledCommodityEdit : sledCommodityEditPage.getPage()) {
					sledCommodityNames.add(sledCommodityEdit.getSledCommodity().getCnName());
				}
				specTradeTime.setSledCommodityNames(sledCommodityNames);
				
			} else {
				result.setErrorCode(7);
				result.setErrorMsg("商品个数为0，添加失败");
				echoJson(result);
				return;
			}
			
			if (localSpecTradeTime.getNonTradeStartDate() == null || localSpecTradeTime.getNonTradeStartDate().isEmpty()) {
				result.setErrorCode(7);
				result.setErrorMsg("获取开始日期失败");
				echoJson(result);
				return;
			}
			if (localSpecTradeTime.getNonTradeStartTime() == null || localSpecTradeTime.getNonTradeStartTime().isEmpty()) {
				result.setErrorCode(7);
				result.setErrorMsg("获取开始时间失败");
				echoJson(result);
				return;
			}
			String nonTradeStartTimeStr = localSpecTradeTime.getNonTradeStartDate() + " " + localSpecTradeTime.getNonTradeStartTime().trim().substring(0, 5);
			long nonTradeStartTime = dateSimpleTimeFormat.parse(nonTradeStartTimeStr).getTime() / 1000;
			AppLog.i("SledSpecTradeTimeAdmin ---- addSpecTradeTime ---- nonTradeStartTimeStr : " + nonTradeStartTimeStr + ", nonTradeStartTime : " + nonTradeStartTime);
			specTradeTime.setNonTradeStartTimestamp(nonTradeStartTime);
			
			if (localSpecTradeTime.getNonTradeEndDate() == null || localSpecTradeTime.getNonTradeEndDate().isEmpty()) {
				result.setErrorCode(7);
				result.setErrorMsg("获取开始日期失败");
				echoJson(result);
				return;
			}
			if (localSpecTradeTime.getNonTradeEndTime() == null || localSpecTradeTime.getNonTradeEndTime().isEmpty()) {
				result.setErrorCode(7);
				result.setErrorMsg("获取开始时间失败");
				echoJson(result);
				return;
			}
			
			String nonTradeEndTimeStr = localSpecTradeTime.getNonTradeEndDate() + " " + localSpecTradeTime.getNonTradeEndTime().trim().substring(0, 5);
			long nonTradeEndTime = dateSimpleTimeFormat.parse(nonTradeEndTimeStr).getTime() / 1000;
			AppLog.i("SledSpecTradeTimeAdmin ---- addSpecTradeTime ---- nonTradeEndTimeStr : " + nonTradeEndTimeStr + ", nonTradeEndTime : " + nonTradeEndTime);
			specTradeTime.setNonTradeEndTimestamp(nonTradeEndTime);
			
			specTradeTime.setNextTradeOpenType(NextTradeOpenType.valueOf(localSpecTradeTime.getNextTradeOpenType()));
			
			mContractServiceStub.addSpecTradeTime(specTradeTime);


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
	
	public void deleteSpecTradeTime() throws IOException {
		ErrorResult result = new ErrorResult();
		
		int specTradeTimeId = parameter("specTradeTimeId", 0);
		AppLog.i("SledSpecTradeTimeAdmin ---- deleteSpecTradeTime ---- specTradeTimeId : " + specTradeTimeId);

		if (specTradeTimeId <= 0) {
			result.setErrorCode(2);
			result.setErrorMsg("获取不到特殊交易时间ID，删除失败");
			echoJson(result);
			return;
		}
		
		if (mContractServiceStub == null) {
			mContractServiceStub = new ContractServiceStub();
		}
		
		try {
			RemoveSpecTradeTimeOption removeSpecTradeTimeOption = new RemoveSpecTradeTimeOption();
			List<Integer> specTradeTimeIds = new ArrayList<Integer>();
			specTradeTimeIds.add(specTradeTimeId);
			removeSpecTradeTimeOption.setSpecTradeTimeIds(specTradeTimeIds);
			mContractServiceStub.removeSpecTradeTime(removeSpecTradeTimeOption);
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
}
