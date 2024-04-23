package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BookingDao;
import model.Bookings;
import utils.PriceCalculation;

/**
 * Servlet implementation class CarSelectionServlet
 */
@WebServlet("/CarSelectionServlet")
public class CarSelectionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CarSelectionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		Bookings booking = new Bookings();
		boolean isBookingUpdated = false;

		
		int carId = Integer.parseInt(request.getParameter("selectedCarId"));
		System.out.println("Carid by user: " + carId);
		double price = PriceCalculation.singleDayPriceCalculation(carId);
		HttpSession session = request.getSession();
		session.setAttribute("carId", carId);
		String fromDate = (String) session.getAttribute("fromDate");
		String toDate = (String) session.getAttribute("toDate");
		int session_carId = (int) session.getAttribute("carId");
		
		try {
			booking.setUserId((int) session.getAttribute("userid"));
			booking.setStartDate(fromDate);
			booking.setEndDate(toDate);
			booking.setTotalPrice(price);
			booking.setCarId(session_carId);
			booking.setStatus("Active");
			isBookingUpdated = BookingDao.insertBooking(booking);

			if (isBookingUpdated) {
				response.sendRedirect("BookingConfirmationServlet");

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.sendRedirect("BookinConfirmation.jsp");
			String carMessage = "car selection failed please select again";
			// insert error page here
		}
		
		response.getWriter().println("Total Price of the booking is : $"+ price);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
