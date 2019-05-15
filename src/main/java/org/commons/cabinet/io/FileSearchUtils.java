package org.commons.cabinet.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.NotDirectoryException;

import org.commons.cabinet.excep.CannotInstanceException;
import org.commons.cabinet.excep.FileNameNotExistsException;
import org.commons.cabinet.str.StringUtils;

/**
 * <p>
 * 这是一个与文件相关的数据检索类
 * </p>
 * Create Date: 2015年11月15日
 * Last Modify: 2016年5月26日
 * 
 * @author Q-WHai
 * @see <a href="https://github.com/qwhai">https://github.com/qwhai</a>
 */
public final class FileSearchUtils {

    // 禁止实例化
    private FileSearchUtils() throws CannotInstanceException {
        throw new CannotInstanceException("不要试图实例化我");
    }

    /**
     * 判断某一文档中是否包含某一关键词
     * 
     * @param filePath
     *      文档路径
     * @param term
     *      关键词
     * @return
     *      是否包含关键词
     * @throws IOException
     *      读写异常
     */
    /**
    public static boolean containsTerm(String filePath, String term) throws IOException {
        List<String> lines = FileReadUtils.readLines(filePath);
        if (lines == null || lines.size() == 0) {
            return false;
        }
        
        for (String line : lines) {
            String[] splitWords = line.split(" ");
            for (String word : splitWords) {
                if (word.equals(term)) {
                    return true;
                }
            }
        }
        
        return false;
    }*/
    
    /**
     * 获得某一文件目录下的所有文件列表
     * 
     * @param dir
     *      文件目录
     * @return
     *      文件目录下的所有文件
     */
    @Deprecated
    public static File[] listFiles(String dir) {
        if (StringUtils.isEmpty(dir)) {
            return null;
        }
        
        File dirFile = new File(dir);
        if (dirFile.isFile()) {
            return null;
        }
        
        return dirFile.listFiles();
    }
    
    /**
     * 获得某一文件目录下的所有文件列表
     * 
     * @param dir
     *      文件目录
     * @return
     *      文件目录下的所有文件名
     */
    @Deprecated
    public static String[] listFilesLabel(String dir) {
        if (StringUtils.isEmpty(dir)) {
            return null;
        }
        
        File dirFile = new File(dir);
        if (dirFile.isFile()) {
            return null;
        }
        
        return dirFile.list();
    }
    
    /**
     * 获得一个文件目录下的所有文件名称(只包含文件名本身)
     * 
     * @param folderName
     *      文件目录
     * @return
     *      文件名称数组
     * @throws FileNameNotExistsException
     *      文件名不存在异常
     * @throws NotDirectoryException
     *      不是目录异常
     */
    public static String[] getAllFileName(String folderName) throws FileNameNotExistsException, NotDirectoryException {
        if (StringUtils.isEmpty(folderName)) {
            throw new NullPointerException("目录名为空，请输入文件目录");
        }
        
        File folderFile = new File(folderName);
        if (!folderFile.exists()) {
            throw new FileNameNotExistsException(folderName + "当前文件目录不存在");
        }
        
        if (!folderFile.isDirectory()) {
            throw new NotDirectoryException(folderName + "不是目录");
        }
        
        return folderFile.list();
    }
    
    /**
     * 获得一个文件目录下的所有文件
     * 
     * @param folderName
     *      文件目录
     * @return
     *      子文件
     * @throws FileNameNotExistsException
     *      文件名不存在异常
     * @throws NotDirectoryException
     *      不是目录异常
     */
    public static File[] getAllSubFiles(String folderName) throws FileNameNotExistsException, NotDirectoryException {
        if (StringUtils.isEmpty(folderName)) {
            throw new NullPointerException("目录名为空，请输入文件目录");
        }
        
        File folderFile = new File(folderName);
        if (!folderFile.exists()) {
            throw new FileNameNotExistsException(folderName + "当前文件目录不存在");
        }
        
        if (!folderFile.isDirectory()) {
            throw new NotDirectoryException(folderName + "不是目录");
        }
        
        return folderFile.listFiles();
    }
    
    /**
     * 获得一个文件目录下的所有文件的完整名称
     * 
     * @param folderName
     *      文件目录
     * @return
     *      文件名称数组
     * @throws FileNameNotExistsException
     *      文件名不存在异常
     * @throws NotDirectoryException
     *      不是目录异常
     */
    public static String[] getAllFileFullName(String folderName) throws FileNameNotExistsException, NotDirectoryException {
        String[] fileNames = getAllFileName(folderName);
        if (!folderName.endsWith("/")) {
            folderName += "/";
        }
        
        for (int i = 0; i < fileNames.length; i++) {
            fileNames[i] = folderName + fileNames[i];
        }
        
        return fileNames;
    }
    
    /**
     * 文件是否存在
     * 
     * @param filePath
     *      文件路径
     * @return
     *      是否存在
     */
    public static final boolean isFileExists(String filePath) {
        File file = new File(filePath);
        return file.exists();
    }
    
    /**
     * 判断一个文件的内容是否为空
     * 
     * @param filePath
     *      文件路径
     * @return
     *      是否为空文件
     * @throws FileNameNotExistsException
     *      文件不存在异常
     */
    public static final boolean isEmptyFile(String filePath) throws FileNameNotExistsException {
        File file = new File(filePath);
        if (!file.exists()) {
            throw new FileNameNotExistsException("文件" + filePath + "不存在");
        }
        
        if (file.length() == 0) {
            return true;
        }
        
        return false;
    }
    
    /**
     * 文件最后一次被修改的时间
     * 
     * @param filePath
     *      文件路径
     * @return
     *      时间
     * @throws FileNameNotExistsException
     *      文件不存在异常
     */
    public static final long lastModified(String filePath) throws FileNameNotExistsException {
        File file = new File(filePath);
        if (!file.exists()) {
            throw new FileNameNotExistsException("文件" + filePath + "不存在");
        }
        
        return file.lastModified();
    }
}
