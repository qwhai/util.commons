package org.commons.cabinet.str.match.impl;

import java.util.ArrayList;
import java.util.List;

import org.commons.cabinet.str.StringUtils;
import org.commons.cabinet.str.match.interf.StringMatch;

/**
 * <p>
 * 基于朴素字符串匹配算法的字符串匹配实现
 * </p>
 * Create Date: 2015年12月23日
 * Last Modify: 2016年5月26日
 * 
 * @author Q-WHai
 * @see <a href="https://github.com/qwhai">https://github.com/qwhai</a>
 */
public class NativeMatch implements StringMatch {

    @Override
    public List<Integer> indexsOfMatch(String match, String pattern) {
        if (StringUtils.isEmpty(match) || StringUtils.isEmpty(pattern)) {
            return null;
        }

        List<Integer> indexs = new ArrayList<Integer>();
        char[] t = match.toCharArray();
        char[] p = pattern.toCharArray();
        int tLength = t.length;
        int pLength = p.length;

        for (int i = 0; i <= tLength - pLength; i++) {
            for (int j = 0; j < pLength; j++) {
                if (t[i + j] == p[j]) {
                    if (j == pLength - 1) {
                        indexs.add(i);
                    }
                    continue;
                }

                break;
            }
        }

        return indexs;
    }
}
