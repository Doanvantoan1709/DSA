/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Stack;
import java.util.Scanner;
import java.util.InputMismatchException;

/**
 *
 * @author Vanto
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentStack stack = new StudentStack();
        int choice = -1;

        do {
            System.out.println("\nStudent Stack Menu:");
            System.out.println("1. Push Student");
            System.out.println("2. Pop Student");
            System.out.println("3. Peek Student");
            System.out.println("4. Display Stack");
            System.out.println("5. Sort by ID (Ascending)");
            System.out.println("6. Sort by Rank (Descending)");
            System.out.println("0. Exit");

            // Handle invalid input for menu choice
            boolean validChoice = false;
            while (!validChoice) {
                try {
                    System.out.print("Enter your choice: ");
                    choice = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    validChoice = true;  // Exit loop if input is valid
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input! Please enter a valid number for choice.");
                    scanner.nextLine();  // Clear invalid input
                }
            }

            switch (choice) {
                case 1:
                    // Push a student to the stack
                    int id = 0;
                    String name = "";
                    double marks = 0.0;

                    // Handle invalid input for Student ID
                    boolean validId = false;
                    while (!validId) {
                        try {
                            System.out.print("Enter Student ID: ");
                            id = scanner.nextInt();
                            scanner.nextLine(); // Consume newline
                            validId = true;
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input! Please enter a valid integer ID.");
                            scanner.nextLine(); // Clear invalid input
                        }
                    }

                    // Input Student Name
                    System.out.print("Enter Student Name: ");
                    name = scanner.nextLine();

                    // Handle invalid input for Student Marks
                    boolean validMarks = false;
                    while (!validMarks) {
                        try {
                            System.out.print("Enter Student Marks: ");
                            marks = scanner.nextDouble();
                            scanner.nextLine(); // Consume newline
                            validMarks = true;
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input! Please enter a valid number for marks.");
                            scanner.nextLine(); // Clear invalid input
                        }
                    }

                    stack.push(new Student(id, name, marks));
                    break;

                case 2:
                    // Pop a student from the stack
                    Student poppedStudent = stack.pop();
                    if (poppedStudent != null) {
                        System.out.println("Popped Student: " + poppedStudent);
                    } else {
                        System.out.println("Stack is empty, nothing to pop.");
                    }
                    break;

                case 3:
                    // Peek at the top student
                    Student peekedStudent = stack.peek();
                    if (peekedStudent != null) {
                        System.out.println("Top Student: " + peekedStudent);
                    } else {
                        System.out.println("Stack is empty, nothing to peek at.");
                    }
                    break;

                case 4:
                    // Display all students in the stack
                    stack.displayStudents();
                    break;

                case 5:
                    // Sort stack by ID (ascending)
                    stack.sortById();
                    break;

                case 6:
                    // Sort stack by Rank (descending)
                    stack.sortByRank();
                    break;

                case 0:
                    System.out.println("Exiting program.");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);

        scanner.close();
    }
}
