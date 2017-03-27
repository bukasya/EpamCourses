package task02;

import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertEquals;

public class PropertiesReaderMapTest {
    @Test
    public void testGetExistingValue() throws Exception {
        File props = new File("src\\main\\resources\\fruits_en.properties");
        String key = "apple";

        String value = PropertiesReaderMap.getValue(props, key);

        assertEquals("apple", value);
    }

    @Test
    public void testGetNotExistingValue() throws Exception {
        File props = new File("src\\main\\resources\\fruits_ru.properties");
        String key = "melon";

        String value = PropertiesReaderMap.getValue(props, key);

        assertEquals("Key not found", value);
    }

    @Test
    public void testGetValueFromNotExistingFile() throws Exception {
        File props = new File("src\\main\\resources\\fruits_fr.properties");
        String key = "apple";

        String value = PropertiesReaderMap.getValue(props, key);

        assertEquals("File not found", value);
    }
}
