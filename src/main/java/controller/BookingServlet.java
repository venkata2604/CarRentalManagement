package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class BookingServlet
 */
@WebServlet("/BookingServlet")
public class BookingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BookingServlet() {
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
//		int carId = Integer.parseInt(request.getParameter("selectedCarId"));
//		System.out.println("Carid by user: " + carId);
//		double price = PriceCalculation.singleDayPriceCalculation(carId);
//		
//		response.getWriter().println("Total Price of the booking is : $"+ price);
		String fromDate = request.getParameter("fromDate");
		String toDate = request.getParameter("toDate");

		HttpSession session = request.getSession(false);
		System.out.println("Booking Servlet Session " + session);

		session.setAttribute("fromDate", fromDate);
		session.setAttribute("toDate", toDate);

		System.out.println("session attributes " + session.getAttribute("toDate"));

		if ((fromDate != null) && (toDate != null)) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/CarSelection.jsp");
			dispatcher.forward(request, response);

//			response.sendRedirect("CarSelection.jsp");
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/BookingPage.jsp");
			dispatcher.forward(request, response);

//			response.sendRedirect("BookingPage.jsp");

		}
		System.out.println("The from and to dates are :" + fromDate + toDate);

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
