package filetest;

import java.io.File;

public class DelMultiDir {
    public static void test() throws InterruptedException {
        File mkdir = new File("src\\filetest\\aaa\\bbb\\ccc\\ddd");
        mkdir.mkdirs();
        Thread.sleep(5000);
        File rootFile = new File("src\\filetest\\aaa");
        delMultiDir(rootFile);
    }

    public static void delMultiDir(File rootFile) {
        if (rootFile.delete()) {
            return;
        } else {
            File[] files = rootFile.listFiles();
            for (File f : files) {
                delMultiDir(f);
                f.delete();
            }
            rootFile.delete();
        }
    }

}
