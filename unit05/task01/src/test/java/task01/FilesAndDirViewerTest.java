package task01;

import org.junit.Test;

import static org.junit.Assert.*;

public class FilesAndDirViewerTest {

    FilesAndDirViewer filesAndDirViewer = new FilesAndDirViewer();

    @Test
    public void testCreateAndDeleteFile() throws Exception {
        String path = "D:\\Java\\EpamCourses\\unit05\\task01\\src\\test\\testfile.txt";

        assertEquals(0, filesAndDirViewer.create(path));
        assertEquals(0, filesAndDirViewer.delete(path));
    }

    @Test
    public void testCreateExistingFile() throws Exception {
        String path = "D:\\Java\\EpamCourses\\unit05\\task01\\src\\test\\testfile.txt";

        assertEquals(0, filesAndDirViewer.create(path));
        assertEquals(1, filesAndDirViewer.create(path));

        filesAndDirViewer.delete(path);
    }

    @Test
    public void testDeleteNotExistingFile() throws Exception {
        String path = "D:\\Java\\EpamCourses\\unit05\\task01\\src\\test\\testfile.txt";

        filesAndDirViewer.create(path);

        assertEquals(0, filesAndDirViewer.delete(path));
        assertEquals(-1, filesAndDirViewer.delete(path));
    }

    @Test
    public void testViewExistingFile() throws Exception {
        String path = "D:\\Java\\EpamCourses\\unit03\\task03\\src\\main\\received.html";

        assertEquals(0, filesAndDirViewer.view(path));
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

    @Test
    public void testAppendStringToExistingFile(){
        String path = "D:\\Java\\EpamCourses\\unit05\\task01\\src\\test\\testfile.txt";

        filesAndDirViewer.create(path);

        assertEquals(0, filesAndDirViewer.append(path, "098"));

        filesAndDirViewer.delete(path);
    }

    @Test
    public void testAppendStringToNotExistingFile(){
        String path = "D:\\Java\\EpamCourses\\unit05\\task01\\src\\test\\testfile.txt";

        assertEquals(1, filesAndDirViewer.append(path, "123"));
    }

    @Test
    public void testGoToLowerExistingDir(){
        String path = "D:\\Java\\EpamCourses\\unit03\\task03\\src\\main";

        assertEquals("D:\\Java\\EpamCourses\\unit03\\task03\\src", filesAndDirViewer.goToLowerDir(path));
    }

    @Test
    public void testGoToLowerNotExistingDir(){
        String path = "D:\\Java\\EpamCourses\\unit03\\task03\\src\\task01";

        assertEquals(path, filesAndDirViewer.goToLowerDir(path));
    }

    @Test
    public void testGoToUpperExistingDirectory(){
        String path = "D:\\Java\\EpamCourses\\unit03\\task03\\src\\main";

        assertEquals(path + "\\" + "java", filesAndDirViewer.goToUpperDir(path, "java"));
    }

    @Test
    public void testGoToUpperNotExistingDirectory(){
        String path = "D:\\Java\\EpamCourses\\unit03\\task03\\src\\main";

        assertEquals(path, filesAndDirViewer.goToUpperDir(path, "task01"));
    }

    @Test
    public void testGoToUpperDirectoryFromNotExistingDirectory(){
        String path = "D:\\Java\\EpamCourses\\unit03\\task03\\src\\task01";

        assertEquals(path, filesAndDirViewer.goToUpperDir(path, "java"));
    }
}