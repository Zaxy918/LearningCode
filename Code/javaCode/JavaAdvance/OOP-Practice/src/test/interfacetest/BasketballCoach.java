package test.interfacetest;

public class BasketballCoach extends Coach {
    public BasketballCoach() {
        super();
    }

    public BasketballCoach(String name, int age) {
        super(name, age);
    }

    @Override
    public void teach() {
        System.out.println("Basketball coach is teaching basketball.");
    }

}
