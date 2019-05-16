package pers.hai.util.commons.math.bean.factory;

import pers.hai.util.commons.math.bean.Ball;
import pers.hai.util.commons.math.bean.interf.Angle;
import pers.hai.util.commons.math.bean.interf.Curve;

/**
 * <p>
 * 具体生产有弧形几何体的工厂
 * </p>
 * Create Date: 2015年12月10日
 * Last Modify: 2016年5月26日
 * 
 * @author Q-WHai
 * @see <a href="https://github.com/qwhai">https://github.com/qwhai</a>
 */
public class CurveFactory extends ShapeFactory {

    @Override
    public Angle createAngle() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Curve createCurve() {
        return new Ball();
    }

}
