<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Password Changed</title>
</head>
<body>
    <h1>Your password has been successfully changed.</h1>
    <p>You will be redirected to the login page shortly.</p>
    <p>If you are not redirected, <a href="../">click here</a>.</p>

    <script type="text/javascript">
        // Redirect to login.jsp after 3 seconds
        setTimeout(function() {
            window.location.href = "../";
        }, 3000); // 3000 milliseconds = 3 seconds
    </script>
</body>
</html>