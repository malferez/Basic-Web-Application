<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Account Deleted</title>
    <script type="text/javascript">
        // Redirect to logout.jsp after 3 seconds
        setTimeout(function() {
            window.location.href = "../Login/logout.jsp";
        }, 3000); // 3000 milliseconds = 3 seconds
    </script>
</head>
<body>
    <h1>Account Successfully Deleted</h1>
    <p>Your account has been deleted. You will be logged out shortly.</p>
    <p>If you're not redirected automatically, <a href="../Login/logout.jsp">click here</a>.</p>
</body>
</html>
