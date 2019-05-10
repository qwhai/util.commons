package org.commons.cabinet.excep;

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
 * @author Q-WHai
 * @see <a href="https://github.com/qwhai">https://github.com/qwhai</a>
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
