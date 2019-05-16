package pers.hai.util.commons;

import pers.hai.util.commons.filter.BloomFilter;
import org.junit.Assert;
import org.junit.Test;

/**
 * @Author: Q-WHai
 * @Date: Created in 18:36 2019/05/10
 */
public class BloomFilterTest extends Testable {

    @Test
    public void test1() {
        BloomFilter filter = new BloomFilter();
        filter.add("6a746f91-0d07-47e6-92c2-8170c1774f7c");
        filter.add("fc259117-751b-40d0-9ee5-9514802137e4");
        filter.add("ac9d566d-5fac-4a91-8653-6c49c0e22255");

        Assert.assertTrue(filter.contains("fc259117-751b-40d0-9ee5-9514802137e4"));
        Assert.assertFalse(filter.contains("d385cab2-d15d-45c6-8866-a263fd62e2c6"));
    }
}
