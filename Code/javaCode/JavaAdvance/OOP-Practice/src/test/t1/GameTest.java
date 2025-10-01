package test.t1;

public class GameTest {
    public static void main(String[] args) throws Exception {
        Role r1 = new Role("Tom", 100);
        Role r2 = new Role("Jerry", 100);
        while (true) {
            r1.attack(r2);
            if (r2.getBlood() == 0) {
                System.out.println(r2.getName() + " has been defeated!");
                break;
            }
            Thread.sleep(1000); // Pause for 1 second
            r2.attack(r1);
            if (r1.getBlood() == 0) {
                System.out.println(r1.getName() + " has been defeated!");
                break;
            }
        }
    }
}
