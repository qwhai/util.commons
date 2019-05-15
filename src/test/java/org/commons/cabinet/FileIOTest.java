package org.commons.cabinet;

import org.commons.cabinet.io.FileIO;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * TODO
 *
 * Create Time: 18:29 2019/05/15
 * Last Modify: 2019/05/15
 *
 * @author Q-WHai
 * @see <a href="https://github.com/qwhai">https://github.com/qwhai</a>
 */
public class FileIOTest extends Testable {

    @Test
    public void test1() {
        try {
            List<String> lines = FileIO.readLines("H:\\1\\cms.sql");
            for (String line : lines) {
                logger.info(line);
            }
        } catch (IOException ex) {
            logger.error(ex.getMessage());
        }
    }

    @Test
    public void test2() {
        try {
            byte[] data = FileIO.read("H:\\1\\cms.sql");
            logger.info(String.format("%d", data.length));
        } catch (IOException ex) {
            logger.error(ex.getMessage());
        }
    }

    @Test
    public void test3() {
        try {
            String data = FileIO.read2String("H:\\1\\cms.sql");
            logger.info(String.format("%s", data));
        } catch (IOException ex) {
            logger.error(ex.getMessage());
        }
    }

    @Test
    public void test4() {
        Assert.assertTrue(FileIO.exists("E:\\tmp\\settings.zip"));
        Assert.assertFalse(FileIO.exists("E:\\tmp\\settings2.zip"));
        Assert.assertFalse(FileIO.exists("E:\\tmp2"));
        Assert.assertTrue(FileIO.exists("E:\\tmp"));
    }

    @Test
    public void test5() {
        try {
            Assert.assertTrue(FileIO.createNewFile("E:\\tmp\\111.txt"));
            Assert.assertFalse(FileIO.createNewFile("E:\\tmp\\111.txt"));
        } catch (IOException ex) {
            logger.error(ex.getMessage());
        }
    }

    @Test
    public void test6() {
        try {
            FileIO.write("E:\\tmp\\111.txt", "abc中文文本".getBytes(StandardCharsets.UTF_8));
        } catch (IOException ex) {
            logger.error(ex.getMessage());
        }
    }

    @Test
    public void test7() {
        try {
            FileIO.write("E:\\tmp\\111.txt", "哈哈哈，这是一行中文文本");
        } catch (IOException ex) {
            logger.error(ex.getMessage());
        }
    }

    @Test
    public void test8() {
        try {
            FileIO.append("E:\\tmp\\111.txt", "这是一行中文");
        } catch (IOException ex) {
            logger.error(ex.getMessage());
        }
    }

    @Test
    public void test9() {
        try {
            FileIO.append("E:\\tmp\\111.txt", "这是一行中文".getBytes(StandardCharsets.UTF_8));
        } catch (IOException ex) {
            logger.error(ex.getMessage());
        }
    }

    @Test
    public void test10() {
        try {
            long millis = FileIO.lastModified("E:\\tmp\\111.txt");
            logger.info(millis);
        } catch (IOException ex) {
            logger.error(ex.getMessage());
        }
    }

    @Test
    public void test11() {
        File[] files = FileIO.listFiles("E:\\tmp");
        if (null == files) return;

        for (File file : files) {
            logger.info(file.getName());
        }
    }

    @Test
    public void test12() {
        File[] files = FileIO.listFiles("E:\\tmp\\111.txt");
        if (null == files) return;

        for (File file : files) {
            logger.info(file.getName());
        }
    }

    @Test
    public void test13() {
        File[] files = FileIO.listFiles("");
        if (null == files) return;

        for (File file : files) {
            logger.info(file.getName());
        }
    }

    @Test
    public void test14() {
        try {
            Assert.assertTrue(FileIO.isEmptyFile("E:\\tmp\\111.txt"));
            Assert.assertFalse(FileIO.isEmptyFile("E:\\tmp\\112.txt"));
        } catch (IOException ex) {
            logger.error(ex.getMessage());
        }
    }

    @Test
    public void test15() {
        logger.info(FileIO.extension("E:\\tmp\\111.txt"));
    }

    @Test
    public void test16() {
        logger.info(FileIO.replaceExtension("E:\\tmp\\111.txt", ".mp4"));
    }

    @Test
    public void test17() {
        Assert.assertTrue(FileIO.createNewFolder("E:\\temp\\a\\2"));
    }

    @Test
    public void test18() {
        Assert.assertTrue(FileIO.deleteFolder(new File("E:\\temp\\a\\2")));
    }

    @Test
    public void test19() {
        Assert.assertTrue(FileIO.rename("E:\\tmp\\111.txt", "E:\\tmp\\3\\1112.txt"));
    }

    @Test
    public void test20() {
        Assert.assertTrue(FileIO.deleteFile("E:\\tmp\\3\\1112.txt"));
    }
}
