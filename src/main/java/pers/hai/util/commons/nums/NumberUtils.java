package pers.hai.util.commons.nums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Stack;

import pers.hai.util.commons.str.StringUtils;
import pers.hai.util.commons.excep.CannotInstanceException;

/**
 * <p>
 * 这个是关于数字相关的工具类
 * </p>
 * Create Date: 2015年11月25日
 * Last Modify: 2016年5月26日
 * 
 * @author Q-WHai
 * @see <a href="https://github.com/qwhai">https://github.com/qwhai</a>
 */
public class NumberUtils {

    // 禁止实例化
    private NumberUtils() throws CannotInstanceException {
        throw new CannotInstanceException("不要试图实例化我");
    }

    /**
     * 产生一个从Integer.MIN_VALUE到Integer.MAX_VALUE的随机数
     * 
     * @return
     *      随机数
     */
    @Deprecated
    public static int randomInteger() {
        return new Random().nextInt();
    }
    
    /**
     * 产生一个从0到(limit - 1)的随机数
     * 
     * @param limit
     *      随机数上限
     * @return
     *      随机数
     */
    @Deprecated
    public static int randomInteger(int limit) {
        return new Random().nextInt(limit);
    }
    
    /**
     * 产生一个[num1, num2]之间的随机数
     * 
     * @param num1
     *      第一个边界
     * @param num2
     *      第二个边界
     * @return
     *      随机数
     */
    @Deprecated
    public static int randomInteger(int num1, int num2) {
        return new Random().nextInt(Math.abs(num2 - num1) + 1) + Math.min(num1, num2);
    }
    
    /**
     * 统计一个数的所有因子
     * 
     * @param n
     *      待统计的数字
     * @return
     *      因子集合
     */
    public static List<Integer> factors(int n) {
        if (n <= 0) {
            return null;
        }
        
        List<Integer> factors = new ArrayList<>();
        int half = n / 2;
        for (int i = 1; i <= half; i++) {
            if (n % i == 0) {
                factors.add(i);
            }
        }
        
        return factors;
    }
    
    /**
     * 求最大公约数
     * 
     * @param num1
     *      数字1
     * @param num2
     *      数字2
     * @return
     *      最大公约数
     */
    public static int maxCommonDivisor(int num1, int num2) {
        return num1 >= num2 ? maxCommonDivisorCore(num1, num2) : maxCommonDivisorCore(num2, num1);
    }
    
    /*
     * 求最大公约数计算器
     * 
     * @param num1
     *      数字1
     * @param num2
     *      数字2
     * @return
     *      最大公约数
     */
    private static int maxCommonDivisorCore(int num1, int num2) {
        if (num1 % num2 == 0) {
            return num2;
        }
        
        return maxCommonDivisorCore(num2, num1 % num2);
    }
    
    // TODO ------------------------------------------- 内部类标识分隔线 ----------------------------------------------------------
    
    /**
     * <p>
     * 与素数相关的工具类
     * </p>
     * 2015年12月22日
     * 
     * @author Q-WHai
     * @see <a href="http://blog.csdn.net/lemon_tree12138">http://blog.csdn.net/lemon_tree12138</a>1
     */
    public static class PrimeUtils {

        /**
         * 判断一个数是否是素数
         * 
         * @param number
         *      整型数值
         * @return
         *      是否是素数
         */
        public static boolean isPrime(int number) {
            if (number < 2) {
                return false;
            }
            
            int j;
            double legalBoundary = Math.sqrt(number);
            for (j = 2; j < legalBoundary; j++) {
                if (number % j == 0) {
                    break;
                }
            }
            
            if (j > legalBoundary) {
                return true;
            }
            
            return false;
        }
        
        /**
         * 带边界的素数数组
         * 
         * @param start
         *      起始边界
         * @param end
         *      结束边界
         * @return
         *      素数数组
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
         * @param count
         *      素数个数
         * @return
         *      素数数组
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
    } // PrimeUtils
    
    // TODO ------------------------------------------- 内部类标识分隔线 ----------------------------------------------------------
    
    /**
     * 
     * <p>
     * 一个进制转化工具
     * </p>
     * 2015年11月25日
     * 
     * @author Q-WHai
     * @see <a href="http://blog.csdn.net/lemon_tree12138">http://blog.csdn.net/lemon_tree12138</a>
     */
    public static class HexUtils {
        
        // 禁止实例化
        private HexUtils() throws CannotInstanceException {
            throw new CannotInstanceException("不要试图实例化我");
        }
        
        /**
         * 将一个数从 十进制转为任意进制
         * 
         * @param num
         *      待转化的数
         * @param destBase
         *      目标进制
         * @return
         *      转化后的数字表示
         */
        public static String transformDecimal(int num, int destBase) {
            if (destBase > 16) {
                throw new RuntimeException("进制数超出范围，base<=16");
            }
            
            StringBuffer str = new StringBuffer("");
            String digths = "0123456789ABCDEF";
            Stack<Character> s = new Stack<Character>();
            while (num != 0) {
                s.push(digths.charAt(num % destBase));
                num /= destBase;
            }
            while (!s.isEmpty()) {
                str.append(s.pop());
            }
            return str.toString();
        }

        /**
         * 16进制内任意进制转换
         * 
         * @param number
         *      待转化的数字
         * @param srcBase
         *      原进制
         * @param destBase
         *      目标进制
         * @return
         *      转化后的数字表示
         */
        public static String transformAnyway(String number, int srcBase, int destBase) {
            if (StringUtils.isEmpty(number)) {
                throw new NullPointerException("待转化的数字不能为空");
            }
            
            if (srcBase == destBase) {
                return number;
            }
            
            String digths = "0123456789ABCDEF";
            char[] chars = number.toCharArray();
            int len = chars.length;
            if (destBase != 10) {
                // 目标进制不是十进制 先转化为十进制
                number = transformAnyway(number, srcBase, 10);
            } else {
                int n = 0;
                for (int i = len - 1; i >= 0; i--) {
                    n += digths.indexOf(chars[i]) * Math.pow(srcBase, len - i - 1);
                }
                return n + "";
            }
            
            return transformDecimal(Integer.valueOf(number), destBase);
        }
    } // HexUtils
}
