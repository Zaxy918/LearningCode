package filetest;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileEncryption {
    public static void test() throws IOException {
        FileInputStream src = new FileInputStream("src\\filetest\\aaa\\0.txt");
        FileOutputStream dest = new FileOutputStream("src\\filetest\\aaa\\1.txt");
        int b;
        while ((b = src.read()) != -1) {
            dest.write(b ^ 10);
        }
        dest.close();
        src.close();
        FileInputStream encypetd = new FileInputStream("src\\filetest\\aaa\\1.txt");
        FileOutputStream decrypted = new FileOutputStream("src\\filetest\\aaa\\2.txt");
        while ((b = encypetd.read()) != -1) {
            decrypted.write(b ^ 10);
        }
        decrypted.close();
        encypetd.close();
    }
}
