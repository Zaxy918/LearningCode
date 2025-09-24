package homework;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Chap8_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String id = sc.nextLine().trim().toLowerCase();
        sc.close();
        if (!isValid(id)) {
            System.out.println("0000-00-00");
        } else {
            String dateInfo = id.substring(6, 14);
            try {
                SimpleDateFormat parser = new SimpleDateFormat("yyyyMMdd");
                Date birthDate = parser.parse(dateInfo);
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                System.out.println(formatter.format(birthDate));
            } catch (ParseException e) {
                System.out.println("0000-00-00");
            }
        }
    }

    public static boolean isValid(String id) {
        if (id.length() != 18)
            return false;
        for (int i = 0; i <= 17; i++) {
            if (i == 17) {
                if (!(id.charAt(i) == 'x' || Character.isDigit(id.charAt(i))))
                    return false;
            } else if (!Character.isDigit(id.charAt(i)))
                return false;
        }
        return true;
    }
}
