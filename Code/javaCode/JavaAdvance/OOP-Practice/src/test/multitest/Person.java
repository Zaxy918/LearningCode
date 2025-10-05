package test.multitest;

public class Person {
    private int age;
    private String name;

    Person() {

    }

    Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void keepPet(Animal pet, String sth) {
        if (pet instanceof Dog d) {
            d.eat(sth);
            d.lookHome();
        }
        if (pet instanceof Cat c) {
            c.eat(sth);
            c.catchMouse();
        }
    }
}
