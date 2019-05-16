package pers.hai.util.commons.datetime;

import pers.hai.util.commons.consts.Constant;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日历工具类
 *
 * Create Date: 2015-11-26
 * Last Modify: 2019-05-10
 *
 * @author Q-WHai
 * @see <a href="https://github.com/qwhai">https://github.com/qwhai</a>
 */
public class CalendarUtils {

    /**
     * 日期格式化
     *
     * @param calendar
     *      指定时间日历
     * @param pattern
     *      模式串
     * @return
     *      格式化日期
     */
    public static String format(Calendar calendar, String pattern) {
        Calendar cal = null == calendar ? Calendar.getInstance() : calendar;
        if(pattern == null || pattern.equals(""))
            pattern = "yyyy-MM-dd HH:mm:ss";

        return new SimpleDateFormat(pattern).format(cal.getTime());
    }

    /**
     * Date类型转换到Calendar类型
     *
     * @param date
     *      Date
     * @return
     *      Calendar
     */
    public static Calendar format(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal;
    }

    /**
     * Calendar类型转换到Date类型
     *
     * @param calendar
     *      日历
     * @return
     *      Date
     */
    public static Date format(Calendar calendar){
        return calendar.getTime();
    }

    /**
     * 得到日历对象中的“年份”
     *
     * @param calendar
     *      日历对象
     * @return
     *      年份
     */
    public static int getYear(Calendar calendar) {
        if(calendar != null){
            return calendar.get(Calendar.YEAR);
        } else {
            return Calendar.getInstance().get(Calendar.YEAR);
        }
    }

    /**
     * 得到日历对象中的“月份”
     * 注意，这里的月份依然是从0开始的
     *
     * @param calendar
     *      日历对象
     * @return
     *      月份
     */
    public static int getMonth(Calendar calendar) {
        if(calendar != null){
            return calendar.get(Calendar.MONTH);
        }else{
            return Calendar.getInstance().get(Calendar.MONTH);
        }
    }

    /**
     * 得到日历对象中的日期
     *
     * @param calendar
     *      日历对象
     * @return
     *      日期
     */
    public static int getDate(Calendar calendar) {
        if(calendar != null){
            return calendar.get(Calendar.DATE);
        } else {
            return Calendar.getInstance().get(Calendar.DATE);
        }
    }

    /**
     * 得到日历对象中的星期
     *
     * @param calendar
     *      日历对象
     * @return
     *      星期
     */
    public static int getWeek(Calendar calendar) {
        if(calendar != null){
            return calendar.get(Calendar.DAY_OF_WEEK);
        } else {
            return Calendar.getInstance().get(Calendar.DAY_OF_WEEK);
        }
    }

    /**
     * 得到日历对象中的小时
     *
     * @param calendar
     *      日历对象
     * @return
     *      小时
     */
    public static int getHour(Calendar calendar) {
        if(calendar != null){
            return calendar.get(Calendar.HOUR);
        } else {
            return Calendar.getInstance().get(Calendar.HOUR);
        }
    }

    /**
     * 得到日历对象中的分钟
     *
     * @param calendar
     *      日历对象
     * @return
     *      分钟
     */
    public static int getMinute(Calendar calendar) {
        if(calendar != null){
            return calendar.get(Calendar.MINUTE);
        } else {
            return Calendar.getInstance().get(Calendar.MINUTE);
        }
    }

    /**
     * 得到日历对象中的秒
     *
     * @param calendar
     *      日历对象
     * @return
     *      秒
     */
    public static int getSecond(Calendar calendar) {
        if(calendar != null){
            return calendar.get(Calendar.SECOND);
        } else {
            return Calendar.getInstance().get(Calendar.SECOND);
        }
    }

    /**
     * 得到指定或者当前时间n天前的Calendar
     *
     * @param calendar
     *      指定时间
     * @param days
     *      之前的n天
     * @return
     *      新日历
     */
    public static Calendar beforeSomeDays(Calendar calendar, int days){
        // 偏移量，给定n天的毫秒数
        long offset = days * Constant.TimeUtils.ONE_DAY_MILLIS;
        Calendar cal = null == calendar ? Calendar.getInstance() : calendar;
        cal.setTimeInMillis(cal.getTimeInMillis() - offset);
        return cal;
    }

    /**
     * 得到指定或者当前时间n天后的Calendar
     *
     * @param calendar
     *      指定时间
     * @param days
     *      之后的n天
     * @return
     *      新日历
     */
    public static Calendar afterSomeDays(Calendar calendar, int days){
        // 偏移量，给定n天的毫秒数
        long offset = days * Constant.TimeUtils.ONE_DAY_MILLIS;
        Calendar cal = null == calendar ? Calendar.getInstance() : calendar;
        cal.setTimeInMillis(cal.getTimeInMillis() + offset);
        return cal;
    }

    /**
     * 前一天的日历
     *
     * @param calendar
     *      指定时间日历
     * @return
     *      新时间日历
     */
    public static Calendar yesterday(Calendar calendar){
        return beforeSomeDays(calendar, 1);
    }

    /**
     * 第二天的日历
     *
     * @param calendar
     *      指定时间日历
     * @return
     *      新时间日历
     */
    public static Calendar tomorrow(Calendar calendar) {
        return afterSomeDays(calendar, 1);
    }

    /**
     * 得到指定或者当前时间前offset毫秒的Calendar
     *
     * @param calendar
     *      指定时间日历
     * @param offsetMillis
     *      向前推移毫秒数
     * @return
     *      新时间日历
     */
    public static Calendar before(Calendar calendar, long offsetMillis) {
        Calendar cal = null == calendar ? Calendar.getInstance() : calendar;
        cal.setTimeInMillis(cal.getTimeInMillis() - offsetMillis);
        return cal;
    }

    /**
     * 得到指定或者当前时间前offset毫秒的Calendar
     *
     * @param calendar
     *      指定时间日历
     * @param offset
     *      向后推移毫秒数
     * @return
     *      新时间日历
     */
    public static Calendar after(Calendar calendar, long offset){
        Calendar cal = null == calendar ? Calendar.getInstance() : calendar;
        cal.setTimeInMillis(cal.getTimeInMillis() - offset);

        return cal;
    }

    /**
     * 得到当前时间的字符串表示
     * 格式2010-02-02 12:12:12
     *
     * @return
     *      格式化日期
     */
    public static String getTimeString(){
        return format(Calendar.getInstance(), "yyyy-MM-dd HH:mm:ss");
    }
}
