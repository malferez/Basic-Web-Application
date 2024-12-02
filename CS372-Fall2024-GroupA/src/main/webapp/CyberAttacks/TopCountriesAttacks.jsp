<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="LearnSE.Model.CyberModel" %>
<!DOCTYPE html>
<html>
<head>
    <title>Top Cyber Attacks</title>
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
    <h1 style="text-align: center;">Top Cyber Attacks</h1>

    <% 
        ArrayList<CyberModel> cyberData = (ArrayList<CyberModel>) request.getAttribute("cyberData");
        if (cyberData == null) {
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