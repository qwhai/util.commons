package org.commons.cabinet.sort.poke;

import org.commons.cabinet.sort.interf.Sortable;

/**
 * <p>
 * 盛放不同排序算法的容器类
 * </p>
 * <p>
 * 用于客户端的用户
 * </p>
 * Create Date: 2015年12月15日
 * Last Modify: 2016年5月26日
 * 
 * @author Q-WHai
 * @see <a href="https://github.com/qwhai">https://github.com/qwhai</a>
 */
public class SortUtils {

    private Sortable sortable = null;
    
    /**
     * 排序容器的构造器
     * 
     * @param _sortable
     *      可排序的算法策略
     */
    public SortUtils(Sortable _sortable) {
        sortable = _sortable;
    }
    
    /**
     * 对数组进行排序
     * 
     * @param array
     *      待排序数组
     * @return
     *      已排序数组
     */
    public int[] sort(int[] array) {
        return sortable.sort(array);
    }
}
