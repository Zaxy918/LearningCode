package test.interfacetest;

public class PingpongPlayer extends Player implements SpeakEn {
    PingpongPlayer() {
        super();
    }

    PingpongPlayer(String name, int age) {
        super(name, age);
    }

    @Override
    public void learn() {
        System.out.println("Pingpong player is learning playing pingpong.");
    }

    @Override
    public void speakEnglish() {
        System.out.println("Pingpong player is speaking English.");
    }
}
