package org.commons.cabinet.excep;

/**
 * <p>
 * 参数异常
 * </p>
 * Create Date: 2015年12月23日
 * Last Modify: 2016年5月26日
 * 
 * @author Q-WHai
 * @see <a href="https://github.com/qwhai">https://github.com/qwhai</a>
 */
public class ParameterException extends Exception {

    private static final long serialVersionUID = 6748742624625559397L;

    public ParameterException() {
        super();
    }
    
    public ParameterException(String msg) {
        super(msg);
    }
    
    public ParameterException(Throwable cause) {
        super(cause);
    }
    
    public ParameterException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
