package main;

import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LogUtil {

    public static List<LogEntry> parseLogs(Path logFilePath) throws Exception {
        return Files.lines(logFilePath).map(LogEntry::parse).toList();
    }

    public static void countLevel(List<LogEntry> entries) {
        Map<String, Long> levelCount = entries.stream().collect(Collectors.groupingBy(LogEntry::getLevel, Collectors.counting()));
        levelCount.entrySet().stream().sorted(Map.Entry.<String, Long>comparingByValue(Comparator.reverseOrder())).forEach(entry -> {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        });
    }

    public static void copyErrors(List<LogEntry> entries, Path outPutPath) throws Exception {
        try (PrintWriter pw = new PrintWriter(outPutPath.toString())) {
            entries.forEach(pw::println);
        } catch (Exception e) {
            throw new Exception();
        }
        System.out.println("Write completed");
        // try {
        //     List<String> errorLogs = entries.stream().filter(entry -> "ERROR".equals(entry.getLevel())).map(entry -> {
        //         StringBuilder sb = new StringBuilder();
        //         sb.append(entry.getTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))).append(" ").append(entry.getLevel()).append(" ").append(entry.getMessage());
        //         return sb.toString();
        //     }).toList();
        //     Files.write(outPutPath, errorLogs, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        // } catch (Exception e) {
        // }
    }
}
