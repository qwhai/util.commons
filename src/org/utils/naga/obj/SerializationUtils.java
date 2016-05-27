package org.utils.naga.obj;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import org.utils.naga.excep.CannotInstanceException;
import org.utils.naga.interf.UtilsInterface;

/**
 * <p>
 * 这个是一个关于对象的持久化的工具类
 * </p>
 * 2015‎年‎11‎月‎25‎日
 * 
 * @author <a href="http://weibo.com/u/5131020927">Q-WHai</a>
 * @see <a href="http://blog.csdn.net/lemon_tree12138">http://blog.csdn.net/lemon_tree12138</a>
 * @version 0.1.1
 */
public class SerializationUtils implements UtilsInterface {

    // 禁止实例化
    private SerializationUtils() throws CannotInstanceException {
        throw new CannotInstanceException("不要试图实例化我");
    }
    
    @Override
    public String getTag() {
        return this.getClass().getName();
    }

    @Override
    public void description() {
        System.out.println("这个是一个关于对象的持久化的工具类");
    }

    /**
     * 将一个对象写入到磁盘
     * 
     * @param s
     *      待写入的对象
     * @param path
     *      写入的路径
     */
    public static void writeObject(Serializable s, String path) {
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(path));
            objectOutputStream.writeObject(s);
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * 从磁盘中读出一个对象
     * 
     * @param path
     *      读出对象的路径
     * @return
     *      读出的对象
     */
    public static Object readObject(String path) {
        Object object = null;
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(path));
            object = objectInputStream.readObject();
            objectInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        
        return object;
    }
}
