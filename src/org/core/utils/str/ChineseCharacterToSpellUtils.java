package org.core.utils.str;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.core.utils.excep.CannotInstanceException;
import org.core.utils.interf.UtilsInterface;

/**
 * <p>
 * 拼音转换类
 * </p>
 * <p>
 * 来源：网络 + 个人更正
 * </p>
 * Create Date: 2015年10月14日
 * Last Modify: 2016年5月26日
 * 
 * @author <a href="http://weibo.com/u/5131020927">Q-WHai</a>
 * @see <a href="http://blog.csdn.net/lemon_tree12138">http://blog.csdn.net/lemon_tree12138</a>
 * @version 0.1.2
 */
public class ChineseCharacterToSpellUtils implements UtilsInterface {

    // 工具类，禁止实例化
    private ChineseCharacterToSpellUtils() throws CannotInstanceException {
        throw new CannotInstanceException("请不要试图实例化我");
    }
    
    @Override
    public String getTag() {
        return getClass().getName();
    }

    @Override
    public void description() {
        System.out.println("这里一个拼音转换的工具类，你可以通过此工具类，把一个字符串(中文)转换成对应的拼音.");
    }

    /**
     * 将字符串转换为拼音
     * 
     * @param cnStr
     *      字符串文本
     * @return
     *      拼音字符串
     */
    public static String toSpell(String cnStr) {
        if (StringUtils.isEmpty(cnStr)) {
            return cnStr;
        }

        char[] chars = cnStr.toCharArray();
        StringBuffer retuBuf = new StringBuffer();
        for (int i = 0, len = chars.length; i < len; i++) {
            String ascii = getCnAscii(chars[i]);
            if (ascii.length() == 0) {
                retuBuf.append(chars[i]);
            } else {
                String[] spell = getSpellByAscii(ascii);
                if (spell == null) {
                    char firstChar = chars[i];
                    if ((firstChar >= 48 && firstChar <= 57)
                            || (firstChar >= 65 && firstChar <= 90)
                            || (firstChar >= 97 && firstChar <= 122)) {
                        retuBuf.append(firstChar);
                    }
                } else {
                    ArrayList<String> spellList = new ArrayList<String>();
                    for (int j = 0; j < spell.length; j++) {
//                        retuBuf.append(spell[j]);
                        spellList.add(spell[j]);
                    }
                    retuBuf.append(spellList.toString());
                }
            }
        }

        return retuBuf.toString();
    }

    /**
     * 将每个分词的首字符转换为拼音
     * 
     * @param cnStr
     *      字符串文本
     * @return
     *      拼音
     */
    public static List<List<String>> getFirstSpell(String cnStr) {
        if (StringUtils.isEmpty(cnStr)) {
            return null;
        }

        char[] chars = cnStr.toCharArray();
        List<List<String>> spells = new ArrayList<List<String>>();
        for (int i = 0, len = chars.length; i < len; i++) {
            String ascii = getCnAscii(chars[i]);
            char[] firstChar = null;
            if (ascii.length() == 1) {
                firstChar = new char[1];
                firstChar[0] = chars[i];
            } else {
                String[] spell = getSpellByAscii(ascii);
                if (spell == null || "".equals(cnStr.trim())) {
                    firstChar = new char[1];
                    firstChar[0] = chars[i];
                } else {
                    try {
                        // 对多音字筛选
                        firstChar = new char[spell.length];
                        for (int j = 0; j < spell.length; j++) {
                            firstChar[j] = spell[j].charAt(0);
                        }
                    } catch (Exception e) {
                        firstChar[0] = " ".toCharArray()[0];
                    }

                }
            }
            
            List<String> charSpells = new ArrayList<String>();
            for (int j = 0; j < firstChar.length; j++) {
                if (charSpells.contains(firstChar[j] + "")) {
                   continue; 
                }
                if ((firstChar[j] >= 48 && firstChar[j] <= 57)
                        || (firstChar[j] >= 65 && firstChar[j] <= 90)
                        || (firstChar[j] >= 97 && firstChar[j] <= 122)) {
                    charSpells.add(firstChar[j] + "");
                }
            }
            
            spells.add(charSpells);
        }
        
        return spells;
    }

    /**
     * 将字符串的首字母转换为拼音
     * 
     * @param cnStr
     *      字符串文本
     * @return
     *      拼音
     */
    public static List<String> getFirstWordSpell(String cnStr) {
        if (StringUtils.isEmpty(cnStr)) {
            return null;
        }

        char[] chars = cnStr.toCharArray();
        List<String> firstWordSpells = new ArrayList<String>();
        for (int i = 0, len = chars.length; i < len; i++) {
            String ascii = getCnAscii(chars[i]);
            if (ascii.length() == 1) {
                firstWordSpells.add(ascii);
            } else {

                String[] spell = getSpellByAscii(ascii);

                if (spell == null || "".equals(cnStr.trim())) {
                    continue;
                } else {
                    for (int j = 0; j < spell.length; j++) {
                        if (!firstWordSpells.contains(String.valueOf(spell[j].charAt(0)))) {
                            firstWordSpells.add(String.valueOf(spell[j].charAt(0)));
                        }
                    }
                    
                    break;
                }
            }
        }
        
        return firstWordSpells;
    }

    // 获得某一个字符(中文)的拼音
    private static String getCnAscii(char cn) {
        byte[] bytes;
        try {
            bytes = (String.valueOf(cn)).getBytes("GBK");
            if (bytes == null || bytes.length > 2 || bytes.length <= 0) {
                return "";
            }
            if (bytes.length == 1) {
                return new String(bytes);
            }
            if (bytes.length == 2) {
                int hightByte = 256 + bytes[0];
                int lowByte = 256 + bytes[1];

                String ascii = hightByte + "-" + lowByte;

                return ascii;
            }
        } catch (UnsupportedEncodingException e) {
            return "";
        }

        return "";
    }

    /**
     * 通过字符的ASCII码获得字符的拼音
     * 
     * @param ascii
     *      字符的ASCII码
     * @return
     *      拼音
     * @throws UnsupportedEncodingException
     *      编码支持异常
     */
    public static String getCharByAscii(String ascii) throws UnsupportedEncodingException {
        String[] bytesLabel = ascii.split("-");
        int hightByte = Integer.parseInt(bytesLabel[0]);
        int lowByte = Integer.parseInt(bytesLabel[1]);
        byte[] bytes = new byte[2];
        bytes[0] = (byte) (hightByte - 256);
        bytes[1] = (byte) (lowByte - 256);
        String c = new String(bytes, "GBK");
        return c;
    }
    
    // 通过字符串的ASCII码获得字符串的拼音
    private static String[] getSpellByAscii(String ascii) {
        if (ascii.indexOf("-") > -1) {
            if (ChineseCharacterAsciiLib.spellMap.containsKey(ascii)) {
                String spell = (String) ChineseCharacterAsciiLib.spellMap.get(ascii);
                String[] spells = spell.split(",");
                return spells;
            }
            return new String[]{ascii};
        } else {
            return new String[]{ascii};
        }
    }

}
