<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Change Email</title>
</head>
<body>
    <h1>Change Email</h1>
    <form action="../ChangeEmailServlet" method="post">
        <label for="newEmail">Enter New Email:</label>
        <input type="email" id="newEmail" name="newEmail" required>
        <br><br>
        
        <label for="password">Enter Your Password:</label>
        <input type="password" id="password" name="password" required>
        <br><br>
        
        <input type="submit" value="Change Email">
    </form>
    
    <br>
    <a href="../">Cancel</a>
</body>
</html>