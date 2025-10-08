package genericitytest;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {

    }

    public static void keepPet(ArrayList<? extends Animal> pets) {
        for (Animal pet : pets) {
            if (pet instanceof Huskie) {
                System.out.println("Huskie");
            } else if (pet instanceof Persian) {
                System.out.println("Persian");
            } else if (pet instanceof LiHua) {
                System.out.println("Lihua");
            } else if (pet instanceof Teddy) {
                System.out.println("Teddy");
            }
        }
    }
}
