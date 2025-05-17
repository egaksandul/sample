<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.library.model.User, com.library.model.Book" %>
<%
    User user = (User) session.getAttribute("user");
    if (user == null) {
        response.sendRedirect("login.jsp?error=session");
        return;
    }
    if (!"Student".equals(user.getRole())) {
        response.sendRedirect("dashboard.jsp");
        return;
    }
    
    Book book = (Book) request.getAttribute("book");
    if (book == null) {
        response.sendRedirect("searchBook.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Reserve Book</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 0; padding: 20px; background-color: #f5f5f5; }
        .reserve-container {
            max-width: 600px;
            margin: 30px auto;
            padding: 30px;
            background: white;
            border-radius: 8px;
            box-shadow: 0 0 15px rgba(0,0,0,0.1);
        }
        h2 { color: #333; margin-bottom: 20px; }
        .book-info {
            margin-bottom: 30px;
            padding: 20px;
            background: #f8f9fa;
            border-radius: 5px;
        }
        .book-info p {
            margin: 10px 0;
            font-size: 16px;
        }
        .book-info strong {
            display: inline-block;
            width: 80px;
        }
        .btn-reserve {
            padding: 10px 20px;
            background: #4CAF50;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
        }
        .btn-reserve:hover { background: #45a049; }
        .nav-links {
            margin-top: 20px;
        }
        .nav-links a {
            color: #2196F3;
            text-decoration: none;
            margin-right: 15px;
        }
    </style>
</head>
<body>
    <div class="reserve-container">
        <h2>Confirm Reservation</h2>
        
        <div class="book-info">
            <p><strong>Title:</strong> <%= book.getTitle() %></p>
            <p><strong>Author:</strong> <%= book.getAuthor() %></p>
            <p><strong>Status:</strong> <%= book.getStatus() %></p>
        </div>
        
        <form action="reservation" method="post">
            <input type="hidden" name="bookId" value="<%= book.getId() %>">
            <input type="submit" value="Confirm Reservation" class="btn-reserve">
        </form>
        
        <div class="nav-links">
            <a href="book?action=list">Back to Book List</a>
            <a href="dashboard.jsp">Dashboard</a>
        </div>
    </div>
</body>
</html>