<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="model.User" %>
<%
    User user = (User) session.getAttribute("user");
    if (user == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>
<%@ page import="model.User" %>

<!DOCTYPE html>
<html>
<head>
    <title>Dashboard</title>
    <style>
        body {
            background-color: #e9ecef;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            padding: 40px;
        }

        .dashboard {
            background-color: #fff;
            width: 500px;
            margin: auto;
            padding: 30px;
            border-radius: 12px;
            box-shadow: 0px 4px 12px rgba(0, 0, 0, 0.1);
        }

        h2 {
            text-align: center;
            color: #333;
            margin-bottom: 30px;
        }

        .menu {
            display: flex;
            flex-direction: column;
            gap: 15px;
        }

        .menu a {
            text-decoration: none;
            background-color: #007bff;
            color: white;
            padding: 12px;
            border-radius: 6px;
            text-align: center;
            font-weight: bold;
            transition: background-color 0.3s;
        }

        .menu a:hover {
            background-color: #0056b3;
        }

        .logout {
            margin-top: 25px;
            text-align: center;
        }

        .logout a {
            color: #dc3545;
            text-decoration: none;
            font-weight: bold;
        }

        .logout a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>

<div class="dashboard">
    <h2>Welcome, <%= user.getUsername() %> [<%= user.getRole() %>]</h2>

    <div class="menu">
        <% if ("Admin".equals(user.getRole())) { %>
            <a href="addBook.jsp">➕ Add Book</a>
            <a href="viewReservations.jsp">📋 View Reservations</a>
        <% } else { %>
            <a href="searchBook.jsp">🔍 Search & Reserve Book</a>
        <% } %>
    </div>

    <div class="logout">
        <a href="logout">⏏ Logout</a>
    </div>
</div>

</body>
</html>
