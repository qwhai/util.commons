package pers.hai.util.commons.datetime;

/**
 * 与时间相关的工具类
 *
 * Create Date: 2015‎-‎11-‎26
 * Last Modify: 2019-05-10
 * 
 * @author Q-WHai
 * @see <a href="https://github.com/qwhai">https://github.com/qwhai</a>
 */
public class TimeUtils {

    /**
     * 当前时间的时间戳
     *
     * @return
     *      时间戳（毫秒）
     */
    public static long currentTimeMillis() {
        return System.currentTimeMillis();
    }

    /**
     * 当前时间的时间戳
     *
     * @return
     *      时间戳（秒）
     */
    public static int currentTimeSeconds() {
        return (int)(System.currentTimeMillis() / 1000);
    }
}
