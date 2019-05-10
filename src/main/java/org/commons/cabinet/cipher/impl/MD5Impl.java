package org.commons.cabinet.cipher.impl;

import org.commons.cabinet.excep.IrreversibleException;
import org.commons.cabinet.cipher.interf.CipherNoKey;

/**
 * <p>
 * MD5哈希明文策略
 * </p>
 * Create Date: 2015年12月15日
 * Last Modify: 2016年4月22日
 * 
 * @author Q-WHai
 * @see <a href="https://github.com/qwhai">https://github.com/qwhai</a>
 */
public final class MD5Impl implements CipherNoKey {

    // RFC1321中定义的标准4*4矩阵的常量定义。
    static final int S11 = 7, S12 = 12, S13 = 17, S14 = 22;
    static final int S21 = 5, S22 = 9, S23 = 14, S24 = 20;
    static final int S31 = 4, S32 = 11, S33 = 16, S34 = 23;
    static final int S41 = 6, S42 = 10, S43 = 15, S44 = 21;

    // 按RFC1321标准定义不可变byte型数组PADDING
    static final byte[] PADDING = { -128, 0, 0, 0, 0, 0, 0, 0,

            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,

            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,

            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };

    // MD5计算过程中的3组核心数据，采用数组形式存放
    private long[] state = new long[4]; // 计算状态(分别对应a b c d)

    private byte[] buffer = new byte[64]; // 分配64个字节私有缓冲区

    private long[] count = new long[2]; // 位个数

    // 最新一次计算结果的16进制ASCII字符串表示，代表了16个字符串形式的MD5值
    public String resultStr;

    // 最新一次计算结果的2进制数组表示，一共16个字节，代表了128bit形式的MD5值
    public byte[] digest = new byte[16];

    @Override
    public byte[] encryption(String plaintext) {
        md5Init(); // 初始化
        md5Update(plaintext.getBytes(), plaintext.length());// 调用MD5的主计算过程
        md5Final(); // 输出结果到digest数组中
        for (int i = 0; i < 16; i++) {
            resultStr += byteToHEX(digest[i]); // 将digest数组中的每个byte型数据转为16进制形式的字符串
        }
        
        return resultStr.getBytes();
    }

    @Override
    public String decryption(byte[] ciphertext) throws IrreversibleException {
        throw new IrreversibleException("MD5采用哈希算法加密，不可逆转。");
    }
    
    // md5初始化函数.初始化核心变量.
    private void md5Init() {
        state[0] = 0x67452301L; // 定义state为RFC1321中定义的标准幻数
        state[1] = 0xefcdab89L; // 定义state为RFC1321中定义的标准幻数
        state[2] = 0x98badcfeL; // 定义state为RFC1321中定义的标准幻数
        state[3] = 0x10325476L; // 定义state为RFC1321中定义的标准幻数
        count[0] = count[1] = 0L; // 初始化为0
        resultStr = "";// 初始化resultStr字符串为空
        for (int i = 0; i < 16; i++) {
            digest[i] = 0;// 初始化digest数组元素为0
        }
        return;
    }

    // 定义F G H I 为4个基数 ，即为4个基本的MD5函数,进行简单的位运算
    private long F(long x, long y, long z) {
        return (x & y) | ((~x) & z);
    }

    private long G(long x, long y, long z) {
        return (x & z) | (y & (~z));
    }

    private long H(long x, long y, long z) {
        return x ^ y ^ z;
    }

    private long I(long x, long y, long z) {
        return y ^ (x | (~z));
    }

    // FF,GG,HH和II调用F,G,H,I函数进行进一步变换
    private long FF(long a, long b, long c, long d, long x, long s, long ac) {
        a += F(b, c, d) + x + ac;
        a = ((int) a << s) | ((int) a >>> (32 - s)); // 这里long型数据右移时使用无符号右移运算符>>>
        a += b;
        return a;
    }

    private long GG(long a, long b, long c, long d, long x, long s, long ac) {
        a += G(b, c, d) + x + ac;
        a = ((int) a << s) | ((int) a >>> (32 - s)); // 这里long型数据右移时使用无符号右移运算符>>>
        a += b;
        return a;
    }

    private long HH(long a, long b, long c, long d, long x, long s, long ac) {
        a += H(b, c, d) + x + ac;
        a = ((int) a << s) | ((int) a >>> (32 - s));// 这里long型数据右移时使用无符号右移运算符>>>
        a += b;
        return a;
    }

    private long II(long a, long b, long c, long d, long x, long s, long ac) {
        a += I(b, c, d) + x + ac;
        a = ((int) a << s) | ((int) a >>> (32 - s));// 这里long型数据右移时使用无符号右移运算符>>>
        a += b;
        return a;
    }

    // MD5的主计算过程，input是需要变换的二进制字节串，inputlen是长度
    private void md5Update(byte[] input, int inputLen) {
        int i = 0, index, partLen;
        byte[] block = new byte[64]; // 分配64个字节缓冲区
        // 根据count计算index值。这里long型数据右移时使用无符号右移运算符>>>
        index = (int) (count[0] >>> 3) & 0x3F;
        if ((count[0] += (inputLen << 3)) < (inputLen << 3)) {
            count[1]++;
        }
        count[1] += (inputLen >>> 29); // 这里int型数据右移时使用无符号右移运算符>>>
        partLen = 64 - index; // 计算partLen值
        if (inputLen >= partLen) {
            md5Memcpy(buffer, input, index, 0, partLen);
            md5Transform(buffer);
            for (i = partLen; i + 63 < inputLen; i += 64) {
                md5Memcpy(block, input, 0, i, 64);
                md5Transform(block);
            }
            index = 0;
        } else {
            i = 0;
        }
        md5Memcpy(buffer, input, index, i, inputLen - i);
    }

    // 整理和填写输出结果，结果放到数组digest中。
    private void md5Final() {
        byte[] bits = new byte[8];
        int index, padLen;
        Encode(bits, count, 8);
        index = (int) (count[0] >>> 3) & 0x3f; // 这里long型数据右移时使用无符号右移运算符>>>
        padLen = (index < 56) ? (56 - index) : (120 - index);
        md5Update(PADDING, padLen);
        md5Update(bits, 8);
        Encode(digest, state, 16);
    }

    // byte数组的块拷贝函数，将input数组中的起始位置为inpos，长度len的数据拷贝到output数组起始位置outpos处。
    private void md5Memcpy(byte[] output, byte[] input, int outpos, int inpos,
            int len) {
        int i;
        for (i = 0; i < len; i++) {
            output[outpos + i] = input[inpos + i];
        }
    }

    // MD5核心变换计算程序，由md5Update函数调用，block是分块的原始字节数组
    private void md5Transform(byte block[]) {
        long a = state[0], b = state[1], c = state[2], d = state[3];
        long[] x = new long[16];
        Decode(x, block, 64);
        // 进行4级级联运算
        // 第1级
        a = FF(a, b, c, d, x[0], S11, 0xd76aa478L); /* 1 */
        d = FF(d, a, b, c, x[1], S12, 0xe8c7b756L); /* 2 */
        c = FF(c, d, a, b, x[2], S13, 0x242070dbL); /* 3 */
        b = FF(b, c, d, a, x[3], S14, 0xc1bdceeeL); /* 4 */
        a = FF(a, b, c, d, x[4], S11, 0xf57c0fafL); /* 5 */
        d = FF(d, a, b, c, x[5], S12, 0x4787c62aL); /* 6 */
        c = FF(c, d, a, b, x[6], S13, 0xa8304613L); /* 7 */
        b = FF(b, c, d, a, x[7], S14, 0xfd469501L); /* 8 */
        a = FF(a, b, c, d, x[8], S11, 0x698098d8L); /* 9 */
        d = FF(d, a, b, c, x[9], S12, 0x8b44f7afL); /* 10 */
        c = FF(c, d, a, b, x[10], S13, 0xffff5bb1L); /* 11 */
        b = FF(b, c, d, a, x[11], S14, 0x895cd7beL); /* 12 */
        a = FF(a, b, c, d, x[12], S11, 0x6b901122L); /* 13 */
        d = FF(d, a, b, c, x[13], S12, 0xfd987193L); /* 14 */
        c = FF(c, d, a, b, x[14], S13, 0xa679438eL); /* 15 */
        b = FF(b, c, d, a, x[15], S14, 0x49b40821L); /* 16 */

        // 第2级
        a = GG(a, b, c, d, x[1], S21, 0xf61e2562L); /* 17 */
        d = GG(d, a, b, c, x[6], S22, 0xc040b340L); /* 18 */
        c = GG(c, d, a, b, x[11], S23, 0x265e5a51L); /* 19 */
        b = GG(b, c, d, a, x[0], S24, 0xe9b6c7aaL); /* 20 */
        a = GG(a, b, c, d, x[5], S21, 0xd62f105dL); /* 21 */
        d = GG(d, a, b, c, x[10], S22, 0x2441453L); /* 22 */
        c = GG(c, d, a, b, x[15], S23, 0xd8a1e681L); /* 23 */
        b = GG(b, c, d, a, x[4], S24, 0xe7d3fbc8L); /* 24 */
        a = GG(a, b, c, d, x[9], S21, 0x21e1cde6L); /* 25 */
        d = GG(d, a, b, c, x[14], S22, 0xc33707d6L); /* 26 */
        c = GG(c, d, a, b, x[3], S23, 0xf4d50d87L); /* 27 */
        b = GG(b, c, d, a, x[8], S24, 0x455a14edL); /* 28 */
        a = GG(a, b, c, d, x[13], S21, 0xa9e3e905L); /* 29 */
        d = GG(d, a, b, c, x[2], S22, 0xfcefa3f8L); /* 30 */
        c = GG(c, d, a, b, x[7], S23, 0x676f02d9L); /* 31 */
        b = GG(b, c, d, a, x[12], S24, 0x8d2a4c8aL); /* 32 */

        // 第3级
        a = HH(a, b, c, d, x[5], S31, 0xfffa3942L); /* 33 */
        d = HH(d, a, b, c, x[8], S32, 0x8771f681L); /* 34 */
        c = HH(c, d, a, b, x[11], S33, 0x6d9d6122L); /* 35 */
        b = HH(b, c, d, a, x[14], S34, 0xfde5380cL); /* 36 */
        a = HH(a, b, c, d, x[1], S31, 0xa4beea44L); /* 37 */
        d = HH(d, a, b, c, x[4], S32, 0x4bdecfa9L); /* 38 */
        c = HH(c, d, a, b, x[7], S33, 0xf6bb4b60L); /* 39 */
        b = HH(b, c, d, a, x[10], S34, 0xbebfbc70L); /* 40 */
        a = HH(a, b, c, d, x[13], S31, 0x289b7ec6L); /* 41 */
        d = HH(d, a, b, c, x[0], S32, 0xeaa127faL); /* 42 */
        c = HH(c, d, a, b, x[3], S33, 0xd4ef3085L); /* 43 */
        b = HH(b, c, d, a, x[6], S34, 0x4881d05L); /* 44 */
        a = HH(a, b, c, d, x[9], S31, 0xd9d4d039L); /* 45 */
        d = HH(d, a, b, c, x[12], S32, 0xe6db99e5L); /* 46 */
        c = HH(c, d, a, b, x[15], S33, 0x1fa27cf8L); /* 47 */
        b = HH(b, c, d, a, x[2], S34, 0xc4ac5665L); /* 48 */

        // 第4级
        a = II(a, b, c, d, x[0], S41, 0xf4292244L); /* 49 */
        d = II(d, a, b, c, x[7], S42, 0x432aff97L); /* 50 */
        c = II(c, d, a, b, x[14], S43, 0xab9423a7L); /* 51 */
        b = II(b, c, d, a, x[5], S44, 0xfc93a039L); /* 52 */
        a = II(a, b, c, d, x[12], S41, 0x655b59c3L); /* 53 */
        d = II(d, a, b, c, x[3], S42, 0x8f0ccc92L); /* 54 */
        c = II(c, d, a, b, x[10], S43, 0xffeff47dL); /* 55 */
        b = II(b, c, d, a, x[1], S44, 0x85845dd1L); /* 56 */
        a = II(a, b, c, d, x[8], S41, 0x6fa87e4fL); /* 57 */
        d = II(d, a, b, c, x[15], S42, 0xfe2ce6e0L); /* 58 */
        c = II(c, d, a, b, x[6], S43, 0xa3014314L); /* 59 */
        b = II(b, c, d, a, x[13], S44, 0x4e0811a1L); /* 60 */
        a = II(a, b, c, d, x[4], S41, 0xf7537e82L); /* 61 */
        d = II(d, a, b, c, x[11], S42, 0xbd3af235L); /* 62 */
        c = II(c, d, a, b, x[2], S43, 0x2ad7d2bbL); /* 63 */
        b = II(b, c, d, a, x[9], S44, 0xeb86d391L); /* 64 */

        // 分别累加到state[0],state[1],state[2],state[3]
        state[0] += a;
        state[1] += b;
        state[2] += c;
        state[3] += d;
    }

    // 把byte型数据转换为无符号long型数据
    private static long byteToul(byte b) {
        return b > 0 ? b : (b & 0x7F + 128);
    }

    // 把byte类型的数据转换成十六进制ASCII字符表示
    private static String byteToHEX(byte in) {
        char[] DigitStr = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'A', 'B', 'C', 'D', 'E', 'F' };
        char[] out = new char[2];
        out[0] = DigitStr[(in >> 4) & 0x0F]; // 取高4位
        out[1] = DigitStr[in & 0x0F]; // 取低4位
        String s = new String(out);
        return s;
    }

    // 将long型数组按顺序拆成byte型数组,长度为len
    private void Encode(byte[] output, long[] input, int len) {
        int i, j;
        for (i = 0, j = 0; j < len; i++, j += 4) {
            output[j] = (byte) (input[i] & 0xffL);
            output[j + 1] = (byte) ((input[i] >>> 8) & 0xffL);
            output[j + 2] = (byte) ((input[i] >>> 16) & 0xffL);
            output[j + 3] = (byte) ((input[i] >>> 24) & 0xffL);
        }
    }

    // 将byte型数组按顺序合成long型数组，长度为len
    private void Decode(long[] output, byte[] input, int len) {
        int i, j;
        for (i = 0, j = 0; j < len; i++, j += 4) {
            output[i] = byteToul(input[j]) | (byteToul(input[j + 1]) << 8)
                    | (byteToul(input[j + 2]) << 16)
                    | (byteToul(input[j + 3]) << 24);
        }
        return;
    }
}
