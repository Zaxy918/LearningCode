import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.Comparator;

public class Chap11 {
    public static void main(String[] args) {
        // 将sortedWords定义在外面，这样所有try块都能访问
        List<Map.Entry<String, Integer>> sortedWords = new ArrayList<>();

        try (FileWriter writer_a = new FileWriter("D:\\temp\\a.txt")) {
            writer_a.append("hello world\n");
            writer_a.append("hello\n");
            writer_a.append("java world hello");
        } catch (Exception e) {
            e.printStackTrace();
        }

        try (FileReader reader = new FileReader("D:\\temp\\a.txt"); BufferedReader bf = new BufferedReader(reader)) {
            String line;
            HashMap<String, Integer> allWords = new HashMap<>();
            // 修复while循环逻辑 - 不要重复调用readLine()
            while ((line = bf.readLine()) != null) {
                String[] words = line.split(" ");
                for (String word : words) {
                    allWords.put(word, allWords.getOrDefault(word, 0) + 1);
                }
            }
            sortedWords = new ArrayList<>(allWords.entrySet());
            // sortedWords.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));
            sortedWords.sort(new Comparator<Map.Entry<String, Integer>>() {
                @Override
                public int compare(Map.Entry<String, Integer> entry1, Map.Entry<String, Integer> entry2) {
                    return entry2.getValue().compareTo(entry1.getValue());
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

        try (FileWriter writer_b = new FileWriter("D:\\temp\\b.txt")) {
            for (Map.Entry<String, Integer> word : sortedWords) {
                writer_b.append(word.getKey());
                writer_b.append(" ");
                // 修复类型错误：需要将Integer转换为String
                writer_b.append(String.valueOf(word.getValue()));
                writer_b.append("\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
