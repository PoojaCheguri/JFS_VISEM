package com.skillnext2;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class StudentServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String course = req.getParameter("course");

        Student s = new Student(name, email, course);
        int status = StudentDAO.save(s);

        if(status > 0) {
            resp.sendRedirect("success.jsp");
        } else {
            resp.getWriter().println("Error saving student");
        }
    }
}
