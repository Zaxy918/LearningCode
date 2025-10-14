package filetest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DirCopy {
    public static void test() throws IOException {
        File src = new File("src");
        File dest = new File("lib\\dest");
        copyDir(src, dest);
    }

    public static void copyDir(File src, File dest) throws IOException {
        dest.mkdirs();
        File[] srcFiles = src.listFiles();
        for (File file : srcFiles) {
            if (file.isFile()) {
                FileInputStream fis = new FileInputStream(file);
                FileOutputStream fos = new FileOutputStream(new File(dest, file.getName()));
                byte[] bytes = new byte[1024 * 1024 * 5];
                int len;
                while ((len = fis.read(bytes)) != -1) {
                    fos.write(bytes, 0, len);
                }
                fos.close();
                fis.close();
            } else {
                copyDir(file, new File(dest, file.getName()));
            }
        }
    }
}
