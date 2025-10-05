package test.multitest;

public class Animal {
    private int age;
    private String color;

    Animal() {
    }

    Animal(int age, String color) {
        this.age = age;
        this.color = color;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void eat(String sth) {
        System.out.println("Eating sth.");
    }
}
