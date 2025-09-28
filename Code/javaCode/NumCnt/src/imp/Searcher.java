package imp;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.util.ArrayList;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.FileSystems;

public class Searcher implements FileVisitor<Path> {

    private final PathMatcher matcher;
    private ArrayList<String> foundPaths = new ArrayList<String>();

    public Searcher(String ext) {
        this.matcher = FileSystems.getDefault().getPathMatcher("glob:" + ext);
    }

    public void judgeFile(Path file) {
        Path name = file.getFileName();
        if (name != null && matcher.matches(name)) {
            foundPaths.add(file.toString());
        }
    }

    public ArrayList<String> getFilePaths() {
        return foundPaths;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        System.out.println("Visiting file: " + file.toString());
        judgeFile(file);
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        System.err.println("Failed to visit file: " + file.toString());
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        return FileVisitResult.CONTINUE;
    }

}
