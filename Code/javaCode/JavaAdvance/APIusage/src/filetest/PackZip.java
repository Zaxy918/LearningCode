package filetest;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class PackZip {
    public static void test() throws Exception {
        File src = new File("src\\filetest\\aaa");
        File dest = new File(src.getParent(), src.getName() + ".zip");
        ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(dest));
        zipFile(zos, src, src.getName());
        zos.close();
    }

    public static void zipFile(ZipOutputStream zos, File src, String name) throws Exception {
        File[] files = src.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    zipFile(zos, file, name + "\\" + file.getName());
                } else {
                    ZipEntry ze = new ZipEntry(name + "\\" + file.getName());
                    zos.putNextEntry(ze);
                    BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
                    int len;
                    byte[] bs = new byte[1024 * 1024 * 5];
                    while ((len = bis.read(bs)) != -1) {
                        zos.write(bs, 0, len);
                    }
                    bis.close();
                    zos.closeEntry();
                }
            }
        }
    }
}
