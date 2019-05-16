package pers.hai.util.commons.math.bean.factory;

import pers.hai.util.commons.math.bean.Triangle;
import pers.hai.util.commons.math.bean.interf.Curve;
import pers.hai.util.commons.math.bean.interf.Angle;

/**
 * <p>
 * 具体生产有角几何体的工厂
 * </p>
 * Create Date: 2015年12月10日
 * Last Modify: 2016年5月26日
 * 
 * @author Q-WHai
 * @see <a href="https://github.com/qwhai">https://github.com/qwhai</a>
 */
public class AngleFactory extends ShapeFactory {

    @Override
    public Angle createAngle() {
        return new Triangle();
    }

    @Override
    public Curve createCurve() {
        // TODO Auto-generated method stub
        return null;
    }


}
