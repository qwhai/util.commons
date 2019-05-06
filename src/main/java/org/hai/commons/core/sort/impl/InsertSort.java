package org.hai.commons.core.sort.impl;

import org.hai.commons.core.containers.ArrayUtils;
import org.hai.commons.core.sort.interf.Sortable;

/**
 * <p>
 * 插入排序策略
 * </p>
 * Create Date: 2015年12月15日
 * Last Modify: 2016年5月26日
 * 
 * @author <a href="http://weibo.com/u/5131020927">Q-WHai</a>
 * @see <a href="http://blog.csdn.net/lemon_tree12138">http://blog.csdn.net/lemon_tree12138</a>
 * @version 0.1.1
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
