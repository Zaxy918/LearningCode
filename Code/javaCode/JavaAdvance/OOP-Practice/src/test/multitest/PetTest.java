package test.multitest;

public class PetTest {
    public static void main(String[] args) {
        Person tom = new Person(19, "Foo");
        Animal dog = new Dog(10, "blue");
        Animal cat = new Cat(9, "pink");
        tom.keepPet(cat, "fish");
        tom.keepPet(dog, "meat");
    }
}
