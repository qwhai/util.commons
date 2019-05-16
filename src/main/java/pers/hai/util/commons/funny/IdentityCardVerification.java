package pers.hai.util.commons.funny;

import pers.hai.util.commons.chars.CharUtils;
import pers.hai.util.commons.excep.CannotInstanceException;
import pers.hai.util.commons.nums.RandomUtils;

/**
 * <p>
 * 身份证号码验证
 * </p>
 * Create Date: 2015‎年‎11‎月‎27‎日
 * Last Modify: 2016年5月26日
 * 
 * @author Q-WHai
 * @see <a href="https://github.com/qwhai">https://github.com/qwhai</a>
 */
public final class IdentityCardVerification {

    // 禁止初始化
    private IdentityCardVerification() throws CannotInstanceException {
        throw new CannotInstanceException("请不要试图初始化我");
    }

    private static final int[] WEIGHT = {7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};
    private static final char[] CHECK = {'1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2'};

    /**
     * 身份证号码验证
     * 
     * @param cardNumber
     *      身份证号码
     * @return
     *      身份证号码是否正确
     */
    public static boolean isLegalIdentityCardNumber(String cardNumber) {
        char[] idNumbers = cardNumber.toCharArray();
        int sum = 0;
        boolean allNumber = true;
        for (int i = 0; i < idNumbers.length - 1; i++) {
            if (CharUtils.isNumberChar(idNumbers[i])) {
                sum += (Integer.parseInt(String.valueOf(idNumbers[i])) * WEIGHT[i]);
            } else {
                allNumber = false;
                break;
            }
        }
        
        if (allNumber) {
            sum %= 11;
            if (idNumbers[idNumbers.length - 1] != CHECK[sum]) {
                return false;
            }
        } else {
            return false;
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        String prefix = "34082319900223";
        RandomUtils random = new RandomUtils();
        while(true) {
            int suff = random.nextInt(1000, 9999);
            if (isLegalIdentityCardNumber(prefix + suff)) {
                System.out.println(prefix + suff);
                break;
            }
        }
    }
    
    /**
     * 随机生成一个身份证号码
     * 
     * @return
     *      身份证号码
     */
    public static String randomIdentityCardNumber() {
        // TODO 待完成
        return null;
    }
}