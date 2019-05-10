package org.commons.cabinet.images;

import org.commons.cabinet.excep.CannotInstanceException;
import org.commons.cabinet.images.interf.ImageInterface;

/**
 * <p>
 * 图片工具类
 * </p>
 * <p>
 * 实际上这是一个类似代理的工具类
 * </p>
 * Create Date: 2015年12月2日
 * Last Modify: 2016年5月26日
 * 
 * @author Q-WHai
 * @see <a href="https://github.com/qwhai">https://github.com/qwhai</a>
 */
public class ImageUtils implements ImageInterface {

    // 工具类，禁止实例化
    private ImageUtils() throws CannotInstanceException {
        throw new CannotInstanceException("请不要试图实例化我");
    }
}
