package org.commons.cabinet.encrypt;

import org.apache.log4j.Logger;
import org.commons.cabinet.encrypt.interf.Encoder;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * SHA256加密算法
 *
 * Create Time: 2019/05/16 15:57
 * Last Modify: 2019/05/16
 *
 * @author Q-WHai
 * @see <a href="https://github.com/qwhai">https://github.com/qwhai</a>
 */
public class SHA256 implements Encoder {

    private final Logger logger = Logger.getLogger(SHA256.class);

    @Override
    public byte[] encode(byte[] src) {
        MessageDigest digest;
        try {
            digest = MessageDigest.getInstance("SHA-256");
            digest.update(src);
            return digest.digest();
        } catch (NoSuchAlgorithmException ex) {
            logger.error(ex.getMessage());
            return null;
        }
    }

    @Override
    public byte[] encode(String src) {
        return encode(src.getBytes());
    }
}
