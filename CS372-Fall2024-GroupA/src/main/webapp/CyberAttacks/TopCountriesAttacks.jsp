<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="LearnSE.Model.CyberModel" %>
<%
String userRole = (String) session.getAttribute("userRole");
%>
<!DOCTYPE html>
<html>
<head>
    <title>Top Cyber Attacks</title>
	<link rel ="stylesheet" type="text/css" href="/CS372-Fall2024-GroupA/stylesheet/text_entry_area.css">
    <link rel="stylesheet" type="text/css" href="/CS372-Fall2024-GroupA/stylesheet/TopCountries.css">
    <style>
        table {
            width: 80%;
            margin: auto;
            border-collapse: collapse;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: center;
        }
        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
<h1>Department of Computer Science and Mathematics</h1>
<h2>Software Engineering: Models, Methods, Process and Techniques with the Emphasis on cybersecurity</h2><hr><br><br>

<% if (userRole == null) { %>
    <%@ include file="../Menu/defaultmenu.jsp" %>
<% } else if ("standard".equals(userRole)) { %>
    <%@ include file="../Menu/standardmenu.jsp" %>
<% } else if ("admin".equals(userRole)) { %>
    <%@ include file="../Menu/adminmenu.jsp" %>
<% } %>
    <h1 style="text-align: center;">Top Cyber Attacks</h1>

    <% 
        ArrayList<CyberModel> cyberData = (ArrayList<CyberModel>) request.getAttribute("cyberData");
        if (cyberData == null || cyberData.isEmpty()) {
    %>
        <p style="text-align: center; color: red;">No data available.</p>
    <% 
        } else {
    %>
        <table>
            <thead>
                <tr>
                    <th>Source Country</th>
                    <th>Number of Attacks</th>
                    <th>Target Country</th>
                    <th>Number of Attacks</th>
                    <th>Month</th>
                    <th>Year</th>
                </tr>
            </thead>
            <tbody>
                <% 
                    for (CyberModel data : cyberData) {
                %>
                <tr>
                    <td><%= data.getSrcCountry() %></td>
                    <td><%= String.valueOf(data.getSrcNoAttack()) %></td>
                    <td><%= data.getTargetCountry() %></td>
                    <td><%= String.valueOf(data.getTargetNoAttack()) %></td>
                    <td><%= data.getMonth() %></td>
                    <td><%= data.getYear() %></td>
                </tr>
                <% 
                    }
                %>
            </tbody>
        </table>
    <% 
        }
    %>
</body>
</html>
