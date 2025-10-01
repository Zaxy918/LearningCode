package test.t4;

import java.util.Scanner;

public class CarTest {
    public static void main(String[] args) {
        Car[] carArray = new Car[3];

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter brand for Car 1: ");
        String brand1 = scanner.nextLine();
        System.out.print("Enter color for Car 1: ");
        String color1 = scanner.nextLine();
        System.out.print("Enter price for Car 1: ");
        double price1 = scanner.nextDouble();
        scanner.nextLine();  // Consume newline

        System.out.print("Enter brand for Car 2: ");
        String brand2 = scanner.nextLine();
        System.out.print("Enter color for Car 2: ");
        String color2 = scanner.nextLine();
        System.out.print("Enter price for Car 2: ");
        double price2 = scanner.nextDouble();
        scanner.nextLine();  // Consume newline

        System.out.print("Enter brand for Car 3: ");
        String brand3 = scanner.nextLine();
        System.out.print("Enter color for Car 3: ");
        String color3 = scanner.nextLine();
        System.out.print("Enter price for Car 3: ");
        double price3 = scanner.nextDouble();

        scanner.close();

        Car c1 = new Car(brand1, color1, price1);
        Car c2 = new Car(brand2, color2, price2);
        Car c3 = new Car(brand3, color3, price3);

        carArray[0] = c1;
        carArray[1] = c2;
        carArray[2] = c3;

        for (Car c : carArray) {
            System.out.println("Brand: " + c.getBrand() + ", Color: " + c.getColor() + ", Price: " + c.getPrice());
        }
    }
}
