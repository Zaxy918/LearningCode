package streamtest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class NumFilt {
    public static void test() {
        ArrayList<Integer> arr = new ArrayList<>();
        Collections.addAll(arr, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> even = arr.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
        System.out.println(even);
    }
}
