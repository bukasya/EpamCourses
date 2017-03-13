package task01;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.FileSystemException;

public class FilesAndDirViewer {

    public int view(String path) {

        File file = new File(path);
        if (!file.exists()) {
            try {
                throw new IOException("Cannot access " + path + ": no such file or directory.");
            } catch (IOException e) {
                return -1;
            }
        } else {
            if (file.isDirectory()) {
                for (File f : file.listFiles()) {
                    System.out.println(f.getName());
                }
                return 0;
            } else {
                System.out.println("File " + path + " exists.");
                return 1;
            }
        }
    }

    public int delete(String path) {
        File file = new File(path);

        if (file.exists()) {
            file.delete();
            return 1;
        } else {
            try {
                throw new IOException("Cannot access " + path + ": no such file or directory.");
            } catch (IOException e) {
                return -1;
            }
        }
    }

    public int create(String path) {
        File file = new File(path);

        if (!file.exists()) {
            try {
                file.createNewFile();
                return 1;
            } catch (IOException e) {
                return -1;
            }
        } else {
            try {
                throw new FileAlreadyExistsException(path);
            } catch (FileAlreadyExistsException e) {
                return 0;
            }
        }
    }
}
