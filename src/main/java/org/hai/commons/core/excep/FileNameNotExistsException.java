package org.hai.commons.core.excep;

import java.io.IOException;

/**
 * <p>
 * 文件名不存在异常(包括文件目录)
 * </p>
 * Create Date: 2015年12月7日
 * Last Modify: 2016年5月26日
 * 
 * @author <a href="http://weibo.com/u/5131020927">Q-WHai</a>
 * @see <a href="http://blog.csdn.net/lemon_tree12138">http://blog.csdn.net/lemon_tree12138</a>
 * @version 0.1.1
 */
public class FileNameNotExistsException extends IOException {

    private static final long serialVersionUID = 3344485672616390564L;

    public FileNameNotExistsException(String msg) {
        super(msg);
    }
}
