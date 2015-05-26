package addressbook.utils;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class FileUtilsTest {

    @Test
    public void testReadLinesFileOk() {
        List<String> lines = FileUtils.readLines("Book");
        assertNotNull(lines);
        assertEquals(2, lines.size());
        assertEquals("Line-01", lines.get(0));
        assertEquals("Line-02", lines.get(1));
    }

    @Test(expected = NullPointerException.class)
    public void testReadLinesNullAsFileName() {
        FileUtils.readLines(null);
    }

    @Test(expected = RuntimeException.class)
    public void testReadLinesFileNotFound() {
        FileUtils.readLines("XYZ");
    }

}