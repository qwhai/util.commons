package pers.hai.util.commons.threads;

import pers.hai.util.commons.excep.CannotInstanceException;

/**
 * <p>
 * 这是一个线程工具类，处理与线程有关的操作
 * </p>
 * Create Date: 2015年11月25日
 * Last Modify: 2016年5月26日
 * 
 * @author Q-WHai
 * @see <a href="https://github.com/qwhai">https://github.com/qwhai</a>
 */
public class ThreadUtils {

    // 禁止实例化
    private ThreadUtils() throws CannotInstanceException {
        throw new CannotInstanceException("不要试图实例化我");
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
