package pers.hai.util.commons.nums;

import pers.hai.util.commons.str.StringUtils;

import java.util.Stack;

/**
 * 进制转化工具
 *
 * Create Time: 2015-12-25
 * Last Modify: 2019-05-22
 *
 * @author Q-WHai
 * @see <a href="https://github.com/qwhai">https://github.com/qwhai</a>
 */
public class HexUtils {

    /**
     * 将十进制转为任意进制
     *
     * @param   num
     *          待转化的数
     *
     * @param   destBase
     *          目标进制
     *
     * @return  转化后的数字表示
     */
    public static String transfromDecimal(int num, int destBase) {
        if (destBase > 16)
            throw new RuntimeException("进制数超出范围，base<=16");

        StringBuilder sb = new StringBuilder();
        String digths = "0123456789ABCDEF";
        Stack<Character> s = new Stack<>();
        while (num != 0) {
            s.push(digths.charAt(num % destBase));
            num /= destBase;
        }
        while (!s.isEmpty())
            sb.append(s.pop());

        return sb.toString();
    }

    /**
     * 十六进制内任意进制转换
     *
     * @param   number
     *          待转化的数字
     *
     * @param   srcBase
     *          原进制
     *
     * @param   destBase
     *          目标进制
     *
     * @return  转化后的数字表示
     */
    public static String transfromAnyway(String number, int srcBase, int destBase) {
        if (StringUtils.isEmpty(number))
            throw new NullPointerException("待转化的数字不能为空");

        if (srcBase == destBase)
            return number;

        String digths = "0123456789ABCDEF";
        char[] chars = number.toCharArray();
        int len = chars.length;
        if (destBase != 10) {
            number = transfromAnyway(number, srcBase, 10); // 目标进制不是十进制 先转化为十进制
        } else {
            int n = 0;
            for (int i = len - 1; i >= 0; i--)
                n += digths.indexOf(chars[i]) * Math.pow(srcBase, len - i - 1);
            return n + "";
        }

        return transfromDecimal(Integer.valueOf(number), destBase);
    }
}
