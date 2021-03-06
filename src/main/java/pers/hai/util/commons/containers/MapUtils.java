package pers.hai.util.commons.containers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

/**
 * 与Map相关的工具类
 *
 * Create Date: 2015‎-‎11‎-‎25‎
 * Last Modify: 2019-05-22
 * 
 * @author Q-WHai
 * @see <a href="https://github.com/qwhai">https://github.com/qwhai</a>
 */
public final class MapUtils {

    /**
     * 对一个Value类型为Integer的Map进行从大到小排序
     * 
     * @param map
     *          待排序map
     * @return
     *          已排序map
     */
    public static List<Map.Entry<String, Integer>> sortIntegerMap(Map<String, Integer> map) {
        
        List<Map.Entry<String, Integer>> mapSorted = new ArrayList<>(map.entrySet());
        Collections.sort(mapSorted, (o1, o2) -> o1.getValue().compareTo(o2.getValue()));
        
        return mapSorted;
    }
    
    /**
     * 对一个Value类型为Double的Map进行从大到小排序
     * 
     * @param map
     *          待排序map
     * @return
     *          已排序map
     */
    public static List<Map.Entry<String, Double>> sortDoubleMap(Map<String, Double> map) {
        
        List<Map.Entry<String, Double>> mapSorted = new ArrayList<>(map.entrySet());
        Collections.sort(mapSorted, (o1, o2) -> o1.getValue().compareTo(o2.getValue()));

        return mapSorted;
    }
}
