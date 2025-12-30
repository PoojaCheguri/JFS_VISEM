import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/saveStudent") // <-- Must match URL
public class StudentServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String salary = request.getParameter("salary");

        response.setContentType("text/html");
        response.getWriter().println("<h1>Student Saved Successfully!</h1>");
        response.getWriter().println("Name: " + name + "<br>");
        response.getWriter().println("Email: " + email + "<br>");
        response.getWriter().println("Salary: " + salary + "<br>");
    }

    // OPTIONAL: Add this so GET doesn't give 405 error
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.getWriter().println("Please submit the form instead of opening URL directly.");
    }
}
