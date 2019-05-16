package pers.hai.util.commons.containers;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import pers.hai.util.commons.chars.CharUtils;
import pers.hai.util.commons.excep.LengthZeroException;
import pers.hai.util.commons.excep.NotNumberException;
import pers.hai.util.commons.str.StringUtils;

/**
 * 这个是一个数组工具类，处理与数组相关的操作
 *
 * Create Date: 2015‎-‎11‎-‎25
 * Last Modify: 2019-05-16
 * 
 * @author Q-WHai
 * @see <a href="https://github.com/qwhai">https://github.com/qwhai</a>
 */
public final class ArrayUtils {

    /**
     * 把字符串数组逐个添加到List列表中
     *
     * @param   list
     *          被添加的List列表
     *
     * @param   arr
     *          待添加的字符串数组
     *
     * @param   <T>
     *          范型类型
     */
    public static <T> void copyToList(List<T> list, T[] arr) {
        Collections.addAll(list, arr);
    }

    /**
     * 把字符串数组逐个添加到List列表中
     *
     * @param   list
     *          被添加的List列表
     *
     * @param   arr
     *          待添加的字符串数组
     *
     * @param   start
     *          开始拷贝的下标
     *
     * @param   <T>
     *          范型类型
     */
    public static <T> void copyToList(List<T> list, T[] arr, int start) {
        copyToList(list, arr, start, arr.length - start);
    }

    /**
     * 把字符串数组逐个添加到List列表中
     *
     * @param   list
     *          被添加的List列表
     *
     * @param   arr
     *          待添加的字符串数组
     *
     * @param   start
     *          开始拷贝的下标
     *
     * @param   length
     *          拷贝长度
     *
     * @param   <T>
     *          范型类型
     */
    public static <T> void copyToList(List<T> list, T[] arr, int start, int length) {
        int end = Math.min(arr.length, start + length);
        for (int i = start; i < end; i++) {
            list.add(arr[i]);
        }
    }

    /**
     * 获得数组中的最大值
     * 
     * @param   arr
     *          待比较的数组
     *
     * @return  最大值
     *
     * @throws LengthZeroException
     *          LengthZeroException
     */
    public static int maxValue(int[] arr) throws LengthZeroException {
        if (0 == arr.length)
            throw new LengthZeroException("array length is zero.");

        int max = arr[0];
        for (int data : arr) {
            if (max < data) {
                max = data;
            }
        }

        return max;
    }
    
    /**
     * 获得数组中的最大值
     * 
     * @param   arr
     *          待比较的数组
     *
     * @return  最大值
     *
     * @throws  LengthZeroException
     *          LengthZeroException
     */
    public static long maxValue(long[] arr) throws LengthZeroException {
        if (arr.length == 0) {
            throw new LengthZeroException("");
        }

        long max = arr[0];
        for (long data : arr) {
            if (max < data) {
                max = data;
            }
        }

        return max;
    }
    
    /**
     * 获得数组中的最大值
     * 
     * @param   array
     *          待比较的数组
     *
     * @return  最大值
     *
     * @throws  LengthZeroException
     *          LengthZeroException
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
     * @param   array
     *          待比较的数组
     *
     * @return  最大值
     *
     * @throws  LengthZeroException
     *          LengthZeroException
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
     * 获得数组中的最大值
     *
     * @param   arr
     *          待比较的数组
     *
     * @param   <T>
     *          范型类型
     *
     * @return  最大值
     */
    public static <T extends Comparable> T maxValue(T[] arr) throws LengthZeroException {
        if (0 == arr.length)
            throw new LengthZeroException("array length is zero.");

        T max = arr[0];
        for (T item : arr) {
            if (0 > max.compareTo(item)) {
                max = item;
            }
        }

        return max;
    }
    
    /**
     * 求数组中一个连续子序列和的最大值
     * 
     * @param   arr
     *          输入数组
     *
     * @return  最大和
     */
    public static int maxSum(int[] arr) {
        if (null == arr || 0 == arr.length)
            return 0;
        
        int maxEndIndex = 0;
        int maxSum = 0;
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            maxEndIndex = Math.max(maxEndIndex + arr[i], 0);
            maxSum = Math.max(maxSum, maxEndIndex);
        }
        
        return maxSum;
    }
    
    /**
     * 求数组中一个连续子序列和的最大值
     * 
     * @param   array
     *          输入数组
     *
     * @return  最大和
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
     * @param   arr
     *          输入数组
     *
     * @return  最大和
     */
    public static float maxSum(float[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        
        float maxEndIndex = 0;
        float maxSum = 0;
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            maxEndIndex = Math.max(maxEndIndex + arr[i], 0);
            maxSum = Math.max(maxSum, maxEndIndex);
        }
        
        return maxSum;
    }
    
    /**
     * 求数组中一个连续子序列和的最大值
     * 
     * @param   arr
     *          输入数组
     *
     * @return  最大和
     */
    public static double maxSum(double[] arr) {
        if (arr == null || arr.length == 0)
            return 0;
        
        double maxEndIndex = 0;
        double maxSum = 0;

        for (double item : arr) {
            maxEndIndex = Math.max(maxEndIndex + item, 0);
            maxSum = Math.max(maxSum, maxEndIndex);
        }
        
        return maxSum;
    }
    
    /**
     * 打印数组
     * 
     * @param   objects
     *          数组
     */
    public static void show(Object[] objects) {
        System.out.println(Arrays.toString(objects));
    }
    
    /**
     * 返回数组字符串表示
     * 
     * @param   arr
     *          数组
     */
    public static String output(byte[] arr) {
        return Arrays.toString(arr);
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
        if (StringUtils.isEmpty(number))
            return null;
        
        char[] chars = number.toCharArray();
        int length = chars.length;
        int[] numbers = new int[length];
        for (int i = 0; i < length; i++) {
            if (!CharUtils.isNumberChar(chars[i]))
                throw new NotNumberException(number + "传入的参数不是数字");
            
            numbers[i] = Integer.parseInt(String.valueOf(chars[i]));
        }
        
        return numbers;
    }
}
