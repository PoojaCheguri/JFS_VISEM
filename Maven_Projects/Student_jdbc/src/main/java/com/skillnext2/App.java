package com.skillnext2;

import com.skillnext2.dao.StudentDAO;
import com.skillnext2.model.Student;

public class App {

    public static void main(String[] args) {

        Student student = new Student(
            "sweety",
            "sweety@.com",
            18,
            "JavaFullStack"
        );

        StudentDAO dao = new StudentDAO();
        dao.addStudent(student);
    }
}
