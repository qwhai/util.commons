package pers.hai.util.commons;

import org.junit.Test;
import pers.hai.util.commons.image.ImageUtils;

import java.awt.*;

/**
 * TODO
 * <p>
 * Create Time: 2019/05/17 10:59
 * Last Modify: 2019/05/17
 *
 * @author Q-WHai
 * @see <a href="https://github.com/qwhai">https://github.com/qwhai</a>
 */
public class ImageUtilsTest {

    @Test
    public void test1() {
        Font font = new Font("Courier New", Font.BOLD, 270);

        ImageUtils.addWaterMark("H:\\2\\1.jpg", "H:\\2\\1.1.jpg", "Hello", Color.YELLOW, font);
    }
}
