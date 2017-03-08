package task03;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ImageParser {
    private Pattern pattern = Pattern.compile("\\([Рр]ис\\.\\s\\d+\\)");
    private Pattern intPattern = Pattern.compile("\\d");
    private String[] imageNumbers = new String[200];
    private int[] intNumbers = new int[200];
    private File file = new File("D:\\Java\\EpamCourses\\unit03\\task03\\src\\main\\Java.SE.03.Information handling_task_attachment.html");

    public void parseFile(){
        String currentLine;
        int i = 0;
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(fileInputStream, "windows-1251");
            BufferedReader bufferedReader = new BufferedReader(isr);
            while ((currentLine = bufferedReader.readLine()) != null){
                Matcher matcher = pattern.matcher(currentLine);
                while(matcher.find()){
                    imageNumbers[i] = matcher.group();
                    Matcher intMatcher = intPattern.matcher(imageNumbers[i]);
                    while(intMatcher.find()){
                        intNumbers[i] = Integer.parseInt(intMatcher.group());
                    }
                    i++;
                }
            }
            for (int k: intNumbers) {
                System.out.println(k);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
