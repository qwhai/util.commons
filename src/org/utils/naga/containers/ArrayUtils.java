package org.utils.naga.containers;

import java.util.Arrays;
import java.util.List;

import org.utils.naga.chars.CharUtils;
import org.utils.naga.excep.CannotInstanceException;
import org.utils.naga.excep.LengthZeroException;
import org.utils.naga.excep.NotNumberException;
import org.utils.naga.str.StringUtils;

/**
 * <p>
 * 这个是一个数组工具类，处理与数组相关的操作
 * </p>
 * 2015‎年‎11‎月‎25‎日
 * 
 * @author <a href="http://weibo.com/u/5131020927">Q-WHai</a>
 * @see <a href="http://blog.csdn.net/lemon_tree12138">http://blog.csdn.net/lemon_tree12138</a>
 * @version 0.1.1
 */
public final class ArrayUtils extends ContainerUtils {

    // 禁止实例化
    private ArrayUtils() throws CannotInstanceException {
        throw new CannotInstanceException("不要试图实例化我");
    }
    
    @Override
    public String getTag() {
        return this.getClass().getName();
    }
    
    @Override
    public void description() {
        System.out.println("这个是一个数组工具类，处理与数组相关的操作");
    }
    
    /**
     * 把字符串数组逐个添加到List列表中
     * 
     * @param list
     *          被添加的List列表
     * @param array
     *          待添加的字符串数组
     */
    public static void addStringArrayToList(List<String> list, String[] array) {
        if (list == null || array == null || array.length == 0) {
            return;
        }
        
        for (String string : array) {
            list.add(string);
        }
    }

    /**
     * 获得数组中的最大值
     * 
     * @param array
     *      待比较的数组
     * @return
     *      最大值
     * @throws LengthZeroException
     *      LengthZeroException
     */
    public static int maxValue(int[] array) throws LengthZeroException {
        if (array.length == 0) {
            throw new LengthZeroException("");
        }

        int max = array[0];
        for (int data : array) {
            if (max < data) {
                max = data;
            }
        }

        return max;
    }
    
    /**
     * 获得数组中的最大值
     * 
     * @param array
     *      待比较的数组
     * @return
     *      最大值
     * @throws LengthZeroException
     *      LengthZeroException
     */
    public static long maxValue(long[] array) throws LengthZeroException {
        if (array.length == 0) {
            throw new LengthZeroException("");
        }

        long max = array[0];
        for (long data : array) {
            if (max < data) {
                max = data;
            }
        }

        return max;
    }
    
    /**
     * 获得数组中的最大值
     * 
     * @param array
     *      待比较的数组
     * @return
     *      最大值
     * @throws LengthZeroException
     *      LengthZeroException
     */
    public static double maxValue(double[] array) throws LengthZeroException {
        if (array.length == 0) {
            throw new LengthZeroException("");
        }

        double max = array[0];
        for (double data : array) {
            if (max < data) {
                max = data;
            }
        }

        return max;
    }
    
    /**
     * 获得数组中的最大值
     * 
     * @param array
     *      待比较的数组
     * @return
     *      最大值
     * @throws LengthZeroException
     *      LengthZeroException
     */
    public static float maxValue(float[] array) throws LengthZeroException {
        if (array.length == 0) {
            throw new LengthZeroException("");
        }

        float max = array[0];
        for (float data : array) {
            if (max < data) {
                max = data;
            }
        }

        return max;
    }
    
    /**
     * 求数组中一个连续子序列和的最大值
     * 
     * @param array
     *      输入数组
     * @return
     *      最大和
     */
    public static int maxSum(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        
        int maxEndIndex = 0;
        int maxSum = 0;
        int length = array.length;
        for (int i = 0; i < length; i++) {
            maxEndIndex = Math.max(maxEndIndex + array[i], 0);
            maxSum = Math.max(maxSum, maxEndIndex);
        }
        
        return maxSum;
    }
    
    /**
     * 求数组中一个连续子序列和的最大值
     * 
     * @param array
     *      输入数组
     * @return
     *      最大和
     */
    public static long maxSum(long[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        
        long maxEndIndex = 0;
        long maxSum = 0;
        int length = array.length;
        for (int i = 0; i < length; i++) {
            maxEndIndex = Math.max(maxEndIndex + array[i], 0);
            maxSum = Math.max(maxSum, maxEndIndex);
        }
        
        return maxSum;
    }
    
    /**
     * 求数组中一个连续子序列和的最大值
     * 
     * @param array
     *      输入数组
     * @return
     *      最大和
     */
    public static float maxSum(float[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        
        float maxEndIndex = 0;
        float maxSum = 0;
        int length = array.length;
        for (int i = 0; i < length; i++) {
            maxEndIndex = Math.max(maxEndIndex + array[i], 0);
            maxSum = Math.max(maxSum, maxEndIndex);
        }
        
        return maxSum;
    }
    
    /**
     * 求数组中一个连续子序列和的最大值
     * 
     * @param array
     *      输入数组
     * @return
     *      最大和
     */
    public static double maxSum(double[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        
        double maxEndIndex = 0;
        double maxSum = 0;
        int length = array.length;
        for (int i = 0; i < length; i++) {
            maxEndIndex = Math.max(maxEndIndex + array[i], 0);
            maxSum = Math.max(maxSum, maxEndIndex);
        }
        
        return maxSum;
    }
    
    /**
     * 打印数组
     * 
     * @param objects
     *      数组
     */
    public static void show(Object[] objects) {
        System.out.println(Arrays.toString(objects));
    }
    
    /**
     * 打印数组
     * 
     * @param array
     *      数组
     */
    public static void show(byte[] array) {
        System.out.println(Arrays.toString(array));
    }
    
    /**
     * 打印数组
     * 
     * @param array
     *      数组
     */
    public static void show(int[] array) {
        System.out.println(Arrays.toString(array));
    }
    
    /**
     * 打印数组
     * 
     * @param array
     *      数组
     */
    public static void show(long[] array) {
        System.out.println(Arrays.toString(array));
    }
    
    /**
     * 打印数组
     * 
     * @param array
     *      数组
     */
    public static void show(float[] array) {
        System.out.println(Arrays.toString(array));
    }
    
    /**
     * 打印数组
     * 
     * @param array
     *      数组
     */
    public static void show(double[] array) {
        System.out.println(Arrays.toString(array));
    }
    
    /**
     * 将整型数组中的第i个数与第j个数进行交换
     * 
     * @param array
     *      整型数组
     * @param i
     *      第1个数的下标
     * @param j
     *      第2个数的下标
     */
    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    
    /**
     * 将一个数字字符串转化为整型数组
     * 
     * @param number
     *      数字字符串
     * @return
     *      整型数组
     * @throws NotNumberException 
     *      非数字异常
     */
    public static int[] transfromToIntegerArray(String number) throws NotNumberException {
        if (StringUtils.isEmpty(number)) {
            return null;
        }
        
        char[] chars = number.toCharArray();
        int length = chars.length;
        int[] numbers = new int[length];
        for (int i = 0; i < length; i++) {
            if (!CharUtils.isNumberChar(chars[i])) {
                throw new NotNumberException(number + "传入的参数不是数字");
            }
            
            numbers[i] = Integer.parseInt(String.valueOf(chars[i]));
        }
        
        return numbers;
    }
}
