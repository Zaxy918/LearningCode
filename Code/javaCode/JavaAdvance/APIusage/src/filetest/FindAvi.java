package filetest;

import java.io.File;
import java.util.Arrays;

public class FindAvi {
    public static void test() {
        File rootFile = new File("src\\filetest\\aaa");
        File[] entrFiles = rootFile.listFiles(f -> f.isFile() && f.toString().endsWith(".avi"));
        System.out.println(Arrays.toString(entrFiles));
    }

}
