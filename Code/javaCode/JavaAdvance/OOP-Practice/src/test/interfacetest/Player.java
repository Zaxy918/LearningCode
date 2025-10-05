package test.interfacetest;

public abstract class Player extends People{
    Player() {
        super();
    }
    Player(String name, int age) {
        super(name, age);
    }

    public abstract void learn();
}
