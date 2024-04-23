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
	<h1>Edit Booking</h1>
	<form action="UpdateBookingServlet" method="post" class="edit-form">
		BookingID : <input type="text" name="bookingId"
			value="<%=booking.getBookingId()%>"><br> User ID: <input
			type="number" name="userId" value="<%=booking.getUserId()%>"><br>
		CarID: <input type="number" name="carId"
			value="<%=booking.getCarId()%>"> <br> StartDate: <input
			type="date" name="startDate" value="<%=booking.getStartDate()%>"><br>
		EndDate: <input type="date" name="endDate"
			value="<%=booking.getEndDate()%>"><br>
		<input type="submit" value="Update Booking">

	</form>
</body>
</html>
