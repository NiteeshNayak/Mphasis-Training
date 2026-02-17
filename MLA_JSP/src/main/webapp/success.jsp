<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Success Page</title>
</head>
<body>

	<h1>Jsp Tags Forward Success..</h1>
	<h3>Session Tracking.</h3>
	<%
	String usr = (String)session.getAttribute("info");
	out.println("User From Success Page : "+usr);
	%>
</body>
</html>