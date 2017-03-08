package task03;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ImageParser {
    private Pattern imageReferencePattern = Pattern.compile("\\([Рр]ис\\.\\s\\d+\\)");
    private Pattern imageNumberPattern = Pattern.compile("\\d");
    private int lastImageNumber;
    private File initialFile = new File("src\\main\\Java.SE.03.Information handling_task_attachment.html");

    public void parseFile(){
        String currentLine;
        try {
            FileInputStream fileInputStream = new FileInputStream(initialFile);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "windows-1251");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            while ((currentLine = bufferedReader.readLine()) != null){
                Matcher matcher = imageReferencePattern.matcher(currentLine);
                while(matcher.find()){
                    //parse image number from imageNumberPattern
                    Matcher intMatcher = imageNumberPattern.matcher(matcher.group());
                    if(intMatcher.find()){
                        int parsedValue = Integer.parseInt(intMatcher.group());
                        if(parsedValue > lastImageNumber){
                            lastImageNumber = parsedValue;
                        }
                        else{
                            //if any next image number doesn't exceed previous
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
