<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Error</title>
    <style>
        body {
            background-color: #f8d7da;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }

        .error-box {
            background-color: #fff;
            border: 1px solid #f5c6cb;
            color: #721c24;
            padding: 30px 40px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
            text-align: center;
        }

        .error-box h2 {
            margin-bottom: 20px;
        }

        .error-box a {
            text-decoration: none;
            color: #fff;
            background-color: #dc3545;
            padding: 10px 20px;
            border-radius: 5px;
            font-weight: bold;
        }

        .error-box a:hover {
            background-color: #c82333;
        }
    </style>
</head>
<body>

<div class="error-box">
    <h2>⚠ Invalid login or action not allowed!</h2>
    <a href="login.jsp">⤴ Try Again</a>
</div>

</body>
</html>
