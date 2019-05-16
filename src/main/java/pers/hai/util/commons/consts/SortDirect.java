package pers.hai.util.commons.consts;

/**
 * 数组的排序方向
 *
 * Create Date: 2016-01-18
 * Last Modify: 2016-05-26
 * 
 * @author Q-WHai
 * @see <a href="https://github.com/qwhai">https://github.com/qwhai</a>
 */
public enum SortDirect {

    ASC("升序"),
    DESC("降序");
    
    private String desc;
    
    SortDirect(String _desc) {
        this.desc = _desc;
    }
    
    public String getDesc() {
        return desc;
    }
}
