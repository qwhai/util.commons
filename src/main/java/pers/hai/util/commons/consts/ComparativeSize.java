package pers.hai.util.commons.consts;

/**
 * 大小比较的结果值
 *
 * Create Date: 2015-12-09
 * Last Modify: 2016-05-26
 * 
 * @author Q-WHai
 * @see <a href="https://github.com/qwhai">https://github.com/qwhai</a>
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
