package org.consoleApp;

import org.consoleApp.dao.CourseDAO;
import org.consoleApp.dao.EnrollmentDAO;
import org.consoleApp.dao.StudentDAO;
import org.consoleApp.model.Course;
import org.consoleApp.model.Student;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        StudentDAO studentDAO = new StudentDAO();
        CourseDAO courseDAO = new CourseDAO();
        EnrollmentDAO enrollmentDAO = new EnrollmentDAO();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Student Management System (PostgreSQL) ---");
            System.out.println("1. Add Student");
            System.out.println("2. Add Course");
            System.out.println("3. Enroll Student in Course");
            System.out.println("4. Add Student + Enroll (Transaction)");
            System.out.println("5. Batch Enroll Students in Course");
            System.out.println("6. Show Students with Courses");
            System.out.println("7. Exit");
            System.out.print("Choose: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String sName = sc.nextLine();
                    System.out.print("Enter age: ");
                    int age = sc.nextInt();
                    studentDAO.addStudent(new Student(sName, age));
                    break;

                case 2:
                    System.out.print("Enter course name: ");
                    String cName = sc.nextLine();
                    courseDAO.addCourse(new Course(cName));
                    break;

                case 3:
                    System.out.print("Enter student ID: ");
                    int sid = sc.nextInt();
                    System.out.print("Enter course ID: ");
                    int cid = sc.nextInt();
                    enrollmentDAO.enrollStudent(sid, cid);
                    break;

                case 4:
                    System.out.print("Enter student name: ");
                    String newName = sc.nextLine();
                    System.out.print("Enter age: ");
                    int newAge = sc.nextInt();
                    System.out.print("Enter course ID: ");
                    int courseId = sc.nextInt();
                    enrollmentDAO.addStudentAndEnroll(new Student(newName, newAge), courseId);
                    break;

                case 5:
                    System.out.print("Enter course ID for batch enrollment: ");
                    int batchCourseId = sc.nextInt();
                    System.out.print("Enter number of students: ");
                    int n = sc.nextInt();
                    int[] ids = new int[n];
                    for (int i = 0; i < n; i++) {
                        System.out.print("Enter student ID " + (i + 1) + ": ");
                        ids[i] = sc.nextInt();
                    }
                    enrollmentDAO.batchEnrollStudents(ids, batchCourseId);
                    break;

                case 6:
                    enrollmentDAO.showStudentsWithCourses();
                    break;

                case 7:
                    System.exit(0);
            }
        }
    }
}