package dep;

public class TitlePrint {
    public static void printNormalLibTitle() {
        System.out.println("=============================================================");
        System.out.println("==========Welcome to the Library Management System!==========");
        System.out.println("============You can now borrow and return books.=============");
        System.out.println("=============================================================");
    }

    public static void printAdminLibTitle() {
        System.out.println("=============================================================");
        System.out.println("==========Welcome to the Library Management System!==========");
        System.out.println("================You can now Manage your books.===============");
        System.out.println("=============================================================");
    }

    public static void printMainTitle() {
        System.out.println("=============================================================");
        System.out.println("==========Welcome to the Library Management System!==========");
        System.out.println("===============Please login or sign up first.================");
        System.out.println("=============================================================");
    }

    public static void printMainMenu() {
        System.out.println("1. Login");
        System.out.println("2. Sign up");
        System.out.println("3. Exit");
    }

    public static void printUserMenu() {
        System.out.println("1. Borrow Book");
        System.out.println("2. Return Book");
        System.out.println("3. List Books");
        System.out.println("4. Search Book");
        System.out.println("5. Exit");
        System.out.println("6. log out");
    }

    public static void printAdminMenu() {
        System.out.println("1. Add Book");
        System.out.println("2. Remove Book");
        System.out.println("3. List Books");
        System.out.println("4. Search Book");
        System.out.println("5. Borrow Book");
        System.out.println("6. Return Book");
        System.out.println("7. Exit");
        System.out.println("8. log out");
    }
}
