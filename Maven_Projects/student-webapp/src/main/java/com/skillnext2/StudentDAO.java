package com.skillnext2;

import java.sql.*;

public class StudentDAO {

    public static Connection getConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(
          "jdbc:mysql://localhost:3306/skillnext_student_db", "root", "yourpassword");
    }

    public static int save(Student s) {
        int status = 0;
        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement(
              "INSERT INTO student(name,email,course) VALUES (?,?,?)");
            ps.setString(1, s.getName());
            ps.setString(2, s.getEmail());
            ps.setString(3, s.getCourse());
            status = ps.executeUpdate();
        } catch(Exception e) {
            e.printStackTrace();
        }
        return status;
    }
}
