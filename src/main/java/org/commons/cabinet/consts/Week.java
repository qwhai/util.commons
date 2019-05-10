package org.commons.cabinet.consts;

/**
 * 星期枚举
 *
 * Create Date: 2015-12-03
 * Last Modify: 2016-05-26
 * 
 * @author Q-WHai
 * @see <a href="https://github.com/qwhai">https://github.com/qwhai</a>
 */
public enum Week {

    /** 周日 */
    Sunday("周日"),
    
    /** 周一 */
    Monday("周一"),
    
    /** 周二 */
    Tuesday("周二"),
    
    /** 周三 */
    Wednesday("周三"),
    
    /** 周四 */
    Thursday("周四"),
    
    /** 周五 */
    Friday("周五"),
    
    /** 周六 */
    Saturday("周六");
    
    private String desc;
    
    Week(String _desc) {
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
