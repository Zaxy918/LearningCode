package filetest;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class Unzip {
    public static void test() throws Exception {
        ZipInputStream zis = new ZipInputStream(new FileInputStream("src\\filetest\\aaa.zip"));
        File dest = new File("src\\filetest\\uaaa\\");
        ZipEntry ze;
        while ((ze = zis.getNextEntry()) != null) {
            if (ze.isDirectory()) {
                System.out.println(ze.getName());
                File zed = new File(dest, ze.getName());
                zed.mkdirs();
            } else {
                BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(new File(dest, ze.getName())));
                byte[] bs = new byte[1024 * 1024 * 5];
                int len;
                while ((len = zis.read(bs)) != -1) {
                    bos.write(bs, 0, len);
                }
                bos.close();
                zis.closeEntry();
            }
        }
        zis.close();
    }
}
