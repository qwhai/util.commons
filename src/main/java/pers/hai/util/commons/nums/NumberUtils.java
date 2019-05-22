package pers.hai.util.commons.nums;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 数字通用工具
 *
 * Create Date: 2015-11-25
 * Last Modify: 2019-05-22
 * 
 * @author Q-WHai
 * @see <a href="https://github.com/qwhai">https://github.com/qwhai</a>
 */
public class NumberUtils {

    /**
     * 产生一个从Integer.MIN_VALUE到Integer.MAX_VALUE的随机数
     * 
     * @return  随机数
     */
    @Deprecated
    public static int randomInteger() {
        return new Random().nextInt();
    }
    
    /**
     * 产生一个从0到(limit - 1)的随机数
     * 
     * @param   limit
     *          随机数上限
     *
     * @return  随机数
     */
    @Deprecated
    public static int randomInteger(int limit) {
        return new Random().nextInt(limit);
    }
    
    /**
     * 产生一个[num1, num2]之间的随机数
     * 
     * @param   num1
     *          第一个边界
     *
     * @param   num2
     *          第二个边界
     *
     * @return  随机数
     */
    @Deprecated
    public static int randomInteger(int num1, int num2) {
        return new Random().nextInt(Math.abs(num2 - num1) + 1) + Math.min(num1, num2);
    }
    
    /**
     * 统计一个数的所有因子
     * 
     * @param   n
     *          待统计的数字
     *
     * @return  因子集合
     */
    public static List<Integer> factors(int n) {
        if (0 >= n)
            return null;
        
        List<Integer> factors = new ArrayList<>();
        int half = n / 2;
        for (int i = 1; i <= half; i++)
            if (n % i == 0)
                factors.add(i);
        
        return factors;
    }
    
    /**
     * 求最大公约数
     * 
     * @param   num1
     *          数字1
     *
     * @param   num2
     *          数字2
     *
     * @return  最大公约数
     */
    public static int maxCommonDivisor(int num1, int num2) {
        return num1 >= num2 ? maxCommonDivisorCore(num1, num2) : maxCommonDivisorCore(num2, num1);
    }

    // ------------------------------------------------- 内部方法分隔线 --------------------------------------------------

    /**
     * 求最大公约数计算器
     * 
     * @param   num1
     *          数字1
     *
     * @param   num2
     *          数字2
     *
     * @return  最大公约数
     */
    private static int maxCommonDivisorCore(int num1, int num2) {
        return (0 == num1 % num2) ? num2 : maxCommonDivisorCore(num2, num1 % num2);
    }
}
