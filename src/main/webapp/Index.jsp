<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Car Rental Management</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
<link
	href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500&display=swap"
	rel="stylesheet">



</head>
<body>

	<div class="login-container">
		<h1>Car Rental Management</h1>
		<form action="SignInServlet" method="post" class="login-form">
			<input type="text" name="username" placeholder="Username" required>
			<input type="password" name="password" placeholder="Password"
				required>
			<button type="submit">Sign in</button>
			<p class="signup-link">
				Don't have an account? <a href="SignUp.jsp">Sign Up</a>
			</p>
		</form>
	</div>

</body>
</html>