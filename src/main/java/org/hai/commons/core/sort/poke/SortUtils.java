package org.hai.commons.core.sort.poke;

import org.hai.commons.core.sort.interf.Sortable;

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
 * @author <a href="http://weibo.com/u/5131020927">Q-WHai</a>
 * @see <a href="http://blog.csdn.net/lemon_tree12138">http://blog.csdn.net/lemon_tree12138</a>
 * @version 0.1.1
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
