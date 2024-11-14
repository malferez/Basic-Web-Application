<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Register</title>
    <link rel="stylesheet" type="text/css" href="stylesheet/register.css">
</head>
<body>
    <div class="register-container">
        <h2>Register New User</h2>
        <form action="/CS372-Fall2024-GroupA/RegisterServlet" method="post">
            <div class="form-group">
                <label for="email">Email</label>
                <input type="email" id="email" name="email" required maxlength="32">
            </div>
            <div class="form-group">
                <label for="first_name">First Name</label>
                <input type="text" id="first_name" name="first_name" required maxlength="32">
            </div>
            <div class="form-group">
                <label for="middle_name">Middle Name</label>
                <input type="text" id="middle_name" name="middle_name" maxlength="32">
            </div>
            <div class="form-group">
                <label for="last_name">Last Name</label>
                <input type="text" id="last_name" name="last_name" required maxlength="32">
            </div>
            <div class="form-group">
                <label for="user_name">Username</label>
                <input type="text" id="user_name" name="user_name" required maxlength="32">
            </div>
            <div class="form-group">
                <label for="user_pwd">Password</label>
                <input type="password" id="user_pwd" name="user_pwd" required>
            </div>
            <div class="form-group">
                <label for="user_confirm_pwd">Confirm Password</label>
                <input type="password" id="user_confirm_pwd" name="user_confirm_pwd" required>
            </div>
            <div class="form-group">
                <label for="sec_question1">Security Question 1</label>
                <select id="sec_question1" name="sec_question1" required>
                    <option value="What is your maternal grandmother's name?">What is your maternal grandmother's name?</option>
                    <option value="What is your oldest sibling's middle name?">What is your oldest sibling's middle name?</option>
                    <option value="What city were you born in?">What city were you born in?</option>
                </select>
                <input type="text" name="sec_answer1" required placeholder="Answer">
            </div>
            <div class="form-group">
                <label for="sec_question2">Security Question 2</label>
                <select id="sec_question2" name="sec_question2" required>
                    <option value="What is your father's middle name?">What is your father's middle name?</option>
                    <option value="What was the name of your first pet?">What was the name of your first pet?</option>
                    <option value="What is the name of your first job?">What is the name of your first job?</option>
                </select>
                <input type="text" name="sec_answer2" required placeholder="Answer">
            </div>
            <button type="submit" value="Submit">Register</button>
        </form>
    </div>
</body>
</html>
