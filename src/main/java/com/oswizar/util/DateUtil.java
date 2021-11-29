package com.oswizar.util;

import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class DateUtil {

    private static final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * 将日期对象转换成字符串
     *
     * @param date
     * @return
     */
    public static String convert2String(Date date) {

        return format.format(date);
    }

    /**
     * 将日期格式的字符串转换成日期
     *
     * @param source
     * @return
     */
    public static Date convert2Date(String source, SimpleDateFormat format) {
        try {
            return format.parse(source);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * @return 返回系统当前时间
     */
    public static Date getCurrentDate() {

        return Calendar.getInstance().getTime();

    }

    /**
     * 根据格式获取当前时间
     *
     * @param format
     * @return
     */
    public static String getTimeOfNow(String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.CHINA);
        return sdf.format(new Date());
    }

    /**
     * 根据格式获取本周一的开始时间
     *
     * @return
     */
    public static String getFirstDayOfWeek(String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.CHINA);
        Calendar cal = Calendar.getInstance(Locale.CHINA);
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        cal.setTimeInMillis(System.currentTimeMillis());
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        return sdf.format(cal.getTime());
    }

    /**
     * 根据格式获取本周一的开始时间戳
     *
     * @return
     */
    public static long getFirstDayOfWeek() {
        Calendar cal = Calendar.getInstance();
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONDAY), cal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        return cal.getTimeInMillis();
    }

    /**
     * 根据格式获取本周末的结束时间
     *
     * @return
     */
    public static String getLastDayOfWeek(String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.CHINA);
        Calendar cal = Calendar.getInstance(Locale.CHINA);
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        cal.setTimeInMillis(System.currentTimeMillis());
        cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        return sdf.format(cal.getTime());
    }

    /**
     * 根据格式获取本周末的结束时间戳
     *
     * @return
     */
    public static long getLastDayOfWeek() {
        Calendar cal = Calendar.getInstance(Locale.CHINA);
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        cal.setTimeInMillis(System.currentTimeMillis());
        cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        return cal.getTimeInMillis();
    }

    /**
     * @param @return
     * @return long
     * @throws
     * @Description: 获取本月第一天的时间戳
     */
    public static long getFirstDayOfMonth() {
        Calendar cal = Calendar.getInstance();
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONDAY), cal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));
        return cal.getTimeInMillis();
    }

    public static long getFirstDayOfMonth(int month) {
        Calendar cal = Calendar.getInstance();
        cal.set(cal.get(Calendar.YEAR), month - 1, cal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));
        return cal.getTimeInMillis();
    }


    /**
     * @param @return
     * @return long
     * @throws
     * @Description: 获取本月最后一天的时间戳
     */
    public static long getLastDayOfMonth() {
        Calendar cal = Calendar.getInstance(Locale.CHINA);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        //将小时至0
        cal.set(Calendar.HOUR_OF_DAY, 23);
        //将分钟至0
        cal.set(Calendar.MINUTE, 59);
        //将秒至0
        cal.set(Calendar.SECOND, 59);
        //将毫秒至0
        cal.set(Calendar.MILLISECOND, 999);
        return cal.getTimeInMillis();
    }

    public static long getLastDayOfMonth(int month) {
        Calendar cal = Calendar.getInstance();
        cal.set(cal.get(Calendar.YEAR), month - 1, cal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        return cal.getTimeInMillis();
    }


    /**
     * 时间格式的转换
     *
     * @param dateStr
     * @param oldFormat
     * @param newFormat
     * @return
     * @throws ParseException
     */
    public static String reverseDateFormat(String dateStr, String oldFormat, String newFormat) throws ParseException {
        Date date = new SimpleDateFormat(oldFormat, Locale.CHINA).parse(dateStr);
        return new SimpleDateFormat(newFormat, Locale.CHINA).format(date);
    }

    /**
     * 将当天时间加上或减去若干天  按格式返回
     *
     * @param format 格式
     * @param num    天数
     * @return
     */
    public static String getAfterDay(String format, int num) {
        SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.CHINA);
        Calendar cal = Calendar.getInstance(Locale.CHINA);
        cal.add(Calendar.DAY_OF_WEEK, num);
        return sdf.format(cal.getTime());
    }

    /**
     * 将特定时间加上或减去若干天  按格式返回
     *
     * @param format 格式
     * @param num    天数
     * @return
     */
    public static String getAfterSpecificDay(String timeStr, String format, int num) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Calendar cal = Calendar.getInstance(Locale.CHINA);
        Date date = null;
        try {
            date = sdf.parse(timeStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        cal.setTime(date);
        cal.add(Calendar.DAY_OF_WEEK, num);
        return sdf.format(cal.getTime());
    }

    /**
     * 将当天时间加上或减去若干月  按格式返回
     *
     * @param format 格式
     * @param num    天数
     * @return
     */
    public static String getAfterMonth(String format, int num) {
        SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.CHINA);
        Calendar cal = Calendar.getInstance(Locale.CHINA);
        cal.add(Calendar.MONTH, num);
        return sdf.format(cal.getTime());
    }

    /**
     * 将当天时间加上或减去若干年  按格式返回
     *
     * @param format 格式
     * @param num    天数
     * @return
     */
    public static String getAfterYear(String format, int num) {
        SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.CHINA);
        Calendar cal = Calendar.getInstance(Locale.CHINA);
        cal.add(Calendar.YEAR, num);
        return sdf.format(cal.getTime());
    }

    /**
     * 比较2个日期字符串的大小
     *
     * @param dateStr1
     * @param dateStr2
     * @param format1
     * @param format2
     * @return 1：dateStr1>dateStr2
     * 0: dateStr1=dateStr2
     * -1: dateStr1<dateStr2
     */
    public static int dateStringCompare(String dateStr1, String dateStr2, String format1, String format2) {
        SimpleDateFormat sdf1 = new SimpleDateFormat(format1, Locale.CHINA);
        SimpleDateFormat sdf2 = new SimpleDateFormat(format2, Locale.CHINA);
        Calendar cal1 = Calendar.getInstance(Locale.CHINA);
        Calendar cal2 = Calendar.getInstance(Locale.CHINA);
        Date date1 = null;
        Date date2 = null;
        try {
            date1 = sdf1.parse(dateStr1);
            date2 = sdf2.parse(dateStr2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        cal1.setTime(date1);
        cal2.setTime(date2);
        return cal1.compareTo(cal2);
    }

    /**
     * 计算2个日期的间隔天数
     *
     * @param t1
     * @param t2
     * @return
     * @throws ParseException
     */
    public static int getBetweenDays(String t1, String t2, String format1, String format2) {
        SimpleDateFormat sdf1 = new SimpleDateFormat(format1);
        SimpleDateFormat sdf2 = new SimpleDateFormat(format2);
        int betweenDays = 0;
        Date d1 = null;
        Date d2 = null;
        try {
            d1 = sdf1.parse(t1);
            d2 = sdf2.parse(t2);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c1.setTime(d1);
        c2.setTime(d2);
        // 保证第二个时间一定大于第一个时间
        if (c1.after(c2)) {
            c1.setTime(d2);
            c2.setTime(d1);
        }
        int betweenYears = c2.get(Calendar.YEAR) - c1.get(Calendar.YEAR);
        betweenDays = c2.get(Calendar.DAY_OF_YEAR) - c1.get(Calendar.DAY_OF_YEAR);
        for (int i = 0; i < betweenYears; i++) {
            c1.set(Calendar.YEAR, (c1.get(Calendar.YEAR) + 1));
            betweenDays += c1.getMaximum(Calendar.DAY_OF_YEAR);
        }
        return betweenDays + 1;
    }

    /**
     * 获取指定月份的天数
     *
     * @param yearMonth 年月
     * @param format    格式
     * @return int
     */
    public static int getDaysOfMonth(String yearMonth, String format) {
        int dayNum = 0;
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date date = null;
        try {
            date = sdf.parse(yearMonth);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        dayNum = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        return dayNum;
    }

    /**
     * 根据传入日期获取当天起始终止时间戳
     *
     * @param date 日期，如：2017-7-4 00:00:00
     * @return List, 包含两个元素，当天的起始-终止时间戳
     * @author 姜宽
     */
    public static List<Long> getSEStamp(Date date) {
        List<Long> timestamps = null;
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.set(Calendar.HOUR_OF_DAY, 0);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.SECOND, 0);
            Date start = calendar.getTime();

            calendar.add(Calendar.DAY_OF_MONTH, 1);
            calendar.add(Calendar.SECOND, -1);
            Date end = calendar.getTime();

            timestamps = new ArrayList<>();
            timestamps.add(start.getTime());
            timestamps.add(end.getTime());

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return timestamps;
    }

    /**
     * 根据传入日期获取当天起始终止时间戳
     *
     * @param dateStr 日期，如：2017-7-4 00:00:00
     * @return List, 包含两个元素，当天的起始-终止时间戳
     * @author 姜宽
     */
    public static List<Long> getSEStamp(String dateStr) {
        try {
            return getSEStamp(format.parse(dateStr));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    /**
     * 根据传入日期获取当天起始终止时间戳
     *
     * @param timestamp 时间戳，如：1499183998000
     * @return List, 包含两个元素，当天的起始-终止时间戳
     * @author 姜宽
     */
    public static List<Long> getSEStamp(Long timestamp) {
        try {
            return getSEStamp(new Date(timestamp));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    /**
     * 将字符串抓化为日期，默认"yyyy-MM-dd HH:mm:ss"
     *
     * @param dateStr 日期字符串
     * @return Date
     * @author 姜宽
     */
    public static Date String2Date(String dateStr) {
        try {
            return format.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 将字符串抓 化为日期
     *
     * @param dateStr 日期字符串
     * @param format  格式化，如"yyyy-MM-dd HH:mm:ss"
     * @return Date
     * @author 姜宽
     */
    public static Date String2Date(String dateStr, String format) {
        try {
            return new SimpleDateFormat(format).parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 将字符串抓化为日期，默认"yyyy-MM-dd HH:mm:ss"
     *
     * @param dateStr 日期字符串
     * @return Long
     * @author 姜宽
     */
    public static Long String2Stamp(String dateStr) {
        try {
            return format.parse(dateStr).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 将字符串抓化为日期
     *
     * @param dateStr 日期字符串
     * @param format  格式化，如"yyyy-MM-dd HH:mm:ss"
     * @return Long
     * @author 姜宽
     */
    public static Long String2Stamp(String dateStr, String format) {
        try {
            return new SimpleDateFormat(format).parse(dateStr).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 日期转化为字符串
     *
     * @param date   日期
     * @param format 格式化
     * @return 字符串
     */
    public static String Date2String(Date date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

    /**
     * 时间戳转化为字符串
     *
     * @param stamp  时间戳
     * @param format 格式化
     * @return 字符串
     */
    public static String Stamp2String(Long stamp, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(new Date(stamp));
    }

    /**
     * 时间戳转化为字符串
     *
     * @param stamp 时间戳
     * @return 字符串
     */
    public static String Stamp2String(Long stamp) {
        return format.format(new Date(stamp));
    }

    /**
     * 将.000Z时间格式转化为UTC时间
     *
     * @param zDateStr 2016-08-15T16:00:00.000Z
     * @return Date
     */
    public static Date ZDateToUTC(String zDateStr) {
        try {
            zDateStr = zDateStr.replace("Z", " UTC");
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS Z");
            Date date = format.parse(zDateStr);
            return date;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * start
     * 本周开始时间戳
     */
    public static Long getWeekStartTime() {
        Calendar cal = Calendar.getInstance();
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        // 获取星期一开始时间戳
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        //将小时至0
        cal.set(Calendar.HOUR_OF_DAY, 0);
        //将分钟至0
        cal.set(Calendar.MINUTE, 0);
        //将秒至0
        cal.set(Calendar.SECOND, 0);
        //将毫秒至0
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTimeInMillis();
    }

    /**
     * end
     * 本周结束时间戳
     */
    public static Long getWeekEndTime() {
        Calendar cal = Calendar.getInstance();
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        // 获取星期日结束时间戳
        cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        //将小时至0
        cal.set(Calendar.HOUR_OF_DAY, 23);
        //将分钟至0
        cal.set(Calendar.MINUTE, 59);
        //将秒至0
        cal.set(Calendar.SECOND, 59);
        //将毫秒至0
        cal.set(Calendar.MILLISECOND, 999);
        return cal.getTimeInMillis();
    }


    public static Integer todayInt() {
        SimpleDateFormat ONLY_DATE_INT = new SimpleDateFormat("yyyyMMdd");
        String todayText = ONLY_DATE_INT.format(now());
        Integer today = new Integer(todayText);
        return today;
    }

    /**
     * @return 当前时间
     */
    public static Date now() {
        return new Date();
    }


    /**
     * @param date8 : “yyyyMMdd”格式的日期字符串
     * @return 值为yyyy-MM-dd的字符串代表日期，若是格式错误返回空字符串
     */
    public static String formatDate(Integer date8) {
        String result = "";

        try {
            String dateTime = date8.toString();
            result = dateTime.substring(0, 4) + "-" + dateTime.substring(4, 6) + "-" + dateTime.substring(6);
        } catch (Exception ignore) {
        }

        return result;
    }


    public static Date from(String source) {
        try {
            String[] timeParts = source.split(":");
            if (timeParts.length == 1) {
                return new SimpleDateFormat("yyyy-MM-dd").parse(source);
            } else if (timeParts.length == 2) {
                return new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(source);
            } else if (timeParts.length == 3) {
                return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(source);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static String formatDatetime(Date date) {
        return date == null ? "" : new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
    }

    public static String formatDatetimeMinute(Date date) {
        return date == null ? "" : new SimpleDateFormat("yyyy-MM-dd HH:mm").format(date);
    }

    public static String formatDate(Date date) {
        return date == null ? "" : new SimpleDateFormat("yyyy-MM-dd").format(date);
    }

    /**
     * 返回当天零点的时间
     *
     * @param date 日期
     * @return 当天零点
     */
    public static Date thatDay(Date date) {
        SimpleDateFormat ONLY_DATE = new SimpleDateFormat("yyyy-MM-dd");
        String dateOnly = ONLY_DATE.format(date);
        Date thatDay = date;
        try {
            thatDay = ONLY_DATE.parse(dateOnly);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return thatDay;
    }

    /**
     * 返回次日零点的时间
     *
     * @param date 日期
     * @return 当天零点
     */
    public static Date nextDay(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, 1);

        return thatDay(cal.getTime());
    }

    /**
     * @param date10 : “yyyy-MM-dd”格式的日期字符串
     * @return 值为yyyyMMdd的整型代表日期，若是格式错误返回null
     */
    public static Integer parseDateInt(String date10) {
        Integer result = null;

        try {
            SimpleDateFormat DEFAULT = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat DEFAULT_INT = new SimpleDateFormat("yyyyMMdd");

            Date date = DEFAULT.parse(date10);
            result = Integer.parseInt(DEFAULT_INT.format(date));
        } catch (Exception ignore) {
        }

        return result;
    }


    public JSONObject request(String httpArg) {
        BufferedReader reader = null;
        String result = null;
        JSONObject jsonObjectResult = null;
        StringBuffer sbf = new StringBuffer();
        String httpUrl = "http://api.goseek.cn/Tools/holiday?date=" + httpArg;

        try {
            URL url = new URL(httpUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            InputStream is = connection.getInputStream();
            reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            String strRead = null;
            while ((strRead = reader.readLine()) != null) {
                sbf.append(strRead);
                sbf.append("\r\n");
            }
            reader.close();
            result = sbf.toString();
//            JSONObject.
            jsonObjectResult = JSONObject.parseObject(result);//转为JSONObject对象
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonObjectResult;
    }




    public static void main(String[] args) {

//        List<Long> result = DateUtil.getSEStamp("2017-7-4 00:00:00");
//        System.out.println(result);
//        result = DateUtil.getSEStamp(1499183998000L);
//        System.out.println(result);
//        long time = DateUtil.getFirstDayOfWeek();
//        System.out.println(time);
//        System.out.println(DateUtil.getFirstDayOfMonth());

        JSONObject a = new DateUtil().request("20180101");
        System.out.println(a);
    }


}
