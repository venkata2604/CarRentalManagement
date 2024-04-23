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
import dao.CarDao;
import model.Bookings;
import model.Car;

/**
 * Servlet implementation class BookingConfirmationServlet
 */
@WebServlet("/BookingConfirmationServlet")
public class BookingConfirmationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BookingConfirmationServlet() {
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
		Bookings booking = new Bookings();
		Car car = new Car();
		HttpSession session = request.getSession();
//		response.getWriter().append("Served at: ").append(request.getContextPath());

		String carId = request.getParameter("selectedCarId");
		System.out.println("carId " + carId);
		try {
			booking = BookingDao.latestBooking();
			car = CarDao.selectCar(booking.getCarId());
			session.setAttribute("bookingId", booking.getBookingId());
			session.setAttribute("carid", booking.getCarId());
			session.setAttribute("carModel", car.getModel());
			booking.setStatus("Active");
			boolean isBookingUpdated = BookingDao.updateBookingStatus(booking);
			car.setStatus("Rented");
			boolean isCarUpdated = CarDao.updateCarStatus(car);
			if ((booking != null )&& (car!=null)&(isBookingUpdated)&&(isCarUpdated)) {
				response.sendRedirect("BookingConfirmation.jsp");
			}
			
//			session.setAttribute("userid", booking.getUserId());
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

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
