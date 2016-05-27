package org.utils.naga.screen;

import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.imageio.*;

/**
 * <p>
 * 一个简单的屏幕抓图
 * </p>
 * Create Date: 2015‎年‎11‎月‎27‎日
 * Last Modify: 2016年5月26日
 * 
 * @author <a href="http://weibo.com/u/5131020927">Q-WHai</a>
 * @see <a href="http://blog.csdn.net/lemon_tree12138">http://blog.csdn.net/lemon_tree12138</a>
 * @version 0.1.1
 */
class ScreenCapture {
    
    private ScreenCapture() {

        try {
            robot = new Robot();
        } catch (AWTException e) {
            System.err.println("Internal Error: " + e);
            e.printStackTrace();
        }
        JPanel cp = (JPanel) dialog.getContentPane();
        cp.setLayout(new BorderLayout());
        labFullScreenImage.addMouseListener(new MouseAdapter() {
            public void mouseReleased(MouseEvent evn) {
                isFirstPoint = true;
                pickedImage = fullScreenImage.getSubimage(recX, recY, recW,
                        recH);
                dialog.setVisible(false);
            }
        });

        labFullScreenImage.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent evn) {
                if (isFirstPoint) {
                    x1 = evn.getX();
                    y1 = evn.getY();
                    isFirstPoint = false;
                } else {
                    x2 = evn.getX();
                    y2 = evn.getY();
                    int maxX = Math.max(x1, x2);
                    int maxY = Math.max(y1, y2);
                    int minX = Math.min(x1, x2);
                    int minY = Math.min(y1, y2);
                    recX = minX;
                    recY = minY;
                    recW = maxX - minX;
                    recH = maxY - minY;
                    labFullScreenImage.drawRectangle(recX, recY, recW, recH);
                }
            }

            public void mouseMoved(MouseEvent e) {
                labFullScreenImage.drawCross(e.getX(), e.getY());
            }
        });

        cp.add(BorderLayout.CENTER, labFullScreenImage);
        dialog.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
        dialog.setAlwaysOnTop(true);
        dialog.setMaximumSize(Toolkit.getDefaultToolkit().getScreenSize());
        dialog.setUndecorated(true);
        dialog.setSize(dialog.getMaximumSize());
        dialog.setModal(true);
    }

    // Singleton Pattern
    public static ScreenCapture getInstance() {
        return defaultCapturer;
    }

    /** 捕捉全屏慕 */
    public Icon captureFullScreen() {
        fullScreenImage = robot.createScreenCapture(new Rectangle(Toolkit
                .getDefaultToolkit().getScreenSize()));
        ImageIcon icon = new ImageIcon(fullScreenImage);
        return icon;
    }

    /** 捕捉屏幕的一个矫形区域 */
    public void captureImage() {
        fullScreenImage = robot.createScreenCapture(new Rectangle(Toolkit
                .getDefaultToolkit().getScreenSize()));
        ImageIcon icon = new ImageIcon(fullScreenImage);
        labFullScreenImage.setIcon(icon);
        dialog.setVisible(true);
    }

    /** 得到捕捉后的BufferedImage */
    public BufferedImage getPickedImage() {
        return pickedImage;
    }

    /** 得到捕捉后的Icon */
    public ImageIcon getPickedIcon() {
        return new ImageIcon(getPickedImage());
    }

    /**
     * 储存为一个文件,为PNG格式
     * 
     * replaced by saveAsPNG(File file)
     **/
    public void saveToFile(File file) throws IOException {
        ImageIO.write(getPickedImage(), defaultImageFormater, file);
    }

    /** 储存为一个文件,为PNG格式 */
    public void saveAsPNG(File file) throws IOException {
        ImageIO.write(getPickedImage(), "png", file);
    }

    /** 储存为一个JPEG格式图像文件 */
    public void saveAsJPEG(File file) throws IOException {
        ImageIO.write(getPickedImage(), "JPEG", file);
    }

    /** 写入一个OutputStream */
    public void write(OutputStream out) throws IOException {
        ImageIO.write(getPickedImage(), defaultImageFormater, out);
    }

    // singleton design pattern
    private static ScreenCapture defaultCapturer = new ScreenCapture();
    private int x1, y1, x2, y2;
    private int recX, recY, recH, recW; // 截取的图像
    private boolean isFirstPoint = true;
    private BackgroundImage labFullScreenImage = new BackgroundImage();
    private Robot robot;
    private BufferedImage fullScreenImage;
    private BufferedImage pickedImage;
    private String defaultImageFormater = "png";
    private JDialog dialog = new JDialog();
}
