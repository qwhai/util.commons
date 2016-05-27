package org.utils.naga.images;

import org.utils.naga.excep.CannotInstanceException;
import org.utils.naga.images.interf.ImageInterface;

/**
 * <p>
 * 图片工具类
 * </p>
 * <p>
 * 实际上这是一个类似代理的工具类
 * </p>
 * 2015年12月2日
 * 
 * @author <a href="http://weibo.com/u/5131020927">Q-WHai</a>
 * @see <a href="http://blog.csdn.net/lemon_tree12138">http://blog.csdn.net/lemon_tree12138</a>
 * @version 0.1.2
 */
public class ImageUtils implements ImageInterface {

    // 工具类，禁止实例化
    private ImageUtils() throws CannotInstanceException {
        throw new CannotInstanceException("请不要试图实例化我");
    }
    
    @Override
    public String getTag() {
        return getClass().getName();
    }

    @Override
    public void description() {
        System.out.println("我是一个图片工具类。目前，你可以使用我来进行图片的灰度化和二值化操作.");
    }
}
