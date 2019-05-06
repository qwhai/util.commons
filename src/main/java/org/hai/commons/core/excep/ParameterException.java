package org.hai.commons.core.excep;

/**
 * <p>
 * 参数异常
 * </p>
 * Create Date: 2015年12月23日
 * Last Modify: 2016年5月26日
 * 
 * @author <a href="http://weibo.com/u/5131020927">Q-WHai</a>
 * @see <a href="http://blog.csdn.net/lemon_tree12138">http://blog.csdn.net/lemon_tree12138</a>
 * @version 0.1.1
 */
public class ParameterException extends Exception {

    private static final long serialVersionUID = 6748742624625559397L;

    public ParameterException() {
        super();
    }
    
    public ParameterException(String msg) {
        super(msg);
    }
    
    public ParameterException(Throwable cause) {
        super(cause);
    }
    
    public ParameterException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
