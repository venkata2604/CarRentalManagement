package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DbConnection;
import dao.UserDao;
import dao.DbConnection.*;
import model.User;
import utils.DaoUtils;

/**
 * Servlet implementation class SignUp
 */
@WebServlet("/SignUpServlet")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SignUpServlet() {
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
		User user = new User();
		user.setUsername(request.getParameter("username"));
		user.setPassword(request.getParameter("password"));
		user.setEmail(request.getParameter("email"));
		user.setFirstName(request.getParameter("firstName"));
		user.setLastName(request.getParameter("lastName"));
		boolean isUserExists = false;

		System.out.println("Printing form data from signup: " + user.getEmail() + user.getFirstName());

		try {
////			DbConnection conn = new DbConnection();
//			Connection conn = getConnection();
			User oldUser = UserDao.selectUser(user.getUsername());
			System.out.println("SignupServlet user: " + user.getUsername());
			if (oldUser.getUsername() != null) {
				isUserExists = true;
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/UserExists.jsp");
				dispatcher.forward(request, response);
//				response.sendRedirect("UserExists.jsp");
			} else {
				UserDao.insertUser(user);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/RegistrationSuccess.jsp");
				dispatcher.forward(request, response);
//				response.sendRedirect("RegistrationSuccess.jsp");
			}

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
