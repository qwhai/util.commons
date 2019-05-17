package pers.hai.util.commons;

import org.junit.Assert;
import org.junit.Test;
import pers.hai.util.commons.funny.InversePolandExpression;

/**
 * TODO
 *
 * Create Time: 2019/05/17 10:00
 * Last Modify: 2019/05/17
 *
 * @author Q-WHai
 * @see <a href="https://github.com/qwhai">https://github.com/qwhai</a>
 */
public class InversePolandExpressionTest extends Testable {

    @Test
    public void test1() {
        InversePolandExpression expression = new InversePolandExpression();
        Assert.assertEquals(2, expression.inversePolandResult("+ 1 1"), 0);
    }

    @Test
    public void test2() {
        InversePolandExpression expression = new InversePolandExpression();
        Assert.assertEquals(29, expression.inversePolandResult("- × + 3 4 5 6"), 0);
    }

    @Test
    public void test3() {
        InversePolandExpression expression = new InversePolandExpression();
        Assert.assertEquals(9, expression.inversePolandResult("+ ÷ + × 3 4 3 5 6"), 0);
    }
}
