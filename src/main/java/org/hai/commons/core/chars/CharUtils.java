package org.hai.commons.core.chars;

import org.core.utils.excep.CannotInstanceException;
import org.core.utils.interf.UtilsInterface;

/**
 * <p>字符串操作工具</p>
 * Create Date: 2015‎年‎11‎月‎27‎日
 * Last Modify: 2016年5月26日
 * 
 * @author <a href="http://weibo.com/u/5131020927">Q-WHai</a>
 * @see <a href="http://blog.csdn.net/lemon_tree12138">http://blog.csdn.net/lemon_tree12138</a>
 * @version 0.1.1
 */
public final class CharUtils implements UtilsInterface {

    // 禁止实例化
    private CharUtils() throws CannotInstanceException {
        throw new CannotInstanceException("请不要试图初始化我");
    }
    
    @Override
    public String getTag() {
        return this.getClass().getName();
    }

    @Override
    public void description() {
        System.out.println("你可以通过我来操作一个字符");
    }

    /**
     * 判断一个字符是否是数字
     * 
     * @param c
     *      待判断的是字符
     * @return
     *      是否是数字字符
     */
    public static boolean isNumberChar(char c) {
        return ('0' <= c && c <= '9');
    }
    
    /**
     * 判断一个字符是否是大写字母
     * 
     * @param c
     *      待判断的是字符
     * @return
     *      是否是大写字母字符
     */
    public static boolean isCapital(char c) {
        return ('A' <= c && c <= 'Z');
    }
    
    /**
     * 判断一个字符是否是小写字母
     * 
     * @param c
     *      待判断的是字符
     * @return
     *      是否是小写字母字符
     */
    public static boolean isLowercase(char c) {
        return ('a' <= c && c <= 'z');
    }
    
    /**
     * 判断一个字符是否是字母
     * 
     * @param c
     *      待判断的是字符
     * @return
     *      是否是字母字符
     */
    public static boolean isLetter(char c) {
        return (isLowercase(c) || isCapital(c));
    }
}
