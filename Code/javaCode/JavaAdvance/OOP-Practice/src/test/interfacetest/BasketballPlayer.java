package test.interfacetest;

public class BasketballPlayer extends Player {
    BasketballPlayer() {
        super();
    }

    BasketballPlayer(String name, int age) {
        super(name, age);
    }

    @Override
    public void learn() {
        System.out.println("Basketball player learning basketball skills");
    }
}
