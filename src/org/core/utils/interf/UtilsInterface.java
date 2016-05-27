package org.core.utils.interf;

/**
 * <p>
 * 这个是一个工具类都要实现的接口
 * </p>
 * Create Date: 2015年11月25日
 * Last Modify: 2016年5月26日
 * 
 * @author <a href="http://weibo.com/u/5131020927">Q-WHai</a>
 * @see <a href="http://blog.csdn.net/lemon_tree12138">http://blog.csdn.net/lemon_tree12138</a>
 * @version 0.1.1
 */
public interface UtilsInterface {

    /**
     * 获得类的Tag(这里即名类)
     * 
     * @return
     *      Tag
     */
    public String getTag();
    
    /**
     * 打印当前类的描述
     */
    public void description();
}
