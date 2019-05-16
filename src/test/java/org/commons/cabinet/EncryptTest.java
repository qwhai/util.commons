package org.commons.cabinet;

import org.commons.cabinet.containers.ArrayUtils;
import org.commons.cabinet.encrypt.*;
import org.commons.cabinet.encrypt.interf.Encoder;
import org.commons.cabinet.encrypt.interf.Encrypt;
import org.junit.Test;

/**
 * TODO
 *
 * Create Time: 2019/05/16 13:35
 * Last Modify: 2019/05/16
 *
 * @author Q-WHai
 * @see <a href="https://github.com/qwhai">https://github.com/qwhai</a>
 */
public class EncryptTest extends Testable {

    @Test
    public void test1() {
        Encrypt base64 = new Base64();
        byte[] cipher = base64.encode("Hello world");
        logger.info(new String(cipher));
    }

    @Test
    public void test2() {
        Encrypt base64 = new Base64();
        byte[] cipher = base64.encode("你好，世界");
        logger.info(new String(cipher));
    }

    @Test
    public void test3() {
        Encrypt base64 = new Base64();
        byte[] cipher = base64.encode("你好，世界".getBytes());
        logger.info(new String(cipher));
    }

    @Test
    public void test4() {
        Encrypt base64 = new Base64();
        byte[] data = base64.decode("SGVsbG8gd29ybGQ=".getBytes());
        logger.info(new String(data));
    }

    @Test
    public void test5() {
        Encrypt base64 = new Base64();
        byte[] data = base64.decode("5L2g5aW977yM5LiW55WM".getBytes());
        logger.info(new String(data));
    }

    @Test
    public void test6() {
        Encrypt base64 = new Base64();
        byte[] data = base64.decode("5L2g5aW977yM5LiW55WM");
        logger.info(new String(data));
    }

    @Test
    public void test7() {
        Encoder md5 = new MD5();
        byte[] cipher = md5.encode("Hello world");
        logger.info(new String(cipher).toLowerCase());
    }

    @Test
    public void test8() {
        Encoder md5 = new MD5();
        byte[] cipher = md5.encode("你好，世界");
        logger.info(new String(cipher).toLowerCase());
    }

    @Test
    public void test9() {
        Encoder sha1 = new SHA1();
        byte[] cipher = sha1.encode("Hello world");

        String s = "";
        for (byte b : cipher) {
            s = String.format("%s%s", s, ByteUtils.byteToHexString(b));
        }

        logger.info(s.toLowerCase());
    }

    @Test
    public void test10() {
        Encoder sha1 = new SHA1();
        byte[] cipher = sha1.encode("你好，世界");

        String s = "";
        for (byte b : cipher) {
            s = String.format("%s%s", s, ByteUtils.byteToHexString(b));
        }

        logger.info(s.toLowerCase());
    }

    @Test
    public void test11() {
        String plaintext = "Hello world";
        byte[] key = new byte[] {
                0x01, 0x02, 0x03, 0x04, 0x05, 0x06, 0x07, 0x08,
                0x09, 0x0a, 0x0b, 0x0c, 0x0d, 0x0e, 0x0f, 0x10
        };

        Encrypt encrypt = new SMS4();
        ((SMS4) encrypt).setKey(key);

        byte[] cipher = encrypt.encode(plaintext);
        if (null == cipher) return;
        logger.info(ArrayUtils.output(cipher));
    }

    @Test
    public void test12() {
        String plaintext = "你好，世界";
        byte[] key = new byte[] {
                0x01, 0x02, 0x03, 0x04, 0x05, 0x06, 0x07, 0x08,
                0x09, 0x0a, 0x0b, 0x0c, 0x0d, 0x0e, 0x0f, 0x10
        };

        Encrypt encrypt = new SMS4();
        ((SMS4) encrypt).setKey(key);

        byte[] cipher = encrypt.encode(plaintext);
        if (null == cipher) return;
        logger.info(ArrayUtils.output(cipher));
    }

    @Test
    public void test13() {
        String plaintext = "你好，世界";
        byte[] key = new byte[] {
                0x01, 0x02, 0x03, 0x04, 0x05, 0x06, 0x07, 0x08,
                0x09, 0x0a, 0x0b, 0x0c, 0x0d, 0x0e, 0x0f, 0x10
        };

        Encrypt encrypt = new SMS4();
        ((SMS4) encrypt).setKey(key);

        byte[] cipher = encrypt.encode(plaintext.getBytes());
        if (null == cipher) return;
        logger.info(ArrayUtils.output(cipher));
    }

    @Test
    public void test14() {
        byte[] cipher = new byte[] {
                -43, -115, -7, -92, 111, 82, 63, -69, 20, -32, 10, 62, -109, -35, 101, -55
        };
        byte[] key = new byte[]{
                0x01, 0x02, 0x03, 0x04, 0x05, 0x06, 0x07, 0x08,
                0x09, 0x0a, 0x0b, 0x0c, 0x0d, 0x0e, 0x0f, 0x10
        };

        Encrypt encrypt = new SMS4();
        ((SMS4) encrypt).setKey(key);

        byte[] data = encrypt.decode(cipher);
        if (null == data) return;
        logger.info(new String(data).trim());
    }

    @Test
    public void test15() {
        byte[] cipher = new byte[] {
                96, -87, -49, 31, -125, 29, -62, -74, -96, 1, 127, -8, -52, 107, -82, 8
        };
        byte[] key = new byte[]{
                0x01, 0x02, 0x03, 0x04, 0x05, 0x06, 0x07, 0x08,
                0x09, 0x0a, 0x0b, 0x0c, 0x0d, 0x0e, 0x0f, 0x10
        };

        Encrypt encrypt = new SMS4();
        ((SMS4) encrypt).setKey(key);

        byte[] data = encrypt.decode(cipher);
        if (null == data) return;
        logger.info(new String(data).trim());
    }

    @Test
    public void test16() {
        Encoder encoder = new SHA256();
        byte[] cipher = encoder.encode("你好，世界".getBytes());

        String s = "";
        for (byte b : cipher) {
            s = String.format("%s%s", s, ByteUtils.byteToHexString(b));
        }

        logger.info(s.toLowerCase());
    }

    @Test
    public void test17() {
        Encoder encoder = new SHA256();
        byte[] cipher = encoder.encode("你好，世界");

        String s = "";
        for (byte b : cipher) {
            s = String.format("%s%s", s, ByteUtils.byteToHexString(b));
        }

        logger.info(s.toLowerCase());
    }
}
