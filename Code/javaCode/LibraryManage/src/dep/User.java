package dep;

public abstract class User {
    private String name;
    private String id;
    private String passWord;

    public User(String name, String id, String passWord) {
        this.name = name;
        this.id = id;
        this.passWord = passWord;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getPassWord() {
        return passWord;
    }

    public abstract void borrowBook(Book book);

    public abstract void returnBook(Book book);

}
