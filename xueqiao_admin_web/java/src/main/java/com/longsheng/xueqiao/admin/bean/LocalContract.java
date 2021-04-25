package com.longsheng.xueqiao.admin.bean;

import java.util.ArrayList;
import java.util.List;

import com.longsheng.xueqiao.admin.util.TimeFormator;
import com.longsheng.xueqiao.contract.thriftapi.SledContractEdit;

public class LocalContract {

	private int sledContractId;
	private int sledCommodityId;
	private String sledContractCode;
	private List<Integer> relateContractIds;
	private String sledTag;
	private String contractEngName;
	private String contractCnName;
	private String contractTcName;
	private String contractExpDate;
	private String lastTradeDate;
	private String firstNoticeDate;
	private String platformEnv;
	private String contractStatus;

	private String editStatus;
	private String workingStatus;

	public int getSledContractId() {
		return sledContractId;
	}

	public void setSledContractId(int sledContractId) {
		this.sledContractId = sledContractId;
	}

	public int getSledCommodityId() {
		return sledCommodityId;
	}

	public void setSledCommodityId(int sledCommodityId) {
		this.sledCommodityId = sledCommodityId;
	}

	public String getSledContractCode() {
		return sledContractCode;
	}

	public void setSledContractCode(String sledContractCode) {
		this.sledContractCode = sledContractCode;
	}

	public List<Integer> getRelateContractIds() {
		return relateContractIds;
	}

	public void setRelateContractIds(List<Integer> relateContractIds) {
		this.relateContractIds = relateContractIds;
	}

	public String getSledTag() {
		return sledTag;
	}

	public void setSledTag(String sledTag) {
		this.sledTag = sledTag;
	}

	public String getContractEngName() {
		return contractEngName;
	}

	public void setContractEngName(String contractEngName) {
		this.contractEngName = contractEngName;
	}

	public String getContractCnName() {
		return contractCnName;
	}

	public void setContractCnName(String contractCnName) {
		this.contractCnName = contractCnName;
	}

	public String getContractTcName() {
		return contractTcName;
	}

	public void setContractTcName(String contractTcName) {
		this.contractTcName = contractTcName;
	}

	public String getContractExpDate() {
		return contractExpDate;
	}

	public void setContractExpDate(String contractExpDate) {
		this.contractExpDate = contractExpDate;
	}

	public String getLastTradeDate() {
		return lastTradeDate;
	}

	public void setLastTradeDate(String lastTradeDate) {
		this.lastTradeDate = lastTradeDate;
	}

	public String getFirstNoticeDate() {
		return firstNoticeDate;
	}

	public void setFirstNoticeDate(String firstNoticeDate) {
		this.firstNoticeDate = firstNoticeDate;
	}

	public String getPlatformEnv() {
		return platformEnv;
	}

	public void setPlatformEnv(String platformEnv) {
		this.platformEnv = platformEnv;
	}

	public String getContractStatus() {
		return contractStatus;
	}

	public void setContractStatus(String contractStatus) {
		this.contractStatus = contractStatus;
	}

	public String getEditStatus() {
		return editStatus;
	}

	public void setEditStatus(String editStatus) {
		this.editStatus = editStatus;
	}

	public String getWorkingStatus() {
		return workingStatus;
	}

	public void setWorkingStatus(String workingStatus) {
		this.workingStatus = workingStatus;
	}

	public static List<LocalContract> transferToLocalContractList(List<SledContractEdit> sledContractEditList) {
		List<LocalContract> LocalContractList = new ArrayList<LocalContract>();
		for (SledContractEdit contractEdit : sledContractEditList) {
			LocalContractList.add(transferToLocalContract(contractEdit));
		}
		return LocalContractList;
	}
	
	public static LocalContract transferToLocalContract(SledContractEdit sledContractEdit) {
		LocalContract localContract = new LocalContract();
		
		localContract.setSledContractId(sledContractEdit.getSledContract().getSledContractId());
		localContract.setSledCommodityId(sledContractEdit.getSledContract().getSledCommodityId());
		localContract.setSledContractCode(sledContractEdit.getSledContract().getSledContractCode());
		localContract.setRelateContractIds(sledContractEdit.getSledContract().getRelateContractIds());
		localContract.setSledTag(sledContractEdit.getSledContract().getSledTag());
		localContract.setContractEngName(sledContractEdit.getSledContract().getContractEngName());
		localContract.setContractCnName(sledContractEdit.getSledContract().getContractCnName());
		localContract.setContractTcName(sledContractEdit.getSledContract().getContractTcName());
		localContract.setContractExpDate(TimeFormator.timeStampToDate2(sledContractEdit.getSledContract().getContractExpDate()));
		localContract.setLastTradeDate(TimeFormator.timeStampToDate2(sledContractEdit.getSledContract().getLastTradeDate()));
		localContract.setFirstNoticeDate(TimeFormator.timeStampToDate2(sledContractEdit.getSledContract().getFirstNoticeDate()));
		localContract.setPlatformEnv(sledContractEdit.getSledContract().getPlatformEnv().name());
		localContract.setContractStatus(sledContractEdit.getSledContract().getContractStatus().name());
		
		localContract.setEditStatus(sledContractEdit.getEditStatus().name());
		localContract.setWorkingStatus(sledContractEdit.getWorkingStatus().name());
		
		return localContract;
	}
}
