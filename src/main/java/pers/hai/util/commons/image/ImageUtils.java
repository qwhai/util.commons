package pers.hai.util.commons.image;

import org.apache.log4j.Logger;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;

/**
 * TODO
 * <p>
 * Create Time: 2019/05/17 10:53
 * Last Modify: 2019/05/17
 *
 * @author Q-WHai
 * @see <a href="https://github.com/qwhai">https://github.com/qwhai</a>
 */
public class ImageUtils {

    private static final Logger logger = Logger.getLogger(ImageUtils.class);

    /**
     * 给图片添加水印
     *
     * @param srcImgPath       源图片路径
     * @param tarImgPath       保存的图片路径
     * @param waterMarkContent 水印内容
     * @param markContentColor 水印颜色
     * @param font             水印字体
     */
    public static void addWaterMark(String srcImgPath, String tarImgPath, String waterMarkContent, Color markContentColor, Font font) {
        try {
            // 读取原图片信息
            File srcImgFile = new File(srcImgPath); // 得到文件
            Image srcImg = ImageIO.read(srcImgFile); // 文件转化为图片
            int srcImgWidth = srcImg.getWidth(null); // 获取图片的宽
            int srcImgHeight = srcImg.getHeight(null); // 获取图片的高

            // 加水印
            BufferedImage bufImg = new BufferedImage(srcImgWidth, srcImgHeight, BufferedImage.TYPE_INT_RGB);
            Graphics2D g = bufImg.createGraphics();
            g.drawImage(srcImg, 0, 0, srcImgWidth, srcImgHeight, null);
            g.setColor(markContentColor);

            // 根据图片的背景设置水印颜色
            g.setFont(font); // 设置字体

            // 设置水印的坐标
            int x = srcImgWidth - 2 * getWatermarkLength(waterMarkContent, g);
            int y = srcImgHeight - 2 * getWatermarkLength(waterMarkContent, g);
            g.drawString(waterMarkContent, x, y); // 画出水印
            g.dispose();

            // 输出图片
            FileOutputStream outImgStream = new FileOutputStream(tarImgPath);
            ImageIO.write(bufImg, "jpg", outImgStream);
            logger.info("attack water mark complete.");

            outImgStream.flush();
            outImgStream.close();
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }
    }

    // ------------------------------------------------- 内部方法分隔线 --------------------------------------------------

    private static int getWatermarkLength(String waterMarkContent, Graphics2D g) {
        return g.getFontMetrics(g.getFont()).charsWidth(waterMarkContent.toCharArray(), 0, waterMarkContent.length());
    }
}
