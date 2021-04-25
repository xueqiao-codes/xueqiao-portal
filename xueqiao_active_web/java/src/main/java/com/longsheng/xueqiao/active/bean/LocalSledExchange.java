package com.longsheng.xueqiao.active.bean;

import com.longsheng.xueqiao.contract.standard.thriftapi.ExchangeOperatingMicType;
import com.longsheng.xueqiao.contract.standard.thriftapi.SledExchange;

import java.util.ArrayList;
import java.util.List;

public class LocalSledExchange {

	private int sledExchangeId;
	private String exchangeMic;
	private String country;
	private String countryCode;
	private String operatingMic;
	private ExchangeOperatingMicType operatingMicType;
	private String nameInstitution;
	private String acronym;
	private String city;
	private String website;
	private String cnName;
	private String cnAcronym;
	private String zoneId;

	public int getSledExchangeId() {
		return sledExchangeId;
	}

	public void setSledExchangeId(int sledExchangeId) {
		this.sledExchangeId = sledExchangeId;
	}

	public String getExchangeMic() {
		return exchangeMic;
	}

	public void setExchangeMic(String exchangeMic) {
		this.exchangeMic = exchangeMic;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getOperatingMic() {
		return operatingMic;
	}

	public void setOperatingMic(String operatingMic) {
		this.operatingMic = operatingMic;
	}

	public ExchangeOperatingMicType getOperatingMicType() {
		return operatingMicType;
	}

	public void setOperatingMicType(ExchangeOperatingMicType operatingMicType) {
		this.operatingMicType = operatingMicType;
	}

	public String getNameInstitution() {
		return nameInstitution;
	}

	public void setNameInstitution(String nameInstitution) {
		this.nameInstitution = nameInstitution;
	}

	public String getAcronym() {
		return acronym;
	}

	public void setAcronym(String acronym) {
		this.acronym = acronym;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getCnName() {
		return cnName;
	}

	public void setCnName(String cnName) {
		this.cnName = cnName;
	}

	public String getCnAcronym() {
		return cnAcronym;
	}

	public void setCnAcronym(String cnAcronym) {
		this.cnAcronym = cnAcronym;
	}

	public String getZoneId() {
		return zoneId;
	}

	public void setZoneId(String zoneId) {
		this.zoneId = zoneId;
	}

	public static List<LocalSledExchange> transferToLocalExchangeList(List<SledExchange> sledExchangeList) {
		List<LocalSledExchange> localSledExchangeList = new ArrayList<LocalSledExchange>();

		if (sledExchangeList != null && !sledExchangeList.isEmpty()) {
			for (SledExchange sledExchange : sledExchangeList) {
				localSledExchangeList.add(transferToLocalExchange(sledExchange));
			}
		}

		return localSledExchangeList;
	}

	private static LocalSledExchange transferToLocalExchange(SledExchange sledExchange) {
		LocalSledExchange localSledExchange = new LocalSledExchange();

		localSledExchange.setSledExchangeId(sledExchange.getSledExchangeId());
		localSledExchange.setExchangeMic(sledExchange.getExchangeMic());
		localSledExchange.setNameInstitution(sledExchange.getNameInstitution());
		localSledExchange.setAcronym(sledExchange.getAcronym());
		localSledExchange.setCnName(sledExchange.getCnName());
		localSledExchange.setCnAcronym(sledExchange.getCnAcronym());

		return localSledExchange;
	}
}
