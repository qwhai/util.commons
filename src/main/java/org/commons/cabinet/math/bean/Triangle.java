package org.commons.cabinet.math.bean;

import org.commons.cabinet.math.bean.interf.Angle;

/**
 * <p>
 * 三角形
 * </p>
 * Create Date: 2015年12月8日
 * Last Modify: 2016年5月26日
 * 
 * @author Q-WHai
 * @see <a href="https://github.com/qwhai">https://github.com/qwhai</a>
 */
public class Triangle implements Angle {

    // 三边
    private double edgeA;
    private double edgeB;
    private double edgeC;

    // 三点
    private Coordinate pointA;
    private Coordinate pointB;
    private Coordinate pointC;
    
    public double getEdgeA() {
        return edgeA;
    }

    public void setEdgeA(double edgeA) {
        this.edgeA = edgeA;
    }

    public double getEdgeB() {
        return edgeB;
    }

    public void setEdgeB(double edgeB) {
        this.edgeB = edgeB;
    }

    public double getEdgeC() {
        return edgeC;
    }

    public void setEdgeC(double edgeC) {
        this.edgeC = edgeC;
    }

    public Coordinate getPointA() {
        return pointA;
    }

    public void setPointA(Coordinate pointA) {
        this.pointA = pointA;
    }

    public Coordinate getPointB() {
        return pointB;
    }

    public void setPointB(Coordinate pointB) {
        this.pointB = pointB;
    }

    public Coordinate getPointC() {
        return pointC;
    }

    public void setPointC(Coordinate pointC) {
        this.pointC = pointC;
    }
    
}
