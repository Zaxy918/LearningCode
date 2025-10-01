package test.t1;

import java.util.Random;

public class Role {
    private String name;
    private int blood;

    public Role() {
    }

    public Role(String name, int blood) {
        this.name = name;
        this.blood = blood;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBlood() {
        return blood;
    }

    public void setBlood(int blood) {
        this.blood = blood;
    }

    public void attack(Role role) {
        Random r = new Random();
        int damage = r.nextInt(20) + 1;
        // Ensure blood does not go below 0
        role.setBlood((role.getBlood() - damage) < 0 ? 0 : (role.getBlood() - damage));
        // Print attack details
        System.out.println(this.getName() + " attacks " + role.getName() + " for " + damage + " damage.");
        System.out.println(role.getName() + " has " + role.getBlood() + " blood left.");
    }
}