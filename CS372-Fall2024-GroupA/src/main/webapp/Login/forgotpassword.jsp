<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Forgot Password</title>
    <link rel="stylesheet" type="text/css" href="../stylesheet/forgotpassword.css">
</head>
<body>
    <div class="form-container">
        <h1>Forgot Password</h1>
        <form action="http://localhost:8000/CS372-Fall2024-GroupA/ForgotPasswordServlet" method="post">
            <div class="form-group">
                <label for="email">Enter your registered email:</label>
                <input type="email" id="email" name="email" required>
            </div>
            <div class="button-group">
                <input type="submit" value="Submit">
                <a href="../">Cancel</a>
            </div>
        </form>
    </div>
</body>
</html>