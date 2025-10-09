package filetest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Free3 {
    public static void test() throws IOException {
        File cntFile = new File("src\\filetest\\aaa\\times.txt");
        if (!cntFile.exists()) {
            cntFile.createNewFile();
            FileWriter fos = new FileWriter(cntFile);
            fos.write("0");
            fos.close();
        }
        BufferedReader br = new BufferedReader(new FileReader(cntFile));
        Integer cnt = Integer.parseInt(br.readLine());
        br.close();
        cnt++;
        if (cnt < 4) {
            System.out.println("The " + cnt + " time for free.");
        } else {
            System.out.println("Pay for next use.");
        }
        BufferedWriter bw = new BufferedWriter(new FileWriter(cntFile));
        bw.write(cnt.toString());
        bw.close();
    }
}
