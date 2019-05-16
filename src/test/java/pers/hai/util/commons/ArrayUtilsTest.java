package pers.hai.util.commons;

import pers.hai.util.commons.containers.ArrayUtils;
import pers.hai.util.commons.excep.LengthZeroException;
import pers.hai.util.commons.excep.NotNumberException;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description TODO
 * @Author Q-WHai
 * @Date 2019/5/11 10:35
 */
public class ArrayUtilsTest extends Testable {

    @Test
    public void test1() {
        String[] arr = new String[]{
                "1234", "567", "89", "abc", "def"
        };

        List<String> list = new ArrayList<>();
        ArrayUtils.copyToList(list, arr);
        logger.info(list);
    }

    @Test
    public void test2() {
        Integer[] arr = new Integer[]{
                12, 22, 1, 2, 45, 6, 7, 9
        };

        List<Integer> list = new ArrayList<>();
        ArrayUtils.copyToList(list, arr);
        logger.info(list);
    }

    @Test
    public void test3() {
        String[] arr = new String[] {};

        List<String> list = new ArrayList<>();
        ArrayUtils.copyToList(list, arr);
        logger.info(list);
    }

    @Test
    public void test4() {
        String[] arr = new String[]{
                "1234", "567", "89", "abc", "def"
        };

        List<String> list = new ArrayList<>();
        ArrayUtils.copyToList(list, arr, 3, 5);
        logger.info(list);
    }

    @Test
    public void test5() {
        Integer[] arr = new Integer[]{
                12, 22, 1, 2, 45, 6, 7, 9
        };

        List<Integer> list = new ArrayList<>();
        ArrayUtils.copyToList(list, arr, 3, 5);
        logger.info(list);
    }

    @Test
    public void test6() {
        String[] arr = new String[]{
                "1234", "567", "89", "abc", "def", "ghi"
        };

        List<String> list = new ArrayList<>();
        ArrayUtils.copyToList(list, arr, 3, 2);
        logger.info(list);
    }

    @Test
    public void test7() {
        Integer[] arr = new Integer[]{
                12, 22, 1, 2, 45, 6, 7, 9
        };

        List<Integer> list = new ArrayList<>();
        ArrayUtils.copyToList(list, arr, 3, 2);
        logger.info(list);
    }

    @Test
    public void test8() {
        String[] arr = new String[]{
                "1234", "567", "89", "abc", "def", "ghi"
        };

        List<String> list = new ArrayList<>();
        ArrayUtils.copyToList(list, arr, 3);
        logger.info(list);
    }

    @Test
    public void test9() {
        Integer[] arr = new Integer[]{
                12, 22, 1, 2, 45, 6, 7, 9
        };

        List<Integer> list = new ArrayList<>();
        ArrayUtils.copyToList(list, arr, 3);
        logger.info(list);
    }

    @Test
    public void test10() {
        int[] arr = new int[]{
                4, 3, 1, 8, 9, 0, -1, 4
        };

        try {
            Assert.assertEquals(9, ArrayUtils.maxValue(arr));
        } catch (LengthZeroException ex) {
            ex.printStackTrace();
        }
    }

    @Test
    public void test11() {
        long[] arr = new long[]{
                4L, 3L, 1L, 8L, 9L, 0L, -1L, 4L
        };

        try {
            Assert.assertEquals(9L, ArrayUtils.maxValue(arr));
        } catch (LengthZeroException ex) {
            ex.printStackTrace();
        }
    }

    @Test
    public void test12() {
        double[] arr = new double[]{
                4.4, 3.1, 1.2, 8.4, 9.1, 0.6, -1, 4.7, 1.1
        };

        try {
            Assert.assertEquals(9.1, ArrayUtils.maxValue(arr), 0);
        } catch (LengthZeroException ex) {
            ex.printStackTrace();
        }
    }

    @Test
    public void test13() {
        float[] arr = new float[]{
                4.4f, 3.1f, 1.2f, 8.4f, 9.1f, 0.6f, -1f, 4.7f, 1.1f
        };

        try {
            Assert.assertEquals(9.1f, ArrayUtils.maxValue(arr), 0);
        } catch (LengthZeroException ex) {
            ex.printStackTrace();
        }
    }

    @Test
    public void test14() {
        String[] arr = new String[]{
                "4", "3", "1", "8", "9", "0", "-1", "4"
        };

        try {
            Assert.assertEquals("9", ArrayUtils.maxValue(arr));
        } catch (LengthZeroException ex) {
            ex.printStackTrace();
        }
    }

    @Test
    public void test15() {
        int[] arr = new int[]{
                1, 1, 9, -1, -5, 1, 2, 4, 6, -1, -4, 9
        };

        int sum = ArrayUtils.maxSum(arr);
        Assert.assertEquals(22, sum);
    }

    @Test
    public void test16() {
        long[] arr = new long[]{
                1L, 1L, 9L, -1L, -5L, 1L, 2L, 4L, 6L, -1L, -4L, 9L
        };

        long sum = ArrayUtils.maxSum(arr);
        Assert.assertEquals(22L, sum);
    }

    @Test
    public void test17() {
        double[] arr = new double[]{
                1.0, 1.2, 9, -1, -5, 1, 2, 4, 6, -1, -4, 9
        };

        double sum = ArrayUtils.maxSum(arr);
        Assert.assertEquals(22.2, sum, 0);
    }

    @Test
    public void test18() {
        float[] arr = new float[]{
                1.0f, 1.2f, 9f, -1f, -5f, 1f, 2f, 4f, 6f, -1f, -4f, 9f
        };

        float sum = ArrayUtils.maxSum(arr);
        Assert.assertEquals(22.2f, sum, 0);
    }

    @Test
    public void test19() {
        try {
            int[] arr = ArrayUtils.transfromToIntegerArray("1234243532314123");
            ArrayUtils.show(arr);
        } catch (NotNumberException ex) {
            ex.printStackTrace();
        }
    }
}
