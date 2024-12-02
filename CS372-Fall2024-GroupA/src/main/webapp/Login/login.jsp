<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <link rel="stylesheet" type="text/css" href="../stylesheet/login.css">
</head>
<body>
    <div class="login-container">
        <h2>Login</h2>
        <form action="/CS372-Fall2024-GroupA/LoginServlet" method="post"> <!-- Adjusted action path to point to LoginServlet -->
            <div class="form-group">
                <label for="usernameOrEmail">Username or Email</label>
                <input type="text" id="usernameOrEmail" name="usernameOrEmail" required maxlength="32">
            </div>
            <div class="form-group">
                <label for="password">Password</label>
                <input type="password" id="password" name="password" required>
            </div>
            <div class="button-group">
                <button type="submit">Login</button>
                <button type="button" onclick="location.href='../Login/forgotpassword.jsp'">Forgot Password</button> <!-- Adjusted path for forgot password -->
                <button type="button" onclick="location.href='../Login/register.jsp'">New User</button> <!-- Adjusted path for register -->
            </div>
        </form>
    </div>
</body>
</html>
