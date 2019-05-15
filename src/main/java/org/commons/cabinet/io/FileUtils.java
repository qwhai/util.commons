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
}
