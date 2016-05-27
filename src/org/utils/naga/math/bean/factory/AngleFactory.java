package org.utils.naga.math.bean.factory;

import org.utils.naga.math.bean.Triangle;
import org.utils.naga.math.bean.interf.Angle;
import org.utils.naga.math.bean.interf.Curve;

/**
 * <p>
 * 具体生产有角几何体的工厂
 * </p>
 * Create Date: 2015年12月10日
 * Last Modify: 2016年5月26日
 * 
 * @author <a href="http://weibo.com/u/5131020927">Q-WHai</a>
 * @see <a href="http://blog.csdn.net/lemon_tree12138">http://blog.csdn.net/lemon_tree12138</a>
 * @version 0.1.1
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
