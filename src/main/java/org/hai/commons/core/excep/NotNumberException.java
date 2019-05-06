package org.hai.commons.core.excep;

/**
 * <p>
 * 非数字异常
 * </p>
 * Create Date: 2015年12月9日
 * Last Modify: 2016年5月26日
 * 
 * @author <a href="http://weibo.com/u/5131020927">Q-WHai</a>
 * @see <a href="http://blog.csdn.net/lemon_tree12138">http://blog.csdn.net/lemon_tree12138</a>
 * @version 0.1.2
 */
public class NotNumberException extends Exception {

    private static final long serialVersionUID = 4562080364994875012L;

    public NotNumberException() {
        super();
    }
    
    public NotNumberException(String msg) {
        super(msg);
    }
    
    public NotNumberException(Throwable cause) {
        super(cause);
    }
    
    public NotNumberException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
