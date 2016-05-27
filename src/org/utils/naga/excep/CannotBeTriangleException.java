package org.utils.naga.excep;

/**
 * <p>
 * 不能组成三角形异常
 * </p>
 * Create Date: 2015年12月9日
 * Last Modify: 2016年5月26日
 * 
 * @author <a href="http://weibo.com/u/5131020927">Q-WHai</a>
 * @see <a href="http://blog.csdn.net/lemon_tree12138">http://blog.csdn.net/lemon_tree12138</a>
 * @version 0.1.1
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
