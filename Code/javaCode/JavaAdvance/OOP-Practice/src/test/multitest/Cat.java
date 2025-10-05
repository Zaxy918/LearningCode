package test.multitest;

public class Cat extends Animal {
    Cat() {
    }

    Cat(int age, String color) {
        super(age, color);
    }

    public void catchMouse() {
        System.out.println("Cat is catching mouse.");
    }

    @Override
    public void eat(String sth) {
        System.out.println("Cat is eating " + sth);
    }
}
