package org.core.utils.excep;

/**
 * <p>
 * 策略异常
 * </p>
 * <p>
 * 针对策略模式
 * </p>
 * Create Date: 2015年12月15日
 * Last Modify: 2016年5月26日
 * 
 * @author <a href="http://weibo.com/u/5131020927">Q-WHai</a>
 * @see <a href="http://blog.csdn.net/lemon_tree12138">http://blog.csdn.net/lemon_tree12138</a>
 * @version 0.1.2
 */
public class StrategyException extends RuntimeException {

    private static final long serialVersionUID = 8399141510465447954L;

    public StrategyException() {
        super();
    }
    
    public StrategyException(String msg) {
        super(msg);
    }
    
    public StrategyException(Throwable cause) {
        super(cause);
    }
    
    public StrategyException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
