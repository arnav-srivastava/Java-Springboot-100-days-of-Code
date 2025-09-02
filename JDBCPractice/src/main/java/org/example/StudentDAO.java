package org.example;

import java.sql.*;

public class StudentDAO {


    public void addStudent(Student student) {
        String sql = "INSERT INTO students (name, email, course) VALUES (?, ?, ?)";

        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, student.getName());
            pstmt.setString(2, student.getEmail());
            pstmt.setString(3, student.getCourse());

            pstmt.executeUpdate();
            System.out.println("Student added successfully!");

        } catch (SQLException e) {
            System.err.println("Error adding student: " + e.getMessage());
        }
    }


    public Student getStudent(int id) {
        String sql = "SELECT * FROM students WHERE id = ?";
        Student student = null;

        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);

            try (ResultSet rs = pstmt.executeQuery()) { // Use executeQuery for SELECT
                if (rs.next()) {
                    student = new Student();
                    student.setId(rs.getInt("id"));
                    student.setName(rs.getString("name"));
                    student.setEmail(rs.getString("email"));
                    student.setCourse(rs.getString("course"));
                }
            }
        } catch (SQLException e) {
            System.err.println("Error retrieving student: " + e.getMessage());
        }
        return student;
    }

    public void updateStudent(Student student) {
        String sql = "UPDATE students SET name = ?, email = ?, course = ? WHERE id = ?";

        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, student.getName());
            pstmt.setString(2, student.getEmail());
            pstmt.setString(3, student.getCourse());
            pstmt.setInt(4, student.getId());

            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Student updated successfully!");
            } else {
                System.out.println("Student with ID " + student.getId() + " not found.");
            }

        } catch (SQLException e) {
            System.err.println("Error updating student: " + e.getMessage());
        }
    }


    public void deleteStudent(int id) {
        String sql = "DELETE FROM students WHERE id = ?";

        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);

            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Student with ID " + id + " deleted successfully!");
            } else {
                System.out.println("Student with ID " + id + " not found.");
            }

        } catch (SQLException e) {
            System.err.println("Error deleting student: " + e.getMessage());
        }
    }
}
