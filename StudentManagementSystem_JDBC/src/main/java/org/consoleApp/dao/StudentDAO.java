package org.consoleApp.dao;


import org.consoleApp.model.Student;
import org.consoleApp.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    public void addStudent(Student student) throws Exception {

        String sql = "INSERT INTO students(name, age) VALUES (?, ?)";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, student.getName());
            ps.setInt(2, student.getAge());

            ps.executeUpdate();

            System.out.println(" Student added: " + student.getName());
        }
    }

    public List<Student> getAllStudents() throws Exception {
        List<Student> list = new ArrayList<>();
        String sql = "SELECT * FROM students";

        try (Connection conn = DBUtil.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                list.add(new Student(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("age")));
            }
        }
        return list;
    }
}

