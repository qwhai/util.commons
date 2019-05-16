package pers.hai.util.commons;

/**
 * 字节工具类
 *
 * Create Time: 2019/05/16 14:53
 * Last Modify: 2019/05/16
 *
 * @author Q-WHai
 * @see <a href="https://github.com/qwhai">https://github.com/qwhai</a>
 */
public class ByteUtils {

    /**
     * 把byte类型的数据转换成十六进制ASCII字符表示
     *
     * @param   in
     *          待转化字节
     *
     * @return  十六进制ASCII字符表示
     */
    public static String byteToHexString(byte in) {
        char[] DigitStr = {
                '0', '1', '2', '3', '4', '5', '6', '7',
                '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'
        };

        char[] out = new char[2];
        out[0] = DigitStr[(in >> 4) & 0x0F];    // 取高4位
        out[1] = DigitStr[in & 0x0F];           // 取低4位

        return new String(out);
    }
}
