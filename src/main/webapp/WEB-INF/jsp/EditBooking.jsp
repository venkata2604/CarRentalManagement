<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="model.Bookings"%>
<%@ page import="dao.BookingDao"%>
<%
Bookings booking = (Bookings) session.getAttribute("booking");
%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Edit Booking</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<div class="navbar">
		<a href="BookingServlet">Home</a> <a href="ViewBookingsServlet">View
			Bookings</a> <a href="LogoutServlet">Logout</a>
	</div>
	<div class="content">
		<div class="update-container ">
			<h1>Edit Booking</h1>
			<form action="UpdateBookingServlet" method="post" class="form-style">
				<div class="form-row">
					<label for="bookingId">BookingID:</label> <input type="text"
						id="bookingId" name="bookingId"
						value="<%=booking.getBookingId()%>" readonly>
				</div>
				<div class="form-row">
					<label for="userId">User ID:</label> <input type="number"
						id="userId" name="userId" value="<%=booking.getUserId()%>"
						readonly>
				</div>
				<div class="form-row">
					<label for="carId">Car ID:</label> <input type="number" id="carId"
						name="carId" value="<%=booking.getCarId()%>" readonly>
				</div>
				<div class="form-row">
					<label for="startDate">Start Date:</label> <input type="date"
						id="startDate" name="startDate"
						value="<%=booking.getStartDate()%>">
				</div>
				<div class="form-row">
					<label for="endDate">End Date:</label> <input type="date"
						id="endDate" name="endDate" value="<%=booking.getEndDate()%>">
				</div>
				<button type="submit" class="btn">Update Booking</button>
			</form>
		</div>
	</div>
</body>
</html>
