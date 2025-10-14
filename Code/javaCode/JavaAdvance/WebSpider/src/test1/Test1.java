package test1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Test1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("src\\res\\name.txt"));
        String nameInfo;
        ArrayList<Student> stus = new ArrayList<>();
        while ((nameInfo = br.readLine()) != null) {
            String[] info = nameInfo.split("-");
            stus.add(new Student(info[0], info[1], Integer.parseInt(info[2]), Double.parseDouble(info[3])));
        }
        br.close();

        Double totalWeight = 0.0;
        for (Student stu : stus) {
            totalWeight += stu.getWeight();
        }

        Double[] weights = new Double[stus.size()];
        int idx = 0;
        for (Student stu : stus) {
            weights[idx++] = stu.getWeight() / totalWeight;
        }

        for (int i = 1; i < weights.length; i++) {
            weights[i] += weights[i - 1];
        }

        int index = -Arrays.binarySearch(weights, Math.random()) - 1;
        Student pickedStu = stus.get(index);
        System.out.println(pickedStu.getName());
        pickedStu.setWeight(pickedStu.getWeight() / 2);

        BufferedWriter bw = new BufferedWriter(new FileWriter("src\\res\\name.txt"));
        for (Student stu : stus) {
            bw.write(stu.toString());
            bw.newLine();
        }
        bw.close();
    }
}
