package pers.hai.util.commons.math.bean;

import pers.hai.util.commons.math.bean.interf.Curve;

/**
 * <p>
 * 球形
 * </p>
 * Create Date: 2015年12月9日
 * Last Modify: 2016年5月26日
 * 
 * @author Q-WHai
 * @see <a href="https://github.com/qwhai">https://github.com/qwhai</a>
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
