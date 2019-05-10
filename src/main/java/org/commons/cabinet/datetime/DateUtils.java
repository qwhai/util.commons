package org.commons.cabinet.datetime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期工具类
 *
 * @Author: Q-WHai
 * @Date: Created in 15:46 2019/05/10
 */
public class DateUtils {

    /**
     * 格式化日期
     *
     * @param seconds   时间戳：秒
     * @return          日期：2019-05-10 17:07:19
     */
    public static String format(int seconds) {
        return format(seconds, "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 格式化日期
     *
     * @param seconds   时间戳：秒
     * @param format    模式串
     * @return          日期字符串
     */
    public static String format(int seconds, String format) {
        return new SimpleDateFormat(format).format(new Date(((long) seconds) * 1000));
    }

    /**
     * 格式化日期
     *
     * @param dateStr   eg: 2019-01-01
     * @param format    模式串
     * @return          Date
     */
    public static Date format(String dateStr, String format) {
        Date date = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            date = sdf.parse(dateStr);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }

        return date;
    }

    /**
     * 格式化日期
     *
     * @param date  日期字符串
     * @return      日期
     */
    public static Date format(String date) {
        return format(date, "yyyy-MM-dd");
    }

    /**
     * 默认格式化日期
     *
     * @param date  日期
     * @return      日期字符串：2019-01-01
     */
    public static String format(Date date) {
        return format(date, "yyyy-MM-dd");
    }

    /**
     * 格式化日期
     *
     * @param date      日期
     * @param format    模式串
     * @return          日期字符串
     */
    public static String format(Date date, String format) {
        return new SimpleDateFormat(format).format(date);
    }

    /**
     * 格式化日期到月份（int）
     *
     * @param date  日期
     * @return      月份
     */
    public static int format2Month(Date date) {
        return Integer.parseInt(format(date, "yyyyMM"));
    }

    /**
     * 格式化日期到月份（int）
     *
     * @param date  日期
     * @return      月份
     */
    public static int format2Month(String date) {
        return Integer.parseInt(format(format(date), "yyyyMM"));
    }

    /**
     * 计算date的前一天
     *
     * @param date  date
     * @return      Date
     */
    public static Date beforeDate(Date date) {
        if (null == date) return null;

        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.DATE, c.get(Calendar.DATE) - 1);

        return c.getTime();
    }

    /**
     * 计算date的后一天
     *
     * @param date  date
     * @return      Date
     */
    public static Date nextDate(Date date) {
        if (null == date) return null;

        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.DATE, c.get(Calendar.DATE) + 1);

        return c.getTime();
    }

    /**
     * 基于date计算上个月的月份
     *
     * @param date  date
     * @return      月份：eg.201901
     */
    public static int lastMonth(Date date) {
        if (null == date) return 0;

        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.MONTH, -1);

        return Integer.parseInt(format(c.getTime(), "yyyyMM"));
    }

    /**
     * 基于date计算上个月的月份
     *
     * @param date      日期字符串
     * @param format    模式串
     * @return          月份：eg.201901
     */
    public static int lastMonth(String date, String format) {
        return lastMonth(format(date, format));
    }

    /**
     * 计算上个月的月份
     *
     * @return  月份：eg.201901
     */
    public static int lastMonth() {
        return lastMonth(new Date());
    }



    /**
     * 是否是同一天
     *
     * @param d1    d1
     * @param d2    d2
     * @return      true:是同一天 / false:不是同一天
     */
    public static boolean isSameDay(Date d1, Date d2) {
        if(d1 != null && d2 != null) {
            Calendar cal1 = Calendar.getInstance();
            cal1.setTime(d1);
            Calendar cal2 = Calendar.getInstance();
            cal2.setTime(d2);
            return isSameDay(cal1, cal2);
        } else {
            throw new IllegalArgumentException("The date must not be null");
        }
    }

    /**
     * 是否是同一天
     *
     * @param c1    c1
     * @param c2    c2
     * @return      true:是同一天 / false:不是同一天
     */
    public static boolean isSameDay(Calendar c1, Calendar c2) {
        if(c1 != null && c2 != null) {
            return c1.get(0) == c2.get(0) && c1.get(1) == c2.get(1) && c1.get(6) == c2.get(6);
        } else {
            throw new IllegalArgumentException("The date must not be null");
        }
    }

    /**
     * d1 是否早于 d2（仅计算日期，不计算时间）
     * @param d1    d1
     * @param d2    d2
     * @return      true:d1早于d2 / false:d1不早于d2
     */
    public static boolean isBeforDay(Date d1, Date d2) {
        Date dt1 = format(format(d1));
        Date dt2 = format(format(d2));

        return dt1.before(dt2);
    }
}
