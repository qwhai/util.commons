package org.commons.cabinet.sort.impl;

import org.commons.cabinet.containers.ArrayUtils;
import org.commons.cabinet.sort.interf.Sortable;

/**
 * <p>
 * 选择排序策略
 * </p>
 * Create Date: 2015年12月15日
 * Last Modify: 2016年5月26日
 * 
 * @author Q-WHai
 * @see <a href="https://github.com/qwhai">https://github.com/qwhai</a>
 */
public class SelectionSort implements Sortable {

    @Override
    public int[] sort(int[] array) {
        if (array == null) {
            return null;
        }
        
        for (int i = 0; i < array.length; i++) {
            int lowIndex = i;
            for (int j = array.length - 1; j > i; j--) {
                if (array[j] < array[lowIndex]) {
                    lowIndex = j;
                }
            }

            ArrayUtils.swap(array, i, lowIndex);
        }
        
        return array;
    }

}
