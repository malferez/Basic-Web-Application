<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Reset Password</title>
    <link rel="stylesheet" type="text/css" href="/CS372-Fall2024-GroupA/stylesheet/forgotpassword.css">
</head>
<body>
    <div class="form-container">
        <h1>Reset Your Password</h1>
        <form action="http://localhost:8000/CS372-Fall2024-GroupA/ResetPasswordServlet" method="post">
            <input type="hidden" name="email" value="<%= request.getAttribute("email") %>">

            <div class="form-group">
                <label for="password">New Password:</label>
                <input type="password" id="password" name="password" required>
            </div>

            <div class="form-group">
                <label for="confirmPassword">Confirm New Password:</label>
                <input type="password" id="confirmPassword" name="confirmPassword" required>
            </div>

            <div class="button-group">
                <input type="submit" value="Reset Password">
                <a href="/CS372-Fall2024-GroupA/">Cancel</a>
            </div>
        </form>
    </div>
</body>
</html>