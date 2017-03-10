package task04;

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class FilmCollection implements Serializable {

    private TreeMap<String, String> filmCollection = new TreeMap<>();

    public void serializeCollection(File file) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);

            for (Map.Entry<String, String> entry : filmCollection.entrySet()) {
                String record = entry.getKey() + ": " + entry.getValue() + "\n";
                bufferedOutputStream.write(record.getBytes());
                bufferedOutputStream.flush();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deserializeCollection(File file) {
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);

            int i;
            StringBuffer buffer = new StringBuffer();
            String[] pair;

            do {
                i = bufferedInputStream.read();
                if (i == '\n') {
                    pair = buffer.toString().split(":\\s");
                    filmCollection.put(pair[0], pair[1]);
                    buffer.delete(0, buffer.length());
                } else {
                    buffer.append((char) i);
                }
            } while (i != -1);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addFilm(String film, String actor) {
        if (filmCollection.containsKey(film)) {
            System.out.println("Film is already in the collection.");
        } else {
            filmCollection.put(film, actor);
        }
    }

    public void deleteFilm(String film) {
        if (filmCollection.containsKey(film)) {
            filmCollection.remove(film);
        } else {
            System.out.println("There is no such film.");
        }
    }

    public void showCollection() {
        for (Map.Entry<String, String> entry : filmCollection.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + ".");
        }
    }
}
