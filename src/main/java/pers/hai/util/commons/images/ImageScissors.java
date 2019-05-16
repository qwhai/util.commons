package pers.hai.util.commons.images;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

import pers.hai.util.commons.images.interf.ImageInterface;

/**
 * <p>
 * 图像剪刀
 * </p>
 * <p>
 * 对图像进行剪切
 * </p>
 * Create Date: 2015年12月30日
 * Last Modify: 2016年5月26日
 * 
 * @author Q-WHai
 * @see <a href="https://github.com/qwhai">https://github.com/qwhai</a>
 */
public class ImageScissors implements ImageInterface {

    private static ImageScissors imageScissors = null;
    
    private BufferedImage targetImage = null;
    private ImageReader imageReader = null;
    private ImageReadParam imageReadParam = null;

    private ImageScissors() {
    }
    
    /**
     * 单例模式创建图像剪切工具
     * 
     * @return
     *      图像剪切工具对象
     */
    public static ImageScissors newInstance() {
        if (imageScissors == null) {
            imageScissors = new ImageScissors();
        }
        
        return imageScissors;
    }
    
    /**
     * 打开一张图片
     * 
     * @param sourcePath
     *      原图片路径
     * @throws IOException
     *      读写异常
     */
    public void open(String sourcePath) throws IOException {
        Iterator<ImageReader> iterator = ImageIO.getImageReadersByFormatName("jpg");
        imageReader = (ImageReader) iterator.next();
        InputStream inputStream = new FileInputStream(sourcePath);
        ImageInputStream imageInputStream = ImageIO.createImageInputStream(inputStream);
        imageReader.setInput(imageInputStream, true);
        imageReadParam = imageReader.getDefaultReadParam();
    }

    /**
     * 裁剪图片正中间的一块区域
     * 
     * @param width
     *      裁剪后的区域宽
     * @param height
     *      裁剪后的区域高
     * @throws IOException
     *      读写异常
     */
    public void cutCenter(int width, int height) throws IOException {
        int imageIndex = 0;
        int primaryWidth = imageReader.getWidth(imageIndex);
        int primaryHeight = imageReader.getHeight(imageIndex);
        
        width = width > primaryWidth ? primaryWidth : width;
        height = height > primaryHeight ? primaryHeight : height;
        
        Rectangle rect = new Rectangle(
                (primaryWidth - width) / 2, (primaryHeight - height) / 2,
                width, height);
        imageReadParam.setSourceRegion(rect);
        targetImage = imageReader.read(imageIndex, imageReadParam);
    }
    
    /**
     * 裁剪图片正中间四分之一的区域
     * 
     * @throws IOException
     *      读写异常
     */
    public void cutCenterHalf() throws IOException {
        int imageIndex = 0;
        int width = imageReader.getWidth(imageIndex) / 2;
        int height = imageReader.getHeight(imageIndex) / 2;
        Rectangle rect = new Rectangle(width / 2, height / 2, width, height);
        imageReadParam.setSourceRegion(rect);
        targetImage = imageReader.read(0, imageReadParam);
    }
    
    /**
     * 图片剪切核心方法
     * 
     * @param startX
     *      开始横坐标
     * @param startY
     *      开始纵坐标
     * @param endX
     *      结束横坐标
     * @param endY
     *      结束纵坐标
     * @throws IOException
     *      读写异常
     */
    public void cut(int startX, int startY, int endX, int endY) throws IOException {
        int imageIndex = 0;
        int primaryWidth = imageReader.getWidth(imageIndex);
        int primaryHeight = imageReader.getHeight(imageIndex);
        int width = endX - startX;
        int height = endY - startY;
        
        width = startX + width > primaryWidth ? primaryWidth - startX : width;
        height = startY + height > primaryHeight ? primaryHeight - startY : height;
        
        Rectangle rect = new Rectangle(startX, startY, width, height);
        imageReadParam.setSourceRegion(rect);
        targetImage = imageReader.read(imageIndex, imageReadParam);
    }

    /**
     * 保存目标图片
     * 
     * @param targetPath
     *      目标图片文件路径
     * @throws IOException
     *      读写异常
     */
    public void save(String targetPath) throws IOException {
        ImageIO.write(targetImage, "jpg", new File(targetPath));
    }
}
