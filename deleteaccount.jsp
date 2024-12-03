<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Delete Account</title>
    <link rel="stylesheet" type="text/css" href="../stylesheet/deleteaccount.css">
</head>
<body>
    <div class="form-container">
        <h1>Delete Account</h1>
        <form action="../DeleteAccountServlet" method="post">
            <p>Are you sure you want to delete your account?</p>
            <div class="form-group">
                <label for="password">Enter your password to confirm:</label>
                <input type="password" id="password" name="password" required>
            </div>
            <div class="button-group">
                <input type="submit" value="Delete Account">
                <a href="../">Cancel</a>
            </div>
        </form>
    </div>
</body>
</html>
