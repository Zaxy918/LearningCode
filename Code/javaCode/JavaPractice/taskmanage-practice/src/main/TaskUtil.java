package main;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TaskUtil {
    @SuppressWarnings("unchecked")
    public static List<Task> deSerialization(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return (List<Task>) ois.readObject();// Make sure the contents in file is a list
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    public static List<Task> filtIndateTask(List<Task> tasks) {
        return tasks.stream().filter(t -> t.getDeadline().isAfter(LocalDateTime.now())).sorted(Comparator.comparing(Task::getPriority).thenComparing(Task::getDeadline)).collect(Collectors.toList());
    }

    public static void writeTaskToFile(List<Task> tasks, String filename) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(filename, true))) {
            tasks.forEach(pw::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
