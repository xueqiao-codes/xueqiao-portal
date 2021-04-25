package com.longsheng.xueqiao.admin.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.io.IOUtils;
import org.apache.thrift.TException;
import org.soldier.base.StringFactory;
import org.soldier.base.logger.AppLog;
import org.soldier.platform.page.IndexedPageOption;
import org.soldier.platform.svr_platform.comm.ErrorInfo;
import org.soldier.platform.web_framework.model.ErrorResult;
import org.soldier.platform.web_framework.util.GsonFactory;

import com.longsheng.xueqiao.admin.bean.LocalBrokerAccessEntry;
import com.longsheng.xueqiao.admin.bean.LocalBrokerEntry;
import com.longsheng.xueqiao.admin.bean.LocalCommoditySourceAccount;
import com.longsheng.xueqiao.broker.dao.thriftapi.BrokerAccessEntryPage;
import com.longsheng.xueqiao.broker.dao.thriftapi.BrokerEntryPage;
import com.longsheng.xueqiao.broker.dao.thriftapi.ReqBrokerAccessEntryOption;
import com.longsheng.xueqiao.broker.dao.thriftapi.ReqBrokerEntryOption;
import com.longsheng.xueqiao.broker.dao.thriftapi.client.BrokerDaoServiceStub;
import com.longsheng.xueqiao.broker.thriftapi.BrokerAccessEntry;
import com.longsheng.xueqiao.broker.thriftapi.BrokerPlatform;
import com.longsheng.xueqiao.contract.thriftapi.CommoditySourceAccount;
import com.longsheng.xueqiao.contract.thriftapi.CommoditySourceAccountPage;
import com.longsheng.xueqiao.contract.thriftapi.ReqCommoditySourceAccountOption;
import com.longsheng.xueqiao.contract.thriftapi.client.ContractServiceStub;

public class SledCommoditySourceAccountAdmin extends OaAuthController {
	private static final int PAGE_SIZE = 10;
	private static final int PAGE_SIZE_MAX = Integer.MAX_VALUE;
	
	private int mTotalPage = 1;
	private int mTotalNum = 0;
	
	ContractServiceStub mContractServiceStub = new ContractServiceStub();
	
	public void show() throws Exception {
		
		queryCommoditySourceAccountList();

		if (mContractServiceStub == null) {
			mContractServiceStub = new ContractServiceStub();
		}
		
		getBrokerList("CTP");
		getBrokerList("ESUNNY");
		
		put("sledTradeTimeList", null);
		
		render("sled_commodity_source_account_admin.html");
	}
	
	private void queryCommoditySourceAccountList() throws ErrorInfo, TException {
//		reqCommoditySourceAccount
		
		if (mContractServiceStub == null) {
			mContractServiceStub = new ContractServiceStub();
		}
		BrokerDaoServiceStub brokerDaoServiceStub = new BrokerDaoServiceStub();
		
		ReqCommoditySourceAccountOption reqCommoditySourceAccountOption = new ReqCommoditySourceAccountOption();
		IndexedPageOption indexedPageOption = new IndexedPageOption();
		indexedPageOption.setNeedTotalCount(true);
		indexedPageOption.setPageIndex(0);
		indexedPageOption.setPageSize(PAGE_SIZE_MAX);
		reqCommoditySourceAccountOption.setPageOption(indexedPageOption);
		CommoditySourceAccountPage commoditySourceAccountPage = mContractServiceStub.reqCommoditySourceAccount(reqCommoditySourceAccountOption);
		
		List<LocalCommoditySourceAccount> localCommoditySourceAccountList = new ArrayList<LocalCommoditySourceAccount>();
		
		if (commoditySourceAccountPage.getPageSize() > 0) {
			for (CommoditySourceAccount commoditySourceAccount : commoditySourceAccountPage.getPage()) {
				LocalCommoditySourceAccount localCommoditySourceAccount = new LocalCommoditySourceAccount();
				
				localCommoditySourceAccount.setAccountId(commoditySourceAccount.getAccountId());
				localCommoditySourceAccount.setTechPlatform(commoditySourceAccount.getTechPlatform().name());
				localCommoditySourceAccount.setTechPlatformEnv(commoditySourceAccount.getTechPlatformEnv().name());
				localCommoditySourceAccount.setAccountName(commoditySourceAccount.getAccountName());
				localCommoditySourceAccount.setAccountpwd(commoditySourceAccount.getAccountpwd());
				if (commoditySourceAccount.getIpAddress() != null && !commoditySourceAccount.getIpAddress().isEmpty()) {
					localCommoditySourceAccount.setIpAddress(commoditySourceAccount.getIpAddress() + ":" + commoditySourceAccount.getPort());
				}
				localCommoditySourceAccount.setPort(commoditySourceAccount.getPort());
				localCommoditySourceAccount.setAccessState(commoditySourceAccount.getAccessState().name());
				
				
				
				//broker
				ReqBrokerEntryOption reqBrokerEntryOption = new ReqBrokerEntryOption();
				List<Integer> brokerIds = new ArrayList<Integer>();
				brokerIds.add(commoditySourceAccount.getBrokerEntryId());
				reqBrokerEntryOption.setBrokerIds(brokerIds);
				
				BrokerEntryPage brokerEntryPage = brokerDaoServiceStub.reqBrokerEntry(reqBrokerEntryOption, 0, 1);
				if (brokerEntryPage.getPageSize() > 0) {
					localCommoditySourceAccount.setBrokerEntry(brokerEntryPage.getPage().get(0).getCnName());
				}
				
				// broker entry
				ReqBrokerAccessEntryOption reqBrokerAccessEntryOption = new ReqBrokerAccessEntryOption();
				List<Integer> entryIds = new ArrayList<Integer>();
				entryIds.add(commoditySourceAccount.getBrokerAccessId());
				AppLog.i("SledCommoditySourceAccountAdmin ---- queryCommoditySourceAccountList ---- commoditySourceAccount.getBrokerAccessId() : " + commoditySourceAccount.getBrokerAccessId());
				reqBrokerAccessEntryOption.setEntryIds(entryIds);
				BrokerAccessEntryPage brokerAccessEntryPage = brokerDaoServiceStub.reqBrokerAccessEntry(reqBrokerAccessEntryOption, 0, 1);
				AppLog.i("SledCommoditySourceAccountAdmin ---- queryCommoditySourceAccountList ---- brokerAccessEntryPage : " + brokerAccessEntryPage.getPageSize());
				if (brokerAccessEntryPage.getPageSize() > 0) {
					localCommoditySourceAccount.setBrokerAccess(brokerAccessEntryPage.getPage().get(0).getAccessName());
				}
				
				//extrainfo
				Map<String,String> accountProperties = commoditySourceAccount.getAccountProperties();
				StringBuilder accountPropertiesStr = new StringBuilder();
				if (accountProperties != null && !accountProperties.isEmpty()) {
					accountProperties.forEach((k,v)->{
						accountPropertiesStr.append(k).append(":").append(v).append("&nbsp;&nbsp;&nbsp;&nbsp;");
//						AppLog.i("SledCommoditySourceAccountAdmin ---- queryCommoditySourceAccountList ---- accountPropertiesStr : " + accountPropertiesStr.toString());
					});
				}
				localCommoditySourceAccount.setExtraInfo(accountPropertiesStr.toString());
				
				localCommoditySourceAccountList.add(localCommoditySourceAccount);
			}
		}
		
		put("sledCommoditySourceAccountList", localCommoditySourceAccountList);
	}
	
	public void getBrokerList(String platform) throws IOException {
		ErrorResult result = new ErrorResult();
//		String platform = parameter("platform", "ESUNNY");
		
		BrokerDaoServiceStub brokerDaoServiceStub = new BrokerDaoServiceStub();

//		ReqBrokerAccessEntryOption reqBrokerAccessEntryOption = new ReqBrokerAccessEntryOption();
//		reqBrokerAccessEntryOption.setPlatform(BrokerPlatform.valueOf(platform));
//		BrokerAccessEntryPage brokerAccessEntryPage = null;
//		try {
//			brokerAccessEntryPage = brokerDaoServiceStub.reqBrokerAccessEntry(reqBrokerAccessEntryOption, 0, PAGE_SIZE_MAX);
//		} catch(ErrorInfo errorInfo) {
//			errorInfo.printStackTrace();
//			result.setErrorCode(errorInfo.getErrorCode());
//			result.setErrorMsg(errorInfo.getErrorMsg() + " : " + errorInfo.getErrorMsg());
//			echoJson(result);
//			return;
//		} catch (Throwable e) {
//			e.printStackTrace();
//			result.setErrorCode(5);
//			result.setErrorMsg("服务器繁忙");
//			echoJson(result);
//			return;
//		}
		
		BrokerEntryPage brokerEntryPage = null;
//		if (brokerAccessEntryPage != null && brokerAccessEntryPage.getPageSize() > 0) {
			ReqBrokerEntryOption reqBrokerEntryOption = new ReqBrokerEntryOption();
			reqBrokerEntryOption.setPlatform(BrokerPlatform.valueOf(platform));
//			List<Integer> brokerIds = new ArrayList<Integer>();
//			for (BrokerAccessEntry brokerAccessEntry : brokerAccessEntryPage.getPage()) {
//				brokerIds.add(brokerAccessEntry.getBrokerId());
//			}
//			reqBrokerEntryOption.setBrokerIds(brokerIds);
			
			try {
				brokerEntryPage = brokerDaoServiceStub.reqBrokerEntry(reqBrokerEntryOption, 0, PAGE_SIZE_MAX);
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
//		}
		if ("ESUNNY".equals(platform)) {
			put("esBrokerList", LocalBrokerEntry.transferToLocalBrokerEntryListWithPlatform(brokerEntryPage, platform));
		} else if ("CTP".equals(platform)) {
			put("ctpBrokerList", LocalBrokerEntry.transferToLocalBrokerEntryListWithPlatform(brokerEntryPage, platform));
		}
		
	}
	
	public void addSourceAccount() throws IOException {
		ErrorResult result = new ErrorResult();
		
		if (mContractServiceStub == null) {
			mContractServiceStub = new ContractServiceStub();
		}
		
		String content = StringFactory.newUtf8String(IOUtils.toByteArray(getServletRequest().getInputStream()));
		AppLog.i("SledCommoditySourceAccountAdmin ---- addSourceAccount ---- content : " + content);
		
		LocalCommoditySourceAccount localCommoditySourceAccount = GsonFactory.getGson().fromJson(content, LocalCommoditySourceAccount.class);
		try {
			CommoditySourceAccount commoditySourceAccount = new CommoditySourceAccount();
			
			commoditySourceAccount.setAccountId(localCommoditySourceAccount.getAccountId());
			commoditySourceAccount.setBrokerEntryId(localCommoditySourceAccount.getBrokerEntryId());
			if (localCommoditySourceAccount.getBrokerAccessId() > 0) {
				commoditySourceAccount.setBrokerAccessId(localCommoditySourceAccount.getBrokerAccessId());
			} else {
				commoditySourceAccount.setBrokerAccessId(getBrokerAccessInfo(localCommoditySourceAccount.getBrokerEntryId(), localCommoditySourceAccount.getTechPlatform()));
			}
			commoditySourceAccount.setAccountName(localCommoditySourceAccount.getAccountName());
			commoditySourceAccount.setAccountpwd(localCommoditySourceAccount.getAccountpwd());
			commoditySourceAccount.setIpAddress(localCommoditySourceAccount.getIpAddress());
			commoditySourceAccount.setPort(localCommoditySourceAccount.getPort());
			
			
			Map<String, String> accountProperties = new HashMap<String, String>();
			if (localCommoditySourceAccount.getAppId() != null && !localCommoditySourceAccount.getAppId().isEmpty()) {
				accountProperties.put("APPID", localCommoditySourceAccount.getAppId());
				AppLog.i("SledCommoditySourceAccountAdmin ---- addSourceAccount ---- APPID : " + localCommoditySourceAccount.getAppId());
			}
			if (localCommoditySourceAccount.getCer() != null && !localCommoditySourceAccount.getCer().isEmpty()) {
				accountProperties.put("CER", localCommoditySourceAccount.getCer());
				AppLog.i("SledCommoditySourceAccountAdmin ---- addSourceAccount ---- CER : " + localCommoditySourceAccount.getCer());
			}
			if (!accountProperties.isEmpty()) {
				commoditySourceAccount.setAccountProperties(accountProperties);
				AppLog.i("SledCommoditySourceAccountAdmin ---- addSourceAccount ---- accountProperties : " + accountProperties.toString());
			}
			
			mContractServiceStub.updateCommoditySourceAccount(commoditySourceAccount);
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
	
	public void getSourceAccountInfo() throws IOException {
		ErrorResult result = new ErrorResult();
		int accountId = parameter("accountId", -1);
		
		if (accountId > 0) {
			if (mContractServiceStub == null) {
				mContractServiceStub = new ContractServiceStub();
			}
			BrokerDaoServiceStub brokerDaoServiceStub = new BrokerDaoServiceStub();
			
			ReqCommoditySourceAccountOption reqCommoditySourceAccountOption = new ReqCommoditySourceAccountOption();
			IndexedPageOption indexedPageOption = new IndexedPageOption();
			indexedPageOption.setPageIndex(0);
			indexedPageOption.setPageSize(1);
			reqCommoditySourceAccountOption.setPageOption(indexedPageOption);
			Set<Integer> accountIds = new HashSet<Integer>();
			accountIds.add(accountId);
			reqCommoditySourceAccountOption.setAccountIds(accountIds);
			CommoditySourceAccountPage commoditySourceAccountPage = null;
			try {
				commoditySourceAccountPage = mContractServiceStub.reqCommoditySourceAccount(reqCommoditySourceAccountOption);
			} catch (TException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			if (commoditySourceAccountPage != null && commoditySourceAccountPage.getPageSize() > 0) {
				CommoditySourceAccount commoditySourceAccount = commoditySourceAccountPage.getPage().get(0);
				LocalCommoditySourceAccount localCommoditySourceAccount = new LocalCommoditySourceAccount();
				
				localCommoditySourceAccount.setAccountId(commoditySourceAccount.getAccountId());
				localCommoditySourceAccount.setTechPlatform(commoditySourceAccount.getTechPlatform().name());
				localCommoditySourceAccount.setTechPlatformEnv(commoditySourceAccount.getTechPlatformEnv().name());
				localCommoditySourceAccount.setAccountName(commoditySourceAccount.getAccountName());
				localCommoditySourceAccount.setAccountpwd(commoditySourceAccount.getAccountpwd());
				localCommoditySourceAccount.setIpAddress(commoditySourceAccount.getIpAddress());
				localCommoditySourceAccount.setPort(commoditySourceAccount.getPort());
				localCommoditySourceAccount.setBrokerEntryId(commoditySourceAccount.getBrokerEntryId());
				localCommoditySourceAccount.setBrokerAccessId(commoditySourceAccount.getBrokerAccessId());
				
				Map<String,String> accountProperties = commoditySourceAccount.getAccountProperties();
				if (accountProperties != null && !accountProperties.isEmpty()) {
					accountProperties.forEach((k,v)->{
						if ("APPID".equals(k)) {
							localCommoditySourceAccount.setAppId(v);
						} else if ("CER".equals(k)) {
							localCommoditySourceAccount.setCer(v);
						}
					});
				}
				
				//broker
				ReqBrokerEntryOption reqBrokerEntryOption = new ReqBrokerEntryOption();
				List<Integer> brokerIds = new ArrayList<Integer>();
				brokerIds.add(commoditySourceAccount.getBrokerEntryId());
				reqBrokerEntryOption.setBrokerIds(brokerIds);
				
				BrokerEntryPage brokerEntryPage = null;
				try {
					brokerEntryPage = brokerDaoServiceStub.reqBrokerEntry(reqBrokerEntryOption, 0, 1);
				} catch (TException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (brokerEntryPage != null && brokerEntryPage.getPageSize() > 0) {
					localCommoditySourceAccount.setBrokerEntry(brokerEntryPage.getPage().get(0).getCnName());
				}
				
				// broker entry
				ReqBrokerAccessEntryOption reqBrokerAccessEntryOption = new ReqBrokerAccessEntryOption();
				List<Integer> entryIds = new ArrayList<Integer>();
				entryIds.add(commoditySourceAccount.getBrokerAccessId());
				reqBrokerAccessEntryOption.setEntryIds(entryIds);
				BrokerAccessEntryPage brokerAccessEntryPage = null;
				try {
					brokerAccessEntryPage = brokerDaoServiceStub.reqBrokerAccessEntry(reqBrokerAccessEntryOption, 0, 1);
				} catch (TException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (brokerAccessEntryPage != null && brokerAccessEntryPage.getPageSize() > 0) {
					localCommoditySourceAccount.setBrokerAccess(brokerAccessEntryPage.getPage().get(0).getAccessName());
				}
				
				AppLog.i("SledCommoditySourceAccountAdmin ---- getSourceAccountInfo ---- broker : " + localCommoditySourceAccount.getBrokerEntry() + ", broker access : " + localCommoditySourceAccount.getBrokerAccess());
				
				echoJson(localCommoditySourceAccount);
				return;
			} else {
				result.setErrorCode(5);
				result.setErrorMsg("获取不到ID为" + accountId + "的账号信息");
			}
		} else {
			result.setErrorCode(5);
			result.setErrorMsg("ID" + accountId + "无效");
		}
		
		echoJson(result);
	}
	
	public void getCTPBrokerAccessInfo() throws IOException {
		ErrorResult result = new ErrorResult();
		int brokerId = parameter("brokerId", -1);
		
		AppLog.i("SledCommoditySourceAccountAdmin ---- getCTPBrokerAccessInfo ---- brokerId : " + brokerId);
		
		if (brokerId > 0) {
			BrokerDaoServiceStub brokerDaoServiceStub = new BrokerDaoServiceStub();
	
			ReqBrokerAccessEntryOption reqBrokerAccessEntryOption = new ReqBrokerAccessEntryOption();
			List<Integer> brokerIds = new ArrayList<Integer>();
			brokerIds.add(brokerId);
			reqBrokerAccessEntryOption.setBrokerIds(brokerIds);
			reqBrokerAccessEntryOption.setPlatform(BrokerPlatform.CTP);
			BrokerAccessEntryPage brokerAccessEntryPage = null;
			try {
				brokerAccessEntryPage = brokerDaoServiceStub.reqBrokerAccessEntry(reqBrokerAccessEntryOption, 0, PAGE_SIZE_MAX);
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
			List<LocalBrokerAccessEntry> localBrokerAccessEntryList = new ArrayList<LocalBrokerAccessEntry>();
			if (brokerAccessEntryPage != null && brokerAccessEntryPage.getPageSize() > 0) {
				for (BrokerAccessEntry brokerAccessEntry : brokerAccessEntryPage.getPage()) {
					LocalBrokerAccessEntry localBrokerAccessEntry = new LocalBrokerAccessEntry();
					localBrokerAccessEntry.setAccessName(brokerAccessEntry.getAccessName());
					localBrokerAccessEntry.setEntryId(brokerAccessEntry.getEntryId());
					AppLog.i("SledCommoditySourceAccountAdmin ---- getCTPBrokerAccessInfo ---- brokerAccessEntry.getAccessName() : " + brokerAccessEntry.getAccessName() + ", brokerAccessEntry.getEntryId() : " + brokerAccessEntry.getEntryId());
					localBrokerAccessEntryList.add(localBrokerAccessEntry);
				}
			}
			AppLog.i("SledCommoditySourceAccountAdmin ---- getCTPBrokerAccessInfo ---- echoJson size : " + localBrokerAccessEntryList.size());
			echoJson(localBrokerAccessEntryList);
		} else {
			result.setErrorCode(5);
			result.setErrorMsg("brokerId不正确：" + brokerId);
			echoJson(result);
		}
	}
	
	public int getBrokerAccessInfo(int brokerId, String platform) throws IOException, ErrorInfo, TException {
		int brokerAccessId = 0;
		BrokerDaoServiceStub brokerDaoServiceStub = new BrokerDaoServiceStub();

		ReqBrokerAccessEntryOption reqBrokerAccessEntryOption = new ReqBrokerAccessEntryOption();
		List<Integer> brokerIds = new ArrayList<Integer>();
		brokerIds.add(brokerId);
		reqBrokerAccessEntryOption.setBrokerIds(brokerIds);
		reqBrokerAccessEntryOption.setPlatform(BrokerPlatform.valueOf(platform));
		BrokerAccessEntryPage brokerAccessEntryPage = null;
		brokerAccessEntryPage = brokerDaoServiceStub.reqBrokerAccessEntry(reqBrokerAccessEntryOption, 0, PAGE_SIZE_MAX);
		if (brokerAccessEntryPage != null && brokerAccessEntryPage.getPageSize() > 0) {
			brokerAccessId = brokerAccessEntryPage.getPage().get(0).getEntryId();
		}
		AppLog.i("SledCommoditySourceAccountAdmin ---- getESBrokerAccessInfo ---- brokerId : " + brokerId + ",brokerAccessEntryPage.getPageSize() : " + brokerAccessEntryPage.getPageSize() + ", brokerAccessId : " + brokerAccessId);
		return brokerAccessId;
	}
}
