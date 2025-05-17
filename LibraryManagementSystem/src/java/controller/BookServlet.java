package controller;

import dao.BookDAO;
import model.Book;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/book")
public class BookServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String action = request.getParameter("action");
        if (action == null) {
            response.sendRedirect("error.jsp");
            return;
        }
        
        BookDAO bookDAO = new BookDAO();
        
        try {
            switch (action) {
                case "search":
                    String keyword = request.getParameter("keyword");
                    List<Book> books = bookDAO.searchBooks(keyword);
                    request.setAttribute("books", books);
                    request.getRequestDispatcher("bookList.jsp").forward(request, response);
                    break;
                    
                case "list":
                    List<Book> allBooks = bookDAO.getAllBooks();
                    request.setAttribute("books", allBooks);
                    request.getRequestDispatcher("bookList.jsp").forward(request, response);
                    break;
                    
                case "view":
                    int id = Integer.parseInt(request.getParameter("id"));
                    Book book = bookDAO.getBookById(id);
                    if (book != null) {
                        request.setAttribute("book", book);
                        request.getRequestDispatcher("reserveForm.jsp").forward(request, response);
                    } else {
                        response.sendRedirect("error.jsp");
                    }
                    break;
                    
                default:
                    response.sendRedirect("error.jsp");
            }
        } catch (SQLException | NumberFormatException e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        }
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String action = request.getParameter("action");
        if (!"add".equals(action)) {
            response.sendRedirect("error.jsp");
            return;
        }
        
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        
        if (title == null || title.isEmpty() || author == null || author.isEmpty()) {
            response.sendRedirect("addBook.jsp?error=empty");
            return;
        }
        
        Book book = new Book();
        book.setTitle(title);
        book.setAuthor(author);
        book.setStatus("Available");
        
        BookDAO bookDAO = new BookDAO();
        try {
            if (bookDAO.addBook(book)) {
                response.sendRedirect("dashboard.jsp");
            } else {
                response.sendRedirect("addBook.jsp?error=failed");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        }
    }
}