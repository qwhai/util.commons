package org.commons.cabinet.encrypt;

import org.commons.cabinet.encrypt.interf.Encrypt;

/**
 * Base64加密策略
 *
 * Create Date: 2015-12-15
 * Last Modify: 2019-05-16
 * 
 * @author Q-WHai
 * @see <a href="https://github.com/qwhai">https://github.com/qwhai</a>
 */
public final class Base64 implements Encrypt {

    @SuppressWarnings("unused")
    private static final char[] base64EncodeChars = new char[] {
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P',
            'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f',
            'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
            'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'
    };

    @SuppressWarnings("unused")
    private static final byte[] base64DecodeChars = new byte[] {
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63,
            52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1,
            -1,  0,  1,  2,  3,  4,  5,  6,  7,  8,  9, 10, 11, 12, 13, 14,
            15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1,
            -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40,
            41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1
    };

    @Override
    public byte[] encode(byte[] src) {
        return java.util.Base64.getEncoder().encode(src);
    }

    @Override
    public byte[] encode(String src) {
        return encode(src.getBytes());
    }

    @Override
    public byte[] decode(byte[] src) {
        return java.util.Base64.getDecoder().decode(src);
    }

    @Override
    public byte[] decode(String src) {
        return java.util.Base64.getDecoder().decode(src);
    }
}
