package pers.hai.util.commons.image;

import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * 字模
 *
 * Create Time: 2019/05/17 11:21
 * Last Modify: 2019/05/17
 *
 * @author Q-WHai
 * @see <a href="https://github.com/qwhai">https://github.com/qwhai</a>
 */
public class WordMatrix {

    private Font font;
    private int width = 64;
    private int height = 64;
    private int x = 0;
    private int y = 0;
    private double zx =   1.0;            // 横向缩放比
    private double zy =   1.0;            // 纵向缩放比
    private Color color = Color.BLACK;

    private static final int CORRECT_X = -2;
    private static final int CORRECT_Y = 56;

    private String word = "";

    private int[] matrix = new int[16 * 16];

    private BufferedImage image;
    private BufferedImage[] bi = new BufferedImage[16 * 16];

    public void start() {
        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);

        Graphics2D g2d = image.createGraphics();
        g2d.setFont(font);
        g2d.fillRect(0, 0, width, height);
        g2d.setColor(color);
        g2d.scale(zx, zy);
        g2d.drawString(word, CORRECT_X + x, CORRECT_Y + y);
        g2d.dispose();

        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 16; j++) {
                bi[i * 16 + j] = image.getSubimage(i * 4, j * 4, 4, 4);
            }
        }
        for (int i = 0; i < bi.length; i++) {
            int intD = 0;
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    intD += bi[i].getRGB(j, k);
                }
            }
            matrix[i] = intD;
        }
    }

    public int[] getMatrix() {
        return matrix;
    }

    public void save(String path) {
        if (null == image) return;

        File f1 = new File(path);
        try {
            ImageIO.write(image, "JPG", f1);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void setWord(char word) {
        this.word = String.valueOf(word);
    }

    public void setWord(String word) {
        this.word = word;
    }

    public void setFont(Font font) {
        this.font = font;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setZoom(double zoom) {
        this.zx = zoom;
        this.zy = zoom;
    }

    public void setZx(double zx) {
        this.zx = zx;
    }

    public void setZy(double zy) {
        this.zy = zy;
    }
}
