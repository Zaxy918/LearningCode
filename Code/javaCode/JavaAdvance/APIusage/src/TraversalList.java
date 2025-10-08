import java.util.ArrayList;

public class TraversalList {
    public static void test() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.forEach(n -> System.out.println(n));
    }
}
