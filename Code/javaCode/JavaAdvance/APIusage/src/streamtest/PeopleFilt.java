package streamtest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;

public class PeopleFilt {
    public static void test() {
        ArrayList<String> peo = new ArrayList<>();
        Collections.addAll(peo, "Zhangsan,23", "Lisi,24", "Wangwu,25");
        Map<String, Integer> map = peo.stream().filter(p -> Integer.parseInt(p.split(",")[1]) >= 24).collect(Collectors.toMap(k -> k.split(",")[0], v -> Integer.parseInt(v.split(",")[1])));
        System.out.println(map);
    }
}
