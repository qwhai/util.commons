package org.utils.naga.sort.impl;

import org.utils.naga.containers.ArrayUtils;
import org.utils.naga.sort.interf.Sortable;

/**
 * <p>
 * 选择排序策略
 * </p>
 * Create Date: 2015年12月15日
 * Last Modify: 2016年5月26日
 * 
 * @author <a href="http://weibo.com/u/5131020927">Q-WHai</a>
 * @see <a href="http://blog.csdn.net/lemon_tree12138">http://blog.csdn.net/lemon_tree12138</a>
 * @version 0.1.1
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
