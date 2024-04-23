<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="java.util.List"%>
<%@ page import="model.Bookings"%>
<%@ page import="dao.BookingDao"%>

<!DOCTYPE html>
<html>
<head>
<%
String carModel = (String) session.getAttribute("carModel");
%>
<title>Your Bookings</title>
</head>
<body>
	<h1>Your Bookings</h1>
	<%
	int sessionUserId = (int) (session.getAttribute("userid"));
	String sessionFromDate = (String) session.getAttribute("fromDate");
	String sessionTODate = (String) session.getAttribute("toDate");
	out.println("userID view booking: " + sessionUserId);
	List<Bookings> bookings = BookingDao.selectAllBookings();
	if (bookings != null && !bookings.isEmpty()) {
		for (Bookings booking : bookings) {
			if (booking.getUserId() == sessionUserId) {
				out.println("<p>Booking ID: " + booking.getBookingId() + " - Car Model: " + carModel + "</p>");
			}
		}
	} else {
		out.println("<p>No bookings found.</p>");
	}
	%>
	<a href="BookingConfirmation.jsp">Back to Confirmation</a>
</body>
</html>
