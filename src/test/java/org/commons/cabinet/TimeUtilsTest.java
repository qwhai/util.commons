package org.commons.cabinet;

import org.commons.cabinet.datetime.TimeUtils;
import org.junit.Test;

/**
 * @Author: Q-WHai
 * @Date: Created in 17:58 2019/05/10
 */
public class TimeUtilsTest extends Testable {

    @Test
    public void test1() {
        long millis = TimeUtils.currentTimeMillis();
        logger.info(millis);
    }

    @Test
    public void test2() {
        int seconds = TimeUtils.currentTimeSeconds();
        logger.info(seconds);
    }
}
