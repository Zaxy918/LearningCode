package main;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LogEntry {
    private LocalDateTime time;
    private String level;
    private String message;

    public LogEntry() {
    }

    public LogEntry(LocalDateTime time, String level, String message) {
        this.time = time;
        this.level = level;
        this.message = message;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static LogEntry parse(String log) {
        String[] fields = log.split(" ", 4);
        return new LogEntry(LocalDateTime.parse(fields[0] + " " + fields[1], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")), fields[2], fields[3]);
    }

    @Override
    public String toString() {
        return time + " " + level + " " + message;
    }
}
