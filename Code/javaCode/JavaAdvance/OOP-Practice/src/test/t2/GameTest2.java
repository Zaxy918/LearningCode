package test.t2;

public class GameTest2 {
    

    public static void main(String[] args) throws Exception {
        Role2 r1 = new Role2("Tom", 100, 'M');
        Role2 r2 = new Role2("Jerry", 100, 'F');
        r1.showRoleInfo();
        r2.showRoleInfo();
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
