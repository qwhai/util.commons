package org.core.utils.time;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.core.utils.consts.Constant;
import org.core.utils.excep.CannotInstanceException;
import org.core.utils.interf.UtilsInterface;

/**
 * <p>
 * 与时间相关的工具类
 * </p>
 * Create Date: 2015‎年‎11‎月‎26日
 * Last Modify: 2016年5月26日
 * 
 * @author <a href="http://weibo.com/u/5131020927">Q-WHai</a>
 * @see <a href="http://blog.csdn.net/lemon_tree12138">http://blog.csdn.net/lemon_tree12138</a>
 * @version 0.1.1
 */
public class TimeUtils implements UtilsInterface {

    // 禁止实例化
    private TimeUtils() throws CannotInstanceException {
        throw new CannotInstanceException("请不要试图实例化我");
    }
    
    @Override
    public String getTag() {
        return this.getClass().getName();
    }

    @Override
    public void description() {
        System.out.println("我是一个关于时间的工具类");
    }

    // TODO ------------------------------------------- 内部类标识分隔线 ----------------------------------------------------------
    
    /**
     * 时间戳相关的工具类
     * 2015年11月26日
     * 
     * @author <a href="http://weibo.com/u/5131020927">Q-WHai</a>
     * @see <a href="http://blog.csdn.net/lemon_tree12138">http://blog.csdn.net/lemon_tree12138</a>
     * @version 0.1
     */
    public static class TimeStampUtils implements UtilsInterface {

        @Override
        public String getTag() {
            return this.getClass().getName();
        }

        @Override
        public void description() {
            System.out.println("时间戳相关的工具类");
        }
        
        /**
         * 当前时间的时间戳
         * 
         * @return
         *      时间戳
         */
        public static long currentTimeStamp() {
            return System.currentTimeMillis();
        }
    } // TimeStampUtils
    
    // TODO ------------------------------------------- 内部类标识分隔线 ----------------------------------------------------------
    
    /**
     * 日历工具类
     * 2015年11月26日
     * 
     * @author <a href="http://weibo.com/u/5131020927">Q-WHai</a>
     * @see <a href="http://blog.csdn.net/lemon_tree12138">http://blog.csdn.net/lemon_tree12138</a>
     * @version 0.1
     */
    public static class CalendarUtils implements UtilsInterface {

        @Override
        public String getTag() {
            return this.getClass().getName();
        }

        @Override
        public void description() {
            System.out.println("我是一个关于日历的工具类");
        }
        
        /**
         * 得到日历对象中的“年份”
         * 
         * @param c
         *      日历对象
         * @return
         *      年份
         */
        public static int getYear(Calendar c) {
            if(c != null){
                return c.get(Calendar.YEAR);
            } else {
                return Calendar.getInstance().get(Calendar.YEAR);
            }
        }
        
        /**
         * 得到日历对象中的“月份”
         * 注意，这里的月份依然是从0开始的
         * 
         * @param c
         *      日历对象
         * @return
         *      月份
         */
        public static int getMonth(Calendar c) {
            if(c != null){
                return c.get(Calendar.MONTH);
            }else{
                return Calendar.getInstance().get(Calendar.MONTH);
            }
        }
        
        /**
         * 得到日历对象中的日期
         * 
         * @param c
         *      日历对象
         * @return
         *      日期
         */
        public static int getDate(Calendar c) {
            if(c != null){
                return c.get(Calendar.DATE);
            } else {
                return Calendar.getInstance().get(Calendar.DATE);
            }
        }
        
        /**
         * 得到日历对象中的星期
         * 
         * @param c
         *      日历对象
         * @return
         *      星期
         */
        public static int getWeek(Calendar c) {
            if(c != null){
                return c.get(Calendar.DAY_OF_WEEK);
            } else {
                return Calendar.getInstance().get(Calendar.DAY_OF_WEEK);
            }
        }
        
        /**
         * 得到日历对象中的小时
         * 
         * @param c
         *      日历对象
         * @return
         *      小时
         */
        public static int getHour(Calendar c) {
            if(c != null){
                return c.get(Calendar.HOUR);
            } else {
                return Calendar.getInstance().get(Calendar.HOUR);
            }
        }
        
        /**
         * 得到日历对象中的分钟
         * 
         * @param c
         *      日历对象
         * @return
         *      分钟
         */
        public static int getMinute(Calendar c) {
            if(c != null){
                return c.get(Calendar.MINUTE);
            } else {
                return Calendar.getInstance().get(Calendar.MINUTE);
            }
        }
        
        /**
         * 得到日历对象中的秒
         * 
         * @param c
         *      日历对象
         * @return
         *      秒
         */
        public static int getSecond(Calendar c) {
            if(c != null){
                return c.get(Calendar.SECOND);
            } else {
                return Calendar.getInstance().get(Calendar.SECOND);
            }
        }
        
        /**
         * 得到指定或者当前时间n天前的Calendar
         * 
         * @param c
         *      指定时间
         * @param n
         *      之前的n天
         * @return
         *      新日历
         */
        public static Calendar beforeSomeDays(Calendar c, int n){
            // 偏移量，给定n天的毫秒数
            long offset = n * Constant.TimeUtils.ONE_DAY_MILLIS;
            Calendar calendar = null;
            
            if(c != null) {
                calendar = c;
            } else {
                calendar = Calendar.getInstance();
            }
            
            calendar.setTimeInMillis(calendar.getTimeInMillis() - offset);
            
            return calendar;
        }
        
        /**
         * 得到指定或者当前时间n天后的Calendar
         * 
         * @param c
         *      指定时间
         * @param n
         *      之后的n天
         * @return
         *      新日历
         */
        public static Calendar afterSomeDays(Calendar c, int n){
            // 偏移量，给定n天的毫秒数
            long offset = n * Constant.TimeUtils.ONE_DAY_MILLIS;
            Calendar calendar = null;
            if(c != null) {
                calendar = c;
            } else {
                calendar = Calendar.getInstance();
            }
            
            calendar.setTimeInMillis(calendar.getTimeInMillis() + offset);
            
            return calendar;
        }
        
        /**
         * 前一天的日历
         * 
         * @param c
         *      指定时间日历
         * @return
         *      新时间日历
         */
        public static Calendar yesterday(Calendar c){
            return beforeSomeDays(c, 1);
        }
        
        /**
         * 第二天的日历
         * 
         * @param c
         *      指定时间日历
         * @return
         *      新时间日历
         */
        public static Calendar tomorrow(Calendar c) {
            return afterSomeDays(c, 1);
        }
        
        /**
         * 得到指定或者当前时间前offset毫秒的Calendar
         * 
         * @param c
         *      指定时间日历
         * @param offset
         *      向前推移毫秒数
         * @return
         *      新时间日历
         */
        public static Calendar before(Calendar c, long offset) {
            Calendar calendar = null;
            if(c != null) {
                calendar = c;
            } else {
                calendar = Calendar.getInstance();
            }
            
            calendar.setTimeInMillis(calendar.getTimeInMillis() - offset);
            
            return calendar;
        }
        
        /**
         * 得到指定或者当前时间前offset毫秒的Calendar
         * 
         * @param c
         *      指定时间日历
         * @param offset
         *      向后推移毫秒数
         * @return
         *      新时间日历
         */
        public static Calendar after(Calendar c, long offset){
            Calendar calendar = null;
            if(c != null) {
                calendar = c;
            } else {
                calendar = Calendar.getInstance();
            }
            
            calendar.setTimeInMillis(calendar.getTimeInMillis() - offset);
            
            return calendar;
        }
        
        /**
         * 日期格式化
         * 
         * @param c
         *      指定时间日历
         * @param pattern
         *      格式化方程
         * @return
         *      格式化日期
         */
        public static String format(Calendar c, String pattern) {
            Calendar calendar = null;
            
            if(c != null){
                calendar = c;
            }else{
                calendar = Calendar.getInstance();
            }
            
            if(pattern == null || pattern.equals("")){
                pattern = "yyyy年MM月dd日 HH:mm:ss";
            }
            
            SimpleDateFormat sdf = new SimpleDateFormat(pattern);
            
            return sdf.format(calendar.getTime());
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
        
        /**
         * Date类型转换到Calendar类型
         * 
         * @param d
         *      Date
         * @return
         *      Calendar
         */
        public static Calendar Date2Calendar(Date d){
            Calendar c = Calendar.getInstance();
            c.setTime(d);
            return c;
        }
        
        /**
         * Calendar类型转换到Date类型
         * 
         * @param c
         *      日历
         * @return
         *      Date
         */
        public static Date Calendar2Date(Calendar c){
            return c.getTime();
        }
        
    } // CalendarUtils
    
//    public static void main(String[] args) {
//        System.out.println(CalendarUtils.getYear(Calendar.getInstance()));
//        System.out.println(CalendarUtils.getMonth(Calendar.getInstance()));
//        System.out.println(CalendarUtils.getDate(Calendar.getInstance()));
//        
//        System.out.println(CalendarUtils.getWeek(Calendar.getInstance()));
//        
//        System.out.println(CalendarUtils.getHour(Calendar.getInstance()));
//        System.out.println(CalendarUtils.getMinute(Calendar.getInstance()));
//        System.out.println(CalendarUtils.getSecond(Calendar.getInstance()));
//        
//        System.out.println(new Date(CalendarUtils.beforeSomeDays(Calendar.getInstance(), 2).getTimeInMillis()));
//        System.out.println(new Date(CalendarUtils.afterSomeDays(Calendar.getInstance(), 1).getTimeInMillis()));
//        System.out.println(new Date(CalendarUtils.yesterday(Calendar.getInstance()).getTimeInMillis()));
//        System.out.println(new Date(CalendarUtils.tomorrow(Calendar.getInstance()).getTimeInMillis()));
//        
//        System.out.println(CalendarUtils.getTimeString());
//    }
}
