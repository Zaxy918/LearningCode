package PolymorphicTest.AnimalTest;

public class Cat implements Animal{
    public void eat(){
        System.out.println("Cat: I eat fish");
    }
    public void move(){
        System.out.println("Cat: I can climb trees");
    }
}
