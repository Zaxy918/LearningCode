package JavaClass;

import java.util.Calendar;
import java.time.*;

public class TimeClass {
    static Calendar gc = Calendar.getInstance();// The default time is now.

    public static void main(String[] args) {
        // Equals to Calendar gc = GregorianCalendar();
        int year = gc.get(Calendar.YEAR);
        int month = gc.get(Calendar.MONTH) + 1;// Month is from 0 to 11.
        int day = gc.get(Calendar.DAY_OF_MONTH);
        int hour = gc.get(Calendar.HOUR);// HOUR_OF_DAY is 24 hours.
        int minute = gc.get(Calendar.MINUTE);
        int second = gc.get(Calendar.SECOND);
        int weekday = gc.get(Calendar.DAY_OF_WEEK);
        System.out.println(year + "year" + month + "month" + day + "day" + hour + "hour" + minute + "minute" + second + "second" + weekday + "week");
        System.out.println(LastdayOfMonth(2024, 2));

        LocalDate today = LocalDate.now();// Current date.
        LocalDate firstDay_2014 = LocalDate.of(2014, Month.JANUARY, 1);// Specific date.
        LocalDate todayBejing = LocalDate.now(ZoneId.of("Asia/Shanghai"));
        LocalDate dateBase = LocalDate.ofEpochDay(365);// The 365th day from base date.
        LocalDate hundredDay_2014 = LocalDate.ofYearDay(2014, 100);
        System.out.println(today + "," + firstDay_2014 + "," + todayBejing + "," + dateBase + "," + hundredDay_2014);

        LocalTime specificTime = LocalTime.of(20, 20, 20, 20);
        LocalTime timeSh = LocalTime.now(ZoneId.of("Asia/Shanghai"));
        LocalTime timeOfDay = LocalTime.ofSecondOfDay(10000);
        System.out.println(specificTime + "," + timeSh + "," + timeOfDay);

        // LocalDateTime is s=the conbination of those two.
    }

    public static int LastdayOfMonth(int year, int month) {
        gc.set(year, month, 1);// Set the current time.
        gc.add(Calendar.DATE, -1);// roll() do not match this.
        return gc.get(Calendar.DAY_OF_MONTH);
    }

    public static int LastdayOfMonth2(int year, int month) {
        LocalDate date = LocalDate.of(year, month, 1);
        date = date.minusDays(1);
        return date.getDayOfMonth();
    }
}
