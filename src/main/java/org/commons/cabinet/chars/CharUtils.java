package org.commons.cabinet.chars;

/**
 * 字符串操作工具
 *
 * Create Date: 2015‎-‎11-‎27‎
 * Last Modify: 2016-05-26
 * 
 * @author Q-WHai
 * @see <a href="https://github.com/qwhai">https://github.com/qwhai</a>
 */
public final class CharUtils {

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
