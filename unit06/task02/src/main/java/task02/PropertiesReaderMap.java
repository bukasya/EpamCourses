package task02;

import java.io.*;
import java.util.HashMap;
import java.util.MissingResourceException;

public class PropertiesReaderMap {

    private static File propsFile;
    private static String[] pair = new String[2];
    private static HashMap<String, String> propertiesMap = new HashMap<String, String>();


    /* for *.properties files saved in unicode
     * (in case of files which contain cyrillic characters) */
    public static String getValue(File propertiesFile, String key) {
        try {
            if(PropertiesReaderMap.propsFile != propertiesFile) {
                PropertiesReaderMap.propsFile = propertiesFile;
                FileInputStream fileInputStream = new FileInputStream(propertiesFile);
                InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "unicode");
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                String currentLine;
                while ((currentLine = bufferedReader.readLine()) != null){
                    pair = currentLine.split("\\s=\\s");
                    propertiesMap.put(pair[0], pair[1]);

                }
            }

            String value = propertiesMap.get(key);

            if(value == null){
                throw new MissingResourceException("Key not found", "PropertiesReader", key);
            }
            else{
                return value;
            }

        } catch (IOException e) {
            return "File not found";
        } catch (MissingResourceException e){
            return e.getMessage();
        }
    }
}
