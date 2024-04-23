package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		UserDao userdao = new UserDao();
		String username = request.getParameter("username");
		System.out.println("username: " + username);
		System.out.println("User exists : "+DaoUtils.isUserExists(username));
		if (DaoUtils.isUserExists(username)) {
			User user = userdao.selectUser(username);
			System.out.println("user object: " + user.getUsername());
			System.out.println("user object: " + user.getFirstName());

			
			String dbpassword = user.getPassword();
			System.out.println("Db retrieved password: " + dbpassword);
			String userPassword = request.getParameter("password");
			System.out.println("user entered password : " + userPassword);
			
			request.getSession().setAttribute("fromDate", username);
			request.getSession().setAttribute("userid", userdao.selectUser(username).getUserId());
			if (userPassword.equals(dbpassword)) {
				System.out.println("Login Successful");
				response.sendRedirect("BookingPage.jsp");
			} else {
				System.out.println("username or password wrong.");
				response.sendRedirect("Index.jsp");
			}

		} else {
			System.out.println("User Does not exist please sign up.");
			response.sendRedirect("SignUp.jsp");
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
