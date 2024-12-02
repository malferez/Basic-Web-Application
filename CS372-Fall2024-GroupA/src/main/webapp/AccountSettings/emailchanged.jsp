<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Email Changed</title>
</head>
<body>
    <h1>Email Updated Successfully</h1>
    <p>Your email has been updated successfully. You will be redirected to the main page shortly.</p>
    <p>If you are not redirected automatically, <a href="../">click here</a> to go to the main page.</p>

    <script type="text/javascript">
        // Redirect to main page after 3 seconds
        setTimeout(function() {
            window.location.href = "../"; // Adjust if needed based on your main page URL
        }, 3000); // 3000 milliseconds = 3 seconds
    </script>
</body>
</html>