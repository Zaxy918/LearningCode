package main;

import java.util.Scanner;

import dep.TitlePrint;
import dep.User;
import dep.OptMan;

public class Main {
    public static User currentUser = null;

    public static void main(String[] args) throws Exception {
        TitlePrint.printMainTitle();
        TitlePrint.printMainMenu();
        try (Scanner scanner = new Scanner(System.in)) {
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    scanner.nextLine();
                    currentUser = OptMan.login(currentUser, scanner);
                    break;
                case 2:
                    scanner.nextLine();
                    currentUser = OptMan.signUp(currentUser, scanner);
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
            if (currentUser.isAdmin) {
                TitlePrint.printAdminLibTitle();
                TitlePrint.printAdminMenu();
            } else {
                TitlePrint.printNormalLibTitle();
                TitlePrint.printUserMenu();
            }
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            OptMan.libChoiceManage(choice, currentUser, scanner);
        }
    }

}
