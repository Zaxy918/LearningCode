package JavaClass;

import java.text.DecimalFormat;
import java.text.Format;
import java.text.MessageFormat;

public class FormatClass {
    public static void main(String[] args) {
        DecimalFormat df1, df2;
        df1 = new DecimalFormat("#.00");// Ignore 0.
        df2 = new DecimalFormat("0.00");// Keep two digits.
        System.out.println(df1.format(0.1) + "," + df2.format(0.1));
        df1 = new DecimalFormat("0.00");
        df2 = new DecimalFormat("0.##");// Ignore 0.
        System.out.println(df1.format(0.1) + "," + df2.format(0.1));
        df1 = new DecimalFormat("#,##0.00");// Add "," ever three digit.
        System.out.println(df1.format(3884729.891));

        // MessageFormat DateFormat is to be continued.
    }
}
