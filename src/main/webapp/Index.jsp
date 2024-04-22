<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Car Rental Management</title>
</head>
<body>

	<h1>Car Rental Management</h1>

	<form action="SignInServlet" method = "post">
		<input type="text" name="username" placeholder="username" required><br>
		<input type="password" name="password" placeholder="password" required><br>
		<input type="submit" value="Sign in"> 
		<a href="SignUp.jsp"> Sign Up </a>
	</form>


</body>
</html>