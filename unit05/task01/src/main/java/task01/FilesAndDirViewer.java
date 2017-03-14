package task01;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;

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
                return 0;
            }
        }
    }

    public int delete(String path) {
        File file = new File(path);

        if (file.exists()) {
            file.delete();
            return 0;
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
                return 0;
            } catch (IOException e) {
                return -1;
            }
        } else {
            try {
                throw new FileAlreadyExistsException(path);
            } catch (FileAlreadyExistsException e) {
                return 1;
            }
        }
    }

    public int append(String path, String text) {
        try {
            File file = new File(path);
            if (file.exists()) {
                FileWriter fileWriter = new FileWriter(file, true);
                fileWriter.write(text);
                fileWriter.flush();
                fileWriter.close();
                return 0;
            } else {
                return 1;
            }
        } catch (IOException e) {
            return -1;
        }
    }

    public String goToLowerDir(String path){
        File file = new File(path);
        if(file.isDirectory()){
            int lastSlash = path.lastIndexOf('\\');
            String newPath = path.substring(0, lastSlash);
            file = new File(newPath);
            if(file.isDirectory()){
                return newPath;
            }
            else {
                try {
                    throw new IOException("Cannot access " + newPath + ": no such file or directory.");
                } catch (IOException e) {
                    return path;
                }
            }
        }
        else{
            try {
                throw new IOException(path + " is not a directory.");
            } catch (IOException e) {
                return path;
            }
        }
    }

    public String goToUpperDir(String path, String upperDirName){
        File file = new File(path);
        if(file.isDirectory()){
            String newPath = path + "\\" + upperDirName;
            file = new File(newPath);
            if(file.isDirectory()){
                return newPath;
            }
            else{
                try {
                    throw new IOException(newPath + " is not a directory");
                } catch (IOException e) {
                    return path;
                }
            }
        }
        else{
            try {
                throw new IOException(path + " is not a directory");
            } catch (IOException e) {
                return path;
            }
        }
    }
}
