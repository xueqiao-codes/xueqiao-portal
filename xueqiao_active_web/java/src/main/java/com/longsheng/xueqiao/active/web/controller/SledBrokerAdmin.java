package com.longsheng.xueqiao.active.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.apache.thrift.TException;
import org.soldier.base.StringFactory;
import org.soldier.base.logger.AppLog;
import org.soldier.platform.svr_platform.comm.ErrorInfo;
import org.soldier.platform.web_framework.model.ErrorResult;
import org.soldier.platform.web_framework.util.GsonFactory;

import com.longsheng.xueqiao.active.bean.LocalBrokerEntry;
import com.longsheng.xueqiao.broker.dao.thriftapi.BrokerAccessEntryPage;
import com.longsheng.xueqiao.broker.dao.thriftapi.BrokerEntryPage;
import com.longsheng.xueqiao.broker.dao.thriftapi.ReqBrokerAccessEntryOption;
import com.longsheng.xueqiao.broker.dao.thriftapi.ReqBrokerEntryOption;
import com.longsheng.xueqiao.broker.dao.thriftapi.client.BrokerDaoServiceStub;
import com.longsheng.xueqiao.broker.thriftapi.BrokerAccessEntry;
import com.longsheng.xueqiao.broker.thriftapi.BrokerEntry;
import com.longsheng.xueqiao.broker.thriftapi.BrokerPlatform;

public class SledBrokerAdmin extends OaAuthController {

	private static final int TIME_OUT = 3000;
	private static final int PAGE_SIZE = 50;
	
	private BrokerDaoServiceStub mBrokerDaoServiceStub = new BrokerDaoServiceStub();
	
	private int mTotalPage = 1;

	public void show() throws Exception {

		int requestPage = parameter("requestPage", 1);
		int brokerId = parameter("brokerId", 0);
		String engName = parameter("engName", "");
		String cnName = parameter("cnName", "");
		String brokerPlatform = parameter("brokerPlatform", "");
		if (requestPage < 1) {
			requestPage = 1;
		}
		if (brokerPlatform != null && !brokerPlatform.isEmpty()) {
			requestPage = queryBrokerEntryListByPlatform(requestPage - 1, brokerPlatform);
		} else {
			requestPage = queryBrokerEntryList(requestPage - 1, brokerId, engName, cnName);
		}
		put("currentPage", requestPage + 1);
		
		if (mTotalPage < 1) {
			mTotalPage = 1;
		}
		put("totalPage", mTotalPage);
		setBaseQueryUrl();
		// brokerEntryList
		render("sled_broker_admin.html");
	}

	public void addBrokerEntry() throws ErrorInfo, TException, IOException {
		ErrorResult result = new ErrorResult();
		String content = StringFactory.newUtf8String(IOUtils.toByteArray(getServletRequest().getInputStream()));
		AppLog.i("SledBrokerAdmin ---- addBroker ---- content : " + content);
		
		LocalBrokerEntry localBrokerEntry = GsonFactory.getGson().fromJson(content, LocalBrokerEntry.class);
		
		BrokerEntry brokerEntry = new BrokerEntry();
		brokerEntry.setEngName(localBrokerEntry.getEngName());
		brokerEntry.setCnName(localBrokerEntry.getCnName());
		brokerEntry.setNote(localBrokerEntry.getNote());
		
		if (mBrokerDaoServiceStub == null) {
			mBrokerDaoServiceStub = new BrokerDaoServiceStub();
		}
		
		int brokerIdResult = 0;
		try {
			brokerIdResult = mBrokerDaoServiceStub.addBrokerEntry(RandomUtils.nextInt(), TIME_OUT, brokerEntry);
		} catch (ErrorInfo errorInfo) {
			errorInfo.printStackTrace();
			result.setErrorCode(errorInfo.getErrorCode());
			result.setErrorMsg(errorInfo.getErrorCode() + " : " + errorInfo.getErrorMsg());
		}
		
		if (brokerIdResult > 0) {
			for (String platform : localBrokerEntry.getPlatforms()) {
				if (platform != null && !platform.isEmpty()) {
					try {
						addBrokerAccessEntry(brokerIdResult, BrokerPlatform.valueOf(platform));
					} catch (ErrorInfo errorInfo) {
						errorInfo.printStackTrace();
						result.setErrorCode(errorInfo.getErrorCode());
						result.setErrorMsg(errorInfo.getErrorCode() + " : " + errorInfo.getErrorMsg());
					}
				}
			}
		}
		echoJson(result);
	}
	
	public void getBrokerEntry() throws ErrorInfo, TException, IOException {
		int brokerId = parameter("brokerId", -1);

		if (brokerId > 0) {
			
			ReqBrokerEntryOption option = new ReqBrokerEntryOption();
			List<Integer> brokerIds = new ArrayList<Integer>();
			brokerIds.add(brokerId);
			option.setBrokerIds(brokerIds);

			if (mBrokerDaoServiceStub == null) {
				mBrokerDaoServiceStub = new BrokerDaoServiceStub();
			}

			BrokerEntryPage brokerEntryPage = mBrokerDaoServiceStub.reqBrokerEntry(RandomUtils.nextInt(), TIME_OUT, option, 0, 1);
			
			if (brokerEntryPage.getPageSize() > 0) {
				BrokerEntry brokerEntry = brokerEntryPage.getPage().get(0);
				LocalBrokerEntry localBrokerEntry = new LocalBrokerEntry();
				localBrokerEntry.setBrokerId(brokerEntry.getBrokerId());
				localBrokerEntry.setEngName(brokerEntry.getEngName());
				localBrokerEntry.setCnName(brokerEntry.getCnName());
				localBrokerEntry.setNote(brokerEntry.getNote());
				localBrokerEntry.setPlatforms(getBrokerPlatformList(brokerEntry.getBrokerId()));
				echoJson(localBrokerEntry);
			}
		}
	}
	
	public void modifyBrokerEntry() throws ErrorInfo, TException, IOException {
		ErrorResult result = new ErrorResult();
		String content = StringFactory.newUtf8String(IOUtils.toByteArray(getServletRequest().getInputStream()));
		AppLog.i("SledBrokerAdmin ---- modifyBrokerEntry ---- content : " + content);
		
		LocalBrokerEntry localBrokerEntry = GsonFactory.getGson().fromJson(content, LocalBrokerEntry.class);
		
		if (localBrokerEntry.getBrokerId() <= 0) {
			result.setErrorCode(401);
			result.setErrorMsg("获取的brokerId不正确：" + localBrokerEntry.getBrokerId());
			echoJson(result);
			return;
		}
		
		BrokerEntry brokerEntry = new BrokerEntry();
		brokerEntry.setBrokerId(localBrokerEntry.getBrokerId());
		brokerEntry.setEngName(localBrokerEntry.getEngName());
		brokerEntry.setCnName(localBrokerEntry.getCnName());
		brokerEntry.setNote(localBrokerEntry.getNote());
		
		if (mBrokerDaoServiceStub == null) {
			mBrokerDaoServiceStub = new BrokerDaoServiceStub();
		}
		
		try {
			mBrokerDaoServiceStub.updateBrokerEntry(RandomUtils.nextInt(), TIME_OUT, brokerEntry);
		} catch (ErrorInfo errorInfo) {
			errorInfo.printStackTrace();
			result.setErrorCode(errorInfo.getErrorCode());
			result.setErrorMsg(errorInfo.getErrorCode() + " : " + errorInfo.getErrorMsg());
		}
		ErrorInfo updateBrokerAccessEntryErrorInfo = null;
		try {
			updateBrokerAccessEntryErrorInfo = updateBrokerAccessEntry(localBrokerEntry.getBrokerId(), localBrokerEntry.getPlatforms());
		} catch (ErrorInfo errorInfo) {
			errorInfo.printStackTrace();
			result.setErrorCode(errorInfo.getErrorCode());
			result.setErrorMsg(errorInfo.getErrorCode() + " : " + errorInfo.getErrorMsg());
		}
		
		if (updateBrokerAccessEntryErrorInfo != null) {
			result.setErrorCode(updateBrokerAccessEntryErrorInfo.getErrorCode());
			result.setErrorMsg(updateBrokerAccessEntryErrorInfo.getErrorCode() + " : " + updateBrokerAccessEntryErrorInfo.getErrorMsg());
		}
		
		echoJson(result);
	}
	
	private ErrorInfo updateBrokerAccessEntry(int brokerId, List<String> newPlatformList) throws ErrorInfo, TException {

		ErrorInfo errorInfo = null;
		
		ReqBrokerAccessEntryOption option = new ReqBrokerAccessEntryOption();
		List<Integer> brokerIds = new ArrayList<Integer>();
		brokerIds.add(brokerId);
		option.setBrokerIds(brokerIds);
		
		if (mBrokerDaoServiceStub == null) {
			mBrokerDaoServiceStub = new BrokerDaoServiceStub();
		}
		
		BrokerAccessEntryPage originalbrokerAccessEntryPage = mBrokerDaoServiceStub.reqBrokerAccessEntry(RandomUtils.nextInt(), TIME_OUT, option, 0, 10);
		
		if (originalbrokerAccessEntryPage != null) {
			//remove
			for (BrokerAccessEntry originalbrokerAccessEntry : originalbrokerAccessEntryPage.getPage()) {
				String platform = originalbrokerAccessEntry.getPlatform().name();
				if (!isInNewPlatformList(platform, newPlatformList)) {
					try {
						removeBrokerAccessEntry(originalbrokerAccessEntry.getEntryId());
					} catch (ErrorInfo e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						errorInfo = e;
					}
				}
			}
			//add
			for (String newPlatform : newPlatformList) {
				if (!newPlatform.isEmpty() && !isInOrignalAccessEntryList(newPlatform, originalbrokerAccessEntryPage.getPage())) {
					addBrokerAccessEntry(brokerId, BrokerPlatform.valueOf(newPlatform));
				}
			}
		}
		return errorInfo;
	}
	
	private boolean isInNewPlatformList(String item, List<String> newPlatformList) {
		boolean isIn = false;
		for (String newPlatform : newPlatformList) {
			if (!newPlatform.isEmpty() && newPlatform.equals(item)) {
				isIn = true;
				break;
			}
		}
		return isIn;
	}
	
	private boolean isInOrignalAccessEntryList(String item, List<BrokerAccessEntry> brokerAccessEntryList) {
		boolean isIn = false;
		for (BrokerAccessEntry entry : brokerAccessEntryList) {
			if (item.equals(entry.getPlatform().name())) {
				isIn = true;
				break;
			}
		}
		return isIn;
	}
	
	private void removeBrokerAccessEntry(int brokerAccessEntryId) throws ErrorInfo, TException {
		
		if (mBrokerDaoServiceStub == null) {
			mBrokerDaoServiceStub = new BrokerDaoServiceStub();
		}
		
		mBrokerDaoServiceStub.removeBrokerAccessEntry(RandomUtils.nextInt(), TIME_OUT, brokerAccessEntryId);
	}
	
	private void addBrokerAccessEntry(int brokerId, BrokerPlatform platform) throws ErrorInfo, TException {
		AppLog.i("SledBrokerAdmin ---- addBrokerAccessEntry ---- brokerId : " + brokerId + ", platform : " + platform);
		BrokerAccessEntry brokerAccessEntry = new BrokerAccessEntry();
		brokerAccessEntry.setBrokerId(brokerId);
		brokerAccessEntry.setPlatform(platform);
		
		if (mBrokerDaoServiceStub == null) {
			mBrokerDaoServiceStub = new BrokerDaoServiceStub();
		}
		
		mBrokerDaoServiceStub.addBrokerAccessEntry(RandomUtils.nextInt(), TIME_OUT, brokerAccessEntry);
	}
	
	private void setBaseQueryUrl() {
		StringBuffer baseQueryUrl = new StringBuffer();
		String baseUrl = this.baseUrl;
		int l = baseUrl.indexOf("requestPage");
		if (l > 0) {
			baseUrl = baseUrl.substring(0, l);
		}
		baseQueryUrl.append(baseUrl);
		baseQueryUrl.append("/SledBrokerAdmin/show?");
		put("baseQueryUrl", baseQueryUrl);
	}

	private int queryBrokerEntryList(int pageIndex, int brokerId, String engName, String cnName) throws TException {

		ReqBrokerEntryOption option = new ReqBrokerEntryOption();
		if (brokerId > 0) {
			List<Integer> brokerIds = new ArrayList<Integer>();
			brokerIds.add(brokerId);
			option.setBrokerIds(brokerIds);
		}
		if (engName != null && !engName.isEmpty()) {
			option.setEngNamePartical(engName);
		}
		if (cnName != null && !cnName.isEmpty()) {
			option.setCnNamePartical(cnName);
		}

		if (mBrokerDaoServiceStub == null) {
			mBrokerDaoServiceStub = new BrokerDaoServiceStub();
		}

		BrokerEntryPage brokerEntryPage = mBrokerDaoServiceStub.reqBrokerEntry(RandomUtils.nextInt(), TIME_OUT, option, pageIndex,
				PAGE_SIZE);

		put("brokerEntryList", transferToLocalBrokerEntryList(brokerEntryPage));
		mTotalPage = (brokerEntryPage.getTotal() + PAGE_SIZE - 1) / PAGE_SIZE;
		AppLog.i("SledBrokerAdmin ---- queryBrokerEntryList ---- mTotalPage : " + mTotalPage);
		return pageIndex > mTotalPage ? mTotalPage : pageIndex;
	}
	
	private int queryBrokerEntryListByPlatform(int pageIndex, String platform) throws TException {

		if (mBrokerDaoServiceStub == null) {
			mBrokerDaoServiceStub = new BrokerDaoServiceStub();
		}

		ReqBrokerAccessEntryOption reqBrokerAccessEntryOption = new ReqBrokerAccessEntryOption();
		reqBrokerAccessEntryOption.setPlatform(BrokerPlatform.valueOf(platform));
		BrokerAccessEntryPage brokerAccessEntryPage = mBrokerDaoServiceStub.reqBrokerAccessEntry(RandomUtils.nextInt(), TIME_OUT, reqBrokerAccessEntryOption, pageIndex, PAGE_SIZE);
		
		if (brokerAccessEntryPage != null && brokerAccessEntryPage.getPageSize() > 0) {
			ReqBrokerEntryOption reqBrokerEntryOption = new ReqBrokerEntryOption();
			List<Integer> brokerIds = new ArrayList<Integer>();
			for (BrokerAccessEntry brokerAccessEntry : brokerAccessEntryPage.getPage()) {
				brokerIds.add(brokerAccessEntry.getBrokerId());
			}
			reqBrokerEntryOption.setBrokerIds(brokerIds);
			BrokerEntryPage brokerEntryPage = mBrokerDaoServiceStub.reqBrokerEntry(RandomUtils.nextInt(), TIME_OUT, reqBrokerEntryOption, 0, PAGE_SIZE);
			put("brokerEntryList", transferToLocalBrokerEntryListWithPlatform(brokerEntryPage, platform));
		}

		mTotalPage = (brokerAccessEntryPage.getTotal() + PAGE_SIZE - 1) / PAGE_SIZE;
		return pageIndex > mTotalPage ? mTotalPage : pageIndex;
	}

	private List<LocalBrokerEntry> transferToLocalBrokerEntryList(BrokerEntryPage page) throws ErrorInfo, TException {
		List<LocalBrokerEntry> localBrokerEntryList = new ArrayList<LocalBrokerEntry>();
		for (BrokerEntry brokerEntry : page.getPage()) {
			LocalBrokerEntry localBrokerEntry = new LocalBrokerEntry();
			localBrokerEntry.setBrokerId(brokerEntry.getBrokerId());
			localBrokerEntry.setEngName(brokerEntry.getEngName());
			localBrokerEntry.setCnName(brokerEntry.getCnName());
			localBrokerEntry.setNote(brokerEntry.getNote());
			localBrokerEntry.setPlatforms(getBrokerPlatformList(brokerEntry.getBrokerId()));
			localBrokerEntryList.add(localBrokerEntry);
		}
		return localBrokerEntryList;
	}
	
	private List<LocalBrokerEntry> transferToLocalBrokerEntryListWithPlatform(BrokerEntryPage page, String platform) throws ErrorInfo, TException {
		List<LocalBrokerEntry> localBrokerEntryList = new ArrayList<LocalBrokerEntry>();
		for (BrokerEntry brokerEntry : page.getPage()) {
			LocalBrokerEntry localBrokerEntry = new LocalBrokerEntry();
			localBrokerEntry.setBrokerId(brokerEntry.getBrokerId());
			localBrokerEntry.setEngName(brokerEntry.getEngName());
			localBrokerEntry.setCnName(brokerEntry.getCnName());
			localBrokerEntry.setNote(brokerEntry.getNote());
			List<String> platforms = new ArrayList<String>();
			platforms.add(platform);
			localBrokerEntry.setPlatforms(platforms);
			localBrokerEntryList.add(localBrokerEntry);
		}
		return localBrokerEntryList;
	}

	private List<String> getBrokerPlatformList(int brokerId) throws ErrorInfo, TException {
		List<String> brokerPlatformList = new ArrayList<String>();

		ReqBrokerAccessEntryOption option = new ReqBrokerAccessEntryOption();
		List<Integer> brokerIds = new ArrayList<Integer>();
		brokerIds.add(brokerId);
		option.setBrokerIds(brokerIds);
		
		if (mBrokerDaoServiceStub == null) {
			mBrokerDaoServiceStub = new BrokerDaoServiceStub();
		}
		
		BrokerAccessEntryPage brokerAccessEntryPage = mBrokerDaoServiceStub.reqBrokerAccessEntry(RandomUtils.nextInt(), TIME_OUT, option, 0, 10);
		if (brokerAccessEntryPage != null && brokerAccessEntryPage.getTotal() > 0) {
			for (BrokerAccessEntry brokerAccessEntry : brokerAccessEntryPage.getPage()) {
				String platform = brokerAccessEntry.getPlatform().name();
				if (!brokerPlatformList.contains(platform)) {
					brokerPlatformList.add(platform);
				}
			}
		}
		return brokerPlatformList;
	}

}
