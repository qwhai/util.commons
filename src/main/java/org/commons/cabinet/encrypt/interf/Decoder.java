package org.commons.cabinet.encrypt.interf;

/**
 * 解码接口
 *
 * Create Time: 2019/05/16 13:54
 * Last Modify: 2019/05/16
 *
 * @author Q-WHai
 * @see <a href="https://github.com/qwhai">https://github.com/qwhai</a>
 */
public interface Decoder {
    String decode(byte[] src);
    String decode(String src);
}
