package org.core.utils.sort.interf;

/**
 * <p>
 * 不同排序算法策略的公共接口类
 * </p>
 * Create Date: 2015年12月15日
 * Last Modify: 2016年5月26日
 * 
 * @author <a href="http://weibo.com/u/5131020927">Q-WHai</a>
 * @see <a href="http://blog.csdn.net/lemon_tree12138">http://blog.csdn.net/lemon_tree12138</a>
 * @version 0.1.1
 */
public interface Sortable {

    /**
     * 对数组进行排序
     * 
     * @param array
     *      待排序数组
     * @return
     *      已排序数组
     */
    public int[] sort(int[] array);
}
