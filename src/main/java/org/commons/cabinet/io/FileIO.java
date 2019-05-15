package org.commons.cabinet.io;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * 文件读写工具类
 *
 * Create Time: 18:18 2019/05/15
 * Last Modify: 2019/05/15
 *
 * @author Q-WHai
 * @see <a href="https://github.com/qwhai">https://github.com/qwhai</a>
 */
public class FileIO {

    /**
     * 按行读取文件
     *
     * @param   path
     *          文件路径
     *
     * @return  文件中的所有行
     *
     * @throws  IOException
     *          文件读写异常
     */
    public static List<String> readLines(String path) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(path), StandardCharsets.UTF_8));
        String line;

        List<String> result = new ArrayList<>();
        while ((line = in.readLine()) != null) {
            result.add(line);
        }

        in.close();

        return result;
    }

    /**
     * 读取文件中所有字节
     *
     * @param   path
     *          文件路径
     *
     * @return  字节数据
     *
     * @throws  IOException
     *          文件读写异常
     */
    public static byte[] read(String path) throws IOException {

        BufferedInputStream in = new BufferedInputStream(new FileInputStream(path));

        byte[] bytes = new byte[2048];
        int n = -1;
        List<Byte> data = new ArrayList<>();
        while ((n = in.read(bytes, 0, bytes.length)) != -1) {
            for (int i = 0; i < n; i++) {
                data.add(bytes[i]);
            }
        }

        in.close();

        byte[] result = new byte[data.size()];
        for (int i = 0; i < data.size(); i++) {
            result[i] = data.get(i);
        }

        return result;
    }

    /**
     * 读取文件中的内容，以字符串形式保存
     *
     * @param   path
     *          文件路径
     *
     * @return  文件文件信息
     *
     * @throws  IOException
     *          文件读写异常
     */
    public static String read2String(String path) throws IOException {

        BufferedInputStream in = new BufferedInputStream(new FileInputStream(path));

        byte[] bytes = new byte[2048];
        int n = -1;
        StringBuilder sb = new StringBuilder();
        while ((n = in.read(bytes, 0, bytes.length)) != -1) {
            sb.append(new String(bytes, 0, n, StandardCharsets.UTF_8));
        }

        in.close();

        return sb.toString();
    }
}
