package pers.hai.util.commons.excep;

/**
 * <p>
 * 几何形状异常
 * </p>
 * Create Date: 2015年12月9日
 * Last Modify: 2016年5月26日
 * 
 * @author Q-WHai
 * @see <a href="https://github.com/qwhai">https://github.com/qwhai</a>
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
