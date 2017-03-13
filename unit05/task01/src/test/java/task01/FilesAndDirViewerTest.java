package task01;

import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

public class FilesAndDirViewerTest {

    FilesAndDirViewer filesAndDirViewer = new FilesAndDirViewer();

    @Test
    public void testCreateAndDeleteFile() throws Exception {
        String path = "D:\\Java\\EpamCourses\\unit05\\task01\\src\\test\\testfile.txt";

        assertEquals(1, filesAndDirViewer.create(path));
        assertEquals(1, filesAndDirViewer.delete(path));
    }

    @Test
    public void testCreateExistingFile() throws Exception {
        String path = "D:\\Java\\EpamCourses\\unit05\\task01\\src\\test\\testfile.txt";

        assertEquals(1, filesAndDirViewer.create(path));
        assertEquals(0, filesAndDirViewer.create(path));

        filesAndDirViewer.delete(path);
    }

    @Test
    public void testDeleteNotExistingFile() throws Exception {
        String path = "D:\\Java\\EpamCourses\\unit05\\task01\\src\\test\\testfile.txt";

        filesAndDirViewer.create(path);

        assertEquals(1, filesAndDirViewer.delete(path));
        assertEquals(-1, filesAndDirViewer.delete(path));
    }

    @Test
    public void testViewExistingFile() throws Exception {
        String path = "D:\\Java\\EpamCourses\\unit03\\task03\\src\\main\\received.html";

        assertEquals(1, filesAndDirViewer.view(path));
    }

    @Test
    public void testViewNotExistingFile() throws Exception {
        String path = "D:\\Java\\EpamCourses\\unit03\\task03\\src\\main\\received.mp3";

        assertEquals(-1, filesAndDirViewer.view(path));
    }

    @Test
    public void testViewExistingDirectory() throws Exception {
        String path = "D:\\Java\\EpamCourses\\unit03\\task03\\src\\main";

        assertEquals(0, filesAndDirViewer.view(path));
    }


}