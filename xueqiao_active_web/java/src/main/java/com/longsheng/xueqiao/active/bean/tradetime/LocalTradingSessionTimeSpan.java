package com.longsheng.xueqiao.active.bean.tradetime;

public class LocalTradingSessionTimeSpan {
	private long timeSpanId;
	private int startDay;                       // 星期几, 例如：星期一,对应枚举类型：Days
	private String startTime;                   // 开始时间，HH:mm:ss， 例如 9:00:00
	private int endDay;                         // 星期几, 例如：星期一,对应枚举类型：Days
	private String endTime;                     // 结束时间，HH:mm:ss， 例如 11:30:00

	private String startWeekdayAndTime;
	private String endWeekdayAndTime;

	public long getTimeSpanId() {
		return timeSpanId;
	}

	public void setTimeSpanId(long timeSpanId) {
		this.timeSpanId = timeSpanId;
	}

	public int getStartDay() {
		return startDay;
	}

	public void setStartDay(int startDay) {
		this.startDay = startDay;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public int getEndDay() {
		return endDay;
	}

	public void setEndDay(int endDay) {
		this.endDay = endDay;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getStartWeekdayAndTime() {
		return startWeekdayAndTime;
	}

	public void setStartWeekdayAndTime(String startWeekdayAndTime) {
		this.startWeekdayAndTime = startWeekdayAndTime;
	}

	public String getEndWeekdayAndTime() {
		return endWeekdayAndTime;
	}

	public void setEndWeekdayAndTime(String endWeekdayAndTime) {
		this.endWeekdayAndTime = endWeekdayAndTime;
	}
}
