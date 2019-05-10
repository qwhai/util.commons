package org.commons.cabinet.logs;

import org.commons.cabinet.consts.MemoryUnit;
import org.commons.cabinet.excep.CannotInstanceException;
import org.commons.cabinet.nums.UnitConversion;

/**
 * <p>
 * 打印日志的工具类
 * </p>
 * Create Date: 2015年11月27日
 * Last Modify: 2016年5月26日
 * 
 * @author Q-WHai
 * @see <a href="https://github.com/qwhai">https://github.com/qwhai</a>
 */
public class LogUtils {

    // 禁止实例化
    private LogUtils() throws CannotInstanceException {
        throw new CannotInstanceException("不要试图实例化我");
    }

    /**
     * 打印时间消耗日志
     * 
     * @param startStamp
     *          开始时间戳
     */
    public static void printTimeUsed(long startStamp) {
        System.out.println("此步操作用时：" + (System.currentTimeMillis() - startStamp) + "ms");
    }
    
    /**
     * 打印时间消耗日志
     * 
     * @param label
     *      标签说明
     * @param startStamp
     *      开始时间戳(毫秒)
     */
    public static void printTimeUsed(String label, long startStamp) {
        System.out.println(label + " 用时：" + (System.currentTimeMillis() - startStamp) + "ms");
    }
    
    /**
     * 打印时间消耗日志
     * 
     * @param label
     *      标签说明
     * @param startStamp
     *      开始时间戳(纳秒)
     */
    public static void printNanoTimeUsed(String label, long startStamp) {
        System.out.println(label + " 用时：" + (System.nanoTime() - startStamp) + "ns");
    }
    
    /**
     * 打印一个整型数组
     * 
     * @param array
     *      整型数组
     */
    public static void printArray(int[] array) {
        boolean firstFlag = true;
        StringBuffer logBuffer = new StringBuffer();
        for (int i : array) {
            if (firstFlag) {
                logBuffer.append("[" + i);
                firstFlag = false;
            } else {
                logBuffer.append(", " + i);
            }
        }
        logBuffer.append("]");
        
        System.out.println(logBuffer.toString());
    }
    
    /**
     * 打印一个字节数组
     * 
     * @param bytes
     *      字节数组
     */
    public static void printBits(byte[] bytes) {
        boolean firstFlag = true;
        StringBuffer logBuffer = new StringBuffer();
        String b = "";
        for (byte i : bytes) {
            b = Integer.toHexString(i & 0xff);
            b = (b.length() == 1 ? ("0" + b) : b);
            if (firstFlag) {
                logBuffer.append("[" + b);
                firstFlag = false;
            } else {
                logBuffer.append(", " + b);
            }
        }
        logBuffer.append("]");
        
        System.out.println(logBuffer.toString());
    }
    
    /**
     * 打印当前Java虚拟机的状态
     */
    public static void printRuntimeInfo() {
        Runtime runtime = Runtime.getRuntime();
        
        long freeMemory = runtime.freeMemory();
        System.out.println("当前Java虚拟机中的空闲内存量：" + UnitConversion.Memory.biggerUnitTranslate(MemoryUnit.Byte, freeMemory));
        
        long totalMemory = runtime.totalMemory();
        System.out.println("当前Java虚拟机中的总内存量：" + UnitConversion.Memory.biggerUnitTranslate(MemoryUnit.Byte, totalMemory));
        
        long maxMemory = runtime.maxMemory();
        System.out.println("当前Java虚拟机中的最大内存量：" + UnitConversion.Memory.biggerUnitTranslate(MemoryUnit.Byte, maxMemory));
    }
}
