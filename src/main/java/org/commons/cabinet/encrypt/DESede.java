package org.commons.cabinet.encrypt;

import org.commons.cabinet.encrypt.interf.Decrypt;
import org.commons.cabinet.encrypt.interf.Encrypt;

/**
 * DESede（三重DES加密算法）
 * 1. 早于AES出现来替代DES
 * 2. 计算密钥时间太长、加密效率不高，所以也基本上不用
 * 3. 密钥长度112/168（JDK）、128/192（BC）
 *
 * Create Time: 2019/05/16 18:20
 * Last Modify: 2019/05/16
 *
 * @author Q-WHai
 * @see <a href="https://github.com/qwhai">https://github.com/qwhai</a>
 */
@Deprecated
public class DESede implements Encrypt, Decrypt {

    @Override
    public byte[] encrypt(byte[] plain) {
        // TODO
        return new byte[0];
    }

    @Override
    public byte[] decrypt(byte[] cipher) {
        // TODO
        return new byte[0];
    }
}
