package org.commons.cabinet.encrypt;

import org.commons.cabinet.encrypt.excep.UnsetKeyException;
import org.commons.cabinet.encrypt.interf.Decrypt;
import org.commons.cabinet.encrypt.interf.Encrypt;

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

    /**
    public static String decry_RC4(byte[] data, String key) {
        if (data == null || key == null) {
            return null;
        }
        return asString(rc4(data, key));
    }

    public static String decry_RC4(String data, String key) {
        if (data == null || key == null) {
            return null;
        }
        return new String(rc4(HexString2Bytes(data), key));
    }

    public static byte[] encry_RC4_byte(String data, String key) {
        if (data == null || key == null) {
            return null;
        }
        byte b_data[] = data.getBytes();
        return rc4(b_data, key);
    }

    public static String encry_RC4_string(String data, String key) {
        if (data == null || key == null) {
            return null;
        }
        return toHexString(asString(encry_RC4_byte(data, key)));
    }

    private static String asString(byte[] buf) {
        StringBuffer strbuf = new StringBuffer(buf.length);
        for (int i = 0; i < buf.length; i++) {
            strbuf.append((char) buf[i]);
        }
        return strbuf.toString();
    }
    */



    /**

    private static String toHexString(String s) {
        String str = "";
        for (int i = 0; i < s.length(); i++) {
            int ch = (int) s.charAt(i);
            String s4 = Integer.toHexString(ch & 0xFF);
            if (s4.length() == 1) {
                s4 = '0' + s4;
            }
            str = str + s4;
        }
        return str;// 0x表示十六进制
    }

    private static byte[] HexString2Bytes(String src) {
        int size = src.length();
        byte[] ret = new byte[size / 2];
        byte[] tmp = src.getBytes();
        for (int i = 0; i < size / 2; i++) {
            ret[i] = uniteBytes(tmp[i * 2], tmp[i * 2 + 1]);
        }
        return ret;
    }


    private static byte uniteBytes(byte src0, byte src1) {
        char _b0 = (char) Byte.decode("0x" + new String(new byte[] { src0 })).byteValue();
        _b0 = (char) (_b0 << 4);
        char _b1 = (char) Byte.decode("0x" + new String(new byte[] { src1 })).byteValue();
        byte ret = (byte) (_b0 ^ _b1);
        return ret;
    }
     */


}
