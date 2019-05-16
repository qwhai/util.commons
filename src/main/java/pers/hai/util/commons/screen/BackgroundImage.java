package pers.hai.util.commons.screen;

import java.awt.Graphics;

import javax.swing.JLabel;

/**
 * <p>
 * 显示图片的Label
 * </p>
 * Create Date: 2015‎年‎11‎月‎27‎日
 * Last Modify: 2016年5月26日
 * 
 * @author Q-WHai
 * @see <a href="https://github.com/qwhai">https://github.com/qwhai</a>
 */
class BackgroundImage extends JLabel {
    
    private static final long serialVersionUID = -7252282614497216965L;
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawRect(x, y, w, h);
        String area = Integer.toString(w) + " * " + Integer.toString(h);
        g.drawString(area, x + (int) w / 2 - 15, y + (int) h / 2);
        g.drawLine(lineX, 0, lineX, getHeight());

        g.drawLine(0, lineY, getWidth(), lineY);
    }

    public void drawRectangle(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        h = height;
        w = width;
        repaint();
    }

    public void drawCross(int x, int y) {
        lineX = x;
        lineY = y;
        repaint();
    }

    int lineX, lineY;
    int x, y, h, w;
}