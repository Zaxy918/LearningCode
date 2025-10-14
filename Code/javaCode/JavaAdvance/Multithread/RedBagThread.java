import java.util.Random;

public class RedBagThread extends Thread {
    public static int cnt = 3;
    public static double money = 100.0;

    @Override
    public void run() {
        synchronized (RedBagThread.class) {
            if (cnt == 0) {
                System.out.println(Thread.currentThread().getName() + " lose the luckmoney.");
                return;
            } else {
                if (cnt == 1) {
                    System.out.println(Thread.currentThread().getName() + " gain $" + RedBagThread.money);
                    cnt--;
                } else {
                    cnt--;
                    Random r = new Random();
                    double gain = r.nextDouble(0.02, money) - 0.01;
                    gain = Math.round(gain * 100.0) / 100.0;
                    RedBagThread.money -= gain;
                    System.out.println(Thread.currentThread().getName() + " gain $" + gain);
                }
            }
        }
    }
}
