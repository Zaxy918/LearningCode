package JavaClass;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Random;

public class MathClass {

    public static void main(String[] args) {
        BigInteger b1 = new BigInteger("123456789");
        BigInteger b2 = new BigInteger("987654321");
        System.out.println(b1.add(b2));
        System.out.println(b1.multiply(b2));
        System.out.println(b1.subtract(b2));
        System.out.println(b2.divide(b1));
        BigDecimal bd1 = new BigDecimal("0.1111113");
        BigDecimal bd2 = new BigDecimal(0.123128947);
        System.out.println(bd1.divide(bd2, 3, RoundingMode.HALF_UP));
        Random r = new Random();
        int[] arr = new int[10];
        arr = r.ints(10, 1, 100).toArray();
        for (int i : arr) {
            System.out.println(i);
        }
        System.out.println(Math.abs(-9));
    }
}
