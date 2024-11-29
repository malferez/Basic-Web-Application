<%@page import="LearnSE.Model.processtypedata"%>
<%@page import="java.util.ArrayList"%>
<%@page import="LearnSE.Dao.daoService" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
daoService pageContent = new daoService();
ArrayList<processtypedata> getpageContent = pageContent.getprocesstypedata();

// Check user role from the session
String userRole = (String) session.getAttribute("userRole");
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Software Engineering</title>
<!-- <link rel ="stylesheet" type="text/css" href="stylesheet/frt_page.css"> -->
<link rel ="stylesheet" type="text/css" href="stylesheet/text_entry_area.css">
<link rel ="stylesheet" type="text/css" href="stylesheet/sitemenu.css">
<style>
    .tblmainpage {
        width: 100%;
        border-collapse: collapse;
    }
    .tblmainpage td {
        border: 1px solid #ddd;
        padding: 8px;
        text-align: left;
        vertical-align: top;
    }
</style>
</head>
<body>    
<h1>Department of Computer Science and Mathematics</h1>
<h2>Software Engineering: Models, Methods, Process and Techniques with the Emphasis on cybersecurity</h2><hr><br><br>

<!-- Load the appropriate menu based on userRole -->
<% if (userRole == null) { %>
    <%@ include file="../Menu/defaultmenu.jsp" %>
<% } else if ("standard".equals(userRole)) { %>
    <%@ include file="../Menu/standardmenu.jsp" %>
<% } else if ("admin".equals(userRole)) { %>
    <%@ include file="../Menu/adminmenu.jsp" %>
<% } %>

<table class="tblmainpage">
    <% for (int i = 0; i < getpageContent.size(); i++) { %>
        <% if (i % 3 == 0) { %><tr><% } %>
            <td>
                <p id="txttitle"><%= getpageContent.get(i).getTitletypetext() %></p>
                <p><%= getpageContent.get(i).getDetailtypetext() %></p>
            </td>
        <% if ((i + 1) % 3 == 0) { %></tr><% } %>
    <% } %>
</table>
</body>
</html>