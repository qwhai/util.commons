package org.utils.naga.sort.impl;

import org.utils.naga.containers.ArrayUtils;
import org.utils.naga.sort.interf.Sortable;

/**
 * <p>
 * Shell排序策略
 * </p>
 * 2015年12月15日
 * 
 * @author <a href="http://weibo.com/u/5131020927">Q-WHai</a>
 * @see <a href="http://blog.csdn.net/lemon_tree12138">http://blog.csdn.net/lemon_tree12138</a>
 * @version 0.1.1
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
