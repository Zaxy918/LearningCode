package test.interfacetest;

public class PingpongCoach extends Coach implements SpeakEn {
    public PingpongCoach() {
        super();
    }

    public PingpongCoach(String name, int age) {
        super(name, age);
    }

    @Override
    public void teach() {
        System.out.println("Pingpong coach is teaching pingpong.");
    }

    @Override
    public void speakEnglish() {
        System.out.println("Pingpong coach is speaking English.");
    }
}
