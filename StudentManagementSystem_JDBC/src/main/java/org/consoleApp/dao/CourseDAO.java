package org.consoleApp.dao;

import org.consoleApp.model.Course;
import org.consoleApp.util.DBUtil;



import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CourseDAO {
    public void addCourse(Course course) throws Exception {
        String sql = "INSERT INTO courses(name) VALUES (?)";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, course.getName());
            ps.executeUpdate();
            System.out.println("✅ Course added: " + course.getName());
        }
    }

    public List<Course> getAllCourses() throws Exception {
        List<Course> list = new ArrayList<>();
        String sql = "SELECT * FROM courses";
        try (Connection conn = DBUtil.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Course(rs.getInt("id"), rs.getString("name")));
            }
        }
        return list;
    }
}
