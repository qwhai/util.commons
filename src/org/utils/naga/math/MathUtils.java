package org.utils.naga.math;

import org.utils.naga.excep.CannotInstanceException;
import org.utils.naga.interf.UtilsInterface;

/**
 * <p>
 * 数学工具类
 * </p>
 * 2015‎年‎11‎月‎25‎日
 * 
 * @author <a href="http://weibo.com/u/5131020927">Q-WHai</a>
 * @see <a href="http://blog.csdn.net/lemon_tree12138">http://blog.csdn.net/lemon_tree12138</a>
 * @version 0.1.1
 */
public class MathUtils implements UtilsInterface {

    // 禁止实例化
    private MathUtils() throws CannotInstanceException {
        throw new CannotInstanceException("不要试图实例化我");
    }
    
    @Override
    public String getTag() {
        return this.getClass().getName();
    }
    
    @Override
    public void description() {
        System.out.println("这是一个数学工具类");
    }

    /**
     * 求n的阶乘
     * (此方法未经过任何优化,所以请保证n在1~13之间)
     * 
     * @param n
     *      阶乘数n
     * @return
     *      阶乘
     */
    public static int factorialRaw(int n) {
        int fac = 1;
        for (int i = 1; i <= n; i++) {
            fac *= i;
        }
        
        return fac;
    }
    
    /**
     * 矩阵转置
     * 
     * @param matrix
     *      原始矩阵
     * @return
     *      转置矩阵
     */
    public static Object[][] matrixTranspose(Object[][] matrix) {
        if (null == matrix) {
            return null;
        }
        
        Object[][] matrixT = new Object[matrix[0].length][matrix.length];
        
        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrixT[i][j] = matrix[j][i];
            }
        }
        
        return matrixT;
    }
    
    /**
     * 计算一维正态分布的值
     * 
     * @param μ
     *      平均数
     * @param σ
     *      标准差
     * @param x
     *      坐标
     * @return
     *      正态分布值
     */
    public static double normalDistribution(double μ, double σ, double x) {
        double index = -1 * (x - μ) * (x - μ) / (2 * σ * σ);
        double base = (1 / (Math.sqrt(2 * Math.PI) * σ)) * Math.E;
        
        return Math.pow(base, index);
    }
    
    /**
     * 一维高斯函数
     * 
     * @param n
     *      一维高斯的范围[-n, n]
     * @param σ
     *      标准方差
     * @return
     *      范围[-n, n]之内的高斯函数值
     */
    public static float[] getOneDimenGaussianFunction(int n, float σ) {
        // 参考：http://blog.csdn.net/jia20003/article/details/7234741
        
        float square_σ = 2 * σ * σ;
        float PI2 = 2 * (float)Math.PI;
        float sqrtσPI2 = (float)Math.sqrt(PI2) * σ ;
        int size = 2 * n + 1;
        
        int index = 0;
        float[] kernalData = new float[size];
        for(int i = -n; i <= n; i++) {
            float distance = i * i;
            kernalData[index] = (float)Math.exp((-distance) / square_σ) / sqrtσPI2;
            index++;
        }
        
        return kernalData;
    }
    
    /**
     * 一维高斯函数
     * (此处返回的一维数组各数和为1.0)
     * 
     * @param n
     *      一维高斯的范围[-n, n]
     * @param σ
     *      标准方差
     * @return
     *      范围[-n, n]之内的高斯函数值
     */
    public static float[] getOneDimenGaussianSumOne(int n, float σ) {
        float sum = 0.0f;
        float[] gauss = MathUtils.getOneDimenGaussianFunction(n, σ);
        
        for (float f : gauss) {
            sum += f;
        }
        
        if (sum == 0) {
            return null;
        }
        
        for (int i = 0; i < gauss.length; i++) {
            gauss[i] /= sum;
        }
        
        return gauss;
    }
    
    /**
     * 二维高斯函数
     * 
     * @param n
     *      二维高斯的范围[-n, n]
     * @param σ
     *      标准方差
     * @return
     *      范围[-n, n]之内的高斯函数值
     */
    public static float[][] getTwoDimenGaussianFunction(int n, float σ) {
        // 参考：http://blog.csdn.net/jia20003/article/details/7234741
        
        int size = 2 * n + 1;
        float σ22 = 2 * σ * σ;
        float σ22PI = (float)Math.PI * σ22;
        float[][] kernalData = new float[size][size];
        int row = 0;
        for(int i = -n; i <= n; i++) {
            int column = 0;
            for(int j = -n; j <= n; j++) {
                float xDistance = i * i;
                float yDistance = j * j;
                kernalData[row][column] = (float)Math.exp(-(xDistance + yDistance) / σ22) / σ22PI;
                column++;
            }
            row++;
        }
        return kernalData;
    }
    
    /**
     * 二维高斯函数
     * （此处返回的二维数组各数和为1.0）
     * 
     * @param n
     *      二维高斯的范围[-n, n]
     * @param σ
     *      标准方差
     * @return
     *      范围[-n, n]之内的高斯函数值
     */
    public static float[][] getTwoDimenGaussianSumOne(int n, float σ) {
        float sum = 0.0f;
        float[][] gauss = MathUtils.getTwoDimenGaussianFunction(n, σ);
        for (float[] fs : gauss) {
            for (int i = 0; i < fs.length; i++) {
                sum += fs[i];
            }
        }
        
        if (sum == 0) {
            return null;
        }
        
        for (int i = 0; i < gauss.length; i++) {
            for (int j = 0; j < gauss[i].length; j++) {
                gauss[i][j] /= sum;
            }
        }
        
        return gauss;
    }
}
