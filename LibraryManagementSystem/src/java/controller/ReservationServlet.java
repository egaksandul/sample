package controller;

import dao.ReservationDAO;
import model.User;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/reservation")
public class ReservationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession(false);
        if (session == null) {
            response.sendRedirect("login.jsp?error=session");
            return;
        }
        
        User user = (User) session.getAttribute("user");
        if (user == null) {
            response.sendRedirect("login.jsp?error=session");
            return;
        }
        
        try {
            int bookId = Integer.parseInt(request.getParameter("bookId"));
            int userId = user.getId();
            
            ReservationDAO reservationDAO = new ReservationDAO();
            if (reservationDAO.reserveBook(bookId, userId)) {
                response.sendRedirect("dashboard.jsp");
            } else {
                response.sendRedirect("error.jsp");
            }
        } catch (NumberFormatException | SQLException e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        }
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession(false);
        if (session == null) {
            response.sendRedirect("login.jsp?error=session");
            return;
        }
        
        User user = (User) session.getAttribute("user");
        if (user == null || !"Admin".equals(user.getRole())) {
            response.sendRedirect("login.jsp?error=unauthorized");
            return;
        }
        
        try {
            ReservationDAO reservationDAO = new ReservationDAO();
            request.setAttribute("reservationList", reservationDAO.getAllReservations());
            request.getRequestDispatcher("viewReservations.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        }
    }
}