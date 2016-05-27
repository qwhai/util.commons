package org.utils.naga.math.bean;

import org.utils.naga.math.bean.interf.Curve;

/**
 * <p>
 * 球形
 * </p>
 * Create Date: 2015年12月9日
 * Last Modify: 2016年5月26日
 * 
 * @author <a href="http://weibo.com/u/5131020927">Q-WHai</a>
 * @see <a href="http://blog.csdn.net/lemon_tree12138">http://blog.csdn.net/lemon_tree12138</a>
 * @version 0.1.1
 */
public class Ball implements Curve {

    private double radius;
    
    private Coordinate center;

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public Coordinate getCenter() {
        return center;
    }

    public void setCenter(Coordinate center) {
        this.center = center;
    }
    
    public double area() {
        return radius * radius * radius;
    }
}
