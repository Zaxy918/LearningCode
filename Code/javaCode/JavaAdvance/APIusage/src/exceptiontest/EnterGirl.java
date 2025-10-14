package exceptiontest;

import java.util.Scanner;

public class EnterGirl {
    public static void aaa() {
        Scanner sc = new Scanner(System.in);
        Girl g = new Girl();
        while (true) {
            try {
                String scName = sc.nextLine();
                Integer scAge = Integer.parseInt(sc.nextLine());
                g.setAge(scAge);
                g.setName(scName);
                System.out.println(g);
                break;
            } catch (NumberFormatException e) {
                e.printStackTrace();
            } catch (AgeOutofBoundException e) {
                e.printStackTrace();
            } catch (NameFormatException e) {
                e.printStackTrace();
            }
        }
        sc.close();
    }
}
