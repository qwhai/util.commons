package org.utils.naga.str.spell;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 字典树中的每个节点信息
 * </p>
 * Create Date: 2015年12月9日
 * Last Modify: 2016年5月26日
 * 
 * @author <a href="http://weibo.com/u/5131020927">Q-WHai</a>
 * @see <a href="http://blog.csdn.net/lemon_tree12138">http://blog.csdn.net/lemon_tree12138</a>
 * @version 0.1.1
 */
class LetterNode {

    protected String name; // 结点的字符名称
    protected int fre; // 单词的词频
    protected boolean end; // 是否是单词结尾
    protected boolean root; // 是否是根结点
    protected Map<String, LetterNode> childrens; // 子节点信息

    protected LetterNode(String name) {
        this.name = name;
        if (childrens == null) {
            childrens = new HashMap<String, LetterNode>();
        }
        setFre(0);
        setRoot(false);
        setEnd(false);
    }
    
    protected String getName() {
        return name;
    }

    protected void setName(String name) {
        this.name = name;
    }

    protected int getFre() {
        return fre;
    }

    protected void setFre(int fre) {
        this.fre = fre;
    }

    protected boolean isEnd() {
        return end;
    }

    protected void setEnd(boolean end) {
        this.end = end;
    }

    protected boolean isRoot() {
        return root;
    }

    protected void setRoot(boolean root) {
        this.root = root;
    }

    protected Map<String, LetterNode> getChildrens() {
        return childrens;
    }

    protected void setChildrens(Map<String, LetterNode> childrens) {
        this.childrens = childrens;
    }
}
