package org.utils.naga.cipher.poke;

import org.utils.naga.cipher.interf.CipherNoKey;
import org.utils.naga.cipher.interf.CipherWithKey;
import org.utils.naga.cipher.interf.Cipherable;
import org.utils.naga.excep.IrreversibleException;
import org.utils.naga.excep.StrategyException;

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
 * @author <a href="http://weibo.com/u/5131020927">Q-WHai</a>
 * @see <a href="http://blog.csdn.net/lemon_tree12138">http://blog.csdn.net/lemon_tree12138</a>
 * @version 0.1.1
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
