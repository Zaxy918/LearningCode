package filetest;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class FileSort {
    public static void test() throws IOException {
        FileReader oriFile = new FileReader("src\\filetest\\aaa\\3.txt");
        StringBuffer sb = new StringBuffer();
        int c;
        while ((c = oriFile.read()) != -1) {
            sb.append((char) c);
        }
        oriFile.close();
        /*
         * 
         * This is very amazing.
         * 
         */
        String str = Arrays.toString(Arrays.stream(sb.toString().split("-")).map(Integer::parseInt).sorted().toArray(Integer[]::new)).replace(", ", "-");
        FileWriter sortedFile = new FileWriter("src\\filetest\\aaa\\3.txt");
        sortedFile.write(str.substring(1, str.length() - 1));
        sortedFile.close();
    }
}
