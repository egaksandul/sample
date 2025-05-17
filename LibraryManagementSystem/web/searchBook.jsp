<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.library.model.User" %>
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
%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Search Books</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 0; padding: 20px; background-color: #f5f5f5; }
        .search-container {
            max-width: 800px;
            margin: 30px auto;
            padding: 30px;
            background: white;
            border-radius: 8px;
            box-shadow: 0 0 15px rgba(0,0,0,0.1);
        }
        h2 { color: #333; margin-bottom: 20px; }
        .search-form {
            display: flex;
            gap: 10px;
            margin-bottom: 30px;
        }
        .search-input {
            flex: 1;
            padding: 10px;
            border: 1px solid #ddd;
            border-radius: 4px;
        }
        .search-btn {
            padding: 10px 20px;
            background: #4CAF50;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
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
    <div class="search-container">
        <h2>Search Books</h2>
        
        <form action="book" method="get" class="search-form">
            <input type="hidden" name="action" value="search">
            <input type="text" name="keyword" placeholder="Enter book title or author" 
                   class="search-input" required>
            <input type="submit" value="Search" class="search-btn">
        </form>
        
        <div class="nav-links">
            <a href="dashboard.jsp">Back to Dashboard</a>
            <a href="logout">Logout</a>
        </div>
    </div>
</body>
</html>