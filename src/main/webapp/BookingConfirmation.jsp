<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Booking Confirmation</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
<link
	href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500&display=swap"
	rel="stylesheet">
<%
// Retrieve booking details from request attributes
int bookingId = (int) session.getAttribute("bookingId");
String carModel = (String) session.getAttribute("carModel");
String bookingDate = (String) session.getAttribute("fromDate");
String returnDate = (String) session.getAttribute("toDate");
%>

</head>
<body>
<div class="navbar">
		<a href="Index.jsp">Home</a> <a href="ViewBookings.jsp">View
			Bookings</a> <a href="Profile.jsp">Profile</a> <a href="LogoutServlet">Logout</a>
	</div>
	<div class="content">
		<div class="form-container">

			<h1>Booking Confirmation</h1>


		<% if (bookingId != 0) { %>
                <p class="confirmation-message">Thank you for your booking.</p>
                <p><strong>Booking ID:</strong> <%= bookingId %></p>
                <p><strong>Car Model:</strong> <%= carModel %></p>
                <p><strong>Pick-up Date:</strong> <%= bookingDate %></p>
                <p><strong>Return Date:</strong> <%= returnDate %></p>
                <a href="BookingServlet" class="button">Return to Home</a>
            <% } else { %>
                <p class="error-message">There was a problem with your booking. Please try again or contact support.</p>
            <% } %>

		</div>
	</div>
</body>
</html>