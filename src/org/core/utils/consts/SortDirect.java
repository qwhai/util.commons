package org.core.utils.consts;

/**
 * <p>
 * 数组的排序方向
 * </p>
 * Create Date: 2016年1月18日
 * Last Modify: 2016年5月26日
 * 
 * @author <a href="http://weibo.com/u/5131020927">Q-WHai</a>
 * @see <a href="http://blog.csdn.net/lemon_tree12138">http://blog.csdn.net/lemon_tree12138</a>
 * @version 0.1.1
 */
public enum SortDirect {

    ASC("升序"),
    DESC("降序");
    
    private String desc;
    
    private SortDirect(String _desc) {
        this.desc = _desc;
    }
    
    public String getDesc() {
        return desc;
    }
}
