<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
input, select {
    width: 100%;
    padding: 10px;
    margin-top: 5px;
    border: 1px solid #ccc;
    border-radius: 5px;
    font-size: 14px;
}
.gender-container {
    display: flex;
    justify-content: space-between;
    margin-top: 5px;
}
.gender-container label {
    font-weight: normal;
    display: flex;
    align-items: center;
    gap: 5px;
}
input[type="submit"] {
    background: #28a745;
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
    background: #218838;
}
@media (max-width: 400px) {
    .container {
        width: 90%;
    }
}

    </style>
</head>
<body>
<div class="container">
        <h2>Registration Form</h2>
        <form action="registration-form" method="post">
            <label for="name">Name:</label>
            <input type="text" id="name" name="name" required>
            
            <label for="email">Email:</label>
            <input type="email" id="email" name="email" required>
            
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required>
            
            <label>Gender:</label>
            <div class="gender-container">
                <label><input type="radio" name="gender" value="male" required> Male</label>
                <label><input type="radio" name="gender" value="female" required> Female</label>
            </div>
            
            <label for="city">City:</label>
            <select id="city" name="city" required>
                <option value="">Select City</option>
                <option value="new_york">New York</option>
                <option value="los_angeles">Los Angeles</option>
                <option value="chicago">Chicago</option>
                <option value="houston">Houston</option>
            </select>
            
            <input type="submit" value="Submit">
        </form>
    </div>

</body>
</html>