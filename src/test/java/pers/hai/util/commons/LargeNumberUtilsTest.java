package pers.hai.util.commons;

import org.junit.Assert;
import org.junit.Test;
import pers.hai.util.commons.excep.NotNumberException;
import pers.hai.util.commons.math.LargeNumberUtils;

/**
 * TODO
 * <p>
 * Create Time: 2019-05-22 17:45
 * Last Modify: 2019-05-22
 *
 * @author Q-WHai
 * @see <a href="https://github.com/qwhai">https://github.com/qwhai</a>
 */
public class LargeNumberUtilsTest extends Testable {

    @Test
    public void test1() {
        try {
            Assert.assertEquals("80235", LargeNumberUtils.add("12345", "67890"));
        } catch (NotNumberException ex) {
            logger.error(ex.getMessage());
        }
    }

    @Test
    public void test2() {
        try {
            logger.info(LargeNumberUtils.add("21398749817492913981900312834340831", "7216738721892389436456905428712347123467"));
        } catch (NotNumberException ex) {
            logger.error(ex.getMessage());
        }
    }

    @Test
    public void test3() {
        try {
            logger.info(LargeNumberUtils.sub("21398749817492913981900312834340831", "7216738721892389436456905428712347123467"));
        } catch (NotNumberException ex) {
            logger.error(ex.getMessage());
        }
    }

    @Test
    public void test4() {
        try {
            logger.info(LargeNumberUtils.sub("7216738721892389436456905428712347123467", "21398749817492913981900312834340831"));
        } catch (NotNumberException ex) {
            logger.error(ex.getMessage());
        }
    }

    @Test
    public void test5() {
        try {
            logger.info(LargeNumberUtils.mul("7216738721892389436456905428712347123467", "21398749817492913981900312834340831"));
        } catch (NotNumberException ex) {
            logger.error(ex.getMessage());
        }
    }

    @Test
    public void test6() {
        try {
            logger.info(LargeNumberUtils.compare("7216738721892389436456905428712347123467", "21398749817492913981900312834340831"));
        } catch (NotNumberException ex) {
            logger.error(ex.getMessage());
        }
    }

    @Test
    public void test7() {
        try {
            logger.info(LargeNumberUtils.compare("7216738721892389436456905428712347123467", "7216738721892389436456905428712347123467"));
        } catch (NotNumberException ex) {
            logger.error(ex.getMessage());
        }
    }

    @Test
    public void test8() {
        try {
            logger.info(LargeNumberUtils.compare("21398749817492913981900312834340831", "7216738721892389436456905428712347123467"));
        } catch (NotNumberException ex) {
            logger.error(ex.getMessage());
        }
    }
}
