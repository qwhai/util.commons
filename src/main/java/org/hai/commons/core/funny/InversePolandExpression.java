package org.hai.commons.core.funny;

import org.hai.commons.core.excep.CannotInstanceException;
import org.core.utils.interf.UtilsInterface;

/**
 * <p>
 * 逆波兰表达式的计算
 * </p>
 * Create Date: 2015年12月9日
 * Last Modify: 2016年5月26日
 * 
 * @author <a href="http://weibo.com/u/5131020927">Q-WHai</a>
 * @see <a href="http://blog.csdn.net/lemon_tree12138">http://blog.csdn.net/lemon_tree12138</a>
 * @version 0.1.1
 */
public final class InversePolandExpression implements UtilsInterface {

    // 工具类，禁止实例化
    private InversePolandExpression() throws CannotInstanceException {
        throw new CannotInstanceException("请不要试图实例化我");
    }
    
    @Override
    public String getTag() {
        return getClass().getName();
    }

    @Override
    public void description() {
        System.out.println("你可以通过我来计算逆波兰表达式.逆波兰表达式的格式如下：\n* + 11.0 12.0 + 24.0 35.0\n+ / + 5.0 3.0 + 1.0 2.0 6.0");
    }
    
    /**
     * 计算逆波兰表达式的结果
     * 
     * @param polandExp
     *      逆波兰表达式
     * @return
     *      计算结果
     */
    public static double inversePolandResult(String polandExp) {
        String[] ops = polandExp.split(" ");
        String[] stack = new String[ops.length];
        int stackIndex = 0;
        for (int i = 0; i < ops.length; i++) {
            if (isOperator(ops[i])) {
                stack[stackIndex++] = ops[i];
            } else {
                if (isOperator(stack[stackIndex - 1])) {
                    stack[stackIndex++] = ops[i];
                } else {
                    double num1 = Double.parseDouble(stack[--stackIndex]);
                    String op = stack[--stackIndex];
                    stack[stackIndex++] = String.valueOf(getResult(num1, op, Double.parseDouble(ops[i])));
                    
                    if (stackIndex >= 2) {
                        if (!isOperator(stack[stackIndex - 2])) {
                            double num2 = Double.parseDouble(stack[--stackIndex]);
                            num1 = Double.parseDouble(stack[--stackIndex]);
                            op = stack[--stackIndex];
                            stack[stackIndex++] = String.valueOf(getResult(num1, op, num2));
                        }
                    }
                }
            }
        }
        
        return Double.parseDouble(stack[--stackIndex]);
    }
    
    // 计算两个数的运算结果
    private static double getResult(double num1, String op, double num2) {
        if (isAddition(op)) {
            return num1 + num2;
        }
        if (isSubtraction(op)) {
            return num1 - num2;
        }
        if (isMultiplication(op)) {
            return num1 * num2;
        }
        if (isDivision(op)) {
            return num1 / num2;
        }
        
        return 0;
    }
    
    // 是运算符
    private static boolean isOperator(String op) {
        if (isAddition(op) || isSubtraction(op) || isMultiplication(op) || isDivision(op)) {
            return true;
        }
        
        return false;
    }
    
    // + 操作
    private static boolean isAddition(String op) {
        if (op.equals("+")) {
            return true;
        }
        
        return false;
    }
    
    // - 操作
    private static boolean isSubtraction(String op) {
        if (op.equals("-")) {
            return true;
        }
        
        return false;
    }
    
    // * 操作
    private static boolean isMultiplication(String op) {
        if (op.equals("*")) {
            return true;
        }
        
        return false;
    }
    
    // / 操作
    private static boolean isDivision(String op) {
        if (op.equals("/")) {
            return true;
        }
        
        return false;
    }
}