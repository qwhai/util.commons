package org.core.utils.sort.impl;

import org.core.utils.containers.ArrayUtils;
import org.core.utils.sort.interf.Sortable;

/**
 * <p>
 * 堆排序策略
 * </p>
 * Create Date: 2015年12月15日
 * Last Modify: 2016年5月26日
 * 
 * @author <a href="http://weibo.com/u/5131020927">Q-WHai</a>
 * @see <a href="http://blog.csdn.net/lemon_tree12138">http://blog.csdn.net/
 *      lemon_tree12138</a>
 * @version 0.1.1
 */
public class HeapSort implements Sortable {

    @Override
    public int[] sort(int[] array) {
        if (array == null) {
            return null;
        }
        MaxHeap maxHeap = new MaxHeap();
        maxHeap.create(array);

        for (int i = 0; i < array.length; i++) {
            maxHeap.removeAndFixit();
        }

        System.arraycopy(maxHeap.queue, 1, array, 0, array.length);

        return array;
    }

    /**
     * <p>
     * 最大堆
     * </p>
     * 2015年12月15日
     * 
     * @author <a href="http://weibo.com/u/5131020927">Q-WHai</a>
     * @see <a href="http://blog.csdn.net/lemon_tree12138">http://blog.csdn.net/lemon_tree12138</a>
     * @version 0.1
     */
    private static class MaxHeap {

        private int size = 0;
        private int[] queue;
        
        public void create(int[] data) {
            this.queue = new int[data.length + 1];
            for (int i = 0; i < data.length; i++) {
                queue[++size] = data[i];
                fixUp(size);
            }
        }

        // 这里对可以确定有序的元素进行移除，再对剩下无序的序列进行排序
        public void removeAndFixit() {
            ArrayUtils.swap(queue, 1, size--);
            fixDown(1);
        }

        // 对于交换后不满足大顶堆的堆，进行重新调整
        private void fixDown(int fatherIndex) {
            int childIndex = 0;
            int leftChildIndex = 0;
            int rightChildIndex = 0;
            while ((childIndex = fatherIndex << 1) <= size) {
                leftChildIndex = childIndex;
                rightChildIndex = childIndex + 1;
                if (leftChildIndex < size && queue[leftChildIndex] < queue[rightChildIndex]) {
                    childIndex++;
                }

                // 不用交换
                if (queue[fatherIndex] > queue[childIndex]) {
                    break;
                }

                ArrayUtils.swap(queue, childIndex, fatherIndex);
                fatherIndex = childIndex;
            }
        }

        // 在初始化阶段，需要构建所有元素满足大顶堆
        private void fixUp(int leafIndex) {
            while (leafIndex > 1) {
                int fatherIndex = leafIndex >> 1;
                if (queue[fatherIndex] > queue[leafIndex]) {
                    break;
                }

                ArrayUtils.swap(queue, fatherIndex, leafIndex);
                leafIndex = fatherIndex;
            }
        }
    }
}
