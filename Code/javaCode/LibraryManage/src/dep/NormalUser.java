package dep;

public class NormalUser extends User {
    private static final int MAX_BORROWED_BOOKS = 3;
    private int borrowedBooks;
    public static final boolean isAdmin = false;

    public NormalUser(String name, String id, String passWord) {
        super(name, id, passWord);
        this.borrowedBooks = 0;
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public String getId() {
        return super.getId();
    }

    @Override
    public void borrowBook(Book book) {
        if (borrowedBooks >= MAX_BORROWED_BOOKS) {
            System.out.println("User " + getName() + " cannot borrow more than " + MAX_BORROWED_BOOKS + " books.");
            return;
        }
        book.borrow();
        this.borrowedBooks++;
        System.out.println("User " + getName() + " borrowed the book: " + book.getTitle());
    }

    @Override
    public void returnBook(Book book) {
        book.returnBook();
        System.out.println("User " + getName() + " returned the book: " + book.getTitle());
    }

}
