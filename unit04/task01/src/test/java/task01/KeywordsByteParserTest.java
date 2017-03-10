package task01;

import org.junit.Test;

import java.io.File;
import java.util.TreeMap;

import static org.junit.Assert.*;

public class KeywordsByteParserTest {
        KeywordsByteParser javaParser = new KeywordsByteParser();

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