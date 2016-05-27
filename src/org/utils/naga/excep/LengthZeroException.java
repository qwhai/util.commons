package org.utils.naga.excep;

/**
 * <p>
 * 0长度异常
 * </p>
 * 2015‎年‎11‎月‎27‎日
 * 
 * @author <a href="http://weibo.com/u/5131020927">Q-WHai</a>
 * @see <a href="http://blog.csdn.net/lemon_tree12138">http://blog.csdn.net/lemon_tree12138</a>
 * @version 0.1.2
 */
public class LengthZeroException extends Exception {

    private static final long serialVersionUID = 3695456528223224911L;

    public LengthZeroException() {
        super();
    }
    
    public LengthZeroException(String message) {
        super(message);
    }
    
    public LengthZeroException(Throwable cause) {
        super(cause);
    }
    
    public LengthZeroException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
