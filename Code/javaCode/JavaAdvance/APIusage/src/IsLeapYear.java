import java.time.LocalDate;
import java.util.Calendar;

public class IsLeapYear {
    public static void test7() {
        Calendar dCalendar = Calendar.getInstance();
        dCalendar.set(2024, 2, 1);
        dCalendar.add(Calendar.DAY_OF_MONTH, -1);
        if (dCalendar.get(Calendar.DAY_OF_MONTH) == 29) {
            System.out.println(dCalendar.get(Calendar.DAY_OF_MONTH));
            System.out.println("IsLeapYear.");
        }
    }

    public static void test8() {
        LocalDate ld = LocalDate.of(2000, 3, 1);
        if (ld.plusDays(-1).getDayOfMonth() == 29) {
            System.out.println("IsLeapYear");
        }
    }
}
