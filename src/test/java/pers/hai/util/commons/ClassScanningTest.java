package pers.hai.util.commons;

import org.junit.Test;
import pers.hai.util.commons.scan.ClassScanner;

/**
 * TODO
 * <p>
 * Create Time: 2019-05-22 14:08
 * Last Modify: 2019-05-22
 *
 * @author Q-WHai
 * @see <a href="https://github.com/qwhai">https://github.com/qwhai</a>
 */
public class ClassScanningTest {

    @Test
    public void test1() {
        ClassScanner scanning = new ClassScanner();
        var classes = scanning.getClasses("pers.hai.util.commons", true);
        System.out.println(classes);
    }
}
