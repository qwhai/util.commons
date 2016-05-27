package org.utils.naga.sort.impl;

import org.utils.naga.containers.ArrayUtils;
import org.utils.naga.sort.interf.Sortable;

/**
 * <p>
 * 快速排序策略
 * </p>
 * 2015年12月15日
 * 
 * @author <a href="http://weibo.com/u/5131020927">Q-WHai</a>
 * @see <a href="http://blog.csdn.net/lemon_tree12138">http://blog.csdn.net/lemon_tree12138</a>
 * @version 0.1.1
 */
public class QKSort implements Sortable {

    @Override
    public int[] sort(int[] array) {
        if (array == null) {
            return null;
        }
        
        return quickSort(array, 0, array.length - 1);
    }

    private static int[] quickSort(int[] array, int beg, int end) {
        if (beg >= end || array == null) {
            return null;
        }

        int p = partition(array, beg, end);

        quickSort(array, beg, p - 1);
        quickSort(array, p + 1, end);

        return array;
    }

    /**
     * 找到分界点
     * 
     * @param array
     * @param beg
     * @param end
     * @return
     */
    private static int partition(int[] array, int beg, int end) {
        int last = array[end];
        int i = beg - 1;

        for (int j = beg; j <= end - 1; j++) {
            if (array[j] <= last) {
                i++;
                if (i != j) {
                    ArrayUtils.swap(array, i, j);
                }
            }
        }

        if ((i + 1) != end) {
            ArrayUtils.swap(array, i + 1, end);
        }

        return i + 1;
    }
}
