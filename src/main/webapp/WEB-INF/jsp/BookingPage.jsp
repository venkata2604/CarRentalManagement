<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<% session = request.getSession(false); %>
<% if (session == null || session.getAttribute("username") == null) {
	response.sendRedirect("Index.jsp");
} %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Booking Page</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<div class="navbar">
		<a href="BookingServlet">Home</a> <a href="ViewBookingsServlet">View
			Bookings</a>  <a href="LogoutServlet">Logout</a>
	</div>
	<div class="content">
		<div class="form-container">
		
			<h1>Make a Booking</h1>
			<form action="BookingServlet" method="post" class="form-style">
				<div class="form-row">
					<label for="fromDate">Pick up</label> <input type="date"
						id="fromDate" name="fromDate" required>
				</div>
				<div class="form-row">
					<label for="toDate">Drop off</label> <input type="date" id="toDate"
						name="toDate" required>
				</div>
				<button type="submit">Book Now</button>
			</form>
		</div>
	</div>
</body>
</html>