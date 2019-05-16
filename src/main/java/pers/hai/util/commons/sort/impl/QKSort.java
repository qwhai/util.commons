package pers.hai.util.commons.sort.impl;

import pers.hai.util.commons.containers.ArrayUtils;
import pers.hai.util.commons.sort.interf.Sortable;

/**
 * <p>
 * 快速排序策略
 * </p>
 * Create Date: 2015年12月15日
 * Last Modify: 2016年5月26日
 * 
 * @author Q-WHai
 * @see <a href="https://github.com/qwhai">https://github.com/qwhai</a>
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
