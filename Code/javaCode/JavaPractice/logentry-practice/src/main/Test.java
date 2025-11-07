package main;

import java.nio.file.Path;
import java.util.List;

public class Test {
    public static void main(String[] args) throws Exception {
        List<LogEntry> entries = LogUtil.parseLogs(Path.of("src/main/sources", "log.txt"));
        LogUtil.countLevel(entries);
        LogUtil.copyErrors(entries, Path.of("error_today.txt"));
    }
}
