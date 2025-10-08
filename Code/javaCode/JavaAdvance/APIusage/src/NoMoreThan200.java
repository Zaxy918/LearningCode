import java.util.ArrayList;
import java.util.Scanner;

public class NoMoreThan200 {
    public static void test() {
        ArrayList<Integer> arr = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        while (true) {
            System.out.println("Enter a int.");
            Integer num = Integer.parseInt(sc.nextLine());
            if (num > 1 && num < 100) {
                arr.add(num);
                sum += num;
                if (sum > 200)
                    break;
            } else {
                System.out.println("Not valid.Input false.");
            }
        }
        sc.close();
    }
}