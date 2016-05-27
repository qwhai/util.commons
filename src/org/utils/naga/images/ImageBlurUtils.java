package org.utils.naga.images;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.utils.naga.images.filters.libs.GaussianFilter;
import org.utils.naga.images.interf.ImageInterface;

/**
 * <p>
 * 图像模糊工具
 * </p>
 * 2015年12月31日
 * 
 * @author <a href="http://weibo.com/u/5131020927">Q-WHai</a>
 * @see <a href="http://blog.csdn.net/lemon_tree12138">http://blog.csdn.net/lemon_tree12138</a>
 * @version 0.1
 */
public class ImageBlurUtils implements ImageInterface {

    public static ImageBlurUtils instance = null;
    private GaussianFilter filter = null;
    
    private ImageBlurUtils() {
        initEvent();
    }
    
    private void initEvent() {
        filter = new GaussianFilter();
    }
    
    public static ImageBlurUtils newInstance() {
        if (instance == null) {
            instance = new ImageBlurUtils();
        }
        
        return instance;
    }
    
    /**
     * 基于正态分布的图片高斯模糊
     * 
     * @param sourcePath
     *      图片原路径
     * @throws IOException
     *      读写异常
     */
    public void gaussianBlur(String sourcePath) throws IOException {
        BufferedImage src = ImageIO.read(new File(sourcePath));
        BufferedImage dst = filter.filter(src, null);
        ImageIO.write(dst, "jpg", new File(sourcePath));
    }
    
    /**
     * 基于正态分布的图片高斯模糊
     * 
     * @param sourcePath
     *      图片原路径
     * @param targetPath
     *      图片目标路径
     * @throws IOException
     *      读写异常
     */
    public void gaussianBlur(String sourcePath, String targetPath) throws IOException {
        BufferedImage src = ImageIO.read(new File(sourcePath));
        BufferedImage dst = filter.filter(src, null);
        ImageIO.write(dst, "jpg", new File(targetPath));
    }
    
    public void gaussianBlur(String sourcePath, int startX, int startY, int blurWidth, int blurHeight) {
        // TODO
    }
    
    public static void main(String[] args) {
        
        {
            ImageBlurUtils utils = newInstance();
            utils.resetRadius(20);
            try {
                utils.gaussianBlur("F:/IMG/7.jpg", "F:/IMG/7-d.jpg");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
//        {
//            ImageOverlayUtils utils = ImageOverlayUtils.newInstance();
//            try {
//                utils.putWatermarkText("F:/IMG/2.jpg", "Blur Filter!", Color.BLUE, new Font("Courier New", Font.BOLD, 20), 100, 100);
//                utils.putWatermarkText("F:/IMG/2-d.jpg", "Blur Filter!", Color.BLUE, new Font("Courier New", Font.BOLD, 20), 100, 100);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
    }
    
    /**
     * 重置过滤器的模糊半径
     * 
     * @param radius
     *      模糊半径
     */
    public void resetRadius(float radius) {
        if (filter == null) {
            return;
        }
        
        filter.setRadius(radius);
    }
    
    /**
     * 重置是否使用透明
     * 
     * @param alphaFlag
     *      是否透明
     */
    public void resetAlpha( boolean alphaFlag ) {
        if (filter == null) {
            return;
        }
        
        filter.setUseAlpha(alphaFlag);
    }
    
    @Override
    public String getTag() {
        return getClass().getName();
    }

    @Override
    public void description() {
        System.out.println("图像模糊工具");
    }

}
