package org.commons.cabinet.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

import org.commons.cabinet.excep.CannotInstanceException;
import org.commons.cabinet.str.StringUtils;

/**
 * <p>
 * 文件操作类
 * </p>
 * Create Date: 2015年11月15日
 * Last Modify: 2016年5月26日
 * 
 * @author Q-WHai
 * @see <a href="https://github.com/qwhai">https://github.com/qwhai</a>
 */
public final class FileUtils {

    // 工具类，禁止实例化
    private FileUtils() throws CannotInstanceException {
        throw new CannotInstanceException("请不要试图实例化我");
    }

    /**
     * 获得文件后缀名
     * 
     * @param fileName
     *      完整文件名
     * @return
     *      后缀名
     */
    public static final String suffixName(String fileName) {
        return StringUtils.RegexUtils.getSub(fileName, "\\.[\\w]+$");
    }

    /**
     * 移除文件的后缀名
     * 
     * @param fileName
     *      完整的文件名
     * @return
     *      文件名(无后缀)
     */
    public static final String removeSuffixName(String fileName) {
        return fileName.replace(suffixName(fileName), "");
    }
    
    /**
     * 创建一个文件，包括其目录。如果目录不存在，也会创建目录
     * 
     * @param filePath
     *      文件的完整路径
     * @throws IOException
     *      读写异常 
     */
    public static final void createFullFile(String filePath) throws IOException {
        File file = new File(filePath);
        if (file.exists()) {
            return;
        }
        
        String[] splits = filePath.split("/");
        String folderName = filePath.replace(splits[splits.length - 1], "");
        makeDirs(folderName);
        
        file.createNewFile();
    }
    
    /**
     * 创建一个文件，不包括其目录。
     * 如果目录不存在，就会抛出异常
     * 
     * @param filePath
     *      文件的完整路径
     * @throws IOException
     *      读写异常 
     */
    public static final void createFile(String filePath) throws IOException {
        File file = new File(filePath);
        if (file.exists()) {
            return;
        }
        
        file.createNewFile();
    }
    
    /**
     * 复制文件
     * 
     * @param source
     *      原文件
     * @param target
     *      目标文件
     * @throws IOException
     *      读写异常
     */
    public static final void copyFileByBuffer(File source, File target) throws IOException {
        if (source == null || target == null) {
            throw new IOException("文件对象为空");
        }
        
        if (!source.exists()) {
            throw new IOException("原文件不存在");
        }
        
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
    }
    
    /**
     * 复制文件
     * 
     * @param source
     *      原文件
     * @param target
     *      目标文件
     * @throws IOException
     *      读写异常
     */
    public static final void copyFileByBuffer(String source, String target) throws IOException {
        if (StringUtils.isEmpty(source) || StringUtils.isEmpty(target)) {
            throw new NullPointerException("文件名不能为空");
        }
        
        File sourceFile = new File(source);
        File targetFile = new File(target);
        
        copyFileByBuffer(sourceFile, targetFile);
    }

    /**
     * 复制文件
     * 
     * @param source
     *      原文件
     * @param target
     *      目标文件
     * @throws IOException
     *      读写异常
     */
    public static final void copyFileByTransfer(File source, File target) throws IOException {
        if (source == null || target == null) {
            throw new IOException("文件对象为空");
        }
        
        if (!source.exists()) {
            throw new IOException("原文件不存在");
        }
        
        FileInputStream inStream = new FileInputStream(source);
        FileOutputStream outStream = new FileOutputStream(target);
        FileChannel in = inStream.getChannel();
        FileChannel out = outStream.getChannel();

        in.transferTo(0, in.size(), out);

        inStream.close();
        in.close();
        outStream.close();
        out.close();
    }
    
    /**
     * 复制文件
     * 
     * @param source
     *      原文件
     * @param target
     *      目标文件
     * @throws IOException
     *      读写异常
     */
    public static final void copyFileByTransfer(String source, String target) throws IOException {
        if (StringUtils.isEmpty(source) || StringUtils.isEmpty(target)) {
            throw new NullPointerException("文件名不能为空");
        }
        
        File sourceFile = new File(source);
        File targetFile = new File(target);
        
        copyFileByTransfer(sourceFile, targetFile);
    }
    
    /**
     * 通过内存映射复制文件
     * 
     * @param sourcePath
     *      原文件
     * @param targetPath
     *      目标文件
     * @throws IOException
     *      读写异常
     */
    public static final void copyFileByMapped(String sourcePath, String targetPath) throws IOException {
        RandomAccessFile readFile = new RandomAccessFile(sourcePath, "r");
        RandomAccessFile writeFile = new RandomAccessFile(targetPath, "rw");

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
    }
    
    /**
     * 创建一个文件夹目录。
     * 这个是一个绝对的创建过程，包括父目录不存在的情况(如果父目录不存在，父目录也会被创建)。
     * 
     * @param folderName
     *      文件夹名称
     * @return
     *      是否创建成功
     */
    public static final boolean makeDirs(String folderName) {
        if (StringUtils.isEmpty(folderName)) {
            return false;
        }

        File folder = new File(folderName);
        return (folder.exists() && folder.isDirectory()) ? true : folder.mkdirs();
    }
    
    /**
     * 删除文件
     * 
     * @param filePathAndName
     *      文件路径及名称
     */
    public static final void deleteFile(String filePathAndName) {
        File myDelFile = new File(filePathAndName);
        myDelFile.delete();
    }
    
    /**
     * 移动一个文件
     * 
     * @param sourcePath
     *      原文件
     * @param targetPath
     *      目标文件
     * @throws IOException
     *      读写异常
     */
    public static final void moveFile(String sourcePath, String targetPath) throws IOException {
        copyFileByTransfer(sourcePath, targetPath);
        deleteFile(sourcePath);
    }
    
    /**
     * 对文件进行重命名
     * 
     * @param oldName
     *      原名称
     * @param newName
     *      新名称
     */
    public static final void rename(String oldName, String newName) {
        File file = new File(oldName);
        file.renameTo(new File(newName));
    }
    
    /**
     * 删除一个非空的文件夹
     * 
     * @param folderName
     * @return
     */
    public static boolean deleteFolder(File folderName) {
        if (folderName.isDirectory()) {
            String[] children = folderName.list();
            // 递归删除目录中的子目录下
            for (int i = 0; i < children.length; i++) {
                boolean success = deleteFolder(new File(folderName, children[i]));
                if (!success) {
                    return false;
                }
            }
        }
        // 目录此时为空，可以删除
        return folderName.delete();
    }
}
