package task03;

import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

public class ImageParserTest {

    @Test
    public void testCheckWhereImagesAreNotConsistent() throws Exception {
        File initialFile = new File("src\\main\\Java.SE.03.Information handling_task_attachment.html");
        File receivedFile = new File("src\\main\\received.html");
        receivedFile.createNewFile();
        ImageParser imageParser = new ImageParser(initialFile, receivedFile);
        assertFalse(imageParser.checkIfImagesAreConsistent());
    }

    @Test
    public void testCheckWhereImagesAreConsistent() throws Exception {
        File initialFile = new File("src\\main\\initialTest.txt");
        File receivedFile = new File("src\\main\\receivedTest.txt");
        ImageParser imageParser = new ImageParser(initialFile, receivedFile);
        assertTrue(imageParser.checkIfImagesAreConsistent());
    }

}