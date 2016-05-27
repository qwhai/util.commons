/**
 * <p>
 * 公共的加密工具接口实现包
 * </p>
 * 
 * @author <a href="http://weibo.com/u/5131020927">Q-WHai</a>
 * @see <a href="http://blog.csdn.net/lemon_tree12138">http://blog.csdn.net/lemon_tree12138</a>
 * @version 0.1
 */
package org.core.utils.cipher.impl;

import org.core.utils.cipher.poke.CipherUtils;
import org.core.utils.excep.IrreversibleException;
import org.core.utils.excep.StrategyException;

// SMS4的测试教程
class CipherClient {

    public static void main(String[] args) {
        byte[] key = { 0x01, 0x23, 0x45, 0x67, (byte) 0x89, (byte) 0xab,
                (byte) 0xcd, (byte) 0xef, (byte) 0xfe, (byte) 0xdc,
                (byte) 0xba, (byte) 0x98, 0x76, 0x54, 0x32, 0x10 };
        
        CipherUtils cipher = new CipherUtils(new SMS4Impl());
        try {
            System.out.println(cipher.decryption(cipher.encryption("中国", key), key));
        } catch (IrreversibleException | StrategyException e) {
            e.printStackTrace();
        }
    }
}