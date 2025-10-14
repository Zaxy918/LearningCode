package filetest;

import java.io.File;
import java.util.ArrayList;

public class FindAllAvi {
    public static void test() {
        File[] rootFiles = File.listRoots();
        ArrayList<String> avis = new ArrayList<>();
        for (File rootFile : rootFiles) {
            findAllAvi(avis, rootFile);
        }
        System.out.println(avis);
    }

    public static void findAllAvi(ArrayList<String> avis, File rootFile) {
        if (rootFile.isFile()) {
            if (rootFile.getName().endsWith("docker")) {
                avis.add(rootFile.getAbsolutePath());
                return;
            }
            return;
        } else {
            File[] files = rootFile.listFiles();
            if (files == null)
                return;
            for (File f : files) {
                findAllAvi(avis, f);
            }
        }
    }
}
