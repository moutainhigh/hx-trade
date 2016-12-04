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
    
    public static long getCurrentTime() {
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
        return toDay.getTime() / 1000;
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
	public static String format1DateToString(Long date){
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
     * 将日期字符串yyyyMMdd转换为时间戳
     *
     * @param str
     * @return
     */
    public static Long stringToTimestamp(String str) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Date date = new Date();
        try {
            date = sdf.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date.getTime();
    }
}
