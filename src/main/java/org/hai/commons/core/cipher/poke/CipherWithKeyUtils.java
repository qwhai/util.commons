package org.hai.commons.core.cipher.poke;

import org.hai.commons.core.cipher.interf.CipherWithKey;
import org.hai.commons.core.excep.IrreversibleException;
import org.hai.commons.core.excep.StrategyException;

/**
 * <p>
 * 盛放不同有密钥加密策略的容器类
 * </p>
 * Create Date: 2016年4月22日
 * Last Modify: 2016年4月22日
 * 
 * @author <a href="http://weibo.com/u/5131020927">Q-WHai</a>
 * @see <a href="http://blog.csdn.net/lemon_tree12138">http://blog.csdn.net/lemon_tree12138</a>
 * @version 0.1.1
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
