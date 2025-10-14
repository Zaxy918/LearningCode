public class Foodie implements Runnable {

    @Override
    public void run() {
        while (true) {
            synchronized (Desk.lock) {
                if (Desk.count == 0) {
                    break;
                } else {
                    if (Desk.flag == 1) {
                        System.out.println("Foodie is eating. Foodie can eat " + --Desk.count + " bowl of noodles more.");
                        Desk.flag = 0;
                        Desk.lock.notifyAll();
                    } else {
                        try {
                            Desk.lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

}