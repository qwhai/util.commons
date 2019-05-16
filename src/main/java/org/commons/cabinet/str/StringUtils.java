package org.commons.cabinet.str;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.commons.cabinet.chars.CharUtils;
import org.commons.cabinet.excep.CannotInstanceException;
import org.commons.cabinet.nums.RandomUtils;
import org.commons.cabinet.str.match.impl.KMP;
import org.commons.cabinet.str.match.poke.StringMatchUtils;

/**
 * 与字符串操作相关的工具类
 *
 * Create Date: 2015-11-15
 * Last Modify: 2019-05-16
 * 
 * @author Q-WHai
 * @see <a href="https://github.com/qwhai">https://github.com/qwhai</a>
 */
public class StringUtils {

    /**
     * 判断一个字符串是否为空字符串
     * 
     * @param text
     *            待判断的字符串
     * @return 是否为空字符串
     */
    public static boolean isEmpty(String text) {
        return text == null || text.length() == 0;
    }
    
    /**
     * 反转一个字符串
     * 
     * @param label
     *          待反转字符串
     * @return
     *          字符串的反转序列
     */
    public static String reverseString(String label) {
        return new StringBuffer(label).reverse().toString();
    }
    
    /**
     * 重复一个字符串n遍
     * 
     * @param label
     *      待重复的字符串
     * @param n
     *      重复次数
     * @return
     *      重复后的字符串
     */
    public static String repeat(String label, int n) {
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < n; i++) {
            buffer.append(label);
        }
        
        return buffer.toString();
    }
    
    /**
     * 判断一个字符串是可以由另一个字符串经过N次拼接得到
     * 
     * @param label
     *      待判断的字符串
     * @param pattern
     *      模式字符串
     * @return
     *      结果
     */
    public static boolean splicing(String label, String pattern) {
        label = label.replaceAll(pattern, "");
        return label.length() == 0;
    }
    
    /**
     * 统计一个数的所有因子
     * 
     * @param n
     *      数字
     * @return
     *      所有因子
     */
    public static ArrayList<Integer> factors(int n) {
        if (n <= 0) {
            return null;
        }
        
        ArrayList<Integer> factors = new ArrayList<Integer>();
        int half = n / 2;
        for (int i = 1; i <= half; i++) {
            if (n % i == 0) {
                factors.add(i);
            }
        }
        
        return factors;
    }
    
    /**
     * 计算一个字符串的最小正周期
     * 
     * @param label
     *      待处理字符串
     * @return
     *      最小正周期
     */
    public static int minCycle(String label) {
        int cycle = 1;
        int length = label.length();
        ArrayList<Integer> factors = factors(length);
        if (factors == null) {
            return 1;
        }
        
        int factorSize = factors.size();
        for (int i = 0; i < factorSize; i++) {
            String pattern = label.substring(0, factors.get(i));
            if (splicing(label, pattern)) {
                cycle = length / factors.get(i);
                break;
            }
        }
        
        return cycle;
    }
    
    /**
     * 将一个字符串循环左移n位
     * 
     * @param label
     *      待移动的字符串
     * @param n
     *      移动位数
     * @return
     *      结果字符串
     */
    public static String leftShift(String label, int n) {
        if (isEmpty(label) || label.length() == 1) {
            return label;
        }
        
        int length = label.length();
        int seek = (n + length) % length;
        
        StringBuffer buffer = new StringBuffer();
        buffer.append(label.substring(seek, length));
        buffer.append(label.substring(0, seek));
        
        return buffer.toString();
    }
    
    /**
     * 将一个字符串循环右移n位
     * 
     * @param label
     *      待移动的字符串
     * @param n
     *      移动位数
     * @return
     *      结果字符串
     */
    public static String rightShift(String label, int n) {
        if (isEmpty(label) || label.length() == 1) {
            return label;
        }
        
        return leftShift(label, label.length() - n);
    }
    
    /**
     * 统计匹配串中模式串的个数
     * 
     * @param match
     *      匹配串
     * @param pattern
     *      模式串
     * @return
     *      个数
     */
    public static int countMatches(String match, String pattern) {
        StringMatchUtils stringMatch = new StringMatchUtils(new KMP());
        return stringMatch.indexsOfMatch(match, pattern).size();
    }
    
    /**
     * 格式化一个浮点型数据
     * 
     * @param data
     *      数值
     * @param pattern
     *      格式化模式(比如：#0.0)
     * @return
     *      格式化后的字符串
     */
    public static String formatDoubleString(double data, String pattern) {
        DecimalFormat format = new DecimalFormat(pattern);
        
        if (data < 0) {
            return "0";
        }
        
        if ((int) (data * 10) == (int) (data) * 10) {
            return (int) data + "";
        } else {
            return format.format(data);
        }
    }
    
    /**
     * 格式化一个整型的数字为一个字符串
     * 
     * @param data
     *      整型数字
     * @param pattern
     *      格式化模式(比如：#000)
     * @return
     *      格式化后的字符串
     */
    public static String formatIntegerString(int data, String pattern) {
        return new DecimalFormat(pattern).format(data);
    }
    
    /**
     * 判断一个字符可以表示一个数字
     * 
     * @param string
     *      字符串
     * @return
     *      判断结果
     */
    @Deprecated
    public static boolean isNumberString(String string) {
        if (StringUtils.isEmpty(string)) {
            return false;
        }
        
        char[] chars = string.toCharArray();
        for (char c : chars) {
            if (!CharUtils.isNumberChar(c)) {
                return false;
            }
        }
        
        return true;
    }
    
    /**
     * 随机生成一段字符串
     * 
     * @param length
     *      字符串长度限制
     * @return
     *      随机字符串
     */
    public static String randomString(int length) {
        StringBuffer buffer = new StringBuffer();
        RandomUtils random = new RandomUtils(26);
        for (int i = 0; i < length; i++) {
            char c = (char) (random.nextInt() + 'a');
            buffer.append(c);
        }
        
        return buffer.toString();
    }
    
    /**
     * 随机生成一段字符串
     * (默认长度不超过64)
     * 
     * @return
     *      随机字符串
     */
    public static String randomString() {
        return randomString(new RandomUtils(2 << 5).nextInt());
    }
    
    // TODO ------------------------------------------- 内部类标识分隔线 ----------------------------------------------------------
    
    /**
     * <p>
     * 处理与字符串相关的正则表达式的工具类
     * </p>
     * 2015年11月25日
     * 
     * @author Q-WHai
     * @see <a href="http://blog.csdn.net/lemon_tree12138">http://blog.csdn.net/lemon_tree12138</a>
     */
    public static class RegexUtils {

        private RegexUtils() throws CannotInstanceException {
            throw new CannotInstanceException("不要试图实例化我");
        }

        /**
         * 获得匹配的字符串
         * 
         * @param str
         *      待匹配的字符串
         * @param re
         *      匹配的正则表达式
         * @return
         *      返回匹配结果
         */
        public static String getSub(String str, String re) {
            String name = "";
            Pattern pattern = Pattern.compile(re);
            Matcher match = pattern.matcher(str);
            if (match.find(0)) {
                name = match.group();
            }

            return name;
        }
        
        /**
         * 获得所有匹配的字符串
         * 
         * @param str
         *      待匹配的字符串
         * @param re
         *      匹配的正则表达式
         * @return
         *      返回匹配结果
         */
        public static List<String> getSubs(String str, String re) {
            List<String> subs = new ArrayList<>();
            
            Pattern pattern = Pattern.compile(re);
            Matcher match = pattern.matcher(str);
            
            while(match.find()) {
                subs.add(match.group());
            }

            return subs;
        }

        /**
         * 判断一段字符串中是否包含中文
         * 
         * @param text
         *          待匹配的字符串
         * @return
         *          是否包含中文
         */
        public static boolean hasChinese(String text) {
            // 匹配的字符串的正则表达式
            String reg_charset = "[\u4e00-\u9fa5]*";

            Pattern p = Pattern.compile(reg_charset);
            Matcher m = p.matcher(text);
            
            while (m.find()) {
                if (m.group().length() > 0) {
                    return true;
                }
            }

            return false;
        }
        
        /**
         * 是否是全中文
         * 
         * @param text
         *      字符串
         * @return
         *      匹配结果
         */
        public static boolean chineseEveryChar(String text) {
            // 匹配的字符串的正则表达式
            return isSub(text, "^[\u4e00-\u9fa5]{0,}$");
        }
        
        /**
         * 判断str是否匹配正则表达式re
         * 
         * @param str
         *          待匹配的字符串
         * @param re
         *          匹配的正则表达式
         * @return
         *          匹配结果
         */
        public static boolean isSub(String str, String re) {
            Pattern pattern = Pattern.compile(re);
            Matcher match = pattern.matcher(str);
            if (match.find(0)) {
                return true;
            }
            
            return false;
        }
        
        /**
         * 计算一个URL所属的网站地址
         * 
         * @param url
         *          待计算的URL
         * @return
         *          返回此URL所属的网站名称
         */
        public static String getWebsiteAddressByURL(String url) {
            return getSub(url, "http(s)?://[\\w.]+/?");
        }
        
        /**
         * 判断一个字符是否是一个URL
         * 
         * @param string
         *      字符串
         * @return
         *      是否是一个合法的URL
         */
        public static boolean isWebsiteAddress(String string) {
            return isSub(string, "^http(s)?://[\\w.]+/?[\\w-.%]*");
        }
        
        /**
         * 判断一个字符串是否是数字
         * 
         * @param string
         *      字符串
         * @return
         *      是否是数字
         */
        public static boolean isNumberString(String string) {
            return isSub(string, "^[0-9]+$");
        }
        
        /**
         * 是否是一个X位的数字
         * 
         * @param string
         *      字符串
         * @param x
         *      位数
         * @return
         *      是否成立
         */
        public static boolean isNumberCountX(String string, int x) {
            return isSub(string, "^\\d{" + x + "}$");
        }
        
        /**
         * 是否是一个至少X位的数字
         * 
         * @param string
         *      字符串
         * @param x
         *      位数
         * @return
         *      是否成立
         */
        public static boolean isNumberCountLeastX(String string, int x) {
            return isSub(string, "^\\d{" + x + ",}$");
        }
        
        /**
         * 是否是一个m-n位的数字
         * 
         * @param string
         *      字符串
         * @param min
         *      位数下限
         * @param max
         *      位数上限
         * @return
         *      是否成立
         */
        public static boolean isNumberCountLeastX(String string, int min, int max) {
            return isSub(string, "^\\d{" + min + "," + max + "}$");
        }
    }
}
