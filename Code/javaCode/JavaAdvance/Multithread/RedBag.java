import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RedBag {
    public static void test() {
        RedBagThread p1 = new RedBagThread();
        RedBagThread p2 = new RedBagThread();
        RedBagThread p3 = new RedBagThread();
        RedBagThread p4 = new RedBagThread();
        RedBagThread p5 = new RedBagThread();

        ExecutorService service = Executors.newFixedThreadPool(3);
        service.submit(p1);
        service.submit(p2);
        service.submit(p3);
        service.submit(p4);
        service.submit(p5);
    }
}
