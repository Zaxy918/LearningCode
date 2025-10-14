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
<<<<<<< HEAD
}
=======
}
>>>>>>> f5a3438eb63a6c40df02d5836987c07a5a558a25
