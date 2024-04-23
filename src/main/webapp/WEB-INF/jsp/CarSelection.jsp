<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page import="model.Car"%>
<%@ page import="dao.CarDao"%>

<% session = request.getSession(false); %>
<% if (session == null || session.getAttribute("username") == null) {
	response.sendRedirect("Index.jsp");
} %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="ISO-8859-1">
    <title>Car Selection</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
    <div class="navbar">
        <a href="BookingServlet">Home</a>
        <a href="ViewBookingsServlet">View Bookings</a>
        <a href="Profile.jsp">Profile</a>
        <a href="LogoutServlet">Logout</a>
    </div>
    <div class="content">
        <div class="car-container">
            <h1>Choose a Car</h1>
            <form action="CarSelectionServlet" method="post" class="form-style">
                <% 
                List<Car> cars = CarDao.selectAllCars();
                for (Car car : cars) {
                %>
                <div class="radio-group">
                    <input type="radio" id="car<%=car.getCarId()%>" name="selectedCarId" value="<%=car.getCarId()%>">
                    <label for="car<%=car.getCarId()%>"><%=car.getMake()%> <%=car.getModel()%> - <%=car.getYear()%> | Seats: <%=car.getNumberOfSeats()%> | Price: $<%=car.getPricePerDay()%> | Status: <%=car.getStatus()%></label>
                </div>
                <% } %>
                <button type="submit">Select Car</button>
            </form>
        </div>
    </div>
</body>
</html>
