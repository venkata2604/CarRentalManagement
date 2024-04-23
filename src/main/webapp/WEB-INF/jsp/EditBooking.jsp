<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="model.Bookings"%>
<%@ page import="dao.BookingDao"%>
<%Bookings booking = (Bookings) session.getAttribute("booking");%>




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
			<div class = "form-row">
			BookingID : <input type = "text" name = "bookingId" value = "<%=booking.getBookingId() %>">
			
			</div>
		</form>
	</div>
</body>
</html>
