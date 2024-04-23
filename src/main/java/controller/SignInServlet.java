package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;
import model.User;
import utils.DaoUtils;

/**
 * Servlet implementation class SignInServlet
 */
@WebServlet("/SignInServlet")
public class SignInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SignInServlet() {
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
		HttpSession session = request.getSession();
		Cookie sessionCookie = new Cookie("JSESSIONID", session.getId());
		sessionCookie.setHttpOnly(true);
		sessionCookie.setSecure(true);
		response.addCookie(sessionCookie);

		System.out.println("Sign in Servlet session : " + session);

		String username = request.getParameter("username");
		session.setAttribute("username", username);
		System.out.println("username: " + username);
		System.out.println("User exists : " + DaoUtils.isUserExists(username));
		if (DaoUtils.isUserExists(username)) {
			User user = UserDao.selectUser(username);
			System.out.println("user object: " + user.getUsername());
			System.out.println("user object: " + user.getFirstName());

			String dbpassword = user.getPassword();
			System.out.println("Db retrieved password: " + dbpassword);
			String userPassword = request.getParameter("password");
			System.out.println("user entered password : " + userPassword);

			request.getSession().setAttribute("fromDate", username);
			request.getSession().setAttribute("userid", UserDao.selectUser(username).getUserId());
			if (userPassword.equals(dbpassword)) {
				System.out.println("Login Successful");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/BookingPage.jsp");
				dispatcher.forward(request, response);
				
//				response.sendRedirect("BookingPage.jsp");
			} else {
				System.out.println("username or password wrong.");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/Index.jsp");
				dispatcher.forward(request, response);
				
//				response.sendRedirect("Index.jsp");
			}

		} else {
			System.out.println("User Does not exist please sign up.");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/SignUp.jsp");
			dispatcher.forward(request, response);
//			response.sendRedirect("SignUp.jsp");
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
