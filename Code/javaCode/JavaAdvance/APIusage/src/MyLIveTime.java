import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class MyLIveTime {
    public static void test7() throws Exception {
        String birthDayStr = "2006-09-18";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date birDate = sdf.parse(birthDayStr);
        System.out.println((System.currentTimeMillis() - birDate.getTime()) / (1000 * 3600 * 24));
    }

    public static void test8() throws Exception {
        LocalDate ldtb = LocalDate.of(2006, 9, 18);
        LocalDate ldtn = LocalDate.now();
        System.out.println(ChronoUnit.DAYS.between(ldtb, ldtn));
    }
}
