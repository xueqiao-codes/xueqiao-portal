package com.longsheng.xueqiao.admin.bean;

public class LocalExchange {

	private int sledExchangeId; // 内部唯一数字id
	private String exchangeMic; // ISO标准的交易所代号，唯一
	private String country; // 交易所所在国家
	private String countryCode; // 国家代号
	private String operatingMic; // 实际发生交易的交易所代号
	private String operatingMicType; // 实际发生交易的交易所归属类型
	private String nameInstitution; // 交易所英文名称
	private String acronym; // 交易所英文简称
	private String city; // 所在城市
	private String website; // 交易所网站
	private String cnName; // 交易所中文名称
	private String cnAcronym; // 交易所中文简称
	private String zoneId; // 所在时区id
	private String activeStartTimestamp; // 生效起始日期
	private String activeEndTimestamp; // 生效结束日期

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

	public String getOperatingMicType() {
		return operatingMicType;
	}

	public void setOperatingMicType(String operatingMicType) {
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

	public String getActiveStartTimestamp() {
		return activeStartTimestamp;
	}

	public void setActiveStartTimestamp(String activeStartTimestamp) {
		this.activeStartTimestamp = activeStartTimestamp;
	}

	public String getActiveEndTimestamp() {
		return activeEndTimestamp;
	}

	public void setActiveEndTimestamp(String activeEndTimestamp) {
		this.activeEndTimestamp = activeEndTimestamp;
	}
}
