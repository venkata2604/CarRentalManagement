<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="model.Car"%>
<%@page import="dao.CarDao"%>
<%
CarDao carDao = new CarDao(); // Assuming CarDAO has the selectAllCars method
List<Car> cars = CarDao.selectAllCars(); // Execute method to fetch cars within a scriptlet, which is request scoped
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Booking</title>
</head>
<%
String fromDate = (String) session.getAttribute("fromDate");
String toDate = (String) session.getAttribute("toDate");
%>

<body>
	<h1>Dates are set</h1>
	<h1>Choose a Car</h1>
	<%
	if (fromDate != null || toDate != null) {
	%>
	<p>
		Your booking dates are From:
		<%=fromDate%>
		to
		<%=toDate%>



	</p>
	<%
	} else {
	%>
	<p>dates are null choose again</p>
	<%
	}
	%>

	<%
	if (cars != null && !cars.isEmpty()) {
	%>
	<form action="BookingConfirmationServlet" method="post">

		<%
		for (Car car : cars) {
		%>
		<div>

			<input type="radio" id="car<%=car.getCarId()%>" name="selectedCarId"
				value="<%=car.getCarId()%>"> <label
				for="car<%=car.getCarId()%>"><%=car.getMake()%> <%=car.getModel()%>
				- <%=car.getYear()%> ||||| Seats: - <%=car.getNumberOfSeats()%>-
				||Price : $<%=car.getPricePerDay()%> - <%=car.getStatus()%></label>
		</div>
		<%
		}
		%>
		<input type="submit" value="Submit Choice">
	</form>
	<% 	} else { 	%>
	<p>No cars available.</p>
	<%
	}
	%>
</body>
</html>