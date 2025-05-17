<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.library.model.User" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    User user = (User) session.getAttribute("user");
    if (user == null || !"Admin".equals(user.getRole())) {
        response.sendRedirect("login.jsp?error=unauthorized");
        return;
    }
%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>View Reservations</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 20px; }
        .container { width: 90%; margin: 0 auto; }
        table { width: 100%; border-collapse: collapse; margin: 20px 0; }
        th, td { border: 1px solid #ddd; padding: 8px; text-align: left; }
        th { background-color: #f4f4f4; }
        tr:nth-child(even) { background-color: #f9f9f9; }
        .back-link { display: inline-block; margin-top: 10px; color: #2196F3; }
    </style>
</head>
<body>
    <div class="container">
        <h2>All Reservations</h2>
        
        <table>
            <tr>
                <th>Student Name</th>
                <th>Book Title</th>
                <th>Reservation Date</th>
            </tr>
            <c:forEach var="r" items="${reservationList}">
                <tr>
                    <td>${r.studentName}</td>
                    <td>${r.bookTitle}</td>
                    <td>${r.reservationDate}</td>
                </tr>
            </c:forEach>
        </table>
        
        <a href="dashboard.jsp" class="back-link">← Back to Dashboard</a>
    </div>
</body>
</html>