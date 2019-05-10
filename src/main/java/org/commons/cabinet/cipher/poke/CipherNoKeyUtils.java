package org.commons.cabinet.cipher.poke;

import org.commons.cabinet.cipher.interf.CipherNoKey;
import org.commons.cabinet.excep.IrreversibleException;
import org.commons.cabinet.excep.StrategyException;

/**
 * <p>
 * 盛放不同没有密钥加密策略的容器类
 * </p>
 * Create Date: 2016年4月22日
 * Last Modify: 2016年4月22日
 * 
 * @author Q-WHai
 * @see <a href="https://github.com/qwhai">https://github.com/qwhai</a>
 */
public class CipherNoKeyUtils {

    private CipherNoKey cipherable = null;
    
    public CipherNoKeyUtils(CipherNoKey _cipherable) {
        this.cipherable = _cipherable;
    }
    
    /**
     * 加密
     * 
     * @param plaintext
     *      待加密明文
     * @return
     *      密文
     * @throws StrategyException
     *      策略异常
     */
    public byte[] encryption(String plaintext) throws StrategyException {
        return cipherable.encryption(plaintext);
    }
    
    /**
     * 解密
     * 
     * @param ciphertext
     *      待解密密文
     * @return
     *      明文
     * @throws IrreversibleException
     *      不可逆操作异常
     * @throws StrategyException 
     *      策略异常
     */
    public String decryption(byte[] ciphertext) throws IrreversibleException, StrategyException {
        return cipherable.decryption(ciphertext);
    }
}
