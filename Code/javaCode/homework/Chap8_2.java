
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Chap8_2 {
    public static final int[] coe = { 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2 };
    public static final char[] last = { '1', '0', 'x', '9', '8', '7', '6', '5', '4', '3', '2' };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String id = sc.nextLine().trim().toLowerCase();
        sc.close();
        if (isValid(id)) {
            String dateInfo = id.substring(6, 14);
            DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("yyyyMMdd");
            LocalDate ldt = LocalDate.parse(dateInfo, dtf1);
            DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            System.out.println(dtf2.format(ldt));
        } else {
            System.out.println("0000-00-00");
        }
    }

    public static boolean isValid(String id) {
        if (id.length() != 18)
            return false;
        int sum = 0;
        for (int i = 0; i <= 17; i++) {
            if (i == 17) {
                if (!(id.charAt(i) == 'x' || Character.isDigit(id.charAt(i))))
                    return false;
            } else
                sum += (id.charAt(i) - '0') * coe[i];
        }
        if (last[sum % 11] != id.charAt(17))
            return false;
        return true;
    }
}