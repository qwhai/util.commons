package org.utils.naga.str;

import org.utils.naga.excep.CannotInstanceException;
import org.utils.naga.interf.UtilsInterface;

/**
 * <p>
 * 字符串编辑距离的算法实现
 * </p>
 * 2015年10月14日
 * 
 * @author <a href="http://weibo.com/u/5131020927">Q-WHai</a>
 * @see <a href="http://blog.csdn.net/lemon_tree12138">http://blog.csdn.net/lemon_tree12138</a>
 * @version 0.1.1
 */
public class LevensteinDistance implements UtilsInterface {

    // 工具类，禁止实例化
    private LevensteinDistance() throws CannotInstanceException {
        throw new CannotInstanceException("不要试图实例化我");
    }
    
    @Override
    public String getTag() {
        return getClass().getName();
    }

    @Override
    public void description() {
        System.out.println("这是一个字符串编辑距离的算法实现工具，你可以使用此工具进行DNA分析、拼字检查、语音辨识、抄袭侦测等领域.");
    }
    
    /**
     * 比较计算两个字符串的编辑距离
     * 
     * @param str1
     *      第一个字符串
     * @param str2
     *      第二个字符串
     * @return
     *      编辑距离
     */
    public static float levenstein(String str1, String str2) {
        // 计算两个字符串的长度。
        int len1 = str1.length();
        int len2 = str2.length();
        // 建立上面说的数组，比字符长度大一个空间
        int[][] dif = new int[len1 + 1][len2 + 1];
        // 赋初值，步骤B。
        for (int a = 0; a <= len1; a++) {
            dif[a][0] = a;
        }
        for (int a = 0; a <= len2; a++) {
            dif[0][a] = a;
        }
        // 计算两个字符是否一样，计算左上的值
        int temp;
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    temp = 0;
                } else {
                    temp = 1;
                }
                // 取三个值中最小的
                dif[i][j] = min(dif[i - 1][j - 1] + temp, dif[i][j - 1] + 1,
                        dif[i - 1][j] + 1);
            }
        }
        
        // 计算相似度
        float similarity = 1 - (float) dif[len1][len2] / Math.max(str1.length(), str2.length());
        
        return similarity;
    }

    // 得到最小值
    private static int min(int... is) {
        int min = Integer.MAX_VALUE;
        for (int i : is) {
            if (min > i) {
                min = i;
            }
        }
        return min;
    }
}