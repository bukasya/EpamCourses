package task01;

import java.io.*;
import java.util.ArrayList;
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

    public void parseFileForKeywords(File file, TreeMap<String, Integer> keywordsMap){
        char[] operatorsArray = {'{', '}', '(', ')', '+', '-', '*', '/', '%', '|', '&', '!', '<', '>', '^', '~', '?', ':' };
        ArrayList<Character> operatorsList = new ArrayList<>();
        for (char c: operatorsArray) {
            operatorsList.add(c);
        }
        StringBuilder buffer = new StringBuilder();
        int i;
        try {
            FileInputStream inputStream = new FileInputStream(file);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);

            do{
                i = bufferedInputStream.read();
                //if this char is operator - replace it with space char
                if(operatorsList.contains((char) i)){
                    i = 32;
                }
                //if this char is a space char & buffer isn't empty - parsing word in buffer
                if(i == 13 || i == 32 || i == 10 || i == 9|| i == -1 && buffer.length() != 0){
                    //if word in buffer is one of the keywords - increment value of that key == word
                    if(keywordsMap.containsKey(buffer.toString())){
                        keywordsMap.replace(buffer.toString(), keywordsMap.get(buffer.toString())+1);
                    }
                    buffer.delete(0, buffer.length());
                }
                //else keeping accumulate the word
                else {
                    buffer.append((char)i);
                }
            } while (i != -1);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
