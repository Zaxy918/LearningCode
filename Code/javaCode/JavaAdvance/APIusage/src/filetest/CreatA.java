package filetest;

import java.io.File;
import java.io.IOException;

public class CreatA {
    public static void test() throws IOException {
        File file = new File("src\\filetest\\aaa");
        file.mkdir();
        File atxt = new File("src\\filetest\\aaa\\a.txt");
        atxt.createNewFile();
    }
}
