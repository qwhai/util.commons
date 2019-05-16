package org.commons.cabinet.encrypt;

import org.apache.log4j.Logger;
import org.commons.cabinet.encrypt.interf.Decrypt;
import org.commons.cabinet.encrypt.interf.Encrypt;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

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

    private final Logger logger = Logger.getLogger(AES.class);

    private byte[] key = null;

    // 此处设置的key，可以是从一个字符串中转换而来
    public void setKey(byte[] key) {
        this.key = key;
    }

    @Override
    public byte[] encrypt(byte[] data) {
        return aes(data, Cipher.ENCRYPT_MODE);
    }

    @Override
    public byte[] decrypt(byte[] cipher) {
        return aes(cipher, Cipher.DECRYPT_MODE);
    }

    private byte[] aes(byte[] data, int mode) {
        try {
            KeyGenerator kgen = KeyGenerator.getInstance("AES");
            kgen.init(128, new SecureRandom(key));
            SecretKey secretKey = kgen.generateKey();
            byte[] enCodeFormat = secretKey.getEncoded();
            SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(mode, key);
            return cipher.doFinal(data);
        } catch (NoSuchAlgorithmException
                | NoSuchPaddingException
                | InvalidKeyException
                | IllegalBlockSizeException
                | BadPaddingException ex) {
            logger.error(ex.getMessage());
            return null;
        }
    }
}
