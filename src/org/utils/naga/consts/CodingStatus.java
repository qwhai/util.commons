package org.utils.naga.consts;

/**
 * <p>
 * 程序当前状态
 * </p>
 * 2015年12月15日
 * 
 * @author <a href="http://weibo.com/u/5131020927">Q-WHai</a>
 * @see <a href="http://blog.csdn.net/lemon_tree12138">http://blog.csdn.net/lemon_tree12138</a>
 * @version 0.1.1
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
