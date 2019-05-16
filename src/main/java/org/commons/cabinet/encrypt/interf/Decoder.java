package org.commons.cabinet.encrypt.interf;

/**
 * 解密接口
 *
 * Create Time: 2019/05/16 13:54
 * Last Modify: 2019/05/16
 *
 * @author Q-WHai
 * @see <a href="https://github.com/qwhai">https://github.com/qwhai</a>
 */
public interface Decoder {
    byte[] decode(byte[] src);
    byte[] decode(String src);
}
