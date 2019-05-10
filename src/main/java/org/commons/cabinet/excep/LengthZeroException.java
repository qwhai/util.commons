package org.commons.cabinet.excep;

/**
 * <p>
 * 0长度异常
 * </p>
 * Create Date: 2015‎年‎11‎月‎27‎日
 * Last Modify: 2016年5月26日
 * 
 * @author Q-WHai
 * @see <a href="https://github.com/qwhai">https://github.com/qwhai</a>
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
