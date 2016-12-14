package com.hgxh.trade.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;



/**
 * @author ZQ
 * @version 1.0
 * @date 2015-5-21
 */
public class DateUtil {
    public final static String YYYYMMDDHHMMSS = "yyyyMMddHHmmssSSS";
    public final static Long ONEDAY = 86400l;
    public final static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
    public final static SimpleDateFormat SECOND_OF_YEAR_FIELD = new SimpleDateFormat("yyyyMMddHHmmss");
    public final static SimpleDateFormat DAY_OF_YEAR_FIELD = new SimpleDateFormat("yyyyMMdd");
    public static final int SECONDS_IN_DAY = 60 * 60 * 24;
    public static final long MILLIS_IN_DAY = 1000L * SECONDS_IN_DAY;

    /**
     * @return
     * @author ZQ
     * @date 2015-5-21
     */
    public static String getDateSequence() {
        return new SimpleDateFormat(YYYYMMDDHHMMSS).format(new Date());
    }

    public static long getDayBefore(int days) {
        String format = "yyyy-MM-DD";
        String dayString = DateSimpleUtil.toString(new Date(System.currentTimeMillis() - days * 24 * 60 * 60 * 1000), format);
        Date day = null;
        try {
            day = DateSimpleUtil.parseDate(dayString, format);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return day.getTime() / 1000;
    }


    public static long getDayAfter(int days) {
        String format = "yyyy-MM-DD";
        String dayString = DateSimpleUtil.toString(new Date(System.currentTimeMillis() + days * 24 * 60 * 60 * 1000), format);
        Date day = null;
        try {
            day = DateSimpleUtil.parseDate(dayString, format);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return day.getTime() / 1000;
    }

    public static long getLastModifyTime() {
        return System.currentTimeMillis();
    }

    public static long getToday() {
        String format = "yyyy-MM-DD";
        String toDayString = DateSimpleUtil.toString(new Date(System.currentTimeMillis()), format);
        Date toDay = null;
        try {
            toDay = DateSimpleUtil.parseDate(toDayString, format);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return toDay.getTime();
    }


    public static Date getDateToday() {
        String format = "yyyy-MM-dd";
        String toDayString = DateSimpleUtil.toString(new Date(System.currentTimeMillis()), format);
        Date toDay = null;
        try {
            toDay = DateSimpleUtil.parseDate(toDayString, format);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return toDay;
    }


    public static String getTodayToString() {
        String format = "yyyy-MM-dd";
        String toDayString = DateSimpleUtil.toString(new Date(System.currentTimeMillis()), format);
        return toDayString;
    }

    /**
	 * 将长整形数据格式化为yyyy-MM-dd的字符串样式
	 * @param date
	 * @return
	 */
	public static String format1DateToString(long date){
		return DateSimpleUtil.toString(new Date(date), "yyyy-MM-dd");
	}
    
	/**
	 * 判断两天是否为同一天
	 * @param ms1
	 * @param ms2
	 * @return
	 */
    public static boolean isSameDayOfMillis(final long ms1, final long ms2) {
        final long interval = ms1 - ms2;
        return interval < MILLIS_IN_DAY
                && interval > -1L * MILLIS_IN_DAY
                && toDay(ms1) == toDay(ms2);
    }
 
    private static long toDay(long millis) {
        return (millis + TimeZone.getDefault().getOffset(millis)) / MILLIS_IN_DAY;
    }

    public static String getSecondOfYearToString(Date date) {
    	return SECOND_OF_YEAR_FIELD.format(date);
    }

    /**
     * 将日期字符串yyyyMMddHHmmss转换为时间戳
     * @param str
     * @return
     */
    public static long stringToTimestamp(String str) {
    	SimpleDateFormat sdf;
    	if(str.length() == 8){
    		sdf = new SimpleDateFormat("yyyyMMdd");
    	}else{
    		sdf = new SimpleDateFormat("yyyyMMddHHmmss");
    	}
        Date date = new Date();
        try {
            date = sdf.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date.getTime();
    }
    
    /**
     * 将时间戳转换成当天0点
     * @param day
     * @return
     */
    public static long getDayBegin(long timestamp) {
        String format = "yyyy-MM-DD";
        String toDayString = DateSimpleUtil.toString(new Date(timestamp), format);
        Date toDay = null;
        try {
            toDay = DateSimpleUtil.parseDate(toDayString, format);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return toDay.getTime();
    }
    
    /**
     * 获取两个时间之间是几个月
     * @param startTime
     * @param endTime
     * @return
     */
    public static int getMonths(long startTime, long endTime){
    	String start = format1DateToString(startTime);
		String end = format1DateToString(endTime);
		String s[] = start.split("-");
		String e[] = end.split("-");
		int months = Math.abs((Integer.parseInt(e[0])-Integer.parseInt(s[0]))*12
				+Integer.parseInt(e[1])-Integer.parseInt(s[1]));
    	return months;
    }
    
    /**
     * 获取日期当月天数
     * @param time
     * @return
     */
    public static int getMonthDays(long time){
    	String date = format1DateToString(time);
    	String d[] = date.split("-");
    	int year = Integer.parseInt(d[0]);
    	int month = Integer.parseInt(d[1]);
    	int days[] = new int[12];
	    days[0] = 31;
	    days[2] = 31;
	    days[3] = 30;
	    days[4] = 31;
	    days[5] = 30;
	    days[6] = 31;
	    days[7] = 31;
	    days[8] = 30;
	    days[9] = 31;
	    days[10] = 30;
	    days[11] = 31;
	    if ((year%4 == 0 && year%100 != 0) || year%400 == 0) {
	        days[1] = 29;
	    } else {
	        days[1] = 28;
	    }		 
	    return days[month-1];
    }
    
    public static int getMonthDays(int year, int month){
    	int days[] = new int[12];
	    days[0] = 31;
	    days[2] = 31;
	    days[3] = 30;
	    days[4] = 31;
	    days[5] = 30;
	    days[6] = 31;
	    days[7] = 31;
	    days[8] = 30;
	    days[9] = 31;
	    days[10] = 30;
	    days[11] = 31;
	    if ((year%4 == 0 && year%100 != 0) || year%400 == 0) {
	        days[1] = 29;
	    } else {
	        days[1] = 28;
	    }		 
	    return days[month-1];
    }
    
}
