package filetest;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopFIleTest {
    public static void test() throws IOException {
        FileInputStream fis = new FileInputStream("D:\\Apps\\Clash\\clash-verge.exe");
        FileOutputStream fos = new FileOutputStream("src\\filetest\\bbb\\copy.exe");
        int len;//Record the lenth of bytes
        long start = System.currentTimeMillis();
        byte[] bs = new byte[1024 * 1024 * 5];
        while ((len = fis.read(bs)) != -1) {
            fos.write(bs, 0, len);
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        fis.close();
        fos.close();
    }
}
