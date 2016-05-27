package org.core.utils.math;

import org.core.utils.consts.ComparativeSize;
import org.core.utils.containers.ArrayUtils;
import org.core.utils.excep.CannotInstanceException;
import org.core.utils.excep.NotNumberException;
import org.core.utils.excep.ParameterException;
import org.core.utils.interf.UtilsInterface;
import org.core.utils.str.StringUtils;

/**
 * <p>
 * 大数运算
 * </p>
 * Create Date: 2015年12月9日
 * Last Modify: 2016年5月26日
 * 
 * @author <a href="http://weibo.com/u/5131020927">Q-WHai</a>
 * @see <a href="http://blog.csdn.net/lemon_tree12138">http://blog.csdn.net/lemon_tree12138</a>
 * @version 0.1.1
 */
public class LargeNumberUtils implements UtilsInterface {

    // 工具类，禁止实例化
    private LargeNumberUtils() throws CannotInstanceException {
        throw new CannotInstanceException("请不要试图实例化我");
    }
    
    @Override
    public String getTag() {
        return getClass().getName();
    }

    @Override
    public void description() {
        System.out.println("此类是进行一些大数的运算。包括大数加法，大数减法，大数乘法、大数除法还有大数阶乘.");
    }

    /**
     * 大数加法
     * 
     * @param string1
     *      加数
     * @param string2
     *      加数
     * @return
     *      和
     * @throws NotNumberException
     *      非数字异常
     */
    public static String addition(String string1, String string2) throws NotNumberException {
        if (!StringUtils.RegexUtils.isNumberString(string1) || !StringUtils.RegexUtils.isNumberString(string2)) {
            throw new NotNumberException("传入的参数不是数字");
        }
        
        int[] nums1 = ArrayUtils.transfromToIntegerArray(StringUtils.reverseString(string1));
        int[] nums2 = ArrayUtils.transfromToIntegerArray(StringUtils.reverseString(string2));
        int length1 = nums1.length;
        int length2 = nums2.length;
        
        int minLength = Math.min(length1, length2);
        int maxLength = Math.max(length1, length2);
        int[] result = new int[maxLength + 1];
        
        // 先逐位相加
        for (int index = 0; index < minLength; index++) {
            result[index] = nums1[index] + nums2[index];
        }
        
        // 余位补足
        if (length1 > minLength) {
            for (int i = minLength; i < maxLength; i++) {
                result[i] = nums1[i];
            }
        } else if (length2 > minLength) {
            for (int i = minLength; i < maxLength; i++) {
                result[i] = nums2[i];
            }
        }
        
        // 进位处理
        carry(result);
        
        return combination(result);
    }
    
    /**
     * 大数减法
     * 
     * @param string1
     *      被减数
     * @param string2
     *      减数
     * @return
     *      结果
     * @throws NotNumberException
     *      非数字异常
     */
    public static String subtraction(String string1, String string2) throws NotNumberException {
        ComparativeSize comparativeSize = compare(string1, string2);
        String resultSign = "";
        if (comparativeSize == ComparativeSize.Equal) {
            return "0";
        } else if (comparativeSize == ComparativeSize.Small) {
            String swap = string1;
            string1 = string2;
            string2 = swap;
            
            resultSign = "-";
        }
        
        int[] nums1 = ArrayUtils.transfromToIntegerArray(StringUtils.reverseString(string1));
        int[] nums2 = ArrayUtils.transfromToIntegerArray(StringUtils.reverseString(string2));
        int length1 = nums1.length;
        int length2 = nums2.length;
        
        int[] result = new int[Math.max(length1, length2) + 1];
        
        int minLength = Math.min(length1, length2);
        int maxLength = Math.max(length1, length2);
        
        // 逐位相减
        for (int i = 0; i < minLength; i++) {
            result[i] = nums1[i] - nums2[i];
        }
        
        // 余位补充
        for (int i = minLength; i < maxLength; i++) {
            result[i] = nums1[i];
        }
        
        // 借位处理
        borrow(result);
        
        return resultSign + combination(result);
    }
    
    /**
     * 大数乘法
     * 
     * @param string1
     *      乘数
     * @param string2
     *      乘数
     * @return
     *      乘积
     * @throws NotNumberException
     *      参数不是数字
     */
    public static String multiplication(String string1, String string2) throws NotNumberException {
        int[] nums1 = ArrayUtils.transfromToIntegerArray(StringUtils.reverseString(string1));
        int[] nums2 = ArrayUtils.transfromToIntegerArray(StringUtils.reverseString(string2));
        
        int length1 = nums1.length;
        int length2 = nums2.length;
        
        // 两数乘积位数不会超过乘数位数和+ 3位
        int cacheLength = length1 + length2 + 3;
        int[] result = new int[cacheLength];

        // 逐位相乘
        for (int i = 0; i < length1; i++) {
            for (int j = 0; j < length2; j++) {
                result[i + j] += (nums1[i] * nums2[j]);
            }
        }
        
        // 进位
        carry(result);
        
        return combination(result);
    }
    
    /**
     * 大数除法
     * (string1 / string2)
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
     * @throws ParameterException
     *      参数大小关系异常
     */
    public static String division(String string1, String string2) throws NotNumberException, ParameterException {
        ComparativeSize compare = compare(string1, string2);
        if (compare == ComparativeSize.Small) {
            throw new ParameterException("输入的参数大小关系有误");
        } else if (compare == ComparativeSize.Equal) {
            return "1";
        }
        
        int length1 = string1.length();
        int length2 = string2.length();
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
    public static String remainder(String string1, String string2) throws NotNumberException {
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
    public static String factorial(String number) {
        
        return null;
    }
    
    /**
     * 比较两个大数的大小
     * 
     * @param string1
     *      大数
     * @param string2
     *      大数
     * @return
     *      大小结果
     * @throws NotNumberException
     *      非数字异常
     */
    public static ComparativeSize compare(String string1, String string2) throws NotNumberException {
        if (!StringUtils.RegexUtils.isNumberString(string1) || !StringUtils.RegexUtils.isNumberString(string2)) {
            throw new NotNumberException("传入的参数不是数字");
        }
        
        int[] nums1 = ArrayUtils.transfromToIntegerArray(string1);
        int[] nums2 = ArrayUtils.transfromToIntegerArray(string2);
        int length1 = nums1.length;
        int length2 = nums2.length;
        
        if (length1 > length2) {
            return ComparativeSize.Bigger;
        } else if (length1 < length2) {
            return ComparativeSize.Small;
        }
        
        for (int i = 0; i < length1; i++) {
            if (nums1[i] > nums2[i]) {
                return ComparativeSize.Bigger;
            } else if (nums1[i] < nums2[i]) {
                return ComparativeSize.Small;
            }
        }
        
        return ComparativeSize.Equal;
    }
    
    // 将一个数字数组拼接成一个字符串，注意这里需要倒置
    private static String combination(int[] numbers) {
        StringBuffer buffer = new StringBuffer();
        boolean started = false;
        for (int i = numbers.length - 1; i >= 0; i--) {
            if (!started && numbers[i] != 0) {
                started = true;
            }
            
            if (started) {
                buffer.append(String.valueOf(numbers[i]));
            }
        }
        
        return started ? buffer.toString() : "0";
    }
    
    // 对逐位操作的结果进行进位操作
    private static void carry(int[] numbers) {
        int cacheLength = numbers.length;
        
        for (int i = 0; i < cacheLength; i++) {
            int carry = numbers[i] / 10; // 进位
            numbers[i] = numbers[i] % 10;
            
            if (carry > 0) {
                numbers[i + 1] += carry;
            }
        }
    }
    
    // 对逐位操作的结果进行借位操作
    private static void borrow(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < 0) {
                numbers[i] += 10;
                numbers[i + 1]--;
            }
        }
    }
}
