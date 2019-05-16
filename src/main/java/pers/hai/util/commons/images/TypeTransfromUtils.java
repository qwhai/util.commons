package pers.hai.util.commons.images;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import pers.hai.util.commons.images.interf.ImageInterface;

/**
 * <p>
 * 图片类型转换工具
 * </p>
 * Create Date: 2015年12月30日
 * Last Modify: 2016年5月26日
 * 
 * @author Q-WHai
 * @see <a href="https://github.com/qwhai">https://github.com/qwhai</a>
 */
public class TypeTransfromUtils implements ImageInterface {

    private static TypeTransfromUtils instance = null;
    
    static final String IMG_PATH = System.getProperty("user.dir") + "/images/originally.jpg";
    
    private TypeTransfromUtils() {
    }
    
    /**
     * 单例模式创建图片类型转换工具
     * 
     * @return
     *      图片类型转换工具对象
     */
    public static TypeTransfromUtils newInstance() {
        if (instance == null) {
            instance = new TypeTransfromUtils();
        }
        
        return instance;
    }
    
    /**
     * 对一张图片进行二值化
     * 
     * @param rawImagePath
     *          原始图片路径
     * @param binaryImagePath
     *          二值化之后图片的路径
     * @throws IOException
     *          IOException
     */
    public void binaryImage(String rawImagePath, String binaryImagePath) throws IOException {
        File file = new File(rawImagePath);
        BufferedImage image = ImageIO.read(file);

        int width = image.getWidth();
        int height = image.getHeight();

        BufferedImage grayImage = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_BINARY);
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                int rgb = image.getRGB(i, j);
                grayImage.setRGB(i, j, rgb);
            }
        }

        // System.getProperty("user.dir") + "/images/binary.jpg"
        File newFile = new File(binaryImagePath);
        ImageIO.write(grayImage, "jpg", newFile);
    }

    /**
     * 对一张图片进行灰度化
     * 
     * @param rawImagePath
     *          原始图片路径
     * @param grayImagePath
     *          灰度化之后图片的路径
     * @throws IOException
     *          IOException
     */
    public void grayImage(String rawImagePath, String grayImagePath) throws IOException {
        File file = new File(rawImagePath);
        BufferedImage image = ImageIO.read(file);

        int width = image.getWidth();
        int height = image.getHeight();

        BufferedImage grayImage = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_GRAY);
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                int rgb = image.getRGB(i, j);
                grayImage.setRGB(i, j, rgb);
            }
        }

        // System.getProperty("user.dir") + "/images/gray.jpg"
        File newFile = new File(grayImagePath);
        ImageIO.write(grayImage, "jpg", newFile);
    }
    
    /**
     * 根据图片类型转换图片
     * 
     * @param rawImagePath
     *      原始图片路径
     * @param grayImagePath
     *      转换化之后图片的路径
     * @param imageType
     *      图片类型
     * @throws IOException
     *      读写异常
     */
    public void transformByImageType(String rawImagePath, String grayImagePath, int imageType) throws IOException {
        File file = new File(rawImagePath);
        BufferedImage image = ImageIO.read(file);

        int width = image.getWidth();
        int height = image.getHeight();

        BufferedImage grayImage = new BufferedImage(width, height, imageType);
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                int rgb = image.getRGB(i, j);
                grayImage.setRGB(i, j, rgb);
            }
        }

        File newFile = new File(grayImagePath);
        ImageIO.write(grayImage, "jpg", newFile);
    }
}
