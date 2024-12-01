/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LinkedList;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Vanto
 */
public class StudentLinkedListApp {
    public static void main(String[] args) {
        // Create instance of Linked List
        StudentLinkedList studentList = new StudentLinkedList();

        // Create a Scanner object for user input
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        do {
            // Display the menu
            System.out.println("\nStudent Management System (Linked List)");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Search Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Edit Student");
            System.out.println("6. Sort Students");
            System.out.println("7. Exit");

            // Handle invalid input for menu option
            boolean validChoice = false;
            while (!validChoice) {
                try {
                    System.out.print("Enter your choice: ");
                    choice = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character
                    validChoice = true; // If input is valid, exit the loop
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input! Please enter a valid number.");
                    scanner.nextLine(); // Clear the buffer
                }
            }
            

            switch (choice) {
                case 1:
                    // Add Student
                    int id = 0;
                    String name = "";
                    double marks = 0;

                    // Handle invalid input for Student ID
                    boolean validId = false;
                    while (!validId) {

                            System.out.print("Enter Student ID: ");
                            id = scanner.nextInt();  // Try to read the ID as an integer
                            scanner.nextLine(); // Consume newline character after nextInt()
                            validId = true;  // If input is valid, set flag to true and exit the loop
 
                    }

                    // Handle invalid input for Student Name (assuming non-empty name is required)
                    System.out.print("Enter Student Name: ");
                    name = scanner.nextLine();

                    // Handle invalid input for Marks
                    boolean validMarks = false;
                    while (!validMarks) {
                        try {
                            System.out.print("Enter Student Marks: ");
                            marks = scanner.nextDouble();  // Try to read the marks as a double
                            validMarks = true;  // If input is valid, set flag to true and exit the loop
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input! Please enter valid marks (a number).");
                            scanner.nextLine(); // Clear the buffer
                        }
                    }

                    studentList.addStudent(id, name, marks);
                    System.out.println("Student added successfully!");
                    break;

                case 2:
                    // Remove Student
                    System.out.print("Enter Student ID to remove: ");
                    int removeId = scanner.nextInt();
                    studentList.removeStudent(removeId);
                    break;

                case 3:
                    // Search Student
                    System.out.print("Enter Student ID to search: ");
                    int searchId = scanner.nextInt();
                    StudentNode studentFound = studentList.searchStudent(searchId);

                    if (studentFound != null) {
                        System.out.println("Student found: ID: " + studentFound.id + ", Name: " + studentFound.name + ", Marks: " + studentFound.marks + ", Rank: " + studentFound.rank);
                    } else {
                        System.out.println("Student not found!");
                    }
                    break;

                case 4:
                    // Display All Students
                    studentList.displayStudents();
                    break;

                case 5:
                    // Edit Student
                    System.out.print("Enter Student ID to edit: ");
                    int editId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character
                    studentList.editStudent(editId, scanner);
                    break;

                case 6:
                    // Sort Students
                    System.out.println("Choose Sorting Option: ");
                    System.out.println("1. Sort by ID");
                    System.out.println("2. Sort by Rank");
                    int sortChoice = 0;

                    // Handle invalid input for sorting option
                    boolean validSortChoice = false;
                    while (!validSortChoice) {
                        try {
                            System.out.print("Enter your option: ");
                            sortChoice = scanner.nextInt();
                            validSortChoice = true; // If input is valid, set flag to true and exit the loop
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input! Please enter a valid number for sorting.");
                            scanner.nextLine(); // Clear the buffer
                        }
                    }

                    if (sortChoice == 1) {
                        studentList.sortStudentsById();                      
                    } else if (sortChoice == 2) {
                        studentList.sortStudentsByRank();
                    } else {
                        System.out.println("Invalid choice!");
                    }
                    break;

                case 7:
                    // Exit
                    System.out.println("Exiting Student Management System...");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 7); // Loop until user chooses to exit

        // Close the scanner object
        scanner.close();
    }
}

