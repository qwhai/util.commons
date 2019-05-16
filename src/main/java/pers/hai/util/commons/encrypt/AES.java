package pers.hai.util.commons.encrypt;

import org.apache.log4j.Logger;
import pers.hai.util.commons.encrypt.excep.UnsetKeyException;
import pers.hai.util.commons.encrypt.interf.Decrypt;
import pers.hai.util.commons.encrypt.interf.Encrypt;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * AES加密算法
 * 1. 最常用的对称加密算法
 * 2. 密钥建立时间短、灵敏性好、内存需求低
 * 3. 实际使用中，使用工作模式为CTR（最好用BC去实现），此工作模式需要引入IV参数（16位的字节数组）
 * 4. 密钥长度128/192/256，其中192与256需要配置无政策限制权限文件（JDK6）
 * 5. 填充模式最常用的两种PKCS5Padding和PKCS7Padding，其中后者只有BC独有
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
        if (null == key)
            throw new UnsetKeyException("未设置key");

        return aes(data, Cipher.ENCRYPT_MODE);
    }

    @Override
    public byte[] decrypt(byte[] cipher) {
        if (null == key)
            throw new UnsetKeyException("未设置key");

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
