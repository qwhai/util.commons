package pers.hai.util.commons.encrypt;

import pers.hai.util.commons.encrypt.excep.UnsetKeyException;
import pers.hai.util.commons.encrypt.interf.Decrypt;
import pers.hai.util.commons.encrypt.interf.Encrypt;

/**
 * RC4加密算法
 *
 * Create Time: 2019/05/16 17:25
 * Last Modify: 2019/05/16
 *
 * @author Q-WHai
 * @see <a href="https://github.com/qwhai">https://github.com/qwhai</a>
 */
public class RC4 implements Encrypt, Decrypt {

    private String key = null;

    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public byte[] encrypt(byte[] plain) {
        if (null == key)
            throw new UnsetKeyException("未设置key");

        return rc4(plain, key);
    }

    @Override
    public byte[] decrypt(byte[] cipher) {
        if (null == key)
            throw new UnsetKeyException("未设置key");

        return rc4(cipher, key);
    }

    // ------------------------------------------------- 内部方法分隔线 --------------------------------------------------

    private byte[] initKey(String key) {
        byte[] b_key = key.getBytes();


        byte[] state = new byte[256];

        for (int i = 0; i < 256; i++) {
            state[i] = (byte) i;
        }
        int index1 = 0;
        int index2 = 0;
        if (0 == b_key.length)
            return null;

        for (int i = 0; i < 256; i++) {
            index2 = ((b_key[index1] & 0xff) + (state[i] & 0xff) + index2) & 0xff;
            byte tmp = state[i];
            state[i] = state[index2];
            state[index2] = tmp;
            index1 = (index1 + 1) % b_key.length;
        }

        return state;
    }

    private byte[] rc4(byte[] data, String key) {
        return rc4(data, initKey(key));
    }

    private byte[] rc4(byte[] data, byte[] key) {
        int x = 0;
        int y = 0;

        int xorIndex;
        byte[] result = new byte[data.length];

        for (int i = 0; i < data.length; i++) {
            x = (x + 1) & 0xff;
            y = ((key[x] & 0xff) + y) & 0xff;
            byte tmp = key[x];
            key[x] = key[y];
            key[y] = tmp;
            xorIndex = ((key[x] & 0xff) + (key[y] & 0xff)) & 0xff;
            result[i] = (byte) (data[i] ^ key[xorIndex]);
        }
        return result;
    }
}
