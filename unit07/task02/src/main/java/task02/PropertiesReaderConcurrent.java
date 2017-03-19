package task02;

import java.io.*;
import java.util.MissingResourceException;
import java.util.Properties;

public class PropertiesReaderConcurrent {

    /* for *.properties files saved in unicode
     * (in case of files which contain cyrillic characters) */
    public static synchronized String getValue(File propertiesFile, String key) {

        try {
            FileInputStream fileInputStream = new FileInputStream(propertiesFile);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "unicode");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            Properties properties = new Properties();

            properties.load(bufferedReader);

            String value = properties.getProperty(key);

            if (value == null) {
                throw new MissingResourceException("Key not found", "PropertiesReader", key);
            } else {
                return value;
            }

        } catch (IOException e) {
            return "File not found";
        } catch (MissingResourceException e) {
            return e.getMessage();
        }
    }

}
