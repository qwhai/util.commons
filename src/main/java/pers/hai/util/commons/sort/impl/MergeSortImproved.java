package pers.hai.util.commons.sort.impl;

import pers.hai.util.commons.containers.ArrayUtils;
import pers.hai.util.commons.sort.interf.Sortable;

/**
 * <p>
 * 归并排序策略(改进)
 * </p>
 * Create Date: 2015年12月15日
 * Last Modify: 2016年5月26日
 * 
 * @author Q-WHai
 * @see <a href="https://github.com/qwhai">https://github.com/qwhai</a>
 */
public class MergeSortImproved implements Sortable {

    private static final int THRESHOLD = 10;
    
    @Override
    public int[] sort(int[] array) {
        if (array == null) {
            return null;
        }
        
        int[] temp = new int[array.length];
        return mergeSort(array, temp, 0, array.length - 1);
    }

    private static int[] mergeSort(int[] array, int[] temp, int l, int r) {
        int i, j, k;
        int mid = (l + r) / 2;
        if (l == r) {
            return null;
        }
        
        if ((mid - l) >= THRESHOLD) {
            mergeSort(array, temp, l, mid);
        } else {
            insertSort(array, l, mid - l + 1);
        }
        
        if ((r - mid) > THRESHOLD) {
            mergeSort(array, temp, mid + 1, r);
        } else {
            insertSort(array, mid + 1, r - mid);
        }

        for (i = l; i <= mid; i++) {
            temp[i] = array[i];
        }
        for (j = 1; j <= r - mid; j++) {
            temp[r - j + 1] = array[j + mid];
        }
        int a = temp[l];
        int b = temp[r];
        for (i = l, j = r, k = l; k <= r; k++) {
            if (a < b) {
                array[k] = temp[i++];
                a = temp[i];
            } else {
                array[k] = temp[j--];
                b = temp[j];
            }
        }
        
        return array;
    }

    private static void insertSort(int[] array, int start, int len) {
        for (int i = start + 1; i < start + len; i++) {
            for (int j = i; (j > start) && array[j] < array[j - 1]; j--) {
                ArrayUtils.swap(array, j, j - 1);
            }
        }
    }
}
