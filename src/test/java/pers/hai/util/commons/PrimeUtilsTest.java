package pers.hai.util.commons;

import org.junit.Assert;
import org.junit.Test;
import pers.hai.util.commons.nums.PrimeUtils;

import java.util.Arrays;

/**
 * TODO
 * <p>
 * Create Time: 2019-05-22 16:24
 * Last Modify: 2019-05-22
 *
 * @author Q-WHai
 * @see <a href="https://github.com/qwhai">https://github.com/qwhai</a>
 */
public class PrimeUtilsTest extends Testable {

    @Test
    public void test1() {
        Assert.assertTrue(PrimeUtils.isPrime(13));
        Assert.assertTrue(PrimeUtils.isPrime(17));
        Assert.assertTrue(PrimeUtils.isPrime(3));
        Assert.assertTrue(PrimeUtils.isPrime(2));
        Assert.assertTrue(PrimeUtils.isPrime(101));
    }

    @Test
    public void test2() {
        Assert.assertFalse(PrimeUtils.isPrime(12));
        Assert.assertFalse(PrimeUtils.isPrime(16));
        Assert.assertFalse(PrimeUtils.isPrime(4));
        Assert.assertFalse(PrimeUtils.isPrime(20));
        Assert.assertFalse(PrimeUtils.isPrime(100));
    }

    @Test
    public void test3() {
        int[] primes = PrimeUtils.primesByBoundary(2, 1000);
        logger.info(Arrays.toString(primes));
    }

    @Test
    public void test4() {
        int[] primes = PrimeUtils.primesByCount(20);
        logger.info(Arrays.toString(primes));
    }
}
