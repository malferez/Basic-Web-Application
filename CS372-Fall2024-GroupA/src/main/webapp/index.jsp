<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<meta name="viewpoint" content="width=device-width, initial-scale=1.0">	
	<meta charset="UTF-8"><!-- the specification of the character encoding to use in the html document.The Unicode Transformation Format -8 (UTF-*)
	It is defined by the International Organization for Standardization (ISO). UTF-8 represents up to 2,097,152 code point. -->
	<meta name="viewport" content="width=device-width, initial-scale=1.0"> <!-- to control the scale of viewport -->
	<meta http-equiv="refresh" content="230"> <!-- if you want to refresh the page every x seconds -->
	<meta name="author" content="J. Alcime"><!-- specifies the author of the page/site -->
	<meta http-equiv="Content-Security-Policy" content="default-src 'self'"><!-- controls the resources a user agent is allowed to load.
	 It helps to detect and mitigate some attacks, including XSS and data injection. default-srch 'self' means allow anything, but the same origin.-->
	 <!-- data injection involves sending malicious data to an application or system -->
	 <meta http-equiv="X-Content-Type-Options" content="nosniff"><!-- this tag helps to prevent the browser from
	 Multipurpose Internet Mail Extension (MIME)-sniffing a response away from the declared -->
	<link rel ="stylesheet" type="text/css" href="stylesheet/text_entry_area.css">
	<link rel ="stylesheet" type="text/css" href="stylesheet/sitemenu.css">
	<script type="text/javascript" src="javascript/main_txt_dt.js"></script>
	<script type="text/javascript" src="javascript/p5.js"></script>
	<title>Data Entry</title>
	</head>
	<body>
	<%@ include file="/Main_Contents/mainpage.jsp"%>	
	<!-- 
		<form method="get" action="ViewMainDataServlet">
			<input type="submit" value="Continue to the main page"></input>
			<br>
			<br>
		</form>
			<a id="login" href="auth/usersign-in.jsp">Employee Entry</a>	
		-->
			
	</body>
</html>