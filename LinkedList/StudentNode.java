/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LinkedList;

/**
 *
 * @author Vanto
 */
public class StudentNode {
    int id;
    String name;
    double marks;
    String rank;

    StudentNode next;

  
    public StudentNode(int id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
        this.rank = assignRank(marks);
        this.next = null;
    }
    
    
     public String assignRank(double marks) {
        if (marks >= 0 && marks < 5.0) {
            return "Fail";
        } else if (marks >= 5.0 && marks < 6.5) {
            return "Medium";
        } else if (marks >= 6.5 && marks < 7.5) {
            return "Good";
        } else if (marks >= 7.5 && marks < 9.0) {
            return "Very Good";
        } else if (marks >= 9.0 && marks <= 10.0) {
            return "Excellent";
        } else {
            return "Invalid Marks";
        }
    }
}
