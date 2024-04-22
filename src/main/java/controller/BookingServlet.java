package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.text.ParseException;
//import utils.PriceCalculation;
import java.text.SimpleDateFormat;
import java.util.Date;

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
		Date startDate;
		Date endDate;
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//		int carId = Integer.parseInt(request.getParameter("selectedCarId"));
//		System.out.println("Carid by user: " + carId);
//		double price = PriceCalculation.singleDayPriceCalculation(carId);
//		
//		response.getWriter().println("Total Price of the booking is : $"+ price);
		String fromDate = request.getParameter("fromDate");
		String toDate = request.getParameter("toDate");

		request.getSession().setAttribute("fromDate", fromDate);
		request.getSession().setAttribute("toDate", toDate);
		// add to database based on booking ID and user ID
		
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		try {
//			startDate= sdf.parse(fromDate);
//			endDate = sdf.parse(toDate);
//			
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		System.out.println("The from and to dates are :" + fromDate + toDate);
		response.sendRedirect("CarSelection.jsp");

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
