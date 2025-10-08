package streamtest;

public class Actor {
    String name;
    Integer age;

    public Actor() {
    }

    public Actor(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public static Actor parseActor(String s) {
        String[] parts = s.split(",");
        return new Actor(parts[0], Integer.valueOf(parts[1]));
    }
}
