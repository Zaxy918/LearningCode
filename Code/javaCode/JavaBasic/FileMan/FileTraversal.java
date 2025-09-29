import java.io.File;

public class FileTraversal {
    public static void main(String[] args) {
        File rootFile = new File("D:\\temp");
        fileTravel(rootFile);
    }

    public static void fileTravel(File root) {
        if (root != null) {
            File[] files = root.listFiles();
            for (File file : files) {
                if (file.isDirectory()) {
                    System.out.println("Reaching dir: " + file.toString());
                    fileTravel(file);
                } else {
                    System.out.println("Reaching file: " + file.toString());
                }
            }
        }
    }
}
