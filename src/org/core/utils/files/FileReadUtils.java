package org.core.utils.files;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.core.utils.excep.CannotInstanceException;
import org.core.utils.interf.UtilsInterface;
import org.core.utils.str.StringUtils;

/**
 * <p>
 * 读文件的工具类
 * </p>
 * Create Date: 2015年11月15日
 * Last Modify: 2016年5月26日
 * 
 * @author <a href="http://weibo.com/u/5131020927">Q-WHai</a>
 * @see <a href="http://blog.csdn.net/lemon_tree12138">http://blog.csdn.net/
 *      lemon_tree12138</a>
 * @version 0.1.1
 */
public final class FileReadUtils implements UtilsInterface {

    // 禁止实例化
    private FileReadUtils() throws CannotInstanceException {
        throw new CannotInstanceException("不要试图实例化我");
    }

    @Override
    public String getTag() {
        return this.getClass().getName();
    }

    @Override
    public void description() {
        System.out.println("读文件的工具类");
    }

    /**
     * 直接进行文件操作的方法
     * 
     * @param filePath
     *            文件路径
     * @return 文件的所有行
     * @throws IOException
     *             读写异常
     */
    public static ArrayList<String> readLines(String filePath)
            throws IOException {
        if (StringUtils.isEmpty(filePath)) {
            return null;
        }

        ArrayList<String> datas = new ArrayList<String>();

        File file = new File(filePath);
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String tempString = null;
        // 一次读入一行，直到读入null为文件结束
        while ((tempString = reader.readLine()) != null) {
            if (!StringUtils.isEmpty(tempString)) {
                datas.add(tempString);
            }
        }
        reader.close();

        return datas;
    }

    /**
     * 将文件直接读出成一个字符串
     * 
     * @param filePath
     *            文件路径
     * @return 文件内容
     * @throws IOException
     *             读写异常
     */
    public static String readToString(String filePath) throws IOException {
        if (StringUtils.isEmpty(filePath)) {
            throw new NullPointerException("文件名不能为空");
        }

        File file = new File(filePath);
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String tempString = null;
        StringBuffer buffer = new StringBuffer();
        // 一次读入一行，直到读入null为文件结束
        while ((tempString = reader.readLine()) != null) {
            if (!StringUtils.isEmpty(tempString)) {
                buffer.append(tempString);
            }
        }

        reader.close();

        return buffer.toString();
    }

    /**
     * 把文件读到一个字节数组
     * 
     * @param filePath
     *      文件路径
     * @return
     *      字节数组
     * @throws IOException
     *      读写异常
     */
    public static byte[] readFileToByteArray(String filePath) throws IOException {
        File file = new File(filePath);
        
        if (!file.exists()) {
            throw new FileNotFoundException("文件" + filePath + "不存在");
        }

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream((int) file.length());
        BufferedInputStream inputStream = null;
        try {
            inputStream = new BufferedInputStream(new FileInputStream(file));
            int bufferSize = 1024;
            byte[] buffer = new byte[bufferSize];
            int len = 0;
            while (-1 != (len = inputStream.read(buffer, 0, bufferSize))) {
                outputStream.write(buffer, 0, len);
            }
            return outputStream.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            outputStream.close();
        }
    }
}
