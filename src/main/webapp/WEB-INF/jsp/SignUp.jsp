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
		<form action="SignUpServlet" method="post" class="login-form">
			<input type="text" name="username" placeholder="Username" required>
			<input type="password" name="password" placeholder="Password"
				required> <input type="email" name="email"
				placeholder="Email" required> <input type="text"
				name="firstName" placeholder="First Name" required> <input
				type="text" name="lastName" placeholder="Last Name" required>
			<button type="submit">Sign Up</button>
			<p class="signup-link">
				Already have an account? <a href="Index.jsp">Log in</a>
			</p>
		</form>
	</div>

</body>
</html>