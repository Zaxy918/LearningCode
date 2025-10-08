package girfriendtest;

public class GFriend {
    private String name;
    private int age;
    private double height;

    public GFriend() {
        this.name = "unknown";
        this.age = 0;
        this.height = 0.0;
    }

    public GFriend(String name, int age, double height) {
        this.name = name;
        this.age = age;
        this.height = height;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public double getHeight() {
        return this.height;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setHeight(double height) {
        this.height = height;
    }

}
