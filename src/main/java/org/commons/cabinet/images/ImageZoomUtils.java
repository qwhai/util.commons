package org.commons.cabinet.images;

import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.commons.cabinet.images.interf.ImageInterface;

/**
 * <p>
 * 图片放缩工具类
 * </p>
 * Create Date: 2015年12月30日
 * Last Modify: 2016年5月26日
 * 
 * @author Q-WHai
 * @see <a href="https://github.com/qwhai">https://github.com/qwhai</a>
 */
public class ImageZoomUtils implements ImageInterface {

    private static ImageZoomUtils instance = null;
    
    private ImageZoomUtils() {
    }
    
    /**
     * 单例模式创建图片放缩工具对象
     * 
     * @return
     *      工具对象
     */
    public static ImageZoomUtils newInstance() {
        if (instance == null) {
            instance = new ImageZoomUtils();
        }
        
        return instance;
    }
    
    /**
     * 对一张图片进行放缩
     * 
     * @param sourcePath
     *      原图片路径
     * @param targetPath
     *      目标图片路径
     * @param width
     *      放缩后的宽度
     * @param height
     *      放缩后的高度
     * @throws IOException
     *      读写异常
     */
    public void zoomImage(String sourcePath, String targetPath, int width, int height) throws IOException {
        double zoomWidth = 0, zoomHeight = 0;
        File srcFile = new File(sourcePath);
        File destFile = new File(targetPath);
        
        BufferedImage bufferedImage = ImageIO.read(srcFile);
        Image Itemp = bufferedImage.getScaledInstance(width, height, BufferedImage.SCALE_SMOOTH);
        
        zoomWidth = width * 1.0 / bufferedImage.getWidth();
        zoomHeight = height * 1.0 / bufferedImage.getHeight();
        
        AffineTransformOp ato = new AffineTransformOp(AffineTransform.getScaleInstance(zoomWidth, zoomHeight), null);
        Itemp = ato.filter(bufferedImage, null);
        
        ImageIO.write((BufferedImage) Itemp, targetPath.substring(targetPath.lastIndexOf(".") + 1), destFile);
    }
    
    /**
     * 按比例放缩图片
     * 
     * @param sourcePath
     *      原图片路径
     * @param targetPath
     *      目标图片路径
     * @param ratio
     *      放缩比率
     * @throws IOException
     *      读写异常
     */
    public void zoomImage(String sourcePath, String targetPath, double ratio) throws IOException {
        int zoomWidth = 0, zoomHeight = 0;
        File srcFile = new File(sourcePath);
        File destFile = new File(targetPath);
        
        BufferedImage bufferedImage = ImageIO.read(srcFile);
        zoomWidth = (int) (ratio * bufferedImage.getWidth());
        zoomHeight = (int) (ratio * bufferedImage.getHeight());
        
        Image Itemp = bufferedImage.getScaledInstance(zoomWidth, zoomHeight, BufferedImage.SCALE_SMOOTH);
        AffineTransformOp ato = new AffineTransformOp(AffineTransform.getScaleInstance(ratio, ratio), null);
        Itemp = ato.filter(bufferedImage, null);
        ImageIO.write((BufferedImage) Itemp, targetPath.substring(targetPath.lastIndexOf(".") + 1), destFile);
    }
}
