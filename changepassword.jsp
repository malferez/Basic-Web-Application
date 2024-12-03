<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Change Password</title>
    <link rel="stylesheet" type="text/css" href="../stylesheet/changepassword.css">
</head>
<body>
    <div class="form-container">
        <h1>Change Password</h1>
        <p>To change your password, please enter your current password and your new password below:</p>
        <form action="../ChangePasswordServlet" method="post">
            <div class="form-group">
                <label for="currentPassword">Current Password:</label>
                <input type="password" id="currentPassword" name="currentPassword" required>
            </div>
            <div class="form-group">
                <label for="newPassword">New Password:</label>
                <input type="password" id="newPassword" name="newPassword" required>
            </div>
            <div class="form-group">
                <label for="confirmPassword">Confirm New Password:</label>
                <input type="password" id="confirmPassword" name="confirmPassword" required>
            </div>
            <div class="button-group">
                <input type="submit" value="Change Password">
                <a href="../">Cancel</a>
            </div>
        </form>
    </div>
</body>
</html>
