package pers.hai.util.commons;

import org.junit.Assert;
import org.junit.Test;

/**
 * @Author: Q-WHai
 * @Date: Created in 18:31 2019/05/10
 */
public class CharUtilsTest extends Testable {

    @Test
    public void test1() {
        Assert.assertTrue(CharUtils.isNumberChar('0'));
        Assert.assertTrue(CharUtils.isNumberChar('1'));
        Assert.assertTrue(CharUtils.isNumberChar('2'));
        Assert.assertTrue(CharUtils.isNumberChar('3'));
        Assert.assertTrue(CharUtils.isNumberChar('4'));
        Assert.assertTrue(CharUtils.isNumberChar('5'));
        Assert.assertTrue(CharUtils.isNumberChar('6'));
        Assert.assertTrue(CharUtils.isNumberChar('7'));
        Assert.assertTrue(CharUtils.isNumberChar('8'));
        Assert.assertTrue(CharUtils.isNumberChar('9'));
        Assert.assertFalse(CharUtils.isNumberChar('a'));
        Assert.assertFalse(CharUtils.isNumberChar('!'));
        Assert.assertFalse(CharUtils.isNumberChar('#'));
        Assert.assertFalse(CharUtils.isNumberChar('中'));
    }

    @Test
    public void test2() {
        Assert.assertTrue(CharUtils.isCapital('Z'));
        Assert.assertFalse(CharUtils.isCapital('z'));
    }

    @Test
    public void test3() {
        Assert.assertTrue(CharUtils.isLowercase('a'));
        Assert.assertFalse(CharUtils.isLowercase('A'));
    }

    @Test
    public void test4() {
        Assert.assertTrue(CharUtils.isLetter('a'));
        Assert.assertTrue(CharUtils.isLetter('A'));
        Assert.assertFalse(CharUtils.isLetter('@'));
    }
}
