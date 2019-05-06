package org.hai.commons.core.nums;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.hai.commons.core.containers.ListUtils;
import org.hai.commons.core.interf.UtilsInterface;

/**
 * <p>
 * 随机数生成器
 * </p>
 * <p>
 * 目前0.1.1版本只支持生成随机整数
 * </p>
 * Create Date: 2015年12月22日
 * Last Modify: 2016年5月26日
 * 
 * @author <a href="http://weibo.com/u/5131020927">Q-WHai</a>
 * @see <a href="http://blog.csdn.net/lemon_tree12138">http://blog.csdn.net/lemon_tree12138</a>
 * @version 0.1.1
 */
public class RandomUtils implements UtilsInterface {

    private Random random = null;
    private int limit;

    public RandomUtils() {
        limit = -1;
        initEvent();
    }
    
    public RandomUtils(int _limit) {
        limit = _limit;
        initEvent();
    }

    /*
     * 初始化随机数生成器
     */
    private void initEvent() {
        random = new Random();
    }

    @Override
    public String getTag() {
        return getClass().getName();
    }

    @Override
    public void description() {
        System.out.println("随机数生成器");
    }

    /**
     * 生成一个随机数。上限在创建对象实例的时候已经给出
     * 
     * @return
     *      随机整数
     */
    public int nextInt() {
        if (limit < 0) {
            return random.nextInt();
        }
        return random.nextInt(limit);
    }
    
    /**
     * 产生一个[start, end]之间的随机数
     * 这里无视start和end的大小关系
     * 
     * @param start
     *      开始边界
     * @param end
     *      结束边界
     * @return
     *      随机整数
     */
    public int nextInt(int start, int end) {
        return random.nextInt(Math.abs(start - end) + 1) + Math.min(start, end);
    }
    
    /**
     * 生产一个不重复的随机数序列
     * 
     * @param start
     *      随机数的最小边界
     * @param end
     *      随机数的最大边界
     * @param count
     *      随机数的个数
     * @return
     *      不重复的随机数序列
     */
    public List<Integer> randomSet(int start, int end, int count) {
        if (end - start + 1 < count) {
            throw new IndexOutOfBoundsException("随机数的范围太小");
        }
        
        List<Integer> randoms = new ArrayList<>();
        
        int[] status = new int[end + 1];
        for (int i = 0; i < count; i++) {
            int random = nextInt(start, end);
            if (status[random] == 0) {
                randoms.add(random);
                status[random] = random == end ? start : (random + 1); // 不可能有在start之前的数字
            } else {
                // 状态转移
                int index = random;
                do {
                    index = status[index];
                } while (status[index] != 0);
                
                randoms.add(index);
                status[index] = index == end ? start : (index + 1); // 不可能有在start之前的数字
            }
        }
        
        return randoms;
    }
    
    /**
     * 生产一个不重复的随机数序列
     * 
     * @param start
     *      随机数的最小边界
     * @param end
     *      随机数的最大边界
     * @param count
     *      随机数的个数
     * @return
     *      不重复的随机数序列
     */
    public List<Integer> randomSetByFloyd(int start, int end, int count) {
        List<Integer> list = new ArrayList<>();
        for (int i = end - count + 1; i < end; i++) {
            int random = nextInt(start, i);
            if (list.contains(random)) {
                list.add(i);
            } else {
                list.add(random);
            }
        }
        
        return list;
    }
    
    /**
     * 生产一个不重复的随机数序列
     * 
     * @param end
     *      随机数的最大边界
     * @param count
     *      随机数的个数
     * @return
     *      不重复的随机数序列
     */
    public List<Integer> randomSet(int end, int count) {
        return randomSet(0, end, count);
    }
    
    /**
     * 生产一个可重复的随机数序列
     * 
     * @param end
     *      随机数的最大边界
     * @param count
     *      随机数的个数
     * @return
     *      随机数序列
     */
    public List<Integer> randomList(int end, int count) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            list.add(nextInt(0, end));
        }
        return list;
    }
    
    /**
     * 随机生成和为S的N个正整数
     * 
     * @param sum
     *      和数
     * @param count
     *      随机数的个数
     * @return
     *      随机数列表
     */
    public List<Integer> randomSum(int sum, int count) {
        /*
         * 注：算法核心是投影法
         * 参考：http://blog.csdn.net/morewindows/article/details/8439393
         */
        List<Integer> randoms = randomSet(sum, count - 1);
        ListUtils.sortASC(randoms);
        
        List<Integer> result = new ArrayList<>(count);
        
        int size = randoms.size();
        result.add(randoms.get(0));
        for (int i = 1; i < size; i++) {
            result.add(randoms.get(i) - randoms.get(i - 1));
        }
        result.add(sum - randoms.get(size- 1));
        
        return result;
    }
}