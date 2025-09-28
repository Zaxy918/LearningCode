package main;

import java.util.Scanner;

import dep.Admin;
import dep.NormalUser;
import dep.Users;
import dep.TitlePrint;
import dep.User;

public class Main {
    public static User currentUser = null;

    public static void main(String[] args) throws Exception {
        TitlePrint.printMainTitle();
        TitlePrint.printMainMenu();
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                scanner.nextLine();
                login();
                break;
            case 2:
                scanner.nextLine();
                signUp();
                break;
            case 3:
                System.out.println("Exiting...");
                Thread.sleep(1000);
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                main(null);
        }
    }

    public static void login() throws Exception {
        if (Users.getUsers().size() == 0) {
            System.out.println("No users found. Please sign up first.");
            signUp();
            return;
        }
        System.out.println("Enter your id: ");
        Scanner scanner = new Scanner(System.in);
        String id = scanner.nextLine();
        if (id.length() != 6) {
            System.out.println("Your id must be 6 numbers.");
            login();
        } else {
            System.out.println("Enter your password: ");
            String password = scanner.nextLine();
            if (Users.matchUser(id, password)) {
                System.out.println("Logging in...");
                Thread.sleep(1000);
                System.out.println("Logged in successfully.");
            } else {
                System.out.println("Your id or password is incorrect. Please try again.");
                login();
            }

        }
    }

    public static void signUp() throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your sign up option: ");
        System.out.println("1. User");
        System.out.println("2. Admin");
        int option = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        if (option != 1 && option != 2) {
            System.out.println("Invalid option. Please try again.");
            signUp();
        } else {
            System.out.println("Enter your name: ");
            String name = scanner.nextLine();
            if (name.length() > 10) {
                System.out.println("Your name can be at most 10 characters.");
                signUp();
            } else if (name.length() == 0) {
                System.out.println("Your name cannot be empty.");
                signUp();
            } else {
                System.out.println("Enter your id (6 numbers): ");
                String id = scanner.nextLine();
                if (id.length() != 6) {
                    System.out.println("Your id must be 6 numbers.");
                    signUp();
                } else {
                    System.out.println("Enter your password: ");
                    String password = scanner.nextLine();
                    if (password.length() < 6) {
                        System.out.println("Your password must be at least 6 characters.");
                        signUp();
                    } else {
                        System.out.println("Signing up...");
                        Thread.sleep(1000);
                        if (option == 1) {
                            Users.addUser(new NormalUser(name, id, password));
                        } else {
                            Users.addUser(new Admin(name, id, password));
                        }
                        System.out.println("You can now login with your id.");
                        login();
                    }
                }
            }
        }
    }
}
