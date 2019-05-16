package pers.hai.util.commons.encrypt;

import java.util.Arrays;

import pers.hai.util.commons.encrypt.interf.Decrypt;
import pers.hai.util.commons.encrypt.interf.Encrypt;

/**
 * SMS4加密策略实现
 *
 * Create Date: 2015-12-15
 * Last Modify: 2019-05-16
 * 
 * @author Q-WHai
 * @see <a href="https://github.com/qwhai">https://github.com/qwhai</a>
 */
public final class SMS4 implements Encrypt, Decrypt {

    private static final int ENCRYPT = 1;
    private static final int DECRYPT = 0;
    private static final int ROUND = 32;
    private static final int BLOCK = 16;

    private byte[] Sbox = {
            (byte) 0xd6, (byte) 0x90, (byte) 0xe9, (byte) 0xfe, (byte) 0xcc, (byte) 0xe1, (byte) 0x3d, (byte) 0xb7,
            (byte) 0x16, (byte) 0xb6, (byte) 0x14, (byte) 0xc2, (byte) 0x28, (byte) 0xfb, (byte) 0x2c, (byte) 0x05,
            (byte) 0x2b, (byte) 0x67, (byte) 0x9a, (byte) 0x76, (byte) 0x2a, (byte) 0xbe, (byte) 0x04, (byte) 0xc3,
            (byte) 0xaa, (byte) 0x44, (byte) 0x13, (byte) 0x26, (byte) 0x49, (byte) 0x86, (byte) 0x06, (byte) 0x99,
            (byte) 0x9c, (byte) 0x42, (byte) 0x50, (byte) 0xf4, (byte) 0x91, (byte) 0xef, (byte) 0x98, (byte) 0x7a,
            (byte) 0x33, (byte) 0x54, (byte) 0x0b, (byte) 0x43, (byte) 0xed, (byte) 0xcf, (byte) 0xac, (byte) 0x62,
            (byte) 0xe4, (byte) 0xb3, (byte) 0x1c, (byte) 0xa9, (byte) 0xc9, (byte) 0x08, (byte) 0xe8, (byte) 0x95,
            (byte) 0x80, (byte) 0xdf, (byte) 0x94, (byte) 0xfa, (byte) 0x75, (byte) 0x8f, (byte) 0x3f, (byte) 0xa6,
            (byte) 0x47, (byte) 0x07, (byte) 0xa7, (byte) 0xfc, (byte) 0xf3, (byte) 0x73, (byte) 0x17, (byte) 0xba,
            (byte) 0x83, (byte) 0x59, (byte) 0x3c, (byte) 0x19, (byte) 0xe6, (byte) 0x85, (byte) 0x4f, (byte) 0xa8,
            (byte) 0x68, (byte) 0x6b, (byte) 0x81, (byte) 0xb2, (byte) 0x71, (byte) 0x64, (byte) 0xda, (byte) 0x8b,
            (byte) 0xf8, (byte) 0xeb, (byte) 0x0f, (byte) 0x4b, (byte) 0x70, (byte) 0x56, (byte) 0x9d, (byte) 0x35,
            (byte) 0x1e, (byte) 0x24, (byte) 0x0e, (byte) 0x5e, (byte) 0x63, (byte) 0x58, (byte) 0xd1, (byte) 0xa2,
            (byte) 0x25, (byte) 0x22, (byte) 0x7c, (byte) 0x3b, (byte) 0x01, (byte) 0x21, (byte) 0x78, (byte) 0x87,
            (byte) 0xd4, (byte) 0x00, (byte) 0x46, (byte) 0x57, (byte) 0x9f, (byte) 0xd3, (byte) 0x27, (byte) 0x52,
            (byte) 0x4c, (byte) 0x36, (byte) 0x02, (byte) 0xe7, (byte) 0xa0, (byte) 0xc4, (byte) 0xc8, (byte) 0x9e,
            (byte) 0xea, (byte) 0xbf, (byte) 0x8a, (byte) 0xd2, (byte) 0x40, (byte) 0xc7, (byte) 0x38, (byte) 0xb5,
            (byte) 0xa3, (byte) 0xf7, (byte) 0xf2, (byte) 0xce, (byte) 0xf9, (byte) 0x61, (byte) 0x15, (byte) 0xa1,
            (byte) 0xe0, (byte) 0xae, (byte) 0x5d, (byte) 0xa4, (byte) 0x9b, (byte) 0x34, (byte) 0x1a, (byte) 0x55,
            (byte) 0xad, (byte) 0x93, (byte) 0x32, (byte) 0x30, (byte) 0xf5, (byte) 0x8c, (byte) 0xb1, (byte) 0xe3,
            (byte) 0x1d, (byte) 0xf6, (byte) 0xe2, (byte) 0x2e, (byte) 0x82, (byte) 0x66, (byte) 0xca, (byte) 0x60,
            (byte) 0xc0, (byte) 0x29, (byte) 0x23, (byte) 0xab, (byte) 0x0d, (byte) 0x53, (byte) 0x4e, (byte) 0x6f,
            (byte) 0xd5, (byte) 0xdb, (byte) 0x37, (byte) 0x45, (byte) 0xde, (byte) 0xfd, (byte) 0x8e, (byte) 0x2f,
            (byte) 0x03, (byte) 0xff, (byte) 0x6a, (byte) 0x72, (byte) 0x6d, (byte) 0x6c, (byte) 0x5b, (byte) 0x51,
            (byte) 0x8d, (byte) 0x1b, (byte) 0xaf, (byte) 0x92, (byte) 0xbb, (byte) 0xdd, (byte) 0xbc, (byte) 0x7f,
            (byte) 0x11, (byte) 0xd9, (byte) 0x5c, (byte) 0x41, (byte) 0x1f, (byte) 0x10, (byte) 0x5a, (byte) 0xd8,
            (byte) 0x0a, (byte) 0xc1, (byte) 0x31, (byte) 0x88, (byte) 0xa5, (byte) 0xcd, (byte) 0x7b, (byte) 0xbd,
            (byte) 0x2d, (byte) 0x74, (byte) 0xd0, (byte) 0x12, (byte) 0xb8, (byte) 0xe5, (byte) 0xb4, (byte) 0xb0,
            (byte) 0x89, (byte) 0x69, (byte) 0x97, (byte) 0x4a, (byte) 0x0c, (byte) 0x96, (byte) 0x77, (byte) 0x7e,
            (byte) 0x65, (byte) 0xb9, (byte) 0xf1, (byte) 0x09, (byte) 0xc5, (byte) 0x6e, (byte) 0xc6, (byte) 0x84,
            (byte) 0x18, (byte) 0xf0, (byte) 0x7d, (byte) 0xec, (byte) 0x3a, (byte) 0xdc, (byte) 0x4d, (byte) 0x20,
            (byte) 0x79, (byte) 0xee, (byte) 0x5f, (byte) 0x3e, (byte) 0xd7, (byte) 0xcb, (byte) 0x39, (byte) 0x48
    };

    private int[] CK = {
            0x00070e15, 0x1c232a31, 0x383f464d, 0x545b6269, 0x70777e85, 0x8c939aa1, 0xa8afb6bd, 0xc4cbd2d9,
            0xe0e7eef5, 0xfc030a11, 0x181f262d, 0x343b4249, 0x50575e65, 0x6c737a81, 0x888f969d, 0xa4abb2b9,
            0xc0c7ced5, 0xdce3eaf1, 0xf8ff060d, 0x141b2229, 0x30373e45, 0x4c535a61, 0x686f767d, 0x848b9299,
            0xa0a7aeb5, 0xbcc3cad1, 0xd8dfe6ed, 0xf4fb0209, 0x10171e25, 0x2c333a41, 0x484f565d, 0x646b7279
    };

    private byte[] key = null;

    public void setKey(byte[] key) {
        this.key = key;
    }

    @Override
    public byte[] decrypt(byte[] cipher) {
        return null == key ? null : decodeSMS4(cipher, key);
    }

    @Override
    public byte[] encrypt(byte[] plain) {
        return null == key ? null : encodeSMS4(supplement(plain), key);
    }

    // ------------------------------------------------- 内部方法分隔线 --------------------------------------------------

    /**
     * 不限明文长度的SMS4加密
     * 
     * @param   plaintext
     *          明文字节数组
     *
     * @param   key
     *          密钥字节数组
     *
     * @return  密文
     */
    private byte[] encodeSMS4(byte[] plaintext, byte[] key) {
        byte[] ciphertext = new byte[plaintext.length];
        
        int k = 0;
        int plainLen = plaintext.length;
        while (k + 16 <= plainLen) {
            byte[] cellPlain = new byte[16];
            for (int i = 0; i < 16; i++) {
                cellPlain[i] = plaintext[k + i];
            }
            byte[] cellCipher = encode16(cellPlain, key);
            for (int i = 0; i < cellCipher.length; i++) {
                ciphertext[k + i] = cellCipher[i];
            }
            
            k += 16;
        }

        return ciphertext;
    }

    /*
     * 不限明文长度的SMS4解密
     * 
     * @param ciphertext
     *      密文字节数组
     * @param key
     *      密钥字节数组
     * @return
     *      明文
     */
    private byte[] decodeSMS4(byte[] ciphertext, byte[] key) {
        byte[] plaintext = new byte[ciphertext.length];
        
        int k = 0;
        int cipherLen = ciphertext.length;
        while (k + 16 <= cipherLen) {
            byte[] cellCipher = new byte[16];
            for (int i = 0; i < 16; i++) {
                cellCipher[i] = ciphertext[k + i];
            }
            byte[] cellPlain = decode16(cellCipher, key);
            for (int i = 0; i < cellPlain.length; i++) {
                plaintext[k + i] = cellPlain[i];
            }
            
            k += 16;
        }
        
        return plaintext;
    }

    private int Rotl(int x, int y) {
        return x << y | x >>> (32 - y);
    }

    private int ByteSub(int A) {
        return (Sbox[A >>> 24 & 0xFF] & 0xFF) << 24
                | (Sbox[A >>> 16 & 0xFF] & 0xFF) << 16
                | (Sbox[A >>> 8 & 0xFF] & 0xFF) << 8 | (Sbox[A & 0xFF] & 0xFF);
    }

    private int L1(int B) {
        return B ^ Rotl(B, 2) ^ Rotl(B, 10) ^ Rotl(B, 18) ^ Rotl(B, 24);
        // return B^(B<<2|B>>>30)^(B<<10|B>>>22)^(B<<18|B>>>14)^(B<<24|B>>>8);
    }

    private int L2(int B) {
        return B ^ Rotl(B, 13) ^ Rotl(B, 23);
        // return B^(B<<13|B>>>19)^(B<<23|B>>>9);
    }

    private void SMS4Crypt(byte[] Input, byte[] Output, int[] rk) {
        int r, mid;
        int[] x = new int[4];
        int[] tmp = new int[4];
        for (int i = 0; i < 4; i++) {
            tmp[0] = Input[0 + 4 * i] & 0xff;
            tmp[1] = Input[1 + 4 * i] & 0xff;
            tmp[2] = Input[2 + 4 * i] & 0xff;
            tmp[3] = Input[3 + 4 * i] & 0xff;
            x[i] = tmp[0] << 24 | tmp[1] << 16 | tmp[2] << 8 | tmp[3];
            // x[i]=(Input[0+4*i]<<24|Input[1+4*i]<<16|Input[2+4*i]<<8|Input[3+4*i]);
        }
        for (r = 0; r < 32; r += 4) {
            mid = x[1] ^ x[2] ^ x[3] ^ rk[r + 0];
            mid = ByteSub(mid);
            x[0] = x[0] ^ L1(mid); // x4

            mid = x[2] ^ x[3] ^ x[0] ^ rk[r + 1];
            mid = ByteSub(mid);
            x[1] = x[1] ^ L1(mid); // x5

            mid = x[3] ^ x[0] ^ x[1] ^ rk[r + 2];
            mid = ByteSub(mid);
            x[2] = x[2] ^ L1(mid); // x6

            mid = x[0] ^ x[1] ^ x[2] ^ rk[r + 3];
            mid = ByteSub(mid);
            x[3] = x[3] ^ L1(mid); // x7
        }

        // Reverse
        for (int j = 0; j < 16; j += 4) {
            Output[j] = (byte) (x[3 - j / 4] >>> 24 & 0xFF);
            Output[j + 1] = (byte) (x[3 - j / 4] >>> 16 & 0xFF);
            Output[j + 2] = (byte) (x[3 - j / 4] >>> 8 & 0xFF);
            Output[j + 3] = (byte) (x[3 - j / 4] & 0xFF);
        }
    }

    private void SMS4KeyExt(byte[] Key, int[] rk, int CryptFlag) {
        int r, mid;
        int[] x = new int[4];
        int[] tmp = new int[4];
        for (int i = 0; i < 4; i++) {
            tmp[0] = Key[0 + 4 * i] & 0xFF;
            tmp[1] = Key[1 + 4 * i] & 0xff;
            tmp[2] = Key[2 + 4 * i] & 0xff;
            tmp[3] = Key[3 + 4 * i] & 0xff;
            x[i] = tmp[0] << 24 | tmp[1] << 16 | tmp[2] << 8 | tmp[3];
            // x[i]=Key[0+4*i]<<24|Key[1+4*i]<<16|Key[2+4*i]<<8|Key[3+4*i];
        }
        x[0] ^= 0xa3b1bac6;
        x[1] ^= 0x56aa3350;
        x[2] ^= 0x677d9197;
        x[3] ^= 0xb27022dc;
        for (r = 0; r < 32; r += 4) {
            mid = x[1] ^ x[2] ^ x[3] ^ CK[r + 0];
            mid = ByteSub(mid);
            rk[r + 0] = x[0] ^= L2(mid); // rk0=K4

            mid = x[2] ^ x[3] ^ x[0] ^ CK[r + 1];
            mid = ByteSub(mid);
            rk[r + 1] = x[1] ^= L2(mid); // rk1=K5

            mid = x[3] ^ x[0] ^ x[1] ^ CK[r + 2];
            mid = ByteSub(mid);
            rk[r + 2] = x[2] ^= L2(mid); // rk2=K6

            mid = x[0] ^ x[1] ^ x[2] ^ CK[r + 3];
            mid = ByteSub(mid);
            rk[r + 3] = x[3] ^= L2(mid); // rk3=K7
        }

        // 解密时轮密钥使用顺序：rk31,rk30,...,rk0
        if (CryptFlag == DECRYPT) {
            for (r = 0; r < 16; r++) {
                mid = rk[r];
                rk[r] = rk[31 - r];
                rk[31 - r] = mid;
            }
        }
    }

    private int sms4(byte[] in, int inLen, byte[] key, byte[] out, int CryptFlag) {
        int point = 0;
        int[] round_key = new int[ROUND];
        // int[] round_key={0};
        SMS4KeyExt(key, round_key, CryptFlag);
        byte[] input = new byte[16];
        byte[] output = new byte[16];

        while (inLen >= BLOCK) {
            input = Arrays.copyOfRange(in, point, point + 16);
            // output=Arrays.copyOfRange(out, point, point+16);
            SMS4Crypt(input, output, round_key);
            System.arraycopy(output, 0, out, point, BLOCK);
            inLen -= BLOCK;
            point += BLOCK;
        }

        return 0;
    }
    
    /*
     * 只加密16位明文
     * 
     * @param plaintext
     *      明文字节数组
     * @param key
     *      密钥字节数组
     * @return
     *      密文
     */
    private byte[] encode16(byte[] plaintext, byte[] key) {
        byte[] cipher = new byte[16];
        sms4(plaintext, 16, key, cipher, ENCRYPT);

        return cipher;
    }

    /*
     * 只解密16位密文
     * 
     * @param ciphertext
     *      密文字节数组
     * @param key
     *      密钥字节数组
     * @return
     *      明文
     */
    private byte[] decode16(byte[] ciphertext, byte[] key) {
        byte[] plain = new byte[16];
        sms4(ciphertext, 16, key, plain, DECRYPT);

        return plain;
    }

    /*
     * 只加密32位明文
     * 
     * @param plaintext
     *      明文字节数组
     * @param key
     *      密钥字节数组
     * @return
     *      密文
     */
    @SuppressWarnings("unused")
    private byte[] encode32(byte[] plaintext, byte[] key) {
        byte[] cipher = new byte[32];
        sms4(plaintext, 32, key, cipher, ENCRYPT);

        return cipher;
    }

    /*
     * 只解密32位密文
     * 
     * @param ciphertext
     *      密文字节数组
     * @param key
     *      密钥字节数组
     * @return
     *      明文
     */
    @SuppressWarnings("unused")
    private byte[] decode32(byte[] ciphertext, byte[] key) {
        byte[] plain = new byte[32];
        sms4(ciphertext, 32, key, plain, DECRYPT);

        return plain;
    }

    private String supplement(String text) {
        StringBuilder sb = new StringBuilder(text);
        for (int i = text.getBytes().length % 16; i < 16; i++) {
            sb.append('\0');
        }

        return sb.toString();
    }

    private byte[] supplement(byte[] data) {
        if (0 == (data.length % 16)) return data;

        byte[] result = new byte[data.length + 16 - (data.length % 16)];
        for (int i = 0; i < data.length; i++) {
            result[i] = data[i];
        }

        return result;
    }
}
