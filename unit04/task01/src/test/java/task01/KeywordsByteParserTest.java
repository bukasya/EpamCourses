package task01;

import org.junit.Test;

import java.io.File;
import java.util.Map;
import java.util.TreeMap;

import static org.junit.Assert.*;

public class KeywordsByteParserTest {
    KeywordsByteParser javaParser = new KeywordsByteParser();

    @Test
    public void testParseFileForKeywords() throws Exception {
        File file = new File("src\\main\\javakeywords.txt");
        File javaFile = new File("src\\test\\CrazyLogger.java");
        TreeMap<String, Integer> keywordsMap;

        keywordsMap = javaParser.readKeywords(file);
        javaParser.parseFileForKeywords(javaFile, keywordsMap);

        assertEquals(2, (long)keywordsMap.get("import"));
        assertEquals(1, (long)keywordsMap.get("if"));
    }

    @Test
    public void testReadKeywords() throws Exception {
        File file = new File("src\\test\\test.txt");
        TreeMap<String, Integer> keywordsMap;

        keywordsMap = javaParser.readKeywords(file);

        assertTrue(keywordsMap.containsKey("hello"));
        assertTrue(keywordsMap.containsKey("me"));
    }

    @Test
    public void testReadKeywordsFromEmptyFile() throws Exception{
        File file = new File("src\\test\\empty.txt");
        TreeMap<String, Integer> keywordMap;

        keywordMap = javaParser.readKeywords(file);

        assertTrue(keywordMap.isEmpty());
    }
}