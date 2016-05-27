package org.utils.naga.consts;

/**
 * <p>季节枚举</p>
 * 2015年12月3日
 * 
 * @author <a href="http://weibo.com/u/5131020927">Q-WHai</a>
 * @see <a href="http://blog.csdn.net/lemon_tree12138">http://blog.csdn.net/lemon_tree12138</a>
 * @version 0.1.1
 */
public enum Season {

    /** 春 */
    Spring("春"),
    
    /** 夏 */
    Summer("夏"),
    
    /** 秋 */
    Autumn("秋"),
    
    /** 冬 */
    Winter("冬");
    
    private String desc;
    
    Season(String _desc) {
        desc = _desc;
    }
    
    /**
     * 获得枚举值的描述
     * 
     * @return
     *      描述
     */
    public String getDesc() {
        return desc;
    }
}
