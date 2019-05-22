package pers.hai.util.commons;

import org.junit.Test;
import pers.hai.util.commons.nums.RandomCore;

/**
 * TODO
 * <p>
 * Create Time: 2019-05-22 16:52
 * Last Modify: 2019-05-22
 *
 * @author Q-WHai
 * @see <a href="https://github.com/qwhai">https://github.com/qwhai</a>
 */
public class RandomCoreTest extends Testable {

    @Test
    public void test1() {
        RandomCore random = new RandomCore(100);
        logger.info(random.nextInt());
    }

    @Test
    public void test2() {
        RandomCore random = new RandomCore(100);
        logger.info(random.nextInt(2, 90));
    }

    @Test
    public void test3() {
        RandomCore random = new RandomCore(100);
        logger.info(random.randomSet(100, 5));
    }

    @Test
    public void test4() {
        RandomCore random = new RandomCore();
        logger.info(random.randomSet(90, 100, 5));
    }

    @Test
    public void test_5() {
        RandomCore random = new RandomCore();
        logger.info(random.randomSetByFloyd(90, 100, 5));
    }

    @Test
    public void test6() {
        RandomCore random = new RandomCore();
        logger.info(random.randomList(90, 5));
    }

    @Test
    public void test7() {
        RandomCore random = new RandomCore();
        logger.info(random.randomSum(90, 5));
    }
}
