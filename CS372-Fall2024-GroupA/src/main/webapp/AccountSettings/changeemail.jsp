<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Change Email</title>
    <link rel="stylesheet" type="text/css" href="../stylesheet/changeemail.css">
</head>
<body>
    <div class="form-container">
        <h1>Change Email</h1>
        <form action="../ChangeEmailServlet" method="post">
            <div class="form-group">
                <label for="newEmail">Enter New Email:</label>
                <input type="email" id="newEmail" name="newEmail" required>
            </div>
            <div class="form-group">
                <label for="password">Enter Your Password:</label>
                <input type="password" id="password" name="password" required>
            </div>
            <div class="button-group">
                <input type="submit" value="Change Email">
                <a href="../">Cancel</a>
            </div>
        </form>
    </div>
</body>
</html>
