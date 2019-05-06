package org.hai.commons.core.containers;

import org.core.utils.interf.UtilsInterface;

/**
 * <p>
 * 与容器相关的工具类
 * </p>
 * Create Date: 2015‎年‎11‎月‎25‎日
 * Last Modify: 2016年5月26日
 * 
 * @author <a href="http://weibo.com/u/5131020927">Q-WHai</a>
 * @see <a href="http://blog.csdn.net/lemon_tree12138">http://blog.csdn.net/lemon_tree12138</a>
 * @version 0.1.1
 */
class ContainerUtils implements UtilsInterface {

    @Override
    public String getTag() {
        return this.getClass().getName();
    }

    @Override
    public void description() {
        System.out.println("与容器相关的工具类");
    }

}
