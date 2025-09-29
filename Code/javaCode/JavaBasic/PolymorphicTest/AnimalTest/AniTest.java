package PolymorphicTest.AnimalTest;

public class AniTest {
    public static void main(String[] args) {
        Animal[] ani = new Animal[4];
        ani[0] = new Cat();
        ani[1] = new Dog();
        ani[2] = new Cat();
        ani[3] = new Dog();
        for (int i = 0; i < 4; i++) {
            ani[i].move();
        }
        for (int i = 0; i < 4; i++) {
            haveLunch(ani[i]);
        }
        haveLunch(new Cat());
        haveLunch(new Dog());
        haveLunch(new Animal() {
            public void eat() {
                System.out.println("I eat");
            }
            public void move() {
                System.out.println("I move");
            }
        });
    }
    public static void haveLunch(Animal a) {
        a.eat();
    }
}
