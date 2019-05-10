package org.commons.cabinet.excep;

import java.io.IOException;

/**
 * <p>
 * 文件名不存在异常(包括文件目录)
 * </p>
 * Create Date: 2015年12月7日
 * Last Modify: 2016年5月26日
 * 
 * @author Q-WHai
 * @see <a href="https://github.com/qwhai">https://github.com/qwhai</a>
 */
public class FileNameNotExistsException extends IOException {

    private static final long serialVersionUID = 3344485672616390564L;

    public FileNameNotExistsException(String msg) {
        super(msg);
    }
}
