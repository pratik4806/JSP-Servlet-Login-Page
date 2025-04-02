<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: Arial, sans-serif;
        }
        body {
            background-color: #f4f4f4;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            padding: 20px;
        }
        .container {
            background: white;
            padding: 25px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
            width: 100%;
            max-width: 350px;
        }
        h2 {
            text-align: center;
            margin-bottom: 15px;
            color: #333;
        }
        label {
            display: block;
            margin-top: 10px;
            font-weight: bold;
            color: #555;
        }
        input {
            width: 100%;
            padding: 10px;
            margin-top: 5px;
            border: 1px solid #ccc;
            border-radius: 5px;
            font-size: 14px;
        }
        input[type="submit"] {
            background: #007bff;
            color: white;
            border: none;
            padding: 12px;
            margin-top: 15px;
            cursor: pointer;
            width: 100%;
            border-radius: 5px;
            font-size: 16px;
            transition: background 0.3s;
        }
        input[type="submit"]:hover {
            background: #0056b3;
        }
        .register-link {
            text-align: center;
            margin-top: 10px;
        }
        .register-link a {
            color: #007bff;
            text-decoration: none;
        }
    </style>
</head>
<body>

    <div class="container">
        <h2>Login</h2>
        <form action="login-form" method="post">
            <label for="email">Email:</label>
            <input type="email" id="email" name="email" required>
            
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required>
            
            <input type="submit" value="Login">
        </form>

        <div class="register-link">
            <p>Don't have an account? <a href="register.jsp">Register here</a></p>
        </div>
    </div>

</body>
</html>
