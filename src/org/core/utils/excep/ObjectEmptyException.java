package org.core.utils.excep;

/**
 * <p>
 * 空对象异常
 * </p>
 * <p>
 * (暂时保留吧，可以用NullpointException代替.重复造轮子了.-_-!)
 * </p>
 * Create Date: 2015‎年‎11‎月‎25‎日
 * Last Modify: 2016年5月26日
 * 
 * @author <a href="http://weibo.com/u/5131020927">Q-WHai</a>
 * @see <a href="http://blog.csdn.net/lemon_tree12138">http://blog.csdn.net/lemon_tree12138</a>
 * @version 0.1.2
 */
@Deprecated
public class ObjectEmptyException extends RuntimeException {

    private static final long serialVersionUID = 6085052841613608878L;

    public ObjectEmptyException() {
        super();
    }
    
    public ObjectEmptyException(String msg) {
        super(msg);
    }
    
    public ObjectEmptyException(Throwable cause) {
        super(cause);
    }
    
    public ObjectEmptyException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
