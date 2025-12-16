package com.skillnext2.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.skillnext2.model.Student;

public class StudentDAO {

    private static final String URL =
        "jdbc:mysql://localhost:3306/skillnext2_db";
    private static final String USER = "root";
    private static final String PASSWORD = "poojasweety@9713"; // change this

    // Insert student
    public void addStudent(Student student) {

        String sql = "INSERT INTO student(name, email, age, course) VALUES (?, ?, ?, ?)";

        try (
            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
            PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setString(1, student.getName());
            ps.setString(2, student.getEmail());
            ps.setInt(3, student.getAge());
            ps.setString(4, student.getCourse());

            ps.executeUpdate();
            System.out.println("Student inserted successfully ✅");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


