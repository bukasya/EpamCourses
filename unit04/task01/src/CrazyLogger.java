package task01;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CrazyLogger {
    private StringBuilder log = new StringBuilder();
    private String logFormat = new String("yyyy-MM-dd : HH-mm - ");

    public void addLog(String s){
        String formattedDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern(logFormat));
        log.append(formattedDate + s);
    }

    private int findString(String s){
        return log.indexOf(s);
    }

    public String findMessage(String s){
        int startIndexOfMessage = findString(s);
        if(startIndexOfMessage > 0)
            return log.substring(startIndexOfMessage - logFormat.length(), startIndexOfMessage + s.length());
        else
            return "";
    }

    public void printMessage(String s){
        System.out.println(s);
    }

    public StringBuilder getLog() {
        return log;
    }
}
