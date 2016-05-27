package org.utils.naga.sort.impl;

import org.utils.naga.sort.interf.Sortable;

/**
 * <p>
 * 归并排序策略
 * </p>
 * Create Date: 2015年12月15日
 * Last Modify: 2016年5月26日
 * 
 * @author <a href="http://weibo.com/u/5131020927">Q-WHai</a>
 * @see <a href="http://blog.csdn.net/lemon_tree12138">http://blog.csdn.net/lemon_tree12138</a>
 * @version 0.1.1
 */
public class MergeSort implements Sortable {

    @Override
    public int[] sort(int[] array) {
        if (array == null) {
            return null;
        }
        
        int[] temp = new int[array.length];
        return mergeSort(array, temp, 0, array.length - 1);
    }

    /*
     * 使用分治算法排序
     * 
     * @param array
     *      待排序数组
     * @param temp
     *      辅助数组
     * @param l
     *      数组的起始位置
     * @param r
     *      数组的结束位置
     * @return
     *      排序数组
     */
    private static int[] mergeSort(int[] array, int[] temp, int l, int r) {
        int mid = (l + r) / 2;
        if (l == r) {
            return null;
        }
        mergeSort(array, temp, l, mid);
        mergeSort(array, temp, mid + 1, r);
        for (int i = l; i <= r; i++) {
            temp[i] = array[i];
        }
        int i1 = l;
        int i2 = mid + 1;
        for (int cur = l; cur <= r; cur++) {
            if (i1 == mid + 1) {
                array[cur] = temp[i2++];
            } else if (i2 > r) {
                array[cur] = temp[i1++];
            } else if (temp[i1] < temp[i2]) {
                array[cur] = temp[i1++];
            } else {
                array[cur] = temp[i2++];
            }
        }
        
        return array;
    }
}
