package girfriendtest;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        GFriend[] gfs = new GFriend[5];
        gfs[0] = new GFriend("Alice", 20, 165.5);
        gfs[1] = new GFriend("Bob", 22, 170.2);
        gfs[2] = new GFriend("Cathy", 19, 160.0);
        gfs[3] = new GFriend("Diana", 21, 168.3);
        gfs[4] = new GFriend("Eva", 23, 172.4);
        Arrays.sort(gfs, (g1, g2) -> {
            if (g1.getAge() != g2.getAge()) {
                return Integer.compare(g1.getAge(), g2.getAge());
            } else if (g1.getHeight() != g2.getHeight()) {
                return Double.compare(g1.getHeight(), g2.getHeight());
            } else {
                return g1.getName().compareTo(g2.getName());
            }
        });
        for (GFriend gf : gfs) {
            System.out.println("Name: " + gf.getName() + ", Age: " + gf.getAge() + ", Height: " + gf.getHeight());
        }
    }
}