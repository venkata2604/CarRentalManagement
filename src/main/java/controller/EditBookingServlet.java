package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BookingDao;
import model.Bookings;

/**
 * Servlet implementation class EditBookingServlet
 */
@WebServlet("/EditBookingServlet")
public class EditBookingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditBookingServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		int bookingId = Integer.parseInt(request.getParameter("bookingId"));
		System.out.println("edit booking id: " + bookingId);

		HttpSession session = request.getSession();
		request.setAttribute("bookingId", bookingId);

		Bookings booking = BookingDao.selectBooking(bookingId);
		int userId = booking.getUserId();
		int carId = booking.getCarId();
		String startDate = booking.getStartDate();
		String endDate = booking.getEndDate();
		double totalPrice = booking.getTotalPrice();
		String status = booking.getStatus();
		String bookingTimeStamp = booking.getBookingTimeStamp();
		System.out.println("booking from editbookingservlet:" + userId + carId + startDate + endDate + totalPrice
				+ status + bookingTimeStamp);

		session.setAttribute("booking", booking);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/EditBooking.jsp");
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
