package pers.hai.util.commons.encrypt.excep;

/**
 * 在加解密前未设置key异常
 *
 * Create Time: 2019/05/16 17:44
 * Last Modify: 2019/05/16
 *
 * @author Q-WHai
 * @see <a href="https://github.com/qwhai">https://github.com/qwhai</a>
 */
public class UnsetKeyException extends RuntimeException {

    public UnsetKeyException(String msg) {
        super(msg);
    }
}
