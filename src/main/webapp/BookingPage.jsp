<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="BookingServlet" method="post">
		<!-- The action will point to a servlet that processes the data -->
		<h1>Logged in Successfully choose a car.</h1>
		<h1>Choose dates for booking</h1>
		<h2>Select Date Range</h2>
		<div>
			<label for="fromDate">From:</label> 
			<input type="date" id="fromDate" name="fromDate" required> 
			<label for="toDate">To:</label> 
			<input type="date" id="toDate" name="toDate" required>
		</div>
		<div>
			<button type="submit"> Submit </button>
		</div>
	</form>
</body>
</html>