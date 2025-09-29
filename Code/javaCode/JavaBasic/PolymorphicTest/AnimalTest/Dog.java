package PolymorphicTest.AnimalTest;

public class Dog implements Animal {
    public void eat(){
        System.out.println("Dog: I eat meat");
    }
    public void move(){
        System.out.println("Dog: I can swim");
    }
}
