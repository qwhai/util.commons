package pers.hai.util.commons.io;

import pers.hai.util.commons.str.StringUtils;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
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
        int n;
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
        int n;
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

    /**
     * 在文件指定位置插入内容
     *
     * @param   path
     *          文件路径
     *
     * @param   data
     *          待插入数据
     *
     * @param   pos
     *          待插入位置
     *
     * @return  true:追加成功 / false:追加失败
     *
     * @throws  IOException
     *          文件读写异常
     */
    public static boolean insert(String path, byte[] data, int pos) throws IOException {
        // 参数校验
        File file = new File(path);
        // 判断文件是否存在
        if (!(file.exists() && file.isFile()))
            throw new IOException("文件不存在");

        // 判断pos是否合法
        if ((pos < 0) || (pos > file.length()))
            throw new IOException("position不合法");

        // 创建临时文件
        File tempFile = File.createTempFile("sss", ".temp", new File("d:/"));
        // 用文件输入流、文件输出流对文件进行操作
        FileOutputStream outputStream = new FileOutputStream(tempFile);
        FileInputStream inputStream = new FileInputStream(tempFile);
        // 在退出JVM退出时自动删除
        tempFile.deleteOnExit();

        // 创建RandomAccessFile流
        RandomAccessFile raf = new RandomAccessFile(file, "rw");
        // 文件指定位置到 pos
        raf.seek(pos);

        int tmp;
        // 将pos位置后的内容写入临时文件
        while (-1 != (tmp = raf.read()))
            outputStream.write(tmp);

        // 将追加内容 contents 写入 pos 位置
        raf.seek(pos);
        raf.write(data);

        // 将临时文件写回文件，并将创建的流关闭
        while ((tmp = inputStream.read()) != -1)
            raf.write(tmp);

        raf.close();
        outputStream.close();
        inputStream.close();

        return true;
    }

    /**
     * 在文件指定位置插入内容
     *
     * @param   path
     *          文件路径
     *
     * @param   content
     *          待插入内容
     *
     * @param   pos
     *          待插入位置
     *
     * @return  true:追加成功 / false:追加失败
     *
     * @throws  IOException
     *          文件读写异常
     */
    public static boolean insert(String path, String content, int pos) throws IOException {
        return insert(path, content.getBytes(StandardCharsets.UTF_8), pos);
    }

    /**
     * 替换文件中的内容
     *
     * @param   path
     *          文件路径
     *
     * @param   data
     *          待替换的数据
     *
     * @param   pos
     *          起始位置
     *
     * @return  true: 成功 / false:失败
     *
     * @throws  IOException
     *          文件读写异常
     */
    public static boolean replace(String path, byte[] data, int pos) throws IOException {
        RandomAccessFile file = new RandomAccessFile(path, "rw");
        file.seek(pos);
        file.write(data);
        file.close();

        return true;
    }

    /**
     * 替换文件中的内容
     *
     * @param   path
     *          文件路径
     *
     * @param   data
     *          待替换的数据
     *
     * @return  true: 成功 / false:失败
     *
     * @throws  IOException
     *          文件读写异常
     */
    public static boolean replace(String path, byte[] data) throws IOException {
        return replace(path, data, 0);
    }

    /**
     * 复制文件
     *
     * @param   source
     *          原文件路径
     *
     * @param   target
     *          目标文件路径
     *
     * @param   type
     *          复制方法类型
     *
     * @return  true: 成功 / false:失败
     *
     * @throws  IOException
     *          文件读写异常
     */
    public static boolean copy(String source, String target, CopyType type) throws IOException {
        switch (type) {
            case BUFFER:
                return copyByBuffer(source,target);
            case TRANSFER:
                return copyByTransfer(source, target);
            case MAPPING:
                return copyByMapped(source,target);
            default:
                return copyByBuffer(source,target);
        }
    }

    /**
     * 复制文件
     *
     * @param   source
     *          原文件
     *
     * @param   target
     *          目标文件
     *
     * @return  true: 成功 / false:失败
     *
     * @throws  IOException
     *          文件读写异常
     */
    public static boolean copy(String source, String target) throws IOException {
        return copy(source, target, CopyType.BUFFER);
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

    // ------------------------------------------------- 内部方法分隔线 --------------------------------------------------

    /**
     * 复制文件
     *
     * @param   source
     *          原文件
     *
     * @param   target
     *          目标文件
     *
     * @throws  IOException
     *          读写异常
     */
    private static boolean copyByTransfer(File source, File target) throws IOException {
        if (null == source || null == target)
            throw new IOException("文件对象为空");

        if (!source.exists())
            throw new IOException("原文件不存在");

        FileChannel in = new FileInputStream(source).getChannel();
        FileChannel out = new FileOutputStream(target).getChannel();

        in.transferTo(0, in.size(), out);

        in.close();
        out.close();

        return true;
    }

    /**
     * 复制文件（Transfer）
     *
     * @param   source
     *          原文件
     *
     * @param   target
     *          目标文件
     *
     * @return  true:成功 / false:失败
     *
     * @throws  IOException
     *          文件读写异常
     */
    private static boolean copyByTransfer(String source, String target) throws IOException {
        if (StringUtils.isEmpty(source) || StringUtils.isEmpty(target))
            throw new IOException("文件名不能为空");

        return copyByTransfer(new File(source), new File(target));
    }

    /**
     * 复制文件（内存映射）
     *
     * @param   source
     *          原文件
     *
     * @param   target
     *          目标文件
     *
     * @return  true:成功 / false:失败
     *
     * @throws  IOException
     *          文件读写异常
     */
    private static boolean copyByMapped(String source, String target) throws IOException {
        RandomAccessFile readFile = new RandomAccessFile(source, "r");
        RandomAccessFile writeFile = new RandomAccessFile(target, "rw");

        long fileLength = readFile.length();

        MappedByteBuffer in = readFile.getChannel().map(FileChannel.MapMode.READ_ONLY, 0, fileLength);
        MappedByteBuffer out = writeFile.getChannel().map(FileChannel.MapMode.READ_WRITE, 0, fileLength);

        for (int i = 0; i < fileLength; i++) {
            out.put(in.get());
        }

        readFile.close();
        writeFile.close();
        in.clear();
        out.clear();

        return true;
    }

    /**
     * 复制文件（Buffer）
     *
     * @param   source
     *          原文件
     *
     * @param   target
     *          目标文件
     *
     * @return  true:成功 / false:失败
     *
     * @throws  IOException
     *          读写异常
     */
    private static boolean copyByBuffer(File source, File target) throws IOException {
        if (null == source || null == target)
            throw new IOException("文件对象为空");

        if (!source.exists())
            throw new IOException("原文件不存在");

        FileInputStream inStream = new FileInputStream(source);
        FileOutputStream outStream = new FileOutputStream(target);
        FileChannel in = inStream.getChannel();
        FileChannel out = outStream.getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(4096);
        while (in.read(buffer) != -1) {
            buffer.flip();
            out.write(buffer);
            buffer.clear();
        }

        inStream.close();
        in.close();
        outStream.close();
        out.close();

        return true;
    }

    /**
     * 复制文件（Buffer）
     *
     * @param   source
     *          原文件
     *
     * @param   target
     *          目标文件
     *
     * @return  true:成功 / false:失败
     *
     * @throws  IOException
     *          读写异常
     */
    private static boolean copyByBuffer(String source, String target) throws IOException {
        if (StringUtils.isEmpty(source) || StringUtils.isEmpty(target))
            throw new IOException("文件名不能为空");

        return copyByBuffer(new File(source), new File(target));
    }
}
