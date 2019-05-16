package pers.hai.util.commons.consts;

/**
 * 季节枚举
 *
 * Create Date: 2015-12-03
 * Last Modify: 2016-05-26
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
