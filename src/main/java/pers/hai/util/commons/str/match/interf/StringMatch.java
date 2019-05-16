package pers.hai.util.commons.str.match.interf;

import java.util.List;

/**
 * <p>
 * 字符串匹配的公共接口
 * </p>
 * Create Date: 2015年12月23日
 * Last Modify: 2016年5月26日
 * 
 * @author Q-WHai
 * @see <a href="https://github.com/qwhai">https://github.com/qwhai</a>
 */
public interface StringMatch {

    /**
     * 获得模式串在匹配串中所有位置
     * 
     * @param match
     *      匹配串
     * @param pattern
     *      模式串
     * @return
     *      所有存在的位置
     */
    List<Integer> indexsOfMatch(String match, String pattern);
}
