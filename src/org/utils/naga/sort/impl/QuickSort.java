package org.utils.naga.sort.impl;

import java.util.List;
import java.util.ListIterator;

import org.utils.naga.sort.interf.Sortable;

/**
 * <p>
 * 快速排序策略
 * </p>
 * Create Date: 2015年12月15日
 * Last Modify: 2016年5月26日
 * 
 * @author <a href="http://weibo.com/u/5131020927">Q-WHai</a>
 * @see <a href="http://blog.csdn.net/lemon_tree12138">http://blog.csdn.net/lemon_tree12138</a>
 * @version 0.1.1
 */
@Deprecated
public class QuickSort implements Sortable {

    @Override
    public int[] sort(int[] array) {
        Integer[] t = new Integer[array.length];
        for (int i = 0; i < array.length; i++) {
            t[i] = array[i];// 封装
        }
        quickSort(t, 0, t.length);// 排序
        for (int i = 0; i < array.length; i++) {
            array[i] = t[i];// 解封装
        }
        
        return array;
    }
    
    @SuppressWarnings("unchecked")
    private static void quickSort(Object[] in, int begin, int end) {
        if (begin == end || begin == (end - 1))
            return;
        Object p = in[begin];
        int a = begin + 1;
        int b = a;
        for (; b < end; b++) {
            // 该对象类型数组必须实现Comparable接口，这样才能使用compareTo函数进行比较
            if (((Comparable<Object>) in[b]).compareTo(p) < 0) {
                if (a == b) {
                    a++;
                    continue;
                }
                Object temp = in[a];
                in[a] = in[b];
                in[b] = temp;
                a++;
            }
        }
        in[begin] = in[a - 1];
        in[a - 1] = p;
        if (a - 1 > begin) {
            quickSort(in, begin, a);
        }
        if (end - 1 > a) {
            quickSort(in, a, end);
        }
        return;
    }

    // 使用泛型，对任意对象数组排序，该对象类型数组必须实现Comparable接口
    public static <T extends Comparable<? super T>> void sort(T[] input) {
        quickSort(input, 0, input.length);
    }

    // 添加对List对象进行排序的功能，参考了Java中的Java.util.Collections类的sort()函数
    @SuppressWarnings("unchecked")
    public static <T extends Comparable<? super T>> void sort(List<T> list) {
        Object[] t = list.toArray();// 将列表转换为数组
        quickSort(t, 0, t.length); // 对数组进行排序
        // 数组排序完成后再写回到列表中
        ListIterator<T> i = list.listIterator();
        for (int j = 0; j < t.length; j++) {
            i.next();
            i.set((T) t[j]);
        }
    }

    // double[]数组的重载函数
    public static void sort(double[] input) {
        Double[] t = new Double[input.length];
        for (int i = 0; i < input.length; i++) {
            t[i] = input[i];
        }
        quickSort(t, 0, t.length);
        for (int i = 0; i < input.length; i++) {
            input[i] = t[i];
        }
    }

    // byte[]数组的重载函数
    public static void sort(byte[] input) {
        Byte[] t = new Byte[input.length];
        for (int i = 0; i < input.length; i++) {
            t[i] = input[i];
        }
        quickSort(t, 0, t.length);
        for (int i = 0; i < input.length; i++) {
            input[i] = t[i];
        }
    }

    // short[]数组的重载函数
    public static void sort(short[] input) {
        Short[] t = new Short[input.length];
        for (int i = 0; i < input.length; i++) {
            t[i] = input[i];
        }
        quickSort(t, 0, t.length);
        for (int i = 0; i < input.length; i++) {
            input[i] = t[i];
        }
    }

    // char[]数组的重载函数
    public static void sort(char[] input) {
        Character[] t = new Character[input.length];
        for (int i = 0; i < input.length; i++) {
            t[i] = input[i];
        }
        quickSort(t, 0, t.length);
        for (int i = 0; i < input.length; i++) {
            input[i] = t[i];
        }
    }

    // float[]数组的重载函数
    public static void sort(float[] input) {
        Float[] t = new Float[input.length];
        for (int i = 0; i < input.length; i++) {
            t[i] = input[i];
        }
        quickSort(t, 0, t.length);
        for (int i = 0; i < input.length; i++) {
            input[i] = t[i];
        }
    }
}
