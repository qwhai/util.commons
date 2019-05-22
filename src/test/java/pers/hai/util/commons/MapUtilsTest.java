package pers.hai.util.commons;

import org.junit.Test;
import pers.hai.util.commons.containers.MapUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO
 * <p>
 * Create Time: 2019-05-22 14:15
 * Last Modify: 2019-05-22
 *
 * @author Q-WHai
 * @see <a href="https://github.com/qwhai">https://github.com/qwhai</a>
 */
public class MapUtilsTest {

    @Test
    public void test1() {
        Map<String, Integer> map = new HashMap<>(){{
            put("d", 4);
            put("a", 1);
            put("c", 3);
            put("b", 2);
        }};

        List<Map.Entry<String, Integer>> list = MapUtils.sortIntegerMap(map);
        System.out.println(list);
    }

    @Test
    public void test2() {
        Map<String, Double> map = new HashMap<>(){{
            put("e", 4.0);
            put("a", 1.1);
            put("b", 1.6);
            put("d", 3.3);
            put("c", 2.6);
        }};

        List<Map.Entry<String, Double>> list = MapUtils.sortDoubleMap(map);
        System.out.println(list);
    }
}
