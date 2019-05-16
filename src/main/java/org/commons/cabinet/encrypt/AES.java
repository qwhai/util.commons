package org.commons.cabinet.encrypt;

import org.commons.cabinet.encrypt.interf.Decrypt;
import org.commons.cabinet.encrypt.interf.Encrypt;

/**
 * AES加密算法
 *
 * Create Time: 2019/05/16 16:09
 * Last Modify: 2019/05/16
 *
 * @author Q-WHai
 * @see <a href="https://github.com/qwhai">https://github.com/qwhai</a>
 */
public class AES implements Encrypt, Decrypt {

    @Override
    public byte[] encrypt(byte[] data) {
        return new byte[0];
    }

    @Override
    public byte[] decrypt(byte[] cipher) {
        return new byte[0];
    }
}
