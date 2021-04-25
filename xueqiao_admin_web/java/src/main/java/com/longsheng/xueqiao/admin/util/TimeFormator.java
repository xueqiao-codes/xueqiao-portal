package com.longsheng.xueqiao.admin.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class TimeFormator {

	public static String milliSecondsToTimer(long milliseconds) {
		String finalTimerString = "";
		String secondsString = "";

		// Convert total duration into time
		int hours = (int) (milliseconds / (1000 * 60 * 60));
		int minutes = (int) (milliseconds % (1000 * 60 * 60)) / (1000 * 60);
		int seconds = (int) ((milliseconds % (1000 * 60 * 60)) % (1000 * 60) / 1000);
		// Add hours if there
		if (hours > 0) {
			finalTimerString = hours + ":";
		}

		// Prepending 0 to seconds if it is one digit
		if (seconds < 10) {
			secondsString = "0" + seconds;
		} else {
			secondsString = "" + seconds;
		}

		finalTimerString = finalTimerString + minutes + ":" + secondsString;

		// return timer string
		return finalTimerString;
	}
	
	public static String timeStampToTimeDif(long timeStamp) {
		String finalDateString = "";

		// Convert total duration into time
		int timeDif = (int) (System.currentTimeMillis() / 1000 - timeStamp);
		int minute = (int) Math.ceil(timeDif / 60);
		int hour = (int) Math.ceil(timeDif / (60 * 60));
		int day = (int) Math.ceil(timeDif / (60 * 60 * 24));

		if (timeDif <= 0 || minute < 1) {
			finalDateString = "刚刚";
		} else if (minute >= 1 && hour < 1) {
			finalDateString = minute + "分钟前";
		} else if (hour >= 1 && day < 1) {
			finalDateString = hour + "小时前";
		} else if (day >= 1 && day < 4) {
			finalDateString = day + "天前";
		} else {
			finalDateString = timeStampToDate(timeStamp).substring(5, 10);
		}

		// return date string
		return finalDateString;
	}
	
	public static String timeStampToDate(long timeStamp) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
		String dateTime = df.format(timeStamp * 1000);
		
		return dateTime;
	}
	
	public static String timeStampToDate3(long timeStamp) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy.MM.dd HH:mm", Locale.getDefault());
		String dateTime = df.format(timeStamp * 1000);
		
		return dateTime;
	}

	public static String timeStampToDate2(long timeStamp) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
		String dateTime = df.format(timeStamp * 1000);
		
		return dateTime;
	}
	
	public static long dateToTimeStamp(String date) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
		long beginTimeStamp = 0;
		
		try {
			beginTimeStamp = df.parse(date).getTime();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return beginTimeStamp;
	}

	public static long dateToTimeStamp2(String date) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
		long beginTimeStamp = 0;
		
		try {
			beginTimeStamp = df.parse(date).getTime();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return beginTimeStamp / 1000;
	}

	public static long dateToTimeStamp3(String date) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault());
		long beginTimeStamp = 0;

		try {
			beginTimeStamp = df.parse(date).getTime();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return beginTimeStamp;
	}
	
	public static String secondsToDuration(long timeStamp) {
		String finalTimerString = "";

		// Convert total duration into time
		int hours = (int) (timeStamp / (60 * 60));
		int minutes = (int) (timeStamp % (60 * 60) / 60);
		int seconds = (int) ((timeStamp % (60 * 60) % 60 ));
		// Add hours if there
		if (hours > 0) {
			finalTimerString = hours + "时";
		}

		// Add seconds if there
		if (minutes > 0) {
			finalTimerString = finalTimerString + minutes + "分";
		}

		finalTimerString = finalTimerString + seconds + "秒";

		// return timer string
		return finalTimerString;
	}
	
	private static int getYearFromTimeStamp(long timeStamp) {
		int year = Integer.parseInt(timeStampToDate(timeStamp).substring(0, 4));
		return year;
	}
	
	private static int getMonthFromTimeStamp(long timeStamp) {
		int month = Integer.parseInt(timeStampToDate(timeStamp).substring(5, 7));
		return month;
	}
	
	private static int getDayFromTimeStamp(long timeStamp) {
		int day = Integer.parseInt(timeStampToDate(timeStamp).substring(8, 10));
		return day;
	}
	
	public static String timeStampToAge(long timeStamp) {
		int birthdayYear = getYearFromTimeStamp(timeStamp);
		int birthdayMonth = getMonthFromTimeStamp(timeStamp);
		int birthdayDay = getDayFromTimeStamp(timeStamp);
		int currentDateYear = getYearFromTimeStamp(System.currentTimeMillis() / 1000);
		int currentDateMonth = getMonthFromTimeStamp(System.currentTimeMillis() / 1000);
		int currentDateDay = getDayFromTimeStamp(System.currentTimeMillis() / 1000);
		
		int age = currentDateYear - birthdayYear - 1;
        if (currentDateMonth > birthdayMonth || (currentDateMonth == birthdayMonth && currentDateDay >= birthdayDay)) {
        	age ++;
        }
 		
		return age + "";
	}
	
	public static String timeStampToDateWithWeek(long timeStamp) {
		String finalDateString = "";

		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault());
		String date = df.format(timeStamp * 1000);
		String nowDate = df.format(System.currentTimeMillis());
		
		if (date.substring(0, 7).equals(nowDate.substring(0, 7))) {
			if (date.substring(8, 10).equals(nowDate.substring(8, 10))) {	
				finalDateString = date.substring(11);
			} else {
				int dateDif = Integer.parseInt(nowDate.substring(8, 10)) - Integer.parseInt(date.substring(8, 10));
				if (dateDif <= 1) {
					finalDateString = "昨天 " + date.substring(11);
				} else {
					finalDateString = date.substring(0, 10);
				}
			}
		} else {
			finalDateString = date.substring(0, 10);
		}
		
		return finalDateString;
	}

	private static long mTodayStartingPoint;
	private static long mYesterdayStartingPoint;
	private static long mThisYearStartingPoint;
	//Time format
	private static SimpleDateFormat formatToday = new SimpleDateFormat("HH:mm", Locale.getDefault());
	private static SimpleDateFormat formatYesterday = new SimpleDateFormat("HH:mm", Locale.getDefault());
	private static SimpleDateFormat formatThisYear = new SimpleDateFormat("MM-dd", Locale.getDefault());
	private static SimpleDateFormat formatBeforeThisYear = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
	public static void updateTimeReference() {
//		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault());

		Calendar current = Calendar.getInstance();
		Calendar time = Calendar.getInstance();
		time.set(Calendar.YEAR, current.get(Calendar.YEAR));
		time.set(Calendar.MONTH, current.get(Calendar.MONTH));
		time.set(Calendar.DAY_OF_MONTH,current.get(Calendar.DAY_OF_MONTH));
		time.set( Calendar.HOUR_OF_DAY, 0);
		time.set( Calendar.MINUTE, 0);
		time.set(Calendar.SECOND, 0);
		mTodayStartingPoint = time.getTimeInMillis();

		time.set(Calendar.DAY_OF_MONTH,current.get(Calendar.DAY_OF_MONTH) - 1);
		mYesterdayStartingPoint = time.getTimeInMillis();

		time.set(Calendar.YEAR, current.get(Calendar.YEAR));
		time.set(Calendar.MONTH, 0);
		time.set(Calendar.DAY_OF_MONTH, 0);
		mThisYearStartingPoint = time.getTimeInMillis();

//		DpDebug.Log("TimeFormator ---- mTodayStartingPoint : " + df.format(mTodayStartingPoint));
//		DpDebug.Log("TimeFormator ---- mYesterdayStartingPoint : " + df.format(mYesterdayStartingPoint));
//		DpDebug.Log("TimeFormator ---- mThisYearStartingPoint : " + df.format(mThisYearStartingPoint));
	}

	public static String timeStampToDate4(long timeStamp) {
		updateTimeReference();
		String finalDateString = "";

		long targetTime = timeStamp * 1000;
		if (targetTime >= mTodayStartingPoint) {
			finalDateString = formatToday.format(targetTime);
		} else if (targetTime > mYesterdayStartingPoint) {
			finalDateString = "昨天 " + formatYesterday.format(targetTime);
		} else if (targetTime > mThisYearStartingPoint) {
			finalDateString = formatThisYear.format(targetTime);
		} else {
			finalDateString = formatBeforeThisYear.format(targetTime);
		}
		return finalDateString;
	}
}
