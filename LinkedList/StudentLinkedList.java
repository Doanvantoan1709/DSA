/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LinkedList;

import java.util.Scanner;

/**
 *
 * @author Vanto
 */
public class StudentLinkedList {

    private StudentNode head;

    public StudentLinkedList() {
        this.head = null;
    }

    public void addStudent(int id, String name, double marks) {
        // Check if the ID already exists in the list
        StudentNode current = head;
        while (current != null) {
            if (current.id == id) {
                // ID already exists, display an error and return
                System.out.println("Error: Student ID " + id + " already exists. Please use a unique ID.");
                return; // Exit the method if ID is duplicated
            }
            current = current.next;
        }

        // If no duplicate ID is found, create a new student node and add it to the list
        StudentNode newStudent = new StudentNode(id, name, marks);
        if (head == null) {
            head = newStudent;
        } else {
            // Traverse to the end of the list and add the new student
            current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newStudent;
        }
    }

    // Remove student by ID
    public void removeStudent(int id) {
        if (head == null) {
            System.out.println("Student list is empty.");
            return;
        }
        if (head.id == id) {
            head = head.next;
            System.out.println("Student with ID " + id + " has been removed.");
            return;
        }

        StudentNode current = head;
        while (current.next != null && current.next.id != id) {
            current = current.next;
        }

        if (current.next == null) {
            System.out.println("Student with ID " + id + " not found.");
        } else {
            current.next = current.next.next;
            System.out.println("Student with ID " + id + " has been removed.");
        }
    }

    // Linear Search
    public StudentNode searchStudent(int id) {
        StudentNode current = head;
        while (current != null) {
            if (current.id == id) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    // Move-to-Front Search
    public StudentNode moveToFrontSearch(int id) {
        StudentNode current = head;
        StudentNode previous = null;

        while (current != null) {
            if (current.id == id) {
                // Move the found node to the front if it's not already there
                if (previous != null) {
                    previous.next = current.next;
                    current.next = head;
                    head = current;
                }
                return current;
            }
            previous = current;
            current = current.next;
        }
        return null; // Return null if the ID was not found
    }

    // Edit student by ID (allow name and marks to be edited)
    public void editStudent(int id, Scanner scanner) {
        StudentNode student = searchStudent(id);
        if (student != null) {
            System.out.println("Editing Student: ID: " + student.id + ", Name: " + student.name + ", Marks: " + student.marks);

            System.out.print("Enter new name (leave blank to keep current): ");
            String newName = scanner.nextLine();
            if (!newName.isEmpty()) {
                student.name = newName;
            }

            System.out.print("Enter new marks (leave blank to keep current): ");
            String newMarksInput = scanner.nextLine();
            if (!newMarksInput.isEmpty()) {
                try {
                    double newMarks = Double.parseDouble(newMarksInput);
                    student.marks = newMarks;
                    student.rank = student.assignRank(newMarks); // Reassign rank after updating marks
                } catch (NumberFormatException e) {
                    System.out.println("Invalid marks entered.");
                }
            }

            System.out.println("Student updated: ID: " + student.id + ", Name: " + student.name + ", Marks: " + student.marks + ", Rank: " + student.rank);
        } else {
            System.out.println("Student with ID " + id + " not found.");
        }
    }

    public void displayStudents() {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }

        StudentNode temp = head;
        while (temp != null) {
            System.out.println("ID: " + temp.id + ", Name: " + temp.name + ", Marks: " + temp.marks + ". Rank: " + temp.rank);
            temp = temp.next;
        }
    }

    public void sortStudentsById() {
        if (head == null || head.next == null) {
            System.out.println("List is already sorted or empty.");
            return;
        }
        StudentNode current = head;
        while (current != null) {
            StudentNode minNode = current;
            StudentNode nextNode = current.next;
            while (nextNode != null) {
                if (nextNode.id < minNode.id) {
                    minNode = nextNode;
                }
                nextNode = nextNode.next;
            }
            if (minNode != current) {
                swapStudents(current, minNode);
            }
            current = current.next;
        }
        displayStudents();
        System.out.println("Students sorted by ID.");
    }

    public void sortStudentsByRank() {
        if (head == null || head.next == null) {
            System.out.println("List is already sorted or empty.");
            return;
        }
        boolean swapped;
        do {
            swapped = false; 
            StudentNode current = head;
            while (current != null && current.next != null) {
                if (getRankValue(current.rank) < getRankValue(current.next.rank)) {
                    swapStudents(current, current.next);
                    swapped = true;
                }
                current = current.next;
            }
        } while (swapped);
        System.out.println("Students sorted by Rank:");
        displayStudents();
    }


    private int getRankValue(String rank) {
        switch (rank) {
            case "Excellent":
                return 5;
            case "Very Good":
                return 4;
            case "Good":
                return 3;
            case "Medium":
                return 2;
            case "Fail":
                return 1;
            default:
                return 0; // Invalid rank
        }
    }

// Helper method to swap two students
    private void swapStudents(StudentNode student1, StudentNode student2) {
        // Swap the content of two nodes
        int tempId = student1.id;
        String tempName = student1.name;
        double tempMarks = student1.marks;
        String tempRank = student1.rank;

        student1.id = student2.id;
        student1.name = student2.name;
        student1.marks = student2.marks;
        student1.rank = student2.rank;

        student2.id = tempId;
        student2.name = tempName;
        student2.marks = tempMarks;
        student2.rank = tempRank;
    }

}
