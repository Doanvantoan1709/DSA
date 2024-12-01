/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Stack;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;
/**
 *
 * @author Vanto
 */
public class StudentStack {
    private Stack<Student> stack = new Stack<>();


    // Push student to the stack with duplicate ID check
    public void push(Student student) {
        // Check for duplicate ID
        for (Student s : stack) {
            if (s.getId() == student.getId()) {
                System.out.println("Error: Student with ID " + student.getId() + " already exists. Cannot push duplicate ID.");
                return; // Exit the method if duplicate ID is found
            }
        }
        
        // No duplicate found, push the student onto the stack
        stack.push(student);
        System.out.println("Student with ID " + student.getId() + " pushed onto the stack.");
    }

    // Pop student from the stack
    public Student pop() {
        if (stack.isEmpty()) {
            System.out.println("Stack is empty!");
            return null;
        }
        return stack.pop();
    }

    // Peek at the top student of the stack
    public Student peek() {
        if (stack.isEmpty()) {
            System.out.println("Stack is empty!");
            return null;
        }
        return stack.peek();
    }

    // Display all students in the stack
    public void displayStudents() {
        if (stack.isEmpty()) {
            System.out.println("No students in the stack.");
            return;
        }
        for (Student student : stack) {
            System.out.println(student);
        }
    }

    public void sortById() {
        if (stack.size() < 2) {
            System.out.println("Stack is already sorted or empty.");
            return;
        }

        // Selection Sort for ascending ID
        for (int i = 0; i < stack.size() - 1; i++) {
            int minIndex = i;

            // Find the minimum ID in the unsorted portion of the stack
            for (int j = i + 1; j < stack.size(); j++) {
                if (stack.get(j).id < stack.get(minIndex).id) {
                    minIndex = j; // Update minIndex to the index of the new minimum
                }
            }

            // If minIndex is different from i, swap the students
            if (minIndex != i) {
                Student temp = stack.get(i);
                stack.set(i, stack.get(minIndex));
                stack.set(minIndex, temp);
            }
        }

        displayStudents();
        System.out.println("Stack sorted by ID in ascending order:");
    }

    // Sort stack by Rank in descending order (using bubble sort)
    public void sortByRank() {
        if (stack.size() < 2) {
            System.out.println("Stack is already sorted or empty.");
            return;
        }

        // Bubble Sort for descending Rank (lexicographical comparison)
        boolean swapped;
        do {
            swapped = false;
            for (int i = 0; i < stack.size() - 1; i++) {
                if (stack.get(i).rank.compareTo(stack.get(i + 1).rank) > 0) {
                    Student temp = stack.get(i);
                    stack.set(i, stack.get(i + 1));
                    stack.set(i + 1, temp);
                    swapped = true;
                }
            }
        } while (swapped);

        displayStudents();
        System.out.println("Stack sorted by Rank in descending order:");
    }
    
        // Binary search by ID
    public Student binarySearchById(int id) {
        if (stack.isEmpty()) {
            System.out.println("Stack is empty!");
            return null;
        }
        List<Student> studentList = new ArrayList<>(stack);
        studentList.sort(Comparator.comparingInt(Student::getId));
        int left = 0;
        int right = studentList.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            Student midStudent = studentList.get(mid);

            if (midStudent.getId() == id) {
                return midStudent;
            }

            if (midStudent.getId() < id) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println("Student with ID " + id + " not found.");
        return null;
    }

   
}
