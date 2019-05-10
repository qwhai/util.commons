package org.commons.cabinet.consts;

/**
 * <p>
 * 季节枚举
 * </p>
 * Create Date: 2015年12月3日
 * Last Modify: 2016年5月26日
 * 
 * @author Q-WHai
 * @see <a href="https://github.com/qwhai">https://github.com/qwhai</a>
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
