public class SellTicketsThread implements Runnable {

    public static int tickets = 100;

    @Override
    public void run() {
        while (true) {
            synchronized (SellTicketsThread.class) {
                if (SellTicketsThread.tickets < 10) {
                    break;
                } else {
                    System.out.println(Thread.currentThread().getName() + " is giving the " + tickets-- + "th tickets.");
                }
            }
        }
    }

}
