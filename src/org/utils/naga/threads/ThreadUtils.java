package org.utils.naga.threads;

import org.utils.naga.excep.CannotInstanceException;
import org.utils.naga.interf.UtilsInterface;

/**
 * <p>
 * 这是一个线程工具类，处理与线程有关的操作
 * </p>
 * Create Date: 2015年11月25日
 * Last Modify: 2016年5月26日
 * 
 * @author <a href="http://weibo.com/u/5131020927">Q-WHai</a>
 * @see <a href="http://blog.csdn.net/lemon_tree12138">http://blog.csdn.net/lemon_tree12138</a>
 * @version 0.1.1
 */
public class ThreadUtils implements UtilsInterface {

    // 禁止实例化
    private ThreadUtils() throws CannotInstanceException {
        throw new CannotInstanceException("不要试图实例化我");
    }
    
    @Override
    public String getTag() {
        return this.getClass().getName();
    }

    @Override
    public void description() {
        System.out.println("这是一个线程工具类，处理与线程有关的操作");
    }

    /**
     * 线程休眠
     * 
     * @param millis
     *      休眠时间(毫秒)
     */
    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
