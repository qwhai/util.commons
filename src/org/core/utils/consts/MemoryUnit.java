package org.core.utils.consts;

/**
 * <p>
 * 计算机存储单位的枚举
 * </p>
 * Create Date: 2015年12月14日
 * Last Modify: 2016年5月26日
 * 
 * @author <a href="http://weibo.com/u/5131020927">Q-WHai</a>
 * @see <a href="http://blog.csdn.net/lemon_tree12138">http://blog.csdn.net/lemon_tree12138</a>
 * @version 0.1.1
 */
public enum MemoryUnit {
    
    /** 位 */
    Bit("位"),
    
    /** 字节 */
    Byte("字节"),
    
    /** 千字节 */
    KB("千字节"),
    
    /** 兆字节 */
    MB("兆字节"),
    
    /** 千兆字节 */
    GB("千兆字节"),
    
    /** 太字节 */
    TB("太字节"),
    
    /** PB */
    PB("PB"),
    
    /** EB */
    EB("EB"),
    
    /** ZB */
    ZB("ZB"),
    
    /** YB */
    YB("YB"),
    
    /** NB */
    NB("NB"),
    
    /** DB */
    DB("DB");
    
    private String desc;
    
    MemoryUnit(String _desc) {
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
