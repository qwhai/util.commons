package pers.hai.util.commons;

import org.junit.Assert;
import org.junit.Test;
import pers.hai.util.commons.nums.NumberUtils;

/**
 * TODO
 * <p>
 * Create Time: 2019-05-22 16:39
 * Last Modify: 2019-05-22
 *
 * @author Q-WHai
 * @see <a href="https://github.com/qwhai">https://github.com/qwhai</a>
 */
public class NumberUtilsTest extends Testable {

    @Test
    public void test1() {
        logger.info(NumberUtils.randomInteger());
    }

    @Test
    public void test2() {
        logger.info(NumberUtils.randomInteger(20));
    }

    @Test
    public void test3() {
        logger.info(NumberUtils.randomInteger(20, 300));
    }

    @Test
    public void test4() {
        logger.info(NumberUtils.factors(300));
    }

    @Test
    public void test5() {
        Assert.assertEquals(100, NumberUtils.maxCommonDivisor(200, 300));
    }
}
