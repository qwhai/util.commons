package org.commons.cabinet.cipher.poke;

import org.commons.cabinet.cipher.interf.CipherWithKey;
import org.commons.cabinet.excep.IrreversibleException;
import org.commons.cabinet.excep.StrategyException;

/**
 * 盛放不同有密钥加密策略的容器类
 *
 * Create Date: 2016-04-22
 * Last Modify: 2016-04-22
 * 
 * @author Q-WHai
 * @see <a href="https://github.com/qwhai">https://github.com/qwhai</a>
 */
public class CipherWithKeyUtils {

    private CipherWithKey cipherable = null;
    
    public CipherWithKeyUtils(CipherWithKey _cipherable) {
        this.cipherable = _cipherable;
    }
    
    /**
     * 加密
     * 
     * @param plaintext
     *      待加密明文
     * @param key
     *      密钥
     * @return
     *      密文
     * @throws StrategyException
     *      策略异常
     */
    public byte[] encryption(String plaintext, byte[] key) throws StrategyException {
        return cipherable.encryption(plaintext, key);
    }
    
    /**
     * 解密
     * 
     * @param ciphertext
     *      待解密密文
     * @param key
     *      密钥
     * @return
     *      明文
     * @throws IrreversibleException
     *      不可逆操作异常
     * @throws StrategyException
     *      策略异常
     */
    public String decryption(byte[] ciphertext, byte[] key) throws IrreversibleException, StrategyException {
        return cipherable.decryption(ciphertext, key);
    }
}
