import java.io.*;

public class hellotxt {
    public static void main(String[] args) {
        try (FileWriter writer = new FileWriter("D:\\temp\\hello.txt")) {
            writer.write("Hello world!");
            System.out.println("File written successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileReader reader = new FileReader("D:\\temp\\hello.txt"); BufferedReader br = new BufferedReader(reader)) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
