package com.longsheng.xueqiao.active.bean;

import java.util.ArrayList;
import java.util.List;

import org.apache.thrift.TException;
import org.soldier.platform.svr_platform.comm.ErrorInfo;

import com.longsheng.xueqiao.broker.dao.thriftapi.BrokerEntryPage;
import com.longsheng.xueqiao.broker.thriftapi.BrokerEntry;

public class LocalBrokerEntry {
	private int brokerId;
	private String engName;
	private String cnName;
	private String note;
	private List<String> platforms;

	public int getBrokerId() {
		return brokerId;
	}

	public void setBrokerId(int brokerId) {
		this.brokerId = brokerId;
	}

	public String getEngName() {
		return engName;
	}

	public void setEngName(String engName) {
		this.engName = engName;
	}

	public String getCnName() {
		return cnName;
	}

	public void setCnName(String cnName) {
		this.cnName = cnName;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public List<String> getPlatforms() {
		return platforms;
	}

	public void setPlatforms(List<String> platforms) {
		this.platforms = platforms;
	}
	
	public static List<LocalBrokerEntry> transferToLocalBrokerEntryListWithPlatform(BrokerEntryPage page, String platform) throws ErrorInfo, TException {
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
}
