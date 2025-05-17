<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Library Login</title>
    <style>
        body { font-family: Arial, sans-serif; background-color: #f5f5f5; margin: 0; padding: 20px; }
        .login-container {
            max-width: 400px;
            margin: 50px auto;
            padding: 30px;
            background: white;
            border-radius: 8px;
            box-shadow: 0 0 15px rgba(0,0,0,0.1);
        }
        h1 { text-align: center; color: #333; margin-bottom: 30px; }
        .form-group { margin-bottom: 20px; }
        label { display: block; margin-bottom: 8px; font-weight: bold; }
        input[type="text"], input[type="password"] {
            width: 100%;
            padding: 10px;
            border: 1px solid #ddd;
            border-radius: 4px;
            box-sizing: border-box;
        }
        .btn-login {
            width: 100%;
            padding: 12px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
        }
        .btn-login:hover { background-color: #45a049; }
        .error {
            color: #d9534f;
            text-align: center;
            margin-top: 15px;
            padding: 10px;
            background-color: #f8d7da;
            border-radius: 4px;
        }
    </style>
</head>
<body>
    <div class="login-container">
        <h1>Library Management System</h1>
        
        <form action="login" method="post">
            <div class="form-group">
                <label for="username">Username:</label>
                <input type="text" id="username" name="username" required>
            </div>
            
            <div class="form-group">
                <label for="password">Password:</label>
                <input type="password" id="password" name="password" required>
            </div>
            
            <input type="submit" value="Login" class="btn-login">
        </form>
        
        <% 
            String error = request.getParameter("error");
            if (error != null) {
                String message = "";
                if (error.equals("invalid")) {
                    message = "Invalid username or password!";
                } else if (error.equals("empty")) {
                    message = "Please enter both username and password!";
                } else if (error.equals("session")) {
                    message = "Session expired. Please login again.";
                }
        %>
            <div class="error"><%= message %></div>
        <% } %>
    </div>
</body>
</html>