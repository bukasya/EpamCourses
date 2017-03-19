package task02;

import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

public class PropertiesReaderConcurrentTest {

    PropertiesReaderConcurrent propertiesReaderConcurrent = new PropertiesReaderConcurrent();

    @Test
    public void testGetExistingValue() throws Exception {
        File props = new File("src\\main\\resources\\fruits_en.properties");
        String key = "apple";

        String value = propertiesReaderConcurrent.getValue(props, key);

        assertEquals("apple", value);
    }

    @Test
    public void testGetNotExistingValue() throws Exception {
        File props = new File("src\\main\\resources\\fruits_ru.properties");
        String key = "melon";

        String value = propertiesReaderConcurrent.getValue(props, key);

        assertEquals("Key not found", value);
    }

    @Test
    public void testGetValueFromNotExistingFile() throws Exception {
        File props = new File("src\\main\\resources\\fruits_fr.properties");
        String key = "apple";

        String value = propertiesReaderConcurrent.getValue(props, key);

        assertEquals("File not found", value);
    }

    @Test
    public void testGetValueWithConcurrency() throws Exception {
        File props = new File("src\\main\\resources\\fruits_en.properties");
        String key1 = "apple";
        String key2 = "pear";

        String[] values = new String[2];

        Thread t1 = new Thread(() -> {
            values[0] = PropertiesReaderConcurrent.getValue(props, key1);
        });
        Thread t2 = new Thread(() -> {
            values[1] = PropertiesReaderConcurrent.getValue(props, key2);
        });

        t1.start();
        t2.start();

        //time for t1 and t2 get values from properties file
        Thread.sleep(1000);

        assertEquals("apple", values[0]);
        assertEquals("pear", values[1]);
    }
}