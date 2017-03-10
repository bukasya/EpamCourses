package task03;

import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

public class EncodingChangerTest {
    @Test
    public void changeEncoding() throws Exception {
        EncodingChanger encodingChanger = new EncodingChanger();
        File input = new File("src\\input.txt");
        File output = new File("output.txt");

        encodingChanger.changeEncoding(input, output, "utf-16");

        assertTrue(output.exists());
    }

}