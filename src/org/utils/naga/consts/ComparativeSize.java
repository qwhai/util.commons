package org.utils.naga.consts;

/**
 * <p>
 * 大小比较的结果值
 * </p>
 * 2015年12月9日
 * 
 * @author <a href="http://weibo.com/u/5131020927">Q-WHai</a>
 * @see <a href="http://blog.csdn.net/lemon_tree12138">http://blog.csdn.net/lemon_tree12138</a>
 * @version 0.1.1
 */
public enum ComparativeSize {

    /** 大于 */
    Bigger("大"),
    
    /** 相等 */
    Equal("相等"),
    
    /** 小于 */
    Small("小");
    
    private String desc;
    
    ComparativeSize(String _desc) {
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
