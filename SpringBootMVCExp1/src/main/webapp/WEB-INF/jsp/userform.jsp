<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<center>
		<h1>Simple User Form</h1>
		<form action="user/api/submitform">
			Enter Username : <input type="text" name="username"><br>
			<br> Enter Password : <input type="password" name="password"><br>
			<br> <input type="submit" value="submit">
		</form>
	</center>
</body>
</html>