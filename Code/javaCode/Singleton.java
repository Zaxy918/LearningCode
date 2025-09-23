public class Singleton {
    private static Singleton obj = new Singleton();
    private String content;

    private Singleton() {//The constructor is private.
        this.content = "abc";
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public static Singleton getInstance() {
        return obj;
    }

    public static void main(String[] args) {
        Singleton obj1 = Singleton.getInstance();
        Singleton obj2 = Singleton.getInstance();
        System.out.println(obj1 == obj2);
    }
}
