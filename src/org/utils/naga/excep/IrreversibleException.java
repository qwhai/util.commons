package org.utils.naga.excep;

/**
 * <p>
 * 操作不可逆异常
 * </p>
 * Create Date: 2015年12月15日
 * Last Modify: 2016年5月26日
 * 
 * @author <a href="http://weibo.com/u/5131020927">Q-WHai</a>
 * @see <a href="http://blog.csdn.net/lemon_tree12138">http://blog.csdn.net/lemon_tree12138</a>
 * @version 0.1.1
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
