package task01;

import java.io.*;
import java.util.TreeMap;

public class KeywordsByteParser {

    public static TreeMap<String, Integer> readKeywords(File file){
        TreeMap<String, Integer> keywordsMap = new TreeMap<>();
        StringBuilder buffer = new StringBuilder();
        int i;
        try {
            FileInputStream inputStream = new FileInputStream(file);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
            do{
                i = bufferedInputStream.read();
                if(i == 13 || i == -1 && buffer.length() != 0){
                    bufferedInputStream.read();
                    keywordsMap.put(buffer.toString(), 0);
                    buffer.delete(0, buffer.length());
                } 
                else {
                    buffer.append((char)i);
                }
            } while (i != -1);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return keywordsMap;
    }


}
