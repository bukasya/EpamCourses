package task03;

import org.junit.Test;

import static org.junit.Assert.*;

public class ImageParserTest {
    @Test
    public void testMarkSentencesWithImages() throws Exception {
        ImageParser imageParser = new ImageParser();
        imageParser.markSentencesWithImages(imageParser.splitToSentences());
    }

    @Test
    public void testSplitToSentences() throws Exception {
        ImageParser imageParser = new ImageParser();
        imageParser.splitToSentences();
    }

    @Test
    public void testParseFile() throws Exception {
        ImageParser imageParser = new ImageParser();
        imageParser.parseFile();
    }

}