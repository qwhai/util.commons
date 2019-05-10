package org.commons.cabinet.cipher.poke;

import org.commons.cabinet.cipher.interf.CipherNoKey;
import org.commons.cabinet.cipher.interf.CipherWithKey;
import org.commons.cabinet.cipher.interf.Cipherable;
import org.commons.cabinet.excep.IrreversibleException;
import org.commons.cabinet.excep.StrategyException;

/**
 * <p>
 * 盛放不同策略的容器类
 * </p>
 * <p>
 * 客户端可以通过该类来进行加密（或解密）操作
 * </p>
 * Create Date: 2015年12月15日
 * Last Modify: 2016年5月26日
 * 
 * @author Q-WHai
 * @see <a href="https://github.com/qwhai">https://github.com/qwhai</a>
 */
public final class CipherUtils {

    private Cipherable cipherable = null;
    
    public CipherUtils(Cipherable _cipherable) {
        cipherable = _cipherable;
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
        if (!(cipherable instanceof CipherNoKey)) {
            throw new StrategyException("Call a wrong cipher interface.");
        }
        CipherNoKeyUtils utils = new CipherNoKeyUtils((CipherNoKey) this.cipherable);
        return utils.encryption(plaintext);
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
        if (!(cipherable instanceof CipherWithKey)) {
            throw new StrategyException("Call a wrong cipher interface.");
        }
        CipherWithKeyUtils utils = new CipherWithKeyUtils((CipherWithKey) this.cipherable);
        return utils.encryption(plaintext, key);
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
        if (!(cipherable instanceof CipherNoKey)) {
            throw new StrategyException("Call a wrong cipher interface.");
        }
        CipherNoKeyUtils utils = new CipherNoKeyUtils((CipherNoKey) this.cipherable);
        return utils.decryption(ciphertext);
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
        if (!(cipherable instanceof CipherWithKey)) {
            throw new StrategyException("Call a wrong cipher interface.");
        }
        CipherWithKeyUtils utils = new CipherWithKeyUtils((CipherWithKey) this.cipherable);
        return utils.decryption(ciphertext, key);
    }
}
