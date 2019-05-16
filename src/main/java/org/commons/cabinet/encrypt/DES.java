package org.commons.cabinet.encrypt;

import org.apache.log4j.Logger;
import org.commons.cabinet.encrypt.excep.UnsetKeyException;
import org.commons.cabinet.encrypt.interf.Decrypt;
import org.commons.cabinet.encrypt.interf.Encrypt;

import javax.crypto.*;
import javax.crypto.spec.DESKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;

/**
 * 对称DES加密算法
 * 1. 已破解，不再安全，基本没有企业在用了
 * 2. 是对称加密算法的基石，具有学习价值
 * 3. 密钥长度56（JDK）、56/64（BC）
 * 注意：DES加密和解密过程中，密钥长度都必须是8的倍数
 *
 * DES加密介绍
 * DES是一种对称加密算法，所谓对称加密算法即：加密和解密使用相同密钥的算法。
 * DES加密算法出自IBM的研究，后来被美国政府正式采用，之后开始广泛流传，但是近些年使用越来越少，因为DES使用56位密钥，以现代计算能力，24小时内即可被破解。
 * 虽然如此，在某些简单应用中，我们还是可以使用DES加密算法。
 *
 * Create Time: 2019/05/16 17:13
 * Last Modify: 2019/05/16
 *
 * @author Q-WHai
 * @see <a href="https://github.com/qwhai">https://github.com/qwhai</a>
 */
@Deprecated
public class DES implements Encrypt, Decrypt {

    private final Logger logger = Logger.getLogger(DES.class);

    private byte[] key = null;

    // 此处设置的key，可以是从一个字符串中转换而来
    public void setKey(byte[] key) {
        this.key = key;
    }

    @Override
    public byte[] encrypt(byte[] plain) {
        if (null == key)
            throw new UnsetKeyException("未设置key");

        return des(plain, Cipher.ENCRYPT_MODE);
    }

    @Override
    public byte[] decrypt(byte[] cipher) {
        if (null == key)
            throw new UnsetKeyException("未设置key");

        return des(cipher, Cipher.DECRYPT_MODE);
    }

    private byte[] des(byte[] data, int mode) {
        try {
            SecureRandom random = new SecureRandom();
            DESKeySpec desKey = new DESKeySpec(key);
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey securekey = keyFactory.generateSecret(desKey);
            // Cipher对象实际完成加密操作
            Cipher cipher = Cipher.getInstance("DES");
            // 用密匙初始化Cipher对象
            cipher.init(mode, securekey, random);
            // 正式执行加密操作
            return cipher.doFinal(data);
        } catch (InvalidKeyException
                | NoSuchAlgorithmException
                | InvalidKeySpecException
                | NoSuchPaddingException
                | IllegalBlockSizeException
                | BadPaddingException ex) {
            logger.error(ex.getMessage());
            return null;
        }
    }
}
