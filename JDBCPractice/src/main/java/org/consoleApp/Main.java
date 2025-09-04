package org.example;

public class Main {
    public static void main(String[] args) {
        StudentDAO studentDAO = new StudentDAO();


        System.out.println("--- Creating Student ---");
        Student newStudent = new Student("Arnav Srivastava", "arnav.s@example.com", "Computer Science");
        studentDAO.addStudent(newStudent);


        int studentId = 1;


        System.out.println("\n--- Reading Student ---");
        Student retrievedStudent = studentDAO.getStudent(studentId);
        System.out.println("Retrieved: " + retrievedStudent);

        if (retrievedStudent != null) {
            System.out.println("\n--- Updating Student ---");
            retrievedStudent.setCourse("Data Science");
            studentDAO.updateStudent(retrievedStudent);

            Student updatedStudent = studentDAO.getStudent(studentId);
            System.out.println("After Update: " + updatedStudent);
        }

        System.out.println("\n--- Deleting Student ---");
        studentDAO.deleteStudent(studentId);

        Student deletedStudent = studentDAO.getStudent(studentId);
        System.out.println("After Deletion, Retrieved: " + deletedStudent);
    }
}