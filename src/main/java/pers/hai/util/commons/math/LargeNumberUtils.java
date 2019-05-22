package pers.hai.util.commons.math;

import pers.hai.util.commons.str.StringUtils;
import pers.hai.util.commons.consts.ComparativeSize;
import pers.hai.util.commons.containers.ArrayUtils;
import pers.hai.util.commons.excep.NotNumberException;
import pers.hai.util.commons.excep.ParameterException;

/**
 * <p>
 * 大数运算
 * </p>
 * Create Date: 2015-12-09
 * Last Modify: 2019-05-22
 * 
 * @author Q-WHai
 * @see <a href="https://github.com/qwhai">https://github.com/qwhai</a>
 */
public class LargeNumberUtils {

    /**
     * 大数加法
     * 
     * @param   num1
     *          大数1
     *
     * @param   num2
     *          大数2
     *
     * @return  加法和值
     *
     * @throws  NotNumberException
     *          非数字异常
     */
    public static String add(String num1, String num2) throws NotNumberException {
        if (!StringUtils.RegexUtils.isNumberString(num1) || !StringUtils.RegexUtils.isNumberString(num2))
            throw new NotNumberException("The incoming parameter is not a number.");
        
        int[] nums1 = ArrayUtils.transfromToIntegerArray(StringUtils.reverseString(num1));
        int[] nums2 = ArrayUtils.transfromToIntegerArray(StringUtils.reverseString(num2));
        if (null == nums1 || null == nums2) return "";

        int length1 = nums1.length;
        int length2 = nums2.length;
        
        int minLength = Math.min(length1, length2);
        int maxLength = Math.max(length1, length2);
        int[] result = new int[maxLength + 1];
        
        // 先逐位相加
        for (int index = 0; index < minLength; index++)
            result[index] = nums1[index] + nums2[index];
        
        // 余位补足
        if (length1 > minLength)
            for (int i = minLength; i < maxLength; i++)
                result[i] = nums1[i];
        else if (length2 > minLength)
            for (int i = minLength; i < maxLength; i++)
                result[i] = nums2[i];
        
        // 进位处理
        carry(result);
        
        return combination(result);
    }
    
    /**
     * 大数减法
     * 
     * @param   num1
     *          被减数
     *
     * @param   num2
     *          减数
     *
     * @return  大数减法值
     *
     * @throws  NotNumberException
     *          非数字异常
     */
    public static String sub(String num1, String num2) throws NotNumberException {
        if (!StringUtils.RegexUtils.isNumberString(num1) || !StringUtils.RegexUtils.isNumberString(num2))
            throw new NotNumberException("The incoming parameter is not a number.");

        ComparativeSize comparativeSize = compare(num1, num2);
        String resultSign = "";
        if (ComparativeSize.Equal == comparativeSize)
            return "0";
        else if (ComparativeSize.Small == comparativeSize) {
            String swap = num1;
            num1 = num2;
            num2 = swap;
            
            resultSign = "-";
        }
        
        int[] nums1 = ArrayUtils.transfromToIntegerArray(StringUtils.reverseString(num1));
        int[] nums2 = ArrayUtils.transfromToIntegerArray(StringUtils.reverseString(num2));
        if (null == nums1 || null == nums2) return "";

        int length1 = nums1.length;
        int length2 = nums2.length;
        
        int[] result = new int[Math.max(length1, length2) + 1];
        
        int minLength = Math.min(length1, length2);
        int maxLength = Math.max(length1, length2);
        
        // 逐位相减
        for (int i = 0; i < minLength; i++)
            result[i] = nums1[i] - nums2[i];
        
        // 余位补充
        for (int i = minLength; i < maxLength; i++)
            result[i] = nums1[i];
        
        // 借位处理
        borrow(result);
        
        return resultSign + combination(result);
    }
    
    /**
     * 大数乘法
     * 
     * @param   num1
     *          乘数1
     *
     * @param   num2
     *          乘数2
     *
     * @return  大数乘法乘积
     *
     * @throws  NotNumberException
     *          参数不是数字
     */
    public static String mul(String num1, String num2) throws NotNumberException {
        if (!StringUtils.RegexUtils.isNumberString(num1) || !StringUtils.RegexUtils.isNumberString(num2))
            throw new NotNumberException("The incoming parameter is not a number.");

        int[] nums1 = ArrayUtils.transfromToIntegerArray(StringUtils.reverseString(num1));
        int[] nums2 = ArrayUtils.transfromToIntegerArray(StringUtils.reverseString(num2));
        if (null == nums1 || null == nums2) return "";

        int length1 = nums1.length;
        int length2 = nums2.length;
        
        // 两数乘积位数不会超过乘数位数和+ 3位
        int cacheLength = length1 + length2 + 3;
        int[] result = new int[cacheLength];

        // 逐位相乘
        for (int i = 0; i < length1; i++)
            for (int j = 0; j < length2; j++)
                result[i + j] += (nums1[i] * nums2[j]);
        
        // 进位
        carry(result);
        
        return combination(result);
    }
    
    /**
     * 大数除法
     * (num1 / num2)
     * 
     * TODO
     * @param   num1
     *          被除数
     *
     * @param   num2
     *          除数
     *
     * @return
     *          商
     *
     * @throws  NotNumberException
     *          非数字异常
     *
     * @throws  ParameterException
     *          参数大小关系异常
     */
    public static String div(String num1, String num2) throws NotNumberException, ParameterException {
        ComparativeSize compare = compare(num1, num2);
        if (compare == ComparativeSize.Small)
            throw new ParameterException("输入的参数大小关系有误");
        else if (compare == ComparativeSize.Equal)
            return "1";
        
        int length1 = num1.length();
        int length2 = num2.length();
        for (int i = 0; i <= length2 - length1; i++) {
            // TODO
        }
        
        return null;
    }
    
    /**
     * 大数求余
     * 
     * TODO
     * @param string1
     *      被除数
     * @param string2
     *      除数
     * @return
     *      商
     * @throws NotNumberException
     *      非数字异常
     */
    public static String rem(String string1, String string2) throws NotNumberException {
        return null;
    }
    
    /**
     * 大数阶乘
     * 
     * TODO
     * @param number
     *      阶乘次数
     * @return
     *      阶乘
     */
    public static String fac(String number) {
        
        return null;
    }
    
    /**
     * 比较两个大数的大小
     * 
     * @param num1
     *      大数
     * @param num2
     *      大数
     * @return
     *      大小结果
     * @throws NotNumberException
     *      非数字异常
     */
    public static ComparativeSize compare(String num1, String num2) throws NotNumberException {
        if (!StringUtils.RegexUtils.isNumberString(num1) || !StringUtils.RegexUtils.isNumberString(num2))
            throw new NotNumberException("The incoming parameter is not a number.");
        
        int[] nums1 = ArrayUtils.transfromToIntegerArray(num1);
        int[] nums2 = ArrayUtils.transfromToIntegerArray(num2);
        int length1 = nums1.length;
        int length2 = nums2.length;
        
        if (length1 > length2)
            return ComparativeSize.Bigger;
        else if (length1 < length2)
            return ComparativeSize.Small;
        
        for (int i = 0; i < length1; i++) {
            if (nums1[i] > nums2[i])
                return ComparativeSize.Bigger;
            else if (nums1[i] < nums2[i])
                return ComparativeSize.Small;
        }
        
        return ComparativeSize.Equal;
    }

    // ------------------------------------------------- 内部方法分隔线 --------------------------------------------------
    
    // 将一个数字数组拼接成一个字符串，注意这里需要倒置
    private static String combination(int[] numbers) {
        StringBuilder buffer = new StringBuilder();
        boolean started = false;
        for (int i = numbers.length - 1; i >= 0; i--) {
            if (!started && 0 != numbers[i])
                started = true;
            
            if (started)
                buffer.append(String.format("%d", numbers[i]));
        }
        
        return started ? buffer.toString() : "0";
    }
    
    // 对逐位操作的结果进行进位操作
    private static void carry(int[] numbers) {
        int cacheLength = numbers.length;
        
        for (int i = 0; i < cacheLength; i++) {
            int carry = numbers[i] / 10; // 进位
            numbers[i] = numbers[i] % 10;
            
            if (0 < carry)
                numbers[i + 1] += carry;
        }
    }
    
    // 对逐位操作的结果进行借位操作
    private static void borrow(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            if (0 > numbers[i]) {
                numbers[i] += 10;
                numbers[i + 1]--;
            }
        }
    }
}
