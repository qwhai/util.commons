package pers.hai.util.commons.image;

import java.awt.Color;
import java.awt.Font;
import java.io.IOException;

import pers.hai.util.commons.image.interf.ImageInterface;

// jdk 1.8
//import com.sun.image.codec.jpeg.JPEGCodec;
//import com.sun.image.codec.jpeg.JPEGImageEncoder;

/**
 * <p>
 * 图片叠加工具类
 * </p>
 * Create Date: 2015年12月30日
 * Last Modify: 2016年5月26日
 * 
 * @author Q-WHai
 * @see <a href="https://github.com/qwhai">https://github.com/qwhai</a>
 */
public class ImageOverlayUtils implements ImageInterface {

    private static ImageOverlayUtils instance = null;
    
    private ImageOverlayUtils() {
    }
    
    /**
     * 单例模式创建图片叠加工具对象
     * 
     * @return
     *      工具对象
     */
    public static ImageOverlayUtils newInstance() {
        if (instance == null) {
            instance = new ImageOverlayUtils();
        }
        
        return instance;
    }
    
    /**
     * jdk 1.8
     * 向一个目标图片上覆盖一个水印图片
     * 
     * @param markImgPath
     *      水印图片路径
     * @param targetImgPath
     *      目标图片路径
     * @param x
     *      覆盖位置横坐标
     * @param y
     *      覆盖位置纵坐标
     * @throws IOException
     *      读写异常
     */
    public void putWatermarkImage(String markImgPath, String targetImgPath, int x, int y) throws IOException {
        // 目标文件
        //File targetFile = new File(targetImgPath);
        //Image targetImage = ImageIO.read(targetFile);
        //int widthT = targetImage.getWidth(null);
        //int heightT = targetImage.getHeight(null);
        //
        //BufferedImage bufferedImage = new BufferedImage(widthT, heightT, BufferedImage.TYPE_INT_RGB);
        //Graphics graphics = bufferedImage.createGraphics();
        //graphics.drawImage(targetImage, 0, 0, widthT, heightT, null);
        //
        //// 水印文件
        //File markFile = new File(markImgPath);
        //Image markImage = ImageIO.read(markFile);
        //int widthM = markImage.getWidth(null);
        //int heightM = markImage.getHeight(null);
        //graphics.drawImage(markImage, x, y, widthM, heightM, null);
        //
        //// 水印覆盖
        //graphics.dispose();
        //
        //FileOutputStream outputStream = new FileOutputStream(targetImgPath);
        //JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(outputStream);
        //encoder.encode(bufferedImage);
        //
        //outputStream.close();
    }
    
    /**
     * jdk 1.8
     * 向图片中添加一个文件水印
     * 
     * @param targetImgPath
     *      待添加水印的图片路径
     * @param markLabel
     *      水印文本
     * @param color
     *      文本颜色
     * @param font
     *      文本字体
     * @param x
     *      水印位置横坐标
     * @param y
     *      水印位置纵坐标
     * @throws IOException
     *      读写异常
     */
    public void putWatermarkText(String targetImgPath, String markLabel, Color color, Font font, int x, int y) throws IOException {
        //File targetFile = new File(targetImgPath);
        //Image targetImage = ImageIO.read(targetFile);
        //int widthT = targetImage.getWidth(null);
        //int heightT = targetImage.getHeight(null);
        //
        //BufferedImage bufferedImage = new BufferedImage(widthT, heightT, BufferedImage.TYPE_INT_RGB);
        //Graphics graphics = bufferedImage.createGraphics();
        //graphics.drawImage(targetImage, 0, 0, widthT, heightT, null);
        //
        //graphics.setColor(color);
        //graphics.setFont(font);
        //graphics.drawString(markLabel, x, y);
        //graphics.dispose();
        //
        //FileOutputStream outputStream = new FileOutputStream(targetImgPath);
        //JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(outputStream);
        //encoder.encode(bufferedImage);
        //
        //outputStream.close();
        
        /*
         * 调用过程格式如下：
         * utils.putWatermarkText("F:/IMG/GB/3.jpg", "HELLO WATERMARK!", Color.GREEN, new Font("Courier New", Font.BOLD, 20), 330, 230);
         */
    }
}
