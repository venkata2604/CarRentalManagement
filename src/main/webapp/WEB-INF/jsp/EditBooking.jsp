<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	<%@ page import="model.Bookings" %>
	<%@ page import="dao.BookingDao" %>
	<%int bookingId = (int) session.getAttribute("bookingId"); %>
	
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Edit Booking</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<div class="content">
		<h1>Edit Booking</h1>
		<form action="UpdateBookingServlet" method="post" class="edit-form">
			<div class="form-row">
				<label for="bookingID">Booking ID:</label> <input type="text"
					id="bookingID" name="bookingID" value="${booking.bookingID}"
					readonly>
			</div>
			<div class="form-row">
				<label for="userID">User ID:</label> <input type="text" id="userID"
					name="userID" value="${booking.userID}">
			</div>
			<div class="form-row">
				<label for="carID">Car ID:</label> <input type="text" id="carID"
					name="carID" value="${booking.carID}">
			</div>
			<div class="form-row">
				<label for="startDate">Start Date:</label> <input type="date"
					id="startDate" name="startDate" value="${booking.startDate}">
			</div>
			<div class="form-row">
				<label for="endDate">End Date:</label> <input type="date"
					id="endDate" name="endDate" value="${booking.endDate}">
			</div>
			<div class="form-row">
				<label for="totalPrice">Total Price:</label> <input type="text"
					id="totalPrice" name="totalPrice" value="${booking.totalPrice}">
			</div>
			<div class="form-row">
				<label for="status">Status:</label> <select id="status"
					name="status">
					<option value="Active"
						${booking.status == 'Active' ? 'selected' : ''}>Active</option>
					<option value="Completed"
						${booking.status == 'Completed' ? 'selected' : ''}>Completed</option>
					<option value="Cancelled"
						${booking.status == 'Cancelled' ? 'selected' : ''}>Cancelled</option>
				</select>
			</div>
			<div class="form-row">
				<label for="bookingTimestamp">Booking Timestamp:</label> <input
					type="text" id="bookingTimestamp" name="bookingTimestamp"
					value="${booking.bookingTimestamp}" readonly>
			</div>
			<div class="form-row">
				<button type="submit">Update Booking</button>
			</div>
		</form>
	</div>
</body>
</html>
