package pers.hai.util.commons;

import pers.hai.util.commons.datetime.DateUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

/**
 * @Author: Q-WHai
 * @Date: Created in 17:02 2019/05/10
 */
public class DateUtilsTest extends Testable {

    @Test
    public void test1() {
        String date = DateUtils.format(1557479239);

        Assert.assertEquals("2019-05-10 17:07:19", date);
        logger.info(date);
    }

    @Test
    public void test2() {
        String date = DateUtils.format(1557479239, "yyyy/MM/dd HH:mm:ss");

        Assert.assertEquals("2019/05/10 17:07:19", date);
        logger.info(date);
    }

    @Test
    public void test3() {
        Date date = DateUtils.beforeDate(new Date());
        logger.info(date);
    }

    @Test
    public void test4() {
        Date date = DateUtils.nextDate(new Date());
        logger.info(date);
    }

    @Test
    public void test5() {
        int month = DateUtils.lastMonth(DateUtils.format("2018-09-12"));

        Assert.assertEquals(201808, month);
        logger.info(month);
    }

    @Test
    public void test6() {
        int month = DateUtils.lastMonth("2019-01-02", "yyyy-MM-dd");

        Assert.assertEquals(201812, month);
        logger.info(month);
    }

    @Test
    public void test7() {
        int month = DateUtils.lastMonth();
        logger.info(month);
    }

    @Test
    public void test8() {
        Date date = DateUtils.format("2019-01-02", "yyyy-MM-dd");
        logger.info(date);
    }

    @Test
    public void test9() {
        Date date = DateUtils.format("2019-01-02");
        logger.info(date);
    }

    @Test
    public void test10() {
        Date date = DateUtils.format("2018-12-02");

        String dateStr = DateUtils.format(date);
        Assert.assertEquals("2018-12-02", dateStr);
        logger.info(dateStr);
    }

    @Test
    public void test11() {
        Date date = DateUtils.format("2018-12-02 12:21:33", "yyyy-MM-dd HH:mm:ss");

        String dateStr = DateUtils.format(date, "yyyy-MM-dd HH:mm:ss");
        Assert.assertEquals("2018-12-02 12:21:33", dateStr);
        logger.info(dateStr);
    }

    @Test
    public void test12() {
        Date date = DateUtils.format("2018-12-02 12:21:33", "yyyy-MM-dd HH:mm:ss");

        int month = DateUtils.format2Month(date);
        Assert.assertEquals(201812, month);
        logger.info(month);
    }

    @Test
    public void test13() {
        int month = DateUtils.format2Month("2019-01-02");
        Assert.assertEquals(201901, month);
        logger.info(month);
    }

    @Test
    public void test14() {
        Date date1 = DateUtils.format("2019-01-02");
        Date date2 = DateUtils.format("2019-01-02");

        boolean same = DateUtils.isSameDay(date1, date2);
        Assert.assertTrue(same);
    }

    @Test
    public void test15() {
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(DateUtils.format("2019-01-02"));

        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(DateUtils.format("2019-01-02"));

        boolean same = DateUtils.isSameDay(cal1, cal2);
        Assert.assertTrue(same);
    }

    @Test
    public void test16() {
        Date date1 = DateUtils.format("2019-01-02");
        Date date2 = DateUtils.format("2019-01-02");

        boolean same = DateUtils.isBeforDay(date1, date2);
        Assert.assertTrue(same);
    }
}
