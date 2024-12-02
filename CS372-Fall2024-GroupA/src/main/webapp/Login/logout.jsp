<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    // Invalidate the current session
    session.invalidate();

    // Redirect to the default main page
    response.sendRedirect("/CS372-Fall2024-GroupA/");
%>
