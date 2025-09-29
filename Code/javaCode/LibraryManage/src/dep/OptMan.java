package dep;

import java.util.Scanner;
import main.Main;

public class OptMan {
    public static User login(User currentUser, Scanner scanner) throws Exception {
        if (Users.getUsers().size() == 0) {
            System.out.println("No users found. Please sign up first.");
            return signUp(currentUser, scanner);
        }
        System.out.println("Enter your id: ");
        String id = scanner.nextLine();
        if (id.length() != 6) {
            System.out.println("Your id must be 6 numbers.");
            return login(currentUser, scanner);
        } else {
            System.out.println("Enter your password: ");
            String password = scanner.nextLine();
            User user = Users.getUser(id, password);
            if (user != null) {
                System.out.println("Logging in...");
                Thread.sleep(1000);
                System.out.println("Logged in successfully.");
                return user;
            } else {
                System.out.println("Your id or password is incorrect. Please try again.");
                return login(currentUser, scanner);
            }
        }
    }

    public static User signUp(User currentUser, Scanner scanner) throws Exception {
        System.out.println("Enter your sign up option: ");
        System.out.println("1. User");
        System.out.println("2. Admin");
        int option = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        if (option != 1 && option != 2) {
            System.out.println("Invalid option. Please try again.");
            return signUp(currentUser, scanner);
        } else {
            System.out.println("Enter your name: ");
            String name = scanner.nextLine();
            if (name.length() > 10) {
                System.out.println("Your name can be at most 10 characters.");
                return signUp(currentUser, scanner);
            } else if (name.length() == 0) {
                System.out.println("Your name cannot be empty.");
                return signUp(currentUser, scanner);
            } else {
                System.out.println("Enter your id (6 numbers): ");
                String id = scanner.nextLine();
                if (id.length() != 6) {
                    System.out.println("Your id must be 6 numbers.");
                    return signUp(currentUser, scanner);
                } else {
                    if (Users.userExists(id)) {
                        System.out.println("This id is already taken. Please try again.");
                        return signUp(currentUser, scanner);
                    }
                    System.out.println("Enter your password: ");
                    String password = scanner.nextLine();
                    if (password.length() < 6) {
                        System.out.println("Your password must be at least 6 characters.");
                        return signUp(currentUser, scanner);
                    } else {
                        System.out.println("Signing up...");
                        Thread.sleep(1000);
                        User newUser;
                        if (option == 1) {
                            newUser = new NormalUser(name, id, password);
                            Users.addUser(newUser);
                        } else {
                            newUser = new Admin(name, id, password);
                            Users.addUser(newUser);
                        }
                        System.out.println("You can now login with your id.");
                        return OptMan.login(currentUser, scanner);
                    }
                }
            }
        }
    }

    public static void libChoiceManage(int choice, User currentUser, Scanner scanner) throws Exception {
        int newChoice;
        switch (choice) {
            case 1:
                if (currentUser.isAdmin) {
                    // Add Book
                    System.out.println("Title: ");
                    String title = scanner.nextLine();
                    if (title.equals("q")) {
                        if (currentUser.isAdmin) {
                            TitlePrint.printAdminMenu();
                        } else {
                            TitlePrint.printUserMenu();
                        }
                        newChoice = scanner.nextInt();
                        scanner.nextLine(); // Consume the newline character
                        libChoiceManage(newChoice, currentUser, scanner);
                        return;
                    }
                    System.out.println("Author: ");
                    String author = scanner.nextLine();
                    if (author.equals("q")) {
                        if (currentUser.isAdmin) {
                            TitlePrint.printAdminMenu();
                        } else {
                            TitlePrint.printUserMenu();
                        }
                        newChoice = scanner.nextInt();
                        scanner.nextLine(); // Consume the newline character
                        libChoiceManage(newChoice, currentUser, scanner);
                        return;
                    }
                    if (title.length() == 0 || author.length() == 0) {
                        System.out.println("Title and Author cannot be empty. Please try again.(q to quit)");
                        libChoiceManage(choice, currentUser, scanner);
                        return;
                    } else {
                        if (Library.searchBook(title) != null) {
                            System.out.println("This book already exists. Please try again.(q to quit)");
                            libChoiceManage(choice, currentUser, scanner);
                            return;
                        }
                        Library.addBook(new Book(title, author));
                        System.out.println("Book \"" + title + "\" by " + author + " added successfully.");
                        TitlePrint.printAdminMenu();
                        newChoice = scanner.nextInt();
                        scanner.nextLine(); // Consume the newline character
                        libChoiceManage(newChoice, currentUser, scanner);
                        return;
                    }
                } else {
                    // Borrow Book
                    System.out.println("Which book do you want to borrow? (Enter title. q to quit)");
                    String title = scanner.nextLine();
                    if (title.equals("q")) {
                        if (currentUser.isAdmin) {
                            TitlePrint.printAdminMenu();
                        } else {
                            TitlePrint.printUserMenu();
                        }
                        newChoice = scanner.nextInt();
                        scanner.nextLine(); // Consume the newline character
                        libChoiceManage(newChoice, currentUser, scanner);
                        return;
                    }
                    Book book = Library.searchBook(title);
                    if (book != null) {
                        if (book.isBorrowed()) {
                            System.out.println("Sorry, this book is already borrowed.");
                            libChoiceManage(choice, currentUser, scanner);
                            return;
                        }
                        currentUser.borrowBook(book);
                        TitlePrint.printUserMenu();
                        newChoice = scanner.nextInt();
                        scanner.nextLine(); // Consume the newline character
                        libChoiceManage(newChoice, currentUser, scanner);
                    } else {
                        System.out.println("Book not found. Please try again.");
                        libChoiceManage(choice, currentUser, scanner);
                        return;
                    }
                }
            case 2:
                if (currentUser.isAdmin) {
                    // Remove Book
                    System.out.println("Which book do you want to remove? (Enter title. q to quit)");
                    String title = scanner.nextLine();
                    if (title.equals("q")) {
                        TitlePrint.printAdminMenu();
                        newChoice = scanner.nextInt();
                        scanner.nextLine(); // Consume the newline character
                        libChoiceManage(newChoice, currentUser, scanner);
                        return;
                    }
                    Book book = Library.searchBook(title);
                    if (book != null) {
                        if (book.isBorrowed()) {
                            System.out.println("The book is currently borrowed and cannot be removed.");
                            libChoiceManage(choice, currentUser, scanner);
                            return;
                        }
                        Library.removeBook(book);
                        System.out.println("Book \"" + book.getTitle() + "\" removed successfully.");
                        TitlePrint.printAdminMenu();
                        newChoice = scanner.nextInt();
                        scanner.nextLine(); // Consume the newline character
                        libChoiceManage(newChoice, currentUser, scanner);
                    } else {
                        System.out.println("Book not found. Please try again.");
                        libChoiceManage(choice, currentUser, scanner);
                    }
                } else {
                    // Return Book
                    System.out.println("Which book do you want to return? (Enter title. q to quit)");
                    String title = scanner.nextLine();
                    if (title.equals("q")) {
                        TitlePrint.printUserMenu();
                        newChoice = scanner.nextInt();
                        scanner.nextLine(); // Consume the newline character
                        libChoiceManage(newChoice, currentUser, scanner);
                        return;
                    }
                    Book book = Library.searchBook(title);
                    if (book != null) {
                        if (!book.isBorrowed()) {
                            System.out.println("This book was not borrowed.");
                            libChoiceManage(choice, currentUser, scanner);
                            return;
                        }
                        currentUser.returnBook(book);
                        TitlePrint.printUserMenu();
                        newChoice = scanner.nextInt();
                        scanner.nextLine(); // Consume the newline character
                        libChoiceManage(newChoice, currentUser, scanner);
                    } else {
                        System.out.println("Book not found. Please try again.");
                        libChoiceManage(choice, currentUser, scanner);
                    }
                }
                break;
            case 3:
                // List Books
                System.out.println("Listing all books:");
                for (Book book : Library.getBooks()) {
                    System.out.println("- " + book.getTitle() + " by " + book.getAuthor()
                            + (book.isBorrowed() ? " (Borrowed)" : ""));
                }
                System.out.println("==========End of list===========");
                if (currentUser.isAdmin) {
                    TitlePrint.printAdminMenu();
                } else {
                    TitlePrint.printUserMenu();
                }
                newChoice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character
                libChoiceManage(newChoice, currentUser, scanner);
                break;
            case 4:
                // Search Book
                System.out.println("Enter book title to search(q to quit):");
                String searchTitle = scanner.nextLine();
                if (searchTitle.equals("q")) {
                    if (currentUser.isAdmin) {
                        TitlePrint.printAdminMenu();
                    } else {
                        TitlePrint.printUserMenu();
                    }
                    newChoice = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    libChoiceManage(newChoice, currentUser, scanner);
                    return;
                }
                Book book = Library.searchBook(searchTitle);
                if (book != null) {
                    System.out.println("Book found: " + book.getTitle() + " by " + book.getAuthor());
                    if (currentUser.isAdmin) {
                        TitlePrint.printAdminMenu();
                    } else {
                        TitlePrint.printUserMenu();
                    }
                    newChoice = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    libChoiceManage(newChoice, currentUser, scanner);
                } else {
                    System.out.println("Book not found. Please try again.");
                    libChoiceManage(choice, currentUser, scanner);
                    return;
                }
                break;
            case 5:
                if (currentUser.isAdmin) {
                    // Borrow Book
                    System.out.println("Which book do you want to borrow? (Enter title. q to quit)");
                    String title = scanner.nextLine();
                    if (title.equals("q")) {
                        TitlePrint.printAdminMenu();
                        newChoice = scanner.nextInt();
                        scanner.nextLine(); // Consume the newline character
                        libChoiceManage(newChoice, currentUser, scanner);
                        return;
                    }
                    Book foundBook = Library.searchBook(title);
                    if (foundBook != null) {
                        if (foundBook.isBorrowed()) {
                            System.out.println("The book is currently borrowed and cannot be borrowed again.");
                            libChoiceManage(choice, currentUser, scanner);
                            return;
                        }
                        currentUser.borrowBook(foundBook);
                        System.out.println("Book borrowed successfully.");
                        TitlePrint.printAdminMenu();
                        newChoice = scanner.nextInt();
                        scanner.nextLine(); // Consume the newline character
                        libChoiceManage(newChoice, currentUser, scanner);
                        return;
                    } else {
                        System.out.println("Book not found. Please try again.");
                        libChoiceManage(choice, currentUser, scanner);
                        return;
                    }
                } else {
                    // Exit
                    System.out.println("Exiting...");
                    Thread.sleep(1000);
                    System.exit(0);
                }
                break;
            case 6:
                if (currentUser.isAdmin) {
                    // Return Book
                    System.out.println("Which book do you want to return? (Enter title. q to quit)");
                    String title = scanner.nextLine();
                    if (title.equals("q")) {
                        TitlePrint.printAdminMenu();
                        newChoice = scanner.nextInt();
                        scanner.nextLine(); // Consume the newline character
                        libChoiceManage(newChoice, currentUser, scanner);
                        return;
                    }
                    Book foundBook = Library.searchBook(title);
                    if (foundBook != null) {
                        if (!foundBook.isBorrowed()) {
                            System.out.println("This book was not borrowed.");
                            libChoiceManage(choice, currentUser, scanner);
                            return;
                        }
                        currentUser.returnBook(foundBook);
                        TitlePrint.printAdminMenu();
                        newChoice = scanner.nextInt();
                        scanner.nextLine(); // Consume the newline character
                        libChoiceManage(newChoice, currentUser, scanner);
                        return;
                    } else {
                        System.out.println("Book not found. Please try again.");
                        libChoiceManage(choice, currentUser, scanner);
                        return;
                    }
                } else {
                    // Log out
                    System.out.println("Logging out...");
                    Thread.sleep(1000);
                    currentUser = null;
                    Main.main(null);
                }
                break;
            case 7:
                if (currentUser.isAdmin) {
                    // Exit
                    System.out.println("Exiting...");
                    Thread.sleep(1000);
                    System.exit(0);
                } else {
                    // Invalid choice
                    System.out.println("Invalid choice. Please try again.");
                    TitlePrint.printUserMenu();
                    newChoice = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    libChoiceManage(newChoice, currentUser, scanner);
                    return;
                }
                break;
            case 8:
                if (currentUser.isAdmin) {
                    // Log out
                    System.out.println("Logging out...");
                    Thread.sleep(1000);
                    currentUser = null;
                    Main.main(null);
                } else {
                    // Invalid choice
                    System.out.println("Invalid choice. Please try again.");
                    TitlePrint.printUserMenu();
                    newChoice = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    libChoiceManage(newChoice, currentUser, scanner);
                    return;
                }
            default:
                System.out.println("Invalid choice. Please try again.");
                if (currentUser.isAdmin) {
                    TitlePrint.printAdminMenu();
                } else {
                    TitlePrint.printUserMenu();
                }
                newChoice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character
                libChoiceManage(newChoice, currentUser, scanner);
                return;
        }

    }
}
