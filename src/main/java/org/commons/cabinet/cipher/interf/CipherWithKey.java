package org.commons.cabinet.cipher.interf;

import org.commons.cabinet.excep.IrreversibleException;
import org.commons.cabinet.excep.StrategyException;

/**
 * 公共的加密工具接口（有密钥的类型）
 *
 * Create Date: 2016-04-22
 * Last Modify: 2016-04-22
 * 
 * @author Q-WHai
 * @see <a href="https://github.com/qwhai">https://github.com/qwhai</a>
 */
public interface CipherWithKey extends Cipherable {

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
    byte[] encryption(String plaintext, byte[] key) throws StrategyException;
    
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
    String decryption(byte[] ciphertext, byte[] key) throws IrreversibleException, StrategyException;
}
