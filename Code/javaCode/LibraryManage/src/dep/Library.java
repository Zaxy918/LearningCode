package dep;

import java.util.ArrayList;

public class Library {

    private static ArrayList<Book> books;

    private Library() {
        books = new ArrayList<>();
    }

    public static void addBook(Book book) {
        books.add(book);
    }

    public static void removeBook(Book book) {
        books.remove(book);
    }

    public static ArrayList<Book> listBooks() {
        return books;
    }

    public static void searchBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                System.out.println("Book found: " + book.getTitle() + " by " + book.getAuthor());
                return;
            }
        }
        System.out.println("Book not found.");
    }
}
