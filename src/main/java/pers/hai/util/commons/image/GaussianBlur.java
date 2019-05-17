package pers.hai.util.commons.image;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import pers.hai.util.commons.math.MathUtils;
import pers.hai.util.commons.image.interf.ImageInterface;

/**
 * <p>
 * 高斯模糊算法
 * </p>
 * <p>
 * 基于二维环境下的正态分布
 * </p>
 * <p>程序参考：</p>
 * <p>http://www.ruanyifeng.com/blog/2012/11/gaussian_blur.html</p>
 * <p>http://blog.csdn.net/jia20003/article/details/7234741</p>
 * Create Date: 2015年12月29日
 * Last Modify: 2016年5月26日
 * 
 * @author Q-WHai
 * @see <a href="https://github.com/qwhai">https://github.com/qwhai</a>
 */
@Deprecated
public class GaussianBlur implements ImageInterface {

    private static GaussianBlur instance = null;
    
    private int radius;
    private int round;
    
    // 高斯函数的权重矩阵
    private float[][] normal_distribution = null;
    
    /*
     * <p>
     * 高斯模糊算法构造器
     * </p>
     * 2015年12月29日
     * 
     * @param _round
     *      轮循次数
     * @param _radius
     *      模糊半径
     *
     * @see <a href="http://blog.csdn.net/lemon_tree12138">http://blog.csdn.net/lemon_tree12138</a>
     */
    private GaussianBlur(int _round, int _radius) {
        round = _round;
        radius = _radius;
        initEvent(radius, 1.5f);
    }
    
    /**
     * 单例模式获得高斯模糊工具
     * 
     * @param _round
     *      轮循次数
     * @param _radius
     *      模糊半径
     * @return
     *      高斯模糊工具对象
     */
    public static GaussianBlur newInstance(int _round, int _radius) {
        if (instance == null) {
            instance = new GaussianBlur(_round, _radius);
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
        gaussianBlur(sourcePath, sourcePath, round, radius);
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
        gaussianBlur(sourcePath, targetPath, round, radius);
    }
    
    /**
     * 基于正态分布的图片高斯模糊
     * 
     * @param sourcePath
     *      图片原路径
     * @param targetPath
     *      图片目标路径
     * @param round
     *      轮循高斯模糊的次数
     * @param radius
     *      高斯模糊半径
     * @throws IOException
     *      读写异常
     */
    public void gaussianBlur(String sourcePath, String targetPath, int round, int radius) throws IOException {
        BufferedImage bufferedImage = ImageIO.read(new File(sourcePath));
        int height = bufferedImage.getHeight();
        int width = bufferedImage.getWidth();
        
        int matrixLength = 2 * radius + 1;
        int[][] matrix = new int[matrixLength][matrixLength];
        int[] values = new int[matrixLength * matrixLength];
        
        for (int r = 0; r < round; r++) {
            for (int i = 0; i < width; i++) {
                for (int j = 0; j < height; j++) {
                    readPixel(bufferedImage, i, j, values);
                    fillMatrix(matrix, values);
                    bufferedImage.setRGB(i, j, avgMatrix(matrix));
                }
            }
        }
        
        ImageIO.write(bufferedImage, "jpg", new File(targetPath));
    }
    
    /**
     * 基于正态分布的图片高斯模糊
     * 
     * @param sourcePath
     *      图片原路径
     * @param startX
     *      模糊位置的开始横坐标
     * @param startY
     *      模糊位置的开始纵坐标
     * @param blurWidth
     *      模糊区域的宽度
     * @param blurHeight
     *      模糊区域的高度
     * @throws IOException
     *      读写异常
     */
    public void gaussianBlur(String sourcePath, int startX, int startY, int blurWidth, int blurHeight) throws IOException {
        BufferedImage bufferedImage = ImageIO.read(new File(sourcePath));
        int height = bufferedImage.getHeight();
        int width = bufferedImage.getWidth();
        
        blurWidth = blurWidth + startX > width ? width - startX : blurWidth;
        blurHeight = blurHeight + startY > height ? height - startY : blurHeight;
        
        int matrixLength = 2 * radius + 1;
        int[][] matrix = new int[matrixLength][matrixLength];
        int[] values = new int[matrixLength * matrixLength];
        
        for (int r = 0; r < round; r++) {
            for (int i = startX; i < blurWidth + startX; i++) {
                for (int j = startY; j < blurHeight + startY; j++) {
                    readPixel(bufferedImage, i, j, values);
                    fillMatrix(matrix, values);
                    bufferedImage.setRGB(i, j, avgMatrix(matrix));
                }
            }
        }
        
        ImageIO.write(bufferedImage, "jpg", new File(sourcePath));
    }
    
    /*
     * 初始化任务
     * 
     * @param n
     *      二维高斯的范围[-n, n]
     * @param σ
     *      标准方差
     */
    private void initEvent(int n, float σ) {
        normal_distribution = MathUtils.getTwoDimenGaussianSumOne(n, σ);
    }
    
    /*
     * 读取图片上的像素点
     * 
     * @param img
     *            图片
     * @param x
     *            像素的横坐标
     * @param y
     *            像素的纵坐标
     * @param pixels
     *            保存图片中以(x, y)为中心点，半径为1的周围n个点像素RGB值
     */
    private void readPixel(BufferedImage img, int x, int y, int[] pixels) {
        int radius = (int) ((Math.sqrt(pixels.length) - 1) / 2);
        int raw = 2 * radius + 1;
        int clo = 2 * radius + 1;
        
        int xStart = x - radius;
        int yStart = y - radius;
        int current = 0;
        for (int i = xStart; i < clo + xStart; i++) {
            for (int j = yStart; j < raw + yStart; j++) {
                int tx = i;
                // 边界处理
                if (tx < 0) {
                    tx = -tx;
                } else if (tx >= img.getWidth()) {
                    tx = x;
                }

                int ty = j;
                // 边界处理
                if (ty < 0) {
                    ty = -ty;
                } else if (ty >= img.getHeight()) {
                    ty = y;
                }
                pixels[current++] = img.getRGB(tx, ty);
            }
        }
    }

    /*
     * 将读取的像素RGB值保存到二维数组中
     * 
     * @param matrix
     *            二维数组
     * @param values
     *            一维数组
     */
    private void fillMatrix(int[][] matrix, int... values) {
        int filled = 0;
        for (int i = 0; i < matrix.length; i++) {
            int[] x = matrix[i];
            for (int j = 0; j < x.length; j++) {
                x[j] = values[filled++];
            }
        }
    }

    /*
     * 计算平均值重新写入图片
     * 
     * @param matrix
     *      保存的二维数组
     * @return
     *      新的颜色RGB
     */
    private int avgMatrix(int[][] matrix) {
        int red = 0;
        int green = 0;
        int blue = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                Color color = new Color(matrix[i][j]);
                red += (normal_distribution[i][j] * color.getRed());
                green += (normal_distribution[i][j] * color.getGreen());
                blue += (normal_distribution[i][j] * color.getBlue());
            }
        }
        return new Color(red, green, blue).getRGB();
    }
}
