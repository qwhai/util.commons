package org.commons.cabinet;

import org.commons.cabinet.datetime.CalendarUtils;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

/**
 * @Author: Q-WHai
 * @Date: Created in 18:07 2019/05/10
 */
public class CalendarUtilsTest extends Testable {

    @Test
    public void test1() {
        int year = CalendarUtils.getYear(Calendar.getInstance());
        logger.info(year);
    }

    @Test
    public void test2() {
        int year = CalendarUtils.getMonth(Calendar.getInstance());
        logger.info(year);
    }

    @Test
    public void test3() {
        int year = CalendarUtils.getDate(Calendar.getInstance());
        logger.info(year);
    }

    @Test
    public void test4() {
        int year = CalendarUtils.getWeek(Calendar.getInstance());
        logger.info(year);
    }

    @Test
    public void test5() {
        int year = CalendarUtils.getHour(Calendar.getInstance());
        logger.info(year);
    }

    @Test
    public void test6() {
        int year = CalendarUtils.getMinute(Calendar.getInstance());
        logger.info(year);
    }

    @Test
    public void test7() {
        int year = CalendarUtils.getSecond(Calendar.getInstance());
        logger.info(year);
    }

    @Test
    public void test8() {
        Date date = new Date(CalendarUtils.beforeSomeDays(Calendar.getInstance(), 2).getTimeInMillis());
        logger.info(date);
    }

    @Test
    public void test9() {
        Date date = new Date(CalendarUtils.afterSomeDays(Calendar.getInstance(), 1).getTimeInMillis());
        logger.info(date);
    }

    @Test
    public void test10() {
        Date date = new Date(CalendarUtils.yesterday(Calendar.getInstance()).getTimeInMillis());
        logger.info(date);
    }

    @Test
    public void test11() {
        Date date = new Date(CalendarUtils.tomorrow(Calendar.getInstance()).getTimeInMillis());
        logger.info(date);
    }

    @Test
    public void test12() {
        String date = CalendarUtils.getTimeString();
        logger.info(date);
    }

    @Test
    public void test13() {
        Calendar cal = CalendarUtils.before(Calendar.getInstance(), 10000);
        logger.info(cal);
    }

    @Test
    public void test14() {
        Calendar cal = CalendarUtils.after(Calendar.getInstance(), 10000);
        logger.info(cal);
    }

    @Test
    public void test15() {
        String cal = CalendarUtils.format(Calendar.getInstance(), "yyyy年MM月dd日 HH:mm:ss");
        logger.info(cal);
    }

    @Test
    public void test16() {
        Calendar cal = CalendarUtils.format(new Date());
        logger.info(cal);
    }

    @Test
    public void test17() {
        Date date = CalendarUtils.format(Calendar.getInstance());
        logger.info(date);
    }
}
