package pers.hai.util.commons.sort.impl;

import pers.hai.util.commons.containers.ArrayUtils;
import pers.hai.util.commons.sort.interf.Sortable;

/**
 * <p>
 * Shell排序策略
 * </p>
 * Create Date: 2015年12月15日
 * Last Modify: 2016年5月26日
 * 
 * @author Q-WHai
 * @see <a href="https://github.com/qwhai">https://github.com/qwhai</a>
 */
public class ShellSort implements Sortable {

    @Override
    public int[] sort(int[] array) {
        if (array == null) {
            return null;
        }
        
        for (int i = array.length / 2; i > 2; i /= 2) {
            for (int j = 0; j < i; j++) {
                insertSort(array, j, i);
            }
        }

        insertSort(array, 0, 1);
        
        return array;
    }

    private static void insertSort(int[] array, int start, int step) {
        for (int i = start + step; i < array.length; i += step) {
            for (int j = i; (j >= step) && (array[j] < array[j - step]); j -= step) {
                ArrayUtils.swap(array, j, j - step);
            }
        }
    }
}
