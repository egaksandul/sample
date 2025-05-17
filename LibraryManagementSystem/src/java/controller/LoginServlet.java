package controller;

import dao.UserDAO;
import model.User;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            response.sendRedirect("login.jsp?error=empty");
            return;
        }
        
        try {
            UserDAO dao = new UserDAO();
            User user = dao.validateUser(username, password);
            
            if (user != null) {
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                
                if ("Student".equals(user.getRole())) {
                    response.sendRedirect("searchBook.jsp");
                } else {
                    response.sendRedirect("dashboard.jsp");
                }
            } else {
                response.sendRedirect("login.jsp?error=invalid");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        }
    }
}