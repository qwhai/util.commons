package org.utils.naga.math.bean.factory;

import org.utils.naga.math.bean.interf.Angle;
import org.utils.naga.math.bean.interf.Curve;

/**
 * <p>
 * 抽象工厂方法
 * </p>
 * 2015年12月10日
 * 
 * @author <a href="http://weibo.com/u/5131020927">Q-WHai</a>
 * @see <a href="http://blog.csdn.net/lemon_tree12138">http://blog.csdn.net/lemon_tree12138</a>
 * @version 0.1.1
 */
public abstract class ShapeFactory {

    public abstract Angle createAngle();
    
    public abstract Curve createCurve();
}
