package streamtest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Str2Stu {
    public static void test() {
        ArrayList<String> strStu = new ArrayList<>();
        Collections.addAll(strStu, "ZS,24", "LS,23", "MM,21");
        System.out.println(Arrays.toString(strStu.stream().map(Student::parseStudent).toArray()));
        List<Student> stus = strStu.stream().map(Student::parseStudent).toList();
        String[] stuArr = stus.stream().map(Student::getName).toArray(String[]::new);
        String[] stuStr = stus.stream().map(Student::toString).toArray(String[]::new);
        System.out.println(Arrays.toString(stuArr));
        System.out.println(Arrays.toString(stuStr));
    }
}
