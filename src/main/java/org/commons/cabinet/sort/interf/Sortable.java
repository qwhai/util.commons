package org.commons.cabinet.sort.interf;

/**
 * <p>
 * 不同排序算法策略的公共接口类
 * </p>
 * Create Date: 2015年12月15日
 * Last Modify: 2016年5月26日
 * 
 * @author Q-WHai
 * @see <a href="https://github.com/qwhai">https://github.com/qwhai</a>
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
    int[] sort(int[] array);
}
