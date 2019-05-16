package org.commons.cabinet.encrypt.interf;

/**
 * 解密接口
 *
 * Create Time: 2019/05/16 16:15
 * Last Modify: 2019/05/16
 *
 * @author Q-WHai
 * @see <a href="https://github.com/qwhai">https://github.com/qwhai</a>
 */
public interface Decrypt {
    byte[] decrypt(byte[] cipher);
}
