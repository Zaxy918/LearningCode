package streamtest;

public class Student {
    String name;
    Integer age;

    public String getName() {
        return name;
    }

    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
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

    public static Student parseStudent(String s) {
        String[] parts = s.split(",");
        return new Student(parts[0], Integer.valueOf(parts[1]));
    }

    @Override
    public String toString() {
        return name + "-" + Integer.toString(age);
    }
}
