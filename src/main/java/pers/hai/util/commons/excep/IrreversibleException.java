package pers.hai.util.commons.excep;

/**
 * <p>
 * 操作不可逆异常
 * </p>
 * Create Date: 2015年12月15日
 * Last Modify: 2016年5月26日
 * 
 * @author Q-WHai
 * @see <a href="https://github.com/qwhai">https://github.com/qwhai</a>
 */
public class IrreversibleException extends Exception {

    private static final long serialVersionUID = -728782621527005273L;

    public IrreversibleException(String msg) {
        super(msg);
    }
    
    public IrreversibleException(Throwable cause) {
        super(cause);
    }
    
    public IrreversibleException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
