/**
 * <p>
 * 使用字典树实现拼音的智能切分
 * </p>
 * 
 * @author <a href="http://weibo.com/u/5131020927">Q-WHai</a>
 * @see <a href="http://blog.csdn.net/lemon_tree12138">http://blog.csdn.net/lemon_tree12138</a>
 * @version 0.1
 */
package org.utils.naga.str.spell;

import java.io.IOException;
import java.util.List;

import org.utils.naga.files.FileReadUtils;

/**
 * 使用教程
 */
class SpellTest {

    static SpellTrie tree = new SpellTrie("spell");
    
    public static void main(String[] args) {
        String spell = "qinshimingyuezhijunlintianxia";
        try {
            initSpells();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        System.out.println(tree.splitSpell(spell));
    }
    
    private static void initSpells() throws IOException {
        List<String> spells = FileReadUtils.readLines("./data/spell.txt");
        for (int i = 0; i < spells.size(); i++) {
            tree.insert(spells.get(i));
        }
    }
}