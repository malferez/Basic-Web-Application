<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Delete Account</title>
</head>
<body>
    <h1>Delete Account</h1>
    <form action="../DeleteAccountServlet" method="post">
        <p>Are you sure you want to delete your account?</p>
        <label for="password">Enter your password to confirm:</label>
        <input type="password" id="password" name="password" required>
        <br><br>
        <input type="submit" value="Delete Account">
    </form>
    <br>
    <a href="../">Cancel</a>
</body>
</html>
