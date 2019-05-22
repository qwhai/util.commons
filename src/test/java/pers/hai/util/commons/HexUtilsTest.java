package pers.hai.util.commons;

import org.junit.Assert;
import org.junit.Test;
import pers.hai.util.commons.nums.HexUtils;

/**
 * TODO
 * <p>
 * Create Time: 2019-05-22 16:32
 * Last Modify: 2019-05-22
 *
 * @author Q-WHai
 * @see <a href="https://github.com/qwhai">https://github.com/qwhai</a>
 */
public class HexUtilsTest extends Testable {

    @Test
    public void test1() {
        Assert.assertEquals("78", HexUtils.transfromDecimal(120, 16));
        Assert.assertEquals("A", HexUtils.transfromDecimal(10, 16));
        Assert.assertEquals("FF", HexUtils.transfromDecimal(255, 16));
    }

    @Test
    public void test2() {
        Assert.assertEquals("78", HexUtils.transfromAnyway("120", 10, 16));
        Assert.assertEquals("124", HexUtils.transfromAnyway("565", 7, 16));
        Assert.assertEquals("100100100", HexUtils.transfromAnyway("565", 7, 2));
        Assert.assertEquals("292", HexUtils.transfromAnyway("565", 7, 10));
    }
}
