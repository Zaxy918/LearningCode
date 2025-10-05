package test.multitest;

public class Dog extends Animal {
    Dog() {
    }

    Dog(int age, String color) {
        super(age, color);
    }

    public void lookHome() {
        System.out.println("Dog is looking home.");
    }

    @Override
    public void eat(String sth) {
        System.out.println("Dog is eating " + sth);
    }
}
