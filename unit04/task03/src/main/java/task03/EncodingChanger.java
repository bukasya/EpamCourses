package task03;

import java.io.*;

public class EncodingChanger {

    public void changeEncoding(File input, File output, String newCharsetName){
        try {
            FileInputStream fileInputStream = new FileInputStream(input);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            FileOutputStream fileOutputStream = new FileOutputStream(output);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, newCharsetName);
            BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);

            String currentLine;
            while ((currentLine = bufferedReader.readLine()) != null){
                bufferedWriter.write(currentLine);
            }
            bufferedWriter.flush();

            fileInputStream.close();
            fileOutputStream.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
