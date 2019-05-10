package org.commons.cabinet.excep;

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
 * @author Q-WHai
 * @see <a href="https://github.com/qwhai">https://github.com/qwhai</a>
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
