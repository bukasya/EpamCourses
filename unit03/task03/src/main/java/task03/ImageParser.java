package task03;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ImageParser {
    private Pattern pattern = Pattern.compile("\\([Рр]ис\\.\\s\\d+\\)");
    private Pattern intPattern = Pattern.compile("\\d");
    private int lastNumber;
    private File file = new File("D:\\Java\\EpamCourses\\unit03\\task03\\src\\main\\Java.SE.03.Information handling_task_attachment.html");

    public void parseFile(){
        String currentLine;
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(fileInputStream, "windows-1251");
            BufferedReader bufferedReader = new BufferedReader(isr);
            while ((currentLine = bufferedReader.readLine()) != null){
                Matcher matcher = pattern.matcher(currentLine);
                while(matcher.find()){
                    Matcher intMatcher = intPattern.matcher(matcher.group());
                    if(intMatcher.find()){
                        int parsedValue = Integer.parseInt(intMatcher.group());
                        if(parsedValue > lastNumber){
                            lastNumber = parsedValue;
                        }
                        else{
                            System.out.println("The author refers to the figures inconsistently.");
                            return;
                        }
                    }
                }
            }
            System.out.println("The author refers to the figures consistently.");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
