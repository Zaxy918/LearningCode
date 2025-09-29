import java.io.*;
import java.nio.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.EnumSet;

public class FileExMatch {
    public static int cnt = 0;

    public static void main(String[] args) throws IOException {
        Path rootPath = Paths.get("D:\\LearningCode\\Code\\javaCode\\");
        String ext = "*.java";
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:" + ext);
        Files.walkFileTree(rootPath, EnumSet.of(FileVisitOption.FOLLOW_LINKS), Integer.MAX_VALUE, new SimpleFileVisitor<Path>() {

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
                if (matcher.matches(file.getFileName())) {
                    System.out.println("Find file" + file.toString());
                    cnt++;
                }
                return FileVisitResult.CONTINUE;
            }
        });
        System.out.println("There are " + cnt + " files that match " + ext);
    }
}
