package pers.hai.util.commons.io;

/**
 * 文件复制类型：
 * BUFFER       通过buffer方式
 * TRANSFER     通过transfer方式
 * MAPPING      通过内存映射方式
 *
 * Create Time: 2019/05/16 10:20
 * Last Modify: 2019/05/16
 *
 * @author Q-WHai
 * @see <a href="https://github.com/qwhai">https://github.com/qwhai</a>
 */
public enum CopyType {
    BUFFER,
    TRANSFER,
    MAPPING
}
