package org.commons.cabinet.str.match.impl;

import java.util.ArrayList;
import java.util.List;

import org.commons.cabinet.str.match.interf.StringMatch;
import org.commons.cabinet.str.StringUtils;

/**
 * <p>
 * 基于KMP算法的字符串匹配实现
 * </p>
 * Create Date: 2015年12月23日
 * Last Modify: 2016年5月26日
 * 
 * @author Q-WHai
 * @see <a href="https://github.com/qwhai">https://github.com/qwhai</a>
 */
public class KMP implements StringMatch {

    @Override
    public List<Integer> indexsOfMatch(String match, String pattern) {
        if (StringUtils.isEmpty(match) || StringUtils.isEmpty(pattern)) {
            return null;
        }
        
        List<Integer> indexs = new ArrayList<Integer>();
        char[] t = match.toCharArray();
        char[] p = pattern.toCharArray();
        int[] next = getNext(pattern);
        
        int indexT = 0;
        int indexP = 0;
        while (indexT < t.length) {
            if (t[indexT] == p[indexP]) {
                indexP++;
                indexT++;
            } else {
                if (indexP == 0) {
                    indexT++;
                } else {
                    indexP = next[indexP - 1];
                }
            }
            
            if (indexP == p.length) {
                indexs.add(indexT - indexP);
                indexP = 0;
            }
        }
        
        return indexs;
    }

    /*
     * 获得字符串中的每个最优前缀子字符串中的
     * 最长的最优前缀等于最优后缀的长度
     * 
     * @param text
     *      待计算的字符串
     * @return
     *      返回最长的最优前缀等于最优后缀的长度数组
     */
    private int[] getNext(String text) {
        if (StringUtils.isEmpty(text)) {
            return null;
        }
        
        int textLength = text.length();
        int[] lengths = new int[textLength];
        
        for (int i = 0; i < textLength; i++) {
            String sub = text.substring(0, i + 1);
            int maxLen = 0;
            for (int j = 0; j < sub.length() - 1; j++) {
                String subChild = sub.substring(0, j + 1);
                if (sub.endsWith(subChild) && subChild.length() > maxLen) {
                    maxLen = subChild.length();
                }
            }
            
            lengths[i] = maxLen;
        }
        
        return lengths;
    }
}
