package org.hai.commons.core.str.match.poke;

import java.util.List;

import org.hai.commons.core.str.match.interf.StringMatch;

/**
 * <p>
 * 策略的包装类
 * </p>
 * Create Date: 2015年12月23日
 * Last Modify: 2016年5月26日
 * 
 * @author <a href="http://weibo.com/u/5131020927">Q-WHai</a>
 * @see <a href="http://blog.csdn.net/lemon_tree12138">http://blog.csdn.net/lemon_tree12138</a>
 * @version 0.1.1
 */
public class StringMatchUtils {

    private StringMatch stringMatch = null;
    
    /**
     * <p>
     * 构造器重载
     * </p>
     * 2015年12月23日
     * 
     * @param _stringMatch
     *      传入一个待包装的StringMatch接口
     * @see <a href="http://blog.csdn.net/lemon_tree12138">http://blog.csdn.net/lemon_tree12138</a>
     */
    public StringMatchUtils(StringMatch _stringMatch) {
        stringMatch = _stringMatch;
    }
    
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
    public List<Integer> indexsOfMatch(String match, String pattern) {
        return stringMatch.indexsOfMatch(match, pattern);
    }
}
