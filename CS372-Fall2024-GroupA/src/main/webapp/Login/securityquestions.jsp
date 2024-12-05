<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Security Questions</title>
    <link rel="stylesheet" type="text/css" href="/CS372-Fall2024-GroupA/stylesheet/securityquestions.css">
</head>
<body>
    <div class="form-container">
        <h1>Security Questions</h1>
        <% 
            String error = (String) request.getAttribute("error");
            if (error != null) {
        %>
            <p class="error-message"><%= error %></p>
        <% 
            }
        %>
        <form action="http://localhost:8000/CS372-Fall2024-GroupA/VerifySecurityQuestionsServlet" method="post">
            <input type="hidden" name="email" value="<%= request.getAttribute("email") %>">

            <div class="form-group">
                <label for="question1"><%= request.getAttribute("question1") != null ? request.getAttribute("question1") : "Security Question 1" %>:</label>
                <input type="text" id="question1" name="answer1" required>
            </div>

            <div class="form-group">
                <label for="question2"><%= request.getAttribute("question2") != null ? request.getAttribute("question2") : "Security Question 2" %>:</label>
                <input type="text" id="question2" name="answer2" required>
            </div>

            <div class="button-group">
                <input type="submit" value="Submit">
                <a href="/CS372-Fall2024-GroupA/">Cancel</a>
            </div>
        </form>
    </div>
</body>
</html>