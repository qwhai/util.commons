package org.commons.cabinet.containers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import org.commons.cabinet.excep.CannotInstanceException;

/**
 * <p>
 * 与Map相关的工具类
 * </p>
 * Create Date: 2015‎年‎11‎月‎25‎日
 * Last Modify: 2016年5月26日
 * 
 * @author Q-WHai
 * @see <a href="https://github.com/qwhai">https://github.com/qwhai</a>
 */
public final class MapUtils {

    // 禁止实例化
    private MapUtils() throws CannotInstanceException {
        throw new CannotInstanceException("不要试图实例化我");
    }

    /**
     * 对一个Value类型为Integer的Map进行从大到小排序
     * 
     * @param map
     *          待排序map
     * @return
     *          已排序map
     */
    public static List<Map.Entry<String, Integer>> sortIntegerMap(Map<String, Integer> map) {
        
        List<Map.Entry<String, Integer>> mapSorted = new ArrayList<Map.Entry<String, Integer>>(map.entrySet());
        Collections.sort(mapSorted, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });
        
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
        
        List<Map.Entry<String, Double>> mapSorted = new ArrayList<Map.Entry<String, Double>>(map.entrySet());
        Collections.sort(mapSorted, new Comparator<Map.Entry<String, Double>>() {
            public int compare(Map.Entry<String, Double> o1, Map.Entry<String, Double> o2) {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });
        
        return mapSorted;
    }
}
