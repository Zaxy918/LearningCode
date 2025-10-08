package streamtest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class ActFilt {
    public static void test() {
        ArrayList<String> menActors = new ArrayList<>();
        ArrayList<String> womenActors = new ArrayList<>();
        Collections.addAll(menActors, "CXK,24", "YHX,23", "LBT,22", "WQ,24", "GJ,30", "XLL,27");
        Collections.addAll(womenActors, "ZXY,35", "YY,36", "GYY,43", "ZTT,31", "LS,35", "YXM,33");
        List<Actor> picked = Stream.concat(menActors.stream().filter(a -> a.split(",")[0].length() >= 3).limit(2), womenActors.stream().filter(a -> "Y".equals(a.split(",")[0])).skip(1)).map(Actor::parseActor).toList();
        picked.forEach(a -> System.out.println(a.getName() + ", " + a.getAge()));
    }
}
