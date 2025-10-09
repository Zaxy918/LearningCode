package filetest;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyCompare {
    public static void test() throws IOException {
        FileInputStream fis = new FileInputStream("D:\\Apps\\4399zmxyonline.exe");
        FileOutputStream fos = new FileOutputStream("src\\filetest\\aaa\\aaa.exe");
        BufferedInputStream bis = new BufferedInputStream(fis);
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        //One time one byte slowest.
        long s1 = System.currentTimeMillis();
        int b;
        while ((b = fis.read()) != -1) {
            fos.write(b);
        }
        //Fast
        long s2 = System.currentTimeMillis();
        while ((b = bis.read()) != -1) {
            bos.write(b);
        }
        long s3 = System.currentTimeMillis();
        //One time one blocks, fast and recmmended.
        byte[] bs = new byte[1024 * 1024 * 5];
        while ((b = fis.read(bs)) != -1) {
            fos.write(bs, 0, b);
        }
        Long s4 = System.currentTimeMillis();
        while ((b = bis.read(bs)) != -1) {
            bos.write(bs);
        }
        long s5 = System.currentTimeMillis();
        bos.close();
        bis.close();
        long r1 = s2 - s1;
        long r2 = s3 - s2;
        long r3 = s4 - s3;
        long r4 = s5 - s4;
        System.out.println(r1);
        System.out.println(r2);
        System.out.println(r3);
        System.out.println(r4);
    }
}
