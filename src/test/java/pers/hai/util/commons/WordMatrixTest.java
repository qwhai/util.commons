package pers.hai.util.commons;

import org.junit.Test;
import pers.hai.util.commons.image.WordMatrix;

import java.awt.*;

/**
 * TODO
 * <p>
 * Create Time: 2019/05/17 11:31
 * Last Modify: 2019/05/17
 *
 * @author Q-WHai
 * @see <a href="https://github.com/qwhai">https://github.com/qwhai</a>
 */
public class WordMatrixTest {

    @Test
    public void test1() {
        WordMatrix matrix = new WordMatrix();
        matrix.setFont(new Font("文泉驿正黑", Font.BOLD, 64));
        matrix.setColor(Color.BLUE);
        matrix.setWidth(64);
        matrix.setHeight(64);
        matrix.setZoom(1.1);
        matrix.setWord('国');

        matrix.start();
        int[] mx = matrix.getMatrix();
        for (int i = 0; i < 16; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < 16; j++) {
                if (mx[i + j * 16] < -16) {
                    sb.append("■");
                } else {
                    sb.append("-");
                }
            }
            System.out.println(sb.toString());
        }
    }

    @Test
    public void test2() {
        WordMatrix matrix = new WordMatrix();
        matrix.setFont(new Font("文泉驿正黑", Font.BOLD, 64));
        matrix.setColor(Color.BLUE);
        matrix.setWidth(64);
        matrix.setHeight(64);
        matrix.setZoom(1.1);
        matrix.setWord('国');

        matrix.start();
        matrix.save("H:/1/1.jpg");
    }

    @Test
    public void test3() {
        WordMatrix matrix = new WordMatrix();
        matrix.setFont(new Font("文泉驿正黑", Font.BOLD, 64));
        matrix.setColor(Color.BLUE);
        matrix.setWidth(64);
        matrix.setHeight(64);
        matrix.setZx(1.1);
        matrix.setZy(1.1);
        matrix.setWord('国');

        matrix.start();
        matrix.save("H:/1/1.jpg");
    }

    @Test
    public void test4() {
        WordMatrix matrix = new WordMatrix();
        matrix.setFont(new Font("文泉驿正黑", Font.BOLD, 64));
        matrix.setColor(Color.BLUE);
        matrix.setWidth(128);
        matrix.setHeight(64);
        matrix.setZoom(1.1);
        matrix.setWord("中国");

        matrix.start();
        matrix.save("H:/1/1.jpg");
    }

    @Test
    public void test5() {
        WordMatrix matrix = new WordMatrix();
        matrix.setFont(new Font("文泉驿正黑", Font.BOLD, 64));
        matrix.setColor(Color.BLUE);
        matrix.setWidth(128);
        matrix.setHeight(64);
        matrix.setX(0);
        matrix.setY(0);
        matrix.setZoom(1.0);
        matrix.setWord("中国");

        matrix.start();
        matrix.save("H:/1/1.jpg");
    }

    @Test
    public void test6() {
        WordMatrix matrix = new WordMatrix();
        matrix.setFont(new Font("楷体", Font.BOLD, 64));
        matrix.setColor(Color.BLUE);
        matrix.setWidth(128);
        matrix.setHeight(64);
        matrix.setWord("中国");

        matrix.start();
        matrix.save("H:/1/1.jpg");
    }

    @Test
    public void test7() {
        WordMatrix matrix = new WordMatrix();
        matrix.setFont(new Font("Courier New", Font.BOLD, 64));
        matrix.setColor(Color.BLUE);
        matrix.setWidth(188);
        matrix.setHeight(64);
        matrix.setWord("Hello");

        matrix.start();
        matrix.save("H:/1/1.jpg");
    }
}
