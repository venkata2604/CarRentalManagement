package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;

import model.User;

public class UserDao {

//	private String jdbcURL = "jdbc:mysql://localhost:3306/car_rental";
//	private String dbUsername = "root";
//	private String dbPassword = "1234";

	private static final String INSERT_USERS_SQL = "INSERT INTO users"
			+ "  (username, password, email, firstName,  lastName) VALUES " + " (?, ?, ?, ?, ?);";

//	private static final String SELECT_USER_BY_ID = "select username ,email, firstName, lastName, email from users where username =?";
	private static final String SELECT_USER_BY_ID = "select * from users where username =?";

	private static final String SELECT_ALL_USERS = "select * from users";
	private static final String DELETE_USERS_SQL = "delete from users where username = ?;";
	private static final String UPDATE_USERS_SQL = "update users set username = ?, password = ?, firstName = ?, lastName = ?, email= ? where username = ?;";

	public UserDao() {

	}

	/*
	 * "INSERT INTO users" +
	 * "  (username, password, email, firstName,  lastName) VALUES " +
	 * " (?, ?, ?, ?, ?);";
	 */
	public static void insertUser(User user) throws SQLException {
		System.out.println(INSERT_USERS_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = DbConnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
			preparedStatement.setString(1, user.getUsername());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.setString(3, user.getEmail());
			preparedStatement.setString(4, user.getFirstName());
			preparedStatement.setString(5, user.getLastName());

			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static User selectUser(String username) {
		User user = new User();
		// Step 1: Establishing a Connection
		try (Connection connection = DbConnection.getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {
			preparedStatement.setString(1, username);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			System.out.println("result set : " + rs);

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int userId = rs.getInt("userid");
//				String username = rs.getString("username");
				String password = rs.getString("password");
				String email = rs.getString("email");
				String role = rs.getString("role");
				String registrationDate = rs.getString("registrationdate");
				String firstName = rs.getString("firstName");
				String lastName = rs.getString("lastName");
				String MiddleName = rs.getString("middlename");

				user.setUserId(userId);
				user.setUsername(username);
				user.setPassword(password);
				user.setEmail(email);
				user.setRole(role);
				user.setRegistrationDate(registrationDate);
				user.setFirstName(firstName);
				user.setLastName(lastName);
				user.setMiddleName(MiddleName);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

//	public List<User> selectAllUsers() {
//
//		// using try-with-resources to avoid closing resources (boiler plate code)
//		List<User> users = new ArrayList<>();
//		// Step 1: Establishing a Connection
//		try (Connection connection = DbConnection.getConnection();
//
//				// Step 2:Create a statement using connection object
//				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {
//			System.out.println(preparedStatement);
//			// Step 3: Execute the query or update query
//			ResultSet rs = preparedStatement.executeQuery();
//
//			// Step 4: Process the ResultSet object.
//			while (rs.next()) {
//				User user = new User();
//				String username = rs.getString("username");
//				String email = rs.getString("email");
//				String firstName = rs.getString("firstName");
//				String lastName = rs.getString("lastName");
//				
//				
//				
//				users.add(new User(username, password, email, firstName, lastName));  //Modify this to accommodate a list 
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return users;
//	}

	public boolean deleteUser(String username) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = DbConnection.getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);) {
			statement.setString(1, username);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	public boolean updateUser(User user) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = DbConnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USERS_SQL);) {
			System.out.println("updated USer:" + preparedStatement);
			preparedStatement.setString(1, user.getUsername());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.setString(3, user.getEmail());
			preparedStatement.setString(4, user.getFirstName());
			preparedStatement.setString(5, user.getLastName());

			rowUpdated = preparedStatement.executeUpdate() > 0;
		}
		return rowUpdated;
	}

	public static void databaseMetadata(String username) {
		try (Connection connection = DbConnection.getConnection();

				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnsNumber = rsmd.getColumnCount();
			for (int i = 1; i <= columnsNumber; i++) {
				System.out.println("Column Name: " + rsmd.getColumnName(i));
			}

			// Step 4: Process the ResultSet object.
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
//		UserDao userdao = new UserDao();
		User user = new User();
		user.setUsername("usernamedao");
		user.setEmail("usernamedao@gmail.com");
		user.setFirstName("firstnameDao");
		user.setLastName("lastNameDao");
		user.setPassword("1234");

		// userdao.insertUser(user);
//			System.out.println("user inserted successfully!!!!");
//			userdao.deleteUser("usernamedao");
		databaseMetadata("usernamedao");
	}

}
