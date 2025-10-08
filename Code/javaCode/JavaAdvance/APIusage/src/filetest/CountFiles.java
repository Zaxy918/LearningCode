package filetest;

import java.io.File;
import java.util.*;

public class CountFiles {
    public static void test() throws Exception {
        File rootFile = new File("src\\filetest\\aaa");
        rootFile.mkdirs();
        for (int i = 0; i < 13; i++) {
            if (i < 3) {
                File mktxt = new File(rootFile, Integer.toString(i) + ".txt");
                mktxt.createNewFile();
            } else if (i >= 3 && i < 7) {
                File mkdoc = new File(rootFile, Integer.toString(i) + ".doc");
                mkdoc.createNewFile();
            } else if (i >= 7) {
                File mkjpg = new File(rootFile, Integer.toString(i) + ".jpg");
                mkjpg.createNewFile();
            }
        }
        HashMap<String, Integer> fileTimes = new HashMap<>();
        countfiles(rootFile, fileTimes);
        fileTimes.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(System.out::println);
    }

    public static void countfiles(File rootFile, HashMap<String, Integer> fileMap) {
        if (rootFile.isFile()) {
            String ext = rootFile.getName().split("\\.")[1];
            fileMap.put(ext, fileMap.get(ext) == null ? 1 : (fileMap.get(ext) + 1));
        } else {
            File[] files = rootFile.listFiles();
            for (File file : files) {
                countfiles(file, fileMap);
            }
        }
    }
}
