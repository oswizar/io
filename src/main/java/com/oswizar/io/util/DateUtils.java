/**
 *====================================================
 * 文件名称: DateUtils.java
 * 修订记录：
 * No    日期				作者(操作:具体内容)
 * 1.    2015年9月26日			chenxy(创建:创建文件)
 *====================================================
 * 类描述：(说明未实现或其它不应生成javadoc的内容)
 */
package com.oswizar.io.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @ClassName: DateUtils
 */
public class DateUtils {

	/** 当前时间 */
	public static Date now() {
		return new Date();
	}

	/**
	 * 对日期时间对象进行调整
	 * @param date
	 * @param CALENDARFIELD
	 *
	 *            <pre>
	 * 年 Calendar.YEAR
	 * 月 Calendar.MONTH
	 * 日 Calendar.DATE
	 * 时 Calendar.HOUR
	 * 分 Calendar.MINUTE
	 * 秒 Calendar.SECOND
	 *            </pre>
	 *
	 * @param amount 调整数量，>0表向后调整（明天，明年），<0表向前调整（昨天，去年）
	 * @return
	 * @author:chenxy
	 */
	public static Date addDateField(Date date, int CALENDARFIELD, int amount) {
		if (null == date) {
			return date;
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(CALENDARFIELD, amount);
		return calendar.getTime();
	}

	public static Date addHours(Date date, int amount) {
		return addDateField(date, Calendar.HOUR_OF_DAY, amount);
	}

	/**
	 * 转化Date类型
	 * @param date
	 * @return
	 * @author:chenxy
	 */
	public static Integer parseDateInt(String date) {
		if (org.apache.commons.lang3.StringUtils.isBlank(date)) {
			return null;
		}
		date = date.replaceAll("[^0-9]", "");
		return Integer.parseInt(date);
	}

	/**
	 * 转化Date类型
	 * @param date
	 * @return
	 * @author:chenxy
	 */
	public static Integer parseDateInt(Date date) {
		if (date == null) {
			return null;
		}
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		return Integer.parseInt(format.format(date));
	}

	public static String getCurrentDateMinute() {
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		return format.format(new Date());
	}

	public static String getCurrentLinkedDateTime() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return format.format(new Date());
	}

	public static String getCurrentDate() {
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		return format.format(new Date());
	}

	public static Date fromDateInt(int dateInt) {
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
			return format.parse(dateInt + "");
		} catch (Exception e) {
		}
		return null;
	}

	/** 每天结束时间 */
	public static Date formatEndDay(String date) {
		if (StringUtils.isBlank(date)) {
			return null;
		}
		try {
			date = date.replaceAll("[^0-9]", "").substring(0, 8) + "235959999";
			SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmssSSS");
			return format.parse(date);
		} catch (Exception e) {
		}
		return null;
	}

	/** 每天结束时间 */
	public static Date formatEndDay(Date date) {
		try {
			String d = new SimpleDateFormat("yyyyMMdd").format(date) + "235959999";
			return new SimpleDateFormat("yyyyMMddHHmmssSSS").parse(d);
		} catch (Exception e) {
		}
		return null;
	}

	/** 每天开始时间 */
	public static Date formatBeginDay(String date) {
		if (StringUtils.isBlank(date)) {
			return null;
		}
		try {
			date = date.replaceAll("[^0-9]", "").substring(0, 8) + "000000000";
			SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmssSSS");
			return format.parse(date);
		} catch (Exception e) {
		}
		return null;
	}

	/** 每天开始时间 */
	public static Date formatBeginDay(Date date) {
		try {
			String d = new SimpleDateFormat("yyyyMMdd").format(date) + "000000000";
			return new SimpleDateFormat("yyyyMMddHHmmssSSS").parse(d);
		} catch (Exception e) {
		}
		return null;
	}

	/**
	 * 计算两个日期之间相差的天数
	 * @param smdate 较小的时间
	 * @param bdate 较大的时间
	 * @return 相差天数
	 * @throws ParseException
	 */
	public static int daysBetween(Date smdate, Date bdate) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			smdate = sdf.parse(sdf.format(smdate));
			bdate = sdf.parse(sdf.format(bdate));
			Calendar cal = Calendar.getInstance();
			cal.setTime(smdate);
			long time1 = cal.getTimeInMillis();
			cal.setTime(bdate);
			long time2 = cal.getTimeInMillis();
			long between_days = (time2 - time1) / (1000 * 3600 * 24);

			return Integer.parseInt(String.valueOf(between_days));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * 计算两个日期之间相差的小时数
	 * @param smdate 较小的时间
	 * @param bdate 较大的时间
	 * @return 相差小时数
	 * @throws ParseException
	 */
	public static int hoursBetween(Date smdate, Date bdate) {
		try {
			Long h = bdate.getTime() - smdate.getTime();
			return Integer.parseInt(String.valueOf(h/3600000));
		} catch (Exception e) {
//			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * 获取本月第一天
	 * @return 本月第一天
	 */
	public static Date getFirstDay() {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.MONTH, 0);
		c.set(Calendar.DAY_OF_MONTH,1);//设置为1号,当前日期既为本月第一天
		return c.getTime();
	}

	/**
	 * 获取本月最后一天
	 * @return 本月第一天
	 */
	public static Date getLastDay() {
		Calendar c = Calendar.getInstance();
        c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
		return c.getTime();
	}

	 /**
     * 获取某年第一天日期
     * @param year 年份
     * @return Date
     */
    public static Date getYearFirst(int year){
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.YEAR, year);
        Date currYearFirst = calendar.getTime();
        return currYearFirst;
    }

    /**
     * 获取某年最后一天日期
     * @param year 年份
     * @return Date
     */
    public static Date getYearLast(int year){
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.YEAR, year);
        calendar.roll(Calendar.DAY_OF_YEAR, -1);
        Date currYearLast = calendar.getTime();

        return currYearLast;
    }

    /**
     * 获取当年的第一天
     * @param
     * @return
     */
    public static Date getCurrYearFirst(){
        Calendar currCal=Calendar.getInstance();
        int currentYear = currCal.get(Calendar.YEAR);
        return getYearFirst(currentYear);
    }

    /**
     * 获取当年的最后一天
     * @param
     * @return
     */
    public static Date getCurrYearLast(){
        Calendar currCal=Calendar.getInstance();
        int currentYear = currCal.get(Calendar.YEAR);
        return getYearLast(currentYear);
    }

	public static String formatDate(Date date) {
		return date == null ? "" : new SimpleDateFormat("yyyy-MM-dd").format(date);
	}

	/**
	 * @return 10年后的时间
	 */
	public static Date tenYearsLater() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.YEAR, 10);
		return cal.getTime();
	}
}
