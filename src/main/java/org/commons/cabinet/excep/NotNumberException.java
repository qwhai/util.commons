package org.commons.cabinet.excep;

/**
 * <p>
 * 非数字异常
 * </p>
 * Create Date: 2015年12月9日
 * Last Modify: 2016年5月26日
 * 
 * @author Q-WHai
 * @see <a href="https://github.com/qwhai">https://github.com/qwhai</a>
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
