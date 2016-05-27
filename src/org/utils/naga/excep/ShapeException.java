package org.utils.naga.excep;

/**
 * <p>
 * 几何形状异常
 * </p>
 * 2015年12月9日
 * 
 * @author <a href="http://weibo.com/u/5131020927">Q-WHai</a>
 * @see <a href="http://blog.csdn.net/lemon_tree12138">http://blog.csdn.net/lemon_tree12138</a>
 * @version 0.1.2
 */
public class ShapeException extends Exception {

    private static final long serialVersionUID = 351036624807058041L;

    public ShapeException() {
        super();
    }
    
    public ShapeException(String msg) {
        super(msg);
    }
    
    public ShapeException(String msg, Throwable cause) {
        super(msg, cause);
    }
    
    public ShapeException(Throwable cause) {
        super(cause);
    }
}
