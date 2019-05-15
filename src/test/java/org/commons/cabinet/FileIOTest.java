package org.commons.cabinet;

import org.commons.cabinet.io.FileIO;
import org.junit.Test;

import java.io.IOException;
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
}
