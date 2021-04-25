package com.longsheng.xueqiao.active.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.math.RandomUtils;
import org.apache.thrift.TException;
import org.soldier.base.logger.AppLog;
import org.soldier.platform.svr_platform.comm.ErrorInfo;
import org.soldier.platform.web_framework.model.ErrorResult;

import com.longsheng.xueqiao.active.bean.LocalAccessAddress;
import com.longsheng.xueqiao.active.bean.LocalBrokerAccessEntry;
import com.longsheng.xueqiao.active.bean.LocalSimpleBrokerAccessEntry;
import com.longsheng.xueqiao.active.util.ChineseNumUtil;
import com.longsheng.xueqiao.broker.dao.thriftapi.BrokerAccessEntryPage;
import com.longsheng.xueqiao.broker.dao.thriftapi.ReqBrokerAccessEntryOption;
import com.longsheng.xueqiao.broker.dao.thriftapi.client.BrokerDaoServiceStub;
import com.longsheng.xueqiao.broker.thriftapi.AccessAddress;
import com.longsheng.xueqiao.broker.thriftapi.BrokerAccessEntry;
import com.longsheng.xueqiao.broker.thriftapi.BrokerAccessStatus;
import com.longsheng.xueqiao.broker.thriftapi.BrokerPlatform;
import com.longsheng.xueqiao.broker.thriftapi.TechPlatformEnv;

public class SledBrokerAccessAdmin extends OaAuthController {
	private static final int TIME_OUT = 3000;

	private static final int ACCESS_ENTRY_PAGE_SIZE = 50;

	BrokerDaoServiceStub mBrokerDaoServiceStub = new BrokerDaoServiceStub();

	public void show() throws Exception {

		int entryId = parameter("entryId", -1);
		int brokerId = parameter("brokerId", 0);
		String platform = parameter("platform", "");
		String brokerCnName = parameter("brokerCnName", "");

		AppLog.i("SledBrokerAccessAdmin ---- show ---- entryId : " + entryId + ", brokerId : " + brokerId + ", platform : " + platform);
		
//		setBaseQueryUrl();
		if (entryId > 0) {
			queryBrokerAccessEntryByEntryId(entryId);
		} else {
			queryBrokerAccessEntryByBrokerIdAndPlatform(brokerId, platform);
		}

		 put("brokerCnName", brokerCnName);
		render("sled_broker_access_admin.html");
	}

	public void addAccessAddress() throws IOException, ErrorInfo, TException {
		ErrorResult result = new ErrorResult();
		result.setErrorCode(0);

		int entryId = parameter("entryId", 0);
		String addressType = parameter("addressType", "");
		String accessAddressIp = parameter("accessAddressIp", "");
		int accessAddressPort = parameter("accessAddressPort", 0);

		AppLog.i("SledBrokerAccessAdmin ---- addAccessAddress ---- entryId : " + entryId + ", accessAddressIp : "
				+ accessAddressIp + ", accessAddressPort : " + accessAddressPort + ", addressType : " + addressType);
		
		if (entryId > 0 && addressType != null && accessAddressIp != null && !accessAddressIp.isEmpty() && accessAddressPort >= 0) {

			if (mBrokerDaoServiceStub == null) {
				mBrokerDaoServiceStub = new BrokerDaoServiceStub();
			}
			ReqBrokerAccessEntryOption option = new ReqBrokerAccessEntryOption();
			List<Integer> entryIds = new ArrayList<Integer>();
			entryIds.add(entryId);
			option.setEntryIds(entryIds);

			BrokerAccessEntryPage page = null;

			try {
				page = mBrokerDaoServiceStub.reqBrokerAccessEntry(RandomUtils.nextInt(), TIME_OUT, option, 0, 1);
			} catch (ErrorInfo e) {
				e.printStackTrace();
				result.setErrorCode(e.getErrorCode());
				result.setErrorMsg(e.getErrorMsg());
			}

			// AppLog.i("SledBrokerAccessAdmin ---- addAccessAddress ----
			// page.getPageSize() : " + page.getPageSize());
			if (page == null || page.getPageSize() < 1) {
				return;
			}
			BrokerAccessEntry brokerAccessEntry = page.getPage().get(0);

			if ("type_trade".equals(addressType)) {
				List<AccessAddress> tradeAddresses = brokerAccessEntry.getTradeAddresses();
				AccessAddress tradeAddress = new AccessAddress();
				tradeAddress.setAddress(accessAddressIp);
				tradeAddress.setPort(accessAddressPort);
				tradeAddresses.add(tradeAddress);
				AppLog.i("SledBrokerAccessAdmin ---- addAccessAddress ---- type_trade ---- accessAddressIp : " + accessAddressIp + ", accessAddressPort : " + accessAddressPort);
				brokerAccessEntry.setTradeAddresses(tradeAddresses);
			} else if ("type_quota".equals(addressType)) {
				List<AccessAddress> quotaAddresses = brokerAccessEntry.getQuotaAddresses();
				AccessAddress quotaAddress = new AccessAddress();
				quotaAddress.setAddress(accessAddressIp);
				quotaAddress.setPort(accessAddressPort);
				quotaAddresses.add(quotaAddress);
				brokerAccessEntry.setQuotaAddresses(quotaAddresses);
			} else {
				result.setErrorCode(5);
				result.setErrorMsg("地址类型出错，添加失败（请找工程师确认）");
				echoJson(result);
				return;
			}
			
			// Set edit status
			brokerAccessEntry.setStatus(BrokerAccessStatus.EDIT);

			try {
				mBrokerDaoServiceStub.updateBrokerAccessEntry(RandomUtils.nextInt(), TIME_OUT, brokerAccessEntry);
			} catch (ErrorInfo e) {
				e.printStackTrace();
				result.setErrorCode(e.getErrorCode());
				result.setErrorMsg(e.getErrorMsg());
			}
		}

		echoJson(result);
	}

	public void removeAccessAddress() throws IOException, ErrorInfo, TException {
		ErrorResult result = new ErrorResult();
		result.setErrorCode(0);

		int entryId = parameter("entryId", 0);
		String addressType = parameter("addressType", "");
		String accessAddressIp = parameter("accessAddressIp", "");
		int accessAddressPort = parameter("accessAddressPort", 0);
		AppLog.i("SledBrokerAccessAdmin ---- updateAccessAddressList ---- entryId : " + entryId + ", accessAddressIp : "
				+ accessAddressIp + ", accessAddressPort : " + accessAddressPort + ", addressType : " + addressType);

		if (entryId > 0 && addressType != null && accessAddressIp != null && !accessAddressIp.isEmpty() && accessAddressPort >= 0) {

			if (mBrokerDaoServiceStub == null) {
				mBrokerDaoServiceStub = new BrokerDaoServiceStub();
			}
			ReqBrokerAccessEntryOption option = new ReqBrokerAccessEntryOption();
			List<Integer> entryIds = new ArrayList<Integer>();
			entryIds.add(entryId);
			option.setEntryIds(entryIds);

			BrokerAccessEntryPage page = null;

			try {
				page = mBrokerDaoServiceStub.reqBrokerAccessEntry(RandomUtils.nextInt(), TIME_OUT, option, 0, 1);
			} catch (ErrorInfo e) {
				e.printStackTrace();
				result.setErrorCode(e.getErrorCode());
				result.setErrorMsg(e.getErrorMsg());
			}
			if (page == null || page.getPageSize() < 1) {
				result.setErrorCode(2);
				result.setErrorMsg("接入详情查询错误，删除失败");
				echoJson(result);
				return;
			}
			BrokerAccessEntry brokerAccessEntry = page.getPage().get(0);

			if ("type_trade".equals(addressType)) {
				List<AccessAddress> tradeAddresses = brokerAccessEntry.getTradeAddresses();
				for (AccessAddress aa : tradeAddresses) {
					if (accessAddressIp.equals(aa.getAddress()) && accessAddressPort == aa.getPort()) {
						tradeAddresses.remove(aa);
						break;
					}
				}
				brokerAccessEntry.setTradeAddresses(tradeAddresses);
			} else if ("type_quota".equals(addressType)) {
				List<AccessAddress> quotaAddresses = brokerAccessEntry.getQuotaAddresses();
				for (AccessAddress aa : quotaAddresses) {
					if (accessAddressIp.equals(aa.getAddress()) && accessAddressPort == aa.getPort()) {
						quotaAddresses.remove(aa);
						break;
					}
				}
				brokerAccessEntry.setQuotaAddresses(quotaAddresses);
			} else {
				result.setErrorCode(5);
				result.setErrorMsg("地址类型出错，删除失败（请找工程师确认）");
				echoJson(result);
				return;
			}
			

			// Set edit status
			brokerAccessEntry.setStatus(BrokerAccessStatus.EDIT);
			
			try {
				mBrokerDaoServiceStub.updateBrokerAccessEntry(RandomUtils.nextInt(), TIME_OUT, brokerAccessEntry);
			} catch (ErrorInfo e) {
				e.printStackTrace();
				result.setErrorCode(e.getErrorCode());
				result.setErrorMsg(e.getErrorMsg());
			}
		}
		echoJson(result);
	}

	public void addCustomInfo() throws ErrorInfo, TException, IOException {
		ErrorResult result = new ErrorResult();
		result.setErrorCode(0);

		int entryId = parameter("entryId", 0);
		String customInfoKey = parameter("customInfoKey", "");
		String customInfoValue = parameter("customInfoValue", "");
		AppLog.i("SledBrokerAccessAdmin ---- addCustomInfo ---- entryId : " + entryId + ", customInfoKey : "
				+ customInfoKey + ", customInfoValue : " + customInfoValue);

		if (entryId > 0 && !customInfoKey.isEmpty()) {
			if (mBrokerDaoServiceStub == null) {
				mBrokerDaoServiceStub = new BrokerDaoServiceStub();
			}

			ReqBrokerAccessEntryOption option = new ReqBrokerAccessEntryOption();
			List<Integer> entryIds = new ArrayList<Integer>();
			entryIds.add(entryId);
			option.setEntryIds(entryIds);

			BrokerAccessEntryPage page = null;

			try {
				page = mBrokerDaoServiceStub.reqBrokerAccessEntry(RandomUtils.nextInt(), TIME_OUT, option, 0, 1);
			} catch (ErrorInfo e) {
				e.printStackTrace();
				result.setErrorCode(e.getErrorCode());
				result.setErrorMsg(e.getErrorMsg());
			}

			// AppLog.i("SledBrokerAccessAdmin ---- addCustomInfo ----
			// page.getPageSize() : " + page.getPageSize());
			if (page == null || page.getPageSize() < 1) {
				result.setErrorCode(2);
				result.setErrorMsg("接入详情查询错误，删除失败");
				echoJson(result);
				return;
			}
			BrokerAccessEntry brokerAccessEntry = page.getPage().get(0);

			Map<String, String> customInfoMap = brokerAccessEntry.getCustomInfoMap();
			customInfoMap.put(customInfoKey, customInfoValue);
			brokerAccessEntry.setCustomInfoMap(customInfoMap);

			// Set edit status
			brokerAccessEntry.setStatus(BrokerAccessStatus.EDIT);
			
			try {
				mBrokerDaoServiceStub.updateBrokerAccessEntry(RandomUtils.nextInt(), TIME_OUT, brokerAccessEntry);
			} catch (ErrorInfo e) {
				e.printStackTrace();
				result.setErrorCode(e.getErrorCode());
				result.setErrorMsg(e.getErrorMsg());
			}
		}
		echoJson(result);
	}

	public void removeCustomInfo() throws TException, IOException {
		ErrorResult result = new ErrorResult();
		result.setErrorCode(0);

		int entryId = parameter("entryId", 0);
		String customInfoKey = parameter("customInfoKey", "");
		String customInfoValue = parameter("customInfoValue", "");
		AppLog.i("SledBrokerAccessAdmin ---- removeCustomInfo ---- entryId : " + entryId + ", customInfoKey : "
				+ customInfoKey + ", customInfoValue : " + customInfoValue);

		if (entryId > 0 && !customInfoKey.isEmpty()) {
			if (mBrokerDaoServiceStub == null) {
				mBrokerDaoServiceStub = new BrokerDaoServiceStub();
			}

			ReqBrokerAccessEntryOption option = new ReqBrokerAccessEntryOption();
			List<Integer> entryIds = new ArrayList<Integer>();
			entryIds.add(entryId);
			option.setEntryIds(entryIds);

			BrokerAccessEntryPage page = null;

			try {
				page = mBrokerDaoServiceStub.reqBrokerAccessEntry(RandomUtils.nextInt(), TIME_OUT, option, 0, 1);
			} catch (ErrorInfo e) {
				e.printStackTrace();
				result.setErrorCode(e.getErrorCode());
				result.setErrorMsg(e.getErrorMsg());
			}

			if (page == null || page.getPageSize() < 1) {
				result.setErrorCode(2);
				result.setErrorMsg("接入详情查询错误，删除失败");
				echoJson(result);
				return;
			}
			BrokerAccessEntry brokerAccessEntry = page.getPage().get(0);

			Map<String, String> customInfoMap = brokerAccessEntry.getCustomInfoMap();
			if (customInfoMap.containsKey(customInfoKey)) {
				if (customInfoMap.get(customInfoKey).equals(customInfoValue)) {
					customInfoMap.remove(customInfoKey);

					AppLog.i("SledBrokerAccessAdmin ---- removeCustomInfo ---- customInfoKey : " + customInfoKey
							+ ", containsKey : " + customInfoMap.containsKey(customInfoKey));

					brokerAccessEntry.setCustomInfoMap(customInfoMap);

					// Set edit status
					brokerAccessEntry.setStatus(BrokerAccessStatus.EDIT);
					
					try {
						mBrokerDaoServiceStub.updateBrokerAccessEntry(RandomUtils.nextInt(), TIME_OUT,
								brokerAccessEntry);
					} catch (ErrorInfo e) {
						e.printStackTrace();
						result.setErrorCode(e.getErrorCode());
						result.setErrorMsg(e.getErrorMsg());
					}
					echoJson(result);
					return;
				}
			}
			result.setErrorCode(3);
			result.setErrorMsg("没有该KEY，或VALUE不对应，删除失败");
			echoJson(result);
			return;
		} else {
			result.setErrorCode(2);
			result.setErrorMsg("读取entryId或key值失败，删除失败");
			echoJson(result);
		}
	}
	
	public void updateAccessName() throws TException, IOException {
		ErrorResult result = new ErrorResult();
		result.setErrorCode(0);

		int entryId = parameter("entryId", 0);
		String accessName = parameter("accessName", "");
		AppLog.i("SledBrokerAccessAdmin ---- updateAccessName ---- entryId : " + entryId + ", accessName : " + accessName);

		if (entryId > 0 && !accessName.isEmpty()) {
			if (mBrokerDaoServiceStub == null) {
				mBrokerDaoServiceStub = new BrokerDaoServiceStub();
			}

			ReqBrokerAccessEntryOption option = new ReqBrokerAccessEntryOption();
			List<Integer> entryIds = new ArrayList<Integer>();
			entryIds.add(entryId);
			option.setEntryIds(entryIds);

			BrokerAccessEntryPage page = null;

			try {
				page = mBrokerDaoServiceStub.reqBrokerAccessEntry(RandomUtils.nextInt(), TIME_OUT, option, 0, 1);
			} catch (ErrorInfo e) {
				e.printStackTrace();
				result.setErrorCode(e.getErrorCode());
				result.setErrorMsg(e.getErrorMsg());
			}

			if (page == null || page.getPageSize() < 1) {
				result.setErrorCode(2);
				result.setErrorMsg("接入详情查询错误，修改失败");
				echoJson(result);
				return;
			}
			BrokerAccessEntry brokerAccessEntry = page.getPage().get(0);

			// Set edit status
			brokerAccessEntry.setStatus(BrokerAccessStatus.EDIT);
			brokerAccessEntry.setAccessName(accessName);
			
			try {
				mBrokerDaoServiceStub.updateBrokerAccessEntry(RandomUtils.nextInt(), TIME_OUT, brokerAccessEntry);
			} catch (ErrorInfo e) {
				e.printStackTrace();
				result.setErrorCode(e.getErrorCode());
				result.setErrorMsg(e.getErrorMsg());
			}
			echoJson(result);
			return;
		} else {
			result.setErrorCode(2);
			result.setErrorMsg("读取entryId或当前席名称失败，修改失败");
			echoJson(result);
		}
	}

	public void addBrokerAccessEntry() throws TException, IOException {
		ErrorResult result = new ErrorResult();
		result.setErrorCode(0);

		int brokerId = parameter("brokerId", 0);
		String platform = parameter("platform", "");
		String accessName = parameter("accessName", "");
		
		AppLog.i("SledBrokerAccessAdmin ---- addBrokerAccessEntry ---- brokerId : " + brokerId + ", platform : " + platform);

		if (brokerId > 0 && !platform.isEmpty()) {
			if (mBrokerDaoServiceStub == null) {
				mBrokerDaoServiceStub = new BrokerDaoServiceStub();
			}
			
			BrokerAccessEntryPage page = null;
			
			try {
				page = _queryBrokerAccessEntryByBrokerIdAndPlatform(brokerId, platform);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			BrokerAccessEntry brokerAccessEntry = new BrokerAccessEntry();
			
			brokerAccessEntry.setBrokerId(brokerId);
			brokerAccessEntry.setPlatform(BrokerPlatform.valueOf(platform));
			
			AppLog.i("SledBrokerAccessAdmin ---- addBrokerAccessEntry ---- page.getTotal() : " + page.getTotal());
			if (accessName != null && !accessName.isEmpty()) {
				brokerAccessEntry.setAccessName(accessName);
			} else {
				if (page == null || page.getTotal() > 0) {
					brokerAccessEntry.setAccessName(ChineseNumUtil.numberToChinese(page.getTotal()) + "席");
				} else {
					brokerAccessEntry.setAccessName("主席");
				}
			}
			
			try {
				mBrokerDaoServiceStub.addBrokerAccessEntry(RandomUtils.nextInt(), TIME_OUT, brokerAccessEntry);
			} catch (ErrorInfo e) {
				e.printStackTrace();
				result.setErrorCode(e.getErrorCode());
				result.setErrorMsg(e.getErrorMsg());
			}
			echoJson(result);
		} else {
			result.setErrorCode(2);
			result.setErrorMsg("读取brokerId或平台失败，添加失败");
			echoJson(result);
		}
	}
	
	public void removeAccessEntry() throws TException, IOException {
		ErrorResult result = new ErrorResult();
		result.setErrorCode(0);

		int entryId = parameter("entryId", 0);
		AppLog.i("SledBrokerAccessAdmin ---- updateAccessName ---- entryId : " + entryId);

		if (entryId > 0) {
			if (mBrokerDaoServiceStub == null) {
				mBrokerDaoServiceStub = new BrokerDaoServiceStub();
			}

			try {
				mBrokerDaoServiceStub.removeBrokerAccessEntry(RandomUtils.nextInt(), TIME_OUT, entryId);
			} catch (ErrorInfo e) {
				e.printStackTrace();
				result.setErrorCode(e.getErrorCode());
				result.setErrorMsg(e.getErrorMsg());
			}
			echoJson(result);
			return;
		} else {
			result.setErrorCode(2);
			result.setErrorMsg("读取entryId失败，修改失败");
			echoJson(result);
		}
	}
	
	public void validate() throws TException, IOException {
		ErrorResult result = new ErrorResult();
		result.setErrorCode(0);

		int entryId = parameter("entryId", 0);

		if (entryId > 0) {
			if (mBrokerDaoServiceStub == null) {
				mBrokerDaoServiceStub = new BrokerDaoServiceStub();
			}

			ReqBrokerAccessEntryOption option = new ReqBrokerAccessEntryOption();
			List<Integer> entryIds = new ArrayList<Integer>();
			entryIds.add(entryId);
			option.setEntryIds(entryIds);

			BrokerAccessEntryPage page = null;

			try {
				page = mBrokerDaoServiceStub.reqBrokerAccessEntry(RandomUtils.nextInt(), TIME_OUT, option, 0, 1);
			} catch (ErrorInfo e) {
				e.printStackTrace();
				result.setErrorCode(e.getErrorCode());
				result.setErrorMsg(e.getErrorMsg());
			}

			if (page == null || page.getPageSize() < 1) {
				result.setErrorCode(2);
				result.setErrorMsg("接入详情查询错误，验证失败");
				echoJson(result);
				return;
			}
			BrokerAccessEntry brokerAccessEntry = page.getPage().get(0);

			brokerAccessEntry.setStatus(BrokerAccessStatus.VERIFIED_CORRECT);

			try {
				mBrokerDaoServiceStub.updateBrokerAccessEntry(RandomUtils.nextInt(), TIME_OUT, brokerAccessEntry);
			} catch (ErrorInfo e) {
				e.printStackTrace();
				result.setErrorCode(e.getErrorCode());
				result.setErrorMsg(e.getErrorMsg());
			}
			echoJson(result);
			return;
		} else {
			result.setErrorCode(2);
			result.setErrorMsg("读取entryId出错，验证失败");
			echoJson(result);
		}
	}

	public void sync() throws TException, IOException {
		ErrorResult result = new ErrorResult();
		result.setErrorCode(0);

		int entryId = parameter("entryId", 0);
		AppLog.i("SledBrokerAccessAdmin ---- sync ---- entryId : " + entryId);
		if (entryId > 0) {
			if (mBrokerDaoServiceStub == null) {
				mBrokerDaoServiceStub = new BrokerDaoServiceStub();
			}

			try {
				mBrokerDaoServiceStub.syncBrokerAccessEntry(RandomUtils.nextInt(), TIME_OUT, entryId);
			} catch (ErrorInfo e) {
				e.printStackTrace();
				result.setErrorCode(e.getErrorCode());
				result.setErrorMsg(e.getErrorMsg());
			}

		} else {
			result.setErrorCode(2);
			result.setErrorMsg("读取entryId出错，验证失败");
		}
		echoJson(result);
	}

	public void recover() throws TException, IOException {
		ErrorResult result = new ErrorResult();
		result.setErrorCode(0);

		int entryId = parameter("entryId", 0);

		if (entryId > 0) {
			if (mBrokerDaoServiceStub == null) {
				mBrokerDaoServiceStub = new BrokerDaoServiceStub();
			}

			try {
				mBrokerDaoServiceStub.reqWorkingBrokerAccessEntry(RandomUtils.nextInt(), TIME_OUT, entryId);
			} catch (ErrorInfo e) {
				e.printStackTrace();
				result.setErrorCode(e.getErrorCode());
				result.setErrorMsg(e.getErrorMsg());
			}
		} else {
			result.setErrorCode(2);
			result.setErrorMsg("读取entryId出错，验证失败");
		}
		echoJson(result);
	}
	
	public void updateTechPlatformEnv() throws TException, IOException {
		ErrorResult result = new ErrorResult();
		result.setErrorCode(0);

		int entryId = parameter("entryId", 0);
		String techPlatformEnv = parameter("techPlatformEnv", "");
		AppLog.i("SledBrokerAccessAdmin ---- removeCustomInfo ---- entryId : " + entryId + ", techPlatformEnv : " + techPlatformEnv);

		if (entryId > 0 && !techPlatformEnv.isEmpty()) {
			if (mBrokerDaoServiceStub == null) {
				mBrokerDaoServiceStub = new BrokerDaoServiceStub();
			}

			ReqBrokerAccessEntryOption option = new ReqBrokerAccessEntryOption();
			List<Integer> entryIds = new ArrayList<Integer>();
			entryIds.add(entryId);
			option.setEntryIds(entryIds);

			BrokerAccessEntryPage page = null;

			try {
				page = mBrokerDaoServiceStub.reqBrokerAccessEntry(RandomUtils.nextInt(), TIME_OUT, option, 0, 1);
			} catch (ErrorInfo e) {
				e.printStackTrace();
				result.setErrorCode(e.getErrorCode());
				result.setErrorMsg(e.getErrorMsg());
			}

			if (page == null || page.getPageSize() < 1) {
				result.setErrorCode(2);
				result.setErrorMsg("接入详情查询错误，修改失败");
				echoJson(result);
				return;
			}
			BrokerAccessEntry brokerAccessEntry = page.getPage().get(0);
			
			brokerAccessEntry.setTechPlatformEnv(TechPlatformEnv.valueOf(techPlatformEnv));

			// Set edit status
			brokerAccessEntry.setStatus(BrokerAccessStatus.EDIT);
			
			try {
				mBrokerDaoServiceStub.updateBrokerAccessEntry(RandomUtils.nextInt(), TIME_OUT, brokerAccessEntry);
			} catch (ErrorInfo e) {
				e.printStackTrace();
				result.setErrorCode(e.getErrorCode());
				result.setErrorMsg(e.getErrorMsg());
			}
			echoJson(result);
		} else {
			result.setErrorCode(2);
			result.setErrorMsg("读取entryId或技术平台环境值失败，修改失败");
			echoJson(result);
		}
	}

	private boolean isIpValid(String ipStr) {
		if (ipStr.length() < 7 || ipStr.length() > 15 || "".equals(ipStr)) {
			return false;
		}
		/**
		 * 判断IP格式和范围
		 */
		String rexp = "([1-9]|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3}";
		Pattern pat = Pattern.compile(rexp);
		Matcher mat = pat.matcher(ipStr);
		boolean ipAddress = mat.find();
		return ipAddress;
	}

	private void queryBrokerAccessEntryByEntryId(int entryId) throws TException {

		if (mBrokerDaoServiceStub == null) {
			mBrokerDaoServiceStub = new BrokerDaoServiceStub();
		}
		ReqBrokerAccessEntryOption option = new ReqBrokerAccessEntryOption();
		List<Integer> entryIds = new ArrayList<Integer>();
		entryIds.add(entryId);
		option.setEntryIds(entryIds);

		BrokerAccessEntryPage page = mBrokerDaoServiceStub.reqBrokerAccessEntry(RandomUtils.nextInt(), TIME_OUT, option, 0, 1);

		if (page != null && page.getPageSize() > 0) {
			// TODO : get brokerAccessList
			LocalBrokerAccessEntry localBrokerAccessEntry = transferToLocalBrokerAccessEntry(page.getPage().get(0));
			
			page = _queryBrokerAccessEntryByBrokerIdAndPlatform(localBrokerAccessEntry.getBrokerId(), localBrokerAccessEntry.getPlatform());
			
			List<LocalSimpleBrokerAccessEntry> brokerAccessEntryList = new ArrayList<LocalSimpleBrokerAccessEntry>();
			
			AppLog.i("SledBrokerAccessAdmin ---- queryBrokerAccessEntryByEntryId ---- page.getPage() : " + page.getPage());
			
			for (BrokerAccessEntry brokerAccessEntry : page.getPage()) {
				LocalSimpleBrokerAccessEntry localSimpleBrokerAccessEntry = new LocalSimpleBrokerAccessEntry();
				localSimpleBrokerAccessEntry.setEntryId(brokerAccessEntry.getEntryId());
				localSimpleBrokerAccessEntry.setAccessName(brokerAccessEntry.getAccessName());
				brokerAccessEntryList.add(localSimpleBrokerAccessEntry);
			}
			localBrokerAccessEntry.setBrokerAccessEntryList(brokerAccessEntryList);
			
			put("brokerAccessEntry", localBrokerAccessEntry);
			put("platform", localBrokerAccessEntry.getPlatform());
		}
	}
	
	private BrokerAccessEntryPage _queryBrokerAccessEntryByBrokerIdAndPlatform(int brokerId, String platform) throws TException {
		if (mBrokerDaoServiceStub == null) {
			mBrokerDaoServiceStub = new BrokerDaoServiceStub();
		}
		ReqBrokerAccessEntryOption option = new ReqBrokerAccessEntryOption();
		List<Integer> brokerIds = new ArrayList<Integer>();
		brokerIds.add(brokerId);
		option.setBrokerIds(brokerIds);
		option.setPlatform(BrokerPlatform.valueOf(platform));

		BrokerAccessEntryPage page = mBrokerDaoServiceStub.reqBrokerAccessEntry(RandomUtils.nextInt(), TIME_OUT, option, 0, ACCESS_ENTRY_PAGE_SIZE);
		return page;
	}
	
	private void queryBrokerAccessEntryByBrokerIdAndPlatform(int brokerId, String platform) throws TException {

		BrokerAccessEntryPage page = _queryBrokerAccessEntryByBrokerIdAndPlatform(brokerId, platform);
		
		if (page != null && page.getPageSize() > 0) {
			LocalBrokerAccessEntry localBrokerAccessEntry = transferToLocalBrokerAccessEntry(page.getPage().get(0));
			List<LocalSimpleBrokerAccessEntry> brokerAccessEntryList = new ArrayList<LocalSimpleBrokerAccessEntry>();
			for (BrokerAccessEntry brokerAccessEntry : page.getPage()) {
				LocalSimpleBrokerAccessEntry localSimpleBrokerAccessEntry = new LocalSimpleBrokerAccessEntry();
				localSimpleBrokerAccessEntry.setEntryId(brokerAccessEntry.getEntryId());
				localSimpleBrokerAccessEntry.setAccessName(brokerAccessEntry.getAccessName());
				brokerAccessEntryList.add(localSimpleBrokerAccessEntry);
			}
			localBrokerAccessEntry.setBrokerAccessEntryList(brokerAccessEntryList);
			put("brokerAccessEntry", localBrokerAccessEntry);
			put("platform", localBrokerAccessEntry.getPlatform());
		}
	}

	private LocalBrokerAccessEntry transferToLocalBrokerAccessEntry(BrokerAccessEntry brokerAccessEntry) {
		LocalBrokerAccessEntry localBrokerAccessEntry = new LocalBrokerAccessEntry();
		AppLog.i("SledBrokerAccessAdmin ---- transferToLocalBrokerAccessEntry ---- brokerAccessEntry.getEntryId() : "
				+ brokerAccessEntry.getEntryId());
		localBrokerAccessEntry.setEntryId(brokerAccessEntry.getEntryId());
		localBrokerAccessEntry.setBrokerId(brokerAccessEntry.getBrokerId());
		localBrokerAccessEntry.setPlatform(brokerAccessEntry.getPlatform().name());
		localBrokerAccessEntry.setStatus(brokerAccessEntry.getStatus().name());
		localBrokerAccessEntry.setWorkingStatus(brokerAccessEntry.getWorkingStatus().name());
		localBrokerAccessEntry.setCustomInfoMap(brokerAccessEntry.getCustomInfoMap());
		localBrokerAccessEntry.setTechPlatformEnv(brokerAccessEntry.getTechPlatformEnv().name());
		localBrokerAccessEntry.setAccessName(brokerAccessEntry.getAccessName());

		AppLog.i("SledBrokerAccessAdmin ---- transferToLocalBrokerAccessEntry ---- brokerAccessEntry.getAccessName() : " + brokerAccessEntry.getAccessName());
		
		List<LocalAccessAddress> localTradeAddressList = new ArrayList<LocalAccessAddress>();
		for (AccessAddress accessAddress : brokerAccessEntry.getTradeAddresses()) {
			LocalAccessAddress localTradeAddress = new LocalAccessAddress();
			localTradeAddress.setAddress(accessAddress.getAddress());
			localTradeAddress.setPort(accessAddress.getPort());
			localTradeAddressList.add(localTradeAddress);
			AppLog.i("SledBrokerAccessAdmin ---- transferToLocalBrokerAccessEntry ---- accessAddress.getTradeAddresses() : " + accessAddress.getAddress());
		}
		localBrokerAccessEntry.setTradeAddressList(localTradeAddressList);
		
		List<LocalAccessAddress> localQuotaAddressList = new ArrayList<LocalAccessAddress>();
		for (AccessAddress accessAddress : brokerAccessEntry.getQuotaAddresses()) {
			LocalAccessAddress localQuotaAddress = new LocalAccessAddress();
			localQuotaAddress.setAddress(accessAddress.getAddress());
			localQuotaAddress.setPort(accessAddress.getPort());
			localQuotaAddressList.add(localQuotaAddress);
			AppLog.i("SledBrokerAccessAdmin ---- transferToLocalBrokerAccessEntry ---- accessAddress.getQuotaAddresses() : " + accessAddress.getAddress());
		}
		localBrokerAccessEntry.setQuotaAddressList(localQuotaAddressList);

		return localBrokerAccessEntry;
	}
}
