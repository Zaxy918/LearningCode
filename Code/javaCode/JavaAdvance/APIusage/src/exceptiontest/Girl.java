package exceptiontest;

public class Girl {
    String name;
    Integer age;

    public Girl() {
    }

    public Girl(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.length() < 3 || name.length() > 10) {
            throw new NameFormatException("Name is in wrong format");
        }
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        if (age < 18 || age > 40) {
            throw new AgeOutofBoundException("Age out of bound");
        }
        this.age = age;
    }

    @Override
    public String toString() {
        return "Girl [name=" + name + ", age=" + age + "]";
    }
}
