package filetest;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class ISRtest {
    public static void test() throws Exception {
        BufferedReader bw = new BufferedReader(new InputStreamReader(new FileInputStream("src\\filetest\\aaa\\csb.txt")));
        String line;
        while ((line = bw.readLine()) != null) {
            System.out.println(line);
        }
        bw.close();
    }
}
