package filetest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CsbSort {
    public static void test() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("src\\filetest\\aaa\\csb.txt"));
        ArrayList<String> csb = new ArrayList<>();
        String line;
        while ((line = br.readLine()) != null) {
            csb.add(line);
        }
        br.close();
        BufferedWriter bw = new BufferedWriter(new FileWriter("src\\filetest\\aaa\\csb.txt"));
        csb.stream().sorted((o1, o2) -> Integer.parseInt(o1.split(".")[0]) - Integer.parseInt(o2.split(".")[0])).forEach(lin -> {
            try {
                bw.write(lin);
                bw.newLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        bw.close();
    }
}
