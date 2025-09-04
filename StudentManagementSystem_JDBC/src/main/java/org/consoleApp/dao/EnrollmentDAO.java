package org.consoleApp.dao;


import org.consoleApp.model.Student;
import org.consoleApp.util.DBUtil;

import java.sql.*;

public class EnrollmentDAO {

    // enroll single student
    public void enrollStudent(int studentId, int courseId) throws Exception {
        String sql = "INSERT INTO enrollments(student_id, course_id) VALUES(?, ?)";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, studentId);
            ps.setInt(2, courseId);
            ps.executeUpdate();
            System.out.println("✅ Enrolled student " + studentId + " in course " + courseId);
        }
    }

    // Transaction: Insert student + enroll
    public void addStudentAndEnroll(Student student, int courseId) throws Exception {
        String insertStudent = "INSERT INTO students(name, age) VALUES (?, ?) RETURNING id";
        String insertEnroll = "INSERT INTO enrollments(student_id, course_id) VALUES (?, ?)";

        Connection conn = null;
        try {
            conn = DBUtil.getConnection();
            conn.setAutoCommit(false); // begin transaction

            int studentId;
            try (PreparedStatement ps = conn.prepareStatement(insertStudent)) {
                ps.setString(1, student.getName());
                ps.setInt(2, student.getAge());
                ResultSet rs = ps.executeQuery();
                rs.next();
                studentId = rs.getInt("id");
            }

            try (PreparedStatement ps2 = conn.prepareStatement(insertEnroll)) {
                ps2.setInt(1, studentId);
                ps2.setInt(2, courseId);
                ps2.executeUpdate();
            }

            conn.commit();
            System.out.println("✅ Student added and enrolled successfully.");
        } catch (Exception e) {
            if (conn != null) {
                conn.rollback();
                System.out.println("❌ Transaction failed. Rolled back!");
            }
            throw e;
        } finally {
            if (conn != null) {
                conn.setAutoCommit(true);
                conn.close();
            }
        }
    }

    // Batch Enroll multiple students into a course
    public void batchEnrollStudents(int[] studentIds, int courseId) throws Exception {
        String sql = "INSERT INTO enrollments(student_id, course_id) VALUES (?, ?)";
        Connection conn = null;
        try {
            conn = DBUtil.getConnection();
            conn.setAutoCommit(false);

            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                for (int sid : studentIds) {
                    ps.setInt(1, sid);
                    ps.setInt(2, courseId);
                    ps.addBatch();
                }
                int[] results = ps.executeBatch();
                conn.commit();
                System.out.println("✅ Batch enrollment complete: " + results.length + " records inserted.");
            }
        } catch (Exception e) {
            if (conn != null) {
                conn.rollback();
                System.out.println(" Batch enrollment failed. Rolled back!");
            }
            throw e;
        } finally {
            if (conn != null) {
                conn.setAutoCommit(true);
                conn.close();
            }
        }
    }

    // Show students with courses (JOIN)
    public void showStudentsWithCourses() throws Exception {
        String sql = "SELECT s.id, s.name, c.name AS course " +
                "FROM students s " +
                "JOIN enrollments e ON s.id = e.student_id " +
                "JOIN courses c ON e.course_id = c.id";
        try (Connection conn = DBUtil.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println(rs.getInt("id") + " | " +
                        rs.getString("name") + " | " +
                        rs.getString("course"));
            }
        }
    }
}

