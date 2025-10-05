package test.interfacetest;

public abstract class Coach extends People{
    Coach() {
        super();
    }
    Coach(String name, int age) {
        super(name, age);
    }

    public abstract void teach();
}
