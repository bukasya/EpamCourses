package task01;

import java.util.Scanner;

public class FileManager {
    private static String[] greeting = {"Welcome to file manager! Press:", "1. Create file in specified directory."
            , "2. Delete specified file.", "3. View current directory.", "4. Go to lower directory."
            , "5. Go to upper directory.", "6. Write to specified file.", "0. Exit."};
    private static String currentDir = "D:\\Java\\EpamCourses\\unit05\\task01\\src\\main\\java\\task01";
    private static FilesAndDirViewer filesAndDirViewer = new FilesAndDirViewer();

    public static void main(String[] args) {
        for (String s : greeting) {
            System.out.println(s);
        }
        Scanner scanner = new Scanner(System.in);
        String path;
        while (true) {
            System.out.println("Current directory is " + currentDir);
            switch(scanner.nextInt()){
                case 1:
                    scanner.nextLine();
                    System.out.println("Enter full filename: ");
                    path = scanner.nextLine();
                    filesAndDirViewer.create(currentDir + "\\" + path);
                    break;
                case 2:
                    scanner.nextLine();
                    System.out.println("Enter full filename: ");
                    path = scanner.nextLine();
                    filesAndDirViewer.delete(currentDir + "\\" + path);
                    break;
                case 3:
                    filesAndDirViewer.view(currentDir);
                    break;
                case 4:
                    currentDir = filesAndDirViewer.goToLowerDir(currentDir);
                    break;
                case 5:
                    scanner.nextLine();
                    System.out.println("Enter upper directory name: ");
                    String newPath = scanner.nextLine();
                    currentDir = filesAndDirViewer.goToUpperDir(currentDir, newPath);
                    break;
                case 6:
                    scanner.nextLine();
                    System.out.println("Enter filename: ");
                    String fileName = scanner.nextLine();
                    System.out.println("Enter text to write in file: ");
                    String text = scanner.nextLine();
                    filesAndDirViewer.append(currentDir + "\\" + fileName, text);
                    break;
                case 0:
                    System.exit(0);
                    break;
            }
        }
    }
}
