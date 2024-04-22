<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<FORM action="SignUpServlet">
		<input type="text" name="username" placeholder="username" value= "user1" required><br>
		<input type="password" name="password" placeholder="password" value = "pass" required><br>
		<input type="email" name="email" placeholder="email" value= "user1@gmail.com" required><br>

		<input type="text" name="firstName" placeholder="first name" value = "firstname User" required><br>
		<input type="text" name="lastName" placeholder="last name" value = "lastname user" required><br>

		<input type="submit" value="Sign Up">
		<a href = "Index.jsp">Log in</a>




	</FORM>

</body>
</html>