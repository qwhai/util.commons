package org.hai.commons.core.containers;

import java.util.List;
import java.util.RandomAccess;

import org.hai.commons.core.consts.SortDirect;
import org.core.utils.excep.CannotInstanceException;

/**
 * <p>
 * 关于List列表的工具类
 * </p>
 * Create Date: 2015年12月24日
 * Last Modify: 2016年5月26日
 * 
 * @author <a href="http://weibo.com/u/5131020927">Q-WHai</a>
 * @see <a href="http://blog.csdn.net/lemon_tree12138">http://blog.csdn.net/lemon_tree12138</a>
 * @version 0.1.1
 */
public final class ListUtils extends ContainerUtils {

    // 工具类，禁止实例化
    private ListUtils() throws CannotInstanceException {
        throw new CannotInstanceException("不要实例化我");
    }
    
    @Override
    public String getTag() {
        return getClass().getName();
    }
    
    @Override
    public void description() {
        System.out.println("关于List列表的工具类");
    }
    
    /**
     * 计算一个列表的平均值
     * 
     * @param list
     *          整型列表
     * @return
     *          平均数
     */
    public static double average(List<Integer> list) {
        int sum = 0;
        if (list instanceof RandomAccess) {
            // 对于可以随机存取的，采用下标访问
            for (int i = 0; i < list.size(); i++) {
                sum += list.get(i);
            }
        } else {
            // 对于顺序存取的，采用迭代访问
            for (int i : list) {
                sum += i;
            }
        }
        
        return 1.0 * sum / list.size();
    }
    
    /**
     * 对一个列表进行排序
     * 
     * @param list
     *      待排序列表
     */
    public static void sortASC(List<Integer> list) {
        sort(list, SortDirect.ASC);
    }
    
    /**
     * 对一个列表进行排序
     * 
     * @param list
     *      待排序列表
     */
    public static void sortDESC(List<Integer> list) {
        sort(list, SortDirect.DESC);
    }
    
    /*
     * 对一个列表进行排序
     * 
     * @param list
     *      待排序列表
     * @param direct
     *      排序方向
     */
    private static void sort(List<Integer> list, SortDirect direct) {
        int listSize = list.size();
        
        for (int i = 0; i < listSize; i++) {
            for (int j = i + 1; j < listSize; j++) {
                if (i == j) {
                    continue;
                }
                
                if (direct == SortDirect.ASC) {
                    if (list.get(i) > list.get(j)) {
                        int swap = list.get(i);
                        list.set(i, list.get(j));
                        list.set(j, swap);
                    }
                } else {
                    if (list.get(i) < list.get(j)) {
                        int swap = list.get(i);
                        list.set(i, list.get(j));
                        list.set(j, swap);
                    }
                }
            }
        }
    }
}
