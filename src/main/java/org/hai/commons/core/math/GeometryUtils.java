package org.hai.commons.core.math;

import org.hai.commons.core.excep.CannotBeTriangleException;
import org.hai.commons.core.excep.CannotInstanceException;
import org.hai.commons.core.excep.ShapeException;
import org.hai.commons.core.interf.UtilsInterface;
import org.hai.commons.core.math.bean.Ball;
import org.hai.commons.core.math.bean.Coordinate;

/**
 * <p>
 * 这是一个几何工具类
 * </p>
 * Create Date: 2015年12月8日
 * Last Modify: 2016年5月26日
 * 
 * @author <a href="http://weibo.com/u/5131020927">Q-WHai</a>
 * @see <a href="http://blog.csdn.net/lemon_tree12138">http://blog.csdn.net/lemon_tree12138</a>
 * @version 0.1.1
 */
public class GeometryUtils implements UtilsInterface {

    // 工具类，禁止实例化
    private GeometryUtils() throws CannotInstanceException {
        throw new CannotInstanceException("请不要试图实例化我");
    }
    
    @Override
    public String getTag() {
        return getClass().getName();
    }

    @Override
    public void description() {
        System.out.println("我是的一个几何工具类");
    }

    /**
     * 计算空间中两个点坐标之间的距离
     * 
     * @param c1
     *      点坐标
     * @param c2
     *      点坐标
     * @return
     *      距离
     */
    public static double distance(Coordinate c1, Coordinate c2) {
        double diffX = c1.getX() - c2.getX();
        double diffY = c1.getY() - c2.getY();
        double diffZ = c1.getZ() - c2.getZ();
        
        double distance = Math.sqrt(diffX * diffX + diffY * diffY + diffZ * diffZ);
        
        return distance;
    }
    
    // TODO ------------------------------------------- 内部类标识分隔线 ----------------------------------------------------------
    
    /**
     * <p>
     * 三角形
     * </p>
     * 2015年12月9日
     * 
     * @author <a href="http://weibo.com/u/5131020927">Q-WHai</a>
     * @see <a href="http://blog.csdn.net/lemon_tree12138">http://blog.csdn.net/lemon_tree12138</a>
     * @version 0.1
     */
    public static class TriangleUtils implements UtilsInterface {
        
        // 工具类，禁止实例化
        private TriangleUtils() throws CannotInstanceException {
            throw new CannotInstanceException("请不要实例化我");
        }
        
        @Override
        public String getTag() {
            return getClass().getName();
        }

        @Override
        public void description() {
            System.out.println("我是负责处理三角形的工具类");
        }
        
        /**
         * 判断3条线段是否可以构成三角形
         * 
         * @param a
         *      边长
         * @param b
         *      边长
         * @param c
         *      边长
         * @return
         *      能否构成三角形
         */
        public static boolean isTriangle(double a, double b, double c) {
            if (a <= 0 || b <= 0 || c <= 0) {
                return false;
            }
            
            boolean f1 = a + b > c;
            boolean f2 = a + c > b;
            boolean f3 = b + c > a;
            
            if (f1 && f2 && f3) {
                return true;
            }
            
            return false;
        }
        
        /**
         * 计算一个三角形的面积
         * 
         * @param a
         *      边长
         * @param b
         *      边长
         * @param c
         *      边长
         * @return
         *      面积
         * @throws CannotBeTriangleException 
         *      不构成三角形异常
         */
        public static double area(double a, double b, double c) throws CannotBeTriangleException {
            if (!isTriangle(a, b, c)) {
                throw new CannotBeTriangleException("不能组成三角形");
            }
            
            double p = (a + b + c) / 2;
            return Math.sqrt(p * (p -a) * (p -b) * (p -c));
        }
    }
    
    // TODO ------------------------------------------- 内部类标识分隔线 ----------------------------------------------------------
    
    /**
     * <p>
     * 圆形
     * </p>
     * 2015年12月9日
     * 
     * @author <a href="http://weibo.com/u/5131020927">Q-WHai</a>
     * @see <a href="http://blog.csdn.net/lemon_tree12138">http://blog.csdn.net/lemon_tree12138</a>
     * @version 0.1
     */
    public static class CircularUtils implements UtilsInterface {
        
        // 工具类，禁止实例化
        private CircularUtils() throws CannotInstanceException {
            throw new CannotInstanceException("请不要试图实例化我");
        }
        
        @Override
        public String getTag() {
            return getClass().getName();
        }

        @Override
        public void description() {
            System.out.println("我是处理圆形的工具类");
        }
        
        /**
         * 计算一个圆形的面积
         * 
         * @param r
         *      半径
         * @return
         *      面积
         * @throws ShapeException
         *      形状异常
         */
        public static double area(double r) throws ShapeException {
            if (r < 0) {
                throw new ShapeException("");
            }
            
            return Math.PI * r * r;
        }
    }
    
    // TODO ------------------------------------------- 内部类标识分隔线 ----------------------------------------------------------
    
    /**
     * <p>
     * 球形
     * </p>
     * 2015年12月9日
     * 
     * @author <a href="http://weibo.com/u/5131020927">Q-WHai</a>
     * @see <a href="http://blog.csdn.net/lemon_tree12138">http://blog.csdn.net/lemon_tree12138</a>
     * @version 0.1
     */
    public static class BallUtils implements UtilsInterface {

        // 工具类，禁止实例化
        private BallUtils() throws CannotInstanceException {
            throw new CannotInstanceException("请不要试图实例化我");
        }
        
        @Override
        public String getTag() {
            return getClass().getName();
        }

        @Override
        public void description() {
            System.out.println("我是一个处理球形的工具类");
        }
        
        @Deprecated
        public static double area(Ball ball) throws ShapeException {
            if (ball.getRadius() < 0) {
                throw new ShapeException("我不能构成一个球");
            }
            
            return Math.PI * ball.getRadius() * ball.getRadius() * ball.getRadius();
        }
    }
}
