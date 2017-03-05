package task01;

import org.junit.Test;

import static org.junit.Assert.*;

public class CrazyLoggerTest {

    @Test
    public void testFindMessageInEmptyLog() throws Exception{
        CrazyLogger logger = new CrazyLogger();

        assertFalse(logger.findMessage("This is string").length() > 0);
    }

    @Test
    public void testFindMessageWhichContained() throws Exception {
        CrazyLogger logger = new CrazyLogger();
        String[] messages = {"Hello", "it's me", "I was wondering", "if after all these years", "you'd like to meet"};

        for (String s: messages) {
            logger.addLog(s);
        }

        assertTrue(logger.findMessage("it's me").length() > 0);
        logger.printMessage(logger.findMessage("it's me"));
    }

    @Test
    public void testFindMessageWhichNotContained() throws Exception {
        CrazyLogger logger = new CrazyLogger();
        String[] messages = {"Hello", "it's me", "I was wondering", "if after all these years", "you'd like to meet"};

        for (String s: messages) {
            logger.addLog(s);
        }

        assertFalse(logger.findMessage("This string is not contained in messages").length() > 0);
    }
}