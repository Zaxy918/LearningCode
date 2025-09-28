package main;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashMap;
import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;

import imp.Searcher;
import imp.Num;
import imp.FileAnalyzer;

public class NumberCount {
    public static void main(String[] args) throws IOException {
        Path fileTree = Paths.get("C:\\temp\\number_count");
        Searcher walk = new Searcher("*.txt");
        EnumSet<FileVisitOption> opt = EnumSet.of(FileVisitOption.FOLLOW_LINKS);
        Files.walkFileTree(fileTree, opt, Integer.MAX_VALUE, walk);
        ArrayList<String> filePaths = walk.getFilePaths();

        HashMap<Integer, Num> countMap = new HashMap<Integer, Num>();
        for (String path : filePaths) {
            HashMap<Integer, Num> tempMap = new FileAnalyzer(path).getNumAccount();
            if (tempMap.size() > 0) {
                mapCombine(countMap, tempMap);
            }
        }

        ArrayList<Num> nums = new ArrayList<Num>(countMap.values());
        Collections.sort(nums);

        outPut(nums);
    }

    public static void mapCombine(HashMap<Integer, Num> mainMap, HashMap<Integer, Num> addMap) {
        for (Integer key : addMap.keySet()) {
            if (mainMap.containsKey(key)) {
                mainMap.get(key).increment(addMap.get(key).getCount());
            } else {
                mainMap.put(key, new Num(key, addMap.get(key).getCount()));
            }
        }
    }

    public static void outPut(ArrayList<Num> nums) {
        System.out.println("The ranking of number occurrences is:");
        int sum = 0;
        for (Num n : nums) {
            System.out.println("Number " + n.getNum() + " occurred " + n.getCount() + " times");
            sum += n.getCount();
        }
        System.out.println("Total occurrences: " + sum);
    }
}
