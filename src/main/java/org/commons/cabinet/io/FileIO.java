package org.commons.cabinet.io;

import org.commons.cabinet.str.StringUtils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
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
public final class FileIO {

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

    /**
     * 以覆盖形式写文件
     *
     * @param   path
     *          文件目录
     *
     * @param   data
     *          写入数据
     *
     * @return  true:写入成功 / false:写入失败
     *
     * @throws  IOException
     *          文件读写异常
     */
    public static boolean write(String path, byte[] data) throws IOException {
        if (!exists(path))
            createNewFile(path);

        BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(path));
        for (int i = 0; i < data.length; i += 1024) {
            out.write(Arrays.copyOfRange(data, i * 1024, Math.min((i + 1) * 1024, data.length)));
        }

        out.flush();
        out.close();

        return true;
    }

    /**
     * 以覆盖形式写文件
     *
     * @param   path
     *          文件目录
     *
     * @param   content
     *          写入内容
     *
     * @return  true:写入成功 / false:写入失败
     *
     * @throws  IOException
     *          文件读写异常
     */
    public static boolean write(String path, String content) throws IOException {
        return write(path, content.getBytes(StandardCharsets.UTF_8));
    }

    /**
     * 以追加形式写文件
     *
     * @param   path
     *          文件路径
     *
     * @param   data
     *          追加数据
     *
     * @return  true:追加成功 / false:追加失败
     *
     * @throws  IOException
     *          文件读写异常
     */
    public static boolean append(String path, byte[] data) throws IOException {
        if (!exists(path))
            createNewFile(path);

        try (FileOutputStream fos = new FileOutputStream(path, true)) {
            fos.write(data);
        }

        return true;
    }

    /**
     * 以追加形式写文件
     *
     * @param   path
     *          文件路径
     *
     * @param   content
     *          追加内容
     *
     * @return  true:追加成功 / false:追加失败
     *
     * @throws  IOException
     *          文件读写异常
     */
    public static boolean append(String path, String content) throws IOException {
        return append(path, content.getBytes(StandardCharsets.UTF_8));
    }

    public static boolean insert(String path, String content) throws IOException {
        // TODO
        return false;
    }

    public static boolean insert(String path, byte[] data) throws IOException {
        // TODO
        return false;
    }

    public static boolean replace(String path, byte[] data, int seek) throws IOException {
        // TODO
        return false;
    }

    public static boolean replace(String path, byte[] data) throws IOException {
        return replace(path, data, 0);
    }

    /**
     * 判别文件是否存在
     *
     * @param   path
     *          文件目录或文件夹目录
     *
     * @return  true:存在 / false:不存在
     */
    public static boolean exists(String path) {
        return new File(path).exists();
    }

    /**
     * 创建一个新文件
     *
     * @param   path
     *          文件路径
     *
     * @return  true:创建成功 / false:创建失败
     *
     * @throws  IOException
     *          文件读写异常
     */
    public static boolean createNewFile(String path) throws IOException {
        return new File(path).createNewFile();
    }

    /**
     * 创建一个文件夹目录
     * 这个是一个绝对的创建过程，包括父目录不存在的情况（如果父目录不存在，父目录也会被创建）
     *
     * @param   dir
     *          文件夹名称
     *
     * @return  是否创建成功
     */
    public static boolean createNewFolder(String dir) {
        File folder = new File(dir);
        return (folder.exists() && folder.isDirectory()) || folder.mkdirs();
    }

    /**
     * 文件最后一次被修改的时间
     *
     * @param   path
     *          文件路径
     *
     * @return  毫秒时间戳
     *
     * @throws  IOException
     *          文件读写异常
     */
    public static long lastModified(String path) throws IOException {
        File file = new File(path);
        if (!file.exists())
            throw new IOException(String.format("文件%s不存在", path));

        return file.lastModified();
    }

    /**
     * 获得文件夹下的所有一级文件列表
     *
     * @param   dir
     *          文件目录
     *
     * @return  文件目录下的所有文件
     */
    public static File[] listFiles(String dir) {
        File folder = new File(dir);
        return !folder.exists() ? null : folder.isFile() ? null : folder.listFiles();
    }

    /**
     * 判断文件内容是否为空
     *
     * @param   path
     *          文件路径
     *
     * @return  是否为空文件
     *
     * @throws  IOException
     *          文件读写异常
     */
    public static boolean isEmptyFile(String path) throws IOException {
        File file = new File(path);
        if (!file.exists())
            throw new IOException(String.format("文件%s不存在", path));

        return 0 == file.length();
    }

    /**
     * 获得文件扩展名
     *
     * @param   path
     *          完整文件名
     *
     * @return  后缀名
     */
    public static String extension(String path) {
        return StringUtils.RegexUtils.getSub(path, "\\.[\\w]+$");
    }

    /**
     * 替换文件的扩展名
     *
     * @param   path
     *          完整的文件名
     *
     * @param   extension
     *          扩展名（包含'.'号）
     *
     * @return  文件名
     */
    public static String replaceExtension(String path, String extension) {
        return path.replace(extension(path), extension);
    }

    /**
     * 删除文件
     *
     * @param   path
     *          文件路径
     *
     * @return  true:成功 / false:失败
     */
    public static boolean deleteFile(String path) {
        File file = new File(path);
        if (!file.exists())
            return false;

        return file.delete();
    }

    /**
     * 删除一个非空的文件夹
     *
     * @param   dir
     *          待删除文件夹
     *
     * @return  true:删除成功 / false:删除失败
     */
    public static boolean deleteFolder(File dir) {
        if (dir.isDirectory()) {
            String[] children = dir.list();
            if (null == children)
                return false;

            // 递归删除目录中的子目录下
            for (String child : children) {
                boolean success = deleteFolder(new File(dir, child));
                if (!success)
                    return false;
            }
        }

        // 目录此时为空，可以删除
        return dir.delete();
    }

    /**
     * 对文件进行重命名
     *
     * @param   oldName
     *          原名称
     *
     * @param   newName
     *          新名称
     *
     * @return  true:重命名成功 / false:重命名失败
     */
    public static boolean rename(String oldName, String newName) {
        File file = new File(oldName);
        return file.renameTo(new File(newName));
    }
}
