public class SellTickets {
    public static void test() {
        Thread t1 = new Thread(new SellTicketsThread());
        Thread t2 = new Thread(new SellTicketsThread());
        t1.start();
        t2.start();
    }
}
