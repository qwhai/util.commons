package pers.hai.util.commons.nums;

import java.util.Arrays;

/**
 * 素数处理工具
 *
 * Create Time: 2015-12-22
 * Last Modify: 2019-05-22
 *
 * @author Q-WHai
 * @see <a href="http://blog.csdn.net/lemon_tree12138">http://blog.csdn.net/lemon_tree12138</a>1
 */
public class PrimeUtils {

    /**
     * 判断一个数是否是素数
     *
     * @param   number
     *          整型数值
     *
     * @return  是否是素数
     */
    public static boolean isPrime(int number) {
        if (number < 2)
            return false;

        int j;
        double legalBoundary = Math.sqrt(number);
        for (j = 2; j < legalBoundary; j++) {
            if (number % j == 0)
                break;
        }

        return j > legalBoundary;
    }

    /**
     * 带边界的素数数组
     *
     * @param   start
     *          起始边界
     *
     * @param   end
     *          结束边界
     *
     * @return  素数数组
     */
    public static int[] primesByBoundary(int start, int end) {
        int[] primeNumbers = new int[1];
        int primeIndex = 0;

        for (int num = start; num <= end; num++) {
            if (isPrime(num)) {
                if (primeIndex >= primeNumbers.length) {
                    primeNumbers = Arrays.copyOf(primeNumbers, primeIndex + 1);
                }
                primeNumbers[primeIndex++] = num;
            }
        }

        return primeNumbers;
    }

    /**
     * 输出指定个数的素数
     *
     * @param   count
     *          素数个数
     *
     * @return  素数数组
     */
    public static int[] primesByCount(int count) {
        int[] primeNumbers = new int[count];
        int primeIndex = 0;

        int num = 2;
        while(primeIndex < count) {
            if (isPrime(num)) {
                if (primeIndex >= primeNumbers.length) {
                    primeNumbers = Arrays.copyOf(primeNumbers, primeIndex + 1);
                }
                primeNumbers[primeIndex++] = num;
            }

            ++num;
        }

        return primeNumbers;
    }
}