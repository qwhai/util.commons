package org.commons.cabinet.sort.impl;

import org.commons.cabinet.containers.ArrayUtils;
import org.commons.cabinet.sort.interf.Sortable;

/**
 * <p>
 * 插入排序策略
 * </p>
 * Create Date: 2015年12月15日
 * Last Modify: 2016年5月26日
 * 
 * @author Q-WHai
 * @see <a href="https://github.com/qwhai">https://github.com/qwhai</a>
 */
public class InsertSort implements Sortable {

    @Override
    public int[] sort(int[] array) {
        if (array == null) {
            return null;
        }
        
        for (int i = 1; i < array.length; i++) {
            for (int j = i; (j > 0) && (array[j] < array[j - 1]); j--) {
                ArrayUtils.swap(array, j, j - 1);
            }
        }
        
        return array;
    }

}
