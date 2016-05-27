package org.core.utils.consts;

import org.core.utils.excep.CannotInstanceException;

/**
 * <p>
 * 常量类
 * </p>
 * Create Date: 2015年11月15日
 * Last Modify: 2016年5月26日
 * 
 * @author <a href="http://weibo.com/u/5131020927">Q-WHai</a>
 * @see <a href="http://blog.csdn.net/lemon_tree12138">http://blog.csdn.net/lemon_tree12138</a>
 * @version 0.1.1
 */
public final class Constant {

    // 禁止实例化
    private Constant() throws CannotInstanceException {
        throw new CannotInstanceException("不要试图实例化我");
    }
    
    // TODO ------------------------------------------- 内部类标识分隔线 ----------------------------------------------------------
    
    /**
     * 与时间相关的常量
     * 2015年11月25日
     * 
     * @author <a href="http://weibo.com/u/5131020927">Q-WHai</a>
     * @see <a href="http://blog.csdn.net/lemon_tree12138">http://blog.csdn.net/lemon_tree12138</a>
     * @version 0.1
     */
    public final static class TimeUtils {
        /** 1秒钟内有多少毫秒 */
        public static final long ONE_SECOND_MILLIS = 1 * 1000L;
        
        /** 1分钟内有多少毫秒 */
        public static final long ONE_MINUTE_MILLIS = 1 * 60 * ONE_SECOND_MILLIS;
        
        /** 1小时内有多少毫秒 */
        public static final long ONE_HOUR_MILLIS = 1 * 60 * ONE_MINUTE_MILLIS;
        
        /** 1天内有多少毫秒 */
        public static final long ONE_DAY_MILLIS = 1 * 24 * ONE_HOUR_MILLIS;
        
        /** 1个星期内有多少毫秒 */
        public static final long ONE_WEEK_MILLIS = 1 * 7 * ONE_DAY_MILLIS;
        
        /** 标准1个月(即30天)内有多少毫秒 */
        public static final long ONE_MONTH_MILLIS = 1 * 30 * ONE_DAY_MILLIS;
        
        /** 1年(标准情况365天)内有多少毫秒 */
        public static final long ONE_YEAR_MILLIS = 1 * 365 * ONE_DAY_MILLIS;
    }
}
