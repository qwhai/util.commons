package org.commons.cabinet.consts;

/**
 * 程序当前状态
 *
 * Create Date: 2015-12-15
 * Last Modify: 2016-05-26
 * 
 * @author Q-WHai
 * @see <a href="https://github.com/qwhai">https://github.com/qwhai</a>
 */
public enum CodingStatus {

    /** 调度状态 */
    Debug("调试状态"),
    
    /** 执行状态 */
    Running("执行");
    
    private String desc;
    
    private CodingStatus(String _desc) {
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
