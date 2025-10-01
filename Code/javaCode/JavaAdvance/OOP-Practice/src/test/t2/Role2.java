package test.t2;

import java.util.Random;

public class Role2 {
    private String name;
    private int blood;
    private char gender;
    private String face;

    private static final String[] maleFaces = { "Handsome", "Charming", "Dashing", "Attractive", "Elegant" };
    private static final String[] femaleFaces = { "Beautiful", "Gorgeous", "Stunning", "Pretty", "Lovely" };
    private static final String[] attack_desc = {
        "%s swings a mighty punch at %s, dealing %d damage!",
        "%s swiftly kicks %s, causing %d damage!",
        "%s launches a surprise attack on %s, inflicting %d damage!",
        "%s uses a special move against %s, resulting in %d damage!",
        "%s strikes %s with a powerful blow, delivering %d damage!"
    };
    private static final String[] injured_desc = {
        "%s staggers from the hit, losing %d blood!",
        "%s reels back, taking %d damage!",
        "%s is hurt badly, blood reduced by %d!",
        "%s grits their teeth, suffering %d damage!",
        "%s falls to one knee, blood drops by %d!"
    };
    public Role2() {
    }

    public Role2(String name, int blood, char gender) {
        this.name = name;
        this.blood = blood;
        this.gender = gender;
        setFace(gender);
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

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getFace() {
        return face;
    }

    public void setFace(char gender) {
        Random random = new Random();
        if (gender == 'M') {
            this.face = maleFaces[random.nextInt(maleFaces.length)];
        } else if (gender == 'F') {
            this.face = femaleFaces[random.nextInt(femaleFaces.length)];
        } else {
            this.face = "Unknown";
        }
    }

    public void attack(Role2 role) {
        Random r = new Random();
        int index = r.nextInt(attack_desc.length);
        int damage = r.nextInt(20) + 1;
        System.out.printf(attack_desc[index], this.getName(), role.getName(), damage);
        System.out.println();
        // Ensure blood does not go below 0
        role.setBlood((role.getBlood() - damage) < 0 ? 0 : (role.getBlood() - damage));
        System.out.printf(injured_desc[index], role.getName(), damage);
        System.out.println();
    }

    public void showRoleInfo() {
        System.out.println("Name: " + name);
        System.out.println("Blood: " + blood);
        System.out.println("Gender: " + gender);
        System.out.println("Face: " + face);
    }
}