package task03;

import org.junit.Test;

import static org.junit.Assert.*;

public class ImageParserTest {
    @Test
    public void testParseFile() throws Exception {
        ImageParser imageParser = new ImageParser();
        imageParser.parseFile();
    }

}