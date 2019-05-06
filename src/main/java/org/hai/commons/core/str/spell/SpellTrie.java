package org.hai.commons.core.str.spell;

/**
 * <p>
 * 拼音字典树
 * </p>
 * Create Date: 2015年12月9日
 * Last Modify: 2016年5月26日
 * 
 * @author <a href="http://weibo.com/u/5131020927">Q-WHai</a>
 * @see <a href="http://blog.csdn.net/lemon_tree12138">http://blog.csdn.net/lemon_tree12138</a>
 * @version 0.1.1
 */
public class SpellTrie {

    LetterNode root;
    
    public SpellTrie(String name) {
        root = new LetterNode(name);
        root.setFre(0);
        root.setEnd(false);
        root.setRoot(true);
    }
    
    /**
     * 向字典树中插入一条记录
     * 
     * @param word
     *      插入的拼音
     */
    public void insert(String word) {
        LetterNode node = root;
        char[] words = word.toCharArray();
        for (int i = 0; i < words.length; i++) {
            if (node.getChildrens().containsKey(words[i] + "")) {
                if (i == words.length - 1) {
                    LetterNode endNode = node.getChildrens().get(words[i] + "");
                    endNode.setFre(endNode.getFre() + 1);
                    endNode.setEnd(true);
                }
            } else {
                LetterNode newNode = new LetterNode(words[i] + "");
                if (i == words.length - 1) {
                    newNode.setFre(1);
                    newNode.setEnd(true);
                    newNode.setRoot(false);
                }
                
                node.getChildrens().put(words[i] + "", newNode);
            }
            
            node = node.getChildrens().get(words[i] + "");
        }
    }
    
    /**
     * 检查一个拼音被插入的词频
     * 
     * @param word
     *      关键词
     * @return
     *      频率
     */
    public int searchFre(String word) {
        int fre = -1;
        
        LetterNode node = root;
        char[] words = word.toCharArray();
        for (int i = 0; i < words.length; i++) {
            if (node.getChildrens().containsKey(words[i] + "")) {
                node = node.getChildrens().get(words[i] + "");
                fre = node.getFre();
            } else {
                fre = -1;
                break;
            }
        }
        
        return fre;
    }
    
    /**
     * 将一个句子切分成对应的单个关键词
     * 
     * @param spell
     *      句子
     * @return
     *      单个关键词
     */
    public String splitSpell(String spell) {
        LetterNode node = root;
        char[] letters = spell.toCharArray();
        String spells = "";
        for (int i = 0; i < letters.length; i++) {
            if (node.getChildrens().containsKey(letters[i] + "")) {
                spells += letters[i];
                node = node.getChildrens().get(letters[i] + "");
            } else {
                node = root;
                spells += " ";
                i--;
            }
        }
        
        return spells;
    }
}
