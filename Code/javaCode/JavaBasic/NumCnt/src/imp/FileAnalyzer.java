package imp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class FileAnalyzer {
    private String filePath;

    public FileAnalyzer(String filePath) {
        this.filePath = filePath;
    }

    public HashMap<Integer, Num> getNumAccount() {
        HashMap<Integer, Num> countMap = new HashMap<Integer, Num>();
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            while ((line = br.readLine()) != null) {
                for (char n : line.toCharArray()) {
                    if (Character.isDigit(n)) {
                        int num = n - '0';
                        if (countMap.containsKey(num)) {
                            countMap.get(num).increment(1);
                        } else {
                            countMap.put(num, new Num(num, 1));
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return countMap;
    }
}
