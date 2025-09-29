package dep;

import java.util.ArrayList;

public class Library {

    private static ArrayList<Book> books;
    private static final int MAX_BOOKS = 100;

    static {
        books = new ArrayList<Book>(MAX_BOOKS);
    }

    public static void addBook(Book book) {
        if (books.size() < MAX_BOOKS) {
            books.add(book);
        } else {
            System.out.println("Library is full. Cannot add more books.");
        }
    }

    public static void removeBook(Book book) {
        books.remove(book);
    }

    public static ArrayList<Book> getBooks() {
        return books;
    }

    public static Book searchBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }
}
