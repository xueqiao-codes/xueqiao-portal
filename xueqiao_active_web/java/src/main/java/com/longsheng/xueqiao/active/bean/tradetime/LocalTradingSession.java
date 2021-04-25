package com.longsheng.xueqiao.active.bean.tradetime;

import com.google.gson.Gson;

import java.util.List;

public class LocalTradingSession {

	private long tradeSessionId;
	private List<LocalTradingSessionTimeSpan> timeSpans;
	private int timeSystem;                             //时制，对应枚举类型 TimeSystem

	public long getTradeSessionId() {
		return tradeSessionId;
	}

	public void setTradeSessionId(long tradeSessionId) {
		this.tradeSessionId = tradeSessionId;
	}

	public List<LocalTradingSessionTimeSpan> getTimeSpans() {
		return timeSpans;
	}

	public void setTimeSpans(List<LocalTradingSessionTimeSpan> timeSpans) {
		this.timeSpans = timeSpans;
	}

	public int getTimeSystem() {
		return timeSystem;
	}

	public void setTimeSystem(int timeSystem) {
		this.timeSystem = timeSystem;
	}

	public String toString() {
		return new Gson().toJson(this);
	}
}
