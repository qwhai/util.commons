package org.commons.cabinet.encrypt.interf;

/**
 * 加密接口
 *
 * Create Time: 2019/05/16 13:51
 * Last Modify: 2019/05/16
 *
 * @author Q-WHai
 * @see <a href="https://github.com/qwhai">https://github.com/qwhai</a>
 */
public interface Encoder {
    byte[] encode(byte[] src);
    byte[] encode(String src);
}
