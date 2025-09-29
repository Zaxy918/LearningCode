package dep;

public class Admin extends User {
    private static final int MAX_BORROWED_BOOKS = 5;
    private int borrowedBooks;

    public Admin(String name, String id, String passWord) {
        super(name, id, passWord);
        this.borrowedBooks = 0;
        this.isAdmin = true;
    }

    public void addBook(Book book) {
        Library.addBook(book);
        System.out.println("Admin " + getName() + " added the book: " + book.getTitle());
    }

    public void removeBook(Book book) {
        Library.removeBook(book);
        System.out.println("Admin " + getName() + " removed the book: " + book.getTitle());
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
            System.out.println("Admin " + getName() + " cannot borrow more than " + MAX_BORROWED_BOOKS + " books.");
            return;
        }
        book.borrow();
        this.borrowedBooks++;
        System.out.println("Admin " + getName() + " borrowed the book: " + book.getTitle());
    }

    @Override
    public void returnBook(Book book) {
        book.returnBook();
        this.borrowedBooks--;
        System.out.println("Admin " + getName() + " returned the book: " + book.getTitle());
    }

}