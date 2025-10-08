package main;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

import imp.Student;

public class StuSys {
    public static void main(String[] args) throws Exception {

        ArrayList<Student> students = new ArrayList<>();

        while (true) {

            System.out.println("Hello, Student Management System!");
            System.out.println("1. Add Student");
            System.out.println("2. Delete Student");
            System.out.println("3. Update Student");
            System.out.println("4. View Student");
            System.out.println("5. Exit");

            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter your choice: ");
            String choice = scanner.next();
            switch (choice) {
            case "1":
                addStudent(students);
                break;
            case "2":
                deleteStudent(students);
                break;
            case "3":
                updateStudent(students);
                break;
            case "4":
                viewStudent(students);
                break;
            case "5":
                System.out.println("Exiting...");
                Thread.sleep(1000);
                scanner.close();
                System.exit(0);
            default:
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void addStudent(ArrayList<Student> students) {
        Scanner scanner = new Scanner(System.in);
        Student student = new Student();
        while (true) {
            System.out.print("Enter student ID: ");
            String id = scanner.next();
            if (isIdExist(students, id)) {
                System.out.println("ID already exists. Please try again.");
            } else {
                student.setId(id);
                System.out.print("Enter student Name: ");
                String name = scanner.next();
                student.setName(name);
                System.out.print("Enter student Age: ");
                int age = scanner.nextInt();
                scanner.nextLine();
                student.setAge(age);
                System.out.print("Enter student Location: ");
                String location = scanner.next();
                student.setLocation(location);
                students.add(student);
                System.out.println("Student added successfully.");
                return;
            }
        }
    }

    public static void deleteStudent(ArrayList<Student> students) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter student ID to delete: ");
            String id = scanner.next();
            if (!isIdExist(students, id)) {
                System.out.println("ID does not exist. Please try again.");
            } else {
                students.remove(getIndex(students, id));
                System.out.println("Student deleted successfully.");
                return;
            }
        }
    }

    public static void updateStudent(ArrayList<Student> students) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter a student id you want to update: ");
            String id = scanner.next();
            if (!isIdExist(students, id)) {
                System.out.println("Id doesn't exist, please try again.");
                return;
            } else {
                Student student = students.get(getIndex(students, id));
                System.out.print("Enter new id: ");
                String newId = scanner.next();
                student.setId(newId);
                System.out.print("Enter new name: ");
                String newName = scanner.next();
                student.setName(newName);
                System.out.print("Enter new age: ");
                int newAge = scanner.nextInt();
                scanner.nextLine();
                student.setAge(newAge);
                System.out.print("Enter new location: ");
                String newLocation = scanner.nextLine();
                student.setLocation(newLocation);
                System.out.println("Student updated successfully.");
                return;
            }
        }
    }

    public static void viewStudent(ArrayList<Student> students) {
        if (students.size() == 0) {
            System.out.println("No students found.");
            return;
        }
        System.out.printf("%-16s %-8s %-8s %-8s\n", "ID", "Name", "Age", "Location");
        for (Student student : students) {
            System.out.printf("%-16s %-8s %-8d %-8s\n", student.getId(), student.getName(), student.getAge(), student.getLocation());
        }
        return;
    }

    public static boolean isIdExist(ArrayList<Student> students, String id) {
        return getIndex(students, id) >= 0;
    }

    public static int getIndex(ArrayList<Student> students, String id) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }
}
