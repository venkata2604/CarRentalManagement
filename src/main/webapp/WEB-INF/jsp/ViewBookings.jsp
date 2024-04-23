<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="java.util.List"%>
<%@ page import="model.Bookings"%>
<%@ page import="dao.BookingDao"%>
<%@ page import="dao.CarDao"%>


<!DOCTYPE html>
<html>
<head>
<title>View Bookings</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
<link
	href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500&display=swap"
	rel="stylesheet">

<%
String carModel = (String) session.getAttribute("carModel");
int sessionUserId = (int) (session.getAttribute("userid"));
String sessionFromDate = (String) session.getAttribute("fromDate");
String sessionTODate = (String) session.getAttribute("toDate");
List<Bookings> bookings = BookingDao.selectAllBookings();
%>
</head>
<body>
	<div class="navbar">
		<a href="BookingServlet">Home</a> <a href="ViewBookingsServlet">View
			Bookings</a> <a href="Profile.jsp">Profile</a> <a href="LogoutServlet">Logout</a>
	</div>

	<div class="content">
		<div class="view-bookings-container">
			<h1>Your Bookings</h1>
			<table class="bookings-table">
				<thead>
					<tr>
						<th>Booking ID</th>
						<th>Car Model</th>
						<th>Pick-up Date</th>
						<th>Return Date</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>

					<%
					if (bookings != null && !bookings.isEmpty()) {
						for (Bookings booking : bookings) {
							if (booking.getUserId() == sessionUserId) {
					%>
					<tr>
						<td><%=booking.getBookingId()%></td>
						<td><%=CarDao.selectCar(booking.getCarId()).getModel()%></td>
						<td><%=booking.getStartDate()%></td>
						<td><%=booking.getEndDate()%></td>
						<td><a
							href="EditBookingServlet?bookingId=<%=booking.getBookingId()%>"
							class="button edit-btn">Edit</a> <a
							href="DeleteBookingServlet?bookingId=<%=booking.getBookingId()%>"
							class="button delete-btn">Delete</a></td>
					</tr>

					<%
					}
					}
					} else {
					out.println("<p>No bookings found.</p>");
					}
					%>
				</tbody>
			</table>
		</div>
	</div>





</body>
</html>
