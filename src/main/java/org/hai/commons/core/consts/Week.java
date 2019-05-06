package org.hai.commons.core.consts;

/**
 * <p>
 * 星期枚举
 * </p>
 * Create Date: 2015年12月3日
 * Last Modify: 2016年5月26日
 * 
 * @author <a href="http://weibo.com/u/5131020927">Q-WHai</a>
 * @see <a href="http://blog.csdn.net/lemon_tree12138">http://blog.csdn.net/lemon_tree12138</a>
 * @version 0.1.1
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
