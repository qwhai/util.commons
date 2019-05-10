package org.commons.cabinet.excep;

/**
 * <p>
 * 不能组成三角形异常
 * </p>
 * Create Date: 2015年12月9日
 * Last Modify: 2016年5月26日
 * 
 * @author Q-WHai
 * @see <a href="https://github.com/qwhai">https://github.com/qwhai</a>
 */
public class CannotBeTriangleException extends ShapeException {

    private static final long serialVersionUID = -1021859624286333243L;

    public CannotBeTriangleException(String msg) {
        super(msg);
    }
    
    public CannotBeTriangleException(String msg, Throwable cause) {
        super(msg, cause);
    }
    
    public CannotBeTriangleException(Throwable cause) {
        super(cause);
    }
}
