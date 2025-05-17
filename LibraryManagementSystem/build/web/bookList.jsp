<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.library.model.User, java.util.List" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    User user = (User) session.getAttribute("user");
    if (user == null) {
        response.sendRedirect("login.jsp?error=session");
        return;
    }
    
    List<Book> books = (List<Book>) request.getAttribute("books");
    if (books == null) {
        response.sendRedirect("searchBook.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Book List</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 0; padding: 20px; background-color: #f5f5f5; }
        .booklist-container {
            max-width: 1000px;
            margin: 30px auto;
            padding: 30px;
            background: white;
            border-radius: 8px;
            box-shadow: 0 0 15px rgba(0,0,0,0.1);
        }
        h2 { color: #333; margin-bottom: 20px; }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 20px;
        }
        th, td {
            padding: 12px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }
        th {
            background-color: #f8f9fa;
            font-weight: bold;
        }
        tr:hover {
            background-color: #f5f5f5;
        }
        .status-available { color: #28a745; }
        .status-reserved { color: #dc3545; }
        .reserve-link {
            color: #2196F3;
            text-decoration: none;
        }
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
    <div class="booklist-container">
        <h2>Book List</h2>
        
        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Title</th>
                    <th>Author</th>
                    <th>Status</th>
                    <% if ("Student".equals(user.getRole())) { %>
                        <th>Action</th>
                    <% } %>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="book" items="${books}">
                    <tr>
                        <td>${book.id}</td>
                        <td>${book.title}</td>
                        <td>${book.author}</td>
                        <td class="status-${book.status eq 'Available' ? 'available' : 'reserved'}">
                            ${book.status}
                        </td>
                        <% if ("Student".equals(user.getRole())) { %>
                            <td>
                                <c:if test="${book.status eq 'Available'}">
                                    <a href="book?action=view&id=${book.id}" class="reserve-link">Reserve</a>
                                </c:if>
                            </td>
                        <% } %>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        
        <div class="nav-links">
            <a href="searchBook.jsp">Back to Search</a>
            <a href="dashboard.jsp">Dashboard</a>
            <a href="logout">Logout</a>
        </div>
    </div>
</body>
</html>